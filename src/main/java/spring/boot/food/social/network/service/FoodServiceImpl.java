package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.food.social.network.dto.FoodDTO;
import spring.boot.food.social.network.entity.FoodEntity;
import spring.boot.food.social.network.entity.ResManagerEntity;
import spring.boot.food.social.network.repository.FoodRepository;
import spring.boot.food.social.network.repository.ResManagerRepository;

@Service
public class FoodServiceImpl extends AbstractBaseService<FoodEntity, FoodDTO, FoodRepository> implements FoodService {
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private ResManagerRepository resManagerRepository;

    @Override
    protected FoodRepository getRepository() {
        return foodRepository;
    }

    @Override
    protected void specificMapToDTO(FoodEntity entity, FoodDTO dto) {
        super.specificMapToDTO(entity, dto);
        ResManagerEntity resManagerEntity = resManagerRepository.findById(entity.getIdRes()).orElse(null);
        if(resManagerEntity != null){
            dto.setNameStore(resManagerEntity.getName());
        }
    }
}
