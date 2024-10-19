package com.cofig.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cofig.demo.Entity.Student;
import com.cofig.demo.Repository.StudentRepo;

@RestController
public class CacheController {
	

    @Autowired
    private StudentRepo studentRepository;
	
    @Autowired
    private CacheManager cacheManager;
	
	@GetMapping("/")
	public String test() {
		return "Application Running on port .........";
	}
	
	
//	@GetMapping("/studentData")
//	@Cacheable(value = "allStudentsCache", key = "#root.methodName")
//	public List<Student> getAllStudents() {
//	    // Option 1: Retrieve all students without any sorting
//		List<Student> stuData= studentRepository.findAll();
//		
//		
//		
//	    return stuData;
//    }
	
	@GetMapping("/studentData")
	@Cacheable(value = "allStudentsCache", key = "#root.methodName")
	public List<Student> getAllStudents() {
	    List<Student> students;
	    System.out.println(cacheManager.getCache("allStudentsCache").get("getAllStudents"));
	    if (cacheManager.getCache("allStudentsCache").get("getAllStudents") != null) {
	        System.out.println("Retrieved from Cache!");
	        students = (List<Student>) cacheManager.getCache("allStudentsCache").get("getAllStudents").get();
	    } else {
	        System.out.println("Retrieved from Database!");
	        System.out.println(cacheManager.getCache("allStudentsCache").get("getAllStudents"));
	        students = studentRepository.findAll();
	    }
	    return students;
	}
	
	@GetMapping("/checkCache")
	public String justCheckCache() {
		 System.out.println(cacheManager.getCache("allStudentsCache").get("getAllStudents"));
		String cachedData = "checked successfully...."+ cacheManager.getCache("allStudentsCache").get("getAllStudents").toString();
		 
		return cachedData;
	}
	
	
	
	
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
	    Student student = studentRepository.getById(studentId);
	    return ResponseEntity.ok(student);
	}
	

}
