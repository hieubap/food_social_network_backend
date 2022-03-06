package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.food.social.network.dto.MessageDTO;
import spring.boot.food.social.network.service.MessageService;

@RequestMapping("/message")
@RestController
@CrossOrigin
public class MessageController extends BaseController<MessageDTO, MessageService> {
    @Autowired
    private MessageService messageService;

    @Override
    public MessageService getService() {
        return messageService;
    }
}
