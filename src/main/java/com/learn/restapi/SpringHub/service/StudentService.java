package com.learn.restapi.SpringHub.service;

import com.learn.restapi.SpringHub.entity.Student;
import com.learn.restapi.SpringHub.repository.StudentRepository;
import com.learn.restapi.SpringHub.request.CreateStudentRequest;
import com.learn.restapi.SpringHub.request.InQueryRequest;
import com.learn.restapi.SpringHub.request.UpdateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student has been deleted successfully";
    }

    public List<Student> getByFirstName ( String firstName){
        return studentRepository.findByfirstName(firstName);
    }

    public Student getByFirstNameAndLastName( String firstName, String lastName){
        return  studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Student> getByFirstNameOrLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    public List<Student> getByFirstNameIn(InQueryRequest inQueryRequest) {
        return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
    }

    public List<Student> getAllStudentWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllStudentWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        return studentRepository.findAll(sort);
    }

    public List<Student> getAllwithLike(String lastName) {
        return studentRepository.findByLastNameContains(lastName);
    }

    public List<Student> getAllStartsWith(String lastName) {
        return studentRepository.findByLastNameStartsWith(lastName);
    }
}
