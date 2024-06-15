package com.learn.restapi.SpringHub.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.learn.restapi.SpringHub.entity.Student;
import lombok.*;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StudentResponse {

    /**
     * @JsonIgnore- skip this field in response of API
     */
    //@JsonIgnore
    private Long id;

    /**
     * @JsonProeprty change the name, like that you want to see in response of API
     */
    // @JsonProperty("first_name")
    private String firstName;

    //@JsonProperty("last_name")
    private String lastName;

    private String email;

    //private String fullName;

    private String street;

    private String city;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        //this.fullName = student.getFirstName() + " " + student.getLastName();
        this.street = student.getAddress().getStreetName();
        this.city = student.getAddress().getCityName();
    }


}
