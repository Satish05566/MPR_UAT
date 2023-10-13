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

    <title>DPM-GST-12</title>
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
		<%-- <c:if test="${Model != null}"> --%>
		<c:if test="${not empty Model && Model_COMPLETE_COMM >=1}">
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
                                href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_mm_yyyy}&MPR=DPM-GST-12"
                                style="color: brown; font-weight: bold;"> <img
                                src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
                        </c:if></td>
                    <td>&nbsp;</td>
                   <%--  <%
                        String strDate = (String) request.getAttribute("_mm_yyyy");
                        java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = srcDtFormat.parse(strDate);
                        java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
                        desDt = desDtFormat.format(date);
                    
                    %> --%>
                    
                    <td style="text-align: center;"><a
                        download='DPM-GST-12(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
                    <td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
                </tr>
            </table>
        </c:if>  
            <tr>
                <td colspan="20" align="center">
                    <h1 align="center">DPM-GST-12[GST-REG-1]</h1>
                    <h2 align="center">REPORT ON REGISTRATION OF TAXPAYERS</h2>
                </td>
            </tr>
            <tr>
                <td align="left" colspan="2" style="padding-left:10px;">
                   <h2>${ViewBag_report_name}<br />
                   MONTH : <%=desDt.toUpperCase()%>                   
                   </h2>
                </td>
            </tr>
      </table>
        
             <c:if test="${not empty Model && Model_COMPLETE_COMM >=1}">
            <% int i=0; %>
		         <c:if test="${Report_Type=='Crr'}">
		            <div><h2>CORRECTED REPORT<span style="color:red;"> **Corrections are shown in red</span></h2></div>
		        </c:if>
				<table id="report_1" class="Report_body" >
				   <tr class="header_bcg_clr">
				       <!-- <th rowspan="2" align="center">S.NO.</th> -->
				       <th rowspan="2" align="center">No. of taxpayers at the beginning of the month</th>
				       <th rowspan="2" align="center">New Taxpayers added during the month</th>
				       <th rowspan="2" colspan="1" align="center">Migration of Tax payers from other Zones (Applicable for Maharashtra, Gujarat and Uttar Pradesh Only)</th>
				       <th rowspan="2" colspan="1" align="center">Migration of Tax payers to other Zones (Applicable for Maharashtra, Gujarat and Uttar Pradesh Only)</th>
				       <th rowspan="1" colspan="3" align="center">Cancellation of Registration</th>
				       <th rowspan="2"  align="center">Revocation of Cancelled Registration</th>
				       <th rowspan="2" colspan="1" align="center">No. of Taxpayers at the end of the month</th>
				   </tr>
				   <tr class="header_bcg_clr">
				       <th rowspan="1" colspan="1" align="center">Suo moto</th>
				       <th rowspan="1" colspan="1" align="center">On request</th>
				       <th rowspan="1" colspan="1" align="center">Total</th>
				   </tr>
				   <tr class="header_bcg_clr">
				       <th align="center">1</th>
				       <th align="center">2</th>
				       <th align="center">3</th>
				       <th align="center">4</th>
				       <th align="center">5</th>
				       <th align="center">6</th>
				       <th align="center">7</th>
				       <th align="center">8</th>
				       <th align="center">9</th>
				       <!-- <th align="center">10</th> -->
				   </tr>
					<c:forEach items="${Model}" var="model">
						<tr>
						    <%-- <th align="center"><%= i+1 %></th> --%>
						    <td align="right" >${model.NO_TAXPAYER_FOR_MONTH}</th> 
						    <td align="right">${model.NEW_TAXPAYER_FOR_MONTH}</td>
						    <td align="right">${model.MIGRATION_TAXPAYER_FROM}</td>
						    <td align="right">${model.MIGRATION_TAXPAYER_TO}</td>
						    <td align="right">${model.SUO_MOTO}</td>
						    <td align="right">${model.ON_REQUEST}</td>
						    <td align="right">${model.TOTAL}</td>
						    <td align="right">${model.REVOCATION}</td>
						    <td align="right">${model.NO_TAXPAYER_ATEND_MONTH}</td>
						</tr>
					<%--  <% i=i+1; %> --%>
					</c:forEach>
				</table>
         </c:if> 
         <!-- not empty Model &&  -->
        <c:if test="${empty Model || (COMPLETE_COMM == 0)}">
        <table class="Report_body">
            <tr>
                <th colspan="9" align="center">
                    <h1 style="color:red;">No Record Found</h1>
                </th>
            </tr>
        </table>
        </c:if>
    </div>
    
</body>
</html>


