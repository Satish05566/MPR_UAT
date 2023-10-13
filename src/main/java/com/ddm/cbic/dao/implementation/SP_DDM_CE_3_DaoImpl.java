
package com.ddm.cbic.dao.implementation;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.model.SP_DDM_CE_3_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CE_3_COMM_TEMP_WITH_OUT_Result;
import com.ddm.cbic.model.SP_DDM_CE_3_COMM_TEMP_LST_WITH_OUT_Result;
import com.ddm.cbic.model.SP_DDM_CE_3_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CE_3_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CE_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CE_3_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_CE_3_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_CE_3_REGION_Result;

@Repository
public class SP_DDM_CE_3_DaoImpl {

	private static final Logger logger = LoggerFactory.getLogger(SP_DDM_CE_3_DaoImpl.class);

	@Autowired
	private EntityManager em;

	public String generateResultBean_SP_MPR_CHECK_VALIDATE_UPTO(Object[] objArray) {
		System.out.println("objArray--> " + objArray[0]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_MPR_CHECK_VALIDATE_UPTO");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,  objArray[1]);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3,  objArray[2]);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
		query.execute();
		String out =  query.getOutputParameterValue(4).toString();
		return out;
	}

	public boolean generateResultBean_SP_SUBMIT_LOG_UPTO_SELECT(Object[] objArray) {
		System.out.println("objArray--> " + objArray[0]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_SUBMIT_LOG_UPTO_SELECT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2,  objArray[1]);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3,  objArray[2]);
		return query.execute();

	}

	private List<SP_DDM_CE_3_REGION_Result> sp_DDM_CE_3_REGION_Result = new ArrayList<SP_DDM_CE_3_REGION_Result>();

	@SuppressWarnings("unchecked")
	public List<SP_DDM_CE_3_REGION_Result> generateResultList_SP_DDM_CE_3_REGION(Object[] objArray) {
		SP_DDM_CE_3_REGION_Result sp_DDM_CE_3_REGION_Result = new SP_DDM_CE_3_REGION_Result();
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_3_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != objArray[0] && objArray[0] != null) {
			query.setParameter(1,  objArray[0]);
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if (null != objArray[1] && objArray[1] != null) {
			query.setParameter(2,  objArray[1]);
		}
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_DDM_CE_3_REGION_Result.generateResultList_SP_DDM_CE_3_REGION((List<Object[]>)query.getResultList());
		}
		else {
			return new ArrayList<SP_DDM_CE_3_REGION_Result>();
		}
	}

	private SP_DDM_CE_3_MAX_DATE_Result sp_DDM_CE_3_MAX_DATE_Result = new SP_DDM_CE_3_MAX_DATE_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_CE_3_MAX_DATE_Result> generateResultList_SP_DDM_CE_3_MAX_DATE(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_3_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0]);
		query.execute();
		return sp_DDM_CE_3_MAX_DATE_Result.generateResultList_SP_DDM_CE_3_MAX_DATE(query.getResultList());
	}

	public Object generateResultBean_SP_DDM_CE_3_MAX_DATE(Object[] objArray) {
		System.out.println("objArray--> " + objArray[0]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_3_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0]);
		query.execute();
		return query.getResultList().get(0);
	}

	private List<SP_DDM_CE_3_ALL_Result> sp_list_SP_DDM_CE_3_ALL_Result = new ArrayList<SP_DDM_CE_3_ALL_Result>();

	public List<SP_DDM_CE_3_ALL_Result> generateResultBean_SP_DDM_CE_3_ALL(Object[] objArray) {
		SP_DDM_CE_3_ALL_Result sp_DDM_CE_3_ALL_Result = new SP_DDM_CE_3_ALL_Result();
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_3_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != objArray[0] && objArray[0] != null) {
			query.setParameter(1,  objArray[0]);
		}
		query.execute();
		if(query.getResultList().size() > 0) {
			
			return sp_DDM_CE_3_ALL_Result.generateResultList_SP_DDM_CE_3_ALL((List<Object[]>)query.getResultList());
		}
		else {
			return new ArrayList<SP_DDM_CE_3_ALL_Result>();
		}
	}

	private List<SP_DDM_CE_3_ZONE_Result> sp_list_DDM_CE_3_ZONE_Result = new ArrayList<SP_DDM_CE_3_ZONE_Result>();

	public List<SP_DDM_CE_3_ZONE_Result> generateResultBean_SP_DDM_CE_3_ZONE(Object[] objArray) {
		SP_DDM_CE_3_ZONE_Result sp_DDM_CE_3_ZONE_Result = new SP_DDM_CE_3_ZONE_Result();
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_3_ZONE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != objArray[0] && objArray[0] != null) {
			query.setParameter(1,  objArray[0]);
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if (null != objArray[1] && objArray[1] != null) {
			query.setParameter(2,  objArray[1]);
		}
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_DDM_CE_3_ZONE_Result.generateResultList_SP_DDM_CE_3_ZONE((List<Object[]>)query.getResultList());
		}
		else {
			return new ArrayList<SP_DDM_CE_3_ZONE_Result>();
		}
	}

	private List<SP_DDM_CE_3_COMM_Result> sp_list_DDM_CE_3_COMM_Result = new ArrayList<SP_DDM_CE_3_COMM_Result>();

	public List<SP_DDM_CE_3_COMM_Result> generateResultBean_SP_DDM_CE_3_COMM(Object[] objArray) {
		SP_DDM_CE_3_COMM_Result sp_DDM_CE_3_COMM_Result = new SP_DDM_CE_3_COMM_Result();
		System.out.println("in DDM_CE_3 action objArray[0]--" + objArray[0] + "--objArray[1]--" + objArray[1]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_3_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != objArray[0] && objArray[0] != null) {
			query.setParameter(1,  objArray[0]);
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if (null != objArray[0] && objArray[0] != null) {
			query.setParameter(2,  objArray[1]);
		}
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_DDM_CE_3_COMM_Result.generateResultList_SP_DDM_CE_3_COMM((List<Object[]>)query.getResultList());
		}
		else {
			return new ArrayList<SP_DDM_CE_3_COMM_Result>();
		}
	}

	List<SP_DDM_CE_3_COMM_TEMP_REPORT_Result> sp_list_DDM_CE_3_COMM_TEMP_REPORT_Result = new ArrayList<SP_DDM_CE_3_COMM_TEMP_REPORT_Result>();

	public List<SP_DDM_CE_3_COMM_TEMP_REPORT_Result> generateResultBean_SP_DDM_CE_3_COMM_TEMP_REPORT(Object[] objArray) {
		SP_DDM_CE_3_COMM_TEMP_REPORT_Result sp_DDM_CE_3_COMM_TEMP_REPORT_Result = new SP_DDM_CE_3_COMM_TEMP_REPORT_Result();
		System.out.println("in DDM_CE_3 action objArray[0]--" + objArray[0] + "--objArray[1]--" + objArray[1]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_3_COMM_TEMP_REPORT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != objArray[0] && objArray[0] != null) {
			query.setParameter(1,  objArray[0]);
		}

		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if (null != objArray[1] && objArray[1] != null) {
			query.setParameter(2,  objArray[1]);
		}

		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != objArray[2] && objArray[2] != null) {
			query.setParameter(3,  objArray[2]);
		}

		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		if (null != objArray[3] && objArray[3] != null) {
			query.setParameter(4,  objArray[3]);
		}

		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		if (null != objArray[4] && objArray[4] != null) {
			query.setParameter(5,  objArray[4]);
		}
		query.execute();
		if(query.getResultList().size() > 0) {
		return sp_DDM_CE_3_COMM_TEMP_REPORT_Result
				.generateResultList_SP_DDM_CE_3_COMM_TEMP_REPORT((List<Object[]>)query.getResultList());
		}
		else {
			return new ArrayList<SP_DDM_CE_3_COMM_TEMP_REPORT_Result>();
		}
	}

	private SP_DDM_CE_3_COMM_TEMP_Result sp_DDM_CE_3_COMM_TEMP_Result = new SP_DDM_CE_3_COMM_TEMP_Result();

	@SuppressWarnings("unchecked")

	public SP_DDM_CE_3_COMM_TEMP_LST_WITH_OUT_Result generateResultList_SP_DDM_CE_3_COMM_TEMP(Object[] objArray) {
		SP_DDM_CE_3_COMM_TEMP_LST_WITH_OUT_Result sp_DDM_CE_3_COMM_TEMP_LST_WITH_OUT_Result = new SP_DDM_CE_3_COMM_TEMP_LST_WITH_OUT_Result();
		 StoredProcedureQuery query =em.createStoredProcedureQuery("SP_DDM_CE_3_COMM_TEMP");
		  
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  if(null!=objArray[0]) {query.setParameter(1,objArray[0].toString() );} 
		  
		  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		  
		  if(null!=objArray[1]) { query.setParameter(2,objArray[1] );} 
		  
		 			  
		  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		  if(null!=objArray[2]) {query.setParameter(3,objArray[2] ); }
		  
			  
		  query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);		  
		  query.execute(); 
		  String out = query.getOutputParameterValue(4).toString();
		  logger.info("--out--"+out);
		  //request.getSession().setAttribute("_Result", out);
		  sp_DDM_CE_3_COMM_TEMP_LST_WITH_OUT_Result.setOut(out);
		  sp_DDM_CE_3_COMM_TEMP_Result.generateResultList_SP_DDM_CE_3_COMM_TEMP(query.getResultList());
		  if(query.getResultList().size() > 0) {
			  sp_DDM_CE_3_COMM_TEMP_LST_WITH_OUT_Result.setLst(sp_DDM_CE_3_COMM_TEMP_Result.generateResultList_SP_DDM_CE_3_COMM_TEMP(query.getResultList()));
			   return sp_DDM_CE_3_COMM_TEMP_LST_WITH_OUT_Result;
		  }
			else {
				return sp_DDM_CE_3_COMM_TEMP_LST_WITH_OUT_Result;
			}
	}

//Object

	private SP_DDM_CE_3_COMM_TEMP_Result SP_DDM_CE_3_COMM_TEMP_Result = new SP_DDM_CE_3_COMM_TEMP_Result();

	public SP_DDM_CE_3_COMM_TEMP_WITH_OUT_Result generateResultBean_SP_DDM_CE_3_COMM_TEMP(Object[] objArray,
			HttpServletRequest request) {
		SP_DDM_CE_3_COMM_TEMP_WITH_OUT_Result sp_DDM_CE_3_COMM_TEMP_WITH_OUT_Result = new SP_DDM_CE_3_COMM_TEMP_WITH_OUT_Result();
		System.out.println("objArray--> " + objArray[0]);
		System.out.println("objArray--> " + objArray[1]);
		System.out.println("objArray--> " + objArray[2]);
		System.out.println("objArray--> " + objArray[3]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_3_COMM_TEMP");

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,  objArray[0]);

		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

		if (null != objArray[1] && objArray[1] != null) {
			query.setParameter(2,  objArray[1]);
		}

		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3,  objArray[2]);

		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
		query.execute();
		String out =  query.getOutputParameterValue(4).toString();
		logger.info("--out--" + out);
		//request.getSession().setAttribute("_Result", out);
		sp_DDM_CE_3_COMM_TEMP_WITH_OUT_Result.setOut(out);
		sp_DDM_CE_3_COMM_TEMP_WITH_OUT_Result.setSp_DDM_CE_3_COMM_TEMP_Result(null);
		if(query.getResultList().size() > 0) {
		
		sp_DDM_CE_3_COMM_TEMP_WITH_OUT_Result.setSp_DDM_CE_3_COMM_TEMP_Result(SP_DDM_CE_3_COMM_TEMP_Result
				.generateResultBean_SP_DDM_CE_3_COMM_TEMP((Object[]) query.getResultList().get(0)));
		return sp_DDM_CE_3_COMM_TEMP_WITH_OUT_Result;
		}
		else {
			return sp_DDM_CE_3_COMM_TEMP_WITH_OUT_Result;
		}

	}

	public String generateResultBeanSP_DDM_CE_3_INSERT(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_3_INSERT");
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
		
		//query.registerStoredProcedureParameter(15, String.class, ParameterMode.OUT);
		query.execute();
		// String out =  query.getOutputParameterValue(15).toString();
		String out = "RECORD SUBMITTED";
		return out;
		// return query.execute();

	}

	public String generateResultBean_SP_DDM_CE_3_UPDATE(Object[] objArray) {

		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_CE_3_TEMP_UPDATE");

		System.out.println("objArray[0]--> " + objArray[0]);
		System.out.println("objArray[1]--> " + objArray[1]);
		System.out.println("objArray[2]--> " + objArray[2]);
		System.out.println("objArray[3]--> " + objArray[3]);

		System.out.println("objArray[4]--> " + objArray[4]);
		System.out.println("objArray[5]--> " + objArray[5]);
		System.out.println("objArray[6]--> " + objArray[6]);
		System.out.println("objArray[7]--> " + objArray[7]);

		System.out.println("objArray[8]--> " + objArray[8]);
		System.out.println("objArray[9]--> " + objArray[9]);
		System.out.println("objArray[10]--> " + objArray[10]);
		System.out.println("objArray[11]--> " + objArray[11]);

		System.out.println("objArray[12]--> " + objArray[12]);
		System.out.println("objArray[13]--> " + objArray[13]);
		System.out.println("objArray[14]--> " + objArray[14]);
		System.out.println("objArray[15]--> " + objArray[15]);

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
		
		//query.registerStoredProcedureParameter(16, String.class, ParameterMode.OUT);
		boolean  ret =query.execute();
		logger.info(" boolean  ret =query.execute() "+ ret );
		String out =  "RECORD UPDATED";
		return out;
		// return query.execute();

	}

}
