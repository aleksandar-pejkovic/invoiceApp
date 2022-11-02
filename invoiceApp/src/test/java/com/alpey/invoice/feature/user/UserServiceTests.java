package com.alpey.invoice.feature.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTests {

	@Autowired
	UserService service;

	@Test
	public void testCreate() {
		UserDto dto = new UserDto();
		dto.setEmail("aca@gmail.com");
		dto.setPassword("pejko123");
		assertEquals("aca@gmail.com", service.create(dto).getEmail());
		assertEquals("pejko123", service.create(dto).getPassword());
	}

}
