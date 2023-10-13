<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />
<%-- <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/mpr-report.css" rel="stylesheet" /> --%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-6">
			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-book fa-fw"></i> GI-GST-2
			</h4>

		</div>
		<div class="col-lg-6">

			<ol class="breadcrumb float-right no-bg-col m-b-0 p-t-20 p-r-0">
				<li><a href="/KPI_Home"><i class="fa fa-home"></i>
						Management Information</a></li>
				<li><a href="/Insert">Upload</a></li>
				<li class="active">GST</li>


			</ol>
		</div>
	</div>
	<div class="row">
		<form:form action="/MPR/GSTGI/Insert/GI_GST_2" id="giGst2CommTemp"
			name="giGst2CommTemp" method="POST" modelAttribute="giGst2CommTemp">
			<c:choose>
				<c:when
					test="${ViewBagMessage!=null || ViewBagMessage.length() ==0}">
					<div class="col-lg-12">
						<div class="alert-success" id="login_error">
							<span class="closebtn"
								onclick="this.parentElement.style.display='none';">&times;</span>
							${ViewBagMessage}
						</div>
					</div>
				</c:when>
				<c:when
					test="${ViewBagMessage_Error!=null || ViewBagMessage_Error.length() ==0}">
					<div class="col-lg-12">
						<div class="alert" id="login_error">
							<span class="closebtn"
								onclick="this.parentElement.style.display='none';">&times;</span>
							${ViewBagMessage_Error}
						</div>
					</div>
				</c:when>
			</c:choose>
			<div class="col-lg-12">
				<div class="panel panel-danger">
					<div class="panel-heading text-capitalize">INVESTIGATION OF
						CASES</div>
					<div class="panel-body">
						<div class="panel panel-warning">
							<%
								String strDate = (String) request.getAttribute("MM_YYYY");
							    String flag = (String) request.getAttribute("flag");
									java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
									java.util.Date date = srcDtFormat.parse(strDate);
									java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
									String desDt = desDtFormat.format(date);
							%>
							<div class="panel-heading sub-month">
								MONTH :
								<%=desDt.toUpperCase()%>
								<div class="sub-lakh">Amount: Rs. in Lakhs</div>
							</div>


							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<tr>
									<tr class="text-center-capitalize table-header-center">
										<td rowspan="2" colspan="2">OPENING BALANCE</td>
										<td rowspan="2" colspan="2">RECEIPT</td>
										<td rowspan="1" colspan="8">CASES DISPOSED OFF DURING THE
											MONTH</td>
										<td rowspan="2" colspan="2">CLOSING BALANCE</td>
										<td rowspan="1" colspan="4">Age wise Braek up of Pending
											Investigation</td>
									</tr>
									<tr class="text-center-capitalize table-header-center">
										<td rowspan="1" colspan="2">SCN/ DRC-01 ISSUED</td>
										<td rowspan="1" colspan="2">VOLUNTARY COMPLIANCE/
											ISSUANCE OF DRC-04</td>
										<td rowspan="1" colspan="2">CLOSURE ON MERIT</td>
										<td rowspan="1" colspan="2">CLOSURE BY TRANSFER</td>
										<td rowspan="1" colspan="2">Less than 2 years</td>
										<td rowspan="1" colspan="2">More than 2 years</td>

									</tr>

									<tr class="text-center-capitalize table-header-center">
										<td rowspan="1" colspan="1">NO. OF CASES</td>
										<td rowspan="1" colspan="1">TAX INVOLVED</td>
										<td rowspan="1" colspan="1">NO. OF CASES</td>
										<td rowspan="1" colspan="1">TAX INVOLVED</td>
										<td rowspan="1" colspan="1">NO. OF CASES</td>
										<td rowspan="1" colspan="1">TAX INVOLVED</td>
										<td rowspan="1" colspan="1">NO. OF CASES</td>
										<td rowspan="1" colspan="1">TAX INVOLVED</td>
										<td rowspan="1" colspan="1">NO. OF CASES</td>
										<td rowspan="1" colspan="1">TAX INVOLVED</td>
										<td rowspan="1" colspan="1">NO. OF CASES</td>
										<td rowspan="1" colspan="1">TAX INVOLVED</td>
										<td rowspan="1" colspan="1">NO. OF CASES</td>
										<td rowspan="1" colspan="1">TAX INVOLVED</td>
										<td rowspan="1" colspan="1">NO. OF CASES</td>
										<td rowspan="1" colspan="1">TAX INVOLVED</td>
										<td rowspan="1" colspan="1">NO. OF CASES</td>
										<td rowspan="1" colspan="1">TAX INVOLVED</td>
									</tr>
									<c:if test="${not empty model}">
										<tr>
											<%
											String TokenNo = (String) request.getSession().getAttribute("TokenNo");
												String MM_YYYY = (String) request.getAttribute("MM_YYYY");
												String CRR = (String) request.getAttribute("CRR");
										%>
											<td><input type="hidden" id="HDTokenNo" name="HDTokenNo"
												value="<%=TokenNo%>" /> <input type="hidden" id="MM_YYYY"
												name="MM_YYYY" value="${MM_YYYY}" /> <input type="hidden"
												id="CRR" name="CRR" value="${CRR}" /> <input type="hidden"
												id="request_CSRF_Token" name="request_CSRF_Token"
												value="<%=session.getAttribute("CSRF_Token")%>"> <form:input
													path="OPENING_BALANCE_NO" type="text"
													style="text-align: right;" name="OPENING_BALANCE_NO"
													id="OPENING_BALANCE_NO" class="form-control min-width-1"
													autocomplete="off" value="${model.OPENING_BALANCE_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" maxlength="18" readonly="true" /> <form:errors
													path="OPENING_BALANCE_NO" cssClass="error" /></td>
											<td><form:input path="OPENING_BALANCE_TAX" type="text"
													style="text-align: right;" name="OPENING_BALANCE_TAX"
													id="OPENING_BALANCE_TAX" class="form-control min-width-1"
													autocomplete="off" maxlength="18" value="${model.OPENING_BALANCE_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" readonly="true" /> <form:errors
													path="OPENING_BALANCE_TAX" cssClass="error" /></td>
											<td><form:input path="RECEIPT_NO" type="text"
													style="text-align: right;" name="RECEIPT_NO"
													id="RECEIPT_NO" class="form-control min-width-1"
													autocomplete="off" maxlength="18" value="${model.RECEIPT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors path="RECEIPT_NO"
													cssClass="error" /></td>
											<td><form:input path="RECEIPT_TAX" type="text"
													style="text-align: right;" name="RECEIPT_TAX"
													id="RECEIPT_TAX" class="form-control min-width-1"
													autocomplete="off" maxlength="18" value="${model.RECEIPT_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors path="RECEIPT_TAX"
													cssClass="error" /></td>
											<td><form:input path="SCN_NO" type="text"
													style="text-align: right;" name="SCN_NO" id="SCN_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SCN_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors path="SCN_NO"
													cssClass="error" /></td>
											<td><form:input path="SCN_TAX" type="text"
													style="text-align: right;" name="SCN_TAX" id="SCN_TAX"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SCN_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors path="SCN_TAX"
													cssClass="error" /></td>
											<td><form:input path="VOLUNTARY_NO" type="text"
													style="text-align: right;" name="VOLUNTARY_NO"
													id="VOLUNTARY_NO" class="form-control min-width-1"
													autocomplete="off" maxlength="18" value="${model.VOLUNTARY_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors path="VOLUNTARY_NO"
													cssClass="error" /></td>
											<td><form:input path="VOLUNTARY_TAX" type="text"
													style="text-align: right;" name="VOLUNTARY_TAX"
													id="VOLUNTARY_TAX" class="form-control min-width-1"
													autocomplete="off" maxlength="18" value="${model.VOLUNTARY_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors path="VOLUNTARY_TAX"
													cssClass="error" /></td>

											<td><form:input path="MERIT_NO" type="text"
													style="text-align: right;" name="MERIT_NO" id="MERIT_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.MERIT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors path="MERIT_NO"
													cssClass="error" /></td>
											<td><form:input path="MERIT_TAX" type="text"
													style="text-align: right;" name="MERIT_TAX" id="MERIT_TAX"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.MERIT_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors path="MERIT_TAX"
													cssClass="error" /></td>

											<td><form:input path="TRANSFER_NO" type="text"
													style="text-align: right;" name="TRANSFER_NO"
													id="TRANSFER_NO" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.TRANSFER_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors path="TRANSFER_NO"
													cssClass="error" /></td>
											<td><form:input path="TRANSFER_TAX" type="text"
													style="text-align: right;" name="TRANSFER_TAX"
													id="TRANSFER_TAX" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.TRANSFER_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors path="TRANSFER_TAX"
													cssClass="error" /></td>
											<td><form:input path="CLOSING_BALANCE_NO" type="text"
													style="text-align: right;" name="CLOSING_BALANCE_NO"
													id="CLOSING_BALANCE_NO" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.CLOSING_BALANCE_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													readonly="true" /> <form:errors path="CLOSING_BALANCE_NO"
													cssClass="error" /></td>
											<td><form:input path="CLOSING_BALANCE_TAX" type="text"
													style="text-align: right;" name="CLOSING_BALANCE_TAX"
													id="CLOSING_BALANCE_TAX" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.CLOSING_BALANCE_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													readonly="true" /> <form:errors path="CLOSING_BALANCE_TAX"
													cssClass="error" /></td>
											<td><form:input path="LESS_THAN_2_NO" type="text"
													style="text-align: right;" name="LESS_THAN_2_NO"
													id="LESS_THAN_2_NO" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.LESS_THAN_2_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors path="LESS_THAN_2_NO"
													cssClass="error" /></td>
											<td><form:input path="LESS_THAN_2_TAX" type="text"
													style="text-align: right;" name="LESS_THAN_2_TAX"
													id="LESS_THAN_2_TAX" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.LESS_THAN_2_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors path="LESS_THAN_2_TAX"
													cssClass="error" /></td>
											<td><form:input path="MORE_THAN_2_NO" type="text"
													style="text-align: right;" name="MORE_THAN_2_NO"
													id="MORE_THAN_2_NO" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.MORE_THAN_2_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors path="MORE_THAN_2_NO"
													cssClass="error" /></td>
											<td><form:input path="MORE_THAN_2_TAX" type="text"
													style="text-align: right;" name="MORE_THAN_2_TAX"
													id="MORE_THAN_2_TAX" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.MORE_THAN_2_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors path="MORE_THAN_2_TAX"
													cssClass="error" /></td>
										</tr>
									</c:if>
								</table>
							</div>
						</div>
						<!-- As there is no editable field - commented upload, update and cancel button -->
						<c:if test="${not empty model}">
							<div align="center">
								<input name="btn_submit" class="btn btn-success" id="btn_submit"
									type="submit" value="${ViewBag_button}" /> <input
									type="hidden" name="hndresult" id="hndresult"
									value="${ViewBagMessage}" /> <input name="btn_Cancel"
									id="btn_Cancel" class="btn btn-danger" type="reset"
									value="Cancel" />

							</div>
						</c:if>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</div>
<c:if test="${flag == 'N'}">
	<c:if test="${empty model}">
		<form action="/MPR/GSTGI/Insert/GI_GST_2_Opening" id="gIGst2CommTemp"
			name="gIGst2CommTemp" autocomplete="off" method="post"
			modelAttribute="gIGst2CommTemp">

			<div class="modal fade" id="openingBox" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<%
								String strDate = (String) request.getAttribute("MM_YYYY");
							    String flag = (String) request.getAttribute("flag");
									java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
									java.util.Date date = srcDtFormat.parse(strDate);
									java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
									String desDt = desDtFormat.format(date);
							%>
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header"
							style="background-color: #f2dede; color: #a94442;">
							<h5 class="modal-title" id="exampleModalLabel">
								<span style="color: green; margin-right: 5%;">MONTH : <%=desDt.toUpperCase()%></span>
								<b>INVESTIGATION OF CASES</b>
							</h5>
						</div>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">

									<tr class="table-header-center text-center-capitalize">
										<td colspan="2">Opening Balance</td>

									</tr>
									<tr class="table-header-center">

										<td>No.</td>
										<td>Amount</td>

									</tr>

									<tr>
										<%
											String TokenNo = (String) request.getSession().getAttribute("TokenNo");
												String MM_YYYY = (String) request.getAttribute("MM_YYYY");
												String CRR = (String) request.getAttribute("CRR");
										%>
										<td><input type="hidden" id="HDTokenNo" name="HDTokenNo"
											value="<%=TokenNo%>" /> 
											<input type="hidden" id="MM_YYYY"
											name="MM_YYYY" value="${MM_YYYY}" /> <input type="hidden"
											id="CRR" name="CRR" value="${CRR}" /> <input type="hidden"
											id="request_CSRF_Token" name="request_CSRF_Token"
											value="<%=session.getAttribute("CSRF_Token")%>"> <input
											path="OPENING_BALANCE_NO" type="text" placeholder="0"
											name="OPENING_BALANCE_NO" id="OPENING_BALANCE_NO"
											class="form-control min-width-90" maxlength="18" autocomplete="off" value=""
											onkeypress="return event.charCode >= 48 && event.charCode <= 57"
											required="true" /> <form:errors path="OPENING_BALANCE_NO"
												cssClass="error" /></td>
										<td><input path="OPENING_BALANCE_AMOUNT" type="text"
											placeholder="0.00" name="OPENING_BALANCE_AMOUNT"
											id="OPENING_BALANCE_AMOUNT" class="form-control min-width-90"
											maxlength="18" autocomplete="off" value=""
											onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
											required="true" /> <form:errors
												path="OPENING_BALANCE_AMOUNT" cssClass="error" /></td>



									</tr>

								</table>


							</div>

							<div class="modal-footer">
								<!-- <button type="button" class="btn btn-danger" data-dismiss="modal" style="margin-right:10px;"
                    id="cancel_button">Close</button> -->
								<input type="submit"
									name="btn_submit" class="btn btn-success" value="Upload"
									id="UpdateId" />

							</div>
						</div>
					</div>
				</div>

		
		</form>
	</c:if>
</c:if>
<script
	src="<%=session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script
	src="<%=session.getAttribute("COMMON_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>
<script
	src="<%=session.getAttribute("JSP_PATH_RESOLVE")%>Content-MPR/jsMPR/jquery.validate.min.js"></script>
<script
	src="<%=session.getAttribute("JSP_PATH_RESOLVE")%>Content-MPR/jsMPR/jquery.validate.unobtrusive.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		if ('${CRR}' == null || '${CRR}' == "") {
			$("#btn_Abort").hide();
		}

		if ($("#hndresult").val() == "CORRECTION REQUEST SUBMITTED") {
			$("#btn_submit").hide();
			$("#btn_Abort").hide();
		} else {
			$("#btn_submit").show();
			if ('${CRR}' == "T") {
				$("#btn_submit").val("Submit");
			}
		}
		

		 addNewData1();
		 

	});
	
	 function addNewData1() {

		 		
			$('#openingBox').modal({
	            show: true,
	            backdrop: false,
	            keyboard: false
	        });
		} 

		
</script>

<script type="text/javascript">
	$(document).ready(function() {

		var button_name = $('#btn_submit').val();
		if (button_name == "Upload") {
			$('#btn_Cancel').show();
		} else {
			$('#btn_Cancel').hide();
		}

		$('.form-control').keyup(function(){
        	var val = $(this).val();
            if(isNaN(val)){
                 val = val.replace(/[^0-9\.]/g,'');
                 if(val.split('.').length>2) 
                     val =val.replace(/\.+$/,"");
            }
            if(val.indexOf(".") >= 0)
            	val = val.indexOf(".") >= 0 ? val.slice(0, val.indexOf(".") + 3) : val;
            $(this).val(val); 
        });
	});
</script>

<jsp:include page="../../GSTHome/Footer.jsp" />