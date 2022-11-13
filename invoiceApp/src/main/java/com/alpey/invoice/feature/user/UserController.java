package com.alpey.invoice.feature.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpey.invoice.utils.convert.Convert;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	Convert convert;

	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest request) {
		if (!request.checkUserRequestCredentials())
			throw new RuntimeException("Insert valid data!");
		UserDto dto = convert.toDto(request);
		dto = userService.createUser(dto);
		return convert.toResponse(dto);
	}

}
