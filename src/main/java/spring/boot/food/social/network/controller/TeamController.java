package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.core.controller.BaseController;
import spring.boot.core.dto.ResponseDTO;
import spring.boot.food.social.network.dto.TeamDTO;
import spring.boot.food.social.network.service.TeamService;

@RequestMapping("/team")
@RestController
@CrossOrigin
public class TeamController extends BaseController<TeamDTO, TeamService> {
    @Autowired
    private TeamService teamService;

    @Override
    public TeamService getService() {
        return teamService;
    }

    @PostMapping("/add-user")
    public ResponseDTO addUser(@RequestBody TeamDTO dto){
        return response(getService().addUser(dto));
    }

    @PostMapping("/join")
    public ResponseDTO join(@RequestBody TeamDTO dto){
        return response(getService().joinTeamRes(dto));
    }
}

