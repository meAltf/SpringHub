package com.learn.restapi.SpringHub.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class InQueryRequest {

    /**
     * created this inQueryRequest- to fetch students details based on the List of firstName..
     */

    private List<String> firstNames;
}
