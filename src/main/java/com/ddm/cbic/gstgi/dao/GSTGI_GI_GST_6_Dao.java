package com.ddm.cbic.gstgi.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstgi.model.SP_GI_GST_6_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_ZONE_Result;

public interface GSTGI_GI_GST_6_Dao {

	public Object generateResult_SP_GI_GST_6_MAX_DATE(String code);
	
	public List<SP_GI_GST_6_COMM_TEMP_Result> generateResultBeanList_SP_GI_GST_6_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public String generateResult_SP_GI_GST_6_UPDATE(String code, String mm_yyyy,
			String HSN_SAC_CODE,String GOODS_OR_SERVICES_TYPE, String NO_OF_CASES, String AMOUNT_OF_TAX_EVASION,
			String NO_OF_CASES_PRE, String AMOUNT_OF_TAX_EVASION_PRE, 
			 Object crr);

	
	  public String generateResult_SP_GI_GST_6_INSERT(String code, String mm_yyyy,
				String HSN_SAC_CODE,String GOODS_OR_SERVICES_TYPE, String NO_OF_CASES, String AMOUNT_OF_TAX_EVASION,
				String NO_OF_CASES_PRE, String AMOUNT_OF_TAX_EVASION_PRE);
	 
	public List<SP_GI_GST_6_ALL_Result> generateResult_SP_GI_GST_6_ALL(String mm_yyyy);

	public List<SP_GI_GST_6_ZONE_Result> generateResult_SP_GI_GST_6_ZONE(String code, String mm_yyyy);

	public List<SP_GI_GST_6_COMM_Result> generateResult_SP_GI_GST_6_COMM(String code, String mm_yyyy);

	public List<SP_GI_GST_6_COMM_TEMP_REPORT_Result> generateResult_SP_GI_GST_6_COMM_TEMP_REPORT(String code, String mm_yyyy,
			Object object, Object object2, Object object3);
	
	
}
