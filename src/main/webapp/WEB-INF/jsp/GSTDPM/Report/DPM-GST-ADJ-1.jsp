<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width" />

   <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/mpr-report.css" rel="stylesheet" />
  
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

        <title>GST-ADJ-1</title>
    </head>
    <body>

    <div id="Report_main">
      <%!  String desDt = "";String strDate="";%>
        <%
						    strDate = (String) request.getAttribute("ViewBag_MM_YYYY");
					      	java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
					      	java.util.Date date = srcDtFormat.parse(strDate);
					      	java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
					        desDt = desDtFormat.format(date);
						%> 
   
      <table>
     
		<tr>
		<td style="text-align: center; ">
                                <a download='GST-ADJ-1(<%= desDt.toUpperCase() %>).xls' href="">Download</a>
                                    &nbsp;&nbsp; <a href="javascript:window.print();">Print</a> 
                                </td>
                                <td style="text-align: right; "><%= new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date()) %></td>
                                </tr>
				        
				        <c:set var = "TOTAL_COMM"  value = "${Model.TOTAL_COMM}"/>
				        <c:set var = "COMPLETE_COMM"  value = "${Model.COMPLETE_COMM}"/>
				        <c:set var = "AMND"  value = "${Model.AMND}"/>
             <c:if test="${!(empty Model)}">  
                      
                        <tr>
                                <td style="text-align: left;">
                                <c:if test = "${TOTAL_COMM > COMPLETE_COMM}">
                                <img src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/incomplete.gif" title="${COMPLETE_COMM}/${TOTAL_COMM}" />
                                </c:if> 
                                <c:if test = "${!(TOTAL_COMM > COMPLETE_COMM)}">
                                <img src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/complete.gif" />
                                </c:if>
                                <c:if test = "${AMND != 0}"> 
                                <a href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=DPM-GST-ADJ-1" style="color:brown; font-weight:bold;"><img src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
                                </c:if> 
                                </td>
                                <td>&nbsp;</td>
                            </tr>
                </c:if>            
                   
                    </table>
                     
               <table>   
                <tr>
                    <td colspan="4" align="center">
                        <h1>GST-ADJ-1</h1>
                        <h2>
                            Statement indicating Receipt, Disposal & Pendency of Adjudication cases
                    </h2>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="left" style="padding-left:10px;">
                    <h2>${ViewBag_Report_Name}<br />MONTH : <%= desDt.toUpperCase() %></h2>
                </td>
                <td colspan="2" align="right" style="padding-left:10px;"><h2>Amount in Rs. Lakhs</h2></td>

            </tr>
            
            
        </table>
        
  <c:if test="${!(empty Model)}">
           <c:if test="${ReportType=='Crr'}">
            
                <div><h2>CORRECTED REPORT<span style="color:red;">**Corrections are shown in red</span></h2></div>
            </c:if>
       
        

    <table id="report_1" class="Report_body">
        <tr class="header_bcg_clr">
            <th rowspan="2" colspan="1"  width="10%">
                ADJUDICATING AUTHORITY
            </th>
            <th rowspan="2" colspan="1"  width="10%">
                CATEGORY
            </th>
            <th colspan="2"  width="10%">
                OPENING BALANCE	
            </th>
            <th colspan="2"  width="10%">
                RECEIPT DURING THE MONTH	
            </th>
            <th colspan="2"  width="14%">
                RECEIPT UPTO THE MONTH	
            </th>
            <th  colspan="2"  width="14%">
               DISPOSAL DURING THE MONTH	
            </th>
            <th colspan="2"  width="10%">
                DISPOSAL UPTO THE MONTH	
            </th>
            <th colspan="2"  width="10%">
                % of cases where OIO issued within 30 days of PH	
            </th>
            <th colspan="2"  width="10%">
                CLOSING BALANCE 	
            </th>
            <th colspan="4"  width="14%">
                AGE WISE BREAK-UP OF PENDENCY			
            </th>
            <th  colspan="4"  width="14%">
               TIME LEFT FOR ADJUDICATION 				
            </th>
            
        </tr>
        
        <tr class="header_bcg_clr">
            
            <th align="center">NO</th>
            <th align="center">AMT</th>
            <th align="center">NO</th>
            <th align="center">AMT</th>
            <th align="center">NO</th>
            <th align="center">AMT</th>
            <th align="center">NO</th>
            <th align="center">AMT</th>
            <th align="center">NO</th>
            <th align="center">AMT</th>
            <th align="center">NO</th>
            <th align="center">AMT</th>
            <th align="center">NO</th>
            <th align="center">AMT</th>
                
                
            <th align="center">Less than 3 months</th>
            <th align="center">3 to 6 months</th>
            <th align="center">6 to12 months</th>
            <th align="center">More than 1 year</th>
            
            <th align="center">Less than 3 months</th>
            <th align="center">3 to 6 months</th>
            <th align="center">6 to12 months</th>
            <th align="center">More than 1 year</th>
          </tr>
          
        <tr class="header_bcg_clr">
            <th >1</th>
            <th >2</th>
            <th >3</th>
            <th >4</th>
            <th >5</th>
            <th >6</th>
            <th >7</th>
            <th >8</th>
            <th >9</th>
            <th >10</th>
            <th >11</th>
            <th >12</th>
            <th >13</th>
            <th >14</th>
            <th >15</th>
            <th >16</th>
            <th >17</th>
            <th >18</th>
            <th >19</th>
            <th >20</th>
            <th >21</th>
            <th >22</th>
            <th >23</th>
            <th >24</th>
            
        </tr>
        <tr class="table-datarow-right">
            
            <th    rowspan="4">
                ADC/JC
            </th>
            <th>
                COMMISSIONERATE LEVEL CASES
            </th>
            
            <td>${Model.ADC_COMMISSIONERATE_OPENING_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_OPENING_AMT}</td>
            <td>${Model.ADC_COMMISSIONERATE_RECEIPT_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_RECEIPT_AMT}</td>
            <td>${Model.ADC_COMMISSIONERATE_RECEIPT_NO_UPTO}</td>
            <td>${Model.ADC_COMMISSIONERATE_RECEIPT_AMT_UPTO}</td>
            <td>${Model.ADC_COMMISSIONERATE_DISPOSAL_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_DISPOSAL_AMT}</td>
            <td>${Model.ADC_COMMISSIONERATE_DISPOSAL_NO_UPTO}</td>
            <td>${Model.ADC_COMMISSIONERATE_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.ADC_COMMISSIONERATE_OIO_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_OIO_AMT}</td>
            <td>${Model.ADC_COMM_CLOSING_NO}</td>
            <td>${Model.ADC_COMM_CLOSING_AMT}</td>
            <td>${Model.ADC_COMMISSIONERATE_AGE_LESS_3_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_AGE_3_TO_6_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_AGE_6_TO_12_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_TIME_LESS_3_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_TIME_3_TO_6_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_TIME_6_TO_12_NO}</td>
            <td>${Model.ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO}</td>
       
            </tr>
        <tr class="table-datarow-right">
            
            <th>
                AUDIT CASES
            </th>
            
            <td>${Model.ADC_AUDIT_OPENING_NO}</td>
            <td>${Model.ADC_AUDIT_OPENING_AMT}</td>
            <td>${Model.ADC_AUDIT_RECEIPT_NO}</td>
            <td>${Model.ADC_AUDIT_RECEIPT_AMT}</td>
            <td>${Model.ADC_AUDIT_RECEIPT_NO_UPTO}</td>
            <td>${Model.ADC_AUDIT_RECEIPT_AMT_UPTO}</td>
            <td>${Model.ADC_AUDIT_DISPOSAL_NO}</td>
            <td>${Model.ADC_AUDIT_DISPOSAL_AMT}</td>
            <td>${Model.ADC_AUDIT_DISPOSAL_NO_UPTO}</td>
            <td>${Model.ADC_AUDIT_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.ADC_AUDIT_OIO_NO}</td>
            <td>${Model.ADC_AUDIT_OIO_AMT}</td>
            <td>${Model.ADC_AUDIT_CLOSING_NO}</td>
            <td>${Model.ADC_AUDIT_CLOSING_AMT}</td>
            <td>${Model.ADC_AUDIT_AGE_LESS_3_NO}</td>
            <td>${Model.ADC_AUDIT_AGE_3_TO_6_NO}</td>
            <td>${Model.ADC_AUDIT_AGE_6_TO_12_NO}</td>
            <td>${Model.ADC_AUDIT_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.ADC_AUDIT_TIME_LESS_3_NO}</td>
            <td>${Model.ADC_AUDIT_TIME_3_TO_6_NO}</td>
            <td>${Model.ADC_AUDIT_TIME_6_TO_12_NO}</td>
            <td>${Model.ADC_AUDIT_TIME_MORE_THAN_1_NO}</td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th>
                INVESTIGATION AGENCIES CASES
            </th>
            
           <td>${Model.ADC_INVESTIGATION_OPENING_NO}</td>
            <td>${Model.ADC_INVESTIGATION_OPENING_AMT}</td>
            <td>${Model.ADC_INVESTIGATION_RECEIPT_NO}</td>
            <td>${Model.ADC_INVESTIGATION_RECEIPT_AMT}</td>
            <td>${Model.ADC_INVESTIGATION_RECEIPT_NO_UPTO}</td>
            <td>${Model.ADC_INVESTIGATION_RECEIPT_AMT_UPTO}</td>
            <td>${Model.ADC_INVESTIGATION_DISPOSAL_NO}</td>
            <td>${Model.ADC_INVESTIGATION_DISPOSAL_AMT}</td>
            <td>${Model.ADC_INVESTIGATION_DISPOSAL_NO_UPTO}</td>
            <td>${Model.ADC_INVESTIGATION_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.ADC_INVESTIGATION_OIO_NO}</td>
            <td>${Model.ADC_INVESTIGATION_OIO_AMT}</td>
            <td>${Model.ADC_INVESTIGATION_CLOSING_NO}</td>
            <td>${Model.ADC_INVESTIGATION_CLOSING_AMT}</td>
            <td>${Model.ADC_INVESTIGATION_AGE_LESS_3_NO}</td>
            <td>${Model.ADC_INVESTIGATION_AGE_3_TO_6_NO}</td>
            <td>${Model.ADC_INVESTIGATION_AGE_6_TO_12_NO}</td>
            <td>${Model.ADC_INVESTIGATION_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.ADC_INVESTIGATION_TIME_LESS_3_NO}</td>
            <td>${Model.ADC_INVESTIGATION_TIME_3_TO_6_NO}</td>
            <td>${Model.ADC_INVESTIGATION_TIME_6_TO_12_NO}</td>
            <td>${Model.ADC_INVESTIGATION_TIME_MORE_THAN_1_NO}</td>
            
            </tr>
        <tr class="table-datarow-right">
            <th >
                CALL BOOK CASES 
                CASES PENDING UNDER SECTION 75(11) OF CGST ACT
            </th>
            
            <td>${Model.ADC_CALLBOOK_OPENING_NO}</td>
            <td>${Model.ADC_CALLBOOK_OPENING_AMT}</td>
            <td>${Model.ADC_CALLBOOK_RECEIPT_NO}</td>
            <td>${Model.ADC_CALLBOOK_RECEIPT_AMT}</td>
            <td>${Model.ADC_CALLBOOK_RECEIPT_NO_UPTO}</td>
            <td>${Model.ADC_CALLBOOK_RECEIPT_AMT_UPTO}</td>
            <td>${Model.ADC_CALLBOOK_DISPOSAL_NO}</td>
            <td>${Model.ADC_CALLBOOK_DISPOSAL_AMT}</td>
            <td>${Model.ADC_CALLBOOK_DISPOSAL_NO_UPTO}</td>
            <td>${Model.ADC_CALLBOOK_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.ADC_CALLBOOK_OIO_NO}</td>
            <td>${Model.ADC_CALLBOOK_OIO_AMT}</td>
            <td>${Model.ADC_CALLBOOK_CLOSING_NO}</td>
            <td>${Model.ADC_CALLBOOK_CLOSING_AMT}</td>
            <td>${Model.ADC_CALLBOOK_AGE_LESS_3_NO}</td>
            <td>${Model.ADC_CALLBOOK_AGE_3_TO_6_NO}</td>
            <td>${Model.ADC_CALLBOOK_AGE_6_TO_12_NO}</td>
            <td>${Model.ADC_CALLBOOK_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.ADC_CALLBOOK_TIME_LESS_3_NO}</td>
            <td>${Model.ADC_CALLBOOK_TIME_3_TO_6_NO}</td>
            <td>${Model.ADC_CALLBOOK_TIME_6_TO_12_NO}</td>
            <td>${Model.ADC_CALLBOOK_TIME_MORE_THAN_1_NO}</td>
            
            </tr>
                  
            
        <tr class="table-datarow-right">
            
            <th    rowspan="4">
                DC/AC
            </th>
            <th >
                COMMISSIONERATE LEVEL CASES
            </th>
            
            <td>${Model.DC_COMMISSIONERATE_OPENING_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_OPENING_AMT}</td>
            <td>${Model.DC_COMMISSIONERATE_RECEIPT_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_RECEIPT_AMT}</td>
            <td>${Model.DC_COMMISSIONERATE_RECEIPT_NO_UPTO}</td>
            <td>${Model.DC_COMMISSIONERATE_RECEIPT_AMT_UPTO}</td>
            <td>${Model.DC_COMMISSIONERATE_DISPOSAL_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_DISPOSAL_AMT}</td>
            <td>${Model.DC_COMMISSIONERATE_DISPOSAL_NO_UPTO}</td>
            <td>${Model.DC_COMMISSIONERATE_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.DC_COMMISSIONERATE_OIO_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_OIO_AMT}</td>
            <td>${Model.DC_COMM_CLOSING_NO}</td>
            <td>${Model.DC_COMM_CLOSING_AMT}</td>
            <td>${Model.DC_COMMISSIONERATE_AGE_LESS_3_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_AGE_3_TO_6_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_AGE_6_TO_12_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_TIME_LESS_3_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_TIME_3_TO_6_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_TIME_6_TO_12_NO}</td>
            <td>${Model.DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO}</td>
       
            </tr>
        <tr class="table-datarow-right">
            
            <th>
                AUDIT CASES
            </th>
            
            <td>${Model.DC_AUDIT_OPENING_NO}</td>
            <td>${Model.DC_AUDIT_OPENING_AMT}</td>
            <td>${Model.DC_AUDIT_RECEIPT_NO}</td>
            <td>${Model.DC_AUDIT_RECEIPT_AMT}</td>
            <td>${Model.DC_AUDIT_RECEIPT_NO_UPTO}</td>
            <td>${Model.DC_AUDIT_RECEIPT_AMT_UPTO}</td>
            <td>${Model.DC_AUDIT_DISPOSAL_NO}</td>
            <td>${Model.DC_AUDIT_DISPOSAL_AMT}</td>
            <td>${Model.DC_AUDIT_DISPOSAL_NO_UPTO}</td>
            <td>${Model.DC_AUDIT_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.DC_AUDIT_OIO_NO}</td>
            <td>${Model.DC_AUDIT_OIO_AMT}</td>
            <td>${Model.DC_AUDIT_CLOSING_NO}</td>
            <td>${Model.DC_AUDIT_CLOSING_AMT}</td>
            <td>${Model.DC_AUDIT_AGE_LESS_3_NO}</td>
            <td>${Model.DC_AUDIT_AGE_3_TO_6_NO}</td>
            <td>${Model.DC_AUDIT_AGE_6_TO_12_NO}</td>
            <td>${Model.DC_AUDIT_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.DC_AUDIT_TIME_LESS_3_NO}</td>
            <td>${Model.DC_AUDIT_TIME_3_TO_6_NO}</td>
            <td>${Model.DC_AUDIT_TIME_6_TO_12_NO}</td>
            <td>${Model.DC_AUDIT_TIME_MORE_THAN_1_NO}</td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th>
                INVESTIGATION AGENCIES CASES
            </th>
            
           <td>${Model.DC_INVESTIGATION_OPENING_NO}</td>
            <td>${Model.DC_INVESTIGATION_OPENING_AMT}</td>
            <td>${Model.DC_INVESTIGATION_RECEIPT_NO}</td>
            <td>${Model.DC_INVESTIGATION_RECEIPT_AMT}</td>
            <td>${Model.DC_INVESTIGATION_RECEIPT_NO_UPTO}</td>
            <td>${Model.DC_INVESTIGATION_RECEIPT_AMT_UPTO}</td>
            <td>${Model.DC_INVESTIGATION_DISPOSAL_NO}</td>
            <td>${Model.DC_INVESTIGATION_DISPOSAL_AMT}</td>
            <td>${Model.DC_INVESTIGATION_DISPOSAL_NO_UPTO}</td>
            <td>${Model.DC_INVESTIGATION_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.DC_INVESTIGATION_OIO_NO}</td>
            <td>${Model.DC_INVESTIGATION_OIO_AMT}</td>
            <td>${Model.DC_INVESTIGATION_CLOSING_NO}</td>
            <td>${Model.DC_INVESTIGATION_CLOSING_AMT}</td>
            <td>${Model.DC_INVESTIGATION_AGE_LESS_3_NO}</td>
            <td>${Model.DC_INVESTIGATION_AGE_3_TO_6_NO}</td>
            <td>${Model.DC_INVESTIGATION_AGE_6_TO_12_NO}</td>
            <td>${Model.DC_INVESTIGATION_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.DC_INVESTIGATION_TIME_LESS_3_NO}</td>
            <td>${Model.DC_INVESTIGATION_TIME_3_TO_6_NO}</td>
            <td>${Model.DC_INVESTIGATION_TIME_6_TO_12_NO}</td>
            <td>${Model.DC_INVESTIGATION_TIME_MORE_THAN_1_NO}</td>
            
            </tr>
        <tr class="table-datarow-right">
            <th >
                CALL BOOK CASES 
                CASES PENDING UNDER SECTION 75(11) OF CGST ACT
            </th>
            
            <td>${Model.DC_CALLBOOK_OPENING_NO}</td>
            <td>${Model.DC_CALLBOOK_OPENING_AMT}</td>
            <td>${Model.DC_CALLBOOK_RECEIPT_NO}</td>
            <td>${Model.DC_CALLBOOK_RECEIPT_AMT}</td>
            <td>${Model.DC_CALLBOOK_RECEIPT_NO_UPTO}</td>
            <td>${Model.DC_CALLBOOK_RECEIPT_AMT_UPTO}</td>
            <td>${Model.DC_CALLBOOK_DISPOSAL_NO}</td>
            <td>${Model.DC_CALLBOOK_DISPOSAL_AMT}</td>
            <td>${Model.DC_CALLBOOK_DISPOSAL_NO_UPTO}</td>
            <td>${Model.DC_CALLBOOK_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.DC_CALLBOOK_OIO_NO}</td>
            <td>${Model.DC_CALLBOOK_OIO_AMT}</td>
            <td>${Model.DC_CALLBOOK_CLOSING_NO}</td>
            <td>${Model.DC_CALLBOOK_CLOSING_AMT}</td>
            <td>${Model.DC_CALLBOOK_AGE_LESS_3_NO}</td>
            <td>${Model.DC_CALLBOOK_AGE_3_TO_6_NO}</td>
            <td>${Model.DC_CALLBOOK_AGE_6_TO_12_NO}</td>
            <td>${Model.DC_CALLBOOK_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.DC_CALLBOOK_TIME_LESS_3_NO}</td>
            <td>${Model.DC_CALLBOOK_TIME_3_TO_6_NO}</td>
            <td>${Model.DC_CALLBOOK_TIME_6_TO_12_NO}</td>
            <td>${Model.DC_CALLBOOK_TIME_MORE_THAN_1_NO}</td>
            
            </tr>
            <tr class="table-datarow-right">
            
            <th    rowspan="4">
                Superintendent
            </th>
            <th >
                COMMISSIONERATE LEVEL CASES
            </th>
            
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_OPENING_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO_UPTO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT_UPTO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO_UPTO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_OIO_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_OIO_AMT}</td>
            <td>${Model.SUPERINTENDENT_COMM_CLOSING_NO}</td>
            <td>${Model.SUPERINTENDENT_COMM_CLOSING_AMT}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO}</td>
            <td>${Model.SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO}</td>
       
            </tr>
        <tr class="table-datarow-right">
            
            <th>
                AUDIT CASES
            </th>
            
            <td>${Model.SUPERINTENDENT_AUDIT_OPENING_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_OPENING_AMT}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_RECEIPT_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_RECEIPT_AMT}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_RECEIPT_NO_UPTO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_RECEIPT_AMT_UPTO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_DISPOSAL_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_DISPOSAL_AMT}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_DISPOSAL_NO_UPTO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_OIO_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_OIO_AMT}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_CLOSING_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_CLOSING_AMT}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_AGE_LESS_3_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_TIME_LESS_3_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO}</td>
            <td>${Model.SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO}</td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th>
                INVESTIGATION AGENCIES CASES
            </th>
            
           <td>${Model.SUPERINTENDENT_INVESTIGATION_OPENING_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_OPENING_AMT}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_RECEIPT_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_RECEIPT_NO_UPTO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT_UPTO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO_UPTO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_OIO_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_OIO_AMT}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_CLOSING_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_CLOSING_AMT}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO}</td>
            <td>${Model.SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO}</td>
            
            </tr>
        <tr class="table-datarow-right">
            <th >
                CALL BOOK CASES 
                CASES PENDING UNDER SECTION 75(11) OF CGST ACT
            </th>
            
            <td>${Model.SUPERINTENDENT_CALLBOOK_OPENING_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_OPENING_AMT}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_RECEIPT_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_RECEIPT_AMT}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_RECEIPT_NO_UPTO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_RECEIPT_AMT_UPTO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_DISPOSAL_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_DISPOSAL_NO_UPTO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT_UPTO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_OIO_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_OIO_AMT}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_CLOSING_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_CLOSING_AMT}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO}</td>
            <td>${Model.SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO}</td>
            
            </tr>

    </table>
  
         
</c:if>

<c:if test="${Model==null || Model==''}">  
            <table class="Report_body">
    <tr>
        <th colspan="4" align="center">
            <h1 style="color:red;">No Record Found !</h1>
        </th>
    </tr>
</table>
</c:if>
</div>
</body>
</html>
