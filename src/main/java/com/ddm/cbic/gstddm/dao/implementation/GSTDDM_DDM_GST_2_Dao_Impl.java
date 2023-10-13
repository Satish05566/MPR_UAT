package com.ddm.cbic.gstddm.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstddm.dao.GSTDDM_DDM_GST_2_Dao;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_ALL_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_OTHERS_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_REGION_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_ZONE_Result;

@Repository
public class GSTDDM_DDM_GST_2_Dao_Impl implements GSTDDM_DDM_GST_2_Dao {
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	

	@Override
	public Object generateResult_SP_DDM_GST_2_MAX_DATE(String code) {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_2_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);			
		query.execute();				
		return query.getResultList().get(0);
	}

	@Override
	public SP_DDM_GST_2_COMM_TEMP_Result generateResult_SP_DDM_GST_2_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_2_COMM_TEMP");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != crr) query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);			
		query.execute();
		
		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_DDM_GST_2_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
		
	}

	@Override
	public String generateResult_SP_DDM_GST_2_UPDATE(String code, String mm_yyyy, String audit_RECOVERY,
			String anti_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS, String recovery_OF_CONFIRMED_DEMANDS,
			String pre_DEPOSITS, String scrutiny_OF_GST_RETURNS, String recovery_FROM_DEFAULTERS,
			String finalisation_OF_PROVISIONAL_ASSESSMENTS, String others_NAME, String others_VALUE,
              Object crr) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_2_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, audit_RECOVERY);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, anti_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, recovery_OF_CONFIRMED_DEMANDS);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, pre_DEPOSITS);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, scrutiny_OF_GST_RETURNS);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, recovery_FROM_DEFAULTERS);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, finalisation_OF_PROVISIONAL_ASSESSMENTS);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, others_NAME);	
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, others_VALUE);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(12, crr); 
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(13).toString();
	}

	@Override
	public String generateResult_SP_DDM_GST_2_INSERT(String code, String mm_yyyy, String audit_RECOVERY,
			String anti_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS, String recovery_OF_CONFIRMED_DEMANDS,
			String pre_DEPOSITS, String scrutiny_OF_GST_RETURNS, String recovery_FROM_DEFAULTERS,
			String finalisation_OF_PROVISIONAL_ASSESSMENTS, String others_NAME, String others_VALUE) {

		
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_2_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, audit_RECOVERY);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, anti_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, recovery_OF_CONFIRMED_DEMANDS);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, pre_DEPOSITS);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, scrutiny_OF_GST_RETURNS);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, recovery_FROM_DEFAULTERS);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, finalisation_OF_PROVISIONAL_ASSESSMENTS);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, others_NAME);		
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, others_VALUE);	
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(12).toString();
	}

	@Override
	public SP_DDM_GST_2_ALL_Result generateResult_SP_DDM_GST_2_ALL(String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_2_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);							
		query.execute();				
		return new SP_DDM_GST_2_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_DDM_GST_2_REGION_Result generateResult_SP_DDM_GST_2_REGION(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_2_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);						
		query.execute();				
		// return new SP_DDM_GST_2_REGION_Result().generateRegionResult(query.getResultList());
		return null;
	}

	@Override
	public SP_DDM_GST_2_ZONE_Result generateResult_SP_DDM_GST_2_ZONE(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_2_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_DDM_GST_2_ZONE_Result().generateZoneResult(query.getResultList());		
	}

	@Override
	public SP_DDM_GST_2_COMM_Result generateResult_SP_DDM_GST_2_COMM(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_2_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);		
		query.execute();				
		return new SP_DDM_GST_2_COMM_Result().generateCommResult(query.getResultList());

	}

	@Override
	public SP_DDM_GST_2_COMM_TEMP_REPORT_Result generateResult_SP_DDM_GST_2_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object crr, Object bak, Object submission_Date) {
		if(crr == null || crr == "")crr=null;
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_2_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(3, crr);	
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		if(bak != null)query.setParameter(4, bak);	
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		if(submission_Date != null)query.setParameter(5, submission_Date);	
		query.execute();				
		return new SP_DDM_GST_2_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
		
	}

	@Override
	public List<SP_DDM_GST_2_OTHERS_Result> generateResult_SP_DDM_GST_2_OTHERS() {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_2_OTHERS");								
		query.execute();				
		return new SP_DDM_GST_2_OTHERS_Result().generateOthersResult(query.getResultList());
	}


}
