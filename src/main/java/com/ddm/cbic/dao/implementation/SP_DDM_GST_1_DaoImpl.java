
  package com.ddm.cbic.dao.implementation;
  
  import java.math.BigInteger;
import java.util.ArrayList;

import javax.persistence.EntityManager; 
  import javax.persistence.ParameterMode; 
  import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger; 
  import org.slf4j.LoggerFactory; 
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.stereotype.Repository;

import com.ddm.cbic.model.SP_DDM_CE_1_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_ALL_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_ALL_Result; 
  import com.ddm.cbic.model.SP_DDM_GST_1_COMM_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_COMM_TEMP_REPORT_Result; 
  import com.ddm.cbic.model.SP_DDM_GST_1_ZONE_Result;
  import com.ddm.cbic.model.SP_DDM_GST_1_REGION_Result;
  
  @Repository public class SP_DDM_GST_1_DaoImpl {
  
  private static final Logger logger =
  LoggerFactory.getLogger(SP_DDM_GST_1_DaoImpl.class);
  
  @Autowired private EntityManager em;
  
  
  
  
  
  private SP_DDM_GST_1_REGION_Result sp_DDM_GST_1_REGION_Result = new   SP_DDM_GST_1_REGION_Result();
  
  @SuppressWarnings("unchecked") public SP_DDM_GST_1_REGION_Result
  generateResultList_SP_DDM_GST_1_REGION(Object[] objArray) {
  try {
  StoredProcedureQuery query =  em.createStoredProcedureQuery("SP_DDM_GST_1_REGION");
  query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
  if(null!=objArray[0] && objArray[0]!=null) { query.setParameter(1, (String)
  objArray[0]);} query.registerStoredProcedureParameter(2, String.class,
  ParameterMode.IN); if(null!=objArray[1] && objArray[1]!=null) {
  query.setParameter(2, (String) objArray[1]);} query.execute(); return
  sp_DDM_GST_1_REGION_Result.generateResultBean_SP_DDM_GST_1_REGION((Object[])query.getResultList().get(0)); 
  }finally {em.close();}
  }
  
  
  private SP_DDM_GST_1_ALL_Result sp_SP_DDM_GST_1_ALL_Result = new   SP_DDM_GST_1_ALL_Result();
  
  
  
  private SP_DDM_GST_1_ZONE_Result sp_DDM_GST_1_ZONE_Result =new
  SP_DDM_GST_1_ZONE_Result(); public SP_DDM_GST_1_ZONE_Result
  generateResultBean_SP_DDM_GST_1_ZONE(Object[] objArray) {
  try {
  StoredProcedureQuery query =
  em.createStoredProcedureQuery("SP_DDM_GST_1_ZONE");
  query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
  if(null!=objArray[0] && objArray[0]!=null) { query.setParameter(1, (String)
  objArray[0]);} query.registerStoredProcedureParameter(2, String.class,
  ParameterMode.IN); if(null!=objArray[1] && objArray[1]!=null) {
  query.setParameter(2, (String) objArray[1]);} query.execute(); 
  return sp_DDM_GST_1_ZONE_Result.generateResultBean_SP_DDM_GST_1_ZONE((Object[])query.getResultList().get(0));  
  }
  finally {em.close();}}
  
  private SP_DDM_GST_1_COMM_Result sp_DDM_GST_1_COMM_Result=new
  SP_DDM_GST_1_COMM_Result(); 
  public SP_DDM_GST_1_COMM_Result generateResultBean_SP_DDM_GST_1_COMM(Object[] objArray) {
  System.out.println("in DDM_GST_1 action value of objArray[0]--"+objArray[0]+
  "--objArray[1]--"+objArray[1]);try { StoredProcedureQuery query =
  em.createStoredProcedureQuery("SP_DDM_GST_1_COMM");
  query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
  if(null!=objArray[0] && objArray[0]!=null) { query.setParameter(1, (String)
  objArray[0]);} query.registerStoredProcedureParameter(2, String.class,
  ParameterMode.IN); if(null!=objArray[0] && objArray[0]!=null) {
  query.setParameter(2, (String) objArray[1]);} 
  query.execute(); 
 
  //return sp_DDM_GST_1_COMM_Result.generateResultBean_SP_DDM_GST_1_COMM((Object[])query.getResultList().get(0));
  if(query.getResultList().size() > 0) {
		return sp_DDM_GST_1_COMM_Result.generateResultBean_SP_DDM_GST_1_COMM((Object[]) query.getResultList().get(0));
		}
		else {
			return null;
		}
  
  
  
  }
  
  
  finally {em.close();}
  
  }
  
  
  SP_DDM_GST_1_COMM_TEMP_REPORT_Result sp_DDM_GST_1_COMM_TEMP_REPORT_Result=new
  SP_DDM_GST_1_COMM_TEMP_REPORT_Result(); public
  SP_DDM_GST_1_COMM_TEMP_REPORT_Result
  generateResultBean_SP_DDM_GST_1_COMM_TEMP_REPORT(Object[] objArray) {
  System.out.println("in DDM_GST_1 action objArray[0]--"+objArray[0]+
  "--objArray[1]--"+objArray[1]);try { StoredProcedureQuery query =
  em.createStoredProcedureQuery("SP_DDM_GST_1_COMM_TEMP_REPORT");
  query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
  if(null!=objArray[0] && objArray[0]!=null) { query.setParameter(1, (String)
  objArray[0]);}
  
  query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
  if(null!=objArray[1] && objArray[1]!=null) { query.setParameter(2, (String)
  objArray[1]);}
  
  
  query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
  if(null!=objArray[2] && objArray[2]!=null) { query.setParameter(3, (String)
  objArray[2]);}
  
  query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
  if(null!=objArray[3] && objArray[3]!=null) { query.setParameter(4, (String)
  objArray[3]);}
  
  query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
  if(null!=objArray[4] && objArray[4]!=null) { query.setParameter(5, (String)
  objArray[4]);} query.execute(); return sp_DDM_GST_1_COMM_TEMP_REPORT_Result.
  generateResultBean_SP_DDM_GST_1_COMM_TEMP_REPORT((Object[])
  query.getResultList().get(0));  }finally {em.close();}}
  
  
  
  public SP_DDM_GST_1_ALL_Result generateResultBean_SP_DDM_GST_1_ALL(Object[]
  objArray) { try{StoredProcedureQuery query =
  em.createStoredProcedureQuery("SP_DDM_GST_1_ALL");
  query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
  if(null!=objArray[0] && objArray[0]!=null) { 
	  query.setParameter(1, (String)objArray[0]);
	  } 
  query.execute(); return
  sp_SP_DDM_GST_1_ALL_Result.generateResultBean_SP_DDM_GST_1_ALL((Object[])
  query.getResultList().get(0));  }finally {em.close();}
  }

  public Object generateResultBean(Object[] objArray){
	  System.out.println("objArray--> "+objArray[0]);
	  try {
	  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_1_MAX_DATE");
	  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	  query.setParameter(1,(String)objArray[0] ); 
	  query.execute(); 
	  return  query.getResultList().get(0); }finally {em.close();}
	  }
  
  
  public Object generateResultBeanSP_DDM_GST_1_TARGET_MAX_DATE(Object[] objArray){
		 logger.info("objArray--> "+objArray[0]);
		 try {
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_1_TARGET_MAX_DATE");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.execute(); 
		  return  query.getResultList().get(0); }finally {em.close();}
		  }
  
  
  private SP_DDM_GST_1_COMM_TARGET_Result sp_DDM_GST_1_COMM_TARGET_Result=new SP_DDM_GST_1_COMM_TARGET_Result();
	public SP_DDM_GST_1_COMM_TARGET_Result generateResultBeanSP_DDM_GST_1_COMM_TARGET_Result(Object[] objArray){
		 logger.info("objArray-mm_yyyy-> "+objArray[0]);
		 logger.info("objArray-Comm_code-> "+objArray[1]);
		 try {
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_1_COMM_TARGET");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		  query.setParameter(2,(String)objArray[1] ); 
		  query.execute(); 
		  if(query.getResultList().size() > 0) {
		  return sp_DDM_GST_1_COMM_TARGET_Result.generateResultBean((Object[])query.getResultList().get(0));
		  }
		  else {
			  
		  return null; 	  
		  }
		 }finally {em.close();}
	 }
	
	
	@Transactional
	public int generateResultBeanSP_DDM_GST_1_TARGET_UPDATE(Object[] objArray){
		 try {
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_1_TARGET_UPDATE");
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
		  
		  return query.executeUpdate();
		 }finally {em.close();}
	}
	
	
	public boolean generateResultBeanSP_DDM_GST_1_TARGET_INSERT(Object[] objArray){
		 logger.info("objArray[2]--> "+objArray[2]);
		 try {
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_GST_1_TARGET_INSERT");
		  
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
		  
		  return query.execute();
		 }finally {em.close();}
		  
	}

  
  }
 