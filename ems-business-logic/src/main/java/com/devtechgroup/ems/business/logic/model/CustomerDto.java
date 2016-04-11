package com.devtechgroup.ems.business.logic.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CustomerDto {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "^[a-z0-9]*$")
    @NotNull
    @Size(min = 1, max = 40)
    private String loginName;

    @NotNull
    @Size(min = 1, max = 40)
    private String password;

    @Size(max = 40)
    private String firstName;

    @Size(max = 40)
    private String lastName;

    @Email
    private String email;

}
