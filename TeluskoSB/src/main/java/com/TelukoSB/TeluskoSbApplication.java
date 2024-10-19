package com.TelukoSB;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.TelukoSB.Controller.StringController;

@SpringBootApplication
public class TeluskoSbApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TeluskoSbApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(StringController.class);
        StringController controller = context.getBean(StringController.class);
        
        controller.StringData();
	}

}
