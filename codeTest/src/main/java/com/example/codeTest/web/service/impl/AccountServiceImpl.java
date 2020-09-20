package com.example.codeTest.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.codeTest.web.entity.Account;
import com.example.codeTest.web.entity.Role;
import com.example.codeTest.web.repository.AccountRepository;
import com.example.codeTest.web.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * 계정 저장 메소드
	 */
	public Account save(Account account) {
		String encodedPassword = passwordEncoder.encode(account.getPassword());
		account.setPassword(encodedPassword);
		account.setEnabled(true);
		
		Role role = new Role();
		role.setId(1L);
		account.getRoles().add(role);
		return accountRepository.save(account);
		
	}
}
