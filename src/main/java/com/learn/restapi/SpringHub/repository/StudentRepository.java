package com.learn.restapi.SpringHub.repository;

import com.learn.restapi.SpringHub.entity.Student;
import com.learn.restapi.SpringHub.request.InQueryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * JPA- Java Persistence API
     */
    /**
     * entityName class, and data type of primary key
     */

    /**
     * JpaRepository is a combination of -
     * CrudRepository<Student, Long> and PagingAndSortingRepository<Student, Long>
     * Both
     */

    List<Student> findByfirstName(String firstName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findByFirstNameOrLastName(String firstName, String lastName);

    List<Student> findByFirstNameIn(List<String> firstNames);

    List<Student> findByLastNameContains(String lastName);

    List<Student> findByLastNameStartsWith(String lastName);

    /**
     * JPQL- Java Persistence Query Language
     */
    /**
     * If you want to change the name in query other than what you put in variableName so use, @Param
     * like firstName = :firstName but you want to written like this- firstName = :firstname so in variable side write -
     *
     * @Param("firstname") String firstName
     */
    @Query("FROM Student WHERE firstName = :firstName AND lastName = :lastName")
    Student getByFirstNameAndLastName(String firstName, String lastName);

    @Modifying
    @Transactional
    @Query("UPDATE Student SET firstName = :firstName WHERE id = :id")
    Integer updateFirstName(Long id, String firstName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student WHERE firstName = :firstName")
    Integer deleteByFirstName(String firstName);
}
