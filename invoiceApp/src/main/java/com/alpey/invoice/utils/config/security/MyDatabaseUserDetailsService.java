package com.alpey.invoice.utils.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.alpey.invoice.feature.user.UserRepository;

public class MyDatabaseUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = (UserDetails) repo.findByUsername(username);
		if (userDetails == null)
			throw new UsernameNotFoundException(username);
		return userDetails;
	}

}
