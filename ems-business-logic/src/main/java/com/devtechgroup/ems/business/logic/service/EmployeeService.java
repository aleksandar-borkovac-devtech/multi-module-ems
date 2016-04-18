package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.adapter.EmployeeAdapter;
import com.devtechgroup.ems.business.logic.model.EmployeeDto;
import com.devtechgroup.ems.data.access.entity.Employee;
import com.devtechgroup.ems.data.access.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class EmployeeService implements IEmployeeService{

    /*@Autowired
    protected IEmployeeRepository employeeRepository;*/


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return null;
        //return employeeRepository.save(employeeAdapter.adapt(employeeDto));
    }

    @Override
    public EmployeeDto editEmployee(Long id, EmployeeDto employeeDto) {

        /*Employee one = employeeRepository.findOne(id);

        one.setFirstName(employeeDto.getFirstName());
        one.setLastName(employeeDto.getLastName());
        one.setCity(employeeDto.getCity());
        one.setEmail(employeeDto.getEmail());
        one.setSalary(employeeDto.getSalary());

        EmployeeDto adapt = EmployeeAdapter.adapt(one);*/

        return null;
        //return employeeRepository.save();
    }

    @Override
    public Collection<EmployeeDto> getAllEmployees() {
        /*Iterable<Employee> itr = employeeRepository.findAll();*/
        return null;
        //return (Collection<EmployeeDto>) itr;
    }

    @Override
    public EmployeeDto findEmployee(Long id) {
        return null;
        //return employeeRepository.findOne(id);
    }

    @Override
    public Boolean deleteEmployee(Long Id) {
        /*Employee temp = employeeRepository.findOne(employeeId);
        if(temp!=null){
            employeeRepository.delete(id);
        }*/
        return true;
    }
}