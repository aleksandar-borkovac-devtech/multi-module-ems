package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.model.CustomerDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface ICustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto editCustomer(Long id, CustomerDto customer);
    List<CustomerDto> getAllCustomers();
    CustomerDto findCustomer(Long id);
    Boolean deleteCustomer(Long Id);
}
