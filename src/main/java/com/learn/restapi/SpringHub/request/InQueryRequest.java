package com.learn.restapi.SpringHub.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InQueryRequest {

    /**
     * created this inQueryRequest- to fetch students details based on the List of firstName..
     */

    private List<String> firstNames;
}
