package com.devtechgroup.ems.business.logic.adapter;

import com.devtechgroup.ems.business.logic.model.EmployeeDto;
import com.devtechgroup.ems.data.access.entity.Employee;

public final class EmployeeAdapter {

    public static Employee adapt(EmployeeDto employeeDto){

        Employee retVal = new Employee();

        retVal.setId(employeeDto.getId());
        retVal.setFirstName(employeeDto.getFirstName());
        retVal.setLastName(employeeDto.getLastName());
        retVal.setCity(employeeDto.getCity());
        retVal.setEmail(employeeDto.getEmail());
        retVal.setSalary(employeeDto.getSalary());

        return retVal;
    }

    public static EmployeeDto adapt(Employee employee){

        EmployeeDto retVal = new EmployeeDto();

        retVal.setId(employee.getId());
        retVal.setFirstName(employee.getFirstName());
        retVal.setLastName(employee.getLastName());
        retVal.setEmail(employee.getEmail());
        retVal.setCity(employee.getCity());
        retVal.setSalary(employee.getSalary());

        return retVal;
    }
}
