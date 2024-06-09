package com.learn.restapi.SpringHub.controller;

import com.learn.restapi.SpringHub.entity.Student;
import com.learn.restapi.SpringHub.response.StudentResponse;
import com.learn.restapi.SpringHub.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    StudentService studentService;

    @Deprecated
//    @GetMapping("/get")
//    public StudentResponse getStudent(){
//        StudentResponse studentResponse = new StudentResponse(1L, "robert", "broon");
//        return studentResponse;
//    }

    @GetMapping("/getAllStudent")
    public List<StudentResponse> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }


}
