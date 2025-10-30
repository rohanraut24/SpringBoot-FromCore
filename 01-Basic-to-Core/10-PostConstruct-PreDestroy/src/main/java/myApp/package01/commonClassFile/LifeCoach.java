package myApp.package01.commonClassFile;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LifeCoach implements Coach{
    public LifeCoach(){
        System.out.println("We are in "+getClass().getSimpleName());
    }

//    The @PostConstruct method is called only once during the entire lifecycle of a bean.
//    We can use such(PostConstruct) annotation for initialization and setup thing after bean
    @PostConstruct
    public void anyMethod(){
        System.out.println("After completion of Dependency Injection(Bean completion),we are in "+ getClass().getSimpleName());

    }

//     This annotation used just before bean is removed from the Spring container
//     This ensures that resources like file handles, database connections, network connections,
//     or background threads are properly closed or stopped,
//     preventing resource leaks and ensuring a graceful shutdown of the application.
    @PreDestroy
    public void anyMethod1(){
        System.out.println(" This will run just before termination the running code");
    }

    public String getDailyWorkout(){
        return "Life is hard,there is SOMETHING that makes life EASY that thing is DISCIPLINE";
    }
}
