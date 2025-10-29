package myApp.package01.config;
import myApp.package01.commonClassFile.Coach;
import myApp.package01.commonClassFile.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SportConfig {

//    @Bean annotation is used to declare a method that returns an object to be managed by the Spring container.

//    @Bean("anything") //can use like this or just use bean
    @Bean
    public Coach swimCoach(){   //In bean this class(SwimCoach) is stored as swimCoach so we use it here
        return new SwimCoach();
    }
}
