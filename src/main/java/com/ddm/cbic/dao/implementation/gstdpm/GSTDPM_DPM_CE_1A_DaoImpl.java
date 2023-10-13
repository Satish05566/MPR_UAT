package com.ddm.cbic.dao.implementation.gstdpm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*import com.ddm.cbic.model.gstdpm.SP_DGI_CE_1A_ALL_Result;*/
//import com.ddm.cbic.model.gstcei.SP_DGI_CE_1A_COMMCODE_Result;
/*import com.ddm.cbic.model.gstdpm.SP_DGI_CE_1A_COMM_Result;
import com.ddm.cbic.model.gstdpm.SP_DGI_CE_1A_COMM_TEMP_Result;
import com.ddm.cbic.model.gstdpm.SP_DGI_CE_1A_COMM_TEMP_REPORT_Result;
*///import com.ddm.cbic.model.gstcei.SP_DGI_CE_1A_FORUM_Result;
//import com.ddm.cbic.model.gstcei.SP_DGI_CE_1A_OPENING_Result;
//import com.ddm.cbic.model.gstdpm.SP_DGI_CE_1A_REGION_Result;
//import com.ddm.cbic.model.gstcei.SP_DGI_CE_1A_TRANSFER_COMM_TEMP_Result;
/*import com.ddm.cbic.model.gstdpm.SP_DGI_CE_1A_ZONE_Result;
import com.ddm.cbic.model.gstdpm.SP_DGI_RANGE_OPENING8_Result;
import com.ddm.cbic.model.gstdpm.SP_DGI_CE_1A_REPORT_OPENING_Result;*/

@Repository
public class GSTDPM_DPM_CE_1A_DaoImpl {
	
private static final Logger logger = LoggerFactory.getLogger(GSTDPM_DPM_CE_1A_DaoImpl.class);
	
	
	@Autowired
	private EntityManager entityManager;
	StoredProcedureQuery query;
	
	/*
	 * public List<SP_DGI_CE_1A_ALL_Result>
	 * generateResultBeanList_SP_DGI_CE_1A_ALL(String _MM_YYYY) {
	 * 
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_DGI_CE_1A_ALL");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * query.setParameter(1, _MM_YYYY); query.execute(); SP_DGI_CE_1A_ALL_Result
	 * sP_DLA_CE_ALL_Result = new SP_DGI_CE_1A_ALL_Result(); return
	 * sP_DLA_CE_ALL_Result.generateReportBeanListAll(query.getResultList()); }
	 * 
	 * public List<SP_DGI_CE_1A_REGION_Result>
	 * generateResultBeanList_SP_DGI_CE_1A_REGION(String _MM_YYYY, String code) {
	 * 
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_DGI_CE_1A_REGION");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * query.setParameter(1, _MM_YYYY); query.registerStoredProcedureParameter(2,
	 * String.class, ParameterMode.IN); query.setParameter(2, code);
	 * query.execute(); SP_DGI_CE_1A_REGION_Result sP_DLA_CE_REGION_Result = new
	 * SP_DGI_CE_1A_REGION_Result(); return
	 * sP_DLA_CE_REGION_Result.generateReportBeanListRegion(query.getResultList());
	 * }
	 * 
	 * public List<SP_DGI_CE_1A_COMM_Result>
	 * generateResultBeanList_SP_DGI_CE_1A_COMM(String _MM_YYYY, String code) {
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_DGI_CE_1A_COMM");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * query.setParameter(1, _MM_YYYY); query.registerStoredProcedureParameter(2,
	 * String.class, ParameterMode.IN); query.setParameter(2, code);
	 * query.execute(); SP_DGI_CE_1A_COMM_Result sP_DLA_CE_COMM_Result = new
	 * SP_DGI_CE_1A_COMM_Result(); return
	 * sP_DLA_CE_COMM_Result.generateReportBeanListComm(query.getResultList()); }
	 * 
	 * public List<SP_DGI_CE_1A_ZONE_Result>
	 * generateResultBeanList_SP_DGI_CE_1A_ZONE(String _MM_YYYY, String code) {
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_DGI_CE_1A_ZONE");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * 
	 * query.setParameter(1, _MM_YYYY); query.registerStoredProcedureParameter(2,
	 * String.class, ParameterMode.IN); query.setParameter(2, code);
	 * query.execute(); SP_DGI_CE_1A_ZONE_Result sP_DLA_CE_ZONE_Result = new
	 * SP_DGI_CE_1A_ZONE_Result(); return
	 * sP_DLA_CE_ZONE_Result.generateResultBeanListZone(query.getResultList()); }
	 * 
	 * public Object generateResult_SP_DGI_CE_1A_MAX_DATE(String objArray) {
	 * logger.info("objArray--> "+objArray); StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_DGI_CE_1A_MAX_DATE");
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,objArray); query.execute(); return
	 * query.getResultList().get(0); }
	 * 
	 * public List<SP_DGI_CE_1A_COMM_TEMP_REPORT_Result>
	 * generateResultBeanList_SP_DGI_CE_1A_COMM_TEMP_REPORT(Object[] objArray) {
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_DGI_CE_1A_COMM_TEMP_REPORT");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * if(null != objArray[0]) {query.setParameter(1, objArray[0]);}
	 * query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	 * if(null != objArray[1]) {query.setParameter(2, objArray[1]);}
	 * query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
	 * if(null != objArray[2]) {query.setParameter(3, objArray[2]);}
	 * query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
	 * if(null != objArray[3]) {query.setParameter(4, objArray[3]);}
	 * query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
	 * if(null != objArray[4]) {query.setParameter(5, objArray[4]);}
	 * query.execute();
	 * 
	 * SP_DGI_CE_1A_COMM_TEMP_REPORT_Result sP_DLA_CE_TEMP_Result = new
	 * SP_DGI_CE_1A_COMM_TEMP_REPORT_Result(); return
	 * sP_DLA_CE_TEMP_Result.generateResultCommTempReport(query.getResultList()); }
	 * 
	 * 
	 * 
	 * public List<SP_DGI_CE_1A_COMM_TEMP_Result>
	 * generateResultBeanList_SP_DGI_CE_1A_COMM_TEMP(String code, String mM_YYYY,
	 * HttpServletRequest request, Object crr) {
	 * 
	 * logger.info("code  "+code); logger.info("mM_YYYY  "+mM_YYYY);
	 * logger.info("crr  "+crr);
	 * 
	 * 
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_DGI_CE_1A_COMM_TEMP"); if(crr ==
	 * null || crr =="")crr=null; query.registerStoredProcedureParameter(1,
	 * String.class, ParameterMode.IN); if(null != mM_YYYY) {query.setParameter(1,
	 * mM_YYYY);} query.registerStoredProcedureParameter(2, String.class,
	 * ParameterMode.IN); if(null != code) {query.setParameter(2, code);}
	 * 
	 * query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
	 * if(null != crr) {query.setParameter(3, crr);}
	 * 
	 * query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
	 * 
	 * 
	 * query.execute();
	 * 
	 * String out = (String)query.getOutputParameterValue(4);
	 * logger.info("OUT  "+out);
	 * 
	 * request.setAttribute("result", out);
	 * 
	 * return new
	 * SP_DGI_CE_1A_COMM_TEMP_Result().generateReportBeanListCommTemp(query.
	 * getResultList()); }
	 * 
	 * 
	 * 
	 * public List<SP_DGI_CE_1A_REPORT_OPENING_Result>
	 * generateResult_SP_DGI_CE_1A_REPORT_OPENING(String code, String mM_YYYY) {
	 * 
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_DGI_CE_1A_REPORT_OPENING");
	 * 
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * if(null != code) {query.setParameter(1, code);}
	 * query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	 * if(null != mM_YYYY) {query.setParameter(2,mM_YYYY);}
	 * 
	 * query.execute();
	 * logger.info(" query.getResultList() "+query.getResultList()); return new
	 * SP_DGI_CE_1A_REPORT_OPENING_Result().generateReportBeanListReportOpening(
	 * query.getResultList()); }
	 * 
	 * 
	 * public List<SP_DGI_RANGE_OPENING8_Result>
	 * generateResult_SP_DGI_RANGE_OPENING8(String code, String mM_YYYY,String page)
	 * {
	 * 
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_DGI_RANGE_OPENING8");
	 * 
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * if(null != code) {query.setParameter(1, code);}
	 * query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	 * if(null != mM_YYYY) {query.setParameter(2,mM_YYYY);}
	 * query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
	 * {query.setParameter(3,page);}
	 * 
	 * query.execute();
	 * logger.info(" query.getResultList() "+query.getResultList()); return new
	 * SP_DGI_RANGE_OPENING8_Result().generateReportOpening(query.getResultList());
	 * }
	 */
	
	public String generateResult_SP_DGI_OPENING_INSERT8(			
			String code,String mm_yyyy, String page, String COMM_CLOSING_NO, String COMM_CLOSING_AMT,String JC_CLOSING_NO, String JC_CLOSING_AMT, 
			String AC_CLOSING_NO, String AC_CLOSING_AMT, String SUP_CLOSING_NO,String SUP_CLOSING_AMT) {
		
		    StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_DGI_OPENING_INSERT8");		
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);		
			query.setParameter(1, code);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2,mm_yyyy);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3,page);
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);		
			query.setParameter(4, COMM_CLOSING_NO);
			query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			query.setParameter(5,COMM_CLOSING_AMT);
			query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);		
			query.setParameter(6, JC_CLOSING_NO);	
			query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
			query.setParameter(7,JC_CLOSING_AMT);
			query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);		
			query.setParameter(8, AC_CLOSING_NO);	
			query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
			query.setParameter(9,AC_CLOSING_AMT);
			query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);		
			query.setParameter(10, SUP_CLOSING_NO);
			query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
			query.setParameter(11,SUP_CLOSING_AMT);
					
		    query.execute();
		
		    return "Inserted";
	}

	public String generateResult_SP_DGI_OPENING_UPDATE8(			
			String code,String mm_yyyy, String page, String COMM_CLOSING_NO, String COMM_CLOSING_AMT,String JC_CLOSING_NO, String JC_CLOSING_AMT, 
			String AC_CLOSING_NO, String AC_CLOSING_AMT, String SUP_CLOSING_NO,String SUP_CLOSING_AMT) {
		
		    StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_DGI_OPENING_UPDATE8");		
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);		
			query.setParameter(1, code);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2,mm_yyyy);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3,page);
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);		
			query.setParameter(4, COMM_CLOSING_NO);
			query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			query.setParameter(5,COMM_CLOSING_AMT);
			query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);		
			query.setParameter(6, JC_CLOSING_NO);	
			query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
			query.setParameter(7,JC_CLOSING_AMT);
			query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);		
			query.setParameter(8, AC_CLOSING_NO);	
			query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
			query.setParameter(9,AC_CLOSING_AMT);
			query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);		
			query.setParameter(10, SUP_CLOSING_NO);
			query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
			query.setParameter(11,SUP_CLOSING_AMT);
					
		    query.execute();
		
		    return "Updated";
	}

	public String generateResult_SP_DGI_CE_1A_TEMP_UPDATE(
			String COMM_RECEIPT_NO, String COMM_RECEIPT_AMT, String COMM_DISPOSAL_NO, String COMM_DISPOSAL_AMT, String COMM_MONTHS_3_AMT, 
			String COMM_MONTHS_3TO6_AMT, String COMM_MONTHS_6TO12_AMT, String COMM_MORE_YEAR_AMT,
            String JC_RECEIPT_NO, String JC_RECEIPT_AMT, String JC_DISPOSAL_NO, String JC_DISPOSAL_AMT, String JC_MONTHS_3_AMT, String JC_MONTHS_3TO6_AMT, String JC_MONTHS_6TO12_AMT, String JC_MORE_YEAR_AMT,
            String AC_RECEIPT_NO, String AC_RECEIPT_AMT, String AC_DISPOSAL_NO, String AC_DISPOSAL_AMT, String AC_MONTHS_3_AMT, String AC_MONTHS_3TO6_AMT, String AC_MONTHS_6TO12_AMT, String AC_MORE_YEAR_AMT,
            String SUP_RECEIPT_NO, String SUP_RECEIPT_AMT, String SUP_DISPOSAL_NO, String SUP_DISPOSAL_AMT, String SUP_MONTHS_3_AMT, String SUP_MONTHS_3TO6_AMT, String SUP_MONTHS_6TO12_AMT, String SUP_MORE_YEAR_AMT,
            String MM_YYYY,String  code, String p_CRR
			) {
		
		query= entityManager.createStoredProcedureQuery("SP_DGI_CE_1A_TEMP_UPDATE");
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, COMM_RECEIPT_NO);	
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, COMM_RECEIPT_AMT );
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, COMM_DISPOSAL_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, COMM_DISPOSAL_AMT );
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, COMM_MONTHS_3_AMT);	
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, COMM_MONTHS_3TO6_AMT);	
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, COMM_MONTHS_6TO12_AMT);	
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, COMM_MORE_YEAR_AMT);	
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, JC_RECEIPT_NO);	
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, JC_RECEIPT_AMT);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, JC_DISPOSAL_NO);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, JC_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, JC_MONTHS_3_AMT);	
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, JC_MONTHS_3TO6_AMT);	
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, JC_MONTHS_6TO12_AMT);	
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, JC_MORE_YEAR_AMT);	
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, AC_RECEIPT_NO);	
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, AC_RECEIPT_AMT );
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, AC_DISPOSAL_NO);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, AC_DISPOSAL_AMT);	
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, AC_MONTHS_3_AMT);	
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, AC_MONTHS_3TO6_AMT);	
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, AC_MONTHS_6TO12_AMT);	
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, AC_MORE_YEAR_AMT);
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, SUP_RECEIPT_NO);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, SUP_RECEIPT_AMT);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		query.setParameter(27, SUP_DISPOSAL_NO);
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		query.setParameter(28, SUP_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
		query.setParameter(29, SUP_MONTHS_3_AMT);	
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.IN);
		query.setParameter(30, SUP_MONTHS_3TO6_AMT);	
		query.registerStoredProcedureParameter(31, String.class, ParameterMode.IN);
		query.setParameter(31, SUP_MONTHS_6TO12_AMT);	
		query.registerStoredProcedureParameter(32, String.class, ParameterMode.IN);
		query.setParameter(32, SUP_MORE_YEAR_AMT);
		query.registerStoredProcedureParameter(33, String.class, ParameterMode.IN);
		query.setParameter(33, MM_YYYY);
		query.registerStoredProcedureParameter(34, String.class, ParameterMode.IN);
		query.setParameter(34, code);
		query.registerStoredProcedureParameter(35, String.class, ParameterMode.IN);
		if(null != p_CRR) {query.setParameter(35, p_CRR);}
		
		query.registerStoredProcedureParameter(36, String.class, ParameterMode.OUT);
		
		query.execute();	
		return query.getOutputParameterValue(36).toString();
			//return null;
	}

	
	public String generateResult_SP_DGI_CE_1A_INSERT(String COMM_RECEIPT_NO, String COMM_RECEIPT_AMT, String COMM_DISPOSAL_NO, String COMM_DISPOSAL_AMT, String COMM_MONTHS_3_AMT, 
			String COMM_MONTHS_3TO6_AMT, String COMM_MONTHS_6TO12_AMT, String COMM_MORE_YEAR_AMT,
            String JC_RECEIPT_NO, String JC_RECEIPT_AMT, String JC_DISPOSAL_NO, String JC_DISPOSAL_AMT, String JC_MONTHS_3_AMT, String JC_MONTHS_3TO6_AMT, String JC_MONTHS_6TO12_AMT, String JC_MORE_YEAR_AMT,
            String AC_RECEIPT_NO, String AC_RECEIPT_AMT, String AC_DISPOSAL_NO, String AC_DISPOSAL_AMT, String AC_MONTHS_3_AMT, String AC_MONTHS_3TO6_AMT, String AC_MONTHS_6TO12_AMT, String AC_MORE_YEAR_AMT,
            String SUP_RECEIPT_NO, String SUP_RECEIPT_AMT, String SUP_DISPOSAL_NO, String SUP_DISPOSAL_AMT, String SUP_MONTHS_3_AMT, String SUP_MONTHS_3TO6_AMT, String SUP_MONTHS_6TO12_AMT, String SUP_MORE_YEAR_AMT,
            String MM_YYYY,String  code) {

		
		query= entityManager.createStoredProcedureQuery("SP_DGI_CE_1A_INSERT");

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, COMM_RECEIPT_NO);	
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, COMM_RECEIPT_AMT );
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, COMM_DISPOSAL_NO);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, COMM_DISPOSAL_AMT );
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, COMM_MONTHS_3_AMT);	
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, COMM_MONTHS_3TO6_AMT);	
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, COMM_MONTHS_6TO12_AMT);	
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, COMM_MORE_YEAR_AMT);	
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, JC_RECEIPT_NO);	
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, JC_RECEIPT_AMT);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, JC_DISPOSAL_NO);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, JC_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, JC_MONTHS_3_AMT);	
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, JC_MONTHS_3TO6_AMT);	
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, JC_MONTHS_6TO12_AMT);	
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, JC_MORE_YEAR_AMT);	
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, AC_RECEIPT_NO);	
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, AC_RECEIPT_AMT );
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, AC_DISPOSAL_NO);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, AC_DISPOSAL_AMT);	
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, AC_MONTHS_3_AMT);	
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, AC_MONTHS_3TO6_AMT);	
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, AC_MONTHS_6TO12_AMT);	
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, AC_MORE_YEAR_AMT);
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, SUP_RECEIPT_NO);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, SUP_RECEIPT_AMT);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		query.setParameter(27, SUP_DISPOSAL_NO);
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		query.setParameter(28, SUP_DISPOSAL_AMT);
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
		query.setParameter(29, SUP_MONTHS_3_AMT);	
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.IN);
		query.setParameter(30, SUP_MONTHS_3TO6_AMT);	
		query.registerStoredProcedureParameter(31, String.class, ParameterMode.IN);
		query.setParameter(31, SUP_MONTHS_6TO12_AMT);	
		query.registerStoredProcedureParameter(32, String.class, ParameterMode.IN);
		query.setParameter(32, SUP_MORE_YEAR_AMT);
		query.registerStoredProcedureParameter(33, String.class, ParameterMode.IN);
		query.setParameter(33, MM_YYYY);
		query.registerStoredProcedureParameter(34, String.class, ParameterMode.IN);
		query.setParameter(34, code);
				
		query.registerStoredProcedureParameter(35, String.class, ParameterMode.OUT);
	
		query.execute();	
		return query.getOutputParameterValue(35).toString();
		
	}
	
	public String generateResult_SP_SUBMISSION_DGI_CEX_GST(String comm_code, String user, String remoteAddr,
			String report_Group) {
		
			query= entityManager.createStoredProcedureQuery("SP_SUBMISSION_DGI_CEX_GST");
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
			 logger.info(" SP_SUBMISSION_DGI_CEX_GST Result "+query.getOutputParameterValue(5));
			return query.getOutputParameterValue(5).toString();
	}
	
	public String generateResult_SP_SUBMISSION_DGI_CUS_GST(String comm_code, String user, String remoteAddr,
			String report_Group) {
		
			query= entityManager.createStoredProcedureQuery("SP_SUBMISSION_DGI_CUS_GST");
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
			 logger.info(" SP_SUBMISSION_DGI_CUS_GST Result "+query.getOutputParameterValue(5));
			return query.getOutputParameterValue(5).toString();
	}
	
	public String generateResult_SP_SUBMISSION_DGI_STX_GST(String comm_code, String user, String remoteAddr,
			String report_Group) {
		
			query= entityManager.createStoredProcedureQuery("SP_SUBMISSION_DGI_STX_GST");
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
			 logger.info(" SP_SUBMISSION_DGI_STX_GST Result "+query.getOutputParameterValue(5));
			return query.getOutputParameterValue(5).toString();
	}
	
	public String generateResult_SP_SUBMISSION_DGI_GST(String comm_code, String user, String remoteAddr,
			String report_Group) {
		
			query= entityManager.createStoredProcedureQuery("SP_SUBMISSION_DGI_GST");
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
			 logger.info(" SP_SUBMISSION_DGI_GST Result "+query.getOutputParameterValue(5));
			return query.getOutputParameterValue(5).toString();
	}

}
