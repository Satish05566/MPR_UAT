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


	<form>


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
							<li><a class="hindi" href='/MIS/GSTHome/ChangePassword'><i
									class="fa fa-gear fa-fw"></i> पासवर्ड बदलें</a> <a class="eng"
								href='/MIS/GSTHome/ChangePassword'><i
									class="fa fa-gear fa-fw"></i> Change Password</a></li>
							<li class="divider"></li>
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

					<h1 class="page-header hindi"
						style="text-align: center; color: #0268bf;">सीबीआईसी संचार
						में आपका स्वागत है।</h1>
					<h1 class="page-header eng"
						style="text-align: center; color: #0268bf;">

						Welcome to CBIC - Sanchar <img id="cbic_sanchar"
							src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content/Logo/CBICDDM.png"
							style="height: 75px; width: 75px;" />

					</h1>

				</div>

				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->


			<div class="row">

				<div class="col-lg-12 col-md-12">
					<div class="col-lg-2 col-md-6" style="padding-top: 50px;"></div>
					<div class="col-lg-4 col-md-6" style="padding-top: 50px;">
						<div class="panel panel-red">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-book fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge hindi">पीएमएम, डब्लूआरआर, जीईएम,
											इत्यादि</div>
										<div class="huge eng">PMM, WRR,GeM etc.</div>
										<div></div>
									</div>
								</div>
							</div>
							<a href="#">
								<div class="panel-footer">
									<span class="pull-left"> <a id="btn_multi"
										class="btn btn-red float-right"><i
											class="fa fa-sign-in fa-2x"></i></a>


									</span> <span class="pull-right"><i
										class="fa fa-arrow-circle-right"></i></span>
									<div class="clearfix"></div>
								</div>
							</a>
						</div>
					</div>
					

					<div class="col-lg-4 col-md-6" style="padding-top: 50px;">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-book fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge hindi">मुख्य निष्पादन संकेतक</div>
										<div class="huge eng">Key Performance Indicators</div>

										<div></div>
									</div>
								</div>
							</div>
							<a href="#">
								<div class="panel-footer">
									<span class="pull-left"> <a id="btn_mis"
										class="btn btn-primary float-right"><i
											class="fa fa-sign-in fa-2x"></i></a>


									</span> <span class="pull-right"><i
										class="fa fa-arrow-circle-right"></i></span>
									<div class="clearfix"></div>
								</div>
							</a>
						</div>
					</div>

					<div class="col-lg-2 col-md-6" style="padding-top: 50px;"></div>

				</div>


				<div class="col-lg-12 col-md-12">

					<div class="col-lg-2 col-md-6" style="padding-top: 50px;"></div>
					<div class="col-lg-4 col-md-6" style="padding-top: 50px;">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-book fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge hindi">सामान्य संसूचना</div>
										<div class="huge eng">General Communication</div>
										<div></div>
									</div>
								</div>
							</div>
							<a href="#">
								<div class="panel-footer">
									<span class="pull-left"> <a id="btn_monitoring"
										class="btn btn-primary float-right"><i
											class="fa fa-sign-in fa-2x"></i></a>
									</span> <span class="pull-right"><i
										class="fa fa-arrow-circle-right"></i></span>
									<div class="clearfix"></div>
								</div>
							</a>
						</div>
					</div>
					
					<div class="col-lg-4 col-md-6" style="padding-top: 50px;">
						<div class="panel panel-green">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-book fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge hindi">निदेशालयों की विश्लेषण रिपोर्टें</div>
										<div class="huge eng">Analytical Reports of Directorates</div>
										<div></div>
									</div>
								</div>
							</div>
							<a href="#">
								<div class="panel-footer">
									<span class="pull-left"> 
									<a id="btn_analytical" class="btn btn-green float-right">
									<i	class="fa fa-sign-in fa-2x"></i></a>
									</span> <span class="pull-right"><i
										class="fa fa-arrow-circle-right"></i></span>
									<div class="clearfix"></div>
								</div>
							</a>
						</div>
					</div>
					
					<div class="col-lg-2 col-md-6" style="padding-top: 50px;"></div>

				</div>

			</div>
			<!-- /.row -->
			<!-- /.row -->
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
		<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/jquery-3.6.0.min.js"></script>
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

		<!---END TO SHOW- Modal POP-UP-->
		<!--  START Analytical Reports Modal POP-UP-->

		<div id="modal_analytical" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content"
					style="overflow: hidden; text-align: justify; padding-left: 20px; padding-right: 20px;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title green hindi">निदेशालयों की विश्लेषण
							रिपोर्टें</h4>
						<h4 class="modal-title green eng">Analytical Reports of
							Directorates</h4>
					</div>
					<div class="modal-body" style="overflow-y: auto;">


						<p class="hindi">'निदेशालयों की विश्लेषण रिपोर्ट’ मापांक में
							विभिन्न प्रकार की रिपोर्टें/आँकड़े समाहित हैं, जिसे व्यक्तिगत
							निदेशालयों द्वारा क्षेत्रीय गठनों से संरचित प्रतिक्रिया प्राप्त
							करने हेतु, भेजना आवश्यक है। इसप्रकार की प्रत्येक रिपोर्ट को एक
							विशेष रिपोर्ट आईडी संख्या के द्वारा पहचाना जा सकता है। इस मापांक
							की मुख्यतः दो विशेषताएँ हैं। पहला,प्रयोक्ता निदेशालय द्वारा
							विश्लेषित रिपोर्ट/आंकड़े को अनुप्रयोग पर अपलोड कर अपेक्षित प्रापक
							क्षेत्रीय गठनों को भेजा जा सकेगा। इसके साथ ही प्रापक क्षेत्रीय
							गठनों या अखिल भारतीय गठनों के संयोजन को चुनने का भी विकल्प उपलब्ध
							है। दूसरा,प्रापक क्षेत्रीय गठन प्रतिक्रिया को संरचित क्षेत्रों
							में अपलोड कर पाएंगे,जिससे प्रेषक निदेशालय को संकलन में सुविधा
							होगी।</p>
						<p class="eng">'Analytical Reports of Directorates' module
							contains various reports/data that the individual Directorates
							need to send to the field formaitons for obtaining a structured
							feedback. Each such report is identified by a unique Report Id
							No. There are two main features of this module.Firstly the user
							Directorate would push the analysed report/data to the intended
							recipient field formation by uploading it on to the application.
							There is also an option to select any combination of recipient
							field formations or even 'All India'. Secondly, the recipient
							field formation would be able to upoad the response in structured
							fields thereby enabling ease of compilation by the sender
							Directorate.</p>
						<p class="hindi">
							<i class="fa fa-circle green" aria-hidden="true"></i>&nbsp;
							विश्लेषण रिपोर्ट
						</p>
						<p class="eng">
							<i class="fa fa-circle green" aria-hidden="true"></i>&nbsp;
							Analytical Reports
						</p>
						<p class="hindi">
							<i class="fa fa-circle green" aria-hidden="true"></i>&nbsp; की
							गयी कार्रवाई की रिपोर्टें
						</p>
						<p class="eng">
							<i class="fa fa-circle green" aria-hidden="true"></i>&nbsp;
							Action taken Reports
						</p>
						<p class="hindi">
							<i class="fa fa-circle green" aria-hidden="true"></i>&nbsp;
							प्रतिक्रिया
						</p>
						<p class="eng">
							<i class="fa fa-circle green" aria-hidden="true"></i>&nbsp;
							Feedback
						</p>
						<p class="hindi">
							<i class="fa fa-circle green" aria-hidden="true"></i>&nbsp; सार
						</p>
						<p class="eng">
							<i class="fa fa-circle green" aria-hidden="true"></i>&nbsp;
							Summary Report
						</p>
						<p class="hindi">
							<i class="fa fa-circle green" aria-hidden="true"></i>&nbsp;
							सामान्य रिपोर्ट
						</p>
						<p class="eng">
							<i class="fa fa-circle green" aria-hidden="true"></i>&nbsp;
							General Reports
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Back</button>
						<a class="btn btn-green float-right"
							href='/MIS/GSTHome/DirectorateDesk'><i
							class="fa fa-sign-in fa-2x"></i></a> <a class="btn btn-danger"
							data-dismiss="modal" style="margin-right: 10px;"><i
							class="fa fa-sign-in fa-2x fa-rotate-180"></i></a>
					</div>
				</div>

			</div>
		</div>

		<!---END TO SHOW-Analytical Reports Modal POP-UP-->
		<!--  START MIS Reports Modal POP-UP-->

		<div id="modal_mis" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content"
					style="overflow: hidden; text-align: justify; padding-left: 20px; padding-right: 20px;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title primary eng">Key Performance
							Indicators</h4>
						<h4 class="modal-title primary hindi">मुख्य निष्पादन संकेतक</h4>
					</div>
					<div class="modal-body" style="overflow-y: auto;">

						<p class="hindi">इस अनुप्रयोग में राजस्व निष्पादन की निगरानी
							तथा विश्लेषण के लिए विभिन्न प्रकार के मापांक समाहित हैं।
							प्रथम,मासिक आधार पर विभागीय गठनों द्वारा मासिक निष्पादन
							रिपोर्ट(एमपीआर)को अपलोड किया जा सकेगा। एमपीआर में उपलब्ध आँकड़े को
							कार्यव्यवहार की निगरानी के लिए विश्लेषित किया जाएगा।</p>
						<p class="eng">This application contains various types of
							modules monitoring and analyzing revenue performance.First,the
							Monthly Performance Report(MPR) is uploaded by the departments
							formations on a monthly basis.The data contained in the MPR is
							analyzed for monitoring the performance.</p>
						<p class="hindi">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							एमपीआर
						</p>
						<p class="eng">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							Monthly Performance Report (MPR)
						</p>
						<p class="hindi">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							मासिक सारांश
						</p>
						<p class="eng">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							Monthly Summary Report (MSR)
						</p>
						<p class="hindi">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							राजस्व प्रवृतियाँ
						</p>
						<p class="eng">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							Monthly Revenue Report (MRR)
						</p>
						<p class="hindi">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							राजस्व निष्पादन
						</p>
						<p class="eng">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							Monthly Revenue Performance Report (FMR)
						</p>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Back</button>
						<a class="btn btn-primary float-right"
							href='/MIS/GSTHome/Home'><i
							class="fa fa-sign-in fa-2x"></i></a> <a class="btn btn-danger"
							data-dismiss="modal" style="margin-right: 10px;"><i
							class="fa fa-sign-in fa-2x fa-rotate-180"></i></a>
					</div>
				</div>

			</div>
		</div>

		<!---END TO SHOW- MIS Reports Modal POP-UP-->
		<!--  START Monitoring Feedback Reports Modal POP-UP-->

		<div id="modal_monitoring" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content"
					style="overflow: hidden; text-align: justify; padding-left: 20px; padding-right: 20px;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title primary eng">General Communication</h4>
						<h4 class="modal-title primary hindi">सामान्य संसूचना</h4>
					</div>

					<div class="modal-body" style="overflow-y: auto;">
						<p class="hindi">यह अनुप्रयोग सीबीआईसी प्रयोक्ताओं के मध्य
							शीघ्र एवं सुलभ अंतःक्रिया/सम्प्रेषण के लिए एक मंच उपलब्ध करवाता
							है। क्षेत्रीय गठनों को भेजी गयी प्रत्येक रिपोर्ट/आँकड़े को एक
							विशिष्ट रिपोर्ट आईडी संख्या द्वारा पहचाना जा सकता है। आरंभ मे
							प्रयोक्ता द्वारा विश्लेषित रिपोर्ट/आँकड़े को अनुप्रयोग पर अपलोड कर
							अपेक्षित गठनों को भेजा जा सकता है। इसके साथ ही अखिल भारतीय स्तर
							पर प्रेषक गठनों एवं प्रयोक्ताओं के संयोजन को चुनने का विकल्प भी
							उपलब्ध है। प्रेषक गठनों द्वारा अपनी प्रतिक्रिया को संरचित
							क्षेत्रों में अपलोड किया जाना आवश्यक है। इस अनुप्रयोग के कुछ
							अपेक्षित लाभ निम्नलिखित हैं।</p>
						<p class="eng">This Application provides a platform for quick
							and easy interaction/communication among CBIC's users. Each
							report/data sent to the field formations for a response is
							identified by a unique Report Id No. Initially, the user would
							push the analysed report/data to the intended recipient formation
							by uploading it on to the application. There is also an option to
							select any combination of recipient formations or users on All
							India basis. The recipient formation is required to respond by
							uploading its response in structured fields. The following are
							some of the intended benifits of the application</p>
						<p class="hindi"></p>
						<p class="eng">The main purpose of the General Communication
							is to interact between CBIC users. Inside this Application we
							have various types of features to communicate between each users.
							We can Compose Report to multiple users at a one time.Also we can
							forward the sent report to another user according to particular
							user. we can view the status of the Recipient & Sender of Users.
						</p>

						<p class="hindi">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							संचारण
						</p>
						<p class="eng">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							Quick & easy communication
						</p>
						<p class="hindi">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							रिपोर्ट्स
						</p>
						<p class="eng">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							Reports in structured form
						</p>
						<p class="hindi">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							धारा प्रश्न
						</p>
						<p class="eng">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							Prompt replies to Parliament Questions
						</p>
						<p class="hindi">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							निगमनों से प्राप्त सामान्य सूचनाएँ
						</p>
						<p class="eng">
							<i class="fa fa-circle primary" aria-hidden="true"></i>&nbsp;
							Different types of information from formations
						</p>
					</div>
					<div class="modal-footer">
						<a class="btn btn-danger"
							data-dismiss="modal" style="margin-right: 10px;"><i
							class="fa fa-sign-in fa-2x fa-rotate-180"></i></a>
						<!-- <button type="button" class="btn btn-danger" data-dismiss="modal">Back</button> -->
						<a class="btn btn-primary float-right"
							href='Home'><i
							class="fa fa-sign-in fa-2x"></i></a> 
							
							<a class="btn btn-primary float-right"
							href='/MIS/DRN/Home'><i
							class="fa fa-sign-in fa-2x"></i></a> 
							
							<!-- 
						<a class="btn btn-primary float-right"
							href='/MIS/DRN/Home'>--<i
							class="fa fa-sign-in fa-2x"></i>--</a> <a class="btn btn-danger"
							data-dismiss="modal" style="margin-right: 10px;"><i
							class="fa fa-sign-in fa-2x fa-rotate-180"></i></a>	
						 -->

					</div>
				</div>

			</div>
		</div>

		<!---END TO SHOW- Monitoring Feedback Reports Modal POP-UP-->
		<!--  START Multi Functional Reports Modal POP-UP-->

		<div id="modal_multi" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content"
					style="overflow: hidden; text-align: justify; padding-left: 20px; padding-right: 20px;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title red eng">PMM, WRR,GeM, etc.</h4>
						<h4 class="modal-title red hindi">पीएमएम, डब्लूआरआर, जीईएम,
							इत्यादि</h4>
					</div>
					<div class="modal-body" style="overflow-y: auto;">
						<p class="hindi">इस अनुप्रयोग में अलग-अलग विषयों जैसे अभियोग
							प्रबंधन,साप्ताहिक प्रतिदाय,कर विवाद निगरानी तथा सरकारी
							ई-बाज़ार(जीईएम)के लिए विभिन्न प्रकार के मापांक/रिपोर्ट उपलब्ध हैं।
						</p>
						<p class="eng">This Application contents various
							modules/reports on different subjects such as Prosecution
							Management, Weekly Refund, Tax Disputes Monitoring and Goverment
							e-Marketplace (GeM).</p>
						<p class="hindi">
							<i class="fa fa-circle red" aria-hidden="true"></i>&nbsp; अभियोग
							प्रबंधन
						</p>
						<p class="eng">
							<i class="fa fa-circle red" aria-hidden="true"></i>&nbsp;
							Prosecution Management
						</p>
						<p class="hindi">
							<i class="fa fa-circle red" aria-hidden="true"></i>&nbsp;
							साप्ताहिक प्रतिदाय
						</p>
						<p class="eng">
							<i class="fa fa-circle red" aria-hidden="true"></i>&nbsp; Weekly
							Refund
						</p>
						<p class="hindi">
							<i class="fa fa-circle red" aria-hidden="true"></i>&nbsp;
							ई-बाज़ार(जीईएम)
						</p>
						<p class="eng">
							<i class="fa fa-circle red" aria-hidden="true"></i>&nbsp;
							e-Marketplace (GeM)
						</p>
						<p class="hindi">
							<i class="fa fa-circle red" aria-hidden="true"></i>&nbsp; कर
							विवाद
						</p>
						<p class="eng">
							<i class="fa fa-circle red" aria-hidden="true"></i>&nbsp; Tax
							Disputes Monitoring
						</p>

						<p class="hindi">
							<i class="fa fa-circle red" aria-hidden="true"></i>&nbsp; दक्षता
							लेखा-परीक्षा
						</p>
						<p class="eng">
							<i class="fa fa-circle red" aria-hidden="true"></i>&nbsp; Audit
							Efficiency
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Back</button>
						<a class="btn btn-red float-right"
							href="/MIS/GSTHome/ApplicationDesk"><i
							class="fa fa-sign-in fa-2x"></i></a> <a class="btn btn-danger"
							data-dismiss="modal" style="margin-right: 10px;"><i
							class="fa fa-sign-in fa-2x fa-rotate-180"></i></a>
					</div>
				</div>

			</div>
		</div>

		<!---END TO SHOW- Multi Functional Reports Modal POP-UP-->


		<!--   ----------------- DG Admin-OTP------------------- -->
		<div class="modal info-custom" id="modal-feedback-details-dgadmn"
			style="overflow-y: scroll !important;">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close close_modal"
							data-dismiss="modal" aria-label="Close"></button>
						<h4 class="modal-title">OTP Verification To Access DG System
							and Data Management</h4>

					</div>
					<div class="modal-body" style="padding: 0px !important;">
						<!-- general form elements -->
						<div class="box-body">
							<div class="form-group" style="margin-bottom: 0px !important;">
								<div class="col-lg-12 col-md-12 col-sm-12">
									<div id="div_feedback_enhance_bind_dgadmn">
										<div class="col-lg-12 col-md-12 col-sm-12"
											style="padding-top: 20px; padding-bottom: 20px;">
											<input type="hidden" id="HD_usertype_dgadmn" /> <input
												type="hidden" id="HD_UserCode_dgadmn" />
											<div class="col-lg-3 col-md-3 col-sm-3 align-right"
												style="margin-top: 10px;">Enter OTP *</div>
											<div class="col-lg-6 col-md-6 col-sm-6">
												<input type="text" class="form-control" id="txt_OTP_dgadmn"
													placeholder="Enter OTP">
											</div>
											<div class="col-lg-3 col-md-3 col-sm-3">
												<input type="button" class="btn btn-success"
													id="btn_verify_dgadmn" value="Verify OTP" />
											</div>
										</div>

										<div class="col-lg-12 col-md-12 col-sm-12"
											style="padding-bottom: 20px; display: none;"
											id="div_resend_otp_dgadmn">
											<div class="col-lg-3 col-md-3 col-sm-3"></div>
											<div class="col-lg-6 col-md-6 col-sm-6"
												style="margin-top: 10px;">
												Not Received OTP Resend in <span class="timer"></span> mins?
											</div>
											<div class="col-lg-3 col-md-3 col-sm-3">
												<input type="button" class="btn btn-warning"
													value="Resend OTP" id="btn_resend_otp_dgadmn"
													style="display: none;" />
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 align-center"
											id="div_display_mob_dgadmn" style="display: none;">
											<p style="color: red">
												OTP has been successfully sent to #######<span
													id="spn_mob_dgadmn">###</span>
											</p>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 align-center"
											id="div_alert_msg_dgadmn" style="display: none;">
											<p style="color: red" id="alert_msg_dgadmn"></p>
										</div>
									</div>

								</div>
							</div>

						</div>

						<!-- /.box-body -->

					</div>


					<div class="modal-footer">
						<button type="button"
							class="btn btn-default pull-right close_modal"
							data-dismiss="modal" aria-label="Close">Close</button>
					</div>


				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>

	</form>
</body>
</html>

<!-- ----------------- DGADMIN------------------- -->
<script>
	jQuery('#dgadmin_validate').click(function() {
		$('#modal-feedback-details-dgadmn').show();
		OTP_Generate();
	});

	jQuery('#btn_resend_otp_dgadmn').click(function() {
		OTP_Generate();
	});

	function OTP_Generate() {

		$.get('/DGADMIN/Insert/Generate_OTP', null, function(data) {
			var msg = data.msg;
			if (msg == 'done') {
				$('#div_resend_otp_dgadmn').show();
				$('#div_display_mob_dgadmn').show();
				$('#spn_mob_dgadmn').text(data.mob);
				$('#HD_usertype_dgadmn').val(data.usertype);
				$('#HD_UserCode_dgadmn').val(data.usercode);

				var minutes = 3;
				var seconds = minutes * 60;
				var countdown = setInterval(function() {
					var current = convertIntToTime(seconds); // set the display of the time
					$('.timer').html(current); // place the display time in the div
					if (seconds == 00) {
						$('#btn_resend_otp_dgadmn').show();
						clearInterval(countdown); // stop the time when there are no more seconds
					}
					seconds--; // subtract a second
				}, 1000);
			} else {
				$('#div_resend_otp_dgadmn').hide();
				$('#div_display_mob_dgadmn').hide();
				$('#div_alert_msg_dgadmn').show();
				$('#alert_msg_dgadmn').text(msg);
			}
		});
	}

	function convertIntToTime(num) {
		var mins = Math.floor(num / 60);
		var secs = num % 60;
		var timerOutput = (mins < 10 ? "0" : "") + mins + ":"
				+ (secs < 10 ? "0" : "") + secs;
		return (timerOutput);
	}

	$('.close_modal').click(function() {
		$('#modal-feedback-details-dgadmn').hide();
		window.location.href = "/MIS/GSTHome/Desk";
	});

	jQuery('#btn_verify_dgadmn').click(function() {
		var _otp = jQuery('#txt_OTP_dgadmn').val();
		var _usertype = $('#HD_usertype_dgadmn').val();
		var _usercode = $('#HD_UserCode_dgadmn').val();
		//window.location.href = "/DGARM/NavigationDGARM/Home";
		//return false;

		if (_otp != '' && _usertype != '' && _usercode != '') {
			$.get('/DGADMIN/Insert/Validate_OTP', {
				OTP : _otp,
				UserType : _usertype,
				UserCode : _usercode
			}, function(data) {
				if (data == 'validate') {
					window.location.href = "/DGADMIN/NavigationDGADMIN/Home";
				} else {
					$('#div_alert_msg_dgadmn').show();
					$('#alert_msg_dgadmn').text(data);
				}
			});
		} else {
			alert("There is something missing");
		}

	});
</script>

