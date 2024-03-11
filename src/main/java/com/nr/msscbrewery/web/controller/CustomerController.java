package com.nr.msscbrewery.web.controller;

import com.nr.msscbrewery.services.CustomerService;
import com.nr.msscbrewery.web.model.CustomerDto;
import com.nr.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private  final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId")UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId) , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> handlePost(@RequestBody  CustomerDto customerDto){
        CustomerDto savedDto  = customerService.saveCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        //ToDo add hostname to url
        headers.add("Location","/api/v1/customer/"+savedDto.getId().toString());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<HttpStatus> handleUpdate(@RequestBody CustomerDto customerDto,@PathVariable("customerId") UUID customerId){
        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHandle(@PathVariable("customerId") UUID customerId){
        customerService.deleteById(customerId);
    }
}
