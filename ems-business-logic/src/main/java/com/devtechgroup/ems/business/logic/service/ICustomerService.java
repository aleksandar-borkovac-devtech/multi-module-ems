package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.model.CustomerDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface ICustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
}
