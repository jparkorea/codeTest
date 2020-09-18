package com.example.codeTest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codeTest.domain.entity.KeywordEntity;

public interface KeywordRepository extends JpaRepository<KeywordEntity, String> {
	
}
