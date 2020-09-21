package com.example.codeTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.codeTest.helper.JsonProcessHelper;
import com.example.codeTest.helper.RestApiHelper;

@SpringBootTest
class CodeTestApplicationTests {

	@Autowired
	RestApiHelper helper;
	
	@Test
	void contextLoads() {
	}

	@Test
	void keyTest() {
		System.out.println(helper.toString());
		System.out.println(new JsonProcessHelper().toString());
	}
}
