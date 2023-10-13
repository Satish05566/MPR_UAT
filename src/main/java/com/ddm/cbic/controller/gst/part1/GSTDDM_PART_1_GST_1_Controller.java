package com.ddm.cbic.controller.gst.part1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.dao.implementation.DDM_PART_1_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_DDM_CUS_1_DaoImpl;
import com.ddm.cbic.dao.implementation.SP_DDM_GST_1_DaoImpl;
import com.ddm.cbic.model.SP_DDM_CE_1_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_ALL_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_COMM_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_COMM_TARGET_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_COMM_TEMP_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_REGION_Result;
import com.ddm.cbic.model.SP_DDM_GST_1_ZONE_Result;

@Controller
@RequestMapping("/GSTDDM")
public class GSTDDM_PART_1_GST_1_Controller {

	private static final Logger logger = LoggerFactory.getLogger(GSTDDM_PART_1_GST_1_Controller.class);

	@Autowired
	private DDM_PART_1_DaoImpl DDM_PART_1_DaoImpl;

	@Autowired
	private SP_DDM_GST_1_DaoImpl sp_DDM_GST_1_DaoImpl;

	@Autowired
	private SP_DDM_CUS_1_DaoImpl sp_DDM_CUS_1_DaoImpl;

	// @GetMapping("/Insert/DDM_GST_1")
	@RequestMapping(value = "/Insert/DDM_GST_1_OLD/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView getDDM_GST_1(Model m, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

		logger.info("session CSRF token" + request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token" + request_CSRF_Token);
			ModelAndView mv = new ModelAndView();
			m.addAttribute("ddmGst1CommTemp", new SP_DDM_GST_1_COMM_TEMP_Result());
			Object[] objArray = new Object[9];
			Object COMM_CODE = request.getSession().getAttribute("CODE");

			objArray[0] = COMM_CODE;
			String mm_yyyy = "";
			Date mmyyyy = new Date();
			String crr = (String) request.getParameter("CRR");
			String MM_YYYY = (String) request.getParameter("MM_YYYY");
			logger.info("CRR--" + crr);
			logger.info("MM_YYYY--" + MM_YYYY);
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String result1 = "", result2 = "", mm1 = "", mm = "", _month = "", button = "", Message = "",
					ViewBagResult = "";
			boolean ChecExistsLog = false;

			if ((crr != null && crr != "") && (MM_YYYY != null && MM_YYYY != "")) {
				logger.info("--CRR & MM_YYYY not null--");
				mv.addObject("CRR", "T");
				crr = "T";
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM");
					mmyyyy = formatter.parse(MM_YYYY);
					mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
					logger.info("mm_yyyy--" + mm_yyyy);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				;

			} else {
				Object month = DDM_PART_1_DaoImpl.generateResultBean_SP_DDM_GST_1_MAX_DATE(objArray);
				// month="2017-07-01";
				logger.info("month--" + month);
				if (month == null || month == "") {
					mm_yyyy = "2017-07-01";
				} else {
					_month = month.toString();
					try {
						mmyyyy = sdf.parse(_month);
						mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
						logger.info("mm_yyyy-->" + mm_yyyy);
						Calendar cal = Calendar.getInstance();
						cal.setTime(mmyyyy);
						cal.add(Calendar.MONTH, -1);
						mmyyyy = cal.getTime();
						mm1 = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);

						logger.info("cal month-1 mm_yyyy-->" + mm1);
						objArray[0] = "MIS_DDM_GST_1";
						objArray[1] = COMM_CODE;
						objArray[2] = mm1;
						result1 = DDM_PART_1_DaoImpl.generateResultBean_SP_MPR_CHECK_VALIDATE_UPTO(objArray);
						if (result1 == "SUCCESS") {
							mmyyyy = sdf.parse(_month);
							logger.info("--Inside success--");
							cal.setTime(mmyyyy);
							cal.add(Calendar.YEAR, -1);
							cal.add(Calendar.MONTH, 1);
							mmyyyy = cal.getTime();
							mm = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
							logger.info("cal1 year-1 month+1 mm_yyyy-->" + mm);
							objArray[0] = COMM_CODE;
							objArray[1] = "MIS_DDM_GST_1";
							objArray[2] = mm;
							ChecExistsLog = DDM_PART_1_DaoImpl.generateResultBean_SP_SUBMIT_LOG_UPTO_SELECT(objArray);
							if ((mm.equalsIgnoreCase("2017-06-01")) && (ChecExistsLog == false)) {
								logger.info("--mm.equalsIgnoreCase(2017-06-01)) && (ChecExistsLog==false)--");
								mmyyyy = sdf.parse(_month);
								cal.setTime(mmyyyy);
								cal.add(Calendar.MONTH, 1);
								mmyyyy = cal.getTime();
								mm = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
								logger.info("mm month+1" + mm);
								request.getSession().setAttribute("MM_YYYY", mm_yyyy);
								// getDDM_CUS_2_UPTO();
							} else {
								objArray[0] = "MIS_DDM_GST_1";
								objArray[1] = COMM_CODE;
								objArray[2] = mm;
								result2 = DDM_PART_1_DaoImpl.generateResultBean_SP_MPR_CHECK_VALIDATE_UPTO(objArray);
								if (result2.equalsIgnoreCase("SUCCESS")) {
									mmyyyy = sdf.parse(_month);
									cal.setTime(mmyyyy);
									cal.add(Calendar.MONTH, 1);
									mmyyyy = cal.getTime();
									mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
									logger.info("cal3 month+1 mm_yyyy--" + mm_yyyy);
								} else {
									mmyyyy = sdf.parse(_month);
									cal.setTime(mmyyyy);
									cal.add(Calendar.MONTH, 1);
									mmyyyy = cal.getTime();
									mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
									DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
									Date _date = df.parse("2017-08-01");

									Calendar _cal = Calendar.getInstance();
									_cal.setTime(_date);
									logger.info("--mmyyyy--" + mmyyyy);
									logger.info("--_cal--" + _cal.getTime());
									if (mmyyyy.after(_cal.getTime()) || mmyyyy.equals(_cal.getTime())) {
										logger.info("--mmyyyy.after(_cal.getTime())--");
										request.getSession().setAttribute("MM_YYYY", mm_yyyy);
										// getDDM_CUS_2_UPTO();
									}
								}
							}
						} else {
							mmyyyy = sdf.parse(_month);
							cal.setTime(mmyyyy);
							cal.add(Calendar.MONTH, 1);
							mmyyyy = cal.getTime();
							mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
							logger.info("cal5  month +1 mm_yyyy-->" + mm_yyyy);
							if (mm_yyyy.equalsIgnoreCase("2017-08-01")) {
								logger.info("--mm_yyyy.equalsIgnoreCase(2017-08-01)--");
								mmyyyy = sdf.parse(mm_yyyy);
								cal.setTime(mmyyyy);
								cal.add(Calendar.MONTH, -1);
								mmyyyy = cal.getTime();
								mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
								logger.info("cal6  month -1 mm_yyyy-->" + mm_yyyy);
								request.getSession().setAttribute("MM_YYYY", mm_yyyy);
								// getDDM_CUS_2_UPTO();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			objArray[0] = COMM_CODE;
			objArray[1] = crr;
			objArray[2] = mm_yyyy;
			SP_DDM_GST_1_COMM_TEMP_Result dt = new SP_DDM_GST_1_COMM_TEMP_Result();
			String _Result = "";
			try {
				dt = DDM_PART_1_DaoImpl.generateResultBeanSP_DDM_GST_1_COMM_TEMP(objArray, request);
				mv.addObject("model", dt);
				_Result = (String) request.getSession().getAttribute("_Result");
				// logger.info("getCESS_IRON--"+dt.getANIT_SMG());
				logger.info("_Result-->" + _Result);
			} catch (Exception e) {
				e.printStackTrace();
				dt = null;
			}

			if (dt != null && _Result.equals("TEMP")) {
				logger.info("dt!=null && dt==TEMP");
				button = "Update";
				mv.addObject("button", button);
			} else if (dt == null && (!_Result.equals("MAIN") || !_Result.equals("CRR"))) {
				logger.info("dt==null && (dt!=MAIN ||dt!=CRR )");
				button = "Upload";
				mv.addObject("button", button);
			} else if (dt != null && _Result.equals("CRR")) {
				logger.info("dt!=null && dt==CRR--");
				mv.addObject("Message", "CORRECTION REQUEST SUBMITTED");
				mv.addObject("ViewBagResult", "CORRECTION REQUEST SUBMITTED");
			} else if (dt == null && _Result.equals("MAIN") && !(crr == null)) {
				button = "Submit";
				mv.addObject("button", button);
				logger.info("crr==T && dt==null---button-->" + button);
			}
			if (dt == null && _Result.equals("MAIN") && !(crr.equals("") ||crr.equals(null))) {
				mv.setViewName("correction-message");
				return mv;
			}
			request.getSession().setAttribute("MM_YYYY", mm_yyyy);
			mv.addObject("MM_YYYY", mm_yyyy);
			mv.addObject("ddmGst1CommTemp", new SP_DDM_GST_1_COMM_TEMP_Result());
			mv.setViewName("GSTDDM/Insert/DDM-GST-1");
			return mv;

	}

	@SuppressWarnings("null")
	@RequestMapping(value = "/Insert/DDM_GST_1_OLD", method = RequestMethod.POST)
	public ModelAndView DDM_GST_1(@ModelAttribute("ddmGst1CommTemp") SP_DDM_GST_1_COMM_TEMP_Result ddmGst1CommTemp,
			BindingResult reslt, String btn_submit, String HDTokenNo, HttpServletRequest request) {

		if (request.getSession().getAttribute("CSRF_Token").toString()
				.equalsIgnoreCase(request.getParameter("request_CSRF_Token").toString())) {
			logger.info("Inside DDM_GST_1--");
			logger.info("");
			ModelAndView mv = new ModelAndView();
			Object[] objArray = new Object[15];
			String button = "";
			// HttpSession session=null;
			String crr = (String) request.getAttribute("CRR");
			String AuthTokenNo = (String) request.getSession().getAttribute("AuthTokenNo");
			String COMM_CODE = (String) request.getSession().getAttribute("CODE");
			String MM_YYYY = (String) request.getSession().getAttribute("MM_YYYY");

			logger.info("HDTokenNo-->" + HDTokenNo + " btn_submit-->" + btn_submit + " AuthTokenNo-->" + AuthTokenNo
					+ " COMM_CODE-->" + COMM_CODE + " MM_YYYY-->" + MM_YYYY);
			logger.info("CENTRAL_MOVING_TARGET-->" + request.getParameter("CENTRAL_MOVING_TARGET")
					+ " STATEUT_MOVING_TARGET-->" + request.getParameter("STATEUT_MOVING_TARGET")
					+ " INTEGRATED_MOVING_TARGET-->" + request.getParameter("INTEGRATED_MOVING_TARGET")
					+ "  CESS_MOVING_TARGET-->" + request.getParameter("CESS_MOVING_TARGET") + " CENTRAL_GST_GROSS-->"
					+ request.getParameter("CENTRAL_GST_GROSS") + " STATEUT_GST_GROSS-->"
					+ request.getParameter("STATEUT_GST_GROSS"));
			logger.info("INTEGRATED_GST_GROSS-->" + request.getParameter("INTEGRATED_GST_GROSS") + " CESS_GST_GROSS-->"
					+ request.getParameter("CESS_GST_GROSS") + " CENTRAL_GST_REFUND-->"
					+ request.getParameter("CENTRAL_GST_REFUND") + "  STATEUT_GST_REFUND-->"
					+ request.getParameter("STATEUT_GST_REFUND") + " INTEGRATED_GST_REFUND-->"
					+ request.getParameter("INTEGRATED_GST_REFUND") + " CESS_GST_REFUND-->"
					+ request.getParameter("CESS_GST_REFUND"));

			// if(HDTokenNo==AuthTokenNo) {
			if (btn_submit.equalsIgnoreCase("Update")) {
				logger.info("--btn_submit==Update--");
				objArray[0] = COMM_CODE;
				objArray[1] = MM_YYYY;
				objArray[2] = request.getParameter("CENTRAL_MOVING_TARGET");
				objArray[3] = request.getParameter("STATEUT_MOVING_TARGET");
				objArray[4] = request.getParameter("INTEGRATED_MOVING_TARGET");
				objArray[5] = request.getParameter("CESS_MOVING_TARGET");
				objArray[6] = request.getParameter("CENTRAL_GST_GROSS");
				objArray[7] = request.getParameter("STATEUT_GST_GROSS");
				objArray[8] = request.getParameter("INTEGRATED_GST_GROSS");
				objArray[9] = request.getParameter("CESS_GST_GROSS");
				objArray[10] = request.getParameter("CENTRAL_GST_REFUND");
				objArray[11] = request.getParameter("STATEUT_GST_REFUND");
				objArray[12] = request.getParameter("INTEGRATED_GST_REFUND");
				objArray[13] = request.getParameter("CESS_GST_REFUND");
				objArray[14] = crr;

				String result = DDM_PART_1_DaoImpl.generateResultBeanSP_DDM_GST_1_UPDATE(objArray);
				mv.addObject("Message", result);
				mv.addObject("ViewBagResult", result);
				mv.addObject("button", "Update");

			} else if (btn_submit.equalsIgnoreCase("Upload")) {
				logger.info("--btn_submit==Upload--");
				objArray[0] = COMM_CODE;
				objArray[1] = MM_YYYY;
				objArray[2] = request.getParameter("CENTRAL_MOVING_TARGET");
				objArray[3] = request.getParameter("STATEUT_MOVING_TARGET");
				objArray[4] = request.getParameter("INTEGRATED_MOVING_TARGET");
				objArray[5] = request.getParameter("CESS_MOVING_TARGET");
				objArray[6] = request.getParameter("CENTRAL_GST_GROSS");
				objArray[7] = request.getParameter("STATEUT_GST_GROSS");
				objArray[8] = request.getParameter("INTEGRATED_GST_GROSS");
				objArray[9] = request.getParameter("CESS_GST_GROSS");
				objArray[10] = request.getParameter("CENTRAL_GST_REFUND");
				objArray[11] = request.getParameter("STATEUT_GST_REFUND");
				objArray[12] = request.getParameter("INTEGRATED_GST_REFUND");
				objArray[13] = request.getParameter("CESS_GST_REFUND");
				objArray[14] = "";

				String result = DDM_PART_1_DaoImpl.generateResultBeanSP_DDM_GST_1_INSERT(objArray);
				mv.addObject("Message", result);
				mv.addObject("ViewBagResult", result);
				if (result.equalsIgnoreCase("RECORD SUBMITTED")) {
					button = "Update";
					mv.addObject("button", button);
				} else {
					button = "Upload";
					mv.addObject("button", button);
				}

			} else if (btn_submit.equalsIgnoreCase("Submit")) {
				logger.info("--btn_submit==Submit--");
				objArray[0] = COMM_CODE;
				objArray[1] = MM_YYYY;
				objArray[2] = request.getParameter("CENTRAL_MOVING_TARGET");
				objArray[3] = request.getParameter("STATEUT_MOVING_TARGET");
				objArray[4] = request.getParameter("INTEGRATED_MOVING_TARGET");
				objArray[5] = request.getParameter("CESS_MOVING_TARGET");
				objArray[6] = request.getParameter("CENTRAL_GST_GROSS");
				objArray[7] = request.getParameter("STATEUT_GST_GROSS");
				objArray[8] = request.getParameter("INTEGRATED_GST_GROSS");
				objArray[9] = request.getParameter("CESS_GST_GROSS");
				objArray[10] = request.getParameter("CENTRAL_GST_REFUND");
				objArray[11] = request.getParameter("STATEUT_GST_REFUND");
				objArray[12] = request.getParameter("INTEGRATED_GST_REFUND");
				objArray[13] = request.getParameter("CESS_GST_REFUND");
				objArray[14] = "T";
				crr = "T";
				mv.addObject("CRR", "T");
				String result = DDM_PART_1_DaoImpl.generateResultBeanSP_DDM_GST_1_UPDATE(objArray);
				logger.info("result--" + result);
				mv.addObject("Message", "CORRECTION REQUEST SUBMITTED");
				mv.addObject("ViewBagResult", "CORRECTION REQUEST SUBMITTED");

			}

			objArray[0] = COMM_CODE;
			objArray[1] = crr;
			objArray[2] = MM_YYYY;
			SP_DDM_GST_1_COMM_TEMP_Result dt = new SP_DDM_GST_1_COMM_TEMP_Result();
			String _Result = "";
			try {
				dt = DDM_PART_1_DaoImpl.generateResultBeanSP_DDM_GST_1_COMM_TEMP(objArray, request);
				mv.addObject("model", dt);

				logger.info("_Result-->" + _Result);
			} catch (Exception e) {
				e.printStackTrace();
				dt = null;
			}
			request.setAttribute("MM_YYYY", MM_YYYY);
			mv.addObject("MM_YYYY", MM_YYYY);
			mv.setViewName("GSTDDM/Insert/DDM-GST-1");

			return mv;

		} else {
			request.getSession().invalidate();
			ModelAndView mv = new ModelAndView();

			mv.setViewName("GSTDDM/ResourceNotFound");
			mv.addObject("message", "");

			return mv;
		}
	}

	@RequestMapping(value = "/Report/DDM_GST_1_OLD/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView DDM_GST_1(@PathVariable("Report_Type") String Report_Type, @PathVariable("Code") String Code,
			@PathVariable("Report_Name") String Report_Name, @PathVariable("YYYY-MMM") String MM_YYYY,
			HttpServletRequest request, @PathVariable("request_CSRF_Token") String request_CSRF_Token) {
		logger.info("session CSRF token" + request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token" + request_CSRF_Token);

		if (request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {
			String _MM_YYYY = "";
//			String COMM_CODE = (String) request.getSession().getAttribute("CODE");
			if(!Report_Type.equalsIgnoreCase("Temp")) {
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

			logger.info("Report_Type-->" + Report_Type + "  Code-->" + Code + "  Report_Name-->" + Report_Name
					+ "  MM_YYYY-->" + MM_YYYY + " _MM_YYYY-->" + _MM_YYYY);
			request.getSession().setAttribute("Report_Type", Report_Type);
			SP_DDM_GST_1_ALL_Result result_all = new SP_DDM_GST_1_ALL_Result();
			SP_DDM_GST_1_ZONE_Result result_zone = new SP_DDM_GST_1_ZONE_Result();
			SP_DDM_GST_1_REGION_Result result_region = new SP_DDM_GST_1_REGION_Result();
			SP_DDM_GST_1_COMM_Result result_comm = new SP_DDM_GST_1_COMM_Result();
			SP_DDM_GST_1_COMM_TEMP_REPORT_Result sp_DDM_GST_1_COMM_TEMP_REPORT_Result = new SP_DDM_GST_1_COMM_TEMP_REPORT_Result();
			ModelAndView mv = new ModelAndView();
			String _Report_Name = "";
			switch (Report_Type) {

			case "Region": {
				logger.info("--Region--");
				_Report_Name = "REGION : " + Report_Name;
				mv.addObject("ViewBag_Report_Name", _Report_Name);
				mv.addObject("ViewBag_MM_YYYY", _MM_YYYY);
				Object[] objArray = new Object[2];
				objArray[0] = _MM_YYYY;
				objArray[1] = Code;
				try {
					result_region = sp_DDM_GST_1_DaoImpl.generateResultList_SP_DDM_GST_1_REGION(objArray);
					mv.addObject("Model", result_region);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case "All": {
				logger.info("--All---");
				_Report_Name = Report_Name;
				mv.addObject("ViewBag_Report_Name", _Report_Name);
				mv.addObject("ViewBag_MM_YYYY", _MM_YYYY);
				Object[] objArray = new Object[1];
				objArray[0] = _MM_YYYY;
				try {
					result_all = sp_DDM_GST_1_DaoImpl.generateResultBean_SP_DDM_GST_1_ALL(objArray);
					mv.addObject("Model", result_all);
					mv.addObject("ViewBag_Report", null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case "Zone": {
				logger.info("--Zone---");
				_Report_Name = "ZONE : " + Report_Name;
				mv.addObject("ViewBag_Report_Name", _Report_Name);
				mv.addObject("ViewBag_MM_YYYY", _MM_YYYY);
				Object[] objArray = new Object[2];
				objArray[0] = _MM_YYYY;
				objArray[1] = Code;
				try {
					result_zone = sp_DDM_GST_1_DaoImpl.generateResultBean_SP_DDM_GST_1_ZONE(objArray);
					mv.addObject("Model", result_zone);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}

			case "Comm": {
				logger.info("--Comm---");
				_Report_Name = "COMMISSIONRATE : " + Report_Name;
				mv.addObject("ViewBag_Report_Name", _Report_Name);
				mv.addObject("ViewBag_MM_YYYY", _MM_YYYY);
				Object[] objArray = new Object[2];
				objArray[0] = _MM_YYYY;
				objArray[1] = Code;
				try {
					result_comm = sp_DDM_GST_1_DaoImpl.generateResultBean_SP_DDM_GST_1_COMM(objArray);
					mv.addObject("Model", result_comm);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case "Temp": {
				logger.info("--Temp---");
				try {
					Object[] objArray1 = new Object[2];
					objArray1[0] = Code;
					Object month = sp_DDM_GST_1_DaoImpl.generateResultBean(objArray1);
					logger.info("--month--" + month);
					if (month == null || month == "") {
						_MM_YYYY = "2017-07-01";
					} else {
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						logger.info("--Inside success--");
						Calendar cal = Calendar.getInstance();
						cal.setTime(sdf.parse(month.toString()));
						cal.add(Calendar.MONTH, 1);
						_MM_YYYY = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
						logger.info("--_MM_YYYY-->" + _MM_YYYY);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				_Report_Name = "COMMISSIONRATE : " + Report_Name;
				mv.addObject("ViewBag_Report_Name", _Report_Name);
				mv.addObject("ViewBag_MM_YYYY", _MM_YYYY);
				Object[] objArray = new Object[5];
				objArray[0] = _MM_YYYY;
				objArray[1] = null;
				objArray[2] = null;
				objArray[3] = null;
				objArray[4] = Code;
				try {
					sp_DDM_GST_1_COMM_TEMP_REPORT_Result = sp_DDM_GST_1_DaoImpl
							.generateResultBean_SP_DDM_GST_1_COMM_TEMP_REPORT(objArray);
					mv.addObject("Model", sp_DDM_GST_1_COMM_TEMP_REPORT_Result);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}

//                case "Crr":
//                {
//                	logger.info("--Crr---");
//                	try {
//                	_Report_Name = "COMMISSIONRATE : " + Report_Name;
//                    mv.addObject("ViewBag_Report_Name",_Report_Name);
//                	mv.addObject("ViewBag_MM_YYYY",_MM_YYYY);
//                	Object[] objArray = new Object[5];
//                	objArray[0]=_MM_YYYY;
//                	objArray[1]="T";
//                	objArray[2]=null;
//                	objArray[3]=null;
//                	objArray[4]=Code; 
//                	sp_DDM_GST_1_COMM_TEMP_REPORT_Result = sp_DDM_GST_1_DaoImpl.generateResultBean_SP_DDM_GST_1_COMM_TEMP_REPORT(objArray);
//                	mv.addObject("Model",sp_DDM_GST_1_COMM_TEMP_REPORT_Result);
//                	
//                	
//                	Object[] objArray2 = new Object[2];
//                	objArray2[0]=_MM_YYYY;
//                	objArray2[1]=Code;
//                	
//                	result_comm = sp_DDM_GST_1_DaoImpl.generateResultBean_SP_DDM_GST_1_COMM(objArray2);
//                	mv.addObject("ViewBag_Report",result_comm);
//                	}catch(Exception e) {e.printStackTrace();}
//                	
//                	break;
//                }  
			case "Crr": {
				System.out.println("inside case CRR");
				_Report_Name = "COMMISSIONRATE : " + Report_Name;
				mv.addObject("ViewBag_Report_Name", _Report_Name);
				mv.addObject("ViewBag_MM_YYYY", MM_YYYY);

				Object[] objArray = new Object[5];
				objArray[0] = _MM_YYYY;
				objArray[1] = "T";
				objArray[2] = null;
				objArray[3] = null;
				objArray[4] = Code;

				sp_DDM_GST_1_COMM_TEMP_REPORT_Result = sp_DDM_GST_1_DaoImpl
						.generateResultBean_SP_DDM_GST_1_COMM_TEMP_REPORT(objArray);

				Object[] objArray1 = new Object[2];
				objArray1[0] = _MM_YYYY;
				objArray1[1] = Code;

				result_comm = sp_DDM_GST_1_DaoImpl.generateResultBean_SP_DDM_GST_1_COMM(objArray1);

				if (sp_DDM_GST_1_COMM_TEMP_REPORT_Result != null) {
					mv.addObject("Model_TOTAL_COMM", sp_DDM_GST_1_COMM_TEMP_REPORT_Result.getTOTAL_COMM());
					mv.addObject("Model_COMPLETE_COMM", sp_DDM_GST_1_COMM_TEMP_REPORT_Result.getCOMPLETE_COMM());
					mv.addObject("Model_AMND", sp_DDM_GST_1_COMM_TEMP_REPORT_Result.getAMND());

				} else {
					mv.addObject("Model_TOTAL_COMM", 0);
					mv.addObject("Model_COMPLETE_COMM", 0);
					mv.addObject("Model_AMND", 0);
					mv.addObject("Model_size", 0);
				}
				mv.addObject("Model", sp_DDM_GST_1_COMM_TEMP_REPORT_Result);
				mv.addObject("ViewBagReport", result_comm);
				mv.addObject("_MM_YYYY", _MM_YYYY);
				mv.addObject("ViewBag_Report_Name", Report_Name);
				break;
			}

			default: {
				logger.info("--default---");
				_Report_Name = "COMMISSIONRATE : " + Report_Name;
				mv.addObject("ViewBag_Report_Name", _Report_Name);
				mv.addObject("ViewBag_MM_YYYY", MM_YYYY);
			}
			}
			logger.info("--date --" + _MM_YYYY);
			logger.info("_MM_YYYY" + _MM_YYYY);
			mv.addObject("ViewBag_MM_YYYY", _MM_YYYY);
			request.setAttribute("ViewBag_MM_YYYY", _MM_YYYY);
			mv.setViewName("GSTDDM/Report/DDM-GST-1");
			return mv;

		} else {
			request.getSession().invalidate();
			ModelAndView mv = new ModelAndView();

			mv.setViewName("GSTDDM/ResourceNotFound");
			mv.addObject("message", "");

			return mv;
		}
	}

	@RequestMapping(value = "/Report/DDM_GST_1/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{Submission_Date}/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView DDM_GST_1_Bak(@PathVariable("Report_Type") String Report_Type,
			@PathVariable("Code") String Code, @PathVariable("Report_Name") String Report_Name,
			@PathVariable("YYYY-MMM") String MM_YYYY, @PathVariable("Submission_Date") String Submission_Date,
			HttpServletRequest request) {
		String _MM_YYYY = "";
		logger.info("--Submission_Date--" + Submission_Date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(MM_YYYY);
			DateFormat desDtFormat = new SimpleDateFormat("yyyy-MM-dd");
			MM_YYYY = desDtFormat.format(date);
			DateFormat DtFormat = new SimpleDateFormat("yyyy-MM-dd");
			_MM_YYYY = DtFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (Submission_Date != null && Submission_Date != "") {
			Submission_Date = Submission_Date.substring(0, 10) + " " + Submission_Date.substring(10, 12) + ":"
					+ Submission_Date.substring(12, 14) + ":" + Submission_Date.substring(14, 16) + "."
					+ Submission_Date.substring(16);
			logger.info("--Submission_Date--" + Submission_Date);
		}
		logger.info("Report_Type-->" + Report_Type + "  Code-->" + Code + "  Report_Name-->" + Report_Name
				+ "  MM_YYYY-->" + MM_YYYY + " _MM_YYYY-->" + _MM_YYYY);
		request.getSession().setAttribute("Report_Type", Report_Type);
		SP_DDM_GST_1_COMM_TEMP_REPORT_Result sp_DDM_GST_1_COMM_TEMP_REPORT_Result = new SP_DDM_GST_1_COMM_TEMP_REPORT_Result();
		ModelAndView mv = new ModelAndView();
		String _Report_Name = "";
		logger.info("--Bak---");
		_Report_Name = "COMMISSIONRATE : " + Report_Name;
		mv.addObject("ViewBag_Report_Name", _Report_Name);
		mv.addObject("ViewBag_MM_YYYY", _MM_YYYY);
		Object[] objArray = new Object[5];
		objArray[0] = _MM_YYYY;
		objArray[1] = null;
		objArray[2] = "T";
		objArray[3] = Submission_Date;
		objArray[4] = Code;
		try {
			sp_DDM_GST_1_COMM_TEMP_REPORT_Result = sp_DDM_GST_1_DaoImpl
					.generateResultBean_SP_DDM_GST_1_COMM_TEMP_REPORT(objArray);
			mv.addObject("Model", sp_DDM_GST_1_COMM_TEMP_REPORT_Result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.setViewName("GSTDDM/Report/DDM-GST-1");
		return mv;
	}

	// Vinod End

	// @RequestMapping(value = "/Insert/DDM_GST_1_TARGET/{request_CSRF_Token}",
	// method = RequestMethod.GET)
	@SuppressWarnings("null")
	@RequestMapping(value = "/Insert/DDM_GST_1_TARGET/{request_CSRF_Token}", method = RequestMethod.GET)
	public ModelAndView getDDM_GST_1_TARGET(Model m, HttpServletRequest request,
			@PathVariable("request_CSRF_Token") String request_CSRF_Token) {
		// @RequestMapping(value = "/Insert/DDM_GST_1_TARGET", method =
		// RequestMethod.GET)
		// public ModelAndView getDDM_GST_1_TARGET(Model m,HttpServletRequest request) {

		logger.info("session CSRF token" + request.getSession().getAttribute("CSRF_Token").toString());
		logger.info("request CSRF token" + request_CSRF_Token);
		if (request.getSession().getAttribute("CSRF_Token").toString().equalsIgnoreCase(request_CSRF_Token)) {
			logger.info("--DDM_GST_1_TARGET--");
			ModelAndView mv = new ModelAndView();
			m.addAttribute("ddmGST1CommTarget", new SP_DDM_GST_1_COMM_TARGET_Result());
			// Date mmyyyy = new Date();
			// DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// Calendar cal = Calendar.getInstance();

			Object[] objArray = new Object[1];

			objArray[0] = request.getSession().getAttribute("CODE").toString().trim();

			Object month = sp_DDM_GST_1_DaoImpl.generateResultBeanSP_DDM_GST_1_TARGET_MAX_DATE(objArray);

			String mm_yyyy = "";
			String button = "";
			String Message = "";
			String year = "", year1 = "";
			// var month =
			// dbcontext.SP_DDM_GST_1_TARGET_MAX_DATE(Session["CODE"].ToString()).FirstOrDefault();
			// if (string.IsNullOrEmpty(Convert.ToString(month)))

			if (month == null || month == "") {
				mm_yyyy = "2017-04-01";
			} else {
				Object main_month = "";
				try {
					main_month = sp_DDM_GST_1_DaoImpl.generateResultBean(objArray);
					year = main_month.toString();
					year = year.substring(0, 4) + "-04-01";
					year1 = String.valueOf(Integer.parseInt(main_month.toString().substring(0, 4)) + 1) + "-03-01";
					Date mmyyyy = new Date();
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar cal = Calendar.getInstance();
					if (main_month != null) {
						logger.info("main_month-->" + main_month + " year-->" + year + "year1-->" + year1);
					}
					if (month.toString().substring(0, 4) == main_month.toString().substring(0, 4)) {// month.year==main_month.year
						logger.info("month.year==main_month.year");
						mmyyyy = sdf.parse(year);// year
						cal.setTime(mmyyyy);
						mmyyyy = cal.getTime();
						mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);// year

						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");// year1
						Date year1_date = df.parse(year1);
						Calendar year1_cal = Calendar.getInstance();
						year1_cal.setTime(year1_date);

						Date main_month_date = df.parse(year1);
						Calendar main_month_cal = Calendar.getInstance();
						main_month_cal.setTime(main_month_date);

						logger.info("--year--" + mmyyyy);
						logger.info("--year1--" + year1_cal.getTime());
						if ((main_month_cal.getTime().after(mmyyyy) || mmyyyy.equals(main_month_cal.getTime()))
								&& (main_month_cal.getTime().before(year1_cal.getTime())
										|| main_month_cal.getTime().equals(year1_cal.getTime()))) {
							logger.info("--mmyyyy.after(_cal.getTime())--");
							mm_yyyy = month.toString();
						} else {
							mmyyyy = sdf.parse(month.toString());
							logger.info("--Inside success--");
							cal.setTime(mmyyyy);
							cal.add(Calendar.YEAR, 1);
							mmyyyy = cal.getTime();
							mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
						}

					} else {
						mmyyyy = sdf.parse(month.toString());
						logger.info("--Inside success--");
						cal.setTime(mmyyyy);
						cal.add(Calendar.YEAR, 1);
						mmyyyy = cal.getTime();
						mm_yyyy = new SimpleDateFormat("yyyy-MM-dd").format(mmyyyy);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			logger.info("--Month--" + mm_yyyy);
			Object[] objArray2 = new Object[2];
			objArray2[0] = mm_yyyy;
			objArray2[1] = request.getSession().getAttribute("CODE").toString().trim();

			SP_DDM_GST_1_COMM_TARGET_Result dt = new SP_DDM_GST_1_COMM_TARGET_Result();

			dt = sp_DDM_GST_1_DaoImpl.generateResultBeanSP_DDM_GST_1_COMM_TARGET_Result(objArray2);
			mv.addObject("model", dt);
			if (null != dt) {
				// ViewBag.button = "Update";
				// ViewBag.Message = "Record Updated";

				button = "Update";
				// Message = "Record Updated";
				mv.addObject("button", button);
				mv.addObject("Message", Message);
				logger.info("button-->" + button + " Message-->" + Message);
			} else {
				// ViewBag.button = "Upload";
				button = "Upload";
				mv.addObject("button", button);
				mv.addObject("Message", button);
				logger.info("--button--" + button);

			}
			// TempData["MM_YYYY"] = mm_yyyy;
			// return View("DDM-GST-1-TARGET", dt);

			mv.addObject("MM_YYYY", mm_yyyy);
			// request.getSession().setAttribute("MM_YYYY", mm_yyyy);
			mv.setViewName("GSTDDM/Insert/DDM-GST-1-TARGET");

			return mv;

		} else {
			request.getSession().invalidate();
			ModelAndView mv = new ModelAndView();

			mv.setViewName("GSTDDM/ResourceNotFound");
			mv.addObject("message", "");

			return mv;
		}

	}

	@SuppressWarnings("null")
	@RequestMapping(value = "/Insert/DDM_GST_1_TARGET", method = RequestMethod.POST)
	public ModelAndView DDM_GST_1_TARGET(
			@Valid @ModelAttribute("ddmGST1CommTarget") SP_DDM_GST_1_COMM_TARGET_Result ddmGST1CommTarget,
			BindingResult reslt, String btn_submit, String HDTokenNo, HttpServletRequest request) {

		if (request.getSession().getAttribute("CSRF_Token").toString()
				.equalsIgnoreCase(request.getParameter("request_CSRF_Token").toString())) {
			logger.info("Inside post DDM_GST_1--");
			logger.info("ddmGST1CommTarget--CENTRAL_TARGET" + ddmGST1CommTarget.TARGET_CGST);
			logger.info("ddmGST1CommTarget--STATEUT_TARGET" + ddmGST1CommTarget.TARGET_SGST);
			logger.info("ddmGST1CommTarget--INTEGRATED_TARGET" + ddmGST1CommTarget.TARGET_IGST);
			logger.info("ddmGST1CommTarget--CESS_TARGET" + ddmGST1CommTarget.TARGET_CESS);
			logger.info("ddmGST1CommTarget--MM_YYYY" + ddmGST1CommTarget.MM_YYYY);
			ModelAndView mv = new ModelAndView();
			
			logger.info("reslt.hasErrors()--"+reslt.hasErrors());

			/*
			 * if (reslt.hasErrors()) { logger.info("--Error--");
			 * mv.setViewName("GSTDDM/Insert/DDM-GST-1-TARGET"); return mv; } else {
			 */
			String button = "", Message = "";
			// HttpSession session=null;
			// String AuthTokenNo = (String)
			// request.getSession().getAttribute("AuthTokenNo");
			String COMM_CODE = (String) request.getSession().getAttribute("CODE");
			String MM_YYYY = ddmGST1CommTarget.MM_YYYY;
			Object[] objArray = new Object[6];
			// logger.info("HDTokenNo-->"+HDTokenNo+" btn_submit-->"+btn_submit+"
			// AuthTokenNo-->"+AuthTokenNo+" COMM_CODE-->"+COMM_CODE+" MM_YYYY-->"+MM_YYYY);
			// if(HDTokenNo==AuthTokenNo) {
			if (btn_submit.equalsIgnoreCase("Update") && (!reslt.hasErrors())) {
				objArray[0] = ddmGST1CommTarget.TARGET_CGST;
				objArray[1] = ddmGST1CommTarget.TARGET_SGST;
				objArray[2] = ddmGST1CommTarget.TARGET_IGST;
				objArray[3] = ddmGST1CommTarget.TARGET_CESS;
				objArray[4] = MM_YYYY;
				objArray[5] = COMM_CODE;
				int n;
				try {
					n = sp_DDM_GST_1_DaoImpl.generateResultBeanSP_DDM_GST_1_TARGET_UPDATE(objArray); // SP_DDM_GST_1_TARGET_UPDATE
					logger.info("--n-->" + n);
					// if(n>0) {
					Message = "Record Updated";
					button = "Update";
					mv.addObject("button", button);
					mv.addObject("ViewBagMessage", Message);
					logger.info("button-->" + button + " Message-->" + Message);
					// }
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (btn_submit.equalsIgnoreCase("Upload") && (!reslt.hasErrors())) {
				// COMM_CODE="05";
				objArray[0] = COMM_CODE;
				objArray[1] = MM_YYYY;
				objArray[2] = ddmGST1CommTarget.TARGET_CGST;
				objArray[3] = ddmGST1CommTarget.TARGET_SGST;
				objArray[4] = ddmGST1CommTarget.TARGET_IGST;
				objArray[5] = ddmGST1CommTarget.TARGET_CESS;

				// boolean isInserted=false;
				try {
					boolean isInserted = sp_DDM_GST_1_DaoImpl.generateResultBeanSP_DDM_GST_1_TARGET_INSERT(objArray); // SP_DDM_GST_1_TARGET_INSERT
					logger.info(" isInserted--" + isInserted);
					Message = "Record Inserted";
					button = "Update";
					mv.addObject("button", button);
					mv.addObject("ddmGST1CommTarget", ddmGST1CommTarget);
					mv.addObject("ViewBagMessage", Message);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			logger.info("--Month--" + MM_YYYY);
			Object[] objArray2 = new Object[2];
			objArray2[0] = MM_YYYY;
			objArray2[1] = COMM_CODE;

			SP_DDM_GST_1_COMM_TARGET_Result dt = new SP_DDM_GST_1_COMM_TARGET_Result();

			dt = sp_DDM_GST_1_DaoImpl.generateResultBeanSP_DDM_GST_1_COMM_TARGET_Result(objArray2);
			
			if (dt != null)
            {
            	mv.addObject("button", "Update");
            }
        	else
        	{
        		mv.addObject("button", "Upload");
        	}
			
			mv.addObject("model", dt);
			mv.addObject("MM_YYYY", MM_YYYY);
			mv.setViewName("GSTDDM/Insert/DDM-GST-1-TARGET");

			// }else {
			// request.getSession().invalidate();
			// mv.setViewName("/MIS/Home/login");
			// }

			// }
			return mv;

		} else {
			request.getSession().invalidate();
			ModelAndView mv = new ModelAndView();

			mv.setViewName("GSTDDM/ResourceNotFound");
			mv.addObject("message", "");

			return mv;
		}

	}

}
