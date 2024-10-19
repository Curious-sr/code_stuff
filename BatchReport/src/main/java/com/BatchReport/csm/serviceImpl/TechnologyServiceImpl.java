package com.BatchReport.csm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BatchReport.csm.entity.TechnologyMaster;
import com.BatchReport.csm.repository.TechnologyRepo;
import com.BatchReport.csm.service.TechnologyService;


@Service
public class TechnologyServiceImpl implements TechnologyService {
	
	@Autowired
	private TechnologyRepo technologyRepository;
	
	
	@Override
	public List<TechnologyMaster> getAllTechnology(Integer batch_Id){
		
		
		return technologyRepository.getAllTechnology( batch_Id);
	}
}
