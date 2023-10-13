package com.ddm.cbic.gstdpm.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_ZONE_Result;

public interface GSTDPM_DPM_GST_ADJ_1_Dao {
	public SP_DPM_GST_ADJ_1_ALL_Result generateResult_SP_DPM_GST_ADJ_1_ALL(String mm_yyyy);

	public SP_DPM_GST_ADJ_1_ZONE_Result generateResult_SP_DPM_GST_ADJ_1_ZONE(String zone, String mm_yyyy);

	public SP_DPM_GST_ADJ_1_COMM_Result generateResult_SP_DPM_GST_ADJ_1_COMM(String zone, String mm_yyyy);

	public Object generateResult_SP_DPM_GST_ADJ_1_MAX_DATE(String comm);

	public SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT_Result generateResultBeanList_SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT(String mM_YYYY,
			String code, Object crr,  HttpServletRequest request);

	public SP_DPM_GST_ADJ_1_COMM_TEMP_Result generateResultBeanList_SP_DPM_GST_ADJ_1_COMM_TEMP(String mM_YYYY,
			String code, Object crr,  HttpServletRequest request);

	public String generateResult_SP_DPM_GST_ADJ_1_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY,
			String ADC_COMMISSIONERATE_OPENING_NO, String ADC_COMMISSIONERATE_OPENING_AMT,
			String ADC_COMMISSIONERATE_RECEIPT_NO, String ADC_COMMISSIONERATE_RECEIPT_AMT,
			String ADC_COMMISSIONERATE_DISPOSAL_NO, String ADC_COMMISSIONERATE_DISPOSAL_AMT,
			String ADC_COMMISSIONERATE_OIO_NO, String ADC_COMMISSIONERATE_OIO_AMT,
			String ADC_COMMISSIONERATE_AGE_LESS_3_NO, String ADC_COMMISSIONERATE_AGE_3_TO_6_NO,
			String ADC_COMMISSIONERATE_AGE_6_TO_12_NO, String ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String ADC_COMMISSIONERATE_TIME_LESS_3_NO, String ADC_COMMISSIONERATE_TIME_3_TO_6_NO,
			String ADC_COMMISSIONERATE_TIME_6_TO_12_NO, String ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO, String

			ADC_AUDIT_OPENING_NO, String ADC_AUDIT_OPENING_AMT, String ADC_AUDIT_RECEIPT_NO,
			String ADC_AUDIT_RECEIPT_AMT, String ADC_AUDIT_DISPOSAL_NO, String ADC_AUDIT_DISPOSAL_AMT,
			String ADC_AUDIT_OIO_NO, String ADC_AUDIT_OIO_AMT, String ADC_AUDIT_AGE_LESS_3_NO,
			String ADC_AUDIT_AGE_3_TO_6_NO, String ADC_AUDIT_AGE_6_TO_12_NO, String ADC_AUDIT_AGE_MORE_THAN_1_NO,
			String ADC_AUDIT_TIME_LESS_3_NO, String ADC_AUDIT_TIME_3_TO_6_NO, String ADC_AUDIT_TIME_6_TO_12_NO,
			String ADC_AUDIT_TIME_MORE_THAN_1_NO, String

			ADC_INVESTIGATION_OPENING_NO, String ADC_INVESTIGATION_OPENING_AMT, String ADC_INVESTIGATION_RECEIPT_NO,
			String ADC_INVESTIGATION_RECEIPT_AMT, String ADC_INVESTIGATION_DISPOSAL_NO,
			String ADC_INVESTIGATION_DISPOSAL_AMT, String ADC_INVESTIGATION_OIO_NO, String ADC_INVESTIGATION_OIO_AMT,
			String ADC_INVESTIGATION_AGE_LESS_3_NO, String ADC_INVESTIGATION_AGE_3_TO_6_NO,
			String ADC_INVESTIGATION_AGE_6_TO_12_NO, String ADC_INVESTIGATION_AGE_MORE_THAN_1_NO,
			String ADC_INVESTIGATION_TIME_LESS_3_NO, String ADC_INVESTIGATION_TIME_3_TO_6_NO,
			String ADC_INVESTIGATION_TIME_6_TO_12_NO, String ADC_INVESTIGATION_TIME_MORE_THAN_1_NO, String

			ADC_CALLBOOK_OPENING_NO, String ADC_CALLBOOK_OPENING_AMT, String ADC_CALLBOOK_RECEIPT_NO,
			String ADC_CALLBOOK_RECEIPT_AMT, String ADC_CALLBOOK_DISPOSAL_NO, String ADC_CALLBOOK_DISPOSAL_AMT,
			String ADC_CALLBOOK_OIO_NO, String ADC_CALLBOOK_OIO_AMT, String ADC_CALLBOOK_AGE_LESS_3_NO,
			String ADC_CALLBOOK_AGE_3_TO_6_NO, String ADC_CALLBOOK_AGE_6_TO_12_NO,
			String ADC_CALLBOOK_AGE_MORE_THAN_1_NO, String ADC_CALLBOOK_TIME_LESS_3_NO,
			String ADC_CALLBOOK_TIME_3_TO_6_NO, String ADC_CALLBOOK_TIME_6_TO_12_NO,
			String ADC_CALLBOOK_TIME_MORE_THAN_1_NO,

			String DC_COMMISSIONERATE_OPENING_NO, String DC_COMMISSIONERATE_OPENING_AMT,
			String DC_COMMISSIONERATE_RECEIPT_NO, String DC_COMMISSIONERATE_RECEIPT_AMT,
			String DC_COMMISSIONERATE_DISPOSAL_NO, String DC_COMMISSIONERATE_DISPOSAL_AMT,
			String DC_COMMISSIONERATE_OIO_NO, String DC_COMMISSIONERATE_OIO_AMT,
			String DC_COMMISSIONERATE_AGE_LESS_3_NO, String DC_COMMISSIONERATE_AGE_3_TO_6_NO,
			String DC_COMMISSIONERATE_AGE_6_TO_12_NO, String DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String DC_COMMISSIONERATE_TIME_LESS_3_NO, String DC_COMMISSIONERATE_TIME_3_TO_6_NO,
			String DC_COMMISSIONERATE_TIME_6_TO_12_NO, String DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO, String

			DC_AUDIT_OPENING_NO, String DC_AUDIT_OPENING_AMT, String DC_AUDIT_RECEIPT_NO, String DC_AUDIT_RECEIPT_AMT,
			String DC_AUDIT_DISPOSAL_NO, String DC_AUDIT_DISPOSAL_AMT, String DC_AUDIT_OIO_NO, String DC_AUDIT_OIO_AMT,
			String DC_AUDIT_AGE_LESS_3_NO, String DC_AUDIT_AGE_3_TO_6_NO, String DC_AUDIT_AGE_6_TO_12_NO,
			String DC_AUDIT_AGE_MORE_THAN_1_NO, String DC_AUDIT_TIME_LESS_3_NO, String DC_AUDIT_TIME_3_TO_6_NO,
			String DC_AUDIT_TIME_6_TO_12_NO, String DC_AUDIT_TIME_MORE_THAN_1_NO, String

			DC_INVESTIGATION_OPENING_NO, String DC_INVESTIGATION_OPENING_AMT, String DC_INVESTIGATION_RECEIPT_NO,
			String DC_INVESTIGATION_RECEIPT_AMT, String DC_INVESTIGATION_DISPOSAL_NO,
			String DC_INVESTIGATION_DISPOSAL_AMT, String DC_INVESTIGATION_OIO_NO, String DC_INVESTIGATION_OIO_AMT,
			String DC_INVESTIGATION_AGE_LESS_3_NO, String DC_INVESTIGATION_AGE_3_TO_6_NO,
			String DC_INVESTIGATION_AGE_6_TO_12_NO, String DC_INVESTIGATION_AGE_MORE_THAN_1_NO,
			String DC_INVESTIGATION_TIME_LESS_3_NO, String DC_INVESTIGATION_TIME_3_TO_6_NO,
			String DC_INVESTIGATION_TIME_6_TO_12_NO, String DC_INVESTIGATION_TIME_MORE_THAN_1_NO, String

			DC_CALLBOOK_OPENING_NO, String DC_CALLBOOK_OPENING_AMT, String DC_CALLBOOK_RECEIPT_NO,
			String DC_CALLBOOK_RECEIPT_AMT, String DC_CALLBOOK_DISPOSAL_NO, String DC_CALLBOOK_DISPOSAL_AMT,
			String DC_CALLBOOK_OIO_NO, String DC_CALLBOOK_OIO_AMT, String DC_CALLBOOK_AGE_LESS_3_NO,
			String DC_CALLBOOK_AGE_3_TO_6_NO, String DC_CALLBOOK_AGE_6_TO_12_NO, String DC_CALLBOOK_AGE_MORE_THAN_1_NO,
			String DC_CALLBOOK_TIME_LESS_3_NO, String DC_CALLBOOK_TIME_3_TO_6_NO, String DC_CALLBOOK_TIME_6_TO_12_NO,
			String DC_CALLBOOK_TIME_MORE_THAN_1_NO,

			String SUPERINTENDENT_COMMISSIONERATE_OPENING_NO, String SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT,
			String SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO, String SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT,
			String SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO, String SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT,
			String SUPERINTENDENT_COMMISSIONERATE_OIO_NO, String SUPERINTENDENT_COMMISSIONERATE_OIO_AMT,
			String SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO, String SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO,
			String SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO,
			String SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO, String SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO,
			String SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO,
			String SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO, String

			SUPERINTENDENT_AUDIT_OPENING_NO, String SUPERINTENDENT_AUDIT_OPENING_AMT,
			String SUPERINTENDENT_AUDIT_RECEIPT_NO, String SUPERINTENDENT_AUDIT_RECEIPT_AMT,
			String SUPERINTENDENT_AUDIT_DISPOSAL_NO, String SUPERINTENDENT_AUDIT_DISPOSAL_AMT,
			String SUPERINTENDENT_AUDIT_OIO_NO, String SUPERINTENDENT_AUDIT_OIO_AMT,
			String SUPERINTENDENT_AUDIT_AGE_LESS_3_NO, String SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO,
			String SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO, String SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO,
			String SUPERINTENDENT_AUDIT_TIME_LESS_3_NO, String SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO,
			String SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO, String SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO, String

			SUPERINTENDENT_INVESTIGATION_OPENING_NO, String SUPERINTENDENT_INVESTIGATION_OPENING_AMT,
			String SUPERINTENDENT_INVESTIGATION_RECEIPT_NO, String SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT,
			String SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO, String SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT,
			String SUPERINTENDENT_INVESTIGATION_OIO_NO, String SUPERINTENDENT_INVESTIGATION_OIO_AMT,
			String SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO, String SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO,
			String SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO, String SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO,
			String SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO, String SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO,
			String SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO,
			String SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO, String

			SUPERINTENDENT_CALLBOOK_OPENING_NO, String SUPERINTENDENT_CALLBOOK_OPENING_AMT,
			String SUPERINTENDENT_CALLBOOK_RECEIPT_NO, String SUPERINTENDENT_CALLBOOK_RECEIPT_AMT,
			String SUPERINTENDENT_CALLBOOK_DISPOSAL_NO, String SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT,
			String SUPERINTENDENT_CALLBOOK_OIO_NO, String SUPERINTENDENT_CALLBOOK_OIO_AMT,
			String SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO, String SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO,
			String SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO, String SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO,
			String SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO, String SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO,
			String SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO, String SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO,
			String p_CRR);

	public String generateResult_SP_DPM_GST_ADJ_1_INSERT(String p_COMM_CODE, String p_MM_YYYY,
			String ADC_COMMISSIONERATE_OPENING_NO, String ADC_COMMISSIONERATE_OPENING_AMT,
			String ADC_COMMISSIONERATE_RECEIPT_NO, String ADC_COMMISSIONERATE_RECEIPT_AMT,
			String ADC_COMMISSIONERATE_DISPOSAL_NO, String ADC_COMMISSIONERATE_DISPOSAL_AMT,
			String ADC_COMMISSIONERATE_OIO_NO, String ADC_COMMISSIONERATE_OIO_AMT,
			String ADC_COMMISSIONERATE_AGE_LESS_3_NO, String ADC_COMMISSIONERATE_AGE_3_TO_6_NO,
			String ADC_COMMISSIONERATE_AGE_6_TO_12_NO, String ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String ADC_COMMISSIONERATE_TIME_LESS_3_NO, String ADC_COMMISSIONERATE_TIME_3_TO_6_NO,
			String ADC_COMMISSIONERATE_TIME_6_TO_12_NO, String ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO, String

			ADC_AUDIT_OPENING_NO, String ADC_AUDIT_OPENING_AMT, String ADC_AUDIT_RECEIPT_NO,
			String ADC_AUDIT_RECEIPT_AMT, String ADC_AUDIT_DISPOSAL_NO, String ADC_AUDIT_DISPOSAL_AMT,
			String ADC_AUDIT_OIO_NO, String ADC_AUDIT_OIO_AMT, String ADC_AUDIT_AGE_LESS_3_NO,
			String ADC_AUDIT_AGE_3_TO_6_NO, String ADC_AUDIT_AGE_6_TO_12_NO, String ADC_AUDIT_AGE_MORE_THAN_1_NO,
			String ADC_AUDIT_TIME_LESS_3_NO, String ADC_AUDIT_TIME_3_TO_6_NO, String ADC_AUDIT_TIME_6_TO_12_NO,
			String ADC_AUDIT_TIME_MORE_THAN_1_NO, String

			ADC_INVESTIGATION_OPENING_NO, String ADC_INVESTIGATION_OPENING_AMT, String ADC_INVESTIGATION_RECEIPT_NO,
			String ADC_INVESTIGATION_RECEIPT_AMT, String ADC_INVESTIGATION_DISPOSAL_NO,
			String ADC_INVESTIGATION_DISPOSAL_AMT, String ADC_INVESTIGATION_OIO_NO, String ADC_INVESTIGATION_OIO_AMT,
			String ADC_INVESTIGATION_AGE_LESS_3_NO, String ADC_INVESTIGATION_AGE_3_TO_6_NO,
			String ADC_INVESTIGATION_AGE_6_TO_12_NO, String ADC_INVESTIGATION_AGE_MORE_THAN_1_NO,
			String ADC_INVESTIGATION_TIME_LESS_3_NO, String ADC_INVESTIGATION_TIME_3_TO_6_NO,
			String ADC_INVESTIGATION_TIME_6_TO_12_NO, String ADC_INVESTIGATION_TIME_MORE_THAN_1_NO, String

			ADC_CALLBOOK_OPENING_NO, String ADC_CALLBOOK_OPENING_AMT, String ADC_CALLBOOK_RECEIPT_NO,
			String ADC_CALLBOOK_RECEIPT_AMT, String ADC_CALLBOOK_DISPOSAL_NO, String ADC_CALLBOOK_DISPOSAL_AMT,
			String ADC_CALLBOOK_OIO_NO, String ADC_CALLBOOK_OIO_AMT, String ADC_CALLBOOK_AGE_LESS_3_NO,
			String ADC_CALLBOOK_AGE_3_TO_6_NO, String ADC_CALLBOOK_AGE_6_TO_12_NO,
			String ADC_CALLBOOK_AGE_MORE_THAN_1_NO, String ADC_CALLBOOK_TIME_LESS_3_NO,
			String ADC_CALLBOOK_TIME_3_TO_6_NO, String ADC_CALLBOOK_TIME_6_TO_12_NO,
			String ADC_CALLBOOK_TIME_MORE_THAN_1_NO, String DC_COMMISSIONERATE_OPENING_NO,
			String DC_COMMISSIONERATE_OPENING_AMT, String DC_COMMISSIONERATE_RECEIPT_NO,
			String DC_COMMISSIONERATE_RECEIPT_AMT, String DC_COMMISSIONERATE_DISPOSAL_NO,
			String DC_COMMISSIONERATE_DISPOSAL_AMT, String DC_COMMISSIONERATE_OIO_NO, String DC_COMMISSIONERATE_OIO_AMT,
			String DC_COMMISSIONERATE_AGE_LESS_3_NO, String DC_COMMISSIONERATE_AGE_3_TO_6_NO,
			String DC_COMMISSIONERATE_AGE_6_TO_12_NO, String DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String DC_COMMISSIONERATE_TIME_LESS_3_NO, String DC_COMMISSIONERATE_TIME_3_TO_6_NO,
			String DC_COMMISSIONERATE_TIME_6_TO_12_NO, String DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO, String

			DC_AUDIT_OPENING_NO, String DC_AUDIT_OPENING_AMT, String DC_AUDIT_RECEIPT_NO, String DC_AUDIT_RECEIPT_AMT,
			String DC_AUDIT_DISPOSAL_NO, String DC_AUDIT_DISPOSAL_AMT, String DC_AUDIT_OIO_NO, String DC_AUDIT_OIO_AMT,
			String DC_AUDIT_AGE_LESS_3_NO, String DC_AUDIT_AGE_3_TO_6_NO, String DC_AUDIT_AGE_6_TO_12_NO,
			String DC_AUDIT_AGE_MORE_THAN_1_NO, String DC_AUDIT_TIME_LESS_3_NO, String DC_AUDIT_TIME_3_TO_6_NO,
			String DC_AUDIT_TIME_6_TO_12_NO, String DC_AUDIT_TIME_MORE_THAN_1_NO, String

			DC_INVESTIGATION_OPENING_NO, String DC_INVESTIGATION_OPENING_AMT, String DC_INVESTIGATION_RECEIPT_NO,
			String DC_INVESTIGATION_RECEIPT_AMT, String DC_INVESTIGATION_DISPOSAL_NO,
			String DC_INVESTIGATION_DISPOSAL_AMT, String DC_INVESTIGATION_OIO_NO, String DC_INVESTIGATION_OIO_AMT,
			String DC_INVESTIGATION_AGE_LESS_3_NO, String DC_INVESTIGATION_AGE_3_TO_6_NO,
			String DC_INVESTIGATION_AGE_6_TO_12_NO, String DC_INVESTIGATION_AGE_MORE_THAN_1_NO,
			String DC_INVESTIGATION_TIME_LESS_3_NO, String DC_INVESTIGATION_TIME_3_TO_6_NO,
			String DC_INVESTIGATION_TIME_6_TO_12_NO, String DC_INVESTIGATION_TIME_MORE_THAN_1_NO, String

			DC_CALLBOOK_OPENING_NO, String DC_CALLBOOK_OPENING_AMT, String DC_CALLBOOK_RECEIPT_NO,
			String DC_CALLBOOK_RECEIPT_AMT, String DC_CALLBOOK_DISPOSAL_NO, String DC_CALLBOOK_DISPOSAL_AMT,
			String DC_CALLBOOK_OIO_NO, String DC_CALLBOOK_OIO_AMT, String DC_CALLBOOK_AGE_LESS_3_NO,
			String DC_CALLBOOK_AGE_3_TO_6_NO, String DC_CALLBOOK_AGE_6_TO_12_NO, String DC_CALLBOOK_AGE_MORE_THAN_1_NO,
			String DC_CALLBOOK_TIME_LESS_3_NO, String DC_CALLBOOK_TIME_3_TO_6_NO, String DC_CALLBOOK_TIME_6_TO_12_NO,
			String DC_CALLBOOK_TIME_MORE_THAN_1_NO,

			String SUPERINTENDENT_COMMISSIONERATE_OPENING_NO, String SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT,
			String SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO, String SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT,
			String SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO, String SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT,
			String SUPERINTENDENT_COMMISSIONERATE_OIO_NO, String SUPERINTENDENT_COMMISSIONERATE_OIO_AMT,
			String SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO, String SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO,
			String SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO,
			String SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO,
			String SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO, String SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO,
			String SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO,
			String SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO, String

			SUPERINTENDENT_AUDIT_OPENING_NO, String SUPERINTENDENT_AUDIT_OPENING_AMT,
			String SUPERINTENDENT_AUDIT_RECEIPT_NO, String SUPERINTENDENT_AUDIT_RECEIPT_AMT,
			String SUPERINTENDENT_AUDIT_DISPOSAL_NO, String SUPERINTENDENT_AUDIT_DISPOSAL_AMT,
			String SUPERINTENDENT_AUDIT_OIO_NO, String SUPERINTENDENT_AUDIT_OIO_AMT,
			String SUPERINTENDENT_AUDIT_AGE_LESS_3_NO, String SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO,
			String SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO, String SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO,
			String SUPERINTENDENT_AUDIT_TIME_LESS_3_NO, String SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO,
			String SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO, String SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO, String

			SUPERINTENDENT_INVESTIGATION_OPENING_NO, String SUPERINTENDENT_INVESTIGATION_OPENING_AMT,
			String SUPERINTENDENT_INVESTIGATION_RECEIPT_NO, String SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT,
			String SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO, String SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT,
			String SUPERINTENDENT_INVESTIGATION_OIO_NO, String SUPERINTENDENT_INVESTIGATION_OIO_AMT,
			String SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO, String SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO,
			String SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO, String SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO,
			String SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO, String SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO,
			String SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO,
			String SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO, String

			SUPERINTENDENT_CALLBOOK_OPENING_NO, String SUPERINTENDENT_CALLBOOK_OPENING_AMT,
			String SUPERINTENDENT_CALLBOOK_RECEIPT_NO, String SUPERINTENDENT_CALLBOOK_RECEIPT_AMT,
			String SUPERINTENDENT_CALLBOOK_DISPOSAL_NO, String SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT,
			String SUPERINTENDENT_CALLBOOK_OIO_NO, String SUPERINTENDENT_CALLBOOK_OIO_AMT,
			String SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO, String SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO,
			String SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO, String SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO,
			String SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO, String SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO,
			String SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO, String SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO,
			String p_CRR);
	
	public String generateResult_SP_DPM_GST_ADJ_1_INSERT_OPENING(String p_COMM_CODE, String p_MM_YYYY,
			String ADC_COMMISSIONERATE_OPENING_NO, String ADC_COMMISSIONERATE_OPENING_AMT,
			String ADC_AUDIT_OPENING_NO ,String ADC_AUDIT_OPENING_AMT ,
			String ADC_INVESTIGATION_OPENING_NO , String ADC_INVESTIGATION_OPENING_AMT ,
			String ADC_CALLBOOK_OPENING_NO ,String ADC_CALLBOOK_OPENING_AMT ,
			String DC_COMMISSIONERATE_OPENING_NO ,String DC_COMMISSIONERATE_OPENING_AMT ,
			String DC_AUDIT_OPENING_NO ,String DC_AUDIT_OPENING_AMT ,
			String DC_INVESTIGATION_OPENING_NO ,String DC_INVESTIGATION_OPENING_AMT ,
			String DC_CALLBOOK_OPENING_NO ,String DC_CALLBOOK_OPENING_AMT ,
			String SUPERINTENDENT_COMMISSIONERATE_OPENING_NO ,String SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT ,
			String SUPERINTENDENT_AUDIT_OPENING_NO ,String SUPERINTENDENT_AUDIT_OPENING_AMT ,
			String SUPERINTENDENT_INVESTIGATION_OPENING_NO ,String SUPERINTENDENT_INVESTIGATION_OPENING_AMT ,
			String SUPERINTENDENT_CALLBOOK_OPENING_NO ,String SUPERINTENDENT_CALLBOOK_OPENING_AMT 
			);
}
