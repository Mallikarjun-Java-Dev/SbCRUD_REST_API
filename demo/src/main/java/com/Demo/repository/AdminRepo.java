package com.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer>{

}
