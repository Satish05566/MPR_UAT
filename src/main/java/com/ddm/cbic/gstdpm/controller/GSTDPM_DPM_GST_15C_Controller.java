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

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_15C_Service;

@Controller
@RequestMapping("/GSTDPM")
public class GSTDPM_DPM_GST_15C_Controller {

	@Autowired
	GSTDPM_DPM_GST_15C_Service dpm_gst_15C_service;

	@RequestMapping(value = "/Insert/DPM_GST_15C/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView get_DPM_GST_15C(Model model, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		if (request_CSRF_Token != null) {
			return dpm_gst_15C_service.get_DPM_GST_15C(request);
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/Insert/DPM_GST_15C", method = RequestMethod.POST)
	public ModelAndView post_DPM_GST_15C(
			@Valid @ModelAttribute("dpmGst15cCommTemp") SP_DPM_GST_15C_COMM_TEMP_Result dpmGst15cCommTemp,
			BindingResult reslt, HttpServletRequest request, String btn_submit, String HDTokenNo) {

		ModelAndView modelView = new ModelAndView();
		if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo"))) {

			return dpm_gst_15C_service.post_DPM_GST_15C(dpmGst15cCommTemp, reslt, request, btn_submit);

		} else {
			request.getSession().invalidate();
			modelView.setViewName("GSTDLA/ResourceNotFound");
			modelView.addObject("message", "");
			return modelView;
		}

	}

	@RequestMapping(value = "/Report/DPM_GST_15C/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView getReport_DPM_GST_15C(@PathVariable("Report_Type") String report_type,
			@PathVariable("Code") String code, @PathVariable("Report_Name") String report_name,
			@PathVariable("YYYY-MMM") String mm_yyyy, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token, String Submission_Date) {

		if (request_CSRF_Token != null) {
			return dpm_gst_15C_service.gstReport_DPM_GST_15C(report_type, code, report_name, request, mm_yyyy);
			
		} else {
			return null;
		}

	}

}
