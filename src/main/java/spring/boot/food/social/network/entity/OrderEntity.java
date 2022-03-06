package spring.boot.food.social.network.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.dao.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_order")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idTeam;

    private String phoneNumber;

    private Integer numMember;

    private Integer state;
}
