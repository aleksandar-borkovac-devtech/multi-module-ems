package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.model.EmployeeDto;

import java.util.List;

public interface IEmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto editEmployee(Long employeeId, EmployeeDto employee);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto findEmployee(Long employeeId);
    Boolean deleteEmployee(Long employeeId);

}
