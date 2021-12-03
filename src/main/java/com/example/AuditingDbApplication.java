package com.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AuditingDbApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuditingDbApplication.class, args);
        log.info("Spring boot and jpa auditing application");
    }

}
