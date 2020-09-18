package com.example.codeTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

	@GetMapping("/addr")
	public String addr() {
		return "search/addr";
	}
	
	 
}
