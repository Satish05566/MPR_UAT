package com.ddm.cbic.gstdpm.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_16_Dao;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_REFUND_CATEGORY;
import com.ddm.cbic.gstdpm.model.SP_DGI_GST_16_ZONE_Result;


@Repository
public class GSTDPM_DPM_GST_16_DaoImpl implements  GSTDPM_DPM_GST_16_Dao{
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	@SuppressWarnings("unchecked")
	public List<SP_DGI_GST_16_ALL_Result> generateResult_SP_DGI_GST_16_ALL(String mm_yyyy) {
		// TODO Auto-generated method stub
		query= entityManager.createStoredProcedureQuery("SP_DGI_GST_16_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.execute();				
		return new SP_DGI_GST_16_ALL_Result().generateAllResult(query.getResultList());
	}
	
	public List<SP_DGI_GST_16_ZONE_Result> generateResult_SP_DGI_GST_16_ZONE(String zone ,String mm_yyyy) {
		// TODO Auto-generated method stub
		query= entityManager.createStoredProcedureQuery("SP_DGI_GST_16_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1, zone);			
		query.setParameter(2, mm_yyyy);							
		query.execute();				
		return new SP_DGI_GST_16_ZONE_Result().generateAllResult(query.getResultList());
	}
	public List<SP_DGI_GST_16_COMM_Result> generateResult_SP_DGI_GST_16_COMM(String comm ,String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DGI_GST_16_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1, comm);			
		query.setParameter(2, mm_yyyy);								
		query.execute();				
		return new SP_DGI_GST_16_COMM_Result().generateAllResult(query.getResultList());
	}
	
	public Object generateResult_SP_DGI_GST_16_MAX_DATE(String comm) {
		query = entityManager.createStoredProcedureQuery("SP_GST_RFD_16_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, comm);
		query.execute();
		return query.getResultList().get(0);
	}
	public List<SP_DGI_GST_16_COMM_TEMP_REPORT_Result> 
	generateResultBeanList_SP_DGI_GST_16_COMM_TEMP_REPORT(
			Object[] objArray) {
		query = entityManager.createStoredProcedureQuery("SP_DGI_GST_16_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != objArray[0]) {
			query.setParameter(1, objArray[0]);
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if (null != objArray[1]) {
			query.setParameter(2, objArray[1]);
		}
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != objArray[2]) {
			query.setParameter(3, objArray[2]);
		}
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		if (null != objArray[3]) {
			query.setParameter(4, objArray[3]);
		}
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		if (null != objArray[4]) {
			query.setParameter(5, objArray[4]);
		}
		query.execute();

		return new SP_DGI_GST_16_COMM_TEMP_REPORT_Result().generateAllResult(query.getResultList());
	}
	
	// -------------------------------------------------------------------------------
	public List<SP_DGI_GST_16_COMM_TEMP_Result> generateResultBeanList_SP_DGI_GST_16_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request) {
		
		query = entityManager.createStoredProcedureQuery("SP_DGI_GST_16_COMM_TEMP");
		if (crr == null || crr == "")
			crr = null;

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != code) {
			query.setParameter(1, code);
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN); 
		if (null != mM_YYYY) {
			query.setParameter(2, mM_YYYY);
		}
		
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != crr) {
			query.setParameter(3, crr);
		}
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
		query.execute();

		String out = (String) query.getOutputParameterValue(4);

		request.setAttribute("result", out);

		return new SP_DGI_GST_16_COMM_TEMP_Result().generateAllResult(query.getResultList());
	}

	//---------------------------------
	public String generateResult_SP_DGI_GST_16_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, 
			String p_SR_NO, String p_REFUND_CATEGORY, String p_OPENING_BALANCE_NO,
			String p_OPENING_BALANCE_AMOUNT, String p_RFD_01_NO, String p_RFD_01_AMOUNT,
			String p_RFD_02_NO,String p_RFD_03_NO,
			String p_RFD_03_AMOUNT, String p_RFD_04_NO,String p_RFD_04_AMOUNT,String p_RFD_06_SANCTIONED_NO,
			String p_RFD_06_SANCTIONED_AMOUNT,String p_RFD_06_REJECTED_NO,String p_RFD_06_REJECTED_AMOUNT,
			String p_AGE_BREAKUP_30_45_NO,String p_AGE_BREAKUP_30_45_AMOUNT,String p_AGE_BREAKUP_46_60_NO,
			String p_AGE_BREAKUP_46_60_AMOUNT,String p_AGE_BREAKUP_ABOVE60_NO, String p_AGE_BREAKUP_ABOVE60_AMOUNT,
			String p_CRR) {
		query = entityManager.createStoredProcedureQuery("SP_DGI_GST_16_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_SR_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_REFUND_CATEGORY);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_OPENING_BALANCE_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_OPENING_BALANCE_AMOUNT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_RFD_01_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_RFD_01_AMOUNT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_RFD_02_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_RFD_03_NO);
		
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_RFD_03_AMOUNT);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_RFD_04_NO);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_RFD_04_AMOUNT);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, p_RFD_06_SANCTIONED_NO);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, p_RFD_06_SANCTIONED_AMOUNT);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, p_RFD_06_REJECTED_NO);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, p_RFD_06_REJECTED_AMOUNT);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, p_AGE_BREAKUP_30_45_NO);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, p_AGE_BREAKUP_30_45_AMOUNT);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, p_AGE_BREAKUP_46_60_NO);
		
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, p_AGE_BREAKUP_46_60_AMOUNT);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, p_AGE_BREAKUP_ABOVE60_NO);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, p_AGE_BREAKUP_ABOVE60_AMOUNT);
		
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(24, p_CRR);
		}

		query.registerStoredProcedureParameter(25, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(25).toString();
	}

	
	public String generateResult_SP_DGI_GST_16_INSERT(String p_COMM_CODE, String p_MM_YYYY, 
			String p_SR_NO, String p_REFUND_CATEGORY, String p_OPENING_BALANCE_NO,
			String p_OPENING_BALANCE_AMOUNT, String p_RFD_01_NO, String p_RFD_01_AMOUNT,
			String p_RFD_02_NO,String p_RFD_03_NO,
			String p_RFD_03_AMOUNT, String p_RFD_04_NO,String p_RFD_04_AMOUNT,String p_RFD_06_SANCTIONED_NO,
			String p_RFD_06_SANCTIONED_AMOUNT,String p_RFD_06_REJECTED_NO,String p_RFD_06_REJECTED_AMOUNT,
			String p_AGE_BREAKUP_30_45_NO,String p_AGE_BREAKUP_30_45_AMOUNT,String p_AGE_BREAKUP_46_60_NO,
			String p_AGE_BREAKUP_46_60_AMOUNT,String p_AGE_BREAKUP_ABOVE60_NO, String p_AGE_BREAKUP_ABOVE60_AMOUNT,
			String p_CRR) {

		query = entityManager.createStoredProcedureQuery("SP_DGI_GST_16_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_SR_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_REFUND_CATEGORY);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_OPENING_BALANCE_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_OPENING_BALANCE_AMOUNT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_RFD_01_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_RFD_01_AMOUNT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_RFD_02_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_RFD_03_NO);
		
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_RFD_03_AMOUNT);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_RFD_04_NO);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_RFD_04_AMOUNT);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, p_RFD_06_SANCTIONED_NO);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, p_RFD_06_SANCTIONED_AMOUNT);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, p_RFD_06_REJECTED_NO);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, p_RFD_06_REJECTED_AMOUNT);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, p_AGE_BREAKUP_30_45_NO);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, p_AGE_BREAKUP_30_45_AMOUNT);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, p_AGE_BREAKUP_46_60_NO);
		
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, p_AGE_BREAKUP_46_60_AMOUNT);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, p_AGE_BREAKUP_ABOVE60_NO);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, p_AGE_BREAKUP_ABOVE60_AMOUNT);
		
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(24, p_CRR);
		}

		query.registerStoredProcedureParameter(25, String.class, ParameterMode.OUT);

		query.execute();

		return query.getOutputParameterValue(25).toString();
	}

	public List<SP_DGI_GST_16_REFUND_CATEGORY> generateResultBeanSP_DGI_GST_16_REFUND_LIST(){
		query= entityManager.createStoredProcedureQuery("SP_DGI_GST_16_REFUND_CATEGORY");
		query.execute();				
		return new SP_DGI_GST_16_REFUND_CATEGORY().generateAllResult(query.getResultList());
	}
	
		
}
