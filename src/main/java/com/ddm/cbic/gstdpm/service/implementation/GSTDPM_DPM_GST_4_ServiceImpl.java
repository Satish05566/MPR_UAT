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

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_4_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_REFUND_CATEGORY;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_4_ZONE_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_4_Service;

@Service
public class GSTDPM_DPM_GST_4_ServiceImpl  implements GSTDPM_DPM_GST_4_Service{

	@Autowired
	GSTDPM_DPM_GST_4_Dao gstdpm_DPM_GST_4_Dao;
	
	@Override
	public ModelAndView gstReport_DPM_GST_4(String Report_Type, String code, 
			String report_name,
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

			List<SP_DPM_GST_4_ALL_Result> all_report = new ArrayList<SP_DPM_GST_4_ALL_Result>();
			List<SP_DPM_GST_4_ZONE_Result> zone_report = new ArrayList<SP_DPM_GST_4_ZONE_Result>();
			List<SP_DPM_GST_4_COMM_Result> comm_report = new ArrayList<SP_DPM_GST_4_COMM_Result>();
			
			List<SP_DPM_GST_4_COMM_TEMP_REPORT_Result> temp_report = new ArrayList<SP_DPM_GST_4_COMM_TEMP_REPORT_Result>();
			
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

				all_report =  (List<SP_DPM_GST_4_ALL_Result>) gstdpm_DPM_GST_4_Dao.generateResult_SP_DPM_GST_4_ALL(_mm_yyyy);

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
				objArray[0] = code;
				objArray[1] = _mm_yyyy;

				zone_report = gstdpm_DPM_GST_4_Dao.generateResult_SP_DPM_GST_4_ZONE(code, _mm_yyyy);
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

				comm_report = gstdpm_DPM_GST_4_Dao.generateResult_SP_DPM_GST_4_COMM(code,_mm_yyyy);
				
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
					  gstdpm_DPM_GST_4_Dao.generateResult_SP_DPM_GST_4_MAX_DATE(code);
			  
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
			  objArray[0] = code; 
			  objArray[1] = null; 
			  objArray[2] = null;
			  objArray[3] = null; 
			  objArray[4] = _mm_yyyy;
			  
			  temp_report = gstdpm_DPM_GST_4_Dao.generateResultBeanList_SP_DPM_GST_4_COMM_TEMP_REPORT(objArray); 
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
			 objArray1[0] = code; 
			 objArray1[1] = "T";
			 objArray1[2] = null; objArray1[3] = null; 
			 objArray1[4] = _mm_yyyy;
			 
			 temp_report =gstdpm_DPM_GST_4_Dao.generateResultBeanList_SP_DPM_GST_4_COMM_TEMP_REPORT(objArray1);
			 
			 comm_report = gstdpm_DPM_GST_4_Dao.generateResult_SP_DPM_GST_4_COMM(code,_mm_yyyy);
			 
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
			modelView.setViewName("GSTDPM/Report/DPM-GST-4");//DPM-GST-12
			//gstDPM  GSTDPM_GST 

			return modelView;
			
			
		}

	
	//---------------------------------------------------------INSERT----------------------------------------------------------
		@Override
		public ModelAndView get_DPM_GST_4(Model model, HttpServletRequest request, 
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
				Object month = gstdpm_DPM_GST_4_Dao.generateResult_SP_DPM_GST_4_MAX_DATE(code);
				if (month == null) {
					MM_YYYY = "2022-04-01";
				} else {
					LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
					MM_YYYY = String.valueOf(date);
				}
			}

			List<SP_DPM_GST_4_COMM_TEMP_Result> commTempResult = new ArrayList<SP_DPM_GST_4_COMM_TEMP_Result>();
			commTempResult = gstdpm_DPM_GST_4_Dao.generateResultBeanList_SP_DPM_GST_4_COMM_TEMP(MM_YYYY, code, crr,
					request);
			result = (String) request.getAttribute("result");

			if (commTempResult != null && "TEMP".equals(result)) {
				modelView.addObject("ViewBag_button", "Update");
			} else if (commTempResult == null && (!result.equals("MAIN") || !result.equals("CRR"))) {
				modelView.addObject("ViewBag_button", "Upload");

			} else if (commTempResult != null && result.equals("CRR")) {
				modelView.addObject("ViewBagMessage", "CORRECTION REQUEST SUBMITTED");
				modelView.addObject("ViewBagResult", "CORRECTION REQUEST SUBMITTED");
			}
			if (commTempResult == null && result.equals("MAIN") && !(crr == "" || crr == null)) {
				modelView.setViewName("correction-message");
				return modelView;
			}

			modelView.addObject("MM_YYYY", MM_YYYY);
			modelView.addObject("model", commTempResult);
			modelView.addObject("DpmGst4CommTemp", new SP_DPM_GST_4_COMM_TEMP_Result());
			modelView.setViewName("GSTDPM/Insert/DPM-GST-4");
			return modelView;
		}
		
		@Override
		public ModelAndView post_DPM_GST_4(SP_DPM_GST_4_COMM_TEMP_Result dpmGst4CommTemp,  
				BindingResult reslt, Model model,
				HttpServletRequest request, String btn_submit, String HDTokenNo) {
			ModelAndView modelView = new ModelAndView();
			if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo"))) {
				String result;
				Object crr = request.getParameter("CRR");
				String MM_YYYY = request.getParameter("MM_YYYY");
				String code = (String) request.getSession().getAttribute("CODE");

				if (btn_submit.equals("Update") && !(crr == "" || crr == null)) {
					result = gstdpm_DPM_GST_4_Dao.generateResult_SP_DPM_GST_4_TEMP_UPDATE(code, MM_YYYY,
							dpmGst4CommTemp.getSR_NO(), dpmGst4CommTemp.getREFUND_CATEGORY(), dpmGst4CommTemp.getOPENING_BALANCE_NO(),
							dpmGst4CommTemp.getOPENING_BALANCE_AMOUNT(), dpmGst4CommTemp.getRFD_01_NO(), dpmGst4CommTemp.getRFD_01_AMOUNT(),
							dpmGst4CommTemp.getRFD_02_NO(), dpmGst4CommTemp.getRFD_03_NO(),
							dpmGst4CommTemp.getRFD_03_AMOUNT(),dpmGst4CommTemp.getRFD_04_NO(),dpmGst4CommTemp.getRFD_04_AMOUNT(),
							dpmGst4CommTemp.getRFD_06_SANCTIONED_NO(),dpmGst4CommTemp.getRFD_06_SANCTIONED_AMOUNT(),dpmGst4CommTemp.getRFD_06_REJECTED_NO(),
							dpmGst4CommTemp.getRFD_06_REJECTED_AMOUNT(),dpmGst4CommTemp.getAGE_BREAKUP_30_45_NO(),dpmGst4CommTemp.getAGE_BREAKUP_30_45_AMOUNT(),
							dpmGst4CommTemp.getAGE_BREAKUP_46_60_NO(),dpmGst4CommTemp.getAGE_BREAKUP_46_60_AMOUNT(),
							dpmGst4CommTemp.getAGE_BREAKUP_ABOVE60_NO(),dpmGst4CommTemp.getAGE_BREAKUP_ABOVE60_AMOUNT(),
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
					result = gstdpm_DPM_GST_4_Dao.generateResult_SP_DPM_GST_4_TEMP_UPDATE(code, MM_YYYY,
							dpmGst4CommTemp.getSR_NO(), dpmGst4CommTemp.getREFUND_CATEGORY(), dpmGst4CommTemp.getOPENING_BALANCE_NO(),
							dpmGst4CommTemp.getOPENING_BALANCE_AMOUNT(), dpmGst4CommTemp.getRFD_01_NO(), dpmGst4CommTemp.getRFD_01_AMOUNT(),
							dpmGst4CommTemp.getRFD_02_NO(), dpmGst4CommTemp.getRFD_03_NO(),
							dpmGst4CommTemp.getRFD_03_AMOUNT(),dpmGst4CommTemp.getRFD_04_NO(),dpmGst4CommTemp.getRFD_04_AMOUNT(),
							dpmGst4CommTemp.getRFD_06_SANCTIONED_NO(),dpmGst4CommTemp.getRFD_06_SANCTIONED_AMOUNT(),dpmGst4CommTemp.getRFD_06_REJECTED_NO(),
							dpmGst4CommTemp.getRFD_06_REJECTED_AMOUNT(),dpmGst4CommTemp.getAGE_BREAKUP_30_45_NO(),dpmGst4CommTemp.getAGE_BREAKUP_30_45_AMOUNT(),
							dpmGst4CommTemp.getAGE_BREAKUP_46_60_NO(),dpmGst4CommTemp.getAGE_BREAKUP_46_60_AMOUNT(),
							dpmGst4CommTemp.getAGE_BREAKUP_ABOVE60_NO(),dpmGst4CommTemp.getAGE_BREAKUP_ABOVE60_AMOUNT(),
							null);

					crr = "";
					modelView.addObject("ViewBagMessage", result);
					modelView.addObject("ViewBag_button", "Update");

				}

				else if (btn_submit.equals("Upload")) {
					modelView.addObject("CRR", "");
					result = gstdpm_DPM_GST_4_Dao.generateResult_SP_DPM_GST_4_INSERT(code, MM_YYYY,
							dpmGst4CommTemp.getSR_NO(), dpmGst4CommTemp.getREFUND_CATEGORY(), dpmGst4CommTemp.getOPENING_BALANCE_NO(),
							dpmGst4CommTemp.getOPENING_BALANCE_AMOUNT(), dpmGst4CommTemp.getRFD_01_NO(), dpmGst4CommTemp.getRFD_01_AMOUNT(),
							dpmGst4CommTemp.getRFD_02_NO(), dpmGst4CommTemp.getRFD_03_NO(),
							dpmGst4CommTemp.getRFD_03_AMOUNT(),dpmGst4CommTemp.getRFD_04_NO(),dpmGst4CommTemp.getRFD_04_AMOUNT(),
							dpmGst4CommTemp.getRFD_06_SANCTIONED_NO(),dpmGst4CommTemp.getRFD_06_SANCTIONED_AMOUNT(),dpmGst4CommTemp.getRFD_06_REJECTED_NO(),
							dpmGst4CommTemp.getRFD_06_REJECTED_AMOUNT(),dpmGst4CommTemp.getAGE_BREAKUP_30_45_NO(),dpmGst4CommTemp.getAGE_BREAKUP_30_45_AMOUNT(),
							dpmGst4CommTemp.getAGE_BREAKUP_46_60_NO(),dpmGst4CommTemp.getAGE_BREAKUP_46_60_AMOUNT(),
							dpmGst4CommTemp.getAGE_BREAKUP_ABOVE60_NO(),dpmGst4CommTemp.getAGE_BREAKUP_ABOVE60_AMOUNT(),
							null);

					crr = "";
					modelView.addObject("ViewBagMessage", result);
					if (result.equals("RECORD SUBMITTED")) {
						modelView.addObject("ViewBag_button", "Update");
					} else if (!result.equals("RECORD SUBMITTED")) {
						modelView.addObject("ViewBag_button", "Upload");
					}
				}

				List<SP_DPM_GST_4_COMM_TEMP_Result> commTempResult = new ArrayList<SP_DPM_GST_4_COMM_TEMP_Result>();
				commTempResult = gstdpm_DPM_GST_4_Dao.generateResultBeanList_SP_DPM_GST_4_COMM_TEMP(MM_YYYY, code, crr,request);

				modelView.addObject("MM_YYYY", MM_YYYY);
				modelView.addObject("model", commTempResult);
				modelView.addObject("DpmGst4CommTemp", new SP_DPM_GST_4_COMM_TEMP_Result());
				modelView.setViewName("GSTDPM/Insert/DPM-GST-4");

			}

			return modelView;
		}
		public List<SP_DPM_GST_4_REFUND_CATEGORY> generateResultBeanSP_DPM_GST_4_REFUND_LIST(){
			return gstdpm_DPM_GST_4_Dao.generateResultBeanSP_DPM_GST_4_REFUND_LIST();
		}

}
