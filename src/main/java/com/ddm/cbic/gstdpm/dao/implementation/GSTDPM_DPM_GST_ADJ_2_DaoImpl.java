package com.ddm.cbic.gstdpm.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_ADJ_2_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_ZONE_Result;



@Repository
public class GSTDPM_DPM_GST_ADJ_2_DaoImpl implements  GSTDPM_DPM_GST_ADJ_2_Dao{
	
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	@SuppressWarnings("unchecked")
	public List<SP_DPM_GST_ADJ_2_ALL_Result> generateResult_SP_DPM_GST_ADJ_2_ALL(String mm_yyyy) {
		// TODO Auto-generated method stub
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_2_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.execute();				
		return new SP_DPM_GST_ADJ_2_ALL_Result().generateAllResult(query.getResultList());
	}
	
	public List<SP_DPM_GST_ADJ_2_ZONE_Result> generateResult_SP_DPM_GST_ADJ_2_ZONE(String zone ,String mm_yyyy) {
		// TODO Auto-generated method stub
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_2_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1, zone);			
		query.setParameter(2, mm_yyyy);							
		query.execute();				
		return new SP_DPM_GST_ADJ_2_ZONE_Result().generateAllResult(query.getResultList());
	}
	public List<SP_DPM_GST_ADJ_2_COMM_Result> generateResult_SP_DPM_GST_ADJ_2_COMM(String comm ,String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_2_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1, comm);			
		query.setParameter(2, mm_yyyy);								
		query.execute();				
		return new SP_DPM_GST_ADJ_2_COMM_Result().generateAllResult(query.getResultList());
	}
	
	public Object generateResult_SP_DPM_GST_ADJ_2_MAX_DATE(String comm) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_2_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, comm);
		query.execute();
		return query.getResultList().get(0);
	}
	public List<SP_DPM_GST_ADJ_2_COMM_TEMP_REPORT_Result> 
	generateResultBeanList_SP_DPM_GST_ADJ_2_COMM_TEMP_REPORT(
			Object[] objArray) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_2_COMM_TEMP_REPORT");
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

		
		return new SP_DPM_GST_ADJ_2_COMM_TEMP_REPORT_Result().generateAllResult(query.getResultList());
	}
	
	
	public List<SP_DPM_GST_ADJ_2_COMM_TEMP_Result> generateResultBeanList_SP_DPM_GST_ADJ_2_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request) {
		
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_2_COMM_TEMP");
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
		
		

		return new SP_DPM_GST_ADJ_2_COMM_TEMP_Result().generateAllResult(query.getResultList());
	}

	//---------------------------------
	public String generateResult_SP_DPM_GST_ADJ_2_TEMP_UPDATE(
			String p_COMM_CODE, String p_MM_YYYY, 
			String p_OPENING_NO, String p_OPENING_AMT, String p_RECEIPT_NO,
			String p_RECEIPT_AMT, String p_RECEIPT_UPTO_NO, String p_RECEIPT_UPTO_AMT,
			String p_DISPOSAL_REVENUE_NO, String p_DISPOSAL_REVENUE_AMT,
			String p_DISPOSAL_TAXPAYER_NO, String p_DISPOSAL_TAXPAYER_AMT, String p_TOTAL_DISPOSAL_NO,
			String p_TOTAL_DISPOSAL_AMOUNT, String p_CLOSING_BALANCE_NO, String p_CLOSING_BALANCE_AMOUNT,
			String p_AGE_UPTO_6_NO, String p_AGE_6_TO_12_NO,String p_AGE_MORE_THAN_1_NO,
			String p_CRR) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_2_UPDATE");
		
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_OPENING_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_OPENING_AMT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_RECEIPT_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_RECEIPT_AMT);
		/*
		 * query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		 * query.setParameter(7, p_RECEIPT_UPTO_NO);
		 * query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		 * query.setParameter(8, p_RECEIPT_UPTO_AMT);
		 */
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_DISPOSAL_REVENUE_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_DISPOSAL_REVENUE_AMT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_DISPOSAL_TAXPAYER_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_DISPOSAL_TAXPAYER_AMT);
		
		/*
		 * query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		 * query.setParameter(11, p_CLOSING_BALANCE_NO);
		 * query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		 * query.setParameter(12, p_CLOSING_BALANCE_AMOUNT);
		 */
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_AGE_UPTO_6_NO);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_AGE_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(14, p_CRR);
		}
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(15).toString();
	}
	
	public String generateResult_SP_DPM_GST_ADJ_2_TEMP_INSERT(
			String p_COMM_CODE, String p_MM_YYYY, 
			String p_OPENING_NO, String p_OPENING_AMT, String p_RECEIPT_NO,
			String p_RECEIPT_AMT, String p_RECEIPT_UPTO_NO, String p_RECEIPT_UPTO_AMT,
			String p_DISPOSAL_REVENUE_NO, String p_DISPOSAL_REVENUE_AMT,
			String p_DISPOSAL_TAXPAYER_NO, String p_DISPOSAL_TAXPAYER_AMT, String p_TOTAL_DISPOSAL_NO,
			String p_TOTAL_DISPOSAL_AMOUNT, String p_CLOSING_BALANCE_NO, String p_CLOSING_BALANCE_AMOUNT,
			String p_AGE_UPTO_6_NO, String p_AGE_6_TO_12_NO,String p_AGE_MORE_THAN_1_NO,
			String p_CRR) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_2_INSERT");
		
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_OPENING_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_OPENING_AMT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_RECEIPT_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_RECEIPT_AMT);
		
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_DISPOSAL_REVENUE_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_DISPOSAL_REVENUE_AMT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_DISPOSAL_TAXPAYER_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_DISPOSAL_TAXPAYER_AMT);
		
		
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_AGE_UPTO_6_NO);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_AGE_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(14, p_CRR);
		}
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(15).toString();
	}

	
	
	@Override
	public Object generateResult_SP_DPM_GST_ADJ_2_MARCH_DATA_CHECK(String code) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_2_MARCH_DATA_CHECK");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.execute();
		return query.getResultList().get(0);
	}


		@Override
	
		public String generateResult_SP_DPM_GST_ADJ_2_INSERT_OPENING(String code, String mm_yyyy,
						String opening_BALANCE_NO,String opening_BALANCE_AMOUNT) {
				
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_2_INSERT_OPENING");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, opening_BALANCE_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, opening_BALANCE_AMOUNT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(5).toString();
		}
	
	}
