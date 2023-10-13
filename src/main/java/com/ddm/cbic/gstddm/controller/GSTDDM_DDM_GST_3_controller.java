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

import com.ddm.cbic.gstddm.model.SP_DDM_GST_3_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.service.implementation.GSTDDM_DDM_GST_3_ServiceImpl;

@Controller
@RequestMapping("/GSTDDM")
public class GSTDDM_DDM_GST_3_controller {

	@Autowired
	GSTDDM_DDM_GST_3_ServiceImpl  gstDdmGst3ServiceImpl;
	
	private static final Logger logger = LoggerFactory.getLogger(GSTDDM_DDM_GST_3_controller.class);

	// Start GSTDDM_CUS_7_report
	@RequestMapping(value = "/Report/DDM_GST_3/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}",
			method = RequestMethod.GET)
	public ModelAndView getReport_DDM_GST_3(@PathVariable("Report_Type") String Report_Type,
			@PathVariable("Code") String Code, @PathVariable("Report_Name") String Report_Name,
			@PathVariable("YYYY-MMM") String MM_YYYY, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		ModelAndView getReportmodelView = new ModelAndView();

		getReportmodelView = gstDdmGst3ServiceImpl.getReport_DDM_GST_3(Report_Type, Code, Report_Name, MM_YYYY, request,
				request_CSRF_Token);
		return getReportmodelView;
                                                          
	}

	@RequestMapping(value = "/Insert/DDM_GST_3/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView get_DDM_GST_3(Model model, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		ModelAndView getDdm7modelView = new ModelAndView();

		getDdm7modelView = gstDdmGst3ServiceImpl.get_DDM_GST_3(model, request, request_CSRF_Token);

		return getDdm7modelView;

	}

	@RequestMapping(value = "/Insert/DDM_GST_3", method = RequestMethod.POST)
	public ModelAndView post_DDM_GST_3(
			@Valid @ModelAttribute("ddmGst3CommTemp") SP_DDM_GST_3_COMM_TEMP_Result DdmGst3CommTemp,
			BindingResult reslt, Model model, HttpServletRequest request, String btn_submit, String HDTokenNo) {

		ModelAndView postDdmGSt3modelView = new ModelAndView();
	
		logger.info("reslt.hasErrors()--"+reslt.hasErrors());
		
		

		postDdmGSt3modelView = gstDdmGst3ServiceImpl.post_DDM_GST_3(DdmGst3CommTemp, reslt, model, request, btn_submit,
				HDTokenNo);

		return postDdmGSt3modelView;
	}
}
