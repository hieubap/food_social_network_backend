package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.food.social.network.dto.OrderDTO;
import spring.boot.food.social.network.entity.OrderEntity;
import spring.boot.food.social.network.repository.OrderRepository;

@Service
public class OrderServiceImpl extends AbstractBaseService<OrderEntity, OrderDTO, OrderRepository> implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    protected OrderRepository getRepository() {
        return orderRepository;
    }
}
