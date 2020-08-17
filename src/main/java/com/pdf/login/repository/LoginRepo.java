package com.pdf.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdf.login.entity.LoginEntity;

public interface LoginRepo extends JpaRepository<LoginEntity, String> {
	
	LoginEntity findByUserid(String userid);
	
	boolean existsByUserid(String userid);

}
