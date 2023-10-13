package com.ddm.cbic.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.ddm.cbic.model.SP_CORRECTION_LIST_ZONE_GST_Result;

@Repository
public class SP_CORRECTION_LIST_ZONE_GST_DaoImpl {

private static final Logger logger = LoggerFactory.getLogger(SP_CORRECTION_LIST_ZONE_GST_DaoImpl.class);
	
	@Autowired
	private EntityManager em;
	
	
	private SP_CORRECTION_LIST_ZONE_GST_Result sp_CORRECTION_LIST_ZONE_GST_Result=new SP_CORRECTION_LIST_ZONE_GST_Result();
	@SuppressWarnings("unchecked")
	public  List<SP_CORRECTION_LIST_ZONE_GST_Result> generateResultBeanListSP_CORRECTION_LIST_ZONE_GST(Object[] objArray){

		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_CORRECTION_LIST_ZONE_GST");
		query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		if(null!=objArray[0] && objArray[0]!=null) {
		query.setParameter(1,(String)objArray[0] );}
		query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		if(null!=objArray[1] && objArray[1]!=null) {
		query.setParameter(2,(String)objArray[1] );}
		query.execute();
		return sp_CORRECTION_LIST_ZONE_GST_Result.generateResultBeanList(query.getResultList());
		
		}
	
	
	@Transactional
	@SuppressWarnings("unchecked")
	public  int generateResultBeanListSP_CORRECTION_VALIDATION(String p_COMM_CODE,String p_MM_YYYY,String p_SUBMISSION_DATE,String p_MPR){
        logger.info("p_COMM_CODE-->"+p_COMM_CODE+" p_MM_YYYY-->"+p_MM_YYYY+" p_SUBMISSION_DATE-->"+p_SUBMISSION_DATE+" p_MPR-->"+p_MPR);
		StoredProcedureQuery query = em.createStoredProcedureQuery("SP_CORRECTION_VALIDATION");
		query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		if(null!=p_COMM_CODE && p_COMM_CODE!=null) {
		query.setParameter(1,p_COMM_CODE );}
		query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		if(null!=p_MM_YYYY && p_MM_YYYY!=null) {
		query.setParameter(2,p_MM_YYYY );}
		query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		if(null!=p_SUBMISSION_DATE && p_SUBMISSION_DATE!=null) {
		query.setParameter(3,p_SUBMISSION_DATE );}
		query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
		if(null!=p_MPR && p_MPR!=null) {
		query.setParameter(4,p_MPR );}
		query.registerStoredProcedureParameter(5,String.class,ParameterMode.OUT);
		
		return query.executeUpdate();
		
		}
	
	

	
	
}
