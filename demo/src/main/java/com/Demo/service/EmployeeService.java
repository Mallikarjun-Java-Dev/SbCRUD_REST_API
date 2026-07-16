package com.Demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Demo.dao.EmployeeDao;
import com.Demo.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public String insertData(Employee employee) {
		return employeeDao.insertData(employee);
	}
	
	public Object fetchById(int id) {
	      return employeeDao.fetchById(id);
	      }
	
	public List<Employee> findAllemp(){
		return employeeDao.findALLemp();
		
	}
	public void deleteById(int id) {
		  employeeDao.deleteById(id);
	}
	
	public String deleteAll() {
		return employeeDao.deleteAll();
	}

	public String update(Employee employee) {
		return employeeDao.update(employee);
	}

	public String insertAllData(List<Employee> employee) {
		
		return employeeDao.insertAllData(employee);
	}
	
	public Page<Employee> fetch(int page, int size){
		PageRequest of = PageRequest.of(page, size, Sort.by("name"));

    	  return employeeDao.findAll(of);
    }
	
	
	
}
