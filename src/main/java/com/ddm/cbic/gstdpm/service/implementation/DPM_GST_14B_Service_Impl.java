package com.ddm.cbic.gstdpm.service.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstddm.model.SP_DDM_GST_3A_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_14B_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_14B_Service;

@Service
public class DPM_GST_14B_Service_Impl implements GSTDPM_DPM_GST_14B_Service {

	@Autowired
	GSTDPM_DPM_GST_14B_Dao dpm_gst_14b_dao;

	public ModelAndView get_DPM_GST_14B(HttpServletRequest request) {

		Object crr = request.getParameter("CRR");
		String mm_yyyy = request.getParameter("MM_YYYY");
		String code = (String) request.getSession().getAttribute("CODE");
		ModelAndView modelView = new ModelAndView();
		String result;

		if (!(crr == null || crr == "") && !(mm_yyyy == null || mm_yyyy == "")) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM");
			Date mmyyyy = null;
			try {
				mmyyyy = formatter.parse(mm_yyyy);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
			modelView.addObject("CRR", "T");
		} else {
			modelView.addObject("CRR", "");
			Object month = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_MAX_DATE(code);
			if (month == null || month == "") {
				mm_yyyy = "2022-04-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			}
		}

		SP_DPM_GST_14B_COMM_TEMP_Result tempResult = new SP_DPM_GST_14B_COMM_TEMP_Result();
		tempResult = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_COMM_TEMP(code, mm_yyyy, crr, request);
		result = (String) request.getAttribute("result");

		if (tempResult != null && result.equals("TEMP")) {
			modelView.addObject("ViewBag_button", "Update");
		} else if (tempResult == null && result.equals("MAIN")) {
			modelView.setViewName("correction-message");
			return modelView;
		} else if (tempResult == null && (!result.equals("MAIN") || !result.equals("CRR"))) {
			modelView.addObject("ViewBag_button", "Upload");

		} else if (tempResult != null && result.equals("CRR")) {
			modelView.addObject("ViewBagMessage", "CORRECTION REQUEST SUBMITTED");
		}
		modelView.addObject("MM_YYYY", mm_yyyy);
		modelView.addObject("model", tempResult);
		modelView.addObject("dpmGst14BCommTemp", new SP_DPM_GST_14B_COMM_TEMP_Result());
		modelView.setViewName("GSTDPM/Insert/DPM-GST-14B");
		return modelView;

	}

	public ModelAndView post_DPM_GST_14B(
			@ModelAttribute("dpmGst14BCommTemp") SP_DPM_GST_14B_COMM_TEMP_Result dpmGst14BCommTemp, BindingResult reslt,
			HttpServletRequest request, String btn_submit) {

		ModelAndView modelView = new ModelAndView();

		Object crr = request.getParameter("CRR");
		String mm_yyyy = request.getParameter("MM_YYYY");
		String code = (String) request.getSession().getAttribute("CODE");
		String result;

		if (btn_submit.equals("Update") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "");
			result = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_UPDATE(code, mm_yyyy,
					dpmGst14BCommTemp.getRECEIVED_FROM_OTHER_CPC(), dpmGst14BCommTemp.getPV_REPORT_NOT_RECEIVED(),
					dpmGst14BCommTemp.getOFFICER_FAILED_TO_PROCESS_ARN(), dpmGst14BCommTemp.getOTHERS(), crr);
			
			modelView.addObject("ViewBagMessage", result);
			modelView.addObject("ViewBag_button", "Update");

		} else if (btn_submit.equals("Upload") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "");
			result = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_INSERT(code, mm_yyyy,
					dpmGst14BCommTemp.getRECEIVED_FROM_OTHER_CPC(), dpmGst14BCommTemp.getPV_REPORT_NOT_RECEIVED(),
					dpmGst14BCommTemp.getOFFICER_FAILED_TO_PROCESS_ARN(), dpmGst14BCommTemp.getOTHERS());
			modelView.addObject("ViewBagMessage", result);
			if (result.equals("RECORD SUBMITTED")) {
				modelView.addObject("ViewBag_button", "Update");
			} else {
				modelView.addObject("ViewBag_button", "Upload");
			}

		} else if (btn_submit.equals("Submit")) {
			modelView.addObject("CRR", "T");
			result = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_UPDATE(code, mm_yyyy,
					dpmGst14BCommTemp.getRECEIVED_FROM_OTHER_CPC(), dpmGst14BCommTemp.getPV_REPORT_NOT_RECEIVED(),
					dpmGst14BCommTemp.getOFFICER_FAILED_TO_PROCESS_ARN(), dpmGst14BCommTemp.getOTHERS(), crr);
			if (result.equals("CORRECTION REQUEST SUBMITTED")) {
				modelView.addObject("ViewBagMessage", result);
			} else if (result.equals("INCOMPLETE CORRECTION REQUEST")) {
				LocalDate date = LocalDate.parse(String.valueOf(mm_yyyy)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			} else {
				modelView.addObject("ViewBagMessage", result);

			}
		}

		else {
			modelView.addObject("ViewBag_button", "Update");
		}

		SP_DPM_GST_14B_COMM_TEMP_Result tempResult = new SP_DPM_GST_14B_COMM_TEMP_Result();
		tempResult = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_COMM_TEMP(code, mm_yyyy, crr, request);
		result = (String) request.getAttribute("result");

		modelView.addObject("MM_YYYY", mm_yyyy);
		modelView.addObject("model", tempResult);
		modelView.addObject("DpmGst14BCommTemp", new SP_DPM_GST_14B_COMM_TEMP_Result());
		modelView.setViewName("GSTDPM/Insert/DPM-GST-14B");

		return modelView;
	}

}