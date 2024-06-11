package com.learn.restapi.SpringHub.service;

import com.learn.restapi.SpringHub.entity.Student;
import com.learn.restapi.SpringHub.repository.StudentRepository;
import com.learn.restapi.SpringHub.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student(createStudentRequest);

        student = studentRepository.save(student);
        return student;
    }
}
