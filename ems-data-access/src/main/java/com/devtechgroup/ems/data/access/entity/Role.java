package com.devtechgroup.ems.data.access.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_user")
    private String roleUser;

    @Column(name = "role_admin")
    private String roleAdmin;

    @Column(name = "role_super")
    private String roleSuper;

}
