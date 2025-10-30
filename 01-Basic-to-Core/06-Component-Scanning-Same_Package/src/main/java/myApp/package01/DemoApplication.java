package myApp.package01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Add External package like this
/*
@SpringBootApplication(
		scanBasePackages ={"com.luv2code.springcoredemo","com.luv2code.util"}
		)
*/
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
