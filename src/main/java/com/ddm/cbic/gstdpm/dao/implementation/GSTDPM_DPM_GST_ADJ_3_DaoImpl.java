package com.ddm.cbic.gstdpm.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_ADJ_3_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_ZONE_Result;


@Repository
public class GSTDPM_DPM_GST_ADJ_3_DaoImpl implements  GSTDPM_DPM_GST_ADJ_3_Dao{
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;

	

	private SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result sp_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result = new SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result();
	
	@SuppressWarnings("unchecked")
	public List<SP_DPM_GST_ADJ_3_ALL_Result> generateResult_SP_DPM_GST_ADJ_3_ALL(String mm_yyyy) {
		// TODO Auto-generated method stub
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_3_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.execute();				
		return new SP_DPM_GST_ADJ_3_ALL_Result().generateAllResult(query.getResultList());
	}
	
	public List<SP_DPM_GST_ADJ_3_ZONE_Result> generateResult_SP_DPM_GST_ADJ_3_ZONE(String zone ,String mm_yyyy) {
		// TODO Auto-generated method stub
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_3_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);			
		query.setParameter(2,zone );							
		query.execute();				
		return new SP_DPM_GST_ADJ_3_ZONE_Result().generateAllResult(query.getResultList());
	}
	public List<SP_DPM_GST_ADJ_3_COMM_Result> generateResult_SP_DPM_GST_ADJ_3_COMM(String comm ,String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_3_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1,mm_yyyy );			
		query.setParameter(2, comm);								
		query.execute();				
		return new SP_DPM_GST_ADJ_3_COMM_Result().generateAllResult(query.getResultList());
	}
	
	public Object generateResult_SP_DPM_GST_ADJ_3_MAX_DATE(String comm) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_3_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, comm);
		query.execute();
		return query.getResultList().get(0);
	}
	


	
	public List<SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT(
			Object[] objArray) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT");
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

		return new SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT_Result().generateAllResult(query.getResultList());
	}
	
	// -------------------------------------------------------------------------------
		
	public List<SP_DPM_GST_ADJ_3_COMM_TEMP_Result> generateResultBeanList_SP_DPM_GST_ADJ_3_COMM_TEMP(String mM_YYYY,
			String code, Object crr, HttpServletRequest request) {
		
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_3_COMM_TEMP");
		if (crr == null || crr == "")
			crr = null;

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != code) {
			query.setParameter(1,mM_YYYY );
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN); 
		if (null != mM_YYYY) {
			query.setParameter(2,code );
		}
		
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != crr) {
			query.setParameter(3, crr);
		}
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
		query.execute();

		String out = (String) query.getOutputParameterValue(4);

		request.setAttribute("result", out);

		return new SP_DPM_GST_ADJ_3_COMM_TEMP_Result().generateAllResult(query.getResultList());
	}

	//---------------------------------
	public String generateResult_SP_DPM_GST_ADJ_3_TEMP_UPDATE(String p_COMM_CODE, String p_MM_YYYY, 
			String REASON_ID,String REASON_FOR_KEEPING_IN_CALL_BOOK,
			String ADC_OPENING_NO,String ADC_OPENING_AMT,String ADC_RECEIPT_NO,String ADC_RECEIPT_AMT,String ADC_DISPOSAL_NO,
			String ADC_DISPOSAL_AMT,String ADC_AGE_LESS_6_NO,String ADC_AGE_6_TO_12_NO,String ADC_AGE_1_TO_2_NO,
			String ADC_AGE_MORE_THAN_2_NO,String DC_OPENING_NO,String DC_OPENING_AMT,String DC_RECEIPT_NO,
			String DC_RECEIPT_AMT,String DC_DISPOSAL_NO,String DC_DISPOSAL_AMT,String DC_AGE_LESS_6_NO,
			String DC_AGE_6_TO_12_NO,String DC_AGE_1_TO_2_NO,String DC_AGE_MORE_THAN_2_NO,String SUP_OPENING_NO,
			String SUP_OPENING_AMT,String SUP_RECEIPT_NO,String SUP_RECEIPT_AMT,String SUP_DISPOSAL_NO,
			String SUP_DISPOSAL_AMT,String SUP_AGE_LESS_6_NO,String SUP_AGE_6_TO_12_NO,String SUP_AGE_1_TO_2_NO,
			String SUP_AGE_MORE_THAN_2_NO,
			String p_CRR) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_3_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, REASON_ID);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, REASON_FOR_KEEPING_IN_CALL_BOOK);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, ADC_OPENING_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, ADC_OPENING_AMT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, ADC_RECEIPT_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, ADC_RECEIPT_AMT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, ADC_DISPOSAL_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, ADC_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, ADC_AGE_LESS_6_NO);
		
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, ADC_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, ADC_AGE_1_TO_2_NO);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, ADC_AGE_MORE_THAN_2_NO);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, DC_OPENING_NO);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, DC_OPENING_AMT);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, DC_RECEIPT_NO);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, DC_RECEIPT_AMT);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, DC_DISPOSAL_NO);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, DC_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, DC_AGE_LESS_6_NO);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, DC_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, DC_AGE_1_TO_2_NO);
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, DC_AGE_MORE_THAN_2_NO);
		
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, SUP_OPENING_NO);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, SUP_OPENING_AMT);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		query.setParameter(27, SUP_RECEIPT_NO);
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		query.setParameter(28, SUP_RECEIPT_AMT);
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
		query.setParameter(29, SUP_DISPOSAL_NO);
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.IN);
		query.setParameter(30, SUP_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(31, String.class, ParameterMode.IN);
		query.setParameter(31, SUP_AGE_LESS_6_NO);
		query.registerStoredProcedureParameter(32, String.class, ParameterMode.IN);
		query.setParameter(32, SUP_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(33, String.class, ParameterMode.IN);
		query.setParameter(33, SUP_AGE_1_TO_2_NO);
		query.registerStoredProcedureParameter(34, String.class, ParameterMode.IN);
		query.setParameter(34, SUP_AGE_MORE_THAN_2_NO);
		
		
		query.registerStoredProcedureParameter(35, String.class, ParameterMode.IN);
		if (null != p_CRR) {
			query.setParameter(34, p_CRR);
		}

		query.registerStoredProcedureParameter(36, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(36).toString();
	}

	public String generateResult_SP_DPM_GST_ADJ_3_TEMP_UPLOAD(String p_COMM_CODE, String p_MM_YYYY, 
			String REASON_ID,String REASON_FOR_KEEPING_IN_CALL_BOOK,
			String ADC_OPENING_NO,String ADC_OPENING_AMT,String ADC_RECEIPT_NO,String ADC_RECEIPT_AMT,String ADC_DISPOSAL_NO,
			String ADC_DISPOSAL_AMT,String ADC_AGE_LESS_6_NO,String ADC_AGE_6_TO_12_NO,String ADC_AGE_1_TO_2_NO,
			String ADC_AGE_MORE_THAN_2_NO,String DC_OPENING_NO,String DC_OPENING_AMT,String DC_RECEIPT_NO,
			String DC_RECEIPT_AMT,String DC_DISPOSAL_NO,String DC_DISPOSAL_AMT,String DC_AGE_LESS_6_NO,
			String DC_AGE_6_TO_12_NO,String DC_AGE_1_TO_2_NO,String DC_AGE_MORE_THAN_2_NO,String SUP_OPENING_NO,
			String SUP_OPENING_AMT,String SUP_RECEIPT_NO,String SUP_RECEIPT_AMT,String SUP_DISPOSAL_NO,
			String SUP_DISPOSAL_AMT,String SUP_AGE_LESS_6_NO,String SUP_AGE_6_TO_12_NO,String SUP_AGE_1_TO_2_NO,
			String SUP_AGE_MORE_THAN_2_NO) {
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_3_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, REASON_ID);
		// query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		// query.setParameter(4, REASON_FOR_KEEPING_IN_CALL_BOOK);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, ADC_OPENING_NO);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, ADC_OPENING_AMT);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, ADC_RECEIPT_NO);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, ADC_RECEIPT_AMT);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, ADC_DISPOSAL_NO);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, ADC_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, ADC_AGE_LESS_6_NO);
		
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, ADC_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, ADC_AGE_1_TO_2_NO);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, ADC_AGE_MORE_THAN_2_NO);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, DC_OPENING_NO);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, DC_OPENING_AMT);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, DC_RECEIPT_NO);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, DC_RECEIPT_AMT);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, DC_DISPOSAL_NO);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, DC_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, DC_AGE_LESS_6_NO);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, DC_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, DC_AGE_1_TO_2_NO);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, DC_AGE_MORE_THAN_2_NO);
		
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, SUP_OPENING_NO);
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, SUP_OPENING_AMT);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, SUP_RECEIPT_NO);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		query.setParameter(27, SUP_RECEIPT_AMT);
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		query.setParameter(28, SUP_DISPOSAL_NO);
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
		query.setParameter(29, SUP_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.IN);
		query.setParameter(30, SUP_AGE_LESS_6_NO);
		query.registerStoredProcedureParameter(31, String.class, ParameterMode.IN);
		query.setParameter(31, SUP_AGE_6_TO_12_NO);
		query.registerStoredProcedureParameter(32, String.class, ParameterMode.IN);
		query.setParameter(32, SUP_AGE_1_TO_2_NO);
		query.registerStoredProcedureParameter(33, String.class, ParameterMode.IN);
		query.setParameter(33, SUP_AGE_MORE_THAN_2_NO);
		
		query.registerStoredProcedureParameter(34, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(34).toString();
	}

	
	public String generateResult_SP_DPM_GST_ADJ_3_OPENING_INSERT(String p_COMM_CODE, String p_MM_YYYY, 
	String Appeals_ADC_OPENING_NO,String Appeals_ADC_OPENING_AMT,
	String Appeals_DC_OPENING_NO,String Appeals_DC_OPENING_AMT,
	String Appeals_SUP_OPENING_NO,String Appeals_SUP_OPENING_AMT,
	
	String Injunction_ADC_OPENING_NO,String Injunction_ADC_OPENING_AMT,
	String Injunction_DC_OPENING_NO,String Injunction_DC_OPENING_AMT,
	String Injunction_SUP_OPENING_NO,String Injunction_SUP_OPENING_AMT,
	
	String CAG_ADC_OPENING_NO,String CAG_ADC_OPENING_AMT,
	String CAG_DC_OPENING_NO,String CAG_DC_OPENING_AMT,
	String CAG_SUP_OPENING_NO,String CAG_SUP_OPENING_AMT,
	
	String Board_ADC_OPENING_NO,String Board_ADC_OPENING_AMT,
	String Board_DC_OPENING_NO,String Board_DC_OPENING_AMT,
	String Board_SUP_OPENING_NO,String Board_SUP_OPENING_AMT) 
	{
		query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_3_OPENING_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, p_COMM_CODE);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, p_MM_YYYY);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, Appeals_ADC_OPENING_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, Appeals_ADC_OPENING_AMT);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, Appeals_DC_OPENING_NO);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, Appeals_DC_OPENING_AMT);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, Appeals_SUP_OPENING_NO);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, Appeals_SUP_OPENING_AMT);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);

		query.setParameter(9, Injunction_ADC_OPENING_NO);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, Injunction_ADC_OPENING_AMT);		
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, Injunction_DC_OPENING_NO);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, Injunction_DC_OPENING_AMT);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, Injunction_SUP_OPENING_NO);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, Injunction_SUP_OPENING_AMT);

		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, CAG_ADC_OPENING_NO);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, CAG_ADC_OPENING_AMT);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, CAG_DC_OPENING_NO);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, CAG_DC_OPENING_AMT);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, CAG_SUP_OPENING_NO);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, CAG_SUP_OPENING_AMT);

		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, Board_ADC_OPENING_NO);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, Board_ADC_OPENING_AMT);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, Board_DC_OPENING_NO);		
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, Board_DC_OPENING_AMT);
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, Board_SUP_OPENING_NO);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, Board_SUP_OPENING_NO);
		
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.OUT);
		query.execute();

		return query.getOutputParameterValue(27).toString();
	}	


	public  List<SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result > get_DPM_GST_ADJ_3_REGION_LIST(String COMM_CODE,String MM_YYYY){
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_DPM_GST_ADJ_3_CALLBOOK_REGION");
		query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		query.setParameter(1,COMM_CODE);
		query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		query.setParameter(2,MM_YYYY);
		query.execute();
		int noOfRecords = query.getMaxResults();
		System.out.println("noOfRecords " + noOfRecords);
		if(noOfRecords > 0)
		return sp_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result.generateResultBeanList(query.getResultList());
		else
		return null;	
	}
}
