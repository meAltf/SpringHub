package com.learn.restapi.SpringHub.controller;

import com.learn.restapi.SpringHub.entity.Address;
import com.learn.restapi.SpringHub.response.AddressResponse;
import com.learn.restapi.SpringHub.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    Logger logger = LoggerFactory.getLogger(AddressController.class);


    @GetMapping("/getAddress/{id}")
    public List<AddressResponse> getAddressById(@PathVariable long id){

        logger.error("Inside Error");
        logger.warn("Inside warn");
        logger.info("Inside Info");
        logger.debug("Inside debug");
        logger.debug("Inside Trace");

        Optional<Address> addressList = addressService.getAddressById(id);

        List<AddressResponse> addressResponseList = new ArrayList<>();
        addressList.stream().forEach(address -> {
            addressResponseList.add(new AddressResponse(address));
        });
        return addressResponseList;
    }
}
