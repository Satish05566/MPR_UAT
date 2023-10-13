<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<style>
.input-validation-error
{
    border: 1px solid #ff0000 !important;
}
.form-control{
    height: 30px !important;
}
</style>

<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i>  GST-ADJ-3
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
        String strDate = (String) request.getAttribute("MM_YYYY");
         java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
         java.util.Date date = srcDtFormat.parse(strDate);
         java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
         String desDt = desDtFormat.format(date);
      %> 
      <%   
                                String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                String MM_YYYY = (String) request.getAttribute("MM_YYYY");
                                String CRR = (String) request.getAttribute("CRR");
                                String APR_2023_OPENING=(String) request.getAttribute("APR_2023_OPENING");
                                %>
    <!-- <form:form action="/GSTDPM/Insert/DPM_GST_ADJ_3" id="DpmGstAdj3CommTemp" name = "DpmGstAdj3CommTemp" method="POST"  modelAttribute="DpmGstAdj3CommTemp" >
      -->
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
               CASES PENDING UNDER SECTION 75(11) OF CGST ACT WITH REASONS FOR PENDENCY
               <a style="margin-left: 32%;" onclick="addNewData();" class="btn btn-success" href="javascript:void(0)">Add New</a>
         
            </div>
            
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="panel panel-warning">
                    
                        <div class="panel-heading sub-month">
                              MONTH : <%= desDt.toUpperCase() %>
                
                        <div class="sub-lakh">Amount: Rs. in Lakhs</div>
                    </div>
          <div class="table-responsive">
                  <table class="table table-striped table-bordered table-hover">
                        
                        <tr class="table-header-center text-center-capitalize">
                                <td rowspan="2" style="width:2%;">S.No.</td>
                                <td rowspan="2" >Reason for keeping in Call Book</td>
                                <td rowspan="2" >Adjudicating Authority</td>
                                <td colspan="2">Opening Balance</td>
                                <td colspan="2">Receipt</td>
                                <td colspan="2">Disposal</td>
                                <td colspan="2">Closing Balance</td>
                                <td colspan="4">Age wise Break up of pendency</td>
                       </tr>
                       <tr class="table-header-center">
                       
                            <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="CRR" name="CRR" value="${CRR}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                                    
                           <td>No </td>
                           <td>Amount </td>
                           <td>No </td>
                           <td>Amount </td>
                           <td>No </td>
                           <td>Amount </td>
                           <td>No </td>
                           <td>Amount </td>
                           <td>Less than 6 months </td>
                            <td>6  to 12 months </td>
                           <td>1 year to 2 years </td>
                            <td>More than 2 years </td>                           
                       </tr>
                       
                       <% int i=0; %>
                     <c:forEach items="${model}" var="r">  
                        <tr>
                               
                                
                                <th class="text-center header-text-readonly" rowspan="3"><%= i+1 %></th>
                                <th class="header-text-readonly" rowspan="3">
                                    <!-- ${r.REASON_FOR_KEEPING_IN_CALL_BOOK }
                                 -->
                                                                   
                                  <a style="width: 65px; padding: 3px 9px; height: 27px; margin-top: 5px;"
                                                onclick="GetReport('${r.REASON_ID}', 
                                                '${r.ADC_OPENING_NO}','${r.ADC_OPENING_AMT}','${r.ADC_RECEIPT_NO}', 
                                                '${r.ADC_RECEIPT_AMT}','${r.ADC_DISPOSAL_NO}', 
                                                '${r.ADC_DISPOSAL_AMT}', 
                                                '${r.ADC_CLOSING_NO}', 
                                                '${r.ADC_CLOSING_AMT}', 
                                                '${r.ADC_AGE_LESS_6_NO}', 
                                                '${r.ADC_AGE_6_TO_12_NO}', 
                                                '${r.ADC_AGE_1_TO_2_NO}', 
                                                '${r.ADC_AGE_MORE_THAN_2_NO}', 
                                                '${r.DC_OPENING_NO}', 
                                                '${r.DC_OPENING_AMT}', 
                                                '${r.DC_RECEIPT_NO}', 
                                                '${r.DC_RECEIPT_AMT}', 
                                                '${r.DC_DISPOSAL_NO}', 
                                                '${r.DC_DISPOSAL_AMT}', 
                                                '${r.DC_CLOSING_NO}', 
                                                '${r.DC_CLOSING_AMT}', 
                                                '${r.DC_AGE_LESS_6_NO}', 
                                                '${r.DC_AGE_6_TO_12_NO}', 
                                                '${r.DC_AGE_1_TO_2_NO}', 
                                                '${r.DC_AGE_MORE_THAN_2_NO}', 
                                                '${r.SUP_OPENING_NO}', 
                                                '${r.SUP_OPENING_AMT}', 
                                                '${r.SUP_RECEIPT_NO}', 
                                                '${r.SUP_RECEIPT_AMT}', 
                                                '${r.SUP_DISPOSAL_NO}', 
                                                '${r.SUP_DISPOSAL_AMT}', 
                                                '${r.SUP_CLOSING_NO}', 
                                                '${r.SUP_CLOSING_AMT}', 
                                                '${r.SUP_AGE_LESS_6_NO}', 
                                                '${r.SUP_AGE_6_TO_12_NO}', 
                                                '${r.SUP_AGE_1_TO_2_NO}', 
                                                '${r.SUP_AGE_MORE_THAN_2_NO}',);" href="#">
                                                    ${r.REASON_FOR_KEEPING_IN_CALL_BOOK }
                                 </a>
												

                                </th>
                                <th class="header-text-readonly">ADC/JC</th>
                                <td>
                                   
                                      <label>  ${r.ADC_OPENING_NO}</label>  
                                       
                                </td>
                                 <td>                                    
                                   <label>${r.ADC_OPENING_AMT}</label>
                                       
                                       
                                </td> 
                                
                                <td>
                                    
                                       <label>${r.ADC_RECEIPT_NO}</label>  
                                </td>
                                 <td>                                    
                                       <label>${r.ADC_RECEIPT_AMT}</label>                                  
                                </td>  
                                
                                <td>
                                    <label>${r.ADC_DISPOSAL_NO}</label>     
                                </td>
                                 <td> 
                                    <label>${r.ADC_DISPOSAL_AMT}</label>                                      
                                </td>  
                                
                                <td>
                                    <label>${r.ADC_CLOSING_NO}</label>      
                                       
                                </td>
                                 <td>                                    
                                    <label>${r.ADC_CLOSING_AMT}</label>                                      
                                </td>  
                                
                                <td>
                                    <label>${r.ADC_AGE_LESS_6_NO}</label>      
                                       
                                </td>
                                 <td>                                    
                                     <label>${r.ADC_AGE_6_TO_12_NO}</label>                                       
                                </td>  
                                
                                <td>
                                    <label>${r.ADC_AGE_1_TO_2_NO}</label>  
                                </td>
                                 <td>                                    
                                    <label>${r.ADC_AGE_MORE_THAN_2_NO}</label>                                    
                                </td>  
                               
                           </tr>
                            
                           <tr>
                               
                                <th class="header-text-readonly">DC/AC</th>
                                 <td>
                                    <label>${r.DC_OPENING_NO}</label>                                        
                                </td>
                                 <td>                                    
                                    <label>${r.DC_OPENING_AMT}</label>                                 
                                </td> 
                                
                                <td>
                                    <label>${r.DC_RECEIPT_NO}</label> 
                                </td>
                                 <td>                                    
                                    <label>${r.DC_RECEIPT_AMT}</label>                                  
                                </td>  
                                
                                <td>
                                    <label>${r.DC_DISPOSAL_NO}</label> 
                                </td>
                                 <td>                                    
                                    <label>${r.DC_DISPOSAL_AMT}</label>                                  
                                </td>  
                                
                                <td>
                                    <label>${r.DC_CLOSING_NO}</label>                                        
                                </td>
                                 <td>                                    
                                   <label>${r.DC_CLOSING_AMT}</label>                               
                                </td>  
                                
                                <td>
                                    <label>${r.DC_AGE_LESS_6_NO}</label> 
                                </td>
                                 <td>                                    
                                    <label>${r.DC_AGE_6_TO_12_NO}</label>                                  
                                </td>  
                                
                                <td>
                                    <label>${r.DC_AGE_1_TO_2_NO}</label> 
                                </td>
                                 <td>                                    
                                    <label>${r.DC_AGE_MORE_THAN_2_NO}</label>                                  
                                </td>  
                            </tr>   
                            
                            <tr>
                               
                                <th class="header-text-readonly">Superintendent</th>
                                 <td>
                                     <label>${r.SUP_OPENING_NO}</label>  
                                </td>
                                 <td>                                    
                                    <label>${r.SUP_OPENING_AMT}</label>                                  
                                </td> 
                                
                                <td>
                                     <label>${r.SUP_RECEIPT_NO}</label>  
                                       
                                </td>
                                 <td>                                    
                                    <label>${r.SUP_RECEIPT_AMT}</label>                                   
                                </td>  
                                
                                <td>
                                    <label>${r.SUP_DISPOSAL_NO}</label>  
                                </td>
                                 <td>                                    
                                    <label>${r.SUP_DISPOSAL_AMT}</label>                                    
                                </td>  
                                
                                <td>
                                    <label>${r.SUP_CLOSING_NO}</label>  
                                       
                                </td>
                                 <td>                                    
                                    <label>${r.SUP_CLOSING_AMT}</label>                                   
                                </td>  
                                
                                <td>
                                    <label>${r.SUP_AGE_LESS_6_NO}</label>  
                                       
                                </td>
                                 <td>                                    
                                    <label>${r.SUP_AGE_6_TO_12_NO}</label>                                   
                                </td>  
                                
                                <td>
                                    <label>${r.SUP_AGE_1_TO_2_NO}</label>  
                                       
                                </td>
                                 <td>                                    
                                    <label>${r.SUP_AGE_MORE_THAN_2_NO}</label>                                    
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
                <%-- <div align="center">
                    <input name="btn_submit" class="btn btn-success" id="btn_submit" type="submit" value="${ViewBag_button}" />
                    <input type="hidden" name="hndresult" id="hndresult" value="${ViewBagMessage}" />
                    <input name="btn_Cancel" id="btn_Cancel" class="btn btn-danger" onclick="location.href='/GSTGI/Insert/GI_GST_3/<%=TokenNo%>';" type="reset" value="Cancel" />

                </div> --%>
            </div>
            <!-- /.col-lg-6 -->

        </div>
    </div>

    <!-- </form:form> -->
    </div>
</div>

<form action="/MPR/GSTDPM/Insert/DPM_GST_ADJ_3_OPENING_INSERT" id="gIGstCommTemp1" name="gIGstCommTemp1" autocomplete="off" method="post"  modelAttribute="gIGstCommTemp1">
 
<div class="modal fade" id="openingBox" tabindex="-1" role="dialog"
aria-labelledby="exampleModalLabel" aria-hidden="true">

<div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
        <div class="modal-header"
            style="background-color: #f2dede; color: #a94442; ">
            <h5 class="modal-title" id="exampleModalLabel" style="text-align: center;">
                CASES PENDING UNDER SECTION 75(11) OF CGST ACT WITH REASONS FOR PENDENCY
            </h5>
            <!-- <button type="button" class="close" style="margin-top:-23px;opacity: inherit;color: #c9302c;" 
                data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button> -->
            <h5 style="color: green;">
                <span style="margin-right: 5%;">MONTH : <%=desDt.toUpperCase()%></span>
                <span style="text-align: CENTER;color: GREEN;font-weight: bold;
                margin-left: 25%;"> Opening Form</span>
              <span class="sub-lakh">Amount: Rs. in Lakhs</span>
            </h5>
        </div>
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                      
                      <tr class="table-header-center text-center-capitalize">
                              <td rowspan="2" style="width:2%;">S.No.</td>
                              <td rowspan="2" >Reason for keeping in Call Book</td>
                              <td rowspan="2" >Adjudicating Authority</td>
                              <td colspan="2">Opening Balance</td>
                              
                     </tr>
                     <tr class="table-header-center">
                     
                         <td>No </td>
                         <td>Amount </td>
                                                
                     </tr>
            
                      <tr>
                             
                              <th class="text-center header-text-readonly" rowspan="3">1</th>
                              <th class="header-text-readonly" rowspan="3">
                                <!-- <select class="form-control">
                                    <option value="1">Appeals filed by the department on the same issue</option>
                                    <option value="2">Injunction issued by the Courts</option>
                                    <option value="3">C&AG Audit objections contested</option>
                                    <option value="4">Board's specific direction to keep the cases in CASES PENDING UNDER SECTION 75(11) OF CGST ACT/Others</option>
                                </select> -->
                                Appeals filed by the department on the same issue
                              </th>
                              <th class="header-text-readonly">ADC/JC</th>
                              <td>
                                <input type="hidden" id="HDTokenNoOpening" name="HDTokenNoOpening" value="<%=TokenNo%>" />
                                <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />

                                  <input path="Appeals_ADC_OPENING_NO" type="text" maxlength="18"placeholder="0" name="Appeals_ADC_OPENING_NO" id="Appeals_ADC_OPENING_NO" class="form-control min-width-90" 
                                  autocomplete="off" value= ""
                                  onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true" />
                                  <form:errors path="Appeals_ADC_OPENING_NO" cssClass="error" /> 
                                     
                              </td>
                               <td>                                    
                                 <input path="Appeals_ADC_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="Appeals_ADC_OPENING_AMT" id="Appeals_ADC_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                  value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                     <form:errors path="Appeals_ADC_OPENING_AMT" cssClass="error" />                                  
                              </td> 
                         </tr>

                         <tr>
                             
                            <th class="header-text-readonly">DC/AC</th>
                             <td>
                                <input path="Appeals_DC_OPENING_NO" type="text" maxlength="18"placeholder="0" name="Appeals_DC_OPENING_NO" id="Appeals_DC_OPENING_NO" class="form-control min-width-90" 
                                autocomplete="off" value= ""
                                onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                   <errors path="Appeals_DC_OPENING_NO" cssClass="error" /> 
                                   
                            </td>
                             <td>                                    
                               <input path="Appeals_DC_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="Appeals_DC_OPENING_AMT" id="Appeals_DC_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                   <errors path="Appeals_DC_OPENING_AMT" cssClass="error" />                                  
                            </td> 
                        </tr>   
                        
                        <tr>
                           
                            <th class="header-text-readonly">Superintendent</th>
                             <td>
                                <input path="Appeals_SUP_OPENING_NO" type="text" maxlength="18"placeholder="0" name="Appeals_SUP_OPENING_NO" id="Appeals_SUP_OPENING_NO" class="form-control min-width-90" 
                                autocomplete="off" value= ""
                                onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                   <errors path="Appeals_SUP_OPENING_NO" cssClass="error" /> 
                                   
                            </td>
                             <td>                                    
                               <input path="Appeals_SUP_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="Appeals_SUP_OPENING_AMT" id="Appeals_SUP_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                   <errors path="Appeals_SUP_OPENING_AMT" cssClass="error" />                                  
                            </td>                              
                        </tr> 
                     
                        <!-- Second ROW -->
                        <tr>
                             
                            <th class="text-center header-text-readonly" rowspan="3">2</th>
                            <th class="header-text-readonly" rowspan="3">
                              <!-- <select class="form-control">
                                  <option value="1">Appeals filed by the department on the same issue</option>
                                  <option value="2">Injunction issued by the Courts</option>
                                  <option value="3">C&AG Audit objections contested</option>
                                  <option value="4">Board's specific direction to keep the cases in CASES PENDING UNDER SECTION 75(11) OF CGST ACT/Others</option>
                              </select> -->
                              Injunction issued by the Courts
                            </th>
                            <th class="header-text-readonly">ADC/JC</th>
                            <td>
                               
                                <input path="Injunction_ADC_OPENING_NO" type="text" maxlength="18"placeholder="0" name="Injunction_ADC_OPENING_NO" id="Injunction_ADC_OPENING_NO" class="form-control min-width-90" 
                                autocomplete="off" value= ""
                                onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true" />
                                   <form:errors path="Injunction_ADC_OPENING_NO" cssClass="error" /> 
                                   
                            </td>
                             <td>                                    
                               <input path="Injunction_ADC_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="Injunction_ADC_OPENING_AMT" id="Injunction_ADC_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                                value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                   <form:errors path="Injunction_ADC_OPENING_AMT" cssClass="error" />                                  
                            </td> 
                       </tr>

                       <tr>
                           
                          <th class="header-text-readonly">DC/AC</th>
                           <td>
                              <input path="Injunction_DC_OPENING_NO" type="text" maxlength="18"placeholder="0" name="Injunction_DC_OPENING_NO" id="Injunction_DC_OPENING_NO" class="form-control min-width-90" 
                              autocomplete="off" value= ""
                              onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                 <errors path="Injunction_DC_OPENING_NO" cssClass="error" /> 
                                 
                          </td>
                           <td>                                    
                             <input path="Injunction_DC_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="Injunction_DC_OPENING_AMT" id="Injunction_DC_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                              value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                 <errors path="Injunction_DC_OPENING_AMT" cssClass="error" />                                  
                          </td> 
                          
                      </tr>   
                      
                      <tr>
                         
                          <th class="header-text-readonly">Superintendent</th>
                           <td>
                              <input path="Injunction_SUP_OPENING_NO" type="text" maxlength="18"placeholder="0" name="Injunction_SUP_OPENING_NO" id="Injunction_SUP_OPENING_NO" class="form-control min-width-90" 
                              autocomplete="off" value= ""
                              onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                 <errors path="Injunction_SUP_OPENING_NO" cssClass="error" /> 
                                 
                          </td>
                           <td>                                    
                             <input path="Injunction_SUP_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="Injunction_SUP_OPENING_AMT" id="Injunction_SUP_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                              value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                 <errors path="Injunction_SUP_OPENING_AMT" cssClass="error" />                                  
                          </td>                              
                      </tr> 

                      <!-- Third ROW -->
                      <tr>
                             
                        <th class="text-center header-text-readonly" rowspan="3">3</th>
                        <th class="header-text-readonly" rowspan="3">
                          <!-- <select class="form-control">
                              <option value="1">Appeals filed by the department on the same issue</option>
                              <option value="2">Injunction issued by the Courts</option>
                              <option value="3">C&AG Audit objections contested</option>
                              <option value="4">Board's specific direction to keep the cases in CASES PENDING UNDER SECTION 75(11) OF CGST ACT/Others</option>
                          </select> -->
                          C&AG Audit objections contested
                        </th>
                        <th class="header-text-readonly">ADC/JC</th>
                        <td>
                            
                            <input path="CAG_ADC_OPENING_NO" type="text" maxlength="18"placeholder="0" name="CAG_ADC_OPENING_NO" id="CAG_ADC_OPENING_NO" class="form-control min-width-90" 
                            autocomplete="off" value= ""
                            onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                               <form:errors path="CAG_ADC_OPENING_NO" cssClass="error" /> 
                               
                        </td>
                         <td>                                    
                           <input path="CAG_ADC_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="CAG_ADC_OPENING_AMT" id="CAG_ADC_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                            value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                            <form:errors path="CAG_ADC_OPENING_AMT" cssClass="error" />                                  
                        </td> 
                   </tr>

                   <tr>
                       
                      <th class="header-text-readonly">DC/AC</th>
                       <td>
                          <input path="CAG_DC_OPENING_NO" type="text" maxlength="18"placeholder="0" name="CAG_DC_OPENING_NO" id="CAG_DC_OPENING_NO" class="form-control min-width-90" 
                          autocomplete="off" value= ""
                          onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                             <errors path="CAG_DC_OPENING_NO" cssClass="error" /> 
                             
                      </td>
                       <td>                                    
                         <input path="CAG_DC_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="CAG_DC_OPENING_AMT" id="CAG_DC_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                          value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                             <errors path="CAG_DC_OPENING_AMT" cssClass="error" />                                  
                      </td> 
                      
                      
                  </tr>   
                  
                  <tr>
                     
                      <th class="header-text-readonly">Superintendent</th>
                       <td>
                          <input path="CAG_SUP_OPENING_NO" type="text" maxlength="18"placeholder="0" name="CAG_SUP_OPENING_NO" id="CAG_SUP_OPENING_NO" class="form-control min-width-90" 
                          autocomplete="off" value= ""
                          onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                             <errors path="CAG_SUP_OPENING_NO" cssClass="error" /> 
                             
                      </td>
                       <td>                                    
                         <input path="CAG_SUP_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="CAG_SUP_OPENING_AMT" id="CAG_SUP_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                          value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                             <errors path="CAG_SUP_OPENING_AMT" cssClass="error" />                                  
                      </td>                              
                  </tr> 

                  <!-- Fourth ROW -->
                  <tr>
                             
                    <th class="text-center header-text-readonly" rowspan="3">4</th>
                    <th class="header-text-readonly" rowspan="3">
                      <!-- <select class="form-control">
                          <option value="1">Appeals filed by the department on the same issue</option>
                          <option value="2">Injunction issued by the Courts</option>
                          <option value="3">C&AG Audit objections contested</option>
                          <option value="4">Board's specific direction to keep the cases in CASES PENDING UNDER SECTION 75(11) OF CGST ACT/Others</option>
                      </select> -->
                      Board's specific direction to keep the cases in CASES PENDING UNDER SECTION 75(11) OF CGST ACT/Others
                    </th>
                    <th class="header-text-readonly">ADC/JC</th>
                    <td>
                       
                        <input path="Board_ADC_OPENING_NO" type="text" maxlength="18"placeholder="0" name="Board_ADC_OPENING_NO" id="Board_ADC_OPENING_NO" class="form-control min-width-90" 
                        autocomplete="off" value= ""
                        onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"  />
                           <form:errors path="Board_ADC_OPENING_NO" cssClass="error" /> 
                           
                    </td>
                     <td>                                    
                       <input path="Board_ADC_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="Board_ADC_OPENING_AMT" id="Board_ADC_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                        value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                           <form:errors path="Board_ADC_OPENING_AMT" cssClass="error" />                                  
                    </td> 
               </tr>

               <tr>
                   
                  <th class="header-text-readonly">DC/AC</th>
                   <td>
                      <input path="Board_DC_OPENING_NO" type="text" maxlength="18"placeholder="0" name="Board_DC_OPENING_NO" id="Board_DC_OPENING_NO" class="form-control min-width-90" 
                      autocomplete="off" value= ""
                      onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                         <errors path="Board_DC_OPENING_NO" cssClass="error" /> 
                         
                  </td>
                   <td>                                    
                     <input path="Board_DC_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="Board_DC_OPENING_AMT" id="Board_DC_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                      value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                         <errors path="Board_DC_OPENING_AMT" cssClass="error" />                                  
                  </td> 
                  
                  
              </tr>   
              
              <tr>
                 
                  <th class="header-text-readonly">Superintendent</th>
                   <td>
                      <input path="Board_SUP_OPENING_NO" type="text" maxlength="18"placeholder="0" name="Board_SUP_OPENING_NO" id="Board_SUP_OPENING_NO" class="form-control min-width-90" 
                      autocomplete="off" value= ""
                      onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                         <errors path="Board_SUP_OPENING_NO" cssClass="error" /> 
                         
                  </td>
                   <td>                                    
                     <input path="Board_SUP_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="Board_SUP_OPENING_AMT" id="Board_SUP_OPENING_AMT" class="form-control min-width-90" autocomplete="off" 
                      value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                         <errors path="Board_SUP_OPENING_AMT" cssClass="error" />                                  
                  </td>                              
              </tr> 
                 </table>
          </div>

            <div class="modal-footer">
                <!-- <button type="button" class="btn btn-danger" data-dismiss="modal" style="margin-right:10px;"
                    id="cancel_button">Close</button> -->
                <input type="submit" name="btn_submit" class="btn btn-success"
                    value="Upload" id="UpdateId" /> 

            </div>
    </div>
</div>
</div> 
</form>

<form action="/MPR/GSTDPM/Insert/DPM_GST_ADJ_3" id="DpmGstAdj3CommTemp" name="DpmGstAdj3CommTemp" autocomplete="off" method="post"  modelAttribute="DpmGstAdj3CommTemp">
    <div class="modal fade" id="Modal2" tabindex="-1" role="dialog"
        aria-labelledby="exampleModalLabel" aria-hidden="true">
        
        <div class="modal-dialog modal-lg" role="document" style="width: 90%;">
            <div class="modal-content">
                <div class="modal-header"
                    style="background-color: #f2dede; color: #a94442; ">
                    <h5 class="modal-title" id="exampleModalLabel">
                        <span style="color: green;margin-right: 5%;">MONTH : <%=desDt.toUpperCase()%></span>  
                        CASES PENDING UNDER SECTION 75(11) OF CGST ACT WITH REASONS FOR PENDENCY
                    </h5>
                    <button type="button" class="close" style="margin-top:-23px;opacity: inherit;color: #c9302c;" 
                        data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div> 

                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                          
                          <tr class="table-header-center text-center-capitalize">
                                  <!-- <td rowspan="2" style="width:2%;">S.No.</td> -->
                                  <td rowspan="2" >Reason for keeping in Call Book</td>
                                  <td rowspan="2" >Adjudicating Authority</td>
                                  <td colspan="2">Opening Balance</td>
                                  <td colspan="2">Receipt</td>
                                  <td colspan="2">Disposal</td>
                                  <td colspan="2">Closing Balance</td>
                                  <td colspan="4">Age wise Break up of pendency</td>
                         </tr>
                         <tr class="table-header-center">
                         
                             <td>No </td>
                             <td>Amount </td>
                             <td>No </td>
                             <td>Amount </td>
                             <td>No </td>
                             <td>Amount </td>
                             <td>No </td>
                             <td>Amount </td>
                             <td>Less than 6 months </td>
                              <td>6  to 12 months </td>
                             <td>1 year to 2 years </td>
                              <td>More than 2 years </td>                           
                         </tr>
                
                          <tr>
                                 
                                  <!-- <th class="text-center header-text-readonly" rowspan="3">1</th> -->
                                  <th class="header-text-readonly" rowspan="3">
                                    <select class="form-control" id="ddlPopupRegionLst" required="true">
                                        <!-- <option value="1">Appeals filed by the department on the same issue</option>
                                        <option value="2">Injunction issued by the Courts</option>
                                        <option value="3">C&AG Audit objections contested</option>
                                        <option value="4">Board's specific direction to keep the cases in CASES PENDING UNDER SECTION 75(11) OF CGST ACT/Others</option> -->
                                    </select>
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="CRR" name="CRR" value="${CRR}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%=session.getAttribute("CSRF_Token") %>">
                                    <input type="hidden" name="REASON_ID" id="REASON_ID">
                                    <input type="hidden" name="REASON_FOR_KEEPING_IN_CALL_BOOK" id="REASON_FOR_KEEPING_IN_CALL_BOOK">
                                    <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />  
                                </th>
                                  <th class="header-text-readonly">ADC/JC</th>
                                  <td>
                                     
                                      <input path="ADC_OPENING_NO" type="text" maxlength="18"placeholder="0" name="ADC_OPENING_NO" id="ADC_OPENING_NO" 
                                       class="form-control min-width-90 pop-main-ADC_OPENING_NO clsChange clsCount_addNo_1" 
                                       data-id="1" 
                                      autocomplete="off" value= "" readonly="true"  tabindex="-1"/>
                                         <form:errors path="ADC_OPENING_NO" cssClass="error" /> 
                                         
                                  </td>
                                   <td>                                    
                                     <input path="ADC_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="ADC_OPENING_AMT" id="ADC_OPENING_AMT" 
                                     class="form-control min-width-90 pop-main-ADC_OPENING_AMT clsChange clsCount_addAmt_1" data-id="1" autocomplete="off" 
                                      value= "" readonly="true" tabindex="-1"/>
                                         <form:errors path="ADC_OPENING_AMT" cssClass="error" />                                  
                                  </td> 
                                  
                                  <td>
                                      <input path="ADC_RECEIPT_NO" type="text" maxlength="18"placeholder="0" name="ADC_RECEIPT_NO" id="ADC_RECEIPT_NO" 
                                      class="form-control min-width-90 clsChange clsCount_addNo_1" data-id="1"
                                      autocomplete="off" value= "" data-name="RECPT_NO"
                                      onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                         <form:errors path="ADC_RECEIPT_NO" cssClass="error" /> 
                                         
                                  </td>
                                   <td>                                    
                                     <input path="ADC_RECEIPT_AMT" type="text" maxlength="18"placeholder="0.00" name="ADC_RECEIPT_AMT" id="ADC_RECEIPT_AMT" 
                                     class="form-control min-width-90 clsChange clsCount_addAmt_1" data-id="1" autocomplete="off" 
                                      value= "" data-name="RECPT_AMT"
                                      onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                         <form:errors path="ADC_RECEIPT_AMT" cssClass="error" />                                  
                                  </td>  
                                  
                                  <td>
                                      <input path="ADC_DISPOSAL_NO" type="text" maxlength="18"placeholder="0" name="ADC_DISPOSAL_NO" id="ADC_DISPOSAL_NO" 
                                      class="form-control min-width-90 clsChange clsCount_DispNo_1" data-id="1" data-name="DISP_NO"
                                      autocomplete="off" value= ""
                                      onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                         <form:errors path="ADC_DISPOSAL_NO" cssClass="error" /> 
                                         
                                  </td>
                                   <td>                                    
                                     <input path="ADC_DISPOSAL_AMT" type="text" maxlength="18"placeholder="0.00" name="ADC_DISPOSAL_AMT" id="ADC_DISPOSAL_AMT" 
                                     class="form-control min-width-90 clsChange clsCount_DispAmt_1" data-id="1" data-name="DISP_AMT"
                                     autocomplete="off" 
                                      value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                         <form:errors path="ADC_DISPOSAL_AMT" cssClass="error" />                                  
                                  </td>  
                                  
                                  <td>
                                      <input path="ADC_CLOSING_NO" type="text" maxlength="18"placeholder="0" name="ADC_CLOSING_NO" id="ADC_CLOSING_NO" 
                                      class="form-control min-width-90 clsCount_ClosingNo_1" 
                                      autocomplete="off" value= ""
                                      onkeypress="return event.charCode >= 48 && event.charCode <= 57" readonly="true" tabindex="-1"  />
                                         <form:errors path="ADC_CLOSING_NO" cssClass="error" /> 
                                         
                                  </td>
                                   <td>                                    
                                     <input path="ADC_CLOSING_AMT" type="text" maxlength="18"placeholder="0.00" name="ADC_CLOSING_AMT" id="ADC_CLOSING_AMT" 
                                     class="form-control min-width-90 clsCount_ClosingAmt_1" autocomplete="off" readonly="true" tabindex="-1" 
                                      value= ""   />
                                         <form:errors path="ADC_CLOSING_AMT" cssClass="error" />                                  
                                  </td>  
                                  
                                  <td>
                                      <input path="ADC_AGE_LESS_6_NO" type="text" maxlength="18"placeholder="0" name="ADC_AGE_LESS_6_NO" id="ADC_AGE_LESS_6_NO" 
                                      class="form-control min-width-90 clsChange clsCount_AgeNo_1" data-id="1"
                                      autocomplete="off" value= ""
                                      onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                         <form:errors path="ADC_AGE_LESS_6_NO" cssClass="error" /> 
                                         
                                  </td>
                                   <td>                                    
                                     <input path="ADC_AGE_6_TO_12_NO" type="text" maxlength="18"placeholder="0" name="ADC_AGE_6_TO_12_NO" id="ADC_AGE_6_TO_12_NO" 
                                     class="form-control min-width-90 clsChange clsCount_AgeNo_1" data-id="1" autocomplete="off" 
                                      value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                         <form:errors path="ADC_AGE_6_TO_12_NO" cssClass="error" />                                  
                                  </td>  
                                  
                                  <td>
                                      <input path="ADC_AGE_1_TO_2_NO" type="text" maxlength="18"placeholder="0" name="ADC_AGE_1_TO_2_NO" id="ADC_AGE_1_TO_2_NO" 
                                      class="form-control min-width-90 clsChange clsCount_AgeNo_1" data-id="1"
                                      autocomplete="off" value= ""
                                      onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                         <form:errors path="ADC_AGE_1_TO_2_NO" cssClass="error" /> 
                                         
                                  </td>
                                   <td>                                    
                                     <input path="ADC_AGE_MORE_THAN_2_NO" type="text" maxlength="18"placeholder="0" name="ADC_AGE_MORE_THAN_2_NO" id="ADC_AGE_MORE_THAN_2_NO" 
                                     class="form-control min-width-90 clsChange clsCount_AgeNo_1" data-id="1" autocomplete="off" 
                                      value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                         <form:errors path="ADC_AGE_MORE_THAN_2_NO" cssClass="error" />                                  
                                  </td>  
                             </tr>

                             <tr>
                                 
                                <th class="header-text-readonly">DC/AC</th>
                                 <td>
                                    <input path="DC_OPENING_NO" type="text" maxlength="18"placeholder="0" name="DC_OPENING_NO" id="DC_OPENING_NO" 
                                    class="form-control min-width-90 pop-main-DC_OPENING_NO clsChange clsCount_addNo_2" data-id="2"
                                    autocomplete="off" value= ""readonly="true" tabindex="-1" />
                                       
                                </td>
                                 <td>                                    
                                   <input path="DC_OPENING_AMT" type="text" maxlength="18" placeholder="0.00" name="DC_OPENING_AMT" id="DC_OPENING_AMT" 
                                   class="form-control min-width-90 pop-main-DC_OPENING_AMT clsChange clsCount_addAmt_2" data-id="2" autocomplete="off" 
                                    value= "" readonly="true" tabindex="-1" />
                                </td> 
                                
                                <td>
                                    <input path="DC_RECEIPT_NO" type="text" maxlength="18"placeholder="0" name="DC_RECEIPT_NO" id="DC_RECEIPT_NO" 
                                    class="form-control min-width-90 clsChange clsCount_addNo_2" data-id="2"
                                    autocomplete="off" value= "" data-name="RECPT_NO" 
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="DC_RECEIPT_NO" cssClass="error" /> 
                                       
                                </td>

                                 <td>                                    
                                   <input path="DC_RECEIPT_AMT" type="text" maxlength="18"placeholder="0.00" name="DC_RECEIPT_AMT" id="DC_RECEIPT_AMT" 
                                   class="form-control min-width-90 clsChange clsCount_addAmt_2" data-id="2"  autocomplete="off" 
                                    value= "" data-name="RECPT_AMT" 
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                       <errors path="DC_RECEIPT_AMT" cssClass="error" />                                  
                                </td>  
                                
                                <td>
                                    <input path="DC_DISPOSAL_NO" type="text" maxlength="18"placeholder="0" name="DC_DISPOSAL_NO" 
                                    id="DC_DISPOSAL_NO" class="form-control min-width-90 clsChange clsCount_DispNo_2" 
                                    data-id="2" data-name="DISP_NO"
                                    autocomplete="off" value= ""
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="DC_DISPOSAL_NO" cssClass="error" /> 
                                       
                                </td>
                                 <td>                                    
                                   <input path="DC_DISPOSAL_AMT" type="text" maxlength="18"placeholder="0.00" name="DC_DISPOSAL_AMT" 
                                   id="DC_DISPOSAL_AMT" class="form-control min-width-90 clsChange clsCount_DispAmt_2" data-id="2" 
                                   data-name="DISP_AMT" autocomplete="off" 
                                    value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                       <errors path="DC_DISPOSAL_AMT" cssClass="error" />                                  
                                </td>  
                                
                                <td>
                                    <input path="DC_CLOSING_NO" type="text" maxlength="18"placeholder="0" name="DC_CLOSING_NO" 
                                    id="DC_CLOSING_NO" class="form-control min-width-90 clsCount_ClosingNo_2" 
                                    autocomplete="off" value= "" readonly="true" tabindex="-1" />
                                       <errors path="DC_CLOSING_NO" cssClass="error" /> 
                                       
                                </td>
                                 <td>                                    
                                   <input path="DC_CLOSING_AMT" type="text" maxlength="18"placeholder="0.00" name="DC_CLOSING_AMT" 
                                   id="DC_CLOSING_AMT" class="form-control min-width-90 clsCount_ClosingAmt_2" 
                                   autocomplete="off" readonly="true" tabindex="-1" value= ""   />
                                       <errors path="DC_CLOSING_AMT" cssClass="error" />                                  
                                </td>  
                                
                                <td>
                                    <input path="DC_AGE_LESS_6_NO" type="text" maxlength="18"placeholder="0" name="DC_AGE_LESS_6_NO" id="DC_AGE_LESS_6_NO" class="form-control min-width-90" 
                                    autocomplete="off" value= ""
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="DC_AGE_LESS_6_NO" cssClass="error" /> 
                                       
                                </td>
                                 <td>                                    
                                   <input path="DC_AGE_6_TO_12_NO" type="text" maxlength="18"placeholder="0" name="DC_AGE_6_TO_12_NO" id="DC_AGE_6_TO_12_NO" class="form-control min-width-90" autocomplete="off" 
                                   value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="DC_AGE_6_TO_12_NO" cssClass="error" />                                  
                                </td>  
                                
                                <td>
                                    <input path="DC_AGE_1_TO_2_NO" type="text" maxlength="18"placeholder="0" name="DC_AGE_1_TO_2_NO" id="DC_AGE_1_TO_2_NO" class="form-control min-width-90" 
                                    autocomplete="off" value= ""
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="DC_AGE_1_TO_2_NO" cssClass="error" /> 
                                       
                                </td>
                                 <td>                                    
                                   <input path="DC_AGE_MORE_THAN_2_NO" type="text" maxlength="18"placeholder="0" name="DC_AGE_MORE_THAN_2_NO" id="DC_AGE_MORE_THAN_2_NO" class="form-control min-width-90" autocomplete="off" 
                                    value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="DC_AGE_MORE_THAN_2_NO" cssClass="error" />                                  
                                </td>  
                            </tr>   
                            
                            <tr>
                                <th class="header-text-readonly">Superintendent</th>
                                 <td>
                                    <input path="SUP_OPENING_NO" type="text" maxlength="18"placeholder="0" name="SUP_OPENING_NO" id="SUP_OPENING_NO" 
                                    class="form-control min-width-90 pop-main-SUP_OPENING_NO clsCount_addNo_3" data-id="3" 
                                    autocomplete="off" value= "" readonly="true" tabindex="-1" />
                                       <errors path="SUP_OPENING_NO" cssClass="error" /> 
                                       
                                </td>
                                 <td>                                    
                                   <input path="SUP_OPENING_AMT" type="text" maxlength="18"placeholder="0.00" name="SUP_OPENING_AMT" id="SUP_OPENING_AMT" 
                                   class="form-control min-width-90 pop-main-SUP_OPENING_AMT clsCount_addAmt_3" data-id="3" autocomplete="off" 
                                    value= "" readonly="true" tabindex="-1" />
                                                                    
                                </td> 
                                
                                <td>
                                    <input path="SUP_RECEIPT_NO" type="text" maxlength="18"placeholder="0" name="SUP_RECEIPT_NO" id="SUP_RECEIPT_NO" 
                                    class="form-control min-width-90 clsChange clsCount_addNo_3" data-id="3" data-name="RECPT_NO"
                                    autocomplete="off" value= "" 
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="SUP_RECEIPT_NO" cssClass="error" /> 
                                       
                                </td>
                                 <td>                                    
                                   <input path="SUP_RECEIPT_AMT" type="text" maxlength="18"placeholder="0.00" name="SUP_RECEIPT_AMT" id="SUP_RECEIPT_AMT" 
                                   class="form-control min-width-90 clsChange clsCount_addAmt_3" data-id="3" autocomplete="off" 
                                    value= "" data-name="RECPT_AMT" 
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"   />
                                       <errors path="SUP_RECEIPT_AMT" cssClass="error" />                                  
                                </td>  
                                
                                <td>
                                    <input path="SUP_DISPOSAL_NO" type="text" maxlength="18"placeholder="0" name="SUP_DISPOSAL_NO" id="SUP_DISPOSAL_NO" 
                                    class="form-control min-width-90 clsChange clsCount_DispNo_3" data-id="3" 
                                    autocomplete="off" value= "" data-name="DISP_NO"
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="SUP_DISPOSAL_NO" cssClass="error" /> 
                                       
                                </td>
                                 <td>                                    
                                   <input path="SUP_DISPOSAL_AMT" type="text" maxlength="18"placeholder="0.00" 
                                   name="SUP_DISPOSAL_AMT" id="SUP_DISPOSAL_AMT" class="form-control min-width-90 clsChange clsCount_DispAmt_3" data-id="3" 
                                   autocomplete="off"  data-name="DISP_AMT"
                                    value= "" required = "true"   />
                                       <errors path="SUP_DISPOSAL_AMT" cssClass="error" />                                  
                                </td>  
                                
                                <td>
                                    <input path="SUP_CLOSING_NO" type="text" maxlength="18"placeholder="0" name="SUP_CLOSING_NO" id="SUP_CLOSING_NO" 
                                    class="form-control min-width-90 clsCount_ClosingNo_3" 
                                    autocomplete="off" value="" readonly="true"  tabindex="-1" />
                                       
                                </td>
                                 <td>                                    
                                   <input path="SUP_CLOSING_AMT" type="text" maxlength="18"placeholder="0.00" name="SUP_CLOSING_AMT" id="SUP_CLOSING_AMT" 
                                   class="form-control min-width-90 clsCount_ClosingAmt_3"  autocomplete="off" readonly="true" tabindex="-1" 
                                    value="" />
                                                                     
                                </td>  
                                
                                <td>
                                    <input path="SUP_AGE_LESS_6_NO" type="text" maxlength="18"placeholder="0" name="SUP_AGE_LESS_6_NO" id="SUP_AGE_LESS_6_NO" class="form-control min-width-90" 
                                    autocomplete="off" value= ""
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="SUP_AGE_LESS_6_NO" cssClass="error" /> 
                                       
                                </td>
                                 <td>                                    
                                   <input path="SUP_AGE_6_TO_12_NO" type="text" maxlength="18"placeholder="0" name="SUP_AGE_6_TO_12_NO" id="SUP_AGE_6_TO_12_NO" class="form-control min-width-90" autocomplete="off" 
                                    value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="SUP_AGE_6_TO_12_NO" cssClass="error" />                                  
                                </td>  
                                
                                <td>
                                    <input path="SUP_AGE_1_TO_2_NO" type="text" maxlength="18"placeholder="0" name="SUP_AGE_1_TO_2_NO" id="SUP_AGE_1_TO_2_NO" class="form-control min-width-90" 
                                    autocomplete="off" value= ""
                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="SUP_AGE_1_TO_2_NO" cssClass="error" /> 
                                       
                                </td>
                                 <td>                                    
                                   <input path="SUP_AGE_MORE_THAN_2_NO" type="text" maxlength="18"placeholder="0" name="SUP_AGE_MORE_THAN_2_NO" id="SUP_AGE_MORE_THAN_2_NO" class="form-control min-width-90" autocomplete="off" 
                                    value= "" onkeypress="return event.charCode >= 48 && event.charCode <= 57" required = "true"   />
                                       <errors path="SUP_AGE_MORE_THAN_2_NO" cssClass="error" />                                  
                                </td>  
                            </tr> 
                     </table>
              </div>

                <div class="modal-footer">
                    <!-- <button type="button" class="btn btn-danger" data-dismiss="modal" style="margin-right:10px;"
                        id="cancel_button">Close</button> -->
                    <input type="submit" name="btn_submit" class="btn btn-success"
                        value="Upload" id="btn_submit_ID" /> 

                </div>
        </div>
    </div>
</form>


<script src="<%=session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js">
</script>
<script src="<%=session.getAttribute("COMMON_PATH_RESOLVE") %>Content-Common/js/jquery.js">
</script>
<script src="<%=session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js">
</script>
<script src="<%=session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.unobtrusive.js"></script>



<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


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
                {ś
            	  $("#btn_submit").val("Submit");
                }
        }
        
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

        GetCALLBOOK_REGIONLst();
        if($('#MM_YYYY').val()==""|| $('#MM_YYYY').val()==null)
        {
           alert('Sorry your session has expired.! Please login again....')
        }
        else if($('#MM_YYYY').val()=='2023-04-01')
        { 
            if('${APR_2023_OPENING}'=='false')
            popUpOpeningBalance();
        }

        // $('.form-control').keyup(function(){
        // 	var val = $(this).val();
        //     if(isNaN(val)){
        //          val = val.replace(/[^0-9\.]/g,'');
        //          if(val.split('.').length>2) 
        //              val =val.replace(/\.+$/,"");
        //     }
        //     $(this).val(val); 
        // });

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

    /* $(document).on("keyup", function(e) {
    	for (let element of document.getElementsByClassName("error")){
    		
    		element.style.display="none";
    		}
	}); */

    function addNewData() {

        $("#ddlPopupRegionLst").val('');   
        $("#ddlPopupRegionLst").attr("disabled",false);        
    $("#REASON_ID").val(''); 
	$("#REASON_FOR_KEEPING_IN_CALL_BOOK").val(''); 
	$("#ADC_OPENING_NO").val(''); 
	$("#ADC_OPENING_AMT").val(''); 
	$("#ADC_RECEIPT_NO").val(''); 
	$("#ADC_RECEIPT_AMT").val(''); 
	$("#ADC_DISPOSAL_NO").val(''); 
	$("#ADC_DISPOSAL_AMT").val(''); 
	$("#ADC_CLOSING_NO").val(''); 
	$("#ADC_CLOSING_AMT").val(''); 
	$("#ADC_AGE_LESS_6_NO").val(''); 
	$("#ADC_AGE_6_TO_12_NO").val(''); 
	$("#ADC_AGE_1_TO_2_NO").val(''); 
	$("#ADC_AGE_MORE_THAN_2_NO").val(''); 
	$("#DC_OPENING_NO").val(''); 
	$("#DC_OPENING_AMT").val(''); 
	$("#DC_RECEIPT_NO").val(''); 
	$("#DC_RECEIPT_AMT").val(''); 
	$("#DC_DISPOSAL_NO").val(''); 
	$("#DC_DISPOSAL_AMT").val(''); 
	$("#DC_CLOSING_NO").val(''); 
	$("#DC_CLOSING_AMT").val(''); 
	$("#DC_AGE_LESS_6_NO").val(''); 
	$("#DC_AGE_6_TO_12_NO").val(''); 
	$("#DC_AGE_1_TO_2_NO").val(''); 
	$("#DC_AGE_MORE_THAN_2_NO").val(''); 
	$("#SUP_OPENING_NO").val(''); 
	$("#SUP_OPENING_AMT").val(''); 
	$("#SUP_RECEIPT_NO").val(''); 
	$("#SUP_RECEIPT_AMT").val(''); 
	$("#SUP_DISPOSAL_NO").val(''); 
	$("#SUP_DISPOSAL_AMT").val('');  
	$("#SUP_CLOSING_NO").val(''); 
	$("#SUP_CLOSING_AMT").val(''); 
	$("#SUP_AGE_LESS_6_NO").val(''); 
	$("#SUP_AGE_6_TO_12_NO").val(''); 
	$("#SUP_AGE_1_TO_2_NO").val(''); 
	$("#SUP_AGE_MORE_THAN_2_NO").val('');
			
	  $('#Modal2').modal({
	            show: true,
	            backdrop: false,
	            keyboard: false
	  });
	}

    function GetReport( 
	REASON_ID,ADC_OPENING_NO,ADC_OPENING_AMT,ADC_RECEIPT_NO, 
	ADC_RECEIPT_AMT,ADC_DISPOSAL_NO,ADC_DISPOSAL_AMT,ADC_CLOSING_NO,ADC_CLOSING_AMT, 
	ADC_AGE_LESS_6_NO,ADC_AGE_6_TO_12_NO,ADC_AGE_1_TO_2_NO,ADC_AGE_MORE_THAN_2_NO, 
	DC_OPENING_NO,DC_OPENING_AMT,DC_RECEIPT_NO,DC_RECEIPT_AMT, 
	DC_DISPOSAL_NO, 
	DC_DISPOSAL_AMT, 
	DC_CLOSING_NO, 
	DC_CLOSING_AMT, 
	DC_AGE_LESS_6_NO, 
	DC_AGE_6_TO_12_NO, 
	DC_AGE_1_TO_2_NO, 
	DC_AGE_MORE_THAN_2_NO, 
	SUP_OPENING_NO, 
	SUP_OPENING_AMT, 
	SUP_RECEIPT_NO, 
	SUP_RECEIPT_AMT, 
	SUP_DISPOSAL_NO, 
	SUP_DISPOSAL_AMT, 
	SUP_CLOSING_NO, 
	SUP_CLOSING_AMT, 
	SUP_AGE_LESS_6_NO, 
	SUP_AGE_6_TO_12_NO, 
	SUP_AGE_1_TO_2_NO, 
	SUP_AGE_MORE_THAN_2_NO,) {
			
        $("#ddlPopupRegionLst").val(REASON_ID);   
        $("#ddlPopupRegionLst").attr("disabled",true);        
    $("#REASON_ID").val(REASON_ID); 
	$("#REASON_FOR_KEEPING_IN_CALL_BOOK").val(REASON_FOR_KEEPING_IN_CALL_BOOK); 
	$("#ADC_OPENING_NO").val(ADC_OPENING_NO); 
	$("#ADC_OPENING_AMT").val(ADC_OPENING_AMT); 
	$("#ADC_RECEIPT_NO").val(ADC_RECEIPT_NO); 
	$("#ADC_RECEIPT_AMT").val(ADC_RECEIPT_AMT); 
	$("#ADC_DISPOSAL_NO").val(ADC_DISPOSAL_NO); 
	$("#ADC_DISPOSAL_AMT").val(ADC_DISPOSAL_AMT); 
	$("#ADC_CLOSING_NO").val(ADC_CLOSING_NO); 
	$("#ADC_CLOSING_AMT").val(ADC_CLOSING_AMT); 
	$("#ADC_AGE_LESS_6_NO").val(ADC_AGE_LESS_6_NO); 
	$("#ADC_AGE_6_TO_12_NO").val(ADC_AGE_6_TO_12_NO); 
	$("#ADC_AGE_1_TO_2_NO").val(ADC_AGE_1_TO_2_NO); 
	$("#ADC_AGE_MORE_THAN_2_NO").val(ADC_AGE_MORE_THAN_2_NO); 
	$("#DC_OPENING_NO").val(DC_OPENING_NO); 
	$("#DC_OPENING_AMT").val(DC_OPENING_AMT); 
	$("#DC_RECEIPT_NO").val(DC_RECEIPT_NO); 
	$("#DC_RECEIPT_AMT").val(DC_RECEIPT_AMT); 
	$("#DC_DISPOSAL_NO").val(DC_DISPOSAL_NO); 
	$("#DC_DISPOSAL_AMT").val(DC_DISPOSAL_AMT); 
	$("#DC_CLOSING_NO").val(DC_CLOSING_NO); 
	$("#DC_CLOSING_AMT").val(DC_CLOSING_AMT); 
	$("#DC_AGE_LESS_6_NO").val(DC_AGE_LESS_6_NO); 
	$("#DC_AGE_6_TO_12_NO").val(DC_AGE_6_TO_12_NO); 
	$("#DC_AGE_1_TO_2_NO").val(DC_AGE_1_TO_2_NO); 
	$("#DC_AGE_MORE_THAN_2_NO").val(DC_AGE_MORE_THAN_2_NO); 
	$("#SUP_OPENING_NO").val(SUP_OPENING_NO); 
	$("#SUP_OPENING_AMT").val(SUP_OPENING_AMT); 
	$("#SUP_RECEIPT_NO").val(SUP_RECEIPT_NO); 
	$("#SUP_RECEIPT_AMT").val(SUP_RECEIPT_AMT); 
	$("#SUP_DISPOSAL_NO").val(SUP_DISPOSAL_NO); 
	$("#SUP_DISPOSAL_AMT").val(SUP_DISPOSAL_AMT); 
	$("#SUP_CLOSING_NO").val(SUP_CLOSING_NO); 
	$("#SUP_CLOSING_AMT").val(SUP_CLOSING_AMT); 
	$("#SUP_AGE_LESS_6_NO").val(SUP_AGE_LESS_6_NO); 
	$("#SUP_AGE_6_TO_12_NO").val(SUP_AGE_6_TO_12_NO); 
	$("#SUP_AGE_1_TO_2_NO").val(SUP_AGE_1_TO_2_NO); 
	$("#SUP_AGE_MORE_THAN_2_NO").val(SUP_AGE_MORE_THAN_2_NO);
			
			$('#Modal2').modal({
	            show: true,
	            backdrop: false,
	            keyboard: false
	        });
       
            $('#btn_submit_ID').val('Update');
	}

        function popUpOpeningBalance() {
			
			$('#openingBox').modal({
	            show: true,
	            backdrop: false,
	            keyboard: false
	        });
		}    

        function GetCALLBOOK_REGIONLst() {
            
            //var url = "/GSTDPM/CallbookRegionListBind/";
            var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTDPM/CallbookRegionListBind/";
            //var form = $('#__AjaxAntiForgeryForm');
            //var token = $('input[name="__RequestVerificationToken"]', form).val();
			 var _MM_YYYY=$('#MM_YYYY').val();

            $.ajax({
                url: url,
                data: { MM_YYYY: _MM_YYYY },
                cache: false,
                type: "GET",
                success: function (data) {
                	
                    var data=JSON.parse(data.JSONdata);
             
                    var markup="";
                    markup+="<option value='' disabled='disabled' style='background-color: gray;color: black;'>Choose Callbook Region </option>";
                    for (var x = 0; x < data.length; x++) {
                        // markup += "<option value=" + data[x].ID + " data-adc-opening-no="+data[x].ADC_OPENING_NO+">" + " data-adc-opening-amt="+data[x].ADC_OPENING_AMT+">"+ " data-dc-opening-no="+data[x].DC_OPENING_NO+">"+ " data-dc-opening-amt="+data[x].DC_OPENING_AMT+">"+ " data-sup-opening-no="+data[x].SUP_OPENING_NO+">"+ " data-sup-opening-amt="+data[x].SUP_OPENING_AMT+">" + data[x].REGION_NAME + "</option>";
                        if(data[x].ISEXISTDATA=='1')
                          markup += "<option title='This call book reason data is already uploaded!.' disabled='disabled' style='background-color: aliceblue;color: black;' value=" + data[x].ID + " data-adc-no="+data[x].ADC_OPENING_NO+ " data-adc-amt="+data[x].ADC_OPENING_AMT+" data-dc-no="+data[x].DC_OPENING_NO+ " data-dc-amt="+data[x].DC_OPENING_AMT+" data-sup-no="+data[x].SUP_OPENING_NO+ " data-sup-amt="+data[x].SUP_OPENING_AMT+">" + data[x].REGION_NAME + "</option>";
                        else
                          markup += "<option value=" + data[x].ID + " data-adc-no="+data[x].ADC_OPENING_NO+ " data-adc-amt="+data[x].ADC_OPENING_AMT+" data-dc-no="+data[x].DC_OPENING_NO+ " data-dc-amt="+data[x].DC_OPENING_AMT+" data-sup-no="+data[x].SUP_OPENING_NO+ " data-sup-amt="+data[x].SUP_OPENING_AMT+">" + data[x].REGION_NAME + "</option>";
                        
                    }
                    $("#ddlPopupRegionLst").html(markup);
                },
                error: function (reponse) {
                    //alert("error : " + reponse);
                }
            });
    }
    
    $('#ddlPopupRegionLst').change(function(){
            if($('#ddlPopupRegionLst').val()!='')
                {
                    // alert($(this).find(':selected').data('adc-no'));
                    $('#REASON_ID').val($(this).find(':selected').val());
                    $('#REASON_FOR_KEEPING_IN_CALL_BOOK').val($(this).find(':selected').text());
                    $(".pop-main-ADC_OPENING_NO").val($(this).find(':selected').data('adc-no'));
                    $('.pop-main-ADC_OPENING_AMT').val($(this).find(':selected').data('adc-amt'));

                    $(".pop-main-DC_OPENING_NO").val($(this).find(':selected').data('dc-no'));
                    $(".pop-main-DC_OPENING_AMT").val($(this).find(':selected').data('dc-amt'));

                    $(".pop-main-SUP_OPENING_NO").val($(this).find(':selected').data('sup-no'));
                    $(".pop-main-SUP_OPENING_AMT").val($(this).find(':selected').data('sup-amt'));
                
                }
            else
                {
                    $('#REASON_ID').val('');
                    $('#REASON_FOR_KEEPING_IN_CALL_BOOK').val('');
                    $(".pop-main-ADC_OPENING_NO").val('');
                    $('.pop-main-ADC_OPENING_AMT').val('');

                    $(".pop-main-DC_OPENING_NO").val('');
                    $(".pop-main-DC_OPENING_AMT").val('');

                    $(".pop-main-SUP_OPENING_NO").val('');
                    $(".pop-main-SUP_OPENING_AMT").val('');
                }
            });

            
</script>

<script type="text/javascript">
    jQuery('.clsChange').change(function () {
        var self = jQuery(this);
        var row = self.data('id');
        debugger;
        var ChkName = self.data('name');
        ClearField(ChkName, row);

        var total_Add_OpeningNo_Cls = 'clsCount_addNo_' + row;
        var total_Add_OpeningNo = parseFloat(calculateItemQty(total_Add_OpeningNo_Cls));               // Cal Opening + Receipt No....
        var total_Add_OpeningAmt_Cls = 'clsCount_addAmt_' + row;
        var total_Add_OpeningAmt = parseFloat(calculateItemQty(total_Add_OpeningAmt_Cls));               // Cal Opening + Receipt No....


        //start to Calculate The Disposal ..
        var total_Add_DisposalNo_Cls = 'clsCount_DispNo_' + row;
        var total_Add_DisposalNo = parseFloat(calculateItemQty(total_Add_DisposalNo_Cls));               // Cal All Disposal
        var TotalClosing_No = parseFloat(total_Add_OpeningNo - total_Add_DisposalNo);           // Calculate the Closing No.
        $('.clsCount_ClosingNo_' + row).val(TotalClosing_No);    //set the Closing No.
        if (TotalClosing_No < 0) {
            alert('Closing balance can not be negative');
            var getSubtractVal = self.val();
            self.val(0);
            TotalClosing_No = TotalClosing_No + parseFloat(getSubtractVal);
            $('.clsCount_ClosingNo_' + row).val(TotalClosing_No);    //set the Closing No.
        }

        var total_Add_DisposalAmt_Cls = 'clsCount_DispAmt_' + row;
        var total_Add_DisposalAmt = parseFloat(calculateItemQty(total_Add_DisposalAmt_Cls));               // Cal All Disposal
        var TotalClosing_Amt = parseFloat((total_Add_OpeningAmt - total_Add_DisposalAmt).toFixed(2));           // Calculate the Closing No.
        $('.clsCount_ClosingAmt_' + row).val(TotalClosing_Amt.toFixed(2));    //set the Closing Amt.
        if (TotalClosing_Amt < 0) {

            alert('Closing amount can not be negative');
            var getSubtractVal = self.val();
            self.val(0);
            TotalClosing_Amt = TotalClosing_Amt + parseFloat(getSubtractVal);
            $('.clsCount_ClosingAmt_' + row).val(TotalClosing_Amt.toFixed(2));    //set the Closing Amt.
        }



        //Start To Calculate the Age-wise Breakup....
        var total_Add_AgeNo_Cls = 'clsCount_AgeNo_' + row;
        var total_Add_AgeNo = parseFloat(calculateItemQty(total_Add_AgeNo_Cls));               // Cal All The Age-wise Breakup No..
        var TotalAge_No = parseFloat(TotalClosing_No - total_Add_AgeNo);
        $('.clsCount_Age_ClosingNo_' + row).val(TotalAge_No);    //set the AgeWise Breakup No.
        if (TotalAge_No < 0) {
            alert('Ase-wise breakup no can not be negative');
            var getSubtractVal = self.val();
            self.val(0);
            $('.clsCount_Age_ClosingNo_' + row).val(TotalAge_No + parseFloat(getSubtractVal));    //set the AgeWise Breakup No.
        }

        var total_Add_AgeAmt_Cls = 'clsCount_AgeAmt_' + row;
        var total_Add_AgeAmt = parseFloat(calculateItemQty(total_Add_AgeAmt_Cls));               // Cal All The Age-wise Breakup No..
        var TotalAge_Amt = parseFloat(TotalClosing_Amt - total_Add_AgeAmt);
        $('.clsCount_Age_ClosingAmt_' + row).val(TotalAge_Amt.toFixed(2));    //set the AgeWise Breakup No.
        if (TotalAge_Amt < 0) {
            alert('Ase-wise breakup Amount can not be negative');
            var getSubtractVal = self.val().toFixed(2);
            self.val(0);
            $('.clsCount_Age_ClosingAmt_' + row).val(TotalAge_Amt.toFixed(2) + parseFloat(getSubtractVal));    //set the AgeWise Breakup No.
        }

    });

    function calculateItemQty(cls) {
        var sum = 0;
        $('.' + cls).each(function () {

            //add only if the value is number
            if (!isNaN(this.value) && this.value.length != 0) {
                sum += parseFloat(this.value);
            }

        });
        return sum;
    };

    function ClearField(ChkName, row) {
        if (ChkName == 'RECPT_NO') {
            $('.clsCount_DispNo_' + row).val(0);
            $('.clsCount_AgeNo_' + row).val(0);
        }
        else if (ChkName == 'RECPT_AMT') {
            $('.clsCount_DispAmt_' + row).val(0);
            $('.clsCount_AgeAmt_' + row).val(0);
        }
        else if (ChkName == 'DISP_NO') {
            $('.clsCount_AgeNo_' + row).val(0);
        }
        else if (ChkName == 'DISP_AMT') {
            $('.clsCount_AgeAmt_' + row).val(0);
        }
    }
</script>

<jsp:include page="../../GSTHome/Footer.jsp" />


