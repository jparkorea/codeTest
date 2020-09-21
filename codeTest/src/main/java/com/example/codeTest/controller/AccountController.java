package com.example.codeTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.codeTest.web.entity.Account;
import com.example.codeTest.web.service.impl.AccountServiceImpl;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl accountService;
	
	@GetMapping("/login")
	public String login() {
		return "account/login";
	}

	//Test
	@GetMapping("/register")
	public String register() {
		return "account/register";
	}
	
	//Test
	@PostMapping("/register")
	public String register(Account account) {
		accountService.save(account);
		return "redirect:index";
	}
}
