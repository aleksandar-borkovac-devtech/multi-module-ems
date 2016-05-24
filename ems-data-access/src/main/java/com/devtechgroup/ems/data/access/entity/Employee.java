package com.devtechgroup.ems.data.access.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "employee")
public class Employee {

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

    @ManyToOne
    @JoinColumn(name = "fk_id")
    private Customer fk;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "employee_authority",
            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities = new HashSet<>();
}