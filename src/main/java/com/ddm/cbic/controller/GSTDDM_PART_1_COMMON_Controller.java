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
import com.ddm.cbic.dao.implementation.DDM_PART_1_DaoImpl;
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
@RequestMapping("/GSTDDM")
public class GSTDDM_PART_1_COMMON_Controller {
	private static final Logger logger = LoggerFactory.getLogger(GSTDDM_PART_1_COMMON_Controller.class);
	

	@Autowired
	private SP_DDM_CUS_1_DaoImpl sp_DDM_CUS_1_DaoImpl;
	

	
	@Autowired 
	private  SP_LIST_GST_ZONE_DaoImpl sP_LIST_GST_ZONE_DaoImpl;
	@Autowired 
	private  SP_LIST_GST_COMM_DaoImpl sP_LIST_GST_COMM_DaoImpl;
	

	@Autowired
	private SP_DDM_GST_1_DaoImpl sp_DDM_GST_1_DaoImpl;
	
	@Autowired
	private DDM_PART_1_DaoImpl DDM_PART_1_DaoImpl;	
	
	@Autowired
	private SP_DDM_GST_4_DaoImpl sp_DDM_GST_4_DaoImpl;
	
	
	
	@RequestMapping(value = "/ZoneBind", method = RequestMethod.GET)
	public @ResponseBody JSONObject ZoneBind(String dep)
    {
		System.out.println("in ZoneBind action");
		List<SP_LIST_GST_ZONE_Result> gstList = new ArrayList<SP_LIST_GST_ZONE_Result>();
		Object[] objArray = new Object[1];
    	objArray[0]=dep;
    	gstList = sP_LIST_GST_ZONE_DaoImpl.generateResultBeanList(objArray);
    	//SP_LIST_GST_ZONE_Result temp = new SP_LIST_GST_ZONE_Result();
    	//temp.setZONE_CODE("74"); temp.setZONE_NAME("DELHI CUS");
    	//gstList.add(temp);
    	//SP_LIST_GST_ZONE_Result temp2 = new SP_LIST_GST_ZONE_Result();
    	//temp2.setZONE_CODE("75"); temp2.setZONE_NAME("DELHI PREV");
    	//gstList.add(temp2);
    	
    	String json = null;
    	try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(gstList);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	System.out.println("zone list--"+json);
       	JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("gstZoneList", json);
			System.out.println("jsonObject.get(JSONObject)----> in  ZoneBind" + jsonObject.get("gstZoneList"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
        
    }
	@RequestMapping(value = "/CommBind", method = RequestMethod.GET)
	public @ResponseBody JSONObject CommBind(String RequestVerificationToken, String zone,String dep)
    {
		System.out.println("in CommBind action");
		System.out.println("in CommBind action zone--"+zone);
		System.out.println("in CommBind action dep--"+dep);
		List<SP_LIST_GST_COMM_Result> listGstComm = new ArrayList<SP_LIST_GST_COMM_Result>();
		Object[] objArray = new Object[2];
    	objArray[0]=dep;
    	objArray[1]=zone;
    	listGstComm = sP_LIST_GST_COMM_DaoImpl.generateResultBeanList(objArray);
    	
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

            String r_name = "GST" +Report_Name.trim().substring(0, 3);
            String Report_Type = "";
            String MM_YYYY = year.trim() + '-' + month.trim();
            String Code = "0";
            

           // if (string.IsNullOrEmpty(zone_code))
            if(((null == zone_code )||(zone_code.trim().length()== 0)))
            {
                Report_Type = "All";
                Report_Name = "All India";
                url = "/" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
                //return RedirectToAction(viewname, r_name + "/Report", new { Report_Type = Report_Type, Report_Name = Report_Name, Code = Code, MM_YYYY = MM_YYYY });
            }

           // else if ((!string.IsNullOrEmpty(zone_code) && (!string.IsNullOrEmpty(zone_name))) && (string.IsNullOrEmpty(comm_code)))
            else if( ((null != zone_code )&&(zone_code.trim().length()> 0))&&((null != zone_name )&&(zone_name.trim().length()> 0))&&((null == comm_code )||(comm_code.trim().length()== 0)) )
            {
                Code = zone_code;
                Report_Type = "Zone";
                Report_Name = zone_name;
                url = "/" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
            }

            //else if (!string.IsNullOrEmpty(comm_code) && (!string.IsNullOrEmpty(comm_name)) && (!string.IsNullOrEmpty(comm_code)))
            else if ( ((null != comm_code )&&(comm_code.trim().length()> 0))&&((null != comm_name )&&(comm_name.trim().length()> 0)))
            {
                Code = comm_code;
                Report_Type = "Comm";
                Report_Name = comm_name;
                url = "/" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
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
	
		

			
					
							
						
			
						
					
			
			
			
			
			
			
}