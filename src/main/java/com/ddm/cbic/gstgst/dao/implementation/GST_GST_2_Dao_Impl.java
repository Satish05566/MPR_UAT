package com.ddm.cbic.gstgst.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.gstgst.dao.GST_GST_2_Dao;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_ALL_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_TEMP_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_REGION_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_ZONE_Result;

@Repository
public class GST_GST_2_Dao_Impl implements GST_GST_2_Dao{
	
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	

	@Override
	public Object generateResult_SP_GST_GST_2_MAX_DATE(String code) {
		query= entityManager.createStoredProcedureQuery("SP_GST_GST_2_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);			
		query.execute();				
		return query.getResultList().get(0);
	}

	@Override
	public SP_GST_GST_2_COMM_TEMP_Result generateResult_SP_GST_GST_2_COMM_TEMP(String code, String mm_yyyy, Object crr,
			HttpServletRequest request) {
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_GST_GST_2_COMM_TEMP");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != crr) query.setParameter(3, crr);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);			
		query.execute();
		
		request.setAttribute("result", query.getOutputParameterValue(4));
		return new SP_GST_GST_2_COMM_TEMP_Result().generateCommTempResult(query.getResultList());
		
	}

	@Override
	public String generateResult_SP_GST_GST_2_UPDATE(String code, String mm_yyyy, String gstr_1m_F, String gstr_3bm_F,
			String gstr_1q_F, String gstr_3bq_F, String gst_CMP_08_F, String gstr_4_F, String gstr_9_F,
			String gstr_9a_F, String gstr_9c_F, String gstr_1m_D, String gstr_3bm_D, String gstr_1q_D,
			String gstr_3bq_D, String gst_CMP_08_D, String gstr_4_D, String gstr_9_D, String gstr_9a_D,
			String gstr_9c_D, String gstr_3a_I, String gstr_3a_NI, Object crr) {
		
		if(crr ==null || crr =="")crr = null;
		query= entityManager.createStoredProcedureQuery("SP_GST_GST_2_UPDATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, gstr_1m_F);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, gstr_3bm_F);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, gstr_1q_F);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, gstr_3bq_F);		
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, gst_CMP_08_F);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, gstr_4_F);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, gstr_9_F);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, gstr_9a_F);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, gstr_9c_F);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
        query.setParameter(12, gstr_1m_D);
        query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
        query.setParameter(13, gstr_3bm_D);
        query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
        query.setParameter(14, gstr_1q_D);
        query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
        query.setParameter(15, gstr_3bq_D);        
        query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
        query.setParameter(16, gst_CMP_08_D);
        query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
        query.setParameter(17, gstr_4_D);
        query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
        query.setParameter(18, gstr_9_D);
        query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
        query.setParameter(19, gstr_9a_D);
        query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
        query.setParameter(20, gstr_9c_D);		
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, gstr_3a_I);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, gstr_3a_NI);		
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(23, crr); 
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(24).toString();
	}

	@Override
	public String generateResult_SP_GST_GST_2_INSERT(String code, String mm_yyyy, String gstr_1m_F, String gstr_3bm_F,
			String gstr_1q_F, String gstr_3bq_F, String gst_CMP_08_F, String gstr_4_F, String gstr_9_F,
			String gstr_9a_F, String gstr_9c_F, String gstr_1m_D, String gstr_3bm_D, String gstr_1q_D,
			String gstr_3bq_D, String gst_CMP_08_D, String gstr_4_D, String gstr_9_D, String gstr_9a_D,
			String gstr_9c_D, String gstr_3a_I, String gstr_3a_NI) {

		
		query= entityManager.createStoredProcedureQuery("SP_GST_GST_2_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, gstr_1m_F);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, gstr_3bm_F);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, gstr_1q_F);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, gstr_3bq_F);		
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, gst_CMP_08_F);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, gstr_4_F);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, gstr_9_F);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, gstr_9a_F);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, gstr_9c_F);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
        query.setParameter(12, gstr_1m_D);
        query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
        query.setParameter(13, gstr_3bm_D);
        query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
        query.setParameter(14, gstr_1q_D);
        query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
        query.setParameter(15, gstr_3bq_D);        
        query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
        query.setParameter(16, gst_CMP_08_D);
        query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
        query.setParameter(17, gstr_4_D);
        query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
        query.setParameter(18, gstr_9_D);
        query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
        query.setParameter(19, gstr_9a_D);
        query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
        query.setParameter(20, gstr_9c_D);		
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, gstr_3a_I);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, gstr_3a_NI);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.OUT);
		query.execute();					
		return query.getOutputParameterValue(23).toString();
	}

	@Override
	public SP_GST_GST_2_ALL_Result generateResult_SP_GST_GST_2_ALL(String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GST_GST_2_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);							
		query.execute();				
		return new SP_GST_GST_2_ALL_Result().generateAllResult(query.getResultList());
	}

	@Override
	public SP_GST_GST_2_REGION_Result generateResult_SP_GST_GST_2_REGION(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GST_GST_2_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, code);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, mm_yyyy);						
		query.execute();				
		 return new SP_GST_GST_2_REGION_Result().generateRegionResult(query.getResultList());

	}

	@Override
	public SP_GST_GST_2_ZONE_Result generateResult_SP_GST_GST_2_ZONE(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GST_GST_2_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);						
		query.execute();				
		return new SP_GST_GST_2_ZONE_Result().generateZoneResult(query.getResultList());		
	}

	@Override
	public SP_GST_GST_2_COMM_Result generateResult_SP_GST_GST_2_COMM(String code, String mm_yyyy) {
		query= entityManager.createStoredProcedureQuery("SP_GST_GST_2_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);		
		query.execute();				
		return new SP_GST_GST_2_COMM_Result().generateCommResult(query.getResultList());

	}

	@Override
	public SP_GST_GST_2_COMM_TEMP_REPORT_Result generateResult_SP_GST_GST_2_COMM_TEMP_REPORT(String code,
			String mm_yyyy, Object crr, Object bak, Object submission_Date) {
		if(crr == null || crr == "")crr=null;
		query= entityManager.createStoredProcedureQuery("SP_GST_GST_2_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, mm_yyyy);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, code);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(crr != null)query.setParameter(3, crr);	
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		if(bak != null)query.setParameter(4, bak);	
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		if(submission_Date != null)query.setParameter(5, submission_Date);	
		query.execute();				
		return new SP_GST_GST_2_COMM_TEMP_REPORT_Result().generateTempResult(query.getResultList());
		
	}


}
