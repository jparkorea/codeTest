package com.example.codeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.codeTest.domain.entity.LoginEntity;
import com.example.codeTest.domain.repository.LoginRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LoginRepositoryTests {

	@Autowired
	private LoginRepository loginRepository;
	
	private LoginEntity entity() {
		return new LoginEntity("hi", "something");
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
