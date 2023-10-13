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

    <title>GST-ADJ-2</title>
</head>
<body>
<%!String desDt = "";
    String strDate = "";%>
    <c:set var="TOTAL_COMM" value="${Model_TOTAL_COMM}" />
    <c:set var="COMPLETE_COMM" value="${Model_COMPLETE_COMM}" />
    <c:set var="AMND" value="${Model_AMND}" />
    <c:set var="RECEIPT" value="${Model_RECEIPT}" />
    
    
    <div id="Report_main">
     <%
                        String strDate = (String) request.getAttribute("_mm_yyyy");
                        java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = srcDtFormat.parse(strDate);
                        java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
                        desDt = desDtFormat.format(date);
                    
                    %>
	<!-- <table> -->
		<%-- <c:if test="${Model != null}"> --%>
		<c:if test="${not empty Model && Model_COMPLETE_COMM >=1 && RECEIPT!=null }">
            <table >
                <tr>
                    <td style="text-align: left;">                  
					
					<c:if test="${TOTAL_COMM > COMPLETE_COMM}">
								<img
									src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/incomplete.gif"
									title="${COMPLETE_COMM}/${TOTAL_COMM}" />
							</c:if> 
							<c:if test="${!(TOTAL_COMM > COMPLETE_COMM)}">
								<img src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/complete.gif" />
							</c:if>
							
                    <c:if test="${AMND != 0}">
                            <a
                                href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_mm_yyyy}&MPR=DPM-GST-ADJ-2"
                                style="color: brown; font-weight: bold;"> <img
                                src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
                    </c:if></td>
                    
                    <td>&nbsp;</td>
                    
                    <td style="text-align: center;"><a
                        download='DPM-GST-ADJ-2(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
                    <td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
                </tr>
            </table>
        </c:if>  
        <table width="100%" >
            <tr>
                <td colspan="20" align="center">
                    <h1 align="center">GST-ADJ-2 </h1>
                    <h2 align="center">Details of adjudication cases involving GST more than Rs. Five Crores</h2>
                </td>                                            
            </tr>                                                 
            <tr>
                <td align="left" colspan="2" style="padding-left:10px;">
                   <h2>${ViewBag_report_name}<br />
                   MONTH : <%=desDt.toUpperCase()%>                   
                   </h2>
                </td>
               
	                <td align="right" colspan="2" style="padding-left:10px;">
	                    <h2>Amount in Rs. Lakhs</h2>
	               </td>
               
            </tr>
      </table>
        <!-- && Model_COMPLETE_COMM >=1 -->
              <c:if test="${not empty Model && (Model_COMPLETE_COMM > 0) && RECEIPT!=null}"> 
            <% int i=0; %>
		         <c:if test="${Report_Type=='Crr'}">
		            <div><h2>CORRECTED REPORT<span style="color:red;"> **Corrections are shown in red</span></h2></div>
		        </c:if>
				<table id="report_1" class="Report_body" >
				   <tr class="header_bcg_clr">
				       <th rowspan="2" colspan="2"   align="center">OPENING BALANCE</th>
				       <th rowspan="2" colspan="2" align="center">RECEIPT DURING THE MONTH</th>
				       <th rowspan="2" colspan="2" align="center">RECEIPT UPTO THE MONTH</th>
				       <th rowspan="1" colspan="4" align="center">DISPOSAL DURING THE MONTH*</th>
				       <th rowspan="2" colspan="2" align="center">TOTAL DISPOSAL</th>
				       <th rowspan="2" colspan="2" align="center">CLOSING BALANCE</th>
				       <th rowspan="2" colspan="3" align="center">AGE WISE BREAK UP OF PENDENCY</th>				       
				   </tr>
				   <tr class="header_bcg_clr">
				    <th rowspan="1" colspan="2" align="center">DECIDED IN FAVOUR OF REVENUE</th>
				       <th rowspan="1" colspan="2" align="center">DECIDED IN FAVOUR OF TAX PAYER</th>
				   </tr>
				   <tr class="header_bcg_clr">
				       <th  rowspan="1" colspan="1" align="center">No.</th>
				       <th  colspan="1" align="center" >Amount</th>
				       <th  colspan="1" align="center">No.</th>
				       <th colspan="1" align="center">Amount</th>
				        <th  colspan="1" align="center">No.</th>
				       <th colspan="1" align="center">Amount</th>
				        <th rowspan="1" colspan="1" align="center">No.</th>
				       <th rowspan="1" colspan="1" align="center">Amount</th>
				       <th rowspan="1" colspan="1" align="center">No.</th>
				       <th rowspan="1" colspan="1" align="center">Amount</th>				       
				       <th rowspan="1" colspan="1" align="center">No.</th>
				       <th rowspan="1" colspan="1" align="center">Amount</th>
				       <th rowspan="1" colspan="1" align="center">No.</th>
				       <th rowspan="1" colspan="1" align="center">Amount</th>
				       <th rowspan="1" colspan="1" align="center">Up to 6 months</th>
				       <th rowspan="1" colspan="1" align="center">6 to 12 months</th>
				       <th rowspan="1" colspan="1" align="center">More than  1 year</th> 				       
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
				       <th align="center">15</th>
				       <th align="center">16</th>
				       <th align="center">17</th>
				   </tr> 
					<c:forEach items="${Model}" var="model">
					 <tr >
                        <td width="5%" class="table-datarow-center">${(model.OPENING_NO)}</td>
                        <td  width="5%" align="right" style="overflow-wrap: anywhere;" >${(model.OPENING_AMT)}</td>
                        <td  width="5%"  class="table-datarow-center">${(model.RECEIPT_NO)}</td>
                        <td  width="5%" align="right">${(model.RECEIPT_AMT)}</td>
                        <td  width="5%"  class="table-datarow-center">${(model.RECEIPT_UPTO_NO)}</td>
                    	<td width="5%"  align="right">${(model.RECEIPT_UPTO_AMT)}</td>
                     	<td  width="5%" class="table-datarow-center">${(model.DISPOSAL_REVENUE_NO)}</td>
                    	<td width="5%"  align="right" >${(model.DISPOSAL_REVENUE_AMT)}</td>
                     	<td  width="5%"  class="table-datarow-center">${(model.DISPOSAL_TAXPAYER_NO)}</td>
                    	<td  width="5%" align="right">${(model.DISPOSAL_TAXPAYER_AMT)}</td>
                    	<td  width="5%" class="table-datarow-center">${(model.TOTAL_DISPOSAL_NO)}</td>
                     	<td  width="5%" align="right">${(model.TOTAL_DISPOSAL_AMOUNT)}</td>
                    	<td  width="5%"  class="table-datarow-center">${(model.CLOSING_BALANCE_NO)}</td>
                    	<td  width="5%"  align="right" >${(model.CLOSING_BALANCE_AMOUNT)}</td>   
                    	<td  width="5%" class="table-datarow-center">${(model.AGE_UPTO_6_NO)}</td>
                     	<td  width="5%" class="table-datarow-center">${(model.AGE_6_TO_12_NO)}</td>
                    	<td  width="5%"  class="table-datarow-center">${(model.AGE_MORE_THAN_1_NO)}</td>
                    	           
                </tr>
					</c:forEach>
					<tr>
					 <!-- <td colspan="17">
					 * Where case is decided partly in favour of department and partly in favour of taxpayer, then amount will be shown as per order but the no. will be figured in column where highest amount is involved. 
					 </td>-->
					 </tr>
				</table>
				 * Where case is decided partly in favour of department and partly in favour of taxpayer, then amount will be shown as per order but the no. will be figured in column where highest amount is involved.
         </c:if>  
       
        
        <c:if test="${empty Model || (Model_COMPLETE_COMM == 0) || RECEIPT==null}">
        <table class="Report_body">
                <tr>
                    <th colspan="17" align="center">
                        <h1 style="color:red;">No Record Found !</h1>
                    </th>
                </tr>
            </table>
        </c:if>
    </div>
    
</body>
</html>


