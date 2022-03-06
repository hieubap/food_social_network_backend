package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.config.filter.JwtProvider;
import spring.boot.core.exception.BaseException;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.core.utils.DigestUtil;
import spring.boot.food.social.network.dto.UserDTO;
import spring.boot.food.social.network.entity.UserEntity;
import spring.boot.food.social.network.repository.UserRepository;

import java.util.Map;

@Service
public class UserServiceImpl extends AbstractBaseService<UserEntity, UserDTO, UserRepository> implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }


    @Override
    public Map<String, Object> login(UsernameAndPasswordDTO dto) {
        if (dto.getPassword() == null || dto.getUsername() == null) {
            throw new BaseException(400, "Chưa nhập tên đăng nhập hoặc mật khẩu");
        }
        UserEntity userEntity = getRepository().findByUsername(dto.getUsername());
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
    public UserDTO register(UserDTO userDTO) {
        if (userDTO.getPassword() == null || userDTO.getUsername() == null) {
            throw new BaseException(400, "Chưa nhập username và password");
        }
        if (getRepository().existsByUsername(userDTO.getUsername())) {
            throw new BaseException("Tên đăng nhập đã tồn tại");
        }
        UserEntity accountEntity = mapToEntity(userDTO);

        accountEntity.setPassword(DigestUtil.sha256Hex(userDTO.getPassword()));
        save(accountEntity, userDTO);

        return userDTO;
    }

}
