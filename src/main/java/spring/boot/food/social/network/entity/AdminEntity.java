package spring.boot.food.social.network.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.dao.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class AdminEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String password;

    private String address;

    private String avatar;

    private Boolean active;
}
