package com.ddm.cbic.gstddm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.service.implementation.GSTDDM_DDM_GST_3A_ServiceImpl;

@Controller
@RequestMapping("/GSTDDM")
public class GSTDDM_DDM_GST_3A_controller {
	
	private static final Logger logger = LoggerFactory.getLogger(GSTDDM_DDM_GST_3A_controller.class);

	@Autowired
	GSTDDM_DDM_GST_3A_ServiceImpl serviceGstDdmImplRev3A;

	// Start GSTDDM_CUS_7_report
	@RequestMapping(value = "/Report/DDM_GST_3A/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView getReport_DDM_GST_3A(@PathVariable("Report_Type") String Report_Type,
			@PathVariable("Code") String Code, @PathVariable("Report_Name") String Report_Name,
			@PathVariable("YYYY-MMM") String MM_YYYY, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		ModelAndView getReportmodelView = new ModelAndView();

		getReportmodelView = serviceGstDdmImplRev3A.getReport_DDM_GST_3A(Report_Type, Code, Report_Name, MM_YYYY, request,
				request_CSRF_Token);

		return getReportmodelView;

	}

	@RequestMapping(value = "/Insert/DDM_GST_3A/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView get_DDM_GST_3A(Model model, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		ModelAndView getDdm3AmodelView = new ModelAndView();

		getDdm3AmodelView = serviceGstDdmImplRev3A.get_DDM_GST_3A(model, request, request_CSRF_Token);

		return getDdm3AmodelView;

	}

	@RequestMapping(value = "/Insert/DDM_GST_3A", method = RequestMethod.POST)
	public ModelAndView post_DDM_GST_3A(
			@Valid @ModelAttribute("gstRev3ACommTemp") SP_DDM_GST_3A_COMM_TEMP_Result gstRev3ACommTemp,
			BindingResult reslt, Model model, HttpServletRequest request, String btn_submit, String HDTokenNo) {

		ModelAndView postDdm3AmodelView = new ModelAndView();
		
		logger.info("reslt.hasErrors()--"+reslt.hasErrors());
		
		

		postDdm3AmodelView = serviceGstDdmImplRev3A.post_DDM_GST_3A(gstRev3ACommTemp, reslt, model, request, btn_submit,
				HDTokenNo);
		

		return postDdm3AmodelView;
	}
}
