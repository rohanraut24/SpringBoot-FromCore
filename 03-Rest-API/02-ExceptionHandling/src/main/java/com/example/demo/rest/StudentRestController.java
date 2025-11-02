package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

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
        if(studentId >= list.size() || studentId<0){
            throw new StudentNotFoundException("Student is not found -"+studentId);
        }
        return list.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //Globle Exception handler (can handle any type of Exception)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handle(Exception exc){
        StudentErrorResponse err = new StudentErrorResponse();
        err.setMessage(exc.getMessage());
//        err.setMessage("Please right valid id of Student");   //you can set custom message
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setTimeStamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }
}
