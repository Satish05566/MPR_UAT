package com.ddm.cbic.gstddm.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstddm.dao.GSTDDM_DDM_GST_1_Dao;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_ALL_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_REGION_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_ZONE_Result;

@Repository
public class GSTDDM_DDM_GST_1_Dao_Impl implements GSTDDM_DDM_GST_1_Dao {
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	

	@Override
	public Object generateResult_SP_DDM_GST_1_MAX_DATE(String code) {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_1_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);			
		query.execute();				
		return query.getResultList().get(0);
	}

	@Override
	public SP_DDM_GST_1_COMM_TEMP_Result generateResult_SP_DDM_GST_1_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_1_COMM_TEMP");
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != crr) query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);			
		query.execute();
		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_DDM_GST_1_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
	}

	@Override
	public String generateResult_SP_DDM_GST_1_UPDATE(String code, String mm_yyyy, String moving_TARGET_CGST,
			String moving_TARGET_SGST, String moving_TARGET_IGST, String moving_TARGET_CESS, String gross_TAX_CGST,
			String gross_TAX_SGST, String gross_TAX_IGST, String gross_TAX_CESS, String refund_SANCTIONED_CGST,
			String refund_SANCTIONED_SGST, String refund_SANCTIONED_IGST, String refund_SANCTIONED_CESS, Object crr) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_1_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, moving_TARGET_CGST);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, moving_TARGET_SGST);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, moving_TARGET_IGST);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, moving_TARGET_CESS);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, gross_TAX_CGST);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, gross_TAX_SGST);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, gross_TAX_IGST);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, gross_TAX_CESS);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, refund_SANCTIONED_CGST);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, refund_SANCTIONED_SGST);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, refund_SANCTIONED_IGST);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, refund_SANCTIONED_CESS);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(15, crr);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(16).toString();
	}

	@Override
	public String generateResult_SP_DDM_GST_1_INSERT(String code, String mm_yyyy, String moving_TARGET_CGST,
			String moving_TARGET_SGST, String moving_TARGET_IGST, String moving_TARGET_CESS, String gross_TAX_CGST,
			String gross_TAX_SGST, String gross_TAX_IGST, String gross_TAX_CESS, String refund_SANCTIONED_CGST,
			String refund_SANCTIONED_SGST, String refund_SANCTIONED_IGST, String refund_SANCTIONED_CESS) {		
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_1_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, moving_TARGET_CGST);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, moving_TARGET_SGST);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, moving_TARGET_IGST);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, moving_TARGET_CESS);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, gross_TAX_CGST);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, gross_TAX_SGST);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, gross_TAX_IGST);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, gross_TAX_CESS);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, refund_SANCTIONED_CGST);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, refund_SANCTIONED_SGST);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, refund_SANCTIONED_IGST);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, refund_SANCTIONED_CESS);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(15).toString();
	}

	@Override
	public SP_DDM_GST_1_ALL_Result generateResult_SP_DDM_GST_1_ALL(String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_1_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);							
		query.execute();				
		return new SP_DDM_GST_1_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_DDM_GST_1_REGION_Result generateResult_SP_DDM_GST_1_REGION(String mm_yyyy, String code) {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_1_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_DDM_GST_1_REGION_Result().generateRegionResult(query.getResultList());
		
	}

	@Override
	public SP_DDM_GST_1_ZONE_Result generateResult_SP_DDM_GST_1_ZONE(String mm_yyyy, String code) {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_1_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_DDM_GST_1_ZONE_Result().generateZoneResult(query.getResultList());
	}

	@Override
	public SP_DDM_GST_1_COMM_Result generateResult_SP_DDM_GST_1_COMM(String mm_yyyy, String code) {
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_1_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy );
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);		
		query.execute();				
		return new SP_DDM_GST_1_COMM_Result().generateCommResult(query.getResultList());
	}

	@Override
	public SP_DDM_GST_1_COMM_TEMP_REPORT_Result generateResult_SP_DDM_GST_1_COMM_TEMP_REPORT(String mm_yyyy,
			String code, Object crr, Object bak, Object submission_Date) {
		
		if(crr == null || crr == "")crr=null;	
		query= entityManager.createStoredProcedureQuery("SP_DDM_GST_1_COMM_TEMP_REPORT");
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
		return new SP_DDM_GST_1_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
	}

}
