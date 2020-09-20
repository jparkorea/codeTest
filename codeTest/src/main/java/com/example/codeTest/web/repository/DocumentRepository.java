package com.example.codeTest.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.codeTest.web.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String>  {

	Page<Document> findByQuery(String query, Pageable pageable);
}
