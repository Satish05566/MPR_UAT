<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-book fa-fw"></i>  GI-GST-1
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
    <form:form action="/MPR/GSTGI/Insert/GI_GST_1" id="giGst1CommTemp" name = "giGst1CommTemp" method="POST"  modelAttribute="giGst1CommTemp" >
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
                Detection & Realisation
            </div>
						<%
						   String strDate = (String) request.getAttribute("MM_YYYY");
					      	java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
					      	java.util.Date date = srcDtFormat.parse(strDate);
					      	java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
					      	String desDt = desDtFormat.format(date);
						 %> 

            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="panel panel-warning">
                     
                        <div class="panel-heading sub-month">
                              MONTH : <%= desDt.toUpperCase() %>
                
                        <div class="sub-lakh">Amount in Rs. Lakhs</div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">  
  
                          
            <tr class="table-header-center">
            <td rowspan="3" colspan="1"  widtd="10%">
                SI.NO
            </td>
            <td rowspan="3" colspan="1"  widtd="10%">
                ITEMS OF WORK
            </td>
            <td rowspan="3" colspan="2"  widtd="10%">
                TAX
            </td>
            <td colspan="2"  widtd="10%">
                CURRENT FINANCIAL YEAR
            </td>
            <td colspan="2"  widtd="14%">
                PREVIOUS FINANCIAL YEAR	
            </td>
            
        </tr>
        
        <tr class="table-header-center">
            
            <td rowspan="1" colspan="2" align="center">
                    FOR THE MONTH
            </td>                
                
            <td rowspan="1" colspan="2" align="center">
                FOR THE MONTH
            </td>
          </tr>
          <tr class="table-header-center">
            
            <td rowspan="1" colspan="1" align="center">
                    NO. OF CASES
            </td>
            <td rowspan="1" colspan="1" align="center">
                    AMOUNT
            </td>
            <td rowspan="1" colspan="1" align="center">
                 NO. OF CASES
            </td>
            <td rowspan="1" colspan="1" align="center">
                AMOUNT
            </td>
          </tr> 
          <%-- <c:if test="${!(empty model)}"> --%>
          <tr class="table-datarow-right">
            <%
               String TokenNo = (String) request.getSession().getAttribute("TokenNo");
               String MM_YYYY = (String) request.getAttribute("MM_YYYY");
               String CRR = (String) request.getAttribute("CRR");
                                
                                %>
                                
            <th   rowspan="4" class="table-datarow-center header-text-readonly">
                1
            </th>
            <th    rowspan="4" class="header-text-readonly">
                DETECTION
            </th>
            <th colspan="2" class="header-text-readonly">
                CGST
            </th>
            
            <td rowspan="4">
                 <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />
                 <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                 <input type="hidden" id="CRR" name="CRR" value="${CRR}" />
                 <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                 
                     <form:input path="DETECTION_CGST_NO" type="text" style="height:180px;"  name="DETECTION_CGST_NO" id="DETECTION_CGST_NO" class="form-control min-width-1" autocomplete="off" value= "${model.DETECTION_CGST_NO}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 "  />
					 <form:errors path="DETECTION_CGST_NO" cssClass="error" /> 
                     </td>
            <td >
                <form:input path="DETECTION_CGST_AMT" type="text"  name="DETECTION_CGST_AMT" id="DETECTION_CGST_AMT" class="form-control min-width-1" autocomplete="off" value= "${model.DETECTION_CGST_AMT}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="DETECTION_CGST_AMT" cssClass="error" /> 
            </td>
            <td rowspan="4">
                <form:input path="DETECTION_CGST_NO_PRE" type="text"   style="height:180px;" name="DETECTION_CGST_NO_PRE" id="DETECTION_CGST_NO_PRE" class="form-control min-width-1" autocomplete="off" value= "${model.DETECTION_CGST_NO_PRE}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 " />
				<form:errors path="DETECTION_CGST_NO_PRE" cssClass="error" /> 
            </td>
            <td>
                <form:input path="DETECTION_CGST_AMT_PRE" type="text"  name="DETECTION_CGST_AMT_PRE" id="DETECTION_CGST_AMT_PRE" class="form-control min-width-1" autocomplete="off" value= "${model.DETECTION_CGST_AMT_PRE}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="DETECTION_CGST_AMT_PRE" cssClass="error" /> 
            </td>
            </tr>
            
            <tr class="table-datarow-right">
            
            <th colspan="2" class="header-text-readonly">
                SGST/UTGST
            </th>
            
            <td>
                <form:input path="DETECTION_SGST_AMT" type="text"  name="DETECTION_SGST_AMT" id="DETECTION_SGST_AMT" class="form-control min-width-1" autocomplete="off" value= "${model.DETECTION_SGST_AMT}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="DETECTION_SGST_AMT" cssClass="error" /> 
            </td>
            
            <td>
                <form:input path="DETECTION_SGST_AMT_PRE" type="text"  name="DETECTION_SGST_AMT_PRE" id="DETECTION_SGST_AMT_PRE" class="form-control min-width-1" autocomplete="off" value= "${model.DETECTION_SGST_AMT_PRE}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="DETECTION_SGST_AMT_PRE" cssClass="error" /> 
            </td>
            </tr>
            
            <tr class="table-datarow-right">
            
            <th colspan="2" class="header-text-readonly">
                IGST
            </th>
            
            <td>
                <form:input path="DETECTION_IGST_AMT" type="text"  name="DETECTION_IGST_AMT" id="DETECTION_IGST_AMT" class="form-control min-width-1" autocomplete="off" value= "${model.DETECTION_IGST_AMT}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="DETECTION_IGST_AMT" cssClass="error" /> 
            </td>
            
            <td>
                <form:input path="DETECTION_IGST_AMT_PRE" type="text"  name="DETECTION_IGST_AMT_PRE" id="DETECTION_IGST_AMT_PRE" class="form-control min-width-1" autocomplete="off" value= "${model.DETECTION_IGST_AMT_PRE}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="DETECTION_IGST_AMT_PRE" cssClass="error" /> 
            </td>
            </tr>
            
            <tr class="table-datarow-right">
            
            <th colspan="2" class="header-text-readonly">
                CESS
            </th>
            
            <td>
                <form:input path="DETECTION_CESS_AMT" type="text"  name="DETECTION_CESS_AMT" id="DETECTION_CESS_AMT" class="form-control min-width-1" autocomplete="off" value= "${model.DETECTION_CESS_AMT}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="DETECTION_CESS_AMT" cssClass="error" /> 
            </td>
            
            <td>
                <form:input path="DETECTION_CESS_AMT_PRE" type="text"  name="DETECTION_CESS_AMT_PRE" id="DETECTION_CESS_AMT_PRE" class="form-control min-width-1" autocomplete="off" value= "${model.DETECTION_CESS_AMT_PRE}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="DETECTION_CESS_AMT_PRE" cssClass="error" /> 
            </td>
            </tr>
            
            <tr class="table-datarow-right">
            <th   rowspan="4" class="table-datarow-center header-text-readonly">
                2
            </th>
            <th rowspan="4" class="header-text-readonly">
                REALISATION
            </th>
            <th colspan="2" class="header-text-readonly">
                CGST
            </th>
            
            <td rowspan="4" class="table-datarow-center">
                <form:input path="REALISATION_CGST_NO" type="text"  style="height:180px;" name="REALISATION_CGST_NO" id="REALISATION_CGST_NO" class="form-control min-width-1" autocomplete="off" value= "${model.REALISATION_CGST_NO}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 "  />
				<form:errors path="REALISATION_CGST_NO" cssClass="error" /> 
             </td>
            <td>
                <form:input path="REALISATION_CGST_AMT" type="text"  name="REALISATION_CGST_AMT" id="REALISATION_CGST_AMT" class="form-control min-width-1" autocomplete="off" value= "${model.REALISATION_CGST_AMT}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="REALISATION_CGST_AMT" cssClass="error" /> 
            </td>
            <td rowspan="4" >
                <form:input path="REALISATION_CGST_NO_PRE" type="text"  style="height:180px;" name="REALISATION_CGST_NO_PRE" id="REALISATION_CGST_NO_PRE" class="form-control min-width-1" autocomplete="off" value= "${model.REALISATION_CGST_NO_PRE}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 "  />
				<form:errors path="REALISATION_CGST_NO_PRE" cssClass="error" /> 
            </td>
            <td>
                <form:input path="REALISATION_CGST_AMT_PRE" type="text"  name="REALISATION_CGST_AMT_PRE" id="REALISATION_CGST_AMT_PRE" class="form-control min-width-1" autocomplete="off" value= "${model.REALISATION_CGST_AMT_PRE}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="REALISATION_CGST_AMT_PRE" cssClass="error" /> 
            </td>
            </tr>
            
            <tr class="table-datarow-right">
            
            <th colspan="2" class="header-text-readonly">
                SGST/UTGST
            </th>
            
            <td>
                <form:input path="REALISATION_SGST_AMT" type="text"  name="REALISATION_SGST_AMT" id="REALISATION_SGST_AMT" class="form-control min-width-1" autocomplete="off" value= "${model.REALISATION_SGST_AMT}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="REALISATION_SGST_AMT" cssClass="error" /> 
            </td>
            
            <td>
                <form:input path="REALISATION_SGST_AMT_PRE" type="text"  name="REALISATION_SGST_AMT_PRE" id="REALISATION_SGST_AMT_PRE" class="form-control min-width-1" autocomplete="off" value= "${model.REALISATION_SGST_AMT_PRE}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="REALISATION_SGST_AMT_PRE" cssClass="error" /> 
            </td>
            </tr>
            
            <tr class="table-datarow-right">
            
            <th colspan="2" class="header-text-readonly">
                IGST
            </th>
            
            <td>
                <form:input path="REALISATION_IGST_AMT" type="text"  name="REALISATION_IGST_AMT" id="REALISATION_IGST_AMT" class="form-control min-width-1" autocomplete="off" value= "${model.REALISATION_IGST_AMT}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="REALISATION_IGST_AMT" cssClass="error" /> 
            </td>
            
            <td>
                <form:input path="REALISATION_IGST_AMT_PRE" type="text"  name="REALISATION_IGST_AMT_PRE" id="REALISATION_IGST_AMT_PRE" class="form-control min-width-1" autocomplete="off" value= "${model.REALISATION_IGST_AMT_PRE}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="REALISATION_IGST_AMT_PRE" cssClass="error" /> 
            </td>
            </tr>
            
            <tr class="table-datarow-right">
            
            <th colspan="2" class="header-text-readonly">
                CESS
            </th>
            
            <td>
                <form:input path="REALISATION_CESS_AMT" type="text"  name="REALISATION_CESS_AMT" id="REALISATION_CESS_AMT" class="form-control min-width-1" autocomplete="off" value= "${model.REALISATION_CESS_AMT}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="REALISATION_CESS_AMT" cssClass="error" /> 
            </td>
            
            <td>
                <form:input path="REALISATION_CESS_AMT_PRE" type="text"  name="REALISATION_CESS_AMT_PRE" id="REALISATION_CESS_AMT_PRE" class="form-control min-width-1" autocomplete="off" value= "${model.REALISATION_CESS_AMT_PRE}" required="true"  maxlength="18"  onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
				<form:errors path="REALISATION_CESS_AMT_PRE" cssClass="error" /> 
            </td>
            </tr>
            <%-- </c:if> --%>

                        </table> 

                        <!-- /.table-responsive -->
                    </div>

                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
                <%-- <c:if test="${!(empty model)}"> --%>
                <div align="center">
                    <input name="btn_submit" class="btn btn-success" id="btn_submit" type="submit" value="${ViewBag_button}" />
                    <input type="hidden" name="hndresult" id="hndresult" value="${ViewBagMessage}" />
                    <input name="btn_Cancel" id="btn_Cancel" class="btn btn-danger" type="reset" value="Cancel" />

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


