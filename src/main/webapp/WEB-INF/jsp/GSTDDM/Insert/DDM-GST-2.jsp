<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i>  DDM-GST-2
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
    <form:form action="/MPR/GSTDDM/Insert/DDM_GST_2" id="ddmGst2CommTemp" name = "ddmGst2CommTemp" method="POST"  modelAttribute="ddmGst2CommTemp" >
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
               ADDITIONAL REVENUE MOBILISATION-STREAM
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
                
                        <div class="sub-lakh">Amount in Rs Crores</div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                        
                        <tr class="table-header-center">
                                <td style="width:10%;">Sr. No.</td>
                                <td style="width:60%;">ITEMS OF ARM (ADDITIONAL REVENUE MOBILISATION)</td>
                                <td style="width:30%;">RECOVERY DETAILS (CURRENT F.Y.) FOR THE MONTH</td>
                       </tr>

                            <tr>
                                <th class="text-center">1</th>
                                <th>AUDIT RECOVERY</th>
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
                                    <form:input path="AUDIT_RECOVERY" type="text"  name="AUDIT_RECOVERY" id="AUDIT_RECOVERY" class="form-control min-width-1" 
                                    autocomplete="off" value= "${model.AUDIT_RECOVERY}"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="AUDIT_RECOVERY" cssClass="error" />  
                                       
                                </td>
                               
                            </tr>
                            <tr>
                                <th class="text-center">2</th>
                                <th>ANTI-EVASION RECOVERY INCLUDING TRANSIT CHECKS</th>
                                <td>                                    
                                    <form:input path="ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS" type="text"  name="ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS" id="ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS" class="form-control min-width-1" autocomplete="off" value= "${model.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS" cssClass="error" />                                        
                                </td>                               
                            </tr>
                          
                              <tr>
                                <th class="text-center">3</th>
                                <th>RECOVERY OF CONFIRMED DEMANDS</th>
                                <td>                                    
                                    <form:input path="RECOVERY_OF_CONFIRMED_DEMANDS" type="text"  name="RECOVERY_OF_CONFIRMED_DEMANDS" id="RECOVERY_OF_CONFIRMED_DEMANDS" class="form-control min-width-1" autocomplete="off" value= "${model.RECOVERY_OF_CONFIRMED_DEMANDS}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="RECOVERY_OF_CONFIRMED_DEMANDS" cssClass="error" />                                        
                                </td>                               
                            </tr>
                            
                                <tr>
                                <th class="text-center">4</th>
                                <th>PRE-DEPOSITS</th>
                                <td>                                    
                                    <form:input path="PRE_DEPOSITS" type="text"  name="PRE_DEPOSITS" id="PRE_DEPOSITS" class="form-control min-width-1" autocomplete="off" value= "${model.PRE_DEPOSITS}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="PRE_DEPOSITS" cssClass="error" />                                        
                                </td>                               
                            </tr>
                            
                                <tr>
                                <th class="text-center">5</th>
                                <th>SCRUTINY OF GST RETURNS</th>
                                <td>                                    
                                    <form:input path="SCRUTINY_OF_GST_RETURNS" type="text"  name="SCRUTINY_OF_GST_RETURNS" id="SCRUTINY_OF_GST_RETURNS" class="form-control min-width-1" autocomplete="off" value= "${model.SCRUTINY_OF_GST_RETURNS}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="SCRUTINY_OF_GST_RETURNS" cssClass="error" />                                        
                                </td>                               
                            </tr>
                            
                                <tr>
                                <th class="text-center">6</th>
                                <th>RECOVERY FROM DEFAULTERS (late filers/non-filers etc.)</th>
                                <td>                                    
                                    <form:input path="RECOVERY_FROM_DEFAULTERS" type="text"  name="RECOVERY_FROM_DEFAULTERS" id="RECOVERY_FROM_DEFAULTERS" class="form-control min-width-1" autocomplete="off" value= "${model.RECOVERY_FROM_DEFAULTERS}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="RECOVERY_FROM_DEFAULTERS" cssClass="error" />                                        
                                </td>                               
                            </tr>
                            
                                <tr>
                                <th class="text-center">7</th>
                                <th>FINALISATION OF PROVISIONAL ASSESSMENTS</th>
                                <td>                                    
                                    <form:input path="FINALISATION_OF_PROVISIONAL_ASSESSMENTS" type="text"  name="FINALISATION_OF_PROVISIONAL_ASSESSMENTS" id="FINALISATION_OF_PROVISIONAL_ASSESSMENTS" class="form-control min-width-1" autocomplete="off" value= "${model.FINALISATION_OF_PROVISIONAL_ASSESSMENTS}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="FINALISATION_OF_PROVISIONAL_ASSESSMENTS" cssClass="error" />                                        
                                </td>                               
                            </tr>
                            
                                <tr>
                                <th class="text-center">8</th>
                                <th>
                                <p> 
                                <span style="margin-top: 5px;float: left;">OTHERS (SPECIFY) <span class="error">*</span></span> 
                                
                                <form:input path="OTHERS_NAME" type="text"  name="OTHERS_NAME" id="OTHERS_NAME" class="form-control min-width-1-left" 
                                autocomplete="off" value= "${model.OTHERS_NAME}" required = "true"
                                style="width: 47%;margin-left: 4%;float: left;"  />
                                <form:errors path="OTHERS_NAME" cssClass="error" />     
                                
                                
                                <%-- <form:select path="OTHERS_NAME" class="form-control min-width-1" name="OTHERS_NAME" id="OTHERS_NAME" >
                                 	
                                 	  <c:forEach var="var" items="${othersList}">
                                 	  <c:choose>
								        <c:when test="${var.OTHERS_VALUE == model.OTHERS_NAME}">
								            <option selected="true" value="${var.OTHERS}">${var.OTHERS_VALUE}</option>
								        </c:when>
								        <c:otherwise>
								            <option value="${var.OTHERS}">${var.OTHERS_VALUE}</option>
								        </c:otherwise>
								        </c:choose>
								        </c:forEach>
								    
                                </form:select> --%>
                                </p>
                                </th>
                                <td>                                    
                                    <form:input path="OTHERS_VALUE" type="text"  name="OTHERS_VALUE" id="OTHERS_VALUE" class="form-control min-width-1" autocomplete="off" value= "${model.OTHERS_VALUE}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="OTHERS_VALUE" cssClass="error" />                                        
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
    
    $('#OTHERS_NAME').bind('keypress', function (event) {
		 //debugger;
		    var regex = new RegExp(/^[a-zA-Z0-9. ()/',-]+$/);
		    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
		            if (!regex.test(key)) {
		               event.preventDefault();
		               return true;
		            }
		    });
</script>


<jsp:include page="../../GSTHome/Footer.jsp" />


