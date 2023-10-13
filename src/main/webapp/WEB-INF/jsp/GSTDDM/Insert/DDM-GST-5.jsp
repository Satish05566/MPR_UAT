<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i> DDM-GST-5
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
    <form:form action="/MPR/GSTDDM/Insert/DDM_GST_5" id="DdmGst5CommTemp" name="DdmGst5CommTemp" method="POST" modelAttribute="DdmGst5CommTemp" >
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
                 Blocking/Unblocking of ITC
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
                        
                        <tr  class="text-center-capitalize table-header-center">
                                <td rowspan="3" colspan="1" >Action</td>
                                <td  rowspan="3" colspan="1" >SR. NO.</td>
                                <td rowspan="3" colspan="1">Grounds for blocking ITC</td>
                                <td rowspan="2" colspan="2">Opening Balance</td> 
                                <td rowspan="2" colspan="2">ITC blocked during the month</td>  
                                <td rowspan="2" colspan="2">ITC unblocked during the month </td> 
                                <td rowspan="1" colspan="10">Age-Wise pendency of ITC blocked</td>   
                                
                            </tr>
                            
                            <tr class="text-center-capitalize table-header-center">
             					<td rowspan="1" colspan="2">
                    				Upto 3 Months
                			    </td>
                				<td rowspan="1" colspan="2">
                    				3-6 Months
                				</td>
                				<td rowspan="1" colspan="2">
                    				6-9 Months
                				</td>
                				<td rowspan="1" colspan="2">
                    				9-12 Months
                				</td>
                				<td rowspan="1" colspan="2">
                   					More than 1 year
                				</td> 
            				</tr>
            				
            				<tr  class="text-center-capitalize table-header-center">
                <td rowspan="1" colspan="1">
                    No. 
                </td>
                <td rowspan="1" colspan="1">
                    Amount
                </td>
                <td rowspan="1" colspan="1">
                    No. 
                </td>
                <td rowspan="1" colspan="1">
                    Amount
                </td>
                <td rowspan="1" colspan="1">
                    No. 
                </td>
                <td rowspan="1" colspan="1">
                    Amount
                </td>
                <td rowspan="1" colspan="1">
                    No. 
                </td>
                <td rowspan="1" colspan="1">
                    Amount
                </td>
                <td rowspan="1" colspan="1">
                    No. 
                </td>
                <td rowspan="1" colspan="1">
                    Amount
                </td>
                <td rowspan="1" colspan="1">
                    No. 
                </td>
                <td rowspan="1" colspan="1">
                    Amount
                </td>
                <td rowspan="1" colspan="1">
                    No. 
                </td>
                <td rowspan="1" colspan="1">
                    Amount
                </td>
                <td rowspan="1" colspan="1">
                    No. 
                </td>
                <td rowspan="1" colspan="1">
                    Amount
                </td>
                
             </tr>
            				
                            

                            <tr id="tr_hidden">
                              <th class="text-center" >
                                <input name="btn_submit" class="btn btn-success" style="width: 65px;padding: 3px 9px; height: 27px; margin-top: 5px;" id="btn_submit" type="submit" value="Upload" /></th>
                                <th class="text-center" id="txtSR_NO">
                                
                                </th>
                               
                                <%String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                		String CRR = (String) request.getAttribute("CRR");
                                %>
                               
                                <td>
                                <input type="hidden" id="SR_NO" name="SR_NO"/>
                                <input type="hidden" id="GROUNDS_ID" name="GROUNDS_ID"/>
                                <input type="hidden" id="CRR" name="CRR" value="${CRR}" />
                                    <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                                    
                                    <form:input path="GROUNDS_BLOCKING_ITC" type="text" name="GROUNDS_BLOCKING_ITC" id="GROUNDS_BLOCKING_ITC" placeholder="GROUNDS_BLOCKING_ITC"
                                    class="form-control min-width-1" autocomplete="off" readonly="true" required = "true"  />
                                       <form:errors path="GROUNDS_BLOCKING_ITC" cssClass="error" />  
                                      
                                </td>
                                <td>
                                 <form:input path="OPENING_NO" type="text" id="OPENING_NO" name="OPENING_NO"  placeholder="NO"
                                       class="form-control min-width-1" style="min-width: 80px !important;" autocomplete="off" readonly="true" required="true"  />
                                     <form:errors path="OPENING_NO" cssClass="error" />  
                                       
                                </td>
                                <td>
                                 <form:input path="OPENING_AMT" type="text"  name="OPENING_AMT" id="OPENING_AMT" placeholder="AMT"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="OPENING_AMT" cssClass="error" />                                         
                                </td>
                                <td>
                                 <form:input path="ITC_BLOCKED_DURING_MONTH_NO" type="text" id="ITC_BLOCKED_DURING_MONTH_NO" name="ITC_BLOCKED_DURING_MONTH_NO"  placeholder="NO"
                                 class="form-control min-width-1" style="min-width: 80px !important;" autocomplete="off" readonly="true" required="true"  />
                                       <form:errors path="ITC_BLOCKED_DURING_MONTH_NO" cssClass="error" />  
                                       
                                </td>
                                <td>
                                 <form:input path="ITC_BLOCKED_DURING_MONTH_AMT" type="text"  name="ITC_BLOCKED_DURING_MONTH_AMT" id="ITC_BLOCKED_DURING_MONTH_AMT" placeholder="AMT"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_BLOCKED_DURING_MONTH_AMT" cssClass="error" />                                         
                                </td>
                                 <td>
                                 <form:input path="ITC_UNBLOCKED_DURING_MONTH_NO" type="text" name="ITC_UNBLOCKED_DURING_MONTH_NO" id="ITC_UNBLOCKED_DURING_MONTH_NO" placeholder="NO"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                    <form:errors path="ITC_UNBLOCKED_DURING_MONTH_NO" cssClass="error" />                                         
                                </td>
                                
                                <td>
                                 <form:input path="ITC_UNBLOCKED_DURING_MONTH_AMT" type="text" name="ITC_UNBLOCKED_DURING_MONTH_AMT" id="ITC_UNBLOCKED_DURING_MONTH_AMT" placeholder="AMT"
                                  class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_UNBLOCKED_DURING_MONTH_AMT" cssClass="error" />                                         
                                </td>
                                
                                <td>
                                 <form:input path="ITC_PENDING_BLOCKED_MORE_THAN_3_NO" type="text" name="ITC_PENDING_BLOCKED_MORE_THAN_3_NO" id="ITC_PENDING_BLOCKED_MORE_THAN_3_NO" placeholder="NO"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_PENDING_BLOCKED_MORE_THAN_3_NO" cssClass="error" />                                         
                                </td>
                               
                                <td>
                                 <form:input path="ITC_PENDING_BLOCKED_MORE_THAN_3_AMT" type="text" name="ITC_PENDING_BLOCKED_MORE_THAN_3_AMT" id="ITC_PENDING_BLOCKED_MORE_THAN_3_AMT" placeholder="AMT"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_PENDING_BLOCKED_MORE_THAN_3_AMT" cssClass="error" />                                         
                                </td>
                                
                               <td>
                                 <form:input path="ITC_PENDING_BLOCKED_MORE_THAN_6_NO" type="text" name="ITC_PENDING_BLOCKED_MORE_THAN_6_NO" id="ITC_PENDING_BLOCKED_MORE_THAN_6_NO" placeholder="NO"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_PENDING_BLOCKED_MORE_THAN_6_NO" cssClass="error" />                                         
                                </td>
                               
                                <td>
                                 <form:input path="ITC_PENDING_BLOCKED_MORE_THAN_6_AMT" type="text" name="ITC_PENDING_BLOCKED_MORE_THAN_6_AMT" id="ITC_PENDING_BLOCKED_MORE_THAN_6_AMT" placeholder="AMT"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_PENDING_BLOCKED_MORE_THAN_6_AMT" cssClass="error" />                                         
                                </td>
                                
                                <td>
                                 <form:input path="ITC_PENDING_BLOCKED_MORE_THAN_9_NO" type="text" name="ITC_PENDING_BLOCKED_MORE_THAN_9_NO" id="ITC_PENDING_BLOCKED_MORE_THAN_9_NO" placeholder="NO"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_PENDING_BLOCKED_MORE_THAN_9_NO" cssClass="error" />                                         
                                </td>
                               
                                <td>
                                 <form:input path="ITC_PENDING_BLOCKED_MORE_THAN_9_AMT" type="text" name="ITC_PENDING_BLOCKED_MORE_THAN_9_AMT" id="ITC_PENDING_BLOCKED_MORE_THAN_9_AMT" placeholder="AMT"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_PENDING_BLOCKED_MORE_THAN_9_AMT" cssClass="error" />                                         
                                </td>
                                
                                 <td>
                                 <form:input path="ITC_PENDING_BLOCKED_MORE_THAN_12_NO" type="text" name="ITC_PENDING_BLOCKED_MORE_THAN_12_NO" id="ITC_PENDING_BLOCKED_MORE_THAN_12_NO" placeholder="NO"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_PENDING_BLOCKED_MORE_THAN_12_NO" cssClass="error" />                                         
                                </td>
                               
                                <td>
                                 <form:input path="ITC_PENDING_BLOCKED_MORE_THAN_12_AMT" type="text" name="ITC_PENDING_BLOCKED_MORE_THAN_12_AMT" id="ITC_PENDING_BLOCKED_MORE_THAN_12_AMT" placeholder="AMT"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_PENDING_BLOCKED_MORE_THAN_12_AMT" cssClass="error" />                                         
                                </td>
                                
                                 <td>
                                 <form:input path="ITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO" type="text" name="ITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO" id="ITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO" placeholder="NO"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO" cssClass="error" />                                         
                                </td>
                               
                                <td>
                                 <form:input path="ITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT" type="text" name="ITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT" id="ITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT" placeholder="AMT"
                                 class="form-control min-width-1" style="min-width: 80px !important;" readonly="true" autocomplete="off" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  />
                                       <form:errors path="ITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT" cssClass="error" />                                         
                                </td>
                                
                            </tr>
                            
                            <% int rowNO=0; %>
                            <c:forEach items="${model}" var="r">
                           
							  <tr class="table-datarow-right">
								<td class="table-datarow-center"><a disabled class="btn btn-info" style="width: 65px;padding: 3px 9px; height: 27px; margin-top: 5px;" Title="This report is not editable." href="javascript: GetReport('<%= rowNO+1 %>','${r.SR_NO}','${r.GROUNDS_ID}','${r.GROUNDS_BLOCKING_ITC}','${r.OPENING_NO}','${r.OPENING_AMT}','${r.ITC_BLOCKED_DURING_MONTH_NO}','${r.ITC_BLOCKED_DURING_MONTH_AMT}','${r.ITC_UNBLOCKED_DURING_MONTH_NO}','${r.ITC_UNBLOCKED_DURING_MONTH_AMT}','${r.ITC_PENDING_BLOCKED_MORE_THAN_3_NO}','${r.ITC_PENDING_BLOCKED_MORE_THAN_3_AMT}','${r.ITC_PENDING_BLOCKED_MORE_THAN_6_NO}','${r.ITC_PENDING_BLOCKED_MORE_THAN_6_AMT}','${r.ITC_PENDING_BLOCKED_MORE_THAN_9_NO}','${r.ITC_PENDING_BLOCKED_MORE_THAN_9_AMT}','${r.ITC_PENDING_BLOCKED_MORE_THAN_12_NO}','${r.ITC_PENDING_BLOCKED_MORE_THAN_12_AMT}','${r.ITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO}','${r.ITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT}');" >Edit</a></td>			
								<td class="table-datarow-center">
								<%= rowNO+1 %>
								</td>
								<td style="text-align: left;">${r.GROUNDS_BLOCKING_ITC}</td>
								<td >${r.OPENING_NO}</td>
								<td >${r.OPENING_AMT}</td>
								<td >${r.ITC_BLOCKED_DURING_MONTH_NO}</td>
								<td >${r.ITC_BLOCKED_DURING_MONTH_AMT}</td>
								<td >${r.ITC_UNBLOCKED_DURING_MONTH_NO}</td>
								<td >${r.ITC_UNBLOCKED_DURING_MONTH_AMT}</td>
								
								<td >${r.ITC_PENDING_BLOCKED_MORE_THAN_3_NO }</td>
								<td >${r.ITC_PENDING_BLOCKED_MORE_THAN_3_AMT }</td>
								<td >${r.ITC_PENDING_BLOCKED_MORE_THAN_6_NO }</td>
								<td >${r.ITC_PENDING_BLOCKED_MORE_THAN_6_AMT }</td>
								<td >${r.ITC_PENDING_BLOCKED_MORE_THAN_9_NO }</td>
								<td >${r.ITC_PENDING_BLOCKED_MORE_THAN_9_AMT }</td>
								<td >${r.ITC_PENDING_BLOCKED_MORE_THAN_12_NO }</td>
								<td >${r.ITC_PENDING_BLOCKED_MORE_THAN_12_AMT }</td>
								
								<td >${r.ITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO}</td>
								<td >${r.ITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT}</td>
								
								
								<%-- <td class="text-left">								
								  <c:if test="${r.REASON_FOR_INCREASE_REVENUE != 'null' && r.REASON_FOR_INCREASE_REVENUE != null}">
	                                ${r.REASON_FOR_INCREASE_REVENUE}
	                               </c:if>
								</td> --%>
								
							   </tr>
							    <% rowNO=rowNO+1; %>
							</c:forEach>
                            
                        </table>
                        <!-- /.table-responsive -->
                    </div>

                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
                <div>                    
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
<script src="<%= session.getAttribute("COMMON_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.unobtrusive.js"></script>



<script language="javascript" type="text/javascript">
		function GetReport(_index,SR_NO,GROUNDS_ID,GROUNDS_BLOCKING_ITC,OPENING_NO,OPENING_AMT,ITC_BLOCKED_DURING_MONTH_NO,ITC_BLOCKED_DURING_MONTH_AMT,
				ITC_UNBLOCKED_DURING_MONTH_NO,ITC_UNBLOCKED_DURING_MONTH_AMT,
				ITC_PENDING_BLOCKED_MORE_THAN_3_NO,ITC_PENDING_BLOCKED_MORE_THAN_3_AMT,
				ITC_PENDING_BLOCKED_MORE_THAN_6_NO,ITC_PENDING_BLOCKED_MORE_THAN_6_AMT,
				ITC_PENDING_BLOCKED_MORE_THAN_9_NO,ITC_PENDING_BLOCKED_MORE_THAN_9_AMT,
				ITC_PENDING_BLOCKED_MORE_THAN_12_NO,ITC_PENDING_BLOCKED_MORE_THAN_12_AMT,
				ITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO,ITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT
				) {
			//$('#tr_hidden').show();
			$('#txtSR_NO').html(_index);
			$('input[name="SR_NO"]').val(SR_NO);
			$('input[name="GROUNDS_ID"]').val(GROUNDS_ID);
			$('input[name="GROUNDS_BLOCKING_ITC"]').val(GROUNDS_BLOCKING_ITC);
			$('input[name="OPENING_NO"]').val(OPENING_NO);
			$('input[name="OPENING_AMT"]').val(OPENING_AMT);			
			$('input[name="ITC_BLOCKED_DURING_MONTH_NO"]').val(ITC_BLOCKED_DURING_MONTH_NO);
			$('input[name="ITC_BLOCKED_DURING_MONTH_AMT"]').val(ITC_BLOCKED_DURING_MONTH_AMT);
			$('input[name="ITC_UNBLOCKED_DURING_MONTH_NO"]').val(ITC_UNBLOCKED_DURING_MONTH_NO);
			$('input[name="ITC_UNBLOCKED_DURING_MONTH_AMT"]').val(ITC_UNBLOCKED_DURING_MONTH_AMT);
			
			$('input[name="ITC_PENDING_BLOCKED_MORE_THAN_3_NO"]').val(ITC_PENDING_BLOCKED_MORE_THAN_3_NO);
			$('input[name="ITC_PENDING_BLOCKED_MORE_THAN_3_AMT"]').val(ITC_PENDING_BLOCKED_MORE_THAN_3_AMT);
			
			$('input[name="ITC_PENDING_BLOCKED_MORE_THAN_6_NO"]').val(ITC_PENDING_BLOCKED_MORE_THAN_6_NO);
			$('input[name="ITC_PENDING_BLOCKED_MORE_THAN_6_AMT"]').val(ITC_PENDING_BLOCKED_MORE_THAN_6_AMT);
			
			$('input[name="ITC_PENDING_BLOCKED_MORE_THAN_9_NO"]').val(ITC_PENDING_BLOCKED_MORE_THAN_9_NO);
			$('input[name="ITC_PENDING_BLOCKED_MORE_THAN_9_AMT"]').val(ITC_PENDING_BLOCKED_MORE_THAN_9_AMT);
			
			$('input[name="ITC_PENDING_BLOCKED_MORE_THAN_12_NO"]').val(ITC_PENDING_BLOCKED_MORE_THAN_12_NO);
			$('input[name="ITC_PENDING_BLOCKED_MORE_THAN_12_AMT"]').val(ITC_PENDING_BLOCKED_MORE_THAN_12_AMT);
			
			$('input[name="ITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO"]').val(ITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO);
			$('input[name="ITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT"]').val(ITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT);
			$('input[name="btn_submit"]').val('Update');
			

		}
	</script>
<script type="text/javascript">

        $(document).ready(function () {
           $('#tr_hidden').hide();
           
        	/* if($('#CRR').val()=="T")
			{
			$('#tr_hidden').hide();
			}
		else
			$('#tr_hidden').show(); */
        });

    </script>

<script>

    $(document).ready(function () {
        
        /* var row_count = $('#table_count tr').length;
        var count = row_count - 2; */
		//alert("count---"+count);
		//alert($('input[name="ASSESSEE"]').val());
        /* if (count == 20) {
            var r = "Other than top 20";
            $('input[name="txt_DESC_OF_GOODS"]').val(r);
        }
        else  */
            /* if (count == 25) {
            $('#tr_hidden').hide();
        }
        else {
            $('input[name="txt_DESC_OF_GOODS"]').val();
        } */

    });

</script>




<jsp:include page="../../GSTHome/Footer.jsp" />


