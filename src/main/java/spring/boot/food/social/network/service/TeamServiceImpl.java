package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.exception.BaseException;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.food.social.network.dto.OrderDTO;
import spring.boot.food.social.network.dto.ResManagerDTO;
import spring.boot.food.social.network.dto.TeamDTO;
import spring.boot.food.social.network.dto.UserDTO;
import spring.boot.food.social.network.entity.OrderEntity;
import spring.boot.food.social.network.entity.ResManagerEntity;
import spring.boot.food.social.network.entity.TeamEntity;
import spring.boot.food.social.network.entity.UserEntity;
import spring.boot.food.social.network.repository.OrderRepository;
import spring.boot.food.social.network.repository.TeamRepository;
import spring.boot.food.social.network.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl extends AbstractBaseService<TeamEntity, TeamDTO, TeamRepository> implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ResManagerService resManagerService;

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
        if(teamEntity.getActive() != null && !teamEntity.getActive()){
            throw new BaseException("Nhóm đã bị khóa không thể thêm thành viên");
        }
        List<UserEntity> listUsers = teamEntity.getListUsers();
        if(listUsers.size() > 1){
            throw new BaseException("Không thể thêm quá 3 thành viên");
        }
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


    public TeamDTO addUser2(TeamDTO dto) {
        UserEntity userEntity = userRepository.findById(dto.getIdNewUser()).orElse(null);
        if(userEntity == null){
            throw new BaseException("ID Người dùng không tồn tại");
        }

        TeamEntity teamEntity = getById(dto.getId());
        List<UserEntity> listUsers = teamEntity.getListUsers();
        if(listUsers == null){
            listUsers = new ArrayList<>();
        }

        listUsers.add(userEntity);
        teamEntity.setListUsers(listUsers);
        save(teamEntity,dto);
        return dto;
    }

    @Override
    public TeamDTO joinTeamRes(TeamDTO dto) {
        List<TeamEntity> teamEntityList = teamRepository.findByIdRes(dto.getIdRes());
        int indexCanEnter = -1;
        for(int i = 0;i< teamEntityList.size();i++){
            List<UserEntity> listUsers = teamEntityList.get(i).getListUsers();
            boolean isOrder = teamEntityList.get(i).getOrderEntity() != null;
            boolean isActive = teamEntityList.get(i).getActive() != null && teamEntityList.get(i).getActive();
            boolean isFull = listUsers.size() > 1;
            boolean isOnRoom = teamEntityList.get(i).getIdLeader().equals(dto.getIdNewUser());

            for(int j = 0;j<listUsers.size();j++){
                if(listUsers.get(j).getId().equals(dto.getIdNewUser())){
                    isOnRoom = true;
                    break;
                }
            }

            if(isOnRoom && !isOrder){
                return mapToDTO(teamEntityList.get(i));
            }
            if(!isOrder && isActive && !isFull){
                indexCanEnter = i;
            }
        }
        if(indexCanEnter != -1){
            TeamDTO teamDto = mapToDTO(teamEntityList.get(indexCanEnter));
            teamDto.setIdNewUser(dto.getIdNewUser());
            addUser2(teamDto);
            return teamDto;
        } else{
            dto.setIdLeader(dto.getIdNewUser());
            save(dto);
        }

        return dto;
    }

    @Override
    protected void specificMapToDTO(TeamEntity entity, TeamDTO dto) {
        super.specificMapToDTO(entity, dto);
        List<UserEntity> listUser = entity.getListUsers();
        if(listUser == null){
            listUser = new ArrayList<>();
        }
        List<UserDTO> userDTOS = listUser.stream().map(userService::mapToDTO).collect(Collectors.toList());

        UserDTO leader = null;
        if(dto.getIdLeader() != null){
            leader = userService.findById(dto.getIdLeader());
        }
        if(leader != null){

            leader.setIsAdmin(true);
            userDTOS.add(leader);
        }

        OrderEntity order = orderRepository.findByIdTeam(dto.getId());
        if(order != null){
            dto.setOrder(orderService.mapToDTO(order));
        }

        if(dto.getIdRes() != null){
            ResManagerDTO resManagerDTO = resManagerService.findById(dto.getIdRes());
            dto.setResManagerDTO(resManagerDTO);
        }

        dto.setListUser(userDTOS);
    }
}
