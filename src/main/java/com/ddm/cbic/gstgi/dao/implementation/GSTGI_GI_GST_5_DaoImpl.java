package com.ddm.cbic.gstgi.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstddm.dao.GSTDDM_DDM_GST_4A_Dao;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_ALL;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_ZONE_Result;
import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_5_Dao;
import com.ddm.cbic.gstgi.model.SP_GI_GST_5_ALL;
import com.ddm.cbic.gstgi.model.SP_GI_GST_5_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_5_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_5_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_5_ZONE_Result;

@Repository
public class GSTGI_GI_GST_5_DaoImpl implements GSTGI_GI_GST_5_Dao {

	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;

	@Override
	public List<SP_GI_GST_5_ALL> generateResultBeanList_SP_GI_GST_5_ALL(String _MM_YYYY) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_5_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, _MM_YYYY);
		query.execute();

		SP_GI_GST_5_ALL sP_GI_GST_5_ALL_Result = new SP_GI_GST_5_ALL();
		return sP_GI_GST_5_ALL_Result.generateResultBeanList(query.getResultList());
	}

	@Override
	public List<SP_GI_GST_5_ZONE_Result> generateResultBeanList_SP_GI_GST_5_ZONE(String code, String _MM_YYYY) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_5_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, _MM_YYYY);
		query.execute();
		SP_GI_GST_5_ZONE_Result sP_GI_GST_5_ZONE_Result = new SP_GI_GST_5_ZONE_Result();
		return sP_GI_GST_5_ZONE_Result.generateResultBeanList(query.getResultList());
	}

	@Override
	public List<SP_GI_GST_5_COMM_Result> generateResultBeanList_SP_GI_GST_5_COMM(String code, String _MM_YYYY) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_5_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, _MM_YYYY);
		query.execute();
		SP_GI_GST_5_COMM_Result sP_GI_GST_5_COMM_Result = new SP_GI_GST_5_COMM_Result();
		return sP_GI_GST_5_COMM_Result.generateResultBeanList(query.getResultList());
	}

	@Override
	public List<SP_GI_GST_5_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_GI_GST_5_COMM_TEMP_REPORT(
			Object[] objArray) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_5_COMM_TEMP_REPORT");
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

		SP_GI_GST_5_COMM_TEMP_REPORT_Result sP_GI_GST_5_COMM_TEMP_REPORT_Result = new SP_GI_GST_5_COMM_TEMP_REPORT_Result();
		return sP_GI_GST_5_COMM_TEMP_REPORT_Result.generateResultBeanList(query.getResultList());
	}

	@Override
	public List<SP_GI_GST_5_COMM_TEMP_Result> generateResultBeanList_SP_GI_GST_5_COMM_TEMP(String code,
			String mM_YYYY, Object crr, HttpServletRequest request) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_5_COMM_TEMP");
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

		return new SP_GI_GST_5_COMM_TEMP_Result().generateResultBeanList(query.getResultList());
	}

	@Override
	public String generateResult_SP_GI_GST_5_INSERT(String p_COMM_CODE, String p_MM_YYYY, 
			String p_SNO,String p_F_NO,String p_NAME_TAXPAYER,String p_ADDRESS_TAXPAYER,String p_GSTIN,
			String p_TAX_EVADED,String p_NAME,String p_DESGINATION, String p_AGE , String p_PAN,
			String p_AADHAR, String p_DATE_ARREST , String p_ROLE_PLAYED ,String p_SANCTION_ORDER_NO
			, String p_SANCTION_ORDER_DATE, String p_NUMBER_PERSONS_PROSECUTED, String p_DATE_FILING_COURT,
			String p_CRIMINAL_COMPLAINT_NUMBER, String p_COURT_ORDER_NO, String p_COURT_ORDER_DATE,
			String p_COURT_DETAIL_ORDER) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_5_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_SNO);
		
		/*
		 * query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		 * query.setParameter(4, p_NAME_TAXPAYER);
		 * query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		 * query.setParameter(5, p_ADDRESS_TAXPAYER);
		 * query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		 * query.setParameter(6, p_GSTIN); query.registerStoredProcedureParameter(7,
		 * String.class, ParameterMode.IN); query.setParameter(7, p_TAX_EVADED);
		 * query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		 * query.setParameter(8, p_NAME); query.registerStoredProcedureParameter(9,
		 * String.class, ParameterMode.IN); query.setParameter(9, p_DESGINATION);
		 * query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		 * query.setParameter(10, p_AGE); query.registerStoredProcedureParameter(11,
		 * String.class, ParameterMode.IN); query.setParameter(11, p_PAN);
		 * query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		 * query.setParameter(12, p_AADHAR); query.registerStoredProcedureParameter(13,
		 * String.class, ParameterMode.IN); query.setParameter(13, p_DATE_ARREST);
		 * query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		 * query.setParameter(14, p_ROLE_PLAYED);
		 * query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		 * query.setParameter(15, p_SANCTION_ORDER_NO);
		 * query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		 * query.setParameter(16, p_SANCTION_ORDER_DATE);
		 * query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		 * query.setParameter(17, p_NUMBER_PERSONS_PROSECUTED);
		 * query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		 * query.setParameter(18, p_DATE_FILING_COURT);
		 * query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		 * query.setParameter(19, p_CRIMINAL_COMPLAINT_NUMBER);
		 * query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		 * query.setParameter(20, p_COURT_ORDER_NO);
		 * query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		 * query.setParameter(21, p_COURT_ORDER_DATE);
		 * query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		 * query.setParameter(22, p_COURT_DETAIL_ORDER);
		 */
		
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_F_NO);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_NAME_TAXPAYER);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_ADDRESS_TAXPAYER);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_GSTIN);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_TAX_EVADED);		
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_NAME);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_DESGINATION);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_AGE);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_PAN);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_AADHAR);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, p_DATE_ARREST);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, p_ROLE_PLAYED);		
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, p_SANCTION_ORDER_NO);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, p_SANCTION_ORDER_DATE);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, p_NUMBER_PERSONS_PROSECUTED);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, p_DATE_FILING_COURT);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, p_CRIMINAL_COMPLAINT_NUMBER);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, p_COURT_ORDER_NO);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, p_COURT_ORDER_DATE);		
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, p_COURT_DETAIL_ORDER);
		
		
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(24).toString();
	}

	@Override
	public String generateResult_SP_GI_GST_5_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, 
			String p_SNO,String p_F_NO,String p_NAME_TAXPAYER,String p_ADDRESS_TAXPAYER,String p_GSTIN,
			String p_TAX_EVADED,String p_NAME,String p_DESGINATION, String p_AGE , String p_PAN,
			String p_AADHAR, String p_DATE_ARREST , String p_ROLE_PLAYED ,String p_SANCTION_ORDER_NO
			, String p_SANCTION_ORDER_DATE, String p_NUMBER_PERSONS_PROSECUTED, String p_DATE_FILING_COURT,
			String p_CRIMINAL_COMPLAINT_NUMBER, String p_COURT_ORDER_NO, String p_COURT_ORDER_DATE,
			String p_COURT_DETAIL_ORDER,String p_CRR) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_5_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_SNO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_F_NO);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_NAME_TAXPAYER);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_ADDRESS_TAXPAYER);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_GSTIN);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_TAX_EVADED);		
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_NAME);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_DESGINATION);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_AGE);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_PAN);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_AADHAR);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, p_DATE_ARREST);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, p_ROLE_PLAYED);		
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, p_SANCTION_ORDER_NO);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, p_SANCTION_ORDER_DATE);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, p_NUMBER_PERSONS_PROSECUTED);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, p_DATE_FILING_COURT);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, p_CRIMINAL_COMPLAINT_NUMBER);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, p_COURT_ORDER_NO);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, p_COURT_ORDER_DATE);		
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, p_COURT_DETAIL_ORDER);
		
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(24, p_CRR);
		}
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(25).toString();
	}

	@Override 
	public Object generateResult_SP_GI_GST_5_MAX_DATE(String objArray) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_5_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, objArray);
		query.execute();
		return query.getResultList().get(0);
	}

	/*
	 * @Override public String generateResult_SP_SUBMISSION_DDM_CUS_GST(String
	 * comm_code, String user, String remoteAddr, String report_Group) { // TODO
	 * Auto-generated method stub return null; }
	 */

}
