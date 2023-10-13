<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<!DOCTYPE html>
<html lang="en">
	<link rel="icon" type="image/png" href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content/CBECDDM-Logo1.png" sizes="16x16" />
    <meta http-equiv="Content-Type" content="application/xhtml+xml;" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
	<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/css/mycss.css" rel="stylesheet" type="text/css">
    
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/bootstrap/4.0.0/js/bootstrap.min.js"></script>

	<!-- <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/bootstrap/4.0.0/js/jquery-3.5.0.min.js"></script> -->
	<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
	<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/js/jsencrypt.min.js"></script>
  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Directorate of Data Management</title>

</head>


<body>

    <div id="wrapper">

        <!-- header start here -->

        <nav class="navbar-default-Main" role="" style="Z-index:999; position:relative;">

            <div class="navbar-top-links1 login-right">

                <h5 class="p-l-12">for any query please contact us on</h5>
                <ul class="p-0">
                    <li><a href="#overlay" id="open-overlay"><i class="fa fa-phone fa-fw"></i>011-2605 8808 </a></li>
                    <li><a href="#overlay" id="open-overlay"><i class="fa fa-envelope fa-fw"></i>commr-ddm-cbec@gov.in </a></li>
                </ul>

            </div>

        </nav>

        <!-- header ends here -->

        <!-- main body content start here -->

        <section class="mainlogin">

            <div class="container">
                <div class="row">
                    <div class="col-lg-7 col-sm-7">
                        <div class="mainloginText">
							<br><br>
                            <p ><i style="font: italic;">Leveraging Technology for </i></p>
                            <p> <i style="font: italic;">Serving Taxpayers</i> </p>

                        </div>
                    </div>
                    <div class="col-lg-5 col-sm-5">
                        <h4>Sign into your </h4>
                     
                        <h3>KPI (Key Performance Indicator) <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/images/logo/general-communication.png"></h3>
                        <div class="mainloginform">

                       <!-- <form action="#">-->
                            <form action="GSTHome/Home" id="loginForm" method="POST" onSubmit="return validateform()" autocomplete="off">
                               <% String message = (String) request.getAttribute("message");%>
		  						<h3><font color="red">	<%= message %></font></h3>
                                <div class="username">
                                    <label for="username">Username <font color="red">(Case sensitive)</font></label>
                               <!-- <input type="text" class="" id="username" placeholder="Enter your username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your username'">-->
									<input type="text" class="" name="txt_id" id="txtid" placeholder="Enter your username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your username'"   >
                                </div>
                                <div class="username">
                                    <label for="date-out">Password</label>
                               <!-- <input type="password" id="password-field" placeholder="**************" onfocus="this.placeholder = ''" onblur="this.placeholder = '**************'">-->
                               		 <input type="hidden" id="hdnpass">
                               		<input type="password" name="txt_pass" id="txt_pass" on placeholder="**************" onfocus="this.placeholder = ''" onblur="this.placeholder = '**************'"    >
                                    
                                </div>

                                <div class="capcha">
                              <!-- <label for="capcha">ZHRKWX <a href="#"><i class="fa iconposition fa-refresh fa-fw captchacolor padleft10" ></i></a></label>-->
                                    
                                    <label for="capcha">
                                    <img style="height: 35px;width: 145px;margin-top: 10px;" src="Captcha">
                                    <a href="javascript:void(0)"  onclick="window.location.href='Login'"><i class="fa iconposition fa-refresh fa-fw captchacolor padleft10" ></i></a>
                                    </label>
                               <!-- <input type="text" class="" id="username" placeholder="Enter above text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter above text'"> -->
									<input type="text" id="captch" name="captch" class=""  placeholder="Enter above text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter above text'">
                                </div>
                                
                                

                                <div align="right">
                                
                                	<!-- <button type="button" class="btn-third" onclick="window.location.href='http://www.cbecddm.gov.in'" target="_blank">Home</button>  -->
                                	
                                	
                                	<input type="submit" class="btn-third" value="Login"  id="SUBMIT" name="SUBMIT" onclick="submitForm();"/>
                                	<br/>
                                </div>
                                
                                <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <!-- main body content ends here -->

        <!-- footer start here -->
        <footer class="main-footer">
            <div class="text-center hindi" style="display: none;">
                <i style="color: #d9534f; font: italic;">सेवारत करदाताओं के लिए
					प्रभावन तकनीक</i>
                <br> <strong> <a href="https://www.cbecddm.gov.in/">आँकड़ा प्रबंधन निदेशालय</a>.
				</strong> सभी अधिकार सुरक्षित.
            </div>
            <div class="text-center eng divleft">
                <i style="color: #d9534f; font: italic;">Leveraging Technology
					for Serving Taxpayers</i>
                <br>

            </div>
            
          
            
            
            <div class="divright"><a href="https://www.cbecddm.gov.in/"> Directorate of Data
						Management </a>
                <div class="copyrightContent">All rights reserved.</div>
            </div>
           
              <div class="align-self-center m-l-10">
				<div class="c-browser"> Best viewed in 1024 x 764
					resolution </div>
				<div class="copyrightContent">
					<img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/images/logo/chrome.png"
						style="height: 21px; width: 21px"> Google Chrome <img
						src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/images/logo/firefox.png"
						style="height: 25px; width: 25px"> Mozilla Firefox
				</div>
			</div>
        </footer>
    </div>

	<sec:csrfInput />
</body>
<script id="rendered-js">
        $(".toggle-password").click(function() {

            $(this).toggleClass("fa-eye fa-eye-slash");
            var input = $($(this).attr("toggle"));
            if (input.attr("type") == "password") {
                input.attr("type", "text");
            } else {
                input.attr("type", "password");
            }
        });
   
    </script>
<script type="text/javascript">
		/*
		function encryptPassword(){

			 jQuery.post('encryptPassword', {pwd: jQuery(this).val() }, function (data) {
		            if (data != '') {
		                jQuery('#txtpwd').val(data);
		                var rndm = data.substring(0, 6);
		                $('#hdRandom').val(rndm);

		            }
		        });

			}
        
		*/
        function submitForm(){
           // alert("pass" + $('#txt_pass').val());
            let RSAEncrypt = new JSEncrypt();
			RSAEncrypt.setPublicKey("<%= session.getAttribute("ENCRYPTION_PUBLIC_KEY") %>");
			let encryptedPass = RSAEncrypt.encrypt($.trim($('#txt_pass').val()));
		//	alert("encryptedPass "+ encryptedPass);
			// userOTP = encryptedPass;
	  		$('#txt_pass').val(encryptedPass);
	  
        	document.getElementById('loginForm').submit();
         }
</script>
<script type="text/javascript">
/*
jQuery('#txtpwd').change(function (data) {
    $('#hdnpass').val(jQuery(this).val());
   jQuery.post('encryptPassword', {pwd: $('#hdnpass').val() }, function (data) {
       if (data != '') {
           alert("data"+ data);
           jQuery('#txtpwd').val(data);
           var rndm = data.substring(0, 6);
           $('#hdRandom').val(rndm);

       }
   });
}); 
*/

function encryptPassword(pass){
	//alert("pass" + pass);
	
	let RSAEncrypt = new JSEncrypt();
	RSAEncrypt.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkWXVaWPIKNZK71nsfjyIF48HbxcKCozNuebeIJbxNVsK80S9CoHMvpgyE4TFPhfkeDsM6Sxsx+bbPkx8NaCGzeODVGiLE8uj719m7hSnGbH8pu8H0pq9XMu73fcm9NRQuHjJfoMqZxFNquKgkm/5pEBcqk1rq240+toebnsoCu71EC/L4u2ViGuTDwQiUMAwo0s4dnrJgthaog11Vi9dUzg8hWK/t9lK8m82OOF208ixg07reto8ksvZHOGDYHJ7KOZH3nbM24n1tUYAxoXe9atP8y2VLJy7x5WJLq0ofbzFfUg+PqRNzPY5tyUGNVYwgBPfvC399M53dU5OXi/cswIDAQAB");
	let encryptedPass = RSAEncrypt.encrypt($.trim(pass));
	alert("encryptedPass "+ encryptedPass);
	// userOTP = encryptedPass;
	  $('#txt_pass').val(encryptedPass);
}




	$("#txtid").on("input", function () {	      
	        var c = this.selectionStart,
		      r = /[^a-z0-9 _]/gi,
		      v = $(this).val();
		  if(r.test(v)) {
		    $(this).val(v.replace(r, ''));
		    c--;
		  }
		  this.setSelectionRange(c, c);

	    });

		$("#captch").on("input", function () {	      
	        var c = this.selectionStart,
		      r = /[^a-z]/gi,
		      v = $(this).val();
		  if(r.test(v)) {
		    $(this).val(v.replace(r, ''));
		    c--;
		  }
		  this.setSelectionRange(c, c);

	    });

     
 </script>


</html>
