package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.adapter.CustomerAdapter;
import com.devtechgroup.ems.business.logic.model.CustomerDto;
import com.devtechgroup.ems.data.access.entity.Authority;
import com.devtechgroup.ems.data.access.entity.Customer;
import com.devtechgroup.ems.data.access.repository.IAuthorityRepository;
import com.devtechgroup.ems.data.access.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CustomerService implements ICustomerService{

    @Autowired
    protected ICustomerRepository customerRepository;

    @Autowired
    private IAuthorityRepository authorityRepository;

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

        Authority admin = authorityRepository.findOne("ROLE_ADMIN");
        Authority user = authorityRepository.findOne("ROLE_USER");
        Set<Authority> authorities = new HashSet<>();

        try{
            newCustom.setId(customerDto.getId());
            newCustom.setUsername(customerDto.getUsername());
            newCustom.setPassword(new BCryptPasswordEncoder().encode(customerDto.getPassword()));
            newCustom.setFirstName(customerDto.getFirstName());
            newCustom.setLastName(customerDto.getLastName());
            newCustom.setEmail(customerDto.getEmail());
            authorities.add(admin);
            authorities.add(user);
            newCustom.setAuthorities(authorities);
            customerRepository.save(newCustom);
        }catch (DataIntegrityViolationException e){
            //log error
            //throw exception
        }

        return CustomerAdapter.adapt(newCustom);
    }

    @Override
    public List<CustomerDto> getAllCustomers(){

        return CustomerAdapter.adaptList(customerRepository.findAll());
    }

}
