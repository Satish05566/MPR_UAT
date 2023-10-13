package com.ddm.cbic.gstddm.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ddm.cbic.gstddm.model.SP_DDM_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.service.implementation.GSTDDM_DDM_GST_4_ServiceImpl;

@Controller
@RequestMapping("/GSTDDM")
public class GSTDDM_DDM_GST_4_Controller {
	private static final Logger logger = LoggerFactory.getLogger(GSTDDM_DDM_GST_4_Controller.class);

	@Autowired
	GSTDDM_DDM_GST_4_ServiceImpl gstddm_ddm_gst_4_serviceImpl;

	@RequestMapping(value = "/Report/DDM_GST_4/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView getReport_DDM_GST_4(@PathVariable("Report_Type") String Report_Type,
			@PathVariable("Code") String Code, @PathVariable("Report_Name") String Report_Name,
			@PathVariable("YYYY-MMM") String MM_YYYY, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		ModelAndView getReportmodelView = new ModelAndView();

		getReportmodelView = gstddm_ddm_gst_4_serviceImpl.getReport_DDM_GST_4(Report_Type, Code, Report_Name, MM_YYYY,
				request, request_CSRF_Token);

		return getReportmodelView;

	}

	@RequestMapping(value = "/Insert/DDM_GST_4/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView get_DDM_GST_4(Model model, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		ModelAndView getDdmGst4modelView = new ModelAndView();

		getDdmGst4modelView = gstddm_ddm_gst_4_serviceImpl.get_DDM_GST_4(model, request, request_CSRF_Token);

		return getDdmGst4modelView;

	}

	@RequestMapping(value = "/Insert/DDM_GST_4", method = RequestMethod.POST)
	public ModelAndView post_DDM_GST_4(
			@Valid @ModelAttribute("DdmGst4CommTemp") SP_DDM_GST_4_COMM_TEMP_Result DdmGst4CommTemp,
			BindingResult reslt, Model model, HttpServletRequest request, String btn_submit, String HDTokenNo) {

		ModelAndView postDdmGst4modelView = new ModelAndView();

		logger.info("reslt.hasErrors()--"+reslt.hasErrors());
		
		postDdmGst4modelView = gstddm_ddm_gst_4_serviceImpl.post_DDM_GST_4(DdmGst4CommTemp, reslt, model, request, btn_submit,
				HDTokenNo);

		return postDdmGst4modelView;
	}
}
