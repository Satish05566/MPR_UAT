package com.ddm.cbic.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.ddm.cbic.dao.implementation.SP_DDM_CUS_1_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_DDM_GST_1_DaoImpl;


import com.ddm.cbic.dao.implementation.DDM_PART_1_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_CHANGE_PASS_CBEC_DaoImpl;
//import com.ddm.cbic.dao.implementation.SP_DDM_CUS_1_MAX_DATE_DaoImpl;
import com.ddm.cbic.model.SP_DDM_CUS_3_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_MAX_DATE_Result;
//import com.ddm.cbic.model.SP_DDM_CUS_3_MEMBER_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_3_ZONE_Result;


import com.ddm.cbic.dao.implementation.SP_DDM_GST_4_DaoImpl;
import com.ddm.cbic.model.SP_DDM_GST_4_ALL_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_REGION_Result;
import com.ddm.cbic.model.SP_DDM_GST_4_ZONE_Result;



import com.ddm.cbic.dao.implementation.SP_LIST_GST_COMM_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_GST_ZONE_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DDM_CEX_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DDM_CUS_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DDM_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DDM_STX_GST_DaoImpl;

import com.ddm.cbic.dao.implementation.DDM_PART_1_DaoImpl;

import com.ddm.cbic.dao.implementation.gstgst.GST_GST_1_DaoImpl;

import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DLA_CEX_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DLA_CUS_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DLA_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_SUBMISSION_DLA_STX_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.gstcei.GSTCEI_CEI_GST_1_DaoImpl;
import com.ddm.cbic.dao.implementation.gstdpm.GSTDPM_DPM_CE_1A_DaoImpl;


import com.ddm.cbic.model.SP_DDM_CUS_1_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TEMP_ProcResult;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_1_ZONE_Result;

import com.ddm.cbic.model.SP_DDM_CUS_5_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_MEMBER_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_5_ZONE_Result;


import com.ddm.cbic.model.SP_DDM_GST_5_ALL_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_COMM_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_REGION_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_ZONE_Result;
import com.ddm.cbic.model.SP_LIST_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_ALL_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_COMM_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_REGION_Result;
import com.ddm.cbic.model.SP_DDM_CUS_6_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_ALL_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_COMM_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_REGION_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_ZONE_Result;
import com.ddm.cbic.model.SP_DDM_GST_5_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_LIST_GST_COMM_Result;
import com.ddm.cbic.model.SP_LIST_GST_ZONE_Result;
import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class ValidateController {
	private static final Logger logger = LoggerFactory.getLogger(ValidateController.class);


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
	
	//@Autowired
	//private SP_SUBMISSION_DGA_GST_DaoImpl sp_SUBMISSION_DGA_GST_DaoImpl;
	
	
	@Autowired
	private SP_SUBMISSION_DLA_CEX_GST_DaoImpl sp_SUBMISSION_DLA_CEX_GST_DaoImpl;

	@Autowired
	private SP_SUBMISSION_DLA_CUS_GST_DaoImpl sp_SUBMISSION_DLA_CUS_GST_DaoImpl;
	
	@Autowired
	private SP_SUBMISSION_DLA_STX_GST_DaoImpl sp_SUBMISSION_DLA_STX_GST_DaoImpl;
	
	@Autowired
	private SP_SUBMISSION_DLA_GST_DaoImpl sp_SUBMISSION_DLA_GST_DaoImpl;
	
	/*
	 * @Autowired private GSTDJC_DLA_ALL_A_DaoImpl gSTDJC_DLA_ALL_A_DaoImpl;
	 * 
	 * @Autowired private DOL_CUS_1_DaoImpl dOL_CUS_1_DaoImpl;
	 */
	@Autowired
	private GSTCEI_CEI_GST_1_DaoImpl gstcei_CEI_GST_1_DaoImpl;
	
	
	
	@Autowired
	private GST_GST_1_DaoImpl  gST_GST_1_DaoImpl;
	
	
	
	@Autowired
	private GSTDPM_DPM_CE_1A_DaoImpl  gstDPM_DPM_CE_1A_DaoImpl;
	
	
	
	
	
	@Autowired
	private HttpServletRequest autoWiredReq;
	
	
	//@RequestMapping(value = "/Validate/Submission", method = RequestMethod.GET)
	@RequestMapping(value = "/Validate/Submission/{request_CSRF_Token}", method = RequestMethod.GET)		
	public ModelAndView Submission(HttpServletRequest request, HttpServletResponse response,@PathVariable("request_CSRF_Token") String request_CSRF_Token)
    {
		logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token"+ request_CSRF_Token);
		if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {	
			System.out.println("in Submission action");
		
		
		 ModelAndView mv = new ModelAndView();
		
		 mv.setViewName("GSTHome/Submission");
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

		
	
	@RequestMapping(value = "/Validate/CommBind", method = RequestMethod.GET)
	public @ResponseBody JSONObject CommBind(String zone,String dep)
    {
		System.out.println("in CommBind action");
		System.out.println("in CommBind action zone--"+zone);
		System.out.println("in CommBind action dep--"+dep);

		
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
	
	
	@RequestMapping(value = "/Validate/Report_Submission", method = RequestMethod.GET)
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
		 * case "Part-II Anti-smuggling": {
		 * System.out.println("Inside Validate Controller comm_code " + comm_code);
		 * System.out.println("Inside Validate Controller  user " + user);
		 * System.out.println("Inside Validate Controller  remoteAddr " + remoteAddr);
		 * System.out.println("Inside Validate Controller  Report_Group " +
		 * Report_Group); result
		 * =sp_SUBMISSION_DRI_CUS_GST_DaoImpl.generateResult(comm_code, user ,
		 * remoteAddr, Report_Group);
		 * 
		 * } break;
		 */
                
            case "Part-III Anti-evasion":
                {
                    switch (dep)
                    {
			/*
			 * case "CEX": { result
			 * =gstcei_CEI_CE_1_DaoImpl.generateResult_SP_SUBMISSION_CEI_CEX_GST(comm_code,
			 * user , remoteAddr, Report_Group);
			 * //dbcontext.SP_SUBMISSION_CEI_CEX_GST(comm_code, user , remoteAddr,
			 * Report_Group, result); } break; case "STX": { result
			 * =gstcei_CEI_ST_1_DaoImpl.generateResult_SP_SUBMISSION_CEI_STX_GST(comm_code,
			 * user , remoteAddr, Report_Group);
			 * //dbcontext.SP_SUBMISSION_CEI_STX_GST(comm_code, user , remoteAddr,
			 * Report_Group, result); } break;
			 */
                        case "GST":
                            {
                            	result =gstcei_CEI_GST_1_DaoImpl.generateResult_SP_SUBMISSION_CEI_GST(comm_code, user , remoteAddr, Report_Group);
                                //dbcontext.SP_SUBMISSION_CEI_GST(comm_code, user , remoteAddr, Report_Group, result);
                            }
                            break;
                    }

                }
                break;
              
		/*
		 * case "Part-IV Audit": { switch (dep) {
		 * 
		 * case "CEX": { result=
		 * gstDGA_DGA_CE_1_1_DaoImpl.generateResult_SP_SUBMISSION_DGA_CEX_GST(comm_code,
		 * user , remoteAddr, Report_Group);
		 * 
		 * //dbcontext.SP_SUBMISSION_DGA_CEX_GST(comm_code, user , remoteAddr,
		 * Report_Group, result); } break; case "CUS": { result=
		 * gstDGA_DGA_CE_1_1_DaoImpl.generateResult_SP_SUBMISSION_DGA_CUS_GST(comm_code,
		 * user , remoteAddr, Report_Group);
		 * 
		 * //dbcontext.SP_SUBMISSION_DGA_CUS_GST(comm_code, user , remoteAddr,
		 * Report_Group, result);
		 * 
		 * } break; case "STX": { result=
		 * gstDGA_DGA_CE_1_1_DaoImpl.generateResult_SP_SUBMISSION_DGA_STX_GST(comm_code,
		 * user , remoteAddr, Report_Group);
		 * 
		 * //dbcontext.SP_SUBMISSION_DGA_STX_GST(comm_code, user , remoteAddr,
		 * Report_Group, result); } break;
		 * 
		 * case "GST": { //result=
		 * sp_SUBMISSION_DGA_GST_DaoImpl.generateResult(comm_code, user , remoteAddr,
		 * Report_Group); } break; }
		 * 
		 * } break;
		 * 
		 */            case "Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous":
                {
                    switch (dep)
                    {
			/*
			 * case "CEX": { result=
			 * gstDPM_DPM_CE_1A_DaoImpl.generateResult_SP_SUBMISSION_DGI_CEX_GST(comm_code,
			 * user , remoteAddr, Report_Group);
			 * 
			 * } break; case "CUS": { result=
			 * gstDPM_DPM_CE_1A_DaoImpl.generateResult_SP_SUBMISSION_DGI_CUS_GST(comm_code,
			 * user , remoteAddr, Report_Group);
			 * 
			 * 
			 * } break; case "STX": { result=
			 * gstDPM_DPM_CE_1A_DaoImpl.generateResult_SP_SUBMISSION_DGI_STX_GST(comm_code,
			 * user , remoteAddr, Report_Group);
			 * 
			 * } break;
			 */
                        case "GST":
                            {
                            	result= gstDPM_DPM_CE_1A_DaoImpl.generateResult_SP_SUBMISSION_DGI_GST(comm_code, user , remoteAddr, Report_Group);
                                
                                //dbcontext.SP_SUBMISSION_DGI_GST(comm_code, user , remoteAddr, Report_Group, result);
                            }
                            break;                            
                    }

                }
                break;
                
		/*
		 * case "Part-VI Valuation": {
		 * System.out.println("Inside Part VI Validate Controller comm_code " +
		 * comm_code); System.out.println("Inside Part VI Validate Controller  user " +
		 * user); System.out.println("Inside Part VI Validate Controller  remoteAddr " +
		 * remoteAddr);
		 * System.out.println("Inside Part VI Validate Controller  Report_Group " +
		 * Report_Group); result
		 * =sp_SUBMISSION_DOV_CUS_GST_DaoImpl.generateResult(comm_code, user ,
		 * remoteAddr, Report_Group);
		 * 
		 * // dbcontext.SP_SUBMISSION_DOV_CUS_GST(comm_code, user , remoteAddr,
		 * Report_Group, result);
		 * 
		 * } break;
		 * 
		 * case "Part-VII Legal": { switch (dep) { case "CEX": { result =
		 * sp_SUBMISSION_DLA_CEX_GST_DaoImpl.generateResult(comm_code, user ,
		 * remoteAddr, Report_Group); } break; case "CUS": { result=
		 * sp_SUBMISSION_DLA_CUS_GST_DaoImpl.generateResult(comm_code, user ,
		 * remoteAddr, Report_Group);
		 * 
		 * } break; case "STX": { result=
		 * sp_SUBMISSION_DLA_STX_GST_DaoImpl.generateResult(comm_code, user ,
		 * remoteAddr, Report_Group); } break; case "GST": { result=
		 * sp_SUBMISSION_DLA_GST_DaoImpl.generateResult(comm_code, user , remoteAddr,
		 * Report_Group); } break; }
		 * 
		 * } break;
		 * 
		 * case "Part-VIII Arrears": { switch (dep) { case "CEX": { result=
		 * ceTAR_TAR_CE_1_DaoImpl.generateResult_SP_SUBMISSION_TAR_CEX_GST(comm_code,
		 * user , remoteAddr, Report_Group);
		 * 
		 * //dbcontext.SP_SUBMISSION_TAR_CEX_GST(comm_code, user , remoteAddr,
		 * Report_Group, result); } break; case "CUS": { result=
		 * ceTAR_TAR_CE_1_DaoImpl.generateResult_SP_SUBMISSION_TAR_CUS_GST(comm_code,
		 * user , remoteAddr, Report_Group);
		 * 
		 * //dbcontext.SP_SUBMISSION_TAR_CUS_GST(comm_code, user , remoteAddr,
		 * Report_Group, result);
		 * 
		 * } break; case "STX": { result=
		 * ceTAR_TAR_CE_1_DaoImpl.generateResult_SP_SUBMISSION_TAR_STX_GST(comm_code,
		 * user , remoteAddr, Report_Group);
		 * 
		 * //dbcontext.SP_SUBMISSION_TAR_STX_GST(comm_code, user , remoteAddr,
		 * Report_Group, result); } break; case "GST": { result=
		 * ceTAR_TAR_CE_1_DaoImpl.generateResult_SP_SUBMISSION_TAR_GST(comm_code, user ,
		 * remoteAddr, Report_Group);
		 * 
		 * //dbcontext.SP_SUBMISSION_TAR_GST(comm_code, user , remoteAddr, Report_Group,
		 * result); } break; }
		 * 
		 * } break;
		 * 
		 * case "Part-IX Logistics": { result=
		 * dOL_CUS_1_DaoImpl.generateResult_SP_SUBMISSION_DOL_CUS_GST(comm_code, user ,
		 * remoteAddr, Report_Group); //dbcontext.SP_SUBMISSION_DOL_CUS_GST(comm_code,
		 * user , remoteAddr, Report_Group, result);
		 * 
		 * } break;
		 * 
		 * case "Part-X Withdrawal of Departmental Appeals": {
		 * 
		 * result=
		 * gSTDJC_DLA_ALL_A_DaoImpl.generateResult_SP_SUBMISSION_DJC_GST(comm_code, user
		 * , remoteAddr, Report_Group);
		 * 
		 * 
		 * } break;
		 * 
		 */            case "Part-XI Refund granted to UIN entities":
                {                	
                           	     
           	     
           	      result =gST_GST_1_DaoImpl.generateResult_SP_SUBMISSION_GST_GST(comm_code, user , remoteAddr, Report_Group);
               	
               	                	
                }
                break;
           	

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
	
	
	
	
	
}