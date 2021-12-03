package com.example.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

import static java.util.Locale.ENGLISH;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "aware")
public class AuditConfig {

    @Bean
    public AuditorAware<String> aware(){
        return ()-> Optional.of("Administrator");
    }

    @Bean
    public Faker faker(){
        return new Faker(ENGLISH);
    }

}
