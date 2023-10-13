package com.ddm.cbic.gstdpm.dao;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_ZONE_Result;



public interface GSTDPM_DPM_GST_15C_Dao {
	
	public Object generateResult_SP_DPM_GST_15C_MAX_DATE(String code);

	public SP_DPM_GST_15C_COMM_TEMP_Result generateResult_SP_DPM_GST_15C_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public SP_DPM_GST_15C_COMM_TEMP_REPORT_Result generateResult_SP_DPM_GST_15C_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object object, Object object2, Object object3);



	
	public SP_DPM_GST_15C_ALL_Result generateResult_SP_DPM_GST_15C_ALL(String mm_yyyy);

	public SP_DPM_GST_15C_REGION_Result generateResult_SP_DPM_GST_15C_REGION(String code, String mm_yyyy);

	public SP_DPM_GST_15C_ZONE_Result generateResult_SP_DPM_GST_15C_ZONE(String code, String mm_yyyy);

	public SP_DPM_GST_15C_COMM_Result generateResult_SP_DPM_GST_15C_COMM(String code, String mm_yyyy);



	public String generateResult_SP_DPM_GST_15C_UPDATE(String code, String mm_yyyy, String PERSONAL_HEARING_GRANTED_NO_GSTIN,
			String NOTIME_LEFT_FOR_REJECTION_NO_GSTIN,
			String TAXES_OR_DUES_UNPAID_NO_GSTIN,
			String TECHNICAL_ISSUES_NO_GSTIN,
			String OTHERS_SPECIFY,
			String OTHERS_NO_GSTIN, Object crr);

	public String generateResult_SP_DPM_GST_15C_INSERT(String code, String mm_yyyy, String PERSONAL_HEARING_GRANTED_NO_GSTIN,
			String NOTIME_LEFT_FOR_REJECTION_NO_GSTIN,
			String TAXES_OR_DUES_UNPAID_NO_GSTIN,
			String TECHNICAL_ISSUES_NO_GSTIN,
			String OTHERS_SPECIFY,
			String OTHERS_NO_GSTIN);

	
	


}
