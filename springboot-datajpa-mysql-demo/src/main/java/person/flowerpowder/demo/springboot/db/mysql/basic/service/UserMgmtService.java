package person.flowerpowder.demo.springboot.db.mysql.basic.service;


import java.util.List;
import java.util.Optional;

public interface UserMgmtService {

    String createUser(String userName);

    String createAuthor(String author);

    String createGroup(String group);

    Optional<Integer> addUserToGroup(String user, String group);

    List<String> getAllGroupByUser(String user);




}
