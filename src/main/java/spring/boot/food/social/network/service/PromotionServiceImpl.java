package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.food.social.network.dto.PromotionDTO;
import spring.boot.food.social.network.entity.PromotionEntity;
import spring.boot.food.social.network.repository.PromotionRepository;

@Service
public class PromotionServiceImpl extends AbstractBaseService<PromotionEntity, PromotionDTO, PromotionRepository> implements PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    protected PromotionRepository getRepository() {
        return promotionRepository;
    }
}
