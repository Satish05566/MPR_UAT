package com.ddm.cbic.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddm.cbic.model.SP_LOGIN_ACDC_Result;
import com.ddm.cbic.model.SP_LOGIN_GST_COMM_Result;
import com.ddm.cbic.model.User;
import com.ddm.cbic.model.User_GN;
import com.ddm.cbic.model.User_CBEC;

@Repository
public class UserDaoImpl {

	
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<SP_LOGIN_ACDC_Result> getUser_ACDC(String txtId, String pass){
		 System.out.println("Inside getUSER txtId-->" + txtId);
		 System.out.println("Inside getUSER pass-->" + pass);
		 //return em.createNamedStoredProcedureQuery("LOGIN_ACDC").setParameter("paramId", txtId).setParameter("paramPass", pass).getResultList();
		 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN_ACDC");
		 query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		 query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		 query.setParameter(1, txtId);
		 query.setParameter(2, pass);
		 query.execute();
		 return (new SP_LOGIN_ACDC_Result()).generateResultBeanList(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	public List<SP_LOGIN_GST_COMM_Result> getUser_GST_COMM(String txtId, String pass){
		 System.out.println("Inside getUSER txtId-->" + txtId);
		 System.out.println("Inside getUSER pass-->" + pass);
		 
		 StoredProcedureQuery query = em.createStoredProcedureQuery("SP_LOGIN_GST_COMM");
		 query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		 query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		 query.setParameter(1, txtId);
		 query.setParameter(2, pass);
		 query.execute();
		 
		 return (new SP_LOGIN_GST_COMM_Result()).generateResultBeanList(query.getResultList());
	}
	
	
	
	public List<User> getUser_COMM(String txtId, String pass){
		 System.out.println("Inside getUSER txtId-->" + txtId);
		 System.out.println("Inside getUSER pass-->" + pass);
		 return em.createNamedStoredProcedureQuery("LOGIN_COMM").setParameter("paramId", txtId).setParameter("paramPass", pass).getResultList();
		
	}
	
	
	
	public List<User> getUser_GST_DIV(String txtId, String pass){
		 System.out.println("Inside getUSER txtId-->" + txtId);
		 System.out.println("Inside getUSER pass-->" + pass);
		 return em.createNamedStoredProcedureQuery("LOGIN_GST_DIV").setParameter("paramId", txtId).setParameter("paramPass", pass).getResultList();
		
	}
	
	public List<User> getUser_GST_ZONE(String txtId, String pass){
		 System.out.println("Inside getUSER txtId-->" + txtId);
		 System.out.println("Inside getUSER pass-->" + pass);
		 return em.createNamedStoredProcedureQuery("LOGIN_GST_ZONE").setParameter("paramId", txtId).setParameter("paramPass", pass).getResultList();
		
	}
	
	public List<User> getUser_REGION(String txtId, String pass){
		 System.out.println("Inside getUSER txtId-->" + txtId);
		 System.out.println("Inside getUSER pass-->" + pass);
		 return em.createNamedStoredProcedureQuery("LOGIN_REGION").setParameter("paramId", txtId).setParameter("paramPass", pass).getResultList();
		
	}
	public List<User> getUser_zone(String txtId, String pass){
		 System.out.println("Inside getUSER txtId-->" + txtId);
		 System.out.println("Inside getUSER pass-->" + pass);
		 return em.createNamedStoredProcedureQuery("LOGIN_ZONE").setParameter("paramId", txtId).setParameter("paramPass", pass).getResultList();
		
	}
	
	public List<User_CBEC> getUser_CBEC(String txtId, String pass){
		 System.out.println("Inside getUSER txtId-->" + txtId);
		 System.out.println("Inside getUSER pass-->" + pass);
		 return em.createNamedStoredProcedureQuery("LOGIN_CBEC").setParameter("paramId", txtId).setParameter("paramPass", pass).getResultList();
		
	}
	public List<User_CBEC> getUser_FO(String txtId, String pass){
		 System.out.println("Inside getUSER txtId-->" + txtId);
		 System.out.println("Inside getUSER pass-->" + pass);
		 return em.createNamedStoredProcedureQuery("SP_LOGIN_FO").setParameter("paramId", txtId).setParameter("paramPass", pass).getResultList();
		
	}
}
