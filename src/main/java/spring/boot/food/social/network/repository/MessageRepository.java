package spring.boot.food.social.network.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.food.social.network.dto.MessageDTO;
import spring.boot.food.social.network.entity.MessageEntity;

@Repository
public interface MessageRepository extends BaseRepository<MessageEntity, MessageDTO, Long> {
    @Override
    @Query("select e from MessageEntity e" +
            " where (lower(e.content) like %:#{#dto.content}% or :#{#dto.content} is null)" +
            " and (e.idTeam = :#{#dto.idTeam} or :#{#dto.idTeam} is null) " +
            " and (e.idUser = :#{#dto.idUser} or :#{#dto.idUser} is null) ")
    Page<MessageEntity> search(MessageDTO dto, Pageable pageable);
}
