package com.learn.restapi.SpringHub.entity;

import com.learn.restapi.SpringHub.request.CreateStudentRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    /**
     * @Transient-- @Transient annotation is used to indicate that a field should not be persisted in the database.
     *  It tells the JPA provider to ignore this field when performing database operations.
     *  persisted means- saveDataPermanently
     */
    @Transient
    private String fullName;

    public Student(CreateStudentRequest createStudentRequest){
        this.firstName = createStudentRequest.getFirstName();
        this.lastName = createStudentRequest.getLastName();
        this.email = createStudentRequest.getEmail();
        this.fullName = createStudentRequest.getFirstName() + " " + createStudentRequest.getLastName();
    }
}
