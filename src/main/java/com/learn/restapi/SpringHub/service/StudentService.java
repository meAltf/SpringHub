package com.learn.restapi.SpringHub.service;

import com.learn.restapi.SpringHub.entity.Student;
import com.learn.restapi.SpringHub.repository.StudentRepository;
import com.learn.restapi.SpringHub.request.CreateStudentRequest;
import com.learn.restapi.SpringHub.request.UpdateStudentRequest;
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

    public Student updateStudent(UpdateStudentRequest updateStudentRequest){
        Student student = studentRepository.findById(updateStudentRequest.getId()).get();

        if (!updateStudentRequest.getFirstName().isEmpty() && updateStudentRequest.getFirstName() != null) {
            student.setFirstName(updateStudentRequest.getFirstName());
        }
        if (!updateStudentRequest.getEmail().isEmpty() && updateStudentRequest.getEmail() != null) {
            student.setEmail(updateStudentRequest.getEmail());
        }

        student = studentRepository.save(student);
        return student;
    }
}
