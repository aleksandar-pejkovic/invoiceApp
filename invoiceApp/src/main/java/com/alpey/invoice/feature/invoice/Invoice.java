package com.alpey.invoice.feature.invoice;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.alpey.invoice.feature.company.Company;
import com.alpey.invoice.feature.customer.Customer;
import com.alpey.invoice.feature.item.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Company company;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToMany(mappedBy = "invoice")
//	@JsonIgnore
	private List<Item> items;
	private double tax;
	private double total;

	public void calculateTotalAndTax() {
		recalculateTotalAndTax();
	}

	private void recalculateTotalAndTax() {
		this.total = 0;
		this.tax = 0;

		for (Item item : items) {
			this.total += item.getTotal();
			this.tax += item.getTax();
		}
	}
}
