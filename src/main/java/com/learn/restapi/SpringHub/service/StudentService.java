package com.learn.restapi.SpringHub.service;

import com.learn.restapi.SpringHub.entity.Student;
import com.learn.restapi.SpringHub.repository.StudentRepository;
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
}
