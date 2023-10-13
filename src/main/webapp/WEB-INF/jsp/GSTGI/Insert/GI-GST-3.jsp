<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<style>
.input-validation-error
{
    border: 1px solid #ff0000 !important;
}
</style>

<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i>  GI-GST-3 
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
    <form:form action="/MPR/GSTGI/Insert/GI_GST_3" id="giGst3CommTemp" name = "giGst3CommTemp" method="POST"  modelAttribute="giGst3CommTemp" >
     <c:choose>
       <c:when test= "${ViewBagMessage!=null || ViewBagMessage.length() ==0}"> 
        <div class="col-lg-12">
        <div class="alert-success" id="login_success">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            ${ViewBagMessage}
        </div>
     </div> 
    </c:when>
    
    <c:when test= "${ViewBagMessage_error!=null || ViewBagMessage_error.length() ==0}"> 
        <div class="col-lg-12">
        <div class="alert" id="login_error">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            ${ViewBagMessage_error}
        </div>
     </div> 
    </c:when>
    
    </c:choose>

    <div class="col-lg-12">
        <div class="panel panel-danger">
            <div class="panel-heading text-capitalize">
               STATUS OF REWARD SANCTIONED/ DISBURSED
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
                
                        <div class="sub-lakh">Amount: Rs. in Lakhs</div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                        
                        <tr class="table-header-center text-center-capitalize">
                                <td rowspan="3" style="width:2%;" >S.No.</td>
                                <td rowspan="3" style="width:20%;">Description</td>
                                <td rowspan="3" style="width:20%;">Reward Recipient</td>
                                <td style="width:30%;" colspan="2">Reward fund allocated in the Current Financial Year </td>
                       </tr>
                       <tr class="table-header-center">
                           <td colspan="2">DURING THE MONTH</td>
                       </tr>
                       
                        <tr class="table-header-center">
                           <td>NO. OF CASES</td>
                           <td>AMOUNT</td>
                       </tr>

                       <tr>
                                <th  rowspan="2" class="table-datarow-center header-text-readonly">1</th>
                                <th rowspan="2" class="header-text-readonly">Cases ripe for sanction of reward</th>
                                
                                <%   
                                String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                String MM_YYYY = (String) request.getAttribute("MM_YYYY");
                                String CRR = (String) request.getAttribute("CRR");
                                %>
                                <th class="header-text-readonly">Departmental Officer</th>
                                <td>
                                    <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="CRR" name="CRR" value="${CRR}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                                    
                                   <form:input path="REWARD_DEPARTMENTAL_NO" type="text" placeholder="0" name="REWARD_DEPARTMENTAL_NO" id="REWARD_DEPARTMENTAL_NO" class="form-control min-width-1" 
                                    autocomplete="off" value= "${model.REWARD_DEPARTMENTAL_NO}" maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                                       <form:errors path="REWARD_DEPARTMENTAL_NO" cssClass="error" /> 
                                       
                                       
                                </td>
                                 <td>                                    
                                    <form:input path="REWARD_DEPARTMENTAL_AMT" type="text" placeholder="0.00" name="REWARD_DEPARTMENTAL_AMT" id="REWARD_DEPARTMENTAL_AMT" class="form-control min-width-1" autocomplete="off" 
                                    value= "${model.REWARD_DEPARTMENTAL_AMT}" maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="REWARD_DEPARTMENTAL_AMT" cssClass="error" />                                           
                                </td>   
                           </tr>
                            
                            
                           <tr>
                               
                                <th class="header-text-readonly">Informer</th>
                                <td>
                                   <form:input path="REWARD_INFORMER_NO" type="text" placeholder="0" name="REWARD_INFORMER_NO" id="REWARD_INFORMER_NO" class="form-control min-width-1" 
                                    autocomplete="off" value= "${model.REWARD_INFORMER_NO}" maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                                       <form:errors path="REWARD_INFORMER_NO" cssClass="error" />  
                                       
                                </td>
                                 <td>                                    
                                    <form:input path="REWARD_INFORMER_AMT" type="text" placeholder="0.00" name="REWARD_INFORMER_AMT" id="REWARD_INFORMER_AMT" class="form-control min-width-1" autocomplete="off" 
                                    value= "${model.REWARD_INFORMER_AMT}" maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="REWARD_INFORMER_AMT" cssClass="error" />                                        
                                </td>   
                                 
                            </tr>                            
                                                        
                     <tr>
                                <th  rowspan="2"class="table-datarow-center header-text-readonly">2</th>
                                <th rowspan="2" class="header-text-readonly">Reward sanctioned and disbursed</th>
                                                              
                                <th class="header-text-readonly">Departmental Officer</th>
                                <td>
                                    <form:input path="DISBURSED_DEPARTMENTAL_NO" type="text" placeholder="0" name="DISBURSED_DEPARTMENTAL_NO" id="DISBURSED_DEPARTMENTAL_NO" class="form-control min-width-1" 
                                    autocomplete="off" value= "${model.DISBURSED_DEPARTMENTAL_NO}"  maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                                       <form:errors path="DISBURSED_DEPARTMENTAL_NO" cssClass="error" />  
                                       
                                </td>
                                 <td>                                    
                                    <form:input path="DISBURSED_DEPARTMENTAL_AMT" type="text" placeholder="0.00" name="DISBURSED_DEPARTMENTAL_AMT" id="DISBURSED_DEPARTMENTAL_AMT" class="form-control min-width-1" 
                                    autocomplete="off" value= "${model.DISBURSED_DEPARTMENTAL_AMT}"  maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="DISBURSED_DEPARTMENTAL_AMT" cssClass="error" />                                        
                                </td>   
                            </tr>
                            
                           <tr>
                               
                                <th class="header-text-readonly">Informer</th>
                                <td>
                                   <form:input path="DISBURSED_INFORMER_NO" type="text" placeholder="0" name="DISBURSED_INFORMER_NO" id="DISBURSED_INFORMER_NO" class="form-control min-width-1" 
                                    autocomplete="off" value= "${model.DISBURSED_INFORMER_NO}"  maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                                       <form:errors path="DISBURSED_INFORMER_NO" cssClass="error" />  
                                       
                                </td>
                                 <td>                                    
                                    <form:input path="DISBURSED_INFORMER_AMT" type="text" name="DISBURSED_INFORMER_AMT" id="DISBURSED_INFORMER_AMT" class="form-control min-width-1" autocomplete="off" placeholder="0.00"
                                    value= "${model.DISBURSED_INFORMER_AMT}"  maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="DISBURSED_INFORMER_AMT" cssClass="error" />                                        
                                </td>   
                                
                            </tr>                            
                      
                      <tr>
                                <th  rowspan="2" class="table-datarow-center header-text-readonly">3</th>
                                <th rowspan="2" class="header-text-readonly">Reward sanctioned but pending for disbursal </th>
                                                              
                                <th class="header-text-readonly">Departmental Officer</th>
                                <td>
                                    <form:input path="PENDING_DEPARTMENTAL_NO" type="text" placeholder="0" name="PENDING_DEPARTMENTAL_NO" id="PENDING_DEPARTMENTAL_NO" class="form-control min-width-1" 
                                    autocomplete="off" value= "${model.PENDING_DEPARTMENTAL_NO}"  maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                                       <form:errors path="PENDING_DEPARTMENTAL_NO" cssClass="error" />  
                                       
                                </td>
                                 <td>                                    
                                    <form:input path="PENDING_DEPARTMENTAL_AMT" placeholder="0.00" type="text" name="PENDING_DEPARTMENTAL_AMT" id="PENDING_DEPARTMENTAL_AMT" class="form-control min-width-1" autocomplete="off" 
                                    value= "${model.PENDING_DEPARTMENTAL_AMT}"  maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required="true"  />
                                   
                                      <form:errors path="PENDING_DEPARTMENTAL_AMT" cssClass="error" />                                      
                                </td> 
                            </tr>
                            
                            
                           <tr>
                               
                                <th class="header-text-readonly">Informer</th>
                                <td>
                                   <form:input path="PENDING_INFORMER_NO" type="text"  name="PENDING_INFORMER_NO" id="PENDING_INFORMER_NO" class="form-control min-width-1" placeholder="0"
                                    autocomplete="off" value= "${model.PENDING_INFORMER_NO}" maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                                       <form:errors path="PENDING_INFORMER_NO" cssClass="error" />  
                                       
                                </td>
                                 <td>                                    
                                    <form:input path="PENDING_INFORMER_AMT" type="text" placeholder="0.00" name="PENDING_INFORMER_AMT" id="PENDING_INFORMER_AMT" class="form-control min-width-1" autocomplete="off" 
                                    value= "${model.PENDING_INFORMER_AMT}"  maxlength="18"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="PENDING_INFORMER_AMT" cssClass="error" />                                        
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
                    <input name="btn_Cancel" id="btn_Cancel" class="btn btn-danger" onclick="location.href='/GSTGI/Insert/GI_GST_3/<%=TokenNo%>';" type="reset" value="Cancel" />

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

<%-- <script
	src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script
	src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>
<script src="../../../Content-Common/js/jquery.js"></script> --%>


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
            $(this).val(val); 
        });
        
        function clicked() {
        	  if (confirm('You just clicked the button, click ok or cancel to refresh.')) {
        	    yourformelement.submit();
        	    location.reload();
        	  } else {
        	    return false;
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
    
    $(document).on("keyup", function(e) {
    	for (let element of document.getElementsByClassName("error")){
    		
    		element.style.display="none";
    		}
	});
    
    $('#OTHERS_NAME').bind('keypress', function (event) {
		 //debugger;
		    var regex = new RegExp(/^[a-zA-Z0-9. ()/,-]+$/);
		    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
		            if (!regex.test(key)) {
		               event.preventDefault();
		               return true;
		            }
		    });
</script>


<jsp:include page="../../GSTHome/Footer.jsp" />


