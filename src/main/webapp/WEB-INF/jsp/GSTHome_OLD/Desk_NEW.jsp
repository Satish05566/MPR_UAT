<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>		
<!-- saved from url=(0038)/MIS/GSTHome/Desk -->
<html lang="en">
<head>
<link rel="icon" type="image/png"
	href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/images/logo/CBECDDM-Logo.png" sizes="16x16" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<!-- Font Awesome -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/css/mycss.css" rel="stylesheet">



<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Directorate of Data Management</title>
<meta name="viewport" content="width=device-width">

<style>
.clickable {
	cursor: pointer;
}
</style>


</head>

<body class="graybgcolor">
	<div id="wrapper" class="">
		<!-- Navigation -->

		<nav class="navbar-default-Main" role="navigation">


			<div class="nav-right">

				<ul class="nav navbar-top-links navbar-right">
				
					<li class="dropdown p-r-5"><a class="btn btn-third eng"
						href="http://www.cbecddm.gov.in/" target="_blank"> <i
							class="fa fa-sign-out fa-fw-main"></i> Home
					</a> <a class="btn btn-third hindi" href="#" target="_blank"
						style="display: none;"> <i class="fa fa-sign-out fa-fw-main"></i>
							मुख्य पृष्ठ
					</a></li>

					<li class="dropdown p-r-5">
						
						<a class="btn btn-third eng" href="javascript:void(0)" 
						onclick="window.open('<%= session.getAttribute("JSP_PATH_RESOLVE") %>UPLOAD/cbic-sanchar-manual.pdf')"
						> <i class="fa fa-sign-out fa-fw-main"></i>
							About CBIC-Sanchar
					</a> 
					
						<a class="btn btn-third hindi" href="javascript:void(0)"
						onclick="window.location.href='<%= session.getAttribute("JSP_PATH_RESOLVE") %>UPLOAD/cbic-sanchar-manual.pdf'"
						target="_blank" style="display: none;"> <i
							class="fa fa-sign-out fa-fw-main"></i>सीबीआईसी-सांचर के बारे में
					</a>

					</li>

				
				</ul>
			</div>



			<!-- user name and dropdown --->


			<div class="navbar-nav dropdown m-r-20 " style="float: right">

				<a class="nav-link dropdown-toggle" href="" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <i
					class="fa iconposition fa-user-circle-o fa-fw iconColor m-r-5"></i>${USER}
				</a>

				<div class="dropdown-menu" class="m-r-20">
					<!-- <a class="dropdown-item" href="#">-->
					<a class="dropdown-item eng" href="javascript:void(0)"
						onclick="window.location.href='ChangePassword'">
						<i class="fa iconposition fa-lock fa-fw iconColor m-r-5"></i>Change
						Password
					</a> <a class="dropdown-item hindi" href="javascript:void(0)"
						onclick="window.location.href='ChangePassword'">
						<i class="fa iconposition fa-lock fa-fw iconColor m-r-5"></i>पासवर्ड
						बदलें
					</a>
					<!-- <a class="dropdown-item" href="#"><i class="fa iconposition fa-user fa-fw iconColor m-r-5"></i>Profile</a>-->
					<div class="dropdown-divider"></div>

					<!-- <a class="dropdown-item" href="#">-->
					<a class="dropdown-item eng" href="javascript:void(0)"
						onclick="window.location.href='Logout'"> <i
						class="fa iconposition fa-lock fa-fw iconColor m-r-5"></i>Logout
					</a> <a class="dropdown-item hindi" href="javascript:void(0)"
						onclick="window.location.href='Logout'"> <i
						class="fa iconposition fa-lock fa-fw iconColor m-r-5"></i>लॉगआउट
					</a>

				</div>
			</div>
		</nav>



		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!---Body Section-->

	<div id="page-wrapper-Main" class="minHeight430 p-b-40">
		<div class="row">
			<div class="col-sm-1"></div>

			<div class="col-sm-10 p-t-20 p-b-20">

				<h3 class="pageheading eng text-themecolor">Welcome to CBIC -
					Sanchar</h3>
				<h3 class="pageheading hindi text-themecolor" style="display: none;">
					सीबीआईसी संचार में आपका स्वागत है।</ <</h3>

			</div>
			<div class="col-sm-1"></div>


		</div>
		
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-2"><h1><a class="btn btn-primary float-right"
							href='/KPI_Home'>Key Performance Indicator (KPI)</a> </h1></div>
			
			<div class="col-sm-9"></div>
		


		</div>
		<!-- 
		


		<!-- popup overlay for General Communication start here -->

		<div id="overlay">
			<a href="#" class="closepopup">×</a>
			<div id="headingdiv" class="eng">General Communication</div>
			<div id="headingdiv" class="hindi" style="display: none;">
				सामान्य संसूचना</div>

			<p class="eng">This Application provides a platform for quick and easy interaction/communication among CBIC's users.

                        Each communication sent to the field formations for a response is identified by a unique communication Id No.

                        Initially, the user would push the analysed communication to the intended recipient formation by uploading it on to the application.

                        There is also an option to select any combination of recipient formations or users on All India basis.</p>
			<p class="hindi" style="display: none;">यह अनुप्रयोग सीबीआईसी
				प्रयोक्ताओं के मध्य शीघ्र एवं सुलभ अंतःक्रिया/सम्प्रेषण के लिए एक
				मंच उपलब्ध करवाता है। क्षेत्रीय गठनों को भेजी गयी प्रत्येक
				रिपोर्ट/आँकड़े को एक विशिष्ट रिपोर्ट आईडी संख्या द्वारा पहचाना जा
				सकता है। आरंभ मे प्रयोक्ता द्वारा विश्लेषित रिपोर्ट/आँकड़े को
				अनुप्रयोग पर अपलोड कर अपेक्षित गठनों को भेजा जा सकता है। इसके साथ ही
				अखिल भारतीय स्तर पर प्रेषक गठनों एवं प्रयोक्ताओं के संयोजन को चुनने
				का विकल्प भी उपलब्ध है। प्रेषक गठनों द्वारा अपनी प्रतिक्रिया को
				संरचित क्षेत्रों में अपलोड किया जाना आवश्यक है। इस अनुप्रयोग के कुछ
				अपेक्षित लाभ निम्नलिखित हैं।</p>
			


			<div class="divCenter">
				<button type="button" class="btn btn-third"
					onclick="javascript:overlay_OTP();">Proceed</button>
			</div>
			</p>
		</div>
		<div id="mask" onclick="document.location='#';"></div>
		<!-- popup overlay for General Communication ends here -->


		<!-- popup overlay for OTP Window start here -->

		<div id="overlay-otp">
			<a href="#" class="closepopup">×</a>
			<div id="headingdiv" class="eng">One Time Password (OTP)
				verification to access CBIC-Sanchar</div>

			<div id="div_feedback_enhance_bind_dgadmn">
				<div class="col-lg-12 col-md-12 col-sm-12 p-t-b-20 m-l-10">
					<div class="row">
						<input type="hidden" id="HD_usertype_dgadmn" /> <input
							type="hidden" id="HD_UserCode_dgadmn" />
						<div class="col-lg-5 col-md-5 col-sm-5 p-t-20">
							<input type="text" class="form-control input-f-b"
								id="txt_OTP_dgadmn" placeholder="Enter OTP"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Enter OTP'" autocomplete="off">
						</div>
						<div class="col-lg-3 col-md-3 col-sm-3 p-t-20">
							<input type="button" class="btn btn-third l-h-1point3"
								value="Verify OTP" id="btn_verify_dgadmn" />
						</div>

						<div
							class="col-lg-4 col-md-4 col-sm-4 p-t-20 div_resend_otp_dgadmn">
							<input type="button" class="btn btn-warning l-h-1point3"
								value="Resend OTP" id="btn_resend_otp_dgadmn"
								style="display: none;" />
						</div>

					</div>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12 align-self-center p-t-10"
					id="div_display_mob_dgadmn" style="display: none;">
					<p style="color: red;">
						OTP has been successfully sent to #######<span id="spn_mob_dgadmn">###</span>
					</p>
				</div>
				<div
					class="col-lg-12 col-md-12 col-sm-12 align-self-center div_resend_otp_dgadmn"
					style="display: none;">
					<p>
						To resend OTP please wait for <span class="timer"
							style="color: red"></span> mins
					</p>

				</div>
			</div>

			<div class="col-lg-12 col-md-12 col-sm-12 align-self-center"
				id="div_alert_msg_dgadmn" style="display: none;">
				<p style="color: red;" id="alert_msg_dgadmn"></p>
			</div>
		</div>
	</div>
	<div id="mask-otp" onclick="document.location='#';"></div>
	<!-- popup overlay ends here -->

	</div>
	<!-- popup overlay ends here -->



	<footer class="main-footer">
		<div class="text-center hindi" style="display: none;">
			<i style="color: #d9534f; font: italic;">सेवारत करदाताओं के लिए
				प्रभावन तकनीक</i> <br> <strong> <a
				href="https://www.cbecddm.gov.in/">आँकड़ा प्रबंधन निदेशालय</a>.
			</strong> सभी अधिकार सुरक्षित.
		</div>
		<div class="text-center eng divleft">
			<i style="color: #d9534f; font: italic;">Leveraging Technology
				for Serving Taxpayers</i> <br>

		</div>
		<div class="divright">
			<a href="https://www.cbecddm.gov.in/"> Directorate of Data
				Management </a>
			<div class="copyrightContent">All rights reserved.</div>
		</div>
	</footer>
	</div>
	<!-- popup overlay ends here -->

	<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>

	<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/bootstrap/4.0.0/js/custom.min.js"></script>
	<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/bootstrap/4.0.0/js/popper.min.js"></script>
	<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/bootstrap/4.0.0/js/bootstrap.min.js"></script>


	<script language="javascript">
		$(document).ready(function() {
			$('.hindi').hide();
			$('#english_button').hide();
			//window.location.href = "#overlay";
			//overlay_OTP();
		});

		function overlayGC() {
			window.location.href = "#overlay";

		}

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

	<!-- ----------------- DGADMIN----------------- -->
	<script>
		function overlay_OTP() {
			//$('#overlay').hide();	
			window.location.href = "#overlay-otp";
			OTP_Generate();
		}

		jQuery('#dgadmin_validate').click(function() {
			$('#overlay').hide();
			//$('#modal-feedback-details-dgadmn').show();
			$('#overlay-otp').show();
			OTP_Generate();
		});

		jQuery('#btn_resend_otp_dgadmn').click(function() {
			OTP_Generate();
		});

		function show_OTP_Verify() {
			//alert("before show OTP");
			$('#modal-feedback-details-dgadmn').show();
			//alert("before show OTP");
			OTP_Generate();

		}

		function OTP_Generate() {
			// alert("inside OTP_Generate");
			//jQuery.get('Zone_Bind', { dep: depts }, function (data) { chkGetZone(data) });

			jQuery.get('Generate_OTP', {}, function(data) {
				//alert("data " + data);
				var abc = JSON.parse(data.otp_Model);
				//alert("abc " + abc);
				var msg = abc.message;
				// alert("msg "+ msg);
				if (msg == 'done') {
					//	alert("inside done");
					$('.div_resend_otp_dgadmn').show();
					$('#div_display_mob_dgadmn').show();
					$('#spn_mob_dgadmn').text(abc.mobile);
					$('#HD_usertype_dgadmn').val(abc.usertype);
					$('#HD_UserCode_dgadmn').val(abc.usercode);

					var minutes = 5;
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
					$('.div_resend_otp_dgadmn').hide();
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

		$('.closediv').click(function() {
			$('#modal-feedback-details-dgadmn').hide();
			// window.location.href = "/MIS/Desk";
		});

		jQuery('#btn_verify_dgadmn').click(function() {
			var _otp = jQuery('#txt_OTP_dgadmn').val();
			var _usertype = $('#HD_usertype_dgadmn').val();
			var _usercode = $('#HD_UserCode_dgadmn').val();
			//window.location.href = "/DGARM/NavigationDGARM/Home";
			//return false;

			if (_otp != '' && _usertype != '' && _usercode != '') {
				jQuery.get('Validate_OTP', {
					OTP : _otp,
					UserType : _usertype,
					UserCode : _usercode
				}, function(data) {
					//	alert("data"+ data);
					//	alert("data.message"+ data.message);
					if (data.message == '"validate"') {
						window.location.href = "Home";
					} else {
						$('#div_alert_msg_dgadmn').show();
						$('#alert_msg_dgadmn').text(data.message);
					}
				});
			} else {
				alert("There is something missing or Mobile No is not confifured");
			}

		});
	</script>

<sec:csrfInput />
</body>
</html>
