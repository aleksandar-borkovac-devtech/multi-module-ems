package com.devtechgroup.ems.data.access.repository;

import com.devtechgroup.ems.data.access.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorityRepository extends JpaRepository<Authority, Long>{
}
