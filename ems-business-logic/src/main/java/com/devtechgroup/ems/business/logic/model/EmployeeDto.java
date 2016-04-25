package com.devtechgroup.ems.business.logic.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class EmployeeDto {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
