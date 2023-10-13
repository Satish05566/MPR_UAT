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

    <style type="text/css">
        body {
            vertical-align: top;
            font-family: "Segoe UI", Verdana, Helvetica, Sans-Serif;
        }

        #Report_main {
            width: 100%;
            color: #000000;
        }

            #Report_main h1 {
                font-size: 23px;
            }

            #Report_main h2 {
                font-size: 16px;
            }

            #Report_main table {
                width: 100%;
            }

                #Report_main table th {
                    border: 1px solid black;
                    text-transform: uppercase;
                    font-weight: bold;
                    font-size: 12px;
                }

            #Report_main .Report_body td {
                border: solid 1px black;
                font-size: 12px;
            }
    </style>
   
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

    <title>DPM-GST-4</title>
</head>
<body>

<%!String desDt = "";
    String strDate = "";%>
    <c:set var="TOTAL_COMM" value="${Model_TOTAL_COMM}" />
    <c:set var="COMPLETE_COMM" value="${Model_COMPLETE_COMM}" />
    <c:set var="AMND" value="${Model_AMND}" />
    <%
						 String strDate = (String) request.getAttribute("_mm_yyyy");
                        java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = srcDtFormat.parse(strDate);
                        java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
                        desDt = desDtFormat.format(date);
						
						%>
    <div id="Report_main" align="center">

		<c:if test="${Model != null && Model_size!= 1}">
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
									href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=DPM-GST-4"
									style="color: brown; font-weight: bold;"> <img src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
							</c:if></td>
						<td>&nbsp;</td>
						
						<td style="text-align: center;"><a
							download='DPM-GST-4(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
							&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
						<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
					</tr>
                </table>
            </c:if>
        <table>

            <tr>
                <td colspan="14" align="center">
                    <h1>
                        DPM-GST-4<br/>
                        REFUND
                    </h1>
                </td>
            </tr>

           
            <tr style="font-size:15px;">
                <td align="left" colspan="7" style="padding-left:10px;">
                   <h2>${ViewBag_report_name}<br />
                   MONTH : <%=desDt.toUpperCase()%>                   
                   </h2>
                </td>
                <td align="right" colspan="7">
                    <h2> Amount in Rs. Crores</h2>
                </td>

            </tr>

        </table>
        
             <c:if test="${Model != null && Model_size!= 1}">
            <% int i=0; %>
		         <c:if test="${Report_Type=='Crr'}">
		            <div><h2>CORRECTED REPORT<span style="color:red;"> **Corrections are shown in red</span></h2></div>
		        </c:if>
				<table id="report_1" class="Report_body" border="1">
				   <tr class="header_bcg_clr">
				       <th rowspan="3"  style="width:2%">Sr No</th>
				       <th rowspan="3" style="width:20%">Refund category</th>
				       <th rowspan="2" colspan="2"  style="width:6%">Opening Balance</th>
				       <th rowspan="2" colspan="2" style="width:6%">RFD 01</th>
				       <th rowspan="2" colspan="1" style="width:6%">RFD-02 issued within 15 days</th>
				       <th rowspan="2" colspan="2" style="width:6%">RFD 03</th>
				       <th rowspan="2"  colspan="2" style="width:6%">RFD-04 Issued</th>
				       <th rowspan="1" colspan="4" style="width:6%">RFD 06*</th>
				       <th rowspan="2" colspan="2" style="width:6%">Closing Balance</th>
				       <th rowspan="1" colspan="6" style="width:18%">Age Wise Breakup</th>
				   </tr>
				   <tr class="header_bcg_clr">
				       <th rowspan="1" colspan="2" >Sanctioned</th>
				       <th rowspan="1" colspan="2" >Rejected</th>
				       <th rowspan="1" colspan="2" >30-45 days</th>
				       <th rowspan="1" colspan="2" >46-60 days</th>
				       <th rowspan="1" colspan="2" >Above 60 days</th> 
				   </tr> 
				  <tr class="header_bcg_clr">
				       <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >Amount</th>
				        <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >Amount</th>
				       <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >Amount</th>
				       <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >Amount</th>
				        
				       <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >Amount</th>
				        <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >Amount</th>
				       <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >Amount</th> 
				       <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >Amount</th>
				       <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >Amount</th> 
				       <th rowspan="1" colspan="1" >No.</th>
				       <th rowspan="1" colspan="1" >Amount</th>
				   </tr> 
				     <tr class="header_bcg_clr" >
				       <th   >1</th>
				       <th   >2</th>
				       <th   >3</th>
				       <th   >4</th>
				       
				       <th   >5</th>
				       <th   >6</th>
				       <th   >7</th>
				       <th   >8</th>
				       <th   >9</th>
				       <th   >10</th>
				       <th   >11</th>
				       <th   >12</th>
				       <th   >13</th>
				       <th   >14</th>
				       <th   >15</th>
				       <th   >16</th>
				       <th   >17</th>
				       <th   >18</th>
				       <th   >19</th>
				       <th   >20</th>
				       <th   >21</th>
				       <th   >22</th>
				       <th  >23</th>
				   </tr> 
				    <c:forEach items="${Model}" var="model"> 
				   <tr class="table-datarow-right" >
						    <td class="table-datarow-center" ><%= i+1 %></td>
						    <th>${model.REFUND_CATEGORY}</th> 
						    <td >${model.OPENING_BALANCE_NO}</td>
						    <td >${model.OPENING_BALANCE_AMOUNT}</td>
						    <td >${model.RFD_01_NO}</td>
						    <td >${model.RFD_01_AMOUNT}</td>
						    <td >${model.RFD_02_NO}</td>
						    <td >${model.RFD_03_NO}</td>
						    <td >${model.RFD_03_AMOUNT}</td>
						    
						    <td  >${model.RFD_04_NO}</td> 
						    <td >${model.RFD_04_AMOUNT}</td>
						    <td >${model.RFD_06_SANCTIONED_NO}</td>
						    <td >${model.RFD_06_SANCTIONED_AMOUNT}</td>
						    <td >${model.RFD_06_REJECTED_NO}</td>
						    <td >${model.RFD_06_REJECTED_AMOUNT}</td>
						    <td >${model.CLOSING_BALANCE_NO}</td>
						    <td >${model.CLOSING_BALANCE_AMOUNT}</td>
						    <td >${model.AGE_BREAKUP_30_45_NO}</td>
						    <td >${model.AGE_BREAKUP_30_45_AMOUNT}</td>
						    
						    <td  >${model.AGE_BREAKUP_46_60_NO}</td> 
						    <td >${model.AGE_BREAKUP_46_60_AMOUNT}</td>
						    <td >${model.AGE_BREAKUP_ABOVE60_NO}</td>
						    <td >${model.AGE_BREAKUP_ABOVE60_AMOUNT}</td>
						    
						</tr>
						 <% i=i+1; %>
					</c:forEach> 
				</table>
				<br>
				<div style="text-align:left;"><p><span style="color:red;"> *</span>Where refund is partly sanctioned and partly rejected, then amount will be shown as per order but the no. will be figured in column where highest amount is involved</p></div>
         </c:if>
        <c:if test="${empty Model || Model_size== 1}">
        <table class="Report_body">
            <tr>
                <th colspan="9" align="center">
                    <h1 style="color:red;">No Record Found !</h1>
                </th>
            </tr>
        </table>
        </c:if>
    </div>
    
</body>
</html>


