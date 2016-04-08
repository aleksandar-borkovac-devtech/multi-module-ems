package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.model.CustomerDto;
import java.util.Collection;

public interface ICustomerService {

    CustomerDto saveCustomer(CustomerDto customerDto);
    CustomerDto editCustomer(Long id, CustomerDto customerDto);
    Collection<CustomerDto> getAllCustomers();
    CustomerDto findCustomer(Long id);
    Boolean deleteCustomer(Long Id);
    CustomerDto createCustomer(CustomerDto customerDto);
    /*CustomerDto createCustomer(String loginName, String password,
                               String firstName, String lastName,
                               String email);*/
}
