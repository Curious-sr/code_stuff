package com.ReactiveMongoDB.Util;

import org.springframework.beans.BeanUtils;

import com.ReactiveMongoDB.DTO.ProductDto;
import com.ReactiveMongoDB.Entity.Product;

public class AppUtils {

	
	/*
	public  ProductDto entityToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setQuantity(product.getQuantity());
		productDto.setPrice(product.getPrice());
		
		return productDto;
	}
	
	public Product  dtoToEntity(ProductDto productDto) {
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setQuantity(productDto.getQuantity());
		product.setPrice(productDto.getPrice());
		
		return product;
	}
	
	*/
	public static ProductDto entityToDto(Product product) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		return productDto;
	}
	
	public static Product  dtoToEntity(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		return product;
	}
	
	
}
