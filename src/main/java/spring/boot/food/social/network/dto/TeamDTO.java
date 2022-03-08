package spring.boot.food.social.network.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.dto.BaseDTO;
import spring.boot.food.social.network.entity.UserEntity;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO extends BaseDTO {
    private Long id;

    private Long idRes;

    private Integer numberMember;

    private Long idLeader;

    private Boolean active;

    private List<UserDTO> listUser;

    private OrderDTO order;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long idNewUser;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private ZonedDateTime time;
}
