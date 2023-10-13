<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../GSTHome/Header.jsp" />

<div id="page-wrapper">
    <div class="row">
              <div class="col-lg-6">
            <h4 class="page-header p-b-0 no-border">
                <i class="fa fa-book fa-fw"></i>  GST-RTN-1
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
    <form:form action="/MPR/GSTGST/Insert/GST_GST_2" id="gstGst2CommTemp" name = "gstGst2CommTemp" method="POST"  modelAttribute="gstGst2CommTemp" >
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
               Status of filing of various GST returns 
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
                
                        <!-- <div class="sub-lakh">(Rs. In Crores)</div> -->
                        <div class="sub-lakh"></div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                        <tbody >
	                    <!-- <tr>
	                    	<th rowspan="9">Number of Taxpayers required to file GST Returns </th>
	                    	<th rowspan="2">Number of Taxpayers required to file GST Returns </th>
	                    </tr> -->
							    
							      
							    <%   
                                String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                String MM_YYYY = (String) request.getAttribute("MM_YYYY");
                                String CRR = (String) request.getAttribute("CRR");
                                %>
                                
                                
						<tr >
						
							<td rowspan="9" width="30%"  class="table-header-center"
							style="text-transform: uppercase;vertical-align: middle !important;">
							Number of Taxpayers required to file GST Returns
							 <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="CRR" name="CRR" value="${CRR}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
							</td>
							<td rowspan="2" style="text-transform: uppercase;vertical-align: middle !important;">Monthly Return</td>
							<td width="20%">GSTR 1M</td>
							<td><form:input path="GSTR_1M_F" type="text"  name="GSTR_1M_F" id="GSTR_1M_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_1M_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                               <form:errors path="GSTR_1M_F" cssClass="error" /></td></tr>
						
						<tr><td>GSTR 3BM</td><td><form:input path="GSTR_3BM_F" type="text"  name="GSTR_3BM_F" id="GSTR_3BM_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3BM_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true" readonly="true" />
                                <form:errors path="GSTR_3BM_F" cssClass="error" /></td></tr>
						<tr><td rowspan="3" style="text-transform: uppercase;vertical-align: middle !important;">Quarterly Return</td><td>GSTR-1Q</td><td><form:input path="GSTR_1Q_F" type="text"  name="GSTR_1Q_F" id="GSTR_1Q_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_1Q_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                              <form:errors path="GSTR_1Q_F" cssClass="error" /></td></tr>
						<tr><td>GSTR-3BQ</td><td><form:input path="GSTR_3BQ_F" type="text"  name="GSTR_3BQ_F" id="GSTR_3BQ_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3BQ_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true" readonly="true" />
		                              <form:errors path="GSTR_3BQ_F" cssClass="error" /></td></tr>
						<tr><td>GST-CMP-08</td><td><form:input path="GST_CMP_08_F" type="text"  name="GST_CMP_08_F" id="GST_CMP_08_F" class="form-control min-width-1" autocomplete="off" value= "${model.GST_CMP_08_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                              <form:errors path="GST_CMP_08_F" cssClass="error" /></td></tr>
						
						<tr><td rowspan="4" style="text-transform: uppercase;vertical-align: middle !important;">Annual Return</td><td>GSTR 4</td><td><form:input path="GSTR_4_F" type="text"  name="GSTR_4_F" id="GSTR_4_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_4_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_4_F" cssClass="error" /></td></tr>
						<tr><td>GSTR 9</td><td><form:input path="GSTR_9_F" type="text"  name="GSTR_9_F" id="GSTR_9_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9_F" cssClass="error" /></td></tr>
						<tr><td>GSTR 9A</td><td><form:input path="GSTR_9A_F" type="text"  name="GSTR_9A_F" id="GSTR_9A_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9A_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9A_F" cssClass="error" /></td></tr>
						<tr><td>GSTR 9C</td><td> <form:input path="GSTR_9C_F" type="text"  name="GSTR_9C_F" id="GSTR_9C_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9C_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9C_F" cssClass="error" /></td></tr>
	                    <tr >
							<td rowspan="9" width="30%" class="table-header-center"
							style="text-transform: uppercase;vertical-align: middle !important;">Taxpayers who filed GST Returns</td>
							<td rowspan="2" style="text-transform: uppercase;vertical-align: middle !important;">Monthly Return</td>
							<td>GSTR 1M</td><td><form:input path="GSTR_1M_D" type="text"  name="GSTR_1M_D" id="GSTR_1M_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_1M_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_1M_D" cssClass="error" /></td></tr>						
							<tr><td>GSTR 3BM</td><td><form:input path="GSTR_3BM_D" type="text"  name="GSTR_3BM_D" id="GSTR_3BM_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3BM_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_3BM_D" cssClass="error" /></td></tr>
						
						<tr><td rowspan="3" style="text-transform: uppercase;vertical-align: middle !important;">Quarterly Return</td><td>GSTR-1Q</td><td><form:input path="GSTR_1Q_D" type="text"  name="GSTR_1Q_D" id="GSTR_1Q_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_1Q_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_1Q_D" cssClass="error" /></td></tr>
						<tr><td>GSTR-3BQ</td><td><form:input path="GSTR_3BQ_D" type="text"  name="GSTR_3BQ_D" id="GSTR_3BQ_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3BQ_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_3BQ_D" cssClass="error" /></td></tr>
						<tr><td>GST-CMP-08</td><td><form:input path="GST_CMP_08_D" type="text"  name="GST_CMP_08_D" id="GST_CMP_08_D" class="form-control min-width-1" autocomplete="off" value= "${model.GST_CMP_08_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GST_CMP_08_D" cssClass="error" /></td></tr>
						
						<tr><td rowspan="4" style="text-transform: uppercase;vertical-align: middle !important;">Annual Return</td><td>GSTR 4</td><td><form:input path="GSTR_4_D" type="text"  name="GSTR_4_D" id="GSTR_4_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_4_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_4_D" cssClass="error" /></td></tr>
						<tr><td>GSTR 9</td><td><form:input path="GSTR_9_D" type="text"  name="GSTR_9_D" id="GSTR_9_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9_D" cssClass="error" />                                        </td></tr>
						<tr><td>GSTR 9A</td><td><form:input path="GSTR_9A_D" type="text"  name="GSTR_9A_D" id="GSTR_9A_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9A_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9A_D" cssClass="error" /></td></tr>
						<tr><td>GSTR 9C</td><td><form:input path="GSTR_9C_D" type="text"  name="GSTR_9C_D" id="GSTR_9C_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9C_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9C_D" cssClass="error" /></td></tr>
						
						<tr><td colspan="2" width="50%" class="table-header-center"
							style="text-transform: uppercase;text-align:left !important;">Taxpayers where GSTR 3A has been issued (out of col no. 29)</td>
						<td colspan="2"><form:input path="GSTR_3A_I" type="text"  name="GSTR_3A_I" id="GSTR_3A_I" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3A_I}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_3A_I" cssClass="error" /></td></tr>
						<tr><td colspan="2" width="50%" class="table-header-center"
							style="text-transform: uppercase;text-align:left !important;">Taxpayers where GSTR 3A has not been issued  (out of col no. 30)</td>
						<td colspan="2"><form:input path="GSTR_3A_NI" type="text"  name="GSTR_3A_NI" id="GSTR_3A_NI" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3A_NI}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_3A_NI" cssClass="error" /></td></tr>
						
						
                                      
	                    
	                    
	                    
	                    
                        
                       <%--  <tr class="table-header-center">
	                        
	                        <td colspan="2">Number of Taxpayers required to file GST Returns</td>
                        </tr>
					    <tr class="table-header-center"> <td  colspan="2">Monthly Return</td></tr> 
					    <tr><td  style="text-align: left" width="60%">GSTR 1M</td>
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

                                    <form:input path="GSTR_1M_F" type="text"  name="GSTR_1M_F" id="GSTR_1M_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_1M_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_1M_F" cssClass="error" />  
                                       
                                </td></tr>                                
				       <tr><td  style="text-align: left" width="60%">GSTR 3BM</td>
				       	  <td>                                    
                             <form:input path="GSTR_3BM_F" type="text"  name="GSTR_3BM_F" id="GSTR_3BM_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3BM_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true" readonly="true" />
                                <form:errors path="GSTR_3BM_F" cssClass="error" />                                        
                         </td>  
				       </tr>
				       
				        <tr class="table-header-center"><td colspan="2">Quarterly Return</td></tr> 
				       <tr><td  style="text-align: left" width="60%">GSTR-1Q</td>
				       	<td>                                    
                           <form:input path="GSTR_1Q_F" type="text"  name="GSTR_1Q_F" id="GSTR_1Q_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_1Q_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                              <form:errors path="GSTR_1Q_F" cssClass="error" />                                        
                        </td></tr>
				       <tr><th  style="text-align: left" width="70%">GSTR-3BQ</th>
					       <td>                                    
		                           <form:input path="GSTR_3BQ_F" type="text"  name="GSTR_3BQ_F" id="GSTR_3BQ_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3BQ_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true" readonly="true" />
		                              <form:errors path="GSTR_3BQ_F" cssClass="error" />                                        
		                       </td> 
                       </tr>
				       <tr><th style="text-align: left" width="70%">GST-CMP-08 </th>
				       <td>                                    
                           <form:input path="GST_CMP_08_F" type="text"  name="GST_CMP_08_F" id="GST_CMP_08_F" class="form-control min-width-1" autocomplete="off" value= "${model.GST_CMP_08_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                              <form:errors path="GST_CMP_08_F" cssClass="error" />                                        
                       </td>
				       </tr>
				       <tr class="table-header-center">
				        <td colspan="2">Annual Return</td></tr> 
				       <tr><th  style="text-align: left" width="70%">GSTR 4</th>
				        <td>                                    
                                    <form:input path="GSTR_4_F" type="text"  name="GSTR_4_F" id="GSTR_4_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_4_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_4_F" cssClass="error" />                                        
                                </td>
				       </tr>
				       <tr><th style="text-align: left" width="70%">GSTR 9</th> 
				       <td>                                    
                                    <form:input path="GSTR_9_F" type="text"  name="GSTR_9_F" id="GSTR_9_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9_F" cssClass="error" />                                        
                                </td> 
                                </tr>
				       <tr><th  style="text-align: left" width="70%">GSTR 9A</th>
				       <td>                                    
                                    <form:input path="GSTR_9A_F" type="text"  name="GSTR_9A_F" id="GSTR_9A_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9A_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9A_F" cssClass="error" />                                        
                                </td>
				       
				       </tr>
				       <tr><th  style="text-align: left" width="70%">GSTR 9C</th>
				        <td>                                    
                                    <form:input path="GSTR_9C_F" type="text"  name="GSTR_9C_F" id="GSTR_9C_F" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9C_F}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9C_F" cssClass="error" />                                        
                                </td> 
				       </tr>
				        <tr class="table-header-center">
				       <td   colspan="2">Taxpayers who filed GST Returns</td></tr>
				       <tr class="table-header-center"><th colspan="2">Monthly Return</th></tr> 
				       
				       <tr> <th  style="text-align: left" width="70%">GSTR 1M</th> <td>
                                    <form:input path="GSTR_1M_D" type="text"  name="GSTR_1M_D" id="GSTR_1M_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_1M_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_1M_D" cssClass="error" />                                         
                                </td></tr>
				       <tr><th  style="text-align: left" width="70%">GSTR 3BM</th> 
				        <td>                                    
                                    <form:input path="GSTR_3BM_D" type="text"  name="GSTR_3BM_D" id="GSTR_3BM_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3BM_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_3BM_D" cssClass="error" />                                        
                                </td> </tr>
				       
				        <tr class="table-header-center"><td colspan="2">Quarterly Return</td></tr> 
				       <tr>
				       
				       <th style="text-align: left" width="70%">GSTR-1Q</th>
				       <td>                                    
                                    <form:input path="GSTR_1Q_D" type="text"  name="GSTR_1Q_D" id="GSTR_1Q_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_1Q_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_1Q_D" cssClass="error" />                                        
                                </td> 
				        </tr>
				       <tr><th  style="text-align: left" width="70%">GSTR-3BQ</th>
				         <td>                                    
                                    <form:input path="GSTR_3BQ_D" type="text"  name="GSTR_3BQ_D" id="GSTR_3BQ_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3BQ_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_3BQ_D" cssClass="error" />                                        
                                </td>  
				       </tr>
				       <tr><th style="text-align: left" width="70%">GST-CMP-08</th>
				       <td>                                    
                                    <form:input path="GST_CMP_08_D" type="text"  name="GST_CMP_08_D" id="GST_CMP_08_D" class="form-control min-width-1" autocomplete="off" value= "${model.GST_CMP_08_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GST_CMP_08_D" cssClass="error" />                                        
                                </td> 
				       </tr>
				       
				        <tr class="table-header-center"><td  colspan="2">Annual Return</td></tr>
				        <tr>				       
				       <th  style="text-align: left" width="70%">GSTR 4</th>
				       <td>                                    
                                    <form:input path="GSTR_4_D" type="text"  name="GSTR_4_D" id="GSTR_4_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_4_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_4_D" cssClass="error" />                                        
                                </td></tr>
				       <tr><th  style="text-align: left" width="70%">GSTR 9</th>
				       <td>                                    
                                    <form:input path="GSTR_9_D" type="text"  name="GSTR_9_D" id="GSTR_9_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9_D" cssClass="error" />                                        
                                </td> 
				       </tr>
				      <tr> <th  style="text-align: left" width="70%">GSTR 9A</th>
				      <td>                                    
                                    <form:input path="GSTR_9A_D" type="text"  name="GSTR_9A_D" id="GSTR_9A_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9A_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9A_D" cssClass="error" />                                        
                                </td> 
				      </tr>
				      <tr> <th  style="text-align: left" width="70%">GSTR 9C</th>
   						<td>                                    
                                    <form:input path="GSTR_9C_D" type="text"  name="GSTR_9C_D" id="GSTR_9C_D" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_9C_D}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_9C_D" cssClass="error" />                                        
                                </td> 
				   </tr>
				       
				       
				       <tr >
				       <th  width="70%">Taxpayers where GSTR 3A has been issued (out of col no. 29)</th>
				        <td >                                    
                                    <form:input path="GSTR_3A_I" type="text"  name="GSTR_3A_I" id="GSTR_3A_I" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3A_I}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_3A_I" cssClass="error" />                                        
                                </td> 
				       </tr>
				       <tr >
				       <th  width="70%">Taxpayers where GSTR 3A has not been issued  (out of col no. 30)</th>     
				       
				       <td >                                    
                                    <form:input path="GSTR_3A_NI" type="text"  name="GSTR_3A_NI" id="GSTR_3A_NI" class="form-control min-width-1" autocomplete="off" value= "${model.GSTR_3A_NI}" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" required = "true"  readonly="true"/>
                                       <form:errors path="GSTR_3A_NI" cssClass="error" />                                        
                                </td>           
                        </tr>
                       
 --%>                             </tbody>
                        </table>


                        <!-- /.table-responsive -->
                    </div>

                    <!-- /.panel-body -->
                </div>
                
            </div>
            <!-- /.col-lg-6 -->

        </div>
    </div>


    </form:form>
    </div>
</div>

<link href="style.css" rel="stylesheet" />
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
</script>


<jsp:include page="../../GSTHome/Footer.jsp" />


