package spring.boot.food.social.network.repository;

import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.OrderDTO;
import spring.boot.food.social.network.entity.OrderEntity;

@Repository
public interface OrderRepository extends BaseRepository<OrderEntity, OrderDTO,Long> {
}
