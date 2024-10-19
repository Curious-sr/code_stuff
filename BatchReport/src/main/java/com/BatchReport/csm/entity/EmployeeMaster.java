package com.BatchReport.csm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@ToString
@EqualsAndHashCode(of = {"Employee_id", "Employee_Phone"})


@Table(name = "Employee_Master")
public class EmployeeMaster {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_id")
	private Integer Employee_id;
	
	@Column(name = "Employee_Name")
	private String Employee_Name;
	
	@Column(name = "Employee_Phone")
	private String Employee_Phone;
	
	@Column(name = "Employee_Email")
	private String Employee_Email;

}
