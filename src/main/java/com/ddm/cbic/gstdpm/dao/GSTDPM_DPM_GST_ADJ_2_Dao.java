package com.ddm.cbic.gstdpm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_ZONE_Result;


public interface GSTDPM_DPM_GST_ADJ_2_Dao {
	public Object generateResult_SP_DPM_GST_ADJ_2_MARCH_DATA_CHECK(String code);
	
	public List<SP_DPM_GST_ADJ_2_ALL_Result> generateResult_SP_DPM_GST_ADJ_2_ALL(String mm_yyyy);
	public List<SP_DPM_GST_ADJ_2_ZONE_Result> generateResult_SP_DPM_GST_ADJ_2_ZONE(String zone,
			String mm_yyyy);
	public List<SP_DPM_GST_ADJ_2_COMM_Result> generateResult_SP_DPM_GST_ADJ_2_COMM(String zone,
			String mm_yyyy);
	
	public Object generateResult_SP_DPM_GST_ADJ_2_MAX_DATE(String comm) ;
	public List<SP_DPM_GST_ADJ_2_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DPM_GST_ADJ_2_COMM_TEMP_REPORT(Object[] objArray) ;

	public List<SP_DPM_GST_ADJ_2_COMM_TEMP_Result> generateResultBeanList_SP_DPM_GST_ADJ_2_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request);
	
	
	
	public String generateResult_SP_DPM_GST_ADJ_2_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, 
			String p_OPENING_NO, String p_OPENING_AMT, String p_RECEIPT_NO,
			String p_RECEIPT_AMT, String p_RECEIPT_UPTO_NO, String p_RECEIPT_UPTO_AMT,
			String p_DISPOSAL_REVENUE_NO, String p_DISPOSAL_REVENUE_AMT,
			String p_DISPOSAL_TAXPAYER_NO, String p_DISPOSAL_TAXPAYER_AMT, String p_TOTAL_DISPOSAL_NO,
			String p_TOTAL_DISPOSAL_AMOUNT, String p_CLOSING_BALANCE_NO, String p_CLOSING_BALANCE_AMOUNT,
			String p_AGE_UPTO_6_NO, String p_AGE_6_TO_12_NO,String p_AGE_MORE_THAN_1_NO,
			String p_CRR);
	
	public String generateResult_SP_DPM_GST_ADJ_2_TEMP_INSERT(String p_COMM_CODE, String p_MM_YYYY, 
			String p_OPENING_NO, String p_OPENING_AMT, String p_RECEIPT_NO,
			String p_RECEIPT_AMT, String p_RECEIPT_UPTO_NO, String p_RECEIPT_UPTO_AMT,
			String p_DISPOSAL_REVENUE_NO, String p_DISPOSAL_REVENUE_AMT,
			String p_DISPOSAL_TAXPAYER_NO, String p_DISPOSAL_TAXPAYER_AMT, String p_TOTAL_DISPOSAL_NO,
			String p_TOTAL_DISPOSAL_AMOUNT, String p_CLOSING_BALANCE_NO, String p_CLOSING_BALANCE_AMOUNT,
			String p_AGE_UPTO_6_NO, String p_AGE_6_TO_12_NO,String p_AGE_MORE_THAN_1_NO,
			String p_CRR);
	
	
	public String generateResult_SP_DPM_GST_ADJ_2_INSERT_OPENING(String code, String mm_yyyy,
			String opening_BALANCE_NO,String opening_BALANCE_AMOUNT);
	
}
