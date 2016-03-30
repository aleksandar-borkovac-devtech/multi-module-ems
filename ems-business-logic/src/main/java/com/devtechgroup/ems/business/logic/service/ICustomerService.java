package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.model.Customer;

import java.util.Collection;

public interface ICustomerService {

    Customer saveCustomer(Customer costum);
    Boolean deleteCustomer(Long costId);
    Customer editCustomer(Long id, Customer costum);

}