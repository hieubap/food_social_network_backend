package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.exception.BaseException;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.food.social.network.dto.TeamDTO;
import spring.boot.food.social.network.entity.TeamEntity;
import spring.boot.food.social.network.entity.UserEntity;
import spring.boot.food.social.network.repository.TeamRepository;
import spring.boot.food.social.network.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl extends AbstractBaseService<TeamEntity, TeamDTO, TeamRepository> implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    protected TeamRepository getRepository() {
        return teamRepository;
    }

    @Override
    public TeamDTO addUser(TeamDTO dto) {
        UserEntity userEntity = userRepository.findById(dto.getIdNewUser()).orElse(null);
        if(userEntity == null){
            throw new BaseException("ID Người dùng không tồn tại");
        }

        TeamEntity teamEntity = getById(dto.getId());

        if(dto.getIdNewUser() == teamEntity.getIdLeader()){
            throw new BaseException("Không thể thêm quản trị nhóm vào nhóm");
        }
        List<UserEntity> listUsers = teamEntity.getListUsers();
        if(listUsers == null){
            listUsers = new ArrayList<>();
        }

        for(int i = 0;i< listUsers.size();i++){
            if(listUsers.get(i).getId() == dto.getIdNewUser()){
                throw new BaseException("Người dùng đang trong nhóm");
            }
        }
        listUsers.add(userEntity);
        teamEntity.setListUsers(listUsers);
        save(teamEntity,dto);
        return dto;
    }

    @Override
    protected void specificMapToDTO(TeamEntity entity, TeamDTO dto) {
        super.specificMapToDTO(entity, dto);
        dto.setListUser(entity.getListUsers());
    }
}
