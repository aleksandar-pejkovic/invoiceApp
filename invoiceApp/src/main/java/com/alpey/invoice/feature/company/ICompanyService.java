package com.alpey.invoice.feature.company;

import java.util.List;

import com.alpey.invoice.feature.user.User;

public interface ICompanyService {

	CompanyDto create(CompanyDto dto);

	CompanyDto update(CompanyDto dto);

	String delete(User user);

	List<CompanyDto> findAll();

	CompanyDto findByUser(User user);

	CompanyDto findByName(String name);

}
