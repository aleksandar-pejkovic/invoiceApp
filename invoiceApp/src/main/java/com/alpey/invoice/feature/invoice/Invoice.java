package com.alpey.invoice.feature.invoice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alpey.invoice.feature.company.Company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "invoice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String invoiceNo;
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

}
