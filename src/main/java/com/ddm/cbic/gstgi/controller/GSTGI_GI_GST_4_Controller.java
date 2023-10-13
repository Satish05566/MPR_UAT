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

import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.service.GSTGI_GI_GST_4_Service;

@Controller
@RequestMapping("/GSTGI")
public class GSTGI_GI_GST_4_Controller {

	@Autowired
	GSTGI_GI_GST_4_Service gstgi_gi_gst_4_service;

	@RequestMapping(value = "/Insert/GI_GST_4/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView get_GI_GST_4(Model model, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		if (request_CSRF_Token != null) {
			return gstgi_gi_gst_4_service.get_GI_GST_4(request);
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/Report/GI_GST_4/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView getReport_GI_GST_4(@PathVariable("Report_Type") String report_type,
			@PathVariable("Code") String code, @PathVariable("Report_Name") String report_name,
			@PathVariable("YYYY-MMM") String mm_yyyy, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token, String Submission_Date) {

		if (request_CSRF_Token != null) {
			return gstgi_gi_gst_4_service.gstReport_GI_GST_4(report_type, code, report_name, request, mm_yyyy);

		} else {
			return null;
		}

	}

	@RequestMapping(value = "/Insert/GI_GST_4", method = RequestMethod.POST)
	public ModelAndView post_GI_GST_4(
			@Valid @ModelAttribute("giGst4CommTemp") SP_GI_GST_4_COMM_TEMP_Result giGst4CommTemp, BindingResult reslt,
			HttpServletRequest request, String btn_submit, String HDTokenNo) {

		ModelAndView modelView = new ModelAndView();
		if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo"))) {

			return gstgi_gi_gst_4_service.post_GI_GST_4(giGst4CommTemp, reslt, request, btn_submit);

		} else {
			request.getSession().invalidate();
			modelView.setViewName("GSTDLA/ResourceNotFound");
			modelView.addObject("message", "");
			return modelView;
		}

	}

}
