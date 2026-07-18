package com.Demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.dao.AdminDao;
import com.Demo.dto.Admin;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
	public Admin insert(Admin admin ){
		return adminDao.insert(admin);
	}
}
