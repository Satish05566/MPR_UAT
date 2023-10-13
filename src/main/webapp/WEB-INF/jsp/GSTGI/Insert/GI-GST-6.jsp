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
                <i class="fa fa-book fa-fw"></i>GI-GST-6
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
     
      <%   
                                String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                String MM_YYYY = (String) request.getAttribute("MM_YYYY");
                                String CRR = (String) request.getAttribute("CRR");
                                %>
                                
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
        <div class="alert-danger" id="alert_error">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            ${ViewBagMessage_error}
        </div>
     </div> 
    </c:when>
    
    </c:choose>
   

    <div class="col-lg-12">
        <div class="panel panel-danger">
            <div class="panel-heading text-capitalize">
               Tax Evasion prone Goods And Services
                <a style="margin-left: 65%;" onclick="addNewData();" class="btn btn-success" href="javascript:void(0)">Add New</a>
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
                                <td rowspan="3" style="width:2%;">S.No.</td>
                                <td rowspan="3" style="width:40%;">CATEGORY WISE TOP TAX EVASION PRONE GOODS AND SERVICES </td>
                                <td rowspan="3" >HSN/SAC CODE </td>
                                <td style="width:25%;" colspan="2">CURRENT FINANCIAL YEAR </td>
                                <td style="width:25%;" colspan="2">PREVIOUS FINANCIAL YEAR </td>
                       </tr>
                       <tr class="table-header-center">
                           <td colspan="2">FOR THE MONTH </td>
                           <td colspan="2">FOR THE MONTH </td>
                           
                       </tr>
                       
                        <tr class="table-header-center">
                           <td>NO. OF CASES </td>
                           <td>AMOUNT OF TAX EVASION</td>
                           
                           <td>NO. OF CASES </td>
                           <td>AMOUNT OF TAX EVASION</td>
                         
                       </tr>
                       
                       <% int i=0; %>
                     <c:forEach items="${model}" var="r"> 
                     <tr>
                     
                      <th class="table-datarow-center"> <%= i+1 %></th>
                      <th>
                     		<label >
                                <a href="#" onclick="getData('${r.HSN_SAC_CODE}','${r.GOODS_OR_SERVICES_TYPE}','${r.NO_OF_CASES}','${r.AMOUNT_OF_TAX_EVASION}','${r.NO_OF_CASES_PRE}','${r.AMOUNT_OF_TAX_EVASION_PRE}');">  ${r.HSN_SAC_CODE_DESCRIPTION} </a>   </label>
                                                   
                     </th>
                      <th class="table-datarow-center">
                     		<label>${r.HSN_SAC_CODE }</label>
                     
                     </th>
                      
                                                              
                      <td class="table-datarow-center">
                                   
                            <label > ${r.NO_OF_CASES} </label>
                                       
                       </td>
                       <td class="table-datarow-center">                                    
                             <label>${r.AMOUNT_OF_TAX_EVASION}</label>
                        </td> 
                        
                         <td class="table-datarow-center">
                                   
                            <label>${r.NO_OF_CASES_PRE}</label>
                                       
                       </td>
                       <td class="table-datarow-center">                                    
                             <label>${r.AMOUNT_OF_TAX_EVASION_PRE}</label>
                        </td> 
                        </tr>
                     <% i=i+1; %>
                   </c:forEach>
             
                 </table>


                        <!-- /.table-responsive -->
                    </div>

                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
                <div align="center">
                   <%--  <input name="btn_submit" class="btn btn-success" id="btn_submit" type="submit" value="${ViewBag_button}" /> --%>
                    <input type="hidden" name="hndresult" id="hndresult" value="${ViewBagMessage}" />
                  
                </div>
            </div>
            <!-- /.col-lg-6 -->

        </div>
    </div>
   
    </div>
</div>


<!-- Model Popup -->

<form action="/MPR/GSTGI/Insert/GI_GST_6" id="giGst6CommTemp" name="giGst6CommTemp" autocomplete="off" method="post"  modelAttribute="giGst6CommTemp">
    <div class="modal fade" id="Modal2" tabindex="-1" role="dialog"
        aria-labelledby="exampleModalLabel" aria-hidden="true">
        
        <div class="modal-dialog modal-lg" role="document" style="width: 95%;margin-left: 2.5%;">
            <div class="modal-content">
                <div class="modal-header"
                    style="background-color: #f2dede; color: #a94442; ">
                    <h5 class="modal-title" id="exampleModalLabel">
                        Tax Evasion Prone Goods And Services 
                    </h5>
                    <button type="button" class="close" style="margin-top:-23px;opacity: inherit;color: #c9302c;" 
                        data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div> 

                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                          
                          <tr class="table-header-center text-center-capitalize">
                                  <td rowspan="2" style="width:2%;">S.No.</td>
                                  <td rowspan="2" >CATEGORY WISE TOP TAX EVASION PRONE GOODS AND SERVICES</td>  	
                                  <td rowspan="2" >HSN/SAC CODE</td>
                                  <td colspan="2">CURRENT FINANCIAL YEAR</td>
                                  <td colspan="2">PREVIOUS FINANCIAL YEAR</td>
                                  
                         </tr>
                         <tr class="table-header-center">
                         
                        			<input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" /> 
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="CRR" name="CRR" value="${CRR}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                                    
                         
                             <td>NO. OF CASES</td>
                             <td>AMOUNT OF TAX EVASION</td>
                             <td>NO. OF CASES </td>
                             <td>AMOUNT OF TAX EVASION</td>
                                                      
                         </tr>
                
                          <tr>
                                 
                                  <th class="text-center header-text-readonly">1</th>
                                  <th class="header-text-readonly">
                                    <select class="form-control" id="ddlPopupCategoryLst">
                                        <!-- <option value="1">Appeals filed by the department on the same issue</option>
                                        <option value="2">Injunction issued by the Courts</option>
                                        <option value="3">C&AG Audit objections contested</option>
                                        <option value="4">Board's specific direction to keep the cases in CASES PENDING UNDER SECTION 75(11) OF CGST ACT/Others</option> -->
                                    </select>
                                  </th>
                                 
                                  <th class="header-text-readonly">  
                                  
                                  <label id="lblHSNCODE"></label>
                                  
                                  	<input  type="hidden" id="HSN_SAC_CODE" name="HSN_SAC_CODE" /> 
                                  	<input type="hidden" id="GOODS_OR_SERVICES_TYPE" name="GOODS_OR_SERVICES_TYPE" /> 
                                  	
                                  </th>
                                 
                                  <td>
                                     
                                      <input path="NO_OF_CASES" type="text" maxlength="18"  placeholder="0" name="NO_OF_CASES" id="NO_OF_CASES" class="form-control min-width-90 pop-main-NO_OF_CASES"
                                      autocomplete="off" value= ""
                                      onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                         <form:errors path="NO_OF_CASES" cssClass="error" /> 
                                         
                                  </td>
                                   <td>                                    
                                     <input path="AMOUNT_OF_TAX_EVASION" type="text" maxlength="18" placeholder="0.00" name="AMOUNT_OF_TAX_EVASION" id="AMOUNT_OF_TAX_EVASION" class="form-control min-width-90 pop-main-AMOUNT_OF_TAX_EVASION" autocomplete="off" 
                                      value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                         <form:errors path="AMOUNT_OF_TAX_EVASION" cssClass="error" />                                  
                                  </td> 
                                  
                                  <td>
                                      <input path="NO_OF_CASES_PRE" type="text" maxlength="18" placeholder="0" name="NO_OF_CASES_PRE" id="NO_OF_CASES_PRE" class="form-control min-width-90" 
                                      autocomplete="off" value= ""
                                      onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                         <form:errors path="NO_OF_CASES_PRE" cssClass="error" /> 
                                         
                                  </td>
                                   <td>                                    
                                     <input path="AMOUNT_OF_TAX_EVASION_PRE" type="text"  maxlength="18" placeholder="0.00" name="AMOUNT_OF_TAX_EVASION_PRE" id="AMOUNT_OF_TAX_EVASION_PRE" class="form-control min-width-90" autocomplete="off" 
                                      value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                         <form:errors path="AMOUNT_OF_TAX_EVASION_PRE" cssClass="error" />                                  
                                  </td>  
                                  
                                                                   
                             </tr>

                                                     
                     </table>
  
                    
              </div>

                <div class="modal-footer">
                    <!-- <button type="button" class="btn btn-danger" data-dismiss="modal" style="margin-right:10px;"
                        id="cancel_button">Close</button> -->
                    <input type="submit" name="btn_submit" class="btn btn-success"
                        value="Upload" id="btn_submit" /> 

                </div>
        </div>
    </div>
</form>



<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
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

        $("#giGst6CommTemp").validate({
   	     rules: {
   	    	lbl_IRON_AMT: "required",

   	     },
   	     messages: {
   	    	lbl_IRON_AMT: "* Required",
   	    	 
   	     }
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
        
        GetCategoryLst();

    });
    
    $(document).on("keyup", function(e) {
    	for (let element of document.getElementsByClassName("error")){
    		
    		element.style.display="none";
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
    
    
    
    
    function addNewData() {
    	
    	$('#ddlPopupCategoryLst').val('');
    	$('#NO_OF_CASES').val('');
    	$('#AMOUNT_OF_TAX_EVASION').val('');
    	$('#NO_OF_CASES_PRE').val('');
    	$('#AMOUNT_OF_TAX_EVASION_PRE').val('');
		
		$('#Modal2').modal({
            show: true,
            backdrop: false,
            keyboard: false
        });
		$('#ddlPopupCategoryLst').attr('disabled',false);
		$('#btn_submit').val('Upload');
	}
    
    
    function GetCategoryLst() {
        
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTGI/CategoryListBind/";
		
        $.ajax({
            url: url,
            data: {},
            cache: false,
            type: "GET",
            success: function (data) {
            	
                var data=JSON.parse(data.JSONdata);
         
                var markup="";
                markup+="<option value=''>Choose Category </option>";
                for (var x = 0; x < data.length; x++) {
                    if(data[x].HSN_SAC_CODE=='G'||data[x].HSN_SAC_CODE=='S')
                    markup += "<option disabled='true' style='background-color: lightgrey;font-weight: bold;' value='" + data[x].HSN_SAC_CODE + "' data-code="+data[x].HSN_SAC_CODE+ " data-type="+data[x].TYPE+">" + data[x].HSN_SAC_CODE_DESCRIPTION + "</option>";
                    else
                    	markup += "<option value='" + data[x].HSN_SAC_CODE + "' data-code="+data[x].HSN_SAC_CODE+ " data-type="+data[x].TYPE+">" + data[x].HSN_SAC_CODE_DESCRIPTION + "</option>";
                    
                }
                $("#ddlPopupCategoryLst").html(markup);
            },
            error: function (reponse) {
                //alert("error : " + reponse);
            }
        });
    }
    
    $('#ddlPopupCategoryLst').change(function(){
        if($('#ddlPopupCategoryLst').val()!='')
            {
                //alert($(this).find(':selected').data('code'));
                $("#lblHSNCODE").text($(this).find(':selected').data('code'));
                $("#HSN_SAC_CODE").val($(this).find(':selected').data('code'));
                $("#GOODS_OR_SERVICES_TYPE").val($(this).find(':selected').data('type'));
                
            }
    });
    
  
    
    function getData(HSN_SAC_CODE,GOODS_OR_SERVICES_TYPE,NO_OF_CASES,AMOUNT_OF_TAX_EVASION,NO_OF_CASES_PRE,AMOUNT_OF_TAX_EVASION_PRE)
    {
    	$('#Modal2').modal({
            show: true,
            backdrop: false,
            keyboard: false
        });
    	
    	$("#ddlPopupCategoryLst").val(HSN_SAC_CODE);
    	$("#HSN_SAC_CODE").val(HSN_SAC_CODE);
    	$("#GOODS_OR_SERVICES_TYPE").val(GOODS_OR_SERVICES_TYPE);
    	$("#lblHSNCODE").text(HSN_SAC_CODE);
    	$("#NO_OF_CASES").val(NO_OF_CASES);
    	$("#AMOUNT_OF_TAX_EVASION").val(AMOUNT_OF_TAX_EVASION);
    	$("#NO_OF_CASES_PRE").val(NO_OF_CASES_PRE);
    	$("#AMOUNT_OF_TAX_EVASION_PRE").val(AMOUNT_OF_TAX_EVASION_PRE);
    	
    	$('#ddlPopupCategoryLst').attr('disabled',true);
    	$("#btn_submit").val("Update");
    	
    }
</script>


<jsp:include page="../../GSTHome/Footer.jsp" />




