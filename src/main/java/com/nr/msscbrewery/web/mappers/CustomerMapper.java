package com.nr.msscbrewery.web.mappers;

import com.nr.msscbrewery.domain.Customer;
import com.nr.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
