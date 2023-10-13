package com.ddm.cbic.dao.implementation;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.model.SP_CORRECTION_LIST_ALL_GST_Result;
import com.ddm.cbic.model.SP_CORRECTION_LIST_FO_GST_Result;

@Repository
public class CORRECTION_DaoImpl {
	
	@Autowired
	private EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(CORRECTION_DaoImpl.class);
	
	
	
	private SP_CORRECTION_LIST_FO_GST_Result LIST_FO_GST_Result = new SP_CORRECTION_LIST_FO_GST_Result();
	@SuppressWarnings("unchecked")
	public  List<SP_CORRECTION_LIST_FO_GST_Result > generateResultBeanList(Object[] objArray){
	try {
		System.out.println(" before  query.getResultList().size() ");
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_CORRECTION_LIST_FO_GST");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.execute();
	
	//System.out.println("  query.getResultList().size() ");
	System.out.println("  query.getResultList().size() " +  query.getResultList().size());
	return LIST_FO_GST_Result.generateResultBeanList(query.getResultList());
	}
	finally {
		em.close();
	}
}
	
	
	private SP_CORRECTION_LIST_ALL_GST_Result correctionListAll = new SP_CORRECTION_LIST_ALL_GST_Result();
	@SuppressWarnings("unchecked")
	public  List<SP_CORRECTION_LIST_ALL_GST_Result > generateResultBeanList_All(Object[] objArray){
	try {
		System.out.println(" before  query.getResultList().size() ");
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_CORRECTION_LIST_ALL_GST");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	query.setParameter(1,(String)objArray[0] );
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	query.setParameter(2,(String)objArray[1] );
	query.execute();
	
	//System.out.println("  query.getResultList().size() ");
	System.out.println("  query.getResultList().size() " +  query.getResultList().size());
	return correctionListAll.generateResultBeanList(query.getResultList());
	}
	finally {
		em.close();
	}
}

	public String generateResultBean_SP_CORRECTION_APPROVAL(Object[] objArray,HttpServletRequest request){
		  try {
		  
		  System.out.println("objArray--> "+objArray[0]);
		  System.out.println("objArray--> "+objArray[1]);
		  System.out.println("objArray--> "+objArray[2]);
		  System.out.println("objArray--> "+objArray[3]);
		  
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_CORRECTION_APPROVAL");
		  
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  if(null!=objArray[0] && objArray[0]!=null) {
		  query.setParameter(1,(String)objArray[0] ); 
		  }
		  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		  if(null!=objArray[1] && objArray[1]!=null) {
		  query.setParameter(2,(String)objArray[1] ); 
		  }
		  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		  if(null!=objArray[2] && objArray[2]!=null) {
		  query.setParameter(3,(String)objArray[2] ); 
		  }
		  
		  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
		  if(null!=objArray[3] && objArray[3]!=null) {
		  query.setParameter(4,(String)objArray[3] ); 
		  }
		  
		  query.registerStoredProcedureParameter(5,String.class,ParameterMode.OUT);
		  
		  query.execute(); 
		  String out = (String)query.getOutputParameterValue(5);
		  logger.info("--out--"+out);
		  request.getSession().setAttribute("_Result", out);
		  return out;
		  }
			finally {
				em.close();
			}
	 }
	
	public String generateResultBean_SP_CORRECTION_DELETE_CRR(Object[] objArray,HttpServletRequest request){
		  try {
		  
		  
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_CORRECTION_DELETE_CRR");
		  
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  if(null!=objArray[0] ) {
		  query.setParameter(1,objArray[0].toString() ); System.out.println("objArray[0].toString()--> "+objArray[0].toString());
		  }
		  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		  if(null!=objArray[1] ) {
		  query.setParameter(2,objArray[1].toString() );System.out.println("objArray[1].toString()--> "+objArray[1].toString()); 
		  }
		  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		  if(null!=objArray[2] ) {
		  query.setParameter(3,objArray[2].toString() ); System.out.println("objArray[2].toString()--> "+objArray[2].toString());
		  }
		  
		  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
		  if(null!=objArray[3] ) {
		  query.setParameter(4,objArray[3].toString() ); System.out.println("objArray[3].toString()--> "+objArray[3].toString());
		  }
		  query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
		  if(null!=objArray[4] ) {
		  query.setParameter(5,objArray[4].toString() ); System.out.println("objArray[4].toString()--> "+objArray[4].toString());
		  }
		  query.registerStoredProcedureParameter(6,String.class,ParameterMode.OUT);
		  
		  query.execute(); 
		  String out = (String)query.getOutputParameterValue(6);
		  logger.info("--out--"+out);
		  request.getSession().setAttribute("_Result", out);
		  return out;
		  }
			finally {
				em.close();
			}
	 }
	
	public String generateResultBean_SP_CORRECTION_APPROVAL_MSG(Object[] objArray,HttpServletRequest request){
		  try {
		  
		  System.out.println("objArray--> "+objArray[0]);
		  System.out.println("objArray--> "+objArray[1]);
		  System.out.println("objArray--> "+objArray[2]);
		  System.out.println("objArray--> "+objArray[3]);
		  
		  StoredProcedureQuery query =em.createStoredProcedureQuery("SP_CORRECTION_APPROVAL_MSG");
		  
		  query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		  if(null!=objArray[0] && objArray[0]!=null) {
		  query.setParameter(1,(String)objArray[0] ); 
		  }
		  query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		  if(null!=objArray[1] && objArray[1]!=null) {
		  query.setParameter(2,(String)objArray[1] ); 
		  }
		  query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		  if(null!=objArray[2] && objArray[2]!=null) {
		  query.setParameter(3,(String)objArray[2] ); 
		  }
		  
		  query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
		  if(null!=objArray[3] && objArray[3]!=null) {
		  query.setParameter(4,(String)objArray[3] ); 
		  }
		  
		  query.registerStoredProcedureParameter(5,String.class,ParameterMode.OUT);
		  
		  query.execute(); 
		  String out = (String)query.getOutputParameterValue(5);
		  logger.info("--out--"+out);
		  request.getSession().setAttribute("_Result", out);
		  return out;
		  }
			finally {
				em.close();
			}
	 }
	

}
