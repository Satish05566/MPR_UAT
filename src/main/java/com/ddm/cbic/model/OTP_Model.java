package com.ddm.cbic.model;

import java.util.ArrayList;
import java.util.List;

public class OTP_Model {
	
	String message;
	String mobile;
	String usertype;
	String usercode ;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	@Override
	public String toString() {
		return "OTP_Model [message=" + message + ", mobile=" + mobile + ", usertype=" + usertype + ", usercode="
				+ usercode + "]";
	}
	
	
	
	

}
