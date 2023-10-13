package com.ddm.cbic.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository
public class SP_USER_LOGIN_LOG_HISTORY_DaoImpl {
	@Autowired
	private EntityManager em;

public  boolean  executeProc(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_USER_LOGIN_LOG_HISTORY");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	query.setParameter(3,(String)objArray[2] );
	query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	query.setParameter(4,(String)objArray[3] );
	query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	query.setParameter(5,(String)objArray[4] );
	query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
	query.setParameter(6,(String)objArray[5] );
	query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
	query.setParameter(7,(String)objArray[6] );
	
	return query.execute();
	}
	finally {
		em.close();
		
	}
}



}

