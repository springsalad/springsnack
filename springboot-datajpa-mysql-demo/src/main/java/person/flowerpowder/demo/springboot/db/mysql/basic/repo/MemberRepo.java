package person.flowerpowder.demo.springboot.db.mysql.basic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import person.flowerpowder.demo.springboot.db.mysql.basic.model.MemberEntity;

@Repository
public interface MemberRepo extends JpaRepository<MemberEntity, Integer> {
}
