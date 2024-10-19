package com.ReactiveMongoDB.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private String id;
	
	private String name;
	
	private int quantity;
	
	private Double price;
	
	
}
