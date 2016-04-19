package com.devtechgroup.ems.controller;

import com.devtechgroup.ems.business.logic.model.CustomerDto;
import com.devtechgroup.ems.business.logic.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomerController extends BaseApiController {

    private ICustomerService _customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        _customerService = customerService;
    }

    @RequestMapping(value = "/api/customer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto customer = _customerService.createCustomer(customerDto);
        return (null == customer) ? serverError() : created(customer);
    }
}