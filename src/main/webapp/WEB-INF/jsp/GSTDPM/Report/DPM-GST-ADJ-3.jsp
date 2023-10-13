<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.math.BigDecimal"%>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width" />

<link
	href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/mpr-report.css"
	rel="stylesheet" />


<script
	src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script language="javascript" type="text/javascript">
        $(document).ready(function () {
            $('#report_1 tr').each(function () {
                var row = $(this).index();
                $(this).find('td').each(function () {
                    var col = $(this).index();
                   /*  if (report_1.rows[row].cells[col].innerHTML.trim() != report_2.rows[row].cells[col].innerHTML.trim()) {
                        $(this).css('color', 'red');
                        report_2.rows[row].cells[col].style.backgroundColor = "grey";
                    } */
                });
            })
        });
    </script>

<title>GST-ADJ-3</title>
</head>
<body>
	<%!String desDt = "";
    String strDate = "";%>
	<c:set var="TOTAL_COMM" value="${Model_TOTAL_COMM}" />
	<c:set var="COMPLETE_COMM" value="${Model_COMPLETE_COMM}" />
	<c:set var="AMND" value="${Model_AMND}" />
	<div id="Report_main">
		<%
            String strDate = (String) request.getAttribute("_mm_yyyy");
            java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = srcDtFormat.parse(strDate);
            java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
            desDt = desDtFormat.format(date);
        
        %>
		<table>

			<c:if test="${Model != null && Model_size!= 1}">

				<table>

					<tr>
						<td style="text-align: left;"><c:if
								test="${TOTAL_COMM > COMPLETE_COMM}">
								<img
									src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/incomplete.gif"
									title="${COMPLETE_COMM}/${TOTAL_COMM}" />
							</c:if> <c:if test="${!(TOTAL_COMM > COMPLETE_COMM)}">
								<img
									src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/complete.gif" />
							</c:if> <c:if test="${AMND != 0}">
								<a
									href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=DDM-GST-3"
									style="color: brown; font-weight: bold;"> <img
									src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
							</c:if></td>
						<td>&nbsp;</td>


						<td style="text-align: center;"><a
							download='GST-ADJ-3(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
							&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
						<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
					</tr>
				</table>
			</c:if>
			<table>
				<tr>
					<td colspan="20" align="center">
						<h1>GST-ADJ-3</h1>
						<h2>CASES PENDING UNDER SECTION 75(11) OF CGST ACT WITH REASONS FOR PENDENCY</h2>

					</td>

				</tr>

				<tr>
					<td align="left" colspan="2" style="padding-left: 10px;">
						<h2>${ViewBag_report_name}<br /> MONTH :
							<%=desDt.toUpperCase()%>
						</h2>

					</td>
					<td align="right" colspan="2" style="padding-left: 10px;">
						<h2>Amount: Rs. in Lakhs</h2>
					</td>


				</tr>
			</table>

			<c:if test="${Model != null && Model_size >1}">
				<% int i=0; %>
				<c:if test="${Report_Type=='Crr'}">

					<div>
						<h2>
							CORRECTED REPORT<span style="color: red;"> **Corrections
								are shown in red</span>
						</h2>
					</div>
				</c:if>

	
	<table class="Report_body" id="report_1">
                        
                        <tr class="header_bcg_clr">
                                <th rowspan="2" style="width:2%;">S.No.</th>
                                <th rowspan="2" >Reason for keeping in Call Book</th>
                                <th rowspan="2" >Adjudicating Authority</th>
                                <th colspan="2">Opening Balance</th>
                                <th colspan="2">Receipt</th>
                                <th colspan="2">Disposal</th>
                                <th colspan="2">Closing Balance</th>
                                <th colspan="4">Age wise Break up of pendency</th>
                       </tr>
                       <tr class="header_bcg_clr">
                       <%   
                                String TokenNo = (String) request.getSession().getAttribute("TokenNo");
                                String MM_YYYY = (String) request.getAttribute("MM_YYYY");
                                String CRR = (String) request.getAttribute("CRR");
                                %>
                            <input type="hidden" id="HDTokenNo" name="HDTokenNo" value="<%=TokenNo%>" />
                                    <input type="hidden" id="MM_YYYY" name="MM_YYYY" value="${MM_YYYY}" />
                                    <input type="hidden" id="CRR" name="CRR" value="${CRR}" />
                                    <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
                                    
                           <th>No </th>
                           <th>Amount </th>
                           <th>No </th>
                           <th>Amount </th>
                           <th>No </th>
                           <th>Amount </th>
                           <th>No </th>
                           <th>Amount </th>
                           <th>Less than 6 months </th>
                            <th>6  to 12 months </th>
                           <th>1 year to 2 years </th>
                            <th>More than 2 years </th>                           
                       </tr>
                       <tr>
                       <th>1</th>
                       <th>2</th>
                       <th>3</th>
                       <th>4</th>
                       <th>5</th>
                       <th>6</th>
                       <th>7</th>
                       <th>8</th>
                       <th>9</th>
                       <th>10</th>
                       <th>11</th>
                       <th>12</th>
                       <th>13</th>
                       <th>14</th>
                       <th>15</th>
                       </tr>
                       
               <%-- <% int i=0; %> --%>
                     <c:forEach items="${Model}" var="r">  
                        <tr class="table-datarow-right">
                               
                                
                                <th rowspan="3" class="table-datarow-center"><%= i+1 %></th>
                                <th rowspan="3" class="table-datarow-center" style="width: 10%;">${r.REASON_FOR_KEEPING_IN_CALL_BOOK }</th>
                                <th class="table-datarow-center" style="width: 6%;">ADC/JC</th>
                                <td style="width: 5%;">                                   
                                   ${r.ADC_OPENING_NO}
                                       
                                </td>
                                 <td style="width: 5%;">       
                                 ${r.ADC_OPENING_AMT}             
                                </td> 
                                
                                <td style="width: 5%;">
                                    ${r.ADC_RECEIPT_NO}
                                </td>
                                 <td style="width: 5%;">                                    
                                   ${r.ADC_RECEIPT_AMT}                                 
                                </td>  
                                
                                <td style="width: 5%;">
                                    ${r.ADC_DISPOSAL_NO}
                                       
                                </td>
                                 <td style="width: 5%;">                                    
                                   ${r.ADC_DISPOSAL_AMT}                                  
                                </td>  
                                
                                <td style="width: 5%;">
                                    ${r.ADC_CLOSING_NO} 
                                       
                                </td>
                                 <td style="width: 5%;">                                    
                                   ${r.ADC_CLOSING_AMT}                                 
                                </td>  
                                
                                <td style="width: 5%;">
                                    ${r.ADC_AGE_LESS_6_NO} 
                                       
                                </td>
                                 <td style="width: 5%;">                                    
                                   ${r.ADC_AGE_6_TO_12_NO}                                
                                </td>  
                                
                                <td style="width: 5%;">
                                    ${r.ADC_AGE_1_TO_2_NO}
                                </td >
                                 <td style="width: 5%;">                                    
                                   ${r.ADC_AGE_MORE_THAN_2_NO}                                 
                                </td>  
                               
                           </tr>
                            
                           <tr class="table-datarow-right">
                               
                                <th class="table-datarow-center">DC/AC</th>
                                 <td>
                                    ${r.DC_OPENING_NO}
                                       
                                </td>
                                 <td>                                    
                                   ${r.DC_OPENING_AMT}                             
                                </td> 
                                
                                <td>
                                    ${r.DC_RECEIPT_NO}
                                       
                                </td>
                                 <td>                                    
                                   ${r.DC_RECEIPT_AMT}                                
                                </td>  
                                
                                <td>
                                    ${r.DC_DISPOSAL_NO} 
                                       
                                </td>
                                 <td>                                    
                                   ${r.DC_DISPOSAL_AMT}                               
                                </td>  
                                
                                <td>
                                    ${r.DC_CLOSING_NO}
                                       
                                </td>
                                 <td>                                    
                                   ${r.DC_CLOSING_AMT}                                 
                                </td>  
                                
                                <td>
                                    ${r.DC_AGE_LESS_6_NO}
                                </td>
                                 <td>                                    
                                   ${r.DC_AGE_6_TO_12_NO}                                 
                                </td>  
                                
                                <td>
                                    ${r.DC_AGE_1_TO_2_NO}
                                </td>
                                 <td>                                    
                                   ${r.DC_AGE_MORE_THAN_2_NO}                               
                                </td>  
                            </tr>   
                            
                            <tr class="table-datarow-right">
                               
                                <th class="table-datarow-center">Superintendent</th>
                                 <td>
                                    ${r.SUP_OPENING_NO}
                                       
                                </td>
                                 <td>                                    
                                   ${r.SUP_OPENING_AMT}                                
                                </td> 
                                
                                <td>
                                    ${r.SUP_RECEIPT_NO}
                                </td>
                                 <td>                                    
                                   ${r.SUP_RECEIPT_AMT}                              
                                </td>  
                                
                                <td>
                                   ${r.SUP_DISPOSAL_NO} 
                                </td>
                                 <td>                                    
                                   ${r.SUP_DISPOSAL_AMT}                                
                                </td>  
                                
                                <td style="width: 5%;">
                                    ${r.SUP_CLOSING_NO}
                                       
                                </td>
                                 <td style="width: 5%;">                                    
                                   ${r.SUP_CLOSING_AMT}                                
                                </td>  
                                
                                <td style="width: 5%;">
                                    ${r.SUP_AGE_LESS_6_NO}
                                       
                                </td>
                                 <td style="width: 5%;">                                    
                                   ${r.SUP_AGE_6_TO_12_NO}                                 
                                </td>  
                                
                                <td style="width: 5%;">
                                   ${r.SUP_AGE_1_TO_2_NO}  
                                       
                                </td>
                                 <td style="width: 5%;">                                    
                                   ${r.SUP_AGE_MORE_THAN_2_NO}                            
                                </td>  
                            </tr>   
                       <% i=i+1; %>
                       </c:forEach>
                   </table>
	

			   
			
			</c:if>
			<c:if test="${empty Model || Model_size== 1}">
				<table class="Report_body">
					<tr>
						<th colspan="18">
							<h1 style="color: red;">No Record Found !</h1>
						</th>
					</tr>
				</table>
			</c:if>
			</table>
			</div>
</body>
</html>


