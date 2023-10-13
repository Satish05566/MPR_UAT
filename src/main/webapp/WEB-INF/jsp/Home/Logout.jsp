<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>


<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  session.invalidate();
  System.out.println("before session attribute get");
  if(null != session.getAttribute("validLogin")){
	  System.out.println("inside null != validLogin");
	  System.out.println("inside null != validLogin" + session.getAttribute("validLogin"));
  }
  if(null == session.getAttribute("validLogin")){
	  
	  System.out.println("inside null == validLogin");
      String logoutUrl = session.getAttribute("DYNAMIC_LINK_PATH")+"Logout";
      response.sendRedirect(logoutUrl);
  }

  %> 