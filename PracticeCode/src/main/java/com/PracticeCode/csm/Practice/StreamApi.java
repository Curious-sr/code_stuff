package com.PracticeCode.csm.Practice;

import java.util.stream.Stream;

public class StreamApi {

	public static void testingStream() {
		
	Stream.of(10,12,3,45,56,67)
    .sorted()
    .forEach(num -> System.out.println(num));
	
	
	Stream.of("suman","kamal","zia","rajiv","bunu").sorted().forEach(num->System.out.println(num));
	
	
	
	}
	

	
}
