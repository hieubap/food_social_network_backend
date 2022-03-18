package spring.boot.food.social.network.service;

import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.service.BaseService;
import spring.boot.food.social.network.dto.ResManagerDTO;
import spring.boot.food.social.network.entity.ResManagerEntity;

import java.util.Map;

public interface ResManagerService extends BaseService<ResManagerDTO> {
    Map<String, Object> login(UsernameAndPasswordDTO dto);

    ResManagerDTO register(ResManagerDTO account);

    ResManagerDTO mapToDTO(ResManagerEntity entity);
}
