package com.BatchReport.csm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BatchReport.csm.entity.BatchMaster;
import com.BatchReport.csm.repository.BatchRepository;
import com.BatchReport.csm.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchRepository BatchRepo ;
	
	@Override
	public List<BatchMaster> getAllBatch() {
		System.out.println(BatchRepo.findAll());
		return BatchRepo.findAll();
	}
	
	@Override
	public BatchMaster getById(Integer Batch_id) {
		return BatchRepo.getById(Batch_id);
	}
}
