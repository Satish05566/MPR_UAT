package com.ddm.cbic.gstgi.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_4_Dao;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_ZONE_Result;

@Repository
public class GSTGI_GI_GST_4_Dao_Impl implements GSTGI_GI_GST_4_Dao {
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;

	@Override
	public Object generateResult_SP_GI_GST_4_MAX_DATE(String code) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_4_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.execute();
		return query.getResultList().get(0);
	}

	@Override
	public SP_GI_GST_4_COMM_TEMP_Result generateResult_SP_GI_GST_4_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if (crr == null || crr == "")
			crr = null;
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_4_COMM_TEMP");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != crr)
			query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
		query.execute();

		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_GI_GST_4_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_4_COMM_TEMP_REPORT_Result generateResult_SP_GI_GST_4_COMM_TEMP_REPORT(String code, String mm_yyyy,
			Object crr, Object bak, Object submission_Date) {
		if (crr == null || crr == "")
			crr = null;
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_4_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (crr != null)
			query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		if (bak != null)
			query.setParameter(4, bak);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		if (submission_Date != null)
			query.setParameter(5, submission_Date);
		query.execute();

		return new SP_GI_GST_4_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_4_ALL_Result generateResult_SP_GI_GST_4_ALL(String mm_yyyy) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_4_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.execute();
		return new SP_GI_GST_4_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_4_REGION_Result generateResult_SP_GI_GST_4_REGION(String code, String mm_yyyy) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_4_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.execute();
		return new SP_GI_GST_4_REGION_Result().generateRegionResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_4_ZONE_Result generateResult_SP_GI_GST_4_ZONE(String code, String mm_yyyy) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_4_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.execute();
		return new SP_GI_GST_4_ZONE_Result().generateZoneResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_4_COMM_Result generateResult_SP_GI_GST_4_COMM(String code, String mm_yyyy) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_4_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.execute();
		return new SP_GI_GST_4_COMM_Result().generateCommResult(query.getResultList());
	}

	@Override
	public String generateResult_SP_GI_GST_4_UPDATE(String code, String mm_yyyy, String AE_1_NO, String AE_2_NO,
			String INSPECTION_PERMISES_NO, String SEARCHES_NO, String INSPECTION_GOODS_NO, String SUMMONS_NO,
			String SEIZUR67_GOODS_NO, String SEIZUR67_GOODS_VALUE, String SEIZUR67_GOODS_TAX,
			String SEIZUR67_VEHICLES_NO, String SEIZUR67_VEHICLES_VALUE, String SEIZUR67_VEHICLES_TAX,
			String SEIZUR67_CURRENCY_NO, String SEIZUR67_CURRENCY_VALUE, String SEIZUR67_CURRENCY_TAX,
			String SEIZUR129_GOODS_NO, String SEIZUR129_GOODS_VALUE, String SEIZUR129_VEHICLES_NO,
			String SEIZUR129_VEHICLES_VALUE, String ATTACHMENT_GOODS_NO, String ATTACHMENT_GOODS_VALUE,
			String ATTACHMENT_PROPERTY_NO, String ATTACHMENT_PROPERTY_VALUE, String ATTACHMENT_ACCOUNT_NO,
			String INCIDENT_NO, String INCIDENT_AMOUNT, Object crr) {
		if (crr == null || crr == "")
			crr = null;
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_4_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, AE_1_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, AE_2_NO);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, INSPECTION_PERMISES_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, SEARCHES_NO);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, INSPECTION_GOODS_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, SUMMONS_NO);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, SEIZUR67_GOODS_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, SEIZUR67_GOODS_VALUE);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, SEIZUR67_GOODS_TAX);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, SEIZUR67_VEHICLES_NO);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, SEIZUR67_VEHICLES_VALUE);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, SEIZUR67_VEHICLES_TAX);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, SEIZUR67_CURRENCY_NO);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, SEIZUR67_CURRENCY_VALUE);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, SEIZUR67_CURRENCY_TAX);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, SEIZUR129_GOODS_NO);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, SEIZUR129_GOODS_VALUE);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, SEIZUR129_VEHICLES_NO);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, SEIZUR129_VEHICLES_VALUE);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, ATTACHMENT_GOODS_NO);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, ATTACHMENT_GOODS_VALUE);
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, ATTACHMENT_PROPERTY_NO);
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, ATTACHMENT_PROPERTY_NO);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, ATTACHMENT_ACCOUNT_NO);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		query.setParameter(27, INCIDENT_NO);
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		query.setParameter(28, INCIDENT_AMOUNT);
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
		if (null != crr) {
			query.setParameter(29, crr);
		}
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(30).toString();
	}

	@Override
	public String generateResult_SP_GI_GST_4_INSERT(String code, String mm_yyyy, String AE_1_NO, String AE_2_NO,
			String INSPECTION_PERMISES_NO, String SEARCHES_NO, String INSPECTION_GOODS_NO, String SUMMONS_NO,
			String SEIZUR67_GOODS_NO, String SEIZUR67_GOODS_VALUE, String SEIZUR67_GOODS_TAX,
			String SEIZUR67_VEHICLES_NO, String SEIZUR67_VEHICLES_VALUE, String SEIZUR67_VEHICLES_TAX,
			String SEIZUR67_CURRENCY_NO, String SEIZUR67_CURRENCY_VALUE, String SEIZUR67_CURRENCY_TAX,
			String SEIZUR129_GOODS_NO, String SEIZUR129_GOODS_VALUE, String SEIZUR129_VEHICLES_NO,
			String SEIZUR129_VEHICLES_VALUE, String ATTACHMENT_GOODS_NO, String ATTACHMENT_GOODS_VALUE,
			String ATTACHMENT_PROPERTY_NO, String ATTACHMENT_PROPERTY_VALUE, String ATTACHMENT_ACCOUNT_NO,
			String INCIDENT_NO, String INCIDENT_AMOUNT) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_4_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, AE_1_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, AE_2_NO);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, INSPECTION_PERMISES_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, SEARCHES_NO);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, INSPECTION_GOODS_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, SUMMONS_NO);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, SEIZUR67_GOODS_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, SEIZUR67_GOODS_VALUE);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, SEIZUR67_GOODS_TAX);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, SEIZUR67_VEHICLES_NO);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, SEIZUR67_VEHICLES_VALUE);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, SEIZUR67_VEHICLES_TAX);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, SEIZUR67_CURRENCY_NO);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, SEIZUR67_CURRENCY_VALUE);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, SEIZUR67_CURRENCY_TAX);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, SEIZUR129_GOODS_NO);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, SEIZUR129_GOODS_VALUE);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, SEIZUR129_VEHICLES_NO);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, SEIZUR129_VEHICLES_VALUE);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, ATTACHMENT_GOODS_NO);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, ATTACHMENT_GOODS_VALUE);
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, ATTACHMENT_PROPERTY_NO);
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, ATTACHMENT_PROPERTY_NO);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, ATTACHMENT_ACCOUNT_NO);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		query.setParameter(27, INCIDENT_NO);
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		query.setParameter(28, INCIDENT_AMOUNT);
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(29).toString();

	}
}
