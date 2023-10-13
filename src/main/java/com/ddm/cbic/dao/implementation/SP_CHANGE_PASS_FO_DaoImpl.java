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
import com.ddm.cbic.model.SP_CHANGE_PASS_FO_Result;

@Repository
public class SP_CHANGE_PASS_FO_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_CHANGE_PASS_FO_Result sp_CHANGE_PASS_FO_Result = new SP_CHANGE_PASS_FO_Result();
	public  List<SP_CHANGE_PASS_FO_Result > generateResultBeanList(Object[] objArray){
		try {		
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_CHANGE_PASS_FO");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	query.setParameter(3,(String)objArray[2] );
	query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
	
	query.execute();
	String out =(String) query.getOutputParameterValue(4);
	List<Object []> listObjectArray = new ArrayList<Object []>();
	Object[] outParam =new Object[] {out}; 
	listObjectArray.add(outParam);
	return sp_CHANGE_PASS_FO_Result.generateResultBeanList(listObjectArray);
		}
		finally {
			em.close();
			
		}
}

public  SP_CHANGE_PASS_FO_Result  generateResultBean(Object[] objArray){
	try {		
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_CHANGE_PASS_FO");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	query.setParameter(3,(String)objArray[2] );
	query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
	
	query.execute();
	String out = (String)query.getOutputParameterValue(4);
	Object[] outParam =new Object[] {out}; 
	return sp_CHANGE_PASS_FO_Result.generateResultBean(outParam);
	}
	finally {
		em.close();
		
	}
}

public  boolean  executeProc(Object[] objArray){
	try {		
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_CHANGE_PASS_FO");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	query.setParameter(3,(String)objArray[2] );
	query.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
	query.setParameter(4,(String)objArray[3] );
	
	return query.execute();
	}
	finally {
		em.close();
		
	}
}

public  List<String>  generateResultBeanLabels(){
	return  sp_CHANGE_PASS_FO_Result.generateResultBeanLabels();
}

}
