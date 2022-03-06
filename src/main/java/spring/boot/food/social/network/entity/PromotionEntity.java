package spring.boot.food.social.network.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.dao.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "promotion")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class PromotionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idRes;

    private String name;

    private String content;

    private String avatar;
}
