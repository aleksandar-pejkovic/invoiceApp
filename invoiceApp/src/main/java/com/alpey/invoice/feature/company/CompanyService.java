package com.alpey.invoice.feature.company;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.alpey.invoice.feature.user.User;
import com.alpey.invoice.feature.user.UserRepository;
import com.alpey.invoice.utils.convert.Convert;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private CompanyRepository repo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	@Lazy
	private Convert convert;

	@Override
	public CompanyDto create(CompanyDto dto) {
		try {
			User user = userRepo.findByUsername(dto.getUsername());
			Company company = convert.toEntity(dto);
			user.setCompany(company);
			userRepo.save(user);
			System.out.println("Company added!");
			return convert.toDto(company);
		} catch (EntityExistsException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			return new CompanyDto();
		}
	}

	@Override
	public CompanyDto update(CompanyDto dto) {
		try {
			Company company = convert.toEntity(dto);
			Company storedCompany = repo.findByPib(dto.getPib());

			BeanUtils.copyProperties(company, storedCompany);

			storedCompany = repo.save(storedCompany);
			System.out.println("Company updated!");
			return convert.toDto(storedCompany);
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			return new CompanyDto();
		}
	}

	@Override
	public String delete(String username) {
		try {
			User user = userRepo.findByUsername(username);
			Company company = user.getCompany();
			user.setCompany(null);
			userRepo.save(user);
			repo.delete(company);
			return "Company deleted!";
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Illegal input!");
			return "Illegal input!";
		}
	}

	@Override
	public List<CompanyDto> findAll() {
		List<Company> companies = (List<Company>) repo.findAll();
		List<CompanyDto> companyDtos = new ArrayList<>();
		for (Company company : companies) {
			companyDtos.add(convert.toDto(company));
		}
		return companyDtos;
	}

	@Override
	public CompanyDto findByUsername(String username) {
		try {
			User user = userRepo.findByUsername(username);
			Company company = user.getCompany();
			return convert.toDto(company);
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			return new CompanyDto();
		}
	}

	@Override
	public CompanyDto findByName(String name) {
		try {
			Company company = repo.findByName(name);
			return convert.toDto(company);
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			return new CompanyDto();
		}
	}

}
