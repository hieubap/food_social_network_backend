package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.food.social.network.dto.PromotionDTO;
import spring.boot.food.social.network.service.PromotionService;

@RequestMapping("/promotion")
@RestController
@CrossOrigin
public class PromotionController extends BaseController<PromotionDTO, PromotionService> {
    @Autowired
    private PromotionService promotionService;

    @Override
    public PromotionService getService() {
        return promotionService;
    }
}

