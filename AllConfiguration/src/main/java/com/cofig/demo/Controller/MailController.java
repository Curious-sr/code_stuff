package com.cofig.demo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofig.demo.Services.EmailService;



@RestController
public class MailController {
	
	private EmailService mailserv;
	
    @GetMapping("/sending")
	public String SendingMail() {
    	mailserv.sendEmail("sudhansuranjandash1@gmail.com", "Greetings...", "Trial Mail");
		return "Mail sent successfully....";
	}
	
	
	
}
