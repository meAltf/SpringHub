package com.learn.restapi.SpringHub.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
