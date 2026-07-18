package com.Demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.dto.Admin;
import com.Demo.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/add")
	public Admin insert(Admin admin) {
		return adminService.insert(admin);
	}
}
