<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-6">
			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-book fa-fw"></i> GI-GST-4
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
		<form:form action="/MPR/GSTGI/Insert/GI_GST_4" id="giGst4CommTemp"
			name="giGst4CommTemp" method="POST" modelAttribute="giGst4CommTemp">
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
					<div class="panel-heading text-capitalize">Anti-evasion
						performance</div>


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
								<%= desDt.toUpperCase() %>

								<div class="sub-lakh">Amount: Rs. in Lakhs</div>
							</div>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">

									<tr class="table-header-center text-center-capitalize">
										<td rowspan="2" style="width: 2%;">S.No.</td>
										<td rowspan="2" colspan="2" style="width: 60%;">Description
											of Work</td>
										<td colspan="3">For the month</td>
									</tr>
									<tr class="table-header-center">
										<td colspan="3">No.</td>
									</tr>

									<%-- <c:if test="${not empty model }"> --%>
										<tr>
											<th class="table-datarow-center header-text-readonly">1</th>
											<th colspan="2" class="header-text-readonly">AE-1 Filed</th>

											<%   
                                String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                String MM_YYYY = (String) request.getAttribute("MM_YYYY");
                                String CRR = (String) request.getAttribute("CRR");
                                %>

											<td colspan="3"><input type="hidden" id="HDTokenNo"
												name="HDTokenNo" value="<%=TokenNo%>" /> <input
												type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
												<input type="hidden" id="CRR" name="CRR" value="${CRR}" />
												<input type="hidden" id="request_CSRF_Token"
												name="request_CSRF_Token"
												value="<%= session.getAttribute("CSRF_Token") %>"> <form:input
													path="AE_1_NO" type="text" name="AE_1_NO" id="AE_1_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.AE_1_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors path="AE_1_NO"
													cssClass="error" style="float: right;" /></td>

										</tr>

										<tr>
											<th class="table-datarow-center header-text-readonly">2</th>
											<th colspan="2" class="header-text-readonly">AE-2 Filed</th>
											<td colspan="3"><form:input path="AE_2_NO" type="text"
													name="AE_2_NO" id="AE_2_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.AE_2_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors path="AE_2_NO"
													cssClass="error" style="float: right;" /></td>
										</tr>

										<tr class=" header-text-readonly">
											<th class="text-center">3</th>
											<th colspan="2">Inspection of premises conducted (u/s 67
												(1) of the CGST Act, 2017)</th>
											<td colspan="3"><form:input
													path="INSPECTION_PERMISES_NO" type="text"
													name="INSPECTION_PERMISES_NO" id="INSPECTION_PERMISES_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.INSPECTION_PERMISES_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors
													path="INSPECTION_PERMISES_NO" cssClass="error" /></td>
										</tr>

										<tr class=" header-text-readonly">
											<th class="table-datarow-center header-text-readonly">4</th>
											<th colspan="2" class="header-text-readonly">Searches (u/s 67 (2) of the CGST Act,
												2017)</th>
											<td colspan="3"><form:input path="SEARCHES_NO"
													type="text" name="SEARCHES_NO" id="SEARCHES_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEARCHES_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors
													path="SEARCHES_NO" cssClass="error" /></td>
										</tr>

										<tr>
											<th class="table-datarow-center header-text-readonly">5</th>
											<th colspan="2" class="header-text-readonly">Inspection of goods in movement
												conducted (u/s 68 of the CGST Act, 2017)</th>
											<td colspan="3"><form:input path="INSPECTION_GOODS_NO"
													type="text" name="INSPECTION_GOODS_NO"
													id="INSPECTION_GOODS_NO" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.INSPECTION_GOODS_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors path="INSPECTION_GOODS_NO"
													cssClass="error" style="float: right;" /></td>
										</tr>

										<tr class=" header-text-readonly">
											<th class="text-center">6</th>
											<th colspan="2">Summons issued (u/s 70 of the CGST Act,
												2017)</th>
											<td colspan="3"><form:input path="SUMMONS_NO"
													type="text" name="SUMMONS_NO" id="SUMMONS_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SUMMONS_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors
													path="SUMMONS_NO" cssClass="error" /></td>
										</tr>

										<tr class=" header-text-readonly">
											<th class="text-center" rowspan="4">7</th>
											<th rowspan="4">Seizure (u/s 67 (2) of the CGST Act,
												2017)</th>
											<th class="text-center">Description</th>
											<th class="text-center">No.</th>
											<th class="text-center">Value</th>
											<th class="text-center">Tax involved</th>

										</tr>


										<tr class=" header-text-readonly">
											<th>Goods</th>
											<td><form:input path="SEIZUR67_GOODS_NO" type="text"
													name="SEIZUR67_GOODS_NO" id="SEIZUR67_GOODS_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR67_GOODS_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors
													path="SEIZUR67_GOODS_NO" cssClass="error" /></td>
											<td><form:input path="SEIZUR67_GOODS_VALUE" type="text"
													name="SEIZUR67_GOODS_VALUE" id="SEIZUR67_GOODS_VALUE"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR67_GOODS_VALUE}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors
													path="SEIZUR67_GOODS_VALUE" cssClass="error" /></td>
											<td><form:input path="SEIZUR67_GOODS_TAX" type="text"
													name="SEIZUR67_GOODS_TAX" id="SEIZUR67_GOODS_TAX"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR67_GOODS_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors
													path="SEIZUR67_GOODS_TAX" cssClass="error" /></td>

										</tr>

										<tr class=" header-text-readonly">
											<th>Vehicles</th>
											<td><form:input path="SEIZUR67_VEHICLES_NO" type="text"
													name="SEIZUR67_VEHICLES_NO" id="SEIZUR67_VEHICLES_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR67_VEHICLES_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors
													path="SEIZUR67_VEHICLES_NO" cssClass="error" /></td>
											<td><form:input path="SEIZUR67_VEHICLES_VALUE"
													type="text" name="SEIZUR67_VEHICLES_VALUE"
													id="SEIZUR67_VEHICLES_VALUE"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR67_VEHICLES_VALUE}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors
													path="SEIZUR67_VEHICLES_VALUE" cssClass="error" /></td>
											<td><form:input path="SEIZUR67_VEHICLES_TAX" type="text"
													name="SEIZUR67_VEHICLES_TAX" id="SEIZUR67_VEHICLES_TAX"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR67_VEHICLES_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors
													path="SEIZUR67_VEHICLES_TAX" cssClass="error" /></td>

										</tr>

										<tr>
											<th class="header-text-readonly">Currency</th>
											<td><form:input path="SEIZUR67_CURRENCY_NO" type="text"
													name="SEIZUR67_CURRENCY_NO" id="SEIZUR67_CURRENCY_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR67_CURRENCY_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true" /> <form:errors
													path="SEIZUR67_CURRENCY_NO" cssClass="error"
													style="float: right;" /></td>
											<td><form:input path="SEIZUR67_CURRENCY_VALUE"
													type="text" name="SEIZUR67_CURRENCY_VALUE"
													id="SEIZUR67_CURRENCY_VALUE"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR67_CURRENCY_VALUE}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors
													path="SEIZUR67_CURRENCY_VALUE" cssClass="error"
													style="float: right;" /></td>
											<td><form:input path="SEIZUR67_CURRENCY_TAX" type="text"
													name="SEIZUR67_CURRENCY_TAX" id="SEIZUR67_CURRENCY_TAX"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR67_CURRENCY_TAX}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" step=".01"/> <form:errors
													path="SEIZUR67_CURRENCY_TAX" cssClass="error"
													style="float: right;" /></td>

										</tr>




										<tr class=" header-text-readonly">
											<th class="text-center" rowspan="2">8</th>
											<th rowspan="2">Seizure (u/s 129(1) of the CGST Act,
												2017)</th>
											<th>Goods in transit (Specify UQC*)</th>
											<td><form:input path="SEIZUR129_GOODS_NO" type="text"
													name="SEIZUR129_GOODS_NO" id="SEIZUR129_GOODS_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR129_GOODS_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors
													path="SEIZUR129_GOODS_NO" cssClass="error" /></td>
											<td colspan="2"><form:input path="SEIZUR129_GOODS_VALUE"
													type="text" name="SEIZUR129_GOODS_VALUE"
													id="SEIZUR129_GOODS_VALUE" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.SEIZUR129_GOODS_VALUE}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors
													path="SEIZUR129_GOODS_VALUE" cssClass="error" /></td>

										</tr>

										<tr class=" header-text-readonly">
											<th>Vehicles in transit</th>
											<td><form:input path="SEIZUR129_VEHICLES_NO" type="text"
													name="SEIZUR129_VEHICLES_NO" id="SEIZUR129_VEHICLES_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR129_VEHICLES_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors
													path="SEIZUR129_VEHICLES_NO" cssClass="error" /></td>
											<td colspan="2"><form:input
													path="SEIZUR129_VEHICLES_VALUE" type="text"
													name="SEIZUR129_VEHICLES_VALUE"
													id="SEIZUR129_VEHICLES_VALUE"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.SEIZUR129_VEHICLES_VALUE}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors
													path="SEIZUR129_VEHICLES_VALUE" cssClass="error" /></td>

										</tr>

										<tr class=" header-text-readonly">
											<th class="text-center" rowspan="4">9</th>
											<th rowspan="4">Attachment of property including bank
												accounts (u/s 83 (1) of the CGST Act, 2017)</th>
											<th  class="text-center">Description</th>
											<th class="text-center" colspan="2">No.</th>
											<th  class="text-center">Value</th>
										</tr>

										<tr class=" header-text-readonly">
											<th>Provisional Attachment of goods</th>
											<td colspan="2"><form:input path="ATTACHMENT_GOODS_NO"
													type="text" name="ATTACHMENT_GOODS_NO"
													id="ATTACHMENT_GOODS_NO" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.ATTACHMENT_GOODS_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
													required="true"/> <form:errors path="ATTACHMENT_GOODS_NO"
													cssClass="error" style="float: right;" /></td>
											<td><form:input path="ATTACHMENT_GOODS_VALUE"
													type="text" name="ATTACHMENT_GOODS_VALUE"
													id="ATTACHMENT_GOODS_VALUE"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.ATTACHMENT_GOODS_VALUE}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors
													path="ATTACHMENT_GOODS_VALUE" cssClass="error"
													style="float: right;" /></td>
										</tr>

										<tr class=" header-text-readonly">
											<th>Provisional Attachment of property</th>
											<td colspan="2"><form:input
													path="ATTACHMENT_PROPERTY_NO" type="text"
													name="ATTACHMENT_PROPERTY_NO" id="ATTACHMENT_PROPERTY_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.ATTACHMENT_PROPERTY_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors
													path="ATTACHMENT_PROPERTY_NO" cssClass="error"
													style="float: right;" /></td>
											<td><form:input path="ATTACHMENT_PROPERTY_VALUE"
													type="text" name="ATTACHMENT_PROPERTY_VALUE"
													id="ATTACHMENT_PROPERTY_VALUE"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.ATTACHMENT_PROPERTY_VALUE}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true" /> <form:errors
													path="ATTACHMENT_PROPERTY_VALUE" cssClass="error"
													style="float: right;" /></td>
										</tr>

										<tr class=" header-text-readonly">
											<th>Provisional Attachment of bank accounts (only Nos.
												to be reported)</th>
											<td colspan="3"><form:input path="ATTACHMENT_ACCOUNT_NO"
													type="text" name="ATTACHMENT_ACCOUNT_NO"
													id="ATTACHMENT_ACCOUNT_NO" class="form-control min-width-1"
													maxlength="18" autocomplete="off" value="${model.ATTACHMENT_ACCOUNT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors
													path="ATTACHMENT_ACCOUNT_NO" cssClass="error"
													style="float: right;" /></td>
										</tr>



										<tr class=" header-text-readonly">
											<th class="text-center" rowspan="2">10</th>
											<th rowspan="2">Incident Reports issued</th>
											<th>No. of IRs only</th>
											<td colspan="3"><form:input path="INCIDENT_NO"
													type="text" name="INCIDENT_NO" id="INCIDENT_NO"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.INCIDENT_NO}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57"
													required="true" /> <form:errors
													path="INCIDENT_NO" cssClass="error" /></td>

										</tr>

										<tr class=" header-text-readonly">
											<th>Detection Amount</th>
											<td colspan="3"><form:input path="INCIDENT_AMOUNT"
													type="text" name="INCIDENT_AMOUNT" id="INCIDENT_AMOUNT"
													class="form-control min-width-1" maxlength="18" autocomplete="off"
													value="${model.INCIDENT_AMOUNT}"
													onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
													required="true"  /> <form:errors
													path="INCIDENT_AMOUNT" cssClass="error" /></td>

										</tr>
									<%-- </c:if> --%>
								</table>

							</div>
						</div>
						<%-- <c:if test="${not empty model }">  --%> 
                * UQC=Unit Quantity Code
                <!-- /.panel -->
							<div align="center">
								<input name="btn_submit" class="btn btn-success" id="btn_submit"
									type="submit" value="${ViewBag_button}" /> <input
									type="hidden" name="hndresult" id="hndresult"
									value="${ViewBagMessage}" /> <input name="btn_Cancel"
									id="btn_Cancel" class="btn btn-danger" type="reset"
									value="Cancel" />

							</div>
						<%-- </c:if> --%>
					</div>
					<!-- /.col-lg-6 -->

				</div>
			</div>


		</form:form>
	</div>
</div>

<!-- @*Inline Plugin Script For Validation Purpose*@ -->

<script
	src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script
	src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>



<script type="text/javascript">
    $(document).ready(function () {
    	if ('${CRR}' == null || '${CRR}' == "") {
            $("#btn_Abort").hide();
        }

        if ($("#hndresult").val() == "CORRECTION REQUEST SUBMITTED") {
            $("#btn_submit").hide();
            $("#btn_Abort").hide();
        }
        else {
            $("#btn_submit").show();
            if('${CRR}' == "T")
                {
            	  $("#btn_submit").val("Submit");
                }
        }


    });

</script>

<script type="text/javascript">
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

</script>

<script type="text/javascript">
    $(document).ready(function () {

        var button_name = $('#btn_submit').val();
        if (button_name == "Upload") {
            $('#btn_Cancel').show();
        }
        else {
            $('#btn_Cancel').hide();
        }

    });
</script>


<jsp:include page="../../GSTHome/Footer.jsp" />


