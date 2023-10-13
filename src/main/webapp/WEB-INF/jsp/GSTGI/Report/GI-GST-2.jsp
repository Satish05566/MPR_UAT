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

    <title>GI-GST-2</title>
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
									href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=GI-GST-2"
									style="color: brown; font-weight: bold;"> <img src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
							</c:if></td>
						<td>&nbsp;</td>
						
						<td style="text-align: center;"><a
							download='GI-GST-2(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
							&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
						<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
					</tr>
                </table>
           </c:if> 
        <table>

            <tr>
                <td colspan="14" align="center">
                    <h1>
                        GI-GST-2<br/>
                        INVESTIGATION OF CASES
                    </h1>
                </td>
            </tr>

           
            <tr style="font-size:15px;">
                <td align="left" colspan="7" style="padding-left:10px;">
                   <h2>${ViewBag_Report_Name}<br />
                   MONTH : <%=desDt.toUpperCase()%>                   
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
				       <th rowspan="2" colspan="2"  style="width:6%">OPENING BALANCE</th>
				       <th rowspan="2" colspan="2" style="width:6%">RECEIPT</th>
				       <th rowspan="1" colspan="10" style="width:6%">CASES DISPOSED OFF DURING THE MONTH</th>
				       <th rowspan="1" colspan="10" style="width:6%">CASES DISPOSED OFF UPTO THE MONTH</th>
				       <th rowspan="2" colspan="2" style="width:6%">Closing Balance</th>
				       <th rowspan="1" colspan="4" style="width:18%">Age Wise Breakup</th>
				   </tr>
				   <tr class="header_bcg_clr">
				       <th rowspan="1" colspan="2" >SCN/ DRC-01 ISSUED</th>
				       <th rowspan="1" colspan="2" >VOLUNTARY COMPLIANCE/ ISSUANCE OF DRC-04</th>
				       <th rowspan="1" colspan="2" >CLOSURE ON MERIT</th>
				       <th rowspan="1" colspan="2" >CLOSURE BY TRANSFER</th>
				       <th rowspan="1" colspan="2" >TOTAL</th> 
				       <th rowspan="1" colspan="2" >SCN/ DRC-01 ISSUED</th>
				       <th rowspan="1" colspan="2" >VOLUNTARY COMPLIANCE/ ISSUANCE OF DRC-04</th>
				       <th rowspan="1" colspan="2" >CLOSURE ON MERIT</th>
				       <th rowspan="1" colspan="2" >CLOSURE BY TRANSFER</th>
				       <th rowspan="1" colspan="2" >TOTAL</th> 
				       <th rowspan="1" colspan="2" >Less than 2 years</th>
				       <th rowspan="1" colspan="2" >More than 2 years</th> 
				       
				   </tr> 
				  <tr class="header_bcg_clr">
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				       <th rowspan="1" colspan="1" >NO. OF CASES</th>
				       <th rowspan="1" colspan="1" >TAX INVOLVED</th>
				        
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
				       <th  >24</th>
				       <th  >25</th>
				       <th  >26</th>
				       <th  >27</th>
				       <th  >28</th>
				       <th  >29</th>
				       <th  >30</th>
				       
				   </tr> 
				     <tr class="table-datarow-right" >
				     <td >${model.OPENING_BALANCE_NO}</td>
					 <td >${model.OPENING_BALANCE_TAX}</td>
					 <td >${model.RECEIPT_NO}</td>
					 <td >${model.RECEIPT_TAX}</td>
					 <td >${model.SCN_NO_DURING_THE_MOTNH}</td>
					 <td >${model.SCN_TAX_DURING_THE_MOTNH}</td>
					 <td >${model.VOLUNTARY_NO_DURING_THE_MOTNH}</td>
					 <td >${model.VOLUNTARY_TAX_DURING_THE_MOTNH}</td>
					 <td >${model.MERIT_NO_DURING_THE_MOTNH}</td>
					 <td >${model.MERIT_TAX_DURING_THE_MOTNH}</td>
					 <td >${model.TRANSFER_NO_DURING_THE_MOTNH}</td>
					 <td >${model.TRANSFER_TAX_DURING_THE_MOTNH}</td>
					 <td >${model.TOTAL_NO_DURING_THE_MONTH}</td>
					 <td >${model.TOTAL_TAX_DURING_THE_MONTH}</td>
					 <td >${model.SCN_NO_UPTO_THE_MOTNH}</td>
					 <td >${model.SCN_TAX_UPTO_THE_MOTNH}</td>
					 <td >${model.VOLUNTARY_NO_UPTO_THE_MOTNH}</td>
					 <td >${model.VOLUNTARY_TAX_UPTO_THE_MOTNH}</td>
					 <td >${model.MERIT_NO_UPTO_THE_MOTNH}</td>
					 <td >${model.MERIT_TAX_UPTO_THE_MOTNH}</td>
					 <td >${model.TRANSFER_NO_UPTO_THE_MOTNH}</td>
					 <td >${model.TRANSFER_TAX_UPTO_THE_MOTNH}</td>
					 <td >${model.TOTAL_NO_UPTO_THE_MONTH}</td>
					 <td >${model.TOTAL_TAX_UPTO_THE_MONTH}</td>
					 <td >${model.CLOSING_BALANCE_NO}</td>
					 <td >${model.CLOSING_BALANCE_TAX}</td>
					 <td >${model.LESS_THAN_2_NO}</td>
					 <td >${model.LESS_THAN_2_TAX}</td>
					 <td >${model.MORE_THAN_2_NO}</td>
					 <td >${model.MORE_THAN_2_TAX}</td>
				     </tr>
				</table>
				</c:if> 
       <c:if test="${empty model}">  
        <table class="Report_body">
            <tr>
                <th colspan="9" align="center" style="border: 1px solid !important">
                    <h1 style="color:red;">No Record Found !</h1>
                </th>
            </tr>
        </table>
        </c:if> 
    </div>
    
</body>
</html>


