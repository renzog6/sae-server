package ar.nex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "ar.nex")
@SpringBootApplication
public class SaeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaeServerApplication.class, args);		
	}

}
