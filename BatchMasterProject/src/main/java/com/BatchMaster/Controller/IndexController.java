package com.BatchMaster.Controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.BatchMaster.Entity.AssessmentMark;
import com.BatchMaster.Service.BatchMasterService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin(origins = "*")
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private BatchMasterService batchService;
	
	
	@GetMapping("/")
	public String Index() {
		 logger.info("Inside Index Method of IndexController.......");
		return "index";
	}
	
	
	@PostMapping("/viewData")
	public ResponseEntity<?> viewData(@RequestBody String request) {
			JSONObject jsonObject = new JSONObject(request);
			int batchId = jsonObject.getInt("batchId");
			System.out.println(batchId);
		 logger.info("Inside viewData Method of IndexController.......");
		 JSONObject jsonData = new JSONObject();
		 jsonData.put("result", batchService.viewData(batchId).get("result"));
		 jsonData.put("status", "200");
		 return ResponseEntity.ok(jsonData.toString());
	}
	


	
	 @GetMapping("/pdfReport")
	    public ResponseEntity<byte[]> generatePdf(HttpServletResponse response) {
	    	logger.info("Inside generatePdf Method of IndexController.......");
	    	
	    	JSONObject jsonData = new JSONObject();
			jsonData.put("result", batchService.viewData(0).get("result"));
	    	
	    	
	        Document document = new Document();
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();

	        try {
	            // Create PDF document
	            PdfWriter.getInstance(document, baos);
	            document.open();

	            // Create a title
	            document.add(new Paragraph("Batch Data Report"));

	            // Create a table with the number of columns
	            PdfPTable table = new PdfPTable(7); // 7 columns for your data

	            // Add table headers
	            table.addCell("Batch Name");
	            table.addCell("Employee Name");
	            table.addCell("Employee Phone");
	            table.addCell("Batch Start Date");
	            table.addCell("Grade");
	            table.addCell("Mark");
	            table.addCell("Status");

	            // Fetch data from the service
	            JSONArray results = (JSONArray) batchService.viewData(0).get("result");

	            // Convert JSONArray to List
	            List<JSONObject> dataList = new ArrayList<>();
	            for (int i = 0; i < results.length(); i++) {
	                dataList.add(results.getJSONObject(i));
	            }

	            // Populate the table with data
	            for (JSONObject data : dataList) {
	                table.addCell(data.optString("batchName", "N/A")); // Default to "N/A" if not found
	                table.addCell(data.optString("employeeName", "N/A"));
	                table.addCell(data.optString("employeePhone", "N/A"));
	                table.addCell(data.optString("batchStartDate", "N/A"));
	                table.addCell(data.optString("grade", "N/A"));
	                table.addCell(data.optString("mark", "N/A"));
	                // Use opt() for getting "mark", providing a default value if not found
//	                String mark = data.has("mark") ? String.valueOf(data.get("mark")) : "N/A";
//	                table.addCell(mark);
	                
	                table.addCell(data.optString("status", "N/A"));
	            }

	            // Add table to the document
	            document.add(table);
	            document.close();

	            // Prepare the response
	            byte[] pdfBytes = baos.toByteArray();
	            HttpHeaders headers = new HttpHeaders();
	            headers.add("Content-Type", "application/pdf");
	            headers.add("Content-Disposition", "attachment; filename=batchReport.pdf");

	            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	        } catch (DocumentException  e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	
	@GetMapping("/batchDetails")
	public ResponseEntity<?> batchDetails() {
		 logger.info("Inside batchDetails Method of IndexController.......");
		 JSONObject jsonData = new JSONObject();
		 jsonData.put("result", batchService.getAllBatchList().get("result"));
		 jsonData.put("status", "200");
		 return ResponseEntity.ok(jsonData.toString());
	}
	
	@GetMapping("/technologyDetails")
	public  ResponseEntity<?> technologyDetails() {
		 logger.info("Inside technologyDetails Method of IndexController.......");
		 JSONObject jsonData = new JSONObject();
		 jsonData.put("result", batchService.getAllTechnologyList().get("result"));
		 jsonData.put("status", "200");
		 return ResponseEntity.ok(jsonData.toString());
	}
	
	@PostMapping("/getEmployeeList")
	public  ResponseEntity<?> getEmployeeList(@RequestBody Map<String, Object> requestdata) {
		logger.info("Inside getEmployeeList Method of IndexController.......");
		 JSONObject jsonData = new JSONObject();
		 JSONObject request = new JSONObject();
		 request.put("batch_id", requestdata.get("batch_id"));
		 request.put("technology_id", requestdata.get("technology_id"));
		 jsonData.put("result", batchService.getEmployeeList(request).get("result"));
		 jsonData.put("status", "200");
		 return ResponseEntity.ok(jsonData.toString());
	}
	
	@PostMapping("/saveAssessment")
	public  ResponseEntity<?> saveAssessment(@RequestBody Map<String, Object> requestdata) {
		logger.info("Inside saveAssessment Method of IndexController.......");
		 JSONObject jsonData = new JSONObject();
		 String empIdStr = (String) requestdata.get("empid");
         String markStr = (String) requestdata.get("mark");

         Integer empId = Integer.parseInt(empIdStr);
         Integer mark = Integer.parseInt(markStr);
		 AssessmentMark assessmentmark = new AssessmentMark();
		 assessmentmark.setEmpid( empId);
		 assessmentmark.setMark(mark);
		 AssessmentMark record = batchService.saveAssessment(assessmentmark);
		 if(record != null) {
			 jsonData.put("status", "200"); 
			 jsonData.put("message", "Record inserted successfully!");
		 }
		 else {
			 jsonData.put("status", "400");
			 jsonData.put("message", "Something went wrong!");
		 }

		 return ResponseEntity.ok(jsonData.toString());
	}
	
}
