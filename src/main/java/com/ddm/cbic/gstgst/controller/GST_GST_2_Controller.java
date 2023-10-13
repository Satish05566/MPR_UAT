package com.ddm.cbic.gstgst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_TEMP_Result;
import com.ddm.cbic.gstgst.service.GST_GST_2_Service;

@Controller
@RequestMapping("/GSTGST")
public class GST_GST_2_Controller {
	
	@Autowired
	GST_GST_2_Service gst_gst_2_service;

	 @RequestMapping(value = "/Insert/GST_GST_2/{request_CSRF_Token}", method = RequestMethod.GET)
		public ModelAndView get_GST_GST_2(Model model,HttpServletRequest request,
				@PathVariable("request_CSRF_Token") String request_CSRF_Token) {
          
		           if(request_CSRF_Token != null)
		           {
		        	   return gst_gst_2_service.get_GST_GST_2(request);
		           }
		           else
		           {
		        	   return null;   
		           }

		        }

		        @RequestMapping(value = "/Insert/GST_GST_2", method = RequestMethod.POST)
				public ModelAndView post_GST_GST_2(@Valid @ModelAttribute("gstGst2CommTemp") 
				SP_GST_GST_2_COMM_TEMP_Result gstGst2CommTemp,BindingResult reslt,
						 HttpServletRequest request, String btn_submit, String HDTokenNo) {
				      
		      
		        	ModelAndView modelView  = new ModelAndView();
					if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo")))
				            {   
						return gst_gst_2_service.post_GST_GST_2(gstGst2CommTemp, reslt, 
								request, btn_submit);
				            }
				            else
				            {
				            	request.getSession().invalidate();			 
								 modelView.setViewName("GSTDLA/ResourceNotFound");
							     modelView.addObject("message", "");
							     return modelView;
				            }					
		        }		        
		        
		        @RequestMapping(value = "/Report/GST_GST_2/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
		    	public ModelAndView getReport_GST_GST_2(@PathVariable("Report_Type") String report_type, 
		    			@PathVariable("Code") String code,
		    			@PathVariable("Report_Name") String report_name, @PathVariable("YYYY-MMM") String mm_yyyy ,
		    			HttpServletRequest request ,@PathVariable("request_CSRF_Token") String request_CSRF_Token,
		    			String Submission_Date) {
		        	
		    		
		    		
		    		if(request_CSRF_Token != null)
		    		{
		    			return gst_gst_2_service.gstReport_GST_GST_2(report_type,code,report_name,request,mm_yyyy);
		    		}
		    		else
		    		{
		    			return null;
		    		}
		    		
		     }

}
