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

import com.ddm.cbic.gstgi.controller.GSTGI_GI_GST_1A_Controller;
import com.ddm.cbic.gstgi.dao.GSTGI_GI_GST_1A_Dao;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_ALL_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_TEMP_REPORT_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_COMM_TEMP_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_REGION_Result;
import com.ddm.cbic.gstgi.model.SP_GI_GST_1A_ZONE_Result;
import com.ddm.cbic.gstgi.service.GSTGI_GI_GST_1A_Service;

@Service
public class GSTGI_GI_GST_1A_Service_Impl implements GSTGI_GI_GST_1A_Service {
	
	private static final Logger logger = LoggerFactory.getLogger(GSTGI_GI_GST_1A_Controller.class);
	
	@Autowired
	GSTGI_GI_GST_1A_Dao GI_GST_1A_dao;
	
	@Override
	              public ModelAndView get_GI_GST_1A(HttpServletRequest request) {
	            	  
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
		                Object month = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_MAX_DATE(code);
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
		            
		            SP_GI_GST_1A_COMM_TEMP_Result tempResult = new SP_GI_GST_1A_COMM_TEMP_Result();
		            tempResult = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_COMM_TEMP(code, mm_yyyy, crr,request);
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
	                modelView.addObject("giGst1ACommTemp", new SP_GI_GST_1A_COMM_TEMP_Result());
	                modelView.setViewName("GSTGI/Insert/GI-GST-1A");
	                return modelView;


		        }

	              public ModelAndView post_GI_GST_1A(@Valid SP_GI_GST_1A_COMM_TEMP_Result giGst1ACommTemp,
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
						                        result = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_UPDATE(code, mm_yyyy, giGst1ACommTemp.getARRESTS_MADE(),giGst1ACommTemp.getPROSECUTION_SANCTIONED(), giGst1ACommTemp.getCOMPOUNDING_OF_OFFENCES(), giGst1ACommTemp.getPROSECUTION_LAUNCHED(), 
						                        		giGst1ACommTemp.getARRESTS_MADE_PRE(),giGst1ACommTemp.getPROSECUTION_SANCTIONED_PRE(), giGst1ACommTemp.getCOMPOUNDING_OF_OFFENCES_PRE(), giGst1ACommTemp.getPROSECUTION_LAUNCHED_PRE(),crr);
						                        modelView.addObject("ViewBagMessage", result);
						                        modelView.addObject("ViewBag_button", "Update");
						                    }
						                    else if (btn_submit.equals("Upload") && (crr == null || crr == "")&& (!reslt.hasErrors()) )
						                    {
						                    	modelView.addObject("CRR", "");
						                    	result = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_INSERT(code, mm_yyyy, giGst1ACommTemp.getARRESTS_MADE(),giGst1ACommTemp.getPROSECUTION_SANCTIONED(), giGst1ACommTemp.getCOMPOUNDING_OF_OFFENCES(), giGst1ACommTemp.getPROSECUTION_LAUNCHED(), 
						                        		giGst1ACommTemp.getARRESTS_MADE_PRE(),giGst1ACommTemp.getPROSECUTION_SANCTIONED_PRE(), giGst1ACommTemp.getCOMPOUNDING_OF_OFFENCES_PRE(), giGst1ACommTemp.getPROSECUTION_LAUNCHED_PRE());
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
						                        result = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_UPDATE(code, mm_yyyy, giGst1ACommTemp.getARRESTS_MADE(),giGst1ACommTemp.getPROSECUTION_SANCTIONED(), giGst1ACommTemp.getCOMPOUNDING_OF_OFFENCES(), giGst1ACommTemp.getPROSECUTION_LAUNCHED(), 
						                        		giGst1ACommTemp.getARRESTS_MADE_PRE(),giGst1ACommTemp.getPROSECUTION_SANCTIONED_PRE(), giGst1ACommTemp.getCOMPOUNDING_OF_OFFENCES_PRE(), giGst1ACommTemp.getPROSECUTION_LAUNCHED_PRE(),crr);
						                        modelView.addObject("ViewBagMessage", result);
						                    }		                    
						                   
						                    SP_GI_GST_1A_COMM_TEMP_Result tempResult = new SP_GI_GST_1A_COMM_TEMP_Result();
						                    tempResult = GI_GST_1A_dao.generateResult_SP_GI_GST_1A_COMM_TEMP(code, mm_yyyy, crr,request);
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
						                    	modelView.addObject("GiGst1ACommTemp", new SP_GI_GST_1A_COMM_TEMP_Result());
						                    	modelView.setViewName("GSTGI/Insert/GI-GST-1A");    
				                    	
	            	  				}
	            	  				
	            	  				else {
	            	  					request.getSession().invalidate();
	            	  					modelView.setViewName("GSTGI/ResourceNotFound");
	            	  				}
				            
					return modelView;
		        }


}
