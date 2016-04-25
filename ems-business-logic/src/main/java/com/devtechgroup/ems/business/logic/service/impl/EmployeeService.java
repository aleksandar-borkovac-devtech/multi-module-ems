package com.devtechgroup.ems.business.logic.service.impl;

import com.devtechgroup.ems.business.logic.adapter.EmployeeAdapter;
import com.devtechgroup.ems.business.logic.model.EmployeeDto;
import com.devtechgroup.ems.business.logic.service.IEmployeeService;
import com.devtechgroup.ems.data.access.entity.Authority;
import com.devtechgroup.ems.data.access.entity.Employee;
import com.devtechgroup.ems.data.access.repository.IAuthorityRepository;
import com.devtechgroup.ems.data.access.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {

    private IEmployeeRepository _employeeRepository;

    private IAuthorityRepository _authorityRepository;

    private EmployeeAdapter employeeAdapter;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository, IAuthorityRepository authorityRepository){
        _employeeRepository = employeeRepository;
        _authorityRepository = authorityRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee newEmployee = EmployeeAdapter.adapt(employeeDto);

        newEmployee.setId(employeeDto.getId());
        newEmployee.setFirstName(employeeDto.getFirstName());
        newEmployee.setLastName(employeeDto.getLastName());
        newEmployee.setCity(employeeDto.getCity());
        newEmployee.setEmail(employeeDto.getEmail());
        newEmployee.setUsername(employeeDto.getUsername());
        newEmployee.setPassword(employeeDto.getPassword());
        newEmployee.setAuthorities(getEmployeeAuthorities());
        _employeeRepository.save(newEmployee);

        return employeeAdapter.adapt(newEmployee);
    }

    private Set<Authority> getEmployeeAuthorities() {
        Authority user = _authorityRepository.findOne("ROLE_USER");
        Set<Authority> authorities = new HashSet<>();
        authorities.add(user);
        return authorities;
    }

    @Override
    public EmployeeDto editEmployee(Long employee_id, EmployeeDto employee) {

        Employee emp = _employeeRepository.findOne(employee_id);

        emp.setId(employee.getId());
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setCity(employee.getCity());
        emp.setEmail(employee.getEmail());
        emp.setUsername(employee.getUsername());

        return employeeAdapter.adapt(_employeeRepository.save(emp));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        return employeeAdapter.adaptList(_employeeRepository.findAll());

    }

    @Override
    public EmployeeDto findEmployee(Long employee_id) {

        return employeeAdapter.adapt(_employeeRepository.findOne(employee_id));

    }

    @Override
    public Boolean deleteEmployee(Long employee_id) {

        Employee employee = _employeeRepository.findOne(employee_id);
        if (employee != null){
            _employeeRepository.delete(employee_id);
            return true;
        }
        return false;

    }

}
