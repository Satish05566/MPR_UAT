package com.ddm.cbic.dao.implementation.gstcei;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ddm.cbic.model.gstcei.SP_CEI_GST_1_ALL_Result;
import com.ddm.cbic.model.gstcei.SP_CEI_GST_1_COMM_Result;
import com.ddm.cbic.model.gstcei.SP_CEI_GST_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.gstcei.SP_CEI_GST_1_COMM_TEMP_Result;
import com.ddm.cbic.model.gstcei.SP_CEI_GST_1_REGION_Result;
import com.ddm.cbic.model.gstcei.SP_CEI_GST_1_ZONE_Result;

@Repository
public class GSTCEI_CEI_GST_1_DaoImpl {
	private static final Logger logger = LoggerFactory.getLogger(GSTCEI_CEI_GST_1_DaoImpl.class);	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;


	@SuppressWarnings("unchecked")
	public List<SP_CEI_GST_1_ALL_Result> generateResultBeanList_SP_CEI_GST_1_ALL_Result(Object[] objArray) {
		SP_CEI_GST_1_ALL_Result sp_CEI_GST_1_ALL_Result = new SP_CEI_GST_1_ALL_Result();
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_CEI_GST_1_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.execute();
		return sp_CEI_GST_1_ALL_Result.generateResultBeanList(query.getResultList());
	}

	@SuppressWarnings("unchecked")
	public List<SP_CEI_GST_1_COMM_Result> generateResultBeanList_SP_CEI_GST_1_COMM_Result(Object[] objArray) {
		SP_CEI_GST_1_COMM_Result sp_CEI_GST_1_COMM_Result = new SP_CEI_GST_1_COMM_Result();
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_CEI_GST_1_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[1]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[0]);
		query.execute();
		return sp_CEI_GST_1_COMM_Result.generateResultBeanList(query.getResultList());
	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * List<SP_CEI_GST_1_COMM_TEMP_REPORT_Result>
	 * generateResultBeanList_SP_CEI_GST_1_COMM_TEMP_REPORT_Result( Object[]
	 * objArray) { SP_CEI_GST_1_COMM_TEMP_REPORT_Result
	 * sp_CEI_GST_1_COMM_TEMP_REPORT_Result = new
	 * SP_CEI_GST_1_COMM_TEMP_REPORT_Result(); StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_CEI_ST_7_COMM_TEMP_REPORT");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * query.setParameter(1, (String) objArray[0]);
	 * query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	 * query.setParameter(2, (String) objArray[1]);
	 * 
	 * query.execute(); return
	 * sp_CEI_GST_1_COMM_TEMP_REPORT_Result.generateResultBeanList(query.
	 * getResultList()); }
	 */
	@SuppressWarnings("unchecked")
	public List<SP_CEI_GST_1_COMM_TEMP_Result> generateResultBeanList_SP_CEI_GST_1_COMM_TEMP_Result(Object[] objArray) {
		SP_CEI_GST_1_COMM_TEMP_Result sp_CEI_GST_1_COMM_TEMP_Result = new SP_CEI_GST_1_COMM_TEMP_Result();
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_CEI_GST_1_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);

		query.execute();
		return sp_CEI_GST_1_COMM_TEMP_Result.generateResultBeanList(query.getResultList());
	}

	@SuppressWarnings("unchecked")
	public List<SP_CEI_GST_1_REGION_Result> generateResultBeanList_SP_CEI_GST_1_REGION_Result(Object[] objArray) {
		SP_CEI_GST_1_REGION_Result sp_CEI_GST_1_REGION_Result = new SP_CEI_GST_1_REGION_Result();
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_CEI_GST_1_TEMP");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);

		query.execute();
		return sp_CEI_GST_1_REGION_Result.generateResultBeanList(query.getResultList());
	}

	@SuppressWarnings("unchecked")
	public List<SP_CEI_GST_1_ZONE_Result> generateResultBeanList_SP_CEI_GST_1_ZONE_Result(Object[] objArray) {
		SP_CEI_GST_1_ZONE_Result sp_CEI_GST_1_ZONE_Result = new SP_CEI_GST_1_ZONE_Result();
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_CEI_GST_1_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[1]);

		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[0]);

		query.execute();
		return sp_CEI_GST_1_ZONE_Result.generateResultBeanList(query.getResultList());
	}
	
	/*************************** Priyanka Giri *************************************************/
	
	
	public Object generateResult_SP_CEI_GST_1_MAX_DATE(String code) {
			query= entityManager.createStoredProcedureQuery("SP_CEI_GST_1_MAX_DATE");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, code);
			query.execute();	
			return query.getResultList().get(0);
	}

	public SP_CEI_GST_1_COMM_TEMP_Result generateResult_SP_CEI_GST_1_COMM_TEMP(String mm_yyyy, String code,
			HttpServletRequest request, Object crr) {
			if(crr == null || crr == "")crr=null;
			
			query= entityManager.createStoredProcedureQuery("SP_CEI_GST_1_COMM_TEMP");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, mm_yyyy);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, code);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);		
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			if(crr != null)query.setParameter(4, crr);							
			query.execute();
			request.setAttribute("result", query.getOutputParameterValue(3));
			logger.info(" Result "+query.getOutputParameterValue(3));
			return new SP_CEI_GST_1_COMM_TEMP_Result().generateTempResult(query.getResultList());
	}

	public void generateResult_SP_CEI_GST_1_TEMP_UPDATE(String code, String mm_yyyy, String det_NOC,
			String det_AMT_CGST, String det_AMT_IGST, String det_AMT_SGGST, String det_AMT_UTGST, String det_AMT_CESS,
			String real_NOC, String real_AMT_CGST, String real_AMT_IGST, String real_AMT_SGGST, String real_AMT_UTGST,
			String real_AMT_CESS, Object crr) {
			
			query= entityManager.createStoredProcedureQuery("SP_CEI_GST_1_TEMP_UPDATE");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, code);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, mm_yyyy);				
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, det_NOC);	
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			query.setParameter(4, det_AMT_CGST);
			query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			query.setParameter(5, det_AMT_IGST);				
			query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
			query.setParameter(6, det_AMT_SGGST);	
			query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
			query.setParameter(7, det_AMT_UTGST);
			query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
			query.setParameter(8, det_AMT_CESS);				
			query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
			query.setParameter(9, real_NOC);	
			query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
			query.setParameter(10, real_AMT_CGST);
			query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
			query.setParameter(11, real_AMT_IGST);				
			query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
			query.setParameter(12, real_AMT_SGGST);	
			query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
			query.setParameter(13, real_AMT_UTGST);
			query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
			query.setParameter(14, real_AMT_CESS);
			query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
			if(crr != null)query.setParameter(15, crr);
			query.execute();
			
		
	}

	public void generateResult_SP_CEI_GST_1_INSERT(String code, String mm_yyyy, String det_NOC, String det_AMT_CGST,
			String det_AMT_IGST, String det_AMT_SGGST, String det_AMT_UTGST, String det_AMT_CESS, String real_NOC,
			String real_AMT_CGST, String real_AMT_IGST, String real_AMT_SGGST, String real_AMT_UTGST,
			String real_AMT_CESS) {
		
			query= entityManager.createStoredProcedureQuery("SP_CEI_GST_1_INSERT");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, code);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, mm_yyyy);				
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, det_NOC);	
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			query.setParameter(4, det_AMT_CGST);
			query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			query.setParameter(5, det_AMT_IGST);				
			query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
			query.setParameter(6, det_AMT_SGGST);	
			query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
			query.setParameter(7, det_AMT_UTGST);
			query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
			query.setParameter(8, det_AMT_CESS);				
			query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
			query.setParameter(9, real_NOC);	
			query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
			query.setParameter(10, real_AMT_CGST);
			query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
			query.setParameter(11, real_AMT_IGST);				
			query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
			query.setParameter(12, real_AMT_SGGST);	
			query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
			query.setParameter(13, real_AMT_UTGST);
			query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
			query.setParameter(14, real_AMT_CESS);
			query.execute();
		
	}

	

	
	
	public String generateResult_SP_SUBMISSION_CEI_GST(String comm_code, String user, String remoteAddr,
			String report_Group) {
		
			query= entityManager.createStoredProcedureQuery("SP_SUBMISSION_CEI_GST");
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
			 logger.info(" SP_SUBMISSION_DOL_CUS_GST Result "+query.getOutputParameterValue(5));
			return query.getOutputParameterValue(5).toString();
	}

	public List<SP_CEI_GST_1_COMM_TEMP_REPORT_Result> generateResult_SP_CEI_GST_1_COMM_TEMP_REPORT(String _MM_YYYY,
			String code, Object object, Object object2, Object object3) {
		
			query= entityManager.createStoredProcedureQuery("SP_CEI_GST_1_COMM_TEMP_REPORT");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, _MM_YYYY);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, code);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);	
			if(object != null)query.setParameter(3, object);
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			if(object2 != null)query.setParameter(4, object2);		
			query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			if(object3 != null)query.setParameter(5, object3);	
			query.execute();
			return new SP_CEI_GST_1_COMM_TEMP_REPORT_Result().generateResultBeanList(query.getResultList());
	}

	
}
