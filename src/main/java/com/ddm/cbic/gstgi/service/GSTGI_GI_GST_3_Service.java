package com.ddm.cbic.gstgi.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstgi.model.SP_GI_GST_3_COMM_TEMP_Result;

@Service
public interface GSTGI_GI_GST_3_Service {

	public ModelAndView get_GI_GST_3(HttpServletRequest request);

	public ModelAndView post_GI_GST_3(SP_GI_GST_3_COMM_TEMP_Result gstGi3CommTemp,BindingResult reslt, HttpServletRequest request,
			String btn_submit);

	public ModelAndView gstReport_GI_GST_3(String report_type, String code, String report_name,
			HttpServletRequest request, String mm_yyyy);
	

}
