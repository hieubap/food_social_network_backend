package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.food.social.network.dto.TeamDTO;
import spring.boot.food.social.network.entity.TeamEntity;
import spring.boot.food.social.network.repository.TeamRepository;

@Service
public class TeamServiceImpl extends AbstractBaseService<TeamEntity, TeamDTO, TeamRepository> implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    protected TeamRepository getRepository() {
        return teamRepository;
    }
}
