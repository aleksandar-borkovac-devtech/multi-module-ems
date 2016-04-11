package com.devtechgroup.ems.business.logic.model;


import com.devtechgroup.ems.data.access.entity.Customer;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table
public class CustomerDto {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "^[a-z0-9]*$")
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "login_name")
    private String loginName;

    @NotNull
    @Size(min = 1, max = 40)
    private String password;

    @Size(max = 40)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 40)
    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

}
