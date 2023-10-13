package com.ddm.cbic.gstdpm.dao.implementation;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_15B_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_ZONE_Result;
@Repository
public class GSTDPM_DPM_GST_15B_Dao_Impl implements GSTDPM_DPM_GST_15B_Dao{
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	

	@Override
	public Object generateResult_SP_DPM_GST_15B_MAX_DATE(String code) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15B_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);			
		query.execute();				
		return query.getResultList().get(0);
	}

	@Override
	public SP_DPM_GST_15B_COMM_TEMP_Result generateResult_SP_DPM_GST_15B_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15B_COMM_TEMP");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != crr) query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);			
		query.execute();
		
		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_DPM_GST_15B_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
		
	}

	@Override
	public String generateResult_SP_DPM_GST_15B_UPDATE(String code, String mm_yyyy,String PENDENCY_PART_OFFICER_NO_GSTIN ,
			String REPLY_AWAITED_TAXPAYER_NO_GSTIN,
			String TAXES_OR_DUES_UNPAID_NO_GSTIN,
			String TECHNICAL_ISSUES_NO_GSTIN,
			String OTHERS_REMARKS,
			String OTHERS_NO_GSTIN, Object crr) {
		
		//if(crr ==null || crr =="")crr = "";
		if (crr == null || crr == "")
			crr = null;
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15B_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, PENDENCY_PART_OFFICER_NO_GSTIN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, REPLY_AWAITED_TAXPAYER_NO_GSTIN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, TAXES_OR_DUES_UNPAID_NO_GSTIN);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, TECHNICAL_ISSUES_NO_GSTIN);		
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, OTHERS_REMARKS);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, OTHERS_NO_GSTIN);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		if (null != crr) {
			query.setParameter(9, crr);
		}
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(10).toString();
	}

	@Override
	public String generateResult_SP_DPM_GST_15B_INSERT(String code, String mm_yyyy, String PENDENCY_PART_OFFICER_NO_GSTIN ,
			String REPLY_AWAITED_TAXPAYER_NO_GSTIN,
			String TAXES_OR_DUES_UNPAID_NO_GSTIN,
			String TECHNICAL_ISSUES_NO_GSTIN,
			String OTHERS_REMARKS,
			String OTHERS_NO_GSTIN) {
		
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15B_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, PENDENCY_PART_OFFICER_NO_GSTIN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, REPLY_AWAITED_TAXPAYER_NO_GSTIN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, TAXES_OR_DUES_UNPAID_NO_GSTIN);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, TECHNICAL_ISSUES_NO_GSTIN);		
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, OTHERS_REMARKS);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, OTHERS_NO_GSTIN);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(9).toString();
	}

	@Override
	public SP_DPM_GST_15B_ALL_Result generateResult_SP_DPM_GST_15B_ALL(String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15B_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);							
		query.execute();				
		return new SP_DPM_GST_15B_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_DPM_GST_15B_REGION_Result generateResult_SP_DPM_GST_15B_REGION(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15B_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);						
		query.execute();				
		 return new SP_DPM_GST_15B_REGION_Result().generateRegionResult(query.getResultList());

	}

	@Override
	public SP_DPM_GST_15B_ZONE_Result generateResult_SP_DPM_GST_15B_ZONE(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15B_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_DPM_GST_15B_ZONE_Result().generateZoneResult(query.getResultList());		
	}

	@Override
	public SP_DPM_GST_15B_COMM_Result generateResult_SP_DPM_GST_15B_COMM(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15B_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);		
		query.execute();				
		return new SP_DPM_GST_15B_COMM_Result().generateCommResult(query.getResultList());

	}

	@Override
	public SP_DPM_GST_15B_COMM_TEMP_REPORT_Result generateResult_SP_DPM_GST_15B_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object crr, Object bak, Object submission_Date) {
		if(crr == null || crr == "")crr=null;
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15B_COMM_TEMP_REPORT");
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
		System.out.println(query.getResultList());
		return new SP_DPM_GST_15B_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
		
	}
}
