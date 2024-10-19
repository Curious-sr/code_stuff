package com.R.D.SRDash.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.R.D.SRDash.Entity.Employee;
import com.R.D.SRDash.Repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo emprepo;
	
	
	
	@Override
	public List<Employee> getEmployeeData(Long Id) {
		Employee emp = emprepo.getById(Id);
		List<Employee> employeeList = new ArrayList<>();
	    employeeList.add(emp);
	    System.out.println(employeeList);
	    return employeeList;
	}

	
	
	
}
