package com.devtechgroup.ems.controller;

import com.devtechgroup.ems.business.logic.model.EmployeeDto;
import com.devtechgroup.ems.business.logic.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    /*@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") EmployeeDto employeeDto, BindingResult bindingResult,
                              final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "addEmployee";
        }
        EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
        if (employeeDto1 != null) {
            redirectAttributes.addFlashAttribute("saveEmployee", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveEmployee", "unsuccess");
        }

        return "redirect:/employee";
    }*/

    @RequestMapping(value = "/api/employee", method = RequestMethod.GET)
    public List<EmployeeDto> getAll(){

        return new ArrayList<>();
    }

    @RequestMapping(value = "/api/employee/{id}", method = RequestMethod.GET)
    public EmployeeDto getById( @PathVariable String id){

        return new EmployeeDto();
    }

    @RequestMapping(value = "/api/employee", method = RequestMethod.POST)
    public EmployeeDto create(@RequestBody EmployeeDto employee, HttpServletRequest request){




        /*
        * User newUser = userService.createUser(managedUserDTO);
            String baseUrl = request.getScheme() + // "http"
            "://" +                                // "://"
            request.getServerName() +              // "myhost"
            ":" +                                  // ":"
            request.getServerPort() +              // "80"
            request.getContextPath();              // "/myContextPath" or "" if deployed in root context
            mailService.sendCreationEmail(newUser, baseUrl);
            return ResponseEntity.created(new URI("/api/users/" + newUser.getLogin()))
                .headers(HeaderUtil.createAlert( "userManagement.created", newUser.getLogin()))
                .body(newUser);
        }
        *
        * */



        return employee;
    }

    @RequestMapping(value = "/api/employee/{id}", method = RequestMethod.PUT)
    public EmployeeDto update(@PathVariable String id, @RequestBody EmployeeDto employee){

        return employee;
    }

    @RequestMapping(value = "/api/employee/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestParam String id){

    }
}
