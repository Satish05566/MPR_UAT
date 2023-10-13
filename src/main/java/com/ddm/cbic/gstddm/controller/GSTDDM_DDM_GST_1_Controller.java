package com.ddm.cbic.gstddm.controller;

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

import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.service.GSTDDDM_DDM_GST_1_Service;


@Controller
@RequestMapping("/GSTDDM")
public class GSTDDM_DDM_GST_1_Controller {
	
	
	@Autowired
	GSTDDDM_DDM_GST_1_Service ddm_gst_1_service; //CHANGE OBJECT

	 @RequestMapping(value = "/Insert/DDM_GST_1/{request_CSRF_Token}", method = RequestMethod.GET)
	 // GST_REV_1--->DDM_GST_1
		public ModelAndView get_DDM_GST_1(Model model,HttpServletRequest request,
				@PathVariable("request_CSRF_Token") String request_CSRF_Token) {          
		           if(request_CSRF_Token != null)
		           {
		        	   return ddm_gst_1_service.get_DDM_GST_1(request);
		           }                            
		           else
		           {
		        	   return null;
		           }
		        }

	 
		        @RequestMapping(value = "/Insert/DDM_GST_1", method = RequestMethod.POST)
				public ModelAndView post_DDM_GST_1( @Valid @ModelAttribute("ddmGst1CommTemp") 
				SP_DDM_GST_1_COMM_TEMP_Result ddmGst1CommTemp, BindingResult reslt,
						 HttpServletRequest request, String btn_submit, String HDTokenNo) {
				      
		        	ModelAndView modelView  = new ModelAndView();
					if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo")))
				            {   									
					           	return ddm_gst_1_service.post_DDM_GST_1(ddmGst1CommTemp, reslt, request, btn_submit,HDTokenNo);
				            }                           
				            else
				            {
				            	request.getSession().invalidate();			 
								 modelView.setViewName("GSTDDM/ResourceNotFound");
							     modelView.addObject("message", "");
							     return modelView;
				            }					
		        }
		        

		        
		        @RequestMapping(value = "/Report/DDM_GST_1/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
		    	public ModelAndView getReport_GST_REV_1(@PathVariable("Report_Type") String report_type, @PathVariable("Code") String code,@PathVariable("Report_Name") String report_name, @PathVariable("YYYY-MMM") String mm_yyyy ,HttpServletRequest request ,@PathVariable("request_CSRF_Token") String request_CSRF_Token,String Submission_Date) {
		        	
		    		
		    		
		    		if(request_CSRF_Token != null)
		    		{
		    			return ddm_gst_1_service.gstReport_DDM_GST_1(report_type,code,report_name,request,mm_yyyy);
		    		}
		    		else
		    		{
		    			return null;
		    		}
		    		
		     }





}
