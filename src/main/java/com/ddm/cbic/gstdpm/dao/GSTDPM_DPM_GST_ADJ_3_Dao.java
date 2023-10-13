package com.ddm.cbic.gstdpm.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_ZONE_Result;


public interface GSTDPM_DPM_GST_ADJ_3_Dao {
	public List<SP_DPM_GST_ADJ_3_ALL_Result> generateResult_SP_DPM_GST_ADJ_3_ALL(String mm_yyyy);
	public List<SP_DPM_GST_ADJ_3_ZONE_Result> generateResult_SP_DPM_GST_ADJ_3_ZONE(String zone,
			String mm_yyyy);
	public List<SP_DPM_GST_ADJ_3_COMM_Result> generateResult_SP_DPM_GST_ADJ_3_COMM(String zone,
			String mm_yyyy);
	
	public Object generateResult_SP_DPM_GST_ADJ_3_MAX_DATE(String comm) ;
	
	public List<SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT
	(Object[] objArray) ;
	
	
	public List<SP_DPM_GST_ADJ_3_COMM_TEMP_Result> generateResultBeanList_SP_DPM_GST_ADJ_3_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request);
	
	public String generateResult_SP_DPM_GST_ADJ_3_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, 
			String REASON_ID,String REASON_FOR_KEEPING_IN_CALL_BOOK,
			String ADC_OPENING_NO,String ADC_OPENING_AMT,String ADC_RECEIPT_NO,String ADC_RECEIPT_AMT,String ADC_DISPOSAL_NO,
			String ADC_DISPOSAL_AMT,String ADC_AGE_LESS_6_NO,String ADC_AGE_6_TO_12_NO,String ADC_AGE_1_TO_2_NO,
			String ADC_AGE_MORE_THAN_2_NO,String DC_OPENING_NO,String DC_OPENING_AMT,String DC_RECEIPT_NO,
			String DC_RECEIPT_AMT,String DC_DISPOSAL_NO,String DC_DISPOSAL_AMT,String DC_AGE_LESS_6_NO,
			String DC_AGE_6_TO_12_NO,String DC_AGE_1_TO_2_NO,String DC_AGE_MORE_THAN_2_NO,String SUP_OPENING_NO,
			String SUP_OPENING_AMT,String SUP_RECEIPT_NO,String SUP_RECEIPT_AMT,String SUP_DISPOSAL_NO,
			String SUP_DISPOSAL_AMT,String SUP_AGE_LESS_6_NO,String SUP_AGE_6_TO_12_NO,String SUP_AGE_1_TO_2_NO,
			String SUP_AGE_MORE_THAN_2_NO,String p_CRR);

	public String generateResult_SP_DPM_GST_ADJ_3_TEMP_UPLOAD(String p_COMM_CODE, String p_MM_YYYY, 
			String REASON_ID,String REASON_FOR_KEEPING_IN_CALL_BOOK,
			String ADC_OPENING_NO,String ADC_OPENING_AMT,String ADC_RECEIPT_NO,String ADC_RECEIPT_AMT,String ADC_DISPOSAL_NO,
			String ADC_DISPOSAL_AMT,String ADC_AGE_LESS_6_NO,String ADC_AGE_6_TO_12_NO,String ADC_AGE_1_TO_2_NO,
			String ADC_AGE_MORE_THAN_2_NO,String DC_OPENING_NO,String DC_OPENING_AMT,String DC_RECEIPT_NO,
			String DC_RECEIPT_AMT,String DC_DISPOSAL_NO,String DC_DISPOSAL_AMT,String DC_AGE_LESS_6_NO,
			String DC_AGE_6_TO_12_NO,String DC_AGE_1_TO_2_NO,String DC_AGE_MORE_THAN_2_NO,String SUP_OPENING_NO,
			String SUP_OPENING_AMT,String SUP_RECEIPT_NO,String SUP_RECEIPT_AMT,String SUP_DISPOSAL_NO,
			String SUP_DISPOSAL_AMT,String SUP_AGE_LESS_6_NO,String SUP_AGE_6_TO_12_NO,String SUP_AGE_1_TO_2_NO,
			String SUP_AGE_MORE_THAN_2_NO);		
	
	public String generateResult_SP_DPM_GST_ADJ_3_OPENING_INSERT(String p_COMM_CODE, String p_MM_YYYY, 
			String Appeals_ADC_OPENING_NO,String Appeals_ADC_OPENING_AMT,
			String Appeals_DC_OPENING_NO,String Appeals_DC_OPENING_AMT,
			String Appeals_SUP_OPENING_NO,String Appeals_SUP_OPENING_AMT,
			
			String Injunction_ADC_OPENING_NO,String Injunction_ADC_OPENING_AMT,
			String Injunction_DC_OPENING_NO,String Injunction_DC_OPENING_AMT,
			String Injunction_SUP_OPENING_NO,String Injunction_SUP_OPENING_AMT,
			
			String CAG_ADC_OPENING_NO,String CAG_ADC_OPENING_AMT,
			String CAG_DC_OPENING_NO,String CAG_DC_OPENING_AMT,
			String CAG_SUP_OPENING_NO,String CAG_SUP_OPENING_AMT,
			
			String Board_ADC_OPENING_NO,String Board_ADC_OPENING_AMT,
			String Board_DC_OPENING_NO,String Board_DC_OPENING_AMT,
			String Board_SUP_OPENING_NO,String Board_SUP_OPENING_AMT);		
}
