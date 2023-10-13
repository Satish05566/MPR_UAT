<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-6">
			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-book fa-fw"></i> GI-GST-1A
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

		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<form:form action="/MPR/GSTGI/Insert/GI_GST_1A" id="giGst1ACommTemp"
			name="giGst1ACommTemp" method="POST" modelAttribute="giGst1ACommTemp">
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
					<div class="panel-heading text-capitalize">Arrest,
						Prosecution & Compounding of Offences</div>

					<!-- /.panel-heading -->
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
								<!-- <div class="sub-lakh">Amount in Rs. Lakhs</div> -->
							</div>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<tr class="table-header-center">

										<td rowspan="2" colspan="2" width="10%">ITEMS OF WORK</td>
										<td colspan="2" width="10%" class="table-datarow-center">
											CURRENT FINANCIAL YEAR</td>
										<td colspan="2" width="10%" class="table-datarow-center">
											PREVIOUS FINANCIAL YEAR</td>


									</tr>

									<tr class="table-header-center">

										<td rowspan="1" colspan="2" align="center"
											class="table-datarow-center">FOR THE MONTH</td>

										<td rowspan="1" colspan="2" align="center"
											class="table-datarow-center">FOR THE MONTH</td>

									</tr>
									<%-- <c:if test="${!(empty model)}"> --%>
										<tr class="table-datarow-right">
											<th colspan="2" class="header-text-readonly">ARRESTS MADE</th>

											<%
											String TokenNo = (String) request.getSession().getAttribute("TokenNo");
											String MM_YYYY = (String) request.getAttribute("MM_YYYY");
											String CRR = (String) request.getAttribute("CRR");
											%>

											<td colspan="2"><input type="hidden" id="HDTokenNo"
												name="HDTokenNo" value="<%=TokenNo%>" /> <input
												type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
												<input type="hidden" id="CRR" name="CRR" value="${CRR}" />
												<input type="hidden" id="request_CSRF_Token"
												name="request_CSRF_Token"
												value="<%=session.getAttribute("CSRF_Token")%>">
											<form:input path="ARRESTS_MADE" type="text"
													name="ARRESTS_MADE" id="ARRESTS_MADE"
													class="form-control min-width-1" autocomplete="off"
													value="${model.ARRESTS_MADE}"  required="true"  maxlength="18"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 " />
												<form:errors path="ARRESTS_MADE" cssClass="error" /></td>
											<td colspan="2"><form:input path="ARRESTS_MADE_PRE"
													type="text" name="ARRESTS_MADE_PRE" id="ARRESTS_MADE_PRE"
													class="form-control min-width-1" autocomplete="off"
													value="${model.ARRESTS_MADE_PRE}"  required="true"  maxlength="18"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 " />
												<form:errors path="ARRESTS_MADE_PRE" cssClass="error" /></td>


										</tr>

										<tr class="table-datarow-right">

											<th colspan="2" class="header-text-readonly">PROSECUTION SANCTIONED</th>
											<td colspan="2"><form:input
													path="PROSECUTION_SANCTIONED" type="text"
													name="PROSECUTION_SANCTIONED" id="PROSECUTION_SANCTIONED"
													class="form-control min-width-1" autocomplete="off"
													value="${model.PROSECUTION_SANCTIONED}" required="true"  maxlength="18"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57  " />
												<form:errors path="PROSECUTION_SANCTIONED" cssClass="error" />
											</td>
											<td colspan="2"><form:input
													path="PROSECUTION_SANCTIONED_PRE" type="text"
													name="PROSECUTION_SANCTIONED_PRE"
													id="PROSECUTION_SANCTIONED_PRE"
													class="form-control min-width-1" autocomplete="off"
													value="${model.PROSECUTION_SANCTIONED_PRE}" required="true"  maxlength="18"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 " />
												<form:errors path="PROSECUTION_SANCTIONED_PRE"
													cssClass="error" /></td>


										</tr>

										<tr class="table-datarow-right">
											<th colspan="2" class="header-text-readonly">COMPOUNDING OF OFFENCES</th>
											<td colspan="2"><form:input
													path="COMPOUNDING_OF_OFFENCES" type="text"
													name="COMPOUNDING_OF_OFFENCES" id="COMPOUNDING_OF_OFFENCES"
													class="form-control min-width-1" autocomplete="off"
													value="${model.COMPOUNDING_OF_OFFENCES}" required="true"  maxlength="18"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 " />
												<form:errors path="COMPOUNDING_OF_OFFENCES" cssClass="error" />
											</td>
											<td colspan="2"><form:input
													path="COMPOUNDING_OF_OFFENCES_PRE" type="text"
													name="COMPOUNDING_OF_OFFENCES_PRE"
													id="COMPOUNDING_OF_OFFENCES_PRE"
													class="form-control min-width-1" autocomplete="off"
													value="${model.COMPOUNDING_OF_OFFENCES_PRE}"
													required="true"  maxlength="18"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 " />
												<form:errors path="COMPOUNDING_OF_OFFENCES_PRE"
													cssClass="error" /></td>


										</tr>
										<tr class="table-datarow-right">
											<th colspan="2" class="header-text-readonly">PROSECUTION LAUNCHED</th>
											<td colspan="2"><form:input path="PROSECUTION_LAUNCHED"
													type="text" name="PROSECUTION_LAUNCHED"
													id="PROSECUTION_LAUNCHED" class="form-control min-width-1"
													autocomplete="off" value="${model.PROSECUTION_LAUNCHED}"
													required="true"  maxlength="18"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 " />
												<form:errors path="PROSECUTION_LAUNCHED" cssClass="error" />
											</td>
											<td colspan="2"><form:input
													path="PROSECUTION_LAUNCHED_PRE" type="text"
													name="PROSECUTION_LAUNCHED_PRE"
													id="PROSECUTION_LAUNCHED_PRE"
													class="form-control min-width-1" autocomplete="off"
													value="${model.PROSECUTION_LAUNCHED_PRE}" required="true"  maxlength="18"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 " />
												<form:errors path="PROSECUTION_LAUNCHED_PRE"
													cssClass="error" /></td>

										</tr>
									<%-- </c:if> --%>
								</table>
								<!-- /.table-responsive -->

							</div>


						</div>
						<!-- /.panel -->
						<!-- /.panel-body -->
						<%-- <c:if test="${!(empty model)}"> --%>
							<div align="center">
								<input name="btn_submit" type="submit" id="btn_submit"
									value="${ViewBag_button}" class="btn btn-success" /> <input
									type="hidden" name="hndresult" id="hndresult"
									value="${ViewBagMessage}" />
							</div>
						<%-- </c:if> --%>
					</div>
					<!-- /.col-lg-6 -->

				</div>
				</div>
		</form:form>
	</div>
</div>


<script
	src="<%=session.getAttribute("JSP_PATH_RESOLVE")%>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script
	src="<%=session.getAttribute("COMMON_PATH_RESOLVE")%>Content-Common/js/jquery.js"></script>
<script
	src="<%=session.getAttribute("JSP_PATH_RESOLVE")%>Content-MPR/jsMPR/jquery.validate.min.js"></script>

<script>
	$(document).ready(function() {

		if ($("#hndresult").val() == "Record Updated") {
			$("#btn_submit").hide();
			$("#div_msg").hide();

		} else {
			$("#btn_submit").show();
		}
		
	});
</script>
<jsp:include page="../../GSTHome/Footer.jsp" />

