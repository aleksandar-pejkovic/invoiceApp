package com.alpey.invoice.feature.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyRequest {

	private String username;
	private String name;
	private String address;
	private String city;
	private String pib;
	private String mb;
	private String phone;
	private String email;

}
