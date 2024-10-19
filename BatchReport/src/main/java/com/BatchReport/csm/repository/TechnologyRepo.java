package com.BatchReport.csm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BatchReport.csm.entity.TechnologyMaster;

@Repository
public interface TechnologyRepo extends JpaRepository<TechnologyMaster, Integer> {
		
	@Query("From technology_master where technology_id=:batch_Id")
	List<TechnologyMaster> getAllTechnology(Integer batch_Id);
}
