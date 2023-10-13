<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-6">
			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-book fa-fw"></i> DDM-GST-4A
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
		<form:form action="/MPR/GSTDDM/Insert/DDM_GST_4A" id="GstRev4CommTemp"
			name="GstRev4CommTemp" method="POST" modelAttribute="GstRev4CommTemp">
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
					<div class="panel-heading text-capitalize">
						REVENUE FROM TOP 20 SERVICES
					</div>
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

								<div class="sub-lakh">Amount in Rs.Crores</div>
							</div>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<tr class="text-center-capitalize table-header-center">
                                                     <td align="center" rowspan="2">
                                            Action
                                        </td>

                                        <td rowspan="2">
                                            S.NO.
                                        </td>
                                        <td  rowspan="2">
                                            SERVICE ACCOUNTING CODE
                                        </td>
                                        <td  rowspan="2">
                                            NAME OF THE SERVICES
                                        </td>
                                       <td  rowspan="1" colspan="2">
						                   CURRENT F.Y.
						               </td>
						               <td  rowspan="1"  colspan="2">
						                   PREVIOUS F.Y.                   
						               </td>
                                        <td  rowspan="2">
                                           Reason for Increase/Decrease in Revenue
                                        </td>
                                         </tr>
									<tr class="text-center-capitalize table-header-center">
								              <td rowspan="1" colspan="1" >
								                  FOR THE MONTH
								              </td>
								              <td rowspan="1" colspan="1" >
								                   UPTO THE MONTH
								              </td>
								              <td rowspan="1" colspan="1" >
								                   FOR THE MONTH
								              </td>
								              <td rowspan="1" >
								                   UPTO THE MONTH
								              </td>
								          
								           </tr>
									<tr class="textcenter" id="tr_hidden">
										<th class="text-center"
											style="width: 65px; padding: 3px 9px; height: 27px; margin-top: 5px;">
											<input name="btn_submit" class="btn btn-success"
											id="btn_submit" type="submit" value="Update" />
										</th>
										<td class="text-center" id="td_SNO"></td>
										<%String TokenNo = (String) request.getSession().getAttribute("TokenNo");%>
										<td> 
										<form:input path="SNO" type="hidden"
												name="SNO" id="SNO"
												placeholder="SNO NAME" class="form-control min-width-1"
												autocomplete="off" readonly="true" required="true" /> <form:errors
												path="SNO" cssClass="error" />
										<input
											type="hidden" id="HDTokenNo" name="HDTokenNo"
											value="<%=TokenNo%>" /> <input type="hidden" id="MM_YYYY"
											name="MM_YYYY" value="${MM_YYYY}" /> <input type="hidden"
											id="request_CSRF_Token" name="request_CSRF_Token"
											value="<%= session.getAttribute("CSRF_Token") %>">
											 <!-- <td  class="table-datarow-center" id="td_SERVICE_CODE" ></td>  -->
											<form:input
												path="SERVICE_CODE" type="text" name="SERVICE_CODE" id="SERVICE_CODE"
												placeholder="SERVICE CODE" class="form-control min-width-1"
												autocomplete="off" readonly="true" required="true" /> <form:errors
												path="SERVICE_CODE" cssClass="error" /></td> 
											<td><form:input path="SERVICE_NAME" type="text"
												name="SERVICE_NAME" id="SERVICE_NAME"
												placeholder="SERVICE NAME" class="form-control min-width-1"
												autocomplete="off" readonly="true" required="true" /> <form:errors
												path="SERVICE_NAME" cssClass="error" /></td>
										<td><form:input path="CUR_YEAR_FOR" type="text"
												name="CUR_YEAR_FOR" id="CUR_YEAR_FOR"
												placeholder="CUR YEAR FOR" class="form-control min-width-1"
												style="min-width: 80px !important;" readonly="true"
												autocomplete="off"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors path="CUR_YEAR_FOR"
												cssClass="error" /></td>
										<td><form:input path="CUR_YEAR_UPTO" type="text"
												name="CUR_YEAR_UPTO" id="CUR_YEAR_UPTO"
												placeholder="CUR YEAR UPTO" class="form-control min-width-1"
												style="min-width: 80px !important;" readonly="true"
												autocomplete="off"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors path="CUR_YEAR_UPTO"
												cssClass="error" /></td>
										<td><form:input path="PRE_YEAR_FOR" type="text"
												name="PRE_YEAR_FOR" id="PRE_YEAR_FOR"
												placeholder="PRE YEAR FOR" class="form-control min-width-1"
												style="min-width: 80px !important;" readonly="true"
												autocomplete="off"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors path="PRE_YEAR_FOR"
												cssClass="error" /></td>
										<td><form:input path="PRE_YEAR_UPTO" type="text"
												name="PRE_YEAR_UPTO" id="PRE_YEAR_UPTO"
												placeholder="PRE YEAR UPTO" class="form-control min-width-1"
												style="min-width: 80px !important;" readonly="true"
												autocomplete="off"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> <form:errors path="PRE_YEAR_UPTO"
												cssClass="error" /></td>
										<td><form:input path="REASONS" type="text" name="REASONS"
												id="REASONS" placeholder="REASON_FOR_INCREASE_REVENUE"
												class="form-control min-width-1-left" autocomplete="off"
												maxlength="100" required="true" /> 
												<form:errors
												id="reason_error" path="REASONS" cssClass="error" /> <label
											id="lbl_REASONS"></label></td>
									</tr>
									<% int i=0; %>
									<c:forEach items="${Model}" var="r">
										<tr class="table-datarow-right">
												<td class="table-datarow-center"><a class="btn btn-info" style="width: 65px; padding: 3px 9px; height: 27px; margin-top: 5px;"
												href="javascript: GetReport('<%= i+1 %>','${r.SNO}','${r.SERVICE_CODE}','${r.SERVICE_NAME}','${r.CUR_YEAR_FOR}','${r.CUR_YEAR_UPTO}','${r.PRE_YEAR_FOR}','${r.PRE_YEAR_UPTO}','${r.REASONS}');">Edit</a></td>			
												<td class="table-datarow-center"><%=++i%></td>
												<td class="table-datarow-center">${r.SERVICE_CODE}</td>
											<th>${r.SERVICE_NAME}</th>
											<td>${r.CUR_YEAR_FOR}</td>
											<td>${r.CUR_YEAR_UPTO}</td>
											<td>${r.PRE_YEAR_FOR}</td>
											<td>${r.PRE_YEAR_UPTO}</td>
											<th style="overflow-wrap: anywhere;"><c:if
													test="${r.REASONS != 'null' && r.REASONS != null}">
	                                					${r.REASONS}
	                               					</c:if></th>
											</tr>
									</c:forEach>
								</table>
							</div>
						</div>
						<div align="center">
							<input name="btn_error" class="btn btn-success" id="btn_error"
								type="hidden" value="${button}" /> <input type="hidden"
								name="hndresult" id="hndresult" value="${ViewBagResult}" />
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</div>
<script
	src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script
	src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>
<script src="../../../Content-Common/js/jquery.js"></script>

<script language="javascript" type="text/javascript">
		function GetReport(_index,SNO,SERVICE_CODE, SERVICE_NAME, CUR_YEAR_FOR,CUR_YEAR_UPTO,PRE_YEAR_FOR,PRE_YEAR_UPTO,REASONS) {
			$('#tr_hidden').show();
			$('#td_SNO').html(_index);
			$('input[name="SNO"]').val(SNO);
            //$('#td_SERVICE_CODE').html(SERVICE_CODE);
            $('input[name="SERVICE_CODE"]').val(SERVICE_CODE);
            
			$('input[name="SERVICE_NAME"]').val(SERVICE_NAME);
			$('input[name="CUR_YEAR_FOR"]').val(CUR_YEAR_FOR);
			$('input[name="CUR_YEAR_UPTO"]').val(CUR_YEAR_UPTO);
			$('input[name="PRE_YEAR_FOR"]').val(PRE_YEAR_FOR);
			$('input[name="PRE_YEAR_UPTO"]').val(PRE_YEAR_UPTO);
			$('input[name="REASONS"]').val(REASONS);
			$('input[name="btn_submit"]').val('Update');
			document.getElementById('reason_error').innerHTML='';
		}


	$(document).on("keypress", "input[type='text']", function(e) {
		document.getElementById('reason_error').innerHTML = '';
	});
</script>
<script type="text/javascript">

        $(document).ready(function () {
        	var button_name = $('#btn_error').val();
        	console.log(button_name)
            if (button_name == "Error") {
            	$('#tr_hidden').show();
            }
            else {
            	$('#tr_hidden').hide();
            }
        });
        $('#REASONS').bind('keypress', function (event) {
			// debugger;
			    var regex = new RegExp(/^[a-zA-Z0-9. ()/',-]+$/);
			    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
			            if (!regex.test(key)) {
			               event.preventDefault();
			               return true;
			            }
			    });

    </script>
   <!--  <script>

    $(document).ready(function () {
    	$('#tr_hidden').hide();
        var row_count = $('#table_count tr').length;
        var count = row_count - 3;

        if (count == 20) {
            var r = "Other than top 20";
            $('input[name="SERVICE_NAME"]').val(r);
        }
        else if (count == 21) {
            $('#tr_hidden').hide();
        }
        else {
            $('input[name="SERVICE_NAME"]').val();
        }

    });

</script> -->
<jsp:include page="../../GSTHome/Footer.jsp" />
