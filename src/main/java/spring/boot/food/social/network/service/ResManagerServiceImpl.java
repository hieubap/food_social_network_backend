package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.config.filter.JwtProvider;
import spring.boot.core.exception.BaseException;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.core.utils.DigestUtil;
import spring.boot.food.social.network.dto.ResManagerDTO;
import spring.boot.food.social.network.entity.ResManagerEntity;
import spring.boot.food.social.network.entity.UserEntity;
import spring.boot.food.social.network.repository.ResManagerRepository;
import spring.boot.food.social.network.repository.ReviewRepository;

import java.util.Map;

@Service
public class ResManagerServiceImpl extends AbstractBaseService<ResManagerEntity, ResManagerDTO, ResManagerRepository> implements ResManagerService {
    @Autowired
    private ResManagerRepository resManagerRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    protected ResManagerRepository getRepository() {
        return resManagerRepository;
    }

    @Override
    public Map<String, Object> login(UsernameAndPasswordDTO dto) {
        if (dto.getPassword() == null || dto.getUsername() == null) {
            throw new BaseException(400, "Chưa nhập tên đăng nhập hoặc mật khẩu");
        }
        ResManagerEntity userEntity = getRepository().findByUsername(dto.getUsername());
        if (userEntity == null) {
            throw new BaseException(400, "Tên đăng nhập không tồn tại");
        }

        if (userEntity.getActive() == null || !userEntity.getActive()) {
            throw new BaseException(400, "Tài khoản đã bị khóa xin vui lòng liên hệ quản trị viên");
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

        Map<String,Object> resData = jwtProvider.generateToken(jwts);
        resData.put("type",2);
        return resData;
    }

    @Override
    public ResManagerDTO register(ResManagerDTO userDTO) {
        if (userDTO.getPassword() == null || userDTO.getUsername() == null) {
            throw new BaseException(400, "Chưa nhập username và password");
        }
        if (getRepository().existsByUsername(userDTO.getUsername())) {
            throw new BaseException("Tên đăng nhập đã tồn tại");
        }
        ResManagerEntity accountEntity = mapToEntity(userDTO);

        accountEntity.setPassword(DigestUtil.sha256Hex(userDTO.getPassword()));
        save(accountEntity, userDTO);

        return userDTO;
    }

    @Override
    protected void specificMapToDTO(ResManagerEntity entity, ResManagerDTO dto) {
        super.specificMapToDTO(entity, dto);
        Integer numComment = reviewRepository.countByIdRes(entity.getId());
        Integer sumStar = reviewRepository.sumStar(entity.getId());
        dto.setNumComment(numComment);
        if(sumStar != null)
        dto.setNumStar(sumStar/numComment);
    }
}
