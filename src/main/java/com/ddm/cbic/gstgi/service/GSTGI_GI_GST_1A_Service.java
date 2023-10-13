package com.ddm.cbic.gstgi.service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_TEMP_Result;



public interface GSTGI_GI_GST_1A_Service {
	
	 public ModelAndView get_GI_GST_1A(HttpServletRequest request);
	 
	 public ModelAndView post_GI_GST_1A(@Valid SP_GI_GST_1A_COMM_TEMP_Result giGst1CommTemp, BindingResult reslt, HttpServletRequest request,
				String btn_submit, String HDTokenNo);
	

}
