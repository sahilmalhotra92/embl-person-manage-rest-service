package org.sahil.embl.person.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "org.sahil.embl.person")
@ComponentScan(basePackages = "org.sahil.embl.person")
@EntityScan(basePackages = "org.sahil.embl.person")
@SpringBootApplication
public class EMBLApplication {
    public static void main(String[] args) {
        SpringApplication.run(EMBLApplication.class);
    }
}
