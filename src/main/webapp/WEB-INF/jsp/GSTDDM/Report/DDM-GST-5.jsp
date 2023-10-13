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
                    if (report_1.rows[row].cells[col].innerHTML.trim() != report_2.rows[row].cells[col].innerHTML.trim()) {
                        $(this).css('color', 'red');
                        report_2.rows[row].cells[col].style.backgroundColor = "grey";
                    }
                });
            })
        });
    </script>

<title>DDM-GST-5</title>
</head>
<body>
	<%!String desDt = "";
    String strDate = "";%>
	<c:set var="TOTAL_COMM" value="${Model_TOTAL_COMM}" />
	<c:set var="COMPLETE_COMM" value="${Model_COMPLETE_COMM}" />
	<c:set var="AMND" value="${Model_AMND}" />
	<div id="Report_main">
		<%
            String strDate = (String) request.getAttribute("_MM_YYYY");
            java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = srcDtFormat.parse(strDate);
            java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
            desDt = desDtFormat.format(date);
                        
        %>
		<c:if
			test="${Model != null && Model_size!= 1 && Model_COMPLETE_COMM >=1}">

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
								href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=CEI-CE-2"
								style="color: brown; font-weight: bold;"> <img
								src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
						</c:if></td>
					<td>&nbsp;</td>


					<td style="text-align: center;"><a
						download='DDM-GST-5(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
						&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
					<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
				</tr>
			</table>

		</c:if>
		<table>
			<tr>
				<td colspan="20" align="center">
					<h1>DDM-GST-5</h1>
					<h2>Blocking/Unblocking of ITC</h2>
				</td>
			</tr>

			<tr>
				<td align="left" colspan="2" style="padding-left: 10px;">
					<h2>${ViewBag_Report_Name}<br /> MONTH :
						<%=desDt.toUpperCase()%>
					</h2>

				</td>
				<td align="right" colspan="2" style="padding-left: 10px;">
					<h2>Amount in Rs. Crores</h2>
				</td>

			</tr>
		</table>

		<c:if test="${Model != null && Model_COMPLETE_COMM >=1}">
			<% int i=0; %>
			<c:if test="${Report_Type=='Crr'}">

				<div>
					<h2>
						CORRECTED REPORT<span style="color: red;"> **Corrections
							are shown in red</span>
					</h2>
				</div>
			</c:if>

			<table id="report_1" class="Report_body">
				<tr class="header_bcg_clr">
					<th rowspan="3" colspan="1">SR. NO.</th>
					<th rowspan="3" colspan="1">Grounds for blocking ITC</th>
					<th rowspan="2" colspan="2">Opening Balance</th>

					<th rowspan="2" colspan="2">ITC blocked during the month</th>
					<th rowspan="2" colspan="2">ITC unblocked during the month</th>
					<th rowspan="2" colspan="2">Closing Balance</th>
					<th rowspan="1" colspan="10">ITC pending blocked for more than
						3 months</th>

				</tr>
				<tr class="header_bcg_clr">
					<th rowspan="1" colspan="2">Upto 3 Months</th>
					<th rowspan="1" colspan="2">3-6 Months</th>
					<th rowspan="1" colspan="2">6-9 Months</th>
					<th rowspan="1" colspan="2">9-12 Months</th>
					<th rowspan="1" colspan="2">More than 1 year</th>
				</tr>

				<tr class="header_bcg_clr">
					<th rowspan="1" colspan="1">No.</th>
					<th rowspan="1" colspan="1">Amount</th>
					<th rowspan="1" colspan="1">No.</th>
					<th rowspan="1" colspan="1">Amount</th>
					<th rowspan="1" colspan="1">No.</th>
					<th rowspan="1" colspan="1">Amount</th>
					<th rowspan="1" colspan="1">No.</th>
					<th rowspan="1" colspan="1">Amount</th>
					<th rowspan="1" colspan="1">No.</th>
					<th rowspan="1" colspan="1">Amount</th>
					<th rowspan="1" colspan="1">No.</th>
					<th rowspan="1" colspan="1">Amount</th>
					<th rowspan="1" colspan="1">No.</th>
					<th rowspan="1" colspan="1">Amount</th>
					<th rowspan="1" colspan="1">No.</th>
					<th rowspan="1" colspan="1">Amount</th>
					<th rowspan="1" colspan="1">No.</th>
					<th rowspan="1" colspan="1">Amount</th>
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
					<th>10</th>
					<th>11</th>
					<th>12</th>
					<th>13</th>
					<th>14</th>
					<th>15</th>
					<th>16</th>
					<th>17</th>
					<th>18</th>
					<th>19</th>
					<th>20</th>

				</tr>

				<c:forEach items="${Model}" var="r">
					<tr class="table-datarow-right">
						<th class="table-datarow-center" width="3%">
							<%-- ${r.SR_NO} --%> <%= i+1 %>
						</th>

						<th align="left" width="26%">${r.GROUNDS_BLOCKING_ITC}</th>

						<td width="3%">${r.OPENING_NO }</td>
						<td width="3%">${r.OPENING_AMT }</td>
						<td width="3%">${r.ITC_BLOCKED_DURING_MONTH_NO }</td>
						<td width="3%">${r.ITC_BLOCKED_DURING_MONTH_AMT }</td>

						<td width="3%">${r.ITC_UNBLOCKED_DURING_MONTH_NO}</td>
						<td width="3%">${r.ITC_UNBLOCKED_DURING_MONTH_AMT}</td>

						<td width="3%">${r.CLOSING_NO}</td>
						<td width="3%">${r.CLOSING_AMT}</td>

						<td width="3%">${r.ITC_PENDING_BLOCKED_MORE_THAN_3_NO}</td>
						<td width="3%">${r.ITC_PENDING_BLOCKED_MORE_THAN_3_AMT}</td>
						<td width="3%">${r.ITC_PENDING_BLOCKED_MORE_THAN_6_NO}</td>
						<td width="3%">${r.ITC_PENDING_BLOCKED_MORE_THAN_6_AMT}</td>
						<td width="3%">${r.ITC_PENDING_BLOCKED_MORE_THAN_9_NO}</td>
						<td width="3%">${r.ITC_PENDING_BLOCKED_MORE_THAN_9_AMT}</td>
						<td width="3%">${r.ITC_PENDING_BLOCKED_MORE_THAN_12_NO}</td>
						<td width="3%">${r.ITC_PENDING_BLOCKED_MORE_THAN_12_AMT}</td>

						<td width="3%">${r.ITC_PENDING_BLOCKED_MORE_THAN_YEAR_NO}</td>
						<td width="3%">${r.ITC_PENDING_BLOCKED_MORE_THAN_YEAR_AMT}</td>


						<%-- <td align="right" width="4%">
             <c:if test="${r.PER_TOTAL_INCREASE_ITC_UPTO != 'null' && r.PER_TOTAL_INCREASE_ITC_UPTO != null}">
	                                ${r.PER_TOTAL_INCREASE_ITC_UPTO}
	                               </c:if>
             </td> --%>

					</tr>
					<% i=i+1; %>
				</c:forEach>
			</table>




		</c:if>
		<c:if test="${empty Model || Model_COMPLETE_COMM== 0}">
			<table class="Report_body">
				<tr>
					<th colspan="18" align="center">
						<h1 style="color: red;">No Record Found !</h1>
					</th>
				</tr>
			</table>
		</c:if>
	</div>

</body>
</html>


