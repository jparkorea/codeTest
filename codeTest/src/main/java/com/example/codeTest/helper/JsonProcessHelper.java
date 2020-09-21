package com.example.codeTest.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.tomcat.util.json.ParseException;

import com.example.codeTest.web.dto.InfoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProcessHelper {

	/**
	 * API에서 받아온 값을 Json 데이터로 반환
	 * @param apiUrl
	 * @return
	 * @throws Exception
	 */
	public static String getJsonData(String apiUrl, String apiKey) throws Exception {
		URL url = new URL(apiUrl);
		HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "KakaoAK "+apiKey);
		
		int responseCode = con.getResponseCode();
		BufferedReader br = null;
		
		if(responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		}else {
			System.out.println(responseCode+" Error");
			throw new Exception();
		}
		 
		StringBuilder sb = new StringBuilder();
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			sb.append(line);
		}
		br.close();
		con.disconnect();
		
		return sb.toString();
	}
	
	/**
	 * Json 데이터를 InfoDto 객체로 변환
	 * @param json
	 * @return
	 * @throws ParseException
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static InfoDto jsonToData(String json) throws ParseException, JsonMappingException, JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		InfoDto infoDto = objectMapper.readValue(json, InfoDto.class);
		
		return infoDto;
	}
}
