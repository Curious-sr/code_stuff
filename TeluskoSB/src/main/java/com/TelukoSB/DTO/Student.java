package com.TelukoSB.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private Integer Id;
	
	private String Name;
	
	private String Address;
	
	private List<String> PhoneNo;
	
	private Double Salary;
	
	private String Company;
	
}
