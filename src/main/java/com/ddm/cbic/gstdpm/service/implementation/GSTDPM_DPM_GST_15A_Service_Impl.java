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

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_15A_Dao;
import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_15B_Dao;
import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_15C_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15A_ZONE_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15B_ZONE_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_15C_ZONE_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_15A_Service;

@Service
public class GSTDPM_DPM_GST_15A_Service_Impl implements GSTDPM_DPM_GST_15A_Service {

	@Autowired
	GSTDPM_DPM_GST_15A_Dao dpm_gst_15A_dao;
	
	@Autowired
	GSTDPM_DPM_GST_15B_Dao dpm_gst_15B_dao;
	
	@Autowired
	GSTDPM_DPM_GST_15C_Dao dpm_gst_15C_dao;

	public ModelAndView get_DPM_GST_15A(HttpServletRequest request) {

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
			Object month = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_MAX_DATE(code);
			if (month == null || month == "") {
				mm_yyyy = "2022-04-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			}
		}

		SP_DPM_GST_15A_COMM_TEMP_Result tempResult = new SP_DPM_GST_15A_COMM_TEMP_Result();
		tempResult = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_COMM_TEMP(code, mm_yyyy, crr, request);
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
		modelView.addObject("dpmGst15ACommTemp", new SP_DPM_GST_15A_COMM_TEMP_Result());
		modelView.setViewName("GSTDPM/Insert/DPM-GST-15A");
		return modelView;

	}

	public ModelAndView post_DPM_GST_15A(
			@ModelAttribute("dpmGst15ACommTemp") SP_DPM_GST_15A_COMM_TEMP_Result dpmGst15ACommTemp, BindingResult reslt,
			HttpServletRequest request, String btn_submit) {

		ModelAndView modelView = new ModelAndView();

		Object crr = request.getParameter("CRR");
		String mm_yyyy = request.getParameter("MM_YYYY");
		String code = (String) request.getSession().getAttribute("CODE");
		String result = null;

		if (btn_submit.equals("Update")) {
			modelView.addObject("CRR", "");
			result = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_UPDATE(code, mm_yyyy,
					dpmGst15ACommTemp.getSUO_MOTO_OPENING_BALANCE(),
					dpmGst15ACommTemp.getSUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION(),
					dpmGst15ACommTemp.getSUO_MOTO_GSTIN_CANCELLED(),
					dpmGst15ACommTemp.getCANCELLATION_OPENING_BALANCE(),
					dpmGst15ACommTemp.getCANCELLATION_NO_APPLICATION_RECEIVED(),
					dpmGst15ACommTemp.getCANCELLATION_GSTIN_CANCELLED(),
					dpmGst15ACommTemp.getREVOCATION_OPENING_BALANCE(), dpmGst15ACommTemp.getREVOCATION_ARN_RECEIVED(),
					dpmGst15ACommTemp.getREVOCATION_GSTIN_REVOKED(),
					dpmGst15ACommTemp.getREVOCATION_APPLICATION_REJECTED(), crr);
			modelView.addObject("ViewBagMessage", result);
			modelView.addObject("ViewBag_button", "Update");
		} else if (btn_submit.equals("Upload")) {
			modelView.addObject("CRR", "");
			result = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_INSERT(code, mm_yyyy,
					dpmGst15ACommTemp.getSUO_MOTO_OPENING_BALANCE(),
					dpmGst15ACommTemp.getSUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION(),
					dpmGst15ACommTemp.getSUO_MOTO_GSTIN_CANCELLED(),
					dpmGst15ACommTemp.getCANCELLATION_OPENING_BALANCE(),
					dpmGst15ACommTemp.getCANCELLATION_NO_APPLICATION_RECEIVED(),
					dpmGst15ACommTemp.getCANCELLATION_GSTIN_CANCELLED(),
					dpmGst15ACommTemp.getREVOCATION_OPENING_BALANCE(), dpmGst15ACommTemp.getREVOCATION_ARN_RECEIVED(),
					dpmGst15ACommTemp.getREVOCATION_GSTIN_REVOKED(),
					dpmGst15ACommTemp.getREVOCATION_APPLICATION_REJECTED());
			modelView.addObject("ViewBagMessage", result);
			if (result.equals("RECORD SUBMITTED")) {
				modelView.addObject("ViewBag_button", "Update");
			} else {
				modelView.addObject("ViewBag_button", "Upload");
			}

		} else if (btn_submit.equals("Submit")) {
			modelView.addObject("CRR", "T");
			result = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_UPDATE(code, mm_yyyy,
					dpmGst15ACommTemp.getSUO_MOTO_OPENING_BALANCE(),
					dpmGst15ACommTemp.getSUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION(),
					dpmGst15ACommTemp.getSUO_MOTO_GSTIN_CANCELLED(),
					dpmGst15ACommTemp.getCANCELLATION_OPENING_BALANCE(),
					dpmGst15ACommTemp.getCANCELLATION_NO_APPLICATION_RECEIVED(),
					dpmGst15ACommTemp.getCANCELLATION_GSTIN_CANCELLED(),
					dpmGst15ACommTemp.getREVOCATION_OPENING_BALANCE(), 
					dpmGst15ACommTemp.getREVOCATION_ARN_RECEIVED(),
					dpmGst15ACommTemp.getREVOCATION_GSTIN_REVOKED(),
					dpmGst15ACommTemp.getREVOCATION_APPLICATION_REJECTED(), crr);
			if (result.equals("CORRECTION REQUEST SUBMITTED")) {
				modelView.addObject("ViewBagMessage", result);
			} else if (result.equals("INCOMPLETE CORRECTION REQUEST")) {
				LocalDate date = LocalDate.parse(String.valueOf(mm_yyyy)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			} else {
				modelView.addObject("ViewBagMessage", result);

			}
		}

		SP_DPM_GST_15A_COMM_TEMP_Result tempResult = new SP_DPM_GST_15A_COMM_TEMP_Result();
		tempResult = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_COMM_TEMP(code, mm_yyyy, crr, request);
		result = (String) request.getAttribute("result");

		modelView.addObject("MM_YYYY", mm_yyyy);
		modelView.addObject("model", tempResult);
		modelView.addObject("dpmGst15ACommTemp", new SP_DPM_GST_15A_COMM_TEMP_Result());
		modelView.setViewName("GSTDPM/Insert/DPM-GST-15A");
		return modelView;
	}

	public ModelAndView gstReport_DPM_GST_15A(String report_type, String code, String report_name,
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

		SP_DPM_GST_15A_ALL_Result allResult = new SP_DPM_GST_15A_ALL_Result();
		SP_DPM_GST_15A_REGION_Result regionResult = new SP_DPM_GST_15A_REGION_Result();
		SP_DPM_GST_15A_ZONE_Result zoneResult = new SP_DPM_GST_15A_ZONE_Result();
		SP_DPM_GST_15A_COMM_Result commResult = new SP_DPM_GST_15A_COMM_Result();
		SP_DPM_GST_15A_COMM_TEMP_REPORT_Result tempResult = new SP_DPM_GST_15A_COMM_TEMP_REPORT_Result();
		
		SP_DPM_GST_15B_ALL_Result allResultB = new SP_DPM_GST_15B_ALL_Result();
		SP_DPM_GST_15B_REGION_Result regionResultB = new SP_DPM_GST_15B_REGION_Result();
		SP_DPM_GST_15B_ZONE_Result zoneResultB = new SP_DPM_GST_15B_ZONE_Result();
		SP_DPM_GST_15B_COMM_Result commResultB = new SP_DPM_GST_15B_COMM_Result();
		SP_DPM_GST_15B_COMM_TEMP_REPORT_Result tempResultB = new SP_DPM_GST_15B_COMM_TEMP_REPORT_Result();

		SP_DPM_GST_15C_ALL_Result allResultC = new SP_DPM_GST_15C_ALL_Result();
		SP_DPM_GST_15C_REGION_Result regionResultC = new SP_DPM_GST_15C_REGION_Result();
		SP_DPM_GST_15C_ZONE_Result zoneResultC = new SP_DPM_GST_15C_ZONE_Result();
		SP_DPM_GST_15C_COMM_Result commResultC = new SP_DPM_GST_15C_COMM_Result();
		SP_DPM_GST_15C_COMM_TEMP_REPORT_Result tempResultC = new SP_DPM_GST_15C_COMM_TEMP_REPORT_Result();

		switch (report_type) {
		case "All": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", report_name);
			allResult = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_ALL(mm_yyyy);
			modelView.addObject("model", allResult);

			if(allResult!=null) {
				modelView.addObject("Model_TOTAL_COMM", allResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", allResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", allResult.getAMND());
			}else {		
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}
		
			
			allResultB = dpm_gst_15B_dao.generateResult_SP_DPM_GST_15B_ALL(mm_yyyy);
			modelView.addObject("modelB", allResultB);
			
			allResultC = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_ALL(mm_yyyy);
			modelView.addObject("modelC", allResultC);

			break;
		}
		case "Region": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "REGION : " + report_name);
			regionResult = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_REGION(code, mm_yyyy);
			modelView.addObject("model", regionResult);
			
			regionResultB = dpm_gst_15B_dao.generateResult_SP_DPM_GST_15B_REGION(code, mm_yyyy);
			modelView.addObject("modelB", regionResultB);
			
			regionResultC = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_REGION(code, mm_yyyy);
			modelView.addObject("modelC", regionResultC);

			break;
		}

		case "Zone": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "ZONE : " + report_name);
			zoneResult = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_ZONE(code, mm_yyyy);
			modelView.addObject("model", zoneResult);
			
			if(zoneResult!=null) {
				modelView.addObject("Model_TOTAL_COMM", zoneResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", zoneResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", zoneResult.getAMND());
			}else {		
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}
		
			
			zoneResultB = dpm_gst_15B_dao.generateResult_SP_DPM_GST_15B_ZONE(code, mm_yyyy);
			modelView.addObject("modelB", zoneResultB);
			
			zoneResultC = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_ZONE(code, mm_yyyy);
			modelView.addObject("modelC", zoneResultC);

			break;
		}

		case "Comm": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			commResult = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_COMM(code, mm_yyyy);
			modelView.addObject("model", commResult);
			
			if(commResult!=null) {
				modelView.addObject("Model_TOTAL_COMM", commResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", commResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", commResult.getAMND());
			}else {		
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}
			
			commResultB = dpm_gst_15B_dao.generateResult_SP_DPM_GST_15B_COMM(code, mm_yyyy);
			modelView.addObject("modelB", commResultB);
			
			commResultC = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM(code, mm_yyyy);
			modelView.addObject("modelC", commResultC);

			break;
		}

		case "Temp": {
			Object month = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_MAX_DATE(code);
			if (month == null || month == "") {
				mm_yyyy = "2022-04-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				mm_yyyy = String.valueOf(date);
			}
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			tempResult = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_COMM_TEMP_REPORT(code, mm_yyyy, null, null,
					null);
			modelView.addObject("model", tempResult);
			
			if(tempResult!=null) {
				modelView.addObject("Model_TOTAL_COMM", tempResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", tempResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", tempResult.getAMND());
			}else {		
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}
			
			tempResultB = dpm_gst_15B_dao.generateResult_SP_DPM_GST_15B_COMM_TEMP_REPORT(code, mm_yyyy, null, null,
					null);
			modelView.addObject("modelB", tempResultB);
			
			tempResultC = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM_TEMP_REPORT(code, mm_yyyy, null, null,
					null);
			modelView.addObject("modelC", tempResultC);

			break;
		}

		case "Crr": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			tempResult = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_COMM_TEMP_REPORT(code, mm_yyyy, "T", null, null);
			commResult = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_COMM(code, mm_yyyy);
			modelView.addObject("model", tempResult);
			modelView.addObject("ViewBag_ReportA", commResult);
			
			if(commResult!=null) {
				modelView.addObject("Model_TOTAL_COMM", commResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", commResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", commResult.getAMND());
			}else {		
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}
			
			tempResultB = dpm_gst_15B_dao.generateResult_SP_DPM_GST_15B_COMM_TEMP_REPORT(code, mm_yyyy, "T", null, null);
			commResultB = dpm_gst_15B_dao.generateResult_SP_DPM_GST_15B_COMM(code, mm_yyyy);
			modelView.addObject("modelB", tempResultB);
			modelView.addObject("ViewBag_ReportB", commResultB);
			
			tempResultC = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM_TEMP_REPORT(code, mm_yyyy, "T", null, null);
			commResultC = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM(code, mm_yyyy);
			modelView.addObject("modelC", tempResultC);
			modelView.addObject("ViewBag_ReportC", commResultC);

			break;
		}

		case "Bak": {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
			Object Submission_Date = null;
			tempResult = dpm_gst_15A_dao.generateResult_SP_DPM_GST_15A_COMM_TEMP_REPORT(code, mm_yyyy, null, "T",
					Submission_Date);
			modelView.addObject("model", tempResult);
			
			if(tempResult!=null) {
				modelView.addObject("Model_TOTAL_COMM", tempResult.getTOTAL_COMM());
				modelView.addObject("Model_COMPLETE_COMM", tempResult.getCOMPLETE_COMM());
				modelView.addObject("Model_AMND", tempResult.getAMND());
			}else {		
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
			}
			
			
			tempResultB = dpm_gst_15B_dao.generateResult_SP_DPM_GST_15B_COMM_TEMP_REPORT(code, mm_yyyy, null, "T",
					Submission_Date);
			modelView.addObject("modelB", tempResultB);
			
			tempResultC = dpm_gst_15C_dao.generateResult_SP_DPM_GST_15C_COMM_TEMP_REPORT(code, mm_yyyy, null, "T",
					Submission_Date);
			modelView.addObject("modelC", tempResultC);

			break;
		}

		default: {
			modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
			modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		}
		}

		modelView.setViewName("GSTDPM/Report/DPM-GST-15A");
		return modelView;
	}

}
