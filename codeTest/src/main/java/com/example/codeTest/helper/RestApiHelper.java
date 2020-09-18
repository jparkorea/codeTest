package com.example.codeTest.helper;

public class RestApiHelper {

	public enum HttpMethodType { POST, GET, DELETE }
	
	private static final String API_URL  = "https://dapi.kakao.com/v2/local/search/keyword.json";
	
	private static final String REST_API_KEY = "ac85e92d83fe5db337fa2dc8d2158563";
	
	private static final String JS_KEY = "11c6eb02866d2c20a4c4e0b2cc0427f0";

	public static String getApiUrl() {
		return API_URL;
	}

	public static String getRestApiKey() {
		return REST_API_KEY;
	}

	public static String getJsKey() {
		return JS_KEY;
	}
	
	
}
