package com.BatchReport.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BatchReport.csm.entity.BatchMaster;

@Repository
public interface BatchRepository extends JpaRepository<BatchMaster, Integer> {

}
