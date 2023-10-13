package com.ddm.cbic.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.model.SP_LIST_MIS_CBEC_USER_Result;


@Repository
public class SP_LIST_MIS_CBEC_USER_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_LIST_MIS_CBEC_USER_Result sp_LIST_MIS_CBEC_USER_Result = new SP_LIST_MIS_CBEC_USER_Result();
	public  List<SP_LIST_MIS_CBEC_USER_Result > generateResultBeanList(){
		try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LIST_MIS_CBEC_USER");
	
	query.execute();
	return sp_LIST_MIS_CBEC_USER_Result.generateResultBeanList(query.getResultList());
		}
		finally {
			em.close();
			
		}
}


}
