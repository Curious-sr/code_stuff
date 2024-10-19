package com.BatchReport.csm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BatchReport.csm.entity.BatchMaster;


@Service
public interface BatchService {
	List<BatchMaster> getAllBatch();

	BatchMaster getById(Integer Batch_id);
}
