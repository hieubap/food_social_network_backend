package spring.boot.food.social.network.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.dto.BaseDTO;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends BaseDTO {
    private Long id;

    private Long idTeam;

    private String phoneNumber;

    private Integer numMember;

    private Integer state;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idRes;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Saigon")
    private ZonedDateTime time;
}
