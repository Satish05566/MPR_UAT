package com.ddm.cbic.gstdpm.service.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_ADJ_1_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_1_ZONE_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_ADJ_1_Service;

@Service
public class GSTDPM_DPM_GST_ADJ_1_ServiceImpl implements GSTDPM_DPM_GST_ADJ_1_Service {

	@Autowired
	GSTDPM_DPM_GST_ADJ_1_Dao gstdpm_DPM_GST_ADJ_1_Dao;

	@Override
	public ModelAndView gstReport_DPM_GST_ADJ_1(String report_type, String code, 
			String report_name,
			HttpServletRequest request, String mm_yyyy,String request_CSRF_Token) {
		
		ModelAndView modelView = new ModelAndView();
		if(!report_type.equals("Temp"))
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM");
    		Date mmyyyy = null;
				try {
					mmyyyy = formatter.parse(mm_yyyy);
				    }
				 catch (ParseException e) {
					e.printStackTrace();
				}
				mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
		}
		
        modelView.addObject("ReportType",report_type);
        SP_DPM_GST_ADJ_1_ALL_Result allResult = new SP_DPM_GST_ADJ_1_ALL_Result();
        SP_DPM_GST_ADJ_1_REGION_Result regionResult = new SP_DPM_GST_ADJ_1_REGION_Result();
        SP_DPM_GST_ADJ_1_ZONE_Result zoneResult = new SP_DPM_GST_ADJ_1_ZONE_Result();
        SP_DPM_GST_ADJ_1_COMM_Result commResult = new SP_DPM_GST_ADJ_1_COMM_Result();
        SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT_Result tempResult = new SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT_Result();
	
	
         switch (report_type)
         {
             case "All":
                 {
                     modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
                     modelView.addObject("ViewBag_Report_Name", report_name);
                     allResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_ALL(mm_yyyy);
                     modelView.addObject("Model",allResult);
                     break;
                 }
             case "Region":
                 {
                     modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
                     modelView.addObject("ViewBag_Report_Name", "REGION : " + report_name);
                     //regionResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_REGION(mm_yyyy, code);
                     modelView.addObject("Model",regionResult);   
                     break;
                 }


             case "Zone":
                 {
                     modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
                     modelView.addObject("ViewBag_Report_Name", "ZONE : " + report_name);
                     zoneResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_ZONE(mm_yyyy,code);
                     modelView.addObject("Model",zoneResult); 
                     break;
                 }


             case "Comm":
                 {
                     modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
                     modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
                     commResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_COMM(mm_yyyy, code);
                     modelView.addObject("Model",commResult); 
                     break;
                 }


             case "Temp":
                 {
                      Object month = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_MAX_DATE(code);
                     if (month == null || month == "")
                     {
                    	 mm_yyyy = "2017-07-01";
                     }
                     else
                     {
                    	 LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1); 
                    	 mm_yyyy = String.valueOf(date);
                     }
                     Object crr = null;
                     modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
                     modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
                     tempResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResultBeanList_SP_DPM_GST_ADJ_1_COMM_TEMP_REPORT(mm_yyyy, code, crr, null);
                     modelView.addObject("Model",tempResult);
                     break;
                 }


             case "Crr":
                 {
                	 Object crr = "T";
                     modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
                     modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
                     //tempResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResultBeanList_SP_DPM_GST_ADJ_1_COMM_TEMP(mm_yyyy, code, crr, null);
                     commResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_COMM(mm_yyyy, code);
                     modelView.addObject("Model",tempResult);
                     modelView.addObject("ViewBag_Report",commResult);
                     break;
                 }

             case "Bak":
                 {
                     modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
                     modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
                     Object Submission_Date = null;
                     Object crr="T";
					 //tempResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResultBeanList_SP_DPM_GST_ADJ_1_COMM_TEMP(mm_yyyy, code, crr, request);
                     modelView.addObject("Model",tempResult);
                     break;
                 }

             default:
                 {
                     modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
                     modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
                 }
         }

            modelView.setViewName("GSTDPM/Report/DPM-GST-ADJ-1");
	        return modelView;
		}

	// ---------------------------------------------------------INSERT----------------------------------------------------------
	@Override
	public ModelAndView get_DPM_GST_ADJ_1(Model model, HttpServletRequest request, String request_CSRF_Token) {
		ModelAndView modelView = new ModelAndView();
		Object crr = request.getParameter("CRR");
		String MM_YYYY = request.getParameter("MM_YYYY");
		String code = (String) request.getSession().getAttribute("CODE");
		String result;
		if (!(crr == null || crr == "") && !(MM_YYYY == null || MM_YYYY == "")) {
			modelView.addObject("CRR", "T");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM");
			Object mmyyyy = null;
			try {
				mmyyyy = formatter.parse(MM_YYYY);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			MM_YYYY = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
		} else {
			modelView.addObject("CRR", "");
			Object month = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_MAX_DATE(code);
			if (month == null) {
				MM_YYYY = "2023-03-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				MM_YYYY = String.valueOf(date);
			}
		}

		SP_DPM_GST_ADJ_1_COMM_TEMP_Result commTempResult = new SP_DPM_GST_ADJ_1_COMM_TEMP_Result();
		commTempResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResultBeanList_SP_DPM_GST_ADJ_1_COMM_TEMP(MM_YYYY, code, crr,
				request);
		result = (String) request.getAttribute("result");

		if (commTempResult != null && "TEMP".equals(result)) {
			modelView.addObject("ViewBag_button", "Update");
			if(commTempResult.getADC_COMMISSIONERATE_RECEIPT_NO() == null) {
				modelView.addObject("ViewBag_button", "Upload");
			}
		} else if (commTempResult == null && (!result.equals("MAIN") || !result.equals("CRR"))) {
			modelView.addObject("ViewBag_button", "Upload");

		} else if (commTempResult != null && result.equals("CRR")) {
			modelView.addObject("ViewBagMessage", "CORRECTION REQUEST SUBMITTED");
			modelView.addObject("ViewBagResult", "CORRECTION REQUEST SUBMITTED");
		} else if(commTempResult == null && MM_YYYY.equals("2023-03-01")) {
			modelView.addObject("MM_YYYY", MM_YYYY);
			modelView.addObject("model", commTempResult);
			modelView.addObject("DpmGstAdj1CommTemp", new SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening());
			modelView.setViewName("GSTDPM/Insert/DPM-GST-ADJ-1");
			return modelView;
		}
		if (commTempResult == null && result.equals("MAIN") && !(crr == "" || crr == null)) {
			modelView.setViewName("correction-message");
			return modelView;
		}

		modelView.addObject("MM_YYYY", MM_YYYY);
		modelView.addObject("model", commTempResult);
		modelView.addObject("DpmGstAdj1CommTemp", new SP_DPM_GST_ADJ_1_COMM_TEMP_Result());
		modelView.setViewName("GSTDPM/Insert/DPM-GST-ADJ-1");
		return modelView;
	}

	@Override
	public ModelAndView post_DPM_GST_ADJ_1(SP_DPM_GST_ADJ_1_COMM_TEMP_Result dpmGstAdj1CommTemp, BindingResult reslt,
			Model model, HttpServletRequest request, String btn_submit, String HDTokenNo) {
		ModelAndView modelView = new ModelAndView();
		if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo"))) {
			String result;
			Object crr = request.getParameter("CRR");
			String MM_YYYY = request.getParameter("MM_YYYY");
			String code = (String) request.getSession().getAttribute("CODE");
			String opening_msg = null;
			
			if(MM_YYYY.equals("2023-04-01") && dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OPENING_NO() != null) {
				opening_msg = btn_submit;
				btn_submit = "Update";
				
			}

			if (btn_submit.equals("Update") && !(crr == "" || crr == null) && (!reslt.hasErrors())) {

				result = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_TEMP_UPDATE(code, MM_YYYY,
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OPENING_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_RECEIPT_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_DISPOSAL_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OIO_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OIO_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getADC_AUDIT_OPENING_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_OPENING_AMT(), dpmGstAdj1CommTemp.getADC_AUDIT_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_RECEIPT_AMT(), dpmGstAdj1CommTemp.getADC_AUDIT_DISPOSAL_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getADC_AUDIT_OIO_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_OIO_AMT(), dpmGstAdj1CommTemp.getADC_AUDIT_AGE_LESS_3_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_TIME_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_TIME_MORE_THAN_1_NO(), 

						dpmGstAdj1CommTemp.getADC_INVESTIGATION_OPENING_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_OPENING_AMT(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_RECEIPT_AMT(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_DISPOSAL_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_DISPOSAL_AMT(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_OIO_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_OIO_AMT(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getADC_CALLBOOK_OPENING_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_OPENING_AMT(), dpmGstAdj1CommTemp.getADC_CALLBOOK_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_RECEIPT_AMT(), dpmGstAdj1CommTemp.getADC_CALLBOOK_DISPOSAL_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_OIO_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_OIO_AMT(), dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_LESS_3_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_MORE_THAN_1_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_LESS_3_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OPENING_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_RECEIPT_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_DISPOSAL_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OIO_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OIO_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_MORE_THAN_1_NO(), 

						dpmGstAdj1CommTemp.getDC_AUDIT_OPENING_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_OPENING_AMT(), dpmGstAdj1CommTemp.getDC_AUDIT_RECEIPT_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getDC_AUDIT_DISPOSAL_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_DISPOSAL_AMT(), dpmGstAdj1CommTemp.getDC_AUDIT_OIO_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_OIO_AMT(),
						dpmGstAdj1CommTemp.getDC_AUDIT_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_AGE_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getDC_AUDIT_AGE_MORE_THAN_1_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_AUDIT_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getDC_INVESTIGATION_OPENING_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_OPENING_AMT(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_RECEIPT_AMT(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_DISPOSAL_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_DISPOSAL_AMT(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_OIO_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_OIO_AMT(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_MORE_THAN_1_NO(), 

						dpmGstAdj1CommTemp.getDC_CALLBOOK_OPENING_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_OPENING_AMT(), dpmGstAdj1CommTemp.getDC_CALLBOOK_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_RECEIPT_AMT(), dpmGstAdj1CommTemp.getDC_CALLBOOK_DISPOSAL_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_OIO_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_OIO_AMT(), dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_LESS_3_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_3_TO_6_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO(), "T");

				modelView.addObject("CRR", "T");
				crr = "T";
				if (result.equals("CORRECTION REQUEST SUBMITTED")) {
					modelView.addObject("ViewBagMessage", result);
				} else {
					modelView.addObject("ViewBagMessage", result);
				}
			} else if (btn_submit.equals("Update") && (!reslt.hasErrors())) {
				modelView.addObject("CRR", "");
				result = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_TEMP_UPDATE(code, MM_YYYY,
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OPENING_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_RECEIPT_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_DISPOSAL_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OIO_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OIO_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getADC_AUDIT_OPENING_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_OPENING_AMT(), dpmGstAdj1CommTemp.getADC_AUDIT_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_RECEIPT_AMT(), dpmGstAdj1CommTemp.getADC_AUDIT_DISPOSAL_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getADC_AUDIT_OIO_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_OIO_AMT(), dpmGstAdj1CommTemp.getADC_AUDIT_AGE_LESS_3_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_TIME_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_TIME_MORE_THAN_1_NO(), 

						dpmGstAdj1CommTemp.getADC_INVESTIGATION_OPENING_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_OPENING_AMT(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_RECEIPT_AMT(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_DISPOSAL_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_DISPOSAL_AMT(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_OIO_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_OIO_AMT(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getADC_CALLBOOK_OPENING_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_OPENING_AMT(), dpmGstAdj1CommTemp.getADC_CALLBOOK_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_RECEIPT_AMT(), dpmGstAdj1CommTemp.getADC_CALLBOOK_DISPOSAL_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_OIO_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_OIO_AMT(), dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_LESS_3_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_MORE_THAN_1_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_LESS_3_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OPENING_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_RECEIPT_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_DISPOSAL_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OIO_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OIO_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_MORE_THAN_1_NO(), 

						dpmGstAdj1CommTemp.getDC_AUDIT_OPENING_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_OPENING_AMT(), dpmGstAdj1CommTemp.getDC_AUDIT_RECEIPT_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getDC_AUDIT_DISPOSAL_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_DISPOSAL_AMT(), dpmGstAdj1CommTemp.getDC_AUDIT_OIO_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_OIO_AMT(),
						dpmGstAdj1CommTemp.getDC_AUDIT_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_AGE_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getDC_AUDIT_AGE_MORE_THAN_1_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_AUDIT_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getDC_INVESTIGATION_OPENING_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_OPENING_AMT(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_RECEIPT_AMT(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_DISPOSAL_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_DISPOSAL_AMT(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_OIO_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_OIO_AMT(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_MORE_THAN_1_NO(), 

						dpmGstAdj1CommTemp.getDC_CALLBOOK_OPENING_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_OPENING_AMT(), dpmGstAdj1CommTemp.getDC_CALLBOOK_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_RECEIPT_AMT(), dpmGstAdj1CommTemp.getDC_CALLBOOK_DISPOSAL_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_OIO_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_OIO_AMT(), dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_LESS_3_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_3_TO_6_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO(), null);

				crr = "";
				if (opening_msg.equals("Upload") && result.equals("RECORD UPDATED")) {
					modelView.addObject("ViewBag_button", "Update");
					modelView.addObject("ViewBagMessage", "RECORD SUBMITTED");
				}else if (opening_msg.equals("Update") && result.equals("RECORD UPDATED")) {
					modelView.addObject("ViewBag_button", "Update");
					modelView.addObject("ViewBagMessage", result);
				} else if (!result.equals("RECORD UPDATED")) {
					modelView.addObject("ViewBag_button", opening_msg);
					modelView.addObject("ViewBagMessage", result);
				}
			}

			else if (btn_submit.equals("Upload") && (!reslt.hasErrors())) {
				modelView.addObject("CRR", "");
				result = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_INSERT(code, MM_YYYY,
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OPENING_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_RECEIPT_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_DISPOSAL_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OIO_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OIO_AMT(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getADC_AUDIT_OPENING_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_OPENING_AMT(), dpmGstAdj1CommTemp.getADC_AUDIT_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_RECEIPT_AMT(), dpmGstAdj1CommTemp.getADC_AUDIT_DISPOSAL_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getADC_AUDIT_OIO_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_OIO_AMT(), dpmGstAdj1CommTemp.getADC_AUDIT_AGE_LESS_3_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_TIME_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_AUDIT_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getADC_AUDIT_TIME_MORE_THAN_1_NO(), 

						dpmGstAdj1CommTemp.getADC_INVESTIGATION_OPENING_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_OPENING_AMT(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_RECEIPT_AMT(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_DISPOSAL_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_DISPOSAL_AMT(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_OIO_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_OIO_AMT(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getADC_CALLBOOK_OPENING_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_OPENING_AMT(), dpmGstAdj1CommTemp.getADC_CALLBOOK_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_RECEIPT_AMT(), dpmGstAdj1CommTemp.getADC_CALLBOOK_DISPOSAL_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_OIO_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_OIO_AMT(), dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_LESS_3_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_AGE_MORE_THAN_1_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_LESS_3_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_3_TO_6_NO(), dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OPENING_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_RECEIPT_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_DISPOSAL_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OIO_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OIO_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_TIME_MORE_THAN_1_NO(), 

						dpmGstAdj1CommTemp.getDC_AUDIT_OPENING_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_OPENING_AMT(), dpmGstAdj1CommTemp.getDC_AUDIT_RECEIPT_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getDC_AUDIT_DISPOSAL_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_DISPOSAL_AMT(), dpmGstAdj1CommTemp.getDC_AUDIT_OIO_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_OIO_AMT(),
						dpmGstAdj1CommTemp.getDC_AUDIT_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_AGE_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getDC_AUDIT_AGE_MORE_THAN_1_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_AUDIT_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_AUDIT_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getDC_INVESTIGATION_OPENING_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_OPENING_AMT(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_RECEIPT_AMT(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_DISPOSAL_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_DISPOSAL_AMT(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_OIO_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_OIO_AMT(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_INVESTIGATION_TIME_MORE_THAN_1_NO(), 

						dpmGstAdj1CommTemp.getDC_CALLBOOK_OPENING_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_OPENING_AMT(), dpmGstAdj1CommTemp.getDC_CALLBOOK_RECEIPT_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_RECEIPT_AMT(), dpmGstAdj1CommTemp.getDC_CALLBOOK_DISPOSAL_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_OIO_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_OIO_AMT(), dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_LESS_3_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_3_TO_6_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_3_TO_6_NO(), dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO(),

						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OPENING_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_RECEIPT_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_RECEIPT_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_DISPOSAL_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_DISPOSAL_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OIO_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OIO_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO(), dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO(), null);

				crr = "";
				modelView.addObject("ViewBagMessage", result);
				if (result.equals("RECORD SUBMITTED")) {
					modelView.addObject("ViewBag_button", "Update");
				} else if (!result.equals("RECORD SUBMITTED")) {
					modelView.addObject("ViewBag_button", "Upload");
				}
			}

			SP_DPM_GST_ADJ_1_COMM_TEMP_Result commTempResult = new SP_DPM_GST_ADJ_1_COMM_TEMP_Result();
			commTempResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResultBeanList_SP_DPM_GST_ADJ_1_COMM_TEMP(MM_YYYY, code, crr,
					request);
			if (commTempResult != null && commTempResult.getADC_COMMISSIONERATE_RECEIPT_NO()!=null)
            {
            	modelView.addObject("ViewBag_button", "Update");
            }
        	else
        	{
        		modelView.addObject("ViewBag_button", "Upload");
        	}
			modelView.addObject("MM_YYYY", MM_YYYY);
			modelView.addObject("model", commTempResult);
			modelView.addObject("dpmGstAdj1CommTemp", new SP_DPM_GST_ADJ_1_COMM_TEMP_Result());
			modelView.setViewName("GSTDPM/Insert/DPM-GST-ADJ-1");

		}

		return modelView;
	}
	
	@Override
	public ModelAndView post_DPM_GST_ADJ_1_OPENING(SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening dpmGstAdj1CommTemp, BindingResult reslt,
			Model model, HttpServletRequest request, String btn_submit, String HDTokenNo) {
		ModelAndView modelView = new ModelAndView();
		Object crr = request.getParameter("CRR");
		if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo"))) {
			String result;
			String MM_YYYY = request.getParameter("MM_YYYY");
			String code = (String) request.getSession().getAttribute("CODE");
			if (btn_submit.equals("Upload")  && (!reslt.hasErrors())) {
				modelView.addObject("CRR", "");
				result = gstdpm_DPM_GST_ADJ_1_Dao.generateResult_SP_DPM_GST_ADJ_1_INSERT_OPENING(code, MM_YYYY,
						dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OPENING_NO(), dpmGstAdj1CommTemp.getADC_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getADC_AUDIT_OPENING_NO(),dpmGstAdj1CommTemp.getADC_AUDIT_OPENING_AMT(),
						dpmGstAdj1CommTemp.getADC_INVESTIGATION_OPENING_NO(), dpmGstAdj1CommTemp.getADC_INVESTIGATION_OPENING_AMT(),
						dpmGstAdj1CommTemp.getADC_CALLBOOK_OPENING_NO(),dpmGstAdj1CommTemp.getADC_CALLBOOK_OPENING_AMT(),
						dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OPENING_NO(),dpmGstAdj1CommTemp.getDC_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getDC_AUDIT_OPENING_NO(),dpmGstAdj1CommTemp.getDC_AUDIT_OPENING_AMT(),
						dpmGstAdj1CommTemp.getDC_INVESTIGATION_OPENING_NO(),dpmGstAdj1CommTemp.getDC_INVESTIGATION_OPENING_AMT(),
						dpmGstAdj1CommTemp.getDC_CALLBOOK_OPENING_NO(),dpmGstAdj1CommTemp.getDC_CALLBOOK_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OPENING_NO(),dpmGstAdj1CommTemp.getSUPERINTENDENT_COMMISSIONERATE_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OPENING_NO(),dpmGstAdj1CommTemp.getSUPERINTENDENT_AUDIT_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OPENING_NO(),dpmGstAdj1CommTemp.getSUPERINTENDENT_INVESTIGATION_OPENING_AMT(),
						dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OPENING_NO(),dpmGstAdj1CommTemp.getSUPERINTENDENT_CALLBOOK_OPENING_AMT());
				modelView.addObject("ViewBagMessage", result);
				if (result.equals("OPENING BALANCE SUBMITTED")) {
					
					modelView.addObject("ViewBag_button", "Upload");
				} else if (!result.equals("OPENING BALANCE SUBMITTED")) {
					modelView.addObject("ViewBag_button", "Upload");
				}
			}
			else {
				modelView.addObject("ViewBagOpeningMessage", "Please Try to input valid data format in Number & Amount Fields.");
				modelView.addObject("ViewBag_button", "Upload");
			}
			crr="";
			SP_DPM_GST_ADJ_1_COMM_TEMP_Result commTempResult = new SP_DPM_GST_ADJ_1_COMM_TEMP_Result();
			commTempResult = gstdpm_DPM_GST_ADJ_1_Dao.generateResultBeanList_SP_DPM_GST_ADJ_1_COMM_TEMP(MM_YYYY, code, crr,
					request);
			if (commTempResult != null)
            {
				if(commTempResult.getADC_COMMISSIONERATE_RECEIPT_NO() == null) {
					reslt=null;
					modelView.addObject("ViewBag_button", "Upload");
				}
				else
					modelView.addObject("ViewBag_button", "Update");
            }
        	else
        	{
        		modelView.addObject("ViewBag_button", "Upload");
        	}
			modelView.addObject("MM_YYYY", MM_YYYY);
			modelView.addObject("model", commTempResult);
			modelView.addObject("DpmGstAdj1CommTemp", new SP_DPM_GST_ADJ_1_COMM_TEMP_Result());
			modelView.setViewName("GSTDPM/Insert/DPM-GST-ADJ-1");

			
		}
		return modelView;
	}

}
