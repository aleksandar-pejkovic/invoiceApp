package com.alpey.invoice.feature.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alpey.invoice.utils.convert.Convert;

@Service
public class UserService implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	@Lazy
	private Convert convert;
	@Autowired
	@Lazy
	private BCryptPasswordEncoder bCrypt;

	@Override
	public UserDto createUser(UserDto dto) {
		if (doesUserWithSameDataExist(dto)) {
			throw new RuntimeException("User with entered data exist");
		}
		User user = convert.toEntity(dto);
		user.setPassword(bCrypt.encode(user.getPassword()));
		user = userRepository.save(user);
		System.out.println("User saved!");
		return convert.toDto(user);
	}

	@Override
	public UserDto update(UserDto dto, String username) {
		try {
			User storedUser = userRepository.findByUsername(username);
			User user = convert.toEntity(dto);

			BeanUtils.copyProperties(user, storedUser);

			if (dto.getPassword() != null) {
				storedUser.setPassword(bCrypt.encode(dto.getPassword()));
			}

			user = userRepository.save(storedUser);
			System.out.println("User updated!");
			return convert.toDto(user);
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("");
			return new UserDto();
		}
	}

	@Override
	public String delete(String username) {
		try {
			User user = userRepository.findByUsername(username);
			userRepository.delete(user);
			System.out.println("User deleted!");
			return "User deleted!";
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Illegal input!");
			return "Illegal input!";
		}
	}

	@Override
	public UserDto findByUsername(String username) {
		try {
			User user = userRepository.findByUsername(username);
			return convert.toDto(user);
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			return new UserDto();
		}
	}

	@Override
	public UserDto findByEmail(String email) {
		try {
			User user = userRepository.findByEmail(email);
			return convert.toDto(user);
		} catch (EntityNotFoundException | NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			return new UserDto();
		}
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<UserDto> dtos = new ArrayList<>();
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users) {
			dtos.add(convert.toDto(user));
		}
		return dtos;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email);
	}

	private boolean doesUserWithSameDataExist(UserDto dto) {
		boolean result = false;
		result = userRepository.existsUserByUsername(dto.getUsername());
		result = userRepository.existsUserByEmail(dto.getEmail());
		return result;
	}
}
