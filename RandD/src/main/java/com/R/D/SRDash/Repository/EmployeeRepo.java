package com.R.D.SRDash.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.R.D.SRDash.Entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	
	
	
}
