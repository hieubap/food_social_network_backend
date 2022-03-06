package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.food.social.network.dto.FoodDTO;
import spring.boot.food.social.network.service.FoodService;

@RequestMapping("/food")
@RestController
@CrossOrigin
public class FoodController extends BaseController<FoodDTO, FoodService> {
    @Autowired
    private FoodService foodService;

    @Override
    public FoodService getService() {
        return foodService;
    }
}
