package demo.simpleapp.demoapi;


import org.springframework.stereotype.Component;


@Component
public class WelcomeMessage {

    public String getWelcomeMessage () {
        return "Welcome to the world of Java!";
    }
}
