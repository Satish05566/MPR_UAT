package com.ddm.cbic.gstdpm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_COMM_TEMP_Result;

public interface GSTDPM_DPM_GST_14B_Service {
	
	
	public ModelAndView get_DPM_GST_14B(HttpServletRequest request);

	public ModelAndView post_DPM_GST_14B(SP_DPM_GST_14B_COMM_TEMP_Result dpmGst14ACommTemp,BindingResult reslt, HttpServletRequest request,
			String btn_submit);


	

}
