package com.ddm.cbic.gstdpm.service.implementation;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_ADJ_3_Dao;
import com.ddm.cbic.gstdpm.dao.implementation.GSTDPM_DPM_GST_ADJ_3_DaoImpl;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_ZONE_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_ZONE_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_ADJ_3_Service;
import com.ddm.cbic.gstdpm.dao.implementation.GSTDPM_DPM_GST_ADJ_3_DaoImpl;

@Service
public class GSTDPM_DPM_GST_ADJ_3_ServiceImpl  implements GSTDPM_DPM_GST_ADJ_3_Service{

	@Autowired
	GSTDPM_DPM_GST_ADJ_3_Dao gstdpm_DPM_GST_ADJ_3_Dao;

	@Autowired
	private GSTDPM_DPM_GST_ADJ_3_DaoImpl gstDPM_DPM_GST_ADJ_3_DaoImpl;
	
	@Override
	public ModelAndView gstReport_DPM_GST_ADJ_3(String Report_Type, String code, String report_name,
			HttpServletRequest request, String mm_yyyy,String request_CSRF_Token) {

		ModelAndView modelView = new ModelAndView();
		
		if (request.getSession().getAttribute("CSRF_Token").toString().
				equalsIgnoreCase(request_CSRF_Token)) {
			String _mm_yyyy = "";

			if (!Report_Type.equalsIgnoreCase("Temp")) {
				if (Report_Type.equalsIgnoreCase("Region")) {
					SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
					try {
						Date date = formatter.parse(mm_yyyy);
						DateFormat desDtFormat = new SimpleDateFormat("MMM-yyyy");
						mm_yyyy = desDtFormat.format(date);
						DateFormat DtFormat = new SimpleDateFormat("yyyy-MM-dd");
						_mm_yyyy = DtFormat.format(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} else {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM");
					try {
						Date date = formatter.parse(mm_yyyy);
						DateFormat desDtFormat = new SimpleDateFormat("yyyy-MMM");
						mm_yyyy = desDtFormat.format(date);
						DateFormat DtFormat = new SimpleDateFormat("yyyy-MM-dd");
						_mm_yyyy = DtFormat.format(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String mm = "";
			Date mmyyyy = new Date();

			List<SP_DPM_GST_ADJ_3_ALL_Result> all_report = new ArrayList<SP_DPM_GST_ADJ_3_ALL_Result>();
			List<SP_DPM_GST_ADJ_3_ZONE_Result> zone_report = new ArrayList<SP_DPM_GST_ADJ_3_ZONE_Result>();
			List<SP_DPM_GST_ADJ_3_COMM_Result> comm_report = new ArrayList<SP_DPM_GST_ADJ_3_COMM_Result>();
			
			List<SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT_Result> temp_report = new ArrayList<SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT_Result>();
			
			System.out.println("in GST_REG1 action _mm_yyyy--" + _mm_yyyy);

			modelView.addObject("Report_Type", Report_Type);

			String _report_name = "";
			switch (Report_Type) {
			case "All": {
				_report_name = report_name;
				modelView.addObject("ViewBag_report_name",_report_name);
				modelView.addObject("ViewBag_mm_yyyy", mm_yyyy);

				Object[] objArray = new Object[1];
				objArray[0] = _mm_yyyy;

				all_report =  gstdpm_DPM_GST_ADJ_3_Dao.generateResult_SP_DPM_GST_ADJ_3_ALL(_mm_yyyy);

				if (all_report != null) {
					System.out.println("result_all " + all_report);

					modelView.addObject("Model", all_report);

					if (all_report.size() > 0) {
						modelView.addObject("Model_TOTAL_COMM", all_report.get(0).getTOTAL_COMM());
						modelView.addObject("Model_COMPLETE_COMM", all_report.get(0).getCOMPLETE_COMM());
						modelView.addObject("Model_AMND", all_report.get(0).getAMND());
						modelView.addObject("Model_size", all_report.size());

					}
				} else {

					modelView.addObject("Model_TOTAL_COMM", 0);
					modelView.addObject("Model_COMPLETE_COMM", 0);
					modelView.addObject("Model_AMND", 0);
					modelView.addObject("Model_size", 0);

				}
				modelView.addObject("Model", all_report);
				modelView.addObject("_mm_yyyy", _mm_yyyy);

				break;
			}
			case "Zone": {
				
				_report_name ="ZONE : " + report_name;
				modelView.addObject("ViewBag_report_name", _report_name);
				System.out.println("ViewBag_report_name" + report_name);
				
				System.out.println("ZONE---------------------" );
				
				modelView.addObject("ViewBag_mm_yyyy", _mm_yyyy);
				Object[] objArray = new Object[2];
				objArray[0] =_mm_yyyy;
				objArray[1] = code;

				zone_report = gstdpm_DPM_GST_ADJ_3_Dao.generateResult_SP_DPM_GST_ADJ_3_ZONE(code, _mm_yyyy);
				if (zone_report != null) {
					if (zone_report.size() > 0) {
						modelView.addObject("Model_TOTAL_COMM", zone_report.get(0).getTOTAL_COMM());
						modelView.addObject("Model_COMPLETE_COMM", zone_report.get(0).getCOMPLETE_COMM());
						modelView.addObject("Model_AMND", zone_report.get(0).getAMND());
						modelView.addObject("Model_size", zone_report.size());

					}
				} else {

					modelView.addObject("Model_TOTAL_COMM", 0);
					modelView.addObject("Model_COMPLETE_COMM", 0);
					modelView.addObject("Model_AMND", 0);
					modelView.addObject("Model_size", 0);

				}

				modelView.addObject("Model", zone_report);
				modelView.addObject("_mm_yyyy", _mm_yyyy);

				break;
			}
			case "Comm": {
				
				_report_name ="COMMISSIONERATE : " + report_name;
				System.out.println("COMMISSIONERATE---------------------" );
				modelView.addObject("ViewBag_report_name", _report_name);
				System.out.println("ViewBag_report_name" + report_name);
				modelView.addObject("ViewBag_mm_yyyy", _mm_yyyy);
				Object[] objArray = new Object[2];
				objArray[0] = code;
				objArray[1] = _mm_yyyy;

				comm_report = gstdpm_DPM_GST_ADJ_3_Dao.generateResult_SP_DPM_GST_ADJ_3_COMM(code,_mm_yyyy);
				
				if (comm_report != null) {
					if (comm_report.size() >= 0) {
						modelView.addObject("Model_TOTAL_COMM", comm_report.get(0).getTOTAL_COMM());
						modelView.addObject("Model_COMPLETE_COMM", comm_report.get(0).getCOMPLETE_COMM());
						modelView.addObject("Model_AMND", comm_report.get(0).getAMND());
						modelView.addObject("Model_size", comm_report.size());

					}
				} else {

					modelView.addObject("Model_TOTAL_COMM", 0);
					modelView.addObject("Model_COMPLETE_COMM", 0);
					modelView.addObject("Model_AMND", 0);
					modelView.addObject("Model_size", 0);

				}

				modelView.addObject("Model", comm_report);
				modelView.addObject("_mm_yyyy", _mm_yyyy);

				break;
			}
			  case "Temp": {
			  
			  Object[] objArray1 = new Object[1]; objArray1[0] = code; Object month =
					  gstdpm_DPM_GST_ADJ_3_Dao.generateResult_SP_DPM_GST_ADJ_3_MAX_DATE(code);
			  
			  if (month == null || "".equals(month)) { _mm_yyyy = "2022-04-01"; } 
			  else {
			  try {
			  _mm_yyyy = month.toString();
			  mmyyyy = sdf.parse(_mm_yyyy); Calendar cal2 = Calendar.getInstance();
			  cal2.setTime(mmyyyy); cal2.add(Calendar.MONTH, 1); 
			  mmyyyy = cal2.getTime();
			  mm = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);			  
			  _mm_yyyy = mm; 
			  } catch (Exception e) { e.printStackTrace(); } }
			  
			  _report_name = "COMMISSIONERATE : " + report_name;
			  modelView.addObject("ViewBag_report_name", _report_name);
			  modelView.addObject("ViewBag_mm_yyyy", _mm_yyyy); 
			  Object[] objArray = new Object[5]; 
			  objArray[0] =_mm_yyyy ; 
			  objArray[1] = code ;
			  objArray[2] = null; 
			  objArray[3] = null; 
			  objArray[4] = null;
			  
			  temp_report = gstdpm_DPM_GST_ADJ_3_Dao.generateResultBeanList_SP_DPM_GST_ADJ_3_COMM_TEMP_REPORT(objArray); 
			  if (temp_report != null) {
				  if (temp_report.size() > 0) {
					  modelView.addObject("Model_TOTAL_COMM", temp_report.get(0).getTOTAL_COMM());
					  modelView.addObject("Model_COMPLETE_COMM",
					  temp_report.get(0).getCOMPLETE_COMM()); modelView.addObject("Model_AMND",
					  temp_report.get(0).getAMND()); modelView.addObject("Model_size",
					  temp_report.size()); 
					  } 
				  }
			  else {
				  modelView.addObject("Model_TOTAL_COMM", 0);
				  modelView.addObject("Model_COMPLETE_COMM", 0);
				  modelView.addObject("Model_AMND", 0); modelView.addObject("Model_size", 0); 
			  }
			  
			  modelView.addObject("Model", temp_report); modelView.addObject("_mm_yyyy", _mm_yyyy);
			  
			  break;
			  }
			 case "Crr": { 
			
			 System.out.println("inside case CRR"); 
			 _report_name = "COMMISSIONRATE : " + report_name; 
			 modelView.addObject("ViewBag_report_name", _report_name);
			 modelView.addObject("ViewBag_mm_yyyy", _mm_yyyy);
			 
			 Object[] objArray1 = new Object[5]; 
			 objArray1[0] =_mm_yyyy ; 
			 objArray1[1] = code ;
			 objArray1[2] = "T"; 
			 objArray1[3] = null; 
			 objArray1[4] = null;
			 
			// temp_report =gstdpm_DPM_GST_ADJ_3_Dao.generateResultBeanList_SP_DPM_GST_ADJ_3_COMM_TEMP(objArray1);
			 
			 comm_report = gstdpm_DPM_GST_ADJ_3_Dao.generateResult_SP_DPM_GST_ADJ_3_COMM(code,_mm_yyyy);
			 
			 if (temp_report != null) {
			 modelView.addObject("Model_TOTAL_COMM",temp_report.get(0).getTOTAL_COMM());
			 modelView.addObject("Model_COMPLETE_COMM",temp_report.get(0).getCOMPLETE_COMM()); 
			 modelView.addObject("Model_AMND",temp_report.get(0).getAMND()); 
			 modelView.addObject("Model_size",temp_report.size());
			 
			 } else {
			 
		     modelView.addObject("Model_TOTAL_COMM", 0);
			 modelView.addObject("Model_COMPLETE_COMM", 0);
			 modelView.addObject("Model_AMND", 0); 
			 modelView.addObject("Model_size", 0); 
			 }
			 modelView.addObject("Model", temp_report);
			 modelView.addObject("ViewBagReport", comm_report);
			 modelView.addObject("_mm_yyyy", _mm_yyyy);
			 
			 break; }
			
			default: {

				report_name = "COMMISSIONRATE : " + report_name;
				modelView.addObject("ViewBag_report_name", report_name);
				modelView.addObject("ViewBag_mm_yyyy", _mm_yyyy);
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
				modelView.addObject("Model_size", 0);
			}		

	}
		/*
		 * }else { request.getSession().invalidate();
		 * modelView.setViewName("GSTDDM/ResourceNotFound");
		 * modelView.addObject("message", "");
		 * 
		 * }
		 */
		}
			modelView.setViewName("GSTDPM/Report/DPM-GST-ADJ-3");//DPM-GST-12
			//gstDPM  GSTDPM_GST 

			return modelView;

	}	
	//---------------------------------------------------------INSERT----------------------------------------------------------
		@Override
		public ModelAndView get_DPM_GST_ADJ_3(Model model, HttpServletRequest request, 
				String request_CSRF_Token) {
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
				Object month = gstdpm_DPM_GST_ADJ_3_Dao.generateResult_SP_DPM_GST_ADJ_3_MAX_DATE(code);
				if (month == null) {
					MM_YYYY = "2023-04-01";
				} else {
					LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
					MM_YYYY = String.valueOf(date);
				}
			}

			List<SP_DPM_GST_ADJ_3_COMM_TEMP_Result> commTempResult = new ArrayList<SP_DPM_GST_ADJ_3_COMM_TEMP_Result>();
			commTempResult = gstdpm_DPM_GST_ADJ_3_Dao.generateResultBeanList_SP_DPM_GST_ADJ_3_COMM_TEMP(MM_YYYY, code, crr,request);
			
			//First Time Opening Balance
			if(MM_YYYY.equalsIgnoreCase("2023-04-01")){
			modelView.addObject("APR_2023_OPENING", "false");
			List<SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result> identifierListResult = new ArrayList<SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result>();
		    identifierListResult = gstDPM_DPM_GST_ADJ_3_DaoImpl.get_DPM_GST_ADJ_3_REGION_LIST(code,MM_YYYY);
			if (identifierListResult != null) {
				  if (identifierListResult.size() > 0) {
					modelView.addObject("APR_2023_OPENING", "true");
				  }
				}
			}
			
			
			result = (String) request.getAttribute("result");

			if (commTempResult != null && result.equals("TEMP")) {
				modelView.addObject("ViewBag_button", "Update");
				System.out.print("ViewBag_button update");
			} else if (commTempResult == null && result.equals("MAIN")) {
				modelView.setViewName("correction-message");
				return modelView;
			} else if (commTempResult == null && (!result.equals("MAIN") || !result.equals("CRR"))) {
				modelView.addObject("ViewBag_button", "Upload");

			} else if (commTempResult != null && result.equals("CRR")) {
				modelView.addObject("ViewBagMessage", "CORRECTION REQUEST SUBMITTED");
			}

			modelView.addObject("MM_YYYY", MM_YYYY);
			modelView.addObject("model", commTempResult);
			modelView.addObject("DpmGstAdj3CommTemp", new SP_DPM_GST_ADJ_3_COMM_TEMP_Result());
			modelView.setViewName("GSTDPM/Insert/DPM-GST-ADJ-3");
			return modelView;
		}
		
		@Override
		public ModelAndView post_DPM_GST_ADJ_3(SP_DPM_GST_ADJ_3_COMM_TEMP_Result dpmGstAdj3CommTemp,  
				BindingResult reslt, Model model,
				HttpServletRequest request, String btn_submit, String HDTokenNo) {
			ModelAndView modelView = new ModelAndView();
					

			if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo"))) {
				String result;
				Object crr = request.getParameter("CRR");
				String MM_YYYY = request.getParameter("MM_YYYY");
				String code = (String) request.getSession().getAttribute("CODE");

			if (btn_submit.equals("Upload") &&  MM_YYYY.equalsIgnoreCase("2023-04-01"))
			{
                    btn_submit="Update";
			}

			if (btn_submit.equals("Update") && !(crr == "" || crr == null)) {
				result = gstdpm_DPM_GST_ADJ_3_Dao.generateResult_SP_DPM_GST_ADJ_3_TEMP_UPDATE(code, MM_YYYY,
							dpmGstAdj3CommTemp.getREASON_ID(),
							dpmGstAdj3CommTemp.getREASON_FOR_KEEPING_IN_CALL_BOOK(),
							dpmGstAdj3CommTemp.getADC_OPENING_NO(),dpmGstAdj3CommTemp.getADC_OPENING_AMT(),dpmGstAdj3CommTemp.getADC_RECEIPT_NO(),dpmGstAdj3CommTemp.getADC_RECEIPT_AMT(),dpmGstAdj3CommTemp.getADC_DISPOSAL_NO(),
							dpmGstAdj3CommTemp.getADC_DISPOSAL_AMT(),dpmGstAdj3CommTemp.getADC_AGE_LESS_6_NO(),dpmGstAdj3CommTemp.getADC_AGE_6_TO_12_NO(),dpmGstAdj3CommTemp.getADC_AGE_1_TO_2_NO(),
							dpmGstAdj3CommTemp.getADC_AGE_MORE_THAN_2_NO(),dpmGstAdj3CommTemp.getDC_OPENING_NO(),dpmGstAdj3CommTemp.getDC_OPENING_AMT(),dpmGstAdj3CommTemp.getDC_RECEIPT_NO(),
							dpmGstAdj3CommTemp.getDC_RECEIPT_AMT(),dpmGstAdj3CommTemp.getDC_DISPOSAL_NO(),dpmGstAdj3CommTemp.getDC_DISPOSAL_AMT(),dpmGstAdj3CommTemp.getDC_AGE_LESS_6_NO(),
							dpmGstAdj3CommTemp.getDC_AGE_6_TO_12_NO(),dpmGstAdj3CommTemp.getDC_AGE_1_TO_2_NO(),dpmGstAdj3CommTemp.getDC_AGE_MORE_THAN_2_NO(),dpmGstAdj3CommTemp.getSUP_OPENING_NO(),
							dpmGstAdj3CommTemp.getSUP_OPENING_AMT(),dpmGstAdj3CommTemp.getSUP_RECEIPT_NO(),dpmGstAdj3CommTemp.getSUP_RECEIPT_AMT(),dpmGstAdj3CommTemp.getSUP_DISPOSAL_NO(),
							dpmGstAdj3CommTemp.getSUP_DISPOSAL_AMT(),dpmGstAdj3CommTemp.getSUP_AGE_LESS_6_NO(),dpmGstAdj3CommTemp.getSUP_AGE_6_TO_12_NO(),dpmGstAdj3CommTemp.getSUP_AGE_1_TO_2_NO(),
							dpmGstAdj3CommTemp.getSUP_AGE_MORE_THAN_2_NO(),
							"T");

					modelView.addObject("CRR", "T");
					crr = "T";
					if (result.equals("CORRECTION REQUEST SUBMITTED")) {
						modelView.addObject("ViewBagMessage", result);
					} else {
						modelView.addObject("ViewBagMessage", result);
					}
				}
				else if (btn_submit.equals("Update")) {
					modelView.addObject("CRR", "");
					result = gstdpm_DPM_GST_ADJ_3_Dao.generateResult_SP_DPM_GST_ADJ_3_TEMP_UPDATE(code, MM_YYYY,
						 	dpmGstAdj3CommTemp.getREASON_ID(),		
							dpmGstAdj3CommTemp.getREASON_FOR_KEEPING_IN_CALL_BOOK(),							
							dpmGstAdj3CommTemp.getADC_OPENING_NO(),dpmGstAdj3CommTemp.getADC_OPENING_AMT(),dpmGstAdj3CommTemp.getADC_RECEIPT_NO(),dpmGstAdj3CommTemp.getADC_RECEIPT_AMT(),dpmGstAdj3CommTemp.getADC_DISPOSAL_NO(),
							dpmGstAdj3CommTemp.getADC_DISPOSAL_AMT(),dpmGstAdj3CommTemp.getADC_AGE_LESS_6_NO(),dpmGstAdj3CommTemp.getADC_AGE_6_TO_12_NO(),dpmGstAdj3CommTemp.getADC_AGE_1_TO_2_NO(),
							dpmGstAdj3CommTemp.getADC_AGE_MORE_THAN_2_NO(),dpmGstAdj3CommTemp.getDC_OPENING_NO(),dpmGstAdj3CommTemp.getDC_OPENING_AMT(),dpmGstAdj3CommTemp.getDC_RECEIPT_NO(),
							dpmGstAdj3CommTemp.getDC_RECEIPT_AMT(),dpmGstAdj3CommTemp.getDC_DISPOSAL_NO(),dpmGstAdj3CommTemp.getDC_DISPOSAL_AMT(),dpmGstAdj3CommTemp.getDC_AGE_LESS_6_NO(),
							dpmGstAdj3CommTemp.getDC_AGE_6_TO_12_NO(),dpmGstAdj3CommTemp.getDC_AGE_1_TO_2_NO(),dpmGstAdj3CommTemp.getDC_AGE_MORE_THAN_2_NO(),dpmGstAdj3CommTemp.getSUP_OPENING_NO(),
							dpmGstAdj3CommTemp.getSUP_OPENING_AMT(),dpmGstAdj3CommTemp.getSUP_RECEIPT_NO(),dpmGstAdj3CommTemp.getSUP_RECEIPT_AMT(),dpmGstAdj3CommTemp.getSUP_DISPOSAL_NO(),
							dpmGstAdj3CommTemp.getSUP_DISPOSAL_AMT(),dpmGstAdj3CommTemp.getSUP_AGE_LESS_6_NO(),dpmGstAdj3CommTemp.getSUP_AGE_6_TO_12_NO(),dpmGstAdj3CommTemp.getSUP_AGE_1_TO_2_NO(),
							dpmGstAdj3CommTemp.getSUP_AGE_MORE_THAN_2_NO(),
							null);

					crr = "";
					modelView.addObject("ViewBagMessage", result);
					modelView.addObject("ViewBag_button", "Update");

				}

				else if (btn_submit.equals("Upload")) {

					modelView.addObject("CRR", "");
					result = gstdpm_DPM_GST_ADJ_3_Dao.generateResult_SP_DPM_GST_ADJ_3_TEMP_UPLOAD(code, MM_YYYY,
						 	dpmGstAdj3CommTemp.getREASON_ID(),		
							dpmGstAdj3CommTemp.getREASON_FOR_KEEPING_IN_CALL_BOOK(),							
							dpmGstAdj3CommTemp.getADC_OPENING_NO(),dpmGstAdj3CommTemp.getADC_OPENING_AMT(),dpmGstAdj3CommTemp.getADC_RECEIPT_NO(),dpmGstAdj3CommTemp.getADC_RECEIPT_AMT(),dpmGstAdj3CommTemp.getADC_DISPOSAL_NO(),
							dpmGstAdj3CommTemp.getADC_DISPOSAL_AMT(),dpmGstAdj3CommTemp.getADC_AGE_LESS_6_NO(),dpmGstAdj3CommTemp.getADC_AGE_6_TO_12_NO(),dpmGstAdj3CommTemp.getADC_AGE_1_TO_2_NO(),
							dpmGstAdj3CommTemp.getADC_AGE_MORE_THAN_2_NO(),dpmGstAdj3CommTemp.getDC_OPENING_NO(),dpmGstAdj3CommTemp.getDC_OPENING_AMT(),dpmGstAdj3CommTemp.getDC_RECEIPT_NO(),
							dpmGstAdj3CommTemp.getDC_RECEIPT_AMT(),dpmGstAdj3CommTemp.getDC_DISPOSAL_NO(),dpmGstAdj3CommTemp.getDC_DISPOSAL_AMT(),dpmGstAdj3CommTemp.getDC_AGE_LESS_6_NO(),
							dpmGstAdj3CommTemp.getDC_AGE_6_TO_12_NO(),dpmGstAdj3CommTemp.getDC_AGE_1_TO_2_NO(),dpmGstAdj3CommTemp.getDC_AGE_MORE_THAN_2_NO(),dpmGstAdj3CommTemp.getSUP_OPENING_NO(),
							dpmGstAdj3CommTemp.getSUP_OPENING_AMT(),dpmGstAdj3CommTemp.getSUP_RECEIPT_NO(),dpmGstAdj3CommTemp.getSUP_RECEIPT_AMT(),dpmGstAdj3CommTemp.getSUP_DISPOSAL_NO(),
							dpmGstAdj3CommTemp.getSUP_DISPOSAL_AMT(),dpmGstAdj3CommTemp.getSUP_AGE_LESS_6_NO(),dpmGstAdj3CommTemp.getSUP_AGE_6_TO_12_NO(),dpmGstAdj3CommTemp.getSUP_AGE_1_TO_2_NO(),
							dpmGstAdj3CommTemp.getSUP_AGE_MORE_THAN_2_NO());

					crr = "";
					modelView.addObject("ViewBagMessage", result);
					modelView.addObject("ViewBag_button", "Update");

					// modelView.addObject("CRR", "");
					// result="Sorry upload functionality is not permitted for this report.";
					// crr = "";
					// modelView.addObject("ViewBagMessage_error", result);
					// modelView.addObject("ViewBag_button", "Update");
					
				}

				List<SP_DPM_GST_ADJ_3_COMM_TEMP_Result> commTempResult = new ArrayList<SP_DPM_GST_ADJ_3_COMM_TEMP_Result>();
				commTempResult = gstdpm_DPM_GST_ADJ_3_Dao.generateResultBeanList_SP_DPM_GST_ADJ_3_COMM_TEMP(MM_YYYY, code, crr,request);

				
				modelView.addObject("MM_YYYY", MM_YYYY);
				modelView.addObject("model", commTempResult);
				modelView.addObject("DpmGstAdj3CommTemp", new SP_DPM_GST_ADJ_3_COMM_TEMP_Result());
				modelView.setViewName("GSTDPM/Insert/DPM-GST-ADJ-3");

			}

			return modelView;
		}

		@Override
		public ModelAndView post_DPM_GST_ADJ_3_OPENING_INSERT(BindingResult reslt,
		String Appeals_ADC_OPENING_NO,String Appeals_ADC_OPENING_AMT,
		String Appeals_DC_OPENING_NO,String Appeals_DC_OPENING_AMT,
		String Appeals_SUP_OPENING_NO,String Appeals_SUP_OPENING_AMT,
		
		String Injunction_ADC_OPENING_NO,String Injunction_ADC_OPENING_AMT,
		String Injunction_DC_OPENING_NO,String Injunction_DC_OPENING_AMT,
		String Injunction_SUP_OPENING_NO,String Injunction_SUP_OPENING_AMT,
		
		String CAG_ADC_OPENING_NO,String CAG_ADC_OPENING_AMT,
		String CAG_DC_OPENING_NO,String CAG_DC_OPENING_AMT,
		String CAG_SUP_OPENING_NO,String CAG_SUP_OPENING_AMT,
		
		String Board_ADC_OPENING_NO,String Board_ADC_OPENING_AMT,
		String Board_DC_OPENING_NO,String Board_DC_OPENING_AMT,
		String Board_SUP_OPENING_NO,String Board_SUP_OPENING_AMT,
		HttpServletRequest request, String btn_submit, String HDTokenNo,String MM_YYYY) {
		 ModelAndView modelView = new ModelAndView();
			if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo"))) {
				String result;
				String code = (String) request.getSession().getAttribute("CODE");

				if (btn_submit.equals("Upload")) {
					result = gstdpm_DPM_GST_ADJ_3_Dao.generateResult_SP_DPM_GST_ADJ_3_OPENING_INSERT(code, MM_YYYY,
						Appeals_ADC_OPENING_NO,Appeals_ADC_OPENING_AMT,
						Appeals_DC_OPENING_NO,Appeals_DC_OPENING_AMT,
						Appeals_SUP_OPENING_NO,Appeals_SUP_OPENING_AMT,
						
						Injunction_ADC_OPENING_NO,Injunction_ADC_OPENING_AMT,
						Injunction_DC_OPENING_NO,Injunction_DC_OPENING_AMT,
					    Injunction_SUP_OPENING_NO,Injunction_SUP_OPENING_AMT,
						
						CAG_ADC_OPENING_NO,CAG_ADC_OPENING_AMT,
						CAG_DC_OPENING_NO,CAG_DC_OPENING_AMT,
						CAG_SUP_OPENING_NO,CAG_SUP_OPENING_AMT,
						
						Board_ADC_OPENING_NO,Board_ADC_OPENING_AMT,
						Board_DC_OPENING_NO,Board_DC_OPENING_AMT,
						Board_SUP_OPENING_NO,Board_SUP_OPENING_AMT);
						
					if (result.equals("OPENING RECORD SUBMITTED")) {
						modelView.addObject("ViewBagMessage", result);
					} else {
						modelView.addObject("ViewBagMessage", result);
					}
				}
				else if (btn_submit.equals("Update")) {
					modelView.addObject("CRR", "");
					result="Sorry update functionality is not permitted for this report.";
					//crr = "";
					modelView.addObject("ViewBagMessage_error", result);
					modelView.addObject("ViewBag_button", "Update");
					
				}

				List<SP_DPM_GST_ADJ_3_COMM_TEMP_Result> commTempResult = new ArrayList<SP_DPM_GST_ADJ_3_COMM_TEMP_Result>();
				//commTempResult = gstdpm_DPM_GST_ADJ_3_Dao.generateResultBeanList_SP_DPM_GST_ADJ_3_COMM_TEMP(MM_YYYY, code, crr,request);

				modelView.addObject("MM_YYYY", MM_YYYY);
				modelView.addObject("model", commTempResult);
				modelView.addObject("DpmGstAdj3CommTemp", new SP_DPM_GST_ADJ_3_COMM_TEMP_Result());
				modelView.setViewName("GSTDPM/Insert/DPM-GST-ADJ-3");

			}

			return modelView;
		}
}
