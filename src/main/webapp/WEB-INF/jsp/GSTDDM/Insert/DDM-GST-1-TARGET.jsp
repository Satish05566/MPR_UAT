<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />
<div id="page-wrapper">
	<div class="row">
	              <div class="col-lg-6">
				<h4 class="page-header p-b-0 no-border">
					<i class="fa fa-book fa-fw"></i>  DDM-GST-1-TARGET
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
	<form:form action="/MPR/GSTDDM/Insert/DDM_GST_1_TARGET" id="ddmGST1Target" name = "ddmGST1Target" method="POST"  modelAttribute="ddmGST1CommTarget" >
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
                    DDM-GST-1-TARGET
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
			                         <td>Sr. No.</td>
			                         <td>DESCRIPTION</td>
			                         <td>CGST</td>
			                         <td>STATE/UT GST</td>
			                         <td>IGST</td>
			                         <td>CESS</td>
		                        </tr>   
                                <tbody>
                                    <tr>
                                        <th class="text-center">1</th>
                                        <th>TARGET FOR FINANCIAL YEAR </th>
                                        <td>
                                            <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="" />
                                            <input type="hidden" id="MM_YYYY" name="MM_YYYY" class="form-control min-width-1"  value='${MM_YYYY}' />
                                           <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                                          
                                          <form:input path="TARGET_CGST" type="text"  name="TARGET_CGST" id="TARGET_CGST" class="form-control min-width-1" autocomplete="off" value= "${model.TARGET_CGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									        <form:errors path="TARGET_CGST" cssClass="error" />
                                        </td>
                                        <td>
                                            <form:input path="TARGET_SGST" type="text"  name="TARGET_SGST" id="TARGET_SGST" class="form-control min-width-1" autocomplete="off" value= "${model.TARGET_SGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									        <form:errors path="TARGET_SGST" cssClass="error" />
                                        </td>
                                        <td>
                                        	<form:input path="TARGET_IGST" type="text"  name="TARGET_IGST" id="TARGET_IGST" class="form-control min-width-1" autocomplete="off" value= "${model.TARGET_IGST}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									        <form:errors path="TARGET_IGST" cssClass="error" />
                                        
                                        </td>
                                        <td>
                                        	<form:input path="TARGET_CESS" type="text"  name="TARGET_CESS" id="TARGET_CESS" class="form-control min-width-1" autocomplete="off" value= "${model.TARGET_CESS}" required = "true" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"  />
									        <form:errors path="TARGET_CESS" cssClass="error" />
                                        
                                        </td>  
                                        
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->

                    </div>

                    <!-- /.panel-body -->
                    <div align="center">
                        <input name="btn_submit" type="submit" id="btn_submit" value="${button}" class="btn btn-success" />
                        <input type="hidden" name="hndresult" id="hndresult" value="${Message}" />
                    </div>
                </div>
                <!-- /.panel -->

            </div>
            <!-- /.col-lg-6 -->

        </div>
    </form:form>
    </div>
</div>


<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script src="<%= session.getAttribute("COMMON_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.unobtrusive.js"></script>

<script>
    $(document).ready(function () {

        if ($("#hndresult").val() == "Record Updated") {
            $("#btn_submit").hide();
            $("#div_msg").hide();

        }
        else {
            $("#btn_submit").show();
        }

    });
</script>
<jsp:include page="../../GSTHome/Footer.jsp" />

