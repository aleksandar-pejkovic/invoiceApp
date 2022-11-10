package com.alpey.invoice.feature.user;

import com.alpey.invoice.feature.company.CompanyDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

	private String username;
	private String email;
	private String password;
	private CompanyDto companyDto;

}
