<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page errorPage="error.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 
  
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type='text/css' />
<!-- Font Awesome -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>../Content-GST/font-awesome/css/font-awesome.min.css" rel="stylesheet" type='text/css' />
<!-- NProgress -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/nprogress.css" rel="stylesheet" type='text/css'>
<!-- Animate.css -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/animate.min.css" rel="stylesheet" type='text/css'>
<!-- Custom Theme Style -->
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/cssGST/custom.min.css" rel="stylesheet" type='text/css'>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/jquery-3.6.0.min.js"></script>

<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/jsGST/jquery.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-GST/bootstrap-3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
        function mouseoverPass(obj) {
            var obj = document.getElementById('txtpwd');
            obj.type = "text";
        }
        function mouseoutPass(obj) {
            var obj = document.getElementById('txtpwd');
            obj.type = "password";
        }

        function submitForm(){
            //alert("before submit login form");
        	document.getElementById('loginForm').submit();
         }
</script>
<html>
<head>
    <title>MIS Login</title>
    <style>
        #logo_login {
            width: 550px;
        }
        
       
body {
    background-color: #FFFFFF;
}
    </style>

</head>

<body >
 <%
   response.setHeader( "viewport", "width=device-width"); 
   response.setHeader( "Pragma", "no-cache" );
   response.setHeader( "Cache-Control", "no-cache" );
   response.setDateHeader( "Expires", 0 ); 

   
 %> 
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" style="color: #2e6da4 !important">Important Information!</h4>
                </div>
                <div class="modal-body" style="color:black !important">
                    <p>
                        Successfully launched of "CBIC-Sanchar", a digital communication tool for fast and easy communication with the department on the DDM portal. www.cbecddm.gov.in Users are requested to use it actively and give feedback.<br />
                        <a style="font-size:20px; font-weight:bold;" target="_blank" href="http://www.cbecddm.gov.in/DOLetters/cbic-sanchar-manual.pdf"><i class="fa fa-download"></i>&nbsp;CBIC-Sanchar User Manual<img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-DRN/assets/img/pdf-16x16.png" alt=""><span class="newlink"></span></a>
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
                </div>
            </div>

        </div>
    </div>

    <div><noscript style="color:red;"><meta http-equiv="REFRESH" content="0; url=ScriptError.html"></noscript></div>
    <%--   <% response.setHeader( "REFRESH", "0" ); %>  --%> 

    <a class="hiddenanchor" id="signin"></a>
     <form action="/MIS/Desk" id="loginForm" method="POST" onSubmit="return validateform()">
        <div class="login_wrapper">
            <div class="animate form login_form">
                <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content/Logo/Merge-Eng.png" id="logo_login" />
                <marquee onmouseover="this.stop();" onmouseout="this.start();" scrolldelay="100" behavior="scroll" loop="infinite">
                    <h4 style="color: red; margin-top: 15px; font-size: 14px;">For any query please contact us on Ph : 011-2605 8808 / Email : commr-ddm-cbec@gov.in</h4>
                </marquee>
                <%-- <div>
                          
                           <form:label >Country</form:label>
                           
                             <form:select path = "country">
                             <form:option value = "NONE" label = "Select"/>
                             <form:options items = "${countryList}" />
                             </form:select>     	

                         
                          </div> --%>
                <section class="login_content">
                   <%--  <form> --%>
                        <input id="hdRandom" type="hidden" name="RandomNo" />
                        <h1>CBIC-Sanchar <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content/Logo/CBICDDM.png" style="height: 40px; width: 40px; margin-top: -10px;" /></h1>
                        
                        <% String msg = (String)request.getAttribute("message");
                        if(!msg.isEmpty()){
                        %>
                        <div class="alert" id="login_error">
                            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                            <%=msg %>
                        </div>
                        <%} %>
                        <div class="input-group" id="txt_username">
                            <span class="input-group-addon" id="basic-addon1">Username</span>
                            <input type="text" autocomplete="off" class="form-control" name="txt_id" id="txtid" placeholder="Username" aria-describedby="basic-addon1" required="true">
                        </div>

                        <div class="input-group" id="txt_password">
                            <span class="input-group-addon" id="basic-addon1">Password</span>
                            <input  type="password" class="form-control" name="txt_pass" id="txtpwd" autocomplete="off" required placeholder="Password" aria-describedby="basic-addon1">
                            <span class="input-group-addon" id="basic-addon1"><i class="fa fa-eye" aria-hidden="true" onmouseover="mouseoverPass();" onmouseout="mouseoutPass();"></i></span>
                        </div>
						
						 

                        <div>
                            <img style="height: 35px;width: 145px;margin-top: 21px;" src="/MIS/Captcha">
                        </div>
                         
                        
                        <div>
                            <input id="captch" type="text" name="captch" class="form-control" />
                        </div>
                        <div class="btn-group" data-toggle="buttons">
                            <input type="hidden" id="postgst" name='gst_type' value="post">

                              <label class="btn ">
                            <!--    <input type="radio" id="pregst" name='gst_type' value="pre"><i class=" fa fa-circle-o fa-2x"></i><i class="fa fa-check-circle-o fa-2x"></i><span> Pre GST</span>
                            </label>
                            <label class="btn active">
                                <input type="radio" id="postgst" name='gst_type' value="post" checked><i class="fa fa-circle-o fa-2x"></i><i class="fa fa-check-circle-o fa-2x"></i><span> Post GST</span>
                            </label> -->
                        </div>
                        <div>

                            <!-- <input type="button" class="btn btn-danger reset_pass" value="Forgotten Password" data-toggle="modal" data-target="#myModal" /> -->
                            <input style="float:left" type="button" class="btn btn-primary submit" value="Home" title="CBIC-DDM Home Page" onclick="location.href = 'http://www.cbecddm.gov.in/index.aspx'" />
                            <input type="submit" class="btn btn-success submit" value="Login" title="Post GST is defalut login page. Kinldy change above to login previous MIS Portal" id="SUBMIT" name="SUBMIT" onclick="submitForm();"/>
                        </div>
                           	
                        <div class="clearfix"></div>
                        <div class="separator">

                            <div class="footer_login">
                                <p>All Rights Reserved</p>
                                <p><a href="http://www.cbecddm.gov.in/index.aspx">Directorate of Data Management</a> </p>
                                <p>CBIC, New Delhi, India</p>
                            </div>
                        </div>
                   <%--  </form> --%>
                </section>
            </div>

        </div>
        <!-- Forget Password -->
      <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Forgetten Password</h4>
                    </div>
                    <div class="modal-body">
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Username</span>
                            <input type="text" class="form-control" name="txt_id" placeholder="Username" required aria-describedby="basic-addon1">
                        </div>

                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Email ID</span>
                            <input type="email" class="form-control" name="txt_email" placeholder="Email ID" aria-describedby="basic-addon1">
                        </div>


                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Mobile Number</span>
                            <input type="number" class="form-control" name="txt_mobile" placeholder="Mobile Number" aria-describedby="basic-addon1">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
</form>
</body>
</html>

<script type="text/javascript">
    $(document).ready(function () {
        //chk();

        /* $(window).on('load', function () {
            $('#myModal').modal('show');
        }); */
        window.history.forward(-1);

        window.history.pushState(null, "", window.location.href);
        window.onpopstate = function () {
            window.history.pushState(null, "", window.location.href);
        };
        //mouseoutPass();
      //  submitForm();
        
    });

    function chk() {
        var ab = '12345Satishtiwari';
        var c = ab.substring(0, 5)
        $('#hdRandom').val(c);
        //alert(c);
    }

</script>
<script type="text/javascript">
    $(document).ready(function () {
        //chk();
        window.history.forward(-1);

        window.history.pushState(null, "", window.location.href);
        window.onpopstate = function () {
            window.history.pushState(null, "", window.location.href);
        };
    });

    function chk() {
        var ab = '12345Satishtiwari';
        var c = ab.substring(0, 5)
        $('#hdRandom').val(c);
      //  alert(c);
    }
</script>

   
<script type="text/javascript">
     jQuery('#txtpwd').change(function (data) {
        jQuery.post('/MIS/encryptPassword', {pwd: jQuery(this).val() }, function (data) {
            if (data != '') {
                jQuery('#txtpwd').val(data);
                var rndm = data.substring(0, 6);
                $('#hdRandom').val(rndm);

            }
        });
    }); 
 </script>
 <script type="text/javascript">
     function GetZone(_stateId) {
        var _month = $("#ddl_mth option:selected").text();
        var _year = $('#ddl_year').val();
        if (_year == '' || _month == '-Select Month-') {
            alert('Please select the year and month');
            return false;
        }

        $('#ddlcomm').empty();
        ReportBind();
        var procemessage = "<option value='0'> Please wait...</option>";
        $("#ddlzone").html(procemessage).show();
        var url = "/GSTHome/Zone_Bind/";

        var form = $('#__AjaxAntiForgeryForm');
        var token = $('input[name="__RequestVerificationToken"]', form).val();

        $.ajax({
            url: url,
            data: { __RequestVerificationToken: token, dep: _stateId },
            cache: false,
            type: "POST",
            success: function (data) {
                var markup = "<option value=''>All India</option>";
                //---------------------------------------------------------
                if ($('#ddl_dep').val() == 'CEX' || $('#ddl_dep').val() == 'STX') {
                    markup += "<option value='CC'>DGGI</option>";
                    markup += "<option value='A0'>DGA</option>";
                }
                if ($('#ddl_dep').val() == 'GST') {
                    markup += "<option value='CC'>DGGI</option>";
                }
                else if ($('#ddl_dep').val() == 'CUS') {
                    markup += "<option value='DD'>DGRI</option>";
                    markup += "<option value='A0'>DGA</option>";
                    markup += "<option value='0A'>CC ZONE</option>";
                }
                else if ($("input:radio[name='Report_Type']:checked").val() == "FF") {
                    markup += "<option value='00'>MEMBER REGION</option>";
                    markup += "<option value='CC'>DGCEI</option>";
                    markup += "<option value='DD'>DGRI</option>";
                    markup += "<option value='A0'>DGA</option>";
                    markup += "<option value='0A'>CC ZONE</option>";
                }
                //------------------------------------------------------------
                for (var x = 0; x < data.length; x++) {
                    markup += "<option value=" + data[x].Value + ">" + data[x].Text + "</option>";
                }
                $("#ddlzone").html(markup).show();
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }
     </script>
 
 
 <!-- <script type="text/javascript">
    //function Check() {
    //    if (jQuery('#txt_id').val() != '' && jQuery('#txtpwd').val() != '' && jQuery('#CaptchaInputText').val() != '') {
    //        var password = jQuery('#txtpwd').val();
    //        jQuery.post('/MIS/Common/EncryptPassword', { pwd: password }, function (data) {
    //            if (data != '') {
    //                jQuery('#txtpwd').val(data);
    //                var formData = new FormData($("#form1")[0]);//, { "file": file }
    //                $.ajax({
    //                    url: '/Home/Login',
    //                    type: "POST",
    //                    dataType: "JSON",
    //                    data: formData,
    //                    contentType: false,
    //                    processData: false,
    //                    //traditional:true,
    //                    success: function (data) {
    //                        alert(data);
    //                        windows.location.href = '/Home/Login'
    //                        //window.location.href = 'http://www.xyz.com';
    //                    }

    //                });

    //            }

    //        });
    //    }
    //}
</script> -->

