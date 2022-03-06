package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.food.social.network.dto.OrderDTO;
import spring.boot.food.social.network.service.OrderService;

@RequestMapping("/order")
@RestController
@CrossOrigin
public class OrderController extends BaseController<OrderDTO, OrderService> {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderService getService() {
        return orderService;
    }
}

