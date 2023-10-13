package com.ddm.cbic.gstgi.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_1_Dao;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_ZONE_Result;



@Repository
public class GSTGI_GI_GST_1_Dao_Impl implements GSTGI_GI_GST_1_Dao {
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	

	@Override
	public Object generateResult_SP_GI_GST_1_MAX_DATE(String code) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);			
		query.execute();				
		return query.getResultList().get(0);
	}

	@Override
	public SP_GI_GST_1_COMM_TEMP_Result generateResult_SP_GI_GST_1_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1_COMM_TEMP");
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != crr) query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);			
		query.execute();
		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_GI_GST_1_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
	}

	@Override
	public String generateResult_SP_GI_GST_1_UPDATE(String code, String mm_yyyy, 
			String DETECTION_CGST_NO,
			String DETECTION_CGST_AMT, String DETECTION_SGST_AMT, String DETECTION_IGST_AMT,
			String DETECTION_CESS_AMT, String DETECTION_CGST_NO_PRE, String DETECTION_CGST_AMT_PRE,
			String DETECTION_SGST_AMT_PRE, String DETECTION_IGST_AMT_PRE, String DETECTION_CESS_AMT_PRE,
			String REALISATION_CGST_NO,String REALISATION_CGST_AMT,
			String REALISATION_SGST_AMT, String REALISATION_IGST_AMT, String REALISATION_CESS_AMT, String REALISATION_CGST_NO_PRE,
			String REALISATION_CGST_AMT_PRE,
			String REALISATION_SGST_AMT_PRE, String REALISATION_IGST_AMT_PRE, String REALISATION_CESS_AMT_PRE, Object crr) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, DETECTION_CGST_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, DETECTION_CGST_AMT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, DETECTION_SGST_AMT);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, DETECTION_IGST_AMT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, DETECTION_CESS_AMT);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, DETECTION_CGST_NO_PRE);
		
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, DETECTION_CGST_AMT_PRE);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, DETECTION_SGST_AMT_PRE);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, DETECTION_IGST_AMT_PRE);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, DETECTION_CESS_AMT_PRE);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, REALISATION_CGST_NO);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, REALISATION_CGST_AMT);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, REALISATION_SGST_AMT);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, REALISATION_IGST_AMT);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, REALISATION_CESS_AMT);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, REALISATION_CGST_NO_PRE);
		
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, REALISATION_CGST_AMT_PRE);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, REALISATION_SGST_AMT_PRE);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, REALISATION_IGST_AMT_PRE);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, REALISATION_CESS_AMT_PRE);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(23, crr);
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(24).toString();
	}

	@Override
	public String generateResult_SP_GI_GST_1_INSERT(String code, String mm_yyyy, 
			String DETECTION_CGST_NO,
			String DETECTION_CGST_AMT, String DETECTION_SGST_AMT, String DETECTION_IGST_AMT,
			String DETECTION_CESS_AMT, String DETECTION_CGST_NO_PRE, String DETECTION_CGST_AMT_PRE,
			String DETECTION_SGST_AMT_PRE, String DETECTION_IGST_AMT_PRE, String DETECTION_CESS_AMT_PRE,
			String REALISATION_CGST_NO,
			String REALISATION_CGST_AMT,
			String REALISATION_SGST_AMT, String REALISATION_IGST_AMT, String REALISATION_CESS_AMT, String REALISATION_CGST_NO_PRE,
			String REALISATION_CGST_AMT_PRE,
			String REALISATION_SGST_AMT_PRE, String REALISATION_IGST_AMT_PRE, String REALISATION_CESS_AMT_PRE) {		
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1_INSERT");
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, DETECTION_CGST_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, DETECTION_CGST_AMT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, DETECTION_SGST_AMT);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, DETECTION_IGST_AMT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, DETECTION_CESS_AMT);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, DETECTION_CGST_NO_PRE);
		
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, DETECTION_CGST_AMT_PRE);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, DETECTION_SGST_AMT_PRE);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, DETECTION_IGST_AMT_PRE);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, DETECTION_CESS_AMT_PRE);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, REALISATION_CGST_NO);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, REALISATION_CGST_AMT);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, REALISATION_SGST_AMT);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, REALISATION_IGST_AMT);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, REALISATION_CESS_AMT);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, REALISATION_CGST_NO_PRE);
		
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, REALISATION_CGST_AMT_PRE);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, REALISATION_SGST_AMT_PRE);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, REALISATION_IGST_AMT_PRE);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, REALISATION_CESS_AMT_PRE);
		
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(23).toString();
	}

	@Override
	public SP_GI_GST_1_ALL_Result generateResult_SP_GI_GST_1_ALL(String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);							
		query.execute();				
		return new SP_GI_GST_1_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_1_REGION_Result generateResult_SP_GI_GST_1_REGION(String mm_yyyy, String code) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_GI_GST_1_REGION_Result().generateRegionResult(query.getResultList());
		
	}

	@Override
	public SP_GI_GST_1_ZONE_Result generateResult_SP_GI_GST_1_ZONE(String mm_yyyy, String code) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_GI_GST_1_ZONE_Result().generateZoneResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_1_COMM_Result generateResult_SP_GI_GST_1_COMM(String mm_yyyy, String code) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy );
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);		
		query.execute();				
		return new SP_GI_GST_1_COMM_Result().generateCommResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_1_COMM_TEMP_REPORT_Result generateResult_SP_GI_GST_1_COMM_TEMP_REPORT(String mm_yyyy,
			String code, Object crr, Object bak, Object submission_Date) {
		
		if(crr == null || crr == "")crr=null;	
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_1_COMM_TEMP_REPORT");
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
		return new SP_GI_GST_1_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
	}

}


