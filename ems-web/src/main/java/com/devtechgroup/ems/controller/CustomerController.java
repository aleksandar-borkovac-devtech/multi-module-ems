package com.devtechgroup.ems.controller;

import com.devtechgroup.ems.business.logic.model.CustomerDto;
import com.devtechgroup.ems.business.logic.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {


    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/api/customer/{customer_id}", method = RequestMethod.GET)
    public CustomerDto getById(@PathVariable("customer_id") Long customer_id){

        return customerService.findCustomer(customer_id);
    }

    @RequestMapping(value = "/api/customer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@Valid @RequestBody CustomerDto customerDto){

        return customerService.createCustomer(customerDto);
    }

    @RequestMapping(value = "/api/customer/{customer_id}", method = RequestMethod.PUT)
    public CustomerDto update(@PathVariable("customer_id") Long customer_id, @RequestBody CustomerDto customer){

        return customer;
    }

    @RequestMapping(value = "/api/customer/{customer_id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("customer_id") Long customer_id){
        return "deleted!";
    }

    @RequestMapping(value = "/api/customer", method = RequestMethod.GET)
    public List<CustomerDto> getAllCustomers(){

        return customerService.getAllCustomers();
    }
}