<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />



<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i> DDM-GST-3
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
    <form:form action="/MPR/GSTDDM/Insert/DDM_GST_3" id="ddmGst3CommTemp" name = "ddmGst3CommTemp" method="POST"  modelAttribute="ddmGst3CommTemp" >
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
                 Revenue From Top 25 Taxpayers
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
                        
                        <tr class="table-header-center text-center-capitalize">
                                <td rowspan="3">ACTION</td>
                                <td class="text-center" rowspan="3">Sr. No.</td>
                                <td rowspan="3">GSTIN</td>
                                <td rowspan="3">Legal Name of the Taxpayer</td>
                                <td colspan="4" >CURRENT F.Y.</td> 
                                <td colspan="4">PREVIOUS F.Y.</td>   
                                <td rowspan="3">Reason for Increase/Decrease in Revenue</td>                             

                            </tr>
                             <tr class="table-header-center text-center-capitalize">
                               
                                <td colspan="2">FOR THE MONTH  </td>  
                                 <td colspan="2">UPTO THE MONTH  </td> 
                                <td colspan="2">FOR THE MONTH</td> 
                                 <td rowspan="1" colspan="2" style="border : 1px solid #ddd;">UPTO THE MONTH</td>  
                            </tr>
                            <tr class="table-header-center text-center-capitalize">
                               
                                <td >Cash   </td>  
                                 <td>ITC  </td> 
                                 <td >Cash   </td>  
                                 <td>ITC  </td> 
                                  <td >Cash   </td>  
                                 <td>ITC  </td> 
                                  <td >Cash   </td>  
                                 <td style="border : 1px solid #ddd;">ITC  </td> 
                            </tr>

                            <tr class="textcenter" id="tr_hidden">
                              <th class="text-center" style="width: 65px;padding: 3px 9px; height: 27px; margin-top: 5px;" >
                                <input name="btn_submit" class="btn btn-success" id="btn_submit" type="submit" value="Update" /></th>
                                <th class="text-center" id="txtSR_NO">
                                
                                </th>
                               
                                <%String TokenNo = (String) request.getSession().getAttribute("TokenNo");%>
                               
                                <td>
                                <!-- <input type="hidden" id="SR_NO" name="SR_NO"/> -->
                                <form:input path="SR_NO" type="hidden"  name="SR_NO" id="SR_NO" />
                                       <form:errors path="SR_NO" cssClass="error" /> 
                                    <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                                    <form:input path="GSTIN" type="text"  name="GSTIN" id="GSTIN" placeholder="GSTIN"
                                    class="form-control min-width-1" autocomplete="off" readonly="true" required = "true"  />
                                       <form:errors path="GSTIN" cssClass="error" />  
                                       
                                </td>
                                <td>
                                 <form:input path="NAME_OF_TAXPAYER" type="text" name="NAME_OF_TAXPAYER" id="Gross Revenue" placeholder="NAME OF TAXPAYER"
                                 class="form-control min-width-1" autocomplete="off" readonly="true" required = "true"/>
                                       <form:errors path="NAME_OF_TAXPAYER" cssClass="error" />  
                                       
                                </td>
                                <td>
                                 <form:input path="CASH_FOR_CURRENT" type="text"  name="CASH_FOR_CURRENT" id="CASH_FOR_CURRENT" placeholder="CASH"
                                 class="form-control min-width-1" style="min-width: 80px !important;vertical-align: middle;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="CASH_FOR_CURRENT" cssClass="error" />                                         
                                </td>
                                 <td>
                                 <form:input path="ITC_FOR_CURRENT" type="text" name="Gross Revenue" id="ITC_FOR_CURRENT" placeholder="ITC"
                                 class="form-control min-width-1" style="min-width: 80px !important;vertical-align: middle;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                    <form:errors path="ITC_FOR_CURRENT" cssClass="error" />                                         
                                </td>
                                
                                <td>                             
									       	
                                 <form:input path="CASH_UPTO_CURRENT" type="text" name="Gross Revenue" id="CASH_UPTO_CURRENT" placeholder="CASH"
                                  class="form-control min-width-1" style="min-width: 80px !important;vertical-align: middle;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="CASH_UPTO_CURRENT" cssClass="error" />                                         
                                </td>
                                
                                 <td>
                                 <form:input path="ITC_UPTO_CURRENT" type="text" name="ITC_UPTO_CURRENT" id="ITC_UPTO_CURRENT" placeholder="ITC"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_UPTO_CURRENT" cssClass="error" />                                         
                                </td>
                               
                                <td>
                                 <form:input path="CASH_FOR_PREV" type="text" name="CASH_FOR_PREV" id="CASH_FOR_PREV" placeholder="CASH"
                                 class="form-control min-width-1" style="min-width: 80px !important;vertical-align: middle;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="CASH_FOR_PREV" cssClass="error" />                                         
                                </td>
                                 <td>
                                 <form:input path="ITC_FOR_PREV" type="text" name="ITC_FOR_PREV" id="ITC_FOR_PREV" placeholder="ITC"
                                  class="form-control min-width-1" style="min-width: 80px !important;vertical-align: middle;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_FOR_PREV" cssClass="error" />                                         
                                </td>
                                
                                <td>
                                 <form:input path="CASH_UPTO_PREV" type="text"  name="Gross Revenue" id="CASH_UPTO_PREV" placeholder="CASH"
								 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="CASH_UPTO_PREV" cssClass="error" />                                         
                                </td>
                                 <td>
                                 <form:input path="ITC_UPTO_PREV" type="text"  name="ITC_UPTO_PREV" id="ITC_UPTO_PREV" placeholder="ITC"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_UPTO_PREV" cssClass="error" />                                         
                                </td>
                                
                                 <td>
                                     	
                                 <form:input path="REASON_FOR_INCREASE_REVENUE" type="text"  name="REASON_FOR_INCREASE_REVENUE"
                                  id="REASON_FOR_INCREASE_REVENUE" placeholder="REASON_FOR_INCREASE_REVENUE"
                                  class="form-control min-width-1-left" autocomplete="off"  maxlength="100" style="overflow-wrap: anywhere;"
                                   required = "true"/>
                                       <form:errors  style="text-align: left !important;" id="reason_error" path="REASON_FOR_INCREASE_REVENUE" cssClass="error" />  
                                       <label id="lbl_REASONS"></label> 
                                       
                                </td>
                            </tr>
                            
                            <% int rowNO=0; %>
                            <c:forEach items="${model}" var="r">
                           
							  <tr class="table-datarow-right">
								<td class="table-datarow-center" ><a class="btn btn-info"  style="width: 65px;padding: 3px 9px; height: 27px; margin-top: 5px;" href="javascript: GetReport('<%= rowNO+1 %>','${r.SR_NO}','${r.GSTIN}','${r.NAME_OF_TAXPAYER}','${r.CASH_FOR_CURRENT}','${r.ITC_FOR_CURRENT}','${r.CASH_UPTO_CURRENT}','${r.ITC_UPTO_CURRENT}','${r.CASH_FOR_PREV}','${r.ITC_FOR_PREV}','${r.CASH_UPTO_PREV}','${r.ITC_UPTO_PREV}','${r.REASON_FOR_INCREASE_REVENUE}');">Edit</a></td>			
								<td class="table-datarow-center">
								<%= rowNO+1 %>
								</td>
								<td class="table-datarow-center">${r.GSTIN}</td>
								<th width="15%" style="overflow-wrap: anywhere;">${r.NAME_OF_TAXPAYER}</th>
								<td width="8%">${r.CASH_FOR_CURRENT}</td>
								<td width="8%">${r.ITC_FOR_CURRENT}</td>
								<td width="8%">${r.CASH_UPTO_CURRENT}</td>
								<td width="8%">${r.ITC_UPTO_CURRENT}</td>
								<td width="8%">${r.CASH_FOR_PREV}</td>
								<td width="8%">${r.ITC_FOR_PREV}</td>
								<td width="8%">${r.CASH_UPTO_PREV}</td>
								<td width="8%">${r.ITC_UPTO_PREV}</td>
								<th class="text-left" width="15%" style="overflow-wrap: anywhere;">
								<%-- ${r.REASON_FOR_INCREASE_REVENUE} --%>
								  <c:if test="${r.REASON_FOR_INCREASE_REVENUE != 'null' && r.REASON_FOR_INCREASE_REVENUE != null}">
	                                ${r.REASON_FOR_INCREASE_REVENUE}
	                               </c:if>
								</th>
								
							   </tr>
							    <% rowNO=rowNO+1; %>
							</c:forEach>
                            
                        </table>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->

                <div align="center">
                         <input name="btn_error" class="btn btn-success" id="btn_error" type="hidden" value="${button}" />
                        <input type="hidden" name="hndresult" id="hndresult" value="${ViewBagResult}" />
                        <!-- <input name="btn_Close" id="btn_Close" class="btn btn-danger" value="Close" onclick="window.close();"/> -->
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
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.unobtrusive.js"></script>

<script src="../../../Content-Common/js/jquery.js"></script>

<script language="javascript" type="text/javascript">
		function GetReport(_index,SR_NO,GSTIN,NAME_OF_TAXPAYER,CASH_FOR_CURRENT,ITC_FOR_CURRENT,CASH_UPTO_CURRENT,ITC_UPTO_CURRENT,CASH_FOR_PREV,ITC_FOR_PREV,
				CASH_UPTO_PREV,ITC_UPTO_PREV,REASON_FOR_INCREASE_REVENUE
				) {

			$('#tr_hidden').show();
			$('#txtSR_NO').html(_index);
			$('input[name="SR_NO"]').val(SR_NO);
			$('input[name="GSTIN"]').val(GSTIN);
			$('input[name="NAME_OF_TAXPAYER"]').val(NAME_OF_TAXPAYER);
			$('input[name="CASH_FOR_CURRENT"]').val(CASH_FOR_CURRENT);
			$('input[name="ITC_FOR_CURRENT"]').val(ITC_FOR_CURRENT);
			$('input[name="CASH_UPTO_CURRENT"]').val(CASH_UPTO_CURRENT);
			$('input[name="ITC_UPTO_CURRENT"]').val(ITC_UPTO_CURRENT);
			$('input[name="CASH_FOR_PREV"]').val(CASH_FOR_PREV);
			$('input[name="ITC_FOR_PREV"]').val(ITC_FOR_PREV);
			$('input[name="CASH_FOR_PREV"]').val(CASH_FOR_PREV);
			$('input[name="CASH_UPTO_PREV"]').val(CASH_UPTO_PREV);
			$('input[name="ITC_UPTO_PREV"]').val(ITC_UPTO_PREV);
			$('input[name="REASON_FOR_INCREASE_REVENUE"]').val(REASON_FOR_INCREASE_REVENUE);
			$('input[name="btn_submit"]').val('Update');
			document.getElementById('reason_error').innerHTML='';
		}
		$(document).on("keypress", "input[type='text']", function(e) {
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
            
            if($('#CRR').val()=="T")
			{
			$('#tr_hidden').hide();
			}
			
        
        });
        
        function closeWin() {
        	 window.close();
        	}
        
        $('#REASON_FOR_INCREASE_REVENUE').bind('keypress', function (event) {
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


