package msp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import services.UserServiceImpl;

@SpringBootApplication(scanBasePackageClasses = {MainController.class, UserServiceImpl.class})
public class Application {

    public static void main(String[] args) {
    	//trying to update the git version
        SpringApplication.run(Application.class, args);
    }
}