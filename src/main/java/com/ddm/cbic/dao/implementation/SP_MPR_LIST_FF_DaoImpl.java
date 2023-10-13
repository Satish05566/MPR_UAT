package com.ddm.cbic.dao.implementation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ddm.cbic.model.SP_MPR_GST_LIST_USER_Result;
import com.ddm.cbic.model.SP_MPR_LIST_FF_Result;

@Repository
public class SP_MPR_LIST_FF_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_MPR_LIST_FF_Result sp_MPR_LIST_FF_Result = new SP_MPR_LIST_FF_Result();
	@SuppressWarnings("unchecked")
	public  List<SP_MPR_LIST_FF_Result > generateResultBeanList(Object[] objArray){
		try {		
		System.out.println(" before  query.getResultList().size() ");
		
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_MPR_LIST_FF");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	if(null != objArray[0]) {System.out.println("  objArray[0].toString() " + objArray[0].toString());	query.setParameter(1,objArray[0].toString() );}
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	if(null != objArray[1]) {System.out.println("  objArray[1].toString() " + objArray[1].toString());	query.setParameter(2,objArray[1].toString() );}
	query.execute();
	
	System.out.println("  query.getResultList().size() ");
	System.out.println("  query.getResultList().size() " +  query.getResultList().size());
	return sp_MPR_LIST_FF_Result.generateResultBeanList(query.getResultList());
		}
		finally {
			em.close();
			
		}
}

public  SP_MPR_LIST_FF_Result  generateResultBean(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_MPR_LIST_FF");
	
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	if(null != objArray[0]) {System.out.println("  objArray[0].toString() " + objArray[0].toString());	query.setParameter(1,objArray[0].toString() );}
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	if(null != objArray[1]) {System.out.println("  objArray[1].toString() " + objArray[1].toString());	query.setParameter(2,objArray[1].toString() );}
	
	query.execute();
	return sp_MPR_LIST_FF_Result.generateResultBean((Object[])query.getResultList().get(0));
	}
	finally {
		em.close();
		
	}
}

public  boolean  executeProc(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_MPR_LIST_FF");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	
	return query.execute();
	}
	finally {
		em.close();
		
	}
}

public  List<String>  generateResultBeanLabels(){
	return  sp_MPR_LIST_FF_Result.generateResultBeanLabels();
}

}
