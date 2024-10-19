package com.BatchMaster.Entity;

import java.time.LocalDate;

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
public class BatchMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer batch_id;
	
	private String batch_name;
	
	private LocalDate  batch_start_date;
	
	private Integer batch_strength;
	
}
