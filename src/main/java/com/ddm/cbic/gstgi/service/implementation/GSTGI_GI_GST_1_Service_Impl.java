package com.ddm.cbic.gstgi.service.implementation;

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

import com.ddm.cbic.gstgi.controller.GSTGI_GI_GST_1_Controller;
import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_1A_Dao;
import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_1_Dao;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_ZONE_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1_ZONE_Result;
import com.ddm.cbic.gstgi.service.GSTGI_GI_GST_1_Service;

@Service
public class GSTGI_GI_GST_1_Service_Impl implements GSTGI_GI_GST_1_Service {
	
	private static final Logger logger = LoggerFactory.getLogger(GSTGI_GI_GST_1_Controller.class);
	
	@Autowired
	GSTGI_GI_GST_1_Dao GI_GST_1_dao;
	
	@Autowired
	GSTGI_GI_GST_1A_Dao GI_GST_1A_dao;
	
	@Override
	              public ModelAndView get_GI_GST_1(HttpServletRequest request) {
	            	  
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
		                Object month = GI_GST_1_dao.generateResult_SP_GI_GST_1_MAX_DATE(code);
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
		            
		            SP_GI_GST_1_COMM_TEMP_Result tempResult = new SP_GI_GST_1_COMM_TEMP_Result();
		            tempResult = GI_GST_1_dao.generateResult_SP_GI_GST_1_COMM_TEMP(code, mm_yyyy, crr,request);
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
	                modelView.addObject("giGst1CommTemp", new SP_GI_GST_1_COMM_TEMP_Result());
	                modelView.setViewName("GSTGI/Insert/GI-GST-1");
	                return modelView;


		        }

	              public ModelAndView post_GI_GST_1(@Valid SP_GI_GST_1_COMM_TEMP_Result giGst1CommTemp,
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
						                        result = GI_GST_1_dao.generateResult_SP_GI_GST_1_UPDATE(code, mm_yyyy, 
						                        		  giGst1CommTemp.getDETECTION_CGST_NO(), giGst1CommTemp.getDETECTION_CGST_AMT(), 
						                        		  giGst1CommTemp.getDETECTION_SGST_AMT(), giGst1CommTemp.getDETECTION_IGST_AMT(), 
						                        		  giGst1CommTemp.getDETECTION_CESS_AMT(), giGst1CommTemp.getDETECTION_CGST_NO_PRE(),
		                                                  giGst1CommTemp.getDETECTION_CGST_AMT_PRE(),giGst1CommTemp.getDETECTION_SGST_AMT_PRE(),
		                                                  giGst1CommTemp.getDETECTION_IGST_AMT_PRE(),giGst1CommTemp.getDETECTION_CESS_AMT_PRE(),
						                        		  giGst1CommTemp.getREALISATION_CGST_NO(), giGst1CommTemp.getREALISATION_CGST_AMT(), 
						                        		  giGst1CommTemp.getREALISATION_SGST_AMT(), giGst1CommTemp.getREALISATION_IGST_AMT(), 
						                        		  giGst1CommTemp.getREALISATION_CESS_AMT(), giGst1CommTemp.getREALISATION_CGST_NO_PRE(),
		                                                  giGst1CommTemp.getREALISATION_CGST_AMT_PRE(),giGst1CommTemp.getREALISATION_SGST_AMT_PRE(),
		                                                  giGst1CommTemp.getREALISATION_IGST_AMT_PRE(),giGst1CommTemp.getREALISATION_CESS_AMT_PRE(),crr);
						                        modelView.addObject("ViewBagMessage", result);
						                        modelView.addObject("ViewBag_button", "Update");
						                    }
						                    else if (btn_submit.equals("Upload") && (crr == null || crr == "")&& (!reslt.hasErrors()) )
						                    {
						                    	modelView.addObject("CRR", "");
						                    	result = GI_GST_1_dao.generateResult_SP_GI_GST_1_INSERT(code, mm_yyyy, 
						                    			giGst1CommTemp.getDETECTION_CGST_NO(), giGst1CommTemp.getDETECTION_CGST_AMT(), 
						                        		  giGst1CommTemp.getDETECTION_SGST_AMT(), giGst1CommTemp.getDETECTION_IGST_AMT(), 
						                        		  giGst1CommTemp.getDETECTION_CESS_AMT(), giGst1CommTemp.getDETECTION_CGST_NO_PRE(),
		                                                  giGst1CommTemp.getDETECTION_CGST_AMT_PRE(),giGst1CommTemp.getDETECTION_SGST_AMT_PRE(),
		                                                  giGst1CommTemp.getDETECTION_IGST_AMT_PRE(),giGst1CommTemp.getDETECTION_CESS_AMT_PRE(),
						                        		  giGst1CommTemp.getREALISATION_CGST_NO(), giGst1CommTemp.getREALISATION_CGST_AMT(), 
						                        		  giGst1CommTemp.getREALISATION_SGST_AMT(), giGst1CommTemp.getREALISATION_IGST_AMT(), 
						                        		  giGst1CommTemp.getREALISATION_CESS_AMT(), giGst1CommTemp.getREALISATION_CGST_NO_PRE(),
		                                                  giGst1CommTemp.getREALISATION_CGST_AMT_PRE(),giGst1CommTemp.getREALISATION_SGST_AMT_PRE(),
		                                                  giGst1CommTemp.getREALISATION_IGST_AMT_PRE(),giGst1CommTemp.getREALISATION_CESS_AMT_PRE());
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
						                        result = GI_GST_1_dao.generateResult_SP_GI_GST_1_UPDATE(code, mm_yyyy, giGst1CommTemp.getDETECTION_CGST_NO(), 
						                        		  giGst1CommTemp.getDETECTION_CGST_AMT(), 
						                        		  giGst1CommTemp.getDETECTION_SGST_AMT(), giGst1CommTemp.getDETECTION_IGST_AMT(), 
						                        		  giGst1CommTemp.getDETECTION_CESS_AMT(), giGst1CommTemp.getDETECTION_CGST_NO_PRE(),
		                                                  giGst1CommTemp.getDETECTION_CGST_AMT_PRE(),giGst1CommTemp.getDETECTION_SGST_AMT_PRE(),
		                                                  giGst1CommTemp.getDETECTION_IGST_AMT_PRE(),giGst1CommTemp.getDETECTION_CESS_AMT_PRE(),
		                                                  giGst1CommTemp.getREALISATION_CGST_NO(),giGst1CommTemp.getREALISATION_CGST_AMT(), 
		                                                  giGst1CommTemp.getREALISATION_SGST_AMT(), giGst1CommTemp.getREALISATION_IGST_AMT(), 
		                                                  giGst1CommTemp.getREALISATION_CESS_AMT(),giGst1CommTemp.getREALISATION_CGST_NO_PRE(),
		                                                  giGst1CommTemp.getREALISATION_CGST_AMT_PRE(),giGst1CommTemp.getREALISATION_CGST_AMT_PRE(),
		                                                  giGst1CommTemp.getREALISATION_CGST_AMT_PRE(),giGst1CommTemp.getREALISATION_CGST_AMT_PRE(),crr);
						                        modelView.addObject("ViewBagMessage", result);
						                    }		                    
						                   
						                    SP_GI_GST_1_COMM_TEMP_Result tempResult = new SP_GI_GST_1_COMM_TEMP_Result();
						                    tempResult = GI_GST_1_dao.generateResult_SP_GI_GST_1_COMM_TEMP(code, mm_yyyy, crr,request);
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
						                    	modelView.addObject("GiGst1CommTemp", new SP_GI_GST_1_COMM_TEMP_Result());
						                    	modelView.setViewName("GSTGI/Insert/GI-GST-1");    
				                    	
	            	  				}
	            	  				
	            	  				else {
	            	  					request.getSession().invalidate();
	            	  					modelView.setViewName("GSTGI/ResourceNotFound");
	            	  				}
				            
					return modelView;
		        }

				
				
		        
		       
		        public ModelAndView gstReport_GI_GST_1(String report_type, String code, String report_name,
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
		            SP_GI_GST_1_ALL_Result allResult = new SP_GI_GST_1_ALL_Result();
		            SP_GI_GST_1_REGION_Result regionResult = new SP_GI_GST_1_REGION_Result();
		            SP_GI_GST_1_ZONE_Result zoneResult = new SP_GI_GST_1_ZONE_Result();
		            SP_GI_GST_1_COMM_Result commResult = new SP_GI_GST_1_COMM_Result();
		            SP_GI_GST_1_COMM_TEMP_REPORT_Result tempResult = new SP_GI_GST_1_COMM_TEMP_REPORT_Result();
		            SP_GI_GST_1A_ALL_Result allResultA = new SP_GI_GST_1A_ALL_Result();
		            SP_GI_GST_1A_REGION_Result regionResultA = new SP_GI_GST_1A_REGION_Result();
		            SP_GI_GST_1A_ZONE_Result zoneResultA = new SP_GI_GST_1A_ZONE_Result();
		            SP_GI_GST_1A_COMM_Result commResultA = new SP_GI_GST_1A_COMM_Result();
		            SP_GI_GST_1A_COMM_TEMP_REPORT_Result tempResultA = new SP_GI_GST_1A_COMM_TEMP_REPORT_Result();
		    	
		    	
		             switch (report_type)
		             {
		                 case "All":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", report_name);
		                         allResult = GI_GST_1_dao.generateResult_SP_GI_GST_1_ALL(mm_yyyy);
		                         modelView.addObject("Model",allResult);
		                         allResultA = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_ALL(mm_yyyy);
		                         modelView.addObject("ModelA",allResultA);
		                         break;
		                     }
		                 case "Region":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "REGION : " + report_name);
		                         regionResult = GI_GST_1_dao.generateResult_SP_GI_GST_1_REGION(mm_yyyy, code);
		                         modelView.addObject("Model",regionResult);   
		                         regionResultA = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_REGION(mm_yyyy, code);
		                         modelView.addObject("ModelA",regionResultA);
		                         break;
		                     }


		                 case "Zone":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "ZONE : " + report_name);
		                         zoneResult = GI_GST_1_dao.generateResult_SP_GI_GST_1_ZONE(mm_yyyy,code);
		                         modelView.addObject("Model",zoneResult); 
		                         zoneResultA = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_ZONE(mm_yyyy,code);
		                         modelView.addObject("ModelA",zoneResultA); 
		                         break;
		                     }


		                 case "Comm":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         commResult = GI_GST_1_dao.generateResult_SP_GI_GST_1_COMM(mm_yyyy, code);
		                         modelView.addObject("Model",commResult); 
		                         commResultA = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_COMM(mm_yyyy, code);
		                         modelView.addObject("ModelA",commResultA);
		                         break;
		                     }


		                 case "Temp":
		                     {
		                          Object month = GI_GST_1_dao.generateResult_SP_GI_GST_1_MAX_DATE(code);
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
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         tempResult = GI_GST_1_dao.generateResult_SP_GI_GST_1_COMM_TEMP_REPORT(mm_yyyy, code, null, null, null);
		                         modelView.addObject("Model",tempResult);
		                         tempResultA = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_COMM_TEMP_REPORT(mm_yyyy, code, null, null, null);
		                         modelView.addObject("ModelA",tempResultA);
		                         break;
		                     }


		                 case "Crr":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         tempResult = GI_GST_1_dao.generateResult_SP_GI_GST_1_COMM_TEMP_REPORT(mm_yyyy, code, "T", null, null);
		                         commResult = GI_GST_1_dao.generateResult_SP_GI_GST_1_COMM(mm_yyyy, code);
		                         modelView.addObject("Model",tempResult);
		                         modelView.addObject("ViewBag_Report",commResult);
		                         tempResultA = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_COMM_TEMP_REPORT(mm_yyyy, code, "T", null, null);
		                         commResultA = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_COMM(mm_yyyy, code);
		                         modelView.addObject("ModelA",tempResultA);
		                         modelView.addObject("ViewBag_Report",commResultA);
		                         break;
		                     }

		                 case "Bak":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         Object Submission_Date = null;
								 tempResult = GI_GST_1_dao.generateResult_SP_GI_GST_1_COMM_TEMP_REPORT(mm_yyyy, code, null, "T", Submission_Date);
		                         modelView.addObject("Model",tempResult);
		                         tempResultA = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_COMM_TEMP_REPORT(mm_yyyy, code, null, "T", Submission_Date);
		                         modelView.addObject("ModelA",tempResultA);
		                         break;
		                     }

		                 default:
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                     }
		             }

		                modelView.setViewName("GSTGI/Report/GI-GST-1");
		    	        return modelView;
		    	        }

				
				



}
