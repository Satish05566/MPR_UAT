<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<!-- <div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><i class="fa fa-edit fa-fw"></i> DPM-GST-12[GST-REG-1]</h1>
        </div>

    </div> -->
    
    <div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i>DPM-GST-12[GST-REG-1]
            </h4>

        </div>

    <form:form action="/MPR/GSTDPM/Insert/DPM_GST_12" id="DpmGst12CommTemp" 
    name = "DpmGst12CommTemp" method="POST" 
     modelAttribute="DpmGst12CommTemp" >

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

        <!-- <div class="col-lg-12">
            <div class="panel panel-info">
                <div class="panel-heading">
                    REPORT ON REGISTRATION OF TAXPAYERS
                </div> -->
                
                <div class="col-lg-12">
        <div class="panel panel-danger">
            <div class="panel-heading text-capitalize">
                REPORT ON REGISTRATION OF TAXPAYERS
            </div>


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
                              MONTH : <%= desDt.toUpperCase() %>
                
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">

                                <tbody class="text-capitalize">


                                    <tr>
                                        <th class="text-center">
                                            1
                                        </th>
                                        <th>
                                            No. of taxpayers at the beginning of the month
                                        </th>
                                        <td >
										<%
											String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                            String MM_YYYY = (String) request.getAttribute("MM_YYYY");
                                            String CRR = (String) request.getAttribute("CRR");
										    %>
                                          <input type="hidden" id="HDTokenNo" name="HDTokenNo"   value="<%=TokenNo%>" />
                                          <input type="hidden" id="MM_YYYY" name="MM_YYYY"   value="<%=MM_YYYY%>" />
                                          <input type="hidden" id="CRR" name="CRR"   value="<%=CRR%>" />
                                            <form:input path="SR_NO"  style="display:none;" 
                                        	name="SR_NO" id="SR_NO" class="form-control min-width-1" value="${model[0].SR_NO}" type="hidden"/> 
                                        	
                                            <input type="text"  data-rule-required="true" 
                                            name="NO_TAXPAYER_FOR_MONTH" id="NO_TAXPAYER_FOR_MONTH"  value="${model[0].NO_TAXPAYER_FOR_MONTH}"
											class="form-control min-width-1" maxlength="10" 
											onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "required" readonly ="readonly" />
											  <form:errors path="NO_TAXPAYER_FOR_MONTH" cssClass="error" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <th class="text-center">
                                            2
                                        </th>
                                        <th >
                                            New Taxpayers added during the month
                                        </th>
                                        <td >
										<input type="text"  data-rule-required="true" name="NEW_TAXPAYER_FOR_MONTH" id="NEW_TAXPAYER_FOR_MONTH"  value="${model[0].NEW_TAXPAYER_FOR_MONTH}"
											class="form-control min-width-1" maxlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "required" readonly ="readonly"/>
											  <form:errors path="NEW_TAXPAYER_FOR_MONTH" cssClass="error" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <th class="text-center">
                                            3
                                        </th>
                                        <th >
                                            Migration of Tax payers from other Zones (Applicable for Maharashtra, Gujarat and Uttar Pradesh Only)
                                        </th>
                                        <td >
										<input type="text"  data-rule-required="true" name="MIGRATION_TAXPAYER_FROM" id="MIGRATION_TAXPAYER_FROM"  value="${model[0].MIGRATION_TAXPAYER_FROM}"
											class="form-control min-width-1" maxlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "required" readonly ="readonly"/>
											  <form:errors path="MIGRATION_TAXPAYER_FROM" cssClass="error" />
                                        </td>
                                    </tr>

 									<tr>
                                        <th class="text-center">
                                            4
                                        </th>
                                        <th >
                                            Migration of Tax payers to other Zones (Applicable for Maharashtra, Gujarat and Uttar Pradesh Only)
                                        </th>
                                        <td >
										<input type="text"  data-rule-required="true" name="MIGRATION_TAXPAYER_TO" id="MIGRATION_TAXPAYER_TO"  value="${model[0].MIGRATION_TAXPAYER_TO}"
											class="form-control min-width-1" maxlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "required" readonly ="readonly"/>
											  <form:errors path="MIGRATION_TAXPAYER_TO" cssClass="error" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <th class="text-center">
                                            5
                                        </th>
                                        <th >
                                            Cancellation of registration - Suo moto
                                        </th>
                                        <td >
										<input type="text"  data-rule-required="true" name="SUO_MOTO" id="SUO_MOTO"  value="${model[0].SUO_MOTO}"
											class="form-control min-width-1" maxlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "required" readonly ="readonly"/>
											  <form:errors path="SUO_MOTO" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="text-center">
                                            6
                                        </th>
                                        <th >
                                            Cancellation of registration -On request
                                        </th>
                                        <td >
										<input type="text"  data-rule-required="true" name="ON_REQUEST" id="ON_REQUEST"  value="${model[0].ON_REQUEST}"
											class="form-control min-width-1" maxlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "required" readonly ="readonly"/>
											  <form:errors path="ON_REQUEST" cssClass="error" />
                                        </td>
                                    </tr>
                                     <tr>
                                        <th class="text-center">
                                            7
                                        </th>
                                        <th >
                                            Revocation of Cancelled Registration
                                        </th>
                                        <td >
										<input type="text"  data-rule-required="true" name="REVOCATION" id="REVOCATION"  value="${model[0].REVOCATION}"
											class="form-control min-width-1" maxlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "required" readonly ="readonly"/>
											  <form:errors path="REVOCATION" cssClass="error" />
                                        </td>
                                    </tr>
                                </tbody>
                                                               
                            </table>

                        </div>

                    </div>


                    <div align="center">

                    <input type="hidden" type="submit" name="btn_submit" id="btn_submit" value="${ViewBag_button}" class="btn btn-success" />
                    <input type="hidden" type="hidden" name="hndresult" id="hndresult" value="${ViewBagMessage}" />                   
                    <input type="hidden" name="btn_Cancel" id="btn_Cancel" type="reset" value="Cancel" class="btn btn-danger" />     
                    </div>
                </div>
            </div>

        </div>
</form:form>
</div>

<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.unobtrusive.js"></script>
<script type="text/javascript">
        $(document).ready(function () {

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
