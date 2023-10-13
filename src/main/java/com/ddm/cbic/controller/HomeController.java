package com.ddm.cbic.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

import com.ddm.cbic.dao.implementation.SP_LIST_REGION_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_COMM_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_ZONE_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_MPR_GST_LIST_USER_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_MPR_LIST_FF_DaoImpl;

import com.ddm.cbic.model.SP_LIST_REGION_Result;
import com.ddm.cbic.model.SP_LIST_COMM_Result;
import com.ddm.cbic.model.SP_LIST_ZONE_Result;
import com.ddm.cbic.model.SP_MPR_GST_LIST_USER_Result;
import com.ddm.cbic.model.SP_MPR_LIST_FF_Result;

import com.google.gson.Gson;


@Controller
@RequestMapping("/Home")
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(GSTHomeController.class);
	
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
	
	@RequestMapping(value = "/Home/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView Home(HttpServletRequest request, HttpServletResponse response,@PathVariable("request_CSRF_Token") String request_CSRF_Token)
    {
		logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token"+ request_CSRF_Token);
		if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {
		
		System.out.println("--Inside PRE_Home--");
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		System.out.println("---userId--"+request.getSession().getAttribute("USER"));
		System.out.println("--type--"+request.getSession().getAttribute("TYPE"));
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		 mv.setViewName("Home/Home");
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
	
	@RequestMapping(value = "/Report/{request_CSRF_Token}", method = RequestMethod.GET)	
	public ModelAndView Report(HttpServletRequest request, HttpServletResponse response,@PathVariable("request_CSRF_Token") String request_CSRF_Token)
    {
		logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token"+ request_CSRF_Token);
		if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {
		
		System.out.println("in PreReport action");
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		System.out.println(request.getSession().getAttribute("USER"));
		System.out.println(request.getSession().getAttribute("TYPE"));
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		// mv.setViewName("GSTHome/Home");
		 mv.setViewName("Home/Report");
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


	@RequestMapping(value = "/Insert", method = RequestMethod.GET)
	public ModelAndView Insert(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("in Insert action");
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		System.out.println(request.getSession().getAttribute("USER"));
		System.out.println(request.getSession().getAttribute("TYPE"));
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		 mv.setViewName("Home/Insert");
		 mv.addObject("message", "");
		 request.getSession().setAttribute("ModelAndView", mv);
	    return mv;
	}
	
	//@RequestMapping(value = "/MSR", method = RequestMethod.GET)
	@RequestMapping(value = "/MSR/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView MSR(HttpServletRequest request, HttpServletResponse response,@PathVariable("request_CSRF_Token") String request_CSRF_Token)
    {
		logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token"+ request_CSRF_Token);
		if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {	
		System.out.println("in MSR action");
		String userId = (String)request.getSession().getAttribute("USER");
		String type = (String)request.getSession().getAttribute("TYPE");
		System.out.println(request.getSession().getAttribute("USER"));
		System.out.println(request.getSession().getAttribute("TYPE"));
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("USER",userId);
		 mv.addObject("TYPE",type);
		 mv.setViewName("Home/MSR");
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
	

	@RequestMapping(value = "/Zone_Bind", method = RequestMethod.GET)
	public @ResponseBody JSONObject Zone_Bind(String dep)
    {
		System.out.println("in ZoneBind action dep" + dep);
		List<SP_LIST_ZONE_Result> gstList = new ArrayList<SP_LIST_ZONE_Result>();
		if(dep.equalsIgnoreCase("null"))
		{
			dep=null;
		}
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
	
	@RequestMapping(value = "/Comm_Bind", method = RequestMethod.GET)
	public @ResponseBody JSONObject Comm_Bind(String zone,String dep)
    {
		System.out.println("in CommBind action");
		System.out.println("in CommBind action zone--"+zone);
		System.out.println("in CommBind action dep--"+dep);
		
		List<SP_LIST_COMM_Result> listGstComm = new ArrayList<SP_LIST_COMM_Result>();
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
	

	//@PostMapping(path = "/ReportBind")
	@RequestMapping(value = "/ReportBind", method = RequestMethod.GET )
	public @ResponseBody JSONObject ReportBind(String comm,String dep, String type,String zone)
    {	
		if(null != type) {}else {type="";}
		//String type ="";
		JSONObject jsonObj = new JSONObject();
		System.out.println("in ReportBind action");
		
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
		
		
		//if (!string.IsNullOrEmpty(comm) && !string.IsNullOrEmpty(dep))
		if (((null !=comm) && (comm.trim().length() > 0))&&((null != dep) && (dep.trim().length() > 0)))
        {
			 
            logger.info("Inside  comm and dep not blank not null block---");
            logger.info("comm---"+comm);
            logger.info("dep---"+dep);
            logger.info("zone---"+zone);
            mpr1 = mprListUser(dep, "Part-I Revenue", comm, zone, dep + "_Part_1",type);
            mpr2 = mprListUser(dep, "Part-II Anti-smuggling", comm, zone, "CUS_Part_2",type); 
            if (dep.equalsIgnoreCase("CEX") || dep.equalsIgnoreCase("STX"))
            {
            mpr3 = mprListUser(dep, "Part-III Anti-evasion", comm, zone, dep + "_Part_3",type);  
            }
            mpr4 = mprListUser(dep, "Part-IV Audit", comm, zone, dep + "_Part_4",type);
            mpr5 = mprListUser(dep, "Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous", comm, zone, dep + "_Part_5",type);
            mpr6 = mprListUser(dep, "Part-VI Valuation", comm, zone, "CUS_Part_6",type);
            mpr7 = mprListUser(dep, "Part-VII Legal", comm, "", dep + "_Part_7",type);
            mpr8 = mprListUser(dep, "Part-VIII Arrears", comm, zone, dep + "_Part_8",type);            
            mpr9 = mprListUser(dep, "Part-IX Logistics", comm, zone, "CUS_Part_9",type);
            
            
        }
        else
        {
        	logger.info("zone--"+zone);
        	logger.info("comm--"+comm);
        	logger.info("dep--"+dep);
        	if((null != comm)&&(comm.length()>0))
            {
            	System.out.println("Inside comm not blenk or null");
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
			logger.info("jsonObject.get(data1)----> in ReportBind" + jsonObject.get("data1")  );
			logger.info("jsonObject.get(data2)----> in ReportBind" + jsonObject.get("data2")  );
			logger.info("jsonObject.get(data3)----> in ReportBind" + jsonObject.get("data3")  );
			logger.info("jsonObject.get(data4)----> in ReportBind" + jsonObject.get("data4")  );
			logger.info("jsonObject.get(data5)----> in ReportBind" + jsonObject.get("data5")  );
			logger.info("jsonObject.get(data6)----> in ReportBind" + jsonObject.get("data6")  );
			logger.info("jsonObject.get(data7)----> in ReportBind" + jsonObject.get("data7")  );
			logger.info("jsonObject.get(data8)----> in ReportBind" + jsonObject.get("data8")  );
			logger.info("jsonObject.get(data9)----> in ReportBind" + jsonObject.get("data9")  );
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("jsonObj.get(data1)----> " + jsonObj.get("data1")  );
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
    	
    	mprListUser = sP_MPR_GST_LIST_USER_DaoImpl.generateResultBeanListNonGST(objArray);
    	    	
        //List<SP_MPR_GST_LIST_USER_Result> originalList = sP_MPR_GST_LIST_USER_DaoImpl.generateResultBeanList(objArray);                
    	if(groupName.equalsIgnoreCase("Part-I Revenue"))
        {
        	if (dep.equalsIgnoreCase("CUS") || ((null == dep) || (dep.length() == 0)))
            {
        		mprList = mprListUser.stream()
        				.filter(employee -> !employee.getCODE().equalsIgnoreCase("DDM-CUS-1A"))
        				.collect(Collectors.toList());
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
        				.filter(employee -> !employee.getCODE().equalsIgnoreCase("TAR-CE-6") && !employee.getCODE().equalsIgnoreCase("TAR-CUS-6") && !employee.getCODE().equalsIgnoreCase("TAR-ST-6"))
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
    
        	mprList = mprListFF;
      
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
            

            String r_name = Report_Name.trim().substring(0, 3);
            String Report_Type = "";
            String MM_YYYY = year.trim() + '-' + month.trim();
            String Code = "0";
            

            if(((null == zone_code )||(zone_code.trim().length()== 0)))
            {
                Report_Type = "All";
                Report_Name = "All India";
                if(r_name.equalsIgnoreCase("DDM"))
                {
                url = "/"+ r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
                }
                else
                {
                	url = "/" + "GST" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
                }
                //return RedirectToAction(viewname, r_name + "/Report", new { Report_Type = Report_Type, Report_Name = Report_Name, Code = Code, MM_YYYY = MM_YYYY });
            }

           else if( ((null != zone_code )&&(zone_code.trim().length()> 0))&&((null != zone_name )&&(zone_name.trim().length()> 0))&&((null == comm_code )||(comm_code.trim().length()== 0)) )
            {
            	Code = zone_code;
                Report_Type = "Zone";
                Report_Name = zone_name;
                
                if(r_name.equalsIgnoreCase("DDM"))
                {
                	url = "/"+ r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
                }
                else
                {
                	url = "/" + "GST" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
                }
                //url = "/" + "GST" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
            }

            else if ( ((null != comm_code )&&(comm_code.trim().length()> 0))&&((null != comm_name )&&(comm_name.trim().length()> 0)))
            {
            	Code = comm_code;
                Report_Type = "Comm";
                Report_Name = comm_name;
                
                if(r_name.equalsIgnoreCase("DDM"))
                {
                	url = "/"+ r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
                }
                else
                {
                	url = "/" + "GST" + r_name + "/Report/" + viewname + "/" + Report_Type + "/" + Code + "/" + Report_Name + "/" + MM_YYYY;
                }
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
