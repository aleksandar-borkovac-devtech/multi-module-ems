package com.devtechgroup.ems.business.logic.adapter;


import com.devtechgroup.ems.business.logic.model.CustomerDto;
import com.devtechgroup.ems.data.access.entity.Customer;

public class CustomerAdapter {

    public static Customer adapt(CustomerDto customerDto){

        Customer retVal = new Customer();

        retVal.setId(customerDto.getId());
        retVal.setFirstName(customerDto.getFirstName());
        retVal.setLastName(customerDto.getLastName());
        retVal.setEmail(customerDto.getEmail());

        return retVal;

    }

    public static CustomerDto adapt(Customer customer){

        CustomerDto retVal = new CustomerDto();

        retVal.setId(customer.getId());
        retVal.setFirstName(customer.getFirstName());
        retVal.setLastName(customer.getLastName());
        retVal.setEmail(customer.getEmail());

        return retVal;
    }

}
