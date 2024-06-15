package com.learn.restapi.SpringHub.controller;

import com.learn.restapi.SpringHub.entity.Student;
import com.learn.restapi.SpringHub.request.CreateStudentRequest;
import com.learn.restapi.SpringHub.request.UpdateStudentRequest;
import com.learn.restapi.SpringHub.response.StudentResponse;
import com.learn.restapi.SpringHub.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
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

    @PostMapping("/createStudent")
    public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        Student student = studentService.createStudent(createStudentRequest);

        return new StudentResponse(student);
    }

    @PutMapping("/updateStudent")
    public StudentResponse updateStudent(@RequestBody UpdateStudentRequest updateStudentRequest) {
        Student student = studentService.updateStudent(updateStudentRequest);

        return new StudentResponse(student);
    }

    /*
    No need to speicify under requestparam or pathvariable "id", if it matching or you are going to give exact name
     */
    @DeleteMapping("/deleteStudent")
    public String deleteStudentR(@RequestParam("id") Long id) {
        return studentService.deleteStudent(id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudentP(@PathVariable("id") Long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/getByFirstName/{firstName}")
    public List<StudentResponse> getByFirstName(@PathVariable String firstName){
        List<Student> studentList = studentService.getByFirstName(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

    @GetMapping("/getByFirstNameAndLastName/{firstName}/{lastName}")
    public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName,
                                                     @PathVariable String lastName) {
        return new StudentResponse(studentService.getByFirstNameAndLastName(firstName, lastName));
    }

    @GetMapping("/getByFirstNameOrLastName/{firstName}/{lastName}")
    public List<StudentResponse> getByFirstNameOrLastName(@PathVariable String firstName,
                                                          @PathVariable String lastName) {
        List<Student> studentList = studentService.getByFirstNameOrLastName(firstName, lastName);
        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

}
