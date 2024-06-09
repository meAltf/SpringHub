package com.learn.restapi.SpringHub.controller;

import com.learn.restapi.SpringHub.response.StudentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    /**
     * if this spring.application.name unabel to found in application.properties file,
     * then it takes default value as mentioned below
     * and doesn't throw any errorrr.
     */
    @Value("${spring.application.name:Default Demo App}")
    private String appName;

    @GetMapping("/get")
    public StudentResponse getStudent(){
        //return "Hello Student";
        StudentResponse studentResponse = new StudentResponse(1L, "robert", "broon");
        return studentResponse;
    }
}
