package com.Reactive.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.Reactive.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {

	private static void sleepExecution(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	public List<Customer>loadAllCustomer(){
		
		return IntStream.rangeClosed(1, 50)
		.peek(CustomerDao::sleepExecution)
		.peek(i->System.out.println("Processing Count :"+i))
		.mapToObj(i->new Customer(i,"customer"+i))
		.collect(Collectors.toList());
	}
	
	public Flux<Customer>loadAllCustomerStream(){
			
			return Flux.range(1, 50)
			.delayElements(Duration.ofSeconds(1))
			.doOnNext(i->System.out.println("Processing Count :"+i))
			.map(i->new Customer(i,"customer"+i));
		}
	
	
	public Flux<Customer>getCustomersList(){
		
		return Flux.range(1, 50)
		.doOnNext(i->System.out.println("Processing Count :"+i))
		.map(i->new Customer(i,"customer"+i));
	}
	
	
public Flux<Customer>getCustomersStream(){
		
		return Flux.range(1, 50)
		.delayElements(Duration.ofSeconds(1))
		.doOnNext(i->System.out.println("Processing Count :"+i))
		.map(i->new Customer(i,"customer"+i));
	}
	
	
	
}
