package com.devtechgroup.ems.data.access.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(targetEntity=Employee.class, mappedBy = "fk")
    private Set<Employee> employees;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "customer_authority",
            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities = new HashSet<>();
}
