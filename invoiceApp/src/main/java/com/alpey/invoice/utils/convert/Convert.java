package com.alpey.invoice.utils.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alpey.invoice.feature.company.Company;
import com.alpey.invoice.feature.company.CompanyDto;
import com.alpey.invoice.feature.company.CompanyRequest;
import com.alpey.invoice.feature.company.CompanyResponse;
import com.alpey.invoice.feature.user.User;
import com.alpey.invoice.feature.user.UserDto;
import com.alpey.invoice.feature.user.UserRequest;
import com.alpey.invoice.feature.user.UserResponse;

@Component
public class Convert implements Convertable {

	@Autowired
	ModelMapper mapper;

	/*
	 * 
	 * User features convert section
	 * 
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
	public UserDto toDto(UserRequest request) {
		UserDto dto = new UserDto();
		mapper.map(request, dto);
		return dto;
	}

	@Override
	public UserResponse toResponse(UserDto dto) {
		UserResponse response = new UserResponse();
		mapper.map(dto, response);
		return response;
	}

	/*
	 * 
	 * Company features convert section
	 * 
	 */

	@Override
	public Company toEntity(CompanyDto dto) {
		Company company = new Company();
		mapper.map(dto, company);
		return company;
	}

	@Override
	public CompanyDto toDto(Company company) {
		CompanyDto dto = new CompanyDto();
		mapper.map(company, dto);
		return dto;
	}

	@Override
	public CompanyDto toDto(CompanyRequest request) {
		CompanyDto dto = new CompanyDto();
		mapper.map(request, dto);
		return dto;
	}

	@Override
	public CompanyResponse toResponse(CompanyDto dto) {
		CompanyResponse response = new CompanyResponse();
		mapper.map(dto, response);
		return response;
	}

	/*
	 * Invoice features convert section
	 */

}
