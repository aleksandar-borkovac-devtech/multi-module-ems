package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.adapter.CustomerAdapter;
import com.devtechgroup.ems.business.logic.model.CustomerDto;
import com.devtechgroup.ems.data.access.entity.Customer;
import com.devtechgroup.ems.data.access.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class CustomerService implements ICustomerService{

    @Autowired
    protected ICustomerRepository customerRepository;



    @Override
    public CustomerDto editCustomer(Long id, CustomerDto customer){

        Customer one = customerRepository.findOne(id);
        one.setFirstName(customer.getFirstName());
        one.setLastName(customer.getLastName());
        one.setEmail(customer.getEmail());

        customerRepository.save(one);

        return CustomerAdapter.adapt(one);
    }

    @Override
    public CustomerDto findCustomer(Long id) {
        return CustomerAdapter.adapt(customerRepository.findOne(id));
    }

    @Override
    public Boolean deleteCustomer(Long id){
        Customer custom = customerRepository.findOne(id);
        if(custom!=null){
            customerRepository.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto){

        Customer newCustom = CustomerAdapter.adapt(customerDto);

        newCustom.setId(customerDto.getId());
        newCustom.setUsername(customerDto.getUsername());
        newCustom.setPassword(new BCryptPasswordEncoder().encode(customerDto.getPassword()));
        newCustom.setFirstName(customerDto.getFirstName());
        newCustom.setLastName(customerDto.getLastName());
        newCustom.setEmail(customerDto.getEmail());
        /*newCustom.setRole(customerDto.getRole());*/

        customerRepository.save(newCustom);

        return CustomerAdapter.adapt(newCustom);
    }

    @Override
    public List<CustomerDto> getAllCustomers(){

        return CustomerAdapter.adaptList(customerRepository.findAll());
    }

}
