package com.ddm.cbic.gstddm.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_ALL_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_ZONE_Result;


@Repository
public interface GSTDDM_DDM_GST_4_Dao {
	public List<SP_DDM_GST_4_ALL_Result> generateResultBeanList_SP_DDM_GST_4_ALL(String _MM_YYYY);

	public List<SP_DDM_GST_4_ZONE_Result> generateResultBeanList_SP_DDM_GST_4_ZONE(String code, String _MM_YYYY);

	public List<SP_DDM_GST_4_COMM_Result> generateResultBeanList_SP_DDM_GST_4_COMM(String code, String _MM_YYYY);

	public List<SP_DDM_GST_4_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DDM_GST_4_COMM_TEMP_REPORT(
			Object[] objArray);

	public List<SP_DDM_GST_4_COMM_TEMP_Result> generateResultBeanList_SP_DDM_GST_4_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request);

	public String generateResult_SP_DDM_GST_4_INSERT(String p_COMM_CODE, String p_MM_YYYY, String p_SERVICE_NAME,
			String p_CUR_YEAR_FOR, String p_CUR_YEAR_UPTO, String p_PRE_YEAR_FOR, String p_PRE_YEAR_UPTO,
			String p_REASONS);

	public String generateResult_SP_DDM_GST_4_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, String p_SNO,
			String p_SERVICE_CODE, String p_SERVICE_NAME, String p_CUR_YEAR_FOR, String p_CUR_YEAR_UPTO,
			String p_PRE_YEAR_FOR, String p_PRE_YEAR_UPTO, String p_REASONS, String p_CRR);

	public Object generateResult_SP_DDM_GST_4_MAX_DATE(String objArray);

	public String generateResult_SP_SUBMISSION_DDM_GST(String comm_code, String user, String remoteAddr,
			String report_Group);


}
