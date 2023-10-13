package com.ddm.cbic.gstdpm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_TEMP_Result;


@Service
public interface GSTDPM_DPM_GST_ADJ_3_Service {
	
	 public ModelAndView gstReport_DPM_GST_ADJ_3(String report_type, String code,
	 String report_name, HttpServletRequest request, String mm_yyyy,String request_CSRF_Token);

	 public ModelAndView get_DPM_GST_ADJ_3(Model model, HttpServletRequest request, String request_CSRF_Token) ;
	 public ModelAndView post_DPM_GST_ADJ_3(SP_DPM_GST_ADJ_3_COMM_TEMP_Result dpmGst12CommTemp, BindingResult reslt, Model model,
				HttpServletRequest request, String btn_submit, String HDTokenNo);
	 
	public ModelAndView post_DPM_GST_ADJ_3_OPENING_INSERT(BindingResult reslt,
	String Appeals_ADC_OPENING_NO,String Appeals_ADC_OPENING_AMT,
	String Appeals_DC_OPENING_NO,String Appeals_DC_OPENING_AMT,
	String Appeals_SUP_OPENING_NO,String Appeals_SUP_OPENING_AMT,
	
	String Injunction_ADC_OPENING_NO,String Injunction_ADC_OPENING_AMT,
	String Injunction_DC_OPENING_NO,String Injunction_DC_OPENING_AMT,
	String Injunction_SUP_OPENING_NO,String Injunction_SUP_OPENING_AMT,
	
	String CAG_ADC_OPENING_NO,String CAG_ADC_OPENING_AMT,
	String CAG_DC_OPENING_NO,String CAG_DC_OPENING_AMT,
	String CAG_SUP_OPENING_NO,String CAG_SUP_OPENING_AMT,
	
	String Board_ADC_OPENING_NO,String Board_ADC_OPENING_AMT,
	String Board_DC_OPENING_NO,String Board_DC_OPENING_AMT,
	String Board_SUP_OPENING_NO,String Board_SUP_OPENING_AMT,
	HttpServletRequest request, String btn_submit, String HDTokenNo,String MM_YYYY);	
	
	//public List<SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result> get_DPM_GST_ADJ_3_REGION_LIST(String COMM_CODE,String MM_YYYY);
}
