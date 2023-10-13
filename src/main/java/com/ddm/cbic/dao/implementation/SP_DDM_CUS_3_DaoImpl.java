package com.ddm.cbic.dao.implementation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ddm.cbic.model.SP_DDM_CUS_3_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_TEMP_WITH_OUT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_TEMP_REPORT_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_3_INSERT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_REGION_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_3_TEMP_UPDATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_ZONE_Result;

import com.ddm.cbic.model.SP_DDM_CE_4_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CE_4_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CE_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CE_4_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CE_4_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CE_4_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_ZONE_Result;


import com.ddm.cbic.model.SP_DDM_CUS_5_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_COMM_TEMP_REPORT_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_5_INSERT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_MEMBER_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_REGION_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_5_TEMP_UPDATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_ZONE_Result;

import com.ddm.cbic.model.SP_DDM_GST_5_ALL_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_COMM_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_REGION_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_ZONE_Result;


import com.ddm.cbic.model.SP_DDM_CUS_6_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_ALL_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_REGION_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_COMM_TEMP_Result;



import com.ddm.cbic.model.SP_DDM_GST_1_COMM_TEMP_Result;

import com.ddm.cbic.model.SP_DDM_CE_5_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_MEMBER_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_ZONE_Result;

import com.ddm.cbic.model.SP_DDM_CUS_1A_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_COMM_TEMP_ProcResult;
import com.ddm.cbic.model.SP_DDM_CUS_1A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_ZONE_Result;




@Repository
public class SP_DDM_CUS_3_DaoImpl {
	@Autowired
	private EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(SP_DDM_CUS_3_DaoImpl.class);
		
	public String generateResultBean_SP_MPR_CHECK_VALIDATE_UPTO(Object[] objArray){
		  System.out.println("objArray--> "+objArray[0]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_MPR_CHECK_VALIDATE_UPTO");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,objArray[0].toString() ); 
		  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		  query.setParameter(2,objArray[1].toString() ); 
		  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		  query.setParameter(3,objArray[2].toString() ); 
		  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
		  query.execute(); 
		  String out = query.getOutputParameterValue(4).toString();
		  return out	;
	     }
	

public boolean generateResultBean_SP_SUBMIT_LOG_UPTO_SELECT(Object[] objArray){
	  System.out.println("objArray--> "+objArray[0]);
	  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_SUBMIT_LOG_UPTO_SELECT");
	  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	  query.setParameter(1,objArray[0].toString() ); 
	  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	  query.setParameter(2,objArray[1].toString() ); 
	  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	  query.setParameter(3,objArray[2].toString() ); 
	  return query.execute(); 
	 
}
	

	//-----138
	private SP_DDM_CUS_3_ALL_Result sp_SP_DDM_CUS_3_ALL_Result = new SP_DDM_CUS_3_ALL_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_ALL_Result> generateResultList_SP_DDM_CUS_3_ALL(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0].toString());
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_SP_DDM_CUS_3_ALL_Result.generateResultList_SP_DDM_CUS_3_ALL(query.getResultList());
		}
		else {
			return new ArrayList<SP_DDM_CUS_3_ALL_Result>();
		}
	}

//Object
	public SP_DDM_CUS_3_ALL_Result generateResultBean_SP_DDM_CUS_3_ALL(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0].toString());
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_SP_DDM_CUS_3_ALL_Result.generateResultBean_SP_DDM_CUS_3_ALL((Object[]) query.getResultList().get(0));
		}
		else {
			return new SP_DDM_CUS_3_ALL_Result();
		}
	}

//-----148
	private SP_DDM_CUS_3_COMM_Result sp_SP_DDM_CUS_3_COMM_Result = new SP_DDM_CUS_3_COMM_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_COMM_Result> generateResultList_SP_DDM_CUS_3_COMM(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,  objArray[1].toString());
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_SP_DDM_CUS_3_COMM_Result.generateResultList_SP_DDM_CUS_3_COMM(query.getResultList());
		}
		else {
			return new ArrayList<SP_DDM_CUS_3_COMM_Result>();
		}
	}

//Object
	public SP_DDM_CUS_3_COMM_Result generateResultBean_SP_DDM_CUS_3_COMM(Object[] objArray) {
		System.out.println("in DDM_CUS_3 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,  objArray[1].toString());
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_SP_DDM_CUS_3_COMM_Result.generateResultBean_SP_DDM_CUS_3_COMM((Object[]) query.getResultList().get(0));
	}
	else {
		return new SP_DDM_CUS_3_COMM_Result();
	}
	}
	
	
	//-----
		/*
		private SP_DDM_CUS_3_COMM_TEMP_Result sp_SP_DDM_CUS_3_COMM_TEMP_Result = new SP_DDM_CUS_3_COMM_TEMP_Result();

		@SuppressWarnings("unchecked")

		public List<SP_DDM_CUS_3_COMM_TEMP_Result> generateResultList_SP_DDM_CUS_3_COMM_TEMP(Object[] objArray) {
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM_TEMP");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1,  objArray[0].toString());
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2,  objArray[1].toString());
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3,  objArray[2].toString());
//			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
//			query.setParameter(4,  objArray[3].toString());
//			query.execute();
			
			query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);		  
			  query.execute(); 
			
			  if(query.getResultList().size() > 0) {
			return sp_SP_DDM_CUS_3_COMM_TEMP_Result.generateResultList_SP_DDM_CUS_3_COMM_TEMP(query.getResultList());
		}
		else {
			return new ArrayList<SP_DDM_CUS_3_COMM_TEMP_Result>();
		}
		}
		*/

	//Object
			 
		  private SP_DDM_CUS_3_COMM_TEMP_Result SP_DDM_CUS_3_COMM_TEMP_Result=new SP_DDM_CUS_3_COMM_TEMP_Result();
		  public SP_DDM_CUS_3_COMM_TEMP_WITH_OUT_Result generateResultBean_SP_DDM_CUS_3_COMM_TEMP(Object[] objArray,HttpServletRequest request){
			  System.out.println("objArray 0--> "+objArray[0]);
			  System.out.println("objArray1--> "+objArray[1]);
			  System.out.println("objArray2--> "+objArray[2]);
			  System.out.println("objArray 3--> "+objArray[3]);
			  SP_DDM_CUS_3_COMM_TEMP_WITH_OUT_Result sp_DDM_CUS_3_COMM_TEMP_WITH_OUT_Result = new SP_DDM_CUS_3_COMM_TEMP_WITH_OUT_Result();
			  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM_TEMP");
			  
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  if(null!=objArray[0] ) {query.setParameter(1,objArray[0].toString() ); logger.info("objArray[0].toString()"+objArray[0].toString());} 
			  
			  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);			  
			  if(null!=objArray[1] ) {query.setParameter(2,objArray[1].toString() );  logger.info("objArray[1].toString()"+objArray[1].toString());}
			 			  
			  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
			  if(null!=objArray[2] ) { query.setParameter(3,objArray[2].toString() ); logger.info("objArray[2].toString()"+objArray[2].toString());}
			  
				  
			  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);		  
			  query.execute(); 
			  String out = query.getOutputParameterValue(4).toString();
			  logger.info("--out-- from with out "+out);
			  
			  logger.info("query.getResultList().size() "+query.getResultList().size());
			  request.getSession().setAttribute("_Result", out);
			  
			  sp_DDM_CUS_3_COMM_TEMP_WITH_OUT_Result.setOut(out);
			  sp_DDM_CUS_3_COMM_TEMP_WITH_OUT_Result.setSp_DDM_CUS_3_COMM_TEMP_Result(null);
			 
			  //request.getSession().setAttribute("_Result", out);
			 if(query.getResultList().size() > 0) {
				  sp_DDM_CUS_3_COMM_TEMP_WITH_OUT_Result.setSp_DDM_CUS_3_COMM_TEMP_Result(SP_DDM_CUS_3_COMM_TEMP_Result.generateResultBean_SP_DDM_CUS_3_COMM_TEMP((Object[])query.getResultList().get(0)));
			  return sp_DDM_CUS_3_COMM_TEMP_WITH_OUT_Result;
		  }
			else {
				return sp_DDM_CUS_3_COMM_TEMP_WITH_OUT_Result;
			}
			
		 }		  
		

//-----
	private SP_DDM_CUS_3_COMM_TEMP_REPORT_Result sp_SP_DDM_CUS_3_COMM_TEMP_REPORT_Result = new SP_DDM_CUS_3_COMM_TEMP_REPORT_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CUS_3_COMM_TEMP_REPORT(Object[] objArray) {
		System.out.println("objArray--> "+objArray[0]);
		  System.out.println("objArray--> "+objArray[1]);
		  System.out.println("objArray--> "+objArray[2]);
		  System.out.println("objArray--> "+objArray[3]);
		  System.out.println("objArray--> "+objArray[4]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,  objArray[1].toString());
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3,  objArray[2].toString());
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4,  objArray[3].toString());
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5,  objArray[4].toString());
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_SP_DDM_CUS_3_COMM_TEMP_REPORT_Result.generateResultList_SP_DDM_CUS_3_COMM_TEMP_REPORT(query.getResultList());
	}
	else {
		return new ArrayList<SP_DDM_CUS_3_COMM_TEMP_REPORT_Result>();
	}
	}

//Object
	public SP_DDM_CUS_3_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CUS_3_COMM_TEMP_REPORT(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) 
		  {
		  query.setParameter(2,objArray[1].toString() ); 
		  }		
		//query.setParameter(2, objArray[1]);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null!=objArray[2] && objArray[2]!=null) 
		  {
		  query.setParameter(3,objArray[2].toString() ); 
		  }
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		if(null!=objArray[3] && objArray[3]!=null) 
		  {
		   query.setParameter(4,objArray[3].toString() ); 
		  }
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, objArray[4].toString());
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_SP_DDM_CUS_3_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CUS_3_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
	}
	else {
		return new SP_DDM_CUS_3_COMM_TEMP_REPORT_Result();
	}
	}

//-----151
	//--INSERT/UPDATE---152
	//public boolean executeProc(Object[] objArray) {
	public String generateResultBeanSP_DDM_CUS_3_INSERT(Object[] objArray){	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);		
		if(null != objArray[0]) {query.setParameter(1,  objArray[0].toString());}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null != objArray[1]) {query.setParameter(2,  objArray[1].toString());}
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null != objArray[2]) {query.setParameter(3,  objArray[2].toString());}
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		if(null != objArray[3]) {query.setParameter(4,  objArray[3].toString());}
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		if(null != objArray[4]) {query.setParameter(5,  objArray[4].toString());}
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		if(null != objArray[5]) {query.setParameter(6,  objArray[5].toString());}
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		if(null != objArray[6]) {query.setParameter(7,  objArray[6].toString());}
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		if(null != objArray[7]) {query.setParameter(8,  objArray[7].toString());}
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		if(null != objArray[8]) {query.setParameter(9,  objArray[8].toString());}
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		if(null != objArray[9]) {query.setParameter(10,  objArray[9].toString());}
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		if(null != objArray[10]) {query.setParameter(11,  objArray[10].toString());}
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		if(null != objArray[11]) {query.setParameter(12,  objArray[11].toString());}
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		if(null != objArray[12]) {query.setParameter(13,  objArray[12].toString());}
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		if(null != objArray[13]) {query.setParameter(14,  objArray[13].toString());}
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		if(null != objArray[14]) {query.setParameter(15,  objArray[14].toString());}
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		if(null != objArray[15]) {query.setParameter(16,  objArray[15].toString());}
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		if(null != objArray[16]) {query.setParameter(17,  objArray[16].toString());}
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		if(null != objArray[17]) {query.setParameter(18,  objArray[17].toString());}
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		if(null != objArray[18]) {query.setParameter(19,  objArray[18].toString());}
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		if(null != objArray[19]) {query.setParameter(20,  objArray[19].toString());}
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		if(null != objArray[20]) {query.setParameter(21,  objArray[20].toString());}
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		if(null != objArray[21]) {query.setParameter(22,  objArray[21].toString());}
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		if(null != objArray[22]) {query.setParameter(23,  objArray[22].toString());}
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		if(null != objArray[23]) {query.setParameter(24,  objArray[23].toString());}
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		if(null != objArray[24]) {query.setParameter(25,  objArray[24].toString());}
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		if(null != objArray[25]) {query.setParameter(26,  objArray[25].toString());}
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		if(null != objArray[26]) {query.setParameter(27,  objArray[26].toString());}
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		if(null != objArray[27]) {query.setParameter(28,  objArray[27].toString());}
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
		if(null != objArray[28]) {query.setParameter(29,  objArray[28].toString());}
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.IN);
		if(null != objArray[29]) {query.setParameter(30,  objArray[29].toString());}
		query.registerStoredProcedureParameter(31,String.class,ParameterMode.OUT);
		query.execute(); 
		String out = query.getOutputParameterValue(31).toString();
		return out	;
		  //return query.execute();
		
		//return query.execute();
	}

//--INSERT/UPDATE---153

//-----154
	private SP_DDM_CUS_3_MAX_DATE_Result sp_SP_DDM_CUS_3_MAX_DATE_Result = new SP_DDM_CUS_3_MAX_DATE_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_MAX_DATE_Result> generateResultList_SP_DDM_CUS_3_MAX_DATE(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0].toString());
		query.execute();
		return sp_SP_DDM_CUS_3_MAX_DATE_Result.generateResultList_SP_DDM_CUS_3_MAX_DATE(query.getResultList());
	}

//Object
	
	public Object generateResultBean_SP_DDM_CUS_3_MAX_DATE(Object[] objArray){
		  System.out.println("objArray--> "+objArray[0]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_3_MAX_DATE");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,objArray[0].toString() ); 
		  query.execute(); 
		  return  query.getResultList().get(0);
		  }
	

//-----155
	
//-----156
	private SP_DDM_CUS_3_REGION_Result sp_SP_DDM_CUS_3_REGION_Result = new SP_DDM_CUS_3_REGION_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_REGION_Result> generateResultList_SP_DDM_CUS_3_REGION(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,  objArray[1].toString());
		query.execute();
		return sp_SP_DDM_CUS_3_REGION_Result.generateResultList_SP_DDM_CUS_3_REGION(query.getResultList());
	}

//Object
	public SP_DDM_CUS_3_REGION_Result generateResultBean_SP_DDM_CUS_3_REGION(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,  objArray[1].toString());
		query.execute();
		return sp_SP_DDM_CUS_3_REGION_Result
				.generateResultBean_SP_DDM_CUS_3_REGION((Object[]) query.getResultList().get(0));
	}

//--INSERT/UPDATE---157
	//public boolean executeProc(Object[] objArray) {
		public String generateResultBean_SP_DDM_CUS_3_TEMP_UPDATE(Object[] objArray){
	
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_TEMP_UPDATE");
		
		  System.out.println("objArray[0]--> "+objArray[0]);
		  System.out.println("objArray[1]--> "+objArray[1]);
		  System.out.println("objArray[2]--> "+objArray[2]);
		  System.out.println("objArray[3]--> "+objArray[3]);
		  System.out.println("objArray[4]--> "+objArray[4]);
		  System.out.println("objArray[5]--> "+objArray[5]);
		  System.out.println("objArray[6]--> "+objArray[6]);
		  System.out.println("objArray[7]--> "+objArray[7]);
		  System.out.println("objArray[8]--> "+objArray[8]);
		  System.out.println("objArray[9]--> "+objArray[9]);
		  System.out.println("objArray[10]--> "+objArray[10]);
		  System.out.println("objArray[11]--> "+objArray[11]);
		  System.out.println("objArray[12]--> "+objArray[12]);
		  System.out.println("objArray[13]--> "+objArray[13]);
		  System.out.println("objArray[14]--> "+objArray[14]);
		  System.out.println("objArray[15]--> "+objArray[15]);
		  System.out.println("objArray[16]--> "+objArray[16]);
		  System.out.println("objArray[17]--> "+objArray[17]);
		  System.out.println("objArray[18]--> "+objArray[18]);
		  System.out.println("objArray[19]--> "+objArray[19]);
		  System.out.println("objArray[20]--> "+objArray[20]);
		  System.out.println("objArray[21]--> "+objArray[21]);
		  System.out.println("objArray[22]--> "+objArray[22]);
		  System.out.println("objArray[23]--> "+objArray[23]);
		  System.out.println("objArray[24]--> "+objArray[24]);
		  System.out.println("objArray[25]--> "+objArray[25]);
		  System.out.println("objArray[26]--> "+objArray[26]);
		  System.out.println("objArray[27]--> "+objArray[27]);
		  System.out.println("objArray[28]--> "+objArray[28]);
		  System.out.println("objArray[29]--> "+objArray[29]);
		  System.out.println("objArray[30]--> "+objArray[30]);
		  
		  query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		  if(null != objArray[0]) {query.setParameter(1,  objArray[0].toString());}
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			if(null != objArray[1]) {query.setParameter(2,  objArray[1].toString());}
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			if(null != objArray[2]) {query.setParameter(3,  objArray[2].toString());}
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			if(null != objArray[3]) {query.setParameter(4,  objArray[3].toString());}
			query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			if(null != objArray[4]) {query.setParameter(5,  objArray[4].toString());}
			query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
			if(null != objArray[5]) {query.setParameter(6,  objArray[5].toString());}
			query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
			if(null != objArray[6]) {query.setParameter(7,  objArray[6].toString());}
			query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
			if(null != objArray[7]) {query.setParameter(8,  objArray[7].toString());}
			query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
			if(null != objArray[8]) {query.setParameter(9,  objArray[8].toString());}
			query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
			if(null != objArray[9]) {query.setParameter(10,  objArray[9].toString());}
			query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
			if(null != objArray[10]) {query.setParameter(11,  objArray[10].toString());}
			query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
			if(null != objArray[11]) {query.setParameter(12,  objArray[11].toString());}
			query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
			if(null != objArray[12]) {query.setParameter(13,  objArray[12].toString());}
			query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
			if(null != objArray[13]) {query.setParameter(14,  objArray[13].toString());}
			query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
			if(null != objArray[14]) {query.setParameter(15,  objArray[14].toString());}
			query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
			if(null != objArray[15]) {query.setParameter(16,  objArray[15].toString());}
			query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
			if(null != objArray[16]) {query.setParameter(17,  objArray[16].toString());}
			query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
			if(null != objArray[17]) {query.setParameter(18,  objArray[17].toString());}
			query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
			if(null != objArray[18]) {query.setParameter(19,  objArray[18].toString());}
			query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
			if(null != objArray[19]) {query.setParameter(20,  objArray[19].toString());}
			query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
			if(null != objArray[20]) {query.setParameter(21,  objArray[20].toString());}
			query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
			if(null != objArray[21]) {query.setParameter(22,  objArray[21].toString());}
			query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
			if(null != objArray[22]) {query.setParameter(23,  objArray[22].toString());}
			query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
			if(null != objArray[23]) {query.setParameter(24,  objArray[23].toString());}
			query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
			if(null != objArray[24]) {query.setParameter(25,  objArray[24].toString());}
			query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
			if(null != objArray[25]) {query.setParameter(26,  objArray[25].toString());}
			query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
			if(null != objArray[26]) {query.setParameter(27,  objArray[26].toString());}
			query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
			if(null != objArray[27]) {query.setParameter(28,  objArray[27].toString());}
			query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
			if(null != objArray[28]) {query.setParameter(29,  objArray[28].toString());}
			
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.IN);   // for crr
		
		if(null!=objArray[29] && objArray[29]!=null) 
		  {
		  query.setParameter(30,objArray[29].toString() ); 
		  }
		
		query.registerStoredProcedureParameter(31, String.class, ParameterMode.IN);
		query.setParameter(31, objArray[30].toString());
		
		 query.registerStoredProcedureParameter(32,String.class,ParameterMode.OUT);
		  query.execute(); 
		  String out = query.getOutputParameterValue(32).toString();
		  return out	;
		  //return query.execute();
	}

//--INSERT/UPDATE---158
	//-----159
	private SP_DDM_CUS_3_ZONE_Result sp_SP_DDM_CUS_3_ZONE_Result = new SP_DDM_CUS_3_ZONE_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_ZONE_Result> generateResultList_SP_DDM_CUS_3_ZONE(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,  objArray[1].toString());
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_SP_DDM_CUS_3_ZONE_Result.generateResultList_SP_DDM_CUS_3_ZONE(query.getResultList());
		}
		else {
			return new ArrayList<SP_DDM_CUS_3_ZONE_Result>();
		}
	}

//Object
	public SP_DDM_CUS_3_ZONE_Result generateResultBean_SP_DDM_CUS_3_ZONE(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,  objArray[1].toString());
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_SP_DDM_CUS_3_ZONE_Result
				.generateResultBean_SP_DDM_CUS_3_ZONE((Object[]) query.getResultList().get(0));
		}
		else {
			return new SP_DDM_CUS_3_ZONE_Result();
		}
	}
//-----160
	
				
}
