package com.ddm.cbic.dao.implementation;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ddm.cbic.model.SP_DDM_CUS_4_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_4_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_4_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CUS_4_COMM_TEMP_REPORT_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_4_INSERT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_4_MAX_DATE_Result;

import com.ddm.cbic.model.SP_DDM_CUS_4_REGION_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_4_TEMP_UPDATE_Result;
import com.ddm.cbic.model.SP_DDM_CUS_4_ZONE_Result;



@Repository
public class DDM_CUS_4_DaoImpl {
	@Autowired
	private EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(DDM_CUS_4_DaoImpl.class);
		
	public String generateResultBean_SP_MPR_CHECK_VALIDATE_UPTO(Object[] objArray){
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
	

public boolean generateResultBean_SP_SUBMIT_LOG_UPTO_SELECT(Object[] objArray){
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


	//-----138
	private SP_DDM_CUS_4_ALL_Result sp_SP_DDM_CUS_4_ALL_Result = new SP_DDM_CUS_4_ALL_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_4_ALL_Result> generateResultList_SP_DDM_CUS_4_ALL(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.execute();
		return sp_SP_DDM_CUS_4_ALL_Result.generateResultList_SP_DDM_CUS_4_ALL(query.getResultList());
	}

//Object
	

//-----148
	private SP_DDM_CUS_4_COMM_Result sp_SP_DDM_CUS_4_COMM_Result = new SP_DDM_CUS_4_COMM_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_4_COMM_Result> generateResultList_SP_DDM_CUS_4_COMM(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_CUS_4_COMM_Result.generateResultList_SP_DDM_CUS_4_COMM(query.getResultList());
	}

//Object
	public SP_DDM_CUS_4_COMM_Result generateResultBean_SP_DDM_CUS_4_COMM(Object[] objArray) {
		System.out.println("in DDM_CUS_4 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_CUS_4_COMM_Result.generateResultBean_SP_DDM_CUS_4_COMM((Object[]) query.getResultList().get(0));
	}
	

//-----
	private SP_DDM_CUS_4_COMM_TEMP_Result sp_SP_DDM_CUS_4_COMM_TEMP_Result = new SP_DDM_CUS_4_COMM_TEMP_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_4_COMM_TEMP_Result> generateResultList_SP_DDM_CUS_4_COMM_TEMP(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_COMM_TEMP");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, (String) objArray[2]);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, (String) objArray[3]);
		query.execute();
		return sp_SP_DDM_CUS_4_COMM_TEMP_Result.generateResultList_SP_DDM_CUS_4_COMM_TEMP(query.getResultList());
	}

//Object
		 
	 
	  
	
	private SP_DDM_CUS_4_COMM_TEMP_REPORT_Result sp_SP_DDM_CUS_4_COMM_TEMP_REPORT_Result = new SP_DDM_CUS_4_COMM_TEMP_REPORT_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_4_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CUS_4_COMM_TEMP_REPORT(
			Object[] objArray) {
		System.out.println("objArray--> "+objArray[0]);
		  System.out.println("objArray--> "+objArray[1]);
		  System.out.println("objArray--> "+objArray[2]);
		  System.out.println("objArray--> "+objArray[3]);
		  System.out.println("objArray--> "+objArray[4]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
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
		query.setParameter(5, (String) objArray[4]);
		query.execute();
		return sp_SP_DDM_CUS_4_COMM_TEMP_REPORT_Result.generateResultList_SP_DDM_CUS_4_COMM_TEMP_REPORT(query.getResultList());
	}

//Object
	public SP_DDM_CUS_4_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CUS_4_COMM_TEMP_REPORT(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_COMM_TEMP_REPORT");
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
		return sp_SP_DDM_CUS_4_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_CUS_4_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
	}

//-----151
	//--INSERT/UPDATE---152
	//public boolean executeProc(Object[] objArray) {
	public String generateResultBeanSP_DDM_CUS_4_INSERT(Object[] objArray){	
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
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, (String) objArray[9]);
		
		 query.registerStoredProcedureParameter(11,String.class,ParameterMode.OUT);
		  query.execute(); 
		  String out = (String)query.getOutputParameterValue(11);
		  return out	;
		  //return query.execute();
		
		//return query.execute();
	}

//--INSERT/UPDATE---153

//-----154
	private SP_DDM_CUS_4_MAX_DATE_Result sp_SP_DDM_CUS_4_MAX_DATE_Result = new SP_DDM_CUS_4_MAX_DATE_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CUS_4_MAX_DATE_Result> generateResultList_SP_DDM_CUS_4_MAX_DATE(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.execute();
		return sp_SP_DDM_CUS_4_MAX_DATE_Result.generateResultList_SP_DDM_CUS_4_MAX_DATE(query.getResultList());
	}

//Object
	/*
	 * public SP_DDM_CUS_4_MAX_DATE_Result
	 * generateResultBean_SP_DDM_CUS_4_MAX_DATE(Object[] objArray) {
	 * StoredProcedureQuery query =
	 * em.createStoredProcedureQuery("SP_DDM_CUS_4_MAX_DATE");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * query.setParameter(1, (String) objArray[0]); query.execute(); return
	 * sp_SP_DDM_CUS_4_MAX_DATE_Result.generateResultBean_SP_DDM_CUS_4_MAX_DATE((
	 * Object[]) query.getResultList().get(0)); }
	 */
	
	
	

//-----155
	



//-----156
	private SP_DDM_CUS_4_REGION_Result sp_SP_DDM_CUS_4_REGION_Result = new SP_DDM_CUS_4_REGION_Result();

//Object
	public List<SP_DDM_CUS_4_REGION_Result> generateResultBean_SP_DDM_CUS_4_REGION(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_REGION");
		System.out.println("objArray[0]--> "+objArray[0]);
		System.out.println("objArray[1]--> "+objArray[1]);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[1]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[0]);
		query.execute();
		return sp_SP_DDM_CUS_4_REGION_Result.generateResultList_SP_DDM_CUS_4_REGION(query.getResultList());
	}

	
		
//--INSERT/UPDATE---158
	//-----159
	private SP_DDM_CUS_4_ZONE_Result sp_SP_DDM_CUS_4_ZONE_Result = new SP_DDM_CUS_4_ZONE_Result();

	
//Object
	public List<SP_DDM_CUS_4_ZONE_Result> generateResultBean_SP_DDM_CUS_4_ZONE(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CUS_4_ZONE");
		System.out.println("objArray[0]--> "+objArray[0]);
		System.out.println("objArray[1]--> "+objArray[1]);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,(String) objArray[1]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,(String) objArray[0]);
		query.execute();
		return sp_SP_DDM_CUS_4_ZONE_Result.generateResultList_SP_DDM_CUS_4_ZONE(query.getResultList());
	}
	
	
	private SP_DDM_CUS_4_COMM_TEMP_Result sp_DDM_CUS_4_COMM_TEMP_Result=new SP_DDM_CUS_4_COMM_TEMP_Result();
	  public List<SP_DDM_CUS_4_COMM_TEMP_Result> generateResultBean_SP_DDM_CUS_4_COMM_TEMP(Object[] objArray,HttpServletRequest request){
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
