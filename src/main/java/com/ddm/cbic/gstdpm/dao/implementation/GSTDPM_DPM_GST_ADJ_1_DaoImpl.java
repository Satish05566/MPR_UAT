package com.ddm.cbic.gstdpm.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_ADJ_1_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_ZONE_Result;

@Repository
public class GSTDPM_DPM_GST_ADJ_1_DaoImpl implements  GSTDPM_DPM_GST_ADJ_1_Dao{
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	@SuppressWarnings("unchecked")
	public SP_DPM_GST_ADJ_1_ALL_Result generateResult_SP_DPM_GST_ADJ_1_ALL(String mm_yyyy) {
		// TODO Auto-generated method stub
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_1_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.execute();				
		return new SP_DPM_GST_ADJ_1_ALL_Result().generateAllResult(query.getResultList());
	}
	
	public SP_DPM_GST_ADJ_1_ZONE_Result generateResult_SP_DPM_GST_ADJ_1_ZONE(String zone ,String mm_yyyy) {
		// TODO Auto-generated method stub
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_1_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1, zone);			
		query.setParameter(2, mm_yyyy);							
		query.execute();				
		return new SP_DPM_GST_ADJ_1_ZONE_Result().generateAllResult(query.getResultList());
	}
	public SP_DPM_GST_ADJ_1_COMM_Result generateResult_SP_DPM_GST_ADJ_1_COMM(String comm ,String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_1_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1, comm);			
		query.setParameter(2, mm_yyyy);								
		query.execute();				
		return new SP_DPM_GST_ADJ_1_COMM_Result().generateAllResult(query.getResultList());
	}
	
	public Object generateResult_SP_DPM_GST_ADJ_1_MAX_DATE(String comm) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_1_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, comm);
		query.execute();
		return query.getResultList().get(0);
	}
	public SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT_Result 
	generateResultBeanList_SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT(
			String mM_YYYY,
			String code, Object crr, HttpServletRequest request) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != mM_YYYY) {
			query.setParameter(1, mM_YYYY);
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if (null != code) {
			query.setParameter(2, code);
		}
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != crr) {
			query.setParameter(3, crr);
		}
		
		  query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN); 
		  if (null != request) { query.setParameter(4, request); }
		  query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN); 
		 
		query.execute();

		
		return new SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT_Result().generateAllResult(query.getResultList());
	}
	
	
	public SP_DPM_GST_ADJ_1_COMM_TEMP_Result generateResultBeanList_SP_DPM_GST_ADJ_1_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request) {
		
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_1_COMM_TEMP");
		if (crr == null || crr == "")
			crr = null;

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != mM_YYYY) {
			query.setParameter(1, mM_YYYY);
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN); 
		if (null != code) {
			query.setParameter(2, code);
		}
		
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != crr) {
			query.setParameter(3, crr);
		}
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
		query.execute();

		String out = (String) query.getOutputParameterValue(4);

		request.setAttribute("result", out);
		
		

		return new SP_DPM_GST_ADJ_1_COMM_TEMP_Result().generateAllResult(query.getResultList());
	}

	//---------------------------------
	public String generateResult_SP_DPM_GST_ADJ_1_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY,
			String p_ADC_COMMISSIONERATE_OPENING_NO, String p_ADC_COMMISSIONERATE_OPENING_AMT,
			String p_ADC_COMMISSIONERATE_RECEIPT_NO, String p_ADC_COMMISSIONERATE_RECEIPT_AMT,
			String p_ADC_COMMISSIONERATE_DISPOSAL_NO, String p_ADC_COMMISSIONERATE_DISPOSAL_AMT,
			String p_ADC_COMMISSIONERATE_OIO_NO, String p_ADC_COMMISSIONERATE_OIO_AMT,
			String p_ADC_COMMISSIONERATE_AGE_LESS_3_NO, String p_ADC_COMMISSIONERATE_AGE_3_TO_6_NO,
			String p_ADC_COMMISSIONERATE_AGE_6_TO_12_NO, String p_ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String p_ADC_COMMISSIONERATE_TIME_LESS_3_NO, String p_ADC_COMMISSIONERATE_TIME_3_TO_6_NO,
			String p_ADC_COMMISSIONERATE_TIME_6_TO_12_NO, String p_ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO,
			String p_ADC_AUDIT_OPENING_NO, String p_ADC_AUDIT_OPENING_AMT, String p_ADC_AUDIT_RECEIPT_NO,
			String p_ADC_AUDIT_RECEIPT_AMT, String p_ADC_AUDIT_DISPOSAL_NO, String p_ADC_AUDIT_DISPOSAL_AMT,
			String p_ADC_AUDIT_OIO_NO, String p_ADC_AUDIT_OIO_AMT, String p_ADC_AUDIT_AGE_LESS_3_NO,
			String p_ADC_AUDIT_AGE_3_TO_6_NO, String p_ADC_AUDIT_AGE_6_TO_12_NO, String p_ADC_AUDIT_AGE_MORE_THAN_1_NO,
			String p_ADC_AUDIT_TIME_LESS_3_NO, String p_ADC_AUDIT_TIME_3_TO_6_NO, String p_ADC_AUDIT_TIME_6_TO_12_NO,
			String p_ADC_AUDIT_TIME_MORE_THAN_1_NO, String p_ADC_INVESTIGATION_OPENING_NO,
			String p_ADC_INVESTIGATION_OPENING_AMT, String p_ADC_INVESTIGATION_RECEIPT_NO,
			String p_ADC_INVESTIGATION_RECEIPT_AMT, String p_ADC_INVESTIGATION_DISPOSAL_NO,
			String p_ADC_INVESTIGATION_DISPOSAL_AMT, String p_ADC_INVESTIGATION_OIO_NO,
			String p_ADC_INVESTIGATION_OIO_AMT, String p_ADC_INVESTIGATION_AGE_LESS_3_NO,
			String p_ADC_INVESTIGATION_AGE_3_TO_6_NO, String p_ADC_INVESTIGATION_AGE_6_TO_12_NO,
			String p_ADC_INVESTIGATION_AGE_MORE_THAN_1_NO, String p_ADC_INVESTIGATION_TIME_LESS_3_NO,
			String p_ADC_INVESTIGATION_TIME_3_TO_6_NO, String p_ADC_INVESTIGATION_TIME_6_TO_12_NO,
			String p_ADC_INVESTIGATION_TIME_MORE_THAN_1_NO, String p_ADC_CALLBOOK_OPENING_NO,
			String p_ADC_CALLBOOK_OPENING_AMT, String p_ADC_CALLBOOK_RECEIPT_NO, String p_ADC_CALLBOOK_RECEIPT_AMT,
			String p_ADC_CALLBOOK_DISPOSAL_NO, String p_ADC_CALLBOOK_DISPOSAL_AMT, String p_ADC_CALLBOOK_OIO_NO,
			String p_ADC_CALLBOOK_OIO_AMT, String p_ADC_CALLBOOK_AGE_LESS_3_NO, String p_ADC_CALLBOOK_AGE_3_TO_6_NO,
			String p_ADC_CALLBOOK_AGE_6_TO_12_NO, String p_ADC_CALLBOOK_AGE_MORE_THAN_1_NO,
			String p_ADC_CALLBOOK_TIME_LESS_3_NO, String p_ADC_CALLBOOK_TIME_3_TO_6_NO,
			String p_ADC_CALLBOOK_TIME_6_TO_12_NO, String p_ADC_CALLBOOK_TIME_MORE_THAN_1_NO,
			String p_DC_COMMISSIONERATE_OPENING_NO, String p_DC_COMMISSIONERATE_OPENING_AMT,
			String p_DC_COMMISSIONERATE_RECEIPT_NO, String p_DC_COMMISSIONERATE_RECEIPT_AMT,
			String p_DC_COMMISSIONERATE_DISPOSAL_NO, String p_DC_COMMISSIONERATE_DISPOSAL_AMT,
			String p_DC_COMMISSIONERATE_OIO_NO, String p_DC_COMMISSIONERATE_OIO_AMT,
			String p_DC_COMMISSIONERATE_AGE_LESS_3_NO, String p_DC_COMMISSIONERATE_AGE_3_TO_6_NO,
			String p_DC_COMMISSIONERATE_AGE_6_TO_12_NO, String p_DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String p_DC_COMMISSIONERATE_TIME_LESS_3_NO, String p_DC_COMMISSIONERATE_TIME_3_TO_6_NO,
			String p_DC_COMMISSIONERATE_TIME_6_TO_12_NO, String p_DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO,
			String p_DC_AUDIT_OPENING_NO, String p_DC_AUDIT_OPENING_AMT, String p_DC_AUDIT_RECEIPT_NO,
			String p_DC_AUDIT_RECEIPT_AMT, String p_DC_AUDIT_DISPOSAL_NO, String p_DC_AUDIT_DISPOSAL_AMT,
			String p_DC_AUDIT_OIO_NO, String p_DC_AUDIT_OIO_AMT, String p_DC_AUDIT_AGE_LESS_3_NO,
			String p_DC_AUDIT_AGE_3_TO_6_NO, String p_DC_AUDIT_AGE_6_TO_12_NO, String p_DC_AUDIT_AGE_MORE_THAN_1_NO,
			String p_DC_AUDIT_TIME_LESS_3_NO, String p_DC_AUDIT_TIME_3_TO_6_NO, String p_DC_AUDIT_TIME_6_TO_12_NO,
			String p_DC_AUDIT_TIME_MORE_THAN_1_NO, String p_DC_INVESTIGATION_OPENING_NO,
			String p_DC_INVESTIGATION_OPENING_AMT, String p_DC_INVESTIGATION_RECEIPT_NO,
			String p_DC_INVESTIGATION_RECEIPT_AMT, String p_DC_INVESTIGATION_DISPOSAL_NO,
			String p_DC_INVESTIGATION_DISPOSAL_AMT, String p_DC_INVESTIGATION_OIO_NO, String p_DC_INVESTIGATION_OIO_AMT,
			String p_DC_INVESTIGATION_AGE_LESS_3_NO, String p_DC_INVESTIGATION_AGE_3_TO_6_NO,
			String p_DC_INVESTIGATION_AGE_6_TO_12_NO, String p_DC_INVESTIGATION_AGE_MORE_THAN_1_NO,
			String p_DC_INVESTIGATION_TIME_LESS_3_NO, String p_DC_INVESTIGATION_TIME_3_TO_6_NO,
			String p_DC_INVESTIGATION_TIME_6_TO_12_NO, String p_DC_INVESTIGATION_TIME_MORE_THAN_1_NO,
			String p_DC_CALLBOOK_OPENING_NO, String p_DC_CALLBOOK_OPENING_AMT, String p_DC_CALLBOOK_RECEIPT_NO,
			String p_DC_CALLBOOK_RECEIPT_AMT, String p_DC_CALLBOOK_DISPOSAL_NO, String p_DC_CALLBOOK_DISPOSAL_AMT,
			String p_DC_CALLBOOK_OIO_NO, String p_DC_CALLBOOK_OIO_AMT, String p_DC_CALLBOOK_AGE_LESS_3_NO,
			String p_DC_CALLBOOK_AGE_3_TO_6_NO, String p_DC_CALLBOOK_AGE_6_TO_12_NO,
			String p_DC_CALLBOOK_AGE_MORE_THAN_1_NO, String p_DC_CALLBOOK_TIME_LESS_3_NO,
			String p_DC_CALLBOOK_TIME_3_TO_6_NO, String p_DC_CALLBOOK_TIME_6_TO_12_NO,
			String p_DC_CALLBOOK_TIME_MORE_THAN_1_NO, String p_SUPERINTENDENT_COMMISSIONERATE_OPENING_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT, String p_SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT, String p_SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT, String p_SUPERINTENDENT_COMMISSIONERATE_OIO_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_OIO_AMT, String p_SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO, String p_SUPERINTENDENT_AUDIT_OPENING_NO,
			String p_SUPERINTENDENT_AUDIT_OPENING_AMT, String p_SUPERINTENDENT_AUDIT_RECEIPT_NO,
			String p_SUPERINTENDENT_AUDIT_RECEIPT_AMT, String p_SUPERINTENDENT_AUDIT_DISPOSAL_NO,
			String p_SUPERINTENDENT_AUDIT_DISPOSAL_AMT, String p_SUPERINTENDENT_AUDIT_OIO_NO,
			String p_SUPERINTENDENT_AUDIT_OIO_AMT, String p_SUPERINTENDENT_AUDIT_AGE_LESS_3_NO,
			String p_SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO, String p_SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO,
			String p_SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO, String p_SUPERINTENDENT_AUDIT_TIME_LESS_3_NO,
			String p_SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO, String p_SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO,
			String p_SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO, String p_SUPERINTENDENT_INVESTIGATION_OPENING_NO,
			String p_SUPERINTENDENT_INVESTIGATION_OPENING_AMT, String p_SUPERINTENDENT_INVESTIGATION_RECEIPT_NO,
			String p_SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT, String p_SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO,
			String p_SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT, String p_SUPERINTENDENT_INVESTIGATION_OIO_NO,
			String p_SUPERINTENDENT_INVESTIGATION_OIO_AMT, String p_SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO,
			String p_SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO, String p_SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO,
			String p_SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO,
			String p_SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO, String p_SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO,
			String p_SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO,
			String p_SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO, String p_SUPERINTENDENT_CALLBOOK_OPENING_NO,
			String p_SUPERINTENDENT_CALLBOOK_OPENING_AMT, String p_SUPERINTENDENT_CALLBOOK_RECEIPT_NO,
			String p_SUPERINTENDENT_CALLBOOK_RECEIPT_AMT, String p_SUPERINTENDENT_CALLBOOK_DISPOSAL_NO,
			String p_SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT, String p_SUPERINTENDENT_CALLBOOK_OIO_NO,
			String p_SUPERINTENDENT_CALLBOOK_OIO_AMT, String p_SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO,
			String p_SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO, String p_SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO,
			String p_SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO, String p_SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO,
			String p_SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO, String p_SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO,
			String p_SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO, String p_CRR) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_1_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_ADC_COMMISSIONERATE_OPENING_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_ADC_COMMISSIONERATE_OPENING_AMT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_ADC_COMMISSIONERATE_RECEIPT_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_ADC_COMMISSIONERATE_RECEIPT_AMT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_ADC_COMMISSIONERATE_DISPOSAL_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_ADC_COMMISSIONERATE_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_ADC_COMMISSIONERATE_OIO_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_ADC_COMMISSIONERATE_OIO_AMT);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_ADC_COMMISSIONERATE_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_ADC_COMMISSIONERATE_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_ADC_COMMISSIONERATE_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, p_ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, p_ADC_COMMISSIONERATE_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, p_ADC_COMMISSIONERATE_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, p_ADC_COMMISSIONERATE_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, p_ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, p_ADC_AUDIT_OPENING_NO);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, p_ADC_AUDIT_OPENING_AMT);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, p_ADC_AUDIT_RECEIPT_NO);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, p_ADC_AUDIT_RECEIPT_AMT);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, p_ADC_AUDIT_DISPOSAL_NO);
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, p_ADC_AUDIT_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, p_ADC_AUDIT_OIO_NO);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, p_ADC_AUDIT_OIO_AMT);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		query.setParameter(27, p_ADC_AUDIT_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		query.setParameter(28, p_ADC_AUDIT_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
		query.setParameter(29, p_ADC_AUDIT_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.IN);
		query.setParameter(30, p_ADC_AUDIT_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(31, String.class, ParameterMode.IN);
		query.setParameter(31, p_ADC_AUDIT_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(32, String.class, ParameterMode.IN);
		query.setParameter(32, p_ADC_AUDIT_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(33, String.class, ParameterMode.IN);
		query.setParameter(33, p_ADC_AUDIT_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(34, String.class, ParameterMode.IN);
		query.setParameter(34, p_ADC_AUDIT_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(35, String.class, ParameterMode.IN);
		query.setParameter(35, p_ADC_INVESTIGATION_OPENING_NO);
		query.registerStoredProcedureParameter(36, String.class, ParameterMode.IN);
		query.setParameter(36, p_ADC_INVESTIGATION_OPENING_AMT);
		query.registerStoredProcedureParameter(37, String.class, ParameterMode.IN);
		query.setParameter(37, p_ADC_INVESTIGATION_RECEIPT_NO);
		query.registerStoredProcedureParameter(38, String.class, ParameterMode.IN);
		query.setParameter(38, p_ADC_INVESTIGATION_RECEIPT_AMT);
		query.registerStoredProcedureParameter(39, String.class, ParameterMode.IN);
		query.setParameter(39, p_ADC_INVESTIGATION_DISPOSAL_NO);
		query.registerStoredProcedureParameter(40, String.class, ParameterMode.IN);
		query.setParameter(40, p_ADC_INVESTIGATION_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(41, String.class, ParameterMode.IN);
		query.setParameter(41, p_ADC_INVESTIGATION_OIO_NO);
		query.registerStoredProcedureParameter(42, String.class, ParameterMode.IN);
		query.setParameter(42, p_ADC_INVESTIGATION_OIO_AMT);
		query.registerStoredProcedureParameter(43, String.class, ParameterMode.IN);
		query.setParameter(43, p_ADC_INVESTIGATION_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(44, String.class, ParameterMode.IN);
		query.setParameter(44, p_ADC_INVESTIGATION_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(45, String.class, ParameterMode.IN);
		query.setParameter(45, p_ADC_INVESTIGATION_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(46, String.class, ParameterMode.IN);
		query.setParameter(46, p_ADC_INVESTIGATION_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(47, String.class, ParameterMode.IN);
		query.setParameter(47, p_ADC_INVESTIGATION_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(48, String.class, ParameterMode.IN);
		query.setParameter(48, p_ADC_INVESTIGATION_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(49, String.class, ParameterMode.IN);
		query.setParameter(49, p_ADC_INVESTIGATION_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(50, String.class, ParameterMode.IN);
		query.setParameter(50, p_ADC_INVESTIGATION_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(51, String.class, ParameterMode.IN);
		query.setParameter(51, p_ADC_CALLBOOK_OPENING_NO);
		query.registerStoredProcedureParameter(52, String.class, ParameterMode.IN);
		query.setParameter(52, p_ADC_CALLBOOK_OPENING_AMT);
		query.registerStoredProcedureParameter(53, String.class, ParameterMode.IN);
		query.setParameter(53, p_ADC_CALLBOOK_RECEIPT_NO);
		query.registerStoredProcedureParameter(54, String.class, ParameterMode.IN);
		query.setParameter(54, p_ADC_CALLBOOK_RECEIPT_AMT);
		query.registerStoredProcedureParameter(55, String.class, ParameterMode.IN);
		query.setParameter(55, p_ADC_CALLBOOK_DISPOSAL_NO);
		query.registerStoredProcedureParameter(56, String.class, ParameterMode.IN);
		query.setParameter(56, p_ADC_CALLBOOK_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(57, String.class, ParameterMode.IN);
		query.setParameter(57, p_ADC_CALLBOOK_OIO_NO);
		query.registerStoredProcedureParameter(58, String.class, ParameterMode.IN);
		query.setParameter(58, p_ADC_CALLBOOK_OIO_AMT);
		query.registerStoredProcedureParameter(59, String.class, ParameterMode.IN);
		query.setParameter(59, p_ADC_CALLBOOK_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(60, String.class, ParameterMode.IN);
		query.setParameter(60, p_ADC_CALLBOOK_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(61, String.class, ParameterMode.IN);
		query.setParameter(61, p_ADC_CALLBOOK_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(62, String.class, ParameterMode.IN);
		query.setParameter(62, p_ADC_CALLBOOK_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(63, String.class, ParameterMode.IN);
		query.setParameter(63, p_ADC_CALLBOOK_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(64, String.class, ParameterMode.IN);
		query.setParameter(64, p_ADC_CALLBOOK_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(65, String.class, ParameterMode.IN);
		query.setParameter(65, p_ADC_CALLBOOK_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(66, String.class, ParameterMode.IN);
		query.setParameter(66, p_ADC_CALLBOOK_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(67, String.class, ParameterMode.IN);
		query.setParameter(67, p_DC_COMMISSIONERATE_OPENING_NO);
		query.registerStoredProcedureParameter(68, String.class, ParameterMode.IN);
		query.setParameter(68, p_DC_COMMISSIONERATE_OPENING_AMT);
		query.registerStoredProcedureParameter(69, String.class, ParameterMode.IN);
		query.setParameter(69, p_DC_COMMISSIONERATE_RECEIPT_NO);
		query.registerStoredProcedureParameter(70, String.class, ParameterMode.IN);
		query.setParameter(70, p_DC_COMMISSIONERATE_RECEIPT_AMT);
		query.registerStoredProcedureParameter(71, String.class, ParameterMode.IN);
		query.setParameter(71, p_DC_COMMISSIONERATE_DISPOSAL_NO);
		query.registerStoredProcedureParameter(72, String.class, ParameterMode.IN);
		query.setParameter(72, p_DC_COMMISSIONERATE_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(73, String.class, ParameterMode.IN);
		query.setParameter(73, p_DC_COMMISSIONERATE_OIO_NO);
		query.registerStoredProcedureParameter(74, String.class, ParameterMode.IN);
		query.setParameter(74, p_DC_COMMISSIONERATE_OIO_AMT);
		query.registerStoredProcedureParameter(75, String.class, ParameterMode.IN);
		query.setParameter(75, p_DC_COMMISSIONERATE_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(76, String.class, ParameterMode.IN);
		query.setParameter(76, p_DC_COMMISSIONERATE_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(77, String.class, ParameterMode.IN);
		query.setParameter(77, p_DC_COMMISSIONERATE_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(78, String.class, ParameterMode.IN);
		query.setParameter(78, p_DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(79, String.class, ParameterMode.IN);
		query.setParameter(79, p_DC_COMMISSIONERATE_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(80, String.class, ParameterMode.IN);
		query.setParameter(80, p_DC_COMMISSIONERATE_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(81, String.class, ParameterMode.IN);
		query.setParameter(81, p_DC_COMMISSIONERATE_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(82, String.class, ParameterMode.IN);
		query.setParameter(82, p_DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(83, String.class, ParameterMode.IN);
		query.setParameter(83, p_DC_AUDIT_OPENING_NO);
		query.registerStoredProcedureParameter(84, String.class, ParameterMode.IN);
		query.setParameter(84, p_DC_AUDIT_OPENING_AMT);
		query.registerStoredProcedureParameter(85, String.class, ParameterMode.IN);
		query.setParameter(85, p_DC_AUDIT_RECEIPT_NO);
		query.registerStoredProcedureParameter(86, String.class, ParameterMode.IN);
		query.setParameter(86, p_DC_AUDIT_RECEIPT_AMT);
		query.registerStoredProcedureParameter(87, String.class, ParameterMode.IN);
		query.setParameter(87, p_DC_AUDIT_DISPOSAL_NO);
		query.registerStoredProcedureParameter(88, String.class, ParameterMode.IN);
		query.setParameter(88, p_DC_AUDIT_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(89, String.class, ParameterMode.IN);
		query.setParameter(89, p_DC_AUDIT_OIO_NO);
		query.registerStoredProcedureParameter(90, String.class, ParameterMode.IN);
		query.setParameter(90, p_DC_AUDIT_OIO_AMT);
		query.registerStoredProcedureParameter(91, String.class, ParameterMode.IN);
		query.setParameter(91, p_DC_AUDIT_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(92, String.class, ParameterMode.IN);
		query.setParameter(92, p_DC_AUDIT_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(93, String.class, ParameterMode.IN);
		query.setParameter(93, p_DC_AUDIT_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(94, String.class, ParameterMode.IN);
		query.setParameter(94, p_DC_AUDIT_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(95, String.class, ParameterMode.IN);
		query.setParameter(95, p_DC_AUDIT_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(96, String.class, ParameterMode.IN);
		query.setParameter(96, p_DC_AUDIT_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(97, String.class, ParameterMode.IN);
		query.setParameter(97, p_DC_AUDIT_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(98, String.class, ParameterMode.IN);
		query.setParameter(98, p_DC_AUDIT_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(99, String.class, ParameterMode.IN);
		query.setParameter(99, p_DC_INVESTIGATION_OPENING_NO);
		query.registerStoredProcedureParameter(100, String.class, ParameterMode.IN);
		query.setParameter(100, p_DC_INVESTIGATION_OPENING_AMT);
		query.registerStoredProcedureParameter(101, String.class, ParameterMode.IN);
		query.setParameter(101, p_DC_INVESTIGATION_RECEIPT_NO);
		query.registerStoredProcedureParameter(102, String.class, ParameterMode.IN);
		query.setParameter(102, p_DC_INVESTIGATION_RECEIPT_AMT);
		query.registerStoredProcedureParameter(103, String.class, ParameterMode.IN);
		query.setParameter(103, p_DC_INVESTIGATION_DISPOSAL_NO);
		query.registerStoredProcedureParameter(104, String.class, ParameterMode.IN);
		query.setParameter(104, p_DC_INVESTIGATION_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(105, String.class, ParameterMode.IN);
		query.setParameter(105, p_DC_INVESTIGATION_OIO_NO);
		query.registerStoredProcedureParameter(106, String.class, ParameterMode.IN);
		query.setParameter(106, p_DC_INVESTIGATION_OIO_AMT);
		query.registerStoredProcedureParameter(107, String.class, ParameterMode.IN);
		query.setParameter(107, p_DC_INVESTIGATION_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(108, String.class, ParameterMode.IN);
		query.setParameter(108, p_DC_INVESTIGATION_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(109, String.class, ParameterMode.IN);
		query.setParameter(109, p_DC_INVESTIGATION_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(110, String.class, ParameterMode.IN);
		query.setParameter(110, p_DC_INVESTIGATION_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(111, String.class, ParameterMode.IN);
		query.setParameter(111, p_DC_INVESTIGATION_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(112, String.class, ParameterMode.IN);
		query.setParameter(112, p_DC_INVESTIGATION_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(113, String.class, ParameterMode.IN);
		query.setParameter(113, p_DC_INVESTIGATION_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(114, String.class, ParameterMode.IN);
		query.setParameter(114, p_DC_INVESTIGATION_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(115, String.class, ParameterMode.IN);
		query.setParameter(115, p_DC_CALLBOOK_OPENING_NO);
		query.registerStoredProcedureParameter(116, String.class, ParameterMode.IN);
		query.setParameter(116, p_DC_CALLBOOK_OPENING_AMT);
		query.registerStoredProcedureParameter(117, String.class, ParameterMode.IN);
		query.setParameter(117, p_DC_CALLBOOK_RECEIPT_NO);
		query.registerStoredProcedureParameter(118, String.class, ParameterMode.IN);
		query.setParameter(118, p_DC_CALLBOOK_RECEIPT_AMT);
		query.registerStoredProcedureParameter(119, String.class, ParameterMode.IN);
		query.setParameter(119, p_DC_CALLBOOK_DISPOSAL_NO);
		query.registerStoredProcedureParameter(120, String.class, ParameterMode.IN);
		query.setParameter(120, p_DC_CALLBOOK_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(121, String.class, ParameterMode.IN);
		query.setParameter(121, p_DC_CALLBOOK_OIO_NO);
		query.registerStoredProcedureParameter(122, String.class, ParameterMode.IN);
		query.setParameter(122, p_DC_CALLBOOK_OIO_AMT);
		query.registerStoredProcedureParameter(123, String.class, ParameterMode.IN);
		query.setParameter(123, p_DC_CALLBOOK_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(124, String.class, ParameterMode.IN);
		query.setParameter(124, p_DC_CALLBOOK_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(125, String.class, ParameterMode.IN);
		query.setParameter(125, p_DC_CALLBOOK_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(126, String.class, ParameterMode.IN);
		query.setParameter(126, p_DC_CALLBOOK_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(127, String.class, ParameterMode.IN);
		query.setParameter(127, p_DC_CALLBOOK_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(128, String.class, ParameterMode.IN);
		query.setParameter(128, p_DC_CALLBOOK_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(129, String.class, ParameterMode.IN);
		query.setParameter(129, p_DC_CALLBOOK_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(130, String.class, ParameterMode.IN);
		query.setParameter(130, p_DC_CALLBOOK_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(131, String.class, ParameterMode.IN);
		query.setParameter(131, p_SUPERINTENDENT_COMMISSIONERATE_OPENING_NO);
		query.registerStoredProcedureParameter(132, String.class, ParameterMode.IN);
		query.setParameter(132, p_SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT);
		query.registerStoredProcedureParameter(133, String.class, ParameterMode.IN);
		query.setParameter(133, p_SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO);
		query.registerStoredProcedureParameter(134, String.class, ParameterMode.IN);
		query.setParameter(134, p_SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT);
		query.registerStoredProcedureParameter(135, String.class, ParameterMode.IN);
		query.setParameter(135, p_SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO);
		query.registerStoredProcedureParameter(136, String.class, ParameterMode.IN);
		query.setParameter(136, p_SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(137, String.class, ParameterMode.IN);
		query.setParameter(137, p_SUPERINTENDENT_COMMISSIONERATE_OIO_NO);
		query.registerStoredProcedureParameter(138, String.class, ParameterMode.IN);
		query.setParameter(138, p_SUPERINTENDENT_COMMISSIONERATE_OIO_AMT);
		query.registerStoredProcedureParameter(139, String.class, ParameterMode.IN);
		query.setParameter(139, p_SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(140, String.class, ParameterMode.IN);
		query.setParameter(140, p_SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(141, String.class, ParameterMode.IN);
		query.setParameter(141, p_SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(142, String.class, ParameterMode.IN);
		query.setParameter(142, p_SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(143, String.class, ParameterMode.IN);
		query.setParameter(143, p_SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(144, String.class, ParameterMode.IN);
		query.setParameter(144, p_SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(145, String.class, ParameterMode.IN);
		query.setParameter(145, p_SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(146, String.class, ParameterMode.IN);
		query.setParameter(146, p_SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(147, String.class, ParameterMode.IN);
		query.setParameter(147, p_SUPERINTENDENT_AUDIT_OPENING_NO);
		query.registerStoredProcedureParameter(148, String.class, ParameterMode.IN);
		query.setParameter(148, p_SUPERINTENDENT_AUDIT_OPENING_AMT);
		query.registerStoredProcedureParameter(149, String.class, ParameterMode.IN);
		query.setParameter(149, p_SUPERINTENDENT_AUDIT_RECEIPT_NO);
		query.registerStoredProcedureParameter(150, String.class, ParameterMode.IN);
		query.setParameter(150, p_SUPERINTENDENT_AUDIT_RECEIPT_AMT);
		query.registerStoredProcedureParameter(151, String.class, ParameterMode.IN);
		query.setParameter(151, p_SUPERINTENDENT_AUDIT_DISPOSAL_NO);
		query.registerStoredProcedureParameter(152, String.class, ParameterMode.IN);
		query.setParameter(152, p_SUPERINTENDENT_AUDIT_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(153, String.class, ParameterMode.IN);
		query.setParameter(153, p_SUPERINTENDENT_AUDIT_OIO_NO);
		query.registerStoredProcedureParameter(154, String.class, ParameterMode.IN);
		query.setParameter(154, p_SUPERINTENDENT_AUDIT_OIO_AMT);
		query.registerStoredProcedureParameter(155, String.class, ParameterMode.IN);
		query.setParameter(155, p_SUPERINTENDENT_AUDIT_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(156, String.class, ParameterMode.IN);
		query.setParameter(156, p_SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(157, String.class, ParameterMode.IN);
		query.setParameter(157, p_SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(158, String.class, ParameterMode.IN);
		query.setParameter(158, p_SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(159, String.class, ParameterMode.IN);
		query.setParameter(159, p_SUPERINTENDENT_AUDIT_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(160, String.class, ParameterMode.IN);
		query.setParameter(160, p_SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(161, String.class, ParameterMode.IN);
		query.setParameter(161, p_SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(162, String.class, ParameterMode.IN);
		query.setParameter(162, p_SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(163, String.class, ParameterMode.IN);
		query.setParameter(163, p_SUPERINTENDENT_INVESTIGATION_OPENING_NO);
		query.registerStoredProcedureParameter(164, String.class, ParameterMode.IN);
		query.setParameter(164, p_SUPERINTENDENT_INVESTIGATION_OPENING_AMT);
		query.registerStoredProcedureParameter(165, String.class, ParameterMode.IN);
		query.setParameter(165, p_SUPERINTENDENT_INVESTIGATION_RECEIPT_NO);
		query.registerStoredProcedureParameter(166, String.class, ParameterMode.IN);
		query.setParameter(166, p_SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT);
		query.registerStoredProcedureParameter(167, String.class, ParameterMode.IN);
		query.setParameter(167, p_SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO);
		query.registerStoredProcedureParameter(168, String.class, ParameterMode.IN);
		query.setParameter(168, p_SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(169, String.class, ParameterMode.IN);
		query.setParameter(169, p_SUPERINTENDENT_INVESTIGATION_OIO_NO);
		query.registerStoredProcedureParameter(170, String.class, ParameterMode.IN);
		query.setParameter(170, p_SUPERINTENDENT_INVESTIGATION_OIO_AMT);
		query.registerStoredProcedureParameter(171, String.class, ParameterMode.IN);
		query.setParameter(171, p_SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(172, String.class, ParameterMode.IN);
		query.setParameter(172, p_SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(173, String.class, ParameterMode.IN);
		query.setParameter(173, p_SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(174, String.class, ParameterMode.IN);
		query.setParameter(174, p_SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(175, String.class, ParameterMode.IN);
		query.setParameter(175, p_SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(176, String.class, ParameterMode.IN);
		query.setParameter(176, p_SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(177, String.class, ParameterMode.IN);
		query.setParameter(177, p_SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(178, String.class, ParameterMode.IN);
		query.setParameter(178, p_SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(179, String.class, ParameterMode.IN);
		query.setParameter(179, p_SUPERINTENDENT_CALLBOOK_OPENING_NO);
		query.registerStoredProcedureParameter(180, String.class, ParameterMode.IN);
		query.setParameter(180, p_SUPERINTENDENT_CALLBOOK_OPENING_AMT);
		query.registerStoredProcedureParameter(181, String.class, ParameterMode.IN);
		query.setParameter(181, p_SUPERINTENDENT_CALLBOOK_RECEIPT_NO);
		query.registerStoredProcedureParameter(182, String.class, ParameterMode.IN);
		query.setParameter(182, p_SUPERINTENDENT_CALLBOOK_RECEIPT_AMT);
		query.registerStoredProcedureParameter(183, String.class, ParameterMode.IN);
		query.setParameter(183, p_SUPERINTENDENT_CALLBOOK_DISPOSAL_NO);
		query.registerStoredProcedureParameter(184, String.class, ParameterMode.IN);
		query.setParameter(184, p_SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(185, String.class, ParameterMode.IN);
		query.setParameter(185, p_SUPERINTENDENT_CALLBOOK_OIO_NO);
		query.registerStoredProcedureParameter(186, String.class, ParameterMode.IN);
		query.setParameter(186, p_SUPERINTENDENT_CALLBOOK_OIO_AMT);
		query.registerStoredProcedureParameter(187, String.class, ParameterMode.IN);
		query.setParameter(187, p_SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(188, String.class, ParameterMode.IN);
		query.setParameter(188, p_SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(189, String.class, ParameterMode.IN);
		query.setParameter(189, p_SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(190, String.class, ParameterMode.IN);
		query.setParameter(190, p_SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(191, String.class, ParameterMode.IN);
		query.setParameter(191, p_SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(192, String.class, ParameterMode.IN);
		query.setParameter(192, p_SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(193, String.class, ParameterMode.IN);
		query.setParameter(193, p_SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(194, String.class, ParameterMode.IN);
		query.setParameter(194, p_SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO);

		query.registerStoredProcedureParameter(195, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(195, p_CRR);
		}

		query.registerStoredProcedureParameter(196, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(196).toString();
	}

	
	public String generateResult_SP_DPM_GST_ADJ_1_INSERT(String p_COMM_CODE, String p_MM_YYYY,
			String p_ADC_COMMISSIONERATE_OPENING_NO, String p_ADC_COMMISSIONERATE_OPENING_AMT,
			String p_ADC_COMMISSIONERATE_RECEIPT_NO, String p_ADC_COMMISSIONERATE_RECEIPT_AMT,
			String p_ADC_COMMISSIONERATE_DISPOSAL_NO, String p_ADC_COMMISSIONERATE_DISPOSAL_AMT,
			String p_ADC_COMMISSIONERATE_OIO_NO, String p_ADC_COMMISSIONERATE_OIO_AMT,
			String p_ADC_COMMISSIONERATE_AGE_LESS_3_NO, String p_ADC_COMMISSIONERATE_AGE_3_TO_6_NO,
			String p_ADC_COMMISSIONERATE_AGE_6_TO_12_NO, String p_ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String p_ADC_COMMISSIONERATE_TIME_LESS_3_NO, String p_ADC_COMMISSIONERATE_TIME_3_TO_6_NO,
			String p_ADC_COMMISSIONERATE_TIME_6_TO_12_NO, String p_ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO,
			String p_ADC_AUDIT_OPENING_NO, String p_ADC_AUDIT_OPENING_AMT, String p_ADC_AUDIT_RECEIPT_NO,
			String p_ADC_AUDIT_RECEIPT_AMT, String p_ADC_AUDIT_DISPOSAL_NO, String p_ADC_AUDIT_DISPOSAL_AMT,
			String p_ADC_AUDIT_OIO_NO, String p_ADC_AUDIT_OIO_AMT, String p_ADC_AUDIT_AGE_LESS_3_NO,
			String p_ADC_AUDIT_AGE_3_TO_6_NO, String p_ADC_AUDIT_AGE_6_TO_12_NO, String p_ADC_AUDIT_AGE_MORE_THAN_1_NO,
			String p_ADC_AUDIT_TIME_LESS_3_NO, String p_ADC_AUDIT_TIME_3_TO_6_NO, String p_ADC_AUDIT_TIME_6_TO_12_NO,
			String p_ADC_AUDIT_TIME_MORE_THAN_1_NO, String p_ADC_INVESTIGATION_OPENING_NO,
			String p_ADC_INVESTIGATION_OPENING_AMT, String p_ADC_INVESTIGATION_RECEIPT_NO,
			String p_ADC_INVESTIGATION_RECEIPT_AMT, String p_ADC_INVESTIGATION_DISPOSAL_NO,
			String p_ADC_INVESTIGATION_DISPOSAL_AMT, String p_ADC_INVESTIGATION_OIO_NO,
			String p_ADC_INVESTIGATION_OIO_AMT, String p_ADC_INVESTIGATION_AGE_LESS_3_NO,
			String p_ADC_INVESTIGATION_AGE_3_TO_6_NO, String p_ADC_INVESTIGATION_AGE_6_TO_12_NO,
			String p_ADC_INVESTIGATION_AGE_MORE_THAN_1_NO, String p_ADC_INVESTIGATION_TIME_LESS_3_NO,
			String p_ADC_INVESTIGATION_TIME_3_TO_6_NO, String p_ADC_INVESTIGATION_TIME_6_TO_12_NO,
			String p_ADC_INVESTIGATION_TIME_MORE_THAN_1_NO, String p_ADC_CALLBOOK_OPENING_NO,
			String p_ADC_CALLBOOK_OPENING_AMT, String p_ADC_CALLBOOK_RECEIPT_NO, String p_ADC_CALLBOOK_RECEIPT_AMT,
			String p_ADC_CALLBOOK_DISPOSAL_NO, String p_ADC_CALLBOOK_DISPOSAL_AMT, String p_ADC_CALLBOOK_OIO_NO,
			String p_ADC_CALLBOOK_OIO_AMT, String p_ADC_CALLBOOK_AGE_LESS_3_NO, String p_ADC_CALLBOOK_AGE_3_TO_6_NO,
			String p_ADC_CALLBOOK_AGE_6_TO_12_NO, String p_ADC_CALLBOOK_AGE_MORE_THAN_1_NO,
			String p_ADC_CALLBOOK_TIME_LESS_3_NO, String p_ADC_CALLBOOK_TIME_3_TO_6_NO,
			String p_ADC_CALLBOOK_TIME_6_TO_12_NO, String p_ADC_CALLBOOK_TIME_MORE_THAN_1_NO,
			String p_DC_COMMISSIONERATE_OPENING_NO, String p_DC_COMMISSIONERATE_OPENING_AMT,
			String p_DC_COMMISSIONERATE_RECEIPT_NO, String p_DC_COMMISSIONERATE_RECEIPT_AMT,
			String p_DC_COMMISSIONERATE_DISPOSAL_NO, String p_DC_COMMISSIONERATE_DISPOSAL_AMT,
			String p_DC_COMMISSIONERATE_OIO_NO, String p_DC_COMMISSIONERATE_OIO_AMT,
			String p_DC_COMMISSIONERATE_AGE_LESS_3_NO, String p_DC_COMMISSIONERATE_AGE_3_TO_6_NO,
			String p_DC_COMMISSIONERATE_AGE_6_TO_12_NO, String p_DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String p_DC_COMMISSIONERATE_TIME_LESS_3_NO, String p_DC_COMMISSIONERATE_TIME_3_TO_6_NO,
			String p_DC_COMMISSIONERATE_TIME_6_TO_12_NO, String p_DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO,
			String p_DC_AUDIT_OPENING_NO, String p_DC_AUDIT_OPENING_AMT, String p_DC_AUDIT_RECEIPT_NO,
			String p_DC_AUDIT_RECEIPT_AMT, String p_DC_AUDIT_DISPOSAL_NO, String p_DC_AUDIT_DISPOSAL_AMT,
			String p_DC_AUDIT_OIO_NO, String p_DC_AUDIT_OIO_AMT, String p_DC_AUDIT_AGE_LESS_3_NO,
			String p_DC_AUDIT_AGE_3_TO_6_NO, String p_DC_AUDIT_AGE_6_TO_12_NO, String p_DC_AUDIT_AGE_MORE_THAN_1_NO,
			String p_DC_AUDIT_TIME_LESS_3_NO, String p_DC_AUDIT_TIME_3_TO_6_NO, String p_DC_AUDIT_TIME_6_TO_12_NO,
			String p_DC_AUDIT_TIME_MORE_THAN_1_NO, String p_DC_INVESTIGATION_OPENING_NO,
			String p_DC_INVESTIGATION_OPENING_AMT, String p_DC_INVESTIGATION_RECEIPT_NO,
			String p_DC_INVESTIGATION_RECEIPT_AMT, String p_DC_INVESTIGATION_DISPOSAL_NO,
			String p_DC_INVESTIGATION_DISPOSAL_AMT, String p_DC_INVESTIGATION_OIO_NO, String p_DC_INVESTIGATION_OIO_AMT,
			String p_DC_INVESTIGATION_AGE_LESS_3_NO, String p_DC_INVESTIGATION_AGE_3_TO_6_NO,
			String p_DC_INVESTIGATION_AGE_6_TO_12_NO, String p_DC_INVESTIGATION_AGE_MORE_THAN_1_NO,
			String p_DC_INVESTIGATION_TIME_LESS_3_NO, String p_DC_INVESTIGATION_TIME_3_TO_6_NO,
			String p_DC_INVESTIGATION_TIME_6_TO_12_NO, String p_DC_INVESTIGATION_TIME_MORE_THAN_1_NO,
			String p_DC_CALLBOOK_OPENING_NO, String p_DC_CALLBOOK_OPENING_AMT, String p_DC_CALLBOOK_RECEIPT_NO,
			String p_DC_CALLBOOK_RECEIPT_AMT, String p_DC_CALLBOOK_DISPOSAL_NO, String p_DC_CALLBOOK_DISPOSAL_AMT,
			String p_DC_CALLBOOK_OIO_NO, String p_DC_CALLBOOK_OIO_AMT, String p_DC_CALLBOOK_AGE_LESS_3_NO,
			String p_DC_CALLBOOK_AGE_3_TO_6_NO, String p_DC_CALLBOOK_AGE_6_TO_12_NO,
			String p_DC_CALLBOOK_AGE_MORE_THAN_1_NO, String p_DC_CALLBOOK_TIME_LESS_3_NO,
			String p_DC_CALLBOOK_TIME_3_TO_6_NO, String p_DC_CALLBOOK_TIME_6_TO_12_NO,
			String p_DC_CALLBOOK_TIME_MORE_THAN_1_NO, String p_SUPERINTENDENT_COMMISSIONERATE_OPENING_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT, String p_SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT, String p_SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT, String p_SUPERINTENDENT_COMMISSIONERATE_OIO_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_OIO_AMT, String p_SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO,
			String p_SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO, String p_SUPERINTENDENT_AUDIT_OPENING_NO,
			String p_SUPERINTENDENT_AUDIT_OPENING_AMT, String p_SUPERINTENDENT_AUDIT_RECEIPT_NO,
			String p_SUPERINTENDENT_AUDIT_RECEIPT_AMT, String p_SUPERINTENDENT_AUDIT_DISPOSAL_NO,
			String p_SUPERINTENDENT_AUDIT_DISPOSAL_AMT, String p_SUPERINTENDENT_AUDIT_OIO_NO,
			String p_SUPERINTENDENT_AUDIT_OIO_AMT, String p_SUPERINTENDENT_AUDIT_AGE_LESS_3_NO,
			String p_SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO, String p_SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO,
			String p_SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO, String p_SUPERINTENDENT_AUDIT_TIME_LESS_3_NO,
			String p_SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO, String p_SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO,
			String p_SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO, String p_SUPERINTENDENT_INVESTIGATION_OPENING_NO,
			String p_SUPERINTENDENT_INVESTIGATION_OPENING_AMT, String p_SUPERINTENDENT_INVESTIGATION_RECEIPT_NO,
			String p_SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT, String p_SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO,
			String p_SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT, String p_SUPERINTENDENT_INVESTIGATION_OIO_NO,
			String p_SUPERINTENDENT_INVESTIGATION_OIO_AMT, String p_SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO,
			String p_SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO, String p_SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO,
			String p_SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO,
			String p_SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO, String p_SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO,
			String p_SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO,
			String p_SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO, String p_SUPERINTENDENT_CALLBOOK_OPENING_NO,
			String p_SUPERINTENDENT_CALLBOOK_OPENING_AMT, String p_SUPERINTENDENT_CALLBOOK_RECEIPT_NO,
			String p_SUPERINTENDENT_CALLBOOK_RECEIPT_AMT, String p_SUPERINTENDENT_CALLBOOK_DISPOSAL_NO,
			String p_SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT, String p_SUPERINTENDENT_CALLBOOK_OIO_NO,
			String p_SUPERINTENDENT_CALLBOOK_OIO_AMT, String p_SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO,
			String p_SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO, String p_SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO,
			String p_SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO, String p_SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO,
			String p_SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO, String p_SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO,
			String p_SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO, String p_CRR) {

		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_1_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_ADC_COMMISSIONERATE_OPENING_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_ADC_COMMISSIONERATE_OPENING_AMT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_ADC_COMMISSIONERATE_RECEIPT_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_ADC_COMMISSIONERATE_RECEIPT_AMT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_ADC_COMMISSIONERATE_DISPOSAL_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_ADC_COMMISSIONERATE_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_ADC_COMMISSIONERATE_OIO_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_ADC_COMMISSIONERATE_OIO_AMT);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_ADC_COMMISSIONERATE_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_ADC_COMMISSIONERATE_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_ADC_COMMISSIONERATE_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, p_ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, p_ADC_COMMISSIONERATE_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, p_ADC_COMMISSIONERATE_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, p_ADC_COMMISSIONERATE_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, p_ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, p_ADC_AUDIT_OPENING_NO);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, p_ADC_AUDIT_OPENING_AMT);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, p_ADC_AUDIT_RECEIPT_NO);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, p_ADC_AUDIT_RECEIPT_AMT);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, p_ADC_AUDIT_DISPOSAL_NO);
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, p_ADC_AUDIT_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, p_ADC_AUDIT_OIO_NO);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, p_ADC_AUDIT_OIO_AMT);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		query.setParameter(27, p_ADC_AUDIT_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		query.setParameter(28, p_ADC_AUDIT_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
		query.setParameter(29, p_ADC_AUDIT_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.IN);
		query.setParameter(30, p_ADC_AUDIT_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(31, String.class, ParameterMode.IN);
		query.setParameter(31, p_ADC_AUDIT_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(32, String.class, ParameterMode.IN);
		query.setParameter(32, p_ADC_AUDIT_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(33, String.class, ParameterMode.IN);
		query.setParameter(33, p_ADC_AUDIT_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(34, String.class, ParameterMode.IN);
		query.setParameter(34, p_ADC_AUDIT_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(35, String.class, ParameterMode.IN);
		query.setParameter(35, p_ADC_INVESTIGATION_OPENING_NO);
		query.registerStoredProcedureParameter(36, String.class, ParameterMode.IN);
		query.setParameter(36, p_ADC_INVESTIGATION_OPENING_AMT);
		query.registerStoredProcedureParameter(37, String.class, ParameterMode.IN);
		query.setParameter(37, p_ADC_INVESTIGATION_RECEIPT_NO);
		query.registerStoredProcedureParameter(38, String.class, ParameterMode.IN);
		query.setParameter(38, p_ADC_INVESTIGATION_RECEIPT_AMT);
		query.registerStoredProcedureParameter(39, String.class, ParameterMode.IN);
		query.setParameter(39, p_ADC_INVESTIGATION_DISPOSAL_NO);
		query.registerStoredProcedureParameter(40, String.class, ParameterMode.IN);
		query.setParameter(40, p_ADC_INVESTIGATION_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(41, String.class, ParameterMode.IN);
		query.setParameter(41, p_ADC_INVESTIGATION_OIO_NO);
		query.registerStoredProcedureParameter(42, String.class, ParameterMode.IN);
		query.setParameter(42, p_ADC_INVESTIGATION_OIO_AMT);
		query.registerStoredProcedureParameter(43, String.class, ParameterMode.IN);
		query.setParameter(43, p_ADC_INVESTIGATION_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(44, String.class, ParameterMode.IN);
		query.setParameter(44, p_ADC_INVESTIGATION_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(45, String.class, ParameterMode.IN);
		query.setParameter(45, p_ADC_INVESTIGATION_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(46, String.class, ParameterMode.IN);
		query.setParameter(46, p_ADC_INVESTIGATION_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(47, String.class, ParameterMode.IN);
		query.setParameter(47, p_ADC_INVESTIGATION_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(48, String.class, ParameterMode.IN);
		query.setParameter(48, p_ADC_INVESTIGATION_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(49, String.class, ParameterMode.IN);
		query.setParameter(49, p_ADC_INVESTIGATION_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(50, String.class, ParameterMode.IN);
		query.setParameter(50, p_ADC_INVESTIGATION_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(51, String.class, ParameterMode.IN);
		query.setParameter(51, p_ADC_CALLBOOK_OPENING_NO);
		query.registerStoredProcedureParameter(52, String.class, ParameterMode.IN);
		query.setParameter(52, p_ADC_CALLBOOK_OPENING_AMT);
		query.registerStoredProcedureParameter(53, String.class, ParameterMode.IN);
		query.setParameter(53, p_ADC_CALLBOOK_RECEIPT_NO);
		query.registerStoredProcedureParameter(54, String.class, ParameterMode.IN);
		query.setParameter(54, p_ADC_CALLBOOK_RECEIPT_AMT);
		query.registerStoredProcedureParameter(55, String.class, ParameterMode.IN);
		query.setParameter(55, p_ADC_CALLBOOK_DISPOSAL_NO);
		query.registerStoredProcedureParameter(56, String.class, ParameterMode.IN);
		query.setParameter(56, p_ADC_CALLBOOK_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(57, String.class, ParameterMode.IN);
		query.setParameter(57, p_ADC_CALLBOOK_OIO_NO);
		query.registerStoredProcedureParameter(58, String.class, ParameterMode.IN);
		query.setParameter(58, p_ADC_CALLBOOK_OIO_AMT);
		query.registerStoredProcedureParameter(59, String.class, ParameterMode.IN);
		query.setParameter(59, p_ADC_CALLBOOK_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(60, String.class, ParameterMode.IN);
		query.setParameter(60, p_ADC_CALLBOOK_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(61, String.class, ParameterMode.IN);
		query.setParameter(61, p_ADC_CALLBOOK_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(62, String.class, ParameterMode.IN);
		query.setParameter(62, p_ADC_CALLBOOK_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(63, String.class, ParameterMode.IN);
		query.setParameter(63, p_ADC_CALLBOOK_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(64, String.class, ParameterMode.IN);
		query.setParameter(64, p_ADC_CALLBOOK_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(65, String.class, ParameterMode.IN);
		query.setParameter(65, p_ADC_CALLBOOK_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(66, String.class, ParameterMode.IN);
		query.setParameter(66, p_ADC_CALLBOOK_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(67, String.class, ParameterMode.IN);
		query.setParameter(67, p_DC_COMMISSIONERATE_OPENING_NO);
		query.registerStoredProcedureParameter(68, String.class, ParameterMode.IN);
		query.setParameter(68, p_DC_COMMISSIONERATE_OPENING_AMT);
		query.registerStoredProcedureParameter(69, String.class, ParameterMode.IN);
		query.setParameter(69, p_DC_COMMISSIONERATE_RECEIPT_NO);
		query.registerStoredProcedureParameter(70, String.class, ParameterMode.IN);
		query.setParameter(70, p_DC_COMMISSIONERATE_RECEIPT_AMT);
		query.registerStoredProcedureParameter(71, String.class, ParameterMode.IN);
		query.setParameter(71, p_DC_COMMISSIONERATE_DISPOSAL_NO);
		query.registerStoredProcedureParameter(72, String.class, ParameterMode.IN);
		query.setParameter(72, p_DC_COMMISSIONERATE_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(73, String.class, ParameterMode.IN);
		query.setParameter(73, p_DC_COMMISSIONERATE_OIO_NO);
		query.registerStoredProcedureParameter(74, String.class, ParameterMode.IN);
		query.setParameter(74, p_DC_COMMISSIONERATE_OIO_AMT);
		query.registerStoredProcedureParameter(75, String.class, ParameterMode.IN);
		query.setParameter(75, p_DC_COMMISSIONERATE_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(76, String.class, ParameterMode.IN);
		query.setParameter(76, p_DC_COMMISSIONERATE_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(77, String.class, ParameterMode.IN);
		query.setParameter(77, p_DC_COMMISSIONERATE_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(78, String.class, ParameterMode.IN);
		query.setParameter(78, p_DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(79, String.class, ParameterMode.IN);
		query.setParameter(79, p_DC_COMMISSIONERATE_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(80, String.class, ParameterMode.IN);
		query.setParameter(80, p_DC_COMMISSIONERATE_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(81, String.class, ParameterMode.IN);
		query.setParameter(81, p_DC_COMMISSIONERATE_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(82, String.class, ParameterMode.IN);
		query.setParameter(82, p_DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(83, String.class, ParameterMode.IN);
		query.setParameter(83, p_DC_AUDIT_OPENING_NO);
		query.registerStoredProcedureParameter(84, String.class, ParameterMode.IN);
		query.setParameter(84, p_DC_AUDIT_OPENING_AMT);
		query.registerStoredProcedureParameter(85, String.class, ParameterMode.IN);
		query.setParameter(85, p_DC_AUDIT_RECEIPT_NO);
		query.registerStoredProcedureParameter(86, String.class, ParameterMode.IN);
		query.setParameter(86, p_DC_AUDIT_RECEIPT_AMT);
		query.registerStoredProcedureParameter(87, String.class, ParameterMode.IN);
		query.setParameter(87, p_DC_AUDIT_DISPOSAL_NO);
		query.registerStoredProcedureParameter(88, String.class, ParameterMode.IN);
		query.setParameter(88, p_DC_AUDIT_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(89, String.class, ParameterMode.IN);
		query.setParameter(89, p_DC_AUDIT_OIO_NO);
		query.registerStoredProcedureParameter(90, String.class, ParameterMode.IN);
		query.setParameter(90, p_DC_AUDIT_OIO_AMT);
		query.registerStoredProcedureParameter(91, String.class, ParameterMode.IN);
		query.setParameter(91, p_DC_AUDIT_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(92, String.class, ParameterMode.IN);
		query.setParameter(92, p_DC_AUDIT_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(93, String.class, ParameterMode.IN);
		query.setParameter(93, p_DC_AUDIT_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(94, String.class, ParameterMode.IN);
		query.setParameter(94, p_DC_AUDIT_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(95, String.class, ParameterMode.IN);
		query.setParameter(95, p_DC_AUDIT_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(96, String.class, ParameterMode.IN);
		query.setParameter(96, p_DC_AUDIT_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(97, String.class, ParameterMode.IN);
		query.setParameter(97, p_DC_AUDIT_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(98, String.class, ParameterMode.IN);
		query.setParameter(98, p_DC_AUDIT_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(99, String.class, ParameterMode.IN);
		query.setParameter(99, p_DC_INVESTIGATION_OPENING_NO);
		query.registerStoredProcedureParameter(100, String.class, ParameterMode.IN);
		query.setParameter(100, p_DC_INVESTIGATION_OPENING_AMT);
		query.registerStoredProcedureParameter(101, String.class, ParameterMode.IN);
		query.setParameter(101, p_DC_INVESTIGATION_RECEIPT_NO);
		query.registerStoredProcedureParameter(102, String.class, ParameterMode.IN);
		query.setParameter(102, p_DC_INVESTIGATION_RECEIPT_AMT);
		query.registerStoredProcedureParameter(103, String.class, ParameterMode.IN);
		query.setParameter(103, p_DC_INVESTIGATION_DISPOSAL_NO);
		query.registerStoredProcedureParameter(104, String.class, ParameterMode.IN);
		query.setParameter(104, p_DC_INVESTIGATION_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(105, String.class, ParameterMode.IN);
		query.setParameter(105, p_DC_INVESTIGATION_OIO_NO);
		query.registerStoredProcedureParameter(106, String.class, ParameterMode.IN);
		query.setParameter(106, p_DC_INVESTIGATION_OIO_AMT);
		query.registerStoredProcedureParameter(107, String.class, ParameterMode.IN);
		query.setParameter(107, p_DC_INVESTIGATION_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(108, String.class, ParameterMode.IN);
		query.setParameter(108, p_DC_INVESTIGATION_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(109, String.class, ParameterMode.IN);
		query.setParameter(109, p_DC_INVESTIGATION_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(110, String.class, ParameterMode.IN);
		query.setParameter(110, p_DC_INVESTIGATION_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(111, String.class, ParameterMode.IN);
		query.setParameter(111, p_DC_INVESTIGATION_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(112, String.class, ParameterMode.IN);
		query.setParameter(112, p_DC_INVESTIGATION_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(113, String.class, ParameterMode.IN);
		query.setParameter(113, p_DC_INVESTIGATION_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(114, String.class, ParameterMode.IN);
		query.setParameter(114, p_DC_INVESTIGATION_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(115, String.class, ParameterMode.IN);
		query.setParameter(115, p_DC_CALLBOOK_OPENING_NO);
		query.registerStoredProcedureParameter(116, String.class, ParameterMode.IN);
		query.setParameter(116, p_DC_CALLBOOK_OPENING_AMT);
		query.registerStoredProcedureParameter(117, String.class, ParameterMode.IN);
		query.setParameter(117, p_DC_CALLBOOK_RECEIPT_NO);
		query.registerStoredProcedureParameter(118, String.class, ParameterMode.IN);
		query.setParameter(118, p_DC_CALLBOOK_RECEIPT_AMT);
		query.registerStoredProcedureParameter(119, String.class, ParameterMode.IN);
		query.setParameter(119, p_DC_CALLBOOK_DISPOSAL_NO);
		query.registerStoredProcedureParameter(120, String.class, ParameterMode.IN);
		query.setParameter(120, p_DC_CALLBOOK_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(121, String.class, ParameterMode.IN);
		query.setParameter(121, p_DC_CALLBOOK_OIO_NO);
		query.registerStoredProcedureParameter(122, String.class, ParameterMode.IN);
		query.setParameter(122, p_DC_CALLBOOK_OIO_AMT);
		query.registerStoredProcedureParameter(123, String.class, ParameterMode.IN);
		query.setParameter(123, p_DC_CALLBOOK_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(124, String.class, ParameterMode.IN);
		query.setParameter(124, p_DC_CALLBOOK_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(125, String.class, ParameterMode.IN);
		query.setParameter(125, p_DC_CALLBOOK_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(126, String.class, ParameterMode.IN);
		query.setParameter(126, p_DC_CALLBOOK_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(127, String.class, ParameterMode.IN);
		query.setParameter(127, p_DC_CALLBOOK_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(128, String.class, ParameterMode.IN);
		query.setParameter(128, p_DC_CALLBOOK_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(129, String.class, ParameterMode.IN);
		query.setParameter(129, p_DC_CALLBOOK_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(130, String.class, ParameterMode.IN);
		query.setParameter(130, p_DC_CALLBOOK_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(131, String.class, ParameterMode.IN);
		query.setParameter(131, p_SUPERINTENDENT_COMMISSIONERATE_OPENING_NO);
		query.registerStoredProcedureParameter(132, String.class, ParameterMode.IN);
		query.setParameter(132, p_SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT);
		query.registerStoredProcedureParameter(133, String.class, ParameterMode.IN);
		query.setParameter(133, p_SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO);
		query.registerStoredProcedureParameter(134, String.class, ParameterMode.IN);
		query.setParameter(134, p_SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT);
		query.registerStoredProcedureParameter(135, String.class, ParameterMode.IN);
		query.setParameter(135, p_SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO);
		query.registerStoredProcedureParameter(136, String.class, ParameterMode.IN);
		query.setParameter(136, p_SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(137, String.class, ParameterMode.IN);
		query.setParameter(137, p_SUPERINTENDENT_COMMISSIONERATE_OIO_NO);
		query.registerStoredProcedureParameter(138, String.class, ParameterMode.IN);
		query.setParameter(138, p_SUPERINTENDENT_COMMISSIONERATE_OIO_AMT);
		query.registerStoredProcedureParameter(139, String.class, ParameterMode.IN);
		query.setParameter(139, p_SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(140, String.class, ParameterMode.IN);
		query.setParameter(140, p_SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(141, String.class, ParameterMode.IN);
		query.setParameter(141, p_SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(142, String.class, ParameterMode.IN);
		query.setParameter(142, p_SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(143, String.class, ParameterMode.IN);
		query.setParameter(143, p_SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(144, String.class, ParameterMode.IN);
		query.setParameter(144, p_SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(145, String.class, ParameterMode.IN);
		query.setParameter(145, p_SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(146, String.class, ParameterMode.IN);
		query.setParameter(146, p_SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(147, String.class, ParameterMode.IN);
		query.setParameter(147, p_SUPERINTENDENT_AUDIT_OPENING_NO);
		query.registerStoredProcedureParameter(148, String.class, ParameterMode.IN);
		query.setParameter(148, p_SUPERINTENDENT_AUDIT_OPENING_AMT);
		query.registerStoredProcedureParameter(149, String.class, ParameterMode.IN);
		query.setParameter(149, p_SUPERINTENDENT_AUDIT_RECEIPT_NO);
		query.registerStoredProcedureParameter(150, String.class, ParameterMode.IN);
		query.setParameter(150, p_SUPERINTENDENT_AUDIT_RECEIPT_AMT);
		query.registerStoredProcedureParameter(151, String.class, ParameterMode.IN);
		query.setParameter(151, p_SUPERINTENDENT_AUDIT_DISPOSAL_NO);
		query.registerStoredProcedureParameter(152, String.class, ParameterMode.IN);
		query.setParameter(152, p_SUPERINTENDENT_AUDIT_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(153, String.class, ParameterMode.IN);
		query.setParameter(153, p_SUPERINTENDENT_AUDIT_OIO_NO);
		query.registerStoredProcedureParameter(154, String.class, ParameterMode.IN);
		query.setParameter(154, p_SUPERINTENDENT_AUDIT_OIO_AMT);
		query.registerStoredProcedureParameter(155, String.class, ParameterMode.IN);
		query.setParameter(155, p_SUPERINTENDENT_AUDIT_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(156, String.class, ParameterMode.IN);
		query.setParameter(156, p_SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(157, String.class, ParameterMode.IN);
		query.setParameter(157, p_SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(158, String.class, ParameterMode.IN);
		query.setParameter(158, p_SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(159, String.class, ParameterMode.IN);
		query.setParameter(159, p_SUPERINTENDENT_AUDIT_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(160, String.class, ParameterMode.IN);
		query.setParameter(160, p_SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(161, String.class, ParameterMode.IN);
		query.setParameter(161, p_SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(162, String.class, ParameterMode.IN);
		query.setParameter(162, p_SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(163, String.class, ParameterMode.IN);
		query.setParameter(163, p_SUPERINTENDENT_INVESTIGATION_OPENING_NO);
		query.registerStoredProcedureParameter(164, String.class, ParameterMode.IN);
		query.setParameter(164, p_SUPERINTENDENT_INVESTIGATION_OPENING_AMT);
		query.registerStoredProcedureParameter(165, String.class, ParameterMode.IN);
		query.setParameter(165, p_SUPERINTENDENT_INVESTIGATION_RECEIPT_NO);
		query.registerStoredProcedureParameter(166, String.class, ParameterMode.IN);
		query.setParameter(166, p_SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT);
		query.registerStoredProcedureParameter(167, String.class, ParameterMode.IN);
		query.setParameter(167, p_SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO);
		query.registerStoredProcedureParameter(168, String.class, ParameterMode.IN);
		query.setParameter(168, p_SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(169, String.class, ParameterMode.IN);
		query.setParameter(169, p_SUPERINTENDENT_INVESTIGATION_OIO_NO);
		query.registerStoredProcedureParameter(170, String.class, ParameterMode.IN);
		query.setParameter(170, p_SUPERINTENDENT_INVESTIGATION_OIO_AMT);
		query.registerStoredProcedureParameter(171, String.class, ParameterMode.IN);
		query.setParameter(171, p_SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(172, String.class, ParameterMode.IN);
		query.setParameter(172, p_SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(173, String.class, ParameterMode.IN);
		query.setParameter(173, p_SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(174, String.class, ParameterMode.IN);
		query.setParameter(174, p_SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(175, String.class, ParameterMode.IN);
		query.setParameter(175, p_SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(176, String.class, ParameterMode.IN);
		query.setParameter(176, p_SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(177, String.class, ParameterMode.IN);
		query.setParameter(177, p_SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(178, String.class, ParameterMode.IN);
		query.setParameter(178, p_SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO);
		
		query.registerStoredProcedureParameter(179, String.class, ParameterMode.IN);
		query.setParameter(179, p_SUPERINTENDENT_CALLBOOK_OPENING_NO);
		query.registerStoredProcedureParameter(180, String.class, ParameterMode.IN);
		query.setParameter(180, p_SUPERINTENDENT_CALLBOOK_OPENING_AMT);
		query.registerStoredProcedureParameter(181, String.class, ParameterMode.IN);
		query.setParameter(181, p_SUPERINTENDENT_CALLBOOK_RECEIPT_NO);
		query.registerStoredProcedureParameter(182, String.class, ParameterMode.IN);
		query.setParameter(182, p_SUPERINTENDENT_CALLBOOK_RECEIPT_AMT);
		query.registerStoredProcedureParameter(183, String.class, ParameterMode.IN);
		query.setParameter(183, p_SUPERINTENDENT_CALLBOOK_DISPOSAL_NO);
		query.registerStoredProcedureParameter(184, String.class, ParameterMode.IN);
		query.setParameter(184, p_SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(185, String.class, ParameterMode.IN);
		query.setParameter(185, p_SUPERINTENDENT_CALLBOOK_OIO_NO);
		query.registerStoredProcedureParameter(186, String.class, ParameterMode.IN);
		query.setParameter(186, p_SUPERINTENDENT_CALLBOOK_OIO_AMT);
		query.registerStoredProcedureParameter(187, String.class, ParameterMode.IN);
		query.setParameter(187, p_SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO);
		query.registerStoredProcedureParameter(188, String.class, ParameterMode.IN);
		query.setParameter(188, p_SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO);
		query.registerStoredProcedureParameter(189, String.class, ParameterMode.IN);
		query.setParameter(189, p_SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(190, String.class, ParameterMode.IN);
		query.setParameter(190, p_SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(191, String.class, ParameterMode.IN);
		query.setParameter(191, p_SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO);
		query.registerStoredProcedureParameter(192, String.class, ParameterMode.IN);
		query.setParameter(192, p_SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO);
		query.registerStoredProcedureParameter(193, String.class, ParameterMode.IN);
		query.setParameter(193, p_SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO);
		query.registerStoredProcedureParameter(194, String.class, ParameterMode.IN);
		query.setParameter(194, p_SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO);
		query.registerStoredProcedureParameter(195, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(195).toString();
	}
	
	public String generateResult_SP_DPM_GST_ADJ_1_INSERT_OPENING(String p_COMM_CODE, String p_MM_YYYY,
			String p_ADC_COMMISSIONERATE_OPENING_NO, String p_ADC_COMMISSIONERATE_OPENING_AMT,
			String p_ADC_AUDIT_OPENING_NO, String p_ADC_AUDIT_OPENING_AMT,
			String p_ADC_INVESTIGATION_OPENING_NO,String p_ADC_INVESTIGATION_OPENING_AMT,
			String p_ADC_CALLBOOK_OPENING_NO, String p_ADC_CALLBOOK_OPENING_AMT,
			String p_DC_COMMISSIONERATE_OPENING_NO, String p_DC_COMMISSIONERATE_OPENING_AMT,
			String p_DC_AUDIT_OPENING_NO, String p_DC_AUDIT_OPENING_AMT, 
			String p_DC_INVESTIGATION_OPENING_NO,String p_DC_INVESTIGATION_OPENING_AMT, 
			String p_DC_CALLBOOK_OPENING_NO, String p_DC_CALLBOOK_OPENING_AMT,
			String p_SUPERINTENDENT_COMMISSIONERATE_OPENING_NO, String p_SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT,
			String p_SUPERINTENDENT_AUDIT_OPENING_NO,String p_SUPERINTENDENT_AUDIT_OPENING_AMT,
			String p_SUPERINTENDENT_INVESTIGATION_OPENING_NO, String p_SUPERINTENDENT_INVESTIGATION_OPENING_AMT,
			String p_SUPERINTENDENT_CALLBOOK_OPENING_NO, String p_SUPERINTENDENT_CALLBOOK_OPENING_AMT) {

		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_1_INSERT_OPENING");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_ADC_COMMISSIONERATE_OPENING_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_ADC_COMMISSIONERATE_OPENING_AMT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_ADC_AUDIT_OPENING_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_ADC_AUDIT_OPENING_AMT);
	
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_ADC_INVESTIGATION_OPENING_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_ADC_INVESTIGATION_OPENING_AMT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_ADC_CALLBOOK_OPENING_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_ADC_CALLBOOK_OPENING_AMT);
	
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_DC_COMMISSIONERATE_OPENING_NO);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_DC_COMMISSIONERATE_OPENING_AMT);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_DC_AUDIT_OPENING_NO);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, p_DC_AUDIT_OPENING_AMT);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, p_DC_INVESTIGATION_OPENING_NO);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, p_DC_INVESTIGATION_OPENING_AMT);
	
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, p_DC_CALLBOOK_OPENING_NO);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, p_DC_CALLBOOK_OPENING_AMT);
		
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, p_SUPERINTENDENT_COMMISSIONERATE_OPENING_NO);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, p_SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, p_SUPERINTENDENT_AUDIT_OPENING_NO);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, p_SUPERINTENDENT_AUDIT_OPENING_AMT);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, p_SUPERINTENDENT_INVESTIGATION_OPENING_NO);
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, p_SUPERINTENDENT_INVESTIGATION_OPENING_AMT);
		
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, p_SUPERINTENDENT_CALLBOOK_OPENING_NO);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, p_SUPERINTENDENT_CALLBOOK_OPENING_AMT);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(27).toString();
	}
}
