package spring.boot.food.social.network.service;

import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.service.BaseService;
import spring.boot.food.social.network.dto.UserDTO;
import spring.boot.food.social.network.entity.UserEntity;

import java.util.Map;

public interface UserService extends BaseService<UserDTO> {
    Map<String, Object> login(UsernameAndPasswordDTO dto);

    UserDTO register(UserDTO account);

    UserDTO mapToDTO(UserEntity e);
}
