package com.PracticeCode.csm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.PracticeCode.csm.Practice.StreamApi;

@SpringBootApplication
public class PracticeCodeApplication {

	public static void main(String[] args) {
//		SpringApplication.run(PracticeCodeApplication.class, args);
		StreamApi data = new StreamApi();
		data.testingStream();
		
	}

}
