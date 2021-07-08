package ru.one.springhomework;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@org.springframework.context.annotation.Configuration
@ComponentScan("ru.one.springhomework")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "ru.one.springhomework.repos")
public class Configuration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    }

