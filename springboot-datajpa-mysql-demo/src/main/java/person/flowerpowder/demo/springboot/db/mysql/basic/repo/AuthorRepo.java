package person.flowerpowder.demo.springboot.db.mysql.basic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import person.flowerpowder.demo.springboot.db.mysql.basic.model.AuthorEntity;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorEntity, Integer> {
}
