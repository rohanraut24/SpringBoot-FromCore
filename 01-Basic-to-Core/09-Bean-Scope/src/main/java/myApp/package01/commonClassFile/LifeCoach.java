package myApp.package01.commonClassFile;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//Here we give scope manually if it is
// Prototype => Then for every instance it will in new bean
// Singleton => Then for every instance it will be pointing to same bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class LifeCoach implements Coach{
    public LifeCoach(){
        System.out.println("We are in "+getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        return "Life is hard,there is SOMETHING that makes life EASY that thing is DISCIPLINE";
    }
}
