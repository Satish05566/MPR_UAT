package com.ddm.cbic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Controller implements ErrorController {

	// ...
	
	@Value("${COOKIE_CHECK_ANTARANG}")
    private boolean COOKIE_CHECK_ANTARANG;

	@RequestMapping("/error")
	public String handleError(HttpServletResponse response) {
		
		System.out.println("response.getStatus() " + response.getStatus());
		
		
		if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
			return "<h1>Requested Resource Not Found. Please contact Administrator Please re-login .</h1>";
		}
		else if(response.getStatus() == HttpStatus.FORBIDDEN.value()) {
			return "<h1>Access Denied. Please contact Administrator</h1>";
		}
		else if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			
			//return "<h1>Either Your Session has Expired or Some Internal Server Error Occured. Please re-login. <a href=\"javascript:void(0)\" onclick=\"window.open('http://cbicddmuat.cbic.gov.in:8080/MIS/Login')\"> Click Here</a></h1>" ;
			if(COOKIE_CHECK_ANTARANG) {
				return   "<h1>Either Your Session has Expired or Some Internal Server Error Occured. Please re-login through Antarang link</h1>";
			}
			else {
			
				//return   "<h1>Either Your Session has Expired or Some Internal Server Error Occured. Please re-login . </h1>";	
				return   "<h1>Either Your Session has Expired. Please re-login . </h1>";	
				
			}
		}
		else {
			return "<h1>Some Error Occured. Please contact Administrator</h1>";
		}

		
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	
	
	

}