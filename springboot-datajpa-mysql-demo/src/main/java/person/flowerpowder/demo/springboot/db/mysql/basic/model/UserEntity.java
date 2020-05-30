package person.flowerpowder.demo.springboot.db.mysql.basic.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;

    @Basic
    @Column(name = "create_time", nullable = true)
    private Timestamp createTime;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "userByUserId")
    private Collection<MemberEntity> membersById;



}
