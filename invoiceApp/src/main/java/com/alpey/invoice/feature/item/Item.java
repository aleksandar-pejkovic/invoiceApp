package com.alpey.invoice.feature.item;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alpey.invoice.feature.invoice.Invoice;
import com.alpey.invoice.feature.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "item")
@NoArgsConstructor
@Getter
@Setter
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "invoice_id", nullable = false)
	@JsonIgnore
	private Invoice invoice;
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	@JsonIgnore
	private Product product;
	private double amount;
	private double tax;
	private double total;

	public Item(Long id, Invoice invoice, Product product, double amount, double tax, double total) {
		super();
		this.id = id;
		this.invoice = invoice;
		this.product = product;
		this.amount = amount;
		calculateTotalAndTax();
	}

	public void calculateTotalAndTax() {
		calcTotal();
		calcTax();
	}

	private void calcTotal() {
		this.total = this.amount * this.product.getPrice();
	}

	private void calcTax() {
		double vatPercent = this.product.getVat();
		double vatRecalculatedPercent = (100 * vatPercent) / (100 + vatPercent);
		double tax = this.total * vatRecalculatedPercent / 100;
		BigDecimal bd = BigDecimal.valueOf(tax);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		this.tax = bd.doubleValue();
	}

}
