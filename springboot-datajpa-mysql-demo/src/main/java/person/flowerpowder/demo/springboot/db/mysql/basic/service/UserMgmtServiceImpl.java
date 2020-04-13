package person.flowerpowder.demo.springboot.db.mysql.basic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.flowerpowder.demo.springboot.db.mysql.basic.model.domain.User;
import person.flowerpowder.demo.springboot.db.mysql.basic.repo.UserRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMgmtServiceImpl implements UserMgmtService {


    private UserRepo userRepo;

    @Autowired
    public UserMgmtServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;

    }

    @Override
    public List<String> listAllNames() {

       List<User>  users = userRepo.findAll();

       return  users.stream().map( user -> {
           return user.getName();
       }).collect(Collectors.toList());

    }
}
