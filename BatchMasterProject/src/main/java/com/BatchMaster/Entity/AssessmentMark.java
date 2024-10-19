package com.BatchMaster.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentMark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer slno;
	
	private Integer empid;
	
	private Integer mark;
	
}
