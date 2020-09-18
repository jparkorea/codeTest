package com.example.codeTest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codeTest.domain.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long>{
	
}
