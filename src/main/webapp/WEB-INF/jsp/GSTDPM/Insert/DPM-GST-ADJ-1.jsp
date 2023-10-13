<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />


<style>
.multiselect-container {
	position: relative !important;
}

.input_border_none {
	border-style: none;
	pointer-events: none;
	cursor: pointer;
}
</style>


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-6">
			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-book fa-fw"></i> GST-ADJ-1
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
							<%
							String code = (String) request.getSession().getAttribute("CODE");
							String MM_YYYY = (String) request.getAttribute("MM_YYYY");
							%>

							<%
							String strDate = (String) request.getAttribute("MM_YYYY");
							java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
							java.util.Date date = srcDtFormat.parse(strDate);
							java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
							String desDt = desDtFormat.format(date);
							java.text.DateFormat desDtFormat1 = new java.text.SimpleDateFormat("yyyy-MMM");
							String desDt1 = desDtFormat1.format(date);
							%>
		<form:form action="/MPR/GSTDPM/Insert/DPM_GST_ADJ_1"
			id="dpmGstAdj1CommTemp" name="dpmGstAdj1CommTemp" method="POST"
			modelAttribute="DpmGstAdj1CommTemp">

			<c:choose>
				<c:when
					test="${ViewBagMessage!=null || ViewBagMessage.length()==0 }">
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
					<div class="panel-heading text-capitalize">Statement
						indicating Receipt, Disposal & Pendency of Adjudication cases</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="panel panel-warning">
							
							<div class="panel-heading sub-month">
								MONTH :
								<%=desDt.toUpperCase()%>
								<div class="sub-lakh">Amount in Rs. Lakhs</div>
							</div>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<tbody>

										<tr class="text-center-capitalize table-header-center">
											<td rowspan="2">ADJUDICATING AUTHORITY</td>
											<td rowspan="2">CATEGORY</td>
											<td colspan="2" width="10%">OPENING BALANCE</td>
											<td colspan="2" width="10%">RECEIPT DURING THE MONTH</td>
											<td colspan="2" width="10%">DISPOSAL DURING THE MONTH</td>
											<td colspan="2" width="10%">% of cases where OIO issued
												within 30 days of PH</td>
											<td colspan="2" width="10%">CLOSING BALANCE</td>
											<td colspan="4" width="10%">AGE WISE BREAK-UP OF
												PENDENCY</td>
											<td colspan="4" width="10%">TIME LEFT FOR ADJUDICATION</td>
										</tr>
										<tr class="text-center-capitalize table-header-center">
											<td width="10%">NO</td>
											<td width="10%">AMT</td>
											<td width="10%">NO</td>
											<td width="10%">AMT</td>
											<td width="10%">NO</td>
											<td width="10%">AMT</td>
											<td width="10%">NO</td>
											<td width="10%">AMT</td>
											<td width="10%">NO</td>
											<td width="10%">AMT</td>
											<td width="10%">Less than 3 months</td>
											<td width="10%">3 to 6 months</td>
											<td width="10%">6 to12 months</td>
											<td width="10%">More than 1 year</td>

											<td width="10%">Less than 3 months</td>
											<td width="10%">3 to 6 months</td>
											<td width="10%">6 to12 months</td>
											<td width="10%">More than 1 year</td>

										</tr>
										<%-- <c:if test="${!(empty model)}"> --%>
										<tr class="text-center-capitalize">
											<td class = "header-text-readonly" rowspan="4">ADC/JC</td>
											<td class = "header-text-readonly">COMMISSIONERATE LEVEL CASES</td>
											<%
											String TokenNo = (String) request.getSession().getAttribute("TokenNo");
											String CRR = (String) request.getAttribute("CRR");
											%>
											<td><input type="hidden" id="HDTokenNo" name="HDTokenNo"
												value="<%=TokenNo%>" /> <input type="hidden" id="MM_YYYY"
												name="MM_YYYY" value="${MM_YYYY}" /> <input type="hidden"
												id="CRR" name="CRR" value="${CRR}" /> <input type="hidden"
												id="request_CSRF_Token" name="request_CSRF_Token"
												value="<%=session.getAttribute("CSRF_Token")%>"> <form:input
													path="ADC_COMMISSIONERATE_OPENING_NO"
													name="ADC_COMMISSIONERATE_OPENING_NO"
													id="ADC_COMMISSIONERATE_OPENING_NO"
													class="form-control min-width-1"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													value="${model.ADC_COMMISSIONERATE_OPENING_NO}"  readonly='true'
													required="true"  maxlength="18" /> <form:errors
													path="ADC_COMMISSIONERATE_OPENING_NO" cssClass="error" /></td>
											<td><form:input path="ADC_COMMISSIONERATE_OPENING_AMT"
													type="text" name="ADC_COMMISSIONERATE_OPENING_AMT"
													id="ADC_COMMISSIONERATE_OPENING_AMT"
													class="form-control min-width-1"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													value="${model.ADC_COMMISSIONERATE_OPENING_AMT}"  readonly='true'
													required="true"  maxlength="18" /> <form:errors
													path="ADC_COMMISSIONERATE_OPENING_AMT" cssClass="error" /></td>
											<td><form:input path="ADC_COMMISSIONERATE_RECEIPT_NO"  
													type="text" name="ADC_COMMISSIONERATE_RECEIPT_NO"
													id="ADC_COMMISSIONERATE_RECEIPT_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_RECEIPT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"/>
												<form:errors path="ADC_COMMISSIONERATE_RECEIPT_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_COMMISSIONERATE_RECEIPT_AMT"
													type="text" name="ADC_COMMISSIONERATE_RECEIPT_AMT"
													id="ADC_COMMISSIONERATE_RECEIPT_AMT"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_RECEIPT_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_RECEIPT_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_COMMISSIONERATE_DISPOSAL_NO"
													type="text" name="ADC_COMMISSIONERATE_DISPOSAL_NO"
													id="ADC_COMMISSIONERATE_DISPOSAL_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_DISPOSAL_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_DISPOSAL_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_COMMISSIONERATE_DISPOSAL_AMT"
													type="text" name="ADC_COMMISSIONERATE_DISPOSAL_AMT"
													id="ADC_COMMISSIONERATE_DISPOSAL_AMT"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_DISPOSAL_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_DISPOSAL_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_COMMISSIONERATE_OIO_NO"
													type="text" name="ADC_COMMISSIONERATE_OIO_NO"
													id="ADC_COMMISSIONERATE_OIO_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_OIO_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_OIO_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_COMMISSIONERATE_OIO_AMT"
													type="text" name="ADC_COMMISSIONERATE_OIO_AMT"
													id="ADC_COMMISSIONERATE_OIO_AMT"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_OIO_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_OIO_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_COMM_CLOSING_NO" type="text"
													name="ADC_COMM_CLOSING_NO" id="ADC_COMM_CLOSING_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMM_CLOSING_NO}" readonly='true'  
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_COMM_CLOSING_NO" cssClass="error" /></td>
											<td><form:input path="ADC_COMM_CLOSING_AMT" type="text"
													name="ADC_COMM_CLOSING_AMT" id="ADC_COMM_CLOSING_AMT"
													class="form-control min-width-1"
													value="${model.ADC_COMM_CLOSING_AMT}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="ADC_COMM_CLOSING_AMT" cssClass="error" /></td>
											<td><form:input path="ADC_COMMISSIONERATE_AGE_LESS_3_NO"
													type="text" name="ADC_COMMISSIONERATE_AGE_LESS_3_NO"
													id="ADC_COMMISSIONERATE_AGE_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_AGE_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_AGE_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_COMMISSIONERATE_AGE_3_TO_6_NO"
													type="text" name="ADC_COMMISSIONERATE_AGE_3_TO_6_NO"
													id="ADC_COMMISSIONERATE_AGE_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_AGE_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_AGE_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input
													path="ADC_COMMISSIONERATE_AGE_6_TO_12_NO" type="text"
													name="ADC_COMMISSIONERATE_AGE_6_TO_12_NO"
													id="ADC_COMMISSIONERATE_AGE_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_AGE_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_AGE_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input
													path="ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO" type="text"
													name="ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO"
													id="ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO"
													cssClass="error" /></td>
											<td><form:input
													path="ADC_COMMISSIONERATE_TIME_LESS_3_NO" type="text"
													name="ADC_COMMISSIONERATE_TIME_LESS_3_NO"
													id="ADC_COMMISSIONERATE_TIME_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_TIME_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_TIME_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input
													path="ADC_COMMISSIONERATE_TIME_3_TO_6_NO" type="text"
													name="ADC_COMMISSIONERATE_TIME_3_TO_6_NO"
													id="ADC_COMMISSIONERATE_TIME_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_TIME_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_TIME_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input
													path="ADC_COMMISSIONERATE_TIME_6_TO_12_NO" type="text"
													name="ADC_COMMISSIONERATE_TIME_6_TO_12_NO"
													id="ADC_COMMISSIONERATE_TIME_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_TIME_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_TIME_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input
													path="ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO" type="text"
													name="ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO"
													id="ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO"
													cssClass="error" /></td>
										</tr>
										<tr class="text-center-capitalize ">

											<td class = "header-text-readonly">AUDIT CASES</td>
											<td><form:input path="ADC_AUDIT_OPENING_NO" type="text"
													name="ADC_AUDIT_OPENING_NO" id="ADC_AUDIT_OPENING_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_OPENING_NO}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_OPENING_NO" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_OPENING_AMT" type="text"
													name="ADC_AUDIT_OPENING_AMT" id="ADC_AUDIT_OPENING_AMT"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_OPENING_AMT}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_OPENING_AMT" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_RECEIPT_NO" type="text"
													name="ADC_AUDIT_RECEIPT_NO" id="ADC_AUDIT_RECEIPT_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_RECEIPT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_RECEIPT_NO" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_RECEIPT_AMT" type="text"
													name="ADC_AUDIT_RECEIPT_AMT" id="ADC_AUDIT_RECEIPT_AMT"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_RECEIPT_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_RECEIPT_AMT" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_DISPOSAL_NO" type="text"
													name="ADC_AUDIT_DISPOSAL_NO" id="ADC_AUDIT_DISPOSAL_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_DISPOSAL_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_DISPOSAL_NO" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_DISPOSAL_AMT"
													type="text" name="ADC_AUDIT_DISPOSAL_AMT"
													id="ADC_AUDIT_DISPOSAL_AMT"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_DISPOSAL_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_DISPOSAL_AMT" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_OIO_NO" type="text"
													name="ADC_AUDIT_OIO_NO" id="ADC_AUDIT_OIO_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_OIO_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_OIO_NO" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_OIO_AMT" type="text"
													name="ADC_AUDIT_OIO_AMT" id="ADC_AUDIT_OIO_AMT"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_OIO_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_OIO_AMT" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_CLOSING_NO" type="text"
													name="ADC_AUDIT_CLOSING_NO" id="ADC_AUDIT_CLOSING_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_CLOSING_NO}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_AUDIT_CLOSING_NO" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_CLOSING_AMT" type="text"
													name="ADC_AUDIT_CLOSING_AMT" id="ADC_AUDIT_CLOSING_AMT"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_CLOSING_AMT}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="ADC_AUDIT_CLOSING_AMT" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_AGE_LESS_3_NO"
													type="text" name="ADC_AUDIT_AGE_LESS_3_NO"
													id="ADC_AUDIT_AGE_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_AGE_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_AGE_LESS_3_NO" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_AGE_3_TO_6_NO"
													type="text" name="ADC_AUDIT_AGE_3_TO_6_NO"
													id="ADC_AUDIT_AGE_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_AGE_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_AGE_3_TO_6_NO" cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_AGE_6_TO_12_NO"
													type="text" name="ADC_AUDIT_AGE_6_TO_12_NO"
													id="ADC_AUDIT_AGE_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_AGE_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_AGE_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_AGE_MORE_THAN_1_NO"
													type="text" name="ADC_AUDIT_AGE_MORE_THAN_1_NO"
													id="ADC_AUDIT_AGE_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_AGE_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_AGE_MORE_THAN_1_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_TIME_LESS_3_NO"
													type="text" name="ADC_AUDIT_TIME_LESS_3_NO"
													id="ADC_AUDIT_TIME_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_TIME_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_TIME_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_TIME_3_TO_6_NO"
													type="text" name="ADC_AUDIT_TIME_3_TO_6_NO"
													id="ADC_AUDIT_TIME_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_TIME_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_TIME_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_TIME_6_TO_12_NO"
													type="text" name="ADC_AUDIT_TIME_6_TO_12_NO"
													id="ADC_AUDIT_TIME_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_TIME_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_TIME_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_AUDIT_TIME_MORE_THAN_1_NO"
													type="text" name="ADC_AUDIT_TIME_MORE_THAN_1_NO"
													id="ADC_AUDIT_TIME_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.ADC_AUDIT_TIME_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_AUDIT_TIME_MORE_THAN_1_NO"
													cssClass="error" /></td>
										</tr>
										
										<tr class="text-center-capitalize">

											<td class = "header-text-readonly">INVESTIGATION AGENCIES CASES</td>
											<td><form:input path="ADC_INVESTIGATION_OPENING_NO"
													type="text" name="ADC_INVESTIGATION_OPENING_NO"
													id="ADC_INVESTIGATION_OPENING_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_OPENING_NO}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_OPENING_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_OPENING_AMT"
													type="text" name="ADC_INVESTIGATION_OPENING_AMT"
													id="ADC_INVESTIGATION_OPENING_AMT"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_OPENING_AMT}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_OPENING_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_RECEIPT_NO"
													type="text" name="ADC_INVESTIGATION_RECEIPT_NO"
													id="ADC_INVESTIGATION_RECEIPT_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_RECEIPT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_RECEIPT_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_RECEIPT_AMT"
													type="text" name="ADC_INVESTIGATION_RECEIPT_AMT"
													id="ADC_INVESTIGATION_RECEIPT_AMT"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_RECEIPT_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_RECEIPT_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_DISPOSAL_NO"
													type="text" name="ADC_INVESTIGATION_DISPOSAL_NO"
													id="ADC_INVESTIGATION_DISPOSAL_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_DISPOSAL_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_DISPOSAL_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_DISPOSAL_AMT"
													type="text" name="ADC_INVESTIGATION_DISPOSAL_AMT"
													id="ADC_INVESTIGATION_DISPOSAL_AMT"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_DISPOSAL_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_DISPOSAL_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_OIO_NO"
													type="text" name="ADC_INVESTIGATION_OIO_NO"
													id="ADC_INVESTIGATION_OIO_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_OIO_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_OIO_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_OIO_AMT"
													type="text" name="ADC_INVESTIGATION_OIO_AMT"
													id="ADC_INVESTIGATION_OIO_AMT"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_OIO_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_OIO_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_CLOSING_NO"
													type="text" name="ADC_INVESTIGATION_CLOSING_NO"
													id="ADC_INVESTIGATION_CLOSING_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_CLOSING_NO}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_INVESTIGATION_CLOSING_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_CLOSING_AMT"
													type="text" name="ADC_INVESTIGATION_CLOSING_AMT"
													id="ADC_INVESTIGATION_CLOSING_AMT"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_CLOSING_AMT}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="ADC_INVESTIGATION_CLOSING_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_AGE_LESS_3_NO"
													type="text" name="ADC_INVESTIGATION_AGE_LESS_3_NO"
													id="ADC_INVESTIGATION_AGE_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_AGE_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_AGE_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_AGE_3_TO_6_NO"
													type="text" name="ADC_INVESTIGATION_AGE_3_TO_6_NO"
													id="ADC_INVESTIGATION_AGE_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_AGE_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_AGE_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_AGE_6_TO_12_NO"
													type="text" name="ADC_INVESTIGATION_AGE_6_TO_12_NO"
													id="ADC_INVESTIGATION_AGE_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_AGE_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_AGE_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input
													path="ADC_INVESTIGATION_AGE_MORE_THAN_1_NO" type="text"
													name="ADC_INVESTIGATION_AGE_MORE_THAN_1_NO"
													id="ADC_INVESTIGATION_AGE_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_AGE_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_AGE_MORE_THAN_1_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_TIME_LESS_3_NO"
													type="text" name="ADC_INVESTIGATION_TIME_LESS_3_NO"
													id="ADC_INVESTIGATION_TIME_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_TIME_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_TIME_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_TIME_3_TO_6_NO"
													type="text" name="ADC_INVESTIGATION_TIME_3_TO_6_NO"
													id="ADC_INVESTIGATION_TIME_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_TIME_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_TIME_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_INVESTIGATION_TIME_6_TO_12_NO"
													type="text" name="ADC_INVESTIGATION_TIME_6_TO_12_NO"
													id="ADC_INVESTIGATION_TIME_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_TIME_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_TIME_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input
													path="ADC_INVESTIGATION_TIME_MORE_THAN_1_NO" type="text"
													name="ADC_INVESTIGATION_TIME_MORE_THAN_1_NO"
													id="ADC_INVESTIGATION_TIME_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.ADC_INVESTIGATION_TIME_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="ADC_INVESTIGATION_TIME_MORE_THAN_1_NO"
													cssClass="error" /></td>
										</tr>
										<tr class="text-center-capitalize">

											<td class = "header-text-readonly">CALL BOOK CASES CASES PENDING UNDER SECTION 75(11)
												OF CGST ACT</td>
											<td><form:input path="ADC_CALLBOOK_OPENING_NO"
													type="text" name="ADC_CALLBOOK_OPENING_NO"
													id="ADC_CALLBOOK_OPENING_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_OPENING_NO}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"   />
												<form:errors path="ADC_CALLBOOK_OPENING_NO" cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_OPENING_AMT"
													type="text" name="ADC_CALLBOOK_OPENING_AMT"
													id="ADC_CALLBOOK_OPENING_AMT"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_OPENING_AMT}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_OPENING_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_RECEIPT_NO"
													type="text" name="ADC_CALLBOOK_RECEIPT_NO"
													id="ADC_CALLBOOK_RECEIPT_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_RECEIPT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_RECEIPT_NO" cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_RECEIPT_AMT"
													type="text" name="ADC_CALLBOOK_RECEIPT_AMT"
													id="ADC_CALLBOOK_RECEIPT_AMT"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_RECEIPT_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_RECEIPT_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_DISPOSAL_NO"
													type="text" name="ADC_CALLBOOK_DISPOSAL_NO"
													id="ADC_CALLBOOK_DISPOSAL_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_DISPOSAL_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_DISPOSAL_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_DISPOSAL_AMT"
													type="text" name="ADC_CALLBOOK_DISPOSAL_AMT"
													id="ADC_CALLBOOK_DISPOSAL_AMT"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_DISPOSAL_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_DISPOSAL_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_OIO_NO" type="text"
													name="ADC_CALLBOOK_OIO_NO" id="ADC_CALLBOOK_OIO_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_OIO_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_OIO_NO" cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_OIO_AMT" type="text"
													name="ADC_CALLBOOK_OIO_AMT" id="ADC_CALLBOOK_OIO_AMT"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_OIO_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_OIO_AMT" cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_CLOSING_NO"
													type="text" name="ADC_CALLBOOK_CLOSING_NO"
													id="ADC_CALLBOOK_CLOSING_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_CLOSING_NO}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_CLOSING_NO" cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_CLOSING_AMT"
													type="text" name="ADC_CALLBOOK_CLOSING_AMT"
													id="ADC_CALLBOOK_CLOSING_AMT"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_CLOSING_AMT}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_CLOSING_AMT"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_AGE_LESS_3_NO"
													type="text" name="ADC_CALLBOOK_AGE_LESS_3_NO"
													id="ADC_CALLBOOK_AGE_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_AGE_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_AGE_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_AGE_3_TO_6_NO"
													type="text" name="ADC_CALLBOOK_AGE_3_TO_6_NO"
													id="ADC_CALLBOOK_AGE_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_AGE_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_AGE_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_AGE_6_TO_12_NO"
													type="text" name="ADC_CALLBOOK_AGE_6_TO_12_NO"
													id="ADC_CALLBOOK_AGE_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_AGE_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_AGE_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_AGE_MORE_THAN_1_NO"
													type="text" name="ADC_CALLBOOK_AGE_MORE_THAN_1_NO"
													id="ADC_CALLBOOK_AGE_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_AGE_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_AGE_MORE_THAN_1_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_TIME_LESS_3_NO"
													type="text" name="ADC_CALLBOOK_TIME_LESS_3_NO"
													id="ADC_CALLBOOK_TIME_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_TIME_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_TIME_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_TIME_3_TO_6_NO"
													type="text" name="ADC_CALLBOOK_TIME_3_TO_6_NO"
													id="ADC_CALLBOOK_TIME_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_TIME_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_TIME_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_TIME_6_TO_12_NO"
													type="text" name="ADC_CALLBOOK_TIME_6_TO_12_NO"
													id="ADC_CALLBOOK_TIME_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_TIME_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_TIME_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input path="ADC_CALLBOOK_TIME_MORE_THAN_1_NO"
													type="text" name="ADC_CALLBOOK_TIME_MORE_THAN_1_NO"
													id="ADC_CALLBOOK_TIME_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.ADC_CALLBOOK_TIME_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="ADC_CALLBOOK_TIME_MORE_THAN_1_NO"
													cssClass="error" /></td>
										</tr>
	
										<tr class="text-center-capitalize ">
											<td class = "header-text-readonly" rowspan="4">DC/AC</td>
											<td class = "header-text-readonly">COMMISSIONERATE LEVEL CASES</td>
											<td><form:input path="DC_COMMISSIONERATE_OPENING_NO"
													name="DC_COMMISSIONERATE_OPENING_NO"
													id="DC_COMMISSIONERATE_OPENING_NO"
													class="form-control min-width-1"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													value="${model.DC_COMMISSIONERATE_OPENING_NO}"  readonly='true'
													required="true"  maxlength="18" /> <form:errors
													path="DC_COMMISSIONERATE_OPENING_NO" cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_OPENING_AMT"
													type="text" name="DC_COMMISSIONERATE_OPENING_AMT"
													id="DC_COMMISSIONERATE_OPENING_AMT"
													class="form-control min-width-1"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													value="${model.DC_COMMISSIONERATE_OPENING_AMT}"  readonly='true'
													required="true"  maxlength="18" /> <form:errors
													path="DC_COMMISSIONERATE_OPENING_AMT" cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_RECEIPT_NO"
													type="text" name="DC_COMMISSIONERATE_RECEIPT_NO"
													id="DC_COMMISSIONERATE_RECEIPT_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_RECEIPT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_RECEIPT_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_RECEIPT_AMT"
													type="text" name="DC_COMMISSIONERATE_RECEIPT_AMT"
													id="DC_COMMISSIONERATE_RECEIPT_AMT"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_RECEIPT_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_RECEIPT_AMT"
													cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_DISPOSAL_NO"
													type="text" name="DC_COMMISSIONERATE_DISPOSAL_NO"
													id="DC_COMMISSIONERATE_DISPOSAL_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_DISPOSAL_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_DISPOSAL_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_DISPOSAL_AMT"
													type="text" name="DC_COMMISSIONERATE_DISPOSAL_AMT"
													id="DC_COMMISSIONERATE_DISPOSAL_AMT"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_DISPOSAL_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_DISPOSAL_AMT"
													cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_OIO_NO"
													type="text" name="DC_COMMISSIONERATE_OIO_NO"
													id="DC_COMMISSIONERATE_OIO_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_OIO_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_OIO_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_OIO_AMT"
													type="text" name="DC_COMMISSIONERATE_OIO_AMT"
													id="DC_COMMISSIONERATE_OIO_AMT"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_OIO_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_OIO_AMT"
													cssClass="error" /></td>
											<td><form:input path="DC_COMM_CLOSING_NO" type="text"
													name="DC_COMM_CLOSING_NO" id="DC_COMM_CLOSING_NO"
													class="form-control min-width-1"
													value="${model.DC_COMM_CLOSING_NO}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_COMM_CLOSING_NO" cssClass="error" /></td>
											<td><form:input path="DC_COMM_CLOSING_AMT" type="text"
													name="DC_COMM_CLOSING_AMT" id="DC_COMM_CLOSING_AMT"
													class="form-control min-width-1"
													value="${model.DC_COMM_CLOSING_AMT}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="DC_COMM_CLOSING_AMT" cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_AGE_LESS_3_NO"
													type="text" name="DC_COMMISSIONERATE_AGE_LESS_3_NO"
													id="DC_COMMISSIONERATE_AGE_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_AGE_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_AGE_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_AGE_3_TO_6_NO"
													type="text" name="DC_COMMISSIONERATE_AGE_3_TO_6_NO"
													id="DC_COMMISSIONERATE_AGE_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_AGE_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_AGE_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_AGE_6_TO_12_NO"
													type="text" name="DC_COMMISSIONERATE_AGE_6_TO_12_NO"
													id="DC_COMMISSIONERATE_AGE_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_AGE_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_AGE_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input
													path="DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO" type="text"
													name="DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO"
													id="DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_TIME_LESS_3_NO"
													type="text" name="DC_COMMISSIONERATE_TIME_LESS_3_NO"
													id="DC_COMMISSIONERATE_TIME_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_TIME_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_TIME_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_COMMISSIONERATE_TIME_3_TO_6_NO"
													type="text" name="DC_COMMISSIONERATE_TIME_3_TO_6_NO"
													id="DC_COMMISSIONERATE_TIME_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_TIME_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_TIME_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input
													path="DC_COMMISSIONERATE_TIME_6_TO_12_NO" type="text"
													name="DC_COMMISSIONERATE_TIME_6_TO_12_NO"
													id="DC_COMMISSIONERATE_TIME_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_TIME_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_TIME_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input
													path="DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO" type="text"
													name="DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO"
													id="DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO"
													cssClass="error" /></td>
										</tr>
										<tr class="text-center-capitalize">

											<td class = "header-text-readonly">AUDIT CASES</td>
											<td><form:input path="DC_AUDIT_OPENING_NO" type="text"
													name="DC_AUDIT_OPENING_NO" id="DC_AUDIT_OPENING_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_OPENING_NO}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_OPENING_NO" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_OPENING_AMT" type="text"
													name="DC_AUDIT_OPENING_AMT" id="DC_AUDIT_OPENING_AMT"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_OPENING_AMT}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_OPENING_AMT" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_RECEIPT_NO" type="text"
													name="DC_AUDIT_RECEIPT_NO" id="DC_AUDIT_RECEIPT_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_RECEIPT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_RECEIPT_NO" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_RECEIPT_AMT" type="text"
													name="DC_AUDIT_RECEIPT_AMT" id="DC_AUDIT_RECEIPT_AMT"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_RECEIPT_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_RECEIPT_AMT" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_DISPOSAL_NO" type="text"
													name="DC_AUDIT_DISPOSAL_NO" id="DC_AUDIT_DISPOSAL_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_DISPOSAL_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_DISPOSAL_NO" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_DISPOSAL_AMT" type="text"
													name="DC_AUDIT_DISPOSAL_AMT" id="DC_AUDIT_DISPOSAL_AMT"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_DISPOSAL_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_DISPOSAL_AMT" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_OIO_NO" type="text"
													name="DC_AUDIT_OIO_NO" id="DC_AUDIT_OIO_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_OIO_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_OIO_NO" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_OIO_AMT" type="text"
													name="DC_AUDIT_OIO_AMT" id="DC_AUDIT_OIO_AMT"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_OIO_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_OIO_AMT" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_CLOSING_NO" type="text"
													name="DC_AUDIT_CLOSING_NO" id="DC_AUDIT_CLOSING_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_CLOSING_NO}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_AUDIT_CLOSING_NO" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_CLOSING_AMT" type="text"
													name="DC_AUDIT_CLOSING_AMT" id="DC_AUDIT_CLOSING_AMT"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_CLOSING_AMT}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="DC_AUDIT_CLOSING_AMT" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_AGE_LESS_3_NO"
													type="text" name="DC_AUDIT_AGE_LESS_3_NO"
													id="DC_AUDIT_AGE_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_AGE_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_AGE_LESS_3_NO" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_AGE_3_TO_6_NO"
													type="text" name="DC_AUDIT_AGE_3_TO_6_NO"
													id="DC_AUDIT_AGE_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_AGE_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_AGE_3_TO_6_NO" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_AGE_6_TO_12_NO"
													type="text" name="DC_AUDIT_AGE_6_TO_12_NO"
													id="DC_AUDIT_AGE_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_AGE_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_AGE_6_TO_12_NO" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_AGE_MORE_THAN_1_NO"
													type="text" name="DC_AUDIT_AGE_MORE_THAN_1_NO"
													id="DC_AUDIT_AGE_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_AGE_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_AGE_MORE_THAN_1_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_TIME_LESS_3_NO"
													type="text" name="DC_AUDIT_TIME_LESS_3_NO"
													id="DC_AUDIT_TIME_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_TIME_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_TIME_LESS_3_NO" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_TIME_3_TO_6_NO"
													type="text" name="DC_AUDIT_TIME_3_TO_6_NO"
													id="DC_AUDIT_TIME_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_TIME_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_TIME_3_TO_6_NO" cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_TIME_6_TO_12_NO"
													type="text" name="DC_AUDIT_TIME_6_TO_12_NO"
													id="DC_AUDIT_TIME_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_TIME_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_TIME_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_AUDIT_TIME_MORE_THAN_1_NO"
													type="text" name="DC_AUDIT_TIME_MORE_THAN_1_NO"
													id="DC_AUDIT_TIME_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.DC_AUDIT_TIME_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_AUDIT_TIME_MORE_THAN_1_NO"
													cssClass="error" /></td>
										</tr>
										
										<tr class="text-center-capitalize">

											<td class = "header-text-readonly">INVESTIGATION AGENCIES CASES</td>
											<td><form:input path="DC_INVESTIGATION_OPENING_NO"
													type="text" name="DC_INVESTIGATION_OPENING_NO"
													id="DC_INVESTIGATION_OPENING_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_OPENING_NO}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_OPENING_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_OPENING_AMT"
													type="text" name="DC_INVESTIGATION_OPENING_AMT"
													id="DC_INVESTIGATION_OPENING_AMT"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_OPENING_AMT}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_OPENING_AMT"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_RECEIPT_NO"
													type="text" name="DC_INVESTIGATION_RECEIPT_NO"
													id="DC_INVESTIGATION_RECEIPT_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_RECEIPT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_RECEIPT_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_RECEIPT_AMT"
													type="text" name="DC_INVESTIGATION_RECEIPT_AMT"
													id="DC_INVESTIGATION_RECEIPT_AMT"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_RECEIPT_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_RECEIPT_AMT"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_DISPOSAL_NO"
													type="text" name="DC_INVESTIGATION_DISPOSAL_NO"
													id="DC_INVESTIGATION_DISPOSAL_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_DISPOSAL_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_DISPOSAL_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_DISPOSAL_AMT"
													type="text" name="DC_INVESTIGATION_DISPOSAL_AMT"
													id="DC_INVESTIGATION_DISPOSAL_AMT"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_DISPOSAL_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_DISPOSAL_AMT"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_OIO_NO"
													type="text" name="DC_INVESTIGATION_OIO_NO"
													id="DC_INVESTIGATION_OIO_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_OIO_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_OIO_NO" cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_OIO_AMT"
													type="text" name="DC_INVESTIGATION_OIO_AMT"
													id="DC_INVESTIGATION_OIO_AMT"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_OIO_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_OIO_AMT"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_CLOSING_NO"
													type="text" name="DC_INVESTIGATION_CLOSING_NO"
													id="DC_INVESTIGATION_CLOSING_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_CLOSING_NO}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_INVESTIGATION_CLOSING_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_CLOSING_AMT"
													type="text" name="DC_INVESTIGATION_CLOSING_AMT"
													id="DC_INVESTIGATION_CLOSING_AMT"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_CLOSING_AMT}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="DC_INVESTIGATION_CLOSING_AMT"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_AGE_LESS_3_NO"
													type="text" name="DC_INVESTIGATION_AGE_LESS_3_NO"
													id="DC_INVESTIGATION_AGE_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_AGE_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_AGE_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_AGE_3_TO_6_NO"
													type="text" name="DC_INVESTIGATION_AGE_3_TO_6_NO"
													id="DC_INVESTIGATION_AGE_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_AGE_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_AGE_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_AGE_6_TO_12_NO"
													type="text" name="DC_INVESTIGATION_AGE_6_TO_12_NO"
													id="DC_INVESTIGATION_AGE_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_AGE_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_AGE_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input
													path="DC_INVESTIGATION_AGE_MORE_THAN_1_NO" type="text"
													name="DC_INVESTIGATION_AGE_MORE_THAN_1_NO"
													id="DC_INVESTIGATION_AGE_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_AGE_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_AGE_MORE_THAN_1_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_TIME_LESS_3_NO"
													type="text" name="DC_INVESTIGATION_TIME_LESS_3_NO"
													id="DC_INVESTIGATION_TIME_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_TIME_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_TIME_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_TIME_3_TO_6_NO"
													type="text" name="DC_INVESTIGATION_TIME_3_TO_6_NO"
													id="DC_INVESTIGATION_TIME_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_TIME_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_TIME_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_INVESTIGATION_TIME_6_TO_12_NO"
													type="text" name="DC_INVESTIGATION_TIME_6_TO_12_NO"
													id="DC_INVESTIGATION_TIME_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_TIME_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_TIME_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input
													path="DC_INVESTIGATION_TIME_MORE_THAN_1_NO" type="text"
													name="DC_INVESTIGATION_TIME_MORE_THAN_1_NO"
													id="DC_INVESTIGATION_TIME_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.DC_INVESTIGATION_TIME_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18" />
												<form:errors path="DC_INVESTIGATION_TIME_MORE_THAN_1_NO"
													cssClass="error" /></td>
										</tr>
										<tr class="text-center-capitalize">

											<td class = "header-text-readonly">CALL BOOK CASES CASES PENDING UNDER SECTION 75(11)
												OF CGST ACT</td>
											<td><form:input path="DC_CALLBOOK_OPENING_NO"
													type="text" name="DC_CALLBOOK_OPENING_NO"
													id="DC_CALLBOOK_OPENING_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_OPENING_NO}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"   />
												<form:errors path="DC_CALLBOOK_OPENING_NO" cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_OPENING_AMT"
													type="text" name="DC_CALLBOOK_OPENING_AMT"
													id="DC_CALLBOOK_OPENING_AMT"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_OPENING_AMT}"  readonly='true'
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"   />
												<form:errors path="DC_CALLBOOK_OPENING_AMT" cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_RECEIPT_NO"
													type="text" name="DC_CALLBOOK_RECEIPT_NO"
													id="DC_CALLBOOK_RECEIPT_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_RECEIPT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_RECEIPT_NO" cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_RECEIPT_AMT"
													type="text" name="DC_CALLBOOK_RECEIPT_AMT"
													id="DC_CALLBOOK_RECEIPT_AMT"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_RECEIPT_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_RECEIPT_AMT" cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_DISPOSAL_NO"
													type="text" name="DC_CALLBOOK_DISPOSAL_NO"
													id="DC_CALLBOOK_DISPOSAL_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_DISPOSAL_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_DISPOSAL_NO" cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_DISPOSAL_AMT"
													type="text" name="DC_CALLBOOK_DISPOSAL_AMT"
													id="DC_CALLBOOK_DISPOSAL_AMT"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_DISPOSAL_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_DISPOSAL_AMT"
													cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_OIO_NO" type="text"
													name="DC_CALLBOOK_OIO_NO" id="DC_CALLBOOK_OIO_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_OIO_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_OIO_NO" cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_OIO_AMT" type="text"
													name="DC_CALLBOOK_OIO_AMT" id="DC_CALLBOOK_OIO_AMT"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_OIO_AMT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_OIO_AMT" cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_CLOSING_NO"
													type="text" name="DC_CALLBOOK_CLOSING_NO"
													id="DC_CALLBOOK_CLOSING_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_CLOSING_NO}" readonly='true' 
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_CLOSING_NO" cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_CLOSING_AMT"
													type="text" name="DC_CALLBOOK_CLOSING_AMT"
													id="DC_CALLBOOK_CLOSING_AMT"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_CLOSING_AMT}" readonly='true'  
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_CLOSING_AMT" cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_AGE_LESS_3_NO"
													type="text" name="DC_CALLBOOK_AGE_LESS_3_NO"
													id="DC_CALLBOOK_AGE_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_AGE_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_AGE_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_AGE_3_TO_6_NO"
													type="text" name="DC_CALLBOOK_AGE_3_TO_6_NO"
													id="DC_CALLBOOK_AGE_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_AGE_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_AGE_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_AGE_6_TO_12_NO"
													type="text" name="DC_CALLBOOK_AGE_6_TO_12_NO"
													id="DC_CALLBOOK_AGE_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_AGE_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_AGE_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_AGE_MORE_THAN_1_NO"
													type="text" name="DC_CALLBOOK_AGE_MORE_THAN_1_NO"
													id="DC_CALLBOOK_AGE_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_AGE_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_AGE_MORE_THAN_1_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_TIME_LESS_3_NO"
													type="text" name="DC_CALLBOOK_TIME_LESS_3_NO"
													id="DC_CALLBOOK_TIME_LESS_3_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_TIME_LESS_3_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_TIME_LESS_3_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_TIME_3_TO_6_NO"
													type="text" name="DC_CALLBOOK_TIME_3_TO_6_NO"
													id="DC_CALLBOOK_TIME_3_TO_6_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_TIME_3_TO_6_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_TIME_3_TO_6_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_TIME_6_TO_12_NO"
													type="text" name="DC_CALLBOOK_TIME_6_TO_12_NO"
													id="DC_CALLBOOK_TIME_6_TO_12_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_TIME_6_TO_12_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_TIME_6_TO_12_NO"
													cssClass="error" /></td>
											<td><form:input path="DC_CALLBOOK_TIME_MORE_THAN_1_NO"
													type="text" name="DC_CALLBOOK_TIME_MORE_THAN_1_NO"
													id="DC_CALLBOOK_TIME_MORE_THAN_1_NO"
													class="form-control min-width-1"
													value="${model.DC_CALLBOOK_TIME_MORE_THAN_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"  maxlength="18"  />
												<form:errors path="DC_CALLBOOK_TIME_MORE_THAN_1_NO"
													cssClass="error" /></td>
										</tr>
										

										<jsp:include page="../../GSTDPM/Insert/DPM-GST-ADJ-1-1.jsp" />
										<%-- </c:if> --%>
									</tbody>
								</table>
							</div>
						</div>
						<%-- <c:if test="${!(empty model)}"> --%>
						<div align="center">
							<input name="btn_submit" class="btn btn-success" id="btn_submit"
								type="submit" value="${ViewBag_button}" /> <input type="hidden"
								name="hndresult" id="hndresult" value="${ViewBagMessage}" /> <input
								name="btn_Cancel" id="btn_Cancel" class="btn btn-danger"
								type="reset" value="Cancel" />
								<input name="btn_opening" class="btn btn-success" id="btn_opening"
								type="hidden" value="${ViewBag_button}" />

						</div>
						<%-- </c:if> --%>
					</div>
				</div>
			</div>


		</form:form>
	</div>
</div>

<form action="/MPR/GSTDPM/Insert/DPM_GST_ADJ_1_OPENING" id="DpmGstAdj1CommTemp" name = "DpmGstAdj1CommTemp" method="POST"  modelAttribute="dpmGstAdj1CommTemp">

<div class="modal fade" id="openingBox" tabindex="-1" role="dialog"
aria-labelledby="exampleModalLabel" aria-hidden="true">

<div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
        <div class="modal-header"
            style="background-color: #f2dede; color: #a94442; ">
            <h5 class="modal-title" id="exampleModalLabel">
                <span style="color: green;margin-right: 5%;">MONTH : <%=desDt.toUpperCase()%></span>  
                Statement indicating Receipt, Disposal & Pendency of Adjudication cases
            </h5>
           
        </div>
        
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                       <c:choose>
				<c:when
					test="${ViewBagOpeningMessage!=null || ViewBagOpeningMessage.length()==0 }">
					<div class="col-lg-12">
						<div class="alert alert-warning" id="opening_error">
							<span class="closebtn"
								onclick="this.parentElement.style.display='none';">&times;</span>
							${ViewBagOpeningMessage}
						</div>
					</div>
				</c:when>
			</c:choose>
                      <tr class="table-header-center text-center-capitalize">
                              <td rowspan="2" width="5%">ADJUDICATING AUTHORITY</td>
								<td rowspan="2" colspan="2" width="5%">CATEGORY</td>
								<td colspan="2" width="20%">OPENING BALANCE</td>
                              
                     </tr>
                     <tr class="table-header-center">
                     
                         <td>No </td>
                         <td>Amount </td>
                                                
                     </tr>
            
                      <tr class="text-center-capitalize">
                             
                              <th class="text-center header-text-readonly " rowspan="4">1</th>
                              <td class = "header-text-readonly" rowspan="4">ADC/JC</td>
							  <td class = "header-text-readonly">COMMISSIONERATE LEVEL CASES</td>
                             
                              <%
									String TokenNo = (String) request.getSession().getAttribute("TokenNo");
									String CRR = (String) request.getAttribute("CRR");
							  %>
							  <td><input type="hidden" id="HDTokenNo" name="HDTokenNo"
									value="<%=TokenNo%>" /> <input type="hidden" id="MM_YYYY"
									name="MM_YYYY" value="${MM_YYYY}" /> <input type="hidden"
									id="CRR" name="CRR" value="${CRR}" /> <input type="hidden"
									id="request_CSRF_Token" name="request_CSRF_Token"
									value="<%=session.getAttribute("CSRF_Token")%>"> 
                                  <input path="ADC_COMMISSIONERATE_OPENING_NO" type="text" placeholder="0" name="ADC_COMMISSIONERATE_OPENING_NO" id="ADC_COMMISSIONERATE_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="ADC_COMMISSIONERATE_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="ADC_COMMISSIONERATE_OPENING_AMT" type="text" placeholder="0.00" name="ADC_COMMISSIONERATE_OPENING_AMT" id="ADC_COMMISSIONERATE_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="ADC_COMMISSIONERATE_OPENING_AMT" cssClass="error" />                                  
                              </td> 
                        </tr>
                        <tr>      
                         <td class = "header-text-readonly">AUDIT CASES</td>
                              <td>
                                  <input path="ADC_AUDIT_OPENING_NO" type="text" placeholder="0" name="ADC_AUDIT_OPENING_NO" id="ADC_AUDIT_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  maxlength="2" />
                                  <form:errors path="ADC_AUDIT_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="ADC_AUDIT_OPENING_AMT" type="text" placeholder="0.00" name="ADC_AUDIT_OPENING_AMT" id="ADC_AUDIT_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="ADC_AUDIT_OPENING_AMT" cssClass="error" />                                  
                              </td> 
                          </tr>
                          <tr>    
                          <td class = "header-text-readonly">INVESTIGATION AGENCIES CASES</td>
                              <td>
                                  <input path="ADC_INVESTIGATION_OPENING_NO" type="text" placeholder="0" name="ADC_INVESTIGATION_OPENING_NO" id="ADC_INVESTIGATION_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="ADC_INVESTIGATION_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="ADC_INVESTIGATION_OPENING_AMT" type="text" placeholder="0.00" name="ADC_INVESTIGATION_OPENING_AMT" id="ADC_INVESTIGATION_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="ADC_INVESTIGATION_OPENING_AMT" cssClass="error" />                                  
                              </td>
                           </tr>
                           <tr> 
                           <td class = "header-text-readonly">CALL BOOK CASES CASES PENDING UNDER SECTION 75(11) OF CGST ACT</td>
                              <td>
                                  <input path="ADC_CALLBOOK_OPENING_NO" type="text" placeholder="0" name="ADC_CALLBOOK_OPENING_NO" id="ADC_CALLBOOK_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="ADC_CALLBOOK_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="ADC_CALLBOOK_OPENING_AMT" type="text" placeholder="0.00" name="ADC_CALLBOOK_OPENING_AMT" id="ADC_CALLBOOK_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="ADC_CALLBOOK_OPENING_AMT" cssClass="error" />                                  
                              </td> 
                         </tr>
                         
                         <tr class="text-center-capitalize">
                             
                              <th class="text-center header-text-readonly" rowspan="4">2</th>
                              <td class = "header-text-readonly" rowspan="4">DC</td>
							  <td class = "header-text-readonly">COMMISSIONERATE LEVEL CASES</td>
                             
                              <td>
                                  <input path="DC_COMMISSIONERATE_OPENING_NO" type="text" placeholder="0" name="DC_COMMISSIONERATE_OPENING_NO" id="DC_COMMISSIONERATE_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="DC_COMMISSIONERATE_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="DC_COMMISSIONERATE_OPENING_AMT" type="text" placeholder="0.00" name="DC_COMMISSIONERATE_OPENING_AMT" id="DC_COMMISSIONERATE_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="DC_COMMISSIONERATE_OPENING_AMT" cssClass="error" />                                  
                              </td> 
                        </tr>
                        <tr>      
                              <td class = "header-text-readonly">AUDIT CASES</td>
                              <td>
                                  <input path="DC_AUDIT_OPENING_NO" type="text" placeholder="0" name="DC_AUDIT_OPENING_NO" id="DC_AUDIT_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="DC_AUDIT_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="DC_AUDIT_OPENING_AMT" type="text" placeholder="0.00" name="DC_AUDIT_OPENING_AMT" id="DC_AUDIT_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="DC_AUDIT_OPENING_AMT" cssClass="error" />                                  
                              </td> 
                          </tr>
                          <tr>    
                              
                              <td class = "header-text-readonly">INVESTIGATION AGENCIES CASES</td>
                              <td>
                                  <input path="DC_INVESTIGATION_OPENING_NO" type="text" placeholder="0" name="DC_INVESTIGATION_OPENING_NO" id="DC_INVESTIGATION_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="DC_INVESTIGATION_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="DC_INVESTIGATION_OPENING_AMT" type="text" placeholder="0.00" name="DC_INVESTIGATION_OPENING_AMT" id="DC_INVESTIGATION_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="DC_INVESTIGATION_OPENING_AMT" cssClass="error" />                                  
                              </td>
                           </tr>
                           <tr> 
                           <td class = "header-text-readonly">CALL BOOK CASES CASES PENDING UNDER SECTION 75(11) OF CGST ACT</td>
                              <td>
                                  <input path="DC_CALLBOOK_OPENING_NO" type="text" placeholder="0" name="DC_CALLBOOK_OPENING_NO" id="DC_CALLBOOK_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="DC_CALLBOOK_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="DC_CALLBOOK_OPENING_AMT" type="text" placeholder="0.00" name="DC_CALLBOOK_OPENING_AMT" id="DC_CALLBOOK_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="DC_CALLBOOK_OPENING_AMT" cssClass="error" />                                  
                              </td> 
                         </tr>
                         
                         <tr class="text-center-capitalize">
                             
                              <th class="text-center header-text-readonly" rowspan="4">3</th>
                              <td class = "header-text-readonly" rowspan="4">SUPERINTENDENT</td>
							  <td class = "header-text-readonly">COMMISSIONERATE LEVEL CASES</td>
                             
                              <td>
                                  <input path="SUPERINTENDENT_COMMISSIONERATE_OPENING_NO" type="text" placeholder="0" name="SUPERINTENDENT_COMMISSIONERATE_OPENING_NO" id="SUPERINTENDENT_COMMISSIONERATE_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="SUPERINTENDENT_COMMISSIONERATE_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT" type="text" placeholder="0.00" name="SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT" id="SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT" cssClass="error" />                                  
                              </td> 
                        </tr>
                        <tr>     
                         <td class = "header-text-readonly">AUDIT CASES</td> 
                              <td>
                                  <input path="SUPERINTENDENT_AUDIT_OPENING_NO" type="text" placeholder="0" name="SUPERINTENDENT_AUDIT_OPENING_NO" id="SUPERINTENDENT_AUDIT_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="SUPERINTENDENT_AUDIT_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="SUPERINTENDENT_AUDIT_OPENING_AMT" type="text" placeholder="0.00" name="SUPERINTENDENT_AUDIT_OPENING_AMT" id="SUPERINTENDENT_AUDIT_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="SUPERINTENDENT_AUDIT_OPENING_AMT" cssClass="error" />                                  
                              </td> 
                          </tr>
                          <tr>    
                          <td class = "header-text-readonly">INVESTIGATION AGENCIES CASES</td>
                              <td>
                                  <input path="SUPERINTENDENT_INVESTIGATION_OPENING_NO" type="text" placeholder="0" name="SUPERINTENDENT_INVESTIGATION_OPENING_NO" id="SUPERINTENDENT_INVESTIGATION_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="SUPERINTENDENT_INVESTIGATION_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="SUPERINTENDENT_INVESTIGATION_OPENING_AMT" type="text" placeholder="0.00" name="SUPERINTENDENT_INVESTIGATION_OPENING_AMT" id="SUPERINTENDENT_INVESTIGATION_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="SUPERINTENDENT_INVESTIGATION_OPENING_AMT" cssClass="error" />                                  
                              </td>
                           </tr>
                           <tr> 
                           <td class = "header-text-readonly">CALL BOOK CASES CASES PENDING UNDER SECTION 75(11) OF CGST ACT</td>
                              <td>
                                  <input path="SUPERINTENDENT_CALLBOOK_OPENING_NO" type="text" placeholder="0" name="SUPERINTENDENT_CALLBOOK_OPENING_NO" id="SUPERINTENDENT_CALLBOOK_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required="true"  maxlength="18"  />
                                  <form:errors path="SUPERINTENDENT_CALLBOOK_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="SUPERINTENDENT_CALLBOOK_OPENING_AMT" type="text" placeholder="0.00" name="SUPERINTENDENT_CALLBOOK_OPENING_AMT" id="SUPERINTENDENT_CALLBOOK_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  maxlength="18"   />
                                     <form:errors path="SUPERINTENDENT_CALLBOOK_OPENING_AMT" cssClass="error" />                                  
                              </td> 
                         </tr>

                 </table>

                
          </div>

            <div class="modal-footer">
                <!-- <button type="button" class="btn btn-danger" data-dismiss="modal" style="margin-right:10px;"
                    id="cancel_button">Close</button> -->
                <input type="submit" name="btn_submit" class="btn btn-success"
                    value="Upload" id="UpdateId" /> 

            </div>
    </div>
</div>
</div>


</form>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script
	src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<script type="text/javascript">
    $(document).ready(function () {
        $("#tr1_hidden").hide();
        if ('${CRR}' == "" || '${CRR}' == null) {
            $("#btn_Abort").hide();
        }

        if (location.href.indexOf('?') != -1) {

            $("#anchnext_month").hide();
            $("#btn_Abort").hide();
        }
        else {
            if ($("#hndresult").val() == "INCOMPLETE CORRECTION REQUEST") {
                $("#anchnext_month").show();
            }
            else {
                $("#anchnext_month").hide();
                if ($("#hndresult").val() != "" && $("#hndresult").val() == "CORRECTION REQUEST NOT SUBMITTED") {
                    GetNext();
                }
            }
        }

    });

    $(document).ready(function () {
    	
    	if(($('#MM_YYYY').val() == '2023-04-01') && ${(empty model)})
    		addNewData1();
    	
        if ($("#hndresult").val() == "CORRECTION REQUEST SUBMITTED") {
            $("#btn_Abort").hide();
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

	
	/* $(".datepicker").datepicker({    
	    //startDate: "+0d",
	    //format: 'dd/mm/yyyy'
	    dateFormat: 'dd/mm/yy',
	    firstDay: 1,
	}); */
	
	
    function addNewData1() {
		
		$('#openingBox').modal({
            show: true,
            backdrop: false,
            keyboard: false
        });
	}
</script>

<!-- <script type="text/javascript">

    $(document).ready(function () {

        

    function ValidateInt(integer) {
        var expr = /^[0-9]{1,18}$/;
        return expr.test(integer);
    };
    function ValidateNumeric(numeric) {
        var expr = /^[0-9]\d{0,9}(\.\d{0,2})?%?$/;
        return expr.test(numeric);
    };

    }); 
</script> -->
<jsp:include page="../../GSTHome/Footer.jsp" />



