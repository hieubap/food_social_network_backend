package spring.boot.food.social.network.service;

import spring.boot.core.service.BaseService;
import spring.boot.food.social.network.dto.OrderDTO;
import spring.boot.food.social.network.entity.OrderEntity;

public interface OrderService extends BaseService<OrderDTO> {
    OrderDTO mapToDTO(OrderEntity entity);
}
