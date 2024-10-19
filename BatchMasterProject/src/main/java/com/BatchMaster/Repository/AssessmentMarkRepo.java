package com.BatchMaster.Repository;

import java.util.List;

import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BatchMaster.Entity.AssessmentMark;
@Repository
public interface AssessmentMarkRepo extends JpaRepository<AssessmentMark, Integer> {
	
	
	@Query(value ="SELECT "
			+ " bm.batch_name,"
			+ " bm.batch_start_date,"
			+ " tm.technology_name,"
			+ " em.employee_name,"
			+ " em.employee_phone,"
			+ " am.mark"
			+ " FROM "
			+ " batch_master bm"
			+ " JOIN "
			+ " batch_allocate ba ON bm.batch_id = ba.batch_id"
			+ " JOIN "
			+ " technology_master tm ON ba.technology_id = tm.technology_id"
			+ " JOIN "
			+ " employee_master em ON ba.employee_id = em.employee_id"
			+ " LEFT JOIN "
			+ "  assessment_mark am ON em.employee_id = am.empid  WHERE (:batchId <= 0 OR bm.batch_id = :batchId)"
			, nativeQuery = true)
	List<Object[]> viewData(int batchId);
	
	

}
