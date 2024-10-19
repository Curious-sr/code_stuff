package com.ReactiveMongoDB.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.ReactiveMongoDB.DTO.ProductDto;
import com.ReactiveMongoDB.Entity.Product;
import com.ReactiveMongoDB.Repository.ProductRepository;
import com.ReactiveMongoDB.Util.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepo;
	
	
	public Flux<ProductDto> getProducts(){
		return productRepo.findAll().map(AppUtils::entityToDto);
	}
	
	public Mono<ProductDto> getProduct(String Id){
		return productRepo.findById(Id).map(AppUtils::entityToDto);
	}
	
	public Flux<ProductDto> getProductInRange(double min ,double max){
		return productRepo.findByPriceBetween(Range.closed(min,max));
	}
	
	public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono){
		return	productDtoMono.map(AppUtils::dtoToEntity)
								.flatMap(productRepo::insert)
								.map(AppUtils::entityToDto);
	}
	
	
	
	public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono,String Id){
		return productRepo.findById(Id)
					.flatMap(p->productDtoMono.map(AppUtils::dtoToEntity)
					.doOnNext(e->e.setId(Id)))
					.flatMap(productRepo::save)
					.map(AppUtils::entityToDto);
		
	}
	
	public Mono<Void> deleteProduct(String Id){
		
		return productRepo.deleteById(Id);	
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
