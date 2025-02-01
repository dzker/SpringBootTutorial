package demo.simpleapp.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.simpleapp.demoapi.run.Location;
import demo.simpleapp.demoapi.run.Run;

import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoapiApplication {

private static final Logger log = LoggerFactory.getLogger(DemoapiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoapiApplication.class, args);
		
	}

	@Bean
	CommandLineRunner runner( ) {
		return args -> {
			Run run = new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
			log.info("Saving run: {}", run);
		};
	}
}
