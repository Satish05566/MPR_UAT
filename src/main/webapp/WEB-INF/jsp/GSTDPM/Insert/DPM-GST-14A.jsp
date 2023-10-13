<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i>  DPM-GST-14A
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
    <form:form action="/MPR/GSTDPM/Insert/DPM_GST_14A" id="dpmGst14ACommTemp" name = "dpmGst14ACommTemp" method="POST"  modelAttribute="dpmGst14ACommTemp" >
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
               PENDENCY OF REGISTRATION APPLICATIONS
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
                
                        <div class="sub-lakh"></div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                        
                       <tr class="text-center-capitalize table-header-center" >
                                <td>ACTION</td>
                                <td>SR.No.</td>
                                <td>Opening Balance</td>
                                <td>No. of ARNs received during the month From GSTN</td>
                                <td>No. of ARNs received during the month From other CPCs/Zone</td>
                                <td>Disposal of ARNs Approved within 07 working days</td>
                                <td>Disposal of ARNs Recommended for Physical Verification</td>
                                <td>Disposal of ARNs Bifurcation of Action taken on the basis of Physical Verification Approved</td>
                                <td>Disposal of ARNs Bifurcation of Action taken on the basis of Physical Verification Rejected</td>
                                <td>Disposal of ARNs Physical Verification Report not Received</td>
                                <td>Disposal of ARNs Transferred to other CPCs/Zone</td>
                                <td>Disposal of ARNs Deemed Registration* (Reasons in REG-1B below)</td>
                                <td>Closing Balance</td>
                       </tr>
						 <%--  <c:if test="${not empty model}"> --%>
                           <tr class="text-center-capitalize">
                           <th class="text-center" style="width: 65px;padding: 3px 9px; height: 27px; margin-top: 5px;" >
                                <input name="btn_submit" class="btn btn-success" id="btn_submit" type="submit" value="${ViewBag_button}" /></th>
                                <th class="text-center">1</th>
                                
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
                                    
                                    <form:input path="OPENING_BALANCE" type="text"   align="right" name="OPENING_BALANCE" id="OPENING_BALANCE" class="form-control min-width-1" autocomplete="off" value= "${model.OPENING_BALANCE}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="OPENING_BALANCE" cssClass="error" />  
                        </td><td>
                                    <form:input path="NO_OF_ARN_RECEIVED_GSTN" type="text"   align="right" name="NO_OF_ARN_RECEIVED_GSTN" id="NO_OF_ARN_RECEIVED_GSTN" class="form-control min-width-1" autocomplete="off" value= "${model.NO_OF_ARN_RECEIVED_GSTN}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="NO_OF_ARN_RECEIVED_GSTN" cssClass="error" />                                        
                           </td>
                           <td>                                      
                                    <form:input path="NO_OF_ARN_RECEIVED_CPC" type="text"   align="right" name="NO_OF_ARN_RECEIVED_CPC" id="NO_OF_ARN_RECEIVED_CPC" class="form-control min-width-1" autocomplete="off" value= "${model.NO_OF_ARN_RECEIVED_CPC}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="NO_OF_ARN_RECEIVED_CPC" cssClass="error" />                                        
                            </td>
                           <td>                                  
                                    <form:input path="DISPOSAL_OF_ARN_WITHIN_7" type="text"   align="right" name="DISPOSAL_OF_ARN_WITHIN_7" id="DISPOSAL_OF_ARN_WITHIN_7" class="form-control min-width-1" autocomplete="off" value= "${model.DISPOSAL_OF_ARN_WITHIN_7}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="DISPOSAL_OF_ARN_WITHIN_7" cssClass="error" />                                        
                                </td>  
                                
                                <td>
                                    <form:input path="DISPOSAL_OF_ARN_PV_RECOMMENDED" type="text"   align="right" name="DISPOSAL_OF_ARN_PV_RECOMMENDED" id="DISPOSAL_OF_ARN_PV_RECOMMENDED" class="form-control min-width-1" autocomplete="off" value= "${model.DISPOSAL_OF_ARN_PV_RECOMMENDED}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="DISPOSAL_OF_ARN_PV_RECOMMENDED" cssClass="error" />                                        
                           </td>
                           <td>
                                    <form:input path="DISPOSAL_OF_ARN_PV_APPROVED" type="text"   align="right" name="DISPOSAL_OF_ARN_PV_APPROVED" id="DISPOSAL_OF_ARN_PV_APPROVED" class="form-control min-width-1" autocomplete="off" value= "${model.DISPOSAL_OF_ARN_PV_APPROVED}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="DISPOSAL_OF_ARN_PV_APPROVED" cssClass="error" />                                        
                           </td>
                           <td>
                                    <form:input path="DISPOSAL_OF_ARN_PV_REJECTED" type="text"   align="right" name="DISPOSAL_OF_ARN_PV_REJECTED" id="DISPOSAL_OF_ARN_PV_REJECTED" class="form-control min-width-1" autocomplete="off" value= "${model.DISPOSAL_OF_ARN_PV_REJECTED}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="DISPOSAL_OF_ARN_PV_REJECTED" cssClass="error" />                                        
                           </td>
                           <td>
                                    <form:input path="DISPOSAL_OF_ARN_PV_NOT_RECEIVED" type="text"   align="right" name="DISPOSAL_OF_ARN_PV_NOT_RECEIVED" id="DISPOSAL_OF_ARN_PV_NOT_RECEIVED" class="form-control min-width-1" autocomplete="off" value= "${model.DISPOSAL_OF_ARN_PV_NOT_RECEIVED}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="DISPOSAL_OF_ARN_PV_NOT_RECEIVED" cssClass="error" />                                        
                           </td>
                           <td>
                                    <form:input path="DISPOSAL_OF_ARN_TRANSFERED_CPC" type="text"   align="right" name="DISPOSAL_OF_ARN_TRANSFERED_CPC" id="DISPOSAL_OF_ARN_TRANSFERED_CPC" class="form-control min-width-1" autocomplete="off" value= "${model.DISPOSAL_OF_ARN_TRANSFERED_CPC}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="DISPOSAL_OF_ARN_TRANSFERED_CPC" cssClass="error" />                                        
                           </td>
                           <td>
                                    <form:input path="DISPOSAL_OF_ARN_DEEMED_REG" type="text"   align="right" name="DISPOSAL_OF_ARN_DEEMED_REG" id="DISPOSAL_OF_ARN_DEEMED_REG" class="form-control min-width-1" autocomplete="off" value= "${model.DISPOSAL_OF_ARN_DEEMED_REG}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="DISPOSAL_OF_ARN_DEEMED_REG" cssClass="error" />                                        
                           </td>
                           
                           
                            <td>
                                    <form:input path="CLOSING_BALANCE" type="text"   align="right" name="CLOSING_BALANCE" id="CLOSING_BALANCE" class="form-control min-width-1" autocomplete="off" value= "${model.CLOSING_BALANCE}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="CLOSING_BALANCE" cssClass="error" />                                        
                           </td>
                                                      
                            </tr>  
                            <%-- </c:if>  --%>                            
                        </table>


                        <!-- /.table-responsive -->
                    </div>

                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
                 
                    <input type="hidden" name="hndresult" id="hndresult" value="${ViewBagMessage}" />
                    <input type="hidden" name="btn_Cancel" id="btn_Cancel" class="btn btn-danger" type="reset" value="Cancel" />
                <div>
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


