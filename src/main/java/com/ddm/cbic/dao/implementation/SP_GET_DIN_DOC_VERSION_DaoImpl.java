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
import com.ddm.cbic.model.SP_GET_DIN_DOC_VERSION_Result;

@Repository
public class SP_GET_DIN_DOC_VERSION_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_GET_DIN_DOC_VERSION_Result sp_GET_DIN_DOC_VERSION_Result = new SP_GET_DIN_DOC_VERSION_Result();
	public  List<SP_GET_DIN_DOC_VERSION_Result > generateResultBeanList(Object[] objArray){
	
		System.out.println("before createStoredProcedureQuery");	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_GET_DIN_DOC_VERSION");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,objArray[0].toString() );
	
	System.out.println("before setParameter" + objArray[0].toString());
	
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,objArray[1].toString() );
	
	query.execute();
	
	return sp_GET_DIN_DOC_VERSION_Result.generateResultBeanList(query.getResultList());
		
}

public  SP_GET_DIN_DOC_VERSION_Result  generateResultBean(Object[] objArray){
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_GET_DIN_DOC_VERSION");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	
	query.execute();
	return sp_GET_DIN_DOC_VERSION_Result.generateResultBean((Object[])query.getResultList().get(0));
}

public  boolean  executeProc(Object[] objArray){
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_GET_DIN_DOC_VERSION");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	
	return query.execute();
}

public  List<String>  generateResultBeanLabels(){
	return  sp_GET_DIN_DOC_VERSION_Result.generateResultBeanLabels();
}

}





