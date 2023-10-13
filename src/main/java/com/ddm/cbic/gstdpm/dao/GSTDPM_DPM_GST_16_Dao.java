package com.ddm.cbic.gstdpm.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_REFUND_CATEGORY;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_ZONE_Result;




public interface GSTDPM_DPM_GST_16_Dao {
	public List<SP_DGI_GST_16_ALL_Result> generateResult_SP_DGI_GST_16_ALL(String mm_yyyy);
	public List<SP_DGI_GST_16_ZONE_Result> generateResult_SP_DGI_GST_16_ZONE(String zone,
			String mm_yyyy);
	public List<SP_DGI_GST_16_COMM_Result> generateResult_SP_DGI_GST_16_COMM(String zone,
			String mm_yyyy);
	
	public List<SP_DGI_GST_16_REFUND_CATEGORY> generateResultBeanSP_DGI_GST_16_REFUND_LIST();
	
	public Object generateResult_SP_DGI_GST_16_MAX_DATE(String comm) ;
	public List<SP_DGI_GST_16_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DGI_GST_16_COMM_TEMP_REPORT(Object[] objArray) ;
	
	public List<SP_DGI_GST_16_COMM_TEMP_Result> generateResultBeanList_SP_DGI_GST_16_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request);
	
	public String generateResult_SP_DGI_GST_16_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, 
			String p_SR_NO, String p_REFUND_CATEGORY, String p_OPENING_BALANCE_NO,
			String p_OPENING_BALANCE_AMOUNT, String p_RFD_01_NO, String p_RFD_01_AMOUNT,
			String p_RFD_02_NO,String p_RFD_03_NO,
			String p_RFD_03_AMOUNT, String p_RFD_04_NO,String p_RFD_04_AMOUNT,String p_RFD_06_SANCTIONED_NO,
			String p_RFD_06_SANCTIONED_AMOUNT,String p_RFD_06_REJECTED_NO,String p_RFD_06_REJECTED_AMOUNT,
			String p_AGE_BREAKUP_30_45_NO,String p_AGE_BREAKUP_30_45_AMOUNT,String p_AGE_BREAKUP_46_60_NO,
			String p_AGE_BREAKUP_46_60_AMOUNT,String p_AGE_BREAKUP_ABOVE60_NO, String p_AGE_BREAKUP_ABOVE60_AMOUNT,
			String p_CRR);
	
	public String generateResult_SP_DGI_GST_16_INSERT(String p_COMM_CODE, String p_MM_YYYY, 
			String p_SR_NO, String p_REFUND_CATEGORY, String p_OPENING_BALANCE_NO,
			String p_OPENING_BALANCE_AMOUNT, String p_RFD_01_NO, String p_RFD_01_AMOUNT,
			String p_RFD_02_NO,String p_RFD_03_NO,
			String p_RFD_03_AMOUNT, String p_RFD_04_NO,String p_RFD_04_AMOUNT,String p_RFD_06_SANCTIONED_NO,
			String p_RFD_06_SANCTIONED_AMOUNT,String p_RFD_06_REJECTED_NO,String p_RFD_06_REJECTED_AMOUNT,
			String p_AGE_BREAKUP_30_45_NO,String p_AGE_BREAKUP_30_45_AMOUNT,String p_AGE_BREAKUP_46_60_NO,
			String p_AGE_BREAKUP_46_60_AMOUNT,String p_AGE_BREAKUP_ABOVE60_NO, String p_AGE_BREAKUP_ABOVE60_AMOUNT
			,String p_CRR);
}
