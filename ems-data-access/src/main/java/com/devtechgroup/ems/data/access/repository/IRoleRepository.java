package com.devtechgroup.ems.data.access.repository;

import com.devtechgroup.ems.data.access.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
}
