package com.ddm.cbic.gstdpm.dao;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_ZONE_Result;

public interface GSTDPM_DPM_GST_14A_Dao {
	
	
	public Object generateResult_SP_DPM_GST_14A_MAX_DATE(String code);

	public SP_DPM_GST_14A_COMM_TEMP_Result generateResult_SP_DPM_GST_14A_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public SP_DPM_GST_14A_COMM_TEMP_REPORT_Result generateResult_SP_DPM_GST_14A_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object object, Object object2, Object object3);



	
	public SP_DPM_GST_14A_ALL_Result generateResult_SP_DPM_GST_14A_ALL(String mm_yyyy);

	public SP_DPM_GST_14A_REGION_Result generateResult_SP_DPM_GST_14A_REGION(String code, String mm_yyyy);

	public SP_DPM_GST_14A_ZONE_Result generateResult_SP_DPM_GST_14A_ZONE(String code, String mm_yyyy);

	public SP_DPM_GST_14A_COMM_Result generateResult_SP_DPM_GST_14A_COMM(String code, String mm_yyyy);

	public String generateResult_SP_DPM_GST_14A_UPDATE(String code, String mm_yyyy,
			String OPENING_BALANCE, String no_OF_ARN_RECEIVED_GSTN, String no_OF_ARN_RECEIVED_CPC,
			String disposal_OF_ARN_WITHIN_7, String disposal_OF_ARN_PV_RECOMMENDED, String disposal_OF_ARN_PV_APPROVED,
			String disposal_OF_ARN_PV_REJECTED, String disposal_OF_ARN_PV_NOT_RECEIVED,
			String disposal_OF_ARN_TRANSFERED_CPC, String disposal_OF_ARN_DEEMED_REG, Object crr);

	public String generateResult_SP_DPM_GST_14A_INSERT(String code, String mm_yyyy,
			String OPENING_BALANCE, String no_OF_ARN_RECEIVED_GSTN, String no_OF_ARN_RECEIVED_CPC,
			String disposal_OF_ARN_WITHIN_7, String disposal_OF_ARN_PV_RECOMMENDED, String disposal_OF_ARN_PV_APPROVED,
			String disposal_OF_ARN_PV_REJECTED, String disposal_OF_ARN_PV_NOT_RECEIVED,
			String disposal_OF_ARN_TRANSFERED_CPC, String disposal_OF_ARN_DEEMED_REG);

	


}
