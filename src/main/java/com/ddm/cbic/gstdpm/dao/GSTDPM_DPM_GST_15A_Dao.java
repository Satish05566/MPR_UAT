package com.ddm.cbic.gstdpm.dao;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_ZONE_Result;



public interface GSTDPM_DPM_GST_15A_Dao {
	
	public Object generateResult_SP_DPM_GST_15A_MAX_DATE(String code);

	public SP_DPM_GST_15A_COMM_TEMP_Result generateResult_SP_DPM_GST_15A_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public SP_DPM_GST_15A_COMM_TEMP_REPORT_Result generateResult_SP_DPM_GST_15A_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object object, Object object2, Object object3);



	
	public SP_DPM_GST_15A_ALL_Result generateResult_SP_DPM_GST_15A_ALL(String mm_yyyy);

	public SP_DPM_GST_15A_REGION_Result generateResult_SP_DPM_GST_15A_REGION(String code, String mm_yyyy);

	public SP_DPM_GST_15A_ZONE_Result generateResult_SP_DPM_GST_15A_ZONE(String code, String mm_yyyy);

	public SP_DPM_GST_15A_COMM_Result generateResult_SP_DPM_GST_15A_COMM(String code, String mm_yyyy);



	public String generateResult_SP_DPM_GST_15A_UPDATE(String code, String mm_yyyy, String suo_MOTO_OPENING_BALANCE,
			String suo_MOTO_GSTIN_LIABLE_FOR_CANCELLATION, String suo_MOTO_GSTIN_CANCELLED,
			String cancellation_OPENING_BALANCE, String cancellation_NO_APPLICATION_RECEIVED,
			String cancellation_GSTIN_CANCELLED, String revocation_OPENING_BALANCE, String revocation_ARN_RECEIVED,
			String revocation_GSTIN_REVOKED, String revocation_APPLICATION_REJECTED, Object crr);

	public String generateResult_SP_DPM_GST_15A_INSERT(String code, String mm_yyyy, String suo_MOTO_OPENING_BALANCE,
			String suo_MOTO_GSTIN_LIABLE_FOR_CANCELLATION, String suo_MOTO_GSTIN_CANCELLED,
			String cancellation_OPENING_BALANCE, String cancellation_NO_APPLICATION_RECEIVED,
			String cancellation_GSTIN_CANCELLED, String revocation_OPENING_BALANCE, String revocation_ARN_RECEIVED,
			String revocation_GSTIN_REVOKED, String revocation_APPLICATION_REJECTED);

	
	


}
