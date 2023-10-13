package com.ddm.cbic.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;

import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SP_SUBMISSION_DLA_CUS_GST_DaoImpl {
	@Autowired
	private EntityManager em;
	
	public  String generateResult(String comm_code,String user ,String remoteAddr,String Report_Group){

	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_SUBMISSION_DLA_CUS_GST");
	
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	if(null!=comm_code) {	query.setParameter(1,comm_code );}
	
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	if(null!=user) {query.setParameter(2,user );}
	
	query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	if(null!=remoteAddr) {query.setParameter(3,remoteAddr );}
	
	query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	if(null!=Report_Group) {query.setParameter(4,Report_Group );}
	
	query.registerStoredProcedureParameter(5,String.class,ParameterMode.OUT);
	query.execute();
	String p_RESULT =(String) query.getOutputParameterValue(5);
	
	return p_RESULT;
}



}
