package spring.boot.food.social.network.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.FoodDTO;
import spring.boot.food.social.network.dto.PostDTO;
import spring.boot.food.social.network.entity.FoodEntity;
import spring.boot.food.social.network.entity.PostEntity;

@Repository
public interface FoodRepository extends BaseRepository<FoodEntity, FoodDTO,Long> {
    @Override
    @Query("select e from FoodEntity e" +
            " where (lower(e.name) like %:#{#dto.name}% or :#{#dto.name} is null) " +
            " and (e.idRes = :#{#dto.idRes} or :#{#dto.idRes} is null)")
    Page<FoodEntity> search(FoodDTO dto, Pageable pageable);
}
