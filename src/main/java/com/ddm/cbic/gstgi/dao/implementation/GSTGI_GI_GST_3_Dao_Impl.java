package com.ddm.cbic.gstgi.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_3_Dao;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_ZONE_Result;

@Repository
public class GSTGI_GI_GST_3_Dao_Impl implements GSTGI_GI_GST_3_Dao {
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	
	@Override
	public Object generateResult_SP_GI_GST_3_MAX_DATE(String code) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_3_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);			
		query.execute();				
		return query.getResultList().get(0);
	}

	@Override
	public SP_GI_GST_3_COMM_TEMP_Result generateResult_SP_GI_GST_3_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_3_COMM_TEMP");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != crr) query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);			
		query.execute();
		
		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_GI_GST_3_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
		
	}

	@Override
	public String generateResult_SP_GI_GST_3_UPDATE(String code, String mm_yyyy, String REWARD_DEPARTMENTAL_NO,
			String REWARD_DEPARTMENTAL_AMT,String REWARD_INFORMER_NO,String REWARD_INFORMER_AMT,
			String DISBURSED_DEPARTMENTAL_NO,String DISBURSED_DEPARTMENTAL_AMT,String DISBURSED_INFORMER_NO,
			String DISBURSED_INFORMER_AMT,String PENDING_DEPARTMENTAL_NO,String PENDING_DEPARTMENTAL_AMT,
			String PENDING_INFORMER_NO,String PENDING_INFORMER_AMT,
              Object crr) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_3_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, REWARD_DEPARTMENTAL_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, REWARD_DEPARTMENTAL_AMT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, REWARD_INFORMER_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, REWARD_INFORMER_AMT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, DISBURSED_DEPARTMENTAL_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, DISBURSED_DEPARTMENTAL_AMT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, DISBURSED_INFORMER_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, DISBURSED_INFORMER_AMT);	
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, PENDING_DEPARTMENTAL_NO);
		
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, PENDING_DEPARTMENTAL_AMT);
		
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, PENDING_INFORMER_NO);
		
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, PENDING_INFORMER_AMT);
						
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(15, crr); 
		
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(16).toString();
	}

	@Override
	public String generateResult_SP_GI_GST_3_INSERT(String code, String mm_yyyy, String REWARD_DEPARTMENTAL_NO,
			String REWARD_DEPARTMENTAL_AMT,String REWARD_INFORMER_NO,String REWARD_INFORMER_AMT,
			String DISBURSED_DEPARTMENTAL_NO,String DISBURSED_DEPARTMENTAL_AMT,String DISBURSED_INFORMER_NO,
			String DISBURSED_INFORMER_AMT,String PENDING_DEPARTMENTAL_NO,String PENDING_DEPARTMENTAL_AMT,
			String PENDING_INFORMER_NO,String PENDING_INFORMER_AMT) {
		
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_3_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, REWARD_DEPARTMENTAL_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, REWARD_DEPARTMENTAL_AMT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, REWARD_INFORMER_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, REWARD_INFORMER_AMT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, DISBURSED_DEPARTMENTAL_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, DISBURSED_DEPARTMENTAL_AMT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, DISBURSED_INFORMER_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, DISBURSED_INFORMER_AMT);	
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, PENDING_DEPARTMENTAL_NO);
		
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, PENDING_DEPARTMENTAL_AMT);
		
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, PENDING_INFORMER_NO);
		
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, PENDING_INFORMER_AMT);
	
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(15).toString();
	}

	@Override
	public SP_GI_GST_3_ALL_Result generateResult_SP_GI_GST_3_ALL(String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_3_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);							
		query.execute();				
		return new SP_GI_GST_3_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_3_ZONE_Result generateResult_SP_GI_GST_3_ZONE(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_3_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_GI_GST_3_ZONE_Result().generateZoneResult(query.getResultList());		
	}

	@Override
	public SP_GI_GST_3_COMM_Result generateResult_SP_GI_GST_3_COMM(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_3_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);		
		query.execute();				
		return new SP_GI_GST_3_COMM_Result().generateCommResult(query.getResultList());

	}

	@Override
	public SP_GI_GST_3_COMM_TEMP_REPORT_Result generateResult_SP_GI_GST_3_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object crr, Object bak, Object submission_Date) {
		if(crr == null || crr == "")crr=null;
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_3_COMM_TEMP_REPORT");
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
		return new SP_GI_GST_3_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
		
	}
}
