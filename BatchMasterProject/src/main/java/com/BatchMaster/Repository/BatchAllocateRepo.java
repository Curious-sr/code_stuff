package com.BatchMaster.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BatchMaster.Entity.BatchAllocate;

@Repository
public interface BatchAllocateRepo extends JpaRepository<BatchAllocate, Integer> {

}
