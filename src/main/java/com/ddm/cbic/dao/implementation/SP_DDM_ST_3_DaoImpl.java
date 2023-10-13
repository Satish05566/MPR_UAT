package com.ddm.cbic.dao.implementation;

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

import com.ddm.cbic.model.SP_DDM_ST_3_ALL_Result;
import com.ddm.cbic.model.SP_DDM_ST_3_COMM_Result;
import com.ddm.cbic.model.SP_DDM_ST_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_ST_3_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_ST_3_REGION_Result;
import com.ddm.cbic.model.SP_DDM_ST_3_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_ST_4_ALL_Result;
import com.ddm.cbic.model.SP_DDM_ST_4_COMM_Result;
import com.ddm.cbic.model.SP_DDM_ST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_ST_4_REGION_Result;
import com.ddm.cbic.model.SP_DDM_ST_4_ZONE_Result;

@Repository
public class SP_DDM_ST_3_DaoImpl {

private static final Logger logger = LoggerFactory.getLogger(SP_DDM_ST_3_DaoImpl.class);
	
	@Autowired
	private EntityManager em;
	
	public Object generateResultBean(Object[] objArray){
		 logger.info("objArray--> "+objArray[0]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_3_MAX_DATE");
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  query.setParameter(1,(String)objArray[0] ); 
		  query.execute(); 
		  return  query.getResultList().get(0);
		  }
	
	
	public String generateResultBeanSP_MPR_CHECK_VALIDATE_UPTO(Object[] objArray){
		 logger.info("objArray--> "+objArray[0]);
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
	
	public List<SP_DDM_ST_3_COMM_TEMP_Result> generateResultBeanSP_DDM_ST_3_COMM_TEMP(Object[] objArray,HttpServletRequest request){
		 SP_DDM_ST_3_COMM_TEMP_Result sp_DDM_ST_3_COMM_TEMP_Result=new SP_DDM_ST_3_COMM_TEMP_Result();
		 logger.info("objArray0--> "+objArray[0]);
		 logger.info("objArray1--> "+objArray[1]);
		 logger.info("objArray2--date> "+objArray[2]);
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_ST_3_COMM_TEMP");
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
		 
		  return sp_DDM_ST_3_COMM_TEMP_Result.sp_DDM_ST_3_COMM_TEMP_Result((List<Object[]>)query.getResultList());
	 }
	

	
	
	@SuppressWarnings("unchecked")
	public List<SP_DDM_ST_4_REGION_Result> generateResultList_SP_DDM_ST_4_REGION(Object[] objArray) {
		SP_DDM_ST_4_REGION_Result sp_SP_DDM_ST_4_REGION_Result = new SP_DDM_ST_4_REGION_Result();
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_4_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) {
		query.setParameter(2, (String) objArray[1]);}
		query.execute();
		
		return sp_SP_DDM_ST_4_REGION_Result.SP_DDM_ST_4_REGION_Result((List<Object[]>)query.getResultList());
		//return sp_SP_DDM_ST_3_REGION_Result.generateResultBean_SP_DDM_ST_3_REGION((Object[])query.getResultList().get(0));
	}

	
	

	public List<SP_DDM_ST_4_ALL_Result> generateResultBean_SP_DDM_ST_4_ALL(Object[] objArray) {
		SP_DDM_ST_4_ALL_Result sp_SP_DDM_ST_4_ALL_Result = new SP_DDM_ST_4_ALL_Result();
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_4_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		query.execute();
		return sp_SP_DDM_ST_4_ALL_Result.SP_DDM_ST_4_ALL_Result((List<Object[]>)query.getResultList());
	}
	
		public List<SP_DDM_ST_4_ZONE_Result> generateResultBean_SP_DDM_ST_4_ZONE(Object[] objArray) {
		SP_DDM_ST_4_ZONE_Result sp_DDM_ST_4_ZONE_Result =new SP_DDM_ST_4_ZONE_Result();

		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_4_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1, (String) objArray[0]);}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) {
		query.setParameter(2, (String) objArray[1]);}
		query.execute();
		return sp_DDM_ST_4_ZONE_Result.SP_DDM_ST_4_ZONE_Result((List<Object[]>)query.getResultList());
	}
	
		
		
		public List<SP_DDM_ST_4_COMM_Result> generateResultBean_SP_DDM_ST_4_COMM(Object[] objArray) {
			SP_DDM_ST_4_COMM_Result sp_DDM_ST_4_COMM_Result=new SP_DDM_ST_4_COMM_Result();
			logger.info("in DDM_CUS_4 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_4_COMM");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			if(null!=objArray[0] && objArray[0]!=null) {
			query.setParameter(1, (String) objArray[0]);}
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			if(null!=objArray[0] && objArray[0]!=null) {
			query.setParameter(2, (String) objArray[1]);}
			query.execute();
			return sp_DDM_ST_4_COMM_Result.SP_DDM_ST_4_COMM_Result((List<Object[]>)query.getResultList());
		}
		
		
		
		
		
		public  List<SP_DDM_ST_4_COMM_TEMP_REPORT_Result> generateResultBean_SP_DDM_ST_4_COMM_TEMP_REPORT_Result(Object[] objArray) {
			SP_DDM_ST_4_COMM_TEMP_REPORT_Result sp_DDM_ST_4_COMM_TEMP_REPORT_Result=new SP_DDM_ST_4_COMM_TEMP_REPORT_Result();
			logger.info("in DDM_CE_4  objArray[0]--"+objArray[0]);
			logger.info("in DDM_CE_4  objArray[1]--"+objArray[1]+"--objArray[2]--"+objArray[2]);
			logger.info("in DDM_CE_4  objArray[3]--"+objArray[3]+"--objArray[4]--"+objArray[4]);
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_4_COMM_TEMP_REPORT");
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
				return sp_DDM_ST_4_COMM_TEMP_REPORT_Result.SP_DDM_ST_4_COMM_TEMP_Report_Result((List<Object[]>)query.getResultList());
		}
	
	
		@SuppressWarnings("unchecked")
		public List<SP_DDM_ST_3_REGION_Result> generateResultList_SP_DDM_ST_3_REGION(Object[] objArray) {
			SP_DDM_ST_3_REGION_Result sp_SP_DDM_ST_3_REGION_Result = new SP_DDM_ST_3_REGION_Result();
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_3_REGION");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			if(null!=objArray[0] && objArray[0]!=null) {
			query.setParameter(1, (String) objArray[0]);}
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			if(null!=objArray[1] && objArray[1]!=null) {
			query.setParameter(2, (String) objArray[1]);}
			query.execute();
			
			return sp_SP_DDM_ST_3_REGION_Result.SP_DDM_ST_3_REGION_Result((List<Object[]>)query.getResultList());
			//return sp_SP_DDM_ST_3_REGION_Result.generateResultBean_SP_DDM_ST_3_REGION((Object[])query.getResultList().get(0));
		}

		
		

		public List<SP_DDM_ST_3_ALL_Result> generateResultBean_SP_DDM_ST_3_ALL(Object[] objArray) {
			SP_DDM_ST_3_ALL_Result sp_SP_DDM_ST_3_ALL_Result = new SP_DDM_ST_3_ALL_Result();
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_3_ALL");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			if(null!=objArray[0] && objArray[0]!=null) {
			query.setParameter(1, (String) objArray[0]);}
			query.execute();
			return sp_SP_DDM_ST_3_ALL_Result.SP_DDM_ST_3_ALL_Result((List<Object[]>)query.getResultList());
		}
		
			public List<SP_DDM_ST_3_ZONE_Result> generateResultBean_SP_DDM_ST_3_ZONE(Object[] objArray) {
			SP_DDM_ST_3_ZONE_Result sp_DDM_ST_3_ZONE_Result =new SP_DDM_ST_3_ZONE_Result();

			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_3_ZONE");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			if(null!=objArray[0] && objArray[0]!=null) {
			query.setParameter(1, (String) objArray[0]);}
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			if(null!=objArray[1] && objArray[1]!=null) {
			query.setParameter(2, (String) objArray[1]);}
			query.execute();
			return sp_DDM_ST_3_ZONE_Result.SP_DDM_ST_3_ZONE_Result((List<Object[]>)query.getResultList());
		}
		
			
			
			public List<SP_DDM_ST_3_COMM_Result> generateResultBean_SP_DDM_ST_3_COMM(Object[] objArray) {
				SP_DDM_ST_3_COMM_Result sp_DDM_ST_3_COMM_Result=new SP_DDM_ST_3_COMM_Result();
				logger.info("in DDM_CUS_1 action objArray[0]--"+objArray[0]+"--objArray[1]--"+objArray[1]);
				StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_3_COMM");
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				if(null!=objArray[0] && objArray[0]!=null) {
				query.setParameter(1, (String) objArray[0]);}
				query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				if(null!=objArray[0] && objArray[0]!=null) {
				query.setParameter(2, (String) objArray[1]);}
				query.execute();
				return sp_DDM_ST_3_COMM_Result.SP_DDM_ST_3_COMM_Result((List<Object[]>)query.getResultList());
			}
			
			
			
			
			
			public  List<SP_DDM_ST_3_COMM_TEMP_REPORT_Result> generateResultBean_SP_DDM_ST_3_COMM_TEMP_REPORT_Result(Object[] objArray) {
				SP_DDM_ST_3_COMM_TEMP_REPORT_Result sp_DDM_ST_3_COMM_TEMP_REPORT_Result=new SP_DDM_ST_3_COMM_TEMP_REPORT_Result();
				logger.info("in DDM_CE_1  objArray[0]--"+objArray[0]);
				logger.info("in DDM_CE_1  objArray[1]--"+objArray[1]+"--objArray[2]--"+objArray[2]);
				logger.info("in DDM_CE_1  objArray[3]--"+objArray[3]+"--objArray[4]--"+objArray[4]);
				StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_ST_3_COMM_TEMP_REPORT");
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
					return sp_DDM_ST_3_COMM_TEMP_REPORT_Result.SP_DDM_ST_3_COMM_TEMP_Report_Result((List<Object[]>)query.getResultList());
			}
		

}
