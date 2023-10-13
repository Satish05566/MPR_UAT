package com.ddm.cbic.gstgi.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_1A_Dao;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_ZONE_Result;



@Repository
public class GSTGI_GI_GST_1A_Dao_Impl implements GSTGI_GI_GST_1A_Dao {
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	

	@Override
	public Object generateResult_SP_GI_GST_1A_MAX_DATE(String code) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1A_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);			
		query.execute();				
		return query.getResultList().get(0);
	}

	@Override
	public SP_GI_GST_1A_COMM_TEMP_Result generateResult_SP_GI_GST_1A_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1A_COMM_TEMP");
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != crr) query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);			
		query.execute();
		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_GI_GST_1A_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
	}

	@Override
	public String generateResult_SP_GI_GST_1A_UPDATE(String code, String mm_yyyy, String ARRESTS_MADE, String PROSECUTION_SANCTIONED,
			String COMPOUNDING_OF_OFFENCES, String PROSECUTION_LAUNCHED, String ARRESTS_MADE_PRE,  String PROSECUTION_SANCTIONED_PRE, String COMPOUNDING_OF_OFFENCES_PRE,
			String PROSECUTION_LAUNCHED_PRE, Object crr) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1A_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, ARRESTS_MADE);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, PROSECUTION_SANCTIONED);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, COMPOUNDING_OF_OFFENCES);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, PROSECUTION_LAUNCHED);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, ARRESTS_MADE_PRE);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, PROSECUTION_SANCTIONED_PRE);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, COMPOUNDING_OF_OFFENCES_PRE);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, PROSECUTION_LAUNCHED_PRE);
		
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(11, crr);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(12).toString();
	}

	@Override
	public String generateResult_SP_GI_GST_1A_INSERT(String code, String mm_yyyy, String ARRESTS_MADE, String PROSECUTION_SANCTIONED,
			String COMPOUNDING_OF_OFFENCES, String PROSECUTION_LAUNCHED, String ARRESTS_MADE_PRE,  String PROSECUTION_SANCTIONED_PRE, String COMPOUNDING_OF_OFFENCES_PRE,
			String PROSECUTION_LAUNCHED_PRE) {		
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1A_INSERT");
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, ARRESTS_MADE);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, PROSECUTION_SANCTIONED);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, COMPOUNDING_OF_OFFENCES);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, PROSECUTION_LAUNCHED);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, ARRESTS_MADE_PRE);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, PROSECUTION_SANCTIONED_PRE);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, COMPOUNDING_OF_OFFENCES_PRE);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, PROSECUTION_LAUNCHED_PRE);
		
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(11).toString();
	}

	@Override
	public SP_GI_GST_1A_ALL_Result generateResult_SP_GI_GST_1A_ALL(String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1A_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);							
		query.execute();				
		return new SP_GI_GST_1A_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_1A_REGION_Result generateResult_SP_GI_GST_1A_REGION(String mm_yyyy, String code) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1A_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_GI_GST_1A_REGION_Result().generateRegionResult(query.getResultList());
		
	}

	@Override
	public SP_GI_GST_1A_ZONE_Result generateResult_SP_GI_GST_1A_ZONE(String mm_yyyy, String code) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1A_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_GI_GST_1A_ZONE_Result().generateZoneResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_1A_COMM_Result generateResult_SP_GI_GST_1A_COMM(String mm_yyyy, String code) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1A_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy );
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);		
		query.execute();				
		return new SP_GI_GST_1A_COMM_Result().generateCommResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_1A_COMM_TEMP_REPORT_Result generateResult_SP_GI_GST_1A_COMM_TEMP_REPORT(String mm_yyyy,
			String code, Object crr, Object bak, Object submission_Date) {
		
		if(crr == null || crr == "")crr=null;	
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1A_COMM_TEMP_REPORT");
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
		return new SP_GI_GST_1A_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
	}

}
