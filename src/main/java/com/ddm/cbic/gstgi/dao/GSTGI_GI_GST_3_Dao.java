package com.ddm.cbic.gstgi.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstgi.model.SP_GI_GST_3_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_ZONE_Result;


public interface GSTGI_GI_GST_3_Dao {

	public Object generateResult_SP_GI_GST_3_MAX_DATE(String code);

	public SP_GI_GST_3_COMM_TEMP_Result generateResult_SP_GI_GST_3_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public String generateResult_SP_GI_GST_3_UPDATE(String code, String mm_yyyy, String REWARD_DEPARTMENTAL_NO,
			String REWARD_DEPARTMENTAL_AMT,String REWARD_INFORMER_NO,String REWARD_INFORMER_AMT,
			String DISBURSED_DEPARTMENTAL_NO,String DISBURSED_DEPARTMENTAL_AMT,String DISBURSED_INFORMER_NO,
			String DISBURSED_INFORMER_AMT,String PENDING_DEPARTMENTAL_NO,String PENDING_DEPARTMENTAL_AMT,
			String PENDING_INFORMER_NO,String PENDING_INFORMER_AMT,Object crr);

	public String generateResult_SP_GI_GST_3_INSERT(String code, String mm_yyyy, String REWARD_DEPARTMENTAL_NO,
			String REWARD_DEPARTMENTAL_AMT,String REWARD_INFORMER_NO,String REWARD_INFORMER_AMT,
			String DISBURSED_DEPARTMENTAL_NO,String DISBURSED_DEPARTMENTAL_AMT,String DISBURSED_INFORMER_NO,
			String DISBURSED_INFORMER_AMT,String PENDING_DEPARTMENTAL_NO,String PENDING_DEPARTMENTAL_AMT,
			String PENDING_INFORMER_NO,String PENDING_INFORMER_AMT);


	public SP_GI_GST_3_ALL_Result generateResult_SP_GI_GST_3_ALL(String mm_yyyy);

	public SP_GI_GST_3_ZONE_Result generateResult_SP_GI_GST_3_ZONE(String code, String mm_yyyy);

	public SP_GI_GST_3_COMM_Result generateResult_SP_GI_GST_3_COMM(String code, String mm_yyyy);

	public SP_GI_GST_3_COMM_TEMP_REPORT_Result generateResult_SP_GI_GST_3_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object object, Object object2, Object object3);
	

}
