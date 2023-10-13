package com.ddm.cbic.gstddm.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_ALL_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_OTHERS_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_REGION_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_ZONE_Result;


public interface GSTDDM_DDM_GST_2_Dao {

	public Object generateResult_SP_DDM_GST_2_MAX_DATE(String code);

	public SP_DDM_GST_2_COMM_TEMP_Result generateResult_SP_DDM_GST_2_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request);

	public String generateResult_SP_DDM_GST_2_UPDATE(String code, String mm_yyyy, String audit_RECOVERY,
			String anti_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS, String recovery_OF_CONFIRMED_DEMANDS,
			String pre_DEPOSITS, String scrutiny_OF_GST_RETURNS, String recovery_FROM_DEFAULTERS,
			String finalisation_OF_PROVISIONAL_ASSESSMENTS, String others_NAME, String others_VALUE, Object crr);


	public String generateResult_SP_DDM_GST_2_INSERT(String code, String mm_yyyy, String audit_RECOVERY,
			String anti_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS, String recovery_OF_CONFIRMED_DEMANDS,
			String pre_DEPOSITS, String scrutiny_OF_GST_RETURNS, String recovery_FROM_DEFAULTERS,
			String finalisation_OF_PROVISIONAL_ASSESSMENTS, String others_NAME, String others_VALUE);



	public SP_DDM_GST_2_ALL_Result generateResult_SP_DDM_GST_2_ALL(String mm_yyyy);

	public SP_DDM_GST_2_REGION_Result generateResult_SP_DDM_GST_2_REGION(String code, String mm_yyyy);

	public SP_DDM_GST_2_ZONE_Result generateResult_SP_DDM_GST_2_ZONE(String code, String mm_yyyy);

	public SP_DDM_GST_2_COMM_Result generateResult_SP_DDM_GST_2_COMM(String code, String mm_yyyy);

	public SP_DDM_GST_2_COMM_TEMP_REPORT_Result generateResult_SP_DDM_GST_2_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object object, Object object2, Object object3);

	public List<SP_DDM_GST_2_OTHERS_Result> generateResult_SP_DDM_GST_2_OTHERS();


	
	
	

}
