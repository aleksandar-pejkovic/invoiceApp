package com.alpey.invoice.feature.company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alpey.invoice.feature.user.User;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

	Company findByUser(User user);

	Company findByName(String name);

}
