package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.config.filter.JwtProvider;
import spring.boot.core.exception.BaseException;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.core.utils.DigestUtil;
import spring.boot.food.social.network.dto.AdminDTO;
import spring.boot.food.social.network.dto.ResManagerDTO;
import spring.boot.food.social.network.entity.AdminEntity;
import spring.boot.food.social.network.entity.ResManagerEntity;
import spring.boot.food.social.network.repository.AdminRepository;

import java.util.Map;

@Service
public class AdminServiceImpl extends AbstractBaseService<AdminEntity, AdminDTO, AdminRepository> implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    protected AdminRepository getRepository() {
        return adminRepository;
    }

    @Override
    public Map<String, Object> login(UsernameAndPasswordDTO dto) {
        if (dto.getPassword() == null || dto.getUsername() == null) {
            throw new BaseException(400, "Chưa nhập tên đăng nhập hoặc mật khẩu");
        }
        AdminEntity userEntity = getRepository().findByUsername(dto.getUsername());
        if (userEntity == null) {
            throw new BaseException(400, "Tên đăng nhập không tồn tại");
        }

        if (!DigestUtil.sha256Hex(dto.getPassword()).equals(userEntity.getPassword())) {
            throw new BaseException(400, "password không chính xác");
        }

        JwtProvider.JwtTokenProperties jwts = JwtProvider.JwtTokenProperties.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .fullName(userEntity.getName())
                .avatar(userEntity.getAvatar())
                .build();

        return jwtProvider.generateToken(jwts);
    }

    @Override
    public AdminDTO register(AdminDTO userDTO) {
        if (userDTO.getPassword() == null || userDTO.getUsername() == null) {
            throw new BaseException(400, "Chưa nhập username và password");
        }
        if (getRepository().existsByUsername(userDTO.getUsername())) {
            throw new BaseException("Tên đăng nhập đã tồn tại");
        }
        AdminEntity accountEntity = mapToEntity(userDTO);

        accountEntity.setPassword(DigestUtil.sha256Hex(userDTO.getPassword()));
        save(accountEntity, userDTO);

        return userDTO;
    }
}
