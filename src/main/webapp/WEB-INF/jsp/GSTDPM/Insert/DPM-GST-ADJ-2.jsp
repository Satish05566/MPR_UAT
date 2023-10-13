<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

    
    <div id="page-wrapper">
    <div class="row">
         <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i>GST-ADJ-2
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

    <form:form action="/GSTDPM/Insert/DPM_GST_ADJ_2" id="dpmGstAdj2CommTemp" 
    name = "dpmGstAdj2CommTemp" method="POST" modelAttribute="dpmGstAdj2CommTemp" > 
    
    <%--  <form:form action="/GSTDPM/Insert/DPM_GST_ADJ_2" id="DpmGstAdj2CommTemp" 
    name = "DpmGstAdj2CommTemp" method="POST" modelAttribute="DpmGstAdj2CommTemp" >  --%>
       <%--  <c:choose>
			<c:when test="${ViewBagMessage!=null || ViewBagMessage.length() ==0}"> 
				<div class="col-lg-12">
					<div class="alert-success" id="login_error">
						<span class="closebtn"                                
							onclick="this.parentElement.style.display='none';">&times;</span>
						${ViewBagMessage}
					</div>
				</div>
			</c:when>
		</c:choose> --%>
		
		<c:choose>
		       <c:when test= "${ViewBagMessage!=null || ViewBagMessage.length() ==0}"> 
		        <div class="col-lg-12">
		        <div class="alert-success" id=alert_success>
		            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
		            ${ViewBagMessage}
		        </div>
		     </div> 
		    </c:when>
		    
		    <c:when test= "${ViewBagMessage_error!=null || ViewBagMessage_error.length() ==0}"> 
		        <div class="col-lg-12">
		        <div class="alert" id="alert_error">
		            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
		            ${ViewBagMessage_error}
		        </div>
		     </div> 
		    </c:when>
		    
		    </c:choose>

        <div class="col-lg-12">
        <div class="panel panel-danger">
            <div class="panel-heading text-capitalize">
               Details of adjudication cases involving GST more than Rs. Five Crores																

            </div>

                <!-- /.panel-heading -->
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
                              MONTH : <%= desDt.toUpperCase() %>
                              <div class="sub-lakh">Amount: in Rs. Lakhs</div>
                        </div>
                       
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <tbody class="text-capitalize">
				   <tr class="text-center-capitalize table-header-center">
				       <td rowspan="2" colspan="2"   align="center">OPENING BALANCE</th>
				       <td rowspan="2" colspan="2" align="center">RECEIPT DURING THE MONTH</th>
				      <!--  <th rowspan="2" colspan="2" align="center">RECEIPT UPTO THE MONTH</th> -->
				       <td rowspan="1" colspan="4" align="center">DISPOSAL DURING THE MONTH*</th>
				      <!--  <th rowspan="2" colspan="2" align="center">TOTAL DISPOSAL</th> -->
				       <td rowspan="2" colspan="2" align="center">CLOSING BALANCE</th>
				       <td rowspan="2" colspan="3" align="center">AGE WISE BREAK UP OF PENDENCY</th>				       
				   </tr>
				   <tr class="text-center-capitalize table-header-center">
				    <td rowspan="1" colspan="2" align="center">DECIDED IN FAVOUR OF REVENUE</th>
				       <td rowspan="1" colspan="2" align="center">DECIDED IN FAVOUR OF TAX PAYER</th>
				   </tr>
				   <tr class="text-center-capitalize table-header-center">
				       <td  rowspan="1" colspan="1" align="center">No.</th>
				       <td  colspan="1" align="center">Amount</th>
				       <td  colspan="1" align="center">No.</th>
				       <td colspan="1" align="center">Amount</th>
				      <!--   <th  colspan="1" align="center">No.</th>
				       <th colspan="1" align="center">Amount</th> -->
				        <td rowspan="1" colspan="1" align="center">No.</th>
				       <td rowspan="1" colspan="1" align="center">Amount</th>
				       <td rowspan="1" colspan="1" align="center">No.</th>
				       <td rowspan="1" colspan="1" align="center">Amount</th>				       
				      <!--  <th rowspan="1" colspan="1" align="center">No.</th>
				       <th rowspan="1" colspan="1" align="center">Amount</th> -->
				       <td rowspan="1" colspan="1" align="center">No.</th>
				       <td rowspan="1" colspan="1" align="center">Amount</th>
				       <td rowspan="1" colspan="1" align="center">Up to 6 months</th>
				       <td rowspan="1" colspan="1" align="center">6 to 12 months</th>
				       <td rowspan="1" colspan="1" align="center">More than  1 year</th> 				       
				   </tr>				
				     
					<c:forEach items="${model}" var="model"> 
					 <tr>	
					 <td align="right">
					  <%
											String TokenNo = (String) request.getSession().getAttribute("TokenNo");
												String MM_YYYY = (String) request.getAttribute("MM_YYYY");
												String CRR = (String) request.getAttribute("CRR");
										%>
										<input type="hidden" id="HDTokenNo" name="HDTokenNo"
											value="<%=TokenNo%>" /> 
											<input type="hidden" id="MM_YYYY"
											name="MM_YYYY" value="${MM_YYYY}" /> <input type="hidden"
											id="CRR" name="CRR" value="${CRR}" /> <input type="hidden"
											id="request_CSRF_Token" name="request_CSRF_Token"
											value="<%=session.getAttribute("CSRF_Token")%>">
						<input type="text"  data-rule-required="true" 
                                       name="OPENING_NO" id="OPENING_NO"  value="${model.OPENING_NO}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57" 
						required = "required" readonly ="readonly" />
					 </td>
					 <td align="right">
						<input type="text"  data-rule-required="true" 
                                       name="OPENING_AMT" id="OPENING_AMT"  value="${model.OPENING_AMT}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "required" readonly ="readonly" />
					</td>
					<td align="right">
						<input type="text"  
                                       name="RECEIPT_NO" id="RECEIPT_NO"  value="${model.RECEIPT_NO}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "required"/>
						  <form:errors path="RECEIPT_NO" cssClass="error" />
					</td>
					<td align="right">
						<input type="text"  data-rule-required="true" 
                                       name="RECEIPT_AMT" id="RECEIPT_AMT"  value="${model.RECEIPT_AMT}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
						 required = "required"  />
						 <form:errors path="RECEIPT_AMT" cssClass="error" />
					</td>
					<td>
						<input type="text"  data-rule-required="true" 
                                       name="DISPOSAL_REVENUE_NO" id="DISPOSAL_REVENUE_NO"  value="${model.DISPOSAL_REVENUE_NO}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "required"  />
						<form:errors path="DISPOSAL_REVENUE_NO" cssClass="error" />
					</td>
					<td>
						<input type="text"  data-rule-required="true" 
                                       name="DISPOSAL_REVENUE_AMT" id="DISPOSAL_REVENUE_AMT"  value="${model.DISPOSAL_REVENUE_AMT}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "required"  />
						<form:errors path="DISPOSAL_REVENUE_AMT" cssClass="error" />
					</td>
					<td>
						<input type="text"  data-rule-required="true" 
                                       name="DISPOSAL_TAXPAYER_NO" id="DISPOSAL_TAXPAYER_NO"  value="${model.DISPOSAL_TAXPAYER_NO}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "required"  />
						<form:errors path="DISPOSAL_TAXPAYER_NO" cssClass="error" />
					</td>
					<td>
						<input type="text"  data-rule-required="true" 
                                       name="DISPOSAL_TAXPAYER_AMT" id="DISPOSAL_TAXPAYER_AMT"  value="${model.DISPOSAL_TAXPAYER_AMT}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "required"  />
						<form:errors path="DISPOSAL_TAXPAYER_AMT" cssClass="error" />
					</td>
					<td>
						<input type="text"  
                                       name="CLOSING_BALANCE_NO" id="CLOSING_BALANCE_NO"  value="${model.CLOSING_BALANCE_NO}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57"  readonly ="readonly"/>
					</td>
					<td>
						<input type="text"  
                                       name="CLOSING_BALANCE_AMOUNT" id="CLOSING_BALANCE_AMOUNT"  value="${model.CLOSING_BALANCE_AMOUNT}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  readonly ="readonly"/>
					</td>
					<td>
						<input type="text"  data-rule-required="true" 
                                       name="AGE_UPTO_6_NO" id="AGE_UPTO_6_NO"  value="${model.AGE_UPTO_6_NO}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "required"  />
						<form:errors path="AGE_UPTO_6_NO" cssClass="error" />
					</td>
					<td>
						<input type="text"  data-rule-required="true" 
                                       name="AGE_6_TO_12_NO" id="AGE_6_TO_12_NO"  value="${model.AGE_6_TO_12_NO}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "required"  />
						<form:errors path="AGE_6_TO_12_NO" cssClass="error" />
					</td>
					<td>
						<input type="text"  data-rule-required="true" 
                                       name="AGE_MORE_THAN_1_NO" id="AGE_MORE_THAN_1_NO"  value="${model.AGE_MORE_THAN_1_NO}"
						class="form-control min-width-1" maxlength="10" 
						onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "required"  />
						<form:errors path="AGE_MORE_THAN_1_NO" cssClass="error" />
					</td>
						</tr> 
					 </c:forEach> 
					 
					 <tr>
					 <td colspan="13">
					 * Where case is decided partly in favour of department and partly in favour of taxpayer, then amount will be shown as per order but the no. will be figured in column where highest amount is involved.
					 </td>
					 </tr>
				</table>
                        </div>
                    </div>
                 <%--    <div align="center">
                    <input type="hidden" type="submit" name="btn_submit" id="btn_submit" value="${ViewBag_button}" class="btn btn-success" />
                    <input type="hidden" type="hidden" name="hndresult" id="hndresult" value="${ViewBagMessage}" />                   
                    <input type="hidden" name="btn_Cancel" id="btn_Cancel" type="reset" value="Cancel" class="btn btn-danger" />     
                    </div>
                     --%>
                    <c:if test="${not empty model}">
							<div align="center">
								<input name="btn_submit" class="btn btn-success" id="btn_submit"
									type="submit" value="${ViewBag_button}" /> 
									<input
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
	
	
		<form action="/MPR/GSTDPM/Insert/DPM_GST_ADJ_2_Opening" id="DPMGstAdj2CommTemp"
			name="DPMGstAdj2CommTemp" autocomplete="off" method="post"
			modelAttribute="DPMGstAdj2CommTemp">

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
								<b>OPENING BALANCE DETAILS [2023-04-01]</b>
							</h5>
							<!-- <button type="button" class="close" style="margin-top:-23px;opacity: inherit;color: #c9302c;" 
                data-dismiss="modal" aria-label="Close"> -->
							<!--  <span aria-hidden="true">&times;</span> 
							</button>-->
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
											class="form-control min-width-90" autocomplete="off" value=""
											onkeypress="return event.charCode >= 48 && event.charCode <= 57"
											required="true" /> <form:errors path="OPENING_BALANCE_NO"
												cssClass="error" /></td>
										<td><input path="OPENING_BALANCE_AMOUNT" type="text"
											placeholder="0.00" name="OPENING_BALANCE_AMOUNT"
											id="OPENING_BALANCE_AMOUNT" class="form-control min-width-90"
											autocomplete="off" value=""
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
        $(document).ready(function () {
        	//alert()

        	$('body'). bind('copy paste',function(e) { e. preventDefault(); return false; });
        	
            if ('@Request.Params["CRR"]' == '' || '@Request.Params["CRR"]' == null) {
                $("#btn_Abort").hide();
            }

            if ($("#hndresult").val() == "CORRECTION REQUEST SUBMITTED") {
                $("#btn_Cancel").hide();
                $("#btn_submit").hide();
                $("#btn_Abort").hide();
            }
            else {

            	if ('${CRR}' == "T")
                {
                    $("#btn_submit").val("Update");
                    $("#btn_Abort").show();
                }
                $("#btn_submit").show();
                $("#btn_Cancel").show();
                $("#btn_Abort").hide();
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

    $(document).ready(function () {

        var button_name = $('#btn_submit').val();
        
        if (button_name == "Upload") {
            $('#btn_Cancel').show();
        }
        else {

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
