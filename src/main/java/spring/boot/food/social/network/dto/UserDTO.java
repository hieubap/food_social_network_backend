package spring.boot.food.social.network.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.dto.BaseDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO {
    private Long id;

    private String name;

    private String username;

    private String password;

    private String address;

    private String avatar;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean isAdmin = false;
}
