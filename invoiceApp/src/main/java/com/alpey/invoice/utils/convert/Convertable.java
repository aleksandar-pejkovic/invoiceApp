package com.alpey.invoice.utils.convert;

import com.alpey.invoice.feature.user.User;
import com.alpey.invoice.feature.user.UserDto;
import com.alpey.invoice.feature.user.UserResponse;

public interface Convertable {

	User toEntity(UserDto dto);

	UserDto toDto(User user);

	UserResponse toResponse(UserDto dto);


}
