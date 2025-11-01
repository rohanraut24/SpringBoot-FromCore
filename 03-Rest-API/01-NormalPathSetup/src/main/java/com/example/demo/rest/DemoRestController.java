package com.example.demo.rest;


import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

//    @GetMapping("/greet")
//    public String getHellow(){
//        return "Hello rohan";
//    }
    private List<Student> list;
    @PostConstruct
    public void loadStudents(){
        list =new ArrayList<>();
        list.add(new Student("Rohan","Raut"));
        list.add(new Student("Shubham","Raut"));
        list.add(new Student("Prasad","Raut"));
    }


    @GetMapping("/Students")
    public List<Student> getStudents(){
        return list;
    }

    @GetMapping("/Student/{studentId}")
    public Student getStudents(@PathVariable int studentId){
        return list.get(studentId);
    }

}
