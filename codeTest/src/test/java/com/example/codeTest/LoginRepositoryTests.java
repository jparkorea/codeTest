package com.example.codeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.codeTest.web.entity.Account;
import com.example.codeTest.web.repository.AccountRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LoginRepositoryTests {

	@Autowired
	private AccountRepository loginRepository;
	
	private Account entity() {
		return new Account();
	}
	
	@Test
	public void test_insert() {
		assertEquals(loginRepository.save(entity()), entity().getId());
	}
	
	@Test
	public void test_select() {
		assertNull(loginRepository.getOne(1L));
	}
}
