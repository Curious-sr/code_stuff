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
@EqualsAndHashCode(of = {"slNo", "employee_Id"})


@Table(name = "Assessment_Mark")
public class AssessmentMark {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slno")
	private Integer slNo;
	
	@Column(name = "empid")
	private Integer employee_Id;
	
	@Column(name = "mark")
	private Integer mark;
	
	

}
