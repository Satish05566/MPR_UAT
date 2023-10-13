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

import com.ddm.cbic.model.SP_DDM_CUS_1_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TEMP_ProcResult;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TEMP_REPORT_Crr_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_4_COMM_TEMP_Result;
@Repository
public class SP_DDM_CUS_4_DaoImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(SP_DDM_CUS_1_DaoImpl.class);
	
	@Autowired
	private EntityManager em;
	
	 public List<SP_DDM_CUS_4_COMM_TEMP_Result> generateResultBean_SP_DDM_CUS_4_COMM_TEMP(Object[] objArray,HttpServletRequest request){
		  SP_DDM_CUS_4_COMM_TEMP_Result sp_DDM_CUS_4_COMM_TEMP_Result=new SP_DDM_CUS_4_COMM_TEMP_Result();
		  System.out.println("objArray--> "+objArray[0]);
		  System.out.println("objArray--> "+objArray[1]);
		  System.out.println("objArray--> "+objArray[2]);
		  System.out.println("objArray--> "+objArray[3]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_4_COMM_TEMP");
		  
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
		  return sp_DDM_CUS_4_COMM_TEMP_Result.generateResultList_SP_DDM_CUS_4_COMM_TEMP(query.getResultList());
	 }
	  
	  public String generateResultBean_SP_DDM_CUS_4_TEMP_UPDATE(Object[] objArray){
			
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_TEMP_UPDATE");
			
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
		}
 
	  public String generateResultBean_SP_DDM_CUS_4_INSERT(Object[] objArray){	
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_INSERT");
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
			}
 
	  public Object generateResultBean_SP_DDM_CUS_4_MAX_DATE(Object[] objArray){
		  System.out.println("objArray--> "+objArray[0]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CUS_4_MAX_DATE");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.execute(); 
		  return  query.getResultList().get(0);
		  }	


}