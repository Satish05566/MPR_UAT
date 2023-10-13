package com.ddm.cbic.dao.implementation;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.model.SP_DDM_CUS_1_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TEMP_ProcResult;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TEMP_REPORT_Crr_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_TEMP_REPORT_Result;
@Repository
public class SP_DDM_CUS_1_DaoImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(SP_DDM_CUS_1_DaoImpl.class);
	
	@Autowired
	private EntityManager em;
	
	public Object generateResultBean(Object[] objArray){
		  System.out.println("objArray--> "+objArray[0]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1_MAX_DATE");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.execute(); 
		  return  query.getResultList().get(0);
		  }



	public String generateResultBeanSP_MPR_CHECK_VALIDATE_UPTO(Object[] objArray){
		  System.out.println("objArray--> "+objArray[0]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_MPR_CHECK_VALIDATE_UPTO");
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
	     }
	
	public boolean generateResultBeanSP_SUBMIT_LOG_UPTO_SELECT(Object[] objArray){
		  System.out.println("objArray--> "+objArray[0]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_SUBMIT_LOG_UPTO_SELECT");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		  query.setParameter(2,(String)objArray[1] ); 
		  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		  query.setParameter(3,(String)objArray[2] ); 
		  return query.execute(); 
		 
	   }

	private SP_DDM_CUS_1_COMM_TEMP_ProcResult sp_DDM_CUS_1_COMM_TEMP_ProcResult=new SP_DDM_CUS_1_COMM_TEMP_ProcResult();
	public SP_DDM_CUS_1_COMM_TEMP_ProcResult generateResultBeanSP_DDM_CUS_1_COMM_TEMP(Object[] objArray,HttpServletRequest request){
		  System.out.println("objArray0--> "+objArray[0]);
		  System.out.println("objArray1--> "+objArray[1]);
		  System.out.println("objArray2--date> "+objArray[2]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1_COMM_TEMP");
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
		  request.getSession().setAttribute("_Result", out);
		  return sp_DDM_CUS_1_COMM_TEMP_ProcResult.generateResultBean((Object[])query.getResultList().get(0));
	 }
	@Transactional
	public String generateResultBeanSP_DDM_CUS_1_TEMP_UPDATE(Object[] objArray){
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
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1_TEMP_UPDATE");
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
		  query.registerStoredProcedureParameter(16,String.class,ParameterMode.OUT);
		  query.execute(); 
		  String out = (String)query.getOutputParameterValue(16);
		  logger.info("update--out-->"+out);
		  return out	;
	}

	public String generateResultBeanSP_DDM_CUS_1_INSERT(Object[] objArray){
		  System.out.println("objArray[2]--> "+objArray[2]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1_INSERT");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  if(null!=objArray[0] && objArray[0]!=null) {
		  query.setParameter(1,(String)objArray[0] ); }
		  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		  if(null!=objArray[1] && objArray[1]!=null) {
		  query.setParameter(2,(String)objArray[1] ); }
		  if(null!=objArray[2] && objArray[2]!=null) {
		  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		  
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
		  query.registerStoredProcedureParameter(15,String.class,ParameterMode.OUT);
		  query.execute(); 
		  String out = (String)query.getOutputParameterValue(15);
		  logger.info("insert--out-->"+out);
		  return out	;
	}

	public Object generateResultBeanTARGET(Object[] objArray){
		  System.out.println("objArray--> "+objArray[0]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1_TARGET_MAX_DATE");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.execute(); 
		  return  query.getResultList().get(0);
		  }	

	private SP_DDM_CUS_1_COMM_TARGET_Result sp_DDM_CUS_1_COMM_TARGET_Result=new SP_DDM_CUS_1_COMM_TARGET_Result();
	public SP_DDM_CUS_1_COMM_TARGET_Result generateResultBeanSP_DDM_CUS_1_COMM_TARGET(Object[] objArray){
		  System.out.println("objArray-mm_yyyy-> "+objArray[0]);
		  System.out.println("objArray-Comm_code-> "+objArray[1]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1_COMM_TARGET");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		  query.setParameter(2,(String)objArray[1] ); 
		  query.execute(); 
		  return sp_DDM_CUS_1_COMM_TARGET_Result.generateResultBean((Object[])query.getResultList().get(0));
	 }



@Transactional
public int generateResultBeanSP_DDM_CUS_1_TARGET_UPDATE(Object[] objArray){
	  System.out.println("objArray0 TARGET--> "+objArray[0]);
	  System.out.println("objArray1 MM_YYYY--> "+objArray[1]);
	  System.out.println("objArray2 COMM_CODE--> "+objArray[2]);
	  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1_TARGET_UPDATE");
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
}
public boolean generateResultBeanSP_DDM_CUS_1_TARGET_INSERT(Object[] objArray){
	  System.out.println("objArray[2]--> "+objArray[2]);
	  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_1_TARGET_INSERT");
	  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	  if(null!=objArray[0] && objArray[0]!=null) {
	  query.setParameter(1,(String)objArray[0] ); }
	  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	  if(null!=objArray[1] && objArray[1]!=null) {
	  query.setParameter(2,(String)objArray[1] ); }
	  if(null!=objArray[2] && objArray[2]!=null) {
	  query.registerStoredProcedureParameter(3,BigInteger.class,ParameterMode.IN);
	  
	  query.setParameter(3,(BigInteger)objArray[2] ); }
	  return query.execute();
	  
}


	private SP_DDM_CUS_1_REGION_Result sp_SP_DDM_CUS_1_REGION_Result = new SP_DDM_CUS_1_REGION_Result();

	@SuppressWarnings("unchecked")
	public SP_DDM_CUS_1_REGION_Result generateResultList_SP_DDM_CUS_1_REGION(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) {
		query.setParameter(2, (String) objArray[1]);}
		query.execute();
		return sp_SP_DDM_CUS_1_REGION_Result.generateResultBean_SP_DDM_CUS_1_REGION((Object[])query.getResultList().get(0));
	}
	
	
	

	private SP_DDM_CUS_1_ALL_Result sp_SP_DDM_CUS_1_ALL_Result = new SP_DDM_CUS_1_ALL_Result();

	public SP_DDM_CUS_1_ALL_Result generateResultBean_SP_DDM_CUS_1_ALL(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		query.execute();
		//return sp_SP_DDM_CUS_1_ALL_Result.generateResultBean_SP_DDM_CUS_1_ALL((Object[]) query.getResultList().get(0));
		if(query.getResultList().size() > 0) {
			return sp_SP_DDM_CUS_1_ALL_Result.generateResultBean_SP_DDM_CUS_1_ALL((Object[]) query.getResultList().get(0));
		}
		else {
			return new SP_DDM_CUS_1_ALL_Result();
		}
	}

	private SP_DDM_CUS_1_ZONE_Result sp_DDM_CUS_1_ZONE_Result =new SP_DDM_CUS_1_ZONE_Result();
	public SP_DDM_CUS_1_ZONE_Result generateResultBean_SP_DDM_CUS_1_ZONE(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) {
		query.setParameter(2, (String) objArray[1]);}
		query.execute();
		return sp_DDM_CUS_1_ZONE_Result.generateResultBean_SP_DDM_CUS_1_ZONE((Object[]) query.getResultList().get(0));
	}

	private SP_DDM_CUS_1_COMM_Result sp_DDM_CUS_1_COMM_Result=new SP_DDM_CUS_1_COMM_Result();
	public SP_DDM_CUS_1_COMM_Result generateResultBean_SP_DDM_CUS_1_COMM(Object[] objArray) {
		System.out.println("in DDM_CUS_1 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(2, (String) objArray[1]);}
		query.execute();
		return sp_DDM_CUS_1_COMM_Result.generateResultBean_SP_DDM_CUS_1_COMM((Object[]) query.getResultList().get(0));
	}


	SP_DDM_CUS_1_COMM_TEMP_REPORT_Result sp_DDM_CUS_1_COMM_TEMP_REPORT_Result=new SP_DDM_CUS_1_COMM_TEMP_REPORT_Result();
	public SP_DDM_CUS_1_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CUS_1_COMM_TEMP_REPORT(Object[] objArray) {
		System.out.println("in DDM_CUS_1 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) {
		query.setParameter(2, (String) objArray[1]);}
		
		
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null!=objArray[2] && objArray[2]!=null) {
		query.setParameter(3, (String) objArray[2]);}
		
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		if(null!=objArray[3] && objArray[3]!=null) {
		query.setParameter(4, (String) objArray[3]);}
		
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		if(null!=objArray[4] && objArray[4]!=null) {
		query.setParameter(5, (String) objArray[4]);}
		query.execute();
		return sp_DDM_CUS_1_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CUS_1_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
	}

	public SP_DDM_CUS_1_COMM_TEMP_REPORT_Crr_Result generateResultBean_SP_DDM_CUS_1_COMM_TEMP_REPORT_Crr(Object[] objArray) {
		SP_DDM_CUS_1_COMM_TEMP_REPORT_Crr_Result sp_DDM_CUS_1_COMM_TEMP_REPORT_Crr_Result=new SP_DDM_CUS_1_COMM_TEMP_REPORT_Crr_Result();
		System.out.println("in DDM_CUS_1 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_1_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) {
		query.setParameter(2, (String) objArray[1]);}
		
		
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if(null!=objArray[2] && objArray[2]!=null) {
		query.setParameter(3, (String) objArray[2]);}
		
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		if(null!=objArray[3] && objArray[3]!=null) {
		query.setParameter(4, (String) objArray[3]);}
		
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		if(null!=objArray[4] && objArray[4]!=null) {
		query.setParameter(5, (String) objArray[4]);}
		query.execute();
		//String objArray1=(String) objArray[1];
			return sp_DDM_CUS_1_COMM_TEMP_REPORT_Crr_Result.generateResultBean_SP_DDM_CUS_1_COMM_TEMP_REPORT_Crr_Result((Object[]) query.getResultList().get(0));
	}



}