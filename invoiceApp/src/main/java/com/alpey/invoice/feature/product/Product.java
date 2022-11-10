package com.alpey.invoice.feature.product;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.alpey.invoice.feature.item.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private long barcode;
	@Column(nullable = false, unique = true)
	private String name;
	private String unit;
	private double vat = 20;
	@Column(nullable = false)
	private double price;
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Item> items;

}
