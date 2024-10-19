package com.BatchMaster.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BatchMaster.Entity.AssessmentMark;
import com.BatchMaster.Repository.AssessmentMarkRepo;
import com.BatchMaster.Repository.BatchMasterRepo;
import com.BatchMaster.Repository.EmployeeMasterRepo;
import com.BatchMaster.Repository.TechnologyMasterRepo;
import com.BatchMaster.Service.BatchMasterService;
@Service
public class BatchMasterServiceImpl implements BatchMasterService {

	@Autowired
	private BatchMasterRepo batchRepo;
	
	@Autowired
	private TechnologyMasterRepo technologyRepo;
	
	@Autowired
	private EmployeeMasterRepo employeeRepo;
	
	@Autowired
	private AssessmentMarkRepo assessmentRepo;
	
	
	private static final Logger logger = LoggerFactory.getLogger(BatchMasterServiceImpl.class);
	
	@Override
	public JSONObject getAllBatchList() {
		logger.info("Inside getAllBatchList method of BatchMasterServiceImpl");


		JSONObject json = new JSONObject();

		json.put("result", batchRepo.findAll());

		return json;

	}

	@Override
	public JSONObject getAllTechnologyList() {
		logger.info("Inside getAllTechnologyList method of BatchMasterServiceImpl");
		JSONObject json = new JSONObject();
		json.put("result", technologyRepo.findAll());
		return json;
	}

	@Override
	public JSONObject getEmployeeList(JSONObject requestData) {
		logger.info("Inside getAllTechnologyList method of BatchMasterServiceImpl");
		JSONObject json = new JSONObject();
		JSONArray employeesArray = new JSONArray();
		List<Object[]> employees=employeeRepo.getEmployeeList(requestData.getInt("batch_id"),requestData.getInt("technology_id"));
		 for (Object[] employee : employees) {
			    Integer employeeId = (Integer) employee[0];
	            String employeeName = (String) employee[1];
	            JSONObject employeeJson = new JSONObject();
	            employeeJson.put("employee_id", employeeId);
	            employeeJson.put("employee_name", employeeName);
	            employeesArray.put(employeeJson);
	        }
		 
		json.put("result", employeesArray);
		return json;
	}

	@Override
	public AssessmentMark saveAssessment(AssessmentMark assessmentmark) {
		AssessmentMark assessment = assessmentRepo.save(assessmentmark);
		return assessment;
	}

	@Override
	public JSONObject viewData(int batchId) {
		JSONObject viewData= new JSONObject();
		List<Object[]> viewDataList =  assessmentRepo.viewData(batchId);
		List<JSONObject> viewList = new ArrayList<>();

	    for (Object[] obj : viewDataList) {
	    	//System.out.println(obj[0]);
	        JSONObject dataObject = new JSONObject();
	        dataObject.put("batchName", obj[0]);
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	        dataObject.put("batchStartDate", dateFormat.format((Date) obj[1]));
	        dataObject.put("technologyName", obj[2]);
	        dataObject.put("employeeName", obj[3]);
	        dataObject.put("employeePhone", obj[4]);
	        dataObject.put("mark", obj[5]);
	        dataObject.put("grade",obj[5] != null? (gradeCalculator(Double.parseDouble(obj[5].toString()))):"N/A");
	        dataObject.put("status",obj[5] != null ? (Double.parseDouble(obj[5].toString()) >= 70 ? "Eligible" :"Not Eligible"):"N/A");
	        viewList.add(dataObject);
	    }

	    viewData.put("result", viewList);

		return viewData;
	}

	public static String gradeCalculator(Double mark) {
		if (mark < 60) {
	        return "F";
	    } else if (mark >= 60 && mark < 80) {
	        return "A";
	    } else if (mark >= 80 && mark < 90) {
	        return "E";
	    } else if (mark >= 90 && mark <= 100) {
	        return "O";
	    }
	    return "";
	}
	

	
	
}
