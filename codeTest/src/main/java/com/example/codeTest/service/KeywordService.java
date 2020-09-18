package com.example.codeTest.service;

import java.io.IOException;
import java.net.MalformedURLException;

import com.example.codeTest.domain.entity.KeywordEntity;
import com.example.codeTest.dto.InfoDto;

public interface KeywordService {

	//KeywordEntity가 DTO로 바뀌어야 함
	InfoDto locationByKeyword(String query) throws MalformedURLException, IOException;
	
	void addCount(KeywordEntity ke);
}
