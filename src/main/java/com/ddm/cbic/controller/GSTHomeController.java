package com.ddm.cbic.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.jackson.
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.ddm.cbic.dao.implementation.SP_CHANGE_PASS_CBEC_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_CHANGE_PASS_COMM_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_CHANGE_PASS_FO_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_CHANGE_PASS_ZONE_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_REGION_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_COMM_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_GST_COMM_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_GST_ZONE_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_ZONE_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_MPR_GST_LIST_USER_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_MPR_LIST_FF_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DDM_CEX_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DDM_CUS_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DDM_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DDM_STX_GST_DaoImpl;
import com.ddm.cbic.model.SP_CHANGE_PASS_CBEC_Result;
import com.ddm.cbic.model.SP_CHANGE_PASS_COMM_GST_Result;
import com.ddm.cbic.model.SP_CHANGE_PASS_FO_Result;
import com.ddm.cbic.model.SP_CHANGE_PASS_ZONE_GST_Result;
import com.ddm.cbic.model.SP_GST_DDM_STATUS_Result;
import com.ddm.cbic.model.SP_GST_STATUS_Result;
import com.ddm.cbic.model.SP_LIST_REGION_Result;
import com.ddm.cbic.model.SP_LIST_DROPDOWN_Result;
import com.ddm.cbic.model.SP_LIST_COMM_Result;
import com.ddm.cbic.model.SP_LIST_GST_COMM_Result;
import com.ddm.cbic.model.SP_LIST_GST_ZONE_Result;
import com.ddm.cbic.model.SP_LIST_ZONE_Result;
import com.ddm.cbic.model.SP_MPR_GST_LIST_USER_Result;
import com.ddm.cbic.model.SP_MPR_LIST_FF_Result;
import com.ddm.cbic.model.SP_STATUS_GST_FF_Result;
import com.google.gson.Gson;




@Controller
@RequestMapping("/GSTHome")
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class GSTHomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(GSTHomeController.class);
	
	
	@Autowired
	private SP_CHANGE_PASS_CBEC_DaoImpl sP_CHANGE_PASS_CBEC_DaoImpl;
	@Autowired
	private SP_CHANGE_PASS_COMM_GST_DaoImpl sP_CHANGE_PASS_COMM_GST_DaoImpl;
	@Autowired
	private SP_CHANGE_PASS_FO_DaoImpl sP_CHANGE_PASS_FO_DaoImpl;
	@Autowired
	private SP_CHANGE_PASS_ZONE_GST_DaoImpl sP_CHANGE_PASS_ZONE_GST_DaoImpl;
	@Autowired 
	private SP_MPR_GST_LIST_USER_DaoImpl sP_MPR_GST_LIST_USER_DaoImpl;
	
	@Autowired 
	private SP_MPR_LIST_FF_DaoImpl sp_MPR_LIST_FF_DaoImpl;	
	
	@Autowired 
	private  SP_LIST_ZONE_DaoImpl sp_LIST_ZONE_DaoImpl;
	@Autowired 
	private  SP_LIST_COMM_DaoImpl sp_LIST_COMM_DaoImpl;	
	
	//---------------
	@Autowired
	private SP_LIST_REGION_DaoImpl sp_LIST_REGION_DaoImpl;
	
	@Autowired
	private SP_LIST_GST_ZONE_DaoImpl sp_LIST_GST_ZONE_DaoImpl;
	
	@Autowired
	private SP_LIST_GST_COMM_DaoImpl sp_LIST_GST_COMM_DaoImpl;
	
	@Autowired
	private SP_SUBMISSION_DDM_CEX_GST_DaoImpl sp_SUBMISSION_DDM_CEX_GST_DaoImpl;

	@Autowired
	private SP_SUBMISSION_DDM_CUS_GST_DaoImpl sp_SUBMISSION_DDM_CUS_GST_DaoImpl;
	
	@Autowired
	private SP_SUBMISSION_DDM_STX_GST_DaoImpl sp_SUBMISSION_DDM_STX_GST_DaoImpl;
	
	@Autowired
	private SP_SUBMISSION_DDM_GST_DaoImpl sp_SUBMISSION_DDM_GST_DaoImpl;
	
	@Autowired
	private HttpServletRequest autoWiredReq;
	
	// @RequestMapping(value = "/Report", method = RequestMethod.GET)
	@RequestMapping(value = "/Report/{request_CSRF_Token}", method = RequestMethod.GET)	
	public ModelAndView Report(HttpServletRequest request, HttpServletResponse response,@PathVariable("request_CSRF_Token") String request_CSRF_Token)
    {
		logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token"+ request_CSRF_Token);
		if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {
		
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		// mv.setViewName("GSTHome/Home");
		 mv.setViewName("GSTHome/Report");
		 mv.addObject("message", "");
		 request.getSession().setAttribute("ModelAndView", mv);		         
        return mv;
		}
	    else {
				request.getSession().invalidate();
				ModelAndView mv = new ModelAndView();
				 
				 mv.setViewName("GSTDOV/ResourceNotFound");
				 mv.addObject("message", "");
				 
		       return mv;
			}  

    }
	
	
	//@RequestMapping(value = "/Insert", method = RequestMethod.GET)
	@RequestMapping(value = "/Insert/{request_CSRF_Token}", method = RequestMethod.GET)	
	public ModelAndView Insert(HttpServletRequest request, HttpServletResponse response,@PathVariable("request_CSRF_Token") String request_CSRF_Token)
    {
		logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token"+ request_CSRF_Token);
		
		if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {
		
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		 mv.setViewName("GSTHome/Insert");
		 mv.addObject("message", "");
		 request.getSession().setAttribute("ModelAndView", mv);
        return mv;
		}
	    else {
				request.getSession().invalidate();
				ModelAndView mv = new ModelAndView();
				 
				 mv.setViewName("GSTDOV/ResourceNotFound");
				 mv.addObject("message", "");
				 
		       return mv;
			}  
    }
	
	
	
	//@PostMapping("/ApplicationDesk")
	@RequestMapping(value = "/ApplicationDesk", method = RequestMethod.GET)
	public ModelAndView ApplicationDesk(HttpServletRequest request, HttpServletResponse response)
    {
		
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type); 
		 mv.setViewName("GSTHome/ApplicationDesk");
		 request.getSession().setAttribute("ModelAndView", mv);
        return mv;
    }
	
	@RequestMapping(value = "/ChangePassword", method = RequestMethod.GET)
	public ModelAndView ChangePassword(HttpServletRequest request, HttpServletResponse response)
    {
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		 mv.setViewName("GSTHome/ChangePassword");
		 mv.addObject("message", "");
		 request.getSession().setAttribute("ModelAndView", mv);
        return mv;
    }
	
	@RequestMapping(value = "/PasswordChange", method = RequestMethod.POST)
	public ModelAndView PasswordChange(HttpServletRequest request, HttpServletResponse response)
    {
		 ModelAndView mv = new ModelAndView();
		try {
		
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		String old_pass = (String)request.getParameter("txt_OldPass");
		String new_pass = (String)request.getParameter("txt_pass");
		String result = "";
		
		old_pass= new LoginController().encryptData_SHA512(old_pass);
		new_pass= new LoginController().encryptData_SHA512(new_pass);
		
		
		
		//System.out.println("old pass encryptedPassSHA512---"+old_pass);
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		//System.out.println("new pass encryptedPassSHA512---"+new_pass);
		 
		SP_CHANGE_PASS_CBEC_Result sP_CHANGE_PASS_CBEC_Result=null;
		SP_CHANGE_PASS_FO_Result sP_CHANGE_PASS_FO_Result=null;
		SP_CHANGE_PASS_COMM_GST_Result sP_CHANGE_PASS_COMM_GST_Result=null;
		SP_CHANGE_PASS_ZONE_GST_Result sP_CHANGE_PASS_ZONE_GST_Result=null;
		
		
		 request.getSession().setAttribute("ModelAndView", mv);
		 Object[] objArray = new Object[3];
		 if (userId.toString().substring(6).equalsIgnoreCase("cbec")) {
			 objArray[0]=userId;
			 objArray[1]=old_pass;
			 objArray[2]=new_pass;
			 sP_CHANGE_PASS_CBEC_Result = sP_CHANGE_PASS_CBEC_DaoImpl.generateResultBean(objArray);
			 result = sP_CHANGE_PASS_CBEC_Result.getP_RESULT();
			 
		 }else if (userId.toString().substring(6).equalsIgnoreCase("gnrl")) {
			 objArray[0]=userId;
			 objArray[1]=old_pass;
			 objArray[2]=new_pass;
			 sP_CHANGE_PASS_FO_Result = sP_CHANGE_PASS_FO_DaoImpl.generateResultBean(objArray);
			 result = sP_CHANGE_PASS_FO_Result.getP_RESULT();
		 }else if (userId.toString().substring(6).equalsIgnoreCase("admn")) {
			 String commcode = userId.substring(3, 5);
        	 
        	 objArray[0]=commcode;
			 objArray[1]=old_pass;
			 objArray[2]=new_pass;
			 sP_CHANGE_PASS_COMM_GST_Result = sP_CHANGE_PASS_COMM_GST_DaoImpl.generateResultBean(objArray);
	         result = sP_CHANGE_PASS_COMM_GST_Result.getP_RESULT();
	     }else if (userId.toString().substring(6).equalsIgnoreCase("zone")) {
	    	 String zonecode = userId.substring(3, 5);
        	 
        	 objArray[0]=zonecode;
			 objArray[1]=old_pass;
			 objArray[2]=new_pass;
	    	 sP_CHANGE_PASS_ZONE_GST_Result = sP_CHANGE_PASS_ZONE_GST_DaoImpl.generateResultBean(objArray);
	    	 result = sP_CHANGE_PASS_ZONE_GST_Result.getP_RESULT();
	     }
		 mv.addObject("message", result);
			
			 mv.setViewName("GSTHome/ChangePassword");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return mv;
    }
	
	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public ModelAndView KPI_Home(HttpServletRequest request, HttpServletResponse response)
    {
		logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token"+ request.getParameter("request_CSRF_Token").toString());
		if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request.getParameter("request_CSRF_Token").toString())) {
		
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		
		String encryptedString = request.getParameter("txtpwd").toString();
		String decryptedString = "";
		try {
		 decryptedString = com.ddm.cbic.security.RSAUtil.decrypt(encryptedString, "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCRZdVpY8go1krvWex+PIgXjwdvFwoKjM255t4glvE1WwrzRL0Kgcy+mDIThMU+F+R4OwzpLGzH5ts+THw1oIbN44NUaIsTy6PvX2buFKcZsfym7wfSmr1cy7vd9yb01FC4eMl+gypnEU2q4qCSb/mkQFyqTWurbjT62h5ueygK7vUQL8vi7ZWIa5MPBCJQwDCjSzh2esmC2FqiDXVWL11TODyFYr+32UrybzY44XbTyLGDTut62jySy9kc4YNgcnso5kfedszbifW1RgDGhd71q0/zLZUsnLvHlYkurSh9vMV9SD4+pE3M9jm3JQY1VjCAE9+8Lf30znd1Tk5eL9yzAgMBAAECggEAaksfHF/VCX235IlB6fuIpmhqz9zw+0t6bqiHxR10E0SOmc+rv82qh7+uBDTxGXbQENFim+hdUjrEFyRFPdMwGb502TVgT0V1gF6nWfABRTiocsWWW3HCc9+BZUD02tGIfYPYEkQDsLumowHwz31K7Lgcxme5CeeUlbr1umEQogR3G64uflfL/Y3JngALUD9mCIRn4oskSmUVZXKnEOa3zh8C6A7ottKODcE8Qa8JGvlIb7VC75i1cLpmbxfFngpzxb/1K1e/TBSF+mlUj6GsNa2CDTiVpL1LYiA7YLCQyGrEheCCf88Vt8X51X19ISQzTk5tkNc9R/SvvOw3IljnIQKBgQDlOY9ID28AmQHxdAsKhonkOOXsUDWiqJiKQXt1ZZzpFzHxc3QzYDjVIlUUzB2qyW46Ig6VeH7r6rsPbwIx5u3NJEQk/0iRTB18v4EgF/LuNg3HdFaxFc0WuGqBy907yCl/fgNJ+RqkI/KdNyyrPsaY0MNLO8yyqZrLaOPq7PIP4wKBgQCiYZ6CoxwgHTM1np5xdAhS4aITHbMNa9LovrJS2QwFCYK0ggHdgJC1gK8W4LNui1vHUJe7Xwl/yXIWXNzEB4fSlLBE/1pKIzVBUN1DrSVmRW16PxoSf67n9FICrHVZTi4+ZqUVGUrnT6/8gpTNVlC7dIIr38IIZ/F8qq6/41n48QKBgD1pXF+78stAMusTYdniDZNdQww6uQPpE2UHAiKDpLQ2CKVdfyY8gz1mw1CdFt2otaVRdoLJE4f1DUSnQvlHmzI4oyEeW7zBnazMSbXldKopRSvImWk8JAQQSEiZ652WlLeZdRweZurOzrMcExWV7fMHCytezAqZseUJJvbLoFZtAoGACU5m8z294ulJgg0xL3di8r0TuNy+4koHsGcdeToPQkqlPwskaDlyEbTqU/lUz0UVYXrw90AfHz/AVh/EV0fHNP5oi8vGtPEHoFKuG67UsePQvmzXZbADqi+Kc7TGlPOyGslvNKJadJ9QirxBIvOLdPLccv9D849he6+cjErPYUECgYAOC+HUlLSFb++Fy5jvJfcmGsr2JFl49PSCEGhXv4vs11nMovmzVxtggZbS9KitV286apBIUIwfBd+OAJb0KJoDrpMdMjZ/9b/WE4jrx8q42UBBtRheNWKIVsuXSl2F3g5Uyu7iFdxGKEE2mHD0nqtd/Iryfncu8u7MR/OWct7Pxg==");
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
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		 mv.setViewName("GSTHome/Home");
		 request.getSession().setAttribute("ModelAndView", mv);
        return mv;
		}
	    else {
				request.getSession().invalidate();
				ModelAndView mv = new ModelAndView();
				 
				 mv.setViewName("GSTDOV/ResourceNotFound");
				 mv.addObject("message", "");
				 
		       return mv;
			}  
    }
	
	
	//@RequestMapping(value = "/Left_Menu_Home", method = RequestMethod.GET)
	@RequestMapping(value = "/Left_Menu_Home/{request_CSRF_Token}", method = RequestMethod.GET)	
	public ModelAndView KPI_Home_from_left_menu(HttpServletRequest request, HttpServletResponse response,@PathVariable("request_CSRF_Token") String request_CSRF_Token)
    {
		logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token"+ request_CSRF_Token);
		if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {
		
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		 mv.setViewName("GSTHome/Home");
		 request.getSession().setAttribute("ModelAndView", mv);
        return mv;
		}
	    else {
				request.getSession().invalidate();
				ModelAndView mv = new ModelAndView();
				 
				 mv.setViewName("GSTDOV/ResourceNotFound");
				 mv.addObject("message", "");
				 
		       return mv;
			}  
    }
	
	
	
	@RequestMapping(value = "/DeskHome", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response)
    {
		
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		// mv.setViewName("GSTHome/Home");
		 mv.setViewName("GSTHome/Home");
		 mv.addObject("message", "");
		 request.getSession().setAttribute("ModelAndView", mv);
        return mv;
    }
	
	@RequestMapping(value = "/Region_Bind", method = RequestMethod.GET)
	public @ResponseBody JSONObject Region_Bind()
    {
		
		List<SP_LIST_REGION_Result> gstList = new ArrayList<SP_LIST_REGION_Result>();
    	
    	gstList = sp_LIST_REGION_DaoImpl.generateResultBeanList();    	
    	String json = null;
    	try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(gstList);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	
       	JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("gstRegionList", json);
			} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
        
    }
	
	@RequestMapping(value = "/Zone_Bind", method = RequestMethod.GET)
	public @ResponseBody JSONObject Zone_Bind(String dep)
    {
		
		List<SP_LIST_GST_ZONE_Result> gstList = new ArrayList<SP_LIST_GST_ZONE_Result>();
		if(dep.equalsIgnoreCase("null"))
		{
			dep=null;
		}
		Object[] objArray = new Object[1];
    	objArray[0]=dep;
    	
    	gstList = sp_LIST_GST_ZONE_DaoImpl.generateResultBeanList(objArray);    	
    	String json = null;
    	try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(gstList);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	
       	JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("gstZoneList", json);
			} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
        
    }	
	
	@RequestMapping(value = "/Comm_Bind", method = RequestMethod.GET)
	public @ResponseBody JSONObject Comm_Bind(String zone,String dep)
    {
		
		List<SP_LIST_GST_COMM_Result> listGstComm = new ArrayList<SP_LIST_GST_COMM_Result>();
		Object[] objArray = new Object[2];
		if(null != dep) { 	
			objArray[0]=dep;
			
			if(dep.trim().length()==0) {
				
				objArray[0]= null;
			}
		
		}
		else {
			objArray[0]=null;
			}
		if(null != zone) {
			objArray[1]=zone;
			}
		else {
			objArray[1]=null;
			}
    	
    	listGstComm = sp_LIST_GST_COMM_DaoImpl.generateResultBeanList(objArray);
    	
    	String json = null;
    	try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(listGstComm);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       	JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("gstCommList", json);
			} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
        
    }
	
		
	//@PostMapping(path = "/ReportBind")
	@RequestMapping(value = "/ReportBind", method = RequestMethod.GET )
	public @ResponseBody JSONObject ReportBind(String comm,String dep, String type,String zone)
    {	
		if(null != type) {}else {type="";}
		//String type ="";
		JSONObject jsonObj = new JSONObject();
		
		String json= null;
		try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(jsonObj);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mpr1 = "[]";
		String mpr2 = "[]";
		String mpr3 = "[]";
		String mpr4 = "[]";
		String mpr5 = "[]";
		String mpr6 = "[]";
		String mpr7 = "[]";
		String mpr8 = "[]";
		String mpr9 = "[]";
        String mpr10 = "[]";
        String mpr11 = "[]";
		
		
		//if (!string.IsNullOrEmpty(comm) && !string.IsNullOrEmpty(dep))
		if (((null !=comm) && (comm.trim().length() > 0))&&((null != dep) && (dep.trim().length() > 0)))
        {
			 
            logger.info("Inside  comm and dep not blank not null block---");
            logger.info("comm---"+comm);
            logger.info("dep---"+dep);
            logger.info("zone---"+zone);
            mpr1 = mprListUser(dep, "Part-I Revenue", comm, zone, dep + "_Part_1",type);
            mpr2 = mprListUser(dep, "Part-II Anti-smuggling", comm, zone, "CUS_Part_2",type); 
            if (dep.equalsIgnoreCase("CEX") || dep.equalsIgnoreCase("STX") || dep.equalsIgnoreCase("GST"))
            {
            mpr3 = mprListUser(dep, "Part-III Anti-evasion", comm, zone, dep + "_Part_3",type);  
            }
            mpr4 = mprListUser(dep, "Part-IV Audit", comm, zone, dep + "_Part_4",type);
            mpr5 = mprListUser(dep, "Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous", comm, zone, dep + "_Part_5",type);
            mpr6 = mprListUser(dep, "Part-VI Valuation", comm, zone, "CUS_Part_6",type);
            mpr7 = mprListUser(dep, "Part-VII Legal", comm, zone, dep + "_Part_7",type);
            mpr8 = mprListUser(dep, "Part-VIII Arrears", comm, zone, dep + "_Part_8",type);            
            mpr9 = mprListUser(dep, "Part-IX Logistics", comm, zone, "CUS_Part_9",type);
            if (dep.equalsIgnoreCase("GST"))
            {
            mpr10 = mprListUser(dep, "Part-X Withdrawal of Departmental Appeals", comm, zone, dep + "_Part_10",type);
            mpr11 = mprListUser(dep, "Part-XI Refund granted to UIN entities", comm, zone, dep + "_Part_11",type);
            }
            
        }
        else
        {
        	logger.info("zone--"+zone);
        	logger.info("comm--"+comm);
        	logger.info("dep--"+dep);
        	if((null != comm)&&(comm.length()>0))
            {
            	
                if (dep.length() == 0)
                {
                    dep = "null";
                }                
                mpr1 = mprListFF("Part-I Revenue", comm,dep,type);
                mpr2 = mprListFF("Part-II Anti-smuggling", comm,dep,type);               
                mpr3 = mprListFF("Part-III Anti-evasion", comm,dep,type);
                mpr4 = mprListFF("Part-IV Audit", comm,dep,type);
                mpr5 = mprListFF("Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous", comm,dep,type);
                mpr6 = mprListFF("Part-VI Valuation", comm,dep,type);
                mpr7 = mprListFF("Part-VII Legal", comm,dep,type);
                mpr8 = mprListFF("Part-VIII Arrears", comm,dep,type);
                mpr9 = mprListFF("Part-IX Logistics", comm,dep,type);
                if (dep.trim().equalsIgnoreCase("GST")  || ((null == dep) || (dep.length() == 0)))
                {
                mpr10 = mprListFF("Part-X Withdrawal of Departmental Appeals", comm,dep,type);
                mpr11 = mprListFF("Part-XI Refund granted to UIN entities", comm,dep,type);
                }
               
            }
            else
            {
            	
            	logger.info("zone--"+zone);
            	logger.info("comm--"+comm);
            	logger.info("dep--"+dep);
            	logger.info("Inside else comm equal blenk or null");
                if (zone.trim().length() == 0)
                {
                    zone = "null";
                }
                if (comm.trim().length() == 0)
                {
                    comm = "null";
                }
                if (dep.trim().length() == 0)
                {
                    dep = "null";
                }
             
                mpr1 = mprListUser(dep, "Part-I Revenue", comm, zone, null,type);
                mpr2 = mprListUser(dep, "Part-II Anti-smuggling", comm, zone, null,type);
                mpr3 = mprListUser(dep, "Part-III Anti-evasion", comm, zone, null,type);
                mpr4 = mprListUser(dep, "Part-IV Audit", comm, zone, null,type);
                mpr5 = mprListUser(dep, "Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous", comm, zone, null,type);
                mpr6 = mprListUser(dep, "Part-VI Valuation", comm, zone, null,type);
                mpr7 = mprListUser(dep, "Part-VII Legal", comm, zone, null,type);
                mpr8 = mprListUser(dep, "Part-VIII Arrears", comm, zone, null,type);
                mpr9 = mprListUser(dep, "Part-IX Logistics", comm, zone, null,type);  
                if (dep.trim().equalsIgnoreCase("GST")  || ((null == dep) || (dep.length() == 0)))
                {
                mpr10 = mprListUser(dep, "Part-X Withdrawal of Departmental Appeals", comm, zone, null,type);
                mpr11 = mprListUser(dep, "Part-XI Refund granted to UIN entities", comm, zone, null,type);
                }
            }
        }
		
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("data1", mpr1);
			jsonObject.put("data2", mpr2);
			jsonObject.put("data3", mpr3);
			jsonObject.put("data4", mpr4);
			jsonObject.put("data5", mpr5);
			jsonObject.put("data6", mpr6);
			jsonObject.put("data7", mpr7);
			jsonObject.put("data8", mpr8);
			jsonObject.put("data9", mpr9);
			jsonObject.put("data10", mpr10);
			jsonObject.put("data11", mpr11);
			logger.info("jsonObject.get(data1)----> in ReportBind" + jsonObject.get("data1")  );
			logger.info("jsonObject.get(data2)----> in ReportBind" + jsonObject.get("data2")  );
			logger.info("jsonObject.get(data3)----> in ReportBind" + jsonObject.get("data3")  );
			logger.info("jsonObject.get(data4)----> in ReportBind" + jsonObject.get("data4")  );
			logger.info("jsonObject.get(data5)----> in ReportBind" + jsonObject.get("data5")  );
			logger.info("jsonObject.get(data6)----> in ReportBind" + jsonObject.get("data6")  );
			logger.info("jsonObject.get(data7)----> in ReportBind" + jsonObject.get("data7")  );
			logger.info("jsonObject.get(data8)----> in ReportBind" + jsonObject.get("data8")  );
			logger.info("jsonObject.get(data9)----> in ReportBind" + jsonObject.get("data9")  );
			logger.info("jsonObject.get(data10)----> in ReportBind" + jsonObject.get("data10")  );
			logger.info("jsonObject.get(data11)----> in ReportBind" + jsonObject.get("data11")  );
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
		
      // return json;
		
    }
	

	public String mprListUser(String dep, String groupName,String comm,String zone,String part,String type) {
		
		List<SP_MPR_GST_LIST_USER_Result> mprList;
		List<SP_MPR_GST_LIST_USER_Result> mprListUser =  new ArrayList<SP_MPR_GST_LIST_USER_Result>();
				
		//String mpr1 = "";
		String json = "";
		Object[] objArray = new Object[5];
    	objArray[0]=dep;
    	objArray[1]=groupName;
    	objArray[2]=comm; //comm
    	objArray[3]=zone; //
    	objArray[4]=part;
    	logger.info("dep in MprListUser--->  "+dep);
    	logger.info("group name in MprListUser--->  "+groupName);
    	logger.info("comm in MprListUser--->  "+comm);    	
    	logger.info("zone name in MprListUser--->  "+zone);
    	logger.info("part name in MprListUser--->  "+part);
    	
    	mprListUser = sP_MPR_GST_LIST_USER_DaoImpl.generateResultBeanList(objArray);
    	    	
        //List<SP_MPR_GST_LIST_USER_Result> originalList = sP_MPR_GST_LIST_USER_DaoImpl.generateResultBeanList(objArray);                
        if(groupName.equalsIgnoreCase("Part-I Revenue"))
        {
        	if(dep.equalsIgnoreCase("CEX") || ((null == dep) || (dep.length() == 0)))
        	{
        		mprList = mprListUser.stream()
        				.filter(employee -> !employee.getCODE().equalsIgnoreCase("DDM-CE-6"))
        				.collect(Collectors.toList());
        	}
        	else if (dep.equalsIgnoreCase("CUS") || ((null == dep) || (dep.length() == 0)))
            {
        		mprList = mprListUser.stream()
        				.filter(employee -> !employee.getCODE().equalsIgnoreCase("DDM-CUS-1") && !employee.getCODE().equalsIgnoreCase("DDM-CUS-6"))
        				.collect(Collectors.toList());
            }
        	else if (dep.equalsIgnoreCase("GST") || ((null == dep) || (dep.length() == 0)))
            {
        		mprList = mprListUser;
            }
        	else
        	{
        		mprList = mprListUser.stream()
        				.filter(employee -> employee.getCODE().equalsIgnoreCase("DDM-ST-1") || employee.getCODE().equalsIgnoreCase("DDM-ST-5"))
        				.collect(Collectors.toList());
        	}
        }
        else if(groupName.equalsIgnoreCase("Part-III Anti-evasion"))
        {
        	if (dep.equalsIgnoreCase("CEX") || dep.equalsIgnoreCase("STX") || ((null == dep) || (dep.length() == 0)))
            {
        		mprList = mprListUser;
            }
        	else if (dep.equalsIgnoreCase("GST") || ((null == dep) || (dep.length() == 0)))
            {
                if (type.equalsIgnoreCase("Insert"))
                {
                	mprList = mprListUser;
                }
                else
                {
                	mprList = mprListUser.stream()
            				.filter(employee -> !employee.getCODE().equalsIgnoreCase("CEI-GST-12B") && !employee.getCODE().equalsIgnoreCase("CEI-GST-12C") && !employee.getCODE().equalsIgnoreCase("GI-GST-1A"))
            				.collect(Collectors.toList());                   
                }
            }
        	else
        	{
        		mprList = mprListUser;
        	}
        }
        else if(groupName.equalsIgnoreCase("Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous"))
        {
        	if (dep.equalsIgnoreCase("CEX") || dep.equalsIgnoreCase("STX") || ((null == dep) || (dep.length() == 0)))
            {
        		mprList = mprListUser;
            }
        	else if (dep.equalsIgnoreCase("GST") || ((null == dep) || (dep.length() == 0)))
            {
        		if (type.equalsIgnoreCase("Insert"))
	            {
        			mprList = mprListUser;
	            }
	        	else
	        	{
	        		mprList = mprListUser.stream()
	        				.filter(employee -> !employee.getCODE().equalsIgnoreCase("DPM-GST-14B") && !employee.getCODE().equalsIgnoreCase("DPM-GST-15B") && !employee.getCODE().equalsIgnoreCase("DPM-GST-15C"))
	        				.collect(Collectors.toList());
	        		
	        	}
            }
        	else
        	{
        		mprList = mprListUser;
        	}
        }
        else if(groupName.equalsIgnoreCase("Part-VIII Arrears"))
        {
        	if (type.equalsIgnoreCase("Insert"))
            {
        		mprList = mprListUser.stream()
        				.filter(employee -> !employee.getCODE().equalsIgnoreCase("TAR-CE-6") && !employee.getCODE().equalsIgnoreCase("TAR-CUS-6") && !employee.getCODE().equalsIgnoreCase("TAR-ST-6") && !employee.getCODE().equalsIgnoreCase("TAR-GST-6"))
        				.collect(Collectors.toList());
            }
        	else
        	{
        		mprList = mprListUser;
        	}
        }
        else
        {
        	mprList = mprListUser;
        }
    	
    	//logger.info("mprListUser size  "+mprListUser.size());
    	logger.info("mprList size  "+mprList.size());    	
    	try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(mprList);
          //JsonArray jsonArray = new Jsojson.getAsJsonArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	logger.info("json list--"+json);
       	return json;
	}

	
	public String mprListFF(String groupName,String comm,String dep,String type) {		
		
		List<SP_MPR_LIST_FF_Result> mprList;
		List<SP_MPR_LIST_FF_Result> mprListFF =  new ArrayList<SP_MPR_LIST_FF_Result>();
		
		String json = "";
		Object[] objArray = new Object[2];
    	objArray[0]=groupName;
    	objArray[1]=comm;
    	logger.info("group name in MprListFF--->  "+groupName);
    	logger.info("comm in MprListFF--->  "+comm);
    	logger.info("dep in MprListFF--->  "+dep);
    	logger.info("type in MprListFF--->  "+type); 
		
    	mprListFF = sp_MPR_LIST_FF_DaoImpl.generateResultBeanList(objArray);
    	logger.info("mprListFF size  "+mprListFF.size());
    	if(groupName.equalsIgnoreCase("Part-I Revenue"))
        {
        	if(dep.equalsIgnoreCase("CEX") || (null == dep) || (dep.length() == 0))
        	{
        		mprList = mprListFF.stream()
        				.filter(employee -> !employee.getCODE().equalsIgnoreCase("DDM-CE-6"))
        				.collect(Collectors.toList());
        	}
        	else if (dep.equalsIgnoreCase("CUS") || (null == dep) || (dep.length() == 0))
            {
        		mprList = mprListFF.stream()
        				.filter(employee -> !employee.getCODE().equalsIgnoreCase("DDM-CUS-1") && !employee.getCODE().equalsIgnoreCase("DDM-CUS-6"))
        				.collect(Collectors.toList());
            }
        	else if (dep.equalsIgnoreCase("GST") || (null == dep) || (dep.length() == 0))
            {
        		mprList = mprListFF;
            }
        	else
        	{
        		mprList = mprListFF.stream()
        				.filter(employee -> employee.getCODE().equalsIgnoreCase("DDM-ST-1") || employee.getCODE().equalsIgnoreCase("DDM-ST-5"))
        				.collect(Collectors.toList());
        	}
        }
        else if(groupName.equalsIgnoreCase("Part-III Anti-evasion"))
        {
        	if (dep.equalsIgnoreCase("CEX") || dep.equalsIgnoreCase("STX") || (null == dep) || (dep.length() == 0))
            {
        		mprList = mprListFF;
            }
        	else if (dep.equalsIgnoreCase("GST") || (null == dep) || (dep.length() == 0))
            {
                if (type.equalsIgnoreCase("Insert"))
                {
                	mprList = mprListFF;
                }
                else
                {
                	mprList = mprListFF.stream()
            				.filter(employee -> !employee.getCODE().equalsIgnoreCase("CEI-GST-12B") && !employee.getCODE().equalsIgnoreCase("CEI-GST-12C") && !employee.getCODE().equalsIgnoreCase("GI-GST-1A"))
            				.collect(Collectors.toList());                   
                }
            }
        	else
        	{
        		mprList = mprListFF;
        	}
        } 
    	
        else if(groupName.equalsIgnoreCase("Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous"))
        {
        	if (dep.equalsIgnoreCase("CEX") || dep.equalsIgnoreCase("STX") || (null == dep) || (dep.length() == 0))
            {
        		mprList = mprListFF;
            }
        	else if (dep.equalsIgnoreCase("GST") || (null == dep) || (dep.length() == 0))
            {
                if (type.equalsIgnoreCase("Insert"))
                {
                	mprList = mprListFF;
                }
                else
                {
                	mprList = mprListFF.stream()
            				.filter(employee -> !employee.getCODE().equalsIgnoreCase("DPM-GST-14B") && !employee.getCODE().equalsIgnoreCase("DPM-GST-15B") && !employee.getCODE().equalsIgnoreCase("DPM-GST-15C"))
            				.collect(Collectors.toList());                   
                }
            }
        	else
        	{
        		mprList = mprListFF;
        	}
        } 
        else
        {
        	mprList = mprListFF;
        }
    	
    	logger.info("mprList size  "+mprList.size());    	
    	try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(mprList);
          //JsonArray jsonArray = new Jsojson.getAsJsonArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	logger.info("json list--"+json);
       	return json;
	}
	
	@RequestMapping(value = "/Report_Redirect", method = RequestMethod.GET)
	public @ResponseBody String Report_Redirect(String dep,String zone_code,String zone_name,String comm_code,String comm_name, String month,String year,String Report_Name)
    {
		logger.info("in Report_Redirect action");
		logger.info("in Report_Redirect action zone--"+zone_name);
		logger.info("in Report_Redirect action dep--"+dep);
		String url = "";		
		//if ((!string.IsNullOrEmpty(month)) && (!string.IsNullOrEmpty(year)))
		if(((null != month )&&(month.trim().length()> 0))&&((null != year )&&(year.trim().length()> 0)))
        {
            String viewname = Report_Name.replace("-", "_");
            if (viewname.trim().equalsIgnoreCase("DOL_CUS_1_OTHERS") || viewname.trim().equalsIgnoreCase("DOL_CUS_3_OTHERS") || viewname.trim().equalsIgnoreCase("DOL_CUS_4_OTHERS"))
            {
                viewname = viewname.replace("_OTHERS", "");
            }
            if (viewname.trim().equalsIgnoreCase("DLA_ALL_X"))
            {
                viewname = viewname.replace("DLA_ALL_X", "DLA_ALL_D");
            }
            if (viewname.trim().equalsIgnoreCase("DDM_CUS_1"))
            {
                viewname = viewname.replace("DDM_CUS_1", "DDM_CUS_1A");
            }
            if (viewname.trim().equalsIgnoreCase("DDM_CUS_1_OLD"))
            {
                viewname = viewname.replace("DDM_CUS_1_OLD", "DDM_CUS_1");
            }
            
            if (viewname.trim().equalsIgnoreCase("DGA_CE_1"))
            {
                viewname = viewname.replace("DGA_CE_1", "DGA_CE_1_1");
            }
            if (viewname.trim().equalsIgnoreCase("DGA_CE_1A"))
            {
                viewname = viewname.replace("DGA_CE_1A", "DGA_CE_1A_1");
            }
            
            if (viewname.trim().equalsIgnoreCase("DGA_ST_1"))
            {
                viewname = viewname.replace("DGA_ST_1", "DGA_ST_1_1");
            }
            if (viewname.trim().equalsIgnoreCase("DGA_ST_1A"))
            {
                viewname = viewname.replace("DGA_ST_1A", "DGA_ST_1A_1");
            }
            
            String r_name = "";
            if(viewname.trim().substring(0, 2).equalsIgnoreCase("GI"))
            {
            	 r_name = Report_Name.trim().substring(0, 2);
            }
            else
            {
            	 r_name = Report_Name.trim().substring(0, 3);
            }

            //String r_name = Report_Name.trim().substring(0, 3);
            String Report_Type = "";
            String MM_YYYY = year.trim() + '-' + month.trim();
            String Code = "0";
            

            if(((null == zone_code )||(zone_code.trim().length()== 0)))
            {
                Report_Type = "All";
                Report_Name = "All India";
                url = "/" + "GST" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
                //return RedirectToAction(viewname, r_name + "/Report", new { Report_Type = Report_Type, Report_Name = Report_Name, Code = Code, MM_YYYY = MM_YYYY });
            }

           else if( ((null != zone_code )&&(zone_code.trim().length()> 0))&&((null != zone_name )&&(zone_name.trim().length()> 0))&&((null == comm_code )||(comm_code.trim().length()== 0)) )
            {
            	Code = zone_code;
                Report_Type = "Zone";
                Report_Name = zone_name;
                url = "/" + "GST" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
            }

            else if ( ((null != comm_code )&&(comm_code.trim().length()> 0))&&((null != comm_name )&&(comm_name.trim().length()> 0)))
            {
            	Code = comm_code;
                Report_Type = "Comm";
                Report_Name = comm_name;
                url = "/" + "GST" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
                //return RedirectToAction(viewname, r_name + "/Report", new { Report_Type = Report_Type, Report_Name = Report_Name, Code = Code, MM_YYYY = MM_YYYY });                
            }
            else
            {
               // return RedirectToAction("Index");
            }

            //return Json(url);
        }
        else
        {
            //return RedirectToAction("Index");

        }
		return url;
        
    }

	
	@RequestMapping(value = "/ZoneBind", method = RequestMethod.GET)
	public @ResponseBody JSONObject ZoneBind(String dep)
    {
		
		List<SP_LIST_ZONE_Result> gstList = new ArrayList<SP_LIST_ZONE_Result>();
		Object[] objArray = new Object[1];
    	objArray[0]=dep;
    	
    	gstList = sp_LIST_ZONE_DaoImpl.generateResultBeanList(objArray);    	
    	String json = null;
    	try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(gstList);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
       	JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("gstZoneList", json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
        
    }
	
	/* @RequestMapping(value = "/CommBind", method = RequestMethod.GET)
	public @ResponseBody JSONObject CommBind(String zone,String dep)
    {
		System.out.println("in CommBind action");
		System.out.println("in CommBind action zone--"+zone);
		System.out.println("in CommBind action dep--"+dep);
		List<SP_LIST_COMM_Result> listGstComm = new ArrayList<SP_LIST_COMM_Result>();
		Object[] objArray = new Object[2];
    	objArray[0]=dep;
    	objArray[1]=zone;
    	listGstComm = sp_LIST_COMM_DaoImpl.generateResultBeanList(objArray);
    	
    	String json = null;
    	try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(listGstComm);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	System.out.println("zone list--"+json);
       	JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("gstCommList", json);
			System.out.println("jsonObject.get(JSONObject)---->in CommBind " + jsonObject.get("gstCommList"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
        
    }
    
    */
	
	@RequestMapping(value = "/CommBind", method = RequestMethod.GET)
	public @ResponseBody JSONObject CommBind(String zone,String dep)
    {
		
		List<SP_LIST_GST_COMM_Result> listGstComm = new ArrayList<SP_LIST_GST_COMM_Result>();
		Object[] objArray = new Object[2];
		if(null != dep) { 	
			objArray[0]=dep;
			
			if(dep.trim().length()==0) {
				
				objArray[0]= null;
			}
		
		}else {objArray[0]=null;}
		if(null != zone) {objArray[1]=zone;}else {objArray[1]=null;}
    	
    	listGstComm = sp_LIST_GST_COMM_DaoImpl.generateResultBeanList(objArray);
    	
    	String json = null;
    	try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(listGstComm);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       	JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("gstCommList", json);
			} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
        
    }
	
	@RequestMapping(value = "/ReportRedirect", method = RequestMethod.GET)
	public @ResponseBody String ReportRedirect(String dep,String zone_code, String zone_name, String comm_code, String comm_name, String month, String year, String Report_Name)
    {
	
		
		String r_name = Report_Name.substring(0, 3);
		String Report_Type = "All";
		String MM_YYYY = year + '-' + month;
		String Code = "0";
		String url = "";
		String viewname = Report_Name.replace("-", "_");
		url = "/MIS/GSTHome/" + "GST" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
       	
		//JSONObject jsonObject = new JSONObject();
		
        return url;	
        
    }
	
	
	//@RequestMapping(value = "/MSR", method = RequestMethod.GET)
	@RequestMapping(value = "/MSR/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView MSR(HttpServletRequest request, HttpServletResponse response,@PathVariable("request_CSRF_Token") String request_CSRF_Token)
    {
		logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token"+ request_CSRF_Token);
		if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {	
		
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		 mv.setViewName("GSTHome/MSR");
		 mv.addObject("message", "");
		 request.getSession().setAttribute("ModelAndView", mv);
        return mv;
		}
	    else {
				request.getSession().invalidate();
				ModelAndView mv = new ModelAndView();
				 
				 mv.setViewName("GSTDOV/ResourceNotFound");
				 mv.addObject("message", "");
				 
		       return mv;
			}
    }
	@RequestMapping(value = "/ReportRedirect1", method = RequestMethod.GET)
	public @ResponseBody String ReportRedirect1(String Report_Name,String year, String month )
    {
	
		
		//String MM_YYYY = year + '-' + month;
		
		//url = "/MIS/GSTHome/" + "GST" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
		
		String r_name = Report_Name.substring(4, 7);
		String Report_Type = "All";
		String MM_YYYY = year + '-' + month;
		String Code = "0";
		String url = "";
		String Report_Name1 = "All India";
		url = "/MIS/GST"+r_name+"/" +"MSR/" + Report_Name.replace('-', '_') +"/" + Report_Type + "/" + Code + "/" + Report_Name1 + "/" + MM_YYYY;
		
		
		//http://www.cbecddm.gov.in/MIS/GSTDDM/MSR/MSR_DDM_CE_1/All/0/All%20India/2019-Jan
		
		//String url = "/MIS/" + "GST" + Report_Name.substring(4, 7) + "/MSR/" + Report_Name.replace('-', '_') + "/All/0/All India/" + MM_YYYY;
       	
		//JSONObject jsonObject = new JSONObject();
		
        return url;	
        
    }
	
	
@RequestMapping(value = "/DirectorateDesk", method = RequestMethod.GET)
public ModelAndView DirectorateDesk(HttpServletRequest request, HttpServletResponse response)
{
	
	String userId = (String)request.getSession().getAttribute("USER");
	String type = (String)request.getSession().getAttribute("TYPE");
	
	 ModelAndView mv = new ModelAndView();
	 mv.addObject("USER",userId);
	 mv.addObject("TYPE",type);
	 mv.setViewName("GSTHome/DirectorateDesk");
	 request.getSession().setAttribute("ModelAndView", mv);
    return mv;
}


@RequestMapping(value = "/Submission", method = RequestMethod.GET)
public ModelAndView Submission(HttpServletRequest request, HttpServletResponse response)
{
	
	 ModelAndView mv = new ModelAndView();
	
	 mv.setViewName("GSTHome/Submission");
	 mv.addObject("message", "");
	 request.getSession().setAttribute("ModelAndView", mv);
    return mv;
}


@RequestMapping(value = "/Report_Submission", method = RequestMethod.GET)
public @ResponseBody JSONObject Report_Submission(String dep, String comm_code, String Report_Group)
{
    //var result = new ObjectParameter("result", typeof(string));
    JSONObject jsonObject = new JSONObject();
    
    String user = autoWiredReq.getSession().getAttribute("USER").toString().trim();
    String remoteAddr = autoWiredReq.getRemoteAddr();
    String result="";
    
    switch (Report_Group)
    {
        case "Part-I Revenue":
            {
                switch (dep)
                {
                    case "CEX":
                        {
                        	result = sp_SUBMISSION_DDM_CEX_GST_DaoImpl.generateResult(comm_code, user , remoteAddr, Report_Group);
                        }
                        break;
                    case "CUS":
                        {
                        	result= sp_SUBMISSION_DDM_CUS_GST_DaoImpl.generateResult(comm_code, user , remoteAddr, Report_Group);

                        }
                        break;
                    case "STX":
                        {
                        	result= sp_SUBMISSION_DDM_STX_GST_DaoImpl.generateResult(comm_code, user , remoteAddr, Report_Group);
                        }
                        break;
                    case "GST":
                        {
                        	result= sp_SUBMISSION_DDM_GST_DaoImpl.generateResult(comm_code, user , remoteAddr, Report_Group);
                        }
                        break;
                }

            }
            break;
        /*
        case "Part-II Anti-smuggling":
            {
                dbcontext.SP_SUBMISSION_DRI_CUS_GST(comm_code, user , remoteAddr, Report_Group, result);

            }
            break;
        case "Part-III Anti-evasion":
            {
                switch (dep)
                {
                    case "CEX":
                        {
                            dbcontext.SP_SUBMISSION_CEI_CEX_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                    case "STX":
                        {
                            dbcontext.SP_SUBMISSION_CEI_STX_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                    case "GST":
                        {
                            dbcontext.SP_SUBMISSION_CEI_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                }

            }
            break;
        case "Part-IV Audit":
            {
                switch (dep)
                {
                    case "CEX":
                        {
                            dbcontext.SP_SUBMISSION_DGA_CEX_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                    case "CUS":
                        {
                            dbcontext.SP_SUBMISSION_DGA_CUS_GST(comm_code, user , remoteAddr, Report_Group, result);

                        }
                        break;
                    case "STX":
                        {
                            dbcontext.SP_SUBMISSION_DGA_STX_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                }

            }
            break;
        case "Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous":
            {
                switch (dep)
                {
                    case "CEX":
                        {
                            dbcontext.SP_SUBMISSION_DGI_CEX_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                    case "CUS":
                        {
                            dbcontext.SP_SUBMISSION_DGI_CUS_GST(comm_code, user , remoteAddr, Report_Group, result);

                        }
                        break;
                    case "STX":
                        {
                            dbcontext.SP_SUBMISSION_DGI_STX_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                    case "GST":
                        {
                            dbcontext.SP_SUBMISSION_DGI_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                }

            }
            break;
        case "Part-VI Valuation":
            {
                dbcontext.SP_SUBMISSION_DOV_CUS_GST(comm_code, user , remoteAddr, Report_Group, result);

            }
            break;
        case "Part-VII Legal":
            {
                switch (dep)
                {
                    case "CEX":
                        {
                            dbcontext.SP_SUBMISSION_DLA_CEX_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                    case "CUS":
                        {
                            dbcontext.SP_SUBMISSION_DLA_CUS_GST(comm_code, user , remoteAddr, Report_Group, result);

                        }
                        break;
                    case "STX":
                        {
                            dbcontext.SP_SUBMISSION_DLA_STX_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                    case "GST":
                        {
                            dbcontext.SP_SUBMISSION_DLA_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                }

            }
            break;
        case "Part-VIII Arrears":
            {
                switch (dep)
                {
                    case "CEX":
                        {
                            dbcontext.SP_SUBMISSION_TAR_CEX_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                    case "CUS":
                        {
                            dbcontext.SP_SUBMISSION_TAR_CUS_GST(comm_code, user , remoteAddr, Report_Group, result);

                        }
                        break;
                    case "STX":
                        {
                            dbcontext.SP_SUBMISSION_TAR_STX_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                    case "GST":
                        {
                            dbcontext.SP_SUBMISSION_TAR_GST(comm_code, user , remoteAddr, Report_Group, result);
                        }
                        break;
                }

            }
            break;
        case "Part-IX Logistics":
            {
                dbcontext.SP_SUBMISSION_DOL_CUS_GST(comm_code, user , remoteAddr, Report_Group, result);

            }
            break;

        case "Part-X Withdrawal of Departmental Appeals":
            {
                dbcontext.SP_SUBMISSION_DJC_GST(comm_code, user , remoteAddr, Report_Group, result);

            }
            break;

        case "Part-XI Refund granted to UIN entities":
            {
                dbcontext.SP_SUBMISSION_GST_GST(comm_code, user , remoteAddr, Report_Group, result);

            }
            break;
         */   	

    }

    
    String json = null;
	try {
    	Gson gson = new Gson();
    	json = new Gson().toJson(result);
    	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   	logger.info("result --"+json);
   
	try {
		jsonObject.put("result", json);
		logger.info("result " + jsonObject.get("result"));
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    return jsonObject;
}


@RequestMapping(value = "/Status/{request_CSRF_Token}", method = RequestMethod.GET)
public ModelAndView Status(HttpServletRequest request, HttpServletResponse response, @PathVariable("request_CSRF_Token") String request_CSRF_Token)
{
	logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
	logger.info("request CSRF token"+ request_CSRF_Token);
	if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {
	
	
	String userId = (String)request.getSession().getAttribute("USER");
	String type = (String)request.getSession().getAttribute("TYPE");
	
	 ModelAndView mv = new ModelAndView();
	 mv.addObject("USER",userId);
	 mv.addObject("TYPE",type);
	 mv.setViewName("GSTHome/Status");
	// SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
	String date_display="";
	String time_display="";
	Date date = new Date();  
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy"); 
	date_display= formatter.format(date);  
	
	SimpleDateFormat formatterTime = new SimpleDateFormat("hh:mm:ss aa"); 
	time_display= formatterTime.format(date);  
	    
	 mv.addObject("date_display",date_display);
	 mv.addObject("time_display",time_display);
	 
	
	 request.getSession().setAttribute("ModelAndView", mv);
    return mv;
    
	}
    else {
			request.getSession().invalidate();
			ModelAndView mv = new ModelAndView();
			 
			 mv.setViewName("GSTDOV/ResourceNotFound");
			 mv.addObject("message", "");
			 
	       return mv;
		}
}

@RequestMapping(value = "/ReportGroup_Bind", method = RequestMethod.GET)
public @ResponseBody JSONObject ReportGroup_Bind(String dep, String dep_text)
{
	
	List<SP_LIST_DROPDOWN_Result> gstList = new ArrayList<SP_LIST_DROPDOWN_Result>();
	
	SP_LIST_DROPDOWN_Result obj;
	if(!dep.equalsIgnoreCase("null"))
	{
		
		obj=new SP_LIST_DROPDOWN_Result();
		obj.setText("Select Report Group");	obj.setValue("0");obj.setSelected("true");			
	    gstList.add(obj);
	    
	    if (dep.equalsIgnoreCase("CUS"))
        {
	    	obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-I Revenue");obj.setValue("PART_1");		
    	    gstList.add(obj);
    	    
    	    obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-II Anti-smuggling");obj.setValue("PART_2");		
    	    gstList.add(obj);
    	    
    	    obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-IV Audit");obj.setValue("PART_4");		
    	    gstList.add(obj);
    	    
    	    obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous");obj.setValue("PART_5");		
    	    gstList.add(obj);
    	    
    	    obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-VI Valuation");obj.setValue("PART_6");		
    	    gstList.add(obj);
    	    
    	    obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-VII Legal");obj.setValue("PART_7");		
    	    gstList.add(obj);
    	    
    	    obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-VIII Arrears");obj.setValue("PART_8");		
    	    gstList.add(obj);
    	    
    	    obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-IX Logistics");obj.setValue("PART_9");		
    	    gstList.add(obj);
    	    
        }
	    else if (dep.equalsIgnoreCase("GST") && !dep_text.equalsIgnoreCase("All"))
        {
	    	obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-IX Logistics");obj.setValue("PART_9");		
    	    gstList.add(obj);
    	    
    	    obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-I Revenue");obj.setValue("PART_1");		
    	    gstList.add(obj);
			obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-III Anti-evasion");obj.setValue("PART_3");		
    	    gstList.add(obj);
			obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous");obj.setValue("PART_5");		
    	    gstList.add(obj);
			obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-VII Legal");obj.setValue("PART_7");		
    	    gstList.add(obj);
			obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-VIII Arrears");obj.setValue("PART_8");		
    	    gstList.add(obj);
			obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-XI Refund granted to UIN entities");obj.setValue("PART_11");		
    	    gstList.add(obj);
        }
        else if (dep.equalsIgnoreCase("GST") && dep_text.equalsIgnoreCase("All"))
        {
            obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-X Withdrawal of Departmental Appeals");obj.setValue("PART_10");		
    	    gstList.add(obj);
        }
        else
        {
        	obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-I Revenue");obj.setValue("PART_1");		
    	    gstList.add(obj);
    	                    
    	    obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-III Anti-evasion");obj.setValue("PART_3");		
    	    gstList.add(obj);
			obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-IV Audit");obj.setValue("PART_4");		
    	    gstList.add(obj);
			obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous");obj.setValue("PART_5");		
    	    gstList.add(obj);
			obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-VII Legal");obj.setValue("PART_7");		
    	    gstList.add(obj);
			obj=new SP_LIST_DROPDOWN_Result();
			obj.setText("Part-VIII Arrears");obj.setValue("PART_8");		
    	    gstList.add(obj);
        }
	}
	
	String json = null;
	try {
    	Gson gson = new Gson();
    	json = new Gson().toJson(gstList);
    	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   	
   	JSONObject jsonObject = new JSONObject();
	try {
		jsonObject.put("GetReportGroup_Bind", json);
		} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    return jsonObject;	
    
}

@RequestMapping(value = "/Status_ReportBind", method = RequestMethod.GET)
public @ResponseBody JSONObject Status_ReportBind(String report_type, String dep, 
		String year, String code, String group, String group_value, String mpr)
{
	logger.info("Start Status");
	String json = null;
	//Gson gson = new Gson();
			
	if (report_type == "FF")
    {
		List<SP_STATUS_GST_FF_Result> gstFFList = new ArrayList<SP_STATUS_GST_FF_Result>();
		Object[] objArray = new Object[2];
    	objArray[0]=code;
    	objArray[1]=year.substring(0, 4);
		gstFFList = sp_LIST_GST_ZONE_DaoImpl.generateResultBean_SP_STATUS_GST_FF(objArray);  
        //var dt = JsonConvert.SerializeObject(dbcontext.SP_STATUS_GST_FF(code, year.Substring(0, 4)));
        //return Json(dt);
		json = new Gson().toJson(gstFFList);
    }
	else
	{
        if (!group.equalsIgnoreCase("Select Report Group"))
        {
        	logger.info("group:"+group+"group_value:"+group_value+"dep:"+dep+"code:"+code);
            if (code.equalsIgnoreCase("0"))
            {
                code = null;
            }
            if (mpr == "" || mpr == null)
            {
            	Object[] objArray = new Object[6];
    	    	objArray[0]=year.substring(0, 4);
    	    	objArray[1]=group;
    	    	objArray[2]=group_value;
    	    	objArray[3]=dep;
    	    	objArray[4]=dep;
    	    	objArray[5]=code;
    	    	
    	    	logger.info("year:"+objArray[0]);
    	    	logger.info("group:"+objArray[1]);
    	    	logger.info("group_value:"+objArray[2]);
    	    	logger.info("dep:"+objArray[3]);
    	    	logger.info("dep:"+objArray[4]);
    	    	logger.info("code:"+objArray[5]);
    	    	
            	List<SP_GST_STATUS_Result> gstList = new ArrayList<SP_GST_STATUS_Result>();
            	gstList = sp_LIST_GST_ZONE_DaoImpl.generateResultBean_SP_GST_STATUS(objArray); 
            	json = new Gson().toJson(gstList);
            	//var dt = JsonConvert.SerializeObject(dbcontext.SP_GST_STATUS(year.Substring(0, 4), group, group_value, dep, dep, code));
                // return Json(dt);
            }
            else
            {
            	Object[] objArray = new Object[6];
    	    	objArray[0]=year.substring(0, 4);
    	    	objArray[1]=group;
    	    	objArray[2]=group_value;
    	    	objArray[3]=dep;
    	    	objArray[4]=mpr;
    	    	objArray[5]=code;
    	    	
            	List<SP_GST_DDM_STATUS_Result> gstList = new ArrayList<SP_GST_DDM_STATUS_Result>();
            	gstList = sp_LIST_GST_ZONE_DaoImpl.generateResultBean_SP_GST_DDM_STATUS(objArray); 
            	json = new Gson().toJson(gstList);
            	
                //var dt = JsonConvert.SerializeObject(dbcontext.SP_GST_DDM_STATUS(year.Substring(0, 4), group, group_value, dep, dep, mpr,code));                       
                //return Json(dt);
            }
        }
        
    }
			
   	
   	JSONObject jsonObject = new JSONObject();
	try {
		jsonObject.put("gstReportList", json);
		} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    return jsonObject;	
    
}	


}
