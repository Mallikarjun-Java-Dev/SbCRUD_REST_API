package com.Demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.Demo.dto.Employee;
import com.Demo.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;

	public String insertData(Employee employee) {
		employeeRepository.save(employee);
		return "Data inserted";
	}

	public Object fetchById(int id) {
		Optional<Employee> oe=employeeRepository.findById(id);
	       if(oe.isPresent()) {
      return oe.get();	    	   
	       }
	       else
		return "no data found with id";
	}

	public List<Employee> findALLemp() {
		return employeeRepository.findAll();
	}

	public void deleteById(int id) {
		employeeRepository.deleteById(id);
		 

	}

	public String deleteAll() {
		employeeRepository.deleteAll();
		return "all data deleted";
	}

	public String update(Employee employee) {

		 employeeRepository.save(employee);
		 return "data update";
	}

	public String insertAllData(List<Employee> employee) {
		
		 employeeRepository.saveAll(employee);
		return "All data inserted";
	}
	
	 public Page<Employee> findAll(int page, int size){
	    	PageRequest of= PageRequest.of(page, size, org.springframework.data.domain.Sort.by("name"));
	    	return  employeeRepository.findAll(of);
	    }

	/*
	 * WHAT WENT WRONG:
	 * 1. Duplicate local variable error: The method parameter was named 'of', and inside the method
	 *    there was an attempt to redeclare 'of' as "PageRequest of = ...".
	 * 2. Cannot find symbol error: Inside this method, 'page' and 'size' variables were referenced,
	 *    but they were not defined in this method's parameters or scope.
	 * 
	 * HOW IT WAS FIXED:
	 * Since the PageRequest object (which contains the page, size, and sorting configuration)
	 * is already constructed in the Service class and passed to this method as 'of', we can
	 * simply pass 'of' directly to employeeRepository.findAll(of) without re-declaring or re-creating it.
	 */
	 public Page<Employee> findAll(PageRequest of) {
	    	return  employeeRepository.findAll(of);
	 }

	 
}