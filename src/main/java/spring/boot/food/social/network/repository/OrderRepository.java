package spring.boot.food.social.network.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.FoodDTO;
import spring.boot.food.social.network.dto.OrderDTO;
import spring.boot.food.social.network.entity.FoodEntity;
import spring.boot.food.social.network.entity.OrderEntity;

@Repository
public interface OrderRepository extends BaseRepository<OrderEntity, OrderDTO,Long> {
    OrderEntity findByIdTeam(Long idTeam);

    @Override
    @Query("select e from OrderEntity e" +
            " join e.teamEntity t" +
            " where (e.idTeam = :#{#dto.idTeam} or :#{#dto.idTeam} is null)" +
            " and (t.idRes = :#{#dto.idRes} or :#{#dto.idRes} is null)")
    Page<OrderEntity> search(OrderDTO dto, Pageable pageable);
}
