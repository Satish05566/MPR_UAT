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

import com.ddm.cbic.model.DINSearch;
import com.ddm.cbic.model.SP_LOGIN_Result;

@Repository
public class SP_LOGIN_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_LOGIN_Result sp_LOGIN_Result = new SP_LOGIN_Result();
	public  List<SP_LOGIN_Result > generateResultBeanList(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	query.setParameter(3,(String)objArray[2] );
	query.execute();
	return sp_LOGIN_Result.generateResultBeanList(query.getResultList());
	}
	finally {
		em.close();
		
	}
}

public  SP_LOGIN_Result  generateResultBean(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	query.setParameter(3,(String)objArray[2] );
	query.execute();
	return sp_LOGIN_Result.generateResultBean((Object[])query.getResultList().get(0));
	}
	finally {
		em.close();
		
	}
}

public  boolean  executeProc(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN");
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

public  List<String>  generateResultBeanLabels(){
	return  sp_LOGIN_Result.generateResultBeanLabels();
}

private DINSearch dinsearch = new DINSearch();

public  List<DINSearch> getDINSEARCH(String DRN_No,String ipAddress){
        StoredProcedureQuery query = em.createStoredProcedureQuery("SP_DRN_VIEW_PUBLICUSER");
        
        try {
        System.out.println("inside dao"+DRN_No);
        System.out.println("inside dao"+ipAddress);
        System.out.println("inside dao"+DRN_No);
        query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
        query.setParameter(1,DRN_No);
        query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
        query.setParameter(2,ipAddress);
        query.execute();
        System.out.println("inside dao====================="+query.getResultList());
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        return dinsearch.generateResultBeanList(query.getResultList());
        
        }

}


