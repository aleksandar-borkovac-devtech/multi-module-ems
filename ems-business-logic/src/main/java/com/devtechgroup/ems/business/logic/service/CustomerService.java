package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.adapter.CustomerAdapter;
import com.devtechgroup.ems.business.logic.model.CustomerDto;
import com.devtechgroup.ems.data.access.entity.Customer;
import com.devtechgroup.ems.data.access.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CustomerService implements ICustomerService{

    @Autowired
    protected ICustomerRepository customerRepository;

    @Autowired
    protected CustomerAdapter customerAdapter;

    @Override
    public CustomerDto editCustomer(Long id, CustomerDto customer){

        Customer one = customerRepository.findOne(id);
        one.setFirstName(customer.getFirstName());
        one.setLastName(customer.getLastName());
        one.setEmail(customer.getEmail());

        customerRepository.save(one);

        return customerAdapter.adapt(one);
    }

    @Override
    public CustomerDto findCustomer(Long id) {
        return customerAdapter.adapt(customerRepository.findOne(id));
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
        Customer newCustom = customerAdapter.adapt(customerDto);
        customerRepository.save(newCustom);
        return customerAdapter.adapt(newCustom);
    }

    @Override
    public Collection<CustomerDto> getAllCustomers() {
        return null;
    }

}
