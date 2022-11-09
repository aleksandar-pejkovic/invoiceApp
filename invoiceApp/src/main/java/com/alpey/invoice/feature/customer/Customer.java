package com.alpey.invoice.feature.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alpey.invoice.feature.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	private String address;
	@Column(nullable = false)
	private String city;
	@Column(unique = true, nullable = false)
	private String pib;
	@Column(unique = true, nullable = false)
	private String mb;
	@Column(unique = true)
	private String phone;
	@ManyToOne
	@JoinColumn(name = "company_id")
	@JsonIgnore
	private Company company;

}
