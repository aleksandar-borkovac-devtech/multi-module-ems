package com.devtechgroup.ems.data.access.repository;

import com.devtechgroup.ems.data.access.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
