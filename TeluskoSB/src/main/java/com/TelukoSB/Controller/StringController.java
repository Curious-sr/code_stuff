package com.TelukoSB.Controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TelukoSB.DTO.Student;

@RestController
public class StringController {
	
	
	
	
	@GetMapping("Test")
	public void StringData() {
		StringBuffer sb = new StringBuffer();
//		System.out.println(sb.capacity());
		System.out.println("=============================================================================================");
		
		
		List<Student> studentList=Stream.of(
				new Student(1,"Ganga","BBSR",Arrays.asList("9090909090","9878890987","8764890985"),23000.89,"CSM"),
				new Student(2,"Raghu","Baripada",Arrays.asList("9890989098","8767820985"),23600.45,"CSM1"),
				new Student(3,"ritesh","CTC",Arrays.asList("8787898778","8767890685","8767892985","8764890985"),23870.89,"CSM2"),
				new Student(4,"mita","ATHAGARH",Arrays.asList("5678908976","8727890985","8467890985","8737890985"),23430.89,"CSM3"),
				new Student(5,"nagesh","BBSR",Arrays.asList("9890987890","8768890985","8767890985","8767890985"),23230.89,"CSM4"),
				new Student(6,"rajani","BBSR",Arrays.asList("9887789878","8787890985","8767890985"),23780.89,"CSM5"),
				new Student(7,"sajani","NJP",Arrays.asList("5678908987","8767880985"),23120.89,"CSM2"),
				new Student(8,"rama","SAMBALPUR",Arrays.asList("7678987678","8787890985","8768890985"),23030.89,"CSM3"),
				new Student(9,"SAM","RAYAGADA",Arrays.asList("7898098767","8767190985","8767880985","8767898985"),23040.89,"CSM1"),
				new Student(10,"Gagan","BBSR",Arrays.asList("8789098767","8767890985","8767840985","8767897985","8767899985"),23500.89,"CSM4"),
				new Student(11,"RADHA","BBSR",Arrays.asList("9890987890","8767690985","8767290985","8767590985","8767830985"),23300.89,"CSM5")
				).collect(Collectors.toList());
				
		
//		System.out.println(studentList);
		//1.List of student whose salary between 23000 and 23200
		List<Student> salList =studentList.stream()
										.filter(student->student.getSalary()>23000 && student.getSalary()<23300)
										.collect(Collectors.toList());
//		System.out.println(salList);
		
		
		//2. find the student who live in BBSR and sort by their name
		List<Student>bbsrList = studentList.stream()
											.filter(student->student.getAddress().equals("BBSR"))
											.sorted(Comparator.comparing(Student::getName))
											.collect(Collectors.toList());
//		System.out.println(bbsrList);
		
		//3.find all address name
		List<String> addressList = studentList.stream()
 											  .map(Student::getAddress)
 											  .distinct()
											  .collect(Collectors.toList());
		Set<String> addressListSet = studentList.stream()
											  .map(Student::getAddress)
											  .collect(Collectors.toSet());
//		System.out.println(addressList);
//		System.out.println(addressListSet);
		
		//4.find all the phoneNo
		List<String> distinctPhoneNumbers = studentList.stream()
										                .flatMap(student -> student.getPhoneNo().stream())
										                .distinct()
										                .collect(Collectors.toList());

//		System.out.println(distinctPhoneNumbers);
		
		
		//5.Group the student by address
		
		Map<String, List<Student>> addressmap = studentList.stream()
										.collect(Collectors.groupingBy(Student::getAddress));
//		System.out.println(addressmap);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
