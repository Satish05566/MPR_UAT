package com.ddm.cbic.gstdpm.dao;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_ZONE_Result;


public interface GSTDPM_DPM_GST_15B_Dao {
	
	public Object generateResult_SP_DPM_GST_15B_MAX_DATE(String code);

	public SP_DPM_GST_15B_COMM_TEMP_Result generateResult_SP_DPM_GST_15B_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public SP_DPM_GST_15B_COMM_TEMP_REPORT_Result generateResult_SP_DPM_GST_15B_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object object, Object object2, Object object3);



	
	public SP_DPM_GST_15B_ALL_Result generateResult_SP_DPM_GST_15B_ALL(String mm_yyyy);

	public SP_DPM_GST_15B_REGION_Result generateResult_SP_DPM_GST_15B_REGION(String code, String mm_yyyy);

	public SP_DPM_GST_15B_ZONE_Result generateResult_SP_DPM_GST_15B_ZONE(String code, String mm_yyyy);

	public SP_DPM_GST_15B_COMM_Result generateResult_SP_DPM_GST_15B_COMM(String code, String mm_yyyy);



	public String generateResult_SP_DPM_GST_15B_UPDATE(String code, String mm_yyyy, String PENDENCY_PART_OFFICER_NO_GSTIN ,
			String REPLY_AWAITED_TAXPAYER_NO_GSTIN,
			String TAXES_OR_DUES_UNPAID_NO_GSTIN,
			String TECHNICAL_ISSUES_NO_GSTIN,
			String OTHERS_REMARKS,
			String OTHERS_NO_GSTIN, Object crr);

	public String generateResult_SP_DPM_GST_15B_INSERT(String code, String mm_yyyy, String PENDENCY_PART_OFFICER_NO_GSTIN ,
			String REPLY_AWAITED_TAXPAYER_NO_GSTIN,
			String TAXES_OR_DUES_UNPAID_NO_GSTIN,
			String TECHNICAL_ISSUES_NO_GSTIN,
			String OTHERS_REMARKS,
			String OTHERS_NO_GSTIN);

	
	


}
