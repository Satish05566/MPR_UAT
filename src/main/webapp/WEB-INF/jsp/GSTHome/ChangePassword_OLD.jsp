<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ddm.cbic.controller.LoginController"%>
<%@ page import="java.io.*,java.util.*"%>
<!-- Stylesheet for Bootstrap -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet" type='text/css' />
<!-- Font Awesome -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type='text/css' />

<!-- Stylesheet for Theme -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/metisMenu.min.css"
	rel="stylesheet" />
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/morris.css" rel="stylesheet" />


<!-- Stylesheet for Datatable -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/dataTables.bootstrap.css"
	rel="stylesheet" />
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/dataTables.responsive.css"
	rel="stylesheet" />

<!-- Stylesheet for Custom Work -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/sb-admin-2.css"
	rel="stylesheet" />





<!-- @{
    ViewBag.Title = "Desk";
    Layout = null;
}
 -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Directorate of Data Management</title>
<meta name="viewport" content="width=device-width" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge">
 -->
<style>
#page-wrapper {
	position: inherit;
	margin: 0 0 0 0 !important;
	padding: 0 30px;
	border-left: 1px solid #e7e7e7;
}

.btn-green {
	color: #fff;
	background-color: #5cb85c;
	border-color: #5cb85c;
}

.btn-green:hover {
	color: #fff;
	background-color: #2d7d2d;
}

.btn-yellow {
	color: #fff;
	background-color: #f0ad4e;
	border-color: #f0ad4e;
}

.btn-yellow:hover {
	color: #fff;
	background-color: #e28e16;
}

.btn-red {
	color: #fff;
	background-color: #d9534f;
	border-color: #d9534f;
}

.btn-red:hover {
	color: #fff;
	background-color: #9a2424;
}

.nav>li>a:hover {
	background-color: #184b77 !important;
	color: #fff;
}

.huge {
	font-size: 32px !important;
}

.red {
	color: #d9534f !important;
}

.green {
	color: #5cb85c !important;
}

.primary {
	color: #337ab7 !important;
}
</style>


</head>
<body>
	<%-- 
<%  response.setHeader("viewport", "width=device-width, initial-scale=1"); 
    response.setHeader("description", "");
    response.setHeader("author", "");
    response.setHeader("viewport","width=device-width");  
%> --%>


	


		<div id="wrapper">
			<!-- Navigation -->

			<nav class="navbar navbar-default navbar-static-top"
				role="navigation" style="margin-bottom: 0">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle"
						data-toggle="collapse in" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
							 <span	class="icon-bar"></span>
					</button>
					<img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/imagesGST/CBECDDM-Logo-New.png" />
				</div>
				<!--  
             <div>
                <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content/Logo/Merge-Eng.png" class="eng_logo eng" />
                <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content/Logo/Merge-Hindi.png" class="hindi_logo hindi " />
            </div> 
-->
				
             <% String USER=(String) request.getSession().getAttribute("USER");
             
             if((USER!=null) || (USER!="")){ %>
				<ul class="nav navbar-top-links navbar-right">

					<li class="dropdown"><a class="btn btn-primary"
						id="hindi_button" onclick="javascript:Bilingual_Hindi();"
						style="padding: 5px; min-height: 5px; padding-left: 15px; padding-right: 15px;">
							हिन्दी में </a> <a class="btn btn-primary" id="english_button"
						onclick="javascript:Bilingual_Eng();"
						style="padding: 5px; min-height: 5px; padding-left: 15px; padding-right: 15px;">
							English </a></li>




					<li class="dropdown"><a href='http://www.cbecddm.gov.in'
						target="_blank" class="btn btn-primary eng"
						style="padding: 5px; min-height: 5px; padding-left: 15px; padding-right: 15px;">
							<i class="fa fa-sign-out fa-fw"></i> Home
					</a> <a href='http://www.cbecddm.gov.in/ddm/h/index.aspx'
						target="_blank" class="btn btn-primary hindi"
						style="padding: 5px; min-height: 5px; padding-left: 15px; padding-right: 15px;">
							<i class="fa fa-sign-out fa-fw"></i> मुख्य पृष्ठ
					</a></li>
					<br />
					<!-- 
					<li class="dropdown" style="float: left; margin-top: 5px;"><a
						href='<%= session.getAttribute("JSP_PATH_RESOLVE") %>../UPLOAD/cbic-sanchar-manual.pdf' target="_blank"
						class="btn btn-primary eng"
						style="padding: 5px; min-height: 5px !important;"> <i
							class="fa fa-download fa-fw"></i> About CBIC-Sanchar
					</a> <a href='<%= session.getAttribute("JSP_PATH_RESOLVE") %>../UPLOAD/cbic-sanchar-manual.pdf'
						target="_blank" class="btn btn-primary hindi"
						style="padding: 5px; min-height: 5px !important;"> <i
							class="fa fa-download fa-fw"></i> सीबीआईसी-सांचर के बारे में
					</a></li>
					  -->	
					<!-- /.dropdown @Session["USER"].ToString() -->

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>${USER}<i
							class="fa fa-caret-down"></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<%
								String TYPE = (String) request.getSession().getAttribute("TYPE");
								if ((TYPE != null && TYPE != "") && ((TYPE.substring(0, 2) != "FO") || (TYPE.substring(0, 4) == "CBEC"))) {
									if (USER != "ddmC1_cbec") {
							%>
							<li><a class="hindi" href='/DGHRD/DGHome/Profile'><i
									class="fa fa-user fa-fw"></i> उपयोगकर्ता पार्श्वक</a></li>
							<li><a class="eng" href='/DGHRD/DGHome/Profile'><i
									class="fa fa-user fa-fw"></i> User Profile</a></li>
							<%
								}
								}
							%>
							
							<li><a class="hindi" href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Logout'><i
									class="fa fa-sign-out fa-fw"></i> लॉगआउट</a> <a class="eng"
								href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Logout'><i class="fa fa-sign-out fa-fw"></i>
									Logout</a></li>

						</ul> <!-- /.dropdown-user --></li>
					<!-- /.dropdown -->
				</ul>
				<br />
			
           <% }%>
				<!-- else
            {
                 Response.Redirect("~/Logout");
            }-->
			</nav>

			<!-- /#page-wrapper -->
		</div>
		<!-- /#wrapper -->
		<!---Body Section-->

	<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><i class="fa fa-lock fa-fw"></i> Change Password</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <!-- @using (Html.BeginForm())
    {
         @Html.AntiForgeryToken() -->
        
               <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        User Profile Details
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <%
                                String msg = (String)request.getAttribute("message");
                                
                                //@if (!string.IsNullOrWhiteSpace(@Convert.ToString(ViewBag.Message)))
                                if(!msg.isEmpty()){%>	
                                <div class="col-lg-12">
                                    <div class="alert" id="login_error">
                                        <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                                        <!-- @ViewBag.Message -->
                                        ${message}
                                    </div>
                                </div> <% } %>
                                <form role="form" action="/MIS/GSTHome/PasswordChange" id="PasswordChangeForm" method="POST">
                                    <div class="form-group">
                                        <div class="input-group" id="txt_password">
                                            <span class="input-group-addon" id="basic-addon1">Old Password</span>
                                            <input type="password" class="form-control" name="txt_OldPass" id="txt_OldPass" required placeholder="Enter Old Password" aria-describedby="basic-addon1">
                                            <span class="input-group-addon" id="basic-addon1"><i class="fa fa-eye" aria-hidden="true" onmouseover="mouseoverPassOld();" onmouseout="mouseoutPassOld();"></i></span>
                                        </div>
                                        </div>
                                    <div class="form-group">
                                        <div class="input-group" id="txt_password">
                                            <span class="input-group-addon" id="basic-addon2">New Password</span>
                                            <input type="password" class="form-control" name="txt_pass" id="txt_pass" required placeholder="Enter New Password" aria-describedby="basic-addon2">
                                            <span class="input-group-addon" id="basic-addon2"><i class="fa fa-eye" aria-hidden="true" onmouseover="mouseoverPassNew();" onmouseout="mouseoutPassNew();"></i></span>
                                        </div>
                                    </div>                          
                                    <input type="submit" class="btn btn-success" value="Change Password" style="float:right" />
                                </form>
                            </div>
                            <!-- /.col-lg-6 (nested) -->
                            <!-- /.col-lg-6 (nested) -->
                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        
       <!-- } -->

</div>

		<footer class="main-footer">
			<div class="text-center hindi">
				<i style="color: #d9534f; font: italic;">सेवारत करदाताओं के लिए
					प्रभावन तकनीक</i><br /> <strong> <a
					href="https://www.cbecddm.gov.in">आँकड़ा प्रबंधन निदेशालय</a>.
				</strong> सभी अधिकार सुरक्षित.
			</div>
			<div class="text-center eng">
				<i style="color: #d9534f; font: italic;">Leveraging Technology
					for Serving Taxpayers</i><br /> <strong> <a
					href="https://www.cbecddm.gov.in"> Directorate of Data
						Management </a>.
				</strong> All rights reserved.
			</div>
		</footer>

		<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/jquery-3.6.0.min.js"></script>

		<style>
.btn-default {
	margin-bottom: 10px !important;
	margin-right: 30px !important;
	margin-top: 20px !important;
}

.align-right {
	text-align: right !important;
}

.align-center {
	text-align: center !important;
}

.align-left {
	text-align: left !important;
}
</style>

		<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/jquery-ui.js"></script>
		<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/jquery-3.5.0.min.js"></script>
		<!-- @*Theme Scripts*@ -->
		<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/metisMenu.min.js"></script>
		<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/morris-data.js"></script>
		<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/raphael.min.js"></script>
		<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/morris.min.js"></script>
		<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/sb-admin-2.js"></script>

		<!-- @*Common Scripts*@ -->

		<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/bootstrap-3.3.7/js/bootstrap.min.js"></script>

		<script language="javascript">
			$(document).ready(function() {
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

		<!---START TO SHOW- Modal POP-UP-->
		<script src="~/js/jquery.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#btn_analytical').click(function() {
					$('#modal_analytical').modal('show')
				});
				$('#btn_mis').click(function() {
					$('#modal_mis').modal('show')
				});
				$('#btn_monitoring').click(function() {
					$('#modal_monitoring').modal('show')
				});
				$('#btn_multi').click(function() {
					$('#modal_multi').modal('show')
				});
			});
		</script>
</body>
</html>

<!-- ----------------- DGADMIN------------------- -->

