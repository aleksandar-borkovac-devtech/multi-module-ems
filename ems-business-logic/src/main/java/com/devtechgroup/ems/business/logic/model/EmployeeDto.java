package com.devtechgroup.ems.business.logic.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
public class EmployeeDto {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size
    private String firstName;

    private String lastName;

    private String email;

    private String city;

    private Integer salary;
}
