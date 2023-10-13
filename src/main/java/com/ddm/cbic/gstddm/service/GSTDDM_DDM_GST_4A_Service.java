package com.ddm.cbic.gstddm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_COMM_TEMP_Result;

@Service
public interface GSTDDM_DDM_GST_4A_Service {
	
	public ModelAndView getReport_DDM_GST_4A(String Report_Type, String Code, String Report_Name, String MM_YYYY,
			HttpServletRequest request, String request_CSRF_Token);

	public ModelAndView get_DDM_GST_4A(Model model, HttpServletRequest request, String request_CSRF_Token);

	public ModelAndView post_DDM_GST_4A(SP_DDM_GST_4A_COMM_TEMP_Result DdmCus7CommTemp, BindingResult reslt,
			Model model, HttpServletRequest request, String btn_submit, String HDTokenNo);

}
