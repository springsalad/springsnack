package person.flowerpowder.demo.springboot.db.mysql.basic.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import person.flowerpowder.demo.springboot.db.mysql.basic.model.GroupEntity;
import person.flowerpowder.demo.springboot.db.mysql.basic.model.MemberEntity;
import person.flowerpowder.demo.springboot.db.mysql.basic.model.UserEntity;
import person.flowerpowder.demo.springboot.db.mysql.basic.repo.AuthorRepo;
import person.flowerpowder.demo.springboot.db.mysql.basic.repo.GroupRepo;
import person.flowerpowder.demo.springboot.db.mysql.basic.repo.MemberRepo;
import person.flowerpowder.demo.springboot.db.mysql.basic.repo.UserRepo;
import person.flowerpowder.demo.springboot.db.mysql.basic.service.UserMgmtService;

import javax.swing.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserMgmtServiceImpl implements UserMgmtService {


    private UserRepo userRepo;
    private AuthorRepo authorRepo;
    private GroupRepo groupRepo;
    private MemberRepo memberRepo;

    @Autowired
    public UserMgmtServiceImpl(AuthorRepo authorRepo,
                               UserRepo userRepo,
                               GroupRepo groupRepo,
                               MemberRepo memberRepo) {
        this.authorRepo = authorRepo;
        this.userRepo = userRepo;
        this.groupRepo = groupRepo;
        this.memberRepo = memberRepo;
    }


    @Override
    @Transactional
    public String createUser(String userName) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userName);
        UserEntity savedUser = userRepo.save(userEntity);
        return savedUser.getName();
    }

    @Override
    @Transactional
    public String createAuthor(String author) {
        return null;
    }

    @Override
    @Transactional
    public String createGroup(String group) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setName(group);
        GroupEntity savedGroupEntity = groupRepo.save(groupEntity);

        return savedGroupEntity.getName();

    }

    @Override
    @Transactional
    public Optional<Integer> addUserToGroup(String user, String group) {


        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id");



        UserEntity userEntity = new UserEntity();
        userEntity.setName(user);
        Example<UserEntity> userExample = Example.of(userEntity, matcher);

        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setName(group);
        Example<GroupEntity> groupExample = Example.of(groupEntity, matcher);

        List<UserEntity>  alllUserEntity = userRepo.findAll(userExample);
        List<GroupEntity> allGroupEntity = groupRepo.findAll(groupExample);

        log.debug("alllUserEntity {}", alllUserEntity);
        log.debug("allGroupEntity {}", allGroupEntity);

        if ( !allGroupEntity.isEmpty() && !alllUserEntity.isEmpty()) {
            log.debug("into here");

            UserEntity userEntity1 = alllUserEntity.get(0);
            Collection<MemberEntity> memberEntities =  userEntity1.getMembersById();

            memberEntities.forEach( memberEntity -> {
                log.info("member is {}", memberEntity);
            });



            MemberEntity memberEntity = new MemberEntity();
            memberEntity.setUserByUserId(alllUserEntity.get(0));
            memberEntity.setGroupByGroupId(allGroupEntity.get(0));
            MemberEntity savedMember = memberRepo.saveAndFlush(memberEntity);
            return Optional.of(savedMember.getId());
        } else {
            return  Optional.empty();
        }
    }

    @Override
    @Transactional
    public List<String> getAllGroupByUser(String user) {
        return null;
    }
}
