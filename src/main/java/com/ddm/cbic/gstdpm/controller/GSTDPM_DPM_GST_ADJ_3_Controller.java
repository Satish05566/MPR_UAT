package com.ddm.cbic.gstdpm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.wink.json4j.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_ADJ_3_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_ADJ_3_Service;
import com.ddm.cbic.gstdpm.dao.implementation.GSTDPM_DPM_GST_ADJ_3_DaoImpl;
import com.google.gson.Gson;
//import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;


@Controller
@RequestMapping("/GSTDPM")
public class GSTDPM_DPM_GST_ADJ_3_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(GSTDPM_DPM_GST_ADJ_3_Controller.class);

	@Autowired
	 GSTDPM_DPM_GST_ADJ_3_Service gstdpm_DPM_GST_ADJ_3_Service; 

	 @Autowired
	private GSTDPM_DPM_GST_ADJ_3_DaoImpl gstDPM_DPM_GST_ADJ_3_DaoImpl;

		 @RequestMapping(value = "/Report/DPM_GST_ADJ_3/{Report_Type}/{Code}/{Report_Name}/{YYYY-MMM}/{request_CSRF_Token}", 
				 method = RequestMethod.GET)
	 	public ModelAndView getReport_DPM_GST_ADJ_3(@PathVariable("Report_Type") String report_type, 
		@PathVariable("Code") String code,
		@PathVariable("Report_Name") String report_name,
		@PathVariable("YYYY-MMM") String mm_yyyy ,
		HttpServletRequest request ,
		@PathVariable("request_CSRF_Token") String request_CSRF_Token, 
		String Submission_Date) {	     	
			
	 		if(request_CSRF_Token != null)
	 		{
	 			
	 		  return gstdpm_DPM_GST_ADJ_3_Service.gstReport_DPM_GST_ADJ_3(report_type,code,report_name,
			  request,mm_yyyy,request_CSRF_Token);
			 
	 		}
	 		else
	 		{
	 			return null;
	 		}	 		
	  }
		 
		 @RequestMapping(value = "/Insert/DPM_GST_ADJ_3/{request_CSRF_Token}", method = RequestMethod.GET)
			public ModelAndView get_DPM_GST_ADJ_3(Model model, HttpServletRequest request,
					@PathVariable("request_CSRF_Token") String request_CSRF_Token) {

			 
				ModelAndView postDdmAdj3modelView = new ModelAndView();
				postDdmAdj3modelView = gstdpm_DPM_GST_ADJ_3_Service.get_DPM_GST_ADJ_3(model, request, request_CSRF_Token);
				return postDdmAdj3modelView;
			}

			@RequestMapping(value = "/Insert/DPM_GST_ADJ_3", method = RequestMethod.POST)
			public ModelAndView post_DPM_GST_ADJ_3(@Valid @ModelAttribute("DpmGstAdj3CommTemp") SP_DPM_GST_ADJ_3_COMM_TEMP_Result dpmGstAdj3CommTemp,
					BindingResult reslt, Model model, HttpServletRequest request, String btn_submit, String HDTokenNo) {

				ModelAndView postDdmAdj3modelView = new ModelAndView();
				postDdmAdj3modelView = gstdpm_DPM_GST_ADJ_3_Service.post_DPM_GST_ADJ_3(dpmGstAdj3CommTemp, reslt, model, request, btn_submit,HDTokenNo);

				return postDdmAdj3modelView;
			}


			@RequestMapping(value = "/Insert/DPM_GST_ADJ_3_OPENING_INSERT", method = RequestMethod.POST)
			public ModelAndView post_DPM_GST_ADJ_3_OPENING_INSERT(@RequestBody @Valid 
			 @ModelAttribute("gIGstCommTemp1") SP_DPM_GST_ADJ_3_COMM_TEMP_Result dpmGstAdj3CommTemp1,
			 BindingResult reslt,
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
			HttpServletRequest request, String btn_submit, String HDTokenNoOpening,String MM_YYYY) {
					
			logger.info("welcome-Appeals_ADC_OPENING_NO="+Appeals_ADC_OPENING_NO);	
			ModelAndView postDdmAdj3modelView = new ModelAndView();		
			
			postDdmAdj3modelView = gstdpm_DPM_GST_ADJ_3_Service.post_DPM_GST_ADJ_3_OPENING_INSERT(
			reslt,
			 Appeals_ADC_OPENING_NO, Appeals_ADC_OPENING_AMT,
			 Appeals_DC_OPENING_NO, Appeals_DC_OPENING_AMT,
			 Appeals_SUP_OPENING_NO,Appeals_SUP_OPENING_AMT,
			
			 Injunction_ADC_OPENING_NO, Injunction_ADC_OPENING_AMT,
			 Injunction_DC_OPENING_NO, Injunction_DC_OPENING_AMT,
			 Injunction_SUP_OPENING_NO, Injunction_SUP_OPENING_AMT,
			
			 CAG_ADC_OPENING_NO, CAG_ADC_OPENING_AMT,
			 CAG_DC_OPENING_NO, CAG_DC_OPENING_AMT,
			 CAG_SUP_OPENING_NO, CAG_SUP_OPENING_AMT,
			
			 Board_ADC_OPENING_NO, Board_ADC_OPENING_AMT,
			 Board_DC_OPENING_NO, Board_DC_OPENING_AMT,
			 Board_SUP_OPENING_NO, Board_SUP_OPENING_AMT,
			 request, btn_submit, HDTokenNoOpening,MM_YYYY);

			return postDdmAdj3modelView;
		}



	@RequestMapping(value = "CallbookRegionListBind", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject CallbookRegionListBind(HttpServletRequest request, HttpServletResponse response, 
	String MM_YYYY) {

		ModelAndView mv = new ModelAndView();
		logger.info("in callbookRegionListResult");
		String COMM_CODE = (String) request.getSession().getAttribute("CODE");
		logger.info("in BranchBind action CODE---3--" + COMM_CODE);
		List<SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result> identifierListResult = new ArrayList<SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result>();
		identifierListResult = gstDPM_DPM_GST_ADJ_3_DaoImpl.get_DPM_GST_ADJ_3_REGION_LIST(COMM_CODE,MM_YYYY);

//		if (identifierListResult != null) {
//
//			for (int i = 0; i < identifierListResult.size(); i++) {
//
//				//logger.info("Result object---" + branchListResult.get(i).getBRANCH_CODE());
//				//logger.info("Result object---" + branchListResult.get(i).getBRANCH_NAME());
//			}
//		}

		mv.addObject("callbookRegionListResult", identifierListResult);
		String json = null;
		try {
			Gson gson = new Gson();
			json = new Gson().toJson(identifierListResult);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// logger.info("--branchListResult--"+json);
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("JSONdata", json);
			// logger.info("branchListResult in JSONdata" + jsonObject.get("JSONdata"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject;

	}
	
}