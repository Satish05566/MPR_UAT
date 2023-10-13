package com.ddm.cbic.gstgi.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_ZONE_Result;
import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_6_Dao;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_ZONE_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result;

@Repository
public class GSTGI_GI_GST_6_Dao_Impl implements GSTGI_GI_GST_6_Dao {
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	
	private SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result sp_GI_GST_6_HSN_SAC_MASTER_LIST_Result = new SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result();
	
	
	@Override
	public Object generateResult_SP_GI_GST_6_MAX_DATE(String code) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_6_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);			
		query.execute();				
		return query.getResultList().get(0);
	}

	@Override
	public List<SP_GI_GST_6_COMM_TEMP_Result> generateResultBeanList_SP_GI_GST_6_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_6_COMM_TEMP");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != crr) query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);			
		query.execute();
		
		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_GI_GST_6_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
		
	}

	@Override
	public String generateResult_SP_GI_GST_6_UPDATE(String code, String mm_yyyy, 
			String p_HSN_SAC_CODE,String p_GOODS_OR_SERVICES_TYPE,
			String p_NO_OF_CASES,String p_AMOUNT_OF_TAX_EVASION,
			
			String p_NO_OF_CASES_PRE,String p_AMOUNT_OF_TAX_EVASION_PRE,
			
			
			Object crr)
			{
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_6_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_HSN_SAC_CODE);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_GOODS_OR_SERVICES_TYPE);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_NO_OF_CASES);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_AMOUNT_OF_TAX_EVASION);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_NO_OF_CASES_PRE);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_AMOUNT_OF_TAX_EVASION_PRE);
		
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(9, crr); 
		
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(10).toString();
	}

	
	  @Override public String generateResult_SP_GI_GST_6_INSERT(String code, String mm_yyyy, 
				String p_HSN_SAC_CODE,String p_GOODS_OR_SERVICES_TYPE,
				String p_NO_OF_CASES,String p_AMOUNT_OF_TAX_EVASION,
				
				String p_NO_OF_CASES_PRE,String p_AMOUNT_OF_TAX_EVASION_PRE) {
	  
	  query= entityManager.createStoredProcedureQuery("SP_GI_GST_6_INSERT");
	  query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	  query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_HSN_SAC_CODE);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_GOODS_OR_SERVICES_TYPE);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_NO_OF_CASES);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_AMOUNT_OF_TAX_EVASION);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_NO_OF_CASES_PRE);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_AMOUNT_OF_TAX_EVASION_PRE);
	 
	  
	  query.registerStoredProcedureParameter(9, String.class, ParameterMode.OUT);
	  query.execute(); return query.getOutputParameterValue(9).toString(); }
	 

	
	public List<SP_GI_GST_6_ALL_Result> generateResult_SP_GI_GST_6_ALL(String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_6_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);							
		query.execute();				
		return new SP_GI_GST_6_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public List<SP_GI_GST_6_ZONE_Result> generateResult_SP_GI_GST_6_ZONE(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_6_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_GI_GST_6_ZONE_Result().generateZoneResult(query.getResultList());		
	}

	@Override
	public List<SP_GI_GST_6_COMM_Result> generateResult_SP_GI_GST_6_COMM(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_6_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);		
		query.execute();				
		return new SP_GI_GST_6_COMM_Result().generateCommResult(query.getResultList());

	}

	@Override
	public List<SP_GI_GST_6_COMM_TEMP_REPORT_Result> generateResult_SP_GI_GST_6_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object crr, Object bak, Object submission_Date) {
		if(crr == null || crr == "")crr=null;
		query= entityManager.createStoredProcedureQuery("SP_GI_GST_6_COMM_TEMP_REPORT");
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
		return new SP_GI_GST_6_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
		
	}
	
	public  List<SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result > get_GI_GST_6_HSN_SAC_MASTER_LIST(){
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_GI_GST_6_HSN_SAC_MASTER");
		query.execute();
		int noOfRecords = query.getMaxResults();
		System.out.println("noOfRecords " + noOfRecords);
		if(noOfRecords > 0)
		return sp_GI_GST_6_HSN_SAC_MASTER_LIST_Result.generateResultBeanList(query.getResultList());
		else
		return null;	
	}
}
