package com.devtechgroup.ems.data.access.repository;

import com.devtechgroup.ems.data.access.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository  extends JpaRepository<Employee, Long>{



}
