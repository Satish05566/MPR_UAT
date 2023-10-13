<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />
<link
	href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/mpr-report.css"
	rel="stylesheet" />
<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">               
                <i class="fa fa-book fa-fw"></i>  DPM-GST-15C[GST-REG-2B]
            </h4>

        </div>
        <div class="col-lg-6">

            <ol class="breadcrumb float-right no-bg-col m-b-0 p-t-20 p-r-0">
                <li><a href="/KPI_Home"><i class="fa fa-home"></i> Management Information</a></li>
                <li><a href="/Insert">Upload</a></li>
                <li class="active">GST</li>
                

            </ol>
        </div>
        
        
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    
     <div class="row">
    <form:form action="/MPR/GSTDPM/Insert/DPM_GST_15C" id="dpmGst15cCommTemp" name = "dpmGst15cCommTemp" method="POST"  modelAttribute="dpmGst15cCommTemp" >
     <c:choose>
       <c:when test= "${ViewBagMessage!=null || ViewBagMessage.length() ==0}"> 
        <div class="col-lg-12">
        <div class="alert-success" id="login_error">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            ${ViewBagMessage}
        </div>
     </div> 
    </c:when>
    </c:choose>

    <div class="col-lg-12">
        <div class="panel panel-danger">
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
                              MONTH : <%= desDt.toUpperCase() %>
                
                       <!--  <div class="sub-lakh">(Rs. In Crores)</div> -->
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                        <tr>
                         <tr class="text-center-capitalize table-header-center">
                        <td style="width:70%"><h4>Reasons for pendency of Revocation of cancelled GSTIN (Column 14 of DPM-GST-15A)</h4></td>
                        <td><h4>No. of GSTINs </h4></td>
                        </tr>
                        <tr>
                          
                                 <%   
                                String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                String MM_YYYY = (String) request.getAttribute("MM_YYYY");
                                String CRR = (String) request.getAttribute("CRR");
                                %>
                           <td>Personal Hearing granted</td>
                           <td>
                                    <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="CRR" name="CRR" value="${CRR}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">

                                    <form:input path="PERSONAL_HEARING_GRANTED_NO_GSTIN" type="text" style="text-align: right;"  
                                    name="PERSONAL_HEARING_GRANTED_NO_GSTIN" id="PERSONAL_HEARING_GRANTED_NO_GSTIN" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true" class="form-control min-width-1" autocomplete="off" 
                                    value= "${model.PERSONAL_HEARING_GRANTED_NO_GSTIN}"  maxlength="10"  />
                                       <form:errors path="PERSONAL_HEARING_GRANTED_NO_GSTIN" cssClass="error" />  
                                       
                                </td>
                        </tr>
                        <tr>
                        <td>No time left for rejection</td>
                        <td><form:input path="NOTIME_LEFT_FOR_REJECTION_NO_GSTIN" type="text" style="text-align: right;"
                                    name="NOTIME_LEFT_FOR_REJECTION_NO_GSTIN" id="NOTIME_LEFT_FOR_REJECTION_NO_GSTIN" class="form-control min-width-1" autocomplete="off" 
                                    value= "${model.NOTIME_LEFT_FOR_REJECTION_NO_GSTIN}"  maxlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                                       <form:errors path="NOTIME_LEFT_FOR_REJECTION_NO_GSTIN" cssClass="error" />  </td></tr>
                        <tr><td>Taxes/Dues are unpaid</td>
                        <td> <form:input path="TAXES_OR_DUES_UNPAID_NO_GSTIN" type="text" style="text-align: right;" name="TAXES_OR_DUES_UNPAID_NO_GSTIN" 
                                    id="TAXES_OR_DUES_UNPAID_NO_GSTIN" class="form-control min-width-1"  maxlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true" autocomplete="off" value= "${model.TAXES_OR_DUES_UNPAID_NO_GSTIN}"  />
                                       <form:errors path="TAXES_OR_DUES_UNPAID_NO_GSTIN" cssClass="error" /></td></tr>
                        <tr><td>Technical issues</td>
                        <td><form:input path="TECHNICAL_ISSUES_NO_GSTIN" type="text" style="text-align: right;"   name="TECHNICAL_ISSUES_NO_GSTIN" 
                                    id="TECHNICAL_ISSUES_NO_GSTIN" class="form-control min-width-1"  maxlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true" autocomplete="off" value= "${model.TECHNICAL_ISSUES_NO_GSTIN}"  />
                                       <form:errors path="TECHNICAL_ISSUES_NO_GSTIN" cssClass="error" /></td></tr>
                        <tr><td>
										<p> 
                                <span style="margin-top: 5px;float: left;">Others, please specify<span class="error">*</span></span>
										 <form:input path="OTHERS_SPECIFY" type="text"  name="OTHERS_SPECIFY" id="OTHERS_SPECIFY" class="form-control min-width-1-left" 
                                autocomplete="off" value= "${model.OTHERS_SPECIFY}" required = "true"
                                style="width: 47%;margin-left: 4%;float: left;"  maxlength="100" />
                                <form:errors path="OTHERS_SPECIFY" cssClass="error" /> </p></td>
                        <td><form:input path="OTHERS_NO_GSTIN" type="text" style="text-align: right;" name="OTHERS_NO_GSTIN" 
                                    id="OTHERS_NO_GSTIN" class="form-control min-width-1"  maxlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true" autocomplete="off" value= "${model.OTHERS_NO_GSTIN}" />
                                       <form:errors path="OTHERS_NO_GSTIN" cssClass="error"/></td></tr>
                        </table>


                        <!-- /.table-responsive -->
                    </div>

                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
                <div align="center">
                    <input name="btn_submit" class="btn btn-success" id="btn_submit" type="submit" value="${ViewBag_button}" />
                    <input type="hidden" name="hndresult" id="hndresult" value="${ViewBagMessage}" />
                    <input name="btn_Cancel" id="btn_Cancel" class="btn btn-danger" type="reset" value="Cancel" />
                    <input name="btn_error" class="btn btn-success" id="btn_error" type="hidden" value="${button}" />

                </div>
            </div>
            <!-- /.col-lg-6 -->

        </div>
    </div>


    </form:form>
    </div>
</div>

<script src="<%= session.getAttribute("COMMON_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>
<%-- <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.unobtrusive.js"></script> --%>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script> 


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

    $(document).ready(function () {

        var button_name = $('#btn_submit').val();
        if (button_name == "Upload") {
            $('#btn_Cancel').show();
        }
        else {
            $('#btn_Cancel').hide();
        }

    });
	$(document).on("keyup", function(e) {
    	for (let element of document.getElementsByClassName("error")){
    		
    		element.style.display="none";
    		}
	});
	 $('#OTHERS_SPECIFY').bind('keypress', function (event) {
		// debugger;
		    var regex = new RegExp(/^[a-zA-Z0-9. ()/,-]+$/);
		    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
		            if (!regex.test(key)) {
		               event.preventDefault();
		               return true;
		            }
		    });
</script>


<jsp:include page="../../GSTHome/Footer.jsp" />


