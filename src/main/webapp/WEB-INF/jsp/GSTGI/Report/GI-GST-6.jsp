<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.math.BigDecimal"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
            
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/mpr-report.css" rel="stylesheet" />
  
   <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
    <script language="javascript" type="text/javascript">
        $(document).ready(function () {
            $('#report_1 tr').each(function () {
                var row = $(this).index();
                $(this).find('td').each(function () {
                    var col = $(this).index();
                    if (report_1.rows[row].cells[col].innerHTML.trim() != report_2.rows[row].cells[col].innerHTML.trim()) {
                        $(this).css('color', 'red');
                        report_2.rows[row].cells[col].style.backgroundColor = "grey";
                    }
                });


            })

        });
    </script>

    <title>GI-GST-6</title>
</head>
<body>
   <%!String desDt = "";
	String strDate = "";%>
	<c:set var="TOTAL_COMM" value="${model[0].TOTAL_COMM}" />
	<c:set var="COMPLETE_COMM" value="${model[0].COMPLETE_COMM}" />
	<c:set var="AMND" value="${model[0].AMND}" />
    <div id="Report_main">
        <table>
        
        <%
						 	String strDate = (String) request.getAttribute("ViewBag_MM_YYYY");
					      	java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
					      	java.util.Date date = srcDtFormat.parse(strDate);
					      	java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
					        desDt = desDtFormat.format(date);
						
						%>

     <c:if test="${model != null && model!=''}">
            
                <table>
                    
                    <tr>
						<td style="text-align: left;">
						<c:if test="${TOTAL_COMM > COMPLETE_COMM}">
								<img
									src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/incomplete.gif"
									title="${COMPLETE_COMM}/${TOTAL_COMM}" />
							</c:if> 
							<c:if test="${!(TOTAL_COMM > COMPLETE_COMM)}">
								<img src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/complete.gif" />
							</c:if> <c:if test="${AMND != 0}">
								<a
									href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=CEI-CE-2"
									style="color: brown; font-weight: bold;"> <img
									src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
							</c:if></td>
						<td>&nbsp;</td>
						
						
						<td style="text-align: center;"><a
							download='GI-GST-6(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
							&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
						<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
					</tr>
                </table>
     </c:if>
            
     
     <table >     
            <tr>
                <td colspan="20" align="center">
                    <h1>GI-GST-6</h1>
                    <h2>Tax Evasion prone Goods And Services</h2>

                </td>

            </tr>
          
            <tr>
                <td align="left" colspan="2" style="padding-left:10px;">
                   <h2>${ViewBag_Report_Name}<br />
                   <!--  COMMISSIONERATE : <br/>
                   FINANCIAL YEAR: <br/> -->
                   MONTH : <%=desDt.toUpperCase()%>
                   
                   </h2>
					
                </td>
                <td align="right" colspan="2" style="padding-left:10px;">
                    <h2>Amount: Rs. in Lakhs</h2>
               </td>
           
               
            </tr>
        </table>
        
    <c:if test="${model!= null && model!=''}">
        <c:if test="${Report_Type=='Crr'}">
            <div><h2>CORRECTED REPORT<span style="color:red;"> **Corrections are shown in red</span></h2></div>
        </c:if>
         <table id="report_1" class="Report_body">
            <tr class="header_bcg_clr">
                <th rowspan="3" width="5%">
                    S.NO.
                </th>
                <th rowspan="3"  align="center" style="width:30%">
                    CATEGORY WISE TOP TAX EVASION PRONE GOODS AND SERVICES 
                </th>
                
                 <th rowspan="3" >
                   HSN/SAC CODE
                </th>
               
                <th rowspan="1" colspan="4" style="width:30%">
                    CURRENT FINANCIAL YEAR
                </th>
                
                 <th rowspan="1" colspan="4" style="width:30%">
                    PREVIOUS FINANCIAL YEAR
                </th>
            </tr>
          
            <tr class="header_bcg_clr">
                
                <th rowspan="1" colspan="2" >
                    FOR THE MONTH
                </th>
                <th rowspan="1" colspan="2" >
                    UPTO THE MONTH
                </th>
                
                <th rowspan="1" colspan="2" >
                    FOR THE MONTH
                </th>
                <th rowspan="1" colspan="2" >
                    UPTO THE MONTH
                </th>
               
                
            </tr>
            <tr class="header_bcg_clr">
            	<th rowspan="1" colspan="1" style="width:70px;" >
                    No. OF CASES

                </th>
                <th rowspan="1" colspan="1" >
                    AMOUNT OF TAX EVASION

                </th>
                
                <th rowspan="1" colspan="1" style="width:70px;" >
                    No. OF CASES
                </th>
                <th rowspan="1" colspan="1" >
                    AMOUNT OF TAX EVASION
                </th>
                
                <th rowspan="1" colspan="1" style="width:70px;" >
                    No. OF CASES

                </th>
                <th rowspan="1" colspan="1" >
                    AMOUNT OF TAX EVASION

                </th>
                
                <th rowspan="1" colspan="1" style="width:70px;" >
                    No. OF CASES
                </th>
                <th rowspan="1" colspan="1" >
                    AMOUNT OF TAX EVASION
                </th>
            </tr>

            <tr>
                <th  width="5%">
                    1
                </th>
                <th  >
                    2
                </th>
                <th  >
                    3
                </th>
                <th  >
                    4
                </th>
                <th  >
                    5
                </th>
                <th  >
                    6
                </th>
                
                 <th  >
                    7
                </th>
                
                 <th  >
                    8
                </th>
                
                 <th  >
                    9
                </th>
                
                 <th  >
                    10
                </th>
                
                 <th  >
                    11
                </th>
                
            </tr>
               
      				 <% int i=0; %>
      				 <% int j=0; %>
                     <c:forEach items="${model}" var="r"> 
                     <tr class="table-datarow-right">
                     
                     <c:if test="${r.GOODS_OR_SERVICES_TYPE=='G'}">
                      	<th class="table-datarow-center"> <%= i+1 %></th>
                     </c:if>
                     <c:if test="${r.GOODS_OR_SERVICES_TYPE=='S'}">
                      	<th class="table-datarow-center"> <%= j+1 %></th>
                     </c:if>
                      <c:if test="${r.GOODS_OR_SERVICES_TYPE=='' && r.HSN_SAC_CODE_DESCRIPTION=='GOODS:'}">
                      	<th class="table-datarow-center"> (A) </th>
                     </c:if>
                     <c:if test="${r.GOODS_OR_SERVICES_TYPE=='' && r.HSN_SAC_CODE_DESCRIPTION=='SERVICES'}">
                      	<th class="table-datarow-center"> (B) </th>
                     </c:if>
                      <c:if test="${r.GOODS_OR_SERVICES_TYPE=='' && (r.HSN_SAC_CODE_DESCRIPTION!='GOODS:' && r.HSN_SAC_CODE_DESCRIPTION!='SERVICES')}">
                      	<th class="table-datarow-center"> </th>
                     </c:if>
                     
                     
                     
                      <th>
                      		<c:if test="${r.GOODS_OR_SERVICES_TYPE==''}">
                      		 
                     		<label style="font-weight:bold;">${r.HSN_SAC_CODE_DESCRIPTION}</label>
                     		</c:if>
                     		
                     		<c:if test="${r.GOODS_OR_SERVICES_TYPE!=''}">
                      		 
                     		<label>${r.HSN_SAC_CODE_DESCRIPTION}</label>
                     		</c:if>
                     
                     </th>
                      <th>
                     		<label>${r.HSN_SAC_CODE}</label>
                     
                     </th>
                      
                                                              
                      <td>       
                            <label > ${r.NO_OF_CASES_CUR_FOR} </label>
                                       
                       </td>
                       <td>                                    
                             <label>${r.TAX_EVASION_AMT_CUR_FOR}</label>
                        </td> 
                        
                         <td>
                                   
                            <label>${r.NO_OF_CASES_CUR_UPTO}</label>                                       
                       </td>
                       <td>                                    
                             <label>${r.AMOUNT_OF_TAX_EVASION_CUR_UPTO}</label>
                        </td> 
                        
                        <td>       
                            <label > ${r.NO_OF_CASES_PRE_FOR} </label>
                                       
                       </td>
                       <td>                                    
                             <label>${r.TAX_EVASION_AMT_PRE_FOR}</label>
                        </td> 
                        
                         <td>
                                   
                            <label>${r.NO_OF_CASES_PRE_UPTO}</label>  
                                                                 
                       </td>
                       <td>                                    
                             <label>${r.AMOUNT_OF_TAX_EVASION_PRE_UPTO}</label>
                        </td> 
                        
                        </tr>
                        
                        <c:if test="${r.GOODS_OR_SERVICES_TYPE=='G'}">
                      	 <% i=i+1; %>
                     	</c:if>
                     	<c:if test="${r.GOODS_OR_SERVICES_TYPE=='S'}">
                      	 <% j=j+1; %>
                     	</c:if>
                     
                    
                   </c:forEach>
        
   <%--  <tr class="table-datarow-right">
            <th class="table-datarow-center">
                1
            </th>

            <th>
               IRON & STEEL PRODUCTS 
            </th>
          
            <th class="table-datarow-center"> 72</th>
            
            <td >
               ${model.IRON_NO_CUR_FOR}
            </td>
            <td >
               ${model.IRON_AMT_CUR_FOR} 
            </td>
           <td >
               ${model.IRON_NO_CUR_UPTO}
            </td>
            <td >
               ${model.IRON_AMT_CUR_UPTO} 
            </td>
            
            <td >            
               ${model.IRON_NO_PRE_FOR}
            </td>
            <td >
               ${model.IRON_AMT_PRE_FOR} 
            </td>
           <td >
               ${model.IRON_NO_PRE_UPTO}
            </td>
            <td >
               ${model.IRON_AMT_PRE_UPTO} 
            </td>
         
        </tr> --%>
   
    
      
        
        
        
   </table>
   
    
     
     
  <c:if test="${ViewBag_Report != null}">
             <center> <h2>EXISTING REPORT</h2></center>
   <table id="report_2" class="Report_body" >
      
   </table>   
   </c:if>   
    </c:if>
        
        
        <c:if test="${empty model}">
        <table class="Report_body">
            <tr>
                <th colspan="18" align="center">
                    <h1 style="color:red;">No Record Found !</h1>
                </th>
            </tr>
        </table>
        </c:if>
    </div>
    
</body>
</html>


