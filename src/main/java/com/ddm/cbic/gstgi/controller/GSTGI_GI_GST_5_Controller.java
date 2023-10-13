package com.ddm.cbic.gstgi.controller;

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

import com.ddm.cbic.gstgi.model.SP_GI_GST_5_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.service.implementation.GSTGI_GI_GST_5_ServiceImpl;

@Controller
@RequestMapping("/GSTGI")
public class GSTGI_GI_GST_5_Controller {

	@Autowired
	GSTGI_GI_GST_5_ServiceImpl  gstGIGIGST5ServiceImpl;

	// Start GSTGST_REV_4A_report
	@RequestMapping(value = "/Report/GI_GST_5/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView getReport_GI_GST_5(@PathVariable("Report_Type") String Report_Type,
			@PathVariable("Code") String Code, @PathVariable("Report_Name") String Report_Name,
			@PathVariable("YYYY-MMM") String MM_YYYY, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		ModelAndView getReportmodelView = new ModelAndView();

		getReportmodelView = gstGIGIGST5ServiceImpl.getReport_GI_GST_5(Report_Type, Code, Report_Name,
				MM_YYYY, request, request_CSRF_Token);

		return getReportmodelView;

	}

	@RequestMapping(value = "/Insert/GI_GST_5/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView get_GI_GST_5(Model model, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		ModelAndView getGIGstModelView = new ModelAndView();

		getGIGstModelView = gstGIGIGST5ServiceImpl.get_GI_GST_5(model, request, request_CSRF_Token);

		return getGIGstModelView;

	}

	@RequestMapping(value = "/Insert/GI_GST_5", method = RequestMethod.POST)
	public ModelAndView post_GI_GST_5(
			@Valid @ModelAttribute("gIGstCommTemp") SP_GI_GST_5_COMM_TEMP_Result gIGstCommTemp,
			BindingResult reslt, Model model, HttpServletRequest request, String btn_submit, String HDTokenNo) {

		ModelAndView getGIGstModelView = new ModelAndView();

		getGIGstModelView = gstGIGIGST5ServiceImpl.post_GI_GST_5(gIGstCommTemp, reslt, model, request,
				btn_submit, HDTokenNo);

		return getGIGstModelView;
	}
}
