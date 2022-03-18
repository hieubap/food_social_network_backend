package spring.boot.food.social.network.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.dao.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class PostEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_res")
    private Long idRes;

    @Column(length = 2000)
    private String content;

    private String imgPath;

    @ManyToOne
    @JoinColumn(name = "id_res",insertable = false ,updatable = false)
    private ResManagerEntity resManagerEntity;
}
