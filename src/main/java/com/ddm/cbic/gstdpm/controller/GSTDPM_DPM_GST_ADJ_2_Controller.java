package com.ddm.cbic.gstdpm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_2_OPENING_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_ADJ_2_Service;
import com.ddm.cbic.gstgi.model.SP_GI_GST_2_OPENING_Result;

@Controller
@RequestMapping("/GSTDPM")
public class GSTDPM_DPM_GST_ADJ_2_Controller {
	

	@Autowired
	GSTDPM_DPM_GST_ADJ_2_Service gstdpm_DPM_GST_ADJ_2_Service;

		 @RequestMapping(value = "/Report/DPM_GST_ADJ_2/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", 
				 method = RequestMethod.GET)
	 	public ModelAndView getReport_DPM_GST_ADJ_2(@PathVariable("Report_Type") String report_type, 
		@PathVariable("Code") String code,
		@PathVariable("Report_Name") String report_name,
		@PathVariable("YYYY-MMM") String mm_yyyy ,
		HttpServletRequest request ,
		@PathVariable("request_CSRF_Token") String request_CSRF_Token, 
		String Submission_Date) {	     	
		/* ModelAndView modelView = new ModelAndView(); */	 		
	 		if(request_CSRF_Token != null)
	 		{
			 return
					 gstdpm_DPM_GST_ADJ_2_Service.gstReport_DPM_GST_ADJ_2(report_type,code,report_name,
			  request,mm_yyyy,request_CSRF_Token);			 
	 		}
	 		else
	 		{
	 			return null;
	 		}	 		
	  }
		 
		 
	 @RequestMapping(value = "/Insert/DPM_GST_ADJ_2/{request_CSRF_Token}", method = RequestMethod.GET)
		public ModelAndView get_DPM_GST_ADJ_2(Model model, HttpServletRequest request,
				@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

			ModelAndView postDpmAdj2modelView = new ModelAndView();

			postDpmAdj2modelView = gstdpm_DPM_GST_ADJ_2_Service.get_DPM_GST_ADJ_2(model, request, request_CSRF_Token);

			return postDpmAdj2modelView;

		}

		@RequestMapping(value = "/Insert/DPM_GST_ADJ_2", method = RequestMethod.POST)
		public ModelAndView post_DPM_GST_ADJ_2(
				@Valid @ModelAttribute("dpmGstAdj2CommTemp") SP_DPM_GST_ADJ_2_COMM_TEMP_Result dpmGstAdj2CommTemp,
				BindingResult reslt, Model model, HttpServletRequest request, String btn_submit, String HDTokenNo) {

			ModelAndView postDpmAdj2modelView = new ModelAndView();

			postDpmAdj2modelView = gstdpm_DPM_GST_ADJ_2_Service.post_DPM_GST_ADJ_2(dpmGstAdj2CommTemp,
					reslt, model, request, btn_submit,
					HDTokenNo);

			return postDpmAdj2modelView;
		}
		

		@RequestMapping(value = "/Insert/DPM_GST_ADJ_2_Opening", method = RequestMethod.POST)
		public ModelAndView postDPM_GST_ADJ_2_OPENING(@Valid @ModelAttribute("dpmGstAdj2CommTemp") 
		SP_DPM_GST_ADJ_2_OPENING_Result dpmGstAdj2CommTemp,BindingResult reslt, 
				String btn_submit, String HDTokenNo,HttpServletRequest request) {
			
			ModelAndView modelView = new ModelAndView();

				return gstdpm_DPM_GST_ADJ_2_Service.post_DPM_GST_ADJ_2_OPENING(dpmGstAdj2CommTemp, reslt, request, btn_submit);
				
			
		}
}