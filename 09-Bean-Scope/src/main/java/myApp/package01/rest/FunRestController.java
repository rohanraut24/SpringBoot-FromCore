package myApp.package01.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String func(){
        return "Hello world the application is started";
    }

    @GetMapping("/api")
    public String function(){
        return "I learn to set default path for the application";
    }



}
