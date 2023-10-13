
package com.ddm.cbic.dao.implementation;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_ALL_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_TEMP_WITH_OUT_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_MAX_DATE_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_REGION_Result;

@Repository
public class SP_DDM_GST_4_DaoImpl {

	private static final Logger logger = LoggerFactory.getLogger(SP_DDM_GST_4_DaoImpl.class);

	@Autowired
	private EntityManager em;

	private SP_DDM_GST_4_REGION_Result sp_DDM_GST_4_REGION_Result = new SP_DDM_GST_4_REGION_Result();

	@SuppressWarnings("unchecked")
	public SP_DDM_GST_4_REGION_Result generateResultList_SP_DDM_GST_4_REGION(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_REGION");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		if (null != objArray[0] && objArray[0] != null) {
			query.setParameter(1, objArray[0].toString());
		}
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if (null != objArray[1] && objArray[1] != null) {
			query.setParameter(2, objArray[1].toString());
		}
		query.execute();
		return sp_DDM_GST_4_REGION_Result
				.generateResultBean_SP_DDM_GST_4_REGION((Object[]) query.getResultList().get(0));
	}

	private SP_DDM_GST_4_MAX_DATE_Result sp_DDM_GST_4_MAX_DATE_Result = new SP_DDM_GST_4_MAX_DATE_Result();

	@SuppressWarnings("unchecked")

	public List<SP_DDM_GST_4_MAX_DATE_Result> generateResultList_SP_DDM_GST_4_MAX_DATE(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, objArray[0].toString());
		query.execute();
		return sp_DDM_GST_4_MAX_DATE_Result.generateResultList_SP_DDM_GST_4_MAX_DATE(query.getResultList());
	}

	public Object generateResultBean_SP_DDM_GST_4_MAX_DATE(Object[] objArray) {
		System.out.println("objArray--> " + objArray[0]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_MAX_DATE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, objArray[0].toString());
		query.execute();
		return query.getResultList().get(0);
	}

	/*
	 * private SP_DDM_GST_4_ALL_Result sp_SP_DDM_GST_4_ALL_Result = new
	 * SP_DDM_GST_4_ALL_Result();
	 * 
	 * public SP_DDM_GST_4_ALL_Result generateResultBean_SP_DDM_GST_4_ALL(Object[]
	 * objArray) { StoredProcedureQuery query =
	 * em.createStoredProcedureQuery("SP_DDM_GST_4_ALL");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * if(null!=objArray[0] && objArray[0]!=null) { query.setParameter(1,
	 * objArray[0].toString());} query.execute(); return
	 * sp_SP_DDM_GST_4_ALL_Result.generateResultBean_SP_DDM_GST_4_ALL((Object[])
	 * query.getResultList().get(0)); }
	 * 
	 * 
	 * private SP_DDM_GST_4_ZONE_Result sp_DDM_GST_4_ZONE_Result =new
	 * SP_DDM_GST_4_ZONE_Result(); public SP_DDM_GST_4_ZONE_Result
	 * generateResultBean_SP_DDM_GST_4_ZONE(Object[] objArray) {
	 * StoredProcedureQuery query =
	 * em.createStoredProcedureQuery("SP_DDM_GST_4_ZONE");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * if(null!=objArray[0] && objArray[0]!=null) { query.setParameter(1,
	 * objArray[0].toString());} query.registerStoredProcedureParameter(2,
	 * String.class, ParameterMode.IN); if(null!=objArray[1] && objArray[1]!=null) {
	 * query.setParameter(2, objArray[1].toString());} query.execute(); return
	 * sp_DDM_GST_4_ZONE_Result.generateResultBean_SP_DDM_GST_4_ZONE((Object[])
	 * query.getResultList().get(0)); }
	 * 
	 * private SP_DDM_GST_4_COMM_Result sp_DDM_GST_4_COMM_Result=new
	 * SP_DDM_GST_4_COMM_Result(); public SP_DDM_GST_4_COMM_Result
	 * generateResultBean_SP_DDM_GST_4_COMM(Object[] objArray) {
	 * System.out.println("in DDM_GST_4 action objArray[0]--"+objArray[0]+
	 * "--objArray[1]--"+objArray[1]); StoredProcedureQuery query =
	 * em.createStoredProcedureQuery("SP_DDM_GST_4_COMM");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * if(null!=objArray[0] && objArray[0]!=null) { query.setParameter(1,
	 * objArray[0].toString());} query.registerStoredProcedureParameter(2,
	 * String.class, ParameterMode.IN); if(null!=objArray[0] && objArray[0]!=null) {
	 * query.setParameter(2, objArray[1].toString());} query.execute(); return
	 * sp_DDM_GST_4_COMM_Result.generateResultBean_SP_DDM_GST_4_COMM((Object[])
	 * query.getResultList().get(0)); }
	 * 
	 * 
	 * SP_DDM_GST_4_COMM_TEMP_REPORT_Result sp_DDM_GST_4_COMM_TEMP_REPORT_Result=new
	 * SP_DDM_GST_4_COMM_TEMP_REPORT_Result();
	 * 
	 * public SP_DDM_GST_4_COMM_TEMP_REPORT_Result
	 * generateResultBean_SP_DDM_GST_4_COMM_TEMP_REPORT(Object[] objArray) {
	 * System.out.println("in DDM_GST_4 action objArray[0]--"+objArray[0]+
	 * "--objArray[1]--"+objArray[1]); StoredProcedureQuery query =
	 * em.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP_REPORT");
	 * query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	 * if(null!=objArray[0] && objArray[0]!=null) { query.setParameter(1,
	 * objArray[0].toString());}
	 * 
	 * query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	 * if(null!=objArray[1] && objArray[1]!=null) { query.setParameter(2,
	 * objArray[1].toString());}
	 * 
	 * 
	 * query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
	 * if(null!=objArray[2] && objArray[2]!=null) { query.setParameter(3,
	 * objArray[2].toString());}
	 * 
	 * query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
	 * if(null!=objArray[3] && objArray[3]!=null) { query.setParameter(4,
	 * objArray[3].toString());}
	 * 
	 * query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
	 * if(null!=objArray[4] && objArray[4]!=null) { query.setParameter(5,
	 * objArray[4].toString());} query.execute(); return
	 * sp_DDM_GST_4_COMM_TEMP_REPORT_Result.
	 * generateResultBean_SP_DDM_GST_4_COMM_TEMP_REPORT((Object[])
	 * query.getResultList().get(0)); }
	 */

	private SP_DDM_GST_4_COMM_TEMP_Result sp_DDM_GST_4_COMM_TEMP_Result = new SP_DDM_GST_4_COMM_TEMP_Result();

	@SuppressWarnings("unchecked")

	public SP_DDM_GST_4_COMM_TEMP_WITH_OUT_Result generateResultList_SP_DDM_GST_4_COMM_TEMP(Object[] objArray) {
		SP_DDM_GST_4_COMM_TEMP_WITH_OUT_Result sp_DDM_GST_4_COMM_TEMP_WITH_OUT_Result = new SP_DDM_GST_4_COMM_TEMP_WITH_OUT_Result();
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP");

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, objArray[1].toString());
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, objArray[2].toString());
//		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
//		query.setParameter(4,  objArray[3].toString());
//		query.execute();

		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT).toString();
		query.execute();
		String out = query.getOutputParameterValue(4).toString();
		sp_DDM_GST_4_COMM_TEMP_WITH_OUT_Result.setOut(out);
		sp_DDM_GST_4_COMM_TEMP_WITH_OUT_Result
				.setLst(sp_DDM_GST_4_COMM_TEMP_Result.generateResultBeanList(query.getResultList()));
		return sp_DDM_GST_4_COMM_TEMP_WITH_OUT_Result;
	}

//Object

	private SP_DDM_GST_4_COMM_TEMP_Result SP_DDM_GST_4_COMM_TEMP_Result = new SP_DDM_GST_4_COMM_TEMP_Result();

	public SP_DDM_GST_4_COMM_TEMP_WITH_OUT_Result generateResultBean_SP_DDM_GST_4_COMM_TEMP(Object[] objArray,
			HttpServletRequest request) {
		SP_DDM_GST_4_COMM_TEMP_WITH_OUT_Result sp_DDM_GST_4_COMM_TEMP_WITH_OUT_Result = new SP_DDM_GST_4_COMM_TEMP_WITH_OUT_Result();
		System.out.println("objArray--> " + objArray[0]);
		System.out.println("objArray--> " + objArray[1]);
		System.out.println("objArray--> " + objArray[2]);
		System.out.println("objArray--> " + objArray[3]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP");

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, objArray[0].toString());

		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

		if (null != objArray[1] && objArray[1] != null) {
			query.setParameter(2, objArray[1].toString());
		}

		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, objArray[2].toString());

		query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
		query.execute();
		String out = query.getOutputParameterValue(4).toString();
		sp_DDM_GST_4_COMM_TEMP_WITH_OUT_Result.setOut(out);
		sp_DDM_GST_4_COMM_TEMP_WITH_OUT_Result
				.setLst(sp_DDM_GST_4_COMM_TEMP_Result.generateResultBeanList(query.getResultList()));
		return sp_DDM_GST_4_COMM_TEMP_WITH_OUT_Result;
	}

	public String generateResultBeanSP_DDM_GST_4_INSERT(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_INSERT");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, objArray[1].toString());
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, objArray[2].toString());
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, objArray[3].toString());
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, objArray[4].toString());
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, objArray[5].toString());
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, objArray[6].toString());
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, objArray[7].toString());
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, objArray[8].toString());
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, objArray[9].toString());
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, objArray[10].toString());

		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		if (null != objArray[11]) {
			query.setParameter(12, objArray[11].toString());
		}

		query.registerStoredProcedureParameter(13, String.class, ParameterMode.OUT);
		query.execute();
		String out = query.getOutputParameterValue(13).toString();
		return out;
		// return query.execute();

		// return query.execute();
	}

	public String generateResultBean_SP_DDM_GST_4_UPDATE(Object[] objArray) {

		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_UPDATE");

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, objArray[0].toString());
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, objArray[1].toString());
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.setParameter(3, objArray[2].toString());
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(4, objArray[3].toString());
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, objArray[4].toString());
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.setParameter(6, objArray[5].toString());
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(7, objArray[6].toString());
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.setParameter(8, objArray[7].toString());
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.setParameter(9, objArray[8].toString());
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.setParameter(10, objArray[9].toString());
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.setParameter(11, objArray[10].toString());
		query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query.setParameter(12, objArray[11].toString());

		query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		if (null != objArray[12]) {
			query.setParameter(13, objArray[12].toString());
		}

		query.registerStoredProcedureParameter(14, String.class, ParameterMode.OUT);
		query.execute();
		String out = query.getOutputParameterValue(14).toString();
		return out;

	}

	private SP_DDM_GST_4_REGION_Result sp_SP_DDM_GST_4_REGION_Result = new SP_DDM_GST_4_REGION_Result();
	private SP_DDM_GST_4_ALL_Result sp_SP_DDM_GST_4_ALL_Result = new SP_DDM_GST_4_ALL_Result();

	public List<SP_DDM_GST_4_REGION_Result> generateResultBeanList_SP_DDM_GST_4_REGION(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_REGION");
		System.out.println("objArray[0]--> " + objArray[0]);
		System.out.println("objArray[1]--> " + objArray[1]);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_GST_4_REGION_Result.SP_DDM_GST_4_REGION_Result(query.getResultList());
	}

	public SP_DDM_GST_4_REGION_Result generateResultBean_SP_DDM_GST_4_REGION(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_REGION");
		System.out.println("objArray[0]--> " + objArray[0]);
		System.out.println("objArray[1]--> " + objArray[1]);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_GST_4_REGION_Result
				.generateResultBean_SP_DDM_GST_4_REGION((Object[]) query.getResultList().get(0));
	}

	public List<SP_DDM_GST_4_ALL_Result> generateResultBeanList_SP_DDM_GST_4_ALL(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.execute();
		return sp_SP_DDM_GST_4_ALL_Result.SP_DDM_GST_4_ALL_Result(query.getResultList());
	}

	public SP_DDM_GST_4_ALL_Result generateResultBean_SP_DDM_GST_4_ALL(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_ALL");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.execute();
		return sp_SP_DDM_GST_4_ALL_Result.generateResultBean_SP_DDM_GST_4_ALL((Object[]) query.getResultList().get(0));
	}

	private SP_DDM_GST_4_ZONE_Result sp_SP_DDM_GST_4_ZONE_Result = new SP_DDM_GST_4_ZONE_Result();

	public List<SP_DDM_GST_4_ZONE_Result> generateResultBeanList_SP_DDM_GST_4_ZONE(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_ZONE");
		System.out.println("objArray[0]--> " + objArray[0]);
		System.out.println("objArray[1]--> " + objArray[1]);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_GST_4_ZONE_Result.SP_DDM_GST_4_ZONE_Result(query.getResultList());
	}

	public SP_DDM_GST_4_ZONE_Result generateResultBean_SP_DDM_GST_4_ZONE(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_ZONE");
		System.out.println("objArray[0]--> " + objArray[0]);
		System.out.println("objArray[1]--> " + objArray[1]);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		return sp_SP_DDM_GST_4_ZONE_Result
				.generateResultBean_SP_DDM_GST_4_ZONE((Object[]) query.getResultList().get(0));
	}

	public SP_DDM_GST_4_COMM_TEMP_Result generateResultBean_SP_DDM_GST_4_COMM_TEMP1(Object[] objArray,
			HttpServletRequest request) {
		try {
			SP_DDM_GST_4_COMM_TEMP_Result sp_DDM_GST_4_COMM_TEMP_Result = new SP_DDM_GST_4_COMM_TEMP_Result();
			System.out.println("objArray--> " + objArray[0]);
			System.out.println("objArray--> " + objArray[1]);
			System.out.println("objArray--> " + objArray[2]);
			// System.out.println("objArray--> "+objArray[3]);
			StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP");

			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			if (null != objArray[0] && objArray[0] != null) {
				query.setParameter(1, (String) objArray[0]);
			}
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			if (null != objArray[1] && objArray[1] != null) {
				query.setParameter(2, (String) objArray[1]);
			}
			query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			if (null != objArray[2] && objArray[2] != null) {
				query.setParameter(3, (String) objArray[2]);
			}
			query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);

			query.execute();
			String out = (String) query.getOutputParameterValue(4);
			logger.info("--out--" + out);
			request.getSession().setAttribute("_Result", out);
			return sp_DDM_GST_4_COMM_TEMP_Result
					.generateResultBean_SP_DDM_GST_4_COMM_TEMP((Object[]) query.getResultList().get(0));
		} finally {
			em.close();
		}
	}

	private SP_DDM_GST_4_COMM_Result sp_SP_DDM_GST_4_COMM_Result = new SP_DDM_GST_4_COMM_Result();

	public List<SP_DDM_GST_4_COMM_TEMP_REPORT_Result> generateResultBeanList_SP_DDM_GST_4_COMM_TEMP_REPORT(
			Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP_REPORT");
		System.out.println("objArray0--> " + objArray[0]);
		System.out.println("objArray1--> " + objArray[1]);
		System.out.println("objArray2--> " + objArray[2]);
		System.out.println("objArray3--> " + objArray[3]);
		System.out.println("objArray4--> " + objArray[4]);

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);

		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if (null != objArray[1] && objArray[1] != null) {
			query.setParameter(2, (String) objArray[1]);
		}

		// query.setParameter(2,(String) objArray[1]);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != objArray[2] && objArray[2] != null) {
			query.setParameter(3, (String) objArray[2]);
		}
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

		if (null != objArray[3] && objArray[3] != null) {
			query.setParameter(4, (String) objArray[3]);
		}
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, (String) objArray[4]);
		query.execute();
		return sp_SP_DDM_GST_4_COMM_TEMP_REPORT_Result.SP_DDM_GST_4_COMM_TEMP_REPORT_Result(query.getResultList());
	}

	private SP_DDM_GST_4_COMM_TEMP_REPORT_Result sp_SP_DDM_GST_4_COMM_TEMP_REPORT_Result = new SP_DDM_GST_4_COMM_TEMP_REPORT_Result();

	public SP_DDM_GST_4_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_GST_4_COMM_TEMP_REPORT(Object[] objArray) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_COMM_TEMP_REPORT");
		System.out.println("objArray0--> " + objArray[0]);
		System.out.println("objArray1--> " + objArray[1]);
		System.out.println("objArray2--> " + objArray[2]);
		System.out.println("objArray3--> " + objArray[3]);
		System.out.println("objArray4--> " + objArray[4]);

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);

		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		if (null != objArray[1] && objArray[1] != null) {
			query.setParameter(2, (String) objArray[1]);
		}

		// query.setParameter(2,(String) objArray[1]);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		if (null != objArray[2] && objArray[2] != null) {
			query.setParameter(3, (String) objArray[2]);
		}
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

		if (null != objArray[3] && objArray[3] != null) {
			query.setParameter(4, (String) objArray[3]);
		}
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(5, (String) objArray[4]);
		query.execute();
		return sp_SP_DDM_GST_4_COMM_TEMP_REPORT_Result
				.generateResultBean_SP_DDM_GST_4_COMM_TEMP_REPORT((Object[]) query.getResultList().get(0));
	}

	public List<SP_DDM_GST_4_COMM_Result> generateResultBeanList_SP_DDM_GST_4_COMM(Object[] objArray) {
		System.out.println("in DDM_CUS_4 action objArray[0]--" + objArray[0] + "--objArray[1]--" + objArray[1]);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DDM_GST_4_COMM");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, (String) objArray[0]);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(2, (String) objArray[1]);
		query.execute();
		// return
		// sp_SP_DDM_GST_4_COMM_Result.SP_DDM_GST_4_COMM_Result(query.getResultList());

		if (query.getResultList().size() > 0) {
			return sp_SP_DDM_GST_4_COMM_Result.SP_DDM_GST_4_COMM_Result((query.getResultList()));
		} else {
			return null;
		}

	}

}
