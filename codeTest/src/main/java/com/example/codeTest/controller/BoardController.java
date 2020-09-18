package com.example.codeTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.codeTest.domain.entity.KeywordEntity;
import com.example.codeTest.domain.repository.KeywordRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private KeywordRepository keywordRepository;
	
	@GetMapping("/list")
	public String addr(Model model) {
		List<KeywordEntity> keywords = keywordRepository.findAll();
		model.addAttribute("keywords", keywords);
		return "board/list";
	}
}

