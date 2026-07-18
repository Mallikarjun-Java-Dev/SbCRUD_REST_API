package com.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
