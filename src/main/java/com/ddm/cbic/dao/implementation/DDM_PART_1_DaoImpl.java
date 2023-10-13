package com.ddm.cbic.dao.implementation;

import java.math.BigInteger;
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

import com.ddm.cbic.model.SP_DDM_CE_4_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CE_4_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CE_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CE_4_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CE_4_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CE_4_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_MEMBER_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CE_5_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CE_6_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CE_6_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CE_6_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CE_6_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CE_6_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_COMM_TEMP_ProcResult;
import com.ddm.cbic.model.SP_DDM_CUS_1A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1A_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_2_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_TEMP_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_3_INSERT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_REGION_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_3_TEMP_UPDATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_COMM_TEMP_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_5_INSERT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_MEMBER_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_REGION_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_5_TEMP_UPDATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_ALL_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_REGION_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_ALL_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_COMM_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_REGION_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_ST_6_ALL_Result;
import com.ddm.cbic.model.SP_DDM_ST_6_COMM_Result;
import com.ddm.cbic.model.SP_DDM_ST_6_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_ST_6_REGION_Result;
import com.ddm.cbic.model.SP_DDM_ST_6_ZONE_Result;


@Repository
public class DDM_PART_1_DaoImpl {
	@Autowired
	private EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(DDM_PART_1_DaoImpl.class);
		
	public String generateResultBean_SP_MPR_CHECK_VALIDATE_UPTO(Object[] objArray){
		  System.out.println("objArray--> "+objArray[0]);
		   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_MPR_CHECK_VALIDATE_UPTO");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		  query.setParameter(2,(String)objArray[1] ); 
		  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		  query.setParameter(3,(String)objArray[2] ); 
		  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
		  query.execute(); 
		  String out = (String)query.getOutputParameterValue(4);
		  return out	;
	     }finally {em.close();}}
	

public boolean generateResultBean_SP_SUBMIT_LOG_UPTO_SELECT(Object[] objArray){
	  System.out.println("objArray--> "+objArray[0]);
	   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_SUBMIT_LOG_UPTO_SELECT");
	  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	  query.setParameter(1,(String)objArray[0] ); 
	  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	  query.setParameter(2,(String)objArray[1] ); 
	  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	  query.setParameter(3,(String)objArray[2] ); 
	  return query.execute(); 
	 
}finally {em.close();}}
	

	//-----138
	private SP_DDM_CUS_3_ALL_Result sp_SP_DDM_CUS_3_ALL_Result = new SP_DDM_CUS_3_ALL_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_ALL_Result> generateResultList_SP_DDM_CUS_3_ALL(Object[] objArray) {
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.execute();
		return sp_SP_DDM_CUS_3_ALL_Result.generateResultList_SP_DDM_CUS_3_ALL(query.getResultList());
	}finally {em.close();}}

//Object
	public SP_DDM_CUS_3_ALL_Result generateResultBean_SP_DDM_CUS_3_ALL(Object[] objArray) {
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.execute();
		return sp_SP_DDM_CUS_3_ALL_Result.generateResultBean_SP_DDM_CUS_3_ALL((Object[]) query.getResultList().get(0));
	}finally {em.close();}}

//-----148
	private SP_DDM_CUS_3_COMM_Result sp_SP_DDM_CUS_3_COMM_Result = new SP_DDM_CUS_3_COMM_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_COMM_Result> generateResultList_SP_DDM_CUS_3_COMM(Object[] objArray) {
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_CUS_3_COMM_Result.generateResultList_SP_DDM_CUS_3_COMM(query.getResultList());
	}finally {em.close();}}

//Object
	public SP_DDM_CUS_3_COMM_Result generateResultBean_SP_DDM_CUS_3_COMM(Object[] objArray) {
		System.out.println("in DDM_CUS_3 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_CUS_3_COMM_Result.generateResultBean_SP_DDM_CUS_3_COMM((Object[]) query.getResultList().get(0));
	}finally {em.close();}}
	
	
	//-----
		private SP_DDM_CUS_3_COMM_TEMP_Result sp_SP_DDM_CUS_3_COMM_TEMP_Result = new SP_DDM_CUS_3_COMM_TEMP_Result();

		@SuppressWarnings("unchecked")

		public List<SP_DDM_CUS_3_COMM_TEMP_Result> generateResultList_SP_DDM_CUS_3_COMM_TEMP(Object[] objArray) {
			 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM_TEMP");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, (String) objArray[2]);
//			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
//			query.setParameter(4, (String) objArray[3]);
//			query.execute();
			
			query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);		  
			  query.execute(); 
			
			
			return sp_SP_DDM_CUS_3_COMM_TEMP_Result.generateResultList_SP_DDM_CUS_3_COMM_TEMP(query.getResultList());
		}finally {em.close();}}

	//Object
			 
		  private SP_DDM_CUS_3_COMM_TEMP_Result SP_DDM_CUS_3_COMM_TEMP_Result=new SP_DDM_CUS_3_COMM_TEMP_Result();
		  public SP_DDM_CUS_3_COMM_TEMP_Result generateResultBean_SP_DDM_CUS_3_COMM_TEMP(Object[] objArray,HttpServletRequest request){
			  System.out.println("objArray--> "+objArray[0]);
			  System.out.println("objArray--> "+objArray[1]);
			  System.out.println("objArray--> "+objArray[2]);
			  System.out.println("objArray--> "+objArray[3]);
			   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM_TEMP");
			  
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,(String)objArray[0] ); 
			  
			  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
			  
			  if(null!=objArray[1] && objArray[1]!=null) 
			  {
			  query.setParameter(2,(String)objArray[1] ); 
			  }
			 			  
			  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
			  query.setParameter(3,(String)objArray[2] ); 
			  
				  
			  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);		  
			  query.execute(); 
			  String out = (String)query.getOutputParameterValue(4);
			  logger.info("--out--"+out);
			  request.getSession().setAttribute("_Result", out);
			  return SP_DDM_CUS_3_COMM_TEMP_Result.generateResultBean_SP_DDM_CUS_3_COMM_TEMP((Object[])query.getResultList().get(0));
			  
		 }finally {em.close();}}		  
		

//-----
	private SP_DDM_CUS_3_COMM_TEMP_REPORT_Result sp_SP_DDM_CUS_3_COMM_TEMP_REPORT_Result = new SP_DDM_CUS_3_COMM_TEMP_REPORT_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CUS_3_COMM_TEMP_REPORT(Object[] objArray) {
		System.out.println("objArray--> "+objArray[0]);
		  System.out.println("objArray--> "+objArray[1]);
		  System.out.println("objArray--> "+objArray[2]);
		  System.out.println("objArray--> "+objArray[3]);
		  System.out.println("objArray--> "+objArray[4]);
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, (String) objArray[2]);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, (String) objArray[3]);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, (String) objArray[4]);
		query.execute();
		return sp_SP_DDM_CUS_3_COMM_TEMP_REPORT_Result.generateResultList_SP_DDM_CUS_3_COMM_TEMP_REPORT(query.getResultList());
	}finally {em.close();}}

//Object
	public SP_DDM_CUS_3_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CUS_3_COMM_TEMP_REPORT(Object[] objArray) {
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,(String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) 
		  {
		  query.setParameter(2,(String)objArray[1] ); 
		  }		
		//query.setParameter(2,(String) objArray[1]);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null!=objArray[2] && objArray[2]!=null) 
		  {
		  query.setParameter(3,(String)objArray[2] ); 
		  }
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		if(null!=objArray[3] && objArray[3]!=null) 
		  {
		   query.setParameter(4,(String)objArray[3] ); 
		  }
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5,(String) objArray[4]);
		query.execute();
		return sp_SP_DDM_CUS_3_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CUS_3_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
	}finally {em.close();}}

//-----151
	//--INSERT/UPDATE---152
	//public boolean executeProc(Object[] objArray) {
	public String generateResultBeanSP_DDM_CUS_3_INSERT(Object[] objArray){	
	 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, (String) objArray[2]);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, (String) objArray[3]);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, (String) objArray[4]);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, (String) objArray[5]);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, (String) objArray[6]);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, (String) objArray[7]);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, (String) objArray[8]);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, (String) objArray[9]);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, (String) objArray[10]);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, (String) objArray[11]);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13, (String) objArray[12]);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14, (String) objArray[13]);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15, (String) objArray[14]);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16, (String) objArray[15]);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17, (String) objArray[16]);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18, (String) objArray[17]);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19, (String) objArray[18]);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20, (String) objArray[19]);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21, (String) objArray[20]);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22, (String) objArray[21]);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23, (String) objArray[22]);
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24, (String) objArray[23]);
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25, (String) objArray[24]);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26, (String) objArray[25]);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		query.setParameter(27, (String) objArray[26]);
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		query.setParameter(28, (String) objArray[27]);
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
		if(objArray[28]!=null) {
		query.setParameter(29, (String) objArray[28]);}
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.IN);
		if(objArray[29]!=null) {
		query.setParameter(30, (String) objArray[29]);}
		query.registerStoredProcedureParameter(31,String.class,ParameterMode.OUT);
		query.execute(); 
		String out = (String)query.getOutputParameterValue(31);
		return out	;
		  //return query.execute();
		
		//return query.execute();
	}finally {em.close();}}

//--INSERT/UPDATE---153

//-----154
	private SP_DDM_CUS_3_MAX_DATE_Result sp_SP_DDM_CUS_3_MAX_DATE_Result = new SP_DDM_CUS_3_MAX_DATE_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_MAX_DATE_Result> generateResultList_SP_DDM_CUS_3_MAX_DATE(Object[] objArray) {
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.execute();
		return sp_SP_DDM_CUS_3_MAX_DATE_Result.generateResultList_SP_DDM_CUS_3_MAX_DATE(query.getResultList());
	}finally {em.close();}}

//Object
	
	public Object generateResultBean_SP_DDM_CUS_3_MAX_DATE(Object[] objArray){
		  System.out.println("objArray--> "+objArray[0]);
		   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_3_MAX_DATE");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.execute(); 
		  return  query.getResultList().get(0);
		  }finally {em.close();}}
	

//-----155
	
//-----156
	private SP_DDM_CUS_3_REGION_Result sp_SP_DDM_CUS_3_REGION_Result = new SP_DDM_CUS_3_REGION_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_REGION_Result> generateResultList_SP_DDM_CUS_3_REGION(Object[] objArray) {
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_CUS_3_REGION_Result.generateResultList_SP_DDM_CUS_3_REGION(query.getResultList());
	}finally {em.close();}}

//Object
	public SP_DDM_CUS_3_REGION_Result generateResultBean_SP_DDM_CUS_3_REGION(Object[] objArray) {
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_CUS_3_REGION_Result
				.generateResultBean_SP_DDM_CUS_3_REGION((Object[]) query.getResultList().get(0));
	}finally {em.close();}}

//--INSERT/UPDATE---157
	//public boolean executeProc(Object[] objArray) {
		public String generateResultBean_SP_DDM_CUS_3_TEMP_UPDATE(Object[] objArray){
	
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_TEMP_UPDATE");
		
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
		query.setParameter(1,(String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,(String) objArray[1]);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3,(String) objArray[2]);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4,(String) objArray[3]);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5,(String) objArray[4]);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6,(String) objArray[5]);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7,(String) objArray[6]);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8,(String) objArray[7]);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9,(String) objArray[8]);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10,(String) objArray[9]);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11,(String) objArray[10]);
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12,(String) objArray[11]);
		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query.setParameter(13,(String) objArray[12]);
		query.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);
		query.setParameter(14,(String) objArray[13]);
		query.registerStoredProcedureParameter(15, String.class, ParameterMode.IN);
		query.setParameter(15,(String) objArray[14]);
		query.registerStoredProcedureParameter(16, String.class, ParameterMode.IN);
		query.setParameter(16,(String) objArray[15]);
		query.registerStoredProcedureParameter(17, String.class, ParameterMode.IN);
		query.setParameter(17,(String) objArray[16]);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.setParameter(18,(String) objArray[17]);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.setParameter(19,(String) objArray[18]);
		query.registerStoredProcedureParameter(20, String.class, ParameterMode.IN);
		query.setParameter(20,(String) objArray[19]);
		query.registerStoredProcedureParameter(21, String.class, ParameterMode.IN);
		query.setParameter(21,(String) objArray[20]);
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.IN);
		query.setParameter(22,(String) objArray[21]);
		query.registerStoredProcedureParameter(23, String.class, ParameterMode.IN);
		query.setParameter(23,(String) objArray[22]);
		query.registerStoredProcedureParameter(24, String.class, ParameterMode.IN);
		query.setParameter(24,(String) objArray[23]);
		query.registerStoredProcedureParameter(25, String.class, ParameterMode.IN);
		query.setParameter(25,(String) objArray[24]);
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.IN);
		query.setParameter(26,(String) objArray[25]);
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.IN);
		if(objArray[26]!=null) {
		query.setParameter(27,(String) objArray[26]);}
		query.registerStoredProcedureParameter(28, String.class, ParameterMode.IN);
		if(objArray[27]!=null) {
		query.setParameter(28,(String) objArray[27]);}
		query.registerStoredProcedureParameter(29, String.class, ParameterMode.IN);
		if(objArray[28]!=null) {
		query.setParameter(29,(String) objArray[28]);}
		query.registerStoredProcedureParameter(30, String.class, ParameterMode.IN);   // for crr
		
		if(null!=objArray[29] && objArray[29]!=null) 
		  {
		  query.setParameter(30,(String)objArray[29] ); 
		  }
		
		query.registerStoredProcedureParameter(31, String.class, ParameterMode.IN);
		query.setParameter(31,(String) objArray[30]);
		
		 query.registerStoredProcedureParameter(32,String.class,ParameterMode.OUT);
		  query.execute(); 
		  String out = (String)query.getOutputParameterValue(32);
		  return out	;
		  //return query.execute();
	}finally {em.close();}}

//--INSERT/UPDATE---158
	//-----159
	private SP_DDM_CUS_3_ZONE_Result sp_SP_DDM_CUS_3_ZONE_Result = new SP_DDM_CUS_3_ZONE_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_3_ZONE_Result> generateResultList_SP_DDM_CUS_3_ZONE(Object[] objArray) {
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_CUS_3_ZONE_Result.generateResultList_SP_DDM_CUS_3_ZONE(query.getResultList());
	}finally {em.close();}}

//Object
	public SP_DDM_CUS_3_ZONE_Result generateResultBean_SP_DDM_CUS_3_ZONE(Object[] objArray) {
		 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_3_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_CUS_3_ZONE_Result
				.generateResultBean_SP_DDM_CUS_3_ZONE((Object[]) query.getResultList().get(0));
	}finally {em.close();}}
//-----160
	
	//Satish
	
		//-----138
			private SP_DDM_CUS_5_ALL_Result sp_SP_DDM_CUS_5_ALL_Result = new SP_DDM_CUS_5_ALL_Result();

			@SuppressWarnings("unchecked")

			public List<SP_DDM_CUS_5_ALL_Result> generateResultList_SP_DDM_CUS_5_ALL(Object[] objArray) {
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_ALL");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) objArray[0]);
				query.execute();
				return sp_SP_DDM_CUS_5_ALL_Result.generateResultList_SP_DDM_CUS_5_ALL(query.getResultList());
			}finally {em.close();}}

		//Object
			public SP_DDM_CUS_5_ALL_Result generateResultBean_SP_DDM_CUS_5_ALL(Object[] objArray) {
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_ALL");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) objArray[0]);
				query.execute();
				return sp_SP_DDM_CUS_5_ALL_Result.generateResultBean_SP_DDM_CUS_5_ALL((Object[]) query.getResultList().get(0));
			}finally {em.close();}}

		//-----148
			private SP_DDM_CUS_5_COMM_Result sp_SP_DDM_CUS_5_COMM_Result = new SP_DDM_CUS_5_COMM_Result();

			@SuppressWarnings("unchecked")

			public List<SP_DDM_CUS_5_COMM_Result> generateResultList_SP_DDM_CUS_5_COMM(Object[] objArray) {
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_COMM");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) objArray[0]);
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				query.setParameter(2, (String) objArray[1]);
				query.execute();
				return sp_SP_DDM_CUS_5_COMM_Result.generateResultList_SP_DDM_CUS_5_COMM(query.getResultList());
			}finally {em.close();}}

		//Object
			public SP_DDM_CUS_5_COMM_Result generateResultBean_SP_DDM_CUS_5_COMM(Object[] objArray) {
				System.out.println("in DDM_CUS_5 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_COMM");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) objArray[0]);
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				query.setParameter(2, (String) objArray[1]);
				query.execute();
				return sp_SP_DDM_CUS_5_COMM_Result.generateResultBean_SP_DDM_CUS_5_COMM((Object[]) query.getResultList().get(0));
			}finally {em.close();}}
			

		//-----
			private SP_DDM_CUS_5_COMM_TEMP_Result sp_SP_DDM_CUS_5_COMM_TEMP_Result = new SP_DDM_CUS_5_COMM_TEMP_Result();

			@SuppressWarnings("unchecked")

			public List<SP_DDM_CUS_5_COMM_TEMP_Result> generateResultList_SP_DDM_CUS_5_COMM_TEMP(Object[] objArray) {
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_COMM_TEMP");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) objArray[0]);
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				query.setParameter(2, (String) objArray[1]);
				query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
				query.setParameter(3, (String) objArray[2]);
				query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
				query.setParameter(4, (String) objArray[3]);
				query.execute();
				return sp_SP_DDM_CUS_5_COMM_TEMP_Result.generateResultList_SP_DDM_CUS_5_COMM_TEMP(query.getResultList());
			}finally {em.close();}}

		//Object
				 
			  private SP_DDM_CUS_5_COMM_TEMP_Result sp_DDM_CUS_5_COMM_TEMP_Result=new SP_DDM_CUS_5_COMM_TEMP_Result();
			  public SP_DDM_CUS_5_COMM_TEMP_Result generateResultBean_SP_DDM_CUS_5_COMM_TEMP(Object[] objArray,HttpServletRequest request){
				  System.out.println("objArray--> "+objArray[0]);
				  System.out.println("objArray--> "+objArray[1]);
				  System.out.println("objArray--> "+objArray[2]);
				  System.out.println("objArray--> "+objArray[3]);
				   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_5_COMM_TEMP");
				  
				  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
				  query.setParameter(1,(String)objArray[0] ); 
				  
				  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
				  if(null!=objArray[1] && objArray[1]!=null) 
				  {
				  query.setParameter(2,(String)objArray[1] ); 
				  }
				  //query.setParameter(2,(String)objArray[1] ); 
				  
				  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
				  if(null!=objArray[2] && objArray[2]!=null) 
				  {
				  query.setParameter(3,(String)objArray[2] ); 
				  }
				  
				  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
				  
				  query.execute(); 
				  String out = (String)query.getOutputParameterValue(4);
				  logger.info("--out--"+out);
				  request.getSession().setAttribute("_Result", out);
				  return sp_DDM_CUS_5_COMM_TEMP_Result.generateResultBeanSP_DDM_CUS_5_COMM_TEMP((Object[])query.getResultList().get(0));
				  /*if(query.getResultList().size() > 0) {
						return sp_DDM_CUS_5_COMM_TEMP_Result.generateResultBeanSP_DDM_CUS_5_COMM_TEMP((Object[]) query.getResultList().get(0));
					}
					else {
						return new SP_DDM_CUS_5_COMM_TEMP_Result();
					}
					*/
				   
				   }finally {em.close();}}
			  
			
			private SP_DDM_CUS_5_COMM_TEMP_REPORT_Result sp_SP_DDM_CUS_5_COMM_TEMP_REPORT_Result = new SP_DDM_CUS_5_COMM_TEMP_REPORT_Result();

			@SuppressWarnings("unchecked")

			public List<SP_DDM_CUS_5_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CUS_5_COMM_TEMP_REPORT(
					Object[] objArray) {
				System.out.println("objArray--> "+objArray[0]);
				  System.out.println("objArray--> "+objArray[1]);
				  System.out.println("objArray--> "+objArray[2]);
				  System.out.println("objArray--> "+objArray[3]);
				  System.out.println("objArray--> "+objArray[4]);
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_COMM_TEMP_REPORT");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) objArray[0]);
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				query.setParameter(2, (String) objArray[1]);
				query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
				query.setParameter(3, (String) objArray[2]);
				query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
				query.setParameter(4, (String) objArray[3]);
				query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
				query.setParameter(5, (String) objArray[4]);
				query.execute();
				return sp_SP_DDM_CUS_5_COMM_TEMP_REPORT_Result.generateResultList_SP_DDM_CUS_5_COMM_TEMP_REPORT(query.getResultList());
			}finally {em.close();}}

		//Object
			public SP_DDM_CUS_5_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CUS_5_COMM_TEMP_REPORT(Object[] objArray) {
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_COMM_TEMP_REPORT");
				System.out.println("objArray0--> "+objArray[0]);
				System.out.println("objArray1--> "+objArray[1]);
				System.out.println("objArray2--> "+objArray[2]);
				System.out.println("objArray3--> "+objArray[3]);
				System.out.println("objArray4--> "+objArray[4]);
				
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1,(String) objArray[0]);
				
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				if(null!=objArray[1] && objArray[1]!=null) 
				  {
				  query.setParameter(2,(String)objArray[1] ); 
				  }
				
				//query.setParameter(2,(String) objArray[1]);
				query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
				if(null!=objArray[2] && objArray[2]!=null) 
				  {
				  query.setParameter(3,(String)objArray[2] ); 
				  }		
				  query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
				  
				  if(null!=objArray[3] && objArray[3]!=null) 
				  {
				   query.setParameter(4,(String)objArray[3] ); 
				  }
				query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
				query.setParameter(5,(String) objArray[4]);
				query.execute();
				//return sp_SP_DDM_CUS_5_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CUS_5_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
			
				if(query.getResultList().size() > 0) {
					return sp_SP_DDM_CUS_5_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CUS_5_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
				}
				else {
					return new SP_DDM_CUS_5_COMM_TEMP_REPORT_Result();
				}
				 
				 }finally {em.close();}}

		//-----151
			//--INSERT/UPDATE---152
			//public boolean executeProc(Object[] objArray) {
			public String generateResultBeanSP_DDM_CUS_5_INSERT(Object[] objArray){	
			 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_INSERT");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) objArray[0]);
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				query.setParameter(2, (String) objArray[1]);
				query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
				query.setParameter(3, (String) objArray[2]);
				query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
				query.setParameter(4, (String) objArray[3]);
				query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
				query.setParameter(5, (String) objArray[4]);
				query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
				query.setParameter(6, (String) objArray[5]);
				query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
				query.setParameter(7, (String) objArray[6]);
				query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
				query.setParameter(8, (String) objArray[7]);
				query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
				query.setParameter(9, (String) objArray[8]);
				query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
				query.setParameter(10, (String) objArray[9]);
				
				 query.registerStoredProcedureParameter(11,String.class,ParameterMode.OUT);
				  query.execute(); 
				  String out = (String)query.getOutputParameterValue(11);
				  return out	;
				  //return query.execute();
				
				//return query.execute();
			}finally {em.close();}}

		//--INSERT/UPDATE---153

		//-----154
			private SP_DDM_CUS_5_MAX_DATE_Result sp_SP_DDM_CUS_5_MAX_DATE_Result = new SP_DDM_CUS_5_MAX_DATE_Result();

			@SuppressWarnings("unchecked")

			public List<SP_DDM_CUS_5_MAX_DATE_Result> generateResultList_SP_DDM_CUS_5_MAX_DATE(Object[] objArray) {
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_MAX_DATE");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) objArray[0]);
				query.execute();
				return sp_SP_DDM_CUS_5_MAX_DATE_Result.generateResultList_SP_DDM_CUS_5_MAX_DATE(query.getResultList());
			}finally {em.close();}}

		//Object
			/*
			 * public SP_DDM_CUS_5_MAX_DATE_Result
			 * generateResultBean_SP_DDM_CUS_5_MAX_DATE(Object[] objArray) {
			 *  try {StoredProcedureQuery query =
			 * em.createStoredProcedureQuery("SP_DDM_CUS_5_MAX_DATE");
			 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			 * query.setParameter(1, (String) objArray[0]); query.execute(); return
			 * sp_SP_DDM_CUS_5_MAX_DATE_Result.generateResultBean_SP_DDM_CUS_5_MAX_DATE((
			 * Object[]) query.getResultList().get(0)); }finally {em.close();}}
			 */
			
			public Object generateResultBean_SP_DDM_CUS_5_MAX_DATE(Object[] objArray){
				  System.out.println("objArray--> "+objArray[0]);
				   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_5_MAX_DATE");
				  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
				  query.setParameter(1,(String)objArray[0] ); 
				  query.execute(); 
				  return  query.getResultList().get(0);
				  }finally {em.close();}}
			
			public Object generateResultBean_SP_DDM_CUS_4_MAX_DATE(Object[] objArray){
				  System.out.println("objArray--> "+objArray[0]);
				   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_4_MAX_DATE");
				  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
				  query.setParameter(1,(String)objArray[0] ); 
				  query.execute(); 
				  return  query.getResultList().get(0);
				  }finally {em.close();}}
			
			

		//-----155
			private SP_DDM_CUS_5_MEMBER_REGION_Result sp_SP_DDM_CUS_5_MEMBER_REGION_Result = new SP_DDM_CUS_5_MEMBER_REGION_Result();


		//Object
			public SP_DDM_CUS_5_MEMBER_REGION_Result generateResultBean_SP_DDM_CUS_5_MEMBER_REGION(Object[] objArray) {
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_MEMBER_REGION");
				System.out.println("objArray[0]--> "+objArray[0]);
				System.out.println("objArray[1]--> "+objArray[1]);
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) objArray[0]);
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				query.setParameter(2, (String) objArray[1]);
				query.execute();
				return sp_SP_DDM_CUS_5_MEMBER_REGION_Result.generateResultBean_SP_DDM_CUS_5_MEMBER_REGION((Object[]) query.getResultList().get(0));
			}finally {em.close();}}

		//-----156
			private SP_DDM_CUS_5_REGION_Result sp_SP_DDM_CUS_5_REGION_Result = new SP_DDM_CUS_5_REGION_Result();

		//Object
			public SP_DDM_CUS_5_REGION_Result generateResultBean_SP_DDM_CUS_5_REGION(Object[] objArray) {
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_REGION");
				System.out.println("objArray[0]--> "+objArray[0]);
				System.out.println("objArray[1]--> "+objArray[1]);
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) objArray[0]);
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				query.setParameter(2, (String) objArray[1]);
				query.execute();
				return sp_SP_DDM_CUS_5_REGION_Result.generateResultBean_SP_DDM_CUS_5_REGION((Object[]) query.getResultList().get(0));
			}finally {em.close();}}

			
				public boolean generateResultBean_SP_DDM_CUS_5_TEMP_UPDATE(Object[] objArray){
			
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_TEMP_UPDATE");
				
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
				
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1,(String) objArray[0]);
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				query.setParameter(2,(String) objArray[1]);
				query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
				query.setParameter(3,(String) objArray[2]);
				query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
				query.setParameter(4,(String) objArray[3]);
				query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
				query.setParameter(5,(String) objArray[4]);
				query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
				query.setParameter(6,(String) objArray[5]);
				query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
				query.setParameter(7,(String) objArray[6]);
				query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
				query.setParameter(8,(String) objArray[7]);
				query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
				query.setParameter(9,(String) objArray[8]);
				query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);   // for crr
				if(null!=objArray[9] && objArray[9]!=null) 
				  {
				  query.setParameter(10,(String)objArray[9] ); 
				  }
				
				query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
				query.setParameter(11,(String) objArray[10]);
				
				// query.registerStoredProcedureParameter(12,String.class,ParameterMode.OUT);
				 // query.execute(); 
				 // String out = (String)query.getOutputParameterValue(12);
				 // return out	;
				  return query.execute();
			}finally {em.close();}}

		//--INSERT/UPDATE---158
			//-----159
			private SP_DDM_CUS_5_ZONE_Result sp_SP_DDM_CUS_5_ZONE_Result = new SP_DDM_CUS_5_ZONE_Result();

			
		//Object
			public SP_DDM_CUS_5_ZONE_Result generateResultBean_SP_DDM_CUS_5_ZONE(Object[] objArray) {
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_ZONE");
				System.out.println("objArray[0]--> "+objArray[0]);
				System.out.println("objArray[1]--> "+objArray[1]);
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1,(String) objArray[0]);
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				query.setParameter(2,(String) objArray[1]);
				query.execute();
				return sp_SP_DDM_CUS_5_ZONE_Result.generateResultBean_SP_DDM_CUS_5_ZONE((Object[]) query.getResultList().get(0));
			}finally {em.close();}}
			// Satish end
		
		
		
		//Vikas Start CUS_6
		
		public SP_DDM_CUS_6_ALL_Result generateResultBean_SP_DDM_CUS_6_ALL(Object[] objArray) {
			SP_DDM_CUS_6_ALL_Result sp_SP_DDM_CUS_6_ALL_Result = new SP_DDM_CUS_6_ALL_Result();
			 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_6_ALL");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String.valueOf(objArray[1])));
			query.execute();
			return sp_SP_DDM_CUS_6_ALL_Result.generateResultBean((Object[]) query.getResultList().get(0));
		}finally {em.close();}}

		
		public List<SP_DDM_CUS_6_ALL_Result> generateResultBeanList_SP_DDM_CUS_6_ALL(Object[] objArray) {
			try {
			SP_DDM_CUS_6_ALL_Result sp_SP_DDM_CUS_6_ALL_Result = new SP_DDM_CUS_6_ALL_Result();
			 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_6_ALL");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String.valueOf(objArray[1])));
			query.execute();
			return sp_SP_DDM_CUS_6_ALL_Result.generateResultList_SP_DDM_CUS_6_ALL(query.getResultList());
			}
			finally {
				em.close();
			}
		}
		
		
		public SP_DDM_CUS_6_ZONE_Result generateResultBean_SP_DDM_CUS_6_ZONE(Object[] objArray) {
			try {
			SP_DDM_CUS_6_ZONE_Result sp_SP_DDM_CUS_6_ZONE_Result = new SP_DDM_CUS_6_ZONE_Result();
			 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_6_ZONE");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, (String.valueOf(objArray[2])));
			query.execute();
			return sp_SP_DDM_CUS_6_ZONE_Result
					.generateResultBean_SP_DDM_CUS_6_ZONE((Object[]) query.getResultList().get(0));
			}
			finally {
				em.close();
			}
		}
		
		
		public List<SP_DDM_CUS_6_ZONE_Result> generateResultList_SP_DDM_CUS_6_ZONE(Object[] objArray) {
			try {
			SP_DDM_CUS_6_ZONE_Result sp_SP_DDM_CUS_6_ZONE_Result = new SP_DDM_CUS_6_ZONE_Result();
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_6_ZONE");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, (String.valueOf(objArray[2])));
			query.execute();
			return sp_SP_DDM_CUS_6_ZONE_Result.generateResultList_SP_DDM_CUS_6_ZONE(query.getResultList());
			}
			finally {
				em.close();
			}
		}
		
		
		
		@SuppressWarnings("unchecked")

		public List<SP_DDM_CUS_6_REGION_Result> generateResultList_SP_DDM_CUS_6_REGION(Object[] objArray) {
			try {
			SP_DDM_CUS_6_REGION_Result sp_SP_DDM_CUS_6_REGION_Result = new SP_DDM_CUS_6_REGION_Result();
			 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_6_REGION");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.execute();
			return sp_SP_DDM_CUS_6_REGION_Result.generateResultList_SP_DDM_CUS_6_REGION(query.getResultList());
			}
			finally {
				em.close();
			}
		}

	//Object
		public SP_DDM_CUS_6_REGION_Result generateResultBean_SP_DDM_CUS_6_REGION(Object[] objArray) {
			try {
			SP_DDM_CUS_6_REGION_Result sp_SP_DDM_CUS_6_REGION_Result = new SP_DDM_CUS_6_REGION_Result();
			 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_6_REGION");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.execute();
			return sp_SP_DDM_CUS_6_REGION_Result.generateResultBean((Object[]) query.getResultList().get(0));
			}
			finally {
				em.close();
			}
		}
		
		//List<SP_DGDDM_REPORT_VIEW_GSTN_COMMWISE_Result >
		public List<SP_DDM_CUS_6_COMM_Result> generateResultBean_SP_DDM_CUS_6_COMM(Object[] objArray) {
			try {
			SP_DDM_CUS_6_COMM_Result sp_SP_DDM_CUS_6_COMM_Result = new SP_DDM_CUS_6_COMM_Result();
			System.out.println("in DDM_CUS_6 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_6_COMM");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.execute();
			return sp_SP_DDM_CUS_6_COMM_Result.generateResultList_SP_DDM_CUS_6_COMM(query.getResultList());
			
			}
			finally {
				em.close();
			}
		}
		
		
		
		
		
		
		@SuppressWarnings("unchecked")

		public List<SP_DDM_CUS_6_COMM_TEMP_Result> generateResultList_SP_DDM_CUS_6_COMM_TEMP(Object[] objArray) {
			try {
			SP_DDM_CUS_6_COMM_TEMP_Result sp_SP_DDM_CUS_6_COMM_TEMP_Result = new SP_DDM_CUS_6_COMM_TEMP_Result();
			 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_6_COMM_TEMP");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, (String) objArray[2]);
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			query.setParameter(4, (String) objArray[3]);
			query.execute();
			return sp_SP_DDM_CUS_6_COMM_TEMP_Result.generateResultList_SP_DDM_CUS_6_COMM_TEMP(query.getResultList());
			}
			finally {
				em.close();
			}
		}


		 
		  public SP_DDM_CUS_6_COMM_TEMP_Result generateResultBean_SP_DDM_CUS_6_COMM_TEMP(Object[] objArray,HttpServletRequest request){
			  try {
			  SP_DDM_CUS_6_COMM_TEMP_Result sp_DDM_CUS_6_COMM_TEMP_Result= new SP_DDM_CUS_6_COMM_TEMP_Result();
			  System.out.println("objArray--> "+objArray[0]);
			  System.out.println("objArray--> "+objArray[1]);
			  System.out.println("objArray--> "+objArray[2]);
			  System.out.println("objArray--> "+objArray[3]);
			  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_6_COMM_TEMP");
			  
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,(String)objArray[0] ); 
			  
			  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
			  query.setParameter(2,(String)objArray[1] ); 
			  
			  query.registerStoredProcedureParameter(3,String.class,ParameterMode.OUT);
			  
			  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
			  if(null!=objArray[3] && objArray[3]!=null) 
			  {
			  query.setParameter(4,(String)objArray[3] ); 
			  }
			  query.execute(); 
			  String out = (String)query.getOutputParameterValue(3);
			  logger.info("--out--"+out);
			  request.getSession().setAttribute("_Result", out);
			  return sp_DDM_CUS_6_COMM_TEMP_Result.generateResultBean((Object[])query.getResultList().get(0));
			  }
				finally {
					em.close();
				}
		 }
		
		
		public Object generateResultBean_SP_DDM_CUS_6_MAX_DATE(Object[] objArray){
			try {
			  System.out.println("objArray--> "+objArray[0]);
			  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_6_MAX_DATE");
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,(String)objArray[0] ); 
			  query.execute(); 
			  return  query.getResultList().get(0);
			}
			finally {
				em.close();
			}
			  }
		
		
		@SuppressWarnings("unchecked")

		public List<SP_DDM_CUS_6_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CUS_6_COMM_TEMP_REPORT(Object[] objArray) {
			try {
			SP_DDM_CUS_6_COMM_TEMP_REPORT_Result sp_SP_DDM_CUS_6_COMM_TEMP_REPORT_Result = new SP_DDM_CUS_6_COMM_TEMP_REPORT_Result();
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_6_COMM_TEMP_REPORT");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, (String) objArray[2]);
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			query.setParameter(4, (String) objArray[3]);
			query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			query.setParameter(5, (String) objArray[4]);
			query.execute();
			return sp_SP_DDM_CUS_6_COMM_TEMP_REPORT_Result.generateResultList_SP_DDM_CUS_6_COMM_TEMP_REPORT(query.getResultList());
			}
			finally {
				em.close();
			}
		}
		
		public SP_DDM_CUS_6_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CUS_6_COMM_TEMP_REPORT(Object[] objArray) {
			try {
			SP_DDM_CUS_6_COMM_TEMP_REPORT_Result sp_SP_DDM_CUS_6_COMM_TEMP_REPORT_Result= new SP_DDM_CUS_6_COMM_TEMP_REPORT_Result();
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_6_COMM_TEMP_REPORT");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, (String) objArray[2]);
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			query.setParameter(4, (String) objArray[3]);
			query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			query.setParameter(5, (String) objArray[4]);
			query.execute();
			return sp_SP_DDM_CUS_6_COMM_TEMP_REPORT_Result
					.generateResultBean((Object[]) query.getResultList().get(0));
			}
			finally {
				em.close();
			}
		}
		
		//Vikas End CUS_6
		
		
		//Vikas Start CE_6
		
		public SP_DDM_CE_6_ALL_Result generateResultBean_SP_DDM_CE_6_ALL(Object[] objArray) {
			SP_DDM_CE_6_ALL_Result sp_SP_DDM_CE_6_ALL_Result = new SP_DDM_CE_6_ALL_Result();
			 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_6_ALL");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String.valueOf(objArray[1])));
			query.execute();
			return sp_SP_DDM_CE_6_ALL_Result.generateResultBean((Object[]) query.getResultList().get(0));
		}finally {em.close();}}

		
		public List<SP_DDM_CE_6_ALL_Result> generateResultBeanList_SP_DDM_CE_6_ALL(Object[] objArray) {
			try {
			SP_DDM_CE_6_ALL_Result sp_SP_DDM_CE_6_ALL_Result = new SP_DDM_CE_6_ALL_Result();
			 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_6_ALL");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String.valueOf(objArray[1])));
			query.execute();
			return sp_SP_DDM_CE_6_ALL_Result.generateResultList_SP_DDM_CE_6_ALL(query.getResultList());
			}
			finally {
				em.close();
			}
		}
		
		
		public List<SP_DDM_CE_6_ZONE_Result> generateResultList_SP_DDM_CE_6_ZONE(Object[] objArray) {
			try {
			SP_DDM_CE_6_ZONE_Result sp_SP_DDM_CE_6_ZONE_Result = new SP_DDM_CE_6_ZONE_Result();
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_6_ZONE");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, (String.valueOf(objArray[2])));
			query.execute();
			return sp_SP_DDM_CE_6_ZONE_Result.generateResultList_SP_DDM_CE_6_ZONE(query.getResultList());
			}
			finally {
				em.close();
			}
		}
		
		@SuppressWarnings("unchecked")

		public List<SP_DDM_CE_6_REGION_Result> generateResultList_SP_DDM_CE_6_REGION(Object[] objArray) {
			try {
			SP_DDM_CE_6_REGION_Result sp_SP_DDM_CE_6_REGION_Result = new SP_DDM_CE_6_REGION_Result();
			 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_6_REGION");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.execute();
			return sp_SP_DDM_CE_6_REGION_Result.generateResultList_SP_DDM_CE_6_REGION(query.getResultList());
			}
			finally {
				em.close();
			}
		}
		
		
		public List<SP_DDM_CE_6_COMM_Result> generateResultBean_SP_DDM_CE_6_COMM(Object[] objArray) {
			try {
			SP_DDM_CE_6_COMM_Result sp_SP_DDM_CE_6_COMM_Result = new SP_DDM_CE_6_COMM_Result();
			System.out.println("in DDM_CE_6 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_6_COMM");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.execute();
			return sp_SP_DDM_CE_6_COMM_Result.generateResultList_SP_DDM_CE_6_COMM(query.getResultList());
			
			}
			finally {
				em.close();
			}
		}
		
		
		public Object generateResultBean_SP_DDM_CE_6_MAX_DATE(Object[] objArray){
			try {
			  System.out.println("objArray--> "+objArray[0]);
			  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CE_6_MAX_DATE");
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,(String)objArray[0] ); 
			  query.execute(); 
			  return  query.getResultList().get(0);
			}
			finally {
				em.close();
			}
			  }
		
		
		
		@SuppressWarnings("unchecked")
		public List<SP_DDM_CE_6_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CE_6_COMM_TEMP_REPORT(Object[] objArray) {
			try {
			SP_DDM_CE_6_COMM_TEMP_REPORT_Result sp_SP_DDM_CE_6_COMM_TEMP_REPORT_Result = new SP_DDM_CE_6_COMM_TEMP_REPORT_Result();
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_6_COMM_TEMP_REPORT");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, (String) objArray[2]);
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			query.setParameter(4, (String) objArray[3]);
			query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			query.setParameter(5, (String) objArray[4]);
			query.execute();
			return sp_SP_DDM_CE_6_COMM_TEMP_REPORT_Result.generateResultList_SP_DDM_CE_6_COMM_TEMP_REPORT(query.getResultList());
			}
			finally {
				em.close();
			}
		}
		
		
		
		public SP_DDM_CE_6_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CE_6_COMM_TEMP_REPORT(Object[] objArray) {
			try {
			SP_DDM_CE_6_COMM_TEMP_REPORT_Result sp_SP_DDM_CE_6_COMM_TEMP_REPORT_Result= new SP_DDM_CE_6_COMM_TEMP_REPORT_Result();
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_6_COMM_TEMP_REPORT");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, (String) objArray[0]);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.setParameter(2, (String) objArray[1]);
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			query.setParameter(3, (String) objArray[2]);
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			query.setParameter(4, (String) objArray[3]);
			query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			query.setParameter(5, (String) objArray[4]);
			query.execute();
			return sp_SP_DDM_CE_6_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CE_6_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
			}
			finally {
				em.close();
			}
		}
		//Vikas End CE_6
		
		
		
		
		
		
		//Vikas Start ST_6
		
				public SP_DDM_ST_6_ALL_Result generateResultBean_SP_DDM_ST_6_ALL(Object[] objArray) {
					SP_DDM_ST_6_ALL_Result sp_SP_DDM_ST_6_ALL_Result = new SP_DDM_ST_6_ALL_Result();
					 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_6_ALL");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					query.setParameter(1, (String) objArray[0]);
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					query.setParameter(2, (String.valueOf(objArray[1])));
					query.execute();
					return sp_SP_DDM_ST_6_ALL_Result.generateResultBean((Object[]) query.getResultList().get(0));
				}finally {em.close();}}

				
				public List<SP_DDM_ST_6_ALL_Result> generateResultBeanList_SP_DDM_ST_6_ALL(Object[] objArray) {
					try {
					SP_DDM_ST_6_ALL_Result sp_SP_DDM_ST_6_ALL_Result = new SP_DDM_ST_6_ALL_Result();
					 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_6_ALL");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					query.setParameter(1, (String) objArray[0]);					
					query.execute();
					return sp_SP_DDM_ST_6_ALL_Result.generateResultList_SP_DDM_ST_6_ALL(query.getResultList());
					}
					finally {
						em.close();
					}
				}
				
				
				public List<SP_DDM_ST_6_ZONE_Result> generateResultList_SP_DDM_ST_6_ZONE(Object[] objArray) {
					try {
					SP_DDM_ST_6_ZONE_Result sp_SP_DDM_ST_6_ZONE_Result = new SP_DDM_ST_6_ZONE_Result();
					StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_6_ZONE");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					query.setParameter(1,(String) objArray[0]);
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					query.setParameter(2, (String) objArray[1]);
					
					query.execute();
					return sp_SP_DDM_ST_6_ZONE_Result.generateResultList_SP_DDM_ST_6_ZONE(query.getResultList());
					}
					finally {
						em.close();
					}
				}
				
				@SuppressWarnings("unchecked")

				public List<SP_DDM_ST_6_REGION_Result> generateResultList_SP_DDM_ST_6_REGION(Object[] objArray) {
					try {
					SP_DDM_ST_6_REGION_Result sp_SP_DDM_ST_6_REGION_Result = new SP_DDM_ST_6_REGION_Result();
					 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_6_REGION");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					query.setParameter(1, (String) objArray[0]);
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					query.setParameter(2, (String) objArray[1]);
					query.execute();
					return sp_SP_DDM_ST_6_REGION_Result.generateResultList_SP_DDM_ST_6_REGION(query.getResultList());
					}
					finally {
						em.close();
					}
				}
				
				
				public List<SP_DDM_ST_6_COMM_Result> generateResultBean_SP_DDM_ST_6_COMM(Object[] objArray) {
					try {
					SP_DDM_ST_6_COMM_Result sp_SP_DDM_ST_6_COMM_Result = new SP_DDM_ST_6_COMM_Result();
					System.out.println("in DDM_ST_6 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
					StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_6_COMM");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					query.setParameter(1, (String) objArray[0]);
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					query.setParameter(2, (String) objArray[1]);
					query.execute();
					return sp_SP_DDM_ST_6_COMM_Result.generateResultList_SP_DDM_ST_6_COMM(query.getResultList());
					
					}
					finally {
						em.close();
					}
				}
				
				
				public Object generateResultBean_SP_DDM_ST_6_MAX_DATE(Object[] objArray){
					try {
					  System.out.println("objArray--> "+objArray[0]);
					  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_6_MAX_DATE");
					  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
					  query.setParameter(1,(String)objArray[0] ); 
					  query.execute(); 
					  return  query.getResultList().get(0);
					}
					finally {
						em.close();
					}
					  }
				
				
				
				@SuppressWarnings("unchecked")
				public List<SP_DDM_ST_6_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_ST_6_COMM_TEMP_REPORT(Object[] objArray) {
					try {
					SP_DDM_ST_6_COMM_TEMP_REPORT_Result sp_SP_DDM_ST_6_COMM_TEMP_REPORT_Result = new SP_DDM_ST_6_COMM_TEMP_REPORT_Result();
					StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_6_COMM_TEMP_REPORT");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					query.setParameter(1, (String) objArray[0]);
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					query.setParameter(2, (String) objArray[1]);
					query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
					query.setParameter(3, (String) objArray[2]);
					query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
					query.setParameter(4, (String) objArray[3]);
					query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
					query.setParameter(5, (String) objArray[4]);
					query.execute();
					return sp_SP_DDM_ST_6_COMM_TEMP_REPORT_Result.generateResultList_SP_DDM_ST_6_COMM_TEMP_REPORT(query.getResultList());
					}
					finally {
						em.close();
					}
				}
				
				
				
				public SP_DDM_ST_6_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_ST_6_COMM_TEMP_REPORT(Object[] objArray) {
					try {
					SP_DDM_ST_6_COMM_TEMP_REPORT_Result sp_SP_DDM_ST_6_COMM_TEMP_REPORT_Result= new SP_DDM_ST_6_COMM_TEMP_REPORT_Result();
					StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_6_COMM_TEMP_REPORT");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					query.setParameter(1, (String) objArray[0]);
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					query.setParameter(2, (String) objArray[1]);
					query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
					query.setParameter(3, (String) objArray[2]);
					query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
					query.setParameter(4, (String) objArray[3]);
					query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
					query.setParameter(5, (String) objArray[4]);
					query.execute();
					return sp_SP_DDM_ST_6_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_ST_6_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
					}
					finally {
						em.close();
					}
				}
				//Vikas End ST_6

		
		
		
		
		
		
		
		
		
		
		
		
		//Vikas GSt 5 Start
		
		
			public Object generateResultBean_SP_DDM_GST_5_MAX_DATE(Object[] objArray){
				try {
				  System.out.println("objArray--> "+objArray[0]);
				   StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_5_MAX_DATE");
				  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
				  query.setParameter(1,(String)objArray[0] ); 
				  query.execute(); 
				  return  query.getResultList().get(0);
				}
				finally {
					em.close();
				}
				  }
			
			public SP_DDM_GST_5_COMM_TEMP_Result generateResultBean_SP_DDM_GST_5_COMM_TEMP1(Object[] objArray,HttpServletRequest request){
				  try {
				  SP_DDM_GST_5_COMM_TEMP_Result sp_DDM_GST_5_COMM_TEMP_Result= new SP_DDM_GST_5_COMM_TEMP_Result();
				  System.out.println("objArray--> "+objArray[0]);
				  System.out.println("objArray--> "+objArray[1]);
				  System.out.println("objArray--> "+objArray[2]);
				 // System.out.println("objArray--> "+objArray[3]);
				  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_5_COMM_TEMP");
				  
				  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
				  if(null!=objArray[0] && objArray[0]!=null) {
				  query.setParameter(1,(String)objArray[0] ); 
				  }
				  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
				  if(null!=objArray[1] && objArray[1]!=null) {
				  query.setParameter(2,(String)objArray[1] ); 
				  }
				  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
				  if(null!=objArray[2] && objArray[2]!=null) {
				  query.setParameter(3,(String)objArray[2] ); 
				  }
				  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
				  
				  query.execute(); 
				  String out = (String)query.getOutputParameterValue(4);
				  logger.info("--out--"+out);
				  request.getSession().setAttribute("_Result", out);
				  return sp_DDM_GST_5_COMM_TEMP_Result.generateResultBean((Object[])query.getResultList().get(0));
				  }
					finally {
						em.close();
					}
			 }
			
			
			
			
			public  SP_DDM_GST_5_COMM_TEMP_Result generateResultBean_SP_DDM_GST_5_COMM_TEMP(Object[] objArray,HttpServletRequest request){
				  SP_DDM_GST_5_COMM_TEMP_Result sP_DDM_GST_5_COMM_TEMP_Result = new SP_DDM_GST_5_COMM_TEMP_Result();
				  System.out.println("SP_DDM_GST_5_COMM_TEMP objArray0--> "+objArray[0]);
				  System.out.println("SP_DDM_GST_5_COMM_TEMP objArray1--> "+objArray[1]);
				  System.out.println("SP_DDM_GST_5_COMM_TEMP objArray2--date> "+objArray[2]);
				   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_5_COMM_TEMP");
				  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
				  if(objArray[0]!=null) {
				  query.setParameter(1,(String)objArray[0] ); }
				  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
				  if(null!=objArray[1] && objArray[1]!=null) {
				  query.setParameter(2,(String)objArray[1] ); }
				  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
				  if(null!=objArray[2] && objArray[2]!=null) {
				  query.setParameter(3,(String)objArray[2] ); }
				  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
				  query.execute(); 
				  String out = (String)query.getOutputParameterValue(4);
				  logger.info("--out--"+out);
				  request.getSession().setAttribute("_ResultSP_DDM_GST_5_COMM_TEMP", out);
				  
				  return sP_DDM_GST_5_COMM_TEMP_Result.generateResultBean((Object[])query.getResultList().get(0));
				 // return out;
			 }finally {em.close();}}
			
			
			
			public boolean generateResultBean_SP_DDM_GST_5_TEMP_UPDATE(Object[] objArray){
				
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_5_TEMP_UPDATE");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				if(objArray[0]!=null) {
				query.setParameter(1, (String) objArray[0]);}
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				if(objArray[1]!=null) {
				query.setParameter(2, (String) objArray[1]);}
				query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
				if(objArray[2]!=null) {
				query.setParameter(3, (String) objArray[2]);}
				query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
				if(objArray[3]!=null) {
				query.setParameter(4, (String) objArray[3]);}
				query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
				if(objArray[4]!=null) {
				query.setParameter(5, (String) objArray[4]);}
				query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
				if(objArray[5]!=null) {
				query.setParameter(6, (String) objArray[5]);}
				query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
				if(objArray[6]!=null) {
				query.setParameter(7, (String) objArray[6]);}
				query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
				if(objArray[7]!=null) {
				query.setParameter(8, (String) objArray[7]);}
				query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
				if(objArray[8]!=null) {
				query.setParameter(9, (String) objArray[8]);}
				query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
				if(objArray[9]!=null) {
				query.setParameter(10, (String) objArray[9]);}
				query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
				if(objArray[10]!=null) {
				query.setParameter(11, (String) objArray[10]);}
				
				query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
				if(objArray[11]!=null) {
				query.setParameter(12, (String) objArray[11]);}
				query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
				if(objArray[12]!=null) {
				query.setParameter(13, (String) objArray[12]);}
				//query.registerStoredProcedureParameter(14,String.class,ParameterMode.OUT);
				return query.execute(); 
				//String out = (String)query.getOutputParameterValue(14);
				//System.out.println("out---"+out);
				//return out	;
				  //return query.execute();
			}finally {em.close();}}
			
			public boolean generateResultBeanSP_DDM_GST_5_INSERT(Object[] objArray){	
				 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_5_INSERT");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					if(objArray[0]!=null){
					query.setParameter(1, (String) objArray[0]);}
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					if(objArray[1]!=null){
					query.setParameter(2, (String) objArray[1]);}
					query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
					if(objArray[2]!=null){
					query.setParameter(3, (String) objArray[2]);}
					query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
					if(objArray[3]!=null){
					query.setParameter(4, (String) objArray[3]);}
					query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
					if(objArray[4]!=null){
					query.setParameter(5, (String) objArray[4]);}
					query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
					if(objArray[5]!=null){
					query.setParameter(6, (String) objArray[5]);}
					query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
					if(objArray[6]!=null){
					query.setParameter(7, (String) objArray[6]);}
					query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
					if(objArray[7]!=null){
					query.setParameter(8, (String) objArray[7]);}
					query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
					if(objArray[8]!=null){
					query.setParameter(9, (String) objArray[8]);}
					query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
					if(objArray[9]!=null){
					query.setParameter(10, (String) objArray[9]);}
					
					query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
					if(objArray[10]!=null){
					query.setParameter(11, (String) objArray[10]);}
					query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
					if(objArray[11]!=null){
					query.setParameter(12, (String) objArray[11]);}
					
					// query.registerStoredProcedureParameter(13,String.class,ParameterMode.OUT);
					  //query.execute(); 
					 // String out = (String)query.getOutputParameterValue(13);
					 // System.out.println("out---"+out);
					  //return out	;
					 return query.execute();
					
					//return query.execute();
				}finally {em.close();}}
		
		
			//START GST
			
			private SP_DDM_GST_5_REGION_Result sp_SP_DDM_GST_5_REGION_Result = new SP_DDM_GST_5_REGION_Result();
			private SP_DDM_GST_5_ALL_Result sp_SP_DDM_GST_5_ALL_Result = new SP_DDM_GST_5_ALL_Result();

				public SP_DDM_GST_5_REGION_Result generateResultBean_SP_DDM_GST_5_REGION(Object[] objArray) {
					 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_5_REGION");
					System.out.println("objArray[0]--> "+objArray[0]);
					System.out.println("objArray[1]--> "+objArray[1]);
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					query.setParameter(1, (String) objArray[0]);
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					query.setParameter(2, (String) objArray[1]);
					query.execute();
					return sp_SP_DDM_GST_5_REGION_Result.generateResultBean_SP_DDM_GST_5_REGION((Object[]) query.getResultList().get(0));
				}finally {em.close();}}
			
				public SP_DDM_GST_5_ALL_Result generateResultBean_SP_DDM_GST_5_ALL(Object[] objArray) {
					 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_5_ALL");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					query.setParameter(1, (String) objArray[0]);
					query.execute();
					if(query.getResultList().size()!=0)
					return sp_SP_DDM_GST_5_ALL_Result.generateResultBean_SP_DDM_GST_5_ALL((Object[]) query.getResultList().get(0));
					else
						return null;
				}finally {em.close();}}
				
				private SP_DDM_GST_5_ZONE_Result sp_SP_DDM_GST_5_ZONE_Result = new SP_DDM_GST_5_ZONE_Result();

					public SP_DDM_GST_5_ZONE_Result generateResultBean_SP_DDM_GST_5_ZONE(Object[] objArray) {
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_5_ZONE");
						System.out.println("objArray[0]--> "+objArray[0]);
						System.out.println("objArray[1]--> "+objArray[1]);
						query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
						query.setParameter(1,(String) objArray[0]);
						query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
						query.setParameter(2,(String) objArray[1]);
						query.execute();
						if(query.getResultList().size()!=0)
						return sp_SP_DDM_GST_5_ZONE_Result.generateResultBean_SP_DDM_GST_5_ZONE((Object[]) query.getResultList().get(0));
						else
							return null;
					}finally {em.close();}}
					
					
					private SP_DDM_GST_5_COMM_TEMP_REPORT_Result sp_SP_DDM_GST_5_COMM_TEMP_REPORT_Result = new SP_DDM_GST_5_COMM_TEMP_REPORT_Result();
					public SP_DDM_GST_5_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_GST_5_COMM_TEMP_REPORT(Object[] objArray) {
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_5_COMM_TEMP_REPORT");
						System.out.println("objArray0--> "+objArray[0]);
						System.out.println("objArray1--> "+objArray[1]);
						System.out.println("objArray2--> "+objArray[2]);
						System.out.println("objArray3--> "+objArray[3]);
						System.out.println("objArray4--> "+objArray[4]);
						
						query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
						query.setParameter(1,(String) objArray[0]);
						
						query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
						if(null!=objArray[1] && objArray[1]!=null) 
						  {
						  query.setParameter(2,(String)objArray[1] ); 
						  }
						
						//query.setParameter(2,(String) objArray[1]);
						query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
						if(null!=objArray[2] && objArray[2]!=null) 
						  {
						  query.setParameter(3,(String)objArray[2] ); 
						  }		
						  query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
						  
						  if(null!=objArray[3] && objArray[3]!=null) 
						  {
						   query.setParameter(4,(String)objArray[3] ); 
						  }
						query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
						query.setParameter(5,(String) objArray[4]);
						query.execute();
						return sp_SP_DDM_GST_5_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_GST_5_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
					}finally {em.close();}}
					
					private SP_DDM_GST_5_COMM_Result sp_SP_DDM_GST_5_COMM_Result = new SP_DDM_GST_5_COMM_Result();
					public SP_DDM_GST_5_COMM_Result generateResultBean_SP_DDM_GST_5_COMM(Object[] objArray) {
						System.out.println("in DDM_CUS_5 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_5_COMM");
						query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
						query.setParameter(1, (String) objArray[0]);
						query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
						query.setParameter(2, (String) objArray[1]);
						query.execute();
						if(query.getResultList().size()!=0)
							return sp_SP_DDM_GST_5_COMM_Result.generateResultBean_SP_DDM_GST_5_COMM((Object[]) query.getResultList().get(0));
						else 
							return null;
					}finally {em.close();}}	

					private SP_DDM_GST_4_REGION_Result sp_SP_DDM_GST_4_REGION_Result = new SP_DDM_GST_4_REGION_Result();
					private SP_DDM_GST_4_ALL_Result sp_SP_DDM_GST_4_ALL_Result = new SP_DDM_GST_4_ALL_Result();
						
						public List<SP_DDM_GST_4_REGION_Result> generateResultBeanList_SP_DDM_GST_4_REGION(Object[] objArray) {
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_REGION");
							System.out.println("objArray[0]--> "+objArray[0]);
							System.out.println("objArray[1]--> "+objArray[1]);
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1, (String) objArray[0]);
							query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
							query.setParameter(2, (String) objArray[1]);
							query.execute();
							return sp_SP_DDM_GST_4_REGION_Result.SP_DDM_GST_4_REGION_Result( query.getResultList());
						}finally {em.close();}}
					
						public SP_DDM_GST_4_REGION_Result generateResultBean_SP_DDM_GST_4_REGION(Object[] objArray) {
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_REGION");
							System.out.println("objArray[0]--> "+objArray[0]);
							System.out.println("objArray[1]--> "+objArray[1]);
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1, (String) objArray[0]);
							query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
							query.setParameter(2, (String) objArray[1]);
							query.execute();
							return sp_SP_DDM_GST_4_REGION_Result.generateResultBean_SP_DDM_GST_4_REGION((Object[]) query.getResultList().get(0));
						}finally {em.close();}}
						
						public List<SP_DDM_GST_4_ALL_Result> generateResultBeanList_SP_DDM_GST_4_ALL(Object[] objArray) {
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_ALL");
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1, (String) objArray[0]);
							query.execute();
							return sp_SP_DDM_GST_4_ALL_Result.SP_DDM_GST_4_ALL_Result(query.getResultList());
						}finally {em.close();}}
						
						public SP_DDM_GST_4_ALL_Result generateResultBean_SP_DDM_GST_4_ALL(Object[] objArray) {
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_ALL");
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1, (String) objArray[0]);
							query.execute();
							return sp_SP_DDM_GST_4_ALL_Result.generateResultBean_SP_DDM_GST_4_ALL((Object[]) query.getResultList().get(0));
						}finally {em.close();}}
						
						private SP_DDM_GST_4_ZONE_Result sp_SP_DDM_GST_4_ZONE_Result = new SP_DDM_GST_4_ZONE_Result();

						public List<SP_DDM_GST_4_ZONE_Result> generateResultBeanList_SP_DDM_GST_4_ZONE(Object[] objArray) {
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_ZONE");
							System.out.println("objArray[0]--> "+objArray[0]);
							System.out.println("objArray[1]--> "+objArray[1]);
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1,(String) objArray[0]);
							query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
							query.setParameter(2,(String) objArray[1]);
							query.execute();
							return sp_SP_DDM_GST_4_ZONE_Result.SP_DDM_GST_4_ZONE_Result(query.getResultList());
						}finally {em.close();}}
						
						public SP_DDM_GST_4_ZONE_Result generateResultBean_SP_DDM_GST_4_ZONE(Object[] objArray) {
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_ZONE");
							System.out.println("objArray[0]--> "+objArray[0]);
							System.out.println("objArray[1]--> "+objArray[1]);
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1,(String) objArray[0]);
							query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
							query.setParameter(2,(String) objArray[1]);
							query.execute();
							return sp_SP_DDM_GST_4_ZONE_Result.generateResultBean_SP_DDM_GST_4_ZONE((Object[]) query.getResultList().get(0));
						}finally {em.close();}}


						public SP_DDM_GST_4_COMM_TEMP_Result generateResultBean_SP_DDM_GST_4_COMM_TEMP1(Object[] objArray,HttpServletRequest request){
							  try {
							  SP_DDM_GST_4_COMM_TEMP_Result sp_DDM_GST_4_COMM_TEMP_Result= new SP_DDM_GST_4_COMM_TEMP_Result();
							  System.out.println("objArray--> "+objArray[0]);
							  System.out.println("objArray--> "+objArray[1]);
							  System.out.println("objArray--> "+objArray[2]);
							 // System.out.println("objArray--> "+objArray[3]);
						     StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP");
							  
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  if(null!=objArray[0] && objArray[0]!=null) {
							  query.setParameter(1,(String)objArray[0] ); 
							  }
							  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
							  if(null!=objArray[1] && objArray[1]!=null) {
							  query.setParameter(2,(String)objArray[1] ); 
							  }
							  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
							  if(null!=objArray[2] && objArray[2]!=null) {
							  query.setParameter(3,(String)objArray[2] ); 
							  }
							  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
							  
							  query.execute(); 
							  String out = (String)query.getOutputParameterValue(4);
							  logger.info("--out--"+out);
							  request.getSession().setAttribute("_Result", out);
							  return sp_DDM_GST_4_COMM_TEMP_Result.generateResultBean_SP_DDM_GST_4_COMM_TEMP((Object[])query.getResultList().get(0));
							  }
								finally {
									em.close();
								}
						 }
						
						private SP_DDM_GST_4_COMM_Result sp_SP_DDM_GST_4_COMM_Result = new SP_DDM_GST_4_COMM_Result();
						
						
						
						
						
						
						
						public List<SP_DDM_GST_4_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DDM_GST_4_COMM_TEMP_REPORT(Object[] objArray) {
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP_REPORT");
							System.out.println("objArray0--> "+objArray[0]);
							System.out.println("objArray1--> "+objArray[1]);
							System.out.println("objArray2--> "+objArray[2]);
							System.out.println("objArray3--> "+objArray[3]);
							System.out.println("objArray4--> "+objArray[4]);
							
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1,(String) objArray[0]);
							
							query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
							if(null!=objArray[1] && objArray[1]!=null) 
							  {
							  query.setParameter(2,(String)objArray[1] ); 
							  }
							
							//query.setParameter(2,(String) objArray[1]);
							query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
							if(null!=objArray[2] && objArray[2]!=null) 
							  {
							  query.setParameter(3,(String)objArray[2] ); 
							  }		
							  query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
							  
							  if(null!=objArray[3] && objArray[3]!=null) 
							  {
							   query.setParameter(4,(String)objArray[3] ); 
							  }
							query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
							query.setParameter(5,(String) objArray[4]);
							query.execute();
							return sp_SP_DDM_GST_4_COMM_TEMP_REPORT_Result.SP_DDM_GST_4_COMM_TEMP_REPORT_Result(query.getResultList());
						}finally {em.close();}}
						
						
						private SP_DDM_GST_4_COMM_TEMP_REPORT_Result sp_SP_DDM_GST_4_COMM_TEMP_REPORT_Result = new SP_DDM_GST_4_COMM_TEMP_REPORT_Result();
						public SP_DDM_GST_4_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_GST_4_COMM_TEMP_REPORT(Object[] objArray) {
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP_REPORT");
							System.out.println("objArray0--> "+objArray[0]);
							System.out.println("objArray1--> "+objArray[1]);
							System.out.println("objArray2--> "+objArray[2]);
							System.out.println("objArray3--> "+objArray[3]);
							System.out.println("objArray4--> "+objArray[4]);
							
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1,(String) objArray[0]);
							
							query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
							if(null!=objArray[1] && objArray[1]!=null) 
							  {
							  query.setParameter(2,(String)objArray[1] ); 
							  }
							
							//query.setParameter(2,(String) objArray[1]);
							query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
							if(null!=objArray[2] && objArray[2]!=null) 
							  {
							  query.setParameter(3,(String)objArray[2] ); 
							  }		
							  query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
							  
							  if(null!=objArray[3] && objArray[3]!=null) 
							  {
							   query.setParameter(4,(String)objArray[3] ); 
							  }
							query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
							query.setParameter(5,(String) objArray[4]);
							query.execute();
							return sp_SP_DDM_GST_4_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_GST_4_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
						}finally {em.close();}}
						
						
						
						public List<SP_DDM_GST_4_COMM_Result> generateResultBeanList_SP_DDM_GST_4_COMM(Object[] objArray) {
							System.out.println("in DDM_CUS_4 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_COMM");
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1, (String) objArray[0]);
							query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
							query.setParameter(2, (String) objArray[1]);
							query.execute();
							return sp_SP_DDM_GST_4_COMM_Result.SP_DDM_GST_4_COMM_Result(query.getResultList());
						}finally {em.close();}}
						
						
						
						
						
						
						//Ujjwal
						private SP_DDM_CUS_2_MAX_DATE_Result sp_SP_DDM_CUS_2_MAX_DATE_Result = new SP_DDM_CUS_2_MAX_DATE_Result();

						@SuppressWarnings("unchecked")

						public List<SP_DDM_CUS_2_MAX_DATE_Result> generateResultList_SP_DDM_CUS_2_MAX_DATE(Object[] objArray) {
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_2_MAX_DATE");
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1, (String) objArray[0]);
							query.execute();
							return sp_SP_DDM_CUS_2_MAX_DATE_Result.generateResultList_SP_DDM_CUS_2_MAX_DATE(query.getResultList());
						}finally {em.close();}}

					
						
						public Object generateResultBean_SP_DDM_CUS_2_MAX_DATE(Object[] objArray){
							  System.out.println("objArray--> "+objArray[0]);
							   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_2_MAX_DATE");
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  query.setParameter(1,(String)objArray[0] ); 
							  query.execute(); 
							  return  query.getResultList().get(0);
							  }finally {em.close();}}
						

						private SP_DDM_CUS_2_ALL_Result sp_DDM_CUS_2_ALL_Result = new SP_DDM_CUS_2_ALL_Result();
						@SuppressWarnings("unchecked")


						
						//Object
						public SP_DDM_CUS_2_ALL_Result generateResultBean_SP_DDM_CUS_2_ALL(Object[] objArray)
						{
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_2_ALL");
						query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
						query.setParameter(1,(String) objArray[0] );
						query.execute();
						return sp_DDM_CUS_2_ALL_Result.generateResultBean_SP_DDM_CUS_2_ALL((Object[]) query.getResultList().get(0));
						}finally {em.close();}}
						//-----115
						private SP_DDM_CUS_2_COMM_Result sp_DDM_CUS_2_COMM_Result = new SP_DDM_CUS_2_COMM_Result();
						@SuppressWarnings("unchecked")


						public List<SP_DDM_CUS_2_COMM_Result> generateResultList_SP_DDM_CUS_2_COMM(Object[] objArray){
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_2_COMM");
						query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
						query.setParameter(1,(String) objArray[0] );
						query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN);
						query.setParameter(2,(String) objArray[1] );
						query.execute();
						return sp_DDM_CUS_2_COMM_Result.generateResultList_SP_DDM_CUS_2_COMM(query.getResultList());
						}finally {em.close();}}


						//Object
						public SP_DDM_CUS_2_COMM_Result generateResultBean_SP_DDM_CUS_2_COMM(Object[] objArray)
						{
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_2_COMM");
						query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
						query.setParameter(1,(String) objArray[0] );
						query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN);
						query.setParameter(2,(String) objArray[1] );
						query.execute();
						return sp_DDM_CUS_2_COMM_Result.generateResultBean_SP_DDM_CUS_2_COMM((Object[]) query.getResultList().get(0));
						}finally {em.close();}}
						//-----116
							//-----117
						private SP_DDM_CUS_2_COMM_TEMP_REPORT_Result sp_DDM_CUS_2_COMM_TEMP_REPORT_Result = new SP_DDM_CUS_2_COMM_TEMP_REPORT_Result();
						@SuppressWarnings("unchecked")


						public List<SP_DDM_CUS_2_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CUS_2_COMM_TEMP_REPORT(Object[] objArray){
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_2_COMM_TEMP_REPORT");
						query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
						query.setParameter(1,(String) objArray[0] );
						query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN);
						query.setParameter(2,(String) objArray[1] );
						query.registerStoredProcedureParameter(3, String.class,ParameterMode.IN);
						query.setParameter(3,(String) objArray[2] );
						query.registerStoredProcedureParameter(4, String.class,ParameterMode.IN);
						query.setParameter(4,(String) objArray[3] );
						query.registerStoredProcedureParameter(5, String.class,ParameterMode.IN);
						query.setParameter(5,(String) objArray[4] );
						query.execute();
						return sp_DDM_CUS_2_COMM_TEMP_REPORT_Result.generateResultList_SP_DDM_CUS_2_COMM_TEMP_REPORT(query.getResultList());
						}finally {em.close();}}


						//Object
						public SP_DDM_CUS_2_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CUS_2_COMM_TEMP_REPORT(Object[] objArray)
						{
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_2_COMM_TEMP_REPORT");
						query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
						query.setParameter(1,(String) objArray[0] );
						query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN);
						if(null != objArray[1]) {	query.setParameter(2,(String) objArray[1] );}
						query.registerStoredProcedureParameter(3, String.class,ParameterMode.IN);
						if(null != objArray[2]) {query.setParameter(3,(String) objArray[2] );}
						query.registerStoredProcedureParameter(4, String.class,ParameterMode.IN);
						if(null != objArray[3]) {query.setParameter(4,(String) objArray[3] );}
						query.registerStoredProcedureParameter(5, String.class,ParameterMode.IN);
						query.setParameter(5,(String) objArray[4] );
						query.execute();
						//return sp_DDM_CUS_2_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CUS_2_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
						if(query.getResultList().size() > 0) {
							return sp_DDM_CUS_2_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CUS_2_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
						}
						else {
							return new SP_DDM_CUS_2_COMM_TEMP_REPORT_Result();
						}
						 
						 
						 }finally {em.close();}}
						//-----118
						//-----122
						private SP_DDM_CUS_2_REGION_Result sp_SP_DDM_CUS_2_REGION_Result = new SP_DDM_CUS_2_REGION_Result();
						@SuppressWarnings("unchecked")


						public List<SP_DDM_CUS_2_REGION_Result> generateResultList_SP_DDM_CUS_2_REGION(Object[] objArray){
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_2_REGION");
						query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
						query.setParameter(1,(String) objArray[0] );
						query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN);
						query.setParameter(2,(String) objArray[1] );
						query.execute();
						return sp_SP_DDM_CUS_2_REGION_Result.generateResultList_SP_DDM_CUS_2_REGION(query.getResultList());
						}finally {em.close();}}


						//Object
						public SP_DDM_CUS_2_REGION_Result generateResultBean_SP_DDM_CUS_2_REGION(Object[] objArray)
						{
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_2_REGION");
						query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
						query.setParameter(1,(String) objArray[0] );
						query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN);
						query.setParameter(2,(String) objArray[1] );
						query.execute();
						return sp_SP_DDM_CUS_2_REGION_Result.generateResultBean_SP_DDM_CUS_2_REGION((Object[]) query.getResultList().get(0));
						}finally {em.close();}}


						//Object
							//-----125
						private SP_DDM_CUS_2_ZONE_Result sp_DDM_CUS_2_ZONE_Result = new SP_DDM_CUS_2_ZONE_Result();
						@SuppressWarnings("unchecked")
						//Object
						public SP_DDM_CUS_2_ZONE_Result generateResultBean_SP_DDM_CUS_2_ZONE(Object[] objArray)
						{
						 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_2_ZONE");
						query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
						query.setParameter(1,(String) objArray[0] );
						query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN);
						query.setParameter(2,(String) objArray[1] );
						query.execute();
						return sp_DDM_CUS_2_ZONE_Result.generateResultBean_SP_DDM_CUS_2_ZONE((Object[]) query.getResultList().get(0));
						}finally {em.close();}}
						
						private SP_DDM_CUS_2_COMM_TEMP_Result sp_DDM_CUS_2_COMM_TEMP_Result=new SP_DDM_CUS_2_COMM_TEMP_Result();
						public SP_DDM_CUS_2_COMM_TEMP_Result generateResultBeanSP_DDM_CUS_2_COMM_TEMP(Object[] objArray,HttpServletRequest request){
							  System.out.println("objArray0--> "+objArray[0]);
							  System.out.println("objArray0--> "+objArray[1]);
							  System.out.println("objArray0--> "+objArray[2]);
							  
							   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_2_COMM_TEMP");
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  query.setParameter(1,(String)objArray[0] );
							  
							  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
							  if(null!=objArray[1] && objArray[1]!=null) 
							  {
							  query.setParameter(2,(String)objArray[1] ); 
							  }
							  
							  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
							  if(null!=objArray[2] && objArray[2]!=null) {
							  query.setParameter(3,(String)objArray[2] ); }
							  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
							  query.execute(); 
							  
							  String out = (String)query.getOutputParameterValue(4);
							  logger.info("--out--"+out);
							  request.getSession().setAttribute("_Result", out);
							  
							  return sp_DDM_CUS_2_COMM_TEMP_Result.generateResultBeanSP_DDM_CUS_2_COMM_TEMP((Object[])query.getResultList().get(0));
							 /* if(query.getResultList().size() > 0) {
									return sp_DDM_CUS_2_COMM_TEMP_Result.generateResultBeanSP_DDM_CUS_2_COMM_TEMP((Object[]) query.getResultList().get(0));
								}
								else {
									return new SP_DDM_CUS_2_COMM_TEMP_Result();
								}*/
							   
							   } 
							   
							   finally {em.close();}}
						
						public String generateResultBeanSP_DDM_CUS_2_TEMP_UPDATE(Object[] objArray){
							System.out.println("objArray--> "+objArray[0]);
							   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_2_TEMP_UPDATE");
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  if(null!=objArray[0] && objArray[0]!=null) {
							  query.setParameter(1,(String)objArray[0] ); }
							  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
							  if(null!=objArray[1] && objArray[1]!=null) {
							  query.setParameter(2,(String)objArray[1] ); }
							  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
							  if(null!=objArray[2] && objArray[2]!=null) {
							  query.setParameter(3,(String)objArray[2] ); }
							  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
							  if(null!=objArray[3] && objArray[3]!=null) {
							  query.setParameter(4,(String)objArray[3] ); }
							  query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
							  if(null!=objArray[4] && objArray[4]!=null) {
							  query.setParameter(5,(String)objArray[4] ); }
							  query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
							  if(null!=objArray[5] && objArray[5]!=null) {
							  query.setParameter(6,(String)objArray[5] ); }
							  query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
							  if(null!=objArray[6] && objArray[6]!=null) {
							  query.setParameter(7,(String)objArray[6] ); }
							  query.registerStoredProcedureParameter(8,String.class,ParameterMode.IN);
							  if(null!=objArray[7] && objArray[7]!=null) {
							  query.setParameter(8,(String)objArray[7] ); }
							  query.registerStoredProcedureParameter(9,String.class,ParameterMode.IN);
							  if(null!=objArray[8] && objArray[8]!=null) {
							  query.setParameter(9,(String)objArray[8] ); }
							  query.registerStoredProcedureParameter(10,String.class,ParameterMode.IN);
							  if(null!=objArray[9] && objArray[9]!=null) {
							  query.setParameter(10,(String)objArray[9] ); }
							  query.registerStoredProcedureParameter(11,String.class,ParameterMode.IN);
							  if(null!=objArray[10] && objArray[10]!=null) {
							  query.setParameter(11,(String)objArray[10] ); }
							  query.registerStoredProcedureParameter(12,String.class,ParameterMode.IN);
							  if(null!=objArray[11] && objArray[11]!=null) {
							  query.setParameter(12,(String)objArray[11] ); }
							  query.registerStoredProcedureParameter(13,String.class,ParameterMode.IN);
							  if(null!=objArray[12] && objArray[12]!=null) {
							  query.setParameter(13,(String)objArray[12] );}
							  query.registerStoredProcedureParameter(14,String.class,ParameterMode.IN);
							  if(null!=objArray[13] && objArray[13]!=null) {
							  query.setParameter(14,(String)objArray[13] ); }
							  query.registerStoredProcedureParameter(15,String.class,ParameterMode.IN);
							  if(null!=objArray[14] && objArray[14]!=null) {
							  query.setParameter(15,(String)objArray[14] ); }
							  query.registerStoredProcedureParameter(16,String.class,ParameterMode.IN);
							  if(null!=objArray[15] && objArray[15]!=null) {
							  query.setParameter(16,(String)objArray[15] ); }
							  query.registerStoredProcedureParameter(17,String.class,ParameterMode.IN);
							  if(null!=objArray[16] && objArray[16]!=null) {
							  query.setParameter(17,(String)objArray[16] ); }
							  query.registerStoredProcedureParameter(18,String.class,ParameterMode.IN);
							  if(null!=objArray[17] && objArray[17]!=null) {
							  query.setParameter(18,(String)objArray[17] ); }
							  query.registerStoredProcedureParameter(19,String.class,ParameterMode.IN);
							  if(null!=objArray[18] && objArray[18]!=null) {
							  query.setParameter(19,(String)objArray[18] ); }
							  query.registerStoredProcedureParameter(20,String.class,ParameterMode.IN);
							  if(null!=objArray[19] && objArray[19]!=null) {
							  query.setParameter(20,(String)objArray[19] ); }
							  query.registerStoredProcedureParameter(21,String.class,ParameterMode.IN);
							  if(null!=objArray[20] && objArray[20]!=null) {
							  query.setParameter(21,(String)objArray[20] ); }
							  query.registerStoredProcedureParameter(22,String.class,ParameterMode.OUT);
							  query.execute(); 
							  String out = (String)query.getOutputParameterValue(22);
							  return out	;
						}finally {em.close();}}

						public String generateResultBeanSP_DDM_CUS_2_INSERT(Object[] objArray){
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
							   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_2_INSERT");
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  if(null!=objArray[0] && objArray[0]!=null) {
							  query.setParameter(1,(String)objArray[0] ); }
							  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
							  if(null!=objArray[1] && objArray[1]!=null) {
							  query.setParameter(2,(String)objArray[1] ); }
							  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
							  if(null!=objArray[2] && objArray[2]!=null) {
							  query.setParameter(3,(String)objArray[2] ); }
							  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
							  if(null!=objArray[3] && objArray[3]!=null) {
							  query.setParameter(4,(String)objArray[3] ); }
							  query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
							  if(null!=objArray[4] && objArray[4]!=null) {
							  query.setParameter(5,(String)objArray[4] ); }
							  query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
							  if(null!=objArray[5] && objArray[5]!=null) {
							  query.setParameter(6,(String)objArray[5] ); }
							  query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
							  if(null!=objArray[6] && objArray[6]!=null) {
							  query.setParameter(7,(String)objArray[6] ); }
							  query.registerStoredProcedureParameter(8,String.class,ParameterMode.IN);
							  if(null!=objArray[7] && objArray[7]!=null) {
							  query.setParameter(8,(String)objArray[7] ); }
							  query.registerStoredProcedureParameter(9,String.class,ParameterMode.IN);
							  if(null!=objArray[8] && objArray[8]!=null) {
							  query.setParameter(9,(String)objArray[8] ); }
							  query.registerStoredProcedureParameter(10,String.class,ParameterMode.IN);
							  if(null!=objArray[9] && objArray[9]!=null) {
							  query.setParameter(10,(String)objArray[9] ); }
							  query.registerStoredProcedureParameter(11,String.class,ParameterMode.IN);
							  if(null!=objArray[10] && objArray[10]!=null) {
							  query.setParameter(11,(String)objArray[10] ); }
							  query.registerStoredProcedureParameter(12,String.class,ParameterMode.IN);
							  if(null!=objArray[11] && objArray[11]!=null) {
							  query.setParameter(12,(String)objArray[11] ); }
							  query.registerStoredProcedureParameter(13,String.class,ParameterMode.IN);
							  if(null!=objArray[12] && objArray[12]!=null) {
							  query.setParameter(13,(String)objArray[12] );}
							  query.registerStoredProcedureParameter(14,String.class,ParameterMode.IN);
							  if(null!=objArray[13] && objArray[13]!=null) {
							  query.setParameter(14,(String)objArray[13] ); }
							  query.registerStoredProcedureParameter(15,String.class,ParameterMode.IN);
							  if(null!=objArray[14] && objArray[14]!=null) {
							  query.setParameter(15,(String)objArray[14] ); }
							  query.registerStoredProcedureParameter(16,String.class,ParameterMode.IN);
							  if(null!=objArray[15] && objArray[15]!=null) {
							  query.setParameter(16,(String)objArray[15] ); }
							  query.registerStoredProcedureParameter(17,String.class,ParameterMode.IN);
							  if(null!=objArray[16] && objArray[16]!=null) {
							  query.setParameter(17,(String)objArray[16] ); }
							  query.registerStoredProcedureParameter(18,String.class,ParameterMode.IN);
							  if(null!=objArray[17] && objArray[17]!=null) {
							  query.setParameter(18,(String)objArray[17] ); }
							  query.registerStoredProcedureParameter(19,String.class,ParameterMode.IN);
							  if(null!=objArray[18] && objArray[18]!=null) {
							  query.setParameter(19,(String)objArray[18] ); }
							  query.registerStoredProcedureParameter(20,String.class,ParameterMode.IN);
							  if(null!=objArray[19] && objArray[19]!=null) {
							  query.setParameter(20,(String)objArray[19] ); }
							  query.registerStoredProcedureParameter(21,String.class,ParameterMode.OUT);
							  query.execute(); 
							  String out = (String)query.getOutputParameterValue(21);
							  return out	;
						}finally {em.close();}}
						
						//Ujjwal
						
						//------------------DDM-GST-1-ALPANA-----------------------------------
						//======================maxdate==========================================
						private SP_DDM_GST_1_MAX_DATE_Result sp_DDM_GST_1_MAX_DATE_Result = new SP_DDM_GST_1_MAX_DATE_Result();
						@SuppressWarnings("unchecked")
						public Object generateResultBean_SP_DDM_GST_1_MAX_DATE(Object[] objArray){
							
							 // System.out.println("objArray--> "+objArray[0]);
							   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_1_MAX_DATE");
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  query.setParameter(1,(String)objArray[0] ); 
							  query.execute(); 
							  return  query.getResultList().get(0);
							  }finally {em.close();}}

						//========================commtemp-gst-1===================================
						private SP_DDM_GST_1_COMM_TEMP_Result SP_DDM_GST_1_COMM_TEMP_Result=new SP_DDM_GST_1_COMM_TEMP_Result();
						public SP_DDM_GST_1_COMM_TEMP_Result generateResultBeanSP_DDM_GST_1_COMM_TEMP(Object[] objArray,HttpServletRequest request){
							  System.out.println("objArray0--> "+objArray[0]);
							  System.out.println("objArray0--> "+objArray[1]);
							  System.out.println("objArray0--> "+objArray[2]);
							  
							   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_1_COMM_TEMP");
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  query.setParameter(1,(String)objArray[0] );
							  
							  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
							  if(null!=objArray[1] && objArray[1]!=null) 
							  {
							  query.setParameter(2,(String)objArray[1] ); 
							  }
							  query.registerStoredProcedureParameter(3,String.class,ParameterMode.OUT);
							  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
							  if(null!=objArray[2] && objArray[2]!=null) {
							  query.setParameter(4,(String)objArray[2] ); }
							 
							  query.execute(); 
							  
							  String out = (String)query.getOutputParameterValue(3);
							  logger.info("--out-1-"+out);
							  request.getSession().setAttribute("_Result", out);
							  
							  return SP_DDM_GST_1_COMM_TEMP_Result.generateResultBeanSP_DDM_GST_1_COMM_TEMP((Object[])query.getResultList().get(0));
						 }finally {em.close();}}
						//=====================INSERT-GST-1-ALPS===========================================
						public String generateResultBeanSP_DDM_GST_1_INSERT(Object[] objArray){
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
							   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_1_INSERT");
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  if(null!=objArray[0] && objArray[0]!=null) {
							  query.setParameter(1,(String)objArray[0] ); }
							  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
							  if(null!=objArray[1] && objArray[1]!=null) {
							  query.setParameter(2,(String)objArray[1] ); }
							  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
							  if(null!=objArray[2] && objArray[2]!=null) {
							  query.setParameter(3,(String)objArray[2] ); }
							  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
							  if(null!=objArray[3] && objArray[3]!=null) {
							  query.setParameter(4,(String)objArray[3] ); }
							  query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
							  if(null!=objArray[4] && objArray[4]!=null) {
							  query.setParameter(5,(String)objArray[4] ); }
							  query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
							  if(null!=objArray[5] && objArray[5]!=null) {
							  query.setParameter(6,(String)objArray[5] ); }
							  query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
							  if(null!=objArray[6] && objArray[6]!=null) {
							  query.setParameter(7,(String)objArray[6] ); }
							  query.registerStoredProcedureParameter(8,String.class,ParameterMode.IN);
							  if(null!=objArray[7] && objArray[7]!=null) {
							  query.setParameter(8,(String)objArray[7] ); }
							  query.registerStoredProcedureParameter(9,String.class,ParameterMode.IN);
							  if(null!=objArray[8] && objArray[8]!=null) {
							  query.setParameter(9,(String)objArray[8] ); }
							  query.registerStoredProcedureParameter(10,String.class,ParameterMode.IN);
							  if(null!=objArray[9] && objArray[9]!=null) {
							  query.setParameter(10,(String)objArray[9] ); }
							  query.registerStoredProcedureParameter(11,String.class,ParameterMode.IN);
							  if(null!=objArray[10] && objArray[10]!=null) {
							  query.setParameter(11,(String)objArray[10] ); }
							  query.registerStoredProcedureParameter(12,String.class,ParameterMode.IN);
							  if(null!=objArray[11] && objArray[11]!=null) {
							  query.setParameter(12,(String)objArray[11] ); }
							  query.registerStoredProcedureParameter(13,String.class,ParameterMode.IN);
							  if(null!=objArray[12] && objArray[12]!=null) {
							  query.setParameter(13,(String)objArray[12] );}
							  query.registerStoredProcedureParameter(14,String.class,ParameterMode.IN);
							  if(null!=objArray[13] && objArray[13]!=null) {
							  query.setParameter(14,(String)objArray[13] );}

							  query.registerStoredProcedureParameter(15,String.class,ParameterMode.OUT);
							  query.execute(); 
							  String out = (String)query.getOutputParameterValue(15);
							  return out;
						}finally {em.close();}}
						
						//=========================UPDATE=================================
						public String generateResultBeanSP_DDM_GST_1_UPDATE(Object[] objArray){
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
							  
							   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_1_UPDATE");
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  if(null!=objArray[0] && objArray[0]!=null) {
							  query.setParameter(1,(String)objArray[0] ); }
							  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
							  if(null!=objArray[1] && objArray[1]!=null) {
							  query.setParameter(2,(String)objArray[1] ); }
							  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
							  if(null!=objArray[2] && objArray[2]!=null) {
							  query.setParameter(3,(String)objArray[2] ); }
							  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
							  if(null!=objArray[3] && objArray[3]!=null) {
							  query.setParameter(4,(String)objArray[3] ); }
							  query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
							  if(null!=objArray[4] && objArray[4]!=null) {
							  query.setParameter(5,(String)objArray[4] ); }
							  query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
							  if(null!=objArray[5] && objArray[5]!=null) {
							  query.setParameter(6,(String)objArray[5] ); }
							  query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
							  if(null!=objArray[6] && objArray[6]!=null) {
							  query.setParameter(7,(String)objArray[6] ); }
							  query.registerStoredProcedureParameter(8,String.class,ParameterMode.IN);
							  if(null!=objArray[7] && objArray[7]!=null) {
							  query.setParameter(8,(String)objArray[7] ); }
							  query.registerStoredProcedureParameter(9,String.class,ParameterMode.IN);
							  if(null!=objArray[8] && objArray[8]!=null) {
							  query.setParameter(9,(String)objArray[8] ); }
							  query.registerStoredProcedureParameter(10,String.class,ParameterMode.IN);
							  if(null!=objArray[9] && objArray[9]!=null) {
							  query.setParameter(10,(String)objArray[9] ); }
							  query.registerStoredProcedureParameter(11,String.class,ParameterMode.IN);
							  if(null!=objArray[10] && objArray[10]!=null) {
							  query.setParameter(11,(String)objArray[10] ); }
							  query.registerStoredProcedureParameter(12,String.class,ParameterMode.IN);
							  if(null!=objArray[11] && objArray[11]!=null) {
							  query.setParameter(12,(String)objArray[11] ); }
							  query.registerStoredProcedureParameter(13,String.class,ParameterMode.IN);
							  if(null!=objArray[12] && objArray[12]!=null) {
							  query.setParameter(13,(String)objArray[12] );}
							  query.registerStoredProcedureParameter(14,String.class,ParameterMode.IN);
							  if(null!=objArray[13] && objArray[13]!=null) {
								  query.setParameter(14,(String)objArray[13] );}
							  query.registerStoredProcedureParameter(15,String.class,ParameterMode.IN);
							  if(null!=objArray[14] && objArray[14]!=null) {
								  query.setParameter(15,(String)objArray[14] );}

							  query.registerStoredProcedureParameter(16,String.class,ParameterMode.OUT);
							  query.execute(); 
							  String out = (String)query.getOutputParameterValue(16);
							  return out	;
						}finally {em.close();}}
						
						
						public Object generateResultBean_SP_DDM_CE_4_MAX_DATE(Object[] objArray){
							try {
							  System.out.println("objArray--> "+objArray[0]);
					          StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CE_4_MAX_DATE");
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  query.setParameter(1,(String)objArray[0] ); 
							  query.execute(); 
							  return  query.getResultList().get(0);
							}
							finally {
								em.close();
							}
							  }
						
						public  String generateResultBean_SP_DDM_CE_4_COMM_TEMP(Object[] objArray){
							try {
							  //SP_DDM_GST_5_COMM_TEMP_Result sP_DDM_GST_5_COMM_TEMP_Result = new SP_DDM_GST_5_COMM_TEMP_Result();
							  System.out.println("SP_DDM_CE_4_COMM_TEMP objArray0--> "+objArray[0]);
							  System.out.println("SP_DDM_CE_4_COMM_TEMP objArray1--> "+objArray[1]);
							  System.out.println("SP_DDM_CE_4_COMM_TEMP objArray2--date> "+objArray[2]);
							  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CE_4_COMM_TEMP");
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  query.setParameter(1,(String)objArray[0] ); 
							  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
							  if(null!=objArray[1] && objArray[1]!=null) {
							  query.setParameter(2,(String)objArray[1] ); }
							  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
							  if(null!=objArray[2] && objArray[2]!=null) {
							  query.setParameter(3,(String)objArray[2] ); }
							  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
							  query.execute(); 
							  String out = (String)query.getOutputParameterValue(4);
							  logger.info("--out--"+out);
							 // request.getSession().setAttribute("_Result", out);
							  //return sP_DDM_GST_5_COMM_TEMP_Result.generateResultBean((Object[])query.getResultList().get(0));
							  return out;
							}finally {
								em.close();
							}
						 }
						
						private SP_DDM_CE_4_COMM_TEMP_Result sp_DDM_CE_4_COMM_TEMP_Result=new SP_DDM_CE_4_COMM_TEMP_Result();
						  public List<SP_DDM_CE_4_COMM_TEMP_Result> generateResultBean_SP_DDM_CE_4_COMM_TEMP(Object[] objArray,HttpServletRequest request){
							  System.out.println("objArray0--> "+objArray[0]);
							  System.out.println("objArray1--> "+objArray[1]);
							  System.out.println("objArray2--> "+objArray[2]);
							   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CE_4_COMM_TEMP");
							  
							  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
							  query.setParameter(1,(String)objArray[0] ); 
							  
							  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
							  if(null!=objArray[1] && objArray[1]!=null) 
							  {
							  query.setParameter(2,(String)objArray[1] ); 
							  }
							  //query.setParameter(2,(String)objArray[1] ); 
							  
							  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
							  if(null!=objArray[2] && objArray[2]!=null) 
							  {
							  query.setParameter(3,(String)objArray[2] ); 
							  }
							  
							  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
							  
							  query.execute(); 
							  String out = (String)query.getOutputParameterValue(4);
							  logger.info("--out--"+out);
							  request.getSession().setAttribute("_Result", out);
							  return sp_DDM_CE_4_COMM_TEMP_Result.generateResultList_SP_DDM_CE_4_COMM_TEMP(query.getResultList());
						 }finally {em.close();}}
						
						
						public List<SP_DDM_CE_4_REGION_Result> generateResultBean_SP_DDM_CE_4_REGION(Object[] objArray) {
							try {
							SP_DDM_CE_4_REGION_Result sp_SP_DDM_CE_4_REGION_Result = new SP_DDM_CE_4_REGION_Result();
							StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_4_REGION");
							System.out.println("objArray[0]--> "+objArray[0]);
							System.out.println("objArray[1]--> "+objArray[1]);
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1, (String) objArray[0]);
							query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
							query.setParameter(2, (String) objArray[1]);
							query.execute();
							return sp_SP_DDM_CE_4_REGION_Result.generateResultList_SP_DDM_CE_4_REGION(query.getResultList());
							}finally {
								em.close();
							}
						}
						
						

						@SuppressWarnings("unchecked")
						public List<SP_DDM_CE_4_ALL_Result> generateResultList_SP_DDM_CE_4_ALL(Object[] objArray) {
							try {
							SP_DDM_CE_4_ALL_Result sp_SP_DDM_CE_4_ALL_Result = new SP_DDM_CE_4_ALL_Result();
							StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_4_ALL");
							query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
							query.setParameter(1, (String) objArray[0]);
							query.execute();
							return sp_SP_DDM_CE_4_ALL_Result.generateResultList_SP_DDM_CE_4_ALL(query.getResultList());
							}finally {
								em.close();
							}
						}
						
						

						
						//Object
							public List<SP_DDM_CE_4_ZONE_Result> generateResultBean_SP_DDM_CE_4_ZONE(Object[] objArray) {
								try {
								SP_DDM_CE_4_ZONE_Result sp_SP_DDM_CE_4_ZONE_Result = new SP_DDM_CE_4_ZONE_Result();
								StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_4_ZONE");
								System.out.println("objArray[0]--> "+objArray[0]);
								System.out.println("objArray[1]--> "+objArray[1]);
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1,(String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2,(String) objArray[1]);
								query.execute();
								return sp_SP_DDM_CE_4_ZONE_Result.generateResultList_SP_DDM_CE_4_ZONE(query.getResultList());
								}
								finally {
									em.close();
								}
							}
							
							

							@SuppressWarnings("unchecked")

							public List<SP_DDM_CE_4_COMM_Result> generateResultList_SP_DDM_CE_4_COMM_Result(Object[] objArray) {
								try {
								SP_DDM_CE_4_COMM_Result sp_SP_DDM_CE_4_COMM_Result = new SP_DDM_CE_4_COMM_Result();
								StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_4_COMM");
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2, (String) objArray[1]);
								query.execute();
								return sp_SP_DDM_CE_4_COMM_Result.generateResultList_SP_DDM_CE_4_COMM(query.getResultList());
								}finally {
									em.close();
								}
							}
							
							

							@SuppressWarnings("unchecked")

							public List<SP_DDM_CE_4_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CE_4_COMM_TEMP_REPORT(Object[] objArray) {
								try {
								SP_DDM_CE_4_COMM_TEMP_REPORT_Result sp_SP_DDM_CE_4_COMM_TEMP_REPORT_Result = new SP_DDM_CE_4_COMM_TEMP_REPORT_Result();
								System.out.println("objArray--> "+objArray[0]);
								  System.out.println("objArray--> "+objArray[1]);
								  System.out.println("objArray--> "+objArray[2]);
								  System.out.println("objArray--> "+objArray[3]);
								  System.out.println("objArray--> "+objArray[4]);
								StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_4_COMM_TEMP_REPORT");
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								if(null!=objArray[1]) {
									query.setParameter(2, (String) objArray[1]);
								}else {
									//query.setParameter(2, null);
								}
								
								query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
								if(null!=objArray[2]) {
									query.setParameter(3, (String) objArray[2]);
								}else {
									//query.setParameter(3, null);
								}
								query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
								if(null!=objArray[3]) {
									query.setParameter(4, (String) objArray[3]);
								}else {
									//query.setParameter(4, (String) objArray[3]);
								}
								
								query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
								query.setParameter(5, (String) objArray[4]);
								query.execute();
								return sp_SP_DDM_CE_4_COMM_TEMP_REPORT_Result.generateResultList_SP_DDM_CE_4_COMM_TEMP_REPORT(query.getResultList());
							}
							finally {
								em.close();
							}
							}
							
							
													
							
								public String generateResultBean_SP_DDM_CE_4_TEMP_UPDATE(Object[] objArray){
								
									try {
								  StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_4_TEMP_UPDATE");
								
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
								
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1,(String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2,(String) objArray[1]);
								query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
								query.setParameter(3,(String) objArray[2]);
								query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
								query.setParameter(4,(String) objArray[3]);
								query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
								query.setParameter(5,(String) objArray[4]);
								query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
								query.setParameter(6,(String) objArray[5]);
								query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
								query.setParameter(7,(String) objArray[6]);
								query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
								query.setParameter(8,(String) objArray[7]);
								query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
								query.setParameter(9,(String) objArray[8]);
								query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);   // for crr
								if(null!=objArray[9] && objArray[9]!=null) 
								  {
								  query.setParameter(10,(String)objArray[9] ); 
								  }
								
								query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
								query.setParameter(11,(String) objArray[10]);
								
								 query.registerStoredProcedureParameter(12,String.class,ParameterMode.OUT);
								  query.execute(); 
								  String out = (String)query.getOutputParameterValue(12);
								  return out	;
								  //return query.execute();
									}finally {
										em.close();
									}
							}
					  
						  public String generateResultBean_SP_DDM_CE_4_INSERT(Object[] objArray){
							  try {
								 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_4_INSERT");
									query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
									query.setParameter(1, (String) objArray[0]);
									query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
									query.setParameter(2, (String) objArray[1]);
									query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
									query.setParameter(3, (String) objArray[2]);
									query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
									query.setParameter(4, (String) objArray[3]);
									query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
									query.setParameter(5, (String) objArray[4]);
									query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
									query.setParameter(6, (String) objArray[5]);
									query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
									query.setParameter(7, (String) objArray[6]);
									query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
									query.setParameter(8, (String) objArray[7]);
									query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
									query.setParameter(9, (String) objArray[8]);
									
									 query.registerStoredProcedureParameter(10,String.class,ParameterMode.OUT);
									  query.execute(); 
									  String out = (String)query.getOutputParameterValue(10);
									  return out	;
									  //return query.execute();
									
									//return query.execute();
								
						  }finally {
								em.close();
							}
						  }	

						  
						
						  private SP_DDM_CE_5_ALL_Result sp_SP_DDM_CEX_5_ALL_Result = new SP_DDM_CE_5_ALL_Result();

							@SuppressWarnings("unchecked")

							public List<SP_DDM_CE_5_ALL_Result> generateResultList_SP_DDM_CEX_5_ALL(Object[] objArray) {
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_ALL");
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.execute();
								return sp_SP_DDM_CEX_5_ALL_Result.generateResultList_SP_DDM_CEX_5_ALL(query.getResultList());
							}finally {em.close();}}

						//Object
							public SP_DDM_CE_5_ALL_Result generateResultBean_SP_DDM_CEX_5_ALL(Object[] objArray) {
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_ALL");
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.execute();
								return sp_SP_DDM_CEX_5_ALL_Result.generateResultBean_SP_DDM_CEX_5_ALL((Object[]) query.getResultList().get(0));
							}finally {em.close();}}

						//-----148
							private SP_DDM_CE_5_COMM_Result sp_SP_DDM_CEX_5_COMM_Result = new SP_DDM_CE_5_COMM_Result();

							@SuppressWarnings("unchecked")

							public List<SP_DDM_CE_5_COMM_Result> generateResultList_SP_DDM_CEX_5_COMM(Object[] objArray) {
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_5_COMM");
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2, (String) objArray[1]);
								query.execute();
								return sp_SP_DDM_CUS_5_COMM_Result.generateResultList_SP_DDM_CUS_5_COMM(query.getResultList());
							}finally {em.close();}}

						//Object
							public SP_DDM_CE_5_COMM_Result generateResultBean_SP_DDM_CEX_5_COMM(Object[] objArray) {
								System.out.println("in DDM_CUS_5 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_COMM");
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2, (String) objArray[1]);
								query.execute();
								return sp_SP_DDM_CEX_5_COMM_Result.generateResultBean_SP_DDM_CEX_5_COMM((Object[]) query.getResultList().get(0));
							}finally {em.close();}}
							

						//-----
							private SP_DDM_CE_5_COMM_TEMP_Result sp_SP_DDM_CEX_5_COMM_TEMP_Result = new SP_DDM_CE_5_COMM_TEMP_Result();

							@SuppressWarnings("unchecked")

							public List<SP_DDM_CE_5_COMM_TEMP_Result> generateResultList_SP_DDM_CEX_5_COMM_TEMP(Object[] objArray) {
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_COMM_TEMP");
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2, (String) objArray[1]);
								query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
								query.setParameter(3, (String) objArray[2]);
								query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
								query.setParameter(4, (String) objArray[3]);
								query.execute();
								return sp_SP_DDM_CEX_5_COMM_TEMP_Result.generateResultList_SP_DDM_CEX_5_COMM_TEMP(query.getResultList());
							}finally {em.close();}}

						//Object
								 
							  private SP_DDM_CE_5_COMM_TEMP_Result sp_DDM_CEX_5_COMM_TEMP_Result=new SP_DDM_CE_5_COMM_TEMP_Result();
							  public SP_DDM_CE_5_COMM_TEMP_Result generateResultBean_SP_DDM_CEX_5_COMM_TEMP(Object[] objArray,HttpServletRequest request){
								  System.out.println("objArray--> "+objArray[0]);
								  System.out.println("objArray--> "+objArray[1]);
								  System.out.println("objArray--> "+objArray[2]);
								  System.out.println("objArray--> "+objArray[3]);
								   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CE_5_COMM_TEMP");
								  
								  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
								  query.setParameter(1,(String)objArray[0] ); 
								  
								  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
								  if(null!=objArray[1] && objArray[1]!=null) 
								  {
								  query.setParameter(2,(String)objArray[1] ); 
								  }
								  //query.setParameter(2,(String)objArray[1] ); 
								  
								  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
								  if(null!=objArray[2] && objArray[2]!=null) 
								  {
								  query.setParameter(3,(String)objArray[2] ); 
								  }
								  
								  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
								  
								  query.execute(); 
								  String out = (String)query.getOutputParameterValue(4);
								  logger.info("--out--"+out);
								  request.getSession().setAttribute("_Result", out);
								  return sp_DDM_CEX_5_COMM_TEMP_Result.generateResultBeanSP_DDM_CEX_5_COMM_TEMP((Object[])query.getResultList().get(0));
							 }finally {em.close();}}
							  
							
							private SP_DDM_CE_5_COMM_TEMP_REPORT_Result sp_SP_DDM_CEX_5_COMM_TEMP_REPORT_Result = new SP_DDM_CE_5_COMM_TEMP_REPORT_Result();

							@SuppressWarnings("unchecked")

							public List<SP_DDM_CE_5_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CEX_5_COMM_TEMP_REPORT(
									Object[] objArray) {
								System.out.println("objArray--> "+objArray[0]);
								  System.out.println("objArray--> "+objArray[1]);
								  System.out.println("objArray--> "+objArray[2]);
								  System.out.println("objArray--> "+objArray[3]);
								  System.out.println("objArray--> "+objArray[4]);
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_COMM_TEMP_REPORT");
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2, (String) objArray[1]);
								query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
								query.setParameter(3, (String) objArray[2]);
								query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
								query.setParameter(4, (String) objArray[3]);
								query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
								query.setParameter(5, (String) objArray[4]);
								query.execute();
								return sp_SP_DDM_CEX_5_COMM_TEMP_REPORT_Result.generateResultList_SP_DDM_CEX_5_COMM_TEMP_REPORT(query.getResultList());
							}finally {em.close();}}

						//Object
							public SP_DDM_CE_5_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CEX_5_COMM_TEMP_REPORT(Object[] objArray) {
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_COMM_TEMP_REPORT");
								System.out.println("objArray0--> "+objArray[0]);
								System.out.println("objArray1--> "+objArray[1]);
								System.out.println("objArray2--> "+objArray[2]);
								System.out.println("objArray3--> "+objArray[3]);
								System.out.println("objArray4--> "+objArray[4]);
								
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1,(String) objArray[0]);
								
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								if(null!=objArray[1] && objArray[1]!=null) 
								  {
								  query.setParameter(2,(String)objArray[1] ); 
								  }
								
								//query.setParameter(2,(String) objArray[1]);
								query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
								if(null!=objArray[2] && objArray[2]!=null) 
								  {
								  query.setParameter(3,(String)objArray[2] ); 
								  }		
								  query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
								  
								  if(null!=objArray[3] && objArray[3]!=null) 
								  {
								   query.setParameter(4,(String)objArray[3] ); 
								  }
								query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
								query.setParameter(5,(String) objArray[4]);
								query.execute();
								return sp_SP_DDM_CEX_5_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CEX_5_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
							}finally {em.close();}}

						
							//public boolean executeProc(Object[] objArray) {
							public boolean generateResultBeanSP_DDM_CEX_5_INSERT(Object[] objArray){	
							 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_INSERT");
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2, (String) objArray[1]);
								query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
								query.setParameter(3, (String) objArray[2]);
								query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
								query.setParameter(4, (String) objArray[3]);
								query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
								query.setParameter(5, (String) objArray[4]);
								query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
								query.setParameter(6, (String) objArray[5]);
								query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
								query.setParameter(7, (String) objArray[6]);
								query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
								query.setParameter(8, (String) objArray[7]);
								query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
								query.setParameter(9, (String) objArray[8]);
								query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
								query.setParameter(10, (String) objArray[9]);
								
								 //query.registerStoredProcedureParameter(11,String.class,ParameterMode.OUT);
								  //query.execute(); 
								 // String out = (String)query.getOutputParameterValue(11);
								 // return out	;
								 return query.execute();
								
								//return query.execute();
							}finally {em.close();}}

						//--INSERT/UPDATE---153

						//-----154
							private SP_DDM_CE_5_MAX_DATE_Result sp_SP_DDM_CEX_5_MAX_DATE_Result = new SP_DDM_CE_5_MAX_DATE_Result();

							@SuppressWarnings("unchecked")

							public List<SP_DDM_CUS_5_MAX_DATE_Result> generateResultList_SP_DDM_CEX_5_MAX_DATE(Object[] objArray) {
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_MAX_DATE");
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.execute();
								return sp_SP_DDM_CEX_5_MAX_DATE_Result.generateResultList_SP_DDM_CEX_5_MAX_DATE(query.getResultList());
							}finally {em.close();}}

							
							public Object generateResultBean_SP_DDM_CEX_5_MAX_DATE(Object[] objArray){
								  System.out.println("objArray--> "+objArray[0]);
								   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CE_5_MAX_DATE");
								  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
								  query.setParameter(1,(String)objArray[0] ); 
								  query.execute(); 
								  return  query.getResultList().get(0);
								  }finally {em.close();}}
							

						//-----155
							private SP_DDM_CE_5_MEMBER_REGION_Result sp_SP_DDM_CEX_5_MEMBER_REGION_Result = new SP_DDM_CE_5_MEMBER_REGION_Result();


						//Object
							public SP_DDM_CE_5_MEMBER_REGION_Result generateResultBean_SP_DDM_CEX_5_MEMBER_REGION(Object[] objArray) {
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_MEMBER_REGION");
								System.out.println("objArray[0]--> "+objArray[0]);
								System.out.println("objArray[1]--> "+objArray[1]);
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2, (String) objArray[1]);
								query.execute();
								return sp_SP_DDM_CEX_5_MEMBER_REGION_Result.generateResultBean_SP_DDM_CEX_5_MEMBER_REGION((Object[]) query.getResultList().get(0));
							}finally {em.close();}}

						
							private SP_DDM_CE_5_REGION_Result sp_SP_DDM_CEX_5_REGION_Result = new SP_DDM_CE_5_REGION_Result();

						//Object
							public SP_DDM_CE_5_REGION_Result generateResultBean_SP_DDM_CEX_5_REGION(Object[] objArray) {
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_REGION");
								System.out.println("objArray[0]--> "+objArray[0]);
								System.out.println("objArray[1]--> "+objArray[1]);
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1, (String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2, (String) objArray[1]);
								query.execute();
								return sp_SP_DDM_CEX_5_REGION_Result.generateResultBean_SP_DDM_CEX_5_REGION((Object[]) query.getResultList().get(0));
							}finally {em.close();}}

							
					  public boolean generateResultBean_SP_DDM_CEX_5_TEMP_UPDATE(Object[] objArray){
							
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_TEMP_UPDATE");
								
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
								
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1,(String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2,(String) objArray[1]);
								query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
								query.setParameter(3,(String) objArray[2]);
								query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
								query.setParameter(4,(String) objArray[3]);
								query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
								query.setParameter(5,(String) objArray[4]);
								query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
								query.setParameter(6,(String) objArray[5]);
								query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
								query.setParameter(7,(String) objArray[6]);
								query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
								query.setParameter(8,(String) objArray[7]);
								query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
								query.setParameter(9,(String) objArray[8]);
								query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);   // for crr
								if(null!=objArray[9] && objArray[9]!=null) 
								  {
								  query.setParameter(10,(String)objArray[9] ); 
								  }
								query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
								query.setParameter(11,(String) objArray[10]);
								
								// query.registerStoredProcedureParameter(12,String.class,ParameterMode.OUT);
								  //query.execute(); 
								  //String out = (String)query.getOutputParameterValue(12);
								 // return out	;
								  return query.execute();
							}finally {em.close();}}


							//-----159
							private SP_DDM_CE_5_ZONE_Result sp_SP_DDM_CEX_5_ZONE_Result = new SP_DDM_CE_5_ZONE_Result();

							
						//Object
							public SP_DDM_CE_5_ZONE_Result generateResultBean_SP_DDM_CEX_5_ZONE(Object[] objArray) {
								 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_5_ZONE");
								System.out.println("objArray[0]--> "+objArray[0]);
								System.out.println("objArray[1]--> "+objArray[1]);
								query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
								query.setParameter(1,(String) objArray[0]);
								query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
								query.setParameter(2,(String) objArray[1]);
								query.execute();
								return sp_SP_DDM_CEX_5_ZONE_Result.generateResultBean_SP_DDM_CEX_5_ZONE((Object[]) query.getResultList().get(0));
							}finally {em.close();}}
					  
					  
				//	 ================================================================================
		
					public Object generateResultBean(Object[] objArray){
						  System.out.println("objArray--> "+objArray[0]);
						   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1A_MAX_DATE");
						  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
						  query.setParameter(1,(String)objArray[0] ); 
						  query.execute(); 
						  return  query.getResultList().get(0);
						  }finally {em.close();}}

				public String generateResultBeanSP_MPR_CHECK_VALIDATE_UPTO(Object[] objArray){
					  System.out.println("objArray--> "+objArray[0]);
					   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_MPR_CHECK_VALIDATE_UPTO");
					  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
					  query.setParameter(1,(String)objArray[0] ); 
					  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
					  query.setParameter(2,(String)objArray[1] ); 
					  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
					  query.setParameter(3,(String)objArray[2] ); 
					  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
					  query.execute(); 
					  String out = (String)query.getOutputParameterValue(4);
					  return out	;
				     }finally {em.close();}}

				public boolean generateResultBeanSP_SUBMIT_LOG_UPTO_SELECT(Object[] objArray){
					  System.out.println("objArray--> "+objArray[0]);
					   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_SUBMIT_LOG_UPTO_SELECT");
					  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
					  query.setParameter(1,(String)objArray[0] ); 
					  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
					  query.setParameter(2,(String)objArray[1] ); 
					  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
					  query.setParameter(3,(String)objArray[2] ); 
					  return query.execute(); 
					 
				   }finally {em.close();}}
				private SP_DDM_CUS_1A_COMM_TEMP_ProcResult sp_DDM_CUS_1A_COMM_TEMP_ProcResult=new SP_DDM_CUS_1A_COMM_TEMP_ProcResult();
				public SP_DDM_CUS_1A_COMM_TEMP_ProcResult generateResultBeanSP_DDM_CUS_1A_COMM_TEMP(Object[] objArray,HttpServletRequest request){
					  System.out.println("objArray0--> "+objArray[0]);
					  System.out.println("objArray1--> "+objArray[1]);
					  System.out.println("objArray2--date> "+objArray[2]);
					   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1A_COMM_TEMP");
					  
					  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
					  query.setParameter(1,(String)objArray[0] ); 
					  
					  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
					  if(null!=objArray[1] && objArray[1]!=null) 
					  {
					  query.setParameter(2,(String)objArray[1] ); 
					  }	  
					  
					  
					  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
					  if(null!=objArray[2] && objArray[2]!=null) 
					  {
					  query.setParameter(3,(String)objArray[2] ); 
					  }
					  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
					  
					  query.execute(); 
					  String out = (String)query.getOutputParameterValue(4);
					  logger.info("--out--"+out);
					  request.getSession().setAttribute("_Result", out);
					  return sp_DDM_CUS_1A_COMM_TEMP_ProcResult.generateResultBean((Object[])query.getResultList().get(0));
					  /*if(query.getResultList().size() > 0) {
							return sp_DDM_CUS_1A_COMM_TEMP_ProcResult.generateResultBean((Object[]) query.getResultList().get(0));
						}
						else {
							return new SP_DDM_CUS_1A_COMM_TEMP_ProcResult();
						} */
					  
					  
				 }finally {em.close();}}
				
				public String generateResultBeanSP_DDM_CUS_1A_TEMP_UPDATE(Object[] objArray){
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
					  System.out.println("objArray[12]--CRR-> "+objArray[12]);
					  System.out.println("objArray[13]--> "+objArray[13]);
					  System.out.println("objArray[14]--> "+objArray[14]);
					   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1A_TEMP_UPDATE");
					  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
					  if(null!=objArray[0] && objArray[0]!=null) {
					  query.setParameter(1,(String)objArray[0] ); }
					  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
					  if(null!=objArray[1] && objArray[1]!=null) {
					  query.setParameter(2,(String)objArray[1] ); }
					  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
					  if(null!=objArray[2] && objArray[2]!=null) {
					  query.setParameter(3,(String)objArray[2] ); }
					  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
					  if(null!=objArray[3] && objArray[3]!=null) {
					  query.setParameter(4,(String)objArray[3] ); }
					  query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
					  if(null!=objArray[4] && objArray[4]!=null) {
					  query.setParameter(5,(String)objArray[4] ); }
					  query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
					  if(null!=objArray[5] && objArray[5]!=null) {
					  query.setParameter(6,(String)objArray[5] ); }
					  query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
					  if(null!=objArray[6] && objArray[6]!=null) {
					  query.setParameter(7,(String)objArray[6] ); }
					  query.registerStoredProcedureParameter(8,String.class,ParameterMode.IN);
					  if(null!=objArray[7] && objArray[7]!=null) {
					  query.setParameter(8,(String)objArray[7] ); }
					  query.registerStoredProcedureParameter(9,String.class,ParameterMode.IN);
					  if(null!=objArray[8] && objArray[8]!=null) {
					  query.setParameter(9,(String)objArray[8] ); }
					  query.registerStoredProcedureParameter(10,String.class,ParameterMode.IN);
					  if(null!=objArray[9] && objArray[9]!=null) {
					  query.setParameter(10,(String)objArray[9] ); }
					  query.registerStoredProcedureParameter(11,String.class,ParameterMode.IN);
					  if(null!=objArray[10] && objArray[10]!=null) {
					  query.setParameter(11,(String)objArray[10] ); }
					  query.registerStoredProcedureParameter(12,String.class,ParameterMode.IN);
					  if(null!=objArray[11] && objArray[11]!=null) {
					  query.setParameter(12,(String)objArray[11] ); }
					  query.registerStoredProcedureParameter(13,String.class,ParameterMode.IN);
					  if(null!=objArray[12] && objArray[12]!=null) {
					  query.setParameter(13,(String)objArray[12] );}
					  query.registerStoredProcedureParameter(14,String.class,ParameterMode.IN);
					  if(null!=objArray[13] && objArray[13]!=null) {
					  query.setParameter(14,(String)objArray[13] ); }
					  query.registerStoredProcedureParameter(15,String.class,ParameterMode.IN);
					  if(null!=objArray[14] && objArray[14]!=null) {
					  query.setParameter(15,(String)objArray[14] );}
					  query.registerStoredProcedureParameter(16,String.class,ParameterMode.IN);
					  if(null!=objArray[15] && objArray[15]!=null) {
						  query.setParameter(16,(String)objArray[15] );}
					  query.registerStoredProcedureParameter(17,String.class,ParameterMode.IN);
					  if(null!=objArray[16] && objArray[16]!=null) {
						  query.setParameter(17,(String)objArray[16] );}
					  query.registerStoredProcedureParameter(18,String.class,ParameterMode.IN);
					  if(null!=objArray[17] && objArray[17]!=null) {
						  query.setParameter(18,(String)objArray[17] );}
					  
					  query.registerStoredProcedureParameter(19,String.class,ParameterMode.OUT);
					  
					  query.registerStoredProcedureParameter(20,String.class,ParameterMode.IN);
					  if(null!=objArray[18] && objArray[18]!=null) {
						  query.setParameter(20,(String)objArray[18] );}
					  
					  query.execute(); 
					  String out = (String)query.getOutputParameterValue(19);
					  logger.info("update--out-->"+out);
					  return out	;
				}finally {em.close();}}
				public String generateResultBeanSP_DDM_CUS_1A_INSERT(Object[] objArray){
					  System.out.println("objArray[2]--> "+objArray[2]);
					   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1A_INSERT");
					  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
					  if(null!=objArray[0] && objArray[0]!=null) {
					  query.setParameter(1,(String)objArray[0] ); }
					  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
					  if(null!=objArray[1] && objArray[1]!=null) {
					  query.setParameter(2,(String)objArray[1] ); }
					  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
					  if(null!=objArray[2] && objArray[2]!=null) {
					  query.setParameter(3,(String)objArray[2] ); }
					  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
					  if(null!=objArray[3] && objArray[3]!=null) {
					  query.setParameter(4,(String)objArray[3] ); }
					  query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
					  if(null!=objArray[4] && objArray[4]!=null) {
					  query.setParameter(5,(String)objArray[4] ); }
					  query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
					  if(null!=objArray[5] && objArray[5]!=null) {
					  query.setParameter(6,(String)objArray[5] ); }
					  query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
					  if(null!=objArray[6] && objArray[6]!=null) {
					  query.setParameter(7,(String)objArray[6] ); }
					  query.registerStoredProcedureParameter(8,String.class,ParameterMode.IN);
					  if(null!=objArray[7] && objArray[7]!=null) {
					  query.setParameter(8,(String)objArray[7] ); }
					  query.registerStoredProcedureParameter(9,String.class,ParameterMode.IN);
					  if(null!=objArray[8] && objArray[8]!=null) {
					  query.setParameter(9,(String)objArray[8] ); }
					  query.registerStoredProcedureParameter(10,String.class,ParameterMode.IN);
					  if(null!=objArray[9] && objArray[9]!=null) {
					  query.setParameter(10,(String)objArray[9] ); }
					  query.registerStoredProcedureParameter(11,String.class,ParameterMode.IN);
					  if(null!=objArray[10] && objArray[10]!=null) {
					  query.setParameter(11,(String)objArray[10] ); }
					  query.registerStoredProcedureParameter(12,String.class,ParameterMode.IN);
					  if(null!=objArray[11] && objArray[11]!=null) {
					  query.setParameter(12,(String)objArray[11] ); }
					  query.registerStoredProcedureParameter(13,String.class,ParameterMode.IN);
					  if(null!=objArray[12] && objArray[12]!=null) {
					  query.setParameter(13,(String)objArray[12] );}
					  query.registerStoredProcedureParameter(14,String.class,ParameterMode.IN);
					  if(null!=objArray[13] && objArray[13]!=null) {
					  query.setParameter(14,(String)objArray[13] ); }
					  query.registerStoredProcedureParameter(15,String.class,ParameterMode.IN);
					  if(null!=objArray[14] && objArray[14]!=null) {
					  query.setParameter(15,(String)objArray[14] );}
					  query.registerStoredProcedureParameter(16,String.class,ParameterMode.IN);
					  if(null!=objArray[15] && objArray[15]!=null) {
						  query.setParameter(16,(String)objArray[15] );}
					  query.registerStoredProcedureParameter(17,String.class,ParameterMode.IN);
					  if(null!=objArray[16] && objArray[16]!=null) {
						  query.setParameter(17,(String)objArray[16] );}
					  query.registerStoredProcedureParameter(18,String.class,ParameterMode.IN);
					  if(null!=objArray[17] && objArray[17]!=null) {
						  query.setParameter(18,(String)objArray[17] );}
					  
					  query.registerStoredProcedureParameter(19,String.class,ParameterMode.OUT);
					  query.execute(); 
					  String out = (String)query.getOutputParameterValue(19);
					  logger.info("insert--out-->"+out);
					  return out	;
				}finally {em.close();}}

				public Object generateResultBean_TARGET_MAXDATE(Object[] objArray){
					  System.out.println("objArray--> "+objArray[0]);
					   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1A_TARGET_MAX_DATE");
					  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
					  query.setParameter(1,(String)objArray[0] ); 
					  query.execute(); 
					  return  query.getResultList().get(0);
					  }finally {em.close();}}	

				private SP_DDM_CUS_1A_COMM_TARGET_Result sp_DDM_CUS_1A_COMM_TARGET_Result=new SP_DDM_CUS_1A_COMM_TARGET_Result();
				public SP_DDM_CUS_1A_COMM_TARGET_Result generateResultBeanSP_DDM_CUS_1A_COMM_TARGET(Object[] objArray){
					  System.out.println("objArray-mm_yyyy-> "+objArray[0]);
					  System.out.println("objArray-Comm_code-> "+objArray[1]);
					   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1A_COMM_TARGET");
					  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
					  query.setParameter(1,(String)objArray[0] ); 
					  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
					  query.setParameter(2,(String)objArray[1] ); 
					  query.execute(); 
					  return sp_DDM_CUS_1A_COMM_TARGET_Result.generateResultBean((Object[])query.getResultList().get(0));
					 /* if(query.getResultList().size() > 0) {
							return sp_DDM_CUS_1A_COMM_TARGET_Result.generateResultBean((Object[]) query.getResultList().get(0));
						}
						else {
							return new SP_DDM_CUS_1A_COMM_TARGET_Result();
						} */
				 }finally {em.close();}}

				@Transactional	
				public int generateResultBeanSP_DDM_CUS_1A_TARGET_UPDATE(Object[] objArray){
					  System.out.println("objArray0 TARGET--> "+objArray[0]);
					  System.out.println("objArray1 MM_YYYY--> "+objArray[1]);
					  System.out.println("objArray2 COMM_CODE--> "+objArray[2]);
					   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1A_TARGET_UPDATE");
					  query.registerStoredProcedureParameter(1,BigInteger.class,ParameterMode.IN);
					  if(null!=objArray[0] && objArray[0]!=null) {
					  query.setParameter(1,(BigInteger)objArray[0] ); }
					  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
					  if(null!=objArray[1] && objArray[1]!=null) {
					  query.setParameter(2,(String)objArray[1] ); }
					  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
					  if(null!=objArray[2] && objArray[2]!=null) {
					  query.setParameter(3,(String)objArray[2] ); }
					  return query.executeUpdate();
				}finally {em.close();}}
				public boolean generateResultBeanSP_DDM_CUS_1A_TARGET_INSERT(Object[] objArray){
					System.out.println("objArray[0]--> "+objArray[0]);
					System.out.println("objArray[1]--> "+objArray[1]);
					System.out.println("objArray[2]--> "+objArray[2]);
					   try {StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1A_TARGET_INSERT");
					  
					  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
					  if(null!=objArray[0] && objArray[0]!=null) 
					  {
					  query.setParameter(1,(String)objArray[0] ); 
					  }
					  
					  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
					  if(null!=objArray[1] && objArray[1]!=null) 
					  {
					  query.setParameter(2,(String)objArray[1]); 
					  }
					  
					  query.registerStoredProcedureParameter(3,BigInteger.class,ParameterMode.IN);				  
					  if(null!=objArray[2] && objArray[2]!=null) 
					  {				  
					  query.setParameter(3,(BigInteger)objArray[2] ); 
					  }
					  return query.execute();
					  
				}finally {em.close();}}

				private SP_DDM_CUS_1A_REGION_Result sp_SP_DDM_CUS_1A_REGION_Result = new SP_DDM_CUS_1A_REGION_Result();

				@SuppressWarnings("unchecked")
				public SP_DDM_CUS_1A_REGION_Result generateResultList_SP_DDM_CUS_1A_REGION(Object[] objArray) {
					 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1A_REGION");
					System.out.println("objArray[0]--"+objArray[0]);
					System.out.println("objArray[1]--"+objArray[1]);
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					if(null!=objArray[0] && objArray[0]!=null) 
					{
					query.setParameter(1, (String) objArray[0]);
					}
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					if(null!=objArray[1] && objArray[1]!=null) 
					{
					query.setParameter(2, (String)objArray[1]);
					}
					query.execute();
					return sp_SP_DDM_CUS_1A_REGION_Result.generateResultBean_SP_DDM_CUS_1A_REGION((Object[])query.getResultList().get(0));
				}finally {em.close();}}

				private SP_DDM_CUS_1A_ALL_Result sp_SP_DDM_CUS_1A_ALL_Result = new SP_DDM_CUS_1A_ALL_Result();

				public SP_DDM_CUS_1A_ALL_Result generateResultBean_SP_DDM_CUS_1A_ALL(Object[] objArray) {
					 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1A_ALL");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					if(null!=objArray[0] && objArray[0]!=null) {
					query.setParameter(1, (String) objArray[0]);}
					query.execute();
					return sp_SP_DDM_CUS_1A_ALL_Result.generateResultBean_SP_DDM_CUS_1A_ALL((Object[]) query.getResultList().get(0));
				}finally {em.close();}}

				private SP_DDM_CUS_1A_ZONE_Result sp_DDM_CUS_1A_ZONE_Result =new SP_DDM_CUS_1A_ZONE_Result();
				public SP_DDM_CUS_1A_ZONE_Result generateResultBean_SP_DDM_CUS_1A_ZONE(Object[] objArray) {
					 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1A_ZONE");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					if(null!=objArray[0] && objArray[0]!=null) {
					query.setParameter(1, (String) objArray[0]);}
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					if(null!=objArray[1] && objArray[1]!=null) {
					query.setParameter(2, (String) objArray[1]);}
					query.execute();
					return sp_DDM_CUS_1A_ZONE_Result.generateResultBean_SP_DDM_CUS_1A_ZONE((Object[]) query.getResultList().get(0));
				}finally {em.close();}}

				private SP_DDM_CUS_1A_COMM_Result sp_DDM_CUS_1A_COMM_Result=new SP_DDM_CUS_1A_COMM_Result();
				public SP_DDM_CUS_1A_COMM_Result generateResultBean_SP_DDM_CUS_1A_COMM(Object[] objArray) {
					System.out.println("in DDM_CUS_1A action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
					 try {StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1A_COMM");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					if(null!=objArray[0] && objArray[0]!=null) {
					query.setParameter(1, (String) objArray[0]);}
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					if(null!=objArray[0] && objArray[0]!=null) {
					query.setParameter(2, (String) objArray[1]);}
					query.execute();
					return sp_DDM_CUS_1A_COMM_Result.generateResultBean_SP_DDM_CUS_1A_COMM((Object[]) query.getResultList().get(0));
				}finally {em.close();}}


				SP_DDM_CUS_1A_COMM_TEMP_REPORT_Result sp_DDM_CUS_1A_COMM_TEMP_REPORT_Result=new SP_DDM_CUS_1A_COMM_TEMP_REPORT_Result();
				public SP_DDM_CUS_1A_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CUS_1A_COMM_TEMP_REPORT(Object[] objArray) {
					System.out.println("objArray[0]--"+objArray[0]);
					System.out.println("objArray[1]--"+objArray[1]);
					System.out.println("objArray[2]--"+objArray[2]);
					System.out.println("objArray[3]--"+objArray[3]);
					System.out.println("objArray[4]--"+objArray[4]);
					try{StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1A_COMM_TEMP_REPORT");
					query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					if(null!=objArray[0] && objArray[0]!=null) 
					{
					query.setParameter(1, (String) objArray[0]);
					}
					
					query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					if(null!=objArray[1] && objArray[1]!=null) 
					{
					query.setParameter(2, (String) objArray[1]);
					}				
					
					query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
					if(null!=objArray[2] && objArray[2]!=null) 
					{
					query.setParameter(3, (String) objArray[2]);
					}
					
					query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
					if(null!=objArray[3] && objArray[3]!=null) 
					{
					query.setParameter(4, (String) objArray[3]);
					}
					
					query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
					if(null!=objArray[4] && objArray[4]!=null) 
					{
					query.setParameter(5, (String) objArray[4]);
					}
					query.execute();
					//return sp_DDM_CUS_1A_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CUS_1A_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
					if(query.getResultList().size() > 0) {
						return sp_DDM_CUS_1A_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CUS_1A_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
					}
					else {
						return new SP_DDM_CUS_1A_COMM_TEMP_REPORT_Result();
					}
					
					}finally {em.close();}}

					
}
