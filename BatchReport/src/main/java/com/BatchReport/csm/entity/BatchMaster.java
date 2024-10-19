package com.BatchReport.csm.entity;

import java.time.LocalDate;

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
@EqualsAndHashCode(of = {"Batch_id"})


@Table(name = "Batch_Master")
public class BatchMaster {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Batch_id")
	private Integer Batch_id;
	
	@Column(name = "Batch_Name")
	private String Batch_Name;
	
	@Column(name = "Batch_Start_Date")
	private LocalDate batchStartDate;
	
	@Column(name = "Batch_strength")
	private Integer Batch_strength;
}
