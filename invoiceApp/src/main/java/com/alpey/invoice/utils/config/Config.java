package com.alpey.invoice.utils.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class Config {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
