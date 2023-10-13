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
import com.ddm.cbic.model.SP_LIST_REGION_Result;

@Repository
public class SP_LIST_REGION_DaoImpl {
	
	@Autowired
	private EntityManager em;
	private SP_LIST_REGION_Result sp_LIST_REGION_Result = new SP_LIST_REGION_Result();
	
	public  List<SP_LIST_REGION_Result > generateResultBeanList() {	
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LIST_REGION");
	query.execute();
	
	return sp_LIST_REGION_Result.generateResultBeanList(query.getResultList());
	}
	finally {
		em.close();		
	}
	
}

}
