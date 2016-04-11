package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.model.CustomerDto;

import java.util.Collection;

public interface ICustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto editCustomer(Long id, CustomerDto customer);
    Collection<CustomerDto> getAllCustomers();
    CustomerDto findCustomer(Long id);
    Boolean deleteCustomer(Long Id);
}
