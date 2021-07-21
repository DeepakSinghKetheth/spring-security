package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Employee;

//@Repository 	
public interface UserRepository extends JpaRepository<Employee, String> {

	Employee findByUsername(String username);
}
