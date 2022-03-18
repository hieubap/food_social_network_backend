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
public class FoodDTO extends BaseDTO {
    private Long id;

    private Long idRes;

    private String name;

    private String price;

    private String avatar;

    private String nameStore;
}
