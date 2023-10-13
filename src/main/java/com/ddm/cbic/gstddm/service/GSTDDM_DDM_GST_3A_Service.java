package com.ddm.cbic.gstddm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_COMM_TEMP_Result;

@Service
public interface GSTDDM_DDM_GST_3A_Service {

	public ModelAndView getReport_DDM_GST_3A(String Report_Type, String Code, String Report_Name, String MM_YYYY,
			HttpServletRequest request, String request_CSRF_Token);

	public ModelAndView get_DDM_GST_3A(Model model, HttpServletRequest request, String request_CSRF_Token);

	public ModelAndView post_DDM_GST_3A(SP_DDM_GST_3A_COMM_TEMP_Result DdmGstRev3ACommTemp, BindingResult reslt, Model model,
			HttpServletRequest request, String btn_submit, String HDTokenNo);

}
