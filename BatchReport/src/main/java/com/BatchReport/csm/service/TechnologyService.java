package com.BatchReport.csm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BatchReport.csm.entity.TechnologyMaster;


@Service
public interface TechnologyService {
	List<TechnologyMaster> getAllTechnology(Integer libraryId);
}
