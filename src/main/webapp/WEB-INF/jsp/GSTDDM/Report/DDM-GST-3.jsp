<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.math.BigDecimal"%>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width" />

<style type="text/css">
  body {
                        
            vertical-align: top;
            font-family: "Segoe UI", Verdana, Helvetica, Sans-Serif;   
            background-color:#FCEFF6;
                         
        } /* pink shadef7cbe1 */
          .header_bcg_clr{                        
		    background: linear-gradient(225deg, #f7cbe1 20%, #E83E8C 30% ,#E00368 55%);
		    color: #fff ;
            }
  </style>

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

<title>DDM-GST-3</title>
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
							download='DDM-GST-3(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
							&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
						<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
					</tr>
				</table>
			</c:if>
			<table>
				<tr>
					<td colspan="20" align="center">
						<h1>DDM-GST-3</h1>
						<h2>Revenue From Top 25 Taxpayers</h2>

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
				<table id="report_1" class="Report_body">
					<tr class="header_bcg_clr">
						<th rowspan="3">SR.NO.</th>
						<th rowspan="3">GSTIN</th>
						<th rowspan="3">Legal Name of the Taxpayer</th>

						<th rowspan="1" colspan="6">CURRENT F.Y.</th>
						<th rowspan="1" colspan="6">PREVIOUS F.Y.</th>
						<th rowspan="2" colspan="3">INCREASE/DECREASE OVER PREVIOUS
							F.Y. (Up to the month)</th>
						<th rowspan="2" colspan="3">% INCREASE/DECREASE OVER PREVIOUS
							F.Y. (Up to the month)</th>
						<th rowspan="3" colspan="1">Reason for Increase/Decrease in
							Revenue</th>

					</tr>
					<tr class="header_bcg_clr">
						<th rowspan="1" colspan="3">FOR THE MONTH</th>
						<th rowspan="1" colspan="3">UPTO THE MONTH</th>
						<th rowspan="1" colspan="3">FOR THE MONTH</th>
						<th rowspan="1" colspan="3">UPTO THE MONTH</th>


					</tr>
					<tr class="header_bcg_clr">
						<th rowspan="1" colspan="1">Cash</th>
						<th rowspan="1" colspan="1">ITC</th>
						<th rowspan="1" colspan="1">Total</th>
						<th rowspan="1" colspan="1">Cash</th>
						<th rowspan="1" colspan="1">ITC</th>
						<th rowspan="1" colspan="1">Total</th>
						<th rowspan="1" colspan="1">Cash</th>
						<th rowspan="1" colspan="1">ITC</th>
						<th rowspan="1" colspan="1">Total</th>
						<th rowspan="1" colspan="1">Cash</th>
						<th rowspan="1" colspan="1">ITC</th>
						<th rowspan="1" colspan="1">Total</th>
						<th rowspan="1" colspan="1">Cash</th>
						<th rowspan="1" colspan="1">ITC</th>
						<th rowspan="1" colspan="1">TOTAL</th>
						<th rowspan="1" colspan="1">Cash</th>
						<th rowspan="1" colspan="1">ITC</th>
						<th rowspan="1" colspan="1">TOTAL</th>
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
						<th>21</th>
						<th>22</th>

					</tr>

					<c:forEach items="${Model}" var="r">
						<tr class="table-datarow-right">
							<th class="table-datarow-center" width="2%">
								<%-- ${r.SR_NO} --%> <%=i + 1%>
							</th>

							<td class="table-datarow-center" width="8%">${r.GSTIN}</td>

							<td style="text-align: left;" width="10%">
								${r.NAME_OF_TAXPAYER }</td>
							<td width="4%">${r.CASH_FOR_CURRENT }</td>
							<td width="4%">${r.ITC_FOR_CURRENT }</td>

							<td width="4%">${r.TOTAL_FOR_CURRENT }</td>
							<td width="4%">${r.CASH_UPTO_CURRENT}</td>

							<td width="4%">${r.ITC_UPTO_CURRENT}</td>

							<td width="4%">${r.TOTAL_UPTO_CURRENT}</td>
							<td width="4%">${r.CASH_FOR_PREV}</td>

							<td width="4%">${r.ITC_FOR_PREV}</td>
							<td width="4%">${r.TOTAL_FOR_PREV}</td>
							<td width="4%">${r.CASH_UPTO_PREV}</td>

							<td width="4%">${r.ITC_UPTO_PREV}</td>
							<td width="4%">${r.TOTAL_UPTO_PREV}</td>

							<td width="4%">${r.INCREASE_CASH_UPTO}</td>
							<td width="4%">${r.INCREASE_ITC_UPTO}</td>
							<td width="4%">${r.TOTAL_INCREASE_ITC_UPTO}</td>

							<td width="4%">${r.PER_INCREASE_CASH_UPTO}</td>
							<td width="4%">${r.PER_INCREASE_ITC_UPTO}</td>
							<td width="4%">${r.PER_TOTAL_INCREASE_ITC_UPTO}</td>

							<td style="text-align: left; overflow-wrap: anywhere;" width="15%"><c:if
									test="${r.REASON_FOR_INCREASE_REVENUE != 'null' && r.REASON_FOR_INCREASE_REVENUE != null}">
	                                ${r.REASON_FOR_INCREASE_REVENUE}
	            </c:if></td>
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


