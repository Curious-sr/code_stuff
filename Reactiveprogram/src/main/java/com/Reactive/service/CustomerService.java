package com.Reactive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Reactive.dao.CustomerDao;
import com.Reactive.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao Dao;
	
	public List<Customer> loadAllCustomer(){
		Long start = System.currentTimeMillis();
		List<Customer> customers = Dao.loadAllCustomer();
		Long end = System.currentTimeMillis();
		System.out.println("Total Execution Time :"+(end-start));
		return customers;
	}
	
	public Flux<Customer> loadAllCustomerStream(){
		Long start = System.currentTimeMillis();
		Flux<Customer> customers = Dao.loadAllCustomerStream();
		Long end = System.currentTimeMillis();
		System.out.println("Total Execution Time :"+(end-start));
		return customers;
	}
	
}
