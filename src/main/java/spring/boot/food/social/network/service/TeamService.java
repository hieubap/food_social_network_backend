package spring.boot.food.social.network.service;

import spring.boot.core.service.BaseService;
import spring.boot.food.social.network.dto.TeamDTO;

public interface TeamService extends BaseService<TeamDTO> {
    TeamDTO addUser(TeamDTO dto);

    TeamDTO joinTeamRes(TeamDTO dto);
}
