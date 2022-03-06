package spring.boot.food.social.network.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.dto.BaseDTO;
import spring.boot.food.social.network.config.ChatMessage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO extends BaseDTO {
    private Long id;

    private Long idUser;

    private Long idTeam;

    private String content;

    private ChatMessage.MessageType type;

    private String fullName;

    private String avatar;
}
