package com.ddm.cbic.gstgi.service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstgi.model.SP_GI_GST_2_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_OPENING_Result;

public interface GSTGI_GI_GST_2_Service {

	ModelAndView get_GI_GST_2(HttpServletRequest request);

	ModelAndView gstReport_GI_GST_2(String report_type, String code, String report_name, HttpServletRequest request,
			String mm_yyyy);

	public ModelAndView post_GI_GST_2(SP_GI_GST_2_COMM_TEMP_Result giGst2CommTemp, BindingResult reslt,
			HttpServletRequest request, String btn_submit);

	ModelAndView post_GI_GST_2_OPENING(@Valid SP_GI_GST_2_OPENING_Result gIGst2CommTemp, BindingResult reslt,
			HttpServletRequest request, String btn_submit);
}
