package spring.boot.food.social.network.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.ReviewDTO;
import spring.boot.food.social.network.entity.ReviewEntity;

@Repository
public interface ReviewRepository extends BaseRepository<ReviewEntity, ReviewDTO,Long> {
    @Override
    @Query("select e from ReviewEntity e" +
            " where (e.idRes = :#{#dto.idRes} or :#{#dto.idRes} is null)" +
            " and (e.numStar = :#{#dto.numStar} or :#{#dto.numStar} is null)" +
            " and (e.idUser = :#{#dto.idUser} or :#{#dto.idUser} is null)")
    Page<ReviewEntity> search(ReviewDTO dto, Pageable pageable);

    Integer countByIdRes(Long idRes);

    @Query("select sum(e.numStar) from ReviewEntity e" +
            " where (e.idRes = :#{#idRes} or :#{#idRes} is null)")
    Integer sumStar(Long idRes);
}
