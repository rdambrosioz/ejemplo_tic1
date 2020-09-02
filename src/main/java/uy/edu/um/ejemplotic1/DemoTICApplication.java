package uy.edu.um.ejemplotic1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class DemoTICApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTICApplication.class, args);
	}

}
