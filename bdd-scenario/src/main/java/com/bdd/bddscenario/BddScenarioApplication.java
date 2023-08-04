package com.bdd.bddscenario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.bdd*"})
@EntityScan("com.bdd.bddscenario.entity")
@EnableJpaRepositories("com.bdd.bddscenario.repositories")
public class BddScenarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BddScenarioApplication.class, args);
	}

}
