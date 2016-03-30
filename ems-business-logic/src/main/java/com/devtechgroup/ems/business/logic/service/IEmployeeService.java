package com.devtechgroup.ems.business.logic.service;

import com.devtechgroup.ems.business.logic.model.Employee;

import java.util.Collection;

public interface IEmployeeService {

    Employee saveEmployee(Employee employee);
    Employee editEmployee(Long id,Employee employee);
    Collection<Employee> getAllEmployees();
    Employee findEmployee(Long employeeId);
    Boolean deleteEmployee(Long employeeId);

}
