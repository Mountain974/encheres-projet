package fr.eni.encheres2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
public class Encheres2Application {

	public static void main(String[] args) {
		SpringApplication.run(Encheres2Application.class, args);
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index.html");
	}

}
