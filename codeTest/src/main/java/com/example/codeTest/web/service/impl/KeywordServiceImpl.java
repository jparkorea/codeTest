package com.example.codeTest.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codeTest.web.entity.Keyword;
import com.example.codeTest.web.repository.KeywordRepository;
import com.example.codeTest.web.service.KeywordService;

@Service
public class KeywordServiceImpl implements KeywordService{

	@Autowired
	private KeywordRepository keywordRepository;
	
	@Override
	public List<Keyword> getList(){
		return keywordRepository.findTop10ByOrderByCountDesc();
	}
	
	@Override
	public List<Keyword> addCountAndGetList(String keyword) {
		
		if(keywordRepository.findByKeyword(keyword) == null) {
			keywordRepository.save(new Keyword(keyword));
		}else {
			Keyword keyEntity = keywordRepository.findByKeyword(keyword);
			keyEntity.setCount(keyEntity.getCount()+1);
			keywordRepository.save(keyEntity);
		}
		
		return keywordRepository.findTop10ByOrderByCountDesc();
	}

	
	
}
