package spring.boot.food.social.network.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.AdminDTO;
import spring.boot.food.social.network.dto.UserDTO;
import spring.boot.food.social.network.entity.AdminEntity;
import spring.boot.food.social.network.entity.UserEntity;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, UserDTO,Long> {
    @Override
    @Query("select e from UserEntity e" +
            " where (lower(e.username) like %:#{#dto.username}% or :#{#dto.username} is null)" +
            " and (lower(e.name) like %:#{#dto.name}% or :#{#dto.name} is null)")
    Page<UserEntity> search(UserDTO dto, Pageable pageable);

    boolean existsByUsername(String username);

    UserEntity findByUsername(String username);
}
