package com.Reactive.Router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.Reactive.Handler.CustomerHandler;
import com.Reactive.Handler.CustomerStreamHandler;

@Configuration
//@ComponentScan(basePackages = "com.Reactive")
public class RouterConfig {
	RouterConfig(){
		System.out.println("created");
	}
	
	@Autowired
	private	CustomerHandler handler;
	
	@Autowired
	private CustomerStreamHandler streamHandler;
	
	
	@Bean
	 RouterFunction<ServerResponse>routerfunction(){
		return RouterFunctions.route()
				.GET("/router/customers", handler::loadCustomers)
				.GET("/router/customers/stream", streamHandler::getCustomers)
				.GET("/router/customers/{input}", handler::findCustomer)
				.POST("/router/customers/save", handler::saveCustomer)
				.build();
	}

	
	
	
	
	
	
	
	
	
	
	
}
