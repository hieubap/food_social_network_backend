package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import spring.boot.food.social.network.dto.MessageDTO;
import spring.boot.food.social.network.service.MessageService;

@Controller
@CrossOrigin
public class WebSocketController {
    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public MessageDTO sendMessage(@Payload MessageDTO chatMessage) {
        if(chatMessage.getIdUser() != null){
            messageService.save(chatMessage);
        }
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/publicChatRoom")
    public MessageDTO addUser(@Payload MessageDTO chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("userId", chatMessage.getIdUser());
        MessageDTO message = new MessageDTO();
        message.setContent("server gửi data về client");
        return message;
    }


    @MessageMapping("/chat.lock")
    @SendTo("/topic/public.realtime")
    public MessageDTO lockAccount(@Payload MessageDTO chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
//        headerAccessor.getSessionAttributes().put("userId", chatMessage.getIdUser());
//        MessageDTO message = new MessageDTO();
//        message.setContent("server gửi data về client");
        return chatMessage;
    }

}