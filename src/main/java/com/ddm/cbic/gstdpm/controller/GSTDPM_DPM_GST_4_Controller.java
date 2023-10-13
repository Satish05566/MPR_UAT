package com.ddm.cbic.gstdpm.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_REFUND_CATEGORY;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_4_Service;

@Controller
@RequestMapping("/GSTDPM")
public class GSTDPM_DPM_GST_4_Controller {
	

	@Autowired
	 GSTDPM_DPM_GST_4_Service gstdpm_DPM_GST_4_Service; 

		 @RequestMapping(value = "/Report/DPM_GST_4/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", 
				 method = RequestMethod.GET)
	 	public ModelAndView getReport_DPM_GST_4(@PathVariable("Report_Type") String report_type, 
		@PathVariable("Code") String code,
		@PathVariable("Report_Name") String report_name,
		@PathVariable("YYYY-MMM") String mm_yyyy ,
		HttpServletRequest request ,
		@PathVariable("request_CSRF_Token") String request_CSRF_Token, 
		String Submission_Date) {	     	
			
	 		if(request_CSRF_Token != null)
	 		{
	 			
	 			return
			  gstdpm_DPM_GST_4_Service.gstReport_DPM_GST_4(report_type,code,report_name,
			  request,mm_yyyy,request_CSRF_Token);
			 
	 		}
	 		else
	 		{
	 			return null;
	 		}	 		
	  }
		 
		 @RequestMapping(value = "/Insert/DPM_GST_4/{request_CSRF_Token}", method = RequestMethod.GET)
			public ModelAndView get_DPM_GST_4(Model model, HttpServletRequest request,
					@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		        List<SP_DPM_GST_4_REFUND_CATEGORY>  refund_CategoryList = new ArrayList<SP_DPM_GST_4_REFUND_CATEGORY>();
		        refund_CategoryList =gstdpm_DPM_GST_4_Service.generateResultBeanSP_DPM_GST_4_REFUND_LIST();
		        model.addAttribute("ViewBag_refundList",refund_CategoryList);
			 
				ModelAndView getDdm7modelView = new ModelAndView();

				getDdm7modelView = gstdpm_DPM_GST_4_Service.get_DPM_GST_4(model, request, request_CSRF_Token);
				
				

				return getDdm7modelView;

			}

			@RequestMapping(value = "/Insert/DPM_GST_4", method = RequestMethod.POST)
			public ModelAndView post_DPM_GST_12(
					@Valid @ModelAttribute("DpmGst4CommTemp") SP_DPM_GST_4_COMM_TEMP_Result dpmGst4CommTemp,
					BindingResult reslt, Model model, HttpServletRequest request, String btn_submit, String HDTokenNo) {

				ModelAndView postDdm4modelView = new ModelAndView();

				postDdm4modelView = gstdpm_DPM_GST_4_Service.post_DPM_GST_4(dpmGst4CommTemp, reslt, model, request, btn_submit,
						HDTokenNo);

				return postDdm4modelView;
			}
		 
		 
}