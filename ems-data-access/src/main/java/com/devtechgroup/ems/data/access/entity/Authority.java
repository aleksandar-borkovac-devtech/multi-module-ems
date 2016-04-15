package com.devtechgroup.ems.data.access.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authority")
public class Authority {

   /* @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    @Id
    @Column(name = "authority_name")
    private String authorityName;

}