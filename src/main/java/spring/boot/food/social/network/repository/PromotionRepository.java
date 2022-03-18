package spring.boot.food.social.network.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.FoodDTO;
import spring.boot.food.social.network.dto.PromotionDTO;
import spring.boot.food.social.network.entity.FoodEntity;
import spring.boot.food.social.network.entity.PromotionEntity;

@Repository
public interface PromotionRepository extends BaseRepository<PromotionEntity, PromotionDTO,Long> {
    @Override
    @Query("select e from PromotionEntity e" +
            " where (lower(e.name) like %:#{#dto.name}% or :#{#dto.name} is null) " +
            " and (lower(e.content) like %:#{#dto.content}% or :#{#dto.content} is null) " +
            " and (e.idRes = :#{#dto.idRes} or :#{#dto.idRes} is null)")
    Page<PromotionEntity> search(PromotionDTO dto, Pageable pageable);
}
