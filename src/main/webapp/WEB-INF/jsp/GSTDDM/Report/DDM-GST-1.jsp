<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width" />

   <link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/mpr-report.css" rel="stylesheet" />
  <style type="text/css">
  body {
            vertical-align: top;
            font-family: "Segoe UI", Verdana, Helvetica, Sans-Serif;   
            background-color:#D8F2FF;  
                         
        }
          .header_bcg_clr{                        
		    background: linear-gradient(225deg, #2bd8ff 20%, #003fa5 30% ,#00BDFE 55%);
		    color: #fff ;
            }
  </style>
 
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

        <title>DDM-GST-1</title>
    </head>
    <body>

    <div id="Report_main">
    <c:if test="${!(empty Model)}" >
      <table>
        <%!  String desDt = "";String strDate="";%>
        <%
						    strDate = (String) request.getAttribute("ViewBag_MM_YYYY");
					      	java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
					      	java.util.Date date = srcDtFormat.parse(strDate);
					      	java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
					        desDt = desDtFormat.format(date);
						%> 
		<tr>
		<td style="text-align: center; ">
                                <a download='DDM-GST-1(<%= desDt.toUpperCase() %>).xls' href="">Download</a>
                                    &nbsp;&nbsp; <a href="javascript:window.print();">Print</a> 
                                </td>
                                <td style="text-align: right; "><%= new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date()) %></td>
                                </tr>
        <c:set var = "TOTAL_COMM"  value = "${Model.TOTAL_COMM}"/>
        <c:set var = "COMPLETE_COMM"  value = "${Model.COMPLETE_COMM}"/>
        <c:set var = "AMND"  value = "${Model.AMND}"/>
               
                      
                        <tr>
                                <td style="text-align: left;">
                                <c:if test = "${TOTAL_COMM > COMPLETE_COMM}">
                                <img src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/incomplete.gif" title="${COMPLETE_COMM}/${TOTAL_COMM}" />
                                </c:if> 
                                <c:if test = "${!(TOTAL_COMM > COMPLETE_COMM)}">
                                <img src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/complete.gif" />
                                </c:if>
                                <c:if test = "${AMND != 0}"> 
                                <a href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=DDM-GST-1" style="color:brown; font-weight:bold;"><img src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
                                </c:if> 
                                </td>
                                <td>&nbsp;</td>
                            </tr>
                   
                    </table>
                     </c:if>
               <table>   
                <tr>
                    <td colspan="4" align="center">
                        <h1>DDM-GST-1</h1>
                        <h2>
                            REVENUE REPORT
                    </h2>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="left" style="padding-left:10px;">
                    <h2>${ViewBag_Report_Name}<br />MONTH : <%= desDt.toUpperCase() %></h2>
                </td>
                <td colspan="2" align="right" style="padding-left:10px;"><h2>Amount in Rs. Crores</h2></td>

            </tr>
            
            
        </table>
        
  <c:if test="${!(empty Model)}">
           <c:if test="${ReportType=='Crr'}">
            
                <div><h2>CORRECTED REPORT<span style="color:red;">**Corrections are shown in red</span></h2></div>
            </c:if>
       
        

    <table id="report_1" class="Report_body" >
        <tr class="header_bcg_clr">
            <th rowspan="2" colspan="2"  width="10%">
                DESCRIPTION
            </th>
            <th rowspan="2"  width="10%">
                TARGET FOR CURRENT FINANCIAL YEAR
            </th>
            <th colspan="2"  width="10%">
                MOVING TARGET
            </th>
            <th colspan="2"  width="14%">
                TAX COLLECTED FOR CURRENT F.Y.	
            </th>
            <th  colspan="2"  width="14%">
               % INCREASE/DECREASE OVER MOVING TARGET 
            </th>
            <th  colspan="2"   width="14%">
                TAX COLLECTED DURING PREVIOUS F.Y.
            </th>
            <th colspan="2"  width="14%">
                INCREASE/DECREASE OVER PREVIOUS F.Y.
            </th>
            <th  colspan="2"  width="14%">
                % INCREASE/DECREASE OVER PREVIOUS F.Y.
            </th>
        </tr>
        
        <tr class="header_bcg_clr">
            
            <th rowspan="1" colspan="1" align="center">
                    FOR THE MONTH
            </th>
            <th rowspan="1" colspan="1" align="center">
                    UPTO THE MONTH
            </th>
                
                
            <th rowspan="1" colspan="1" align="center">
                FOR THE MONTH
            </th>
            <th rowspan="1" colspan="1" align="center">
                UPTO THE MONTH
            </th>
            <th rowspan="1" colspan="1" align="center">
                FOR THE MONTH
            </th>
            <th rowspan="1" colspan="1" align="center">
                UPTO THE MONTH
            </th>
            <th rowspan="1" colspan="1" align="center">
                FOR THE MONTH
            </th>
            <th rowspan="1" colspan="1" align="center">
                UPTO THE MONTH
            </th>
            <th rowspan="1" colspan="1" align="center">
                FOR THE MONTH
            </th>
            <th rowspan="1" colspan="1" align="center">
                UPTO THE MONTH
            </th>
            <th rowspan="1" colspan="1" align="center">
                FOR THE MONTH
            </th>
            <th rowspan="1" colspan="1" align="center">
                UPTO THE MONTH
            </th>
        </tr>
        <tr>
            <th>1</th>
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
            
        </tr>
        <tr class="table-datarow-right">
            <th    rowspan="5">
                GROSS REVENUE
            </th>
            <th  >
                CGST
            </th>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.GROSS_TAX_CGST_C}
            </td>
            <td  >
                ${Model.GROSS_TAX_CGST_UPTO_C}
            </td>
            <td  >
                
            </td>
            <td  >
               
            </td>
            <td  >
                ${Model.GROSS_TAX_CGST_P}
            </td>
            <td  >
                ${Model.GROSS_TAX_CGST_UPTO_P}
            </td>
            <td  >
                ${Model.DIFF_GROSS_REVENUE_TAX_CGST_C}
            </td>
            <td  >
                ${Model.DIFF_GROSS_REVENUE_TAX_CGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_GROSS_REVENUE_TAX_CGST_C}
            </td>
            <td  >
                ${Model.PERCENT_GROSS_REVENUE_TAX_CGST_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  >
                SGST
            </th>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.GROSS_TAX_SGST_C}
            </td>
            <td  >
                ${Model.GROSS_TAX_SGST_UPTO_C}
            </td>
            <td  >
               
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.GROSS_TAX_SGST_P}
            </td>
            <td  >
                ${Model.GROSS_TAX_SGST_UPTO_P}
            </td>
            <td  >
                ${Model.DIFF_GROSS_REVENUE_TAX_SGST_C}
            </td>
            <td  >
                ${Model.DIFF_GROSS_REVENUE_TAX_SGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_GROSS_REVENUE_TAX_SGST_C}
            </td>
            <td  >
                ${Model.PERCENT_GROSS_REVENUE_TAX_SGST_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  >
                IGST
            </th>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.GROSS_TAX_IGST_C}
            </td>
            <td  >
                ${Model.GROSS_TAX_IGST_UPTO_C}
            </td>
            <td  >
               
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.GROSS_TAX_IGST_P}
            </td>
            <td  >
                ${Model.GROSS_TAX_IGST_UPTO_P}
            </td>
            <td  >
                ${Model.DIFF_GROSS_REVENUE_TAX_IGST_C}
            </td>
            <td  >
                ${Model.DIFF_GROSS_REVENUE_TAX_IGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_GROSS_REVENUE_TAX_IGST_C}
            </td>
            <td  >
                ${Model.PERCENT_GROSS_REVENUE_TAX_IGST_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            <th  >
                CESS
            </th>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.GROSS_TAX_CESS_C}
            </td>
            <td  >
                ${Model.GROSS_TAX_CESS_UPTO_C}
            </td>
            <td  >
               
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.GROSS_TAX_CESS_P}
            </td>
            <td  >
                ${Model.GROSS_TAX_CESS_UPTO_P}
            </td>
            <td  >
                ${Model.DIFF_GROSS_REVENUE_TAX_CESS_C}
            </td>
            <td  >
                ${Model.DIFF_GROSS_REVENUE_TAX_CESS_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_GROSS_REVENUE_TAX_CESS_C}
            </td>
            <td  >
                ${Model.PERCENT_GROSS_REVENUE_TAX_CESS_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  >
                TOTAL
            </th>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.TOTAL_GROSS_TAX_C}
            </td>
            <td  >
                ${Model.TOTAL_GROSS_TAX_UPTO_C}
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.TOTAL_GROSS_TAX_P}
            </td>
            <td  >
                ${Model.TOTAL_GROSS_TAX_UPTO_P}
            </td>
            <td  >
                ${Model.TOTAL_DIFF_GROSS_REVENUE_TAX_C}
            </td>
            <td  >
                ${Model.TOTAL_DIFF_GROSS_REVENUE_TAX_UPTO_C}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_GROSS_REVENUE_TAX_C}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_GROSS_REVENUE_TAX_UPTO_C}
            </td>
            
            </tr>
            
            
        <tr class="table-datarow-right">
            <th    rowspan="5">
                Refund  Sanctioned
            </th>
            <th  >
                CGST
            </th>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_CGST_C}
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_CGST_UPTO_C}
            </td>
            <td  >
                
            </td>
            <td  >
               
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_CGST_P}
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_CGST_UPTO_P}
            </td>
            <td  >
                ${Model.DIFF_REFUND_SANCTIONED_CGST_C}
            </td>
            <td  >
                ${Model.DIFF_REFUND_SANCTIONED_CGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_REFUND_SANCTIONED_CGST_C}
            </td>
            <td  >
                ${Model.PERCENT_REFUND_SANCTIONED_CGST_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  >
                SGST
            </th>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_SGST_C}
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_SGST_UPTO_C}
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_SGST_P}
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_SGST_UPTO_P}
            </td>
            <td  >
                ${Model.DIFF_REFUND_SANCTIONED_SGST_C}
            </td>
            <td  >
                ${Model.DIFF_REFUND_SANCTIONED_SGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_REFUND_SANCTIONED_SGST_C}
            </td>
            <td  >
                ${Model.PERCENT_REFUND_SANCTIONED_SGST_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  >
                IGST
            </th>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_IGST_C}
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_IGST_UPTO_C}
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_IGST_P}
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_IGST_UPTO_P}
            </td>
            <td  >
                ${Model.DIFF_REFUND_SANCTIONED_IGST_C}
            </td>
            <td  >
                ${Model.DIFF_REFUND_SANCTIONED_IGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_REFUND_SANCTIONED_IGST_C}
            </td>
            <td  >
                ${Model.PERCENT_REFUND_SANCTIONED_IGST_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            <th  >
                CESS
            </th>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_CESS_C}
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_CESS_UPTO_C}
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_CESS_P}
            </td>
            <td  >
                ${Model.REFUND_SANCTIONED_CESS_UPTO_P}
            </td>
            <td  >
                ${Model.DIFF_REFUND_SANCTIONED_CESS_C}
            </td>
            <td  >
                ${Model.DIFF_REFUND_SANCTIONED_CESS_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_REFUND_SANCTIONED_CESS_C}
            </td>
            <td  >
                ${Model.PERCENT_REFUND_SANCTIONED_CESS_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  >
                TOTAL
            </th>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.TOTAL_REFUND_SANCTIONED_C}
            </td>
            <td  >
                ${Model.TOTAL_REFUND_SANCTIONED_UPTO_C}
            </td>
            <td  >
                
            </td>
            <td  >
                
            </td>
            <td  >
                ${Model.TOTAL_REFUND_SANCTIONED_P}
            </td>
            <td  >
                ${Model.TOTAL_REFUND_SANCTIONED_UPTO_P}
            </td>
            <td  >
                ${Model.TOTAL_DIFF_REFUND_SANCTIONED_C}
            </td>
            <td  >
                ${Model.TOTAL_DIFF_REFUND_SANCTIONED_UPTO_C}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_REFUND_SANCTIONED_C}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_REFUND_SANCTIONED_UPTO_C}
            </td>
            
            </tr>
            
        <tr class="table-datarow-right">
            <th    rowspan="5">
                Net Revenue
            </th>
            <th  >
                CGST
            </th>
            <td  >
                ${Model.TARGET_CGST_C}
            </td>
            <td  >
                ${Model.NET_MOVING_TARGET_CGST_C}
            </td>
            <td  >
                ${Model.NET_MOVING_TARGET_CGST_UPTO_C}
            </td>
            <td  >
                ${Model.NET_TAX_CGST_C}
            </td>
            <td  >
                ${Model.NET_TAX_CGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_CGST_TARGET_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_CGST_TARGET_UPTO_C}
            </td>
            <td  >
                ${Model.NET_TAX_CGST_P}
            </td>
            <td  >
                ${Model.NET_TAX_CGST_UPTO_P}
            </td>
            <td  >
                ${Model.NET_TAX_DIFF_CGST_C}
            </td>
            <td  >
                ${Model.NET_TAX_DIFF_CGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_DIFF_CGST_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_DIFF_CGST_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  >
                SGST
            </th>
            <td  >
                ${Model.TARGET_SGST_C}
            </td>
            <td  >
                ${Model.NET_MOVING_TARGET_SGST_C}
            </td>
            <td  >
                ${Model.NET_MOVING_TARGET_SGST_UPTO_C}
            </td>
            <td  >
                ${Model.NET_TAX_SGST_C}
            </td>
            <td  >
                ${Model.NET_TAX_SGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_SGST_TARGET_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_SGST_TARGET_UPTO_C}
            </td>
            <td  >
                ${Model.NET_TAX_SGST_P}
            </td>
            <td  >
                ${Model.NET_TAX_SGST_UPTO_P}
            </td>
            <td  >
                ${Model.NET_TAX_DIFF_SGST_C}
            </td>
            <td  >
                ${Model.NET_TAX_DIFF_SGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_DIFF_SGST_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_DIFF_SGST_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  >
                IGST
            </th>
            <td  >
                ${Model.TARGET_IGST_C}
            </td>
            <td  >
                ${Model.NET_MOVING_TARGET_IGST_C}
            </td>
            <td  >
                ${Model.NET_MOVING_TARGET_IGST_UPTO_C}
            </td>
            <td  >
                ${Model.NET_TAX_IGST_C}
            </td>
            <td  >
                ${Model.NET_TAX_IGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_IGST_TARGET_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_IGST_TARGET_UPTO_C}
            </td>
            <td  >
                ${Model.NET_TAX_IGST_P}
            </td>
            <td  >
                ${Model.NET_TAX_IGST_UPTO_P}
            </td>
            <td  >
                ${Model.NET_TAX_DIFF_IGST_C}
            </td>
            <td  >
                ${Model.NET_TAX_DIFF_IGST_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_DIFF_IGST_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_DIFF_IGST_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            <th  >
                CESS
            </th>
            <td  >
                ${Model.TARGET_CESS_C}
            </td>
            <td  >
                ${Model.NET_MOVING_TARGET_CESS_C}
            </td>
            <td  >
                ${Model.NET_MOVING_TARGET_CESS_UPTO_C}
            </td>
            <td  >
                ${Model.NET_TAX_CESS_C}
            </td>
            <td  >
                ${Model.NET_TAX_CESS_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_CESS_TARGET_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_CESS_TARGET_UPTO_C}
            </td>
            <td  >
                ${Model.NET_TAX_CESS_P}
            </td>
            <td  >
                ${Model.NET_TAX_CESS_UPTO_P}
            </td>
            <td  >
                ${Model.NET_TAX_DIFF_CESS_C}
            </td>
            <td  >
                ${Model.NET_TAX_DIFF_CESS_UPTO_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_DIFF_CESS_C}
            </td>
            <td  >
                ${Model.PERCENT_NET_TAX_DIFF_CESS_UPTO_C}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  >
                TOTAL
            </th>
            <td  >
                ${Model.TOTAL_TARGET_C }
            </td>
            <td  >
                ${Model.TOTAL_NET_MOVING_TARGET_C }
            </td>
            <td  >
                ${Model.TOTAL_NET_MOVING_TARGET_UPTO_C }
            </td>
            <td  >
                ${Model.TOTAL_NET_TAX_C}
            </td>
            <td  >
                ${Model.TOTAL_NET_TAX_UPTO_C}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_NET_TAX_TARGET_C}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_NET_TAX_TARGET_UPTO_C}
            </td>
            <td  >
                ${Model.TOTAL_NET_TAX_P}
            </td>
            <td  >
                ${Model.TOTAL_NET_TAX_UPTO_P}
            </td>
            <td  >
                ${Model.TOTAL_NET_TAX_DIFF_C}
            </td>
            <td  >
                ${Model.TOTAL_NET_TAX_DIFF_UPTO_C}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_NET_TAX_DIFF_C}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_NET_TAX_DIFF_UPTO_C}
            </td>
            
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
           <!--  <span style="color:red;">**All reports are provisional.</span></div> -->

</body>
</html>
