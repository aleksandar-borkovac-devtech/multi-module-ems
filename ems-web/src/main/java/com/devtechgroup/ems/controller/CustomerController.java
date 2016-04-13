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

    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.GET)
    public CustomerDto getById(@PathVariable("id") Long id){

        return customerService.findCustomer(id);
    }

    @RequestMapping(value = "/api/customer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@Valid @RequestBody CustomerDto customerDto){

        return customerService.createCustomer(customerDto);
    }

    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.PUT)
    public CustomerDto update(@PathVariable Long id, @RequestBody CustomerDto customer){

        return customer;
    }

    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id){
        return "deleted!";
    }

    @RequestMapping(value = "/api/customer", method = RequestMethod.GET)
    public List<CustomerDto> getAllCustomers(){

        return customerService.getAllCustomers();
    }
}