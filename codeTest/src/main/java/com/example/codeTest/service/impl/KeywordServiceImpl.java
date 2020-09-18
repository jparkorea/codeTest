package com.example.codeTest.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.http.HttpHeaders;

import com.example.codeTest.domain.entity.KeywordEntity;
import com.example.codeTest.dto.InfoDto;
import com.example.codeTest.helper.RestApiHelper;
import com.example.codeTest.service.KeywordService;

public class KeywordServiceImpl implements KeywordService{

	/**
	 * 키워드로 검색
	 * @throws IOException 
	 */
	@Override
	public InfoDto locationByKeyword(String query) throws IOException {
		
		
		
		String targetUrl = RestApiHelper.getApiUrl();
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Authorization", RestApiHelper.getRestApiKey());
		
		
		return null;
		
		//GET /v2/local/search/keyword.{format} HTTP/1.1
		//Host: dapi.kakao.com
		//Authorization: KakaoAK {REST_API_KEY}
	}

	@Override
	public void addCount(KeywordEntity ke) {
		// TODO Auto-generated method stub
		
	}

	
	
}
