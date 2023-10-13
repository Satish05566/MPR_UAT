package com.ddm.cbic.gstdpm.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_15A_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_ZONE_Result;


@Repository
public class GSTDPM_DPM_GST_15A_Dao_Impl implements GSTDPM_DPM_GST_15A_Dao{
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	

	@Override
	public Object generateResult_SP_DPM_GST_15A_MAX_DATE(String code) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15A_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);			
		query.execute();				
		return query.getResultList().get(0);
	}

	@Override
	public SP_DPM_GST_15A_COMM_TEMP_Result generateResult_SP_DPM_GST_15A_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15A_COMM_TEMP");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != crr) query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);			
		query.execute();
		
		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_DPM_GST_15A_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
		
	}

	@Override
	public String generateResult_SP_DPM_GST_15A_UPDATE(String code, String mm_yyyy, String suo_MOTO_OPENING_BALANCE,
			String suo_MOTO_GSTIN_LIABLE_FOR_CANCELLATION, String suo_MOTO_GSTIN_CANCELLED,
			String cancellation_OPENING_BALANCE, String cancellation_NO_APPLICATION_RECEIVED,
			String cancellation_GSTIN_CANCELLED, String revocation_OPENING_BALANCE, String revocation_ARN_RECEIVED,
			String revocation_GSTIN_REVOKED, String revocation_APPLICATION_REJECTED, Object crr) {
		
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15A_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, suo_MOTO_OPENING_BALANCE);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, suo_MOTO_GSTIN_LIABLE_FOR_CANCELLATION);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, suo_MOTO_GSTIN_CANCELLED);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, cancellation_OPENING_BALANCE);		
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, cancellation_NO_APPLICATION_RECEIVED);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, cancellation_GSTIN_CANCELLED);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, revocation_OPENING_BALANCE);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, revocation_ARN_RECEIVED);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, revocation_GSTIN_REVOKED);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
        query.setParameter(12, revocation_APPLICATION_REJECTED);	
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(13, crr); 
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(14).toString();
	}

	@Override
	public String generateResult_SP_DPM_GST_15A_INSERT(String code, String mm_yyyy, String suo_MOTO_OPENING_BALANCE,
			String suo_MOTO_GSTIN_LIABLE_FOR_CANCELLATION, String suo_MOTO_GSTIN_CANCELLED,
			String cancellation_OPENING_BALANCE, String cancellation_NO_APPLICATION_RECEIVED,
			String cancellation_GSTIN_CANCELLED, String revocation_OPENING_BALANCE, String revocation_ARN_RECEIVED,
			String revocation_GSTIN_REVOKED, String revocation_APPLICATION_REJECTED) {

		
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15A_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, suo_MOTO_OPENING_BALANCE);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, suo_MOTO_GSTIN_LIABLE_FOR_CANCELLATION);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, suo_MOTO_GSTIN_CANCELLED);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, cancellation_OPENING_BALANCE);		
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, cancellation_NO_APPLICATION_RECEIVED);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, cancellation_GSTIN_CANCELLED);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, revocation_OPENING_BALANCE);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, revocation_ARN_RECEIVED);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, revocation_GSTIN_REVOKED);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
        query.setParameter(12, revocation_APPLICATION_REJECTED);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(13).toString();
	}

	@Override
	public SP_DPM_GST_15A_ALL_Result generateResult_SP_DPM_GST_15A_ALL(String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15A_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);							
		query.execute();				
		return new SP_DPM_GST_15A_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_DPM_GST_15A_REGION_Result generateResult_SP_DPM_GST_15A_REGION(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15A_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);						
		query.execute();				
		 return new SP_DPM_GST_15A_REGION_Result().generateRegionResult(query.getResultList());

	}

	@Override
	public SP_DPM_GST_15A_ZONE_Result generateResult_SP_DPM_GST_15A_ZONE(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15A_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_DPM_GST_15A_ZONE_Result().generateZoneResult(query.getResultList());		
	}

	@Override
	public SP_DPM_GST_15A_COMM_Result generateResult_SP_DPM_GST_15A_COMM(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15A_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);		
		query.execute();				
		return new SP_DPM_GST_15A_COMM_Result().generateCommResult(query.getResultList());

	}

	@Override
	public SP_DPM_GST_15A_COMM_TEMP_REPORT_Result generateResult_SP_DPM_GST_15A_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object crr, Object bak, Object submission_Date) {
		if(crr == null || crr == "")crr=null;
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_15A_COMM_TEMP_REPORT");
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
		return new SP_DPM_GST_15A_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
		
	}

}
