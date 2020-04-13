package person.flowerpowder.demo.springboot.db.mysql.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import person.flowerpowder.demo.springboot.db.mysql.basic.config.DemoConfig;


@Slf4j
@Service
public class AppStarter implements CommandLineRunner {


    private DemoConfig demoConfig;

    @Autowired
    public AppStarter(DemoConfig demoConfig) {
        this.demoConfig = demoConfig;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Application Starting with {}", demoConfig);

    }
}
