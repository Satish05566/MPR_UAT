package com.ddm.cbic.gstgst.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_TEMP_Result;

public interface GST_GST_2_Service {
	
	public ModelAndView get_GST_GST_2(HttpServletRequest request);

	public ModelAndView post_GST_GST_2(SP_GST_GST_2_COMM_TEMP_Result dpmGst17CommTemp,
			BindingResult reslt, HttpServletRequest request,
			String btn_submit);

	public ModelAndView gstReport_GST_GST_2(String report_type, String code, String report_name,
			HttpServletRequest request, String mm_yyyy);
	

}
