package com.ReactiveMongoDB.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Product")
public class Product {

	
	@Id
	private String id;
	
	private String name;
	
	private int quantity;
	
	private Double price;
}
