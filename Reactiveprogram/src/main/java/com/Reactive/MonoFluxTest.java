package com.Reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
	
	
	
	public void testMono() {
		
		Mono<?> monoString  =Mono.just("javatechie")
				.then(Mono.error(new RuntimeException("Exception occured")))
				.log();
		monoString.subscribe(System.out::println);
	}
	
	public void testFlux() {
			
		Flux<?> fluxString  = Flux.just("javatechie","spring","java","mysql")
				.concatWithValues("aws").log();
					
		fluxString.subscribe(System.out::println);
		
		}
	
	
	
	
	
	
	
	
}
