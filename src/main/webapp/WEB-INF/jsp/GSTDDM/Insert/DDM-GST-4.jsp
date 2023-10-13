<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i> DDM-GST-4
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
    <form:form action="/MPR/GSTDDM/Insert/DDM_GST_4" id="DdmGst4CommTemp" name = "DdmGst4CommTemp" method="POST"  modelAttribute="DdmGst4CommTemp" >
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
                 <!-- Revenue From Top 25 Taxpayers (COMMISSIONERATE WISE) -->
                 REVENUE FROM TOP 20 GOODS
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
                
                        <div class="sub-lakh">Amount in Rs.Crores</div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">

									<tr class="text-center-capitalize table-header-center">
										<td rowspan="2" align="center">Action</td>
										<td rowspan="2" align="center">Sr. No.</td>
										<td rowspan="2" align="center">HSN CODE</td>
										<td rowspan="2" align="center">Description of Goods</td>
										<td rowspan="1" colspan="2" align="center">CURRENT F.Y.</td>
										<td rowspan="1" colspan="2" align="center">PREVIOUS F.Y.</td>
										<td rowspan="2" colspan="1" align="center">Reason for
											Increase/Decrease in Revenue</td>

									</tr>
									<tr class="text-center-capitalize table-header-center">
										<td rowspan="1" colspan="1" align="center" width="9%">
											FOR THE MONTH</td>
										<td rowspan="1" colspan="1" align="center" width="9%">
											UPTO THE MONTH</td>
										<td rowspan="1" colspan="1" align="center" width="9%">
											FOR THE MONTH</td>
										<td rowspan="1" colspan="1" align="center" width="9%"
											style="border: 1px solid #ddd";>UPTO THE MONTH</td>


									</tr>
								
                            <tr class="textcenter" id="tr_hidden">
										<th class="text-center"
											style="width: 65px; padding: 3px 9px; height: 27px; margin-top: 5px;">
											<input name="btn_submit" class="btn btn-success"
											id="btn_submit" type="submit" value="Update" />
										</th>
										<td class="text-center" id="td_SNO"></td>
										<!-- <td class="text-center" id="td_HSN_CODE"></td> -->
                                <%String TokenNo = (String) request.getSession().getAttribute("TokenNo");%>
                               
                                <td>
                               <!--  <input type="hidden" id="SNO" name="SNO"/> -->
                               <form:input path="SNO" type="hidden"
												name="SNO" id="SNO"
												placeholder="SNO NAME" class="form-control min-width-1"
												autocomplete="off" readonly="true" required="true" /> <form:errors
												path="SNO" cssClass="error" />
                                    <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                                    <form:input path="HSN_CODE" type="text"  name="HSN_CODE" id="HSN_CODE" placeholder="HSN CODE"
                                    class="form-control min-width-1" autocomplete="off" readonly="true" required = "true"  />
                                       <form:errors path="HSN_CODE" cssClass="error" />  
                                       
                                </td>
                                <td>
                                 <form:input path="DESC_OF_GOODS" type="text" name="DESC_OF_GOODS" id="DESC_OF_GOODS" placeholder="DESC OF GOODS"
                                 class="form-control min-width-1" autocomplete="off" readonly="true" required = "true"  />
                                       <form:errors path="DESC_OF_GOODS" cssClass="error" />  
                                       
                                </td>
                                <td>
                                 <form:input path="CUR_YEAR_FOR" type="text"  name="CUR_YEAR_FOR" id="CUR_YEAR_FOR" placeholder="CUR YEAR FOR"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="CUR_YEAR_FOR" cssClass="error" />                                         
                                </td>
                                 <td>
                                 <form:input path="CUR_YEAR_UPTO" type="text" name="CUR_YEAR_UPTO" id="CUR_YEAR_UPTO" placeholder="CUR YEAR UPTO"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                    <form:errors path="CUR_YEAR_UPTO" cssClass="error" />                                         
                                </td>
                                
                                <td>                             
									       	
                                 <form:input path="PRE_YEAR_FOR" type="text" name="PRE_YEAR_FOR" id="PRE_YEAR_FOR" placeholder="PRE YEAR FOR"
                                  class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="PRE_YEAR_FOR" cssClass="error" />                                         
                                </td >
                                
                                 <td>
                                 <form:input path="PRE_YEAR_UPTO" type="text" name="PRE_YEAR_UPTO" id="PRE_YEAR_UPTO" placeholder="PRE YEAR UPTO"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="PRE_YEAR_UPTO" cssClass="error" />                                         
                                </td>
                               
                                 <td>
                                     	
                                 <form:input path="REASONS" type="text"  name="REASONS" id="REASONS" placeholder="REASON_FOR_INCREASE_REVENUE"
                                  class="form-control min-width-1-left" autocomplete="off"  maxlength="100"  required = "true"/>
                                       <form:errors id="reason_error" path="REASONS" cssClass="error" />    
                                       <label id="lbl_REASONS"></label>
                                </td>
                            </tr>
                            
                            <% int i=0; %>
									<c:forEach items="${Model}" var="r">

										<tr class="table-datarow-right">
											<td class="table-datarow-center"><a
												class="btn btn-info"
												style="width: 65px; padding: 3px 9px; height: 27px; margin-top: 5px;"
												href="javascript: GetReport('<%= i+1 %>','${r.SNO}','${r.HSN_CODE}','${r.DESC_OF_GOODS}','${r.CUR_YEAR_FOR}','${r.CUR_YEAR_UPTO}','${r.PRE_YEAR_FOR}','${r.PRE_YEAR_UPTO}','${r.REASONS}');">Edit</a></td>
											<td class="table-datarow-center"><%=++i%></td>
											<td class="table-datarow-center">${r.HSN_CODE}</td>
											<th>${r.DESC_OF_GOODS}</th>
											<td>${r.CUR_YEAR_FOR}</td>
											<td>${r.CUR_YEAR_UPTO}</td>
											<td>${r.PRE_YEAR_FOR}</td>
											<td>${r.PRE_YEAR_UPTO}</td>
											<th style="overflow-wrap: anywhere;"><c:if
													test="${r.REASONS != 'null' && r.REASONS != null}">
	                                					${r.REASONS}
	                               					</c:if></th>

										</tr>
										<%--  <% i=i+1; %> --%>
									</c:forEach>

								</table>
                        <!-- /.table-responsive -->
                    </div>

                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
                <%-- <div align="center">                    
                    <input type="hidden" name="hndresult" id="hndresult" value="${ViewBagResult}" />
                </div> --%>
                <div align="center">
                         <input name="btn_error" class="btn btn-success" id="btn_error" type="hidden" value="${button}" />
                        <input type="hidden" name="hndresult" id="hndresult" value="${ViewBagResult}" />

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
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>

<script src="../../../Content-Common/js/jquery.js"></script>

<script language="javascript" type="text/javascript">
		function GetReport(_index,SNO,HSN_CODE, DESC_OF_GOODS, CUR_YEAR_FOR,CUR_YEAR_UPTO,PRE_YEAR_FOR,PRE_YEAR_UPTO,REASONS) {
			$('#tr_hidden').show();
			$('#td_SNO').html(_index);
            $('input[name="SNO"]').val(SNO);
            $('#td_HSN_CODE').html(HSN_CODE);
            $('input[name="HSN_CODE"]').val(HSN_CODE);
			$('input[name="DESC_OF_GOODS"]').val(DESC_OF_GOODS);
			$('input[name="CUR_YEAR_FOR"]').val(CUR_YEAR_FOR);
			$('input[name="CUR_YEAR_UPTO"]').val(CUR_YEAR_UPTO);
			$('input[name="PRE_YEAR_FOR"]').val(PRE_YEAR_FOR);
			$('input[name="PRE_YEAR_UPTO"]').val(PRE_YEAR_UPTO);
			$('input[name="REASONS"]').val(REASONS);
			$('input[name="btn_submit"]').val('Update');
			document.getElementById('reason_error').innerHTML='';
		}

		 $(document).on("keypress", "input[type='text']", function(e){
			 document.getElementById('reason_error').innerHTML='';
			 });
	</script>
<script type="text/javascript">

        $(document).ready(function () {
        	var button_name = $('#btn_error').val();
        	console.log(button_name)
            if (button_name == "Error") {
            	$('#tr_hidden').show();
            }
            else {
            	$('#tr_hidden').hide();
            }
        });
        
        $('#REASONS').bind('keypress', function (event) {
        	// debugger;
        	    var regex = new RegExp(/^[a-zA-Z0-9. ()/',-]+$/);
        	    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
        	            if (!regex.test(key)) {
        	               event.preventDefault();
        	               return true;
        	            }
        	    });

    </script>




<jsp:include page="../../GSTHome/Footer.jsp" />


