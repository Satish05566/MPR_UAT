package com.ddm.cbic.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.ddm.cbic.dao.implementation.SP_CHANGE_PASS_CBEC_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_CHANGE_PASS_COMM_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_CHANGE_PASS_FO_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_CHANGE_PASS_ZONE_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_CORRECTION_LIST_ZONE_GST_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_DRI_CUS_1_ALL_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_COMM_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_GST_COMM_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_GST_ZONE_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_LIST_ZONE_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_MPR_GST_LIST_USER_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_MPR_LIST_FF_DaoImpl;
import com.ddm.cbic.model.SP_CHANGE_PASS_CBEC_Result;
import com.ddm.cbic.model.SP_CHANGE_PASS_COMM_GST_Result;
import com.ddm.cbic.model.SP_CHANGE_PASS_FO_Result;
import com.ddm.cbic.model.SP_CHANGE_PASS_ZONE_GST_Result;
import com.ddm.cbic.model.SP_CORRECTION_LIST_ZONE_GST_Result;
import com.ddm.cbic.model.SP_DRI_CUS_1_ALL_Result;
import com.ddm.cbic.model.SP_LIST_COMM_Result;
import com.ddm.cbic.model.SP_LIST_GST_COMM_Result;
import com.ddm.cbic.model.SP_LIST_GST_ZONE_Result;
import com.ddm.cbic.model.SP_LIST_ZONE_Result;
import com.ddm.cbic.model.SP_MPR_GST_LIST_USER_Result;
import com.ddm.cbic.model.SP_MPR_LIST_FF_Result;
import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class CorrectionController {

	@Autowired 
	private  SP_CORRECTION_LIST_ZONE_GST_DaoImpl sp_CORRECTION_LIST_ZONE_GST_DaoImpl;

        private static final Logger logger = LoggerFactory.getLogger(CorrectionController.class);

//Correction Start

//@GetMapping("/Correction"       
@RequestMapping(value = "/Correction/{request_CSRF_Token}", method = RequestMethod.GET)
public ModelAndView getZoneCorrection(HttpServletRequest request, HttpServletResponse response,@PathVariable("request_CSRF_Token") String request_CSRF_Token)
{	
	logger.info("session CSRF token"+ request.getSession().getAttribute("CSRF_Token").toString());
	logger.info("request CSRF token"+ request_CSRF_Token);
	if(request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {	
       ModelAndView mv = new ModelAndView();
       mv.setViewName("GSTHome/Correction");
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
/*
@RequestMapping(value = "/Zone_CorrectionList", method = RequestMethod.POST)
public @ResponseBody JSONObject Zone_CorrectionList(String dep,HttpServletRequest request)
   {
	  logger.info("--Zone_CorrectionList--");
	  String COMM_CODE = (String) request.getSession().getAttribute("CODE");
	  logger.info("dep-->"+dep+" COMM_CODE-->"+COMM_CODE);
	  JSONObject jsonObject = new JSONObject();
	  Object[] objArray=new Object[2];
	  objArray[0]=COMM_CODE;
	  objArray[1]=dep;
	  String json = null;
		List<SP_CORRECTION_LIST_ZONE_GST_Result> dt = new ArrayList<SP_CORRECTION_LIST_ZONE_GST_Result>();
		try {
			dt =sp_CORRECTION_LIST_ZONE_GST_DaoImpl.generateResultBeanListSP_CORRECTION_LIST_ZONE_GST(objArray);
	    	//logger.info("dt--");
	    	json = new Gson().toJson(dt);
			jsonObject.put("dt", json);
			logger.info("--JSONObject  DesignationList---->" + jsonObject.get("dt"));
		} catch (Exception e) {	e.printStackTrace();}	
	  
   return jsonObject; 
   }

@RequestMapping(value = "/Zone_Update_Status", method = RequestMethod.POST)
public @ResponseBody JSONObject Zone_Update_Status(String list_values,String dep,HttpServletRequest request)
   {
	  logger.info("--Zone_Update_Status--");
	  logger.info("list_values-->"+list_values+" dep-->"+dep);
	  String dt = "";
	  JSONObject jsonObject = new JSONObject();
	  if(list_values!=null) {
		  String[] d_zone = list_values.split(",");
		  for(String _zone:d_zone) {
			  logger.info("_zone-->"+_zone);
		  }
		  logger.info("d_zone.length-->"+d_zone.length);
		  String p_SUBMISSION_DATE="",p_MM_YYYY="",p_COMM_CODE="",_MM_YYYY="";
		  
		  for (int i = 0; i < d_zone.length; i = i + 7)
	        {
			  logger.info("d_zone"+i+"-->"+d_zone[i]);
			  d_zone[i + 3]=d_zone[i + 3].trim(); //2020-Jan
	          dt = "01"+"-"+d_zone[i + 3].substring(5, 8) + "-" +d_zone[i + 3].substring(0, 4) ;  //01-Jan-2020
	          SimpleDateFormat formatter_dt = new SimpleDateFormat("dd-MMM-yyyy");
				try {   Date date = formatter_dt.parse(dt); 
					    DateFormat DtFormat = new SimpleDateFormat("yyyy-MM-dd");
					    dt = DtFormat.format(date);
				    } catch (ParseException e) {e.printStackTrace();}  
			   p_MM_YYYY=dt;
			   p_COMM_CODE=d_zone[i].substring(d_zone[i].length()-3, d_zone[i].length()-1) ;
			   p_SUBMISSION_DATE=d_zone[i + 4]+d_zone[i + 5];
	          String p_MPR=d_zone[i + 2].trim();
	          logger.info("p_COMM_CODE-->"+p_COMM_CODE+" p_MM_YYYY-->"+p_MM_YYYY+" p_MPR-->"+p_MPR);
			  
			  String Submission_Date=p_SUBMISSION_DATE;//Nov 3, 2020 12:56:34 PM
			  String SubmissionDate=Submission_Date.substring(5,7).trim()+"-"+Submission_Date.substring(0,4).trim()+"-"+Submission_Date.substring(8,12);   //Submission_Date.substring(0,12);
			  logger.info("--Submission_Date--"+Submission_Date); 
			 
			  SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
				try {  
				        Date date = formatter.parse(SubmissionDate); 
					    DateFormat DtFormat = new SimpleDateFormat("yyyy-MM-dd");
					    _MM_YYYY = DtFormat.format(date);
				    } catch (ParseException e) {e.printStackTrace();}  
				
				 SubmissionDate=_MM_YYYY+" "+Submission_Date.substring(13,21)+".000000";
				 logger.info("--SubmissionDate--"+SubmissionDate);
          int  msg= sp_CORRECTION_LIST_ZONE_GST_DaoImpl.generateResultBeanListSP_CORRECTION_VALIDATION(p_COMM_CODE, p_MM_YYYY,SubmissionDate, p_MPR);
          }
		  
		  String COMM_CODE = (String) request.getSession().getAttribute("CODE");
		  logger.info("dep-->"+dep+" COMM_CODE-->"+COMM_CODE);
		  
		  Object[] objArray=new Object[2];
		  objArray[0]=COMM_CODE;
		  objArray[1]=dep;
		  String json = null;
			List<SP_CORRECTION_LIST_ZONE_GST_Result> data = new ArrayList<SP_CORRECTION_LIST_ZONE_GST_Result>();
			try {
				data =sp_CORRECTION_LIST_ZONE_GST_DaoImpl.generateResultBeanListSP_CORRECTION_LIST_ZONE_GST(objArray);
		    	json = new Gson().toJson(data);
				jsonObject.put("data", json);
				logger.info("--JSONObject  Data---->" + jsonObject.get("data"));
			} catch (Exception e) {	e.printStackTrace();}
			 return jsonObject; 
	      }
		 try {
			jsonObject.put("data", "");
		   } catch (JSONException e) {	e.printStackTrace();}
	    return jsonObject;
	  
   }

	*/
	
	
}
