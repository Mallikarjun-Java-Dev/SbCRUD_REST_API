package com.Demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Demo.dto.Admin;
import com.Demo.repository.AdminRepo;

@Repository
public class AdminDao {

	@Autowired
	AdminRepo adminRepo;
	
	public Admin insert(Admin admin) {
		return adminRepo.save(admin);
	}
}
