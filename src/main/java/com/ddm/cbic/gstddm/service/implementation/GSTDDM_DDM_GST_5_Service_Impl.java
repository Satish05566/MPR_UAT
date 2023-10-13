package com.ddm.cbic.gstddm.service.implementation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstddm.controller.GSTDDM_DDM_GST_5_Controller;
import com.ddm.cbic.gstddm.dao.GSTDDM_DDM_GST_5_Dao;
import com.ddm.cbic.gstddm.dao.implementation.GSTDDM_DDM_GST_5_Dao_Impl;
//import com.ddm.cbic.gstddm.dao.GstDdmCus7Dao;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_5_ALL_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_5_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_5_COMM_TEMP_REPORT_Result;
//import com.ddm.cbic.gstddm.model.SP_DDM_GST_5_COMM_Result;
//import com.ddm.cbic.gstddm.model.SP_DDM_GST_5_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_5_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_5_ZONE_Result;
import com.ddm.cbic.gstddm.service.GSTDDM_DDM_GST_5_Service;




@Service
public class GSTDDM_DDM_GST_5_Service_Impl implements GSTDDM_DDM_GST_5_Service {

	private static final Logger logger = LoggerFactory.getLogger(GSTDDM_DDM_GST_5_Controller.class);

	@Autowired
	GSTDDM_DDM_GST_5_Dao_Impl gstddm_DDM_GST_5_DaoImpl;

	@Override
	public ModelAndView getReport_DDM_GST_5(String Report_Type, String Code, String Report_Name, String MM_YYYY,
			HttpServletRequest request, String request_CSRF_Token) {
		ModelAndView modelView = new ModelAndView();

		if (request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {
			String _MM_YYYY = "";
			System.out.println("in CEI_CE_1 action MM_YYYY--" + MM_YYYY);

			if (!Report_Type.equalsIgnoreCase("Temp")) {
				if (Report_Type.equalsIgnoreCase("Region")) {
					SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
					try {
						Date date = formatter.parse(MM_YYYY);
						DateFormat desDtFormat = new SimpleDateFormat("MMM-yyyy");
						MM_YYYY = desDtFormat.format(date);
						DateFormat DtFormat = new SimpleDateFormat("yyyy-MM-dd");
						_MM_YYYY = DtFormat.format(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} else {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM");
					try {
						Date date = formatter.parse(MM_YYYY);
						DateFormat desDtFormat = new SimpleDateFormat("yyyy-MMM");
						MM_YYYY = desDtFormat.format(date);
						DateFormat DtFormat = new SimpleDateFormat("yyyy-MM-dd");
						_MM_YYYY = DtFormat.format(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}

			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String mm = "";
			Date mmyyyy = new Date();

			List<SP_DDM_GST_5_ALL_Result> all_report = new ArrayList<SP_DDM_GST_5_ALL_Result>();
			List<SP_DDM_GST_5_ZONE_Result> zone_report = new ArrayList<SP_DDM_GST_5_ZONE_Result>();
			//List<SP_DDM_GST_5_REGION_Result> region_report = new ArrayList<SP_DDM_GST_5_REGION_Result>();
			List<SP_DDM_GST_5_COMM_Result> comm_report = new ArrayList<SP_DDM_GST_5_COMM_Result>();
			List<SP_DDM_GST_5_COMM_TEMP_REPORT_Result> temp_report = new ArrayList<SP_DDM_GST_5_COMM_TEMP_REPORT_Result>();

			System.out.println("in DDM_GST_5 action _MM_YYYY--" + _MM_YYYY);

			modelView.addObject("Report_Type", Report_Type);

			String _Report_Name = "";
			switch (Report_Type) {
			case "All": {
				_Report_Name = Report_Name;
				modelView.addObject("ViewBag_Report_Name", _Report_Name);
				modelView.addObject("ViewBag_MM_YYYY", MM_YYYY);

				Object[] objArray = new Object[1];
				objArray[0] = _MM_YYYY;

				all_report = gstddm_DDM_GST_5_DaoImpl.generateResultBeanList_SP_DDM_GST_5_ALL(_MM_YYYY);

				if (all_report != null) {
					logger.info("result_all.size()" + all_report.size());
					logger.info("result_all " + all_report);

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
				modelView.addObject("_MM_YYYY", _MM_YYYY);

				break;
			}
			case "Zone": {
				logger.info("inside case Zone");
				_Report_Name = "ZONE : " + Report_Name;
				modelView.addObject("ViewBag_Report_Name", _Report_Name);
				System.out.println("ViewBag_Report_Name" + _Report_Name);
				modelView.addObject("ViewBag_MM_YYYY", MM_YYYY);
				Object[] objArray = new Object[2];
				objArray[0] = Code;
				objArray[1] = _MM_YYYY;

				zone_report = gstddm_DDM_GST_5_DaoImpl.generateResultBeanList_SP_DDM_GST_5_ZONE(Code, _MM_YYYY);
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
				modelView.addObject("_MM_YYYY", _MM_YYYY);

				break;
			}

			case "Comm": {
				System.out.println("inside case Comm");
				_Report_Name = "COMMISSIONERATE : " + Report_Name;
				modelView.addObject("ViewBag_Report_Name", _Report_Name);
				modelView.addObject("ViewBag_MM_YYYY", MM_YYYY);
				Object[] objArray = new Object[2];
				objArray[0] = Code;
				objArray[1] = _MM_YYYY;

				comm_report = gstddm_DDM_GST_5_DaoImpl.generateResultBeanList_SP_DDM_GST_5_COMM(Code, _MM_YYYY);
				if (comm_report != null) {
					if (comm_report.size() > 0) {

						logger.info("result_comm.size()" + comm_report.size());
						logger.info("result_comm" + comm_report);

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
				modelView.addObject("_MM_YYYY", _MM_YYYY);

				break;
			}
			case "Temp": {

				Object[] objArray1 = new Object[1];
				objArray1[0] = Code;
				Object month = gstddm_DDM_GST_5_DaoImpl.generateResult_SP_DDM_GST_5_MAX_DATE(Code);
				logger.info("month--" + month);
				if (month == null || "".equals(month)) {
					_MM_YYYY = "2022-04-01";
				} else {
					try {

						_MM_YYYY = month.toString();

						mmyyyy = sdf.parse(_MM_YYYY);
						Calendar cal2 = Calendar.getInstance();
						cal2.setTime(mmyyyy);
						cal2.add(Calendar.MONTH, 1);
						mmyyyy = cal2.getTime();
						mm = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
						logger.info("mm--" + mm);
						_MM_YYYY = mm;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				_Report_Name = "COMMISSIONERATE : " + Report_Name;
				modelView.addObject("ViewBag_Report_Name", _Report_Name);
				modelView.addObject("ViewBag_MM_YYYY", MM_YYYY);
				Object[] objArray = new Object[5];
				objArray[0] = Code;
				objArray[1] = null;
				objArray[2] = null;
				objArray[3] = null;
				objArray[4] = _MM_YYYY;

				temp_report = gstddm_DDM_GST_5_DaoImpl.generateResultBeanList_SP_DDM_GST_5_COMM_TEMP_REPORT(objArray);
				if (temp_report != null) {
					logger.info("Comm_temp_result_comm.size()" + temp_report.size());
					logger.info("Comm_temp_result_comm" + temp_report);

					if (temp_report.size() > 0) {
						modelView.addObject("Model_TOTAL_COMM", temp_report.get(0).getTOTAL_COMM());
						modelView.addObject("Model_COMPLETE_COMM", temp_report.get(0).getCOMPLETE_COMM());
						modelView.addObject("Model_AMND", temp_report.get(0).getAMND());
						modelView.addObject("Model_size", temp_report.size());
						modelView.addObject("Model_type", "Temp");

					}
				}

				else {

					modelView.addObject("Model_TOTAL_COMM", 0);
					modelView.addObject("Model_COMPLETE_COMM", 0);
					modelView.addObject("Model_AMND", 0);
					modelView.addObject("Model_size", 0);

				}

				modelView.addObject("Model", temp_report);
				modelView.addObject("_MM_YYYY", _MM_YYYY);

				break;
			}
			case "Crr": {
				System.out.println("inside case CRR");
				_Report_Name = "COMMISSIONERATE : " + Report_Name;
				modelView.addObject("ViewBag_Report_Name", _Report_Name);
				modelView.addObject("ViewBag_MM_YYYY", MM_YYYY);

				Object[] objArray1 = new Object[5];
				objArray1[0] = Code;
				objArray1[1] = "T";
				objArray1[2] = null;
				objArray1[3] = null;
				objArray1[4] = _MM_YYYY;

				temp_report = gstddm_DDM_GST_5_DaoImpl.generateResultBeanList_SP_DDM_GST_5_COMM_TEMP_REPORT(objArray1);

				comm_report = gstddm_DDM_GST_5_DaoImpl.generateResultBeanList_SP_DDM_GST_5_COMM(Code, _MM_YYYY);

				if (temp_report != null) {
					modelView.addObject("Model_TOTAL_COMM", temp_report.get(0).getTOTAL_COMM());
					modelView.addObject("Model_COMPLETE_COMM", temp_report.get(0).getCOMPLETE_COMM());
					modelView.addObject("Model_AMND", temp_report.get(0).getAMND());
					modelView.addObject("Model_size", temp_report.size());

				} else {
					modelView.addObject("Model_TOTAL_COMM", 0);
					modelView.addObject("Model_COMPLETE_COMM", 0);
					modelView.addObject("Model_AMND", 0);
					modelView.addObject("Model_size", 0);
				}
				modelView.addObject("Model", temp_report);
				modelView.addObject("ViewBagReport", comm_report);
				modelView.addObject("_MM_YYYY", _MM_YYYY);

				break;
			}

			default: {

				_Report_Name = "COMMISSIONERATE : " + Report_Name;
				modelView.addObject("ViewBag_Report_Name", _Report_Name);
				modelView.addObject("ViewBag_MM_YYYY", MM_YYYY);
				modelView.addObject("Model_TOTAL_COMM", 0);
				modelView.addObject("Model_COMPLETE_COMM", 0);
				modelView.addObject("Model_AMND", 0);
				modelView.addObject("Model_size", 0);
			}

			}

			modelView.setViewName("GSTDDM/Report/DDM-GST-5");

		} else {
			request.getSession().invalidate();
			modelView.setViewName("GSTDDM/ResourceNotFound");
			modelView.addObject("message", "");

		}

		return modelView;
	}

	/*******************************************************************
	 * Insert
	 *******************************************************************
	 *******************************************************************
	 *****************************/

	@Override
	public ModelAndView get_DDM_GST_5(Model model, HttpServletRequest request, String request_CSRF_Token) {
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
			logger.info("mm_yyyy--" + MM_YYYY);
		} else {
			modelView.addObject("CRR", "");
			Object month = gstddm_DDM_GST_5_DaoImpl.generateResult_SP_DDM_GST_5_MAX_DATE(code);
			if (month == null) {
				MM_YYYY = "2022-04-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				MM_YYYY = String.valueOf(date);
			}
		}

		List<SP_DDM_GST_5_COMM_TEMP_Result> commTempResult = new ArrayList<SP_DDM_GST_5_COMM_TEMP_Result>();
		commTempResult = gstddm_DDM_GST_5_DaoImpl.generateResultBeanList_SP_DDM_GST_5_COMM_TEMP(MM_YYYY, code, crr,request);
		result = (String) request.getAttribute("result");
		logger.info("commTempResult" + commTempResult);

		if (commTempResult != null && "TEMP".equals(result)) {
			logger.info("update");
			modelView.addObject("ViewBag_button", "Update");
		} else if (commTempResult == null && (!result.equals("MAIN") || !result.equals("CRR"))) {
			logger.info("upload");
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
		modelView.addObject("DdmGst5CommTemp", new SP_DDM_GST_5_COMM_TEMP_Result());
		modelView.setViewName("GSTDDM/Insert/DDM-GST-5");
		return modelView;
	}

	@Override
	public ModelAndView post_DDM_GST_5(SP_DDM_GST_5_COMM_TEMP_Result DdmGst5CommTemp, BindingResult reslt, Model model,
			HttpServletRequest request, String btn_submit, String HDTokenNo) {
		ModelAndView modelView = new ModelAndView();
		if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo"))) {
			String result;
			Object crr = request.getParameter("CRR");
			String MM_YYYY = request.getParameter("MM_YYYY");
			String code = (String) request.getSession().getAttribute("CODE");

			logger.info("crr-" + crr);
			if (btn_submit.equals("Update") && !(crr == "" || crr == null)) {

				result = gstddm_DDM_GST_5_DaoImpl.generateResult_SP_DDM_GST_5_TEMP_UPDATE(code, MM_YYYY,
						DdmGst5CommTemp.getSR_NO(), DdmGst5CommTemp.getGROUNDS_ID(),
						DdmGst5CommTemp.getOPENING_NO(),DdmGst5CommTemp.getOPENING_AMT(),
						DdmGst5CommTemp.getITC_BLOCKED_DURING_MONTH_NO(),
						DdmGst5CommTemp.getITC_BLOCKED_DURING_MONTH_AMT(), DdmGst5CommTemp.getITC_UNBLOCKED_DURING_MONTH_NO(), 
						DdmGst5CommTemp.getITC_UNBLOCKED_DURING_MONTH_AMT(),
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_3_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_3_AMT(), 
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_6_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_6_AMT(), 
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_9_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_9_AMT(), 
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_12_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_12_AMT(), 
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT(), 
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
				result = gstddm_DDM_GST_5_DaoImpl.generateResult_SP_DDM_GST_5_TEMP_UPDATE(code, MM_YYYY,
						DdmGst5CommTemp.getSR_NO(), DdmGst5CommTemp.getGROUNDS_ID(), 
						DdmGst5CommTemp.getOPENING_NO(),DdmGst5CommTemp.getOPENING_AMT(),
						DdmGst5CommTemp.getITC_BLOCKED_DURING_MONTH_NO(),
						DdmGst5CommTemp.getITC_BLOCKED_DURING_MONTH_AMT(), DdmGst5CommTemp.getITC_UNBLOCKED_DURING_MONTH_NO(), 
						DdmGst5CommTemp.getITC_UNBLOCKED_DURING_MONTH_AMT(),
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_3_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_3_AMT(), 
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_6_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_6_AMT(), 
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_9_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_9_AMT(), 
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_12_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_12_AMT(), 
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT(), 
						null);
				logger.info("result" + result);

				crr = "";
				modelView.addObject("ViewBagMessage", result);
				modelView.addObject("ViewBag_button", "Update");

			}

			else if (btn_submit.equals("Upload")) {
				modelView.addObject("CRR", "");
				result = gstddm_DDM_GST_5_DaoImpl.generateResult_SP_DDM_GST_5_INSERT(code, MM_YYYY,
						DdmGst5CommTemp.getGROUNDS_ID(), DdmGst5CommTemp.getITC_BLOCKED_DURING_MONTH_NO(),
						DdmGst5CommTemp.getITC_BLOCKED_DURING_MONTH_AMT(), DdmGst5CommTemp.getITC_UNBLOCKED_DURING_MONTH_NO(), 
						DdmGst5CommTemp.getITC_UNBLOCKED_DURING_MONTH_AMT(),
						DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO(), DdmGst5CommTemp.getITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT() 
						,null);

				logger.info("result " + result);
				crr = "";
				modelView.addObject("ViewBagMessage", result);
				if (result.equals("RECORD SUBMITTED")) {
					modelView.addObject("ViewBag_button", "Update");
				} else if (!result.equals("RECORD SUBMITTED")) {
					modelView.addObject("ViewBag_button", "Upload");
				}
			}

			List<SP_DDM_GST_5_COMM_TEMP_Result> commTempResult = new ArrayList<SP_DDM_GST_5_COMM_TEMP_Result>();
			commTempResult = gstddm_DDM_GST_5_DaoImpl.generateResultBeanList_SP_DDM_GST_5_COMM_TEMP(MM_YYYY, code, crr,request);

			modelView.addObject("MM_YYYY", MM_YYYY);
			modelView.addObject("model", commTempResult);
			modelView.addObject("DdmGst5CommTemp", new SP_DDM_GST_5_COMM_TEMP_Result());
			modelView.setViewName("GSTDDM/Insert/DDM-GST-5");

		}

		return modelView;
	}

}
