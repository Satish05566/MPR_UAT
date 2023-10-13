package com.ddm.cbic.gstgi.dao;


import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_ZONE_Result;

public interface GSTGI_GI_GST_1A_Dao {

	Object generateResult_SP_GI_GST_1A_MAX_DATE(String code);

	SP_GI_GST_1A_COMM_TEMP_Result generateResult_SP_GI_GST_1A_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	
	SP_GI_GST_1A_ALL_Result generateResult_SP_GI_GST_1A_ALL(String mm_yyyy);

	SP_GI_GST_1A_REGION_Result generateResult_SP_GI_GST_1A_REGION(String code, String mm_yyyy);

	SP_GI_GST_1A_ZONE_Result generateResult_SP_GI_GST_1A_ZONE(String code, String mm_yyyy);

	SP_GI_GST_1A_COMM_Result generateResult_SP_GI_GST_1A_COMM(String code, String mm_yyyy);

	SP_GI_GST_1A_COMM_TEMP_REPORT_Result generateResult_SP_GI_GST_1A_COMM_TEMP_REPORT(String code, String mm_yyyy,
			Object object, Object object2, Object object3);

	String generateResult_SP_GI_GST_1A_UPDATE(String code, String mm_yyyy, String ARRESTS_MADE, String PROSECUTION_SANCTIONED,
			String COMPOUNDING_OF_OFFENCES, String PROSECUTION_LAUNCHED, String ARRESTS_MADE_PRE, String PROSECUTION_SANCTIONED_PRE, String COMPOUNDING_OF_OFFENCES_PRE,
			String PROSECUTION_LAUNCHED_PRE, Object crr);

	String generateResult_SP_GI_GST_1A_INSERT(String code, String mm_yyyy, String ARRESTS_MADE, String PROSECUTION_SANCTIONED,
			String COMPOUNDING_OF_OFFENCES, String PROSECUTION_LAUNCHED, String ARRESTS_MADE_PRE, String PROSECUTION_SANCTIONED_PRE, String COMPOUNDING_OF_OFFENCES_PRE,
			String PROSECUTION_LAUNCHED_PRE);



	
	
	
	

	

}
