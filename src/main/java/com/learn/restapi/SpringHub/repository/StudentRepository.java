package com.learn.restapi.SpringHub.repository;

import com.learn.restapi.SpringHub.entity.Student;
import com.learn.restapi.SpringHub.request.InQueryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * entityName class, and data type of primary key
     */

    /**
     * JpaRepository is a combination of -
     * CrudRepository<Student, Long> and PagingAndSortingRepository<Student, Long>
     * Both
     */

    List<Student> findByfirstName(String firstName);

    Student findByFirstNameAndLastName ( String firstName, String lastName);

    List<Student> findByFirstNameOrLastName(String firstName, String lastName);

    List<Student> findByFirstNameIn(List<String> firstNames);
}
