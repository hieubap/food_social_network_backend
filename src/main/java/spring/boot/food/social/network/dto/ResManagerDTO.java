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
public class ResManagerDTO extends BaseDTO {
    private Long id;

    private String name;

    private String username;

    private String password;

    private String address;

    private String avatar;

    private Boolean active;

    private Integer numStar;

    private Integer numComment;
}
