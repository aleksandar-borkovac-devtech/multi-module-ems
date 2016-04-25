package com.devtechgroup.ems.controller;

import com.devtechgroup.ems.business.logic.model.EmployeeDto;
import com.devtechgroup.ems.business.logic.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController extends BaseApiController{

    private IEmployeeService _employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService){
        _employeeService = employeeService;
    }

    @RequestMapping(value = "/api/employee", method = RequestMethod.POST)
    public ResponseEntity createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = _employeeService.createEmployee(employeeDto);
    return (null == employee) ? serverError() : created(employee);
    }

    @RequestMapping(value = "/api/employee/{employee_id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("employee_id") Long employee_id) {
        EmployeeDto employee = _employeeService.findEmployee(employee_id);
        return (null == employee) ? serverError() : ok(employee);
    }

    @RequestMapping(value = "/api/employee/{employee_id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("employee_id") Long employee_id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto employee =_employeeService.editEmployee(employee_id, employeeDto);

        return (null == employee) ? serverError() : ok(employeeDto);
    }

    @RequestMapping(value = "/api/employee/{employee_id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("employee_id") Long employee_id){
        _employeeService.deleteEmployee(employee_id);

        return (false) ? serverError() : deleted();
    }

    @RequestMapping(value = "/api/employee", method = RequestMethod.GET)
    public ResponseEntity getAllEmployees(){
        List<EmployeeDto> list =_employeeService.getAllEmployees();

        return (list.isEmpty()) ? serverError() : ok(list);
    }
}
