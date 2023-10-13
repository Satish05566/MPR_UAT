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

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_15C_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_ZONE_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_15C_Service;

@Service
public class GSTDPM_DPM_GST_15C_Service_Impl implements GSTDPM_DPM_GST_15C_Service {

	@Autowired
	GSTDPM_DPM_GST_15C_Dao dpm_gst_15C_dao;

	public ModelAndView get_DPM_GST_15C(HttpServletRequest request) {

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
			Object month = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_MAX_DATE(code);
			if (month == null || month == "") {
				mm_yyyy = "2022-04-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			}
		}

		SP_DPM_GST_15C_COMM_TEMP_Result tempResult = new SP_DPM_GST_15C_COMM_TEMP_Result();
		tempResult = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM_TEMP(code, mm_yyyy, crr, request);
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
		modelView.addObject("dpmGst15cCommTemp", new SP_DPM_GST_15C_COMM_TEMP_Result());
		modelView.setViewName("GSTDPM/Insert/DPM-GST-15C");
		return modelView;

	}

	public ModelAndView post_DPM_GST_15C(
			@ModelAttribute("Gst15cCommTemp") SP_DPM_GST_15C_COMM_TEMP_Result Gst15cCommTemp, BindingResult reslt,
			HttpServletRequest request, String btn_submit) {

		ModelAndView modelView = new ModelAndView();

		Object crr = request.getParameter("CRR");
		String mm_yyyy = request.getParameter("MM_YYYY");
		String code = (String) request.getSession().getAttribute("CODE");
		String result = null;

		if (btn_submit.equals("Update") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "");
			result = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_UPDATE(code, mm_yyyy,
					Gst15cCommTemp.getPERSONAL_HEARING_GRANTED_NO_GSTIN(),
					Gst15cCommTemp.getNOTIME_LEFT_FOR_REJECTION_NO_GSTIN(),
					Gst15cCommTemp.getTAXES_OR_DUES_UNPAID_NO_GSTIN(),
					Gst15cCommTemp.getTECHNICAL_ISSUES_NO_GSTIN(),
					Gst15cCommTemp.getOTHERS_SPECIFY(),
					Gst15cCommTemp.getOTHERS_NO_GSTIN(), crr);
			modelView.addObject("ViewBagMessage", result);
			modelView.addObject("ViewBag_button", "Update");
		} else if (btn_submit.equals("Upload") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "");
			result = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_INSERT(code, mm_yyyy,
					Gst15cCommTemp.getPERSONAL_HEARING_GRANTED_NO_GSTIN(),
					Gst15cCommTemp.getNOTIME_LEFT_FOR_REJECTION_NO_GSTIN(),
					Gst15cCommTemp.getTAXES_OR_DUES_UNPAID_NO_GSTIN(),
					Gst15cCommTemp.getTECHNICAL_ISSUES_NO_GSTIN(),
					Gst15cCommTemp.getOTHERS_SPECIFY(),
					Gst15cCommTemp.getOTHERS_NO_GSTIN());
			modelView.addObject("ViewBagMessage", result);
			if (result.equals("RECORD SUBMITTED")) {
				modelView.addObject("ViewBag_button", "Update");
			} else {
				modelView.addObject("ViewBag_button", "Upload");
			}

		} else if (btn_submit.equals("Submit") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "T");
			result = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_UPDATE(code, mm_yyyy,
					Gst15cCommTemp.getPERSONAL_HEARING_GRANTED_NO_GSTIN(),
					Gst15cCommTemp.getNOTIME_LEFT_FOR_REJECTION_NO_GSTIN(),
					Gst15cCommTemp.getTAXES_OR_DUES_UNPAID_NO_GSTIN(),
					Gst15cCommTemp.getTECHNICAL_ISSUES_NO_GSTIN(),
					"",
					Gst15cCommTemp.getOTHERS_NO_GSTIN(), crr);
			if (result.equals("CORRECTION REQUEST SUBMITTED")) {
				modelView.addObject("ViewBagMessage", result);
			} else if (result.equals("INCOMPLETE CORRECTION REQUEST")) {
				LocalDate date = LocalDate.parse(String.valueOf(mm_yyyy)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			} else {
				modelView.addObject("ViewBagMessage", result);

			}
		}

		SP_DPM_GST_15C_COMM_TEMP_Result tempResult = new SP_DPM_GST_15C_COMM_TEMP_Result();
		tempResult = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM_TEMP(code, mm_yyyy, crr, request);
		result = (String) request.getAttribute("result");

		if(reslt.hasErrors()) {
			modelView.addObject("button", "Error");
		}
		
		if (tempResult != null) {
			modelView.addObject("ViewBag_button", "Update");
		} else {
			modelView.addObject("ViewBag_button", "Upload");
		}
		modelView.addObject("MM_YYYY", mm_yyyy);
		modelView.addObject("model", tempResult);
		modelView.addObject("DpmGst15ACommTemp", new SP_DPM_GST_15C_COMM_TEMP_Result());
		modelView.setViewName("GSTDPM/Insert/DPM-GST-15C");
		return modelView;
	}

	public ModelAndView gstReport_DPM_GST_15C(String report_type, String code, String report_name,
			HttpServletRequest request, String mm_yyyy) {

		ModelAndView modelView = new ModelAndView();
		if (!report_type.equals("Temp")) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM");
			Date mmyyyy = null;
			try {
				mmyyyy = formatter.parse(mm_yyyy);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
		}

		modelView.addObject("ReportType", report_type);

		SP_DPM_GST_15C_ALL_Result allResult = new SP_DPM_GST_15C_ALL_Result();
		SP_DPM_GST_15C_REGION_Result regionResult = new SP_DPM_GST_15C_REGION_Result();
		SP_DPM_GST_15C_ZONE_Result zoneResult = new SP_DPM_GST_15C_ZONE_Result();
		SP_DPM_GST_15C_COMM_Result commResult = new SP_DPM_GST_15C_COMM_Result();
		SP_DPM_GST_15C_COMM_TEMP_REPORT_Result tempResult = new SP_DPM_GST_15C_COMM_TEMP_REPORT_Result();

		switch (report_type) {
		case "All": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", report_name);
			allResult = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_ALL(mm_yyyy);
			modelView.addObject("model", allResult);

			break;
		}
		case "Region": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "REGION : " + report_name);
			regionResult = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_REGION(code, mm_yyyy);
			modelView.addObject("model", regionResult);

			break;
		}

		case "Zone": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "ZONE : " + report_name);
			zoneResult = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_ZONE(code, mm_yyyy);
			modelView.addObject("model", zoneResult);

			break;
		}

		case "Comm": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			commResult = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM(code, mm_yyyy);
			modelView.addObject("model", commResult);

			break;
		}

		case "Temp": {
			Object month = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_MAX_DATE(code);
			if (month == null || month == "") {
				mm_yyyy = "2022-04-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			}
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			tempResult = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM_TEMP_REPORT(code, mm_yyyy, null, null,
					null);
			modelView.addObject("model", tempResult);

			break;
		}

		case "Crr": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONRATE : " + report_name);
			tempResult = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM_TEMP_REPORT(code, mm_yyyy, "T", null, null);
			commResult = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM(code, mm_yyyy);
			modelView.addObject("model", tempResult);
			modelView.addObject("ViewBag_ReportA", commResult);

			break;
		}

		case "Bak": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONRATE : " + report_name);
			Object Submission_Date = null;
			tempResult = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM_TEMP_REPORT(code, mm_yyyy, null, "T",
					Submission_Date);
			modelView.addObject("model", tempResult);

			break;
		}

		default: {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONRATE : " + report_name);
		}
		}

		modelView.setViewName("GSTDPM/Report/DPM-GST-15C");
		return modelView;
	}

}
