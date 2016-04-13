package com.devtechgroup.ems.business.logic.adapter;


import com.devtechgroup.ems.business.logic.model.CustomerDto;
import com.devtechgroup.ems.data.access.entity.Customer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CustomerAdapter {

    public static Customer adapt(CustomerDto customerDto){

        Customer retVal = new Customer();

        retVal.setId(customerDto.getId());
        retVal.setUsername(customerDto.getUsername());
        retVal.setPassword(customerDto.getPassword());
        retVal.setFirstName(customerDto.getFirstName());
        retVal.setLastName(customerDto.getLastName());
        retVal.setEmail(customerDto.getEmail());

        return retVal;

    }

    public static CustomerDto adapt(Customer customer){

        CustomerDto retVal = new CustomerDto();

        retVal.setId(customer.getId());
        retVal.setUsername(customer.getUsername());
        retVal.setPassword(customer.getPassword());
        retVal.setFirstName(customer.getFirstName());
        retVal.setLastName(customer.getLastName());
        retVal.setEmail(customer.getEmail());

        return retVal;
    }

    public static List<CustomerDto> adaptList(List<Customer> customerList){

        List<CustomerDto> customerDtoList = new ArrayList(customerList);

        return customerDtoList;
    }

   /* public static List<Customer> adapt(List<CustomerDto> customerDtoList){
        return customerDtoList.stream().map(this::adapt).collect(toList());
    }*/


}
