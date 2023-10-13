<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.ddm.cbic.controller.GSTHomeController,org.springframework.web.servlet.ModelAndView"%> 

<%{
    //ViewBag.Title = "Directorate Desk";
    //Layout = null;
    System.out.println("in ApplicationeDesk jsp userid " +request.getSession().getAttribute("USER"));
    System.out.println("in ApplicationeDesk jsp type "+request.getSession().getAttribute("TYPE"));
	ModelAndView mv = (ModelAndView)request.getSession().getAttribute("ModelAndView");
	
	
}%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Directorate of Data Management</title>

    <!--  Stylesheet for Bootstrap-->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/font-awesome/css/font-awesome.min.css" rel="stylesheet" />

    <!-- Stylesheet for Theme  -->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/metisMenu.min.css" rel="stylesheet" />
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/morris.css" rel="stylesheet" />


    <!--  Stylesheet for Datatable -->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/dataTables.bootstrap.css" rel="stylesheet" />
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/dataTables.responsive.css" rel="stylesheet" />


    <meta name="viewport" content="width=device-width" />

    <!--  Stylesheet for Custom Work  -->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/sb-admin-2.css" rel="stylesheet" />
    <style>
        #page-wrapper {
            position: inherit;
            margin: 0 0 0 0 !important;
            padding: 0 30px;
            border-left: 1px solid #e7e7e7;
        }
    </style>

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

        .btn-pmm {
            color: #fff;
            background-color: rgb(255,142,29);
            border-color: #ab5704;
        }

            .btn-pmm:hover {
                color: #fff;
                background-color: #ab5704;
            }

        .panel-pmm {
            color: #fff;
            background-color: rgb(255,142,29);
            border-color: #ab5704;
        }


        .btn-gem {
            color: #fff;
            background-color: #00C6D7;
            border-color: #3b5998;
        }

            .btn-gem:hover {
                color: #fff;
                background-color: #0f828c;
            }

        .panel-gem {
            color: #fff;
            background-color: #00C6D7;
            border-color: #3b5998;
        }


        .nav > li > a:hover {
            background-color: #184b77 !important;
            color: #fff;
        }


        .huge {
            font-size: 32px !important;
        }

        .panel-red {
            color: #d9534f;
        }
    </style>





</head>
<body>
    <div id="wrapper">
        <!-- Navigation -->

        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse in" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                 <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/imagesGST/CBECDDM-Logo-New.png" id="img_logo" />  
                    <!-- <img id="cbic_sanchar" src="~/Content/art.png" />  -->
            </div>

<!--             <div class="col-lg-4">
                <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content/Logo/Merge-Eng.png" class="eng_logo eng" />
                <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content/Logo/Merge-Hindi.png" class="hindi_logo hindi " />
            </div>
 -->
            <!-- <div class="col-lg-4" style="text-align:center">
                    <img id="cbic_sanchar" src="../Content/Logo/cbic-sanchar-min.png" />
                </div> -->



            <% //if (!String.IsNullOrEmpty(Convert.ToString(Session["USER"])))
            if (request.getSession().getAttribute("USER")!=null)
            { %>
            <!-- /.navbar-header -->
                <ul class="nav navbar-top-links navbar-right">

                    <!-- /.dropdown -->
                    <!-- /.dropdown -->

                    <li class="dropdown">

                        <a class="btn btn-primary" id="hindi_button" onclick="javascript:Bilingual_Hindi();" style="padding: 5px; min-height: 5px;">
                            हिन्दी में
                        </a>

                        <a class="btn btn-primary" id="english_button" onclick="javascript:Bilingual_Eng();" style="padding: 5px; min-height: 5px;">
                            English
                        </a>

                    </li>



                    <li class="dropdown">
                        <a href='/MIS/GSTHome/Desk' class="btn btn-primary hindi" style="padding: 5px; min-height: 5px;">
                            <i class="fa fa-sign-out fa-fw"></i> सीबीआईसी संचार
                        </a>

                        <a href='/MIS/GSTHome/Desk' class="btn btn-primary eng" style="padding: 5px; min-height: 5px;">
                            <i class="fa fa-sign-out fa-fw"></i> CBIC Sanchar
                        </a>
                    </li>

                    <br />
                    <li class="dropdown" style="float:left;margin-top:5px;">
                        <a href='<%= session.getAttribute("JSP_PATH_RESOLVE") %>../UPLOAD/cbic-sanchar-manual.pdf' target="_blank" class="btn btn-primary eng" style="padding: 5px; min-height: 5px !important; background-color: #05ccb9 !important">
                            <i class="fa fa-download fa-fw"></i> About CBIC-Sanchar
                        </a>
                        <a href='<%= session.getAttribute("JSP_PATH_RESOLVE") %>../UPLOAD/cbic-sanchar-manual.pdf' target="_blank" class="btn btn-primary hindi" style="padding: 5px; min-height: 5px !important; background-color: #05ccb9 !important ">
                            <i class="fa fa-download fa-fw"></i> सीबीआईसी-सांचर के बारे में
                        </a>
                    </li>

                    <!-- /.dropdown -->
                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>${Userid} <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <% 
                            
                            String type = (String)request.getSession().getAttribute("TYPE");
                            String userId = (String)request.getSession().getAttribute("USER");
                            //if ((type.toString().substring(0, 2) != "FO") || (type.toString().substring(0, 4) == "CBEC"))
                            if ((type!=null && type!="")&&((type.toString().substring(0, 2) != "FO") || (type.toString().substring(0, 4) == "CBEC")))
                            {
                                if (userId.toString() != "ddmC1_cbec")
                                { %>

                                    <li><a class="hindi" href='/DGHRD/DGHome/Profile'><i class="fa fa-user fa-fw"></i> प्रयोक्ता पार्श्वक</a></li>
                                    <li><a class="eng" href='/DGHRD/DGHome/Profile'><i class="fa fa-user fa-fw"></i> User Profile</a></li>

                              <% } %>
                          		<% } %>
                           
                            <li>
                                <a class="hindi" href="/MIS/GSTHome/ChangePassword"><i class="fa fa-gear fa-fw"></i> पासवर्ड बदलें</a>
                                <a class="eng" href="/MIS/GSTHome/ChangePassword"><i class="fa fa-gear fa-fw"></i> Change Password</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="hindi" href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Logout'><i class="fa fa-sign-out fa-fw"></i> लॉगआउट</a>
                                <a class="eng" href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Logout'><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>

                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <br />

            <!-- /.navbar-top-links -->

            <!-- /.navbar-static-side -->
            <% } 
            else
            {
               // Response.Redirect("~/Logout");
            } %>
        </nav>

        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!---Body Section-->

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header hindi" style="text-align: center; color: #d9534f; "><i class="fa fa-th-large fa-fw"></i> पीएमएम, डब्लूआरआर, जीईएम  इत्यादि </h1>
                <h1 class="page-header eng" style="text-align: center; color: #d9534f;">
                    <i class="fa fa-th-large fa-fw"></i> PMM, WRR, GeM etc
                    <img id="cbic_sanchar" src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content/Logo/CBICDDM.png" style="height:75px; width:75px;" />
                </h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">

            <div class="col-lg-12 col-md-12">
                <!-- <div class="col-lg-1 col-md-6" style="padding-top:50px;">
                    </div>  -->
                <div class="col-lg-4 col-md-6" style="padding-top:50px;">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-book fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge eng">Prosecution Management</div>
                                    <div class="huge hindi">अभियोग प्रबंधन</div>
                                </div>
                            </div>
                        </div>
                        <a href=" javascript:void(0)" id="dgddm_validate">
                            <div class="panel-footer">
                                <span class="pull-left">
                                    <a class="btn btn-red float-right" href='@Url.Action("Home", "Navigation", new { area = "PMM" })'><i class="fa fa-sign-in fa-2x"></i></a>

                                </span>
                                <!-- <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>  -->
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6" style="padding-top:50px;">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-book fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge eng">Weekly Refund</div>
                                    <div class="huge hindi">साप्ताहिक प्रतिदाय</div>
                                </div>
                            </div>
                        </div>
                        <a href="javascript:void(0)" id="dgarm_validate">
                            <div class="panel-footer">
                                <span class="pull-left">
                                    <a class="btn btn-red float-right" href='@Url.Action("Home", "NavigationWRR", new { area = "GSTWRR" })'><i class="fa fa-sign-in fa-2x"></i></a>

                                </span>
                                <!-- <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span> -->
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                

                <div class="col-lg-4 col-md-6" style="padding-top:50px;">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-book fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge eng">e-Marketplace (GeM)</div>
                                    <div class="huge hindi">ई-बाज़ार(जीईएम)</div>
                                </div>
                            </div>
                        </div>
                        <a href="javascript:void(0)" id="dgarm_validate">
                            <div class="panel-footer">
                                <span class="pull-left">
                                    <a class="btn btn-red float-right" href="/MIS/DGHRD/DGHome/DashBoard"><i class="fa fa-sign-in fa-2x"></i></a>

                                </span>
                                <!-- <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>  -->
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>

                <div class="col-lg-1 col-md-6" style="padding-top:50px;">
                </div>

            </div>

            <div class="col-lg-12 col-md-12">

                <div class="col-lg-2 col-md-6" style="padding-top:50px;">
                </div>



                <!-- <div class="col-lg-3 col-md-6" style="padding-top:50px;">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-book fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge eng">GSTLOCO</div>
                                        <div class="huge hindi">जीएसटी एलओसीओ</div>
                                    </div>
                                </div>
                            </div>
                            <a href="javascript:void(0)" id="dgarm_validate">
                                <div class="panel-footer">
                                    <span class="pull-left">
                                        <a class="btn btn-primary float-right" href='@Url.Action("Home", "REPORT", new { area = "GSTLOCO" }, null)'><i class="fa fa-sign-in fa-2x"></i></a>

                                    </span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div> -->

                <div class="col-lg-4 col-md-6" style="padding-top:50px;">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-book fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge eng">Tax Disputes</div>
                                    <div class="huge hindi">कर विवाद</div>
                                </div>
                            </div>
                        </div>
                        <a href="javascript:void(0)" id="dgarm_validate">
                            <div class="panel-footer">
                                <span class="pull-left">
                                    <a class="btn btn-red float-right" href='@Url.Action("DisputeResolution", "DisputeResolution", new { area = "TDOTS" })'><i class="fa fa-sign-in fa-2x"></i></a>

                                </span>
                                <!-- <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>  -->
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>

                

                <div class="col-lg-4 col-md-6" style="padding-top:50px;">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-book fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge eng">Audit Efficiency</div>
                                    <div class="huge hindi">दक्षता लेखा-परीक्षा</div>
                                </div>
                            </div>
                        </div>
                        <a href="javascript:void(0)" id="dgarm_validate">
                            <div class="panel-footer">
                                <span class="pull-left">
                                    <a class="btn btn-red float-right" href='@Url.Action("Home", "DGAudit", new { area = "DGAudit" }, null)'><i class="fa fa-sign-in fa-2x"></i></a>

                                </span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>

                <div class="col-lg-2 col-md-6" style="padding-top:50px;">
                </div>
            </div>




        </div>
        <!-- /.row -->
        <!-- /.row -->
    </div>

    <footer class="main-footer">
        <div class="text-center hindi">
            <strong> <a href="https://www.cbecddm.gov.in">आँकड़ा प्रबंधन निदेशालय <b style="color: #d9534f; font: italic;">सेवारत करदाताओं के लिए प्रभावन तकनीक </b></a>.</strong> सभी अधिकार सुरक्षित.
        </div>
        <div class="text-center eng">
            <i style="color: #d9534f; font: italic;">Leveraging Technology for Serving Taxpayers</i><br />
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
            text-align: right !important;
        }

        .align-center {
            text-align: center !important;
        }

        .align-left {
            text-align: left !important;
        }
    </style>


    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/jquery-3.6.0.min.js"></script>
    <!-- Common Scripts  -->

    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/jquery-ui.js"></script>
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
    <!--  ----------------- DGARM------------------- -->
    <script>
        jQuery('#dgarm_validate').click(function () {
            $('#modal-feedback-details').show();
            OTP_Generate();
        });


        jQuery('#btn_resend_otp').click(function () {
            OTP_Generate();
        });


        function OTP_Generate() {

            $.get('/DGARM/Insert/Generate_OTP', null, function (data) {
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
            window.location.href = "/GSTHome/DirectorateDesk";
        });


        jQuery('#btn_verify').click(function () {
            var _otp = jQuery('#txt_OTP').val();
            var _usertype = $('#HD_usertype').val();
            var _usercode = $('#HD_UserCode').val();
            //window.location.href = "/DGARM/NavigationDGARM/Home";
            //return false;

            if (_otp != '' && _usertype != '' && _usercode != '') {
                $.get('/DGARM/Insert/Validate_OTP', { OTP: _otp, UserType: _usertype, UserCode: _usercode }, function (data) {
                    if (data == 'validate') {
                        window.location.href = "/DGARM/NavigationDGARM/Home";
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

    <!--  ----------------- DG System------------------- -->
    <script>
        jQuery('#dgddm_validate').click(function () {
            $('#modal-feedback-details-ddm').show();
            OTP_Generate_ddm();
        });


        jQuery('#btn_resend_otp_ddm').click(function () {
            OTP_Generate_ddm();
        });


        function OTP_Generate_ddm() {

            $.get('/DGDDM/Insert/Generate_OTP', null, function (data) {
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
            window.location.href = "/GSTHome/DirectorateDesk";
        });


        jQuery('#btn_verify_ddm').click(function () {
            var _otp = jQuery('#txt_OTP_ddm').val();
            var _usertype = $('#HD_usertype_ddm').val();
            var _usercode = $('#HD_UserCode_ddm').val();
            //window.location.href = "/DGARM/NavigationDGARM/Home";
            //return false;

            if (_otp != '' && _usertype != '' && _usercode != '') {
                $.get('/DGDDM/Insert/Validate_OTP', { OTP: _otp, UserType: _usertype, UserCode: _usercode }, function (data) {
                    if (data == 'validate') {
                        window.location.href = "/DGDDM/NavigationDGDDM/Home";
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





    <!-- Script For File Upload Icons  -->
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/bootstrap-filestyle.min.js"></script>
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/bootstrap-filestyle.js"></script>

    <!-- Script For Datatable  -->

    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/dataTables.bootstrap.min.js"></script>
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/jquery.dataTables.min.js"></script>
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/dataTables.responsive.js"></script>


</body>
</html>
