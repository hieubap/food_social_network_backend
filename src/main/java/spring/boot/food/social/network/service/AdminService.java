package spring.boot.food.social.network.service;

import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.service.BaseService;
import spring.boot.food.social.network.dto.AdminDTO;
import spring.boot.food.social.network.dto.ResManagerDTO;

import java.util.Map;

public interface AdminService extends BaseService<AdminDTO> {
    Map<String, Object> login(UsernameAndPasswordDTO dto);

    AdminDTO register(AdminDTO account);
}
