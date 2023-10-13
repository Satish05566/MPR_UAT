package com.ddm.cbic.gstgi.dao;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstgi.model.SP_GI_GST_2_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_ZONE_Result;

public interface GSTGI_GI_GST_2_Dao {

	public Object generateResult_SP_GI_GST_2_MAX_DATE(String code);

	public Object generateResult_SP_GI_GST_2_MARCH_DATA_CHECK(String code);
	
	public SP_GI_GST_2_COMM_TEMP_Result generateResult_SP_GI_GST_2_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public SP_GI_GST_2_COMM_TEMP_REPORT_Result generateResult_SP_GI_GST_2_COMM_TEMP_REPORT(String code, String mm_yyyy,
			Object crr, Object bak, Object submission_Date);

	public SP_GI_GST_2_ALL_Result generateResult_SP_GI_GST_2_ALL(String mm_yyyy);

	public SP_GI_GST_2_REGION_Result generateResult_SP_GI_GST_2_REGION(String code, String mm_yyyy);

	public SP_GI_GST_2_ZONE_Result generateResult_SP_GI_GST_2_ZONE(String code, String mm_yyyy);

	public SP_GI_GST_2_COMM_Result generateResult_SP_GI_GST_2_COMM(String code, String mm_yyyy);

	public String generateResult_SP_GI_GST_2_UPDATE(String code, String mm_yyyy, String OPENING_BALANCE_NO,
			String OPENING_BALANCE_TAX, String RECEIPT_NO, String RECEIPT_TAX, String SCN_NO_DURING_THE_MOTNH,
			String SCN_TAX_DURING_THE_MOTNH, String VOLUNTARY_NO_DURING_THE_MOTNH,
			String VOLUNTARY_TAX_DURING_THE_MOTNH, String MERIT_NO_DURING_THE_MOTNH, String MERIT_TAX_DURING_THE_MOTNH,
			String TRANSFER_NO_DURING_THE_MOTNH, String TRANSFER_TAX_DURING_THE_MOTNH, String LESS_THAN_2_NO,
			String LESS_THAN_2_TAX, String MORE_THAN_2_NO, String MORE_THAN_2_TAX, Object crr);

	public String generateResult_SP_GI_GST_2_INSERT(String code, String mm_yyyy, String OPENING_BALANCE_NO,
			String OPENING_BALANCE_TAX, String RECEIPT_NO, String RECEIPT_TAX, String SCN_NO_DURING_THE_MOTNH,
			String SCN_TAX_DURING_THE_MOTNH, String VOLUNTARY_NO_DURING_THE_MOTNH,
			String VOLUNTARY_TAX_DURING_THE_MOTNH, String MERIT_NO_DURING_THE_MOTNH, String MERIT_TAX_DURING_THE_MOTNH,
			String TRANSFER_NO_DURING_THE_MOTNH, String TRANSFER_TAX_DURING_THE_MOTNH, String LESS_THAN_2_NO,
			String LESS_THAN_2_TAX, String MORE_THAN_2_NO, String MORE_THAN_2_TAX);

	public String generateResult_SP_GI_GST_2_INSERT_OPENING(String code, String mm_yyyy, String opening_BALANCE_NO,
			String opening_BALANCE_AMOUNT);

}
