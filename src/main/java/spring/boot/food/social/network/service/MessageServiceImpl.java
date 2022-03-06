package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.food.social.network.dto.MessageDTO;
import spring.boot.food.social.network.entity.MessageEntity;
import spring.boot.food.social.network.repository.MessageRepository;

@Service
public class MessageServiceImpl
        extends AbstractBaseService<MessageEntity, MessageDTO, MessageRepository>
        implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    protected MessageRepository getRepository() {
        return messageRepository;
    }
}
