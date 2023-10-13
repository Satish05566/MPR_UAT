package com.ddm.cbic.gstddm.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import org.springframework.web.servlet.ModelAndView;


import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.service.GSTDDM_DDM_GST_2_Service;

@Controller
@RequestMapping("/GSTDDM")
public class GSTDDM_DDM_GST_2_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(GSTDDM_DDM_GST_2_Controller.class);
	
	@Autowired
	GSTDDM_DDM_GST_2_Service DDM_GST_2_service;

	 @RequestMapping(value = "/Insert/DDM_GST_2/{request_CSRF_Token}", method = RequestMethod.GET)
		public ModelAndView get_DDM_GST_2(Model model,HttpServletRequest request,@PathVariable("request_CSRF_Token") String request_CSRF_Token) {
         
		 
		 logger.info("welcome-satish");
		           if(request_CSRF_Token != null)
		           {
		        	   return DDM_GST_2_service.get_DDM_GST_2(request);
		           }
		           else
		           {
		        	   return null;
		           }

		        }

		        @RequestMapping(value = "/Insert/DDM_GST_2", method = RequestMethod.POST)
				public ModelAndView post_DDM_GST_2(@Valid @ModelAttribute("ddmGst2CommTemp") SP_DDM_GST_2_COMM_TEMP_Result ddmGst2CommTemp,BindingResult reslt,
						 HttpServletRequest request, String btn_submit, String HDTokenNo) {
				      
		      
		        	ModelAndView modelView  = new ModelAndView();
					if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo")))
				            {   
									
						
						return DDM_GST_2_service.post_DDM_GST_2(ddmGst2CommTemp, reslt, request, btn_submit);
				                   
				            }
				            else
				            {
				            	request.getSession().invalidate();			 
								 modelView.setViewName("GSTDLA/ResourceNotFound");
							     modelView.addObject("message", "");
							     return modelView;
				            }
					
		        }
		        
		        
		        @RequestMapping(value = "/Report/DDM_GST_2/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
		    	public ModelAndView getReport_DDM_GST_2(@PathVariable("Report_Type") String report_type, @PathVariable("Code") String code,@PathVariable("Report_Name") String report_name, @PathVariable("YYYY-MMM") String mm_yyyy ,HttpServletRequest request ,@PathVariable("request_CSRF_Token") String request_CSRF_Token,String Submission_Date) {
		        	
		    		
		    		
		    		if(request_CSRF_Token != null)
		    		{
		    			return DDM_GST_2_service.gstReport_DDM_GST_2(report_type,code,report_name,request,mm_yyyy);
		    		}
		    		else
		    		{
		    			return null;
		    		}
		    		
		     }



}
