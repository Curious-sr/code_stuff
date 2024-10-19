package com.BatchMaster.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BatchMaster.Entity.EmployeeMaster;
@Repository
public interface EmployeeMasterRepo extends JpaRepository<EmployeeMaster, Integer> {

	
	@Query(value = "SELECT e.Employee_id, e.Employee_Name " +
            "FROM Batch_Allocate ba " +
            "JOIN Employee_Master e ON ba.Employee_id = e.Employee_id " +
            "WHERE ba.Batch_id = :batch_id " +
            "AND ba.Technology_id = :technology_id", nativeQuery = true)
List<Object[]> getEmployeeList(@Param("batch_id") Integer batchId, @Param("technology_id") Integer technologyId);

}
