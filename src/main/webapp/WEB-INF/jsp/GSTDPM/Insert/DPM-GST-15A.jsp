<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />
<link
	href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/mpr-report.css"
	rel="stylesheet" />
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-6">
			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-book fa-fw"></i> DPM-GST-15A[GST-REG-2]
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
		<form:form action="/MPR/GSTDPM/Insert/DPM_GST_15A" id="dpmGst15ACommTemp"
			name="dpmGst15ACommTemp" method="POST"
			modelAttribute="dpmGst15ACommTemp">
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
			</c:choose>
			<div class="col-lg-12">
				<div class="panel panel-danger">
					<div class="panel-heading text-capitalize">REPORT ON
						CANCELLATION OF REGISTRATION AND REVOCATION OF CANCELLED GSTIN</div>
					<div class="panel-body">
						<div class="panel panel-warning">
							<%
								String strDate = (String) request.getAttribute("MM_YYYY");
									java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
									java.util.Date date = srcDtFormat.parse(strDate);
									java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
									String desDt = desDtFormat.format(date);
							%>
							<div class="panel-heading sub-month">
								MONTH :
								<%=desDt.toUpperCase()%>
								<!--  <div class="sub-lakh">(Rs. In Crores)</div> -->
							</div>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<tr>
									<tr class="text-center-capitalize table-header-center">
										<td colspan="3">Suo Moto Cancellation</td>
										<td colspan="3">Cancellation on
											request</td>
										<td colspan="4">Revocation of
											cancelled GSTINs</td>
									</tr>
									<tr class="text-center-capitalize table-header-center">
										<td class="text-center">Opening Balance</td>
										<td class="text-center">GSTINs liable for cancellation
											[Section 29(2)]</td>
										<td class="text-center">GSTINs Cancelled</td>
										<td class="text-center">Opening Balance</td>
										<td class="text-center">No. of applications received
											[Section 29(1)]</td>
										<td class="text-center">GSTINs Cancelled</td>
										<td class="text-center">Opening Balance</td>
										<td class="text-center">ARNs received for revocation</td>
										<td class="text-center">Number of Revocation Applications
											accepted</th>
										<td class="text-center">Number of Revocation Application
											rejected</td>

									</tr>

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
												path="SUO_MOTO_OPENING_BALANCE" type="text" readonly="true"
												style="text-align: right;" name="SUO_MOTO_OPENING_BALANCE"
												id="SUO_MOTO_OPENING_BALANCE"
												class="form-control min-width-1" autocomplete="off"
												value="${model.SUO_MOTO_OPENING_BALANCE}"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors
												path="SUO_MOTO_OPENING_BALANCE" cssClass="error" /></td>
										<td><form:input
												path="SUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION" type="text"
												style="text-align: right;" readonly="true"
												name="SUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION"
												id="SUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION"
												class="form-control min-width-1" autocomplete="off"
												value="${model.SUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION}"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors
												path="SUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION"
												cssClass="error" /></td>
										<td><form:input path="SUO_MOTO_GSTIN_CANCELLED"
												type="text" style="text-align: right;" readonly="true"
												name="SUO_MOTO_GSTIN_CANCELLED"
												id="SUO_MOTO_GSTIN_CANCELLED"
												class="form-control min-width-1" autocomplete="off"
												value="${model.SUO_MOTO_GSTIN_CANCELLED}"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors
												path="SUO_MOTO_GSTIN_CANCELLED" cssClass="error" /></td>
										<td><form:input path="CANCELLATION_OPENING_BALANCE"
												type="text" readonly="true" style="text-align: right;"
												name="CANCELLATION_OPENING_BALANCE"
												id="CANCELLATION_OPENING_BALANCE"
												class="form-control min-width-1" autocomplete="off"
												value="${model.CANCELLATION_OPENING_BALANCE}"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors
												path="CANCELLATION_OPENING_BALANCE" cssClass="error" /></td>
										<td><form:input
												path="CANCELLATION_NO_APPLICATION_RECEIVED" type="text"
												style="text-align: right;" readonly="true"
												name="CANCELLATION_NO_APPLICATION_RECEIVED"
												id="CANCELLATION_NO_APPLICATION_RECEIVED"
												class="form-control min-width-1" autocomplete="off"
												value="${model.CANCELLATION_NO_APPLICATION_RECEIVED}"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors
												path="CANCELLATION_NO_APPLICATION_RECEIVED" cssClass="error" />
										</td>
										<td><form:input path="CANCELLATION_GSTIN_CANCELLED"
												type="text" style="text-align: right;" readonly="true"
												name="CANCELLATION_GSTIN_CANCELLED"
												id="CANCELLATION_GSTIN_CANCELLED"
												class="form-control min-width-1" autocomplete="off"
												value="${model.CANCELLATION_GSTIN_CANCELLED}"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors
												path="CANCELLATION_GSTIN_CANCELLED" cssClass="error" /></td>
										<td><form:input path="REVOCATION_OPENING_BALANCE"
												type="text" style="text-align: right;" readonly="true"
												name="REVOCATION_OPENING_BALANCE"
												id="REVOCATION_OPENING_BALANCE"
												class="form-control min-width-1" autocomplete="off"
												value="${model.REVOCATION_OPENING_BALANCE}"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors
												path="REVOCATION_OPENING_BALANCE" cssClass="error" /></td>
										<td><form:input path="REVOCATION_ARN_RECEIVED"
												type="text" style="text-align: right;" readonly="true"
												name="REVOCATION_ARN_RECEIVED" id="REVOCATION_ARN_RECEIVED"
												class="form-control min-width-1" autocomplete="off"
												value="${model.REVOCATION_ARN_RECEIVED}"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors
												path="REVOCATION_ARN_RECEIVED" cssClass="error" /></td>

										<td><form:input path="REVOCATION_GSTIN_REVOKED"
												type="text" style="text-align: right;" readonly="true"
												name="REVOCATION_GSTIN_REVOKED"
												id="REVOCATION_GSTIN_REVOKED"
												class="form-control min-width-1" autocomplete="off"
												value="${model.REVOCATION_GSTIN_REVOKED}"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors
												path="REVOCATION_GSTIN_REVOKED" cssClass="error" /></td>
										<td><form:input path="REVOCATION_APPLICATION_REJECTED"
												type="text" style="text-align: right;" readonly="true"
												name="REVOCATION_APPLICATION_REJECTED"
												id="REVOCATION_APPLICATION_REJECTED"
												class="form-control min-width-1" autocomplete="off"
												value="${model.REVOCATION_APPLICATION_REJECTED}"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors
												path="REVOCATION_APPLICATION_REJECTED" cssClass="error" />
										</td>
									</tr>

								</table>
							</div>
						</div>
						<!-- As there is no editable field - commented upload, update and cancel button -->
						 <%-- <div align="center">
                    <input name="btn_submit" class="btn btn-success" id="btn_submit" type="submit" value="${ViewBag_button}" />
                    <input type="hidden" name="hndresult" id="hndresult" value="${ViewBagMessage}" />
                    <input name="btn_Cancel" id="btn_Cancel" class="btn btn-danger" type="reset" value="Cancel" />

                </div> --%>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</div>


<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script src="<%= session.getAttribute("COMMON_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.unobtrusive.js"></script>


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

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		var button_name = $('#btn_submit').val();
		if (button_name == "Upload") {
			$('#btn_Cancel').show();
		} else {
			$('#btn_Cancel').hide();
		}

	});
</script>


<jsp:include page="../../GSTHome/Footer.jsp" />