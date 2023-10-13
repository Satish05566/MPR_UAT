package com.ddm.cbic.gstddm.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstddm.dao.GSTDDM_DDM_GST_3A_Dao;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_ALL_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_COMM_TEMP_Result;
//import com.ddm.cbic.model.gstddm.SP_GST_REV_3A_COMM_Result;
//import com.ddm.cbic.model.gstddm.SP_GST_REV_3A_COMM_TEMP_REPORT_Result;
//import com.ddm.cbic.model.gstddm.SP_GST_REV_3A_COMM_TEMP_Result;
//import com.ddm.cbic.model.gstddm.SP_GST_REV_3A_ZONE_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_ZONE_Result;

@Repository

public class GSTDDM_DDM_GST_3A_DaoImpl implements GSTDDM_DDM_GST_3A_Dao {
	private static final Logger logger = LoggerFactory.getLogger(GSTDDM_DDM_GST_3A_DaoImpl.class);

	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;

	public List<SP_DDM_GST_3A_ALL_Result> generateResultBeanList_SP_DDM_GST_3A_ALL(String _MM_YYYY) {

		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_3A_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, _MM_YYYY);
		query.execute();

		SP_DDM_GST_3A_ALL_Result sP_GST_REV_3A_ALL_Result = new SP_DDM_GST_3A_ALL_Result();
		return sP_GST_REV_3A_ALL_Result.generateResultBeanList(query.getResultList());
	}

	public List<SP_DDM_GST_3A_ZONE_Result> generateResultBeanList_SP_DDM_GST_3A_ZONE(String code, String _MM_YYYY) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_3A_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);

		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, _MM_YYYY);
		query.execute();
		SP_DDM_GST_3A_ZONE_Result sP_GST_REV_3A_ZONE_Result = new SP_DDM_GST_3A_ZONE_Result();
		return sP_GST_REV_3A_ZONE_Result.generateResultBeanList(query.getResultList());
	}

	public List<SP_DDM_GST_3A_COMM_Result> generateResultBeanList_SP_DDM_GST_3A_COMM(String code, String _MM_YYYY) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_3A_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, _MM_YYYY);
		query.execute();
		SP_DDM_GST_3A_COMM_Result sP_GST_REV_3A_COMM_Result = new SP_DDM_GST_3A_COMM_Result();
		return sP_GST_REV_3A_COMM_Result.generateResultBeanList(query.getResultList());
	}

	public List<SP_DDM_GST_3A_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DDM_GST_3A_COMM_TEMP_REPORT(
			Object[] objArray) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_3A_COMM_TEMP_REPORT");
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

		SP_DDM_GST_3A_COMM_TEMP_REPORT_Result sP_GST_REV_3A_COMM_TEMP_REPORT_Result = new SP_DDM_GST_3A_COMM_TEMP_REPORT_Result();
		return sP_GST_REV_3A_COMM_TEMP_REPORT_Result.generateResultBeanList(query.getResultList());
	}

	public List<SP_DDM_GST_3A_COMM_TEMP_Result> generateResultBeanList_SP_DDM_GST_3A_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request) {

		logger.info("crr-  " + crr);
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_3A_COMM_TEMP");
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
		logger.info("OUT  " + out);

		request.setAttribute("result", out);

		return new SP_DDM_GST_3A_COMM_TEMP_Result().generateResultBeanList(query.getResultList());
	}

	public String generateResult_SP_DDM_GST_3A_INSERT(String p_COMM_CODE, String p_MM_YYYY, String p_SR_NO,
			String p_GSTIN, String p_NAME_OF_TAXPAYER, String p_CASH_FOR_CURRENT, String p_ITC_FOR_CURRENT,
			String p_CASH_UPTO_CURRENT, String p_ITC_UPTO_CURRENT, String p_CASH_FOR_PREV, String p_ITC_FOR_PREV,
			String p_CASH_UPTO_PREV, String p_ITC_UPTO_PREV, String p_REASON_FOR_INCREASE_REVENUE, String p_CRR) {

		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_3A_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		// if(p_SR_NO==null) //p_SR_NO="0"
		query.setParameter(3, "0");
		// else
		// query.setParameter(3, p_SR_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_GSTIN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_NAME_OF_TAXPAYER);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_CASH_FOR_CURRENT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_ITC_FOR_CURRENT);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_CASH_UPTO_CURRENT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_ITC_UPTO_CURRENT);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_CASH_FOR_PREV);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_ITC_FOR_PREV);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_CASH_UPTO_PREV);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_ITC_UPTO_PREV);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, p_REASON_FOR_INCREASE_REVENUE);

		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(15, p_CRR);
		}

		query.registerStoredProcedureParameter(16, String.class, ParameterMode.OUT);

		query.execute();

		return query.getOutputParameterValue(16).toString();
	}

	public String generateResult_SP_DDM_GST_3A_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, String p_SR_NO,
			String p_GSTIN, String p_NAME_OF_TAXPAYER, String p_CASH_FOR_CURRENT, String p_ITC_FOR_CURRENT,
			String p_CASH_UPTO_CURRENT, String p_ITC_UPTO_CURRENT, String p_CASH_FOR_PREV, String p_ITC_FOR_PREV,
			String p_CASH_UPTO_PREV, String p_ITC_UPTO_PREV, String p_REASON_FOR_INCREASE_REVENUE, String p_CRR) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_3A_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_SR_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_GSTIN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_NAME_OF_TAXPAYER);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_CASH_FOR_CURRENT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_ITC_FOR_CURRENT);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_CASH_UPTO_CURRENT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_ITC_UPTO_CURRENT);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_CASH_FOR_PREV);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, p_ITC_FOR_PREV);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, p_CASH_UPTO_PREV);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, p_ITC_UPTO_PREV);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, p_REASON_FOR_INCREASE_REVENUE);

		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(18, p_CRR);
		}

		query.registerStoredProcedureParameter(19, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(19).toString();
	}

	public Object generateResult_SP_DDM_GST_3A_MAX_DATE(String objArray) {
		logger.info("objArray--> " + objArray);
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_3A_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, objArray);
		query.execute();
		return query.getResultList().get(0);
	}

	public String generateResult_SP_SUBMISSION_DDM_CUS_GST(String comm_code, String user, String remoteAddr,
			String report_Group) {

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_SUBMISSION_DDM_CUS_GST");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, comm_code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, user);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, remoteAddr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, report_Group);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);

		query.execute();
		logger.info(" SP_SUBMISSION_DDM_CUS_GST Result " + query.getOutputParameterValue(5));
		return query.getOutputParameterValue(5).toString();
	}

}
