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
public class TechnologyMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer technology_id;

	private String technology_name;
	
}