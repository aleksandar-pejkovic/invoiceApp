package com.alpey.invoice.feature.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpey.invoice.utils.convert.Convert;

@Service
public class UserService<T, K> implements IUserService {

	@Autowired
	UserRepository repo;
	@Autowired
	ModelMapper mapper;
	@Autowired
	Convert convert;

	@Override
	public UserDto create(UserDto dto) {
		try {
			User user = convert.toEntity(dto);
			user = repo.save(user);
			System.out.println("User saved!");
			return convert.toDto(user);
		} catch (EntityExistsException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			return new UserDto();
		}
	}

	@Override
	public UserDto update(UserDto dto) {
		try {
			User user = convert.toEntity(dto);
			user = repo.save(user);
			System.out.println("User updated!");
			return convert.toDto(user);
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("");
			return new UserDto();
		}
	}

	@Override
	public String delete(String email) {
		try {
			User user = repo.findByEmail(email);
			repo.delete(user);
			System.out.println("User deleted!");
			return "User deleted!";
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Illegal input!");
			return "Illegal input!";
		}
	}

	@Override
	public UserDto findByEmail(String email) {
		try {
			User user = repo.findByEmail(email);
			return convert.toDto(user);
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			return new UserDto();
		}
	}

	@Override
	public List<UserDto> findAll() {
		List<UserDto> dtos = new ArrayList<>();
		List<User> users = (List<User>) repo.findAll();
		for (User user : users) {
			dtos.add(convert.toDto(user));
		}
		return dtos;
	}

}
