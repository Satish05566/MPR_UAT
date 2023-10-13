<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="com.ddm.cbic.controller.GSTHomeController"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Directorate of Data Management</title>

    <!-- Stylesheet for Bootstrap-->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/font-awesome/css/font-awesome.min.css" rel="stylesheet" />

    <!-- @*Stylesheet for Theme*@ -->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/metisMenu.min.css" rel="stylesheet" />
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/morris.css" rel="stylesheet" />


    <!-- @*Stylesheet for Datatable*@ -->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/css/dataTables.bootstrap.css" rel="stylesheet" />
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/css/dataTables.responsive.css" rel="stylesheet" />


    <meta name="viewport" content="width=device-width" />

    <!-- @*Stylesheet for Custom Work*@ -->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/sb-admin-2.css" rel="stylesheet" />

</head>
<body>
    <div id="wrapper">
        <!-- Navigation -->



        <nav class="navbar navbar-default navbar-static-top pos-fixed" role="navigation" style="margin-bottom: 0; width:100%" id="navigation_desk">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse in" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
              
            </div>

            <div class="col-lg-4 pos-fixed">
                <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/images/logo/Merge-Eng.png" class="eng_logo" />
             
            </div>
        

            <% 
            if (request.getSession().getAttribute("USER")!=null && request.getSession().getAttribute("USER")!="")
            	
            { 
            	String type = (String)request.getSession().getAttribute("TYPE");
            	
            %>
            <!-- /.navbar-header -->
                <ul class="nav navbar-top-links navbar-right">

                    <!-- /.dropdown -->
                   
                    <!-- /.dropdown -->
                    <% //@if (Session["USER"].ToString() != "ddmC1_cbec")
                    String userId = (String)request.getSession().getAttribute("USER");
                    System.out.println("userId----"+userId);
                if ((String)request.getSession().getAttribute("USER")!="ddmC1_cbec")
                    { %>
                    	<li class="dropdown">
                            <a href="<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Home/Home/<%=request.getSession().getAttribute("CSRF_Token").toString() %>" class="btn btn-primary eng">
                                <i class="fa fa-sign-out fa-fw"></i> PRE-GST
                            </a>
                          
                        </li>
                   <% }%>

                 
                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i><%=request.getSession().getAttribute("USER") %> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                           <% // @if ((Session["TYPE"].ToString().Substring(0, 2) != "FO") || (Session["TYPE"].ToString().Substring(0, 4) == "CBEC"))
                           if ((type!=null && type!="")&&((type.toString().substring(0, 2) != "FO") || (type.toString().substring(0, 4) == "CBEC")))
                           {
                            
                               // if (Session["USER"].ToString() != "ddmC1_cbec")
                            	   if (userId != "ddmC1_cbec")
                                { %>                                
                                
                               <!--   <li><a class="eng" href='#'><i class="fa fa-user fa-fw"></i> User Profile</a></li> -->
                               
                               <% }
                            }%>
		                   <!--         <li>                                
                               
                                <a class="eng" href='/GSTHome/ChangePassword'><i class="fa fa-gear fa-fw"></i> Change Password</a>
                            </li> -->
                            <li class="divider"></li>
                            <li>
                               
                                <a class="eng" href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Logout'><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>

                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                
            <!-- /.navbar-top-links -->
                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            
                                  
                                  <li>                       
                                <a class="eng" href="<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/Left_Menu_Home/<%=request.getSession().getAttribute("CSRF_Token").toString() %>"><i class="fa fa-home fa-fw"></i> Management Information</a>
                            
                            </li>


                            <%
                                                        	
                            	if(type.equalsIgnoreCase("COMMISSIONERATE")){ 
                            	%>
                                <li>
                                   
                                    <a class="eng" href="<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/Insert/<%=request.getSession().getAttribute("CSRF_Token").toString() %>"><i class="fa fa-upload fa-fw"></i> Upload</a>
                            
                            </li>
                           <% } %>
                           
                            <% 
                            if((String)request.getSession().getAttribute("TYPE")=="COMMISSIONERATE")
                            { %>
                                <li>
                                    
                                    <a class="eng" href="<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Validate/Submission/<%=request.getSession().getAttribute("CSRF_Token").toString() %>"><i class="fa fa-check fa-fw"></i> View</a>
                            
                            </li>
                            <% }                            
                            
                            if((String)request.getSession().getAttribute("TYPE")=="ZONE")
                            { %>
                                <li>
                                    
                                    <a class="eng" href="<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Validate/Submission/<%=request.getSession().getAttribute("CSRF_Token").toString() %>"><i class="fa fa-check fa-fw"></i> Validate</a>
                            
                            </li>
                            <% }
                          
                           if((String)request.getSession().getAttribute("TYPE")=="COMMISSIONERATE")
                            { %>
                                <%-- <li>
                                    
                                    <a class="eng" href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Correction/<%=request.getSession().getAttribute("CSRF_Token").toString() %>'><i class="fa fa-edit fa-fw"></i> Correction</a>
                            </li> --%>
                           <% }
                           
                        	   else if((String)request.getSession().getAttribute("TYPE")=="ZONE")
                            {%>
                                <li>
                                    
                                    <a class="eng" href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>ZoneCorrection/<%=request.getSession().getAttribute("CSRF_Token").toString() %>'><i class="fa fa-edit fa-fw"></i> Correction</a>
                                </li>
                           <% }
                            
                        	   else if((request.getSession().getAttribute("TYPE")!=null && request.getSession().getAttribute("TYPE")!="") && (request.getSession().getAttribute("TYPE").toString().substring(0, 2).equalsIgnoreCase("FO")))
                            { %>
                                <li>
                                   <a class="eng" href="<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>FO_Correction/<%=request.getSession().getAttribute("CSRF_Token").toString() %>"><i class="fa fa-edit fa-fw"></i> Correction</a>
                                    
                                </li>
                           <% 
                           
                           String Type = (String)request.getSession().getAttribute("TYPE");
                            System.out.println("Type in layout jsp---"+Type);
                            }
                            
                            else if((request.getSession().getAttribute("TYPE")!=null 
                            		&& request.getSession().getAttribute("TYPE")!="") 
                            		&& ((String)request.getSession().getAttribute("TYPE").toString().substring(0, 2)=="CBEC"))
                            { %>
                               <!--  <li>
                                  
                                    <a class="eng" href='#'><i class="fa fa-edit fa-fw"></i> Correction</a>
                                </li> -->
                           <% }%>
							
				
                            <%-- <li>
                            
                            	<a class="eng" href="<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/Status/<%=request.getSession().getAttribute("CSRF_Token").toString() %>"><i class="fa fa-th-large fa-fw"></i> Status</a>
                                                            
                            </li> --%>
                            
							<!-- 
                            <li>
                               
                                <a class="eng" href='#'><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                            </li>

                           <%
                           
                         
                            String user = (String)request.getSession().getAttribute("USER");
                           System.out.println("user in layout jsp---"+user);
                            if((user.toString().substring(6) == "zone") || (user.toString().substring(6) == "admn") || (user.toString() == "CBEC USER") || (user.toString() == "FO-DDM"))
                           
                           {%>
                                <li><a href='#'><i class="fa fa-map-marker fa-fw"></i> GSTLoco</a></li>
                            <% }%>

                            <li>
                                <a class="eng" href="#"><i class="fa fa-support fa-fw"></i> Support<span class="fa arrow"></span></a>
                              
                                <ul class="nav nav-second-level">
                                  <% 
                                  
                            		if((type.toString()=="ZONE") ||(type.toString()=="COMMISSIONERATE") || (type.toString()=="DC/AC"))	
                            		  {%>
                                        <li>
                                            <a class="eng" href='#'><i class="fa fa-support fa-fw"></i> Helpdesk</a>
                                            
                                        </li>
                                   <% }
                                   
                                   else if((request.getSession().getAttribute("TYPE")!=null && request.getSession().getAttribute("TYPE")!="")&&((String)request.getSession().getAttribute("TYPE").toString().substring(0, 2)=="FO"))
                                    {%>
                                        <li>
                                            <a class="eng" href='#'><i class="fa fa-support fa-fw"></i> Helpdesk</a>
                                          
                                        </li>
                                   <% }%>
                                   
                                    <li>
                                        <a class="eng" href='#'><i class="fa fa-envelope-o fa-fw"></i> Mail</a>
                                       
                                    </li>
                                    <%
                                    	
                                    	if((String)request.getSession().getAttribute("TYPE").toString()=="FO-DDM")
                                    { %>
                                        <li>
                                            <a class="eng" href='#'><i class="fa fa-envelope fa-fw"></i> Send SMS</a>
                                           
                                        </li>
                                        <li>
                                            <a class="eng" href='#'><i class="fa fa-envelope fa-fw"></i> Send EMAIL</a>
                                            
                                        </li>

                                    <%}%>

                                    <li>
                                        <a class="eng" href='#'><i class="fa fa-envelope fa-fw"></i> Feedback</a>
                                      
                                    </li>
                                </ul>
                               
                            </li>

                         	-->
                            <li>
                                <a class="eng" href='<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Logout'><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                
                            </li>

                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
            <!-- /.navbar-static-side -->
           <%  }
            else
            {
                //Response.Redirect("~/Login");
            }%>
        </nav>

        <!-- /#page-wrapper -->
    </div>
    
   

