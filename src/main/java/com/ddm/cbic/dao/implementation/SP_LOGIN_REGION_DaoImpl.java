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
import com.ddm.cbic.model.SP_LOGIN_REGION_Result;

@Repository
public class SP_LOGIN_REGION_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_LOGIN_REGION_Result sp_LOGIN_REGION_Result = new SP_LOGIN_REGION_Result();
	public  List<SP_LOGIN_REGION_Result > generateResultBeanList(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN_REGION");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.execute();
	return sp_LOGIN_REGION_Result.generateResultBeanList(query.getResultList());
	}
	finally {
		em.close();
		
	}
}

public  SP_LOGIN_REGION_Result  generateResultBean(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN_REGION");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.execute();
	return sp_LOGIN_REGION_Result.generateResultBean((Object[])query.getResultList().get(0));
	}
	finally {
		em.close();
		
	}
}

public  boolean  executeProc(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN_REGION");
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
	return  sp_LOGIN_REGION_Result.generateResultBeanLabels();
}

}
