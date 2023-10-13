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
import com.ddm.cbic.model.SP_LOGIN_COMM_Result;

@Repository
public class SP_LOGIN_COMM_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_LOGIN_COMM_Result sp_LOGIN_COMM_Result = new SP_LOGIN_COMM_Result();
	public  List<SP_LOGIN_COMM_Result > generateResultBeanList(Object[] objArray){

	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN_COMM");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.execute();
	return sp_LOGIN_COMM_Result.generateResultBeanList(query.getResultList());
}

public  SP_LOGIN_COMM_Result  generateResultBean(Object[] objArray){
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN_COMM");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.execute();
	return sp_LOGIN_COMM_Result.generateResultBean((Object[])query.getResultList().get(0));
}

public  boolean  executeProc(Object[] objArray){
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN_COMM");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	return query.execute();
}

public  List<String>  generateResultBeanLabels(){
	return  sp_LOGIN_COMM_Result.generateResultBeanLabels();
}

}
