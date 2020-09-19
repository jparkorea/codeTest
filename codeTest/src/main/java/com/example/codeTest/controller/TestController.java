package com.example.codeTest.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeTest.domain.entity.KeywordEntity;
import com.example.codeTest.domain.entity.LoginEntity;
import com.example.codeTest.domain.repository.KeywordRepository;
import com.example.codeTest.domain.repository.LoginRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private KeywordRepository keywordRepository;

	@GetMapping("/key/list")
	public Iterable<KeywordEntity> getKeyList() {
		return keywordRepository.findAll();
	}

	@Transactional
	@PostMapping("/key")
	public KeywordEntity addKey(KeywordEntity param) {
		return keywordRepository.save(param);
	}
	/*
	 * @GetMapping("/user/list") public Iterable<LoginEntity> getList() { return
	 * loginRepository.findAll(); }
	 * 
	 * @GetMapping("/user/{id}") public LoginEntity getDetail(@PathVariable Long id)
	 * { return loginRepository.getOne(id); }
	 * 
	 * @GetMapping("/key/list") public Iterable<KeywordEntity> getKeyList() { return
	 * keywordRepository.findAll(); }
	 * 
	 * @Transactional
	 * 
	 * @PostMapping("/key") public KeywordEntity addKey(KeywordEntity param) {
	 * return keywordRepository.save(param); }
	 */

}
