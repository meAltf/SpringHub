package com.learn.restapi.SpringHub.controller;

import com.learn.restapi.SpringHub.entity.Student;
import com.learn.restapi.SpringHub.request.CreateStudentRequest;
import com.learn.restapi.SpringHub.request.InQueryRequest;
import com.learn.restapi.SpringHub.request.UpdateStudentRequest;
import com.learn.restapi.SpringHub.response.StudentResponse;
import com.learn.restapi.SpringHub.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**
     * Error < Warn < Info < Debug < Trace
     */
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Deprecated
//    @GetMapping("/get")
//    public StudentResponse getStudent(){
//        StudentResponse studentResponse = new StudentResponse(1L, "robert", "broon");
//        return studentResponse;
//    }

    @GetMapping("/getAllStudent")
    public List<StudentResponse> getAllStudent() {
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
    public List<StudentResponse> getByFirstName(@PathVariable String firstName) {
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

    @GetMapping("/getByFirstNameIn")
    public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest) {

        logger.info("inQueryRequest" + inQueryRequest);
        List<Student> studentList = studentService.getByFirstNameIn(inQueryRequest);

        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        logger.info("studentResponseList" + studentResponseList);

        return studentResponseList;
    }

    @GetMapping("/getAllWithPagination")
    public List<StudentResponse> getAllStudentWithPagination(@RequestParam int pageNo,
                                                             @RequestParam int pageSize) {
        List<Student> studentList = studentService.getAllStudentWithPagination(pageNo, pageSize);

        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

    @GetMapping("/getAllWithSorting")
    public List<StudentResponse> getAllStudentsWithSorting() {
        List<Student> studentList = studentService.getAllStudentWithSorting();

        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

    @GetMapping("/like/{lastName}")
    public List<StudentResponse> getAllWithLike(@PathVariable String lastName) {
        List<Student> studentList = studentService.getAllwithLike(lastName);

        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

    @GetMapping("/startsWith/{lastName}")
    public List<StudentResponse> getAllStartsWith(@PathVariable String lastName) {
        List<Student> studentList = studentService.getAllStartsWith(lastName);

        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

    @PutMapping("/updateFirstName/{id}/{firstName}")
    public String updateStudentWithJpql(@PathVariable Long id, @PathVariable String firstName) {
        return studentService.updateStudentWithJpql(id, firstName) + " Student(s) updated";
    }

    @DeleteMapping("/deleteByFirstName/{firstName}")
    public String deleteStudent(@PathVariable String firstName) {
        return studentService.deleteStudentWithJpql(firstName) + " Student(s) updated";
    }

    @GetMapping("/getByCity/{city}")
    public List<StudentResponse> getAllByCity(@PathVariable String city){

        logger.error("Inside Error");
        logger.warn("Inside warn");
        logger.info("Inside Info");
        logger.debug("Inside debug");
        logger.debug("Inside Trace");

        List<Student> studentList = studentService.getAllByCity(city);

        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }


}
