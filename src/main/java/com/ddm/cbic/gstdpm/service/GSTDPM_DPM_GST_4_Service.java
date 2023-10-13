package com.ddm.cbic.gstdpm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_REFUND_CATEGORY;


@Service
public interface GSTDPM_DPM_GST_4_Service {
	
	 public ModelAndView gstReport_DPM_GST_4(String report_type, String code,
	 String report_name, HttpServletRequest request, String mm_yyyy,String request_CSRF_Token);

	 public ModelAndView get_DPM_GST_4(Model model, HttpServletRequest request, String request_CSRF_Token) ;
	 public ModelAndView post_DPM_GST_4(SP_DPM_GST_4_COMM_TEMP_Result dpmGst12CommTemp, BindingResult reslt, Model model,
				HttpServletRequest request, String btn_submit, String HDTokenNo);
	 
	 public List<SP_DPM_GST_4_REFUND_CATEGORY> generateResultBeanSP_DPM_GST_4_REFUND_LIST();
}
