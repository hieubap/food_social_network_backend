package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
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
}

