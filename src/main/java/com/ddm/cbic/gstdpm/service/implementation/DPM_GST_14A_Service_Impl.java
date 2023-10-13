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

import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_14A_Dao;
import com.ddm.cbic.gstdpm.dao.GSTDPM_DPM_GST_14B_Dao;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14A_ZONE_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_ALL_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_COMM_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_REGION_Result;
import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_ZONE_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_14A_Service;

@Service
public class DPM_GST_14A_Service_Impl implements GSTDPM_DPM_GST_14A_Service {
	
	@Autowired
	GSTDPM_DPM_GST_14A_Dao dpm_gst_14a_dao;
	
	@Autowired
	GSTDPM_DPM_GST_14B_Dao dpm_gst_14b_dao;
	
	 
	              public ModelAndView get_DPM_GST_14A(HttpServletRequest request) {
       
		            Object  crr = request.getParameter("CRR");
		            String  mm_yyyy = request.getParameter("MM_YYYY");
		            String code = (String) request.getSession().getAttribute("CODE");
		            ModelAndView modelView = new ModelAndView();
		            String result;


		            if (!(crr == null || crr == "") && !(mm_yyyy == null || mm_yyyy == ""))
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
		                    modelView.addObject("CRR", "T");
		            }
		            else
		            {
		            	modelView.addObject("CRR", "");
		                Object month = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_MAX_DATE(code);
		                if (month == null || month =="")
		                {
		                	mm_yyyy = "2022-04-01";
		                }
		                else
		                {
		                	LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1); 
		                	mm_yyyy = String.valueOf(date);
		                }
		            }

		            SP_DPM_GST_14A_COMM_TEMP_Result tempResult = new SP_DPM_GST_14A_COMM_TEMP_Result();
		            tempResult = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_COMM_TEMP(code, mm_yyyy, crr,request);
		            result = (String) request.getAttribute("result");
		            
		            
		            if (tempResult != null && result.equals("TEMP") )
		            {
		            	modelView.addObject("ViewBag_button", "Update");
		            }
		            else if (tempResult == null && result.equals("MAIN"))
		            {
		            	modelView.setViewName("correction-message");
		                return modelView;		                
		            }
		            else if (tempResult == null && (!result.equals("MAIN") || !result.equals("CRR")))
		            {
		            	modelView.addObject("ViewBag_button", "Upload");

		            }
		            else if (tempResult != null && result.equals("CRR") )
		            {
		            	modelView.addObject("ViewBagMessage", "CORRECTION REQUEST SUBMITTED");
		            }
		            modelView.addObject("MM_YYYY", mm_yyyy);
	                modelView.addObject("model", tempResult);
	                modelView.addObject("dpmGst14ACommTemp", new SP_DPM_GST_14A_COMM_TEMP_Result());
	                modelView.setViewName("GSTDPM/Insert/DPM-GST-14A");
	                return modelView;


		        }

				public ModelAndView post_DPM_GST_14A(@ModelAttribute("dpmGst14ACommTemp") SP_DPM_GST_14A_COMM_TEMP_Result dpmGst14ACommTemp,BindingResult reslt, HttpServletRequest request, String btn_submit) {
				      
		      
		        	ModelAndView modelView  = new ModelAndView();
					  
									Object crr = request.getParameter("CRR");
									String mm_yyyy = request.getParameter("MM_YYYY");
									String code = (String) request.getSession().getAttribute("CODE");
									String result = null;
				                   
				                    if (btn_submit.equals("Update") )
				                    {
				                    	modelView.addObject("CRR", "");
				                       result = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_UPDATE(code, mm_yyyy, dpmGst14ACommTemp.getOPENING_BALANCE(), dpmGst14ACommTemp.getNO_OF_ARN_RECEIVED_GSTN(), dpmGst14ACommTemp.getNO_OF_ARN_RECEIVED_CPC(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_WITHIN_7(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_RECOMMENDED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_APPROVED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_REJECTED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_NOT_RECEIVED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_TRANSFERED_CPC(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_DEEMED_REG(),crr);
				                        modelView.addObject("ViewBagMessage", result);
				                        modelView.addObject("ViewBag_button", "Update");
				                    }
				                    else if (btn_submit.equals("Upload") )
				                    {
				                    	modelView.addObject("CRR", "");
				                    	result = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_INSERT(code, mm_yyyy, dpmGst14ACommTemp.getOPENING_BALANCE(), dpmGst14ACommTemp.getNO_OF_ARN_RECEIVED_GSTN(), dpmGst14ACommTemp.getNO_OF_ARN_RECEIVED_CPC(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_WITHIN_7(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_RECOMMENDED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_APPROVED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_REJECTED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_NOT_RECEIVED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_TRANSFERED_CPC(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_DEEMED_REG());
				                    	modelView.addObject("ViewBagMessage", result);
				                        if (result.equals("RECORD SUBMITTED") )
				                        {
				                        	modelView.addObject("ViewBag_button", "Update");
				                        }
				                        else
				                        {
				                        	modelView.addObject("ViewBag_button", "Upload");
				                        }

				                    }
				                    else if (btn_submit.equals("Submit") )
				                    {
				                    	modelView.addObject("CRR", "T");
				                        result = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_UPDATE(code, mm_yyyy, dpmGst14ACommTemp.getOPENING_BALANCE(), dpmGst14ACommTemp.getNO_OF_ARN_RECEIVED_GSTN(), dpmGst14ACommTemp.getNO_OF_ARN_RECEIVED_CPC(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_WITHIN_7(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_RECOMMENDED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_APPROVED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_REJECTED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_PV_NOT_RECEIVED(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_TRANSFERED_CPC(), dpmGst14ACommTemp.getDISPOSAL_OF_ARN_DEEMED_REG(),crr);
				                        if (result.equals("CORRECTION REQUEST SUBMITTED") )
				                        {
				                        	modelView.addObject("ViewBagMessage", result);
				                        }
				                        else if(result.equals("INCOMPLETE CORRECTION REQUEST"))
					                    {
					                    	 LocalDate date = LocalDate.parse(String.valueOf(mm_yyyy)).plusMonths(1); 
					                    	 mm_yyyy = String.valueOf(date);                 	                                         
					                    }
					                    else
					                    {
					                        modelView.addObject("ViewBagMessage", result);

					                    }
				                    }
				                    
				                   
				                    SP_DPM_GST_14A_COMM_TEMP_Result tempResult = new SP_DPM_GST_14A_COMM_TEMP_Result();
				                    tempResult = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_COMM_TEMP(code, mm_yyyy, crr,request);
				                    result = (String) request.getAttribute("result");
			                        
				                        modelView.addObject("MM_YYYY", mm_yyyy);
				                    	modelView.addObject("model", tempResult);
				                    	modelView.addObject("dpmGst14ACommTemp", new SP_DPM_GST_14A_COMM_TEMP_Result());
				                    	modelView.setViewName("GSTDPM/Insert/DPM-GST-14A");       
					return modelView;
		        }

				
				
		        
		       
		        public ModelAndView gstReport_DPM_GST_14A(String report_type, String code, String report_name,
		    			HttpServletRequest request, String mm_yyyy) {
		        	
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
		            
		            SP_DPM_GST_14A_ALL_Result allResultA = new SP_DPM_GST_14A_ALL_Result();
		            SP_DPM_GST_14A_REGION_Result regionResultA = new SP_DPM_GST_14A_REGION_Result();
		            SP_DPM_GST_14A_ZONE_Result zoneResultA = new SP_DPM_GST_14A_ZONE_Result();
		            SP_DPM_GST_14A_COMM_Result commResultA = new SP_DPM_GST_14A_COMM_Result();
		            SP_DPM_GST_14A_COMM_TEMP_REPORT_Result tempResultA = new SP_DPM_GST_14A_COMM_TEMP_REPORT_Result();
		            
		            SP_DPM_GST_14B_ALL_Result allResultB = new SP_DPM_GST_14B_ALL_Result();
		            SP_DPM_GST_14B_REGION_Result regionResultB = new SP_DPM_GST_14B_REGION_Result();
		            SP_DPM_GST_14B_ZONE_Result zoneResultB = new SP_DPM_GST_14B_ZONE_Result();
		            SP_DPM_GST_14B_COMM_Result commResultB = new SP_DPM_GST_14B_COMM_Result();
		            SP_DPM_GST_14B_COMM_TEMP_REPORT_Result tempResultB = new SP_DPM_GST_14B_COMM_TEMP_REPORT_Result();
		        
		             switch (report_type)
		             {
		                 case "All":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", report_name);
		                         allResultA = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_ALL(mm_yyyy);
		                         modelView.addObject("modelA",allResultA);
		                         allResultB = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_ALL(mm_yyyy);
		                         modelView.addObject("modelB",allResultB);
		                         break;
		                     }
		                 case "Region":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "REGION : " + report_name);
		                         regionResultA = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_REGION(code, mm_yyyy);
		                         modelView.addObject("modelA",regionResultA); 
		                         regionResultB = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_REGION(code, mm_yyyy);
		                         modelView.addObject("modelB",regionResultB);   
		                         break;
		                     }
		                 case "Zone":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "ZONE : " + report_name);
		                         zoneResultA = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_ZONE(code, mm_yyyy);
		                         modelView.addObject("modelA",zoneResultA); 
		                         zoneResultB = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_ZONE(code, mm_yyyy);
		                         modelView.addObject("modelB",zoneResultB); 
		                         break;
		                     }
		                 case "Comm":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         commResultA = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_COMM(code, mm_yyyy);
		                         modelView.addObject("modelA",commResultA); 
		                         commResultB = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_COMM(code, mm_yyyy);
		                         modelView.addObject("modelB",commResultB); 
		                         break;
		                     }
		                 case "Temp":
		                     {
		                          Object month = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_MAX_DATE(code);
		                         if (month == null || month == "")
		                         {
		                        	 mm_yyyy = "2022-04-01";
		                         }
		                         else
		                         {
		                        	 LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1); 
		                        	 mm_yyyy = String.valueOf(date);
		                         }
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         tempResultA = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_COMM_TEMP_REPORT(code, mm_yyyy, null, null, null);
		                         modelView.addObject("modelA",tempResultA);
		                         tempResultB = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_COMM_TEMP_REPORT(code, mm_yyyy, null, null, null);
		                         modelView.addObject("modelB",tempResultB);
		                         break;
		                     }


		                 case "Crr":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         tempResultA = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_COMM_TEMP_REPORT(code, mm_yyyy, "T", null, null);
		                         commResultA = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_COMM(code, mm_yyyy);
		                         modelView.addObject("modelA",tempResultA);
		                         modelView.addObject("ViewBag_ReportA",commResultA);
		                         tempResultB = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_COMM_TEMP_REPORT(code, mm_yyyy, "T", null, null);
		                         commResultB = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_COMM(code, mm_yyyy);
		                         modelView.addObject("modelB",tempResultB);
		                         modelView.addObject("ViewBag_ReportB",commResultB);
		                         break;
		                     }

		                 case "Bak":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         Object Submission_Date = null;
								 tempResultA = dpm_gst_14a_dao.generateResult_SP_DPM_GST_14A_COMM_TEMP_REPORT(code, mm_yyyy, null, "T", Submission_Date);
		                         modelView.addObject("modelA",tempResultA);
		                         tempResultB = dpm_gst_14b_dao.generateResult_SP_DPM_GST_14B_COMM_TEMP_REPORT(code, mm_yyyy, null, "T", Submission_Date);
		                         modelView.addObject("modelB",tempResultB);
		                         break;
		                     }

		                 default:
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                     }
		             }

		                modelView.setViewName("GSTDPM/Report/DPM-GST-14");
		    	        return modelView;
		    	        }

				




}
