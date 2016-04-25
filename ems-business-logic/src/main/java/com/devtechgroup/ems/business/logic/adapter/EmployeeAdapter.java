package com.devtechgroup.ems.business.logic.adapter;

import com.devtechgroup.ems.business.logic.model.EmployeeDto;
import com.devtechgroup.ems.data.access.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter {

    public static Employee adapt(EmployeeDto employeeDto){

        Employee retVal = new Employee();

        retVal.setId(employeeDto.getId());
        retVal.setUsername(employeeDto.getUsername());
        retVal.setPassword(employeeDto.getPassword());
        retVal.setFirstName(employeeDto.getFirstName());
        retVal.setLastName(employeeDto.getLastName());
        retVal.setEmail(employeeDto.getEmail());
        retVal.setCity(employeeDto.getCity());

        return retVal;

    }

    public static EmployeeDto adapt(Employee employee){

        EmployeeDto retVal = new EmployeeDto();

        retVal.setId(employee.getId());
        retVal.setUsername(employee.getUsername());
        retVal.setPassword(employee.getPassword());
        retVal.setFirstName(employee.getFirstName());
        retVal.setLastName(employee.getLastName());
        retVal.setEmail(employee.getEmail());
        retVal.setCity(employee.getCity());

        return retVal;
    }

    public static List<EmployeeDto> adaptList(List<Employee> employeeList){

        List<EmployeeDto> employeeDtoList = new ArrayList(employeeList);

        return employeeDtoList;
    }
    
}
