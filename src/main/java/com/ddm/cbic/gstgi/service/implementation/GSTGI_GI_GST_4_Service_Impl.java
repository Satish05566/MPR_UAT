package com.ddm.cbic.gstgi.service.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_4_Dao;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_4_ZONE_Result;
import com.ddm.cbic.gstgi.service.GSTGI_GI_GST_4_Service;

@Service
public class GSTGI_GI_GST_4_Service_Impl implements GSTGI_GI_GST_4_Service {

	@Autowired
	GSTGI_GI_GST_4_Dao gi_gst_4_dao;

	@Override
	public ModelAndView get_GI_GST_4(HttpServletRequest request) {
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
			Object month = gi_gst_4_dao.generateResult_SP_GI_GST_4_MAX_DATE(code);
			if (month == null || month == "") {
				mm_yyyy = "2022-04-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			}
		}

		SP_GI_GST_4_COMM_TEMP_Result tempResult = new SP_GI_GST_4_COMM_TEMP_Result();
		tempResult = gi_gst_4_dao.generateResult_SP_GI_GST_4_COMM_TEMP(code, mm_yyyy, crr, request);
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
		modelView.addObject("giGst4CommTemp", new SP_GI_GST_4_COMM_TEMP_Result());
		modelView.setViewName("GSTGI/Insert/GI-GST-4");
		return modelView;
	}

	@Override
	public ModelAndView gstReport_GI_GST_4(String report_type, String code, String report_name,
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

		SP_GI_GST_4_ALL_Result allResult = new SP_GI_GST_4_ALL_Result();
		SP_GI_GST_4_REGION_Result regionResult = new SP_GI_GST_4_REGION_Result();
		SP_GI_GST_4_ZONE_Result zoneResult = new SP_GI_GST_4_ZONE_Result();
		SP_GI_GST_4_COMM_Result commResult = new SP_GI_GST_4_COMM_Result();
		SP_GI_GST_4_COMM_TEMP_REPORT_Result tempResult = new SP_GI_GST_4_COMM_TEMP_REPORT_Result();

		switch (report_type) {
		case "All": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", report_name);
			allResult = gi_gst_4_dao.generateResult_SP_GI_GST_4_ALL(mm_yyyy);
			modelView.addObject("model", allResult);

			if (allResult != null) {
				modelView.addObject("Model_TOTAL_COMM", allResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", allResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", allResult.getAMND());
			} else {
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}

			break;
		}
		case "Region": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "REGION : " + report_name);
			regionResult = gi_gst_4_dao.generateResult_SP_GI_GST_4_REGION(code, mm_yyyy);
			modelView.addObject("model", regionResult);

			break;
		}

		case "Zone": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "ZONE : " + report_name);
			zoneResult = gi_gst_4_dao.generateResult_SP_GI_GST_4_ZONE(code, mm_yyyy);
			modelView.addObject("model", zoneResult);

			if (zoneResult != null) {
				modelView.addObject("Model_TOTAL_COMM", zoneResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", zoneResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", zoneResult.getAMND());
			} else {
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}

			break;
		}

		case "Comm": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			commResult = gi_gst_4_dao.generateResult_SP_GI_GST_4_COMM(code, mm_yyyy);
			modelView.addObject("model", commResult);

			if (commResult != null) {
				modelView.addObject("Model_TOTAL_COMM", commResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", commResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", commResult.getAMND());
			} else {
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}

			break;
		}

		case "Temp": {
			Object month = gi_gst_4_dao.generateResult_SP_GI_GST_4_MAX_DATE(code);
			if (month == null || month == "") {
				mm_yyyy = "2022-04-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			}
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			tempResult = gi_gst_4_dao.generateResult_SP_GI_GST_4_COMM_TEMP_REPORT(code, mm_yyyy, null, null, null);
			modelView.addObject("model", tempResult);

			if (tempResult != null) {
				modelView.addObject("Model_TOTAL_COMM", tempResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", tempResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", tempResult.getAMND());
			} else {
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}

			break;
		}

		case "Crr": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			tempResult = gi_gst_4_dao.generateResult_SP_GI_GST_4_COMM_TEMP_REPORT(code, mm_yyyy, "T", null, null);
			commResult = gi_gst_4_dao.generateResult_SP_GI_GST_4_COMM(code, mm_yyyy);
			modelView.addObject("model", tempResult);
			modelView.addObject("ViewBag_ReportA", commResult);

			if (commResult != null) {
				modelView.addObject("Model_TOTAL_COMM", commResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", commResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", commResult.getAMND());
			} else {
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}

			break;
		}

		case "Bak": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			Object Submission_Date = null;
			tempResult = gi_gst_4_dao.generateResult_SP_GI_GST_4_COMM_TEMP_REPORT(code, mm_yyyy, null, "T",
					Submission_Date);
			modelView.addObject("model", tempResult);

			if (tempResult != null) {
				modelView.addObject("Model_TOTAL_COMM", tempResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", tempResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", tempResult.getAMND());
			} else {
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}

			break;
		}

		default: {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		}
		}

		modelView.setViewName("GSTGI/Report/GI-GST-4");
		return modelView;
	}

	@Override
	public ModelAndView post_GI_GST_4(SP_GI_GST_4_COMM_TEMP_Result giGst4CommTemp, BindingResult reslt,
			HttpServletRequest request, String btn_submit) {
		ModelAndView modelView = new ModelAndView();

		Object crr = request.getParameter("CRR");
		String mm_yyyy = request.getParameter("MM_YYYY");
		String code = (String) request.getSession().getAttribute("CODE");
		String result = null;

		if (btn_submit.equals("Update") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "");
			result = gi_gst_4_dao.generateResult_SP_GI_GST_4_UPDATE(code, mm_yyyy, 
					giGst4CommTemp.getAE_1_NO(),
					giGst4CommTemp.getAE_2_NO(),
					giGst4CommTemp.getINSPECTION_PERMISES_NO(),
					giGst4CommTemp.getSEARCHES_NO(),
					giGst4CommTemp.getINSPECTION_GOODS_NO(),
					giGst4CommTemp.getSUMMONS_NO(),
					giGst4CommTemp.getSEIZUR67_GOODS_NO(),
					giGst4CommTemp.getSEIZUR67_GOODS_VALUE(),
					giGst4CommTemp.getSEIZUR67_GOODS_TAX(),
					giGst4CommTemp.getSEIZUR67_VEHICLES_NO(),
					giGst4CommTemp.getSEIZUR67_VEHICLES_VALUE(),
					giGst4CommTemp.getSEIZUR67_VEHICLES_TAX(),
					giGst4CommTemp.getSEIZUR67_CURRENCY_NO(), 
					giGst4CommTemp.getSEIZUR67_CURRENCY_VALUE(),
					giGst4CommTemp.getSEIZUR67_CURRENCY_TAX(),
					giGst4CommTemp.getSEIZUR129_GOODS_NO(),
					giGst4CommTemp.getSEIZUR129_GOODS_VALUE(),
					giGst4CommTemp.getSEIZUR129_VEHICLES_NO(),
					giGst4CommTemp.getSEIZUR129_VEHICLES_VALUE(),
					giGst4CommTemp.getATTACHMENT_GOODS_NO(),
					giGst4CommTemp.getATTACHMENT_GOODS_VALUE(), 
					giGst4CommTemp.getATTACHMENT_PROPERTY_NO(),
					giGst4CommTemp.getATTACHMENT_PROPERTY_VALUE(), 
					giGst4CommTemp.getATTACHMENT_ACCOUNT_NO(), 
					giGst4CommTemp.getINCIDENT_NO(),
					giGst4CommTemp.getINCIDENT_AMOUNT(),
					crr);
			modelView.addObject("ViewBagMessage", result);
			modelView.addObject("ViewBag_button", "Update");
		} else if (btn_submit.equals("Upload") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "");
			result = gi_gst_4_dao.generateResult_SP_GI_GST_4_INSERT(code, mm_yyyy, giGst4CommTemp.getAE_1_NO(),
					giGst4CommTemp.getAE_2_NO(),
					giGst4CommTemp.getINSPECTION_PERMISES_NO(),
					giGst4CommTemp.getSEARCHES_NO(),
					giGst4CommTemp.getINSPECTION_GOODS_NO(),
					giGst4CommTemp.getSUMMONS_NO(),
					giGst4CommTemp.getSEIZUR67_GOODS_NO(),
					giGst4CommTemp.getSEIZUR67_GOODS_VALUE(),
					giGst4CommTemp.getSEIZUR67_GOODS_TAX(),
					giGst4CommTemp.getSEIZUR67_VEHICLES_NO(),
					giGst4CommTemp.getSEIZUR67_VEHICLES_VALUE(),
					giGst4CommTemp.getSEIZUR67_VEHICLES_TAX(),
					giGst4CommTemp.getSEIZUR67_CURRENCY_NO(), 
					giGst4CommTemp.getSEIZUR67_CURRENCY_VALUE(),
					giGst4CommTemp.getSEIZUR67_CURRENCY_TAX(),
					giGst4CommTemp.getSEIZUR129_GOODS_NO(),
					giGst4CommTemp.getSEIZUR129_GOODS_VALUE(),
					giGst4CommTemp.getSEIZUR129_VEHICLES_NO(),
					giGst4CommTemp.getSEIZUR129_VEHICLES_VALUE(),
					giGst4CommTemp.getATTACHMENT_GOODS_NO(),
					giGst4CommTemp.getATTACHMENT_GOODS_VALUE(), 
					giGst4CommTemp.getATTACHMENT_PROPERTY_NO(),
					giGst4CommTemp.getATTACHMENT_PROPERTY_VALUE(), 
					giGst4CommTemp.getATTACHMENT_ACCOUNT_NO(), 
					giGst4CommTemp.getINCIDENT_NO(),
					giGst4CommTemp.getINCIDENT_AMOUNT());
			modelView.addObject("ViewBagMessage", result);
			if (result.equals("RECORD SUBMITTED")) {
				modelView.addObject("ViewBag_button", "Update");
			} else {
				modelView.addObject("ViewBag_button", "Upload");
			}

		} else if (btn_submit.equals("Submit") && (!reslt.hasErrors())) {
			modelView.addObject("CRR", "T");
			result = gi_gst_4_dao.generateResult_SP_GI_GST_4_UPDATE(code, mm_yyyy, giGst4CommTemp.getAE_1_NO(),
					giGst4CommTemp.getAE_2_NO(),
					giGst4CommTemp.getINSPECTION_PERMISES_NO(),
					giGst4CommTemp.getSEARCHES_NO(),
					giGst4CommTemp.getINSPECTION_GOODS_NO(),
					giGst4CommTemp.getSUMMONS_NO(),
					giGst4CommTemp.getSEIZUR67_GOODS_NO(),
					giGst4CommTemp.getSEIZUR67_GOODS_VALUE(),
					giGst4CommTemp.getSEIZUR67_GOODS_TAX(),
					giGst4CommTemp.getSEIZUR67_VEHICLES_NO(),
					giGst4CommTemp.getSEIZUR67_VEHICLES_VALUE(),
					giGst4CommTemp.getSEIZUR67_VEHICLES_TAX(),
					giGst4CommTemp.getSEIZUR67_CURRENCY_NO(), 
					giGst4CommTemp.getSEIZUR67_CURRENCY_VALUE(),
					giGst4CommTemp.getSEIZUR67_CURRENCY_TAX(),
					giGst4CommTemp.getSEIZUR129_GOODS_NO(),
					giGst4CommTemp.getSEIZUR129_GOODS_VALUE(),
					giGst4CommTemp.getSEIZUR129_VEHICLES_NO(),
					giGst4CommTemp.getSEIZUR129_VEHICLES_VALUE(),
					giGst4CommTemp.getATTACHMENT_GOODS_NO(),
					giGst4CommTemp.getATTACHMENT_GOODS_VALUE(), 
					giGst4CommTemp.getATTACHMENT_PROPERTY_NO(),
					giGst4CommTemp.getATTACHMENT_PROPERTY_VALUE(), 
					giGst4CommTemp.getATTACHMENT_ACCOUNT_NO(), 
					giGst4CommTemp.getINCIDENT_NO(),
					giGst4CommTemp.getINCIDENT_AMOUNT(), crr);
			if (result.equals("CORRECTION REQUEST SUBMITTED")) {
				modelView.addObject("ViewBagMessage", result);
			} else if (result.equals("INCOMPLETE CORRECTION REQUEST")) {
				LocalDate date = LocalDate.parse(String.valueOf(mm_yyyy)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			} else {
				modelView.addObject("ViewBagMessage", result);
			}
		}

		if (reslt.hasErrors()) {
			modelView.addObject("ViewBag_button", btn_submit);
		}
		SP_GI_GST_4_COMM_TEMP_Result tempResult = new SP_GI_GST_4_COMM_TEMP_Result();
		tempResult = gi_gst_4_dao.generateResult_SP_GI_GST_4_COMM_TEMP(code, mm_yyyy, crr, request);
		result = (String) request.getAttribute("result");

		if (reslt.hasErrors()) {
			modelView.addObject("button", "Error");
		}
		modelView.addObject("MM_YYYY", mm_yyyy);
		modelView.addObject("model", tempResult);
		modelView.addObject("GiGst4CommTemp", new SP_GI_GST_4_COMM_TEMP_Result());
		modelView.setViewName("GSTGI/Insert/GI-GST-4");
		return modelView;
	}
}
