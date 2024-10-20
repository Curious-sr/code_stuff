package com.ReactiveMongoDB.Repository;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ReactiveMongoDB.DTO.ProductDto;
import com.ReactiveMongoDB.Entity.Product;

import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

	Flux<ProductDto> findByPriceBetween(Range<Double> priceRange);
	
	

}
