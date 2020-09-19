package com.example.codeTest.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codeTest.domain.entity.KeywordEntity;

public interface KeywordRepository extends JpaRepository<KeywordEntity, Long> {
	
	KeywordEntity findByKeyword(String keyword);
	
	List<KeywordEntity> findTop10ByOrderByCountDesc();
}
