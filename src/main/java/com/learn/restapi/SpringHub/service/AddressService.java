package com.learn.restapi.SpringHub.service;

import com.learn.restapi.SpringHub.entity.Address;
import com.learn.restapi.SpringHub.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Optional<Address> getAddressById(long id) {
        return addressRepository.findById(id);
    }
}
