package com.Reactive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Reactive.dto.Customer;
import com.Reactive.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/Customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/traditional")
	public List<Customer> loadAllCustomer (){
		
		List<Customer> customers =service.loadAllCustomer();
		
		return customers;
	}
	
	@GetMapping(value="/stream",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> loadAllCustomerStream (){
		
		Flux<Customer> customers =service.loadAllCustomerStream();
		
		return customers;
	}
	
}
