package com.R.D.SRDash.Controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

@RequestMapping("RandD/")
public class TestController {

	TestController(){
		System.out.println("Object Created......................");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
		
	@GetMapping("/hello")
	String Hello() {
		return "Hello EveryOne";
	}
	
	@GetMapping("/testJson")
	public ResponseEntity<?> testJson() {
		logger.info("Inside testJson method of TestController");
		JSONObject studentJson= new JSONObject();
		studentJson.put("Name", "Sudhansu Ranjan Dash");
		
				JSONObject stuJson= new JSONObject();
				stuJson.put("Id", 12);
				stuJson.put("Batch", "batch@");
				studentJson.put("Stu", stuJson);
		
		
				JSONObject courseJson= new JSONObject();
				courseJson.put("Information", "test");
				courseJson.put("Id", "3");
				courseJson.put("Name", "course1");
		
				List<JSONObject> courseList = new ArrayList<>();
				courseList.add(courseJson);
		
		
		studentJson.put("Course", courseList);
		
		
						JSONObject addressJson =new JSONObject();
						addressJson.put("H.No", "1234");
						addressJson.put("Name", "Anand Bhaban");
						addressJson.put("Locality", "BBSR");
						addressJson.put("Id", "12000");
						
						JSONObject addressJson2 =new JSONObject();
						addressJson2.put("H.No", "1235");
						addressJson2.put("Name", "Bishal Bhaban");
						addressJson2.put("Locality", "CTC");
						addressJson2.put("Id", "33300");
		
			List<JSONObject> addressList = new ArrayList<>();
			addressList.add(addressJson);
			addressList.add(addressJson2);
		
			JSONObject studentAddress = new JSONObject();
			studentAddress.put("AdditionalInfo", "test Info");
			studentAddress.put("Verified",true);
			studentAddress.put("Address",addressList);
		
		
			List<JSONObject> studentAddressList = new ArrayList<>();
			studentAddressList.add(studentAddress);
		
		studentJson.put("StudentAddress", studentAddressList);
		
		return ResponseEntity.ok(studentJson.toString());
	}
	
	
	
	
	
	@GetMapping("/progessIndicator")
	public ResponseEntity<?> progessIndicator() throws InterruptedException {
		 int maxProgress = 100;
	        int minIncrement = 1;
	        int maxIncrement = 10;
	        int i = 0;
	        while (i <= maxProgress) {
	            int increment = minIncrement + (int) (Math.random() * (maxIncrement - minIncrement + 1));
	            i += increment;
	            if (i > maxProgress) i = maxProgress; 
	            
	            Thread.sleep(500); 
	            System.out.print("\rProgress: " + i + "%");
	            if(i == 100) {
	            	break;
	            }
	        }
	JSONObject jsonObj =new JSONObject();
	return ResponseEntity.ok(jsonObj.toString());
	}
	
	
	
	
	
	
}
