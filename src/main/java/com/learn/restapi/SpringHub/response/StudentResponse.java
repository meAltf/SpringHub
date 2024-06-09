package com.learn.restapi.SpringHub.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StudentResponse {

    /**
     * @JsonIgnore- skip this field in response of API
     */
    @JsonIgnore
    private Long id;

    private String firstName;

    private String lastName;

    public StudentResponse(long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
