package com.alpey.invoice.feature.company;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.alpey.invoice.feature.invoice.Invoice;
import com.alpey.invoice.feature.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne(mappedBy = "company")
	@JsonIgnore
	private User user;
	private String address;
	@Column(nullable = false)
	private String city;
	@Column(unique = true, nullable = false)
	private String pib;
	@Column(unique = true, nullable = false)
	private String mb;
	@Column(unique = true)
	private String phone;
	@OneToMany(mappedBy = "company")
	@JsonIgnore
	private List<Invoice> invoices;
	

}
