package com.ReactiveMongoDB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ReactiveMongoDB.DTO.ProductDto;
import com.ReactiveMongoDB.Service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/Products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public Flux<ProductDto> getProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/{id}")
	public Mono<ProductDto> getProduct(@PathVariable String id){
		return service.getProduct(id);
	}
	
	@GetMapping("product-range")
	public Flux<ProductDto> getProductBetweenRange(@RequestParam("min") double min,@RequestParam("max") double max){
		return service.getProductInRange(min,max);
	}
	
	@PostMapping("/save")
	public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDtoMono){
		return service.saveProduct(productDtoMono);
	}
	
	@PostMapping("/update/{id}")
	public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDtoMono,@PathVariable String id){
		return service.updateProduct(productDtoMono,id);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> deleteProduct(@PathVariable String id){
		return service.deleteProduct(id);
	}
	
	
	
	
	
	
	
	
	
	
}
