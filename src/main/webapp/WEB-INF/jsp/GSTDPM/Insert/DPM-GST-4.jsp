<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />
<%
 String code = (String)request.getSession().getAttribute("CODE");
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
				<i class="fa fa-book fa-fw"></i> DPM-GST-4
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
	<form:form action="/GSTDPM/Insert/DPM_GST_4" id="DpmGst4CommTemp"
		name="DpmGst4CommTemp" method="POST" modelAttribute="DpmGst4CommTemp">

		<c:choose>
			<c:when test="${ViewBagMessage!=null || ViewBagMessage.length() ==0}">
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
				<div class="panel-heading text-capitalize">REFUND</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="panel panel-warning">

						<div class="panel-heading sub-month">
							MONTH :
							<%= desDt.toUpperCase() %>
							<div class="sub-lakh">Amount in Rs. Crores</div>
						</div>
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover">
								<tbody>
									<tr class="text-center-capitalize table-header-center">
										<td rowspan="3" align="center">Action</td>
										<td rowspan="3" align="center">Sr. No.</td>
										<td rowspan="3" align="center" width="20%">Refund
											category</td>
										<td rowspan="2" colspan="2" align="center">Opening
											Balance</td>
										<td rowspan="2" colspan="2" align="center">RFD 01</td>
										<td rowspan="2" colspan="1" align="center">RFD-02 issued
											within 15 days</td>
										<td rowspan="2" colspan="2" align="center">RFD 03</td>
										<td rowspan="2" colspan="2" align="center">RFD-04 Issued</td>
										<td rowspan="1" colspan="4" align="center">RFD 06*</td>
										<!-- <th rowspan="2" colspan="2" align="center">Closing Balance</th> -->
										<td rowspan="1" colspan="6" align="center">Age Wise
											Breakup</td>
									</tr>
									<tr class="text-center-capitalize table-header-center">
										<td rowspan="1" colspan="2" align="center">Sanctioned</td>
										<td rowspan="1" colspan="2" align="center">Rejected</td>
										<td rowspan="1" colspan="2" align="center">30-45 days</td>
										<td rowspan="1" colspan="2" align="center">46-60 days</td>
										<td rowspan="1" colspan="2" align="center">Above 60 days</td>
									</tr>
									<tr class="text-center-capitalize table-header-center">
										<td rowspan="1" colspan="1" align="center">No.</td>
										<td rowspan="1" colspan="1" align="center">Amount</td>
										<td rowspan="1" colspan="1" align="center">No.</td>
										<td rowspan="1" colspan="1" align="center">Amount</td>
										<td rowspan="1" colspan="1" align="center">No.</td>
										<td rowspan="1" colspan="1" align="center">No.</td>
										<td rowspan="1" colspan="1" align="center">Amount</td>

										<td rowspan="1" colspan="1" align="center">No.</td>
										<td rowspan="1" colspan="1" align="center">Amount</td>

										<td rowspan="1" colspan="1" align="center">No.</td>
										<td rowspan="1" colspan="1" align="center">Amount</td>
										<td rowspan="1" colspan="1" align="center">No.</td>
										<td rowspan="1" colspan="1" align="center">Amount</td>

										<!-- <th rowspan="1" colspan="1" align="center">No.</th>
				       <th rowspan="1" colspan="1" align="center">Amount</th>  -->
										<td rowspan="1" colspan="1" align="center">No.</td>
										<td rowspan="1" colspan="1" align="center">Amount</td>
										<td rowspan="1" colspan="1" align="center">No.</td>
										<td rowspan="1" colspan="1" align="center">Amount</td>
										<td rowspan="1" colspan="1" align="center">No.</td>
										<td rowspan="1" colspan="1" align="center">Amount</td>
									</tr>

									<tr id="tr1_hidden">
										<td class="text-center">
											<%
											String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                            String CRR = (String) request.getAttribute("CRR");
										    %> <input type="hidden" id="HDTokenNo" name="HDTokenNo"
											value="<%=TokenNo%>" /> <input type="hidden" id="CRR"
											name="CRR" value="<%=CRR%>" /> <input type="hidden"
											id="MM_YYYY" name="MM_YYYY" value="<%=MM_YYYY%>" /> <input
											name="btn_submit" type="submit" value="${ViewBag_button}"
											id="btn_submit" class="btn btn-success" /> <input
											type="hidden" name="COMMODITY_CODE" />
										</td>
										<%--  <td id="td_FORUM_CODE">

                                            <form:input path="FORUM_CODE" type="text" style="display:none;" name="FORUM_CODE" id="FORUM_CODE" class="form-control min-width-1" value="" />
                                        </td> --%>

										<td>
											<!-- <input name="ddlForumdata" type="hidden" class="form-control min-width-3" /> -->

											<%-- <select  path="REFUND_CATEGORY" id="REFUND_CATEGORY" name="REFUND_CATEGORY" 
                                           required="true" onchange ="GetValue(this);">
                                                <option value="-1">--Select--</option>
                                                <c:forEach var="var" items="${ViewBag_refundList}">
													<option value="${var.refund_category_id}">${var.refund_Category_name}</option>			           
                                                </c:forEach>
                                        	</select>  --%> <form:input
												path="SR_NO" style="display:none;" name="SR_NO" id="SR_NO"
												class="form-control min-width-1" value="" type="hidden" /> <form:input
												path="REFUND_CATEGORY_NAME" type="text"
												name="REFUND_CATEGORY_NAME" id="REFUND_CATEGORY_NAME"
												readonly="true" class="form-control min-width-1" value="" />


											<form:input path="REFUND_CATEGORY" style="display:none;"
												name="REFUND_CATEGORY" id="REFUND_CATEGORY"
												class="form-control min-width-1" value="" type="hidden" /> <!-- Developer use accordinly -->
											<!-- @Html.DropDownList("ddlForum", new SelectList(ViewBag.Forum, "FORUM_CODE", "FORUM"), new { onchange = "javascript: GetValue('this.options[this.selectedIndex].value');", @class = "form-control min-width-1" }) -->

											<!-- <label id="lblForum"></label> -->

										</td>
										<td><form:input path="OPENING_BALANCE_NO" type="text"
												name="OPENING_BALANCE_NO" id="OPENING_BALANCE_NO"
												class="form-control min-width-1" value="" readonly="true"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="OPENING_BALANCE_AMOUNT" type="text"
												readonly="true" name="OPENING_BALANCE_AMOUNT"
												id="OPENING_BALANCE_AMOUNT" class="form-control min-width-1"
												value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_01_NO" type="text"
												readonly="true" name="RFD_01_NO" id="RFD_01_NO"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_01_AMOUNT" type="text"
												readonly="true" name="RFD_01_AMOUNT" id="RFD_01_AMOUNT"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_02_NO" type="text"
												readonly="true" name="RFD_02_NO" id="RFD_02_NO"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_03_NO" type="text"
												readonly="true" name="RFD_03_NO" id="RFD_03_NO"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_03_AMOUNT" type="text"
												readonly="true" name="RFD_03_AMOUNT" id="RFD_03_AMOUNT"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_04_NO" type="text"
												readonly="true" name="RFD_04_NO" id="RFD_04_NO"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_04_AMOUNT" type="text"
												readonly="true" name="RFD_04_AMOUNT" id="RFD_04_AMOUNT"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_06_SANCTIONED_NO" type="text"
												readonly="true" name="RFD_06_SANCTIONED_NO"
												id="RFD_06_SANCTIONED_NO" class="form-control min-width-1"
												value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_06_SANCTIONED_AMOUNT"
												type="text" readonly="true" name="RFD_06_SANCTIONED_AMOUNT"
												id="RFD_06_SANCTIONED_AMOUNT"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_06_REJECTED_NO" type="text"
												readonly="true" name="RFD_06_REJECTED_NO"
												id="RFD_06_REJECTED_NO" class="form-control min-width-1"
												value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="RFD_06_REJECTED_AMOUNT" type="text"
												readonly="true" name="RFD_06_REJECTED_AMOUNT"
												id="RFD_06_REJECTED_AMOUNT" class="form-control min-width-1"
												value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="AGE_BREAKUP_30_45_NO" type="text"
												readonly="true" name="AGE_BREAKUP_30_45_NO"
												id="AGE_BREAKUP_30_45_NO" class="form-control min-width-1"
												value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="AGE_BREAKUP_30_45_AMOUNT"
												type="text" readonly="true" name="AGE_BREAKUP_30_45_AMOUNT"
												id="AGE_BREAKUP_30_45_AMOUNT"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="AGE_BREAKUP_46_60_NO" type="text"
												readonly="true" name="AGE_BREAKUP_46_60_NO"
												id="AGE_BREAKUP_46_60_NO" class="form-control min-width-1"
												value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="AGE_BREAKUP_46_60_AMOUNT"
												type="text" readonly="true" name="AGE_BREAKUP_46_60_AMOUNT"
												id="AGE_BREAKUP_46_60_AMOUNT"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="AGE_BREAKUP_ABOVE60_NO" type="text"
												readonly="true" name="AGE_BREAKUP_ABOVE60_NO"
												id="AGE_BREAKUP_ABOVE60_NO" class="form-control min-width-1"
												value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
										<td><form:input path="AGE_BREAKUP_ABOVE60_AMOUNT"
												type="text" readonly="true"
												name="AGE_BREAKUP_ABOVE60_AMOUNT"
												id="AGE_BREAKUP_ABOVE60_AMOUNT"
												class="form-control min-width-1" value=""
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /></td>
									</tr>
									<% int i=0; %>
									<c:forEach items="${model}" var="r">

										<tr id="td_no" class="table-datarow-right" >
											<td class="table-datarow-center">
												<%-- <a class="btn btn-info" 
                                                href="javascript:GetReport('${r.COMM_CODE}','${r.MM_YYYY}','${r.SR_NO}','${r.REFUND_CATEGORY}','${r.REFUND_CATEGORY_NAME}','${r.OPENING_BALANCE_NO}','${r.OPENING_BALANCE_AMOUNT}','${r.RFD_01_NO}','${r.RFD_01_AMOUNT}','${r.RFD_02_NO}','${r.RFD_03_NO}','${r.RFD_03_AMOUNT}','${r.RFD_04_NO}','${r.RFD_04_AMOUNT}','${r.RFD_06_SANCTIONED_NO}','${r.RFD_06_SANCTIONED_AMOUNT}','${r.RFD_06_REJECTED_NO}','${r.RFD_06_REJECTED_AMOUNT}','${r.AGE_BREAKUP_30_45_NO}','${r.AGE_BREAKUP_30_45_AMOUNT}','${r.AGE_BREAKUP_46_60_NO}','${r.AGE_BREAKUP_46_60_AMOUNT}','${r.AGE_BREAKUP_ABOVE60_NO}','${r.AGE_BREAKUP_ABOVE60_AMOUNT}');">Edit</a> --%>
												<a class="btn btn-info"  style="width: 65px;padding: 3px 9px; height: 27px; margin-top: 5px;" Title="This report is not editable" disabled>Edit</a>
											</td>
											<td class="table-datarow-center"><%= i+1 %></td>
											<th>${r.REFUND_CATEGORY_NAME}</th>
											<td>${r.OPENING_BALANCE_NO}</td>
											<td>${r.OPENING_BALANCE_AMOUNT}</td>
											<td>${r.RFD_01_NO}</td>
											<td>${r.RFD_01_AMOUNT}</td>
											<td>${r.RFD_02_NO}</td>
											<td>${r.RFD_03_NO}</td>
											<td>${r.RFD_03_AMOUNT}</td>
											<td>${r.RFD_04_NO}</td>
											<td>${r.RFD_04_AMOUNT}</td>
											<td>${r.RFD_06_SANCTIONED_NO}</td>
											<td>${r.RFD_06_SANCTIONED_AMOUNT}</td>
											<td>${r.RFD_06_REJECTED_NO}</td>
											<td>${r.RFD_06_REJECTED_AMOUNT}</td>
											<td>${r.AGE_BREAKUP_30_45_NO}</td>
											<td>${r.AGE_BREAKUP_30_45_AMOUNT}</td>
											<td>${r.AGE_BREAKUP_46_60_NO}</td>
											<td>${r.AGE_BREAKUP_46_60_AMOUNT}</td>
											<td>${r.AGE_BREAKUP_ABOVE60_NO}</td>
											<td>${r.AGE_BREAKUP_ABOVE60_AMOUNT}</td>
										</tr>
										<% i=i+1; %>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
                   <p><span style="color:red;"> *</span> Where refund is partly sanctioned and partly rejected, then amount will be shown as per order but the no. will be figured in column where highest amount is involved</p>
					<div align="center">
						<input type="hidden" name="hndresult" id="hndresult"
							value="${ViewBagMessage}" /> <input id="anchnext_month"
							type="button" class="btn btn-success" onclick="GetNext();"
							value="Next Month" /> <input type="hidden" name="hndmonth"
							id="hndmonth" value="<%=desDt1%>" /> <input name="btn_Abort"
							id="btn_Abort" class="btn btn-danger" type="submit"
							onclick="Abort_Correction('DPM-RFD-1')" value="Abort" />

					</div>
				</div>
			</div>
		</div>


	</form:form>
	</div>
</div>

<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-2.1.0.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-1.8.2.min.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/Abort.js"></script>


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
        if ($("#hndresult").val() == "CORRECTION REQUEST SUBMITTED") {
            $("#btn_Abort").hide();
        }
    });
</script>

<script type="text/javascript">

    $(document).ready(function () {

        $("#dlaGst1CommTemp").validate({

            rules: {

                txtReceiptNo: "required",
                txtReceiptAmt: "required",
                txtDisposalNo: "required",
                txtDisposalAmt: "required",
                BREAKUP_FAVOUR_NO: "required",
                BREAKUP_FAVOUR_AMT: "required",
                BREAKUP_AGAINST_NO: "required",
                BREAKUP_AGAINST_AMT: "required",
                BREAKUP_ALLOWED_NO: "required",
                BREAKUP_ALLOWED_AMT: "required",
                BREAKUP_REMANDED_NO: "required",
                BREAKUP_REMANDED_AMT: "required",

                //BREAKUP_TRANSFERRED_NO: "required",
                //BREAKUP_TRANSFERRED_AMT: "required",
                AGEWISE_1: "required",
                AGEWISE_1TO3: "required",
                AGEWISE_3TO5: "required",
                AGEWISE_5TO10: "required",
                AGEWISE_MORE10: "required",
                txtVALUATION: "required",
                txtCLASSIFICATION: "required",
                txtRULE: "required",
                txtOTHER: "required",


            },
            messages: {

                txtReceiptNo: "* Required",
                txtReceiptAmt: "* Required",
                txtDisposalNo: "* Required",
                txtDisposalAmt: "* Required",
                BREAKUP_FAVOUR_NO: "* Required",
                BREAKUP_FAVOUR_AMT: "* Required",
                BREAKUP_AGAINST_NO: "* Required",
                BREAKUP_AGAINST_AMT: "* Required",
                BREAKUP_ALLOWED_NO: "* Required",
                BREAKUP_ALLOWED_AMT: "* Required",
                BREAKUP_REMANDED_NO: "* Required",
                BREAKUP_REMANDED_AMT: "* Required",
                //BREAKUP_TRANSFERRED_NO: "* Required",
                //BREAKUP_TRANSFERRED_AMT: "* Required",
                AGEWISE_1: "* Required",
                AGEWISE_1TO3: "* Required",
                AGEWISE_3TO5: "* Required",
                AGEWISE_5TO10: "* Required",
                AGEWISE_MORE10: "* Required",
                txtVALUATION: "* Required",
                txtCLASSIFICATION: "* Required",
                txtRULE: "* Required",
                txtOTHER: "* Required"

            }
        });
        return false;
    });

    function ValidateInt(integer) {
        var expr = /^[0-9]{1,18}$/;
        return expr.test(integer);
    };
    function ValidateNumeric(numeric) {
        var expr = /^[0-9]\d{0,9}(\.\d{0,2})?%?$/;
        return expr.test(numeric);
    };

    $("#txtReceiptNo").live("change", function () {
        if (!ValidateInt($("#txtReceiptNo").val()) && ($("#txtReceiptNo").val() != "")) {
            $("#lblReceiptNo").text("Must be integer");
        }
        else {
            $("#lblReceiptNo").text("");
        }
    });

    $("#txtReceiptAmt").live("change", function () {
        if (!ValidateNumeric($("#txtReceiptAmt").val()) && ($("#txtReceiptAmt").val() != "")) {
            $("#lblReceiptAmt").text("Must be numeric");
            return false;
        }
        else {
            $("#lblReceiptAmt").text("");
        }
    });

    $("#txtDisposalNo").live("change", function () {
        if (!ValidateInt($("#txtDisposalNo").val()) && ($("#txtDisposalNo").val() != "")) {
            $("#lblDisposalNo").text("Must be integer");
        }
        else {
            $("#lblDisposalNo").text("");
        }
    });

    $("#txtDisposalAmt").live("change", function () {
        if (!ValidateNumeric($("#txtDisposalAmt").val()) && ($("#txtDisposalAmt").val() != "")) {
            $("#lblDisposalAmt").text("Must be numeric");
        }
        else {
            $("#lblDisposalAmt").text("");
        }
    });

    $("#BREAKUP_FAVOUR_NO").live("change", function () {
        if (!ValidateInt($("#BREAKUP_FAVOUR_NO").val()) && ($("#BREAKUP_FAVOUR_NO").val() != "")) {
            $("#lblBREAKUP_FAVOUR_NO").text("Must be integer");
        }
        else {
            $("#lblBREAKUP_FAVOUR_NO").text("");
        }
    });

    $("#BREAKUP_FAVOUR_AMT").live("change", function () {
        if (!ValidateNumeric($("#BREAKUP_FAVOUR_AMT").val()) && ($("#BREAKUP_FAVOUR_AMT").val() != "")) {
            $("#lblBREAKUP_FAVOUR_AMT").text("Must be numeric");
        }
        else {
            $("#lblBREAKUP_FAVOUR_AMT").text("");
        }
    });

    $("#BREAKUP_AGAINST_NO").live("change", function () {
        if (!ValidateInt($("#BREAKUP_AGAINST_NO").val()) && ($("#BREAKUP_AGAINST_NO").val() != "")) {
            $("#lblBREAKUP_AGAINST_NO").text("Must be integer");
        }
        else {
            $("#lblBREAKUP_AGAINST_NO").text("");
        }
    });

    $("#BREAKUP_AGAINST_AMT").live("change", function () {
        if (!ValidateNumeric($("#BREAKUP_AGAINST_AMT").val()) && ($("#BREAKUP_AGAINST_AMT").val() != "")) {
            $("#lblBREAKUP_AGAINST_AMT").text("Must be numeric");
        }
        else {
            $("#lblBREAKUP_AGAINST_AMT").text("");
        }
    });


    $("#BREAKUP_ALLOWED_NO").live("change", function () {
        if (!ValidateInt($("#BREAKUP_ALLOWED_NO").val()) && ($("#BREAKUP_ALLOWED_NO").val() != "")) {
            $("#lblBREAKUP_ALLOWED_NO").text("Must be integer");
        }
        else {
            $("#lblBREAKUP_ALLOWED_NO").text("");
        }
    });


    $("#BREAKUP_ALLOWED_AMT").live("change", function () {
        if (!ValidateNumeric($("#BREAKUP_ALLOWED_AMT").val()) && ($("#BREAKUP_ALLOWED_AMT").val() != "")) {
            $("#lblBREAKUP_ALLOWED_AMT").text("Must be numeric");

        }
        else {
            $("#lblBREAKUP_ALLOWED_AMT").text("");
        }
    });


    $("#BREAKUP_REMANDED_NO").live("change", function () {
        if (!ValidateInt($("#BREAKUP_REMANDED_NO").val()) && ($("#BREAKUP_REMANDED_NO").val() != "")) {
            $("#lblBREAKUP_REMANDED_NO").text("Must be integer");
        }
        else {
            $("#lblBREAKUP_REMANDED_NO").text("");
        }
    });


    $("#BREAKUP_REMANDED_AMT").live("change", function () {
        if (!ValidateNumeric($("#BREAKUP_REMANDED_AMT").val()) && ($("#BREAKUP_REMANDED_AMT").val() != "")) {
            $("#lblBREAKUP_REMANDED_AMT").text("Must be numeric");
        }
        else {
            $("#lblBREAKUP_REMANDED_AMT").text("");
        }
    });

    $("#AGEWISE_1").live("change", function () {
        if (!ValidateInt($("#AGEWISE_1").val()) && ($("#AGEWISE_1").val() != "")) {
            $("#lblAGEWISE_1").text("Must be integer");
        }
        else {
            $("#lblAGEWISE_1").text("");
        }
    });


    $("#AGEWISE_1TO3").live("change", function () {
        if (!ValidateInt($("#AGEWISE_1TO3").val()) && ($("#AGEWISE_1TO3").val() != "")) {
            $("#lblAGEWISE_1TO3").text("Must be integer");
        }
        else {
            $("#lblAGEWISE_1TO3").text("");
        }
    });


    $("#AGEWISE_3TO5").live("change", function () {
        if (!ValidateInt($("#AGEWISE_3TO5").val()) && ($("#AGEWISE_3TO5").val() != "")) {
            $("#lblAGEWISE_3TO5").text("Must be integer");
        }
        else {
            $("#lblAGEWISE_3TO5").text("");
        }
    });

    $("#AGEWISE_5TO10").live("change", function () {
        if (!ValidateInt($("#AGEWISE_5TO10").val()) && ($("#AGEWISE_5TO10").val() != "")) {
            $("#lblAGEWISE_5TO10").text("Must be integer");
        }
        else {
            $("#lblAGEWISE_5TO10").text("");
        }
    });


    $("#AGEWISE_MORE10").live("change", function () {
        if (!ValidateInt($("#AGEWISE_MORE10").val()) && ($("#AGEWISE_MORE10").val() != "")) {
            $("#lblAGEWISE_MORE10").text("Must be integer");
        }
        else {
            $("#lblAGEWISE_MORE10").text("");
        }
    });


    $("#txtVALUATION").live("change", function () {
        if (!ValidateInt($("#txtVALUATION").val()) && ($("#txtVALUATION").val() != "")) {
            $("#lblVALUATION").text("Must be integer");
        }
        else {
            $("#lblVALUATION").text("");
        }
    });

    $("#txtCLASSIFICATION").live("change", function () {
        if (!ValidateInt($("#txtCLASSIFICATION").val()) && ($("#txtCLASSIFICATION").val() != "")) {
            $("#lblCLASSIFICATION").text("Must be integer");
        }
        else {
            $("#lblCLASSIFICATION").text("");
        }
    });


    $("#txtRULE").live("change", function () {
        if (!ValidateInt($("#txtRULE").val()) && ($("#txtRULE").val() != "")) {
            $("#lblRULE").text("Must be integer");
        }
        else {
            $("#lblRULE").text("");
        }
    });


    $("#txtOTHER").live("change", function () {
        if (!ValidateInt($("#txtOTHER").val()) && ($("#txtOTHER").val() != "")) {
            $("#lblOTHER").text("Must be integer");
        }
        else {
            $("#lblOTHER").text("");
        }
    });
</script>

<script>
    function GetReport(COMM_CODE, MM_YYYY,SR_NO,REFUND_CATEGORY,REFUND_CATEGORY_NAME,OPENING_BALANCE_NO, OPENING_BALANCE_AMOUNT, RFD_01_NO, RFD_01_AMOUNT, RFD_02_NO, RFD_03_NO,
    		RFD_03_AMOUNT, RFD_04_NO, RFD_04_AMOUNT, RFD_06_SANCTIONED_NO, RFD_06_SANCTIONED_AMOUNT,
    		RFD_06_REJECTED_NO, RFD_06_REJECTED_AMOUNT, AGE_BREAKUP_30_45_NO, AGE_BREAKUP_30_45_AMOUNT, AGE_BREAKUP_46_60_NO, AGE_BREAKUP_46_60_AMOUNT,
    		AGE_BREAKUP_ABOVE60_NO, AGE_BREAKUP_ABOVE60_AMOUNT) {
        $('#tr1_hidden').show();
        
        /* $('#lblForum').html(FORUM);
        $('#ddlForum').hide();
        $('input[name="ddlForumdata"]').val(FORUM_CODE);
        $('input[name="ddlForum"]').text; */

        $('input[name="SR_NO"]').val(SR_NO);
        $('input[name="btn_submit"]').val('Update');
        
        $('input[name="REFUND_CATEGORY"]').val(REFUND_CATEGORY);
        $('input[name="REFUND_CATEGORY_NAME"]').val(REFUND_CATEGORY_NAME);
        $('input[name="OPENING_BALANCE_NO"]').val(OPENING_BALANCE_NO);
        $('input[name="OPENING_BALANCE_AMOUNT"]').val(OPENING_BALANCE_AMOUNT);
        
        $('input[name="RFD_01_NO"]').val(RFD_01_NO);        
        $('input[name="RFD_01_AMOUNT"]').val(RFD_01_AMOUNT);        
        $('input[name="RFD_02_NO"]').val(RFD_02_NO);
        $('input[name="RFD_03_NO"]').val(RFD_03_NO);        
        $('input[name="RFD_03_AMOUNT"]').val(RFD_03_AMOUNT);        
        $('input[name="RFD_04_NO"]').val(RFD_04_NO);        
        $('input[name="RFD_04_AMOUNT"]').val(RFD_04_AMOUNT);
        
        $('input[name="RFD_06_SANCTIONED_NO"]').val(RFD_06_SANCTIONED_NO);
        $('input[name="RFD_06_SANCTIONED_AMOUNT"]').val(RFD_06_SANCTIONED_AMOUNT);
        
        $('input[name="RFD_06_REJECTED_NO"]').val(RFD_06_REJECTED_NO);
        
        $('input[name="RFD_06_REJECTED_AMOUNT"]').val(RFD_06_REJECTED_AMOUNT);
        
        $('input[name="AGE_BREAKUP_30_45_NO"]').val(AGE_BREAKUP_30_45_NO);
        
        $('input[name="AGE_BREAKUP_30_45_AMOUNT"]').val(AGE_BREAKUP_30_45_AMOUNT);
        
        $('input[name="AGE_BREAKUP_46_60_NO"]').val(AGE_BREAKUP_46_60_NO);
        
        $('input[name="AGE_BREAKUP_46_60_AMOUNT"]').val(AGE_BREAKUP_46_60_AMOUNT);
        
        $('input[name="AGE_BREAKUP_ABOVE60_NO"]').val(AGE_BREAKUP_ABOVE60_NO);
        $('input[name="AGE_BREAKUP_ABOVE60_AMOUNT"]').val(AGE_BREAKUP_ABOVE60_AMOUNT);
    }


  
</script>

<script>

function GetValue(VAL) {
	 var forumcd = document.getElementById("ddlForum"); 
	 //alert(forumcd.value);        
	 var tempUrl = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTDPM/Insert/DPM_GST_16";
	 var mm_yyyy = "<%= strDate%>";
    //forumcd.value = VAL.value;
   $.post(tempUrl, { Forum: forumcd.value, MM_YYYY :mm_yyyy }, function (data) {
   	var openBal = JSON.parse(data.ViewBag_opening_no);
   	var openAmt = JSON.parse(data.ViewBag_opening_amt);
       document.getElementById("OPENING_NO").value = openBal;
       document.getElementById("OPENING_AMT").value = openAmt;
   });

}


</script>


<script type="text/javascript">

    $(document).ready(function () {

       /*  PRI-------------var urlc = window.location.href.slice(window.location.href.indexOf('&') + 1);
        var urlcrr = urlc.slice(urlc.indexOf('=') + 1);
        if (location.href.indexOf('?') == -1) {
            $('#tr1_hidden').show();

        }
        else {
            if (urlcrr == "T" || urlcrr == "T&ID=1") {
                $('#tr1_hidden').hide();

            }
        } */

    });

</script>

<script type="text/javascript">


    function GetNext() {
        var mm = $('#hndmonth').val();

        var MyRows = $('tr#td_no');

        var s_court = 0;
        var h_court = 0;
        var c_court = 0;
        var se_court = 0;
        var co_court = 0;

        for (var i = 0; i < MyRows.length; i++) {
        	var OPENING_NO = parseInt($(MyRows[i]).find('td:eq(3)').html());
            var RECEIPTS_NO = parseInt($(MyRows[i]).find('td:eq(5)').html());
            var DISPOSAL_NO = parseInt($(MyRows[i]).find('td:eq(9)').html());
            var AGEWISE_1 = parseInt($(MyRows[i]).find('td:eq(27)').html());
            var AGEWISE_1TO3 = parseInt($(MyRows[i]).find('td:eq(28)').html());
            var AGEWISE_3TO5 = parseInt($(MyRows[i]).find('td:eq(29)').html());
            var AGEWISE_5TO10 = parseInt($(MyRows[i]).find('td:eq(30)').html());
            var AGEWISE_MORE10 = parseInt($(MyRows[i]).find('td:eq(31)').html());

            var main_value = (OPENING_NO + RECEIPTS_NO) - (DISPOSAL_NO);
            var age_wise = AGEWISE_1 + AGEWISE_1TO3 + AGEWISE_3TO5 + AGEWISE_5TO10 + AGEWISE_MORE10;

            if (main_value == age_wise) {

                if (i == 0) {
                    s_court++;
                }
                else if (i == 1) {
                    h_court++;
                }
                else if (i == 2) {
                    c_court++;
                }
                else if (i == 3) {
                    se_court++;
                }
                else if (i == 4) {
                    co_court++;
                }

            }
            else {

                if ($("#hndresult").val() == "CORRECTION REQUEST SUBMITTED") {
                    $('#lbl_message').hide();
                }
                else {
                    $('#lbl_message').show();
                }

                if (i == 0) {
                    alert("SUPREME COURT Court CLOSING AND SUM OF AGE-WISE BREAK UP MIS MATCH...");

                }
                else if (i == 1) {
                    alert("HIGH COURT CLOSING AND SUM OF AGE-WISE BREAK UP MIS MATCH...");
                }
                else if (i == 2) {
                    alert("CESTAT CLOSING AND SUM OF AGE-WISE BREAK UP MIS MATCH...");
                }
                else if (i == 3) {
                    alert("SETTLEMENT COMMISSION CLOSING AND SUM OF AGE-WISE BREAK UP MIS MATCH...");
                }
                else if (i == 4) {
                    alert("COMMISSIONE (APPEALS) CLOSING AND SUM OF AGE-WISE BREAK UP MIS MATCH...");
                }

            }

        }

        if ((s_court == 1) && (h_court == 1) && (c_court == 1) && (se_court == 1) && (co_court == 1)) {
            if ($("#hndresult").val() != "CORRECTION REQUEST SUBMITTED") {
                var url = "DLA_GST_1/sbdfuf9?MM_YYYY=" + mm + "&CRR=T&ID=1";
                window.location = url;
            }
        }
        else {
            //alert("same");
        }


    }

</script>

<script type="text/javascript">
  /*  $(document).ready(function () {

        $('#TransferCommList').multiselect({
            onChange: function (option, checked, select) {
                var opselected = $(option).val();
                if (checked == true) {
                    DynamicTransferCase();
                }
                else if (checked == false) {
                    DynamicTransferCase();
                }

            }
        });
    });

    function DynamicTransferCase() {
        var selectedTest = $("#TransferCommList option:selected");
        $('#DIV_comm_name').html(null);
        $('#DIV_trans_no').html(null);
        $('#DIV_trans_amt').html(null);
        $('#DIV_trans_agewise').html(null);

        selectedTest.each(function (index) {
            $('#DIV_comm_name').append('<input  id="TransferCaseModelList_' + index + '__COMM_NAME" name="TransferCaseModelList[' + index + '].COMM_NAME" type="text" value=' + $(this).text() + ' class="form-control min-width-3 input_border_none"> <input type="hidden" id="TransferCaseModelList_' + index + '__COMM_CODE" name="TransferCaseModelList[' + index + '].COMM_CODE" value=' + $(this).val() + ' />  </br>');
            $('#DIV_trans_no').append('<input onchange="CalTransfeNo();" id="TransferCaseModelList_' + index + '__CASE_NO" name="TransferCaseModelList[' + index + '].CASE_NO" type="text" class="form-control min-width-3 caltrans_no" placeholder="NO"></br>');

            $('#DIV_trans_amt').append('<input onchange="CalTransfeAmt();" id="TransferCaseModelList_' + index + '__CASE_AMOUNT" name="TransferCaseModelList[' + index + '].CASE_AMOUNT" type="text" class="form-control min-width-3 caltrans_amt" placeholder="AMT"></br>');

            $('#DIV_trans_agewise').append('<select id="TransferCaseModelList_' + index + '__AGE_WISE_BREAKUP" name="TransferCaseModelList[' + index + '].AGE_WISE_BREAKUP" class="form-control min-width-3"><option value="0">CASES LESS THAN 1YR</option><option value="1">CASES FROM 1-3 YRS</option><option value="3">CASES FROM 3-5 YRS</option><option value="5">CASES FROM 5-10 YRS</option><option value="10">CASES GREATER THAN 10YRS</option></select></br>');

        });
    }

    function CalTransfeNo() {
        var TotalTransferNo = calculateItemQty('caltrans_no');
        $('#txtDisposalNo_Transferred').val(parseInt(TotalTransferNo));
    }

    function CalTransfeAmt() {
        var TotalTransferNo = calculateItemQty('caltrans_amt');
        $('#txtDisposalAmt_Transferred').val(parseFloat(TotalTransferNo));
    }


    function calculateItemQty(cls) {
        var sum = 0;
        $('.' + cls).each(function () {
            //add only if the value is number
            if (!isNaN(this.value) && this.value.length != 0) {
                sum += parseFloat(this.value);
            }
        });
        return sum;
    };
*/
</script>



<script>



$('#TransferCaseModelList').change(function(){
	//alert("ONChange");
	
    DynamicTransferCase($('#TransferCaseModelList :selected').text());
  
	          
  });
<%-- BindTranferData1("<%=code%>","<%=MM_YYYY%>"); --%>

function DynamicTransferCase(values) {
    
    $('#DIV_comm_name').html(null);
    $('#DIV_trans_no').html(null);
    $('#DIV_trans_amt').html(null);
    $('#DIV_trans_agewise').html(null);

    
        $('#DIV_comm_name').append('<input  id="TransferCaseModelList_' + 0 + '_COMM_NAME" name="TransferCaseModelList_' + 0 + '_COMM_NAME" type="text" value=' + values + ' class="form-control min-width-3 input_border_none"> <input type="hidden" id="TransferCaseModelList_' + 0 + '_COMM_CODE" name="TransferCaseModelList_' + 0 + '_COMM_CODE" value=' + values + ' />  </br>');
        $('#DIV_trans_no').append('<input onchange="CalTransfeNo();" id="TransferCaseModelList_' + 0 + '_CASE_NO" name="TransferCaseModelList_' + 0 + '_CASE_NO" type="text" class="form-control min-width-3 caltrans_no" placeholder="NO"></br>');
        $('#DIV_trans_amt').append('<input onchange="CalTransfeAmt();" id="TransferCaseModelList_' + 0 + '_CASE_AMOUNT" name="TransferCaseModelList_' + 0 + '_CASE_AMOUNT" type="text" class="form-control min-width-3 caltrans_amt" placeholder="AMT"></br>');
        $('#DIV_trans_agewise').append('<select id="AGE_WISE_BREAKUP" name="AGE_WISE_BREAKUP" class="form-control min-width-3"><option value="0">CASES LESS THAN 1YR</option><option value="1">CASES FROM 1-3 YRS</option><option value="3">CASES FROM 3-5 YRS</option><option value="5">CASES FROM 5-10 YRS</option><option value="10">CASES GREATER THAN 10YRS</option></select></br>');

    
}

 function CalTransfeNo() {
	 
     var TotalTransferNo = calculateItemQty('caltrans_no');
     $('#DISPOSAL_TRANSFER_NO').val(parseInt(TotalTransferNo));
 }

 function CalTransfeAmt() {
	 
     var TotalTransferNo = calculateItemQty('caltrans_amt');
     $('#DISPOSAL_TRANSFER_AMT').val(parseFloat(TotalTransferNo));
 }


 function calculateItemQty(cls) {
	 
     var sum = 0;
     $('.' + cls).each(function () {
             if (!isNaN(this.value) && this.value.length != 0) {
             sum += parseFloat(this.value);
         }
     });
     return sum;
 }


 

 function BindTranferData1(code,dates)
 {
	

     $('#DIV_comm_name').html(null);
     $('#DIV_trans_no').html(null);
     $('#DIV_trans_agewise').html(null);
     
     var index = 0;
     var SelCODE = [];
     
     $.get('/GSTDLA/Insert/GetTransferDataByCOMM_GST_1', { COMM_CODE: code, mm_yyyy: dates }, function (data) {
    	   //alert("  data 1  "+data);
             var data = JSON.parse(data.COMMODITY);
            //alert("  data 2 "+data);
           
             for (var it in data) {
                 $('#DIV_comm_name').append('<input  id="TransferCaseModelList_' + index + '_COMM_NAME" name="TransferCaseModelList_' + index + '_COMM_NAME" type="text" value=' + data[it].CODE_NAME + ' class="form-control min-width-3 input_border_none"> <input type="hidden" id="TransferCaseModelList_' + index + '_COMM_CODE" name="TransferCaseModelList_' + index + '_COMM_CODE" value=' + data[it].CODE + ' />  </br>');
                 $('#DIV_trans_no').append('<input onchange="CalTransfeNo();" id="TransferCaseModelList_' + index + '_CASE_NO" name="TransferCaseModelList_' + index + '_CASE_NO" type="text" value=' + data[it].DISPOSAL_TRANSFER_NO + ' class="form-control min-width-3 caltrans_no" placeholder="NO"></br>');
                 $('#DIV_trans_amt').append('<input onchange="CalTransfeAmt();" id="TransferCaseModelList_' + index + '_CASE_AMOUNT" name="TransferCaseModelList_' + index + '_CASE_AMOUNT" type="text" value=' + data[it].DISPOSAL_TRANSFER_AMT + ' class="form-control min-width-3 caltrans_amt" placeholder="AMT"></br>');

                 if (data[it].AGEWISE_BREAKUP_TRANSFER == 0) {

                     $('#DIV_trans_agewise').append('<select id="AGE_WISE_BREAKUP" name="AGE_WISE_BREAKUP" class="form-control min-width-3"><option value="0" selected>CASES LESS THAN 1YR</option><option value="1" >CASES FROM 1-3 YRS</option><option value="3">CASES FROM 3-5 YRS</option><option value="5">CASES FROM 5-10 YRS</option><option value="10">CASES GREATER THAN 10YRS</option></select></br>');
                 }
                 else if (data[it].AGEWISE_BREAKUP_TRANSFER == 1) {
                     $('#DIV_trans_agewise').append('<select id="AGE_WISE_BREAKUP" name="AGE_WISE_BREAKUP" class="form-control min-width-3"><option value="0">CASES LESS THAN 1YR</option><option value="1" selected>CASES FROM 1-3 YRS</option><option value="3" >CASES FROM 3-5 YRS</option><option value="5">CASES FROM 5-10 YRS</option><option value="10">CASES GREATER THAN 10YRS</option></select></br>');
                 }
                 else if (data[it].AGEWISE_BREAKUP_TRANSFER == 3) {
                     $('#DIV_trans_agewise').append('<select id="AGE_WISE_BREAKUP" name="AGE_WISE_BREAKUP" class="form-control min-width-3"><option value="0">CASES LESS THAN 1YR</option><option value="1" >CASES FROM 1-3 YRS</option><option value="3" selected>CASES FROM 3-5 YRS</option><option value="5">CASES FROM 5-10 YRS</option><option value="10">CASES GREATER THAN 10YRS</option></select></br>');
                 }
                 else if (data[it].AGEWISE_BREAKUP_TRANSFER == 5) {
                     $('#DIV_trans_agewise').append('<select id="AGE_WISE_BREAKUP" name="AGE_WISE_BREAKUP" class="form-control min-width-3"><option value="0">CASES LESS THAN 1YR</option><option value="1" >CASES FROM 1-3 YRS</option><option value="3">CASES FROM 3-5 YRS</option><option value="5" selected>CASES FROM 5-10 YRS</option><option value="10">CASES GREATER THAN 10YRS</option></select></br>');
                 }
                 else if (data[it].AGEWISE_BREAKUP_TRANSFER == 10) {
                     $('#DIV_trans_agewise').append('<select id="AGE_WISE_BREAKUP" name="AGE_WISE_BREAKUP" class="form-control min-width-3"><option value="0">CASES LESS THAN 1YR</option><option value="1" >CASES FROM 1-3 YRS</option><option value="3">CASES FROM 3-5 YRS</option><option value="5">CASES FROM 5-10 YRS</option><option value="10" selected>CASES GREATER THAN 10YRS</option></select></br>');
                 }
                 else {
                     $('#DIV_trans_agewise').append('<select id="AGE_WISE_BREAKUP" name="AGE_WISE_BREAKUP" class="form-control min-width-3"><option value="0">CASES LESS THAN 1YR</option><option value="1">CASES FROM 1-3 YRS</option><option value="3">CASES FROM 3-5 YRS</option><option value="5">CASES FROM 5-10 YRS</option><option value="10">CASES GREATER THAN 10YRS</option></select></br>');
                 }

                 index++;
                 SelCODE.push(data[it].CODE);
             }

             $('#TransferCaseModelList').val(SelCODE);
             $("#TransferCaseModelList").change("refresh");
     });
	 
 }
 
</script>



