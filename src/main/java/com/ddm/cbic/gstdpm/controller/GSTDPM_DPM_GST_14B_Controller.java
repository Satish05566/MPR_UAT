package com.ddm.cbic.gstdpm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ddm.cbic.gstdpm.model.SP_DPM_GST_14B_COMM_TEMP_Result;
import com.ddm.cbic.gstdpm.service.GSTDPM_DPM_GST_14B_Service;

@Controller
@RequestMapping("/GSTDPM")
public class GSTDPM_DPM_GST_14B_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(GSTDPM_DPM_GST_14B_Controller.class);

	@Autowired
	GSTDPM_DPM_GST_14B_Service dpm_gst_14b_service;

	 @RequestMapping(value = "/Insert/DPM_GST_14B/{request_CSRF_Token}", method = RequestMethod.GET)
		public ModelAndView get_DPM_GST_14B(Model model,HttpServletRequest request,@PathVariable("request_CSRF_Token") String request_CSRF_Token) {
          
		           if(request_CSRF_Token != null)
		           {
		        	   return dpm_gst_14b_service.get_DPM_GST_14B(request);
		           }
		           else
		           {
		        	   return null;
		           }

		        }

		        @RequestMapping(value = "/Insert/DPM_GST_14B", method = RequestMethod.POST)
				public ModelAndView post_DPM_GST_14B(@Valid @ModelAttribute("dpmGst14BCommTemp") SP_DPM_GST_14B_COMM_TEMP_Result dpmGst14BCommTemp,BindingResult reslt,
						 HttpServletRequest request, String btn_submit, String HDTokenNo) {
				      
		      
		        	ModelAndView modelView  = new ModelAndView();
		        	
		        	logger.info("reslt.hasErrors()--"+reslt.hasErrors());
		        	
					if (HDTokenNo.equals(request.getSession().getAttribute("TokenNo")))
				            {   
									
						return dpm_gst_14b_service.post_DPM_GST_14B(dpmGst14BCommTemp, reslt, request, btn_submit);
				                   
				            }
				            else
				            {
				            	request.getSession().invalidate();			 
								 modelView.setViewName("GSTDPM/ResourceNotFound");
							     modelView.addObject("message", "");
							     return modelView;
				            }
					
		        }
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		      

}
