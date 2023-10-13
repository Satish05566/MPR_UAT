package com.ddm.cbic.gstddm.service.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstddm.controller.GSTDDM_DDM_GST_1_Controller;
import com.ddm.cbic.gstddm.dao.GSTDDM_DDM_GST_1_Dao;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_ALL_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_COMM_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_COMM_TEMP_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_REGION_Result;
import com.ddm.cbic.gstddm.model.SP_DDM_GST_1_ZONE_Result;
import com.ddm.cbic.gstddm.service.GSTDDDM_DDM_GST_1_Service;

@Service
public class GSTDDM_DDM_GST_1_Service_Impl implements GSTDDDM_DDM_GST_1_Service {
	
	private static final Logger logger = LoggerFactory.getLogger(GSTDDM_DDM_GST_1_Controller.class);
	
	@Autowired
	GSTDDM_DDM_GST_1_Dao DDM_GST_1_dao;
	
	@Override
	              public ModelAndView get_DDM_GST_1(HttpServletRequest request) {
	            	  
	            	ModelAndView modelView = new ModelAndView();
		            Object  crr = request.getParameter("CRR");
		            String  mm_yyyy = request.getParameter("MM_YYYY");
		            String code = (String) request.getSession().getAttribute("CODE");
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
		                Object month = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_MAX_DATE(code);
		                if (month == null || month =="")
		                {
		                	mm_yyyy ="2017-07-01";
		                }
		                else
		                {
		                	LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1); 
		                	mm_yyyy = String.valueOf(date);
		                }
		            }
		            
		            SP_DDM_GST_1_COMM_TEMP_Result tempResult = new SP_DDM_GST_1_COMM_TEMP_Result();
		            tempResult = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_COMM_TEMP(code, mm_yyyy, crr,request);
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
	                modelView.addObject("ddmGst1CommTemp", new SP_DDM_GST_1_COMM_TEMP_Result());
	                modelView.setViewName("GSTDDM/Insert/DDM-GST-1");
	                return modelView;


		        }

	              public ModelAndView post_DDM_GST_1(@Valid SP_DDM_GST_1_COMM_TEMP_Result ddmGst1CommTemp,
							BindingResult reslt, HttpServletRequest request, String btn_submit, String HDTokenNo) {
				      
		      
	            	  				ModelAndView modelView  = new ModelAndView();
	            	  				if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo"))) {
	            	  					
	            	  				
											Object crr = request.getParameter("CRR");
											String mm_yyyy = request.getParameter("MM_YYYY");
											String code = (String) request.getSession().getAttribute("CODE");
											String result;
											
											logger.info("reslt.hasErrors()--"+reslt.hasErrors());										
											
											
						                    if (btn_submit.equals("Update") && (crr == null || crr == "") && (!reslt.hasErrors()))
						                    {
						                    	modelView.addObject("CRR", "");
						                        result = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_UPDATE(code, mm_yyyy, ddmGst1CommTemp.getMOVING_TARGET_CGST(), ddmGst1CommTemp.getMOVING_TARGET_SGST(), ddmGst1CommTemp.getMOVING_TARGET_IGST(), ddmGst1CommTemp.getMOVING_TARGET_CESS(),
						                        		                                                  ddmGst1CommTemp.getGROSS_TAX_CGST(), ddmGst1CommTemp.getGROSS_TAX_SGST(), ddmGst1CommTemp.getGROSS_TAX_IGST(), ddmGst1CommTemp.getGROSS_TAX_CESS(),
						                        		                                                  ddmGst1CommTemp.getREFUND_SANCTIONED_CGST(), ddmGst1CommTemp.getREFUND_SANCTIONED_SGST(), ddmGst1CommTemp.getREFUND_SANCTIONED_IGST(), ddmGst1CommTemp.getREFUND_SANCTIONED_CESS(),crr);
						                        modelView.addObject("ViewBagMessage", result);
						                        modelView.addObject("ViewBag_button", "Update");
						                    }
						                    else if (btn_submit.equals("Upload") && (crr == null || crr == "")&& (!reslt.hasErrors()) )
						                    {
						                    	modelView.addObject("CRR", "");
						                    	result = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_INSERT(code, mm_yyyy, ddmGst1CommTemp.getMOVING_TARGET_CGST(), ddmGst1CommTemp.getMOVING_TARGET_SGST(), ddmGst1CommTemp.getMOVING_TARGET_IGST(), ddmGst1CommTemp.getMOVING_TARGET_CESS(),
		                                                ddmGst1CommTemp.getGROSS_TAX_CGST(), ddmGst1CommTemp.getGROSS_TAX_SGST(), ddmGst1CommTemp.getGROSS_TAX_IGST(), ddmGst1CommTemp.getGROSS_TAX_CESS(),
		                                                ddmGst1CommTemp.getREFUND_SANCTIONED_CGST(), ddmGst1CommTemp.getREFUND_SANCTIONED_SGST(), ddmGst1CommTemp.getREFUND_SANCTIONED_IGST(), ddmGst1CommTemp.getREFUND_SANCTIONED_CESS());
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
						                    else if (btn_submit.equals("Submit") && !(crr == null || crr == "")&& (!reslt.hasErrors()) )
						                    {
						                    	modelView.addObject("CRR", "T");
						                        result = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_UPDATE(code, mm_yyyy, ddmGst1CommTemp.getMOVING_TARGET_CGST(), ddmGst1CommTemp.getMOVING_TARGET_SGST(), ddmGst1CommTemp.getMOVING_TARGET_IGST(), ddmGst1CommTemp.getMOVING_TARGET_CESS(),
		                                                ddmGst1CommTemp.getGROSS_TAX_CGST(), ddmGst1CommTemp.getGROSS_TAX_SGST(), ddmGst1CommTemp.getGROSS_TAX_IGST(), ddmGst1CommTemp.getGROSS_TAX_CESS(),
		                                                ddmGst1CommTemp.getREFUND_SANCTIONED_CGST(), ddmGst1CommTemp.getREFUND_SANCTIONED_SGST(), ddmGst1CommTemp.getREFUND_SANCTIONED_IGST(), ddmGst1CommTemp.getREFUND_SANCTIONED_CESS(),crr);
						                        modelView.addObject("ViewBagMessage", result);
						                    }		                    
						                   
						                    SP_DDM_GST_1_COMM_TEMP_Result tempResult = new SP_DDM_GST_1_COMM_TEMP_Result();
						                    tempResult = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_COMM_TEMP(code, mm_yyyy, crr,request);
						                    result = (String) request.getAttribute("result");
						                    
						                    if (tempResult != null)
					    		            {
					    		            	modelView.addObject("ViewBag_button", "Update");
					    		            }
					                    	else
					                    	{
					                    		modelView.addObject("ViewBag_button", "Upload");
					                    	}
						                   
						                        
						                        modelView.addObject("MM_YYYY", mm_yyyy);
						                    	modelView.addObject("model", tempResult);
						                    	modelView.addObject("DdmGst1CommTemp", new SP_DDM_GST_1_COMM_TEMP_Result());
						                    	modelView.setViewName("GSTDDM/Insert/DDM-GST-1");    
				                    	
	            	  				}
	            	  				
	            	  				else {
	            	  					request.getSession().invalidate();
	            	  					modelView.setViewName("GSTDDM/ResourceNotFound");
	            	  				}
				            
					return modelView;
		        }

				
				
		        
		       
		        public ModelAndView gstReport_DDM_GST_1(String report_type, String code, String report_name,
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
		            SP_DDM_GST_1_ALL_Result allResult = new SP_DDM_GST_1_ALL_Result();
		            SP_DDM_GST_1_REGION_Result regionResult = new SP_DDM_GST_1_REGION_Result();
		            SP_DDM_GST_1_ZONE_Result zoneResult = new SP_DDM_GST_1_ZONE_Result();
		            SP_DDM_GST_1_COMM_Result commResult = new SP_DDM_GST_1_COMM_Result();
		            SP_DDM_GST_1_COMM_TEMP_REPORT_Result tempResult = new SP_DDM_GST_1_COMM_TEMP_REPORT_Result();
		            
		    	
		    	
		             switch (report_type)
		             {
		                 case "All":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", report_name);
		                         allResult = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_ALL(mm_yyyy);
		                         modelView.addObject("Model",allResult);
		                         break;
		                     }
		                 case "Region":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "REGION : " + report_name);
		                         regionResult = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_REGION(mm_yyyy, code);
		                         modelView.addObject("Model",regionResult);       
		                         break;
		                     }


		                 case "Zone":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "ZONE : " + report_name);
		                         zoneResult = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_ZONE(mm_yyyy,code);
		                         modelView.addObject("Model",zoneResult); 
		                         break;
		                     }


		                 case "Comm":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONRATE : " + report_name);
		                         commResult = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_COMM(mm_yyyy, code);
		                         modelView.addObject("Model",commResult); 
		                         break;
		                     }


		                 case "Temp":
		                     {
		                          Object month = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_MAX_DATE(code);
		                         if (month == null || month == "")
		                         {
		                        	 mm_yyyy = "2017-07-01";
		                         }
		                         else
		                         {
		                        	 LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1); 
		                        	 mm_yyyy = String.valueOf(date);
		                         }
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONRATE : " + report_name);
		                         tempResult = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_COMM_TEMP_REPORT(mm_yyyy, code, null, null, null);
		                         modelView.addObject("Model",tempResult);
		                         break;
		                     }


		                 case "Crr":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONRATE : " + report_name);
		                         tempResult = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_COMM_TEMP_REPORT(mm_yyyy, code, "T", null, null);
		                         commResult = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_COMM(mm_yyyy, code);
		                         modelView.addObject("Model",tempResult);
		                         modelView.addObject("ViewBag_Report",commResult);
		                         break;
		                     }

		                 case "Bak":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONRATE : " + report_name);
		                         Object Submission_Date = null;
								tempResult = DDM_GST_1_dao.generateResult_SP_DDM_GST_1_COMM_TEMP_REPORT(mm_yyyy, code, null, "T", Submission_Date);
		                         modelView.addObject("Model",tempResult);
		                         break;
		                     }

		                 default:
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONRATE : " + report_name);
		                     }
		             }

		                modelView.setViewName("GSTDDM/Report/DDM-GST-1");
		    	        return modelView;
		    	        }

				
				



}
