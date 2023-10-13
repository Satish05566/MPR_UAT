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
<title>DPM-GST-15A</title>

<script src="~/Scripts/jquery-1.8.2.min.js"></script>
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
	String strDate = "";%>
	<c:set var="TOTAL_COMM" value="${Model_TOTAL_COMM}" />
	<c:set var="COMPLETE_COMM" value="${Model_COMPLETE_COMM}" />
	<c:set var="AMND" value="${Model_AMND}" />
	<div id="Report_main" align="center">
		<table>

			<tr>
				<c:if test="${Model_COMPLETE_COMM != 0}">
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
								href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=DPM-GST-15"
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
					download='DPM-GST-15(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
					&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
				<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
			</tr>
		</table>
		<%--  </c:if> --%>
		<table>

			<tr>
				<td colspan="14" align="center">
					<h1>
						DPM-GST-15A[GST-REG-2]<br />
						<h2>REPORT ON CANCELLATION OF REGISTRATION AND REVOCATION OF
							CANCELLED GSTIN</h2>
					</h1>
				</td>

			</tr>


			<tr style="font-size: 15px;">
				<td align="left" colspan="7" style="padding-left: 10px;">
					<h2>${ViewBag_Report_Name}<br />MONTH :
						<%=desDt.toUpperCase()%></h2>
				</td>
				<td align="right" colspan="7"></td>

			</tr>

			<tr>
				<td align="left" colspan="14"></td>
			</tr>

		</table>


		<!--START 15A -->
		<c:if test="${not empty model && model.SUO_MOTO_OPENING_BALANCE != null}">
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
					<th rowspan="1" colspan="4" align="center">Suo Moto
						Cancellation</th>
					<th rowspan="1" colspan="4" align="center">Cancellation on
						request</th>
					<th rowspan="2" colspan="1" align="center">TOTAL_PENDENCY</th>
					<th rowspan="1" colspan="5" align="center">Revocation of
						cancelled GSTINs</th>
				</tr>
				<tr class="header_bcg_clr">
					<th rowspan="1" colspan="1" align="center">Opening Balance</th>
					<th rowspan="1" colspan="1" align="center">GSTINs liable for
						cancellation [Section 29(2)]</th>
					<th rowspan="1" colspan="1" align="center">GSTINs Cancelled</th>
					<th rowspan="1" colspan="1" align="center">GSTINs pending for
						cancellation</th>


					<th rowspan="1" colspan="1" align="center">Opening balance</th>
					<th rowspan="1" colspan="1" align="center">No. of applications
						received [Section 29(1)]</th>
					<th rowspan="1" colspan="1" align="center">GSTINs Cancelled</th>
					<th rowspan="1" colspan="1" align="center">GSTINs pending for
						cancellation</th>

					<th rowspan="1" colspan="1" align="center">Opening Balance</th>
					<th rowspan="1" colspan="1" align="center">ARNs received for
						revocation</th>
					<th rowspan="1" colspan="1" align="center">Number of
						Revocation Applications accepted</th>
					<th rowspan="1" colspan="1" align="center">Number of
						Revocation Application rejected</th>
					<th rowspan="1" colspan="1" align="center">No. of ARNs pending</th>
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
					<th align="center">10</th>
					<th align="center">11</th>
					<th align="center">12</th>
					<th align="center">13</th>
					<th align="center">14</th>
				</tr>
				<tr>
					<%-- <th align="center"><%= i+1 %></th> --%>
					<td align="right">${model.SUO_MOTO_OPENING_BALANCE}</tD>
					<td align="right">${model.SUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION}</td>
					<td align="right">${model.SUO_MOTO_GSTIN_CANCELLED}</td>
					<td align="right">${model.SUO_MOTO_GSTIN_PENDING_FOR_CANCELLATION }</td>
					<td align="right">${model.CANCELLATION_OPENING_BALANCE}</td>
					<td align="right">${model.CANCELLATION_NO_APPLICATION_RECEIVED}</td>
					<td align="right">${model.CANCELLATION_GSTIN_CANCELLED}</td>
					<td align="right">${model.CANCELLATION_GSTIN_PENDING_FOR_CANCELLATION }</td>
					<td align="right">${model.TOTAL_PENDENCY }</td>
					<td align="right">${model.REVOCATION_OPENING_BALANCE}</td>
					<td align="right">${model.REVOCATION_ARN_RECEIVED}</td>
					<td align="right">${model.REVOCATION_GSTIN_REVOKED}</td>
					<td align="right">${model.REVOCATION_APPLICATION_REJECTED}</td>
					<td align="right">${ model.REVOCATION_NO_ARN_PENDING}</td>

				</tr>
				<% i=i+1; %>

			</table>
		</c:if>
		<c:if test="${empty model || model.SUO_MOTO_OPENING_BALANCE == null}">
			<table class="Report_body">
				<tr>
					<th colspan="9" align="center" style="border: 1px solid !important">
						<h1 style="color: red;">No Record Found !</h1>
					</th>
				</tr>
			</table>
		</c:if>



		<!--START 15B  -->
		<c:if test="${not empty modelB && modelB.PENDENCY_PART_OFFICER_NO_GSTIN != null && modelB.PENDENCY_PART_OFFICER_NO_GSTIN != 'null'}">

			<c:if test="${Report_Type=='Crr'}">
				<div>
					<h2>
						CORRECTED REPORT<span style="color: red;"> **Corrections
							are shown in red</span>
					</h2>
				</div>
			</c:if>

			<br />
			<br />

			<table id="report_1" class="Report_body" style="width:50%" align="left">
				<tr>
				<td colspan="14" class="table-datarow-center" style="border: 0px solid;">
					<h1>
						DPM-GST-15B[GST-REG-2A]
					</h1>
				</td>
			</tr>
				<tr class="header_bcg_clr">
					<th align="center">Reasons for pendency of cancellation(Column
						8)</th>
					<th align="center">No. of GSTINs</th>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left">Pendency on the part of officer</th>
					<td>${modelB.PENDENCY_PART_OFFICER_NO_GSTIN }</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left">Reply awaited from Taxpayer</th>
					<td>${modelB.REPLY_AWAITED_TAXPAYER_NO_GSTIN}</td>
				</tr >

				<tr class="table-datarow-right">
					<th class="table-datarow-left">Taxes/Dues are unpaid</th>
					<td>${modelB.TAXES_OR_DUES_UNPAID_NO_GSTIN}</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left">Technical issues</th>
					<td>${modelB.TECHNICAL_ISSUES_NO_GSTIN}</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left">Other, please specify <c:if
							test="${modelB.OTHERS_REMARKS!='0.0' &&  modelB.OTHERS_REMARKS!='null' &&  modelB.OTHERS_REMARKS!=null &&  modelB.OTHERS_REMARKS!=''}">
                - ${modelB.OTHERS_REMARKS} 
                </c:if></th>
					<td >${modelB.OTHERS_NO_GSTIN}</td>
				</tr>
			</table>
			<br style="clear:both;" />
		</c:if>

		<c:if test="${empty modelB || modelB.PENDENCY_PART_OFFICER_NO_GSTIN == null || modelB.PENDENCY_PART_OFFICER_NO_GSTIN == 'null'}">
			<td colspan="14" align="center">
				<h1>
					<br />DPM-GST-15B[GST-REG-2A]<br />
				</h1>
			</td>
			<table class="Report_body">
				<tr>
					<th colspan="9" align="center" style="border: 1px solid !important">
						<h1 style="color: red;">No Record Found !</h1>
					</th>
				</tr>
			</table>

		</c:if>

		<!--START 15C  -->
		<c:if test="${not empty modelC && modelC.PERSONAL_HEARING_GRANTED_NO_GSTIN != null && modelC.PERSONAL_HEARING_GRANTED_NO_GSTIN != 'null'}">
			<table>
				<tr>
					<td colspan="14" align="center">
						<h1>
							<br />
						</h1>
					</td>

				</tr>
			</table>
			<c:if test="${Report_Type=='Crr'}">
				<div>
					<h2>
						CORRECTED REPORT<span style="color: red;"> **Corrections
							are shown in red</span>
					</h2>
				</div>
			</c:if>

			<table id="report_1" class="Report_body" style="width:50%" align="left">
				<tr>
				<td colspan="14" class="table-datarow-center" style="border: 0px solid;">
					<h1>
						DPM-GST-15C[GST-REG-2B]
					</h1>
				</td>
			</tr>
				<tr class="header_bcg_clr">
					<th>Reasons for pendency of Revocation of
						cancelled GSTIN (Column 14)</th>
					<th>No. of GSTINs</th>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left">Personal Hearing granted</th>
					<td>${modelC.PERSONAL_HEARING_GRANTED_NO_GSTIN}</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left">No time left for rejection</th>
					<td>${modelC.NOTIME_LEFT_FOR_REJECTION_NO_GSTIN}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-left">Taxes/Dues are unpaid</th>
					<td>${modelC.TAXES_OR_DUES_UNPAID_NO_GSTIN}</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left">Technical issues</th>
					<td>${modelC.TECHNICAL_ISSUES_NO_GSTIN}</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left">Other, please specify <c:if
							test="${modelC.OTHERS_SPECIFY!='0.0' &&  modelC.OTHERS_SPECIFY!='null' &&  modelC.OTHERS_SPECIFY!='' &&  modelC.OTHERS_SPECIFY!=null}">
                - ${modelC.OTHERS_SPECIFY} 
                </c:if></th>
					<td>${modelC.OTHERS_NO_GSTIN}</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${empty modelC || modelC.PERSONAL_HEARING_GRANTED_NO_GSTIN == null || modelC.PERSONAL_HEARING_GRANTED_NO_GSTIN == 'null'}">
			<td colspan="14" align="center">
				<h1>
					<br />DPM-GST-15C[GST-REG-2B]<br />
				</h1>
			</td>
			<table class="Report_body">
				<tr>
					<th colspan="9" align="center" style="border: 1px solid !important">
						<h1 style="color: red;">No Record Found !</h1>
					</th>
				</tr>
			</table>
		</c:if>
	</div>

</body>
</html>


