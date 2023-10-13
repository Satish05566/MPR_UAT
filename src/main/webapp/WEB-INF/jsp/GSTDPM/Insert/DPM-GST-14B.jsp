<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i>  DPM-GST-14B
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
    <form:form action="/MPR/GSTDPM/Insert/DPM_GST_14B" id="dpmGst14BCommTemp" name = "dpmGst14BCommTemp" method="POST"  modelAttribute="dpmGst14BCommTemp" >
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
               Reasons for deemed registration
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
                                <td>S.No.</td>
                                <td>Reasons For Deemed Registration</td>
                                <td>No. Of ARNs</td>
                       </tr>

                           <tr class="table-datarow-right">
                                <td class="table-datarow-center">1</td>
                                <td style="text-align: left;" >Received from other CPCs with only one working day left for action </td>
                                
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
                                    <form:input path="RECEIVED_FROM_OTHER_CPC" type="text"   align="right" name="RECEIVED_FROM_OTHER_CPC" id="RECEIVED_FROM_OTHER_CPC" class="form-control min-width-1" autocomplete="off" value= "${model.RECEIVED_FROM_OTHER_CPC}" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"    />
                                       <form:errors path="RECEIVED_FROM_OTHER_CPC" cssClass="error" />  
                                       
                                </td>
                               
                            </tr>
                           <tr class="table-datarow-right">
                                <td class="table-datarow-center">2</td>
                                <td style="text-align: left;" >PV Report Not Received</td>
                                <td>                                    
                                    <form:input path="PV_REPORT_NOT_RECEIVED" type="text"   align="right" name="PV_REPORT_NOT_RECEIVED" id="PV_REPORT_NOT_RECEIVED" class="form-control min-width-1" autocomplete="off" value= "${model.PV_REPORT_NOT_RECEIVED}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 " required = "true"    />
                                       <form:errors path="PV_REPORT_NOT_RECEIVED" cssClass="error" />                                        
                                </td>                               
                            </tr>
                          
                             <tr class="table-datarow-right">
                                <td class="table-datarow-center">3</td>
                                <td style="text-align: left;" >Officer Failed To Process The ARN</td>
                                <td>                                    
                                    <form:input path="OFFICER_FAILED_TO_PROCESS_ARN" type="text" align="right" name="OFFICER_FAILED_TO_PROCESS_ARN" id="OFFICER_FAILED_TO_PROCESS_ARN" class="form-control min-width-1" autocomplete="off" value= "${model.OFFICER_FAILED_TO_PROCESS_ARN}" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                                       <form:errors path="OFFICER_FAILED_TO_PROCESS_ARN" cssClass="error" />                                        
                                </td>                               
                            </tr>
                            
                               <tr class="table-datarow-right" >
                                <td class="table-datarow-center">4</td>
                                <td style="text-align: left;" >Others</td>
                                <td>                                    
                                    <form:input path="OTHERS" type="text"  align="right" name="OTHERS"
                                     id="OTHERS" class="form-control min-width-1" autocomplete="off" 
                                     value= "${model.OTHERS}" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                                       <form:errors path="OTHERS" cssClass="error" />                                        
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
                    <input type="hidden" name="button_error" id="button_error" value="${button}" />
                    <input name="btn_Cancel" id="btn_Cancel" class="btn btn-danger" type="reset" value="Cancel" />

                </div>
            </div>
            <!-- /.col-lg-6 -->

        </div>
    </div>


    </form:form>
    </div>
</div>


<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
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
        var button_error = $('#btn_error').val();
        if (button_name == "Upload") {
            $('#btn_Cancel').show();
        }
        else {
            $('#btn_Cancel').hide();
            //$('#btn_submit').val("Upload");
        }

    });
    
   
</script>


<jsp:include page="../../GSTHome/Footer.jsp" />


