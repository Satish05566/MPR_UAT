package com.ddm.cbic.gstddm.dao;


import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_ALL_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_REGION_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_ZONE_Result;


public interface GSTDDM_DDM_GST_1_Dao {

	Object generateResult_SP_DDM_GST_1_MAX_DATE(String code);

	SP_DDM_GST_1_COMM_TEMP_Result generateResult_SP_DDM_GST_1_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	
	SP_DDM_GST_1_ALL_Result generateResult_SP_DDM_GST_1_ALL(String mm_yyyy);

	SP_DDM_GST_1_REGION_Result generateResult_SP_DDM_GST_1_REGION(String code, String mm_yyyy);

	SP_DDM_GST_1_ZONE_Result generateResult_SP_DDM_GST_1_ZONE(String code, String mm_yyyy);

	SP_DDM_GST_1_COMM_Result generateResult_SP_DDM_GST_1_COMM(String code, String mm_yyyy);

	SP_DDM_GST_1_COMM_TEMP_REPORT_Result generateResult_SP_DDM_GST_1_COMM_TEMP_REPORT(String code, String mm_yyyy,
			Object object, Object object2, Object object3);

	String generateResult_SP_DDM_GST_1_UPDATE(String code, String mm_yyyy, String moving_TARGET_CGST,
			String moving_TARGET_SGST, String moving_TARGET_IGST, String moving_TARGET_CESS, String gross_TAX_CGST,
			String gross_TAX_SGST, String gross_TAX_IGST, String gross_TAX_CESS, String refund_SANCTIONED_CGST,
			String refund_SANCTIONED_SGST, String refund_SANCTIONED_IGST, String refund_SANCTIONED_CESS, Object crr);

	String generateResult_SP_DDM_GST_1_INSERT(String code, String mm_yyyy, String moving_TARGET_CGST,
			String moving_TARGET_SGST, String moving_TARGET_IGST, String moving_TARGET_CESS, String gross_TAX_CGST,
			String gross_TAX_SGST, String gross_TAX_IGST, String gross_TAX_CESS, String refund_SANCTIONED_CGST,
			String refund_SANCTIONED_SGST, String refund_SANCTIONED_IGST, String refund_SANCTIONED_CESS);



	
	
	
	

	

}
