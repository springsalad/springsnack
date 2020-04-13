package person.flowerpowder.demo.springboot.db.mysql.basic.config;


import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "demo")
@Data

public class DemoConfig {

    private String appname;


}
