package com.example.codeTest.web.service.impl;

import java.io.IOException;
import java.net.URLEncoder;

import com.example.codeTest.web.entity.Document;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codeTest.helper.JsonProcessHelper;
import com.example.codeTest.helper.RestApiHelper;
import com.example.codeTest.web.dto.InfoDto;
import com.example.codeTest.web.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	RestApiHelper restApiHelper;
	
	/**
	 * 키워드로 검색
	 * @throws IOException 
	 */
	@Override
	public InfoDto locationByKeyword(String query) throws IOException {

		InfoDto infoDto = new InfoDto();
		//Query 한글 포함 여부 체크 후 한글 포함 시 UTF-8 인코딩
		String regExp = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";
		String targetUrl = restApiHelper.getApiUrl()+"query=";
		if(query.matches(regExp)) {
			targetUrl += URLEncoder.encode(query, "UTF-8"); 
		}else {
			targetUrl += query;
		}

		try {
			//주소로 URL 객체 생성	
			String jsonData = JsonProcessHelper.getJsonData(targetUrl, restApiHelper.getRestApiKey());

			infoDto = JsonProcessHelper.jsonToData(jsonData);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return infoDto;
	}

}
