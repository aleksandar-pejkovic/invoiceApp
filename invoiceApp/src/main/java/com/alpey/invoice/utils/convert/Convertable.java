package com.alpey.invoice.utils.convert;

import com.alpey.invoice.feature.company.Company;
import com.alpey.invoice.feature.company.CompanyDto;
import com.alpey.invoice.feature.company.CompanyRequest;
import com.alpey.invoice.feature.company.CompanyResponse;
import com.alpey.invoice.feature.user.User;
import com.alpey.invoice.feature.user.UserDto;
import com.alpey.invoice.feature.user.UserRequest;
import com.alpey.invoice.feature.user.UserResponse;

public interface Convertable {

	// User

	User toEntity(UserDto dto);

	UserDto toDto(User user);

	UserDto toDto(UserRequest request);

	UserResponse toResponse(UserDto dto);

	// Company

	Company toEntity(CompanyDto dto);

	CompanyDto toDto(Company company);

	CompanyDto toDto(CompanyRequest companyRequest);

	CompanyResponse toResponse(CompanyDto dto);

	// Customer

}
