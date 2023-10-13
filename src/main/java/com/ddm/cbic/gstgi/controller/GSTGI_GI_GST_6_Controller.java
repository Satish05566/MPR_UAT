package com.ddm.cbic.gstgi.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstgi.model.SP_GI_GST_6_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result;
import com.ddm.cbic.gstgi.service.GSTGI_GI_GST_6_Service;

import com.ddm.cbic.gstgi.dao.implementation.GSTGI_GI_GST_6_Dao_Impl;

import com.google.gson.Gson;

@Controller
@RequestMapping("/GSTGI")
public class GSTGI_GI_GST_6_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(GSTGI_GI_GST_6_Controller.class);
	
	@Autowired
	GSTGI_GI_GST_6_Service GI_GST_6_service;
	
	 @Autowired
		private GSTGI_GI_GST_6_Dao_Impl gstGI_GI_GST_6_Dao_Impl;

	 @RequestMapping(value = "/Insert/GI_GST_6/{request_CSRF_Token}", method = RequestMethod.GET)
		public ModelAndView get_GI_GST_6(Model model,HttpServletRequest request,@PathVariable("request_CSRF_Token") String request_CSRF_Token) {
         
		 
		           logger.info("welcome-amit");
		           if(request_CSRF_Token != null)
		           {
		        	   return GI_GST_6_service.get_GI_GST_6(request);
		           }
		           else
		           {
		        	   return null;
		           }

		        }

		        @RequestMapping(value = "/Insert/GI_GST_6", method = RequestMethod.POST)
				public ModelAndView post_GI_GST_6(@Valid @ModelAttribute("giGst6CommTemp") SP_GI_GST_6_COMM_TEMP_Result giGst6CommTemp,BindingResult reslt,
						 HttpServletRequest request, String btn_submit, String HDTokenNo) {
				      
		      
		        	ModelAndView modelView  = new ModelAndView();
					if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo")))
				            {   
									
						logger.info("welcome-post-Amit");
						return GI_GST_6_service.post_GI_GST_6(giGst6CommTemp, reslt, request, btn_submit);
				                   
				            }
				            else
				            {
				            	request.getSession().invalidate();			 
								 modelView.setViewName("GSTGI/ResourceNotFound");
							     modelView.addObject("message", "");
							     return modelView;
				            }
			
		        }
		        
		        
		        @RequestMapping(value = "/Report/GI_GST_6/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
		    	public ModelAndView getReport_GI_GST_6(@PathVariable("Report_Type") String report_type, @PathVariable("Code") String code,@PathVariable("Report_Name") String report_name, @PathVariable("YYYY-MMM") String mm_yyyy ,HttpServletRequest request ,@PathVariable("request_CSRF_Token") String request_CSRF_Token,String Submission_Date) {
		        	
		    		if(request_CSRF_Token != null)
		    		{
		    			return GI_GST_6_service.gstReport_GI_GST_6(report_type,code,report_name,request,mm_yyyy);
		    		}
		    		else
		    		{
		    			return null;
		    		}
		    		
		     }


		        
		        @RequestMapping(value = "CategoryListBind", method = RequestMethod.GET)
		    	@ResponseBody
		    	public JSONObject CategoryListBind(HttpServletRequest request, HttpServletResponse response) {

		    		ModelAndView mv = new ModelAndView();
		    		logger.info("in CategoryListBind");		    		
		    		List<SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result> identifierListResult = new ArrayList<SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result>();
		    		identifierListResult = gstGI_GI_GST_6_Dao_Impl.get_GI_GST_6_HSN_SAC_MASTER_LIST();


		    		mv.addObject("CategoryListBind", identifierListResult);
		    		String json = null;
		    		try {
		    			Gson gson = new Gson();
		    			json = new Gson().toJson(identifierListResult);

		    		} catch (Exception e) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}
		    		// logger.info("--branchListResult--"+json);
		    		JSONObject jsonObject = new JSONObject();
		    		try {
		    			jsonObject.put("JSONdata", json);
		    			// logger.info("branchListResult in JSONdata" + jsonObject.get("JSONdata"));
		    		} catch (JSONException e) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}

		    		return jsonObject;

		    	}

}
