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
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/font-awesome/css/font-awesome.min.css" rel="stylesheet" />

    <!-- @*Stylesheet for Theme*@ -->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/cssGST/metisMenu.min.css" rel="stylesheet" />
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/cssGST/morris.css" rel="stylesheet" />


    <!-- @*Stylesheet for Datatable*@ -->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/cssGST/dataTables.bootstrap.css" rel="stylesheet" />
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/cssGST/dataTables.responsive.css" rel="stylesheet" />


    <meta name="viewport" content="width=device-width" />

    <!-- @*Stylesheet for Custom Work*@ -->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/cssGST/sb-admin-2.css" rel="stylesheet" />


    <style>

        .page-header {
        color: #337ab7
        }

        .nav > li > a:hover {
            background-color: #184b77 !important;
            color:#fff;
        }

        
    </style>

</head>
<body>

    <div id="wrapper">
        <!-- Navigation -->



        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0" id="navigation_desk">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse in" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/imagesGST/CBECDDM-Logo-New.png" id="img_logo" />

            </div>

            <!-- <div class="col-lg-4">
                <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content/Logo/Merge-Eng.png" class="eng_logo eng" />
                <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content/Logo/Merge-Hindi.png" class="hindi_logo hindi " />
            </div> -->

            <div class="col-lg-3" style="text-align:center">
                <img id="cbic_sanchar" src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content/Logo/CBICDDM.png" />
            </div>

            <% //@if (!string.IsNullOrEmpty(Convert.ToString(Session["USER"])))
            if (request.getSession().getAttribute("USER")!=null && request.getSession().getAttribute("USER")!="")
            	
            { 
            	String TYPE = (String)request.getSession().getAttribute("TYPE");
            	
            %>
            <!-- /.navbar-header -->
                <ul class="nav navbar-top-links navbar-right">

                    <!-- /.dropdown -->
                    <li class="dropdown">

                        <a class="btn btn-primary" id="hindi_button" onclick="javascript:Bilingual_Hindi();">
                            हिन्दी में
                        </a>

                        <a class="btn btn-primary" id="english_button" onclick="javascript:Bilingual_Eng();">
                            English
                        </a>
                    </li>
                    <!-- /.dropdown -->
                    <% //@if (Session["USER"].ToString() != "ddmC1_cbec")
                    String USER = (String)request.getSession().getAttribute("USER");
                    System.out.println("USER----"+USER);
                if ((String)request.getSession().getAttribute("USER")!="ddmC1_cbec")
                    { %>
                        <li class="dropdown">
                            <a href='@Url.Action("Report", "Home", new { area = "" })' class="btn btn-primary eng">
                                <i class="fa fa-sign-out fa-fw"></i> PRE-GST
                            </a>

                            <a href='@Url.Action("Report", "Home", new { area = "" })' class="btn btn-primary hindi">
                                <i class="fa fa-sign-out fa-fw"></i> पूर्व जीएसटी
                            </a>
                        </li>
                   <% }%>

                                       
                    <li class="dropdown">
                        <a href='@Url.Action("Desk", "GSTHome", new { area = "" })' class="btn btn-primary eng">
                            <i class="fa fa-sign-out fa-fw"></i> CBIC Sanchar
                        </a>
                        <a href='@Url.Action("Desk", "GSTHome", new { area = "" })' class="btn btn-primary hindi">
                            <i class="fa fa-sign-out fa-fw"></i> सीबीआईसी संचार
                        </a>
                    </li>
                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i><%=request.getSession().getAttribute("USER") %> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                           <% // @if ((Session["TYPE"].ToString().Substring(0, 2) != "FO") || (Session["TYPE"].ToString().Substring(0, 4) == "CBEC"))
                           if ((TYPE.toString().substring(0, 2) != "FO") || (TYPE.toString().substring(0, 4) == "CBEC"))
                           {
                            
                               // if (Session["USER"].ToString() != "ddmC1_cbec")
                            	   if (USER != "ddmC1_cbec")
                                { %>                                
                                 <li><a class="hindi" href='@Url.Action("ChangeProfile", "GSTHome", new { area = "" })'><i class="fa fa-user fa-fw"></i> प्रयोक्ता पार्श्वक</a></li>
                                 <li><a class="eng" href='@Url.Action("ChangeProfile", "GSTHome", new { area = "" })'><i class="fa fa-user fa-fw"></i> User Profile</a></li>
                               
                               <% }
                            }%>
                            <li>                                
                                <a class="hindi" href='@Url.Action("ChangePassword", "GSTHome", new { area = "" })'><i class="fa fa-gear fa-fw"></i> पासवर्ड बदलें</a>
                                <a class="eng" href='@Url.Action("ChangePassword", "GSTHome", new { area = "" })'><i class="fa fa-gear fa-fw"></i> Change Password</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="hindi" href='@Url.Action("logout", "Home", new { area = "" })'><i class="fa fa-sign-out fa-fw"></i> लॉगआउट</a>
                                <a class="eng" href='@Url.Action("logout", "Home", new { area = "" })'><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>

                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <br />

            <!-- /.navbar-top-links -->
                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li class="sidebar-search">
                                <div class="input-group custom-search-form eng">
                                    <i class="fa fa-user fa-fw"></i>
                                    Username : <%=(String)request.getSession().getAttribute("USER") %>

                                </div>
                                <div class="input-group custom-search-form hindi">
                                    <i class="fa fa-user fa-fw"></i>
                                                                                             उपयोगकर्ता का नाम : <%=(String)request.getSession().getAttribute("USER") %>

                                </div>
                                <!-- /input-group -->
                            </li>
                           <!--  @*<li><a href='@Url.Action("Home", "Navigation", new { area = "PMM" })'><i class="fa fa-home fa-fw"></i> PMM</a></li>*@ -->

                            <li>
                                <a class="hindi" href='@Url.Action("Home", "/GSTHome/Home", new { area = "" })'><i class="fa fa-home fa-fw"></i> एमआईएस रिपोर्ट</a>
                                <a class="eng" href='@Url.Action("Home", "/GSTHome/Home", new { area = "" })'><i class="fa fa-home fa-fw"></i> Management Information</a>
                            
                            </li>


                            <%
                            	//@if (Session["TYPE"] == "COMMISSIONERATE")
                            	
                            	if(TYPE.equalsIgnoreCase("COMMISSIONERATE")){ 
                            	%>
                                <li>
                                    <a class="hindi" href='@Url.Action("Insert", "GSTHome", new{area=""})'><i class="fa fa-upload fa-fw"></i> अपलोड</a>
                                    <a class="eng" href='@Url.Action("Insert", "GSTHome", new{area=""})'><i class="fa fa-upload fa-fw"></i> Upload</a>
                            
                            </li>
                           <% } %>
                           
                            <% //@if (Session["TYPE"] == "ZONE" || Session["TYPE"] == "COMMISSIONERATE")
                            if((String)request.getSession().getAttribute("TYPE")=="ZONE" || (String)request.getSession().getAttribute("TYPE")=="COMMISSIONERATE")
                            { %>
                                <li>
                                    <a class="hindi" href='@Url.Action("Submission", "GSTHome", new { area = "" })'><i class="fa fa-check fa-fw"></i> विधिमान्य</a>
                                    <a class="eng" href='@Url.Action("Submission", "GSTHome", new { area = "" })'><i class="fa fa-check fa-fw"></i> Validate</a>
                            
                            </li>
                            <% }
                           // @if (Session["TYPE"] == "COMMISSIONERATE")
                           if((String)request.getSession().getAttribute("TYPE")=="COMMISSIONERATE")
                            { %>
                                <li>
                                    <a class="hindi" href='@Url.Action("Correction", "GSTHome", new { area = "" })'><i class="fa fa-edit fa-fw"></i> सुधार</a>
                                    <a class="eng" href='@Url.Action("Correction", "GSTHome", new { area = "" })'><i class="fa fa-edit fa-fw"></i> Correction</a>
                            </li>
                           <% }
                           // else if (Session["TYPE"] == "ZONE")
                        	   else if((String)request.getSession().getAttribute("TYPE")=="ZONE")
                            {%>
                                <li>
                                    <a class="hindi" href='@Url.Action("ZoneCorrection", "GSTHome", new { area = "" })'><i class="fa fa-edit fa-fw"></i> सुधार</a>
                                    <a class="eng" href='@Url.Action("ZoneCorrection", "GSTHome", new { area = "" })'><i class="fa fa-edit fa-fw"></i> Correction</a>
                                </li>
                           <% }
                            //else if (Session["TYPE"].ToString().Substring(0, 2) == "FO")
                            else if((String)request.getSession().getAttribute("TYPE").toString().substring(0, 2)=="FO")
                            { %>
                                <li>
                                    <a class="hindi" href='@Url.Action("FO_Correction", "GSTHome", new { area = "" })'><i class="fa fa-edit fa-fw"></i> सुधार</a>
                                    <a class="eng" href='@Url.Action("FO_Correction", "GSTHome", new { area = "" })'><i class="fa fa-edit fa-fw"></i> Correction</a>
                                </li>
                           <% 
                           
                            //TYPE = (String)request.getSession().getAttribute("TYPE");
                            //System.out.println("TYPE in layout jsp---"+TYPE);
                            }
                            //else if (Session["TYPE"].ToString().Substring(0, 4) == "CBEC")
                            else if((String)request.getSession().getAttribute("TYPE").toString().substring(0, 4)=="CBEC")
                            { %>
                                <li>
                                    <a class="hindi" href='@Url.Action("CorrectionBackup", "GSTHome", new { area = "" })'><i class="fa fa-edit fa-fw"></i> सुधार</a>
                                    <a class="eng" href='@Url.Action("CorrectionBackup", "GSTHome", new { area = "" })'><i class="fa fa-edit fa-fw"></i> Correction</a>
                                </li>
                           <% }%>

                            <li>
                                <a class="hindi" href='@Url.Action("Status", "GSTHome", new { area = "" })'><i class="fa fa-th-large fa-fw"></i> स्थिति</a>
                                <a class="eng" href='@Url.Action("Status", "GSTHome", new { area = "" })'><i class="fa fa-th-large fa-fw"></i> Status</a>
                            </li>

                            <li>
                                <a class="hindi" href='@Url.Action("DSB", "GSTHome", new { area = "" })'><i class="fa fa-dashboard fa-fw"></i> नियंत्रण-पट्ट</a>
                                <a class="eng" href='@Url.Action("DSB", "GSTHome", new { area = "" })'><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                            </li>


                            <!-- @*<li><a href='@Url.Action("Home", "NavigationWRR", new { area = "GSTWRR" }, null)'><i class="fa fa-external-link fa-fw"></i> WEEKLY REFUND <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; REPORT</a></li>*@


                            @*@if ((Session["USER"].ToString().Substring(6) == "zone") || (Session["TYPE"].ToString() == "FO-DDM") || (Session["TYPE"].ToString().Substring(0, 4) == "CBEC") || (Session["USERTYPE"].ToString() == "CEI"))
                            {
                                <li><a href='@Url.Action("Home", "Navigation", new { area = "PMM" }, null)'><i class="fa fa-external-link fa-fw"></i> PMM</a></li>
                            }
                            else
                            {
                                <li><a href='@Url.Action("", "", new { area = "" }, null)'><i class="fa fa-external-link fa-fw"></i> PMM</a></li>
                            }*@ -->


                           <%
                           
                           //@if ((Session["USER"].ToString().Substring(6) == "zone") || (Session["USER"].ToString().Substring(6) == "admn") || (Session["TYPE"].ToString() == "CBEC USER") || (Session["TYPE"].ToString() == "FO-DDM"))
                            String user = (String)request.getSession().getAttribute("USER");
                           System.out.println("user in layout jsp---"+user);
                            if((user.toString().substring(6) == "zone") || (user.toString().substring(6) == "admn") || (user.toString() == "CBEC USER") || (user.toString() == "FO-DDM"))
                           
                           {%>
                                <li><a href='@Url.Action("Home", "REPORT", new { area = "GSTLOCO" }, null)'><i class="fa fa-map-marker fa-fw"></i> GSTLoco</a></li>
                            <% }%>

                           <!--  @*@if ((Session["TYPE"].ToString() == "FO-DDM") || (Session["TYPE"].ToString() == "FO-DGA") || (Session["USER"].ToString() == "gstZA_admn"))
                            {
                                <li><a href='@Url.Action("Home", "DGAudit", new { area = "DGAudit" }, null)'><i class="fa fa-external-link fa-fw"></i> AUDIT</a></li>
                            }*@

                            @*@if ((Session["TYPE"].ToString() == "FO-DDM") || (Session["TYPE"].ToString() == "FO-ARM") || (Session["TYPE"].ToString() == "FO-CEI") || (Session["USER"].ToString() == "gstZA_admn") || 
							(Session["USER"].ToString() == "gst50_zone") || (Session["USER"].ToString() == "ceiDG_zone") || (Session["USER"].ToString() == "ceiH0_admn"))
                            {*@
                               @*<li><a href='@Url.Action("Home", "NavigationDGARM", new { area = "DGARM" }, null)'><i class="fa fa-external-link fa-fw"></i> DGARM</a></li>*@
                           
                            @*}*@
                            
                            @*@if ((Session["TYPE"].ToString() == "FO-DDM") || (Session["USER"].ToString() == "gstZA_admn") || (Session["USER"].ToString() == "gstWS_admn"))
                            {
                                <li><a href="javascript:void(0)" id="dgddm_validate"><i class="fa fa-external-link fa-fw"></i> DG System &nbsp;<img src="~/content/blinking_new.gif"></a></li>
                                
                            }*@
                            @*<li><a href='@Url.Action("Home", "NavigationDGADMIN", new { area = "DGADMIN" }, null)'><i class="fa fa-upload fa-fw"></i> ADMINISTRATIVE <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; REPORT</a></li>
                            <li><a href="javascript:void(0)" id="dgarm_validate"><i class="fa fa-external-link fa-fw"></i> DGARM &nbsp;<img src="~/content/blinking_new.gif"></a></li>*@

                            @*@if (Session["USER"].ToString().Substring(6) != "admn")
                            {
                                <li><a href='@Url.Action("DisputeResolution", "DisputeResolution", new { area = "TDOTS" }, null)'><i class="fa fa-external-link fa-fw"></i> TDOTS</a></li>
                            }*@


                            @*@if (Session["TYPE"] != "ZONE")
                            {
                                <li><a href='@Url.Action("DashBoard", "DGHome", new { area = "DGHRD" }, null)'><i class="fa fa-external-link fa-fw"></i> GeM</a></li>
                            }*@
 -->
                            <li>
                                <a class="eng" href="#"><i class="fa fa-support fa-fw"></i> Support<span class="fa arrow"></span></a>
                                <a class="hindi" href="#"><i class="fa fa-support fa-fw"></i> सहायता<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                  <% 
                                  //@if (Session["TYPE"] == "ZONE" || Session["TYPE"] == "COMMISSIONERATE" || Session["TYPE"] == "DC/AC")
                            		if((TYPE.toString()=="ZONE") ||(TYPE.toString()=="COMMISSIONERATE") || (TYPE.toString()=="DC/AC"))	
                            		  {%>
                                        <li>
                                            <a class="eng" href='@Url.Action("HelpDesk", "GSTHome", new { area = "" })'><i class="fa fa-support fa-fw"></i> Helpdesk</a>
                                            <a class="hindi" href='@Url.Action("HelpDesk", "GSTHome", new { area = "" })'><i class="fa fa-support fa-fw"></i> सहायता</a>
                                        </li>
                                   <% }
                                   else if((String)request.getSession().getAttribute("TYPE").toString().substring(0, 2)=="FO")
                                    {%>
                                        <li>
                                            <a class="eng" href='@Url.Action("HelpDesk_FO", "GSTHome", new { area = "" })'><i class="fa fa-support fa-fw"></i> Helpdesk</a>
                                            <a class="hindi" href='@Url.Action("HelpDesk_FO", "GSTHome", new { area = "" })'><i class="fa fa-support fa-fw"></i> सहायता</a>
                                        </li>
                                   <% }%>
                                   
                                    <li>
                                        <a class="eng" href='@Url.Action("Mail", "GSTHome", new { area = "" })'><i class="fa fa-envelope-o fa-fw"></i> Mail</a>
                                        <a class="hindi" href='@Url.Action("Mail", "GSTHome", new { area = "" })'><i class="fa fa-envelope-o fa-fw"></i> मेल</a>
                                    </li>
                                    <%
                                    	//@if (Session["TYPE"].ToString() == "FO-DDM")
                                    	if((String)request.getSession().getAttribute("TYPE").toString()=="FO-DDM")
                                    { %>
                                        <li>
                                            <a class="eng" href='@Url.Action("ViewSMS", "GSTHome", new { area = "" }, null)'><i class="fa fa-envelope fa-fw"></i> Send SMS</a>
                                            <a class="hindi" href='@Url.Action("ViewSMS", "GSTHome", new { area = "" }, null)'><i class="fa fa-envelope fa-fw"></i> एसएमएस भेजें</a>
                                        </li>
                                        <li>
                                            <a class="eng" href='@Url.Action("ViewEMAIL", "GSTHome", new { area = "" }, null)'><i class="fa fa-envelope fa-fw"></i> Send EMAIL</a>
                                            <a class="hindi" href='@Url.Action("ViewEMAIL", "GSTHome", new { area = "" }, null)'><i class="fa fa-envelope fa-fw"></i> ईमेल भेजें</a>
                                        </li>

                                    <%}%>

                                    <li>
                                        <a class="eng" href='@Url.Action("Feedback", "GSTHome", new { area = "" })'><i class="fa fa-envelope fa-fw"></i> Feedback</a>
                                        <a class="hindi" href='@Url.Action("Feedback", "GSTHome", new { area = "" })'><i class="fa fa-envelope fa-fw"></i> प्रतिक्रिया</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>

                            <li>
                                <a class="eng" href='http://www.cbecddm.gov.in' target="_blank"><i class="fa fa-external-link fa-fw"></i> Home</a>
                                <a class="hindi" href='http://www.cbecddm.gov.in' target="_blank"><i class="fa fa-external-link fa-fw"></i> मुख्य-पृष्ठ</a>
                            </li>

                            <li>
                                <a class="eng" href='@Url.Action("logout", "Home", new { area = "" })'><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                <a class="hindi" href='@Url.Action("logout", "Home", new { area = "" })'><i class="fa fa-sign-out fa-fw"></i> लॉगआउट</a>
                            </li>

                            <li>
                     
                                <a class="eng" href="@Url.Action("Desk", "GSTHome", new { area = "" })"><!-- @*<i class="fa fa-undo" aria-hidden="true"></i>*@ --> 
                                    <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content/Logo/CBICDDM.png" style="height:20px; width:20px;"/> CBIC-Sanchar</a>
                                <a class="hindi" href='@Url.Action("Desk", "GSTHome", new { area = "" })'><i class="fa fa-undo fa-fw"></i> निकास /बाहर जाएँ</a>
                            

                          </li>
                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
            <!-- /.navbar-static-side -->
           <%  }
            else
            {
                response.sendRedirect("/MIS/Login");   
            }%>
        </nav>

        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!---Body Section-->
    <!--START UPTO-INSTRUCTION-MODAL POP-UP-->

    <div id="myLargeModal1" class="modal fade" role="dialog">
        <div class="modal-dialog modal-lg">

            <!-- Modal content-->
            <div class="modal-content" style="overflow: hidden; text-align: justify; padding-left: 20px; padding-right: 20px; ">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">UPTO THE MONTH INSTRUCTION</h4>
                </div>
                <div class="modal-body" style="overflow-y: auto;">
                    <p>
                        <i>
                            Columns for <b>Upto the Month Current Year</b> and <b>Upto the Month Last Year</b> data for the MPRs, wherever applicable, for the month of July, 2017 have now been opened for uploading and validation by the Commissionerates / Directorates.
                            <br />
                            Columns for <b>For the Month for Last Year</b>  data for the MPRs, wherever applicable, have now been opened for uploading and validate by the Commissionerates / Directorates.
                            <br />
                            The Upto the Month data for the Current year and Last year should be as per new Jurisdiction of the Commissionerate (GST/Customs).
                            <br /><br />
                            Please upload the relevant data for the month of July, 17 and validate the same by 6th October, 2017.
                            <br /><br />
                            Only after completing this exercise all India, you will be allowed to validate MPRs for August, 2017.

                        </i>
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal">OK</button>

                </div>
            </div>

        </div>
    </div>
	
    <!-- @*--------------- DGARM---------------------------*@ -->
	<div class="modal info-custom" id="modal-feedback-details" style="overflow-y: scroll !important;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close close_modal" data-dismiss="modal" aria-label="Close"></button>
                    <h4 class="modal-title">OTP Verification To Access DGARM</h4>

                </div>
                <div class="modal-body" style="padding:0px !important;">
                    <!-- general form elements -->
                    <div class="box-body">
                        <div class="form-group" style="margin-bottom:0px !important;">
                            <div class="col-lg-12 col-md-12 col-sm-12">                               
                                <div id="div_feedback_enhance_bind">                                 
                                    <div class="col-lg-12 col-md-12 col-sm-12" style="padding-top:20px; padding-bottom:20px;">
                                        <input type="hidden" id="HD_usertype" />
                                        <input type="hidden" id="HD_UserCode" />
                                        <div class="col-lg-3 col-md-3 col-sm-3 align-right" style="margin-top:10px;">
                                            Enter OTP *
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                            <input type="text" class="form-control" id="txt_OTP" placeholder="Enter OTP">
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-3">
                                            <input type="button" class="btn btn-success" id="btn_verify" value="Verify OTP" />
                                        </div>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12" style="padding-bottom:20px;display:none;" id="div_resend_otp" >
                                        <div class="col-lg-3 col-md-3 col-sm-3">                                         
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6" style="margin-top: 10px;">
                                          Not Received OTP Resend in <span class="timer"></span> mins?
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-3">
                                            <input type="button" class="btn btn-warning" value="Resend OTP" id="btn_resend_otp" style="display:none;" />
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 align-center" id="div_display_mob" style="display:none;">
                                        <p style="color:red">OTP has been successfully sent to #######<span id="spn_mob">###</span></p>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 align-center" id="div_alert_msg" style="display:none;">
                                        <p style="color:red" id="alert_msg"></p>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div>

                    <!-- /.box-body -->

                </div>


                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-right close_modal" data-dismiss="modal" aria-label="Close">Close</button>
                </div>


            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>

   <!--  @*----------------- DG System-------------------*@ -->
    <div class="modal info-custom" id="modal-feedback-details-ddm" style="overflow-y: scroll !important;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close close_modal" data-dismiss="modal" aria-label="Close"></button>
                    <h4 class="modal-title">OTP Verification To Access DG System and Data Management</h4>

                </div>
                <div class="modal-body" style="padding:0px !important;">
                    <!-- general form elements -->
                    <div class="box-body">
                        <div class="form-group" style="margin-bottom:0px !important;">
                            <div class="col-lg-12 col-md-12 col-sm-12">
                                <div id="div_feedback_enhance_bind_ddm">
                                    <div class="col-lg-12 col-md-12 col-sm-12" style="padding-top:20px; padding-bottom:20px;">
                                        <input type="hidden" id="HD_usertype_ddm" />
                                        <input type="hidden" id="HD_UserCode_ddm" />
                                        <div class="col-lg-3 col-md-3 col-sm-3 align-right" style="margin-top:10px;">
                                            Enter OTP *
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                            <input type="text" class="form-control" id="txt_OTP_ddm" placeholder="Enter OTP">
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-3">
                                            <input type="button" class="btn btn-success" id="btn_verify_ddm" value="Verify OTP" />
                                        </div>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12" style="padding-bottom:20px;display:none;" id="div_resend_otp_ddm">
                                        <div class="col-lg-3 col-md-3 col-sm-3">
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6" style="margin-top: 10px;">
                                            Not Received OTP Resend in <span class="timer"></span> mins?
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-3">
                                            <input type="button" class="btn btn-warning" value="Resend OTP" id="btn_resend_otp_ddm" style="display:none;" />
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 align-center" id="div_display_mob_ddm" style="display:none;">
                                        <p style="color:red">OTP has been successfully sent to #######<span id="spn_mob_ddm">###</span></p>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 align-center" id="div_alert_msg_ddm" style="display:none;">
                                        <p style="color:red" id="alert_msg_ddm"></p>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div>

                    <!-- /.box-body -->

                </div>


                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-right close_modal" data-dismiss="modal" aria-label="Close">Close</button>
                </div>


            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>

    <script>

        function setModalMaxHeight(element) {
            this.$element = $(element);
            this.$content = this.$element.find('.modal-content');
            var borderWidth = this.$content.outerHeight() - this.$content.innerHeight();
            var dialogMargin = $(window).width() < 768 ? 20 : 60;
            var contentHeight = $(window).height() - (dialogMargin + borderWidth);
            var headerHeight = this.$element.find('.modal-header').outerHeight() || 0;
            var footerHeight = this.$element.find('.modal-footer').outerHeight() || 0;
            var maxHeight = contentHeight - (headerHeight + footerHeight);

            this.$content.css({
                'overflow': 'hidden'
            });

            this.$element
              .find('.modal-body').css({
                  'max-height': maxHeight,
                  'overflow-y': 'auto'
              });
        }

        $('.modal').on('show.bs.modal', function () {
            $(this).show();
            setModalMaxHeight(this);
        });

        $(window).resize(function () {
            if ($('.modal.in').length != 0) {
                setModalMaxHeight($('.modal.in'));
            }
        });
    </script>


    <!--END UPTO-INSTRUCTION-MODAL POP-UP-->
    @RenderBody()

    

    <footer class="main-footer">
        <div class="text-center hindi">
            <strong> <a href="https://www.cbecddm.gov.in">आँकड़ा प्रबंधन निदेशालय <b style="color: #d9534f; font: italic;">सेवारत करदाताओं के लिए प्रभावन तकनीक </b></a>.</strong> सभी अधिकार सुरक्षित.
        </div>
        <div class="text-center eng">
            <i style="color: #d9534f; font: italic; font-size: 16px;">
                <strong> Leveraging Technology for Serving Taxpayers</strong>
            </i><br />
            <strong>
                 <a href="https://www.cbecddm.gov.in">
                    Directorate of Data Management
                </a>.
            </strong> All rights reserved.
        </div>

    </footer>
 <style>
        .btn-default {
            margin-bottom: 10px !important;
            margin-right: 30px !important;
            margin-top: 20px !important;
        }

        .align-right {
        text-align:right !important;
        }
        .align-center {
            text-align: center !important;
        }
        .align-left {
            text-align: left !important;
        }
    </style>
	
    <!-- @*Theme Scripts*@ -->
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/metisMenu.min.js"></script>
    <!-- @*<script src="~/Content-GST/jsGST/morris-data.js"></script>
        <script src="~/Content-GST/jsGST/raphael.min.js"></script>
        <script src="~/Content-GST/jsGST/morris.min.js"></script>*@ -->
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/sb-admin-2.js"></script>

    <!-- @*Common Scripts*@ -->

    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/jquery-ui.js"></script>
    <!-- @*----------------- DGARM-------------------*@ -->
    <script>
        jQuery('#dgarm_validate').click(function () {
            $('#modal-feedback-details').show();
            OTP_Generate();
        });


        jQuery('#btn_resend_otp').click(function () {
            OTP_Generate();
        });


        function OTP_Generate() {

            $.get('/MIS/DGARM/Insert/Generate_OTP', null, function (data) {
                var msg = data.msg;
                console.log(msg);
                if (msg == 'done') {
                    $('#div_resend_otp').show();
                    $('#div_display_mob').show();
                    $('#spn_mob').text(data.mob);
                    $('#HD_usertype').val(data.usertype);
                    $('#HD_UserCode').val(data.usercode);

                    var minutes = 3;
                    var seconds = minutes * 60;
                    var countdown = setInterval(function () {
                        var current = convertIntToTime(seconds); // set the display of the time
                        $('.timer').html(current); // place the display time in the div
                        if (seconds == 00) {
                            $('#btn_resend_otp').show();
                            clearInterval(countdown); // stop the time when there are no more seconds
                        }
                        seconds--; // subtract a second
                    }, 1000);
                }
                else {
                    $('#div_resend_otp').hide();
                    $('#div_display_mob').hide();
                    $('#div_alert_msg').show();
                    $('#alert_msg').text(msg);
                }
            });
        }

        function convertIntToTime(num) {
            var mins = Math.floor(num / 60);
            var secs = num % 60;
            var timerOutput = (mins < 10 ? "0" : "") + mins + ":" + (secs < 10 ? "0" : "") + secs;
            return (timerOutput);
        }

        $('.close_modal').click(function () {
            $('#modal-feedback-details').hide();
            window.location.href = "/MIS/GSTHome/Home";
        });

        
        jQuery('#btn_verify').click(function () {
            var _otp = jQuery('#txt_OTP').val();
            var _usertype = $('#HD_usertype').val();
            var _usercode = $('#HD_UserCode').val();
            //window.location.href = "/MIS/DGARM/NavigationDGARM/Home";
            //return false;

            if (_otp != '' && _usertype != '' && _usercode != '') {
                $.get('/MIS/DGARM/Insert/Validate_OTP', { OTP: _otp, UserType: _usertype, UserCode: _usercode }, function (data) {
                    if (data == 'validate') {
                        window.location.href = "/MIS/DGARM/NavigationDGARM/Home";
                    }
                    else {
                        $('#div_alert_msg').show();
                        $('#alert_msg').text(data);
                    }
                });
            }
            else {
                alert("There is something missing");
            }

        });
    </script>

   <!--  @*----------------- DG System-------------------*@ -->
    <script>
        jQuery('#dgddm_validate').click(function () {
            $('#modal-feedback-details-ddm').show();
            OTP_Generate_ddm();
        });


        jQuery('#btn_resend_otp_ddm').click(function () {
            OTP_Generate_ddm();
        });


        function OTP_Generate_ddm() {

            $.get('/MIS/DGDDM/Insert/Generate_OTP', null, function (data) {
                var msg = data.msg;
                console.log(msg);
                if (msg == 'done') {
                    $('#div_resend_otp_ddm').show();
                    $('#div_display_mob_ddm').show();
                    $('#spn_mob_ddm').text(data.mob);
                    $('#HD_usertype_ddm').val(data.usertype);
                    $('#HD_UserCode_ddm').val(data.usercode);

                    var minutes = 3;
                    var seconds = minutes * 60;
                    var countdown = setInterval(function () {
                        var current = convertIntToTime(seconds); // set the display of the time
                        $('.timer').html(current); // place the display time in the div
                        if (seconds == 00) {
                            $('#btn_resend_otp_ddm').show();
                            clearInterval(countdown); // stop the time when there are no more seconds
                        }
                        seconds--; // subtract a second
                    }, 1000);
                }
                else {
                    $('#div_resend_otp_ddm').hide();
                    $('#div_display_mob_ddm').hide();
                    $('#div_alert_msg_ddm').show();
                    $('#alert_msg_ddm').text(msg);
                }
            });
        }

        function convertIntToTime(num) {
            var mins = Math.floor(num / 60);
            var secs = num % 60;
            var timerOutput = (mins < 10 ? "0" : "") + mins + ":" + (secs < 10 ? "0" : "") + secs;
            return (timerOutput);
        }

        $('.close_modal').click(function () {
            $('#modal-feedback-details-ddm').hide();
            window.location.href = "/MIS/GSTHome/Home";
        });


        jQuery('#btn_verify_ddm').click(function () {
            var _otp = jQuery('#txt_OTP_ddm').val();
            var _usertype = $('#HD_usertype_ddm').val();
            var _usercode = $('#HD_UserCode_ddm').val();
            //window.location.href = "/MIS/DGARM/NavigationDGARM/Home";
            //return false;

            if (_otp != '' && _usertype != '' && _usercode != '') {
                $.get('/MIS/DGDDM/Insert/Validate_OTP', { OTP: _otp, UserType: _usertype, UserCode: _usercode }, function (data) {
                    if (data == 'validate') {
                        window.location.href = "/MIS/DGDDM/NavigationDGDDM/Home";
                    }
                    else {
                        $('#div_alert_msg_ddm').show();
                        $('#alert_msg_ddm').text(data);
                    }
                });
            }
            else {
                alert("There is something missing");
            }

        });
    </script>



    <script language="javascript">
        $(document).ready(function () {
            $('.hindi').hide();
            $('#english_button').hide();
        });

        function Bilingual_Hindi() {
            $('.eng').hide();
            $('.hindi').show();
            $('#hindi_button').hide();
            $('#english_button').show();
        }


        function Bilingual_Eng() {
            $('.eng').show();
            $('.hindi').hide();
            $('#hindi_button').show();
            $('#english_button').hide();
        }


    </script>



    <!-- @*Script For File Upload Icons*@ -->
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/jsGST/bootstrap-filestyle.min.js"></script>
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/jsGST/bootstrap-filestyle.js"></script>

    <!-- @*Script For Datatable*@ -->

    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/jsGST/dataTables.bootstrap.min.js"></script>
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/jsGST/jquery.dataTables.min.js"></script>
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/jsGST/dataTables.responsive.js"></script>
    
</body>
</html>
