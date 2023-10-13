package com.ddm.cbic.gstgi.service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstgi.model.SP_GI_GST_1_COMM_TEMP_Result;



public interface GSTGI_GI_GST_1_Service {
	
	 public ModelAndView get_GI_GST_1(HttpServletRequest request);
	 
	 public ModelAndView post_GI_GST_1(@Valid SP_GI_GST_1_COMM_TEMP_Result giGst1CommTemp, BindingResult reslt, HttpServletRequest request,
				String btn_submit, String HDTokenNo);
	 
	public ModelAndView gstReport_GI_GST_1(String report_type, String code, String report_name,
			HttpServletRequest request, String mm_yyyy);
		
	 
	 

	
	
	
	

}
