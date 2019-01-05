package msp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import msp.services.UserServiceImpl;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	//trying to update the git version
        SpringApplication.run(Application.class, args);
    }
}