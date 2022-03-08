package spring.boot.food.social.network.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.dao.model.BaseEntity;

import javax.persistence.*;
import java.time.ZonedDateTime;

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

    @Column(name = "id_team")
    private Long idTeam;

    private String phoneNumber;

    private Integer numMember;

    private Integer state;

    private ZonedDateTime time;

    @OneToOne
    @JoinColumn(name = "id_team", insertable = false, updatable = false)
    private TeamEntity teamEntity;
}
