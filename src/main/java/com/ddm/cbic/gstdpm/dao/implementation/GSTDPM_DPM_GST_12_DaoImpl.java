package com.ddm.cbic.gstdpm.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_12_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_12_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_12_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_12_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_12_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_12_ZONE_Result;

@Repository
public class GSTDPM_DPM_GST_12_DaoImpl implements  GSTDPM_DPM_GST_12_Dao{
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	@SuppressWarnings("unchecked")
	public List<SP_DPM_GST_12_ALL_Result> generateResult_SP_DPM_GST_12_ALL(String mm_yyyy) {
		// TODO Auto-generated method stub
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_12_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.execute();				
		return new SP_DPM_GST_12_ALL_Result().generateAllResult(query.getResultList());
	}
	
	public List<SP_DPM_GST_12_ZONE_Result> generateResult_SP_DPM_GST_12_ZONE(String zone ,String mm_yyyy) {
		// TODO Auto-generated method stub
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_12_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1, zone);			
		query.setParameter(2, mm_yyyy);							
		query.execute();				
		return new SP_DPM_GST_12_ZONE_Result().generateAllResult(query.getResultList());
	}
	public List<SP_DPM_GST_12_COMM_Result> generateResult_SP_DPM_GST_12_COMM(String comm ,String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_12_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1, comm);			
		query.setParameter(2, mm_yyyy);								
		query.execute();				
		return new SP_DPM_GST_12_COMM_Result().generateAllResult(query.getResultList());
	}
	
	public Object generateResult_SP_DPM_GST_12_MAX_DATE(String comm) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_12_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, comm);
		query.execute();
		return query.getResultList().get(0);
	}
	public List<SP_DPM_GST_12_COMM_TEMP_REPORT_Result> 
	generateResultBeanList_SP_DPM_GST_12_COMM_TEMP_REPORT(
			Object[] objArray) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_12_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != objArray[0]) {
			query.setParameter(1, objArray[0]);
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if (null != objArray[1]) {
			query.setParameter(2, objArray[1]);
		}
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != objArray[2]) {
			query.setParameter(3, objArray[2]);
		}
		
		  query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN); 
		  if (null != objArray[3]) { query.setParameter(4, objArray[3]); }
		  query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN); 
		  if
		  (null != objArray[4]) { query.setParameter(5, objArray[4]); }
		 
		query.execute();

		
		return new SP_DPM_GST_12_COMM_TEMP_REPORT_Result().generateAllResult(query.getResultList());
	}
	
	
	public List<SP_DPM_GST_12_COMM_TEMP_Result> generateResultBeanList_SP_DPM_GST_12_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request) {
		
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_12_COMM_TEMP");
		if (crr == null || crr == "")
			crr = null;

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != code) {
			query.setParameter(1, code);
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN); 
		if (null != mM_YYYY) {
			query.setParameter(2, mM_YYYY);
		}
		
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != crr) {
			query.setParameter(3, crr);
		}
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
		query.execute();

		String out = (String) query.getOutputParameterValue(4);

		request.setAttribute("result", out);
		
		

		return new SP_DPM_GST_12_COMM_TEMP_Result().generateAllResult(query.getResultList());
	}

	//---------------------------------
	public String generateResult_SP_DPM_GST_12_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, 
			String p_SR_NO, String p_NO_TAXPAYER_FOR_MONTH, String p_NEW_TAXPAYER_FOR_MONTH,
			String p_MIGRATION_TAXPAYER_FROM, String p_MIGRATION_TAXPAYER_TO, String p_SUO_MOTO,
			String p_ON_REQUEST, String p_REVOCATION,
			String p_CRR) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_12_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_SR_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_NO_TAXPAYER_FOR_MONTH);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_NEW_TAXPAYER_FOR_MONTH);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_MIGRATION_TAXPAYER_FROM);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_MIGRATION_TAXPAYER_TO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_SUO_MOTO);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_ON_REQUEST);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_REVOCATION);
		
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(11, p_CRR);
		}

		query.registerStoredProcedureParameter(12, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(12).toString();
	}

	
	public String generateResult_SP_DPM_GST_12_INSERT(String p_COMM_CODE, String p_MM_YYYY, 
			String p_SR_NO, String p_NO_TAXPAYER_FOR_MONTH, String p_NEW_TAXPAYER_FOR_MONTH,
			String p_MIGRATION_TAXPAYER_FROM, String p_MIGRATION_TAXPAYER_TO, String p_SUO_MOTO,
			String p_ON_REQUEST, String p_REVOCATION
			,String p_CRR) {

		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_12_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		/*
		 * query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		 * query.setParameter(3, p_SR_NO);
		 */
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_NO_TAXPAYER_FOR_MONTH);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_NEW_TAXPAYER_FOR_MONTH);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_MIGRATION_TAXPAYER_FROM);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_MIGRATION_TAXPAYER_TO);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_SUO_MOTO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_ON_REQUEST);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_REVOCATION);
		
		/*
		 * query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		 * if (null != p_CRR) { query.setParameter(11, p_CRR); }
		 * 
		 * query.registerStoredProcedureParameter(12, String.class, ParameterMode.OUT);
		 * 
		 * query.execute();
		 * 
		 * return query.getOutputParameterValue(12).toString();
		 */
		
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(10).toString();
	}
}
