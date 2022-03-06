package spring.boot.food.social.network.repository;

import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.ReviewDTO;
import spring.boot.food.social.network.entity.ReviewEntity;

@Repository
public interface ReviewRepository extends BaseRepository<ReviewEntity, ReviewDTO,Long> {
}
