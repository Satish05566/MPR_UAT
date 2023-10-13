<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/images/favicon.png">
    <title></title>
    <!-- Bootstrap Core CSS -->
    <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->

    <!--<link href="css/style.css" rel="stylesheet">-->


      <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/css/mycss.css" rel="stylesheet">
        <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/css/spinners.css" rel="stylesheet">

    <!-- You can change the theme colors from here
    <link href="css/colors/blue.css" id="theme" rel="stylesheet">-->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<style media="screen">


</style>

</head>

<body class="fix-header card-no-border">
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
    </div>

    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar">
            <nav class="navbar top-navbar navbar-toggleable-sm navbar-light">
                <!-- ============================================================== -->
                <!-- Logo -->
                <!-- ============================================================== -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">

                        <span>
                         <!-- dark Logo text -->
                         <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/images/logo-text.png" alt="homepage" class="dark-logo" />
                         </span> </a>
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav mr-auto mt-md-0 ">
                        <!-- This is  -->
                        <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                        <li class="nav-item hidden-sm-down">
                        <!-- 
                          <h3 class="text-topheading m-l-30 m-t-">General Communication</h3>
                            <h5 class="text-topheading m-l-30">Jammu (commissionerate)</h5>-->

                        </li>
                        </ul>

                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->




                    	<!--	<div class="dropdown">

                    			<button type="button" class="btn btn-success dropdown-toggle"
                    						data-toggle="dropdown">
                    				Select CS Subjects
                    			</button>

                    			<div class="dropdown-menu">
                    				<a class="dropdown-item" href="#">Data Structure</a>
                    				<a class="dropdown-item" href="#">Algorithm</a>
                    				<a class="dropdown-item" href="#">Operating System</a>
                    				<a class="dropdown-item" href="#">Computer Networks</a>
                    			</div>
                    		</div>

                      -->
    <div class="navbar-nav my-lg-0 dropdown">

                        <!--<a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <img src="images/users/1.jpg" alt="user" class="profile-pic m-r-5" />Markarn Doe</a>-->

                            <a class="nav-link dropdown-toggle" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <i class="fa iconposition fa-user-circle-o fa-fw iconColor m-r-5"></i>${USER}  <i class="fa fa-caret-down fa-fw"></i></a>

                        <div class="dropdown-menu" >
                     <!-- <a class="dropdown-item" href="#">  <i class="fa iconposition fa-lock fa-fw iconColor m-r-5"></i>Change Password</a>
                          <a class="dropdown-item" href="#"><i class="fa iconposition fa-user fa-fw iconColor m-r-5"></i>Profile</a>
                          <div class="dropdown-divider"></div>  -->  
                          
                     <!-- <a class="dropdown-item" href="#">-->
                          <a class="dropdown-item" href="javascript:void(0)" onclick="window.location.href='Logout'">
                          <i class="fa iconposition fa-lock fa-fw iconColor m-r-5"></i>Logout
                          </a>

                        </div>
                    </div>


                </div>
            </nav>
        </header>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar" >
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">

                      <li >
                     <!-- <a href="#">-->
                          <a  href="javascript:void(0)" onclick="window.location.href='ChangePassword'">
                              <i class="fa iconposition fa-th-large fa-fw iconColor"></i> <span>Change Password</span>
                          </a>
                      </li>
                     
                    	<!-- <a href="#">-->
                    	<!-- <a href="@Url.Action("View_Mail_Status", "Insert", new { area = "DGADMIN" })">  -->
                    	<!-- 
                    
                      <li>
                        
                         <a class="eng" href="javascript:void(0)" onclick="window.location.href='http://www.cbecddm.gov.in'" target="_blank">
                          
                              <i class="fa iconposition fa-home fa-fw iconColor"></i> <span>Home</span>
                          </a>
                      </li>
						-->

					  <li>
                     <!-- <a href="#">-->
                          <a href="javascript:void(0)" onclick="window.location.href='Desk'" class="active"> 
                          <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/images/sanchar-logo.png" style="height:20px; width:20px;"> 
                          <span class="m-l-5">CBIC-Sanchar</span>
                          </a>
                      </li>

                      <li>
                          <!-- <a href="#">-->
                          <a href="javascript:void(0)" onclick="window.location.href='Logout'">  
                              <i class="fa iconposition fa-sign-out fa-fw iconColor"></i> <span>Logout</span>
                          </a>
                      </li>
                     




                  </ul>

                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid minHeight600">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-6 col-8 align-self-center">
                        <h3 class="text-themecolor m-b-0 m-t-0">Change Password</h3>

                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                            <li class="breadcrumb-item active">Change Password</li>
                        </ol>
                    </div>

                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->



                <div class="row">
                   <!-- Column -->
                   <div class="col-lg-4 col-xlg-3 col-md-5">
                       <div class="card">
                           <div class="card-block">
                               <center class="m-t-30"> <img src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/images/users/user.png" class="img-circle" width="150">
                                   <h4 class="card-title m-t-10">${USER}</h4>

                               </center>
                           </div>
                       </div>
                   </div>
                   <!-- Column -->
                   <!-- Column -->
                   <div class="col-lg-8 col-xlg-9 col-md-7">
                       <div class="card">
                           <div class="card-block">
                           		<%
                                String msg = (String)request.getAttribute("message");
                                if(!msg.isEmpty()){%><font color="red">	 ${message} </font> <% } %>
                          <!-- <form class="form-horizontal form-material">-->
                               <form class="form-horizontal form-material" role="form" action="PasswordChange" id="PasswordChangeForm" method="POST">
                                   <div class="form-group">
                                       <label class="col-md-12">Current Password</label>
                                       <div class="col-md-12">
                                       <!-- <input type="text"  placeholder="************" onfocus="this.placeholder = ''"  class="InputText1">-->
                                       		<input type="password" class="InputText1" name="txt_OldPass" id="txt_OldPass" placeholder="************" onfocus="this.placeholder = ''">
                                       </div>
                                   </div>
                                   <div class="form-group">
                                       <label for="example-email" class="col-md-12">New Password</label>
                                       <div class="col-md-12">
                                       <!-- <input type="password" placeholder="************" onfocus="this.placeholder = ''"  class="InputText1">-->
                                            <input type="password" class="InputText1" name="txt_pass" id="txt_pass" placeholder="************" onfocus="this.placeholder = ''">
                                       </div>
                                   </div>
                              <!-- <div class="form-group">
                                       <label class="col-md-12">Confirm New Password</label>
                                       <div class="col-md-12">
                                           <input type="password"  placeholder="************" onfocus="this.placeholder = ''"  class="InputText1 inputerror">
                                           <div class="helping-text-form">Password are not matching</div>
                                       </div>
                                   </div>-->



                                   <div class="form-group">
                                       <div class="col-sm-12">
                                      <!-- <button class="btn btn-primary">Update Password</button>-->
                                           <input type="submit" class="btn btn-primary" value="Update Password"  />
                                       </div>
                                   </div>
                               </form>
                           </div>
                       </div>
                   </div>
                   <!-- Column -->
               </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->

            <!-- ============================================================== -->
            <!-- End footer -->


            <!-- ============================================================== -->
        </div>
        <footer class="main-footer"><div class="text-center eng divleft"><i style="color: #d9534f; font: italic;">Leveraging Technology
    for Serving Taxpayers</i></div>
          <div class="divright"><a href="https://www.cbecddm.gov.in/"> Directorate of Data
          Management </a><br>
    <div class="text-right  copyrightContent">All rights reserved.</div>
        </div>

        </footer>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>

    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/js/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->

    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/js/sidebarmenu.js"></script>
    <!--stickey kit -->

    <!--Custom JavaScript -->
    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>UI_Rakesh/js/custom.min.js"></script>


</body>

</html>
