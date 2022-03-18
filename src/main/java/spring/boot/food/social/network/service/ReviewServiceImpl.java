package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.config.filter.JwtProvider;
import spring.boot.core.exception.BaseException;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.core.utils.DigestUtil;
import spring.boot.food.social.network.dto.ResManagerDTO;
import spring.boot.food.social.network.dto.ReviewDTO;
import spring.boot.food.social.network.dto.UserDTO;
import spring.boot.food.social.network.entity.ResManagerEntity;
import spring.boot.food.social.network.entity.ReviewEntity;
import spring.boot.food.social.network.entity.UserEntity;
import spring.boot.food.social.network.repository.ReviewRepository;

import java.util.Map;

@Service
public class ReviewServiceImpl extends AbstractBaseService<ReviewEntity, ReviewDTO, ReviewRepository> implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Override
    protected ReviewRepository getRepository() {
        return reviewRepository;
    }

    @Override
    protected void specificMapToDTO(ReviewEntity entity, ReviewDTO dto) {
        super.specificMapToDTO(entity, dto);

        if(entity.getIdUser() != null){
            dto.setUserDTO(userService.findById(entity.getIdUser()));
        }
    }
}

