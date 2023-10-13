package com.ddm.cbic.gstgi.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_TEMP_Result;

public interface GSTGI_GI_GST_4_Service {

	ModelAndView get_GI_GST_4(HttpServletRequest request);

	ModelAndView gstReport_GI_GST_4(String report_type, String code, String report_name, HttpServletRequest request,
			String mm_yyyy);

	public ModelAndView post_GI_GST_4(SP_GI_GST_4_COMM_TEMP_Result giGst4CommTemp, BindingResult reslt,
			HttpServletRequest request, String btn_submit);

}
