package com.ddm.cbic.gstgi.dao;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstgi.model.SP_GI_GST_1_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_ZONE_Result;

public interface GSTGI_GI_GST_1_Dao {

	Object generateResult_SP_GI_GST_1_MAX_DATE(String code);

	SP_GI_GST_1_COMM_TEMP_Result generateResult_SP_GI_GST_1_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	SP_GI_GST_1_ALL_Result generateResult_SP_GI_GST_1_ALL(String mm_yyyy);

	SP_GI_GST_1_REGION_Result generateResult_SP_GI_GST_1_REGION(String code, String mm_yyyy);

	SP_GI_GST_1_ZONE_Result generateResult_SP_GI_GST_1_ZONE(String code, String mm_yyyy);

	SP_GI_GST_1_COMM_Result generateResult_SP_GI_GST_1_COMM(String code, String mm_yyyy);

	SP_GI_GST_1_COMM_TEMP_REPORT_Result generateResult_SP_GI_GST_1_COMM_TEMP_REPORT(String code, String mm_yyyy,
			Object object, Object object2, Object object3);

	String generateResult_SP_GI_GST_1_UPDATE(String code, String mm_yyyy, 
			String DETECTION_CGST_NO,
			String DETECTION_CGST_AMT, String DETECTION_SGST_AMT, String DETECTION_IGST_AMT,
			String DETECTION_CESS_AMT, String DETECTION_CGST_NO_PRE, String DETECTION_CGST_AMT_PRE,
			String DETECTION_SGST_AMT_PRE, String DETECTION_IGST_AMT_PRE, String DETECTION_CESS_AMT_PRE,
			String REALISATION_CGST_NO,
			String REALISATION_CGST_AMT, String REALISATION_SGST_AMT, String REALISATION_IGST_AMT,
			String REALISATION_CESS_AMT, String REALISATION_CGST_NO_PRE, String REALISATION_CGST_AMT_PRE,
			String REALISATION_SGST_AMT_PRE, String REALISATION_IGST_AMT_PRE, String REALISATION_CESS_AMT_PRE,
			Object crr);

	String generateResult_SP_GI_GST_1_INSERT(String code, String mm_yyyy, 
			String DETECTION_CGST_NO,
			String DETECTION_CGST_AMT, String DETECTION_SGST_AMT, String DETECTION_IGST_AMT,
			String DETECTION_CESS_AMT, String DETECTION_CGST_NO_PRE, String DETECTION_CGST_AMT_PRE,
			String DETECTION_SGST_AMT_PRE, String DETECTION_IGST_AMT_PRE, String DETECTION_CESS_AMT_PRE,
			String REALISATION_CGST_NO,
			String REALISATION_CGST_AMT, String REALISATION_SGST_AMT, String REALISATION_IGST_AMT,
			String REALISATION_CESS_AMT, String REALISATION_CGST_NO_PRE, String REALISATION_CGST_AMT_PRE,
			String REALISATION_SGST_AMT_PRE, String REALISATION_IGST_AMT_PRE, String REALISATION_CESS_AMT_PRE);

}
