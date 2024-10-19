package com.BatchReport.csm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BatchReport.csm.entity.TechnologyMaster;
import com.BatchReport.csm.service.BatchService;
import com.BatchReport.csm.service.TechnologyService;




@Controller
public class BatchContrller {

	@Autowired
	private BatchService batchService;
	
	@Autowired
	private TechnologyService techService;
	
	@GetMapping("")
	public String getForm(Model model) {
		
		model.addAttribute("AllBatch", batchService.getAllBatch());
		System.out.println("ok.....");
		return "batch";
	}
	
	
	@GetMapping("/getSubscriptionBybatch_id")
	public void getSubscriptionByLibraryId(@RequestParam("batchId")Integer batchId,HttpServletResponse resp) {
		PrintWriter pw=null;
		try {
			pw = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<TechnologyMaster> getAllTechnologyList=techService.getAllTechnology(batchId);
		String subscription="";
		for(TechnologyMaster submaster:getAllTechnologyList) {
			subscription+="<option value='"+submaster.getTechnology_id()+"'>"+submaster.getTeeechnology_Name()+"</option>";
		}
		pw.println(subscription);
	}
}
