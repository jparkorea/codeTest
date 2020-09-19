package com.example.codeTest.service;

import java.util.List;

import com.example.codeTest.domain.entity.KeywordEntity;

public interface KeywordService {

	List<KeywordEntity> getList();
	
	List<KeywordEntity> addCountAndGetList(String keyword);
}
