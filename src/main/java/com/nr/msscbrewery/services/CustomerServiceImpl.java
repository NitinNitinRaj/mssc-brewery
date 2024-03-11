package com.nr.msscbrewery.services;

import com.nr.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements  CustomerService{
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return  CustomerDto.builder().id(UUID.randomUUID()).name("Nitin").build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {

    }

    @Override
    public void deleteById(UUID customerId) {

    }
}
