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
    <title>DDM-GST-4A</title>

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
								<a
									href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=DDM-GST-4A"
									style="color: brown; font-weight: bold;"> <img
									src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
							</c:if></td>
						<td>&nbsp;</td>
						
						<td style="text-align: center;"><a
							download='DDM-GST-4A(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
							&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
						<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
					</tr>
               </table>
       </c:if>
         <table width="100%" >
         	<tr>
                <td colspan="12" align="center">
                	<h1>DDM-GST-4A</h1>
                    <h2>REVENUE FROM TOP 20 SERVICES</h2>
                </td>
            </tr>
            <tr>
                <td align="left" colspan="2" style="padding-left:10px;">
                   <h2>${ViewBag_Report_Name}<br />
                   MONTH : <%=desDt.toUpperCase()%>                   
                   </h2>
                </td>
               
	                <td align="right" colspan="2" style="padding-left:10px;">
	                    <h2>Amount in Rs. Crores</h2>
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
            
               <th  rowspan="2" width="2%">
                    Sr. NO.
               </th>
               <th  rowspan="2" width="6%">
                   SERVICE ACCOUNTING CODE
               </th>
               <th  rowspan="2" width="15%">
                    NAME OF THE SERVICES
               </th>               
               <th  rowspan="1" colspan="2" width="8%">
                   CURRENT F.Y.
               </th>
               <th  rowspan="1"  colspan="2" width="8%">
                   PREVIOUS F.Y.                   
               </th>
               <th  rowspan="2" width="8%">
                   INCREASE/DECREASE OVER PREVIOUS F.Y. (For the month)
               </th>
               <th  rowspan="2" width="8%">
                   INCREASE/DECREASE OVER PREVIOUS F.Y. (Up to the month) 
               </th>
               <th  rowspan="2" width="8%">
                   %  INCREASE/DECREASE OVER PREVIOUS F.Y.(For the month)
               </th>
               <th  rowspan="2" width="8%">
                   %  INCREASE/DECREASE OVER PREVIOUS F.Y.(Up to the month)
               </th>
               <th  rowspan="2" width="15%">
                    Reason for Increase/Decrease in Revenue
               </th>               
            </tr>        
        	<tr class="header_bcg_clr">
               <th rowspan="1" colspan="1" >
                   FOR THE MONTH
               </th>
               <th rowspan="1" colspan="1" >
                    UPTO THE MONTH
               </th>
               <th rowspan="1" colspan="1" >
                    FOR THE MONTH
               </th>
               <th rowspan="1" colspan="1" >
                    UPTO THE MONTH
               </th>
           
            </tr>
            
            <tr class="header_bcg_clr">

               <th  >
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
               <th  >
                    12
               </th>
              
            </tr>

 
            <c:forEach items="${Model}" var="r">
              <tr class="table-datarow-right">
            			<th class="table-datarow-center">
                            <%= i+1 %> 
                        </th>
                         <td class="table-datarow-center" width="6%">
                           ${(r.SERVICE_CODE)}
                        </td>
                        <th width="15%">
                            ${(r.SERVICE_NAME)}
                        </th>
                      
                        <td  width="10%">
                            ${(r.CUR_YEAR_FOR)}
                        </td>
                        <td  width="10%">
                            ${(r.CUR_YEAR_UPTO)}
                        </td>
                        <td  width="10%">
                            ${(r.PRE_YEAR_FOR)}
                        </td>
                        <td  width="10%">
                            ${(r.PRE_YEAR_UPTO)}
                        </td>
                    	<td  width="8%">
                    		${(r.INC_DEC_PRV_YR_FOR_MON)}                    		
                    	</td>
                     	<td  width="8%">
                    		${(r.INC_DEC_PRV_YR_UPTO_MON)}         
                    	</td>
                    	<td  width="8%">
                    		${(r.INC_DEC_PRV_YR_PERC_FOR_MON)}
                    	</td>
                     	<td  width="8%">
                    		${(r.INC_DEC_PRV_YR_PERC_UPTO_MON)}        
                    	</td>
                    	<th  width="15%" style="overflow-wrap: anywhere;">
                            ${(r.REASONS)}
                        </th>          
                </tr>
                <% i=i+1; %>
            </c:forEach>
        </table>
    
    
    <%-- <c:if test="${ViewBagReport!=null && ViewBagReport.size() > 0}">
          <h2>EXISTING REPORT</h2>
          <% int j=0; %>
       <table id="report_2" class="Report_body">
            <tr>
            
               <th align="center" rowspan="2">
                    S.NO.
               </th>
                <th align="center" rowspan="2">
                   SERVICE ACCOUNTING CODE
               </th>
               <th align="center" rowspan="2">
                    NAME OF THE SERVICES
               </th>
              
               <th align="center" rowspan="1" colspan="2">
                   CURRENT F.Y.
               </th>
               <th align="center" rowspan="1"  colspan="2">
                   PREVIOUS F.Y.
               </th>
                <th align="center" rowspan="2" >
                   INCREASE/DECREASE OVER PREVIOUS F.Y. (For the month)
               </th>
               <th align="center" rowspan="2" >
                   INCREASE/DECREASE OVER PREVIOUS F.Y. (Up to the month) 
               </th>
               <th align="center" rowspan="2" >
                   %  INCREASE/DECREASE OVER PREVIOUS F.Y.(For the month)
               </th>
               <th align="center" rowspan="2" >
                   %  INCREASE/DECREASE OVER PREVIOUS F.Y.(Up to the month)
               </th>
               <th align="center" rowspan="2">
                    Reason for Increase/Decrease in Revenue 
               </th>
               
            </tr> 
       
        	<tr>
               <th rowspan="1" colspan="1" align="center">
                   FOR THE MONTH
               </th>
               <th rowspan="1" colspan="1" align="center">
                    UPTO THE MONTH
               </th>
               <th rowspan="1" colspan="1" align="center">
                    FOR THE MONTH
               </th>
               <th rowspan="1" colspan="1" align="center">
                    UPTO THE MONTH
               </th>
           
            </tr>
            
            <tr>

               <th align="center" >
                    1
               </th>
               <th align="center" >
                    2
               </th>
               <th align="center" >
                    3
               </th>
               <th align="center" >
                    4
               </th>
               <th align="center" >
                    5
               </th>
               <th align="center" >
                    6
               </th>
               <th align="center" >
                    7
               </th>
               <th align="center" >
                    8
               </th>
               <th align="center" >
                    9
               </th>
               <th align="center" >
                    10
               </th>
              <th align="center" >
                    11
               </th>
               <th align="center" >
                    12
               </th>
              
            </tr>

            <c:forEach items="${Model}" var="r">
                <tr>
                      	<td align="center" width="10%">
                            <%= j+1 %> 
                        </td>
                        <td align="left" width="8%">
                           ${(r.SERVICE_CODE)}
                        </td>
                        <td align="left" width="10%">
                            ${(r.SERVICE_NAME)}
                        </td>
                       
                        <td align="right" width="10%">
                            ${(r.CUR_YEAR_FOR)}
                        </td>
                        <td align="right" width="10%">
                            ${(r.CUR_YEAR_UPTO)}
                        </td>
                        <td align="right" width="10%">
                            ${(r.PRE_YEAR_FOR)}
                        </td>
                        <td align="right" width="10%">
                            ${(r.PRE_YEAR_UPTO)}
                        </td>
                    	<td align="right" width="10%">
                    		${(r.INC_DEC_PRV_YR_FOR_MON)}                    		
                    	</td>
                     	<td align="right" width="10%">
                    		${(r.INC_DEC_PRV_YR_UPTO_MON)}         
                    	</td>
                    	<td align="right" width="10%">
                    		${(r.INC_DEC_PRV_YR_PERC_FOR_MON)}
                    	</td>
                     	<td align="right" width="10%">
                    		${(r.INC_DEC_PRV_YR_PERC_UPTO_MON)}        
                    	</td>
                    	<td align="left" width="1%" >
                            ${(r.REASONS)}
                        </td>          
                </tr>
                <% j=j+1; %>
            </c:forEach>
        </table>

     </c:if> --%>
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