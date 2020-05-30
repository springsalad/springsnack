package person.flowerpowder.demo.springboot.db.mysql.basic.servicetest;




import lombok.extern.slf4j.Slf4j;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import person.flowerpowder.demo.springboot.db.mysql.basic.MySqlBasicDemoApp;
import person.flowerpowder.demo.springboot.db.mysql.basic.service.UserMgmtService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;



import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = MySqlBasicDemoApp.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")

public class UserMgmtServiceTest {

    /***
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }
     ***/

    @Autowired
    private UserMgmtService userMgmtService;


    @Test
    public void createUser() {
        String name = "John";
        String  savedName = userMgmtService.createUser(name);

        assertThat(savedName).isEqualTo(name);
    }


    @Test
    public void createMember() throws InterruptedException {
        String name = "Smith";
        String  savedName = userMgmtService.createUser(name);

        String groupName = "walker";
        String  savedGroupName = userMgmtService.createGroup(groupName);

        Optional<Integer>  memberId = userMgmtService.addUserToGroup(savedName, savedGroupName);

        log.debug("memberId {} {}", memberId, memberId.isPresent());

        Thread.sleep(2000);

        assertThat(memberId.isPresent()).isTrue();
    }




}
