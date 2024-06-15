package com.learn.restapi.SpringHub.response;

import com.learn.restapi.SpringHub.entity.Address;
import lombok.Data;

@Data
public class AddressResponse {

    private Long id;
    private String streetName;
    private String cityName;

    public AddressResponse(Address address){
        this.id = address.getId();
        this.cityName = address.getCityName();
        this.streetName = address.getStreetName();
    }
}
