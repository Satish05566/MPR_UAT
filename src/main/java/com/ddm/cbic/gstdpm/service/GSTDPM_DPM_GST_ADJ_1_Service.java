package com.ddm.cbic.gstdpm.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening;


@Service
public interface GSTDPM_DPM_GST_ADJ_1_Service {
	
	 public ModelAndView gstReport_DPM_GST_ADJ_1(String report_type, String code,
	 String report_name, HttpServletRequest request, String mm_yyyy,String request_CSRF_Token);

	 public ModelAndView get_DPM_GST_ADJ_1(Model model, HttpServletRequest request, String request_CSRF_Token) ;
	 public ModelAndView post_DPM_GST_ADJ_1(SP_DPM_GST_ADJ_1_COMM_TEMP_Result dpmGstAdj1CommTemp, BindingResult reslt, Model model,
				HttpServletRequest request, String btn_submit, String HDTokenNo);
	 public ModelAndView post_DPM_GST_ADJ_1_OPENING(SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening dpmGstAdj1CommTemp, BindingResult reslt, Model model,
				HttpServletRequest request, String btn_submit, String HDTokenNo);
}
