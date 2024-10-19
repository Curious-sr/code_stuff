package com.cofig.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaprojectoneApplication {

	public static void main(String[] args) {
		
//		SpringApplication.run(JavaprojectoneApplication.class, args);
		
		
//		System.out.println("ok");
		Scanner obj= new Scanner(System.in);
		System.out.println("Enter Your Name");
	
		String name=obj.nextLine();
		
//		System.out.println( ((Object)name).getClass().getSimpleName() );
//		System.out.println(name.charAt(0));
		
		String welcomeName="";
		for(int i=0;i<name.length();i++) {
			welcomeName +=  name.charAt(i) +"\t" ;
		}
		
		System.out.println("Hi "+welcomeName +"Welcome to java world...");
	}

}
