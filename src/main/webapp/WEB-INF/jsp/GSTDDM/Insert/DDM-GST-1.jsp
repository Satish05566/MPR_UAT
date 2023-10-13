<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-book fa-fw"></i>  DDM-GST-1
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
    <form:form action="/MPR/GSTDDM/Insert/DDM_GST_1" id="ddmGst1CommTemp" name = "ddmGst1CommTemp" method="POST"  modelAttribute="ddmGst1CommTemp" >
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
            <div class="panel-heading text-capitalize">
                REVENUE REPORT
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
                
                        <div class="sub-lakh">Amount in Rs. Crores</div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">  
                        <tr class="table-header-center">
                         <td>Sr. No</td>
                         <td>DESCRIPTION</td>
                         <td>CGST</td>
                         <td>STATE/UT GST</td>
                         <td>IGST</td>
                         <td>CESS</td>
                        </tr>                    
                           <tr>
                                <th class="text-center">1</th>
                                <th>MOVING TARGET</th>
                                <%
                                   String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                   String MM_YYYY = (String) request.getAttribute("MM_YYYY");
                                   String CRR = (String) request.getAttribute("CRR");
                                
                                %>
                               
                                <td>
                                    <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="CRR" name="CRR" value="${CRR}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                                    
                                        <form:input path="MOVING_TARGET_CGST" type="text"  name="MOVING_TARGET_CGST" id="MOVING_TARGET_CGST" class="form-control min-width-1" autocomplete="off" value= "${model.MOVING_TARGET_CGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									        <form:errors path="MOVING_TARGET_CGST" cssClass="error" /> 
                                        </td>
                                          <td>
                                         <form:input path="MOVING_TARGET_SGST" type="text"  name="MOVING_TARGET_SGST" id="MOVING_TARGET_SGST" class="form-control min-width-1" autocomplete="off" value= "${model.MOVING_TARGET_SGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									     <form:errors path="MOVING_TARGET_SGST" cssClass="error" /> 
                                        </td>
                                          <td>
                                         <form:input path="MOVING_TARGET_IGST" type="text"  name="MOVING_TARGET_IGST" id="MOVING_TARGET_IGST" class="form-control min-width-1" autocomplete="off" value= "${model.MOVING_TARGET_IGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									     <form:errors path="MOVING_TARGET_IGST" cssClass="error" /> 
                                        </td>
                                        <td>
                                         <form:input path="MOVING_TARGET_CESS" type="text"  name="MOVING_TARGET_CESS" id="MOVING_TARGET_CESS" class="form-control min-width-1" autocomplete="off" value= "${model.MOVING_TARGET_CESS}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									     <form:errors path="MOVING_TARGET_CESS" cssClass="error" /> 
                                        </td>
                                      </tr>
                                    <tr>
                                        <th class="text-center">
                                            2
                                        </th>
                                        <th>
                                            GROSS REVENUE
                                        </th>
                                        <td>
                                          <form:input path="GROSS_TAX_CGST" type="text"  name="GROSS_TAX_CGST" id="GROSS_TAX_CGST" class="form-control min-width-1" autocomplete="off" readonly="true" value= "${model.GROSS_TAX_CGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									        <form:errors path="GROSS_TAX_CGST" cssClass="error" /> 
                                        </td>
                                          <td>
                                         <form:input path="GROSS_TAX_SGST" type="text"  name="GROSS_TAX_SGST" id="GROSS_TAX_SGST" class="form-control min-width-1" autocomplete="off" readonly="true" value= "${model.GROSS_TAX_SGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									     <form:errors path="GROSS_TAX_SGST" cssClass="error" /> 
                                        </td>
                                          <td>
                                         <form:input path="GROSS_TAX_IGST" type="text"  name="GROSS_TAX_IGST" id="GROSS_TAX_IGST" class="form-control min-width-1" autocomplete="off" readonly="true" value= "${model.GROSS_TAX_IGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									     <form:errors path="GROSS_TAX_IGST" cssClass="error" /> 
                                        </td>
                                        <td>
                                         <form:input path="GROSS_TAX_CESS" type="text"  name="GROSS_TAX_CESS" id="GROSS_TAX_CESS" class="form-control min-width-1" autocomplete="off" readonly="true" value= "${model.GROSS_TAX_CESS}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									     <form:errors path="GROSS_TAX_CESS" cssClass="error" /> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="text-center">
                                            3
                                        </th>
                                        <th>
                                            REFUND SANCTIONED
                                        </th>
                                        <td>
                                        <form:input path="REFUND_SANCTIONED_CGST" type="text"  name="REFUND_SANCTIONED_CGST" id="REFUND_SANCTIONED_CGST" class="form-control min-width-1" autocomplete="off" readonly="true" value= "${model.REFUND_SANCTIONED_CGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									        <form:errors path="REFUND_SANCTIONED_CGST" cssClass="error" /> 
                                        </td>
                                          <td>
                                         <form:input path="REFUND_SANCTIONED_SGST" type="text"  name="REFUND_SANCTIONED_SGST" id="REFUND_SANCTIONED_SGST" class="form-control min-width-1" autocomplete="off" readonly="true" value= "${model.REFUND_SANCTIONED_SGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									     <form:errors path="REFUND_SANCTIONED_SGST" cssClass="error" /> 
                                        </td>
                                          <td>
                                         <form:input path="REFUND_SANCTIONED_IGST" type="text"  name="REFUND_SANCTIONED_IGST" id="REFUND_SANCTIONED_IGST" class="form-control min-width-1" autocomplete="off" readonly="true" value= "${model.REFUND_SANCTIONED_IGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									     <form:errors path="REFUND_SANCTIONED_IGST" cssClass="error" /> 
                                        </td>
                                        <td>
                                         <form:input path="REFUND_SANCTIONED_CESS" type="text"  name="REFUND_SANCTIONED_CESS" id="REFUND_SANCTIONED_CESS" class="form-control min-width-1" autocomplete="off" readonly="true" value= "${model.REFUND_SANCTIONED_CESS}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									     <form:errors path="REFUND_SANCTIONED_CESS" cssClass="error" /> 
                                        </td>
                                        
                                    </tr>
                           
                          

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

                </div>
            </div>
            <!-- /.col-lg-6 -->

        </div>
    </div>


    </form:form>
    </div>
</div>



<!-- @*Inline Plugin Script For Validation Purpose*@ -->

<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<!-- <script src="<%= session.getAttribute("COMMON_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>  -->
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.unobtrusive.js"></script>


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
</script>


<jsp:include page="../../GSTHome/Footer.jsp" />


