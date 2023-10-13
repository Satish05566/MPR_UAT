package com.ddm.cbic.gstgi.service.implementation;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.lang.jstl.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.ddm.cbic.gstgi.model.SP_GI_GST_3_ALL_Result;

import com.ddm.cbic.gstgi.model.SP_GI_GST_3_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_3_ZONE_Result;
import com.ddm.cbic.gstgi.service.GSTGI_GI_GST_3_Service;

import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_3_Dao;

@Service
public class GSTGI_GI_GST_3_Service_Impl implements GSTGI_GI_GST_3_Service {

	@Autowired
	GSTGI_GI_GST_3_Dao GI_GST_3_dao;

	public ModelAndView get_GI_GST_3(HttpServletRequest request) {

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
			Object month = GI_GST_3_dao.generateResult_SP_GI_GST_3_MAX_DATE(code);
			if (month == null || month == "") {
				mm_yyyy = "2017-07-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			}
		}

		
		SP_GI_GST_3_COMM_TEMP_Result tempResult = new SP_GI_GST_3_COMM_TEMP_Result();
		tempResult = GI_GST_3_dao.generateResult_SP_GI_GST_3_COMM_TEMP(code, mm_yyyy, crr, request);
		result = (String) request.getAttribute("result");

		if (tempResult != null && result.equals("TEMP")) {
			modelView.addObject("ViewBag_button", "Update");
			System.out.print("ViewBag_button update");
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
		modelView.addObject("giGst3CommTemp", new SP_GI_GST_3_COMM_TEMP_Result());
		//modelView.setViewName("gstgi/Insert/DDM-GST-2");
		modelView.setViewName("GSTGI/Insert/GI-GST-3");
		return modelView;

	}

	public ModelAndView post_GI_GST_3(@ModelAttribute("giGst3CommTemp") SP_GI_GST_3_COMM_TEMP_Result gstGi3CommTemp,
			BindingResult reslt, HttpServletRequest request, String btn_submit) {

		ModelAndView modelView = new ModelAndView();

		Object crr = request.getParameter("CRR");
		String mm_yyyy = request.getParameter("MM_YYYY");
		String code = (String) request.getSession().getAttribute("CODE");
		String result;
 
		if(reslt.hasErrors()) {
			modelView.addObject("ViewBagMessage_error", "Please Try to input valid data formate in Number & Amount fields.");
			modelView.addObject("ViewBag_button", "Upload");
		}
		else if (btn_submit.equals("Update") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "");
			result = GI_GST_3_dao.generateResult_SP_GI_GST_3_UPDATE(code, mm_yyyy,
					gstGi3CommTemp.getREWARD_DEPARTMENTAL_NO(),
					gstGi3CommTemp.getREWARD_DEPARTMENTAL_AMT(),
					gstGi3CommTemp.getREWARD_INFORMER_NO(),
					gstGi3CommTemp.getREWARD_INFORMER_AMT(),
					gstGi3CommTemp.getDISBURSED_DEPARTMENTAL_NO(),
					gstGi3CommTemp.getDISBURSED_DEPARTMENTAL_AMT(),
					gstGi3CommTemp.getDISBURSED_INFORMER_NO(),
					gstGi3CommTemp.getDISBURSED_INFORMER_AMT(),
					gstGi3CommTemp.getPENDING_DEPARTMENTAL_NO(),
					gstGi3CommTemp.getPENDING_DEPARTMENTAL_AMT(),
					gstGi3CommTemp.getPENDING_INFORMER_NO(),
					gstGi3CommTemp.getPENDING_INFORMER_AMT(),
					//"0",gstRev2CommTemp.getOTHERS_VALUE()
					crr); 
			modelView.addObject("ViewBagMessage", result);
			modelView.addObject("ViewBag_button", "Update");
		} else if (btn_submit.equals("Upload") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "");
			result = GI_GST_3_dao.generateResult_SP_GI_GST_3_INSERT(code, mm_yyyy,
					gstGi3CommTemp.getREWARD_DEPARTMENTAL_NO(),
					gstGi3CommTemp.getREWARD_DEPARTMENTAL_AMT(),
					gstGi3CommTemp.getREWARD_INFORMER_NO(),
					gstGi3CommTemp.getREWARD_INFORMER_AMT(),
					gstGi3CommTemp.getDISBURSED_DEPARTMENTAL_NO(),
					gstGi3CommTemp.getDISBURSED_DEPARTMENTAL_AMT(),
					gstGi3CommTemp.getDISBURSED_INFORMER_NO(),
					gstGi3CommTemp.getDISBURSED_INFORMER_AMT(),
					gstGi3CommTemp.getPENDING_DEPARTMENTAL_NO(),
					gstGi3CommTemp.getPENDING_DEPARTMENTAL_AMT(),
					gstGi3CommTemp.getPENDING_INFORMER_NO(),
					gstGi3CommTemp.getPENDING_INFORMER_AMT()
					);
			modelView.addObject("ViewBagMessage", result);
			if (result.equals("RECORD SUBMITTED")) {
				modelView.addObject("ViewBag_button", "Update");
			} else {
				modelView.addObject("ViewBag_button", "Upload");
			}

		} else if (btn_submit.equals("Submit") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "T");
			result = GI_GST_3_dao.generateResult_SP_GI_GST_3_UPDATE(code, mm_yyyy,
					gstGi3CommTemp.getREWARD_DEPARTMENTAL_NO(),
					gstGi3CommTemp.getREWARD_DEPARTMENTAL_AMT(),
					gstGi3CommTemp.getREWARD_INFORMER_NO(),
					gstGi3CommTemp.getREWARD_INFORMER_AMT(),
					gstGi3CommTemp.getDISBURSED_DEPARTMENTAL_NO(),
					gstGi3CommTemp.getDISBURSED_DEPARTMENTAL_AMT(),
					gstGi3CommTemp.getDISBURSED_INFORMER_NO(),
					gstGi3CommTemp.getDISBURSED_INFORMER_AMT(),
					gstGi3CommTemp.getPENDING_DEPARTMENTAL_NO(),
					gstGi3CommTemp.getPENDING_DEPARTMENTAL_AMT(),
					gstGi3CommTemp.getPENDING_INFORMER_NO(),
					gstGi3CommTemp.getPENDING_INFORMER_AMT(),
					// "0",gstRev2CommTemp.getOTHERS_VALUE(), 
					crr);
			if (result.equals("CORRECTION REQUEST SUBMITTED")) {
				modelView.addObject("ViewBagMessage", result);
			} else if (result.equals("INCOMPLETE CORRECTION REQUEST")) {
				LocalDate date = LocalDate.parse(String.valueOf(mm_yyyy)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			} else {
				modelView.addObject("ViewBagMessage", result);

			}
		}

		SP_GI_GST_3_COMM_TEMP_Result tempResult = new SP_GI_GST_3_COMM_TEMP_Result();
		tempResult = GI_GST_3_dao.generateResult_SP_GI_GST_3_COMM_TEMP(code, mm_yyyy, crr, request);
		if (tempResult != null) {
				modelView.addObject("ViewBag_button", "Update");
			} 
		else
			modelView.addObject("ViewBag_button", "Upload");

				
		result = (String) request.getAttribute("result");

		modelView.addObject("MM_YYYY", mm_yyyy);
		modelView.addObject("model", tempResult);
		modelView.addObject("GiGst3CommTemp", new SP_GI_GST_3_COMM_TEMP_Result());
		modelView.setViewName("GSTGI/Insert/GI-GST-3");
		return modelView;
	}

	public ModelAndView gstReport_GI_GST_3(String report_type, String code, String report_name,
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

		SP_GI_GST_3_ALL_Result allResult = new SP_GI_GST_3_ALL_Result();
		SP_GI_GST_3_ZONE_Result zoneResult = new SP_GI_GST_3_ZONE_Result();
		SP_GI_GST_3_COMM_Result commResult = new SP_GI_GST_3_COMM_Result();
		SP_GI_GST_3_COMM_TEMP_REPORT_Result tempResult = new SP_GI_GST_3_COMM_TEMP_REPORT_Result();

		switch (report_type) {
		case "All": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", report_name);
			allResult = GI_GST_3_dao.generateResult_SP_GI_GST_3_ALL(mm_yyyy);
			modelView.addObject("model", allResult);
			break;
		}
		case "Region": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "REGION : " + report_name);
			//regionResult = DDM_GST_2_dao.generateResult_SP_GI_GST_3_REGION(code, mm_yyyy);
			modelView.addObject("model", "regionResult");
			break;
		}

		case "Zone": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "ZONE : " + report_name);
			zoneResult = GI_GST_3_dao.generateResult_SP_GI_GST_3_ZONE(code, mm_yyyy);
			modelView.addObject("model", zoneResult);
			break;
		}

		case "Comm": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			commResult = GI_GST_3_dao.generateResult_SP_GI_GST_3_COMM(code, mm_yyyy);
			modelView.addObject("model", commResult);
			break;
		}

		case "Temp": {
			Object month = GI_GST_3_dao.generateResult_SP_GI_GST_3_MAX_DATE(code);
			if (month == null || month == "") {
				mm_yyyy = "2017-07-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			}
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			tempResult = GI_GST_3_dao.generateResult_SP_GI_GST_3_COMM_TEMP_REPORT(code, mm_yyyy, null, null, null);
			modelView.addObject("model", tempResult);
			break;
		}

		case "Crr": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			tempResult = GI_GST_3_dao.generateResult_SP_GI_GST_3_COMM_TEMP_REPORT(code, mm_yyyy, "T", null, null);
			commResult = GI_GST_3_dao.generateResult_SP_GI_GST_3_COMM(code, mm_yyyy);
			modelView.addObject("model", tempResult);
			modelView.addObject("ViewBag_Report", commResult);
			break;
		}

		case "Bak": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			Object Submission_Date = null;
			tempResult = GI_GST_3_dao.generateResult_SP_GI_GST_3_COMM_TEMP_REPORT(code, mm_yyyy, null, "T",
					Submission_Date);
			modelView.addObject("model", tempResult);
			break;
		}

		default: {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		}
		}

		// modelView.setViewName("gstgi/Report/DDM-GST-2");
		modelView.setViewName("GSTGI/Report/GI-GST-3");
		return modelView;
	}
}
