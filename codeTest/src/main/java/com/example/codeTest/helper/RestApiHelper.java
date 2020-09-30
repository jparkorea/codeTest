package com.example.codeTest.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestApiHelper {

	public enum HttpMethodType { POST, GET, DELETE }
	
	private final String API_URL  = "https://dapi.kakao.com/v2/local/search/keyword.json?";
	
	private final String MAP_URL = "	https://map.kakao.com/link/map/";

	@Value("${kakao.rest.api}")
	private String REST_API_KEY;
	
	public String getApiUrl() {
		return API_URL;
	}

	public String getMapUrl() {
		return MAP_URL;
	}
	
	public String getRestApiKey() {
		return REST_API_KEY;
	}

	@Override
	public String toString() {
		return "RestApiHelper [API_URL=" + API_URL + ", MAP_URL=" + MAP_URL + ", REST_API_KEY=" + REST_API_KEY + "]";
	}

	
}
