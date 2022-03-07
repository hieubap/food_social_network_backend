package spring.boot.food.social.network.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.FoodDTO;
import spring.boot.food.social.network.dto.TeamDTO;
import spring.boot.food.social.network.entity.FoodEntity;
import spring.boot.food.social.network.entity.TeamEntity;

@Repository
public interface TeamRepository extends BaseRepository<TeamEntity, TeamDTO,Long> {
    @Override
    @Query("select e from TeamEntity e" +
            " where (e.idRes = :#{#dto.idRes} or :#{#dto.idRes} is null)" +
            " and (exists(select u from e.listUsers u" +
            "                   where u.id = :#{#dto.userId})" +
            "       or :#{#dto.userId} = e.idLeader or :#{#dto.userId} is null)")
    Page<TeamEntity> search(TeamDTO dto, Pageable pageable);
}
