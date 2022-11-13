package com.alpey.invoice.feature.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alpey.invoice.feature.company.Company;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

	User findByEmail(String email);

	User findByCompany(Company company);

	boolean existsUserByUsername(String username);

	boolean existsUserByEmail(String email);

}
