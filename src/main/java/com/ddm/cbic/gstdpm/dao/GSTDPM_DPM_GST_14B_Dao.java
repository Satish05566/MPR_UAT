package com.ddm.cbic.gstdpm.dao;


import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_ZONE_Result;



public interface GSTDPM_DPM_GST_14B_Dao {

	public Object generateResult_SP_DPM_GST_14B_MAX_DATE(String code);

	public SP_DPM_GST_14B_COMM_TEMP_Result generateResult_SP_DPM_GST_14B_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public SP_DPM_GST_14B_COMM_TEMP_REPORT_Result generateResult_SP_DPM_GST_14B_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object object, Object object2, Object object3);

	public String generateResult_SP_DPM_GST_14B_UPDATE(String code, String mm_yyyy, String received_FROM_OTHER_CPC,
			String pv_REPORT_NOT_RECEIVED, String officer_FAILED_TO_PROCESS_ARN, String others, Object crr);

	public String generateResult_SP_DPM_GST_14B_INSERT(String code, String mm_yyyy, String received_FROM_OTHER_CPC,
			String pv_REPORT_NOT_RECEIVED, String officer_FAILED_TO_PROCESS_ARN, String others);

	
	public SP_DPM_GST_14B_ALL_Result generateResult_SP_DPM_GST_14B_ALL(String mm_yyyy);

	public SP_DPM_GST_14B_REGION_Result generateResult_SP_DPM_GST_14B_REGION(String code, String mm_yyyy);

	public SP_DPM_GST_14B_ZONE_Result generateResult_SP_DPM_GST_14B_ZONE(String code, String mm_yyyy);

	public SP_DPM_GST_14B_COMM_Result generateResult_SP_DPM_GST_14B_COMM(String code, String mm_yyyy);

	

	
	
	
	

}
