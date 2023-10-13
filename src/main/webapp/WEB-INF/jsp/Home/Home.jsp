<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<jsp:include page="Header.jsp" />
<%-- <jsp:include page="MPR_LeftMenu.jsp" /> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page
	import="java.io.*,java.util.*,java.time.format.DateTimeFormatter,java.time.LocalDateTime"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12 text-center">
			<h4 class="page-header eng">
				<i class="fa fa-home fa-fw"></i> Key Performance Indicators
			</h4>
			<!-- <h1 class="page-header hindi"><i class="fa fa-home fa-fw"></i> मुख्य निष्पादन संकेतक</h1> -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-book fa-3x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div class="f-s-25 eng">MPR</div>
							<!--  <div class="huge hindi">एमपीआर</div> -->
						</div>
					</div>
				</div>
				<a href="#">
					<div class="panel-footer">
						<span class="pull-left"> <a	class="btn btn-primary float-right" href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Home/Report/<%=request.getSession().getAttribute("CSRF_Token").toString() %>'> 
						<i class="fa fa-sign-in fa-1x"></i></a>

						</span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-book fa-3x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div class="f-s-25 eng">MSR</div>
							<!--<div class="huge hindi">एमएसआर</div>-->
						</div>
					</div>
				</div>
				<a href="#">
					<div class="panel-footer">
						<span class="pull-left"> 
                            <a class="btn btn-primary float-right" href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Home/MSR/<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>
                            <i class="fa fa-sign-in fa-2x"></i></a>							
						</span>
						<!-- @*<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>*@ -->
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		
	</div>

</div>
<jsp:include page="Footer.jsp" />

