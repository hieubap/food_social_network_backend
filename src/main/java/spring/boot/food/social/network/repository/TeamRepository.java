package spring.boot.food.social.network.repository;

import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.TeamDTO;
import spring.boot.food.social.network.entity.TeamEntity;

@Repository
public interface TeamRepository extends BaseRepository<TeamEntity, TeamDTO,Long> {
}
