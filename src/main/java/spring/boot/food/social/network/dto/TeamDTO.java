package spring.boot.food.social.network.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.dto.BaseDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO extends BaseDTO {
    private Long id;

    private Long idRes;

    private Integer numberMember;

    private Long idLeader;
}
