package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String func(){
        return "Hello world the application is started";
    }
    @Value("${author.name}")
    private String boss;

    @Value("${language.name}")
    private String lang;



    //    use properties from application.Properties
    @GetMapping("/boss")
    public String applicationProperties(){
        return "Boss : "+boss +"  Currently doing :"+lang;
    }

}
