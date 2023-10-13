package com.ddm.cbic.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.model.SP_LIST_GST_DIRECTORATE_Result;


@Repository
public class SP_LIST_GST_DIRECTORATE_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_LIST_GST_DIRECTORATE_Result sp_LIST_GST_DIRECTORATE_Result = new SP_LIST_GST_DIRECTORATE_Result();
	public  List<SP_LIST_GST_DIRECTORATE_Result > generateResultBeanList(){
		try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LIST_GST_DIRECTORATE");
	
	query.execute();
	return sp_LIST_GST_DIRECTORATE_Result.generateResultBeanList(query.getResultList());
		}
		finally {
			em.close();
			
		}
}


}
