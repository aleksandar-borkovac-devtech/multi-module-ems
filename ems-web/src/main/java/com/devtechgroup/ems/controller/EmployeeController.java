package com.devtechgroup.ems.controller;

import com.devtechgroup.ems.business.logic.model.EmployeeDto;
import com.devtechgroup.ems.business.logic.service.IEmployeeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
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

    @RequestMapping(value = "/api/employee/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("employeeId") Long employeeId) {
        EmployeeDto employee = _employeeService.findEmployee(employeeId);
        return (null == employee) ? serverError() : ok(employee);
    }

    @RequestMapping(value = "/api/employee/{employeeId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("employeeId") Long employeeId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto employee =_employeeService.editEmployee(employeeId, employeeDto);

        return (null == employee) ? serverError() : update(employeeDto);
    }

    @RequestMapping(value = "/api/employee/{employeeId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("employeeId") Long employeeId){
        Boolean isDeleted =_employeeService.deleteEmployee(employeeId);

        return (isDeleted)? deleted() : serverError();
    }

    @RequestMapping(value = "/api/employee", method = RequestMethod.GET)
    public ResponseEntity getAllEmployees(){
        List<EmployeeDto> list =_employeeService.getAllEmployees();

        return ok(list);
    }
}
