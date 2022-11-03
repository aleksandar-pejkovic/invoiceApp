package com.alpey.invoice.utils.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alpey.invoice.feature.user.User;
import com.alpey.invoice.feature.user.UserDto;
import com.alpey.invoice.feature.user.UserResponse;

@Component
public class Convert implements Convertable {

	@Autowired
	ModelMapper mapper;

	/*
	 * User features convert section
	 */

	@Override
	public User toEntity(UserDto dto) {
		User user = new User();
		mapper.map(dto, user);
		return user;
	}

	@Override
	public UserDto toDto(User user) {
		UserDto dto = new UserDto();
		mapper.map(user, dto);
		return dto;
	}

	@Override
	public UserResponse toResponse(UserDto dto) {
		UserResponse response = new UserResponse();
		mapper.map(dto, response);
		return response;
	}

	/*
	 * Company features convert section
	 */

	/*
	 * Invoice features convert section
	 */

}
