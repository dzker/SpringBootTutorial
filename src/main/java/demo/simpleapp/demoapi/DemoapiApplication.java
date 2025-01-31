package demo.simpleapp.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class DemoapiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoapiApplication.class, args);;

		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");

		System.out.println(welcomeMessage.getWelcomeMessage());

	
	}

}
