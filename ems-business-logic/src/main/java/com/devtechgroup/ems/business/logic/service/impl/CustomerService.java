package com.devtechgroup.ems.business.logic.service.impl;

        import com.devtechgroup.ems.business.logic.adapter.CustomerAdapter;
        import com.devtechgroup.ems.business.logic.model.CustomerDto;
        import com.devtechgroup.ems.business.logic.service.ICustomerService;
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
public class CustomerService implements ICustomerService {

    private ICustomerRepository _customerRepository;
    private IAuthorityRepository _authorityRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository, IAuthorityRepository authorityRepository){
        _authorityRepository = authorityRepository;
        _customerRepository = customerRepository;
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
        newCustom.setAuthorities(getCustomerAuthorities());
        _customerRepository.save(newCustom);

        return CustomerAdapter.adapt(newCustom);
    }

    private Set<Authority> getCustomerAuthorities() {
        Authority admin = _authorityRepository.findOne("ROLE_ADMIN");
        Authority user = _authorityRepository.findOne("ROLE_USER");
        Set<Authority> authorities = new HashSet<>();
        authorities.add(admin);
        authorities.add(user);
        return authorities;
    }

}
