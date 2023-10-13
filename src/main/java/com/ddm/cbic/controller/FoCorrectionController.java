package com.ddm.cbic.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.dao.implementation.CORRECTION_DaoImpl;
import com.ddm.cbic.dao.implementation.DDM_PART_1_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_GST_COMM_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_GST_ZONE_DaoImpl;
import com.ddm.cbic.model.SP_CORRECTION_LIST_ALL_GST_Result;
import com.ddm.cbic.model.SP_CORRECTION_LIST_FO_GST_Result;
import com.ddm.cbic.model.SP_LIST_GST_COMM_Result;
import com.ddm.cbic.model.SP_LIST_GST_ZONE_Result;
import com.google.gson.Gson;


@Controller
@RequestMapping("/")
public class FoCorrectionController {
	
	@Autowired
	private CORRECTION_DaoImpl cORRECTION_DaoImpl;
	
	@Autowired 
	private  SP_LIST_GST_ZONE_DaoImpl sP_LIST_GST_ZONE_DaoImpl;
	@Autowired 
	private  SP_LIST_GST_COMM_DaoImpl sP_LIST_GST_COMM_DaoImpl;
	
	private static final Logger logger = LoggerFactory.getLogger(FoCorrectionController.class);
	
	//@GetMapping("FO_Correction")
	@RequestMapping(value = "/FO_Correction/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView FO_Correction(HttpServletRequest request, HttpServletResponse response,@PathVariable("request_CSRF_Token") String request_CSRF_Token)
	{	
		logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token"+ request_CSRF_Token);
		if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {
		   System.out.println("inside FO_Correction");
	       ModelAndView mv = new ModelAndView();
	       mv.setViewName("GSTHome/FO_Correction");
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
	//@GetMapping("CorrectionBackup")
	@RequestMapping(value = "CorrectionBackup", method = RequestMethod.POST)
	public ModelAndView CorrectionBackup() {
		System.out.println("inside CorrectionBackup");
	       ModelAndView mv = new ModelAndView();
	       mv.setViewName("GSTHome/CorrectionBackup");
	       return mv;
	}
	
	
	
	
	
	
	@RequestMapping(value = "Zone_Bind", method = RequestMethod.GET)
	public @ResponseBody JSONObject Zone_Bind(String dep)
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
       	//System.out.println("zone list--"+json);
       	JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("gstZoneList", json);
			System.out.println("jsonObject.get(in  ZoneBind list" + jsonObject.get("gstZoneList"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
        
    }
	@RequestMapping(value = "/Comm_Bind", method = RequestMethod.GET)
	public @ResponseBody JSONObject Comm_Bind(String RequestVerificationToken, String zone,String dep)
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
       	//System.out.println("zone list--"+json);
       	JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("gstCommList", json);
			System.out.println("in CommBind list" + jsonObject.get("gstCommList"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
        
    }
	
	
	
	
	@RequestMapping(value = "ReportGroup_Bind", method = RequestMethod.GET)
	public @ResponseBody JSONObject ReportGroup_Bind(String dep) // String dep_text one more parameter need to disscus for this function
    {
		System.out.println("in ReportGroup_Bind action");
		Map<String, String> ReportGroupMap = new HashMap();
		String dep_text="_All";
		
		if(dep.equalsIgnoreCase("CUS")) {
			
			System.out.println("Inside dep CUS--block");
			ReportGroupMap.put("Part-I Revenue","PART_1");
			ReportGroupMap.put("Part-II Anti-smuggling","PART_2");
			ReportGroupMap.put("Part-IV Audit","PART_4");
			ReportGroupMap.put("Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous","PART_5");
			ReportGroupMap.put("Part-VI Valuation","PART_6");
			ReportGroupMap.put("Part-VII Legal","PART_7");
			ReportGroupMap.put("Part-VIII Arrears","PART_8");
			ReportGroupMap.put("Part-IX Logistics","PART_9");
			
			
		}
		
		else if(dep.equalsIgnoreCase("GST") && dep_text!="ALL") {
			System.out.println("Inside dep GST and dep_text!=ALL--block");
			ReportGroupMap.put("Part-I Revenue","PART_1");
			ReportGroupMap.put("Part-III Anti-evasion","PART_3");
			ReportGroupMap.put("Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous","PART_5");
			ReportGroupMap.put("Part-VII Legal","PART_7");
			ReportGroupMap.put("Part-VIII Arrears","PART_8");
			ReportGroupMap.put("Part-XI Refund granted to UIN entities","PART_11");
			
			
		}
		else if(dep.equalsIgnoreCase("GST") && dep_text.equalsIgnoreCase("ALL"))
		{
			System.out.println("Inside dep GST and dep_text==ALL--block");
			ReportGroupMap.put("Part-X Withdrawal of Departmental Appeals","PART_10");	
		}
		else {
			System.out.println("Inside else --block");
			ReportGroupMap.put("Part-I Revenue","PART_1");
			ReportGroupMap.put("Part-III Anti-evasion","PART_3");
			ReportGroupMap.put("Part-IV Audit","PART_4");
			ReportGroupMap.put("Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous","PART_5");
			ReportGroupMap.put("Part-VII Legal","PART_7");
			ReportGroupMap.put("Part-VIII Arrears","PART_8");
			
			
			
			
			
		}
    	
    	String json = null;
    	try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(ReportGroupMap);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	System.out.println("zone list--"+json);
       	JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("ReportGroupBind", json);
			System.out.println("ReportGroupBind------" + jsonObject.get("ReportGroupBind"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return jsonObject;	
        
    }
	
	
	
	@RequestMapping(value = "Correction_Backup_List", method = RequestMethod.POST)
	public @ResponseBody JSONObject Correction_Backup_List(String dep,HttpServletRequest request)
    {
		
		
		JSONObject jsonObj = new JSONObject();
		System.out.println("in Correction_Backup_List action");
		
		String json = "";
		Object[] objArray = new Object[2];
    	
		
		List<SP_CORRECTION_LIST_ALL_GST_Result> correctionListAll =  new ArrayList<SP_CORRECTION_LIST_ALL_GST_Result>();
    	correctionListAll = cORRECTION_DaoImpl.generateResultBeanList_All(objArray);
		
		
		try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(correctionListAll);
        	System.out.println("correctionListAll-----"+json);
        	jsonObj.put("correctionListAll", json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObj;
	}

	@RequestMapping(value = "FO_CorrectionList", method = RequestMethod.POST)
	public @ResponseBody JSONObject FO_CorrectionList(String dep,HttpServletRequest request)
    {
		
		String USER = (String)request.getSession().getAttribute("USER");
		JSONObject jsonObj = new JSONObject();
		System.out.println("in FO_CorrectionList action");
		System.out.println("User is---"+USER);
		String FO = "";
		String json = "";
		Object[] objArray = new Object[2];
    	
		if(USER.substring(0,3).toUpperCase().equalsIgnoreCase("CEI")) {
			
			FO="DGCEI";
			System.out.println("FO User is---"+FO);
		}
		else if(USER.substring(0,3).toUpperCase().equalsIgnoreCase("DRI")) {
			
			FO="DGRI";
			System.out.println("FO User is---"+FO);
		}
		else if(USER.substring(0,5).toUpperCase().equalsIgnoreCase("DGP01")) {
			
			FO="DGPM1";
			System.out.println("FO User is---"+FO);
		}
		else if(USER.substring(0,5).toUpperCase().equalsIgnoreCase("DGP02")) {
			
			FO="DGPM2";
			System.out.println("FO User is---"+FO);
		}
		else {
			FO = USER.substring(0,3);
			System.out.println("FO User is---"+FO);
		}
		List<SP_CORRECTION_LIST_FO_GST_Result> ListFoGstResult =  new ArrayList<SP_CORRECTION_LIST_FO_GST_Result>();
		objArray[0]=FO;
    	objArray[1]=dep;
		ListFoGstResult = cORRECTION_DaoImpl.generateResultBeanList(objArray);
		
		
		try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(ListFoGstResult);
        	System.out.println("ListFoGstResult-----"+json);
        	jsonObj.put("ListFoGstResult", json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
        
	@RequestMapping(value = "FO_Update_Status", method = RequestMethod.POST)
	public @ResponseBody JSONObject FO_Update_Status(String code, String MM_YYYY,String sub_date, String mpr, String txt_Remarks, String dep,HttpServletRequest request)
    {
		
		
		
		String msg ="";
		JSONObject jsonObj = new JSONObject();
		System.out.println("in FO_Update_Status action");
		System.out.println("code is--"+code); 
		System.out.println("MM_YYYY is--"+MM_YYYY);
		System.out.println("sub_date is--"+sub_date);
		System.out.println("mpr is--"+mpr);
		System.out.println("txt_Remarks is--"+txt_Remarks);
		System.out.println("dep is--"+dep);
		code = code.trim();
		System.out.println("code length is-----"+code.length());
		int startIndex = code.length();
		startIndex = startIndex-3;
		System.out.println("startIndex---"+startIndex);
		code = code.substring(startIndex,startIndex+2 ); //Mangalore(YZ)
		//String code1[] = code.split("(");
		//System.out.println("code1 is after split-----"+code1);
		//code1=code1.substring(0,code1.length());
		System.out.println("updated code is after substring()-----"+code);
		//txt_Remarks = "ABC";
		Date mm_yyyy = new Date();
		try {
		DateFormat fmt = new SimpleDateFormat("yyyy-MMM");
		mm_yyyy = fmt.parse(MM_YYYY);
         System.out.println("mm_yyyy----"+mm_yyyy);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
        String _mm_yyyy = new java.text.SimpleDateFormat("yyyy-MM-dd").format(mm_yyyy);
        System.out.println("_mm_yyyy----"+_mm_yyyy);
		
		ModelAndView mv = new ModelAndView();
		String json = "";
		String json_1 = "";
		Object[] objArray = new Object[4];
		objArray[0]=code;
		objArray[1]=_mm_yyyy;
		objArray[2]=sub_date;
		objArray[3]=mpr;
		
		Object[] objArray_1 = new Object[5];
		objArray_1[0]=code;
		objArray_1[1]=_mm_yyyy;
		objArray_1[2]=sub_date;
		objArray_1[3]=mpr;
		objArray_1[4]=txt_Remarks;
		
		 if (txt_Remarks==null || "".equals(txt_Remarks))
         {
           msg =cORRECTION_DaoImpl.generateResultBean_SP_CORRECTION_APPROVAL(objArray,request);
           System.out.println("if block--msg==is--"+msg);  
           mv.addObject("ViewBagMessage", msg);
           mv.addObject("ViewBagResult", msg);
         }
         else
         {
        	 
        	 msg =cORRECTION_DaoImpl.generateResultBean_SP_CORRECTION_DELETE_CRR(objArray_1,request);
             System.out.println("else block--msg==is--"+msg);  
             mv.addObject("ViewBagMessage", msg);
             mv.addObject("ViewBagResult", msg);

         }
		        
			
		
		        String USER = (String)request.getSession().getAttribute("USER");
				String FO = USER.substring(0,3);
				System.out.println("FO User in FO_Update_Status -----"+FO);
			
			List<SP_CORRECTION_LIST_FO_GST_Result> ListFoGstResult =  new ArrayList<SP_CORRECTION_LIST_FO_GST_Result>();
			Object[] objArray_2 = new Object[2];
			objArray_2[0]=FO;
	    	objArray_2[1]=dep;
			ListFoGstResult = cORRECTION_DaoImpl.generateResultBeanList(objArray_2);
		
		
		try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(ListFoGstResult);
        	json_1 = new Gson().toJson(msg);
        	jsonObj.put("data1", json);
        	jsonObj.put("data2", json_1);
        	System.out.println("data1-----"+jsonObj.get("data1"));
        	System.out.println("data2-----"+jsonObj.get("data2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObj;
	
    }
	
	
	@RequestMapping(value = "FO_Update_Status_Msg", method = RequestMethod.POST)
	public @ResponseBody JSONObject FO_Update_Status_Msg(String code, String MM_YYYY,String sub_date, String mpr, String txt_Remarks, String dep,HttpServletRequest request)
    {
		
		
		
		String msg ="";
		JSONObject jsonObj = new JSONObject();
		System.out.println("in FO_Update_Status_Msg action");
		System.out.println("code is--"+code); 
		System.out.println("MM_YYYY is--"+MM_YYYY);
		System.out.println("sub_date is--"+sub_date);
		System.out.println("mpr is--"+mpr);
		System.out.println("txt_Remarks is--"+txt_Remarks);
		System.out.println("dep is--"+dep);
		code = code.trim();
		System.out.println("code length is-----"+code.length());
		int startIndex = code.length();
		startIndex = startIndex-3;
		System.out.println("startIndex---"+startIndex);
		code = code.substring(startIndex,startIndex+2 ); //Mangalore(YZ)
		System.out.println("updated code is after substring()-----"+code);
		
		Date mm_yyyy = new Date();
		try {
		DateFormat fmt = new SimpleDateFormat("yyyy-MMM");
		mm_yyyy = fmt.parse(MM_YYYY);
         System.out.println("mm_yyyy----"+mm_yyyy);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
        String _mm_yyyy = new java.text.SimpleDateFormat("yyyy-MM-dd").format(mm_yyyy);
        System.out.println("_mm_yyyy----"+_mm_yyyy);
		
		ModelAndView mv = new ModelAndView();
		String json = "";
		String json_1 = "";
		Object[] objArray = new Object[4];
		objArray[0]=code;
		objArray[1]=_mm_yyyy;
		objArray[2]=sub_date;
		objArray[3]=mpr;
		
		   msg =cORRECTION_DaoImpl.generateResultBean_SP_CORRECTION_APPROVAL_MSG(objArray,request);
           System.out.println("if block--msg==is--"+msg);  
           mv.addObject("ViewBagMessage", msg);
           mv.addObject("ViewBagResult", msg);
        
			
		
		        String USER = (String)request.getSession().getAttribute("USER");
				String FO = USER.substring(0,3);
				System.out.println("FO User in FO_Update_Status_Msg -----"+FO);
			
			List<SP_CORRECTION_LIST_FO_GST_Result> ListFoGstResult =  new ArrayList<SP_CORRECTION_LIST_FO_GST_Result>();
			Object[] objArray_2 = new Object[2];
			objArray_2[0]=FO;
	    	objArray_2[1]=dep;
			ListFoGstResult = cORRECTION_DaoImpl.generateResultBeanList(objArray_2);
		
		
		try {
        	Gson gson = new Gson();
        	json = new Gson().toJson(ListFoGstResult);
        	json_1 = new Gson().toJson(msg);
        	jsonObj.put("data1", json);
        	jsonObj.put("data2", json_1);
        	System.out.println("data1-----"+jsonObj.get("data1"));
        	System.out.println("data2-----"+jsonObj.get("data2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObj;
	
    }
	

}
