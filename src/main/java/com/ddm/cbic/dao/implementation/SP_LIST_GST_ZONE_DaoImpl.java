package com.ddm.cbic.dao.implementation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.model.SP_GST_DDM_STATUS_Result;
import com.ddm.cbic.model.SP_GST_STATUS_Result;
import com.ddm.cbic.model.SP_LIST_GST_ZONE_Result;
import com.ddm.cbic.model.SP_STATUS_GST_FF_Result;

@Repository
public class SP_LIST_GST_ZONE_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_LIST_GST_ZONE_Result sp_LIST_GST_ZONE_Result = new SP_LIST_GST_ZONE_Result();
	
	public  List<SP_LIST_GST_ZONE_Result > generateResultBeanList(Object[] objArray) {
	
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LIST_GST_ZONE");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	if(null != objArray[0]) {
	query.setParameter(1,objArray[0].toString() );
	System.out.println("objArray[0].toString "+ objArray[0].toString());	
	}
	query.execute();
	
	return sp_LIST_GST_ZONE_Result.generateResultBeanList(query.getResultList());
	}
	finally {
		em.close();
		
	}
	
}

public  SP_LIST_GST_ZONE_Result  generateResultBean(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LIST_GST_ZONE");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.execute();
	return sp_LIST_GST_ZONE_Result.generateResultBean((Object[])query.getResultList().get(0));
	}
	finally {
		em.close();
		
	}
}

public List<SP_STATUS_GST_FF_Result> generateResultBean_SP_STATUS_GST_FF(Object[] objArray) {
	try {
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_STATUS_GST_FF");
	query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	if(null!=objArray[0] && objArray[0]!=null) {
	query.setParameter(1, (String) objArray[0]);}
	query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	if(null!=objArray[1] && objArray[1]!=null) {
	query.setParameter(2, (String) objArray[1]);}
	query.execute();
	return new SP_STATUS_GST_FF_Result().generateResultBeanList(query.getResultList());
	}
	finally {
		em.close();
	}
}

public List<SP_GST_STATUS_Result> generateResultBean_SP_GST_STATUS(Object[] objArray) {
	try {
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_GST_STATUS");
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
	
	query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
	if(null!=objArray[5] && objArray[5]!=null) {
		System.out.println("objArray[5]--"+objArray[5]);
	query.setParameter(6, (String) objArray[5]);}
	query.execute();
	return new SP_GST_STATUS_Result().generateResultBeanList(query.getResultList());
	}
	finally {
		em.close();
	}
}

public List<SP_GST_DDM_STATUS_Result> generateResultBean_SP_GST_DDM_STATUS(Object[] objArray) {
	try {
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_GST_DDM_STATUS");
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
	
	query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
	if(null!=objArray[5] && objArray[5]!=null) {
	query.setParameter(6, (String) objArray[5]);}
	query.execute();
	return new SP_GST_DDM_STATUS_Result().generateResultBeanList(query.getResultList());
	}
	finally {
		em.close();
	}
}

public  boolean  executeProc(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LIST_GST_ZONE");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	return query.execute();
	}
	finally {
		em.close();
		
	}
}

public  List<String>  generateResultBeanLabels(){
	return  sp_LIST_GST_ZONE_Result.generateResultBeanLabels();
}

}
