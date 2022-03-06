package spring.boot.food.social.network.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.AdminDTO;
import spring.boot.food.social.network.dto.ResManagerDTO;
import spring.boot.food.social.network.entity.AdminEntity;
import spring.boot.food.social.network.entity.ResManagerEntity;
import spring.boot.food.social.network.entity.UserEntity;

@Repository
public interface ResManagerRepository extends BaseRepository<ResManagerEntity, ResManagerDTO,Long> {

    @Override
    @Query("select e from ResManagerEntity e" +
            " where (lower(e.username) like %:#{#dto.username}% or :#{#dto.username} is null)" +
            " and (lower(e.name) like %:#{#dto.name}% or :#{#dto.name} is null)")
    Page<ResManagerEntity> search(ResManagerDTO dto, Pageable pageable);

    boolean existsByUsername(String username);

    ResManagerEntity findByUsername(String username);
}
