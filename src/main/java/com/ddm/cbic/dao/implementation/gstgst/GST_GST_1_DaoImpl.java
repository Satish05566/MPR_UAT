package com.ddm.cbic.dao.implementation.gstgst;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;/*
													import com.ddm.cbic.model.gstgst.SP_GST_GST_1_COMM_TEMP_Result;
													import com.ddm.cbic.model.gstgst.SP_GST_GST_1_ZONE_Result;
													import com.ddm.cbic.model.gstgst.SP_GST_GST_1_OPENING_Result;
													import com.ddm.cbic.model.gstgst.SP_GST_GST_1_ALL_Result;
													import com.ddm.cbic.model.gstgst.SP_GST_GST_1_COMMCODE_Result;
													import com.ddm.cbic.model.gstgst.SP_GST_GST_1_COMM_Result;
													import com.ddm.cbic.model.gstgst.SP_GST_GST_1_REGION_Result;
													import com.ddm.cbic.model.gstgst.SP_GST_GST_1_TEMP_COMM_Result;
													import com.ddm.cbic.model.gstgst.SP_GST_GST_1_TRANSFER_COMM_TEMP_Result;*/

@Repository
public class GST_GST_1_DaoImpl {
	
private static final Logger logger = LoggerFactory.getLogger(GST_GST_1_DaoImpl.class);
	
	@Autowired
	private EntityManager entityManager;
    
	
	/*
	 * SP_GST_GST_1_COMM_TEMP_Result sP_GST_GST_ALL_Result = new
	 * SP_GST_GST_1_COMM_TEMP_Result() ;
	 * 
	 * public Object generateResultBean_SP_GST_GST_1_MAX_DATE(String code) {
	 * 
	 * StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_GST_GST_1_MAX_DATE");
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,code); query.execute(); return
	 * query.getResultList().get(0); }
	 * 
	 * public String generateResultBeanSP_MPR_CHECK_VALIDATE_UPTO(Object[] objArray)
	 * { logger.info("objArray--> "+objArray[0]); try { StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_MPR_CHECK_VALIDATE_UPTO");
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,String.valueOf(objArray[0] ));
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * query.setParameter(2,String.valueOf(objArray[1] ));
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * query.setParameter(3,String.valueOf(objArray[2]) );
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
	 * query.execute(); String out = (String)query.getOutputParameterValue(4);
	 * return out ; } finally { entityManager.close();
	 * 
	 * } }
	 * 
	 * public List<SP_GST_GST_1_COMM_TEMP_Result>
	 * generateResultBean_SP_GST_GST_1_COMM_TEMP(String code, String mm_yyyy, Object
	 * crr, HttpServletRequest request) { if(crr == null || crr == "") crr =null;
	 * StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_GST_GST_1_COMM_TEMP");
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,code);
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * query.setParameter(2,mm_yyyy);
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * if(crr != null) {query.setParameter(3,crr);}
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
	 * query.execute(); String out = (String)query.getOutputParameterValue(4);
	 * logger.info("--out--"+out); request.setAttribute("result", out); return
	 * sP_GST_GST_ALL_Result.generateResultBeanListGet(query.getResultList()); }
	 * 
	 * 
	 * 
	 * public List<SP_GST_GST_1_TEMP_COMM_Result>
	 * generateResultBeanList_SP_GST_GST_1_COMM_TEMP_REPORT(Object[] objArray) {
	 * 
	 * logger.info("objArray0--> "+objArray[0]);
	 * logger.info("objArray1--> "+objArray[1]);
	 * logger.info("objArray2--> "+objArray[2]);
	 * 
	 * StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_GST_GST_1_COMM_TEMP_REPORT");
	 * 
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * if(null!=objArray[0] && objArray[0]!=null) {
	 * query.setParameter(1,String.valueOf(objArray[0]));}
	 * 
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * if(null!=objArray[1] && objArray[1]!=null) {
	 * query.setParameter(2,String.valueOf(objArray[1]));}
	 * 
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * if(null!=objArray[2] && objArray[2]!=null) {
	 * query.setParameter(3,String.valueOf(objArray[2]));}
	 * 
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	 * if(null!=objArray[3] && objArray[3]!=null) {
	 * query.setParameter(4,String.valueOf(objArray[3]));}
	 * 
	 * query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	 * if(null!=objArray[4] && objArray[4]!=null) {
	 * query.setParameter(5,String.valueOf(objArray[4]));}
	 * 
	 * 
	 * query.execute();
	 * 
	 * 
	 * // request.getSession().setAttribute("_Result", out);
	 * System.out.println(query.getResultList());
	 * 
	 * SP_GST_GST_1_TEMP_COMM_Result reportObject = new
	 * SP_GST_GST_1_TEMP_COMM_Result();
	 * 
	 * return reportObject.generateResultBeanListCommTemp(query.getResultList()); }
	 * 
	 * public List<SP_GST_GST_1_ALL_Result>
	 * generateResultBeanList_SP_GST_GST_ALL(String _MM_YYYY) {
	 * 
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_GST_GST_1_ALL");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * query.setParameter(1, _MM_YYYY); query.execute();
	 * 
	 * SP_GST_GST_1_ALL_Result sP_GST_GST_All_Report = new
	 * SP_GST_GST_1_ALL_Result(); return
	 * sP_GST_GST_All_Report.generateResultBeanListTemp(query.getResultList()); }
	 * 
	 * public List<SP_GST_GST_1_REGION_Result>
	 * generateResultBeanList_SP_GST_GST_1_REGION(String _MM_YYYY, String code) {
	 * 
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_GST_GST_1_REGION");
	 * 
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * query.setParameter(1, _MM_YYYY);
	 * 
	 * query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	 * query.setParameter(2, code);
	 * 
	 * query.execute();
	 * 
	 * SP_GST_GST_1_REGION_Result sP_GST_GST_1_REGION_Report = new
	 * SP_GST_GST_1_REGION_Result(); return
	 * sP_GST_GST_1_REGION_Report.generateResultBeanListTemp(query.getResultList());
	 * }
	 * 
	 * public List<SP_GST_GST_1_ZONE_Result>
	 * generateResultBeanList_SP_GST_GST_1_ZONE(String _MM_YYYY, String code) {
	 * 
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_GST_GST_1_ZONE");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * query.setParameter(1, _MM_YYYY); query.registerStoredProcedureParameter(2,
	 * String.class, ParameterMode.IN); query.setParameter(2, code);
	 * query.execute(); SP_GST_GST_1_ZONE_Result sP_GST_GST_1_ZONE_Report = new
	 * SP_GST_GST_1_ZONE_Result(); return
	 * sP_GST_GST_1_ZONE_Report.generateResultBeanListZone(query.getResultList()); }
	 * 
	 * public List<SP_GST_GST_1_COMM_Result>
	 * generateResultBeanList_SP_GST_GST_1_COMM(String _MM_YYYY, String code) {
	 * 
	 * StoredProcedureQuery query =
	 * entityManager.createStoredProcedureQuery("SP_GST_GST_1_COMM");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * query.setParameter(1, _MM_YYYY); query.registerStoredProcedureParameter(2,
	 * String.class, ParameterMode.IN); query.setParameter(2, code);
	 * query.execute(); SP_GST_GST_1_COMM_Result reportObject = new
	 * SP_GST_GST_1_COMM_Result(); return
	 * reportObject.generateResultBeanListComm(query.getResultList()); }
	 * 
	 * public String generateResultBean_SP_GST_GST_1_INSERT(Object[] objArray,
	 * HttpServletRequest request) { try { StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_GST_GST_1_INSERT");
	 * logger.info("objArray[2] ====== "+objArray[2]);
	 * 
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * if(null!=objArray[0] && objArray[0]!=null) {
	 * query.setParameter(1,String.valueOf(objArray[0]));}
	 * 
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * if(null!=objArray[1] && objArray[1]!=null) {
	 * query.setParameter(2,String.valueOf(objArray[1]));}
	 * 
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * if(null!=objArray[2] && objArray[2]!=null) {
	 * query.setParameter(3,String.valueOf(objArray[2]));}
	 * 
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	 * if(null!=objArray[3] && objArray[3]!=null) {
	 * query.setParameter(4,String.valueOf(objArray[3]));}
	 * 
	 * query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	 * if(null!=objArray[4] && objArray[4]!=null) {
	 * query.setParameter(5,String.valueOf(objArray[4]));}
	 * 
	 * query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
	 * if(null!=objArray[5] && objArray[5]!=null) {
	 * query.setParameter(6,String.valueOf(objArray[5]));}
	 * 
	 * query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
	 * if(null!=objArray[6] && objArray[6]!=null) {
	 * query.setParameter(7,String.valueOf(objArray[6]));}
	 * 
	 * query.registerStoredProcedureParameter(8,String.class,ParameterMode.IN);
	 * if(null!=objArray[7] && objArray[7]!=null) {
	 * query.setParameter(8,String.valueOf(objArray[7]));}
	 * 
	 * 
	 * query.registerStoredProcedureParameter(9,String.class,ParameterMode.IN);
	 * if(null!=objArray[8] && objArray[8]!=null) {
	 * query.setParameter(9,String.valueOf(objArray[8]));}
	 * 
	 * query.registerStoredProcedureParameter(10,String.class,ParameterMode.IN);
	 * if(null!=objArray[9] && objArray[9]!=null) {
	 * query.setParameter(10,String.valueOf(objArray[9]));}
	 * 
	 * query.registerStoredProcedureParameter(11,String.class,ParameterMode.IN);
	 * if(null!=objArray[10] && objArray[10]!=null) {
	 * query.setParameter(11,String.valueOf(objArray[10]));}
	 * 
	 * 
	 * query.registerStoredProcedureParameter(12,String.class,ParameterMode.IN);
	 * if(null!=objArray[11] && objArray[11]!=null) {
	 * query.setParameter(12,String.valueOf(objArray[11]));}
	 * 
	 * query.registerStoredProcedureParameter(13,String.class,ParameterMode.IN);
	 * if(null!=objArray[12] && objArray[12]!=null) {
	 * query.setParameter(13,String.valueOf(objArray[12]));}
	 * 
	 * query.registerStoredProcedureParameter(14,String.class,ParameterMode.IN);
	 * if(null!=objArray[13] && objArray[13]!=null) {
	 * query.setParameter(14,String.valueOf(objArray[13]));}
	 * 
	 * 
	 * query.registerStoredProcedureParameter(15,String.class,ParameterMode.IN);
	 * if(null!=objArray[14] && objArray[14]!=null) {
	 * query.setParameter(15,String.valueOf(objArray[14]));}
	 * 
	 * query.registerStoredProcedureParameter(16,String.class,ParameterMode.IN);
	 * if(null!=objArray[15] && objArray[15]!=null) {
	 * query.setParameter(16,String.valueOf(objArray[15]));}
	 * 
	 * query.registerStoredProcedureParameter(17,String.class,ParameterMode.IN);
	 * if(null!=objArray[16] && objArray[16]!=null) {
	 * query.setParameter(17,String.valueOf(objArray[16]));}
	 * 
	 * query.registerStoredProcedureParameter(18,String.class,ParameterMode.IN);
	 * if(null!=objArray[17] && objArray[17]!=null) {
	 * query.setParameter(18,String.valueOf(objArray[17]));}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * query.registerStoredProcedureParameter(19,String.class,ParameterMode.OUT);
	 * query.execute(); String out = (String) query.getOutputParameterValue(19);
	 * 
	 * System.out.println(out); request.setAttribute("result", out);
	 * 
	 * return out;
	 * 
	 * 
	 * 
	 * } finally { entityManager.close();
	 * 
	 * } }
	 * 
	 * public String generateResultBean_SP_GST_GST_1_UPDATE(Object[]
	 * objArray,HttpServletRequest request) {
	 * 
	 * logger.info("objArray[0]--> "+objArray[0]);
	 * logger.info("objArray[1]--> "+objArray[1]);
	 * logger.info("objArray[2]--> "+objArray[18]); if( objArray[18] == null ||
	 * objArray[18] == "") { objArray[18] = null; } try { StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_GST_GST_1_UPDATE");
	 * 
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * if(null!=objArray[0] && objArray[0]!=null) {
	 * query.setParameter(1,String.valueOf(objArray[0]));}
	 * 
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * if(null!=objArray[1] && objArray[1]!=null) {
	 * query.setParameter(2,String.valueOf(objArray[1]));}
	 * 
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * if(null!=objArray[2] && objArray[2]!=null) {
	 * query.setParameter(3,String.valueOf(objArray[2]));}
	 * 
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	 * if(null!=objArray[3] && objArray[3]!=null) {
	 * query.setParameter(4,String.valueOf(objArray[3]));}
	 * 
	 * query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	 * if(null!=objArray[4] && objArray[4]!=null) {
	 * query.setParameter(5,String.valueOf(objArray[4]));}
	 * 
	 * query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
	 * if(null!=objArray[5] && objArray[5]!=null) {
	 * query.setParameter(6,String.valueOf(objArray[5]));}
	 * 
	 * query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
	 * if(null!=objArray[6] && objArray[6]!=null) {
	 * query.setParameter(7,String.valueOf(objArray[6]));}
	 * 
	 * query.registerStoredProcedureParameter(8,String.class,ParameterMode.IN);
	 * if(null!=objArray[7] && objArray[7]!=null) {
	 * query.setParameter(8,String.valueOf(objArray[7]));}
	 * 
	 * 
	 * query.registerStoredProcedureParameter(9,String.class,ParameterMode.IN);
	 * if(null!=objArray[8] && objArray[8]!=null) {
	 * query.setParameter(9,String.valueOf(objArray[8]));}
	 * 
	 * query.registerStoredProcedureParameter(10,String.class,ParameterMode.IN);
	 * if(null!=objArray[9] && objArray[9]!=null) {
	 * query.setParameter(10,String.valueOf(objArray[9]));}
	 * 
	 * query.registerStoredProcedureParameter(11,String.class,ParameterMode.IN);
	 * if(null!=objArray[10] && objArray[10]!=null) {
	 * query.setParameter(11,String.valueOf(objArray[10]));}
	 * 
	 * 
	 * query.registerStoredProcedureParameter(12,String.class,ParameterMode.IN);
	 * if(null!=objArray[11] && objArray[11]!=null) {
	 * query.setParameter(12,String.valueOf(objArray[5]));}
	 * 
	 * query.registerStoredProcedureParameter(13,String.class,ParameterMode.IN);
	 * if(null!=objArray[12] && objArray[12]!=null) {
	 * query.setParameter(13,String.valueOf(objArray[12]));}
	 * 
	 * query.registerStoredProcedureParameter(14,String.class,ParameterMode.IN);
	 * if(null!=objArray[13] && objArray[13]!=null) {
	 * query.setParameter(14,String.valueOf(objArray[13]));}
	 * 
	 * 
	 * query.registerStoredProcedureParameter(15,String.class,ParameterMode.IN);
	 * if(null!=objArray[14] && objArray[14]!=null) {
	 * query.setParameter(15,String.valueOf(objArray[14]));}
	 * 
	 * query.registerStoredProcedureParameter(16,String.class,ParameterMode.IN);
	 * if(null!=objArray[15] && objArray[15]!=null) {
	 * query.setParameter(16,String.valueOf(objArray[15]));}
	 * 
	 * query.registerStoredProcedureParameter(17,String.class,ParameterMode.IN);
	 * if(null!=objArray[16] && objArray[16]!=null) {
	 * query.setParameter(17,String.valueOf(objArray[16]));}
	 * 
	 * query.registerStoredProcedureParameter(18,String.class,ParameterMode.IN);
	 * if(null!=objArray[17] && objArray[17]!=null) {
	 * query.setParameter(18,String.valueOf(objArray[17]));}
	 * 
	 * 
	 * 
	 * query.registerStoredProcedureParameter(19,String.class,ParameterMode.IN);
	 * if(null!=objArray[18] && objArray[18]!=null) {
	 * query.setParameter(19,String.valueOf(objArray[18]));}
	 * 
	 * 
	 * query.registerStoredProcedureParameter(20,String.class,ParameterMode.OUT);
	 * query.execute(); String out = (String) query.getOutputParameterValue(20);
	 * 
	 * System.out.println(out); request.setAttribute("result", out);
	 * 
	 * 
	 * return out;
	 * 
	 * } finally { entityManager.close();
	 * 
	 * } }
	 * 
	 * public SP_GST_GST_1_OPENING_Result
	 * generateResultBeanSP_GST_GST_1_OPENING(String cOMM_CODE, String mM_YYYY) {
	 * 
	 * logger.info(" cOMM_CODE "+cOMM_CODE); logger.info(" mM_YYYY "+mM_YYYY); try {
	 * StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_GST_GST_1_OPENING");
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,cOMM_CODE);
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * query.setParameter(2, mM_YYYY);
	 * 
	 * query.execute();
	 * 
	 * SP_GST_GST_1_OPENING_Result gst_Opening_Result=new
	 * SP_GST_GST_1_OPENING_Result(); return
	 * SP_GST_GST_1_OPENING_Result.generateOpeningResultList(query.getResultList());
	 * 
	 * } finally { entityManager.close();
	 * 
	 * } }
	 * 
	 * public void generateResultBeanSP_GST_GST_OPENING_UPDATE(Object[] objArray) {
	 * try { StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_GST_GST_OPENING_UPDATE");
	 * 
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * if(null!=objArray[0] && objArray[0]!=null) {
	 * query.setParameter(1,String.valueOf(objArray[0]));}
	 * 
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * if(null!=objArray[1] && objArray[1]!=null) {
	 * query.setParameter(2,String.valueOf(objArray[1]));}
	 * 
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * if(null!=objArray[2] && objArray[2]!=null) {
	 * query.setParameter(3,String.valueOf(objArray[2]));}
	 * 
	 * 
	 * 
	 * System.out.println("execute    execute    "+query.execute());
	 * 
	 * } finally { entityManager.close();
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * public Boolean generateResultBean_SP_GST_GST_OPENING_INSERT(Object[]
	 * objArray) { try { StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_GST_GST_OPENING_INSERT");
	 * 
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * if(null!=objArray[0] && objArray[0]!=null) {
	 * query.setParameter(1,String.valueOf(objArray[0]));}
	 * 
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * if(null!=objArray[1] && objArray[1]!=null) {
	 * query.setParameter(2,String.valueOf(objArray[1]));}
	 * 
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * if(null!=objArray[2] && objArray[2]!=null) {
	 * query.setParameter(3,String.valueOf(objArray[2]));}
	 * 
	 * 
	 * 
	 * System.out.println("execute    execute    "+query.execute());
	 * 
	 * return query.execute();
	 * 
	 * 
	 * 
	 * } finally { entityManager.close();
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * public SP_GST_GST_1_TRANSFER_COMM_TEMP_Result
	 * generateBeanSP_GST_GST_1_TRANSFER_COMM_TEMP(String cOMM_CODE, String mM_YYYY,
	 * Object cRR) {
	 * 
	 * System.out.println(" cOMM_CODE "+cOMM_CODE+"  mM_YYYY  "+mM_YYYY+"  cRR  "
	 * +cRR);
	 * 
	 * try { if(cRR == null || cRR == "") cRR = null; StoredProcedureQuery query
	 * =entityManager.createStoredProcedureQuery("SP_GST_GST_1_TRANSFER_COMM_TEMP");
	 * 
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * if(null!=cOMM_CODE && cOMM_CODE!=null) { query.setParameter(1,cOMM_CODE ); }
	 * 
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * if(null!=mM_YYYY && mM_YYYY!=null) { query.setParameter(2,mM_YYYY ); }
	 * 
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.OUT);
	 * 
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	 * if(cRR!=null) { query.setParameter(4,cRR ); }
	 * 
	 * query.execute();
	 * 
	 * String out = (String) query.getOutputParameterValue(3);
	 * 
	 * System.out.println(query.execute());
	 * 
	 * SP_GST_GST_1_TRANSFER_COMM_TEMP_Result transfer_Result=new
	 * SP_GST_GST_1_TRANSFER_COMM_TEMP_Result(); return
	 * transfer_Result.generateResultBeanListtransferTemp(query.getResultList());
	 * 
	 * 
	 * 
	 * 
	 * } finally { entityManager.close();
	 * 
	 * }
	 */
		
		
		public String generateResult_SP_SUBMISSION_GST_GST(String comm_code, String user, String remoteAddr,
				String report_Group) {
			logger.info(comm_code +"  ,  "+ user+"  ,  "+ remoteAddr +"  ,  "+report_Group);
			
			
			
			try { 
				  StoredProcedureQuery query =entityManager.createStoredProcedureQuery("SP_SUBMISSION_GST_GST");
				  
				  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
				  if(null!=comm_code && comm_code!=null) {
				  query.setParameter(1,comm_code ); }
				  
				  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
				  if(null!=user && user!=null) {
				  query.setParameter(2,user ); }
				  
				  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
				  if(null!=remoteAddr && remoteAddr!=null) {
				  query.setParameter(3,remoteAddr ); }
				  
				  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
				  if(null!=report_Group && report_Group!=null) {
				  query.setParameter(4,report_Group ); }
				  
				  query.registerStoredProcedureParameter(5,String.class,ParameterMode.OUT);
				 
				  query.execute(); 
				  String out = (String) query.getOutputParameterValue(5);
				 
				  System.out.println(out);
				  
				  return out;
				
				 
			 }
				finally {
					entityManager.close();
					
				}
			
		}


		
		
	//}
	
	/*
	
	
	public List<SP_GST_GST_1_COMMCODE_Result> generateResultBean_SP_GST_GST_1_COMMCODE(String cOMM_CODE) {
		 try {
			   logger.info("Calling SP_GST_GST_1_COMMCODE");
			  StoredProcedureQuery query =entityManager.createStoredProcedureQuery("SP_GST_GST_1_COMMCODE");
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,cOMM_CODE); 	  
			  
			  query.execute(); 
			  
			  SP_GST_GST_1_COMMCODE_Result gst_CommCode_Result=new SP_GST_GST_1_COMMCODE_Result();
			  return gst_CommCode_Result.generateResultBeanListCommCode(query.getResultList());
			  
			 }
				finally {
					entityManager.close();
					
				}
	}

	public void generateResult_SP_GST_GST_1_TRANSFER_DELETE(String cOMM_CODE, String mM_YYYY) {
		try {
			  StoredProcedureQuery query =entityManager.createStoredProcedureQuery("SP_GST_GST_1_TRANSFER_DELETE");
			
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,cOMM_CODE); 	  
			  
			  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
			  query.setParameter(2,mM_YYYY); 	  
			  
			  query.execute(); 
			  
			  System.out.println(" SP_GST_GST_1_TRANSFER_DELETE    "+query.execute());
			  
			  
			  
			 }
				finally {
					entityManager.close();
					
				}
		
	}

	public String generateResultBean_SP_GST_GST_1_1_TRANSFER_INSERT(String comm_CODE, String mM_YYYY, String string,
			String string2, String mONTH_LESS_2_NO, String mONTH_LESS_2_AMT, String mONTH_LESS_2_6_NO, String mONTH_LESS_2_6_AMT,
			String mONTH_MORE_6_NO, String mONTH_MORE_6_AMT) {	
		
		   System.out.println( comm_CODE +" , "+ mM_YYYY+" , "+string+" , "+string2+" , "+ mONTH_LESS_2_NO+" , "+mONTH_LESS_2_AMT+" , "+mONTH_LESS_2_6_NO+" , "+mONTH_LESS_2_6_AMT
				   +" , "+mONTH_MORE_6_NO+" , "+mONTH_MORE_6_AMT
				   );
		
		try {
			  StoredProcedureQuery query =entityManager.createStoredProcedureQuery("SP_GST_GST_1_1_TRANSFER_INSERT");
			
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,comm_CODE); 	  
			  
			  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
			  query.setParameter(2,mM_YYYY); 
			  
			  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
			  query.setParameter(3,string); 	  
			  
			  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
			  query.setParameter(4,string2);  	  
			  
			  query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
			  query.setParameter(5,mONTH_LESS_2_NO);  	  
			  
			  query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
			  query.setParameter(6,mONTH_LESS_2_AMT);  	  
			  
			  query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
			  query.setParameter(7,mONTH_LESS_2_6_NO);  			  
			  
			  query.registerStoredProcedureParameter(8,String.class,ParameterMode.IN);
			  query.setParameter(8,mONTH_LESS_2_6_AMT);  	  
			  
			  query.registerStoredProcedureParameter(9,String.class,ParameterMode.IN);
			  query.setParameter(9,mONTH_MORE_6_NO); 
			  
			  
			  query.registerStoredProcedureParameter(10,String.class,ParameterMode.IN);
			  query.setParameter(10,mONTH_MORE_6_NO); 				  
			  
			  query.registerStoredProcedureParameter(11,String.class,ParameterMode.OUT);
			    
			  query.execute(); 
			  
			  String out = (String) query.getOutputParameterValue(11);
			  System.out.println(" query.getParameterValue(11)  "+query.getOutputParameterValue(11));
			  
			  return out;
			  
			 }
				finally {
					entityManager.close();
					
				}
		
	}

	public String generateResultSP_GST_GST_1_TRANSFER_INSERT(String cOMM_CODE, String mM_YYYY, String string,
			String string2, String age_WISE_BREAKUP, String comm_CODE2) {
		
		logger.info( cOMM_CODE +"  ,  "+ mM_YYYY  +"  ,  "+  string
			+"  ,  "+ string2+"  ,  "+  age_WISE_BREAKUP+"  ,  "+  comm_CODE2);
		
		try {
			  StoredProcedureQuery query =entityManager.createStoredProcedureQuery("SP_GST_GST_1_TRANSFER_INSERT");
			
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,cOMM_CODE); 	  
			  
			  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
			  query.setParameter(2,mM_YYYY); 
			  
			  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
			  query.setParameter(3,string); 	  
			  
			  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
			  query.setParameter(4,string2);  	  
			  
			  query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
			  query.setParameter(5,age_WISE_BREAKUP);  	  
			  
			  query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
			  query.setParameter(6,comm_CODE2);  	  
			  
			 
			  query.registerStoredProcedureParameter(7,String.class,ParameterMode.OUT);
			 
			  
			  query.execute(); 
			  
			  String out = (String) query.getOutputParameterValue(7);
			 
			  logger.info(" out "+out);
			  
			  return out;
			  
			 }
				finally {
					entityManager.close();
					
				}
		
		
		
	}
	*/
	
	}