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
import com.ddm.cbic.model.SP_LIST_COMM_Result;

@Repository
public class SP_LIST_COMM_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_LIST_COMM_Result sp_LIST_COMM_Result = new SP_LIST_COMM_Result();
	public  List<SP_LIST_COMM_Result > generateResultBeanList(Object[] objArray){
		try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LIST_COMM");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.execute();
	int noOfRecords = query.getMaxResults();
	System.out.println("noOfRecords " + noOfRecords);
	if(noOfRecords > 0)
	return sp_LIST_COMM_Result.generateResultBeanList(query.getResultList());
	else
	return null;	
		}
		finally {
			em.close();
			
		}
}

public  SP_LIST_COMM_Result  generateResultBean(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LIST_COMM");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.execute();
	return sp_LIST_COMM_Result.generateResultBean((Object[])query.getResultList().get(0));
	}
	finally {
		em.close();
		
	}
}

public  boolean  executeProc(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LIST_COMM");
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
	return  sp_LIST_COMM_Result.generateResultBeanLabels();
}

}
