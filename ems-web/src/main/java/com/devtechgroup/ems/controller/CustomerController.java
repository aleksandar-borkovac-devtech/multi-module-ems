package com.devtechgroup.ems.controller;

import com.devtechgroup.ems.business.logic.model.CustomerDto;
import com.devtechgroup.ems.business.logic.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "/api/customer", method = RequestMethod.GET)
    public List<CustomerDto> getAll(){

        return new ArrayList<>();
    }

    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.GET)
    public CustomerDto getById(@PathVariable String id){

        return new CustomerDto();
    }

    @RequestMapping(value = "/api/customer", method = RequestMethod.POST)
    public CustomerDto create(@RequestBody CustomerDto customer){

        CustomerDto newCustomer = customerService.createCustomer(customer);

        return newCustomer;
    }

    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.PUT)
    public CustomerDto update(@PathVariable String id, @RequestBody CustomerDto customer){

        return customer;
    }

    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestParam String id){

    }
}