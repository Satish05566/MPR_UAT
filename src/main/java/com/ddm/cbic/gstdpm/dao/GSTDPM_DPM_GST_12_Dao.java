package com.ddm.cbic.gstdpm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_12_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_12_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_12_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_12_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_12_ZONE_Result;


public interface GSTDPM_DPM_GST_12_Dao {
	public List<SP_DPM_GST_12_ALL_Result> generateResult_SP_DPM_GST_12_ALL(String mm_yyyy);
	public List<SP_DPM_GST_12_ZONE_Result> generateResult_SP_DPM_GST_12_ZONE(String zone,
			String mm_yyyy);
	public List<SP_DPM_GST_12_COMM_Result> generateResult_SP_DPM_GST_12_COMM(String zone,
			String mm_yyyy);
	
	public Object generateResult_SP_DPM_GST_12_MAX_DATE(String comm) ;
	public List<SP_DPM_GST_12_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DPM_GST_12_COMM_TEMP_REPORT(Object[] objArray) ;

	public List<SP_DPM_GST_12_COMM_TEMP_Result> generateResultBeanList_SP_DPM_GST_12_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request);
	
	public String generateResult_SP_DPM_GST_12_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, 
			String p_SR_NO, String p_NO_TAXPAYER_FOR_MONTH, String p_NEW_TAXPAYER_FOR_MONTH,
			String p_MIGRATION_TAXPAYER_FROM, String p_MIGRATION_TAXPAYER_TO, String p_SUO_MOTO,
			String p_ON_REQUEST, String p_REVOCATION,
			String p_CRR);
	
	public String generateResult_SP_DPM_GST_12_INSERT(String p_COMM_CODE, String p_MM_YYYY, 
			String p_SR_NO, String p_NO_TAXPAYER_FOR_MONTH, String p_NEW_TAXPAYER_FOR_MONTH,
			String p_MIGRATION_TAXPAYER_FROM, String p_MIGRATION_TAXPAYER_TO, String p_SUO_MOTO,
			String p_ON_REQUEST, String p_REVOCATION
			,String p_CRR);
}
