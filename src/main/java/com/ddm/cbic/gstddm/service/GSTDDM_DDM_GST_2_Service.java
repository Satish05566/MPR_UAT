package com.ddm.cbic.gstddm.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstddm.model.SP_DDM_GST_2_COMM_TEMP_Result;

@Service
public interface GSTDDM_DDM_GST_2_Service {

	public ModelAndView get_DDM_GST_2(HttpServletRequest request);

	public ModelAndView post_DDM_GST_2(SP_DDM_GST_2_COMM_TEMP_Result gstRev2CommTemp,BindingResult reslt, HttpServletRequest request,
			String btn_submit);

	public ModelAndView gstReport_DDM_GST_2(String report_type, String code, String report_name,
			HttpServletRequest request, String mm_yyyy);
	

}
