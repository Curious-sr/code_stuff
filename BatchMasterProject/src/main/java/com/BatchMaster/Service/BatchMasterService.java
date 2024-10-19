package com.BatchMaster.Service;

import org.json.JSONObject;

import com.BatchMaster.Entity.AssessmentMark;

public interface BatchMasterService {

	
	JSONObject getAllBatchList();
	
	JSONObject getAllTechnologyList();

	JSONObject getEmployeeList(JSONObject requestData);
	
	AssessmentMark saveAssessment(AssessmentMark assessmentmark);

	JSONObject viewData(int batchId);
	
}
