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
      /*   $(document).ready(function () {
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
            
        }); */
    </script>

<title>DPM-GST-14</title>
</head>
<body>
	<%!String desDt = "";
    String strDate = "";%>
	<c:set var="TOTAL_COMM" value="${modelA.TOTAL_COMM}" />
	<c:set var="COMPLETE_COMM" value="${modelA.COMPLETE_COMM}" />
	<c:set var="AMND" value="${modelA.AMND}" />
	<div id="Report_main">
		<table>

			<table>
				<tr>
					<c:if test="${modelA != null}">
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
								href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=DPM-GST-14"
								style="color: brown; font-weight: bold;"> <img
								src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
							</c:if></td>
					</c:if>
					<td>&nbsp;</td>
					<%
                        String strDate = (String) request.getAttribute("ViewBag_MM_YYYY");
                        java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = srcDtFormat.parse(strDate);
                        java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
                        desDt = desDtFormat.format(date);
                    %>

					<td style="text-align: center;"><a
						download='DPM-GST-14(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
						&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
					<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
				</tr>
			</table>
			<table width="100%">
				<tr>
					<td  colspan="14" align="center">
						<h1>DPM-GST-14A</h1>
						<h2>PENDENCY OF REGISTRATION APPLICATIONS</h2>
					</td>
				</tr>
				<tr>
					<td align="left" colspan="2" style="padding-left: 10px;">
						<h2>${ViewBag_Report_Name}<br /> MONTH :
							<%=desDt.toUpperCase()%>
						</h2>
					</td>
				</tr>
			</table>
			<table id="report_1" class="Report_body">
				<c:if test="${modelA != null && modelA.COMPLETE_COMM!=0}">
					<% int i=0; %>
					<c:if test="${Report_Type=='Crr'}">
						<div>
							<h2>
								CORRECTED REPORT<span style="color: red;"> **Corrections
									are shown in red</span>
							</h2>
						</div>
					</c:if>
					<!-- <table id="report_1" class="Report_body" > -->
					<tr class="text-center-capitalize header_bcg_clr">
						<!-- <th rowspan="4">S.NO.</th> -->
						<th rowspan="4" colspan="1">Opening Balance</th>
						<th rowspan="1" colspan="2">No. of ARNs received during the
							month</th>
						<th rowspan="1" colspan="10">Disposal of ARNs</th>
						<th rowspan="4" colspan="1">Closing Balance (1 + 2 + 3 - 13)</th>
					</tr>
					<tr class="text-center-capitalize header_bcg_clr">
						<th rowspan="3" colspan="1">From GSTN</th>
						<th rowspan="3" colspan="1">From other CPCs/Zone</th>
						<th rowspan="3" colspan="1">ARNs approved within 07 working
							days</th>
						<th rowspan="1" colspan="4">Physical Verification (PV)</th>
						<th rowspan="3" colspan="1">Transferred to other CPCs/Zone</th>
						<th rowspan="3" colspan="1">Deemed registration<br>
							(Reasons in REG-1B below)
						</th>

						<th rowspan="3" colspan="1">Total ARNs Approved (4+6)</th>
						<th rowspan="3" colspan="1">Total ARNs rejected (7)</th>

						<th rowspan="3" colspan="1">Total ARNs Disposed (9 + 10 + 11
							+ 12)</th>
						<!-- <th rowspan="3" colspan="1">Total ARNs Pending at the end of month (Closing Balance) (2+3+4-14)</th> -->
					</tr>
					<tr class="text-center-capitalize header_bcg_clr">
						<th rowspan="2" colspan="1">ARNs recommended for PV</th>
						<th rowspan="1" colspan="2">Bifurcation of Action taken on
							the basis of PV Report received</th>
						<th rowspan="2" colspan="1">PV Report not received</th>
					</tr>
					<tr class="text-center-capitalize header_bcg_clr">
						<th rowspan="1" colspan="1">ARN Approved</th>
						<th rowspan="1" colspan="1">ARN Rejected</th>
					</tr>
					<!--
				     -->
					<tr class="text-center-capitalize header_bcg_clr">
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
					</tr>
					<tr class="table-datarow-right">
						<%--  <th><%= i+1 %></th> --%>
						<td>${modelA.OPENING_BALANCE}</td>
						<td>${modelA.NO_OF_ARN_RECEIVED_GSTN}</td>
						<td>${modelA.NO_OF_ARN_RECEIVED_CPC}</td>
						<td>${modelA.DISPOSAL_OF_ARN_WITHIN_7}</td>
						<td>${modelA.DISPOSAL_OF_ARN_PV_RECOMMENDED}</td>
						<td>${modelA.DISPOSAL_OF_ARN_PV_APPROVED}</td>
						<td>${modelA.DISPOSAL_OF_ARN_PV_REJECTED}</td>
						<td>${modelA.DISPOSAL_OF_ARN_PV_NOT_RECEIVED}</td>
						<td>${modelA.DISPOSAL_OF_ARN_TRANSFERED_CPC}</td>
						<td>${modelA.DISPOSAL_OF_ARN_DEEMED_REG}</td>
						<td>${modelA.TOTAL_ARN_APPROVED}</td>
						<td>${modelA.DISPOSAL_OF_ARN_PV_REJECTED}</td>
						<td>${modelA.TOTAL_ARN_DISPOSED}</td>
						<td>${(modelA.CLOSING_BALANCE)}</td>
					</tr>
					<% i=i+1; %>

					<!-- </table> -->
				</c:if>
				<c:if test="${empty modelA  || modelA.COMPLETE_COMM==0}">

					<tr>
						<th colspan="9">
							<h1 style="color: red;">No Record Found!</h1>
						</th>
					</tr>
				</c:if>
			</table>
			<br />
			<br />
			<br />

			<table width="100%">
				<tr>
					<td  colspan="14" align="center">
						<h1>DPM-GST-14B</h1>
						<h2>Reasons For Deemed Registration</h2>
					</td>
				</tr>
			</table>


			<table id="report_2" class="Report_body">
				<c:if test="${modelB != null && modelB.COMPLETE_COMM!=0}">
					<tr class="header_bcg_clr">
						<th rowspan="1">S.NO.</th>
						<th rowspan="1" colspan="1">Reasons for deemed registration</th>
						<th rowspan="1" colspan="2">No. of ARNs</th>
					</tr>

					<%-- <c:if test="${modelB != null}">  --%>
					<tr class="table-datarow-right">
						<td class="table-datarow-center">1</td>
						<td style="text-align: left;" width="55%">Received from other CPCs with only one
							working day left for action</td>
						<td class="table-datarow-right">${modelB.RECEIVED_FROM_OTHER_CPC}</td>
					</tr>
					<tr class="table-datarow-right">
						<td class="table-datarow-center">2</td>
						<td style="text-align: left;"  width="55%">PV report not received</td>
						<td class="table-datarow-right">${modelB.PV_REPORT_NOT_RECEIVED}</td>
					</tr>
					<tr class="table-datarow-right">
						<td class="table-datarow-center">3</td>
						<td style="text-align: left;"  width="55%">Officer failed to process the ARN</td>
						<td class="table-datarow-right">${modelB.OFFICER_FAILED_TO_PROCESS_ARN}</td>
					</tr>
					<tr class="table-datarow-right">
						<td class="table-datarow-center">4</td>
						<td style="text-align: left;"  width="55%">Others</td>
						<td class="table-datarow-right">${modelB.OTHERS}</td>
					</tr>

					<tr class="table-datarow-right">
						<td class="table-datarow-center">5</td>
						<td style="text-align: left;"  width="55%">Total</td>
						<td>${modelB.TOTAL}</td>
					</tr>
				</c:if>

				<c:if test="${empty modelB || modelB.COMPLETE_COMM==0}">

					<tr>
						<th colspan="9">
							<h1 style="color: red;">No Record Found!</h1>
						</th>
					</tr>
				</c:if>

			</table>




			<c:if test="${ViewBag_ReportA != null}">
				<% int i=0; %>

				<table id="report_1" class="Report_body">
					<tr class="text-center-capitalize header_bcg_clr">
						<th rowspan="4">S.NO.</th>
						<th rowspan="4" colspan="1">Opening Balance</th>
						<th rowspan="1" colspan="2">No. of ARNs received during the
							month</th>
						<th rowspan="1" colspan="10">Disposal of ARNs</th>
						<th rowspan="4" colspan="1">Closing Balance</th>
					</tr>
					<tr class="text-center-capitalize header_bcg_clr">
						<th rowspan="3" colspan="1">From GSTN</th>
						<th rowspan="3" colspan="1">From other CPCs/Zone</th>
						<th rowspan="3" colspan="1">ARNs approved within 07 working
							days</th>
						<th rowspan="1" colspan="4">Physical Verification (PV)</th>
						<th rowspan="3" colspan="1">Transferred to other CPCs/Zone</th>
						<th rowspan="3" colspan="1">Deemed registration</th>

						<th rowspan="3" colspan="1">Total ARNs Approved (5+7)</th>
						<th rowspan="3" colspan="1">Total ARNs rejected (8)</th>

						<th rowspan="3" colspan="1">Total ARNs Disposed (10+11+12+13)</th>
						<!-- <th rowspan="3" colspan="1">Total ARNs Pending at the end of month (Closing Balance) (2+3+4-14)</th> -->
					</tr>
					<tr class="text-center-capitalize header_bcg_clr">
						<th rowspan="2" colspan="1">ARNs recommended for PV</th>
						<th rowspan="1" colspan="2">Bifurcation of Action taken on
							the basis of PV Report received</th>
						<th rowspan="2" colspan="1">PV Report not received</th>
					</tr>
					<tr class="text-center-capitalize header_bcg_clr">
						<th rowspan="1" colspan="1">ARN Approved</th>
						<th rowspan="1" colspan="1">ARN Rejected</th>
					</tr>
					<!--
                                     -->
					<tr class="text-center-capitalize header_bcg_clr">
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
					<tr class="table-datarow-right">
						<th><%= i+1 %></th>
						<td>${modelA.OPENING_BALANCE}</td>
						<td>${ViewBag_ReportA.NO_OF_ARN_RECEIVED_GSTN}</td>
						<td>${ViewBag_ReportA.NO_OF_ARN_RECEIVED_CPC}</td>
						<td>${ViewBag_ReportA.DISPOSAL_OF_ARN_WITHIN_7}</td>
						<td>${ViewBag_ReportA.DISPOSAL_OF_ARN_PV_RECOMMENDED}</td>
						<td>${ViewBag_ReportA.DISPOSAL_OF_ARN_PV_APPROVED}</td>
						<td>${ViewBag_ReportA.DISPOSAL_OF_ARN_PV_REJECTED}</td>
						<td>${ViewBag_ReportA.DISPOSAL_OF_ARN_PV_NOT_RECEIVED}</td>
						<td>${ViewBag_ReportA.DISPOSAL_OF_ARN_TRANSFERED_CPC}</td>
						<td>${ViewBag_ReportA.DISPOSAL_OF_ARN_DEEMED_REG}</td>
						<td>${ViewBag_ReportA.TOTAL_ARN_APPROVED}</td>
						<td>${ViewBag_ReportA.DISPOSAL_OF_ARN_PV_REJECTED}</td>
						<td>${ViewBag_ReportA.TOTAL_ARN_DISPOSED}</td>
						<td>${(ViewBag_ReportA.CLOSING_BALANCE)}</td>
					</tr>
					<% i=i+1; %>
				</table>
			<br />
			<br />
			<br />
				<table id="report_2" class="Report_body">
					<tr class="header_bcg_clr">
						<th rowspan="1">S.NO.</th>
						<th rowspan="1" colspan="1">Reasons for deemed registration</th>
						<th rowspan="1" colspan="2">No. of ARNs</th>
					</tr>
					<tr class="table-datarow-right">
						<th  class="table-datarow-center">1</th>
						<th style="text-align: left;" >Received from other CPCs with only one working day left
							for action</th>
						<td>${ViewBag_ReportB.RECEIVED_FROM_OTHER_CPC}</td>
					</tr>
					<tr class="table-datarow-right">
						<th class="table-datarow-center">2</th>
						<th style="text-align: left;"  >PV report not received</th>
						<td>${ViewBag_ReportB.PV_REPORT_NOT_RECEIVED}</td>
					</tr>
					<tr class="table-datarow-right">
						<th class="table-datarow-center">3</th>
						<th style="text-align: left;"  >Officer failed to process the ARN</th>
						<td>${ViewBag_ReportB.OFFICER_FAILED_TO_PROCESS_ARN}</td>
					</tr>
					<tr class="table-datarow-right">
						<th class="table-datarow-center">4</th>
						<th style="text-align: left;"  >Others</th>
						<td>${ViewBag_ReportB.OTHERS}</td>
					</tr>
					<tr class="table-datarow-right">
						<th class="table-datarow-center">5</th>
						<th style="text-align: left;"  >Total</th>
						<td>${ViewBag_ReportB.TOTAL}</td>
					</tr>
				</table>


			</c:if>

			<%-- <c:if test="${empty modelB}">
        <table class="Report_body">
            <tr>
                <th colspan="9">
                    <h1 style="color:red;">No Record Found!</h1>
                </th>
            </tr>
        </table>
        </c:if> --%>
			</div>
</body>
</html>


