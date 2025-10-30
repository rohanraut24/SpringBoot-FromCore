package myApp.package01.commonClassFile;


// Here we are not using @Component
// Because we want to add third-party class ,so we can do this by setting configuration for Bean
// and we are not using @Component because it does not support addition of third party class

public class SwimCoach implements Coach {
    public String getDailyWorkout(){
        return "Do swimming practice 1hr";
    }
}
