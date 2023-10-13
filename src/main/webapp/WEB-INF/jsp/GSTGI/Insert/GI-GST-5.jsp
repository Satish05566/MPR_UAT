<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<%-- <link
	href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/mpr-report.css"
	rel="stylesheet" /> --%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-6">
			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-book fa-fw"></i> GI-GST-5
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
	
		 <%-- <form:form action="/MPR/GSTGI/Insert/GI_GST_5" id="gIGstCommTemp"
			name="gIGstCommTemp" method="POST" modelAttribute="gIGstCommTemp">  --%>
			<%-- <c:choose>
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
						Arrests, Prosecution Sanctioned And Prosecution Launched under the CGST Act, 2017
						<a style="margin-left: 85%;" onclick="addNewData();" class="btn btn-success"
						 href="#">Add New</a>
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

								<div class="sub-lakh">Amount in Rs. Lakhs</div>
							</div>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
                                       
						 			<tr class="text-center-capitalize table-header-center">
						 			
						 			   <td align="center" rowspan="2" width="5" >Action</td>            
						               <td rowspan="2" width="8%">Sr.NO.</th>
						               <td rowspan="2" width="8%">F. No.</th>
						               <td  rowspan="2" width="15%">NAME OF THE TAXPAYER</th>
						               <td  rowspan="2" width="15%">ADDRESS OF THE TAXPAYER</th>  
						               
						               <td  rowspan="2"  width="8%">GSTIN OF THE TAXPAYER</th>
						               <td  rowspan="2"  width="8%">AMOUNT OF TAX EVADED</th>
						               <td rowspan="2"  width="8%">NAME OF THE PERSON ARRESTED</th>
						               <td rowspan="2"  width="8%">DESGINATION OF THE PERSON ARRESTED</th>
						               <td rowspan="2"  width="8%">AGE OF THE PERSON ARRESTED</th>
						               <td rowspan="2" width="8%">PAN OF THE PERSON ARRESTED</th>
						               <td rowspan="2" width="8%">AADHAR NUMBER OF THE PERSON ARRESTED</th>
						               <td  rowspan="2" width="8%">DATE OF ARREST (DD/MM/YYYY)</th>
						               <td  rowspan="2" width="8%">ROLE PLAYED IN TAX EVASION (MAXIMUM 100 CHARACTERS)</th>
						               <td rowspan="2"  width="15%">PROSECUTION SANCTION ORDER NO.</th>
						               <td rowspan="2"  width="15%">PROSECUTION SANCTION ORDER DATE</th>    
						               <td  rowspan="2" width="8%">NUMBER OF PERSONS PROSECUTED</th>
						               <td  rowspan="2" width="8%">DATE OF FILING OF COMPLAINT IN COURT</th>
						               <td  rowspan="2" width="15%">CRIMINAL COMPLAINT NUMBER</th>   
						               <td  rowspan="1" colspan="3" width="15%">DETAILS OF ORDER PASSED BY THE COURT</th>               
						            </tr> 
									<tr class="text-center-capitalize table-header-center">
						            	<td rowspan="1"  width="8%">Order No.</th>
						            	<td rowspan="1"  width="8%">Order Date</th>      
						                <td  rowspan="1"  width="8%">Details of Order</th> 
						            </tr>  
									<% int i=0; %>
									<c:forEach items="${Model}" var="r">
										<tr >
											<td class="table-datarow-center">
											<a style="width: 65px; padding: 3px 9px; height: 27px; margin-top: 5px;"
											onclick="GetReport('<%= i+1 %>','${r.SNO}','${r.f_NO}','${r.NAME_TAXPAYER}','${r.ADDRESS_TAXPAYER}',
											'${r.GSTIN}','${r.TAX_EVADED}','${r.NAME}','${r.DESGINATION}',
											'${r.AGE}','${r.PAN}','${r.AADHAR}','${r.DATE_ARREST}','${r.ROLE_PLAYED}','${r.SANCTION_ORDER_NO}',
											'${r.SANCTION_ORDER_DATE}',
											'${r.NUMBER_PERSONS_PROSECUTED}','${r.DATE_FILING_COURT}','${r.CRIMINAL_COMPLAINT_NUMBER}',
											'${r.COURT_ORDER_NO}','${r.COURT_ORDER_DATE}','${r.COURT_DETAIL_ORDER}');" href="#"><i class="fa fa-edit fa-2x" ></i></a>
											</td>			
	                               			<td class="table-datarow-center" style="background-color: #67AEE3 !important;" width="8%"><%= i+1 %></td>
					                        <td width="8%" align="center" style="background-color: #67AEE3 !important;"> ${(r.f_NO)}</td>
					                        <td  width="10%" align="left" style="background-color: #67AEE3 !important;">${(r.NAME_TAXPAYER)}</td>
					                        <td  width="10%" align="left" style="background-color: #67AEE3 !important;">${(r.ADDRESS_TAXPAYER)}</td>
					                       	              
					                        <td  width="8%" align="left" style="background-color: #67AEE3 !important;">${(r.GSTIN)}</td>
					                        <td  width="5%" align="right" style="background-color: #67AEE3 !important;">${(r.TAX_EVADED)}</td>
					                        <td  width="8%" align="left" style="background-color: #67AEE3 !important;">${(r.NAME)}</td>
					                        <td  width="8%" align="left" style="background-color: #67AEE3 !important;">${(r.DESGINATION)}</td>
					                        <td  width="8%" align="center" style="background-color: #67AEE3 !important;">${(r.AGE)}</td>
					                    	<td  width="8%" align="left" style="background-color: #67AEE3 !important;">${(r.PAN)}</td>
					                    	<td  width="8%" align="left" style="background-color: #67AEE3 !important;">${(r.AADHAR)}</td>
					                    	
					                     	<td  width="5%" align="left" style="background-color: #67AEE3 !important;">${(r.DATE_ARREST)}</td>
					                    	<td  width="8%" align="left" style="background-color: #67AEE3 !important;">${(r.ROLE_PLAYED)}</td>
					                     	<td  width="10%" align="left" style="background-color: #67AEE3 !important;">${(r.SANCTION_ORDER_NO)} </td>
					                     	<td  width="10%" align="left" style="background-color: #67AEE3 !important;" >${(r.SANCTION_ORDER_DATE)}</td>
					                    	<td  width="5%" align="right" style="background-color: #67AEE3 !important;">${(r.NUMBER_PERSONS_PROSECUTED)}</td>
					                    	<td  width="5%" align="left" style="background-color: #67AEE3 !important;">${(r.DATE_FILING_COURT)}</td>
					                     	<td  width="5%" align="right" style="background-color: #67AEE3 !important;">${(r.CRIMINAL_COMPLAINT_NUMBER)}</td>
					                     	<td  width="5%" align="left" style="background-color: #67AEE3 !important;">${(r.COURT_ORDER_NO)}</td>
					                    	<td  width="5%" align="left" style="background-color: #67AEE3 !important;">${(r.COURT_ORDER_DATE)}</td>
					                    	<td  width="5%" align="left" style="background-color: #67AEE3 !important;">${(r.COURT_DETAIL_ORDER)}</td>		                               					
											</tr>
											 <% i=i+1; %>
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
		<%--  </form:form>  --%>
	</div>
</div>


<form action="/MPR/GSTGI/Insert/GI_GST_5" id="gIGstCommTemp" name="gIGstCommTemp" autocomplete="off" method="post"  modelAttribute="gIGstCommTemp">
			<div class="modal fade" id="Modal2" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header"
							style="background-color: #f2dede; color: #a94442; ">
							<h5 class="modal-title" id="exampleModalLabel"> 
							<span style="color: green;margin-right: 5%;">MONTH : <%=desDt.toUpperCase()%></span> 
							ARRESTS,PROSECUTION SANCTIONED AND PROSECUTION LAUNCHED UNDER THE CGST ACT, 2017
							 <b>GSTIN- </b> <label id="GSTIN_1"> </label>
							</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div> 

						<div class="modal-body" onmousewheel="myFunction_m()" 
						style="height: 600px;overflow-y: auto;">
							<div class="card-body">
							<%String TokenNo = (String) request.getSession().getAttribute("TokenNo");%>
							<input	type="hidden" id="HDTokenNo" name="HDTokenNo"
											value="<%=TokenNo%>" /> 
							<input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
							<input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token"
											value="<%= session.getAttribute("CSRF_Token") %>">
											
							<input type="hidden" id="SNO" name="SNO" value="${SNO}" />
								<div class="form-group row">
									<label for="F_NO" class="col-sm-6 control-label col-form-label">F. No.	</label>
									<div class="col-sm-6">
										<input type="text" class="form-control clsClear disableSpecialChar" 
											id="F_NO" name="F_NO" placeholder="Enter file number" 
											required maxlength="15">	
											<form:errors path="F_NO" cssClass="error" />								
									</div>
								</div>								
								<div class="form-group row">
									<label for="NAME_TAXPAYER" class="col-sm-6 control-label col-form-label">NAME OF THE TAXPAYER</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="NAME_TAXPAYER" 
										name="NAME_TAXPAYER" required>
										<form:errors path="NAME_TAXPAYER" cssClass="error" />	
									</div>
								</div>	
								<div class="form-group row">
									<label for="ADDRESS_TAXPAYER" class="col-sm-6 control-label col-form-label">ADDRESS OF THE TAXPAYER</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="ADDRESS_TAXPAYER" 
										name="ADDRESS_TAXPAYER" required>
										<form:errors path="ADDRESS_TAXPAYER" cssClass="error" />	
									</div>
								</div>							
 								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">GSTIN OF THE TAXPAYER	</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="GSTIN" name="GSTIN"
										 maxlength="16" required>
										<form:errors path="GSTIN" cssClass="error" />	
									</div>
								</div>
								<div class="form-group row">
									<label for="lname" class="col-sm-6 control-label col-form-label">AMOUNT OF TAX EVADED</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="TAX_EVADED" name="TAX_EVADED" maxlength="8" 
										onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" 
										required = "required">
										<form:errors path="TAX_EVADED" cssClass="error" />	
									</div>
								</div>								
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">NAME OF THE PERSON ARRESTED</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="NAME" name="NAME" maxlength="99" required>
										<form:errors path="NAME" cssClass="error" />	
									</div>
								</div>
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">DESGINATION OF THE PERSON ARRESTED</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="DESGINATION" name="DESGINATION" maxlength="99" 
										required>
										<form:errors path="DESGINATION" cssClass="error" />	
									</div>
								</div>
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">AGE OF THE PERSON ARRESTED</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="AGE" name="AGE" maxlength="3"
										onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "required" >
										<form:errors path="AGE" cssClass="error" />	
									</div>
								</div>
								<div class="form-group row">
									<label for="lname" class="col-sm-6 control-label col-form-label">PAN OF THE PERSON ARRESTED</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="PAN" name="PAN" maxlength="10" required>
										<form:errors path="PAN" cssClass="error" />	
									</div>
								</div>
								<div class="form-group row">
									<label for="lname" class="col-sm-6 control-label col-form-label">AADHAR NUMBER OF THE PERSON ARRESTED</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="AADHAR" name="AADHAR" maxlength="12" 
										onkeypress="return event.charCode >= 48 && event.charCode <= 57" required>
										<form:errors path="AADHAR" cssClass="error" />	
									</div>
								</div>								
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">DATE OF ARREST (DD/MM/YYYY)</label>
									<div class="col-sm-6">
										<!-- <input type="text" class="form-control" id="DATE_ARREST" name="DATE_ARREST" > -->										
										
										<input type="date" class="form-control clsClear datepicker"
											id="DATE_ARREST" name="DATE_ARREST" 
											  style="background: white;" required >
									</div>
								</div>
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">ROLE PLAYED IN TAX EVASION (MAXIMUM 100 CHARACTERS)</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="ROLE_PLAYED" name="ROLE_PLAYED" 
										maxlength="99" required>
										<form:errors path="ROLE_PLAYED" cssClass="error" />	
									</div>
								</div>
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">PROSECUTION SANCTION ORDER NO.</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="SANCTION_ORDER_NO" 
										name="SANCTION_ORDER_NO" 
										maxlength="99" required
										>
										<form:errors path="SANCTION_ORDER_NO" cssClass="error" />	
									</div>
								</div>
								 <div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">PROSECUTION SANCTION ORDER DATE</label>
									<div class="col-sm-6">
										<input type="date" class="form-control clsClear datepicker"
											id="SANCTION_ORDER_DATE" name="SANCTION_ORDER_DATE" 
											  style="background: white;" required>
									</div>
								</div> 
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">NUMBER OF PERSONS PROSECUTED</label>
									<div class="col-sm-6">
										 
										<%--  <form:input path="nUMBER_PERSONS_PROSECUTED" type="text"  
												class="form-control min-width-1"
												required="true" />  --%>
												
										  <input type="text" class="form-control" id="NUMBER_PERSONS_PROSECUTED" 
										 name="NUMBER_PERSONS_PROSECUTED" maxlength="5"										 
										 onkeypress="return event.charCode >= 48 && event.charCode <= 57" 
										 required="required">  
										 <form:errors path="NUMBER_PERSONS_PROSECUTED" cssClass="error" />	
										 
										 <%-- <form:input path="nUMBER_PERSONS_PROSECUTED" type="text"
												placeholder="NUMBER PERSONS PROSECUTED" class="form-control min-width-1"
												style="min-width: 80px !important;" readonly="true"
												autocomplete="off"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
												required="true" /> 
												<form:errors path="nUMBER_PERSONS_PROSECUTED"	cssClass="error" /> --%>
										 
									</div>
								</div>
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">DATE OF FILING OF COMPLAINT IN COURT</label>
									<div class="col-sm-6">
										<!-- <input type="text" class="form-control" id="DATE_FILING_COURT" name="DATE_FILING_COURT" > -->
										
										
										<input type="date" class="form-control clsClear datepicker"
											id="DATE_FILING_COURT" name="DATE_FILING_COURT" 
											  style="background: white;" required >
									</div>
								</div>
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">CRIMINAL COMPLAINT NUMBER</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="CRIMINAL_COMPLAINT_NUMBER" 
										name="CRIMINAL_COMPLAINT_NUMBER" maxlength="99" 
										required="required"
										>
										<form:errors path="CRIMINAL_COMPLAINT_NUMBER" cssClass="error" />
									</div>
								</div>
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">ORDER NO PASSED BY THE COURT</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" class="COURT_ORDER_NO" id="COURT_ORDER_NO" 
										name="COURT_ORDER_NO" maxlength="99"  required="required">
										<form:errors path="COURT_ORDER_NO" cssClass="error" />
									</div>
								</div>
								
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">ORDER DATE PASSED BY THE COURT</label>
									<div class="col-sm-6">
										<!-- <input type="text" class="form-control" class="COURT_ORDER_DATE" id="COURT_ORDER_DATE" 
										name="COURT_ORDER_DATE" > -->
										
										<input type="date" class="form-control clsClear datepicker"
											id="COURT_ORDER_DATE" name="COURT_ORDER_DATE" 
											  style="background: white;" required >
									</div>
								</div>
								
								<div class="form-group row">
									<label for="lname"
										class="col-sm-6 control-label col-form-label">DETAILS OF ORDER</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="COURT_DETAIL_ORDER" 
										name="COURT_DETAIL_ORDER" maxlength="99" required="required">
										<form:errors path="COURT_DETAIL_ORDER" cssClass="error" />
									</div>
								</div>							
						    </div>
						</div>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal" style="margin-right:10px;"
								id="cancel_button">Close</button>
							<!-- <input type="submit" name="btn_submit" class="btn btn-success"
								value="Update" id="UpdateId" />  -->
								<input type="submit" name="btn_submit" class="btn btn-success"
                        value="Upload" id="btn_submit" />

						</div>
				</div>
			</div>
		</form>

		<!-- Modal -->

<%-- <script
	src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script> --%>


<script src="../../../Content-Common/js/jquery.js"></script><%-- 
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/assets/libs/datepicker-ui/jquery-ui-1.13.2.js"></script>
 <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/assets/libs/jquery/dist/jquery.min.js"></script>
  --%>
<%-- <link href="<%= session.getAttribute("JSP_PATH_RESOLVE")%>Content-MPR/assets/libs/datepicker-ui/jquery-ui-1.13.2.css" rel="stylesheet"> --%>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>

<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script> 
<%-- <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script> --%>

<!-- <script src="../../../Content-Common/js/jquery.js"></script> -->

<script language="javascript" type="text/javascript">
$('#NUMBER_PERSONS_PROSECUTED').keyup(function(){
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

$(function(){
    var dtToday = new Date();

    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();

    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();

    var maxDate = year + '-' + month + '-' + day;    
    $('#SANCTION_ORDER_DATE').attr('max', maxDate);
    $('#DATE_ARREST').attr('max', maxDate);
    $('#DATE_FILING_COURT').attr('max', maxDate);
    $('#COURT_ORDER_DATE').attr('max', maxDate);
    
    
});



$('#F_NO').bind('keypress', function (event) {
	// debugger;
	    var regex = new RegExp(/^[a-zA-Z0-9]+$/);
	    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
	            if (!regex.test(key)) {
	               event.preventDefault();
	               return true;
	            }
	    }); 
  
$('#NAME_TAXPAYER').bind('keypress', function (event) {
	// debugger;
	    var regex = new RegExp(/^[a-zA-Z ()]+$/);
	    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
	            if (!regex.test(key)) {
	               event.preventDefault();
	               return true;
	            }
	    });


$('#ADDRESS_TAXPAYER').bind('keypress', function (event) {
	// debugger;
	    var regex = new RegExp(/^[a-zA-Z0-9. ()/,-]+$/);
	    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
	            if (!regex.test(key)) {
	               event.preventDefault();
	               return true;
	            }
	    });

$('#GSTIN').bind('keypress', function (event) {
	// debugger;
	    var regex = new RegExp(/^[a-zA-Z0-9]+$/);
	    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
	            if (!regex.test(key)) {
	               event.preventDefault();
	               return true;
	            }
	    });
$('#NAME').bind('keypress', function (event) {
	// debugger;
    var regex = new RegExp(/^[a-zA-Z ()]+$/);
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
            if (!regex.test(key)) {
               event.preventDefault();
               return true;
            }
    });
$('#DESGINATION').bind('keypress', function (event) {
	// debugger;
    var regex = new RegExp(/^[a-zA-Z ()]+$/);
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
            if (!regex.test(key)) {
               event.preventDefault();
               return true;
            }
    });
/* $('#PAN').bind('keypress', function (event) {
	// debugger;
    var regex = new RegExp(/^[a-zA-Z0-9]+$/);
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
            if (!regex.test(key)) {
               event.preventDefault();
               return true;
            }
    }); */
$('#ROLE_PLAYED').bind('keypress', function (event) {
	// debugger;
    var regex = new RegExp(/^[a-zA-Z ()]+$/);
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
            if (!regex.test(key)) {
               event.preventDefault();
               return true;
            }
    });

$('#SANCTION_ORDER_NO').bind('keypress', function (event) {
	// debugger;
    var regex = new RegExp(/^[a-zA-Z0-9 ()]+$/);
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
            if (!regex.test(key)) {
               event.preventDefault();
               return true;
            }
    });
	    
$('#CRIMINAL_COMPLAINT_NUMBER').bind('keypress', function (event) {
	// debugger;
    var regex = new RegExp(/^[a-zA-Z0-9 ()]+$/);
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
            if (!regex.test(key)) {
               event.preventDefault();
               return true;
            }
    });
	    
$('#COURT_ORDER_NO').bind('keypress', function (event) {
	// debugger;
    var regex = new RegExp(/^[a-zA-Z0-9 ()]+$/);
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
            if (!regex.test(key)) {
               event.preventDefault();
               return true;
            }
    });
	    
$('#COURT_DETAIL_ORDER').bind('keypress', function (event) {
	// debugger;
    var regex = new RegExp(/^[a-zA-Z0-9 /,()]+$/);
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
            if (!regex.test(key)) {
               event.preventDefault();
               return true;
            }
    });



		function GetReport(_index,SNO,f_NO,NAME_TAXPAYER,ADDRESS_TAXPAYER,GSTIN,TAX_EVADED,
				NAME,DESGINATION,AGE,PAN,AADHAR,DATE_ARREST,ROLE_PLAYED,SANCTION_ORDER_NO,SANCTION_ORDER_DATE,
				NUMBER_PERSONS_PROSECUTED,DATE_FILING_COURT,CRIMINAL_COMPLAINT_NUMBER,
				COURT_ORDER_NO,COURT_ORDER_DATE,COURT_DETAIL_ORDER) {
			
			$("#SNO").val(SNO);
			$("#F_NO").val(f_NO);
			$('#NAME_TAXPAYER').val(NAME_TAXPAYER);
			$('#ADDRESS_TAXPAYER').val(ADDRESS_TAXPAYER);
			$('#GSTIN').val(GSTIN);
			$("#TAX_EVADED").val(TAX_EVADED);
			$("#NAME").val(NAME);
			$("#DESGINATION").val(DESGINATION);
			$("#AGE").val(AGE);
			$("#PAN").val(PAN);
			$("#AADHAR").val(AADHAR);
			
			$("#ROLE_PLAYED").val(ROLE_PLAYED);
     		$("#SANCTION_ORDER_NO").val(SANCTION_ORDER_NO);
			//$("#SANCTION_ORDER_DATE").val(SANCTION_ORDER_DATE);
			$("#NUMBER_PERSONS_PROSECUTED").val(NUMBER_PERSONS_PROSECUTED);  
			
			$("#CRIMINAL_COMPLAINT_NUMBER").val(CRIMINAL_COMPLAINT_NUMBER);
			$("#COURT_ORDER_NO").val(COURT_ORDER_NO);

			var dateFiling= DATE_FILING_COURT.split('-');
			var newDateFiling = dateFiling[2] + '-' + dateFiling[1] + '-' + dateFiling[0];			
			$("#DATE_FILING_COURT").val(newDateFiling);
			//$("#DATE_FILING_COURT").val(DATE_FILING_COURT);
			
			
			var dateArrest= DATE_ARREST.split('-');
			var newDateArrest = dateArrest[2] + '-' + dateArrest[1] + '-' + dateArrest[0];			
			$("#DATE_ARREST").val(newDateArrest);
			
			
			var dateCourtOrder= COURT_ORDER_DATE.split('-');
			var newDateCourtOrder = dateCourtOrder[2] + '-' + dateCourtOrder[1] + '-' + dateCourtOrder[0];			
			$("#COURT_ORDER_DATE").val(newDateCourtOrder);
			
			
			$("#COURT_DETAIL_ORDER").val(COURT_DETAIL_ORDER);
			
			$('#GSTIN_1').text(GSTIN);
			
			
			var date= SANCTION_ORDER_DATE.split('-');
			var newDate = date[2] + '-' + date[1] + '-' + date[0];			
			$("#SANCTION_ORDER_DATE").val(newDate);
			
			$('#Modal2').modal({
	            show: true,
	            backdrop: false,
	            keyboard: false
	        });
			
			$("#btn_submit").val("Update");
		}


	/* $(document).on("keypress", "input[type='text']", function(e) {
		document.getElementById('reason_error').innerHTML = '';
	}); */
	
	
	
	$('.cls1').click(function(data){
		//alert(jQuery(this).data('SNO'));
		//$("#DRN_Generating_Officer").val(jQuery(this).data('sno'));
		$('#Modal2').modal({
            show: true,
            backdrop: false,
            keyboard: false
        });
	});
	
	 function addNewData() {
			//$("#SNO").val(SNO);
			$("#F_NO").val("");
			$('#NAME_TAXPAYER').val("");
			$('#ADDRESS_TAXPAYER').val("");
			$('#GSTIN').val("");
			$("#TAX_EVADED").val("");
			$("#NAME").val("");
			$("#DESGINATION").val("");
			$("#AGE").val("");
			$("#PAN").val("");
			$("#AADHAR").val("");			
			$("#ROLE_PLAYED").val("");
     		$("#SANCTION_ORDER_NO").val("");
			$("#NUMBER_PERSONS_PROSECUTED").val("");			
			$("#CRIMINAL_COMPLAINT_NUMBER").val("");
			$("#COURT_ORDER_NO").val("");
			$("#DATE_FILING_COURT").val("");			
			$("#DATE_ARREST").val("");			
			$("#COURT_ORDER_DATE").val("");			
			$("#COURT_DETAIL_ORDER").val("");			
			$('#GSTIN_1').text("");
			$("#SANCTION_ORDER_DATE").val("");
			$('#Modal2').modal({
	            show: true,
	            backdrop: false,
	            keyboard: false
	        });
			$("#btn_submit").val("Upload");
		}
	
	/* $(".datepicker").datepicker({    
	    //startDate: "+0d",
	    //format: 'dd/mm/yyyy'
	    dateFormat: 'dd/mm/yy',
	    firstDay: 1,
	}); */
	
	
	function model_popup()
	{
		
		 $('#Modal2').modal({
	            show: true,
	            backdrop: false,
	            keyboard: false
	        });
	}
	
	$('#btn_popup').click(function () {
        $('#Modal2').modal({
            show: true,
            backdrop: false,
            keyboard: false
        })
    });
	
	function myFunction_m() {

        $('#Modal2').bind("mousewheel", function () {
            return false;
        });
    }
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
        
        $('#TAX_EVADED').keyup(function(){
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

    

        
       /*  $('.form-control').keyup(function(){
        	var val = $(this).val();
            if(isNaN(val)){
                 val = val.replace(/[^0-9\.]/g,'');
                 if(val.split('.').length>2) 
                     val =val.replace(/\.+$/,"");
            }
            if(val.indexOf(".") >= 0)
            	val = val.indexOf(".") >= 0 ? val.slice(0, val.indexOf(".") + 3) : val;
            $(this).val(val); 
        }); */
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
