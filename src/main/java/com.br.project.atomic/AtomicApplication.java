package com.br.project.customer.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AtomicApplication {

    public static void main(String[] args) {

        SpringApplication.run(AtomicApplication.class, args);
    }

}
