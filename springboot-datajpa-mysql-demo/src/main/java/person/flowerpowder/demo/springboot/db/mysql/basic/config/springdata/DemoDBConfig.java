
package person.flowerpowder.demo.springboot.db.mysql.basic.config.springdata;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "demoEntityManagerFactory",
        basePackages = { "person.flowerpowder.demo.springboot.db.mysql.basic.repo" },
        transactionManagerRef = "demoTransactionManager"
)
public class DemoDBConfig {


    @Primary
    @Bean(name = "demoDataSource")
    @ConfigurationProperties(prefix = "datasources.demo")
    public DataSource dataSource() {
        // Filled up with the properties specified about thanks to Spring Boot black
        // magic
        return new HikariDataSource();
    }

    @Primary
    @Bean(name = "demoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            /*EntityManagerFactoryBuilder builder, */
            @Qualifier("demoDataSource") DataSource dataSource
    ) {


        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();


        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);


        factory.setPackagesToScan("person.flowerpowder.demo.springboot.db.mysql.basic.model");
        factory.setDataSource(dataSource);
        return factory;
    }

    @Primary
    @Bean(name = "demoTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("demoEntityManagerFactory") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}