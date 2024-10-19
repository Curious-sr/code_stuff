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
@EqualsAndHashCode(of = {"Technology_id"})


@Table(name = "Technology_Master")
public class TechnologyMaster {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Technology_id")
	private Integer Technology_id;
	
	@Column(name = "Teeechnology_Name")
	private String Teeechnology_Name;
	

}
