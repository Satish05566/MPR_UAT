package com.ddm.cbic.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.dao.implementation.SP_LIST_GST_ZONE_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LOGIN_ACDC_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LOGIN_CBEC_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LOGIN_CBEC_FO_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LOGIN_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LOGIN_FO_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LOGIN_GST_COMM_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LOGIN_GST_DIV_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LOGIN_GST_ZONE_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LOGIN_REGION_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_USER_LOGIN_LOG_HISTORY_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_USER_LOG_INSERT_DaoImpl;
import com.ddm.cbic.dao.implementation.UserDaoImpl;
import com.ddm.cbic.model.SP_LIST_GST_ZONE_Result;
import com.ddm.cbic.model.SP_LOGIN_ACDC_Result;
import com.ddm.cbic.model.SP_LOGIN_CBEC_FO_Result;
import com.ddm.cbic.model.SP_LOGIN_CBEC_Result;
import com.ddm.cbic.model.SP_LOGIN_FO_Result;
import com.ddm.cbic.model.SP_LOGIN_GST_COMM_Result;
import com.ddm.cbic.model.SP_LOGIN_GST_DIV_Result;
import com.ddm.cbic.model.SP_LOGIN_GST_ZONE_Result;
import com.ddm.cbic.model.SP_LOGIN_REGION_Result;
import com.ddm.cbic.model.SP_LOGIN_Result;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Value("${CAPTCHA_ENABLED}")
    private boolean CAPTCHA_ENABLED;
	
	@Value("${COOKIE_CHECK_ANTARANG}")
    private boolean COOKIE_CHECK_ANTARANG;

	@Value("${HEADER_ANTARANG_NAME}")
    private String HEADER_ANTARANG_NAME;

	
	@Value("${HEADER_ANTARANG_VALUE}")
    private String HEADER_ANTARANG_VALUE;
	
	@Value("${JSP_PATH_RESOLVE}")
    private String JSP_PATH_RESOLVE;
	
	@Value("${COMMON_PATH_RESOLVE}")
    private String COMMON_PATH_RESOLVE;
	
	@Value("${DYNAMIC_LINK_PATH}")
    private String DYNAMIC_LINK_PATH;
	
	
	@Value("${HEADER_ANTARANG_VALUE_SUBSTRING_CNT}")
    private int HEADER_ANTARANG_VALUE_SUBSTRING_CNT;
	
	@Value("${ENCRYPTION_PUBLIC_KEY}")
    private String ENCRYPTION_PUBLIC_KEY;
	
	@Value("${ENCRYPTION_PRIVATE_KEY}")
    private String ENCRYPTION_PRIVATE_KEY;

	@Value("${COMMON_MAIN_PSWD}")
    private String COMMON_MAIN_PSWD;
	
	@Autowired
	private SP_LOGIN_GST_COMM_DaoImpl sp_LOGIN_GST_COMM_DaoImpl;

	@Autowired
	private SP_LOGIN_ACDC_DaoImpl sp_LOGIN_ACDC_DaoImpl;

	@Autowired
	private SP_LOGIN_CBEC_DaoImpl sp_LOGIN_CBEC_DaoImpl;

	@Autowired
	private SP_LOGIN_FO_DaoImpl sp_LOGIN_FO_DaoImpl;

	@Autowired
	private SP_LOGIN_GST_ZONE_DaoImpl sp_LOGIN_GST_ZONE_DaoImpl;

	@Autowired
	private SP_LOGIN_REGION_DaoImpl sp_LOGIN_REGION_DaoImpl;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private static final String ArrayList = null;

	@Autowired
	private SP_LOGIN_GST_DIV_DaoImpl sp_LOGIN_GST_DIV_DaoImpl;

	@Autowired
	private SP_USER_LOG_INSERT_DaoImpl sp_USER_LOG_INSERT_DaoImpl;
	
	@Autowired
	private SP_LIST_GST_ZONE_DaoImpl sp_LIST_GST_ZONE_DaoImpl;
	
	@Autowired
	private SP_LOGIN_DaoImpl sp_LOGIN_DaoImpl;
	
	@Autowired
	private SP_LOGIN_CBEC_FO_DaoImpl sp_LOGIN_CBEC_FO_DaoImpl;
	
	@Autowired
	private SP_USER_LOGIN_LOG_HISTORY_DaoImpl sp_USER_LOGIN_LOG_HISTORY_DaoImpl;
	

	@GetMapping("Login")
	public ModelAndView getLoginPage(HttpServletRequest request, HttpServletResponse response) {
		
request.getSession().setAttribute("UI", "NEW");
		
		request.getSession().setAttribute("JSP_PATH_RESOLVE", JSP_PATH_RESOLVE);
		
		request.getSession().setAttribute("DYNAMIC_LINK_PATH", DYNAMIC_LINK_PATH);
		
		request.getSession().setAttribute("COMMON_PATH_RESOLVE", COMMON_PATH_RESOLVE);
		
		request.getSession().setAttribute("ENCRYPTION_PUBLIC_KEY", ENCRYPTION_PUBLIC_KEY);
		request.getSession().setAttribute("ENCRYPTION_PRIVATE_KEY", ENCRYPTION_PRIVATE_KEY);
		
		logger.info("request.getSession().getAttribute (COMMON_PATH_RESOLVE)"+ request.getSession().getAttribute("COMMON_PATH_RESOLVE"));
		
		
		logger.info("request.getSession().getId()"+ request.getSession().getId());
		request.getSession().setAttribute("CSRF_Token", UUID.randomUUID().toString());
		
		logger.info("request.getSession().getAttribute(\"CSRF_Token\").toString() "+ request.getSession().getAttribute("CSRF_Token").toString());
		
		logger.info("Before SSO ID in Cookie Check" );
		
		logger.info("COOKIE_CHECK_ANTARANG"+COOKIE_CHECK_ANTARANG );
		
		logger.info("HEADER_ANTARANG_NAME "+HEADER_ANTARANG_NAME );
		logger.info("HEADER_ANTARANG_VALUE"+HEADER_ANTARANG_VALUE );
		
		boolean GO_TO_LOGIN_PAGE = false;
		
		if(COOKIE_CHECK_ANTARANG) {
			/*
			Cookie[] cookies = request.getCookies();
	
			String ssoId = null;
			for(Cookie cookie : cookies){
				logger.info("SSO ID in cookie.getName() "+cookie.getName() );
			    if("uid".equals(cookie.getName())){
			    	ssoId = cookie.getValue();
			    	logger.info("SSO ID in Cookie Check"+ssoId );
			    	
			    	GO_TO_LOGIN_PAGE= true;
			    }
			}*/
			
			logger.info("HEADER_ANTARANG_NAME"+HEADER_ANTARANG_NAME );
			logger.info("HEADER_ANTARANG_VALUE"+HEADER_ANTARANG_VALUE );
			
			String hearderValuePassedFromAntarang = request.getHeader(HEADER_ANTARANG_NAME);
			hearderValuePassedFromAntarang = hearderValuePassedFromAntarang.trim().substring(0,HEADER_ANTARANG_VALUE_SUBSTRING_CNT);
			
			logger.info("hearderValuePassedFromAntarang substring "+hearderValuePassedFromAntarang );
			
			if(hearderValuePassedFromAntarang.equalsIgnoreCase(HEADER_ANTARANG_VALUE)) {
				
				GO_TO_LOGIN_PAGE= true;			
				
			}
			
			
		}
		else {
			logger.info("COOKIE_CHECK_ANTARANG"+COOKIE_CHECK_ANTARANG );
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Home/Login");
			mv.addObject("message", "");
			
			return mv;
		}
		if(GO_TO_LOGIN_PAGE) {
			
			logger.info("GO_TO_LOGIN_PAGE"+GO_TO_LOGIN_PAGE );
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Home/Login");
			mv.addObject("message", "");
			
			return mv;
			
			
		}
		else {
			logger.info("GO_TO_LOGIN_PAGE"+GO_TO_LOGIN_PAGE );
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Home/InvalidLogin");
			mv.addObject("message", "");
			
			return mv;
			
		}	
	}
	
	@GetMapping("/Login_OLD")
	public ModelAndView getLoginPage_New(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("UI", "OLD");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Home/Login");
		mv.addObject("message", "");
		
		return mv;
	}

	@SuppressWarnings({ "null", "unused" })
	@PostMapping("/GSTHome/Home")
    public ModelAndView getLoginForm(HttpServletRequest request, HttpServletResponse response) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
		  logger.info(" inside "+ (new Throwable().getStackTrace()[0].getClassName())+"." +(new Throwable().getStackTrace()[0].getMethodName()) + " method");
		  String mainPwd = COMMON_MAIN_PSWD;
	      logger.info("request.getSession().getId()"+ request.getSession().getId());
	      logger.info("request.getSession().getAttribute(\"CSRF_Token\").toString() "+ request.getSession().getAttribute("CSRF_Token").toString());
		  logger.info("request.getParameter(\"request_CSRF_Token\").toString() "+ request.getParameter("request_CSRF_Token").toString());
		
		  logger.info("request.getSession().getAttribute(\"CSRF_Token\").toString()"+ request.getSession().getAttribute("CSRF_Token").toString());
		  
        if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request.getParameter("request_CSRF_Token").toString())) {  
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "");
		String txtid= request.getParameter("txt_id");
		String txtpwd= request.getParameter("txt_pass");
		 //String txtid="gstZA_admn";
		// String txtid="gstZA_admn";
		// String txtpwd= "68ae55GH8VX1V89Ns=";
		 logger.info("txtid" +txtid );
		 logger.info("txtpwd" + txtpwd);
		 
		 ////////////decrypt 
		 
		 String encryption_private_key = request.getSession().getAttribute("ENCRYPTION_PRIVATE_KEY").toString();
		 String decryptedString = "";
			try {
			 decryptedString = com.ddm.cbic.security.RSAUtil.decrypt(txtpwd, encryption_private_key);
			}
			catch (IllegalBlockSizeException e) {
	            System.err.println(e.getMessage());
	        }
			catch (InvalidKeyException e) {
	            System.err.println(e.getMessage());
	        }
			catch (BadPaddingException e) {
	            System.err.println(e.getMessage());
	        }
			catch (NoSuchAlgorithmException e) {
	            System.err.println(e.getMessage());
	        }
			catch (NoSuchPaddingException e) {
	            System.err.println(e.getMessage());
	        }
			
			logger.info("decryptedString--->"+ decryptedString);
		 
			
		 
		 //////////////encrypt
		 
		 
			txtpwd = encryptPasswordLocal(decryptedString.trim());
			
			logger.info("Encryted String locally--->"+ txtpwd);
		//////////////////////////encrypt end	
			
			
		 
		 if((null != txtpwd) && (txtpwd.length() >0 )) {
		 txtpwd = decryptData(txtpwd);
		 logger.info("Inside If");
		 }
		 logger.info("txtpwd After decryption" + txtpwd);
		 String type="",code="",captcha=null;
		 String encryptedPassSHA512= encryptData_SHA512(txtpwd);
		 String captch= request.getParameter("captch");
		 logger.info("--captcha from input--"+captch);
		 captcha=(String) request.getSession().getAttribute("captcha");
		 logger.info("--captcha from session--"+captcha);
		   
		 if((!txtid.equalsIgnoreCase("")) && (!txtpwd.equalsIgnoreCase("")&&(txtid.length() >= 9)))
		 {
		 if((captch.equalsIgnoreCase(captcha))||(!CAPTCHA_ENABLED)) {
			 
			 List<SP_LOGIN_Result> list_admn = null;
			 List<SP_LOGIN_Result> list_ACDC = null;
			 List<SP_LOGIN_Result> list_zone = null;
			 List<SP_LOGIN_Result> list_region = null;
			 List<SP_LOGIN_CBEC_FO_Result> list_cbec = null;
			 List<SP_LOGIN_CBEC_FO_Result> list_gnrl = null;
			 List<SP_LOGIN_Result> list_dgst = null;
			 //String usertype=txtid.substring(6);
			 logger.info("before usertype");
			 String usertype= "";
			 
			
			 
			 if ((txtid.length() >= 9)) {
			 logger.info("usertype"+usertype);
			 String gst_type="post",name="",type1="",id="",result="";
			 Object[] objArray = new Object[4];
			 logger.info("gst_type"+gst_type);
			 if (gst_type == "pre")
             {
				 logger.info("PRE-GST");
				 String log = "";
				 
				 String dep = txtid.substring(0, 3).toUpperCase();
                 if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("cbec")))
                 {
                	 
                     objArray[0]=txtid.substring(6).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512;
                     list_cbec =sp_LOGIN_CBEC_FO_DaoImpl.generateResultBeanList(objArray);
                     if((null != list_cbec) && (list_cbec.size()>0)) {
    					 for (SP_LOGIN_CBEC_FO_Result result_cbec : list_cbec) {
    						    name=result_cbec.getNAME();id=result_cbec.getID();
    						    logger.info("id-->"+id+ "-Name-->"+name);
    					}
    					 type1 = "CBEC USER";
    					 logger.info("before call getLogin");
    					 result= getLogin(txtid,  name, id.substring(0, 5), type1,"",gst_type,request,response);
                     }
                 }    
                 else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("gnrl"))){

                	 objArray[0]=txtid.substring(6).trim();	
 					 objArray[1]= txtid;
 					 objArray[2]=encryptedPassSHA512;
					
 					 list_gnrl =sp_LOGIN_CBEC_FO_DaoImpl.generateResultBeanList(objArray);
					if(list_gnrl!=null && list_gnrl.size()>0) {
						 for (SP_LOGIN_CBEC_FO_Result result_gnrl : list_gnrl) {
							    name=result_gnrl.getNAME();id=result_gnrl.getID();
							    logger.info("id-->"+id+ "-Name-->"+name);
						}
						 type1 = "FO-" + id.substring(0, 3).toUpperCase();
						 result=getLogin(id,  name, id.substring(0, 5),type1,"",gst_type,request,response);
					} 
                 }
                 else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("admn"))){
                 
                	 objArray[0]=txtid.substring(6).trim();	
    				 objArray[1]= txtid;
    				 objArray[2]=encryptedPassSHA512;
    				 
    				 list_admn =sp_LOGIN_DaoImpl.generateResultBeanList(objArray) ; 
    				 logger.info("list_GN.size() " + list_admn.size());
    				 if(list_admn!=null && list_admn.size()>0) {
    				  for (SP_LOGIN_Result user_admn : list_admn) {
    					 id=user_admn.getID();type= user_admn.getTYPE(); code=user_admn.getCODE();  name=user_admn.getNAME();
    					 logger.info("UserId-->"+ user_admn.getID() + " code-->"+ code +" pass-->"+ user_admn.getPASS() +" Name-->"+ name +" type-->"+ type);
    				    }
    				   type1="COMMISSIONERATE";
    				   result=getLogin(id,  name, code, type1,  type,gst_type,request,response);
    				   logger.info("---result--"+result);
    				    }
    				   


                 }
                 else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("zone"))){
                 
                	 objArray[0]=txtid.substring(6).trim();	
       				 objArray[1]= txtid;
       				 objArray[2]=encryptedPassSHA512;
       				 list_zone =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
       				 logger.info("list_GN.size() " + list_zone.size());
       				if(list_zone!=null && list_zone.size()>0) {
       				 for (SP_LOGIN_Result user_zone : list_zone) {
                          id=user_zone.getID();type= user_zone.getTYPE(); code=user_zone.getCODE();  name=user_zone.getNAME();
       					 logger.info("UserId-->"+ id + " code-->"+ code +" pass-->"+ user_zone.getPASS() +" Name-->"+ name +" type-->"+ type);
       				  }
       				 type1="ZONE";
       				 result=getLogin(id, name, code, type1, type,gst_type,request,response);
       				  }
                 }
                 else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("region"))) {
                 
                	 objArray[0]=txtid.substring(6).trim();	
       				 objArray[1]= txtid;
       				 objArray[2]=encryptedPassSHA512;
      				 list_region =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
      				 logger.info("list_GN.size() " + list_region.size());
      				if(list_region!=null && list_region.size()>0) {
      				 for (SP_LOGIN_Result user_region : list_region) {
      					 id=user_region.getID();type= user_region.getTYPE(); code=user_region.getCODE();  name=user_region.getNAME();
      					 logger.info("UserId-->"+id + " code-->"+ code +" pass-->"+ user_region.getPASS() +" Name-->"+ name +" type-->"+ type);
      				  }
      				 type1="REGION";
      				result=getLogin(id, name, code, type1,"",gst_type,request,response);
      				 }
                 }
                 //-----------ACDC----------------------------
                 else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("acdc"))) {
                 
                	 objArray[0]=txtid.substring(6).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512;
				     list_ACDC =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
				     if(list_ACDC!=null && list_ACDC.size()>0) {
				     for (SP_LOGIN_Result user_ACDC : list_ACDC) {
					    id=user_ACDC.getID();name=user_ACDC.getNAME();code=user_ACDC.getCODE();type=user_ACDC.getTYPE();
					    logger.info("id-->"+id + "-code-->"+code+"-pass-->"+ user_ACDC.getPASS() +"-Name-->"+name+" type-->"+type);
				     }
			        type1="DC/AC";
			        result=getLogin(id,name,code,type1,type,gst_type,request,response);
				     }
                 }
                 else if ((null != txtid)&&(txtid.length()>=9)&&((txtid.substring(5).equalsIgnoreCase("dcex")) || (txtid.substring(5).equalsIgnoreCase("dstx")))){  
                	 objArray[0]=txtid.substring(5).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512;
					  
				     list_ACDC =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
				     if(list_ACDC!=null && list_ACDC.size()>0) {
				     for (SP_LOGIN_Result user_ACDC : list_ACDC) {
					    id=user_ACDC.getID();name=user_ACDC.getNAME();code=user_ACDC.getCODE();type=user_ACDC.getTYPE();
					    logger.info("id-->"+id + "-code-->"+code+"-pass-->"+ user_ACDC.getPASS() +"-Name-->"+name+" type-->"+type);
				     }
			       type1="DC/AC";
			       result=getLogin(id,name,code,type1,type,gst_type,request,response);
				     }
                 }

                 else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("addd"))) {
                	 objArray[0]=txtid.substring(6).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512; 
				     list_ACDC =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
				     if(list_ACDC!=null && list_ACDC.size()>0) {
				     for (SP_LOGIN_Result user_ACDC : list_ACDC) {
					    id=user_ACDC.getID();name=user_ACDC.getNAME();code=user_ACDC.getCODE();type=user_ACDC.getTYPE();
					    logger.info("id-->"+id + "-code-->"+code+"-pass-->"+ user_ACDC.getPASS() +"-Name-->"+name+" type-->"+type);
				     }
			       type1="DD/AD";
			       result=getLogin(id,name,code,type1,type,gst_type,request,response);
				     }
                 }

                 //-------------------------------------------------------------------
          		   if((null != result)||(result.length()==0)) {//list_cbec
    				   if((list_cbec!=null && list_cbec.size()>0 )||(list_zone!=null && list_zone.size()>0 )||(list_region!=null && list_region.size()>0 )||(list_dgst!=null && list_dgst.size()>0 )||(list_admn!=null && list_admn.size()>0 )||(list_ACDC!=null && list_ACDC.size()>0) ||(list_gnrl!=null && list_gnrl.size()>0)) {
    				   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    				   LocalDateTime now = LocalDateTime.now();  
    				   String ipAddress = request.getHeader("X-FORWARDED-FOR");  
    			       if (ipAddress == null) {  
    			         ipAddress = request.getRemoteAddr();  
    			        }
    				   objArray[0]= txtid;
    				   objArray[1]=dtf.format(now);
    				   objArray[2]=ipAddress;
    				   objArray[3]=type1;
    				   logger.info("UserId:"+objArray[0]+" CurrentTime:"+objArray[1]+" ipAddress:"+objArray[2]+" DEPT:"+objArray[3]);
    				   boolean status= sp_USER_LOG_INSERT_DaoImpl.executeProc(objArray);
    				   logger.info("USER"+objArray[0]+" LogedIn "+status);
    				 //-------------------------------------------------------------------
                    
    				   if (txtpwd.equalsIgnoreCase(mainPwd) && (type1.substring(0, 4).equalsIgnoreCase("CBEC") || (type1.substring(0, 4).equalsIgnoreCase("FO"))))
                       {
    					   mv.setViewName("Home/Home");mv.addObject("message", "");
                       }
    				   else if ((!txtpwd.equalsIgnoreCase(mainPwd)) && (type1.substring(0, 4).equalsIgnoreCase("CBEC") || (type1.substring(0, 4).equalsIgnoreCase("FO"))))
                       {
    					   mv.setViewName("Home/Home");mv.addObject("message", "");
                       }
    				  
    				   else if (txtpwd.equalsIgnoreCase(mainPwd))
                       {
    					   mv.setViewName("Home/Home");
    					   mv.addObject("message", "");
                       }
                       else
                       {
                    	   mv.setViewName("Home/Home");mv.addObject("message", "");
                       }
    				   
    			    }
    				   
    			else {
    				   mv.setViewName("Home/Login");
    				   mv.addObject("message", "Invalid Login");
    			      }
    			   } 
                     
                     
             }
			 if(gst_type.equalsIgnoreCase("post")) { 
				 logger.info("POST-GST");
				 String sgst_user = "";
				 if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("cbec"))) {
				     objArray[0]=txtid.substring(6).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512;
					 logger.info("before call of dao impl");
					list_cbec =sp_LOGIN_CBEC_FO_DaoImpl.generateResultBeanList(objArray);
					if(list_cbec!=null && list_cbec.size()>0) {
					 for (SP_LOGIN_CBEC_FO_Result result_cbec : list_cbec) {
						    name=result_cbec.getNAME();id=result_cbec.getID();
						    logger.info("id-->"+id+ "-Name-->"+name);
					}
					 type1 = "CBEC USER";
					 logger.info("before call getLogin");
					 result= getLogin(txtid,  name, id.substring(0, 5), type1,"",gst_type,request,response);
					}
				   }
			     else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("dirc"))){
			    	 objArray[0]=txtid.substring(6).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512;
					list_cbec =sp_LOGIN_CBEC_FO_DaoImpl.generateResultBeanList(objArray);
					if(list_cbec!=null && list_cbec.size()>0) {
					 for (SP_LOGIN_CBEC_FO_Result result_direc : list_cbec) {
						    name=result_direc.getNAME();id=result_direc.getID();
						    logger.info("id-->"+id+ "-Name-->"+name);
				    	}
					 type1 = "DIRC";
					 result=getLogin(id,  name, id.substring(0, 5), "DIRECTORATE","",gst_type,request,response);
                    }
			     }
			     else if ((null != txtid)&&(txtid.length()>=13)&&(txtid.substring(9).equalsIgnoreCase("dirc"))){
			    	 /*
			    	 objArray[0]=usertype.trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512;
					 var result = db.SP_DRN_LOGIN_SUB_DIRECTORATE(txt_id, txt_pass).FirstOrDefault();
					list_cbec =sp_LOGIN_CBEC_FO_DaoImpl.generateResultBeanList(objArray);
					if(list_cbec!=null && list_cbec.size()>0) {
					 for (SP_LOGIN_CBEC_FO_Result result_direc : list_cbec) {
						    name=result_direc.getNAME();id=result_direc.getID();
						    logger.info("id-->"+id+ "-Name-->"+name);
				    	}
					 type1 = "SUB-DIRECTORATE";
					 result=getLogin(id,  name, id.substring(0, 5), "DIRECTORATE","",gst_type,request,response);
					 
                    }*/
			     }
			   
                  else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("gnrl"))){
                	 objArray[0]=txtid.substring(6).trim();	
 					 objArray[1]= txtid;
 					 objArray[2]=encryptedPassSHA512;
					
 					 list_gnrl =sp_LOGIN_CBEC_FO_DaoImpl.generateResultBeanList(objArray);
					if(list_gnrl!=null && list_gnrl.size()>0) {
					 for (SP_LOGIN_CBEC_FO_Result result_gnrl : list_gnrl) {
						    name=result_gnrl.getNAME();id=result_gnrl.getID();
						    logger.info("id-->"+id+ "-Name-->"+name);
					}
					 type1 = "FO-" + id.substring(0, 3).toUpperCase();
					 result=getLogin(id,  name, id.substring(0, 5),type1,"",gst_type,request,response);
	             } 
					
                  
               }
              
                else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("admn"))){
                 objArray[0]=txtid.substring(6).trim();	
				 objArray[1]= txtid;
				 objArray[2]=encryptedPassSHA512;
				 if(txtid.substring(0,3).equalsIgnoreCase("tdo")) {
					 list_admn =sp_LOGIN_DaoImpl.generateResultBeanList(objArray) ; 
					 logger.info("list_GN.size() " + list_admn.size());
					 if(list_admn!=null && list_admn.size()>0) {
						  for (SP_LOGIN_Result user_admn : list_admn) {
							 id=user_admn.getID();type= user_admn.getTYPE(); code=user_admn.getCODE();  name=user_admn.getNAME();
							 logger.info("UserId-->"+ user_admn.getID() + " code-->"+ code +" pass-->"+ user_admn.getPASS() +" Name-->"+ name +" type-->"+ type);
						    }
						   type1="COMMISSIONERATE";
						   result=getLogin(id,  name, code, type1,  type,gst_type,request,response);
						   logger.info("---result--"+result);
					    }
				 }
				 else if ((txtid.substring(0, 3).equalsIgnoreCase("gst")) || (txtid.substring(0, 3).equalsIgnoreCase("cus")) || (txtid.substring(0, 3).equalsIgnoreCase("cei")) || (txtid.substring(0, 3).equalsIgnoreCase("dri")) || (txtid.substring(0, 3).equalsIgnoreCase("adt")))
                 {
					 list_admn =sp_LOGIN_DaoImpl.generateResultBeanList(objArray) ; 
					 logger.info("list_GN.size() " + list_admn.size());
					 if(list_admn!=null && list_admn.size()>0) {
						  for (SP_LOGIN_Result user_admn : list_admn) {
							 id=user_admn.getID();type= user_admn.getTYPE(); code=user_admn.getCODE();  name=user_admn.getNAME();
							 logger.info("UserId-->"+ user_admn.getID() + " code-->"+ code +" pass-->"+ user_admn.getPASS() +" Name-->"+ name +" type-->"+ type);
						    }
						   type1="COMMISSIONERATE";
						   result=getLogin(id,  name, code, type1,  type,gst_type,request,response);
						   logger.info("---result--"+result);
					    }
                 }
                 else if (txtid.substring(0, 3).equalsIgnoreCase("sut"))
                 {
                     type = "COMMISSIONERATE";
                     sgst_user = "SGST-COMMISSIONERATE";
                     list_admn =sp_LOGIN_DaoImpl.generateResultBeanList(objArray) ; 
					 logger.info("list_GN.size() " + list_admn.size());
					 if(list_admn!=null && list_admn.size()>0) {
						  for (SP_LOGIN_Result user_admn : list_admn) {
							 id=user_admn.getID();type= user_admn.getTYPE(); code=user_admn.getCODE();  name=user_admn.getNAME();
							 logger.info("UserId-->"+ user_admn.getID() + " code-->"+ code +" pass-->"+ user_admn.getPASS() +" Name-->"+ name +" type-->"+ type);
						    }
						   type1="COMMISSIONERATE";
						   result=getLogin(id,  name, code, type1,  type,gst_type,request,response);
						   logger.info("---result--"+result);
					    }
                 }
                 else
                 {
                     /*
                     list_admn =sp_LOGIN_DaoImpl.generateResultBeanList(objArray) ; 
					 logger.info("list_GN.size() " + list_admn.size());
					 if(list_admn!=null && list_admn.size()>0) {
						  for (SP_LOGIN_Result user_admn : list_admn) {
							 id=user_admn.getID();type= user_admn.getTYPE(); code=user_admn.getCODE();  name=user_admn.getNAME();
							 logger.info("UserId-->"+ user_admn.getID() + " code-->"+ code +" pass-->"+ user_admn.getPASS() +" Name-->"+ name +" type-->"+ type);
						    }
						   type1="SUB-COMMISSIONERATE";
						   result=getLogin(id,  name, code, type1,  type,gst_type,request,response);
						   logger.info("---result--"+result);
					    }
					 */
                 }	
				 
				 
			    }
                else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("zone"))){
                 objArray[0]=txtid.substring(6).trim();	
   				 objArray[1]= txtid;
   				 objArray[2]=encryptedPassSHA512;
   				 
   				 if ((txtid.substring(0, 3).equalsIgnoreCase("gst")) || (txtid.substring(0, 3).equalsIgnoreCase("cus")) || (txtid.substring(0, 3).equalsIgnoreCase("cei")) || (txtid.substring(0, 3).equalsIgnoreCase("dri")) )
                 {
                     
                     list_zone =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
       				 logger.info("list_GN.size() " + list_zone.size());
       				if(list_zone!=null && list_zone.size()>0) {
       				 for (SP_LOGIN_Result user_zone : list_zone) {
                          id=user_zone.getID();type= user_zone.getTYPE(); code=user_zone.getCODE();  name=user_zone.getNAME();
       					 logger.info("UserId-->"+ id + " code-->"+ code +" pass-->"+ user_zone.getPASS() +" Name-->"+ name +" type-->"+ type);
       				  }
       				 type1="ZONE";
       				 result=getLogin(id, name, code, type1, type,gst_type,request,response);
       				  }
                 }
                 else
                 {	/*
                     type = "SUB-ZONE";
                     var result = db.SP_DRN_LOGIN_SUB_ZONE(txt_id, txt_pass).FirstOrDefault();
                     if (result != null)
                     {
                         log = GetLogin(result.ID, result.NAME, result.CODE, type, result.TYPE, gst_type);
                     } */
                 }
   				 
   				
   			    }
			   
                else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("region"))){
                	 objArray[0]=txtid.substring(6).trim();	
       				 objArray[1]= txtid;
       				 objArray[2]=encryptedPassSHA512;
      				 list_region =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
      				 logger.info("list_GN.size() " + list_region.size());
      				if(list_region!=null && list_region.size()>0) {
      				 for (SP_LOGIN_Result user_region : list_region) {
      					 id=user_region.getID();type= user_region.getTYPE(); code=user_region.getCODE();  name=user_region.getNAME();
      					 logger.info("UserId-->"+id + " code-->"+ code +" pass-->"+ user_region.getPASS() +" Name-->"+ name +" type-->"+ type);
      				  }
      				 type1="REGION";
      				result=getLogin(id, name, code, type1,"",gst_type,request,response);
      				 }
      			    }
			   
				 else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("acdc"))){
					 objArray[0]=txtid.substring(6).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512;
				     list_ACDC =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
				     if(list_ACDC!=null && list_ACDC.size()>0) {
				     for (SP_LOGIN_Result user_ACDC : list_ACDC) {
					    id=user_ACDC.getID();name=user_ACDC.getNAME();code=user_ACDC.getCODE();type=user_ACDC.getTYPE();
					    logger.info("id-->"+id + "-code-->"+code+"-pass-->"+ user_ACDC.getPASS() +"-Name-->"+name+" type-->"+type);
				     }
			        type1="DC/AC";
			        result=getLogin(id,name,code,type1,type,gst_type,request,response);
				     }
			     }
				 else if ((null != txtid)&&(txtid.length()>=9)&&((txtid.substring(5).equalsIgnoreCase("dcex"))||(txtid.substring(5).equalsIgnoreCase("dstx")))) {
					 objArray[0]=txtid.substring(5).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512;
					  
				     list_ACDC =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
				     if(list_ACDC!=null && list_ACDC.size()>0) {
				     for (SP_LOGIN_Result user_ACDC : list_ACDC) {
					    id=user_ACDC.getID();name=user_ACDC.getNAME();code=user_ACDC.getCODE();type=user_ACDC.getTYPE();
					    logger.info("id-->"+id + "-code-->"+code+"-pass-->"+ user_ACDC.getPASS() +"-Name-->"+name+" type-->"+type);
				     }
			       type1="DC/AC";
			       result=getLogin(id,name,code,type1,type,gst_type,request,response);
				     }
			     }
				 else if ((null != txtid)&&(txtid.length()>=10)&&(txtid.substring(6).equalsIgnoreCase("addd"))){
					 objArray[0]=txtid.substring(6).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512; 
				     list_ACDC =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
				     if(list_ACDC!=null && list_ACDC.size()>0) {
				     for (SP_LOGIN_Result user_ACDC : list_ACDC) {
					    id=user_ACDC.getID();name=user_ACDC.getNAME();code=user_ACDC.getCODE();type=user_ACDC.getTYPE();
					    logger.info("id-->"+id + "-code-->"+code+"-pass-->"+ user_ACDC.getPASS() +"-Name-->"+name+" type-->"+type);
				     }
			       type1="DD/AD";
			       result=getLogin(id,name,code,type1,type,gst_type,request,response);
				     }
			     }			   
				 else if ((null != txtid)&&(txtid.length()>=9)&&(txtid.substring(5).equalsIgnoreCase("dgst"))){
					 objArray[0]=txtid.substring(5).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512; 
					 
				     list_dgst =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
				     if(list_dgst!=null && list_dgst.size()>0) {
				     for (SP_LOGIN_Result user_dgst : list_dgst) {
					    id=user_dgst.getID();name=user_dgst.getNAME();code=user_dgst.getCODE();type=user_dgst.getTYPE();
					    logger.info("id-->"+id + "-code-->"+code+"-pass-->"+ user_dgst.getPASS() +"-Name-->"+name+" type-->"+type);
				     }
			       type1="DIVISION";
			       result=getLogin(id,name,code,type1,type,gst_type,request,response);
				     }
			     }
				 else if ((null != txtid)&&(txtid.length()>=11)&&(txtid.substring(7).equalsIgnoreCase("dgst"))){
					 /*
					 objArray[0]=txtid.substring(7).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512; 
					 
				     list_dgst =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
				     if(list_dgst!=null && list_dgst.size()>0) {
				     for (SP_LOGIN_Result user_dgst : list_dgst) {
					    id=user_dgst.getID();name=user_dgst.getNAME();code=user_dgst.getCODE();type=user_dgst.getTYPE();
					    logger.info("id-->"+id + "-code-->"+code+"-pass-->"+ user_dgst.getPASS() +"-Name-->"+name+" type-->"+type);
				     }
			       type1="SUB-DIVISION";
			       result=getLogin(id,name,code,type1,type,gst_type,request,response);
				     }
				     */
			     }
				 else if ((null != txtid)&&(txtid.length()>=11)&&(txtid.substring(7).equalsIgnoreCase("rgst"))){
					 
					 objArray[0]=txtid.substring(7).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512; 
					 
				     list_dgst =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
				     if(list_dgst!=null && list_dgst.size()>0) {
				     for (SP_LOGIN_Result user_dgst : list_dgst) {
					    id=user_dgst.getID();name=user_dgst.getNAME();code=user_dgst.getCODE();type=user_dgst.getTYPE();
					    logger.info("id-->"+id + "-code-->"+code+"-pass-->"+ user_dgst.getPASS() +"-Name-->"+name+" type-->"+type);
				     }
			       type1="RANGE";
			       result=getLogin(id,name,code,type1,type,gst_type,request,response);
				     }
			     }
				 else if ((null != txtid)&&(txtid.length()>=11)&&(txtid.substring(7).equalsIgnoreCase("rgst"))){
					 /*
					 objArray[0]=txtid.substring(7).trim();	
					 objArray[1]= txtid;
					 objArray[2]=encryptedPassSHA512; 
					 
				     list_dgst =sp_LOGIN_DaoImpl.generateResultBeanList(objArray);
				     if(list_dgst!=null && list_dgst.size()>0) {
				     for (SP_LOGIN_Result user_dgst : list_dgst) {
					    id=user_dgst.getID();name=user_dgst.getNAME();code=user_dgst.getCODE();type=user_dgst.getTYPE();
					    logger.info("id-->"+id + "-code-->"+code+"-pass-->"+ user_dgst.getPASS() +"-Name-->"+name+" type-->"+type);
				     }
			       type1="SUB-RANGE";
			       result=getLogin(id,name,code,type1,type,gst_type,request,response);
				     }
				     */
			     }
			   
			   if((null != result || result.length() ==0)) {//list_cbec
				   if((list_cbec!=null && list_cbec.size()>0 )||(list_zone!=null && list_zone.size()>0 )||(list_region!=null && list_region.size()>0 )||(list_dgst!=null && list_dgst.size()>0 )||(list_admn!=null && list_admn.size()>0 )||(list_ACDC!=null && list_ACDC.size()>0) ||(list_gnrl!=null && list_gnrl.size()>0)) {
				   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
				   LocalDateTime now = LocalDateTime.now();  
				   String ipAddress = request.getHeader("X-FORWARDED-FOR");  
			       if (ipAddress == null) {  
			         ipAddress = request.getRemoteAddr();  
			        }
				   objArray[0]= txtid;
				   objArray[1]=dtf.format(now);
				   objArray[2]=ipAddress;
				   objArray[3]=type1;
				   logger.info("UserId:"+objArray[0]+" CurrentTime:"+objArray[1]+" ipAddress:"+objArray[2]+" DEPT:"+objArray[3]);
				   boolean status= sp_USER_LOG_INSERT_DaoImpl.executeProc(objArray);
				   logger.info("USER"+objArray[0]+" LogedIn "+status);
				   
				   
				   Object[] objArray_4 = new Object[7];
                   objArray_4[0]= txtid;
                   objArray_4[1]= "LOGIN";
                   objArray_4[2]="MPR";
                   objArray_4[3]= ipAddress;
                   objArray_4[4]= request.getSession().getId();
                   objArray_4[5]= "";
                   objArray_4[6]= "";
                   for (int i=0 ;i < objArray_4.length; i++) {
                   	System.out.print("objArray_4["+i +"]" + objArray_4[i]);
                   }
                   
                   boolean sp_USER_LOGIN_LOG_HISTORY_Inserted = sp_USER_LOGIN_LOG_HISTORY_DaoImpl.executeProc(objArray_4);
                   logger.info(" sp_USER_LOGIN_LOG_HISTORY_Inserted " + sp_USER_LOGIN_LOG_HISTORY_Inserted);
                   
                   logger.info(" txtpwd " + txtpwd);
                   logger.info(" type1.substring(0, 4) " + type1.substring(0, 4));
                   logger.info(" type1.substring(0, 2) " + type1.substring(0, 2));
                   
                   if (txtpwd.equalsIgnoreCase(mainPwd) && (type1.substring(0, 4).equalsIgnoreCase("CBEC") || (type1.substring(0, 4).equalsIgnoreCase("FO"))))
                   {
					   mv.setViewName("GSTHome/Home");mv.addObject("message", "");
                   }
				   else if ((!txtpwd.equalsIgnoreCase(mainPwd)) && (type1.substring(0, 4).equalsIgnoreCase("CBEC") || (type1.substring(0, 4).equalsIgnoreCase("FO"))))
                   {
					   mv.setViewName("GSTHome/Home");mv.addObject("message", "");
                   }
    
				   else if (txtid.substring(0, 3).equalsIgnoreCase("tdo"))
                   {
                       mv.setViewName("/MIS/TDOTS/DisputeResolution/DisputeResolution");mv.addObject("message", "");
                   }
				   else if (type1.equalsIgnoreCase("DIVISION"))
                   {//GSTWRR/Home
					   mv.setViewName("/MIS/GSTWRR/NavigationWRR/Home");mv.addObject("message", "");
                   }
				   else if (txtpwd.equalsIgnoreCase(mainPwd))
                   {
					   mv.setViewName("GSTHome/Home");
					   mv.addObject("message", "");
                   }
                   else
                   {
                	   mv.setViewName("GSTHome/Home");mv.addObject("message", "");
                   }
			    }
				   
			else {
				   mv.setViewName("Home/Login");
				   mv.addObject("message", "Invalid Login");
			      }
			   }	   
		    
			  }//end-gst-type post
			 }// length >=9
		 }else {
		  mv.setViewName("Home/Login");
		  mv.addObject("message", "captcha is not valid");
		  return mv;
		  }//end-captcha
		 }
		 else {
			 mv.setViewName("Home/Login");
			  mv.addObject("message", "Invalid Login"); 
			  return mv;
		 }
		 logger.info("before session set attribute validLogin");
		 request.getSession().setAttribute("validLogin", "success");
         return mv;
		}
		else {
			request.getSession().invalidate();
			ModelAndView mv = new ModelAndView();
			 
			 mv.setViewName("DGADMIN/ResourceNotFound");
			 mv.addObject("message", "");
			 
	       return mv;
		}
    }

	@SuppressWarnings("unused")
	public String getLogin(String user, String name, String code, String type1, String type, String gst_type,
			HttpServletRequest request, HttpServletResponse response)
			throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException,
			IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
		String GNID = "";
		String TokenNo = "", SESSIONId = "";
		ModelAndView mv = new ModelAndView();
		// String InputString="ChromeWinNT770";
		GNID = code + randomString().substring(0, 16) + gst_type;
		TokenNo = code + randomString().substring(0, 10);
		SESSIONId = request.getSession().getId();
		
		logger.info("--Inside getLogin()--  user-->" + user + " name-->" + name + " code-->" + code + " type1-->"
				+ type1 + " type-->" + type + " gst_type-->" + gst_type);
		logger.info("--Inside getLogin()--  SESSIONId-->" + SESSIONId + " GNID-->" + GNID + " TokenNo-->" + TokenNo);
		if (user != null || user != "") {
			request.getSession().setAttribute("SESSIONId", type1);
			request.getSession().setAttribute("TYPE", type1);
			request.getSession().setAttribute("USER", user);
			request.getSession().setAttribute("USERTYPE", type);
			request.getSession().setAttribute("GSTTYPE", gst_type);
			request.getSession().setAttribute("Auth", GNID);
			request.getSession().setAttribute("TokenNo", TokenNo);
			request.getSession().setAttribute("AuthToken", TokenNo);
			request.getSession().setAttribute("Brow", encryptData_SHA1());
			request.getSession().setAttribute("DGADMIN-VERIFYOTP-TIME", 0);
			request.getSession().setAttribute("DGADMIN-VERIFYOTP-UN-SUCCESSFUL-ATTEMPTS",0);
			request.getSession().setAttribute("DGADMIN-VALID-OTP","FALSE");
			
			mv.addObject("USER",user);
			logger.info("--Inside getLogin()--   TYPE-->" + type1 + " USER-->" + user + " USERTYPE-->" + type
					+ " USERTYPE-->" + type + " GSTTYPE-->" + gst_type + " Auth-->" + GNID + " TokenNo-->" + TokenNo
					+ " AuthToken-->" + TokenNo + " Brow-->" + encryptData_SHA1());

			Cookie ACLog = new Cookie("id", GNID);
			ACLog.setMaxAge(86400);
			response.addCookie(ACLog);
			
			logger.info(" setting of session attribute code "+ code);

			if (type1.substring(0, 4).equalsIgnoreCase("cbec")) {
				request.getSession().setAttribute("CODE", code);
				request.getSession().setAttribute("NAME", name);
			} else {
				if (type1.substring(0, 2).equalsIgnoreCase("FO")) {
					request.getSession().setAttribute("CODE", code);
					request.getSession().setAttribute("NAME", name);
				} else {
					request.getSession().setAttribute("CODE", code);
					request.getSession().setAttribute("NAME", name);
				}
			}

			return "True";
		} else {
			return null;}
		
		}

	

	private static String encryptData_SHA1() throws UnsupportedEncodingException, NoSuchAlgorithmException,
			IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {

		String key = "ChromeWinNT770";
		MessageDigest md = MessageDigest.getInstance("SHA-1");

		byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));

		byte[] base64Bytes = Base64.getEncoder().encode(digestOfPassword);
		String base64EncryptedString = new String(base64Bytes);

	    logger.info("SHA1----EncryptedString---"+base64EncryptedString);
		return base64EncryptedString;
	}

	@GetMapping("/Captcha")
	public void getLoginFormCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info(" inside "+ (new Throwable().getStackTrace()[0].getMethodName()));
		int width = 150;
		int height = 50;
		int mod5 = 5;
		char data[] = getCaptchaAlphaString(6).toCharArray();

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics2D g2d = bufferedImage.createGraphics();

		Font font = new Font("Arial", Font.BOLD, 25);
		g2d.setFont(font);

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);
		// GradientPaint gp = new GradientPaint();
		GradientPaint gp = new GradientPaint(0, 0, Color.white, 0, height / 2, Color.pink, true);

		g2d.setPaint(gp);
		g2d.fillRect(0, 0, width, height);

		g2d.setColor(Color.red);

		Random r = new Random();
		int index = Math.abs(r.nextInt()) % mod5;

		String captcha = String.copyValueOf(data);
		request.getSession().setAttribute("captcha", captcha);

		int x = 20;
		int y = 30;

//	    for (int i=0; i<data.length; i++) {
//	        //x += 10 + (Math.abs(r.nextInt()) % 15);
//	        //y = 20 + Math.abs(r.nextInt()) % 20;
//	    	x=x+(i*5);
//	        g2d.drawChars(data, 0, data.length, x, y);
//	    }
		g2d.drawChars(data, 0, data.length, x, y);
		g2d.dispose();

		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(bufferedImage, "png", os);
		os.close();
	}

	public String randomString() {
		logger.info(" inside "+ (new Throwable().getStackTrace()[0].getMethodName()));
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();

	    logger.info("Random UUID String = " + randomUUIDString);

		return randomUUIDString;

	}

	public String encryptData_SHA512(String pass) throws UnsupportedEncodingException, NoSuchAlgorithmException,
			IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {

		logger.info(" inside "+ (new Throwable().getStackTrace()[0].getMethodName()));
		String key = pass + "ddmnic@)!$";
		MessageDigest md = MessageDigest.getInstance("SHA-512");

		byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));

		byte[] base64Bytes = Base64.getEncoder().encode(digestOfPassword);
		String base64EncryptedString = new String(base64Bytes);

		logger.info("SHA512EncryptedString---" + base64EncryptedString);
		return base64EncryptedString;
	}

	public String getCaptchaAlphaString(int n) {

		logger.info(" inside "+ (new Throwable().getStackTrace()[0].getMethodName()));
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	@PostMapping(path = "/encryptPassword")
	public @ResponseBody String encryptPassword(String pwd)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException,
			BadPaddingException, NoSuchPaddingException, InvalidKeyException {
		logger.info("--encryptPassword--pwd--" + pwd);
		String ramdomString = randomString().substring(0, 6);
		String Key1 = "ddmnic@)!$";
		String Key2 = "DESede";
		String key = Key1 + ramdomString;
		logger.info("key in encryption" + key);
		MessageDigest md = MessageDigest.getInstance("md5");

		byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));

		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

		for (int j = 0, k = 16; j < 8;) {

			keyBytes[k++] = keyBytes[j++];

		}

		SecretKey secretKey = new SecretKeySpec(keyBytes, Key2);

		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");

		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		// pwd
		byte[] plainTextBytes = pwd.getBytes("utf-8");

		byte[] buf = cipher.doFinal(plainTextBytes);

		byte[] base64Bytes = Base64.getEncoder().encode(buf);

		String base64EncryptedString = new String(base64Bytes);
		logger.info("---base64EncryptedString---" + base64EncryptedString);

		return ramdomString + base64EncryptedString;

	}

	private String decryptData(String pass) throws UnsupportedEncodingException, NoSuchAlgorithmException,
			IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {
        String key1 = "ddmnic@)!$";
        String Key2 = "DESede";
		String key = key1 + pass.substring(0, 6);
		logger.info("key in decryption" + key);
		String encryptedPassword = pass.substring(6);

		System.out
				.println("--random Number--> " + pass.substring(0, 6) + "<--encryptedPassword-->" + encryptedPassword);
		byte[] message = Base64.getDecoder().decode(encryptedPassword.getBytes("utf-8"));
		logger.info("message" + message);
		MessageDigest md = MessageDigest.getInstance("md5");

		byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
		logger.info("digestOfPassword" + digestOfPassword);
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		logger.info("keyBytes" + keyBytes);
		for (int j = 0, k = 16; j < 8;) {

			keyBytes[k++] = keyBytes[j++];

		}
		SecretKey secretKey = new SecretKeySpec(keyBytes, Key2);
		Cipher decipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		decipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] plainText = decipher.doFinal(message);
		logger.info("plainText" + plainText);
		String decryptedText = new String(plainText, "utf-8");
		logger.info("decryptedText" + decryptedText);

		return decryptedText;

	}
	@SuppressWarnings("unused")
	@GetMapping("/Logout")
	public ModelAndView getLogoutPage(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		logger.info("Inside Logout---");
		
		Object[] objArray_4 = new Object[7];
        objArray_4[0]= session.getAttribute("USER");
        objArray_4[1]= "LOGOUT";
        objArray_4[2]="MPR";
        objArray_4[3]= request.getRemoteAddr();
        objArray_4[4]= request.getSession().getId();
        objArray_4[5]= "xxx";
        objArray_4[6]= "xxx";
        
        for (int i=0 ;i < objArray_4.length; i++) {
        	System.out.print("objArray_4["+i +"]" + objArray_4[i]);
        }
        
        boolean sp_USER_LOGIN_LOG_HISTORY_Inserted = sp_USER_LOGIN_LOG_HISTORY_DaoImpl.executeProc(objArray_4);
        logger.info(" sp_USER_LOGIN_LOG_HISTORY_Inserted " + sp_USER_LOGIN_LOG_HISTORY_Inserted);
		
		
		 try
         {
			 Cookie cookies = new Cookie("ACLog","");
			 cookies.setMaxAge(0);
             
			 session.invalidate();
             
         }
         catch (Exception ex)
         {
        	 Cookie cookies = new Cookie("ACLog","");
			 cookies.setMaxAge(0);
             
			 session.invalidate();
         }
		/*
		 if(COOKIE_CHECK_ANTARANG) {
			 
				ModelAndView mv = new ModelAndView();
				mv.setViewName("Home/InvalidLogin");
				mv.addObject("message", "");
				
				return mv;
		
		 }else {
		ModelAndView mv = new ModelAndView();
		request.getSession().setAttribute("JSP_PATH_RESOLVE", JSP_PATH_RESOLVE);
		request.getSession().setAttribute("DYNAMIC_LINK_PATH", DYNAMIC_LINK_PATH);
		
		request.getSession().setAttribute("CSRF_Token", UUID.randomUUID().toString());
		mv.setViewName("Home/Login");
		mv.addObject("message", "");
      
		logger.info("Logout end---");
		return mv;
		 }
		 */
		 
		 
		 /////// Common code of Login Page
		    
		 	request.getSession().setAttribute("UI", "NEW");
			
			request.getSession().setAttribute("JSP_PATH_RESOLVE", JSP_PATH_RESOLVE);
			
			request.getSession().setAttribute("DYNAMIC_LINK_PATH", DYNAMIC_LINK_PATH);
			
			request.getSession().setAttribute("COMMON_PATH_RESOLVE", COMMON_PATH_RESOLVE);
			
			logger.info("request.getSession().getAttribute (COMMON_PATH_RESOLVE)"+ request.getSession().getAttribute("COMMON_PATH_RESOLVE"));
			
			
			logger.info("request.getSession().getId()"+ request.getSession().getId());
			request.getSession().setAttribute("CSRF_Token", UUID.randomUUID().toString());
			
			logger.info("request.getSession().getAttribute(\"CSRF_Token\").toString() "+ request.getSession().getAttribute("CSRF_Token").toString());
			
			logger.info("Before SSO ID in Cookie Check" );
			
			logger.info("COOKIE_CHECK_ANTARANG"+COOKIE_CHECK_ANTARANG );
			
			logger.info("HEADER_ANTARANG_NAME "+HEADER_ANTARANG_NAME );
			logger.info("HEADER_ANTARANG_VALUE"+HEADER_ANTARANG_VALUE );
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Home/Login");
			mv.addObject("message", "");
			
			return mv;
		 
		 
	}	
	
	
	
	public  String encryptPasswordLocal(String pwd)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException,
			BadPaddingException, NoSuchPaddingException, InvalidKeyException {
		logger.info("--encryptPassword--pwd--" + pwd);
		String ramdomString = randomString().substring(0, 6);
		String key = "ddmnic@)!$" + ramdomString;
		logger.info("key in encryption" + key);
		MessageDigest md = MessageDigest.getInstance("md5");

		byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));

		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

		for (int j = 0, k = 16; j < 8;) {

			keyBytes[k++] = keyBytes[j++];

		}

		SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");

		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");

		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		// pwd
		byte[] plainTextBytes = pwd.getBytes("utf-8");

		byte[] buf = cipher.doFinal(plainTextBytes);

		byte[] base64Bytes = Base64.getEncoder().encode(buf);

		String base64EncryptedString = new String(base64Bytes);
		logger.info("---base64EncryptedString---" + base64EncryptedString);

		return ramdomString + base64EncryptedString;

	}
		
}
