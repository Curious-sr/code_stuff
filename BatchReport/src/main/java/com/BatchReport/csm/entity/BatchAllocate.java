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
@EqualsAndHashCode(of = {"Batch_Allocate_id"})


@Table(name = "Batch_Allocate")
public class BatchAllocate {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Batch_Allocate_id")
	private Integer Batch_Allocate_id;
	
	@Column(name = "Batch_id")
	private Integer Batch_id;
	
	@Column(name = "Technology_id")
	private Integer Technology_id;
	
	@Column(name = "Employee_id")
	private Integer Employee_id;
}
