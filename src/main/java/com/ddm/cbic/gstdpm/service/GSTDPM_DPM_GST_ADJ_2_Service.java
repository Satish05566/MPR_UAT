package com.ddm.cbic.gstdpm.service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_OPENING_Result;


@Service
public interface GSTDPM_DPM_GST_ADJ_2_Service {
	
	 public ModelAndView gstReport_DPM_GST_ADJ_2(String report_type, String code,
	 String report_name, HttpServletRequest request, String mm_yyyy,String request_CSRF_Token);

	 public ModelAndView get_DPM_GST_ADJ_2(Model model, HttpServletRequest request, String request_CSRF_Token) ;
	 public ModelAndView post_DPM_GST_ADJ_2(SP_DPM_GST_ADJ_2_COMM_TEMP_Result dpmGstAdj2CommTemp, BindingResult reslt, Model model,
				HttpServletRequest request, String btn_submit, String HDTokenNo);
	 
	 ModelAndView post_DPM_GST_ADJ_2_OPENING(@Valid SP_DPM_GST_ADJ_2_OPENING_Result DPMGstAdj2CommTemp, BindingResult reslt,
				HttpServletRequest request, String btn_submit);
				
				
}
