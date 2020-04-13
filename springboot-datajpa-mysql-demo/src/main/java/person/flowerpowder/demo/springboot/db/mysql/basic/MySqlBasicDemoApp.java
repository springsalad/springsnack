package person.flowerpowder.demo.springboot.db.mysql.basic;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class MySqlBasicDemoApp {
    public static void main(String[] args) {

        SpringApplication.run(MySqlBasicDemoApp.class, args);
    }
}
