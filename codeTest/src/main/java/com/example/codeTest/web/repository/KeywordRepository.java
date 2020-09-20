package com.example.codeTest.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.codeTest.web.entity.Keyword;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {
	
	Keyword findByKeyword(String keyword);
	
	List<Keyword> findTop10ByOrderByCountDesc();
}
