package com.ddm.cbic.gstgst.dao;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstgst.model.SP_GST_GST_2_ALL_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_TEMP_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_REGION_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_ZONE_Result;

public interface GST_GST_2_Dao {
	
	public Object generateResult_SP_GST_GST_2_MAX_DATE(String code);

	public SP_GST_GST_2_COMM_TEMP_Result generateResult_SP_GST_GST_2_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public SP_GST_GST_2_COMM_TEMP_REPORT_Result generateResult_SP_GST_GST_2_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object object, Object object2, Object object3);



	
	public SP_GST_GST_2_ALL_Result generateResult_SP_GST_GST_2_ALL(String mm_yyyy);

	public SP_GST_GST_2_REGION_Result generateResult_SP_GST_GST_2_REGION(String code, String mm_yyyy);

	public SP_GST_GST_2_ZONE_Result generateResult_SP_GST_GST_2_ZONE(String code, String mm_yyyy);

	public SP_GST_GST_2_COMM_Result generateResult_SP_GST_GST_2_COMM(String code, String mm_yyyy);

	public String generateResult_SP_GST_GST_2_UPDATE(String code, String mm_yyyy, String gstr_1m_F, String gstr_3bm_F,
			String gstr_1q_F, String gstr_3bq_F, String gst_CMP_08_F, String gstr_4_F, String gstr_9_F,
			String gstr_9a_F, String gstr_9c_F, String gstr_1m_D, String gstr_3bm_D, String gstr_1q_D,
			String gstr_3bq_D, String gst_CMP_08_D, String gstr_4_D, String gstr_9_D, String gstr_9a_D,
			String gstr_9c_D, String gstr_3a_I, String gstr_3a_NI, Object crr);

	public String generateResult_SP_GST_GST_2_INSERT(String code, String mm_yyyy, String gstr_1m_F, String gstr_3bm_F,
			String gstr_1q_F, String gstr_3bq_F, String gst_CMP_08_F, String gstr_4_F, String gstr_9_F,
			String gstr_9a_F, String gstr_9c_F, String gstr_1m_D, String gstr_3bm_D, String gstr_1q_D,
			String gstr_3bq_D, String gst_CMP_08_D, String gstr_4_D, String gstr_9_D, String gstr_9a_D,
			String gstr_9c_D, String gstr_3a_I, String gstr_3a_NI);

	
	

}
