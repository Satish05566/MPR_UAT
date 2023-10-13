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

import com.ddm.cbic.gstddm.dao.implementation.GSTDDM_DDM_GST_4A_DaoImpl;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_ALL;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_4A_ZONE_Result;
import com.ddm.cbic.gstddm.service.GSTDDM_DDM_GST_4A_Service;

@Service
public class GSTDDM_DDM_GST_4A_ServiceImpl implements GSTDDM_DDM_GST_4A_Service {

	private static final Logger logger = LoggerFactory.getLogger(GSTDDM_DDM_GST_4A_ServiceImpl.class);

	@Autowired
	GSTDDM_DDM_GST_4A_DaoImpl GSTddm_ddm_gst_4A_DaoImpl ;

	@Override
	public ModelAndView getReport_DDM_GST_4A(String Report_Type, String Code, String Report_Name, String MM_YYYY,
			HttpServletRequest request, String request_CSRF_Token) 
	{
		ModelAndView ModelView = new ModelAndView();
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

			List<SP_DDM_GST_4A_ALL> all_report = new ArrayList<SP_DDM_GST_4A_ALL>();
			List<SP_DDM_GST_4A_ZONE_Result> zone_report = new ArrayList<SP_DDM_GST_4A_ZONE_Result>();
			List<SP_DDM_GST_4A_COMM_Result> comm_report = new ArrayList<SP_DDM_GST_4A_COMM_Result>();
			List<SP_DDM_GST_4A_COMM_TEMP_REPORT_Result> temp_report = new ArrayList<SP_DDM_GST_4A_COMM_TEMP_REPORT_Result>();

			System.out.println("in GST_REV_4 action _MM_YYYY--" + _MM_YYYY);

			ModelView.addObject("Report_Type", Report_Type);

			String _Report_Name = "";
			switch (Report_Type) {
			case "All": {
				_Report_Name = Report_Name;
				ModelView.addObject("ViewBag_Report_Name", _Report_Name);
				ModelView.addObject("ViewBag_MM_YYYY", MM_YYYY);

				Object[] objArray = new Object[1];
				objArray[0] = _MM_YYYY;

				all_report = GSTddm_ddm_gst_4A_DaoImpl.generateResultBeanList_SP_DDM_GST_4A_ALL(_MM_YYYY);

				if (all_report != null) {
					logger.info("result_all.size()" + all_report.size());
					logger.info("result_all " + all_report);

					
					ModelView.addObject("Model", all_report);

					if (all_report.size() > 0) {
						ModelView.addObject("Model_TOTAL_COMM", all_report.get(0).getTOTAL_COMM());
						ModelView.addObject("Model_COMPLETE_COMM", all_report.get(0).getCOMPLETE_COMM());
						ModelView.addObject("Model_AMND", all_report.get(0).getAMND());
						ModelView.addObject("Model_size", all_report.size());

					}
				} else {

					ModelView.addObject("Model_TOTAL_COMM", 0);
					ModelView.addObject("Model_COMPLETE_COMM", 0);
					ModelView.addObject("Model_AMND", 0);
					ModelView.addObject("Model_size", 0);

				}
				ModelView.addObject("Model", all_report);
				ModelView.addObject("_MM_YYYY", _MM_YYYY);

				break;
			}

			case "Zone": {
				logger.info("inside case Zone");
				_Report_Name = "ZONE : " + Report_Name;
				ModelView.addObject("ViewBag_Report_Name", _Report_Name);
				System.out.println("ViewBag_Report_Name" + _Report_Name);
				ModelView.addObject("ViewBag_MM_YYYY", MM_YYYY);
				
				Object[] objArray = new Object[2];
				objArray[0] = Code;
				objArray[1] = _MM_YYYY;

				zone_report = GSTddm_ddm_gst_4A_DaoImpl.generateResultBeanList_SP_DDM_GST_4A_ZONE(Code, _MM_YYYY);
				if (zone_report != null) {
					if (zone_report.size() > 0) {
						ModelView.addObject("Model_TOTAL_COMM", zone_report.get(0).getTOTAL_COMM());
						ModelView.addObject("Model_COMPLETE_COMM", zone_report.get(0).getCOMPLETE_COMM());
						ModelView.addObject("Model_AMND", zone_report.get(0).getAMND());
						ModelView.addObject("Model_size", zone_report.size());

					}
				} else {

					ModelView.addObject("Model_TOTAL_COMM", 0);
					ModelView.addObject("Model_COMPLETE_COMM", 0);
					ModelView.addObject("Model_AMND", 0);
					ModelView.addObject("Model_size", 0);

				}

				ModelView.addObject("Model", zone_report);
				ModelView.addObject("_MM_YYYY", _MM_YYYY);

				break;
			}

			case "Comm": {
				System.out.println("inside case Comm");
				_Report_Name = "COMMISSIONERATE : " + Report_Name;
				ModelView.addObject("ViewBag_Report_Name", _Report_Name);
				ModelView.addObject("ViewBag_MM_YYYY", MM_YYYY);
				Object[] objArray = new Object[2];
				objArray[0] = Code;
				objArray[1] = _MM_YYYY;

				comm_report = GSTddm_ddm_gst_4A_DaoImpl.generateResultBeanList_SP_DDM_GST_4A_COMM(Code, _MM_YYYY);
				if (comm_report != null) {
					if (comm_report.size() > 0) {

						logger.info("result_comm.size()" + comm_report.size());
						logger.info("result_comm" + comm_report);

						ModelView.addObject("Model_TOTAL_COMM", comm_report.get(0).getTOTAL_COMM());
						ModelView.addObject("Model_COMPLETE_COMM", comm_report.get(0).getCOMPLETE_COMM());
						ModelView.addObject("Model_AMND", comm_report.get(0).getAMND());
						ModelView.addObject("Model_size", comm_report.size());

					}
				} else {

					ModelView.addObject("Model_TOTAL_COMM", 0);
					ModelView.addObject("Model_COMPLETE_COMM", 0);
					ModelView.addObject("Model_AMND", 0);
					ModelView.addObject("Model_size", 0);

				}

				ModelView.addObject("Model", comm_report);
				ModelView.addObject("_MM_YYYY", _MM_YYYY);

				break;
			}
			case "Temp": {

				Object[] objArray1 = new Object[1];
				objArray1[0] = Code;
				Object month = GSTddm_ddm_gst_4A_DaoImpl.generateResult_SP_DDM_GST_4A_MAX_DATE(Code);
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
				ModelView.addObject("ViewBag_Report_Name", _Report_Name);
				ModelView.addObject("ViewBag_MM_YYYY", MM_YYYY);
				Object[] objArray = new Object[5];
				objArray[0] = Code;
				objArray[1] = null;
				objArray[2] = null;
				objArray[3] = null;
				objArray[4] = _MM_YYYY;

				temp_report = GSTddm_ddm_gst_4A_DaoImpl.generateResultBeanList_SP_DDM_GST_4A_COMM_TEMP_REPORT(objArray);
				if (temp_report != null) {
					logger.info("Comm_temp_result_comm.size()" + temp_report.size());
					logger.info("Comm_temp_result_comm" + temp_report);

					if (temp_report.size() > 0) {
						ModelView.addObject("Model_TOTAL_COMM", temp_report.get(0).getTOTAL_COMM());
						ModelView.addObject("Model_COMPLETE_COMM", temp_report.get(0).getCOMPLETE_COMM());
						ModelView.addObject("Model_AMND", temp_report.get(0).getAMND());
						ModelView.addObject("Model_size", temp_report.size());

					}
				}

				else {

					ModelView.addObject("Model_TOTAL_COMM", 0);
					ModelView.addObject("Model_COMPLETE_COMM", 0);
					ModelView.addObject("Model_AMND", 0);
					ModelView.addObject("Model_size", 0);

				}

				ModelView.addObject("Model", temp_report);
				ModelView.addObject("_MM_YYYY", _MM_YYYY);

				break;
			}
			case "Crr": {
				System.out.println("inside case CRR");
				_Report_Name = "COMMISSIONERATE : " + Report_Name;
				ModelView.addObject("ViewBag_Report_Name", _Report_Name);
				ModelView.addObject("ViewBag_MM_YYYY", MM_YYYY);

				Object[] objArray1 = new Object[5];
				objArray1[0] = Code;
				objArray1[1] = "T";
				objArray1[2] = null;
				objArray1[3] = null;
				objArray1[4] = _MM_YYYY;

				temp_report = GSTddm_ddm_gst_4A_DaoImpl.generateResultBeanList_SP_DDM_GST_4A_COMM_TEMP_REPORT(objArray1);

				comm_report = GSTddm_ddm_gst_4A_DaoImpl.generateResultBeanList_SP_DDM_GST_4A_COMM(Code, _MM_YYYY);

				if (temp_report != null) {
					ModelView.addObject("Model_TOTAL_COMM", temp_report.get(0).getTOTAL_COMM());
					ModelView.addObject("Model_COMPLETE_COMM", temp_report.get(0).getCOMPLETE_COMM());
					ModelView.addObject("Model_AMND", temp_report.get(0).getAMND());
					ModelView.addObject("Model_size", temp_report.size());

				} else {
					ModelView.addObject("Model_TOTAL_COMM", 0);
					ModelView.addObject("Model_COMPLETE_COMM", 0);
					ModelView.addObject("Model_AMND", 0);
					ModelView.addObject("Model_size", 0);
				}
				ModelView.addObject("Model", temp_report);
				ModelView.addObject("ViewBagReport", comm_report);
				ModelView.addObject("_MM_YYYY", _MM_YYYY);

				break;
			}

			default: {

				_Report_Name = "COMMISSIONERATE : " + Report_Name;
				ModelView.addObject("ViewBag_Report_Name", _Report_Name);
				ModelView.addObject("ViewBag_MM_YYYY", MM_YYYY);
				ModelView.addObject("Model_TOTAL_COMM", 0);
				ModelView.addObject("Model_COMPLETE_COMM", 0);
				ModelView.addObject("Model_AMND", 0);
				ModelView.addObject("Model_size", 0);
			}

			}

			ModelView.setViewName("GSTDDM/Report/DDM-GST-4A");

		} else {
			request.getSession().invalidate();
			ModelView.setViewName("GSTDDM/ResourceNotFound");
			ModelView.addObject("message", "");

		}

		return ModelView;
	}

	@Override
	public ModelAndView get_DDM_GST_4A(Model Model, HttpServletRequest request, String request_CSRF_Token) {
		ModelAndView ModelView = new ModelAndView();
		Object crr = (String) request.getParameter("CRR");
		String MM_YYYY = request.getParameter("MM_YYYY");
		String code = (String) request.getSession().getAttribute("CODE");
		String result;
		if (!(crr == null || crr == "") && !(MM_YYYY == null || MM_YYYY == "")) {
			ModelView.addObject("CRR", "T");
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
			ModelView.addObject("CRR", "");
			Object month = GSTddm_ddm_gst_4A_DaoImpl.generateResult_SP_DDM_GST_4A_MAX_DATE(code);
			if (month == null) {
				MM_YYYY = "2022-04-01";
			} else {
				LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1);
				MM_YYYY = String.valueOf(date);
			}
		}

		List<SP_DDM_GST_4A_COMM_TEMP_Result> commTempResult = new ArrayList<SP_DDM_GST_4A_COMM_TEMP_Result>();
		commTempResult = GSTddm_ddm_gst_4A_DaoImpl.generateResultBeanList_SP_DDM_GST_4A_COMM_TEMP(code, MM_YYYY, crr,
				request);
		result = (String) request.getAttribute("result");
		logger.info("commTempResult" + commTempResult);

		if (commTempResult != null && "TEMP".equals(result)) {
			logger.info("update");
			ModelView.addObject("ViewBag_button", "Update");
		} else if (commTempResult == null && (!result.equals("MAIN") || !result.equals("CRR"))) {
			logger.info("upload");
			ModelView.addObject("ViewBag_button", "Upload");

		} else if (commTempResult != null && result.equals("CRR")) {
			ModelView.addObject("ViewBagMessage", "CORRECTION REQUEST SUBMITTED");
			ModelView.addObject("ViewBagResult", "CORRECTION REQUEST SUBMITTED");
		}
		if (commTempResult == null && result.equals("MAIN") && !(crr == "" || crr == null)) {
			ModelView.setViewName("correction-message");
			return ModelView;
		}

		ModelView.addObject("MM_YYYY", MM_YYYY);
		ModelView.addObject("Model", commTempResult);
		ModelView.addObject("GstRev4CommTemp", new SP_DDM_GST_4A_COMM_TEMP_Result());
		ModelView.setViewName("GSTDDM/Insert/DDM-GST-4A");
		return ModelView;
	}

	@Override
	public ModelAndView post_DDM_GST_4A(SP_DDM_GST_4A_COMM_TEMP_Result GstRev4CommTemp, BindingResult reslt, Model Model,
			HttpServletRequest request, String btn_submit, String HDTokenNo) {
		ModelAndView ModelView = new ModelAndView();
		if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo"))) {
			String result;
			Object crr = request.getParameter("CRR");
			String MM_YYYY = request.getParameter("MM_YYYY");
			String code = (String) request.getSession().getAttribute("CODE");

			logger.info("crr-" + crr);
			if (btn_submit.equals("Update") && !(crr == "" || crr == null) && (!reslt.hasErrors())) {
				//HSN_CODE
				result = GSTddm_ddm_gst_4A_DaoImpl.generateResult__GSTDDM_DDM_GST_4A_TEMP_UPDATE(code, MM_YYYY,
						request.getParameter("SNO"), request.getParameter("SERVICE_CODE"),
						request.getParameter("SERVICE_NAME"), request.getParameter("CUR_YEAR_FOR"),
						request.getParameter("CUR_YEAR_UPTO"), request.getParameter("PRE_YEAR_FOR"),
						request.getParameter("PRE_YEAR_UPTO"), request.getParameter("REASONS"), "T");

				ModelView.addObject("CRR", "T");
				crr = "T";
				if (result.equals("CORRECTION REQUEST SUBMITTED")) {
					ModelView.addObject("ViewBagMessage", result);
				} else {
					ModelView.addObject("ViewBagMessage", result);
				}
			}

			else if (btn_submit.equals("Update") && (!reslt.hasErrors())) {
				ModelView.addObject("CRR", "");
				result = GSTddm_ddm_gst_4A_DaoImpl.generateResult__GSTDDM_DDM_GST_4A_TEMP_UPDATE(code, MM_YYYY,
						request.getParameter("SNO"), request.getParameter("SERVICE_CODE"),
						request.getParameter("SERVICE_NAME"), request.getParameter("CUR_YEAR_FOR"),
						request.getParameter("CUR_YEAR_UPTO"), request.getParameter("PRE_YEAR_FOR"),
						request.getParameter("PRE_YEAR_UPTO"), request.getParameter("REASONS"), null);
				logger.info("result" + result);

				crr = "";
				ModelView.addObject("ViewBagMessage", result);
				ModelView.addObject("ViewBag_button", "Update");

			}

			else if (btn_submit.equals("Upload") && (!reslt.hasErrors())) {
				ModelView.addObject("CRR", "");
				result = GSTddm_ddm_gst_4A_DaoImpl.generateResult__GSTDDM_DDM_GST_4A_INSERT(code, MM_YYYY,
						request.getParameter("SERVICE_NAME"),
						request.getParameter("CUR_YEAR_FOR"), request.getParameter("CUR_YEAR_UPTO"),
						request.getParameter("PRE_YEAR_FOR"), request.getParameter("PRE_YEAR_UPTO"),
						request.getParameter("REASONS"));

				logger.info("result " + result);
				crr = "";
				ModelView.addObject("ViewBagMessage", result);
				if (result.equals("RECORD SUBMITTED")) {
					ModelView.addObject("ViewBag_button", "Update");
				} else if (!result.equals("RECORD SUBMITTED")) {
					ModelView.addObject("ViewBag_button", "Upload");
				}
			}

			List<SP_DDM_GST_4A_COMM_TEMP_Result> commTempResult = new ArrayList<SP_DDM_GST_4A_COMM_TEMP_Result>();
			commTempResult = GSTddm_ddm_gst_4A_DaoImpl.generateResultBeanList_SP_DDM_GST_4A_COMM_TEMP(code, MM_YYYY, crr,
					request);

			if(reslt.hasErrors()) {
				ModelView.addObject("button", "Error");
			}
			ModelView.addObject("MM_YYYY", MM_YYYY);
			ModelView.addObject("Model", commTempResult);
			ModelView.addObject("gstRev4CommTemp", new SP_DDM_GST_4A_COMM_TEMP_Result());
			ModelView.setViewName("GSTDDM/Insert/DDM-GST-4A");
		}

		return ModelView;
	}

}
