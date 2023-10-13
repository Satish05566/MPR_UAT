package com.ddm.cbic.gstdpm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_COMM_TEMP_Result;

public interface GSTDPM_DPM_GST_14A_Service {
	
	public ModelAndView get_DPM_GST_14A(HttpServletRequest request);

	public ModelAndView post_DPM_GST_14A(SP_DPM_GST_14A_COMM_TEMP_Result dpmGst14ACommTemp,BindingResult reslt, HttpServletRequest request,
			String btn_submit);

	public ModelAndView gstReport_DPM_GST_14A(String report_type, String code, String report_name,
			HttpServletRequest request, String mm_yyyy);
	

}
