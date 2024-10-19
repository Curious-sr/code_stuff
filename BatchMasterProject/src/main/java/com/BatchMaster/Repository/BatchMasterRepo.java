package com.BatchMaster.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BatchMaster.Entity.BatchMaster;
@Repository
public interface BatchMasterRepo extends JpaRepository<BatchMaster, Integer> {

}
