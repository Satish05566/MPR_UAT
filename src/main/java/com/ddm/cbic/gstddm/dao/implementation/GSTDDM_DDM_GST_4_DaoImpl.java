package com.ddm.cbic.gstddm.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstddm.dao.GSTDDM_DDM_GST_4_Dao;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_ALL_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_ZONE_Result;

@Repository
public class GSTDDM_DDM_GST_4_DaoImpl implements GSTDDM_DDM_GST_4_Dao {

	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;

	@Override
	public List<SP_DDM_GST_4_ALL_Result> generateResultBeanList_SP_DDM_GST_4_ALL(String _MM_YYYY) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_4_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, _MM_YYYY);
		query.execute();

		SP_DDM_GST_4_ALL_Result sP_DDM_GST_4_ALL_Result = new SP_DDM_GST_4_ALL_Result();
		return sP_DDM_GST_4_ALL_Result.generateResultBeanList(query.getResultList());
	}

	@Override
	public List<SP_DDM_GST_4_ZONE_Result> generateResultBeanList_SP_DDM_GST_4_ZONE(String code, String _MM_YYYY) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_4_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, _MM_YYYY);
		query.execute();
		SP_DDM_GST_4_ZONE_Result sP_DDM_GST_4_ZONE_Result = new SP_DDM_GST_4_ZONE_Result();
		return sP_DDM_GST_4_ZONE_Result.generateResultBeanList(query.getResultList());
	}

	@Override
	public List<SP_DDM_GST_4_COMM_Result> generateResultBeanList_SP_DDM_GST_4_COMM(String code, String _MM_YYYY) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_4_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, _MM_YYYY);
		query.execute();
		SP_DDM_GST_4_COMM_Result sP_DDM_GST_4_COMM_Result = new SP_DDM_GST_4_COMM_Result();
		return sP_DDM_GST_4_COMM_Result.generateResultBeanList(query.getResultList());
	}

	@Override
	public List<SP_DDM_GST_4_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DDM_GST_4_COMM_TEMP_REPORT(
			Object[] objArray) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP_REPORT");
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

		SP_DDM_GST_4_COMM_TEMP_REPORT_Result sP_DDM_GST_4_COMM_TEMP_REPORT_Result = new SP_DDM_GST_4_COMM_TEMP_REPORT_Result();
		return sP_DDM_GST_4_COMM_TEMP_REPORT_Result.generateResultBeanList(query.getResultList());
	}

	@Override
	public List<SP_DDM_GST_4_COMM_TEMP_Result> generateResultBeanList_SP_DDM_GST_4_COMM_TEMP(String code,
			String mM_YYYY, Object crr, HttpServletRequest request) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP");
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

		return new SP_DDM_GST_4_COMM_TEMP_Result().generateResultBeanList(query.getResultList());
	}

	@Override
	public String generateResult_SP_DDM_GST_4_INSERT(String p_COMM_CODE, String p_MM_YYYY,
			String p_SERVICE_NAME, String p_CUR_YEAR_FOR, String p_CUR_YEAR_UPTO, String p_PRE_YEAR_FOR,
			String p_PRE_YEAR_UPTO, String p_REASONS) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_4_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_SERVICE_NAME);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_CUR_YEAR_FOR);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_CUR_YEAR_UPTO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_PRE_YEAR_FOR);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_PRE_YEAR_UPTO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_REASONS);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(9).toString();
	}

	@Override
	public String generateResult_SP_DDM_GST_4_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, String p_SNO,
			String p_SERVICE_CODE, String p_SERVICE_NAME, String p_CUR_YEAR_FOR, String p_CUR_YEAR_UPTO,
			String p_PRE_YEAR_FOR, String p_PRE_YEAR_UPTO, String p_REASONS, String p_CRR) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_4_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, p_SNO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, p_SERVICE_CODE);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, p_SERVICE_NAME);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, p_CUR_YEAR_FOR);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, p_CUR_YEAR_UPTO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, p_PRE_YEAR_FOR);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, p_PRE_YEAR_UPTO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, p_REASONS);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(10, p_CRR);
		}

		query.registerStoredProcedureParameter(11, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(11).toString();
	}

	@Override
	public Object generateResult_SP_DDM_GST_4_MAX_DATE(String objArray) {
		query = entityManager.createStoredProcedureQuery("SP_DDM_GST_4_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, objArray);
		query.execute();
		return query.getResultList().get(0);
	}

	@Override
	public String generateResult_SP_SUBMISSION_DDM_GST(String comm_code, String user, String remoteAddr,
			String report_Group) {
		// TODO Auto-generated method stub
		return null;
	}

}
