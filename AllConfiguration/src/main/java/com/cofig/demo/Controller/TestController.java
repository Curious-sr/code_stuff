package com.cofig.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {

	
	
	 @Autowired
	    private CacheManager cacheManager;
	 
	 @GetMapping("/checkCacheOtherController")
		public String justCheckCache() {
			 System.out.println(cacheManager.getCache("allStudentsCache").get("getAllStudents"));
			String cachedData = "checked successfully...."+ cacheManager.getCache("allStudentsCache").get("getAllStudents").toString();
			 
			return cachedData;
		}
}
