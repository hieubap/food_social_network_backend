package spring.boot.food.social.network.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.food.social.network.dto.PostDTO;
import spring.boot.food.social.network.entity.PostEntity;
import spring.boot.food.social.network.repository.PostRepository;

@Service
public class PostServiceImpl extends AbstractBaseService<PostEntity, PostDTO, PostRepository> implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ResManagerService resManagerService;

    @Override
    protected PostRepository getRepository() {
        return postRepository;
    }

    @Override
    protected void specificMapToDTO(PostEntity entity, PostDTO dto) {
        super.specificMapToDTO(entity, dto);
        if(entity.getIdRes() != null){
            dto.setResManagerDTO(resManagerService.findById(entity.getIdRes()));
        }
    }
}
