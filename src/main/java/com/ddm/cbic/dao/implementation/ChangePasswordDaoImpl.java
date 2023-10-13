package com.ddm.cbic.dao.implementation;

import javax.persistence.EntityManager;

import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.ddm.cbic.controller.LoginController;
import com.ddm.cbic.dao.ChangePasswordDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Repository

@SuppressWarnings("unchecked")
public class ChangePasswordDaoImpl implements ChangePasswordDao {
	
	@PersistenceContext
	private EntityManager em;
	
	//private static Logger soplogger = LoggerFactory.getLogger(ChangePasswordDaoImpl.class);
	
	public String changePassword(Object[] objArray) {
		//soplogger.info("Enter in ChangePasswordDaoImpl.java >>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Enter in ChangePasswordDaoImpl.java >>>>>>>>>>>>>>>>>>>>>>>>>>");
		StoredProcedureQuery query=null;
		String userid = (String)objArray[0];
		String txt_OldPass = (String)objArray[1];
		String txt_pass = (String)objArray[2];
		String result = (String)objArray[3];
		//userid="brdCU_cbec";  //gstZA_admn brdCU_cbec
		//txt_OldPass="hNIgyQMfKgwEzUWjjD8iLOOI8WlYh6asVE8sfOpSOh0pHtD1C2Qit2iU+eX4spwLtpSbqyJDdo2Em8Q8EFh2Ow==";
		try {
		String encryptedPassSHA512= new LoginController().encryptData_SHA512(txt_OldPass);
		String newencryptedPassSHA512= new LoginController().encryptData_SHA512(txt_pass);
		
		
		
		System.out.println("txt_OldPass---"+txt_OldPass);
		System.out.println("encryptedPassSHA512---"+encryptedPassSHA512);
		
		System.out.println("new txt_pass---"+txt_pass);
		System.out.println("newencryptedPassSHA512---"+newencryptedPassSHA512);
		System.out.println("substring(6) user id in ChangePasswordDaoImpl---"+userid.toString().substring(6));
		
		if (userid.toString().substring(6).equalsIgnoreCase("cbec"))
        {
            //dbcontext.SP_CHANGE_PASS_CBEC(Session["USER"].ToString(), txt_OldPass, txt_pass, result);
              System.out.println("---SP_CHANGE_PASS_CBEC---UserId---"+userid);	
              query = em.createStoredProcedureQuery("SP_CHANGE_PASS_CBEC")
        			  .registerStoredProcedureParameter("p_ID", String.class, ParameterMode.IN)
        			  .registerStoredProcedureParameter("p_PASS", String.class, ParameterMode.IN)
        			  .registerStoredProcedureParameter("p_NEW_PASS", String.class, ParameterMode.IN)
        			  .registerStoredProcedureParameter("p_RESULT", String.class, ParameterMode.OUT)
        			  .setParameter("p_ID", userid)
        			  .setParameter("p_PASS", encryptedPassSHA512)
        			  .setParameter("p_NEW_PASS", newencryptedPassSHA512);
        			  //.setParameter("p_RESULT", "@p");
        			  
              			//System.out.println("query---"+query);
        			  query.execute(); 
        			  result= (String) query.getOutputParameterValue("p_RESULT");
        			  System.out.println("---result-new--"+result);	
         
        }
        else if (userid.toString().substring(6).equalsIgnoreCase("gnrl"))
        {
           // dbcontext.SP_CHANGE_PASS_FO(Session["USER"].ToString(), txt_OldPass, txt_pass, result);
        	 System.out.println("---SP_CHANGE_PASS_FO---UserId---"+userid);	
             query = em.createStoredProcedureQuery("SP_CHANGE_PASS_FO")
       			  .registerStoredProcedureParameter("p_ID", String.class, ParameterMode.IN)
       			  .registerStoredProcedureParameter("p_PASS", String.class, ParameterMode.IN)
       			  .registerStoredProcedureParameter("p_NEW_PASS", String.class, ParameterMode.IN)
       			  .registerStoredProcedureParameter("p_RESULT", String.class, ParameterMode.OUT)
       			  .setParameter("p_ID", userid)
       			  .setParameter("p_PASS", encryptedPassSHA512)
       			  .setParameter("p_NEW_PASS", newencryptedPassSHA512);
       			  
       			  query.execute(); 
       			  result= (String) query.getOutputParameterValue("p_RESULT");
       			  System.out.println("---result---"+result);	
        }
        else if (userid.toString().substring(6).equalsIgnoreCase("admn"))
        {
           // dbcontext.SP_CHANGE_PASS_COMM_GST(Session["CODE"].ToString(), txt_OldPass, txt_pass, result);
        	 System.out.println("---SP_CHANGE_PASS_COMM_GST---UserId---"+userid);	
        	 String commcode = userid.substring(3, 5);
        	 System.out.println("commcode---"+commcode);
             query = em.createStoredProcedureQuery("SP_CHANGE_PASS_COMM_GST")
       			  .registerStoredProcedureParameter("p_COMM_CODE", String.class, ParameterMode.IN)
       			  .registerStoredProcedureParameter("p_PASS", String.class, ParameterMode.IN)
       			  .registerStoredProcedureParameter("p_NEW_PASS", String.class, ParameterMode.IN)
       			  .registerStoredProcedureParameter("p_RESULT", String.class, ParameterMode.OUT)
       			  .setParameter("p_COMM_CODE", commcode)
       			  .setParameter("p_PASS", encryptedPassSHA512)
       			  .setParameter("p_NEW_PASS", newencryptedPassSHA512);
       			  
       			  query.execute(); 
       			  result= (String) query.getOutputParameterValue("p_RESULT");
       			  System.out.println("---result--new -"+result);	
        }
        else if (userid.toString().substring(6).equalsIgnoreCase("zone"))
        {
            //dbcontext.SP_CHANGE_PASS_ZONE_GST(Session["CODE"].ToString(), txt_OldPass, txt_pass, result);
        	 System.out.println("---SP_CHANGE_PASS_ZONE_GST---UserId---"+userid);
        	 String zonecode = userid.substring(3, 5);
        	 System.out.println("zonecode---"+zonecode);
             query = em.createStoredProcedureQuery("SP_CHANGE_PASS_ZONE_GST")
       			  .registerStoredProcedureParameter("p_ID", String.class, ParameterMode.IN)
       			  .registerStoredProcedureParameter("p_PASS", String.class, ParameterMode.IN)
       			  .registerStoredProcedureParameter("p_NEW_PASS", String.class, ParameterMode.IN)
       			  .registerStoredProcedureParameter("p_RESULT", String.class, ParameterMode.OUT)
       			  .setParameter("p_ID", zonecode)
       			  .setParameter("p_PASS", encryptedPassSHA512)
       			  .setParameter("p_NEW_PASS", newencryptedPassSHA512);
       			  
       			  query.execute(); 
       			  result= (String) query.getOutputParameterValue("p_RESULT");
       			  System.out.println("---result---"+result);	
        }
		
		
		
		}catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		return result;
	}

	@Override
	public String changePassword(String userid, String txt_OldPass, String txt_pass, String result) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
