package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.model.EmployeeDto;
import java.util.Collection;

public interface IEmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto editEmployee(Long id, EmployeeDto employeeDto);
    Collection<EmployeeDto> getAllEmployees();
    EmployeeDto findEmployee(Long Id);
    Boolean deleteEmployee(Long Id);

}
