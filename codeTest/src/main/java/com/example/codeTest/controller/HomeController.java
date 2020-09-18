package com.example.codeTest.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping
	public String index() {
		logger.info("HomeController, GetMapping('/')");
		return "index";
	}
}

