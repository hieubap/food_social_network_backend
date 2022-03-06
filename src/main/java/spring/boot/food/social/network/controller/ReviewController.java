package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.food.social.network.dto.ReviewDTO;
import spring.boot.food.social.network.service.ReviewService;

@RequestMapping("/review")
@RestController
@CrossOrigin
public class ReviewController extends BaseController<ReviewDTO, ReviewService> {
    @Autowired
    private ReviewService reviewService;

    @Override
    public ReviewService getService() {
        return reviewService;
    }
}
