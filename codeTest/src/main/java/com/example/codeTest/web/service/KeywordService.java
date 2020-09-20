package com.example.codeTest.web.service;

import java.util.List;

import com.example.codeTest.web.entity.Keyword;

public interface KeywordService {

	List<Keyword> getList();
	
	List<Keyword> addCountAndGetList(String keyword);
}
