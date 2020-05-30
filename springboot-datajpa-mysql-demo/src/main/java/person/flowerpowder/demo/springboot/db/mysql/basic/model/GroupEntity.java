package person.flowerpowder.demo.springboot.db.mysql.basic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;



@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "mygroup")
public class GroupEntity {

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
    @OneToMany(mappedBy = "groupByGroupId")
    private Collection<MemberEntity> membersById;


}
