package com.cofig.demo.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer intStudentId;
	private String vchfullName;
	private Integer tinGender;
	private String vchImage;
	private String vchMobileNo;
	
	public Student() {
		super();
		
	}
	
	
	public Student(Integer intStudentId, String vchfullName, Integer tinGender, String vchImage, String vchMobileNo) {
		super();
		this.intStudentId = intStudentId;
		this.vchfullName = vchfullName;
		this.tinGender = tinGender;
		this.vchImage = vchImage;
		this.vchMobileNo = vchMobileNo;
	}
	
	
	
}
