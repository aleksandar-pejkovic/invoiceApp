package com.alpey.invoice.feature.company;

import java.util.List;

public interface ICompanyService {

	CompanyDto create(CompanyDto dto);

	CompanyDto update(CompanyDto dto);

	String delete(String username);

	List<CompanyDto> findAll();

	CompanyDto findByUsername(String username);

	CompanyDto findByName(String name);

}
