<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.math.BigDecimal"%>


<!DOCTYPE html>

<html>
<head>
<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/mpr-report.css" rel="stylesheet" />
    <title>GI-GST-5</title>

 <meta name="viewport" content="width=device-width" />

      
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

</head>
<body>
<%!String desDt = "";
	String strDate = "";
	%>
	<c:set var="TOTAL_COMM" value="${Model_TOTAL_COMM}" />
	<c:set var="COMPLETE_COMM" value="${Model_COMPLETE_COMM}" />
	<c:set var="AMND" value="${Model_AMND}" />
						<%
						 	String strDate = (String) request.getAttribute("_MM_YYYY");
					      	java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
					      	java.util.Date date = srcDtFormat.parse(strDate);
					      	java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
					        desDt = desDtFormat.format(date);
						%>
    <div id="Report_main" >
        <table>

 <c:if test="${Model != null && Model_size > 0}">

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
								<%-- <a
									href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=GI-GST-5"
									style="color: brown; font-weight: bold;"> <img
									src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a> --%>
							</c:if></td>
						<td>&nbsp;</td>
						
						<td style="text-align: center;"><a
							download='GI-GST-5(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
							&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
						<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
					</tr>
               </table>
       </c:if>
         <table width="100%" >
         	<tr>
                <td colspan="12" align="center">
                	<h1>GI-GST-5</h1>
                    <h2>Arrests, Prosecution Sanctioned And Prosecution Launched under the CGST Act, 2017																									
</h2>
                </td>
            </tr>
            <tr>
                <td align="left" colspan="2" style="padding-left:10px;">
                   <h2>${ViewBag_Report_Name}<br />
                   MONTH : <%=desDt.toUpperCase()%>                   
                   </h2>
                </td>
               
	                <td align="right" colspan="2" style="padding-left:10px;">
	                    <h2>Amount in Rs. Lakhs</h2>
	               </td>
               
            </tr>
               
        </table>


<c:if test="${Model != null && Model_size > 0}"> 
<% int i=0; %>
       <c:if test="${ReportType=='Crr'}">
            <div><h2>CORRECTED REPORT<span style="color:red;">**Corrections are shown in red</span></h2></div>
        </c:if>

<table id="report_1" class="Report_body">
            <tr class="header_bcg_clr">            
               <th rowspan="2" width="3%">Sr. NO.</th>
               <th rowspan="2" width="3%" style="overflow-wrap: anywhere;" >F. No.</th>
               <th  rowspan="2" width="10%" style="overflow-wrap: anywhere;" >NAME AND ADDRESS OF THE TAXPAYER</th>               
               <th  rowspan="2"  width="8%">GSTIN OF THE TAXPAYER</th>
               <th  rowspan="2"  width="5%">AMOUNT OF TAX EVADED</th>
               <th rowspan="2"  width="8%" style="overflow-wrap: anywhere;" >NAME, DESGINATION AND AGE OF THE PERSON ARRESTED</th>
               <th rowspan="2" width="8%" style="overflow-wrap: anywhere;" >PAN & AADHAR NUMBER OF THE PERSON ARRESTED</th>
               <th  rowspan="2" width="5%">DATE OF ARREST (DD/MM/YYYY)</th>
               <th  rowspan="2" width="8%">ROLE PLAYED IN TAX EVASION (MAXIMUM 100 CHARACTERS)</th>
               <th rowspan="2"  width="10%" style="overflow-wrap: anywhere;" >PROSECUTION SANCTION ORDER NO. & DATE</th>   
               <th  rowspan="2" width="5%">NUMBER OF PERSONS PROSECUTED</th>
               <th  rowspan="2" width="5%">DATE OF FILING OF COMPLAINT IN COURT</th>
               <th  rowspan="2" width="5%">CRIMINAL COMPLAINT NUMBER</th>   
               <th  rowspan="1" colspan="2" width="10%">DETAILS OF ORDER PASSED BY THE COURT</th>               
            </tr>      
            <tr class="header_bcg_clr">
            	<th rowspan="1"  width="10%">Order No. & Date</th>   
                <th  rowspan="1"  width="10%">Details of Order</th> 
            </tr>  
            <tr class="header_bcg_clr">
               <th>1</th>
               <th>2</th>
               <th>3</th>
               <th>4</th>
               <th>5</th>
               <th>6</th>
               <th>7</th>
               <th>8</th>
               <th>9</th>
               <th>10 </th>
               <th>11</th>
               <th>12</th>
               <th>13</th>
               <th>14</th>
               <th>15</th>
            </tr>

 
             <c:forEach items="${Model}" var="r">
              <tr >
					                    	
            			<td class="table-datarow-center"><%= i+1 %></td>
                        <td width="3%" class="table-datarow-center">${(r.f_NO)}</td>
                        <td  width="10%" align="left" style="overflow-wrap: anywhere;" >${(r.NAME_TAXPAYER)} ${(r.ADDRESS_TAXPAYER)}</td>
                        <td  width="8%" align="left">${(r.GSTIN)}</td>
                        <td  width="5%" align="right">${(r.TAX_EVADED)}</td>
                        <td  width="8%" align="left">${(r.NAME)} ${(r.DESGINATION)} ${(r.AGE)}</td>
                    	<td  width="8%" align="left">${(r.PAN)} ${(r.AADHAR)}</td>
                     	<td  width="5%" align="right">${(r.DATE_ARREST)}</td>
                    	<td  width="8%" align="left" style="overflow-wrap: anywhere;" align="left" >${(r.ROLE_PLAYED)}</td>
                     	<td  width="10%" align="left">${(r.SANCTION_ORDER_NO)} ${(r.SANCTION_ORDER_DATE)}</td>
                    	<td  width="5%" align="right">${(r.NUMBER_PERSONS_PROSECUTED)}</td>
                    	<td  width="5%" align="right">${(r.DATE_FILING_COURT)}</td>
                     	<td  width="5%" align="right">${(r.CRIMINAL_COMPLAINT_NUMBER)}</td>
                    	<td  width="8%" align="right">${(r.COURT_ORDER_NO)} ${(r.COURT_ORDER_DATE)}</td>
                    	<td  width="8%" align="left" style="overflow-wrap: anywhere;" >${(r.COURT_DETAIL_ORDER)}</td>               
                </tr>
                <% i=i+1; %>
            </c:forEach> 
        </table>
    
    </c:if> 
        <c:if test="${empty Model}">
        <table class="Report_body">
                <tr>
                    <th colspan="16" align="center">
                        <h1 style="color:red;">No Record Found !</h1>
                    </th>
                </tr>
            </table>
        </c:if>
</table>
</div>
</body>
</html>