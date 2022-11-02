package com.alpey.invoice.feature.user;

import java.util.List;

public interface IUserService {

	UserDto create(UserDto dto);

	UserDto update(UserDto dto);

	String delete(String email);

	UserDto findByEmail(String email);

	List<UserDto> findAll();

}
