package com.ddm.cbic.gstgi.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_2_Dao;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_ZONE_Result;

@Repository
public class GSTGI_GI_GST_2_Dao_Impl implements GSTGI_GI_GST_2_Dao {
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;

	@Override
	public Object generateResult_SP_GI_GST_2_MAX_DATE(String code) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.execute();
		return query.getResultList().get(0);
	}

	@Override
	public SP_GI_GST_2_COMM_TEMP_Result generateResult_SP_GI_GST_2_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if (crr == null || crr == "")
			crr = null;
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_COMM_TEMP");
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
		return new SP_GI_GST_2_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_2_COMM_TEMP_REPORT_Result generateResult_SP_GI_GST_2_COMM_TEMP_REPORT(String code, String mm_yyyy,
			Object crr, Object bak, Object submission_Date) {
		if (crr == null || crr == "")
			crr = null;
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_COMM_TEMP_REPORT");
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

		return new SP_GI_GST_2_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_2_ALL_Result generateResult_SP_GI_GST_2_ALL(String mm_yyyy) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.execute();
		return new SP_GI_GST_2_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_2_REGION_Result generateResult_SP_GI_GST_2_REGION(String code, String mm_yyyy) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.execute();
		return new SP_GI_GST_2_REGION_Result().generateRegionResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_2_ZONE_Result generateResult_SP_GI_GST_2_ZONE(String code, String mm_yyyy) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.execute();
		return new SP_GI_GST_2_ZONE_Result().generateZoneResult(query.getResultList());
	}

	@Override
	public SP_GI_GST_2_COMM_Result generateResult_SP_GI_GST_2_COMM(String code, String mm_yyyy) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.execute();
		return new SP_GI_GST_2_COMM_Result().generateCommResult(query.getResultList());
	}

	@Override
	public String generateResult_SP_GI_GST_2_UPDATE(String code, String mm_yyyy, String OPENING_BALANCE_NO,
			String OPENING_BALANCE_TAX, String RECEIPT_NO, String RECEIPT_TAX, String SCN_NO_DURING_THE_MOTNH,
			String SCN_TAX_DURING_THE_MOTNH, String VOLUNTARY_NO_DURING_THE_MOTNH,
			String VOLUNTARY_TAX_DURING_THE_MOTNH, String MERIT_NO_DURING_THE_MOTNH, String MERIT_TAX_DURING_THE_MOTNH,
			String TRANSFER_NO_DURING_THE_MOTNH, String TRANSFER_TAX_DURING_THE_MOTNH, String LESS_THAN_2_NO,
			String LESS_THAN_2_TAX, String MORE_THAN_2_NO, String MORE_THAN_2_TAX, Object crr) {
		if (crr == null || crr == "")
			crr = null;
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, OPENING_BALANCE_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, OPENING_BALANCE_TAX);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, RECEIPT_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, RECEIPT_TAX);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, SCN_NO_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, SCN_TAX_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, VOLUNTARY_NO_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, VOLUNTARY_TAX_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, MERIT_NO_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, MERIT_TAX_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, TRANSFER_NO_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, TRANSFER_TAX_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, LESS_THAN_2_NO);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, LESS_THAN_2_TAX);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, MORE_THAN_2_NO);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, MORE_THAN_2_TAX);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		if (crr != null)
			query.setParameter(19, crr);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(20).toString();
	}

	@Override
	public String generateResult_SP_GI_GST_2_INSERT(String code, String mm_yyyy, String OPENING_BALANCE_NO,
			String OPENING_BALANCE_TAX, String RECEIPT_NO, String RECEIPT_TAX, String SCN_NO_DURING_THE_MOTNH,
			String SCN_TAX_DURING_THE_MOTNH, String VOLUNTARY_NO_DURING_THE_MOTNH,
			String VOLUNTARY_TAX_DURING_THE_MOTNH, String MERIT_NO_DURING_THE_MOTNH, String MERIT_TAX_DURING_THE_MOTNH,
			String TRANSFER_NO_DURING_THE_MOTNH, String TRANSFER_TAX_DURING_THE_MOTNH, String LESS_THAN_2_NO,
			String LESS_THAN_2_TAX, String MORE_THAN_2_NO, String MORE_THAN_2_TAX) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, OPENING_BALANCE_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, OPENING_BALANCE_TAX);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, RECEIPT_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, RECEIPT_TAX);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, SCN_NO_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, SCN_TAX_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, VOLUNTARY_NO_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, VOLUNTARY_TAX_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, MERIT_NO_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, MERIT_TAX_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, TRANSFER_NO_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, TRANSFER_TAX_DURING_THE_MOTNH);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, LESS_THAN_2_NO);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, LESS_THAN_2_TAX);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, MORE_THAN_2_NO);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, MORE_THAN_2_TAX);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(19).toString();

	}
	
	@Override
	public Object generateResult_SP_GI_GST_2_MARCH_DATA_CHECK(String code) {
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_MARCH_DATA_CHECK");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.execute();
		return query.getResultList().get(0);
	}

	@Override
	public String generateResult_SP_GI_GST_2_INSERT_OPENING(String code, String mm_yyyy, String opening_BALANCE_NO,
			String opening_BALANCE_AMOUNT) {
		
		query = entityManager.createStoredProcedureQuery("SP_GI_GST_2_INSERT_OPENING");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, opening_BALANCE_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, opening_BALANCE_AMOUNT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);
		query.execute();
		return query.getOutputParameterValue(5).toString();
	}

}
