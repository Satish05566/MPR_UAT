package com.ddm.cbic.gstddm.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_ALL_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_ZONE_Result;

@Repository
public interface GSTDDM_DDM_GST_3A_Dao {

	public List<SP_DDM_GST_3A_ALL_Result> generateResultBeanList_SP_DDM_GST_3A_ALL(String _MM_YYYY);

	public List<SP_DDM_GST_3A_ZONE_Result> generateResultBeanList_SP_DDM_GST_3A_ZONE(String code, String _MM_YYYY);

	public List<SP_DDM_GST_3A_COMM_Result> generateResultBeanList_SP_DDM_GST_3A_COMM(String code, String _MM_YYYY);

	public List<SP_DDM_GST_3A_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DDM_GST_3A_COMM_TEMP_REPORT(
			Object[] objArray);

	public List<SP_DDM_GST_3A_COMM_TEMP_Result> generateResultBeanList_SP_DDM_GST_3A_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request);

	public String generateResult_SP_DDM_GST_3A_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, String p_SR_NO,
			String p_GSTIN, String p_NAME_OF_TAXPAYER, String p_CASH_FOR_CURRENT, String p_ITC_FOR_CURRENT,
			String p_CASH_UPTO_CURRENT, String p_ITC_UPTO_CURRENT, String p_CASH_FOR_PREV, String p_ITC_FOR_PREV,
			String p_CASH_UPTO_PREV, String p_ITC_UPTO_PREV, String p_REASON_FOR_INCREASE_REVENUE, String p_CRR);

	public String generateResult_SP_DDM_GST_3A_INSERT(String p_COMM_CODE, String p_MM_YYYY, String p_SR_NO,
			String p_GSTIN, String p_NAME_OF_TAXPAYER, String p_CASH_FOR_CURRENT, String p_ITC_FOR_CURRENT,
			String p_CASH_UPTO_CURRENT, String p_ITC_UPTO_CURRENT, String p_CASH_FOR_PREV, String p_ITC_FOR_PREV,
			String p_CASH_UPTO_PREV, String p_ITC_UPTO_PREV, String p_REASON_FOR_INCREASE_REVENUE, String p_CRR);

	public Object generateResult_SP_DDM_GST_3A_MAX_DATE(String objArray);

	public String generateResult_SP_SUBMISSION_DDM_CUS_GST(String comm_code, String user, String remoteAddr,
			String report_Group);

}
