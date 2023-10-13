package com.ddm.cbic.gstgst.service.implementation;

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

import com.ddm.cbic.gstgst.dao.GST_GST_2_Dao;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_ALL_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_COMM_TEMP_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_REGION_Result;
import com.ddm.cbic.gstgst.model.SP_GST_GST_2_ZONE_Result;
import com.ddm.cbic.gstgst.service.GST_GST_2_Service;

@Service
public class GST_GST_2_Service_Impl implements GST_GST_2_Service{
	
	
	@Autowired
	GST_GST_2_Dao gst_gst_2_dao;
	
	
	 
	              public ModelAndView get_GST_GST_2(HttpServletRequest request) {
       
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
		                Object month = gst_gst_2_dao.generateResult_SP_GST_GST_2_MAX_DATE(code);
		                if (month == null || month =="")
		                {
		                	mm_yyyy = "2017-07-01";
		                }
		                else
		                {
		                	LocalDate date = LocalDate.parse(String.valueOf(month)).plusMonths(1); 
		                	mm_yyyy = String.valueOf(date);
		                }
		            }

		            SP_GST_GST_2_COMM_TEMP_Result tempResult = new SP_GST_GST_2_COMM_TEMP_Result();
		            tempResult = gst_gst_2_dao.generateResult_SP_GST_GST_2_COMM_TEMP(code, mm_yyyy, crr,request);
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
	                modelView.addObject("gstGst2CommTemp", new SP_GST_GST_2_COMM_TEMP_Result());
	                modelView.setViewName("GSTGST/Insert/GST-GST-2");
	                return modelView;


		        }

				public ModelAndView post_GST_GST_2(@ModelAttribute("gstGst2CommTemp") SP_GST_GST_2_COMM_TEMP_Result gstGst2CommTemp,
						BindingResult reslt, HttpServletRequest request, String btn_submit) {
				      
		      
		        	ModelAndView modelView  = new ModelAndView();
					  
									Object crr = request.getParameter("CRR");
									String mm_yyyy = request.getParameter("MM_YYYY");
									String code = (String) request.getSession().getAttribute("CODE");
									String result = null;
				                   
				                    if (btn_submit.equals("Update") )
				                    {
				                    	modelView.addObject("CRR", "");
				                       result = gst_gst_2_dao.generateResult_SP_GST_GST_2_UPDATE(code, mm_yyyy, gstGst2CommTemp.getGSTR_1M_F(), gstGst2CommTemp.getGSTR_3BM_F(), gstGst2CommTemp.getGSTR_1Q_F(), gstGst2CommTemp.getGSTR_3BQ_F(), 
				                    	gstGst2CommTemp.getGST_CMP_08_F(), gstGst2CommTemp.getGSTR_4_F(), gstGst2CommTemp.getGSTR_9_F(), gstGst2CommTemp.getGSTR_9A_F(), 
				                    	gstGst2CommTemp.getGSTR_9C_F(), gstGst2CommTemp.getGSTR_1M_D(), gstGst2CommTemp.getGSTR_3BM_D(), gstGst2CommTemp.getGSTR_1Q_D(), 
				                    	gstGst2CommTemp.getGSTR_3BQ_D(), gstGst2CommTemp.getGST_CMP_08_D(), gstGst2CommTemp.getGSTR_4_D(), gstGst2CommTemp.getGSTR_9_D(), 
				                    	gstGst2CommTemp.getGSTR_9A_D(), gstGst2CommTemp.getGSTR_9C_D(), gstGst2CommTemp.getGSTR_3A_I(), gstGst2CommTemp.getGSTR_3A_NI(), crr);
				                        modelView.addObject("ViewBagMessage", result);
				                        modelView.addObject("ViewBag_button", "Update");
				                    }
				                    else if (btn_submit.equals("Upload") )
				                    {
				                    	modelView.addObject("CRR", "");
				                    	result = gst_gst_2_dao.generateResult_SP_GST_GST_2_INSERT(code, mm_yyyy, gstGst2CommTemp.getGSTR_1M_F(), gstGst2CommTemp.getGSTR_3BM_F(), gstGst2CommTemp.getGSTR_1Q_F(), gstGst2CommTemp.getGSTR_3BQ_F(), 
				                    	gstGst2CommTemp.getGST_CMP_08_F(), gstGst2CommTemp.getGSTR_4_F(), gstGst2CommTemp.getGSTR_9_F(), gstGst2CommTemp.getGSTR_9A_F(), 
				                    	gstGst2CommTemp.getGSTR_9C_F(), gstGst2CommTemp.getGSTR_1M_D(), gstGst2CommTemp.getGSTR_3BM_D(), gstGst2CommTemp.getGSTR_1Q_D(), 
				                    	gstGst2CommTemp.getGSTR_3BQ_D(), gstGst2CommTemp.getGST_CMP_08_D(), gstGst2CommTemp.getGSTR_4_D(), gstGst2CommTemp.getGSTR_9_D(), 
				                    	gstGst2CommTemp.getGSTR_9A_D(), gstGst2CommTemp.getGSTR_9C_D(), gstGst2CommTemp.getGSTR_3A_I(), gstGst2CommTemp.getGSTR_3A_NI());
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
				                        result = gst_gst_2_dao.generateResult_SP_GST_GST_2_UPDATE(code, mm_yyyy, gstGst2CommTemp.getGSTR_1M_F(), gstGst2CommTemp.getGSTR_3BM_F(), gstGst2CommTemp.getGSTR_1Q_F(), gstGst2CommTemp.getGSTR_3BQ_F(), 
				                        		gstGst2CommTemp.getGST_CMP_08_F(), gstGst2CommTemp.getGSTR_4_F(), gstGst2CommTemp.getGSTR_9_F(), gstGst2CommTemp.getGSTR_9A_F(), 
				                        		gstGst2CommTemp.getGSTR_9C_F(), gstGst2CommTemp.getGSTR_1M_D(), gstGst2CommTemp.getGSTR_3BM_D(), gstGst2CommTemp.getGSTR_1Q_D(), 
				                        		gstGst2CommTemp.getGSTR_3BQ_D(), gstGst2CommTemp.getGST_CMP_08_D(), gstGst2CommTemp.getGSTR_4_D(), gstGst2CommTemp.getGSTR_9_D(), 
				                        		gstGst2CommTemp.getGSTR_9A_D(), gstGst2CommTemp.getGSTR_9C_D(), gstGst2CommTemp.getGSTR_3A_I(), gstGst2CommTemp.getGSTR_3A_NI(), crr);
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
				                    
				                   
				                    SP_GST_GST_2_COMM_TEMP_Result tempResult = new SP_GST_GST_2_COMM_TEMP_Result();
				                    tempResult = gst_gst_2_dao.generateResult_SP_GST_GST_2_COMM_TEMP(code, mm_yyyy, crr,request);
				                    result = (String) request.getAttribute("result");
			                        
				                        modelView.addObject("MM_YYYY", mm_yyyy);
				                    	modelView.addObject("model", tempResult);
				                    	modelView.addObject("gstGst2CommTemp", new SP_GST_GST_2_COMM_TEMP_Result());
				                    	modelView.setViewName("GSTGST/Insert/GST-GST-2");       
					return modelView;
		        }

				
				
		        
		       
		        public ModelAndView gstReport_GST_GST_2(String report_type, String code, String report_name,
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
		            
		            SP_GST_GST_2_ALL_Result allResult = new SP_GST_GST_2_ALL_Result();
		            SP_GST_GST_2_REGION_Result regionResult = new SP_GST_GST_2_REGION_Result();
		            SP_GST_GST_2_ZONE_Result zoneResult = new SP_GST_GST_2_ZONE_Result();
		            SP_GST_GST_2_COMM_Result commResult = new SP_GST_GST_2_COMM_Result();
		            SP_GST_GST_2_COMM_TEMP_REPORT_Result tempResult = new SP_GST_GST_2_COMM_TEMP_REPORT_Result();
		            
		            
		    	
		    	
		             switch (report_type)
		             {
		                 case "All":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", report_name);
		                         allResult = gst_gst_2_dao.generateResult_SP_GST_GST_2_ALL(mm_yyyy);
		                         modelView.addObject("model",allResult);
		                        
		                         if(allResult!=null) {
		             				modelView.addObject("Model_TOTAL_COMM", allResult.getTOTAL_COMM());
		             				modelView.addObject("Model_COMPLETE_COMM", allResult.getCOMPLETE_COMM());
		             				modelView.addObject("Model_AMND", allResult.getAMND());
		             			}else {		
		             				modelView.addObject("Model_TOTAL_COMM", 0);
		             				modelView.addObject("Model_COMPLETE_COMM", 0);
		             				modelView.addObject("Model_AMND", 0);
		             			}
		                         
		                         break;
		                     }
		                 case "Region":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "REGION : " + report_name);
		                         regionResult = gst_gst_2_dao.generateResult_SP_GST_GST_2_REGION(code, mm_yyyy);
		                         modelView.addObject("model",regionResult); 
		                           
		                         break;
		                     }


		                 case "Zone":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "ZONE : " + report_name);
		                         zoneResult = gst_gst_2_dao.generateResult_SP_GST_GST_2_ZONE(code, mm_yyyy);
		                         modelView.addObject("model",zoneResult); 
		                         if(zoneResult!=null) {
		             				modelView.addObject("Model_TOTAL_COMM", zoneResult.getTOTAL_COMM());
		             				modelView.addObject("Model_COMPLETE_COMM", zoneResult.getCOMPLETE_COMM());
		             				modelView.addObject("Model_AMND", zoneResult.getAMND());
		             			}else {		
		             				modelView.addObject("Model_TOTAL_COMM", 0);
		             				modelView.addObject("Model_COMPLETE_COMM", 0);
		             				modelView.addObject("Model_AMND", 0);
		             			}
		                         
		                         break;
		                     }


		                 case "Comm":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         commResult = gst_gst_2_dao.generateResult_SP_GST_GST_2_COMM(code, mm_yyyy);
		                         modelView.addObject("model",commResult); 
		                         
		                         if(commResult!=null) {
		             				modelView.addObject("Model_TOTAL_COMM", commResult.getTOTAL_COMM());
		             				modelView.addObject("Model_COMPLETE_COMM", commResult.getCOMPLETE_COMM());
		             				modelView.addObject("Model_AMND", commResult.getAMND());
		             			}else {		
		             				modelView.addObject("Model_TOTAL_COMM", 0);
		             				modelView.addObject("Model_COMPLETE_COMM", 0);
		             				modelView.addObject("Model_AMND", 0);
		             			}
		                         break;
		                     }


		                 case "Temp":
		                     {
		                          Object month = gst_gst_2_dao.generateResult_SP_GST_GST_2_MAX_DATE(code);
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
		                         tempResult = gst_gst_2_dao.generateResult_SP_GST_GST_2_COMM_TEMP_REPORT(code, mm_yyyy, null, null, null);
		                         modelView.addObject("model",tempResult);
		                         
		                         if(tempResult!=null) {
		             				modelView.addObject("Model_TOTAL_COMM", tempResult.getTOTAL_COMM());
		             				modelView.addObject("Model_COMPLETE_COMM", tempResult.getCOMPLETE_COMM());
		             				modelView.addObject("Model_AMND", tempResult.getAMND());
		             			}else {		
		             				modelView.addObject("Model_TOTAL_COMM", 0);
		             				modelView.addObject("Model_COMPLETE_COMM", 0);
		             				modelView.addObject("Model_AMND", 0);
		             			}
		                        
		                         break;
		                     }


		                 case "Crr":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         tempResult = gst_gst_2_dao.generateResult_SP_GST_GST_2_COMM_TEMP_REPORT(code, mm_yyyy, "T", null, null);
		                         commResult = gst_gst_2_dao.generateResult_SP_GST_GST_2_COMM(code, mm_yyyy);
		                         modelView.addObject("model",tempResult);
		                         modelView.addObject("ViewBag_ReportA",commResult);
		                         
		                         if(commResult!=null) {
		             				modelView.addObject("Model_TOTAL_COMM", commResult.getTOTAL_COMM());
		             				modelView.addObject("Model_COMPLETE_COMM", commResult.getCOMPLETE_COMM());
		             				modelView.addObject("Model_AMND", commResult.getAMND());
		             			}else {		
		             				modelView.addObject("Model_TOTAL_COMM", 0);
		             				modelView.addObject("Model_COMPLETE_COMM", 0);
		             				modelView.addObject("Model_AMND", 0);
		             			}
		                        
		                         break;
		                     }

		                 case "Bak":
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                         Object Submission_Date = null;
								 tempResult = gst_gst_2_dao.generateResult_SP_GST_GST_2_COMM_TEMP_REPORT(code, mm_yyyy, null, "T", Submission_Date);
		                         modelView.addObject("model",tempResult);
		                         
		                     	if(tempResult!=null) {
		            				modelView.addObject("Model_TOTAL_COMM", tempResult.getTOTAL_COMM());
		            				modelView.addObject("Model_COMPLETE_COMM", tempResult.getCOMPLETE_COMM());
		            				modelView.addObject("Model_AMND", tempResult.getAMND());
		            			}else {		
		            				modelView.addObject("Model_TOTAL_COMM", 0);
		            				modelView.addObject("Model_COMPLETE_COMM", 0);
		            				modelView.addObject("Model_AMND", 0);
		            			}
		                        
		                         break;
		                     }

		                 default:
		                     {
		                         modelView.addObject("ViewBag_MM_YYYY", mm_yyyy);
		                         modelView.addObject("ViewBag_Report_Name", "COMMISSIONERATE : " + report_name);
		                     }
		             }

		                modelView.setViewName("GSTGST/Report/GST-GST-2");
		    	        return modelView;
		    	        }

				

}
