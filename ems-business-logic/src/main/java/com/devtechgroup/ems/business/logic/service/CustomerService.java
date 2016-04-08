package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.model.CustomerDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CustomerService implements ICustomerService{

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto){
        return null;
    }

    @Override
    public CustomerDto editCustomer(Long id, CustomerDto customerDto){
        return null;
    }

    @Override
    public Collection<CustomerDto> getAllCustomers() {
        return null;
    }

    @Override
    public CustomerDto findCustomer(Long id) {
        return null;
    }

    @Override
    public Boolean deleteCustomer(Long id){
        return null;
    }

  @Override
    public CustomerDto createCustomer(CustomerDto customerDto){

      CustomerDto custom = new CustomerDto();

      custom.setLoginName(customerDto.getLoginName());
      custom.setPassword(customerDto.getPassword());
      custom.setFirstName(customerDto.getFirstName());
      custom.setLastName(customerDto.getLastName());
      custom.setEmail(customerDto.getEmail());

        return custom;
    }

}
