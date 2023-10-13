package com.ddm.cbic.gstdpm.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_14A_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_ZONE_Result;

@Repository
public class GSTDPM_DPM_GST_14A_Dao_Impl implements GSTDPM_DPM_GST_14A_Dao {
	
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	

	@Override
	public Object generateResult_SP_DPM_GST_14A_MAX_DATE(String code) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_14A_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);			
		query.execute();				
		return query.getResultList().get(0);
	}

	@Override
	public SP_DPM_GST_14A_COMM_TEMP_Result generateResult_SP_DPM_GST_14A_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_14A_COMM_TEMP");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != crr) query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);			
		query.execute();
		
		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_DPM_GST_14A_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
		
	}

	@Override
	public String generateResult_SP_DPM_GST_14A_UPDATE(String code, String mm_yyyy,
			String OPENING_BALANCE, String no_OF_ARN_RECEIVED_GSTN, String no_OF_ARN_RECEIVED_CPC,
			String disposal_OF_ARN_WITHIN_7, String disposal_OF_ARN_PV_RECOMMENDED, String disposal_OF_ARN_PV_APPROVED,
			String disposal_OF_ARN_PV_REJECTED, String disposal_OF_ARN_PV_NOT_RECEIVED,
			String disposal_OF_ARN_TRANSFERED_CPC, String disposal_OF_ARN_DEEMED_REG, Object crr) {
		
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_14A_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, OPENING_BALANCE);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, no_OF_ARN_RECEIVED_GSTN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, no_OF_ARN_RECEIVED_CPC);		
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, disposal_OF_ARN_WITHIN_7);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, disposal_OF_ARN_PV_RECOMMENDED);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, disposal_OF_ARN_PV_APPROVED);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, disposal_OF_ARN_PV_REJECTED);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, disposal_OF_ARN_PV_NOT_RECEIVED);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, disposal_OF_ARN_TRANSFERED_CPC);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, disposal_OF_ARN_DEEMED_REG);		
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(13, crr); 
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(14).toString();
	}

	@Override
	public String generateResult_SP_DPM_GST_14A_INSERT(String code, String mm_yyyy,
			String OPENING_BALANCE, String no_OF_ARN_RECEIVED_GSTN, String no_OF_ARN_RECEIVED_CPC,
			String disposal_OF_ARN_WITHIN_7, String disposal_OF_ARN_PV_RECOMMENDED, String disposal_OF_ARN_PV_APPROVED,
			String disposal_OF_ARN_PV_REJECTED, String disposal_OF_ARN_PV_NOT_RECEIVED,
			String disposal_OF_ARN_TRANSFERED_CPC, String disposal_OF_ARN_DEEMED_REG) {

		
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_14A_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, OPENING_BALANCE);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, no_OF_ARN_RECEIVED_GSTN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, no_OF_ARN_RECEIVED_CPC);		
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, disposal_OF_ARN_WITHIN_7);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, disposal_OF_ARN_PV_RECOMMENDED);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, disposal_OF_ARN_PV_APPROVED);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, disposal_OF_ARN_PV_REJECTED);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, disposal_OF_ARN_PV_NOT_RECEIVED);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, disposal_OF_ARN_TRANSFERED_CPC);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, disposal_OF_ARN_DEEMED_REG);	
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(13).toString();
	}

	@Override
	public SP_DPM_GST_14A_ALL_Result generateResult_SP_DPM_GST_14A_ALL(String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_14A_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);							
		query.execute();				
		return new SP_DPM_GST_14A_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_DPM_GST_14A_REGION_Result generateResult_SP_DPM_GST_14A_REGION(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_14A_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);						
		query.execute();				
		 return new SP_DPM_GST_14A_REGION_Result().generateRegionResult(query.getResultList());

	}

	@Override
	public SP_DPM_GST_14A_ZONE_Result generateResult_SP_DPM_GST_14A_ZONE(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_14A_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_DPM_GST_14A_ZONE_Result().generateZoneResult(query.getResultList());		
	}

	@Override
	public SP_DPM_GST_14A_COMM_Result generateResult_SP_DPM_GST_14A_COMM(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_14A_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);		
		query.execute();				
		return new SP_DPM_GST_14A_COMM_Result().generateCommResult(query.getResultList());

	}

	@Override
	public SP_DPM_GST_14A_COMM_TEMP_REPORT_Result generateResult_SP_DPM_GST_14A_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object crr, Object bak, Object submission_Date) {
		if(crr == null || crr == "")crr=null;
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_14A_COMM_TEMP_REPORT");
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
		return new SP_DPM_GST_14A_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
		
	}

}
