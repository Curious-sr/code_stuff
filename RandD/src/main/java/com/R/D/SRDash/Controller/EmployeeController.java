package com.R.D.SRDash.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.R.D.SRDash.Entity.Employee;
import com.R.D.SRDash.Service.EmployeeService;



@RestController
@CrossOrigin(origins = "*")

@RequestMapping("RandD/")


public class EmployeeController {
	
	@Autowired
	 EmployeeService empService;
	
	@PostMapping("employee")
	public ResponseEntity<Map<String, Object>> getEmployee() {
	    Map<String, Object> response = new HashMap<>();
	    Long id = 1L;
	    List<Employee> data = empService.getEmployeeData(id);
	    response.put("result", data);
	    return ResponseEntity.ok(response);
	}
	
	@GetMapping("employee")
	public ResponseEntity<Map<String, Object>> addEmployee() {
	    Map<String, Object> response = new HashMap<>();
	    Long id = 1L;
	    List<Employee> data = empService.getEmployeeData(id);
	    response.put("result", data);
	    return ResponseEntity.ok(response);
	}
	

}
