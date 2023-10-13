package com.ddm.cbic.gstddm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstddm.model.SP_DDM_GST_5_COMM_TEMP_Result;



@Service
public interface GSTDDM_DDM_GST_5_Service {

	public ModelAndView getReport_DDM_GST_5(String Report_Type, String Code, String Report_Name, String MM_YYYY,
			HttpServletRequest request, String request_CSRF_Token);

	public ModelAndView get_DDM_GST_5(Model model, HttpServletRequest request, String request_CSRF_Token);

	public ModelAndView post_DDM_GST_5(SP_DDM_GST_5_COMM_TEMP_Result DdmGstRev3CommTemp, BindingResult reslt, Model model,
			HttpServletRequest request, String btn_submit, String HDTokenNo);

}
