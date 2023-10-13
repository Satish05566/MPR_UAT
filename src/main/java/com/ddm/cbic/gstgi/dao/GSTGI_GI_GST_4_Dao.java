package com.ddm.cbic.gstgi.dao;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstgi.model.SP_GI_GST_4_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_ZONE_Result;

public interface GSTGI_GI_GST_4_Dao {

	public Object generateResult_SP_GI_GST_4_MAX_DATE(String code);

	public SP_GI_GST_4_COMM_TEMP_Result generateResult_SP_GI_GST_4_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public SP_GI_GST_4_COMM_TEMP_REPORT_Result generateResult_SP_GI_GST_4_COMM_TEMP_REPORT(String code, String mm_yyyy,
			Object object, Object object2, Object object3);

	public SP_GI_GST_4_ALL_Result generateResult_SP_GI_GST_4_ALL(String mm_yyyy);

	public SP_GI_GST_4_REGION_Result generateResult_SP_GI_GST_4_REGION(String code, String mm_yyyy);

	public SP_GI_GST_4_ZONE_Result generateResult_SP_GI_GST_4_ZONE(String code, String mm_yyyy);

	public SP_GI_GST_4_COMM_Result generateResult_SP_GI_GST_4_COMM(String code, String mm_yyyy);

	public String generateResult_SP_GI_GST_4_UPDATE(String code, String mm_yyyy, String AE_1_NO, String AE_2_NO,
			String INSPECTION_PERMISES_NO, String SEARCHES_NO, String INSPECTION_GOODS_NO, String SUMMONS_NO,
			String SEIZUR67_GOODS_NO, String SEIZUR67_GOODS_VALUE, String SEIZUR67_GOODS_TAX,
			String SEIZUR67_VEHICLES_NO, String SEIZUR67_VEHICLES_VALUE, String SEIZUR67_VEHICLES_TAX,
			String SEIZUR67_CURRENCY_NO, String SEIZUR67_CURRENCY_VALUE, String SEIZUR67_CURRENCY_TAX,
			String SEIZUR129_GOODS_NO, String SEIZUR129_GOODS_VALUE, String SEIZUR129_VEHICLES_NO,
			String SEIZUR129_VEHICLES_VALUE, String ATTACHMENT_GOODS_NO, String ATTACHMENT_GOODS_VALUE,
			String ATTACHMENT_PROPERTY_NO, String ATTACHMENT_PROPERTY_VALUE, String ATTACHMENT_ACCOUNT_NO,
			String INCIDENT_NO, String INCIDENT_AMOUNT, Object crr);

	public String generateResult_SP_GI_GST_4_INSERT(String code, String mm_yyyy, String AE_1_NO, String AE_2_NO,
			String INSPECTION_PERMISES_NO, String SEARCHES_NO, String INSPECTION_GOODS_NO, String SUMMONS_NO,
			String SEIZUR67_GOODS_NO, String SEIZUR67_GOODS_VALUE, String SEIZUR67_GOODS_TAX,
			String SEIZUR67_VEHICLES_NO, String SEIZUR67_VEHICLES_VALUE, String SEIZUR67_VEHICLES_TAX,
			String SEIZUR67_CURRENCY_NO, String SEIZUR67_CURRENCY_VALUE, String SEIZUR67_CURRENCY_TAX,
			String SEIZUR129_GOODS_NO, String SEIZUR129_GOODS_VALUE, String SEIZUR129_VEHICLES_NO,
			String SEIZUR129_VEHICLES_VALUE, String ATTACHMENT_GOODS_NO, String ATTACHMENT_GOODS_VALUE,
			String ATTACHMENT_PROPERTY_NO, String ATTACHMENT_PROPERTY_VALUE, String ATTACHMENT_ACCOUNT_NO,
			String INCIDENT_NO, String INCIDENT_AMOUNT);
}
