package com.alpey.invoice.feature.user;

import com.alpey.invoice.feature.company.CompanyRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequest {

	private String username;
	private String email;
	private String password;
	private CompanyRequest companyRequest;

	public boolean checkUserRequestCredentials() {
		if (this.username.isBlank() || this.email.isBlank() || this.password.isBlank())
			return false;
		return true;
	}

}
