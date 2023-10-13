package com.ddm.cbic.gstgi.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstgi.model.SP_GI_GST_5_ALL;
import com.ddm.cbic.gstgi.model.SP_GI_GST_5_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_5_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_5_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_5_ZONE_Result;

@Repository
public interface GSTGI_GI_GST_5_Dao {

	public List<SP_GI_GST_5_ALL> generateResultBeanList_SP_GI_GST_5_ALL(String _MM_YYYY);

	public List<SP_GI_GST_5_ZONE_Result> generateResultBeanList_SP_GI_GST_5_ZONE(String code, String _MM_YYYY);

	public List<SP_GI_GST_5_COMM_Result> generateResultBeanList_SP_GI_GST_5_COMM(String code, String _MM_YYYY);

	
	public List<SP_GI_GST_5_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_GI_GST_5_COMM_TEMP_REPORT(
			Object[] objArray);

	public List<SP_GI_GST_5_COMM_TEMP_Result> generateResultBeanList_SP_GI_GST_5_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request);
	
	 public String generateResult_SP_GI_GST_5_INSERT(String p_COMM_CODE, String p_MM_YYYY, 
				String p_SNO,String p_F_NO,String p_NAME_TAXPAYER,String p_ADDRESS_TAXPAYER,String p_GSTIN,
				String p_TAX_EVADED,String p_NAME,String p_DESGINATION, String p_AGE , String p_PAN,
				String p_AADHAR, String p_DATE_ARREST , String p_ROLE_PLAYED ,String p_SANCTION_ORDER_NO
				, String p_SANCTION_ORDER_DATE, String p_NUMBER_PERSONS_PROSECUTED, String p_DATE_FILING_COURT,
				String p_CRIMINAL_COMPLAINT_NUMBER, String p_COURT_ORDER_NO, String p_COURT_ORDER_DATE,
				String p_COURT_DETAIL_ORDER);
	

	public String generateResult_SP_GI_GST_5_TEMP_UPDATE(
			String p_COMM_CODE, String p_MM_YYYY, 
			String p_SNO,String p_F_NO,String p_NAME_TAXPAYER,String p_ADDRESS_TAXPAYER,String p_GSTIN,
			String p_TAX_EVADED,String p_NAME,String p_DESGINATION, String p_AGE , String p_PAN,
			String p_AADHAR, String p_DATE_ARREST , String p_ROLE_PLAYED ,String p_SANCTION_ORDER_NO
			, String p_SANCTION_ORDER_DATE, String p_NUMBER_PERSONS_PROSECUTED, String p_DATE_FILING_COURT,
			String p_CRIMINAL_COMPLAINT_NUMBER, String p_COURT_ORDER_NO, String p_COURT_ORDER_DATE,
			String p_COURT_DETAIL_ORDER,String p_CRR);

	public Object generateResult_SP_GI_GST_5_MAX_DATE(String objArray);

	/*
	 * public String generateResult_SP_SUBMISSION_DDM_CUS_GST(String comm_code,
	 * String user, String remoteAddr, String report_Group);
	 */


}
