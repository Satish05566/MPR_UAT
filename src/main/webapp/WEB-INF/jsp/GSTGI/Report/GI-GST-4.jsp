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

<title>GI-GST-4</title>
</head>
<body>

	<%!String desDt = "";
    String strDate = "";%>
	<c:set var="TOTAL_COMM" value="${Model_TOTAL_COMM}" />
	<c:set var="COMPLETE_COMM" value="${Model_COMPLETE_COMM}" />
	<c:set var="AMND" value="${Model_AMND}" />
	<%
						 String strDate = (String) request.getAttribute("ViewBag_MM_YYYY");
                        java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = srcDtFormat.parse(strDate);
                        java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
                        desDt = desDtFormat.format(date);
						
						%>
	<div id="Report_main" align="center">

		<c:if test="${not empty model}">
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
								href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=GI-GST-4"
								style="color: brown; font-weight: bold;"> <img
								src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
						</c:if></td>
					<td>&nbsp;</td>

					<td style="text-align: center;"><a
						download='GI-GST-4(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
						&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
					<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
				</tr>
			</table>
		</c:if>
		<table>

			<tr>
				<td colspan="14" align="center">
					<h1>
						GI-GST-4<br /> Anti-evasion performance
					</h1>
				</td>
			</tr>


			<tr style="font-size: 15px;">
				<td align="left" colspan="7" style="padding-left: 10px;">
					<h2>${ViewBag_Report_Name}<br /> MONTH :
						<%=desDt.toUpperCase()%>
					</h2>
				</td>
				<td align="right" colspan="7">
					<h2>Amount: Rs. in Lakhs</h2>
				</td>

			</tr>

		</table>

		<c:if test="${not empty model }">
			<table id="report_1" class="Report_body" border="1">
				<tr class="header_bcg_clr">
					<th rowspan="2">S.No.</th>
					<th rowspan="2" colspan="2" style="width: 70%;">Description of
						Work</th>
					<th colspan="3">For the month</th>
					<th colspan="3">Upto the month</th>
				</tr>
				<tr class="header_bcg_clr">
					<th colspan="3">No.</th>
					<th colspan="3">No.</th>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-center"><b>1</b></th>
					<th colspan="2" class="table-datarow-left"><b>AE-1 Filed</b></th>

					<td colspan="3">${model.AE_1_NO_FOR}</td>
					<td colspan="3">${model.AE_1_NO_UPTO}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-center"><b>2</b></th>
					<th colspan="2" class="table-datarow-left"><b>AE-2 Filed</b></th>
					<td colspan="3">${model.AE_2_NO_FOR}</td>
					<td colspan="3">${model.AE_2_NO_UPTO}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-center"><b>3</b></th>
					<th colspan="2" class="table-datarow-left"><b>Inspection
							of premises conducted (u/s 67 (1) of the CGST Act, 2017)</b></th>
					<td colspan="3">${model.INSPECTION_PERMISES_NO_FOR}</td>
					<td colspan="3">${model.INSPECTION_PERMISES_NO_UPTO}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-center"><b>4</b></th>
					<th colspan="2" class="table-datarow-left"><b>Searches
							(u/s 67 (2) of the CGST Act, 2017)</b></th>
					<td colspan="3">${model.SEARCHES_NO_FOR}</td>
					<td colspan="3">${model.SEARCHES_NO_UPTO}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-center"><b>5</b></th>
					<th colspan="2" class="table-datarow-left"><b>Inspection
							of goods in movement conducted (u/s 68 of the CGST Act, 2017)</b></th>
					<td colspan="3">${model.INSPECTION_GOODS_NO_FOR}</td>
					<td colspan="3">${model.INSPECTION_GOODS_NO_UPTO}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-center"><b>6</b></th>
					<th colspan="2" class="table-datarow-left"><b>Summons
							issued (u/s 70 of the CGST Act, 2017)</b></th>
					<td colspan="3">${model.SUMMONS_NO_FOR}</td>
					<td colspan="3">${model.SUMMONS_NO_UPTO}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-center" rowspan="4"><b>7</b></th>
					<th rowspan="4"><b>Seizure (u/s 67 (2) of the CGST Act,
							2017)</b></th>
					<th class="table-datarow-center" style="background: #b3cbe8;"><b>Description</b></th>
					<th class="table-datarow-center" style="background: #b3cbe8;"><b>No.</b></th>
					<th class="table-datarow-center" style="background: #b3cbe8;"><b>Value</b></th>
					<th class="table-datarow-center" style="background: #b3cbe8;"><b>Tax
							involved</b></th>
					<th class="table-datarow-center" style="background: #b3cbe8;"><b>No.</b></th>
					<th class="table-datarow-center" style="background: #b3cbe8;"><b>Value</b></th>
					<th class="table-datarow-center" style="background: #b3cbe8;"><b>Tax
							involved</b></th>

				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-left"><b>Goods</b></th>
					<td>${model.SEIZUR67_GOODS_NO_FOR}</td>
					<td>${model.SEIZUR67_GOODS_VALUE_FOR}</td>
					<td>${model.SEIZUR67_GOODS_TAX_FOR}</td>
					<td>${model.SEIZUR67_GOODS_NO_UPTO}</td>
					<td>${model.SEIZUR67_GOODS_VALUE_UPTO}</td>
					<td>${model.SEIZUR67_GOODS_TAX_UPTO}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-left"><b>Vehicles</b></th>
					<td>${model.SEIZUR67_VEHICLES_NO_FOR}</td>
					<td>${model.SEIZUR67_VEHICLES_VALUE_FOR}</td>
					<td>${model.SEIZUR67_VEHICLES_TAX_FOR}</td>
					<td>${model.SEIZUR67_VEHICLES_NO_UPTO}</td>
					<td>${model.SEIZUR67_VEHICLES_VALUE_UPTO}</td>
					<td>${model.SEIZUR67_VEHICLES_TAX_UPTO}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-left"><b>Currency</b></th>
					<td>${model.SEIZUR67_CURRENCY_NO_FOR}</td>
					<td>${model.SEIZUR67_CURRENCY_VALUE_FOR}</td>
					<td>${model.SEIZUR67_CURRENCY_TAX_FOR}</td>
					<td>${model.SEIZUR67_CURRENCY_NO_UPTO}</td>
					<td>${model.SEIZUR67_CURRENCY_VALUE_UPTO}</td>
					<td>${model.SEIZUR67_CURRENCY_TAX_UPTO}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-center" rowspan="2"><b>8</b></th>
					<th rowspan="2" class="table-datarow-left"><b>Seizure (u/s
							129(1) of the CGST Act, 2017)</b></th>
					<th class="table-datarow-left"><b>Goods in transit
							(Specify UQC*)</b></th>
					<td>${model.SEIZUR129_GOODS_NO_FOR}</td>
					<td colspan="2">${model.SEIZUR129_GOODS_VALUE_FOR}</td>
					<td>${model.SEIZUR129_GOODS_NO_UPTO}</td>
					<td colspan="2">${model.SEIZUR129_GOODS_VALUE_UPTO}</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left"><b>Vehicles in transit</b></th>
					<td>${model.SEIZUR129_VEHICLES_NO_FOR}</td>
					<td colspan="2">${model.SEIZUR129_VEHICLES_VALUE_FOR}</td>
					<td>${model.SEIZUR129_VEHICLES_NO_UPTO}</td>
					<td colspan="2">${model.SEIZUR129_VEHICLES_VALUE_UPTO}</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-center" rowspan="4"><b>9</b></th>
					<th rowspan="4"><b>Attachment of property including bank
							accounts (u/s 83 (1) of the CGST Act, 2017)</b></th>
					<th class="table-datarow-center" style="background: #b3cbe8;"><b>DESCRIPTION</b></th>
					<th class="table-datarow-center" colspan="2">No.</th>
					<th class="table-datarow-center">Value</th>
					<th class="table-datarow-center" colspan="2">No.</th>
					<th class="table-datarow-center">Value</th>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left"><b>Provisional Attachment
							of goods</b></th>
					<td colspan="2">${model.ATTACHMENT_GOODS_NO_FOR}</td>
					<td>${model.ATTACHMENT_GOODS_VALUE_FOR}</td>
					<td colspan="2">${model.ATTACHMENT_GOODS_NO_UPTO}</td>
					<td>${model.ATTACHMENT_GOODS_VALUE_UPTO}</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left"><b>Provisional Attachment
							of property</b></th>
					<td colspan="2">${model.ATTACHMENT_PROPERTY_NO_FOR}</td>
					<td>${model.ATTACHMENT_PROPERTY_VALUE_FOR}</td>
					<td colspan="2">${model.ATTACHMENT_PROPERTY_NO_UPTO}</td>
					<td>${model.ATTACHMENT_PROPERTY_VALUE_UPTO}</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left"><b>Provisional Attachment
							of bank accounts (only Nos. to be reported)</b></th>
					<td colspan="3">${model.ATTACHMENT_ACCOUNT_NO_FOR}</td>
					<td colspan="3">${model.ATTACHMENT_ACCOUNT_NO_UPTO}</td>
				</tr>

				<tr class="table-datarow-right">
					<th class="table-datarow-center" rowspan="2"><b>10</b></th>
					<th class="table-datarow-left" rowspan="2"><b>Incident
							Reports issued </b></th>
					<th class="table-datarow-left"><b>No. of IRs only</b></th>
					<td colspan="3">${model.INCIDENT_NO_FOR}</td>
					<td colspan="3">${model.INCIDENT_NO_UPTO}</td>
				</tr>
				<tr class="table-datarow-right">
					<th class="table-datarow-left"><b>Detection Amount</b></th>
					<td colspan="3">${model.INCIDENT_AMOUNT_FOR}</td>
					<td colspan="3">${model.INCIDENT_AMOUNT_UPTO}</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${not empty model }">
			<div style="float: left;">* UQC=Unit Quantity Code</div>
		</c:if>
		<c:if test="${empty model}">
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


