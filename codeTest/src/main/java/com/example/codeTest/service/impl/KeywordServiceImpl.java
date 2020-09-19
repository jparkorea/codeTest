package com.example.codeTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codeTest.domain.entity.KeywordEntity;
import com.example.codeTest.domain.repository.KeywordRepository;
import com.example.codeTest.service.KeywordService;

@Service
public class KeywordServiceImpl implements KeywordService{

	@Autowired
	private KeywordRepository keywordRepository;
	
	@Override
	public List<KeywordEntity> getList(){
		return keywordRepository.findTop10ByOrderByCountDesc();
	}
	
	@Override
	public List<KeywordEntity> addCountAndGetList(String keyword) {
		
		if(keywordRepository.findByKeyword(keyword) == null) {
			keywordRepository.save(new KeywordEntity(keyword));
		}else {
			KeywordEntity keyEntity = keywordRepository.findByKeyword(keyword);
			keyEntity.setCount(keyEntity.getCount()+1);
			keywordRepository.save(keyEntity);
		}
		
		return keywordRepository.findTop10ByOrderByCountDesc();
	}

	
	
}
