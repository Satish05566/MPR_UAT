package com.ddm.cbic.gstddm.controller;

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

import com.ddm.cbic.gstddm.model.SP_DDM_GST_5_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.service.implementation.GSTDDM_DDM_GST_5_Service_Impl;


@Controller
@RequestMapping("/GSTDDM")
public class GSTDDM_DDM_GST_5_Controller {

	@Autowired
	GSTDDM_DDM_GST_5_Service_Impl serviceGstDdmImplItc1;

	// Start GSTDDM_CUS_7_report
	@RequestMapping(value = "/Report/DDM_GST_5/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView getReport_DDM_GST_5(@PathVariable("Report_Type") String Report_Type,
			@PathVariable("Code") String Code, @PathVariable("Report_Name") String Report_Name,
			@PathVariable("YYYY-MMM") String MM_YYYY, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		ModelAndView getReportmodelView = new ModelAndView();

		getReportmodelView = serviceGstDdmImplItc1.getReport_DDM_GST_5(Report_Type, Code, Report_Name, MM_YYYY, request,
				request_CSRF_Token);

		return getReportmodelView;

	}

	@RequestMapping(value = "/Insert/DDM_GST_5/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView get_DDM_GST_5(Model model, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		ModelAndView getDdm7modelView = new ModelAndView();

		getDdm7modelView = serviceGstDdmImplItc1.get_DDM_GST_5(model, request, request_CSRF_Token);

		return getDdm7modelView;

	}

	@RequestMapping(value = "/Insert/DDM_GST_5", method = RequestMethod.POST)
	public ModelAndView post_DDM_GST_5(
			@Valid @ModelAttribute("gstITC1CommTemp") SP_DDM_GST_5_COMM_TEMP_Result gstItc1CommTemp,
			BindingResult reslt, Model model, HttpServletRequest request, String btn_submit, String HDTokenNo) {

		ModelAndView postDdm7modelView = new ModelAndView();

		postDdm7modelView = serviceGstDdmImplItc1.post_DDM_GST_5(gstItc1CommTemp, reslt, model, request, btn_submit,
				HDTokenNo);

		return postDdm7modelView;
	}
}
