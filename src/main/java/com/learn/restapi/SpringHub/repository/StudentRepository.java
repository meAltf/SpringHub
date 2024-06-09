package com.learn.restapi.SpringHub.repository;

import com.learn.restapi.SpringHub.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}
