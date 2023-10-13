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

import com.ddm.cbic.model.SP_DDM_CE_1_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_ST_1_ALL_Result;
import com.ddm.cbic.model.SP_DDM_ST_1_COMM_Result;
import com.ddm.cbic.model.SP_DDM_ST_1_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_ST_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_ST_1_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_ST_1_REGION_Result;
import com.ddm.cbic.model.SP_DDM_ST_1_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_ST_2_ALL_Result;
import com.ddm.cbic.model.SP_DDM_ST_2_COMM_Result;
import com.ddm.cbic.model.SP_DDM_ST_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_ST_2_REGION_Result;
import com.ddm.cbic.model.SP_DDM_ST_2_ZONE_Result;

@Repository
public class SP_DDM_ST_1_DaoImpl {

private static final Logger logger = LoggerFactory.getLogger(SP_DDM_ST_1_DaoImpl.class);
	
	@Autowired
	private EntityManager em;
	
	public Object generateResultBean(Object[] objArray){
		 logger.info("objArray--> "+objArray[0]);
		 try {
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_1_MAX_DATE");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.execute(); 
		  return  query.getResultList().get(0);
		 }
			finally {
				em.close();
				
			}
		  }
	
	
	public String generateResultBeanSP_MPR_CHECK_VALIDATE_UPTO(Object[] objArray){
		 logger.info("objArray--> "+objArray[0]);
		 try {
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
			finally {
				em.close();
				
			}
	     }
	
	public SP_DDM_ST_1_COMM_TEMP_Result generateResultBeanSP_DDM_ST_1_COMM_TEMP(Object[] objArray,HttpServletRequest request){
		 SP_DDM_ST_1_COMM_TEMP_Result sp_DDM_ST_1_COMM_TEMP_Result=new SP_DDM_ST_1_COMM_TEMP_Result();
		 logger.info("objArray0--> "+objArray[0]);
		 logger.info("objArray1--> "+objArray[1]);
		 logger.info("objArray2--date> "+objArray[2]);
		 try {
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_1_COMM_TEMP");
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
		  return sp_DDM_ST_1_COMM_TEMP_Result.generateResultBean_SP_DDM_ST_1_COMM_TEMP((Object[])query.getResultList().get(0));
		 }
			finally {
				em.close();
				
			}
	 }
	
	
	@Transactional
	public String generateResultBeanSP_DDM_ST_1_TEMP_UPDATE(Object[] objArray){
		 logger.info("objArray[0]--> "+objArray[0]);
		 logger.info("objArray[1]--> "+objArray[1]);
		 logger.info("objArray[2]--> "+objArray[2]);
		 try { 
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_1_TEMP_UPDATE");
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
		  
		  query.registerStoredProcedureParameter(8,String.class,ParameterMode.OUT);
		  query.execute(); 
		  String out = (String)query.getOutputParameterValue(8);
		  logger.info("update--out-->"+out);
		  return out	;
		 }
			finally {
				em.close();
				
			}
	}
	
	public String generateResultBeanSP_DDM_ST_1_INSERT(Object[] objArray){
		 logger.info("objArray[2]--> "+objArray[2]);
		 try {
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_1_INSERT");
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
          query.registerStoredProcedureParameter(7,String.class,ParameterMode.OUT);
          query.execute(); 
		  String out = (String)query.getOutputParameterValue(7);
		  logger.info("insert--out-->"+out);
		  return out	;}
			finally {
				em.close();
				
			}
		   	
	}

	@SuppressWarnings("unchecked")
	public SP_DDM_ST_2_REGION_Result generateResultList_SP_DDM_ST_2_REGION(Object[] objArray) {
		
		SP_DDM_ST_2_REGION_Result sp_SP_DDM_ST_2_REGION_Result = new SP_DDM_ST_2_REGION_Result();
		try {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_2_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) {
		query.setParameter(2, (String) objArray[1]);}
		query.execute();
		return sp_SP_DDM_ST_2_REGION_Result.generateResultBean_SP_DDM_ST_2_REGION((Object[])query.getResultList().get(0));
		}
		finally {
			em.close();
			
		}
	}

	
	public SP_DDM_ST_2_ALL_Result generateResultBean_SP_DDM_ST_2_ALL(Object[] objArray) {
		SP_DDM_ST_2_ALL_Result sp_SP_DDM_ST_2_ALL_Result = new SP_DDM_ST_2_ALL_Result();
		try {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_2_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		query.execute();
		return sp_SP_DDM_ST_2_ALL_Result.generateResultBean_SP_DDM_ST_2_ALL((Object[]) query.getResultList().get(0));
		}
		finally {
			em.close();
			
		}
	}
	
		public SP_DDM_ST_2_ZONE_Result generateResultBean_SP_DDM_ST_2_ZONE(Object[] objArray) {
		SP_DDM_ST_2_ZONE_Result sp_DDM_ST_2_ZONE_Result =new SP_DDM_ST_2_ZONE_Result();
        try {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_2_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) {
		query.setParameter(2, (String) objArray[1]);}
		query.execute();
		return sp_DDM_ST_2_ZONE_Result.generateResultBean_SP_DDM_ST_2_ZONE((Object[]) query.getResultList().get(0));
        }
		finally {
			em.close();
			
		}
	}
	
	
		public SP_DDM_ST_2_COMM_Result generateResultBean_SP_DDM_ST_2_COMM(Object[] objArray) {
			SP_DDM_ST_2_COMM_Result sp_DDM_ST_2_COMM_Result=new SP_DDM_ST_2_COMM_Result();
			logger.info("in DDM_CUS_2 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
			try {
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_2_COMM");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			if(null!=objArray[0] && objArray[0]!=null) {
			query.setParameter(1, (String) objArray[0]);}
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			if(null!=objArray[0] && objArray[0]!=null) {
			query.setParameter(2, (String) objArray[1]);}
			query.execute();
			//return sp_DDM_ST_1_COMM_Result.generateResultBean_SP_DDM_ST_1_COMM((Object[]) query.getResultList().get(0));
			if(query.getResultList().size() > 0) {
				return sp_DDM_ST_2_COMM_Result.generateResultBean_SP_DDM_ST_2_COMM((Object[]) query.getResultList().get(0));
			}
			else {
				return new SP_DDM_ST_2_COMM_Result();
			}
			}
			finally {
				em.close();
				
			}
		}
		
		public SP_DDM_ST_2_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_ST_2_COMM_TEMP_REPORT_Result(Object[] objArray) {
			SP_DDM_ST_2_COMM_TEMP_REPORT_Result sp_DDM_ST_2_COMM_TEMP_REPORT_Result=new SP_DDM_ST_2_COMM_TEMP_REPORT_Result();
			logger.info("in DDM_CE_1  objArray[0]--"+objArray[0]);
			logger.info("in DDM_CE_1  objArray[1]--"+objArray[1]+"--objArray[2]--"+objArray[2]);
			logger.info("in DDM_CE_1  objArray[3]--"+objArray[3]+"--objArray[4]--"+objArray[4]);
			try {
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_2_COMM_TEMP_REPORT");
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
				return sp_DDM_ST_2_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_ST_2_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
			}
			finally {
				em.close();
				
			}
		}
	
	
		public boolean generateResultBeanSP_SUBMIT_LOG_UPTO_SELECT(Object[] objArray){
			 logger.info("objArray--> "+objArray[0]);
			 try {
			  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_SUBMIT_LOG_UPTO_SELECT");
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,(String)objArray[0] ); 
			  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
			  query.setParameter(2,(String)objArray[1] ); 
			  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
			  query.setParameter(3,(String)objArray[2] ); 
			  return query.execute(); 
			 }
				finally {
					em.close();
					
				}
			 
			 
			 
			 
		   }
		
		public Object generateResultBeanTARGET(Object[] objArray){
			 logger.info("objArray--> "+objArray[0]);
			 try {
			  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_1_TARGET_MAX_DATE");
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,(String)objArray[0] ); 
			  query.execute(); 
			  return  query.getResultList().get(0);
			 }
				finally {
					em.close();
					
				}
			  }	
		
		private SP_DDM_ST_1_COMM_TARGET_Result sp_DDM_ST_1_COMM_TARGET_Result=new SP_DDM_ST_1_COMM_TARGET_Result();
		public SP_DDM_ST_1_COMM_TARGET_Result generateResultBeanSP_DDM_ST_1_COMM_TARGET_Result(Object[] objArray){
			 logger.info("objArray-mm_yyyy-> "+objArray[0]);
			 logger.info("objArray-Comm_code-> "+objArray[1]);
			 try {
			  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_1_COMM_TARGET");
			  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
			  query.setParameter(1,(String)objArray[0] ); 
			  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
			  query.setParameter(2,(String)objArray[1] ); 
			  query.execute(); 
			  return sp_DDM_ST_1_COMM_TARGET_Result.generateResultBean((Object[])query.getResultList().get(0));
			  
			 /* if(query.getResultList().size() > 0) {
					return sp_DDM_ST_1_COMM_TARGET_Result.generateResultBean((Object[]) query.getResultList().get(0));
				}
				else {
					return new SP_DDM_ST_1_COMM_TARGET_Result();
				} */
			 }
				finally {
					em.close();
					
				}
		 }
		
		@Transactional
		public int generateResultBeanSP_DDM_ST_1_TARGET_UPDATE(Object[] objArray){
			 logger.info("objArray0 TARGET--> "+objArray[0]);
			 logger.info("objArray1 MM_YYYY--> "+objArray[1]);
			 logger.info("objArray2 COMM_CODE--> "+objArray[2]);
			 try {
			  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_1_TARGET_UPDATE");
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
				finally {
					em.close();
					
				}
		}
		public boolean generateResultBeanSP_DDM_ST_1_TARGET_INSERT(Object[] objArray){
			 logger.info("objArray[2]--> "+objArray[2]);
			 try {
			  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_1_TARGET_INSERT");
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
				finally {
					em.close();
					
				}
			  
		}

		
		@SuppressWarnings("unchecked")
		public SP_DDM_ST_1_REGION_Result generateResultList_SP_DDM_ST_1_REGION(Object[] objArray) {
			
			SP_DDM_ST_1_REGION_Result sp_SP_DDM_ST_1_REGION_Result = new SP_DDM_ST_1_REGION_Result();
			try {
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_1_REGION");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			if(null!=objArray[0] && objArray[0]!=null) {
			query.setParameter(1, (String) objArray[0]);}
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			if(null!=objArray[1] && objArray[1]!=null) {
			query.setParameter(2, (String) objArray[1]);}
			query.execute();
			return sp_SP_DDM_ST_1_REGION_Result.generateResultBean_SP_DDM_ST_1_REGION((Object[])query.getResultList().get(0));
			}
			finally {
				em.close();
				
			}
		}

		
		

		public SP_DDM_ST_1_ALL_Result generateResultBean_SP_DDM_ST_1_ALL(Object[] objArray) {
			SP_DDM_ST_1_ALL_Result sp_SP_DDM_ST_1_ALL_Result = new SP_DDM_ST_1_ALL_Result();
			try {
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_1_ALL");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			if(null!=objArray[0] && objArray[0]!=null) {
			query.setParameter(1, (String) objArray[0]);}
			query.execute();
			return sp_SP_DDM_ST_1_ALL_Result.generateResultBean_SP_DDM_ST_1_ALL((Object[]) query.getResultList().get(0));
			}
			finally {
				em.close();
				
			}
		}
		
			public SP_DDM_ST_1_ZONE_Result generateResultBean_SP_DDM_ST_1_ZONE(Object[] objArray) {
			SP_DDM_ST_1_ZONE_Result sp_DDM_ST_1_ZONE_Result =new SP_DDM_ST_1_ZONE_Result();
	        try {
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_1_ZONE");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			if(null!=objArray[0] && objArray[0]!=null) {
			query.setParameter(1, (String) objArray[0]);}
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			if(null!=objArray[1] && objArray[1]!=null) {
			query.setParameter(2, (String) objArray[1]);}
			query.execute();
			return sp_DDM_ST_1_ZONE_Result.generateResultBean_SP_DDM_ST_1_ZONE((Object[]) query.getResultList().get(0));
	        }
			finally {
				em.close();
				
			}
		}
		
			
			
			public SP_DDM_ST_1_COMM_Result generateResultBean_SP_DDM_ST_1_COMM(Object[] objArray) {
				SP_DDM_ST_1_COMM_Result sp_DDM_ST_1_COMM_Result=new SP_DDM_ST_1_COMM_Result();
				logger.info("in DDM_CUS_1 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
				try {
				StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_1_COMM");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				if(null!=objArray[0] && objArray[0]!=null) {
				query.setParameter(1, (String) objArray[0]);}
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				if(null!=objArray[0] && objArray[0]!=null) {
				query.setParameter(2, (String) objArray[1]);}
				query.execute();
				//return sp_DDM_ST_1_COMM_Result.generateResultBean_SP_DDM_ST_1_COMM((Object[]) query.getResultList().get(0));
				if(query.getResultList().size() > 0) {
					return sp_DDM_ST_1_COMM_Result.generateResultBean_SP_DDM_ST_1_COMM((Object[]) query.getResultList().get(0));
				}
				else {
					return new SP_DDM_ST_1_COMM_Result();
				}
				}
				finally {
					em.close();
					
				}
			}
			
			
			
			
			
			public SP_DDM_ST_1_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_ST_1_COMM_TEMP_REPORT_Result(Object[] objArray) {
				SP_DDM_ST_1_COMM_TEMP_REPORT_Result sp_DDM_ST_1_COMM_TEMP_REPORT_Result=new SP_DDM_ST_1_COMM_TEMP_REPORT_Result();
				logger.info("in DDM_CE_1  objArray[0]--"+objArray[0]);
				logger.info("in DDM_CE_1  objArray[1]--"+objArray[1]+"--objArray[2]--"+objArray[2]);
				logger.info("in DDM_CE_1  objArray[3]--"+objArray[3]+"--objArray[4]--"+objArray[4]);
				try {
				StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_1_COMM_TEMP_REPORT");
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
				
					if((null != query.getResultList())&&(query.getResultList().size() > 0)) {
						return sp_DDM_ST_1_COMM_TEMP_REPORT_Result.generateResultBean_SP_DDM_ST_1_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
					}
					else {
						return null;
					}
					 
				}
				finally {
					em.close();
					
				}
			}

		
		

}
