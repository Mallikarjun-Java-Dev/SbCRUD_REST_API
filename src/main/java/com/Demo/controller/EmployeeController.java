package com.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.dto.Employee;
import com.Demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public String insertData(@RequestBody Employee employee) {

		return employeeService.insertData(employee);
		// return "Data Inserted Successfully";
	}

	@GetMapping("/{id}")
	public Object fetchById(@PathVariable int id) {
		return employeeService.fetchById(id);
	}

	@GetMapping
	public List<Employee> findallemp() {
		return employeeService.findAllemp();
	}

	// Delete employee by sending id in request body: {"id": 26}
	@DeleteMapping("/deleteById")
	public String deleteByBody(@RequestBody Employee employee) {
		employeeService.DeleteById(employee.getId());
		return "data deleted";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		employeeService.DeleteById(id);
		return "data deleted";
	}

	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return employeeService.deleteAll();
	}

	@PostMapping("/all")
	public String insertAllData(@RequestBody List<Employee> employee) {
		return employeeService.insertAllData(employee);
	}

	@PatchMapping
	public String update(@RequestBody Employee employee) {
		return employeeService.update(employee);
	}
	
	// @GetMapping("/fetch/{page}/{size}")
    // public Page<Employee> fetchAllEmployee(@PathVariable int page, @PathVariable int size){
    // 	return employeeService.fetch(page, size);
    // }
}