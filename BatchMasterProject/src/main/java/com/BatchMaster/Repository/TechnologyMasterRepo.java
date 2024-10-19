package com.BatchMaster.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BatchMaster.Entity.TechnologyMaster;
@Repository
public interface TechnologyMasterRepo extends JpaRepository<TechnologyMaster, Integer> {

}
