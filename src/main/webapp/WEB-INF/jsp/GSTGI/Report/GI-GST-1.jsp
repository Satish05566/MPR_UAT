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

        <title>GI-GST-1</title>
    </head>
    <body>
	<%!  String desDt = "";String strDate="";%>
        <%
						    strDate = (String) request.getAttribute("ViewBag_MM_YYYY");
					      	java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
					      	java.util.Date date = srcDtFormat.parse(strDate);
					      	java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
					        desDt = desDtFormat.format(date);
						%>
    <div id="Report_main">
    <c:if test="${!(empty Model)}" >
      <table>
         
		<tr>
		<td style="text-align: center; ">
                                <a download='GI-GST-1(<%= desDt.toUpperCase() %>).xls' href="">Download</a>
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
                        <h1>GI-GST-1</h1>
                        <h2>
                            Detection & Realisation
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
            <th rowspan="3" colspan="1"  width="10%">
                SI.NO
            </th>
            <th rowspan="3" colspan="1"  width="10%">
                ITEMS OF WORK
            </th>
            <th rowspan="3" colspan="2"  width="10%">
                TAX
            </th>
            <th colspan="4"  width="10%">
                CURRENT FINANCIAL YEAR
            </th>
            <th colspan="4"  width="14%">
                PREVIOUS FINANCIAL YEAR	
            </th>
            <th  colspan="4"  width="14%">
               PERCENTAGE INCREASE/DECREASE OVER PREVIOUS FINANCIAL YEAR 
            </th>
            
        </tr>
        
        <tr class="header_bcg_clr">
            
            <th rowspan="1" colspan="2" align="center">
                    FOR THE MONTH
            </th>
            <th rowspan="1" colspan="2" align="center">
                    UPTO THE MONTH
            </th>
                
                
            <th rowspan="1" colspan="2" align="center">
                FOR THE MONTH
            </th>
            <th rowspan="1" colspan="2" align="center">
                UPTO THE MONTH
            </th>
            <th rowspan="1" colspan="2" align="center">
                FOR THE MONTH
            </th>
            <th rowspan="1" colspan="2" align="center">
                UPTO THE MONTH
            </th>
          </tr>
          <tr class="header_bcg_clr">
            
            <th rowspan="1" colspan="1" align="center">
                    NO. OF CASES
            </th>
            <th rowspan="1" colspan="1" align="center">
                    AMOUNT
            </th>
            <th rowspan="1" colspan="1" align="center">
                 NO. OF CASES
            </th>
            <th rowspan="1" colspan="1" align="center">
                AMOUNT
            </th>
            <th rowspan="1" colspan="1" align="center">
                 NO. OF CASES
            </th>
            <th rowspan="1" colspan="1" align="center">
                AMOUNT
            </th>
            <th rowspan="1" colspan="1" align="center">
                    NO. OF CASES
            </th>
            <th rowspan="1" colspan="1" align="center">
                    AMOUNT
            </th>
            <th rowspan="1" colspan="1" align="center">
                 NO. OF CASES
            </th>
            <th rowspan="1" colspan="1" align="center">
                AMOUNT
            </th>
            <th rowspan="1" colspan="1" align="center">
                 NO. OF CASES
            </th>
            <th rowspan="1" colspan="1" align="center">
                AMOUNT
            </th>
          </tr>
        <tr class="header_bcg_clr">
            <th>1</th>
            <th >1</th>
            <th colspan="2">2</th>
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
            
        </tr>
        <tr class="table-datarow-right">
            
            <th rowspan="5" class="table-datarow-center">
                1
            </th>
            <th    rowspan="5">
                DETECTION
            </th>
            <th colspan="2">
                CGST
            </th>
            
            <td rowspan="5" >
                ${Model.DETECTION_CGST_NO}
            </td>
            <td  >
                ${Model.DETECTION_CGST_AMT}
            </td>
            <td  rowspan="5" >
                ${Model.DETECTION_CGST_NO_UPTO}
            </td>
            <td  >
                ${Model.DETECTION_CGST_AMT_UPTO}
            </td>
            <td  rowspan="5" >
               ${Model.DETECTION_CGST_NO_PRE}
            </td>
            <td  >
                ${Model.DETECTION_CGST_AMT_PRE}
            </td>
            <td  rowspan="5" >
               ${Model.DETECTION_CGST_NO_PRE_UPTO}
            </td>
            <td  >
                ${Model.DETECTION_CGST_AMT_PRE_UPTO}
            </td>
            <td  rowspan="5" >
                ${Model.PERCENT_DETECTION_CGST_NO}
            </td>
            <td  >
                ${Model.PERCENT_DETECTION_CGST_AMT}
            </td>
            <td  rowspan="5" >
                ${Model.PERCENT_DETECTION_CGST_NO_UPTO}
            </td>
            <td  >
                ${Model.PERCENT_DETECTION_CGST_AMT_UPTO}
            </td>
                        
            </tr>
        <tr class="table-datarow-right">
            
            <th colspan="2" >
                SGST/UTGST
            </th>
            
            <td  >
                ${Model.DETECTION_SGST_AMT}
            </td>
            <td  >
                ${Model.DETECTION_SGST_AMT_UPTO}
            </td>
            <td  >
                ${Model.DETECTION_SGST_AMT_PRE}
            </td>
            <td  >
                ${Model.DETECTION_SGST_AMT_PRE_UPTO}
            </td>
            <td  >
                ${Model.PERCENT_DETECTION_SGST_AMT}
            </td>
            <td  >
                ${Model.PERCENT_DETECTION_SGST_AMT_UPTO}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  colspan="2">
                IGST
            </th>
            
            <td  >
                ${Model.DETECTION_IGST_AMT}
            </td>
            <td  >
                ${Model.DETECTION_IGST_AMT_UPTO}
            </td>
            <td  >
                ${Model.DETECTION_IGST_AMT_PRE}
            </td>
            <td  >
                ${Model.DETECTION_IGST_AMT_PRE_UPTO}
            </td>
            <td  >
                ${Model.PERCENT_DETECTION_IGST_AMT}
            </td>
            <td  >
                ${Model.PERCENT_DETECTION_IGST_AMT_UPTO}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            <th colspan="2" >
                CESS
            </th>
            
            <td  >
                ${Model.DETECTION_CESS_AMT}
            </td>
            <td  >
                ${Model.DETECTION_CESS_AMT_UPTO}
            </td>
            <td  >
                ${Model.DETECTION_CESS_AMT_PRE}
            </td>
            <td  >
                ${Model.DETECTION_CESS_AMT_PRE_UPTO}
            </td>
            <td  >
                ${Model.PERCENT_DETECTION_CESS_AMT}
            </td>
            <td  >
                ${Model.PERCENT_DETECTION_CESS_AMT_UPTO}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  colspan="2">
                TOTAL
            </th>
            
            <td  >
                ${Model.TOTAL_DETECTION_AMT}
            </td>
            <td  >
                ${Model.TOTAL_DETECTION_AMT_UPTO}
            </td>
            <td  >
                ${Model.TOTAL_DETECTION_AMT_PRE}
            </td>
            <td  >
                ${Model.TOTAL_DETECTION_AMT_PRE_UPTO}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_DETECTION_AMT}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_DETECTION_AMT_UPTO}
            </td>
            
            </tr>
            
            
        <tr class="table-datarow-right">
            <th    rowspan="5" class="table-datarow-center">
                2
            </th>
            <th    rowspan="5">
                REALISATION
            </th>
            <th colspan="2" >
                CGST
            </th>
            
            <td rowspan="5" >
                ${Model.REALISATION_CGST_NO}
            </td>
            <td  >
                ${Model.REALISATION_CGST_AMT}
            </td>
            <td  rowspan="5" >
                ${Model.REALISATION_CGST_NO_UPTO}
            </td>
            <td  >
                ${Model.REALISATION_CGST_AMT_UPTO}
            </td>
            <td  rowspan="5" >
               ${Model.REALISATION_CGST_NO_PRE}
            </td>
            <td  >
                ${Model.REALISATION_CGST_AMT_PRE}
            </td>
            <td  rowspan="5" >
               ${Model.REALISATION_CGST_NO_PRE_UPTO}
            </td>
            <td  >
                ${Model.REALISATION_CGST_AMT_PRE_UPTO}
            </td>
            <td  rowspan="5" >
                ${Model.PERCENT_REALISATION_CGST_NO}
            </td>
            <td  >
                ${Model.PERCENT_REALISATION_CGST_AMT}
            </td>
            <td  rowspan="5" >
                ${Model.PERCENT_REALISATION_CGST_NO_UPTO}
            </td>
            <td  >
                ${Model.PERCENT_REALISATION_CGST_AMT_UPTO}
            </td>
                        
            </tr>
        <tr class="table-datarow-right">
            
            <th colspan="2" >
                SGST/UTGST
            </th>
            
            <td  >
                ${Model.REALISATION_SGST_AMT}
            </td>
            <td  >
                ${Model.REALISATION_SGST_AMT_UPTO}
            </td>
            <td  >
                ${Model.REALISATION_SGST_AMT_PRE}
            </td>
            <td  >
                ${Model.REALISATION_SGST_AMT_PRE_UPTO}
            </td>
            <td  >
                ${Model.PERCENT_REALISATION_SGST_AMT}
            </td>
            <td  >
                ${Model.PERCENT_REALISATION_SGST_AMT_UPTO}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  colspan="2">
                IGST
            </th>
            
            <td  >
                ${Model.REALISATION_IGST_AMT}
            </td>
            <td  >
                ${Model.REALISATION_IGST_AMT_UPTO}
            </td>
            <td  >
                ${Model.REALISATION_IGST_AMT_PRE}
            </td>
            <td  >
                ${Model.REALISATION_IGST_AMT_PRE_UPTO}
            </td>
            <td  >
                ${Model.PERCENT_REALISATION_IGST_AMT}
            </td>
            <td  >
                ${Model.PERCENT_REALISATION_IGST_AMT_UPTO}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            <th colspan="2" >
                CESS
            </th>
            
            <td  >
                ${Model.REALISATION_CESS_AMT}
            </td>
            <td  >
                ${Model.REALISATION_CESS_AMT_UPTO}
            </td>
            <td  >
                ${Model.REALISATION_CESS_AMT_PRE}
            </td>
            <td  >
                ${Model.REALISATION_CESS_AMT_PRE_UPTO}
            </td>
            <td  >
                ${Model.PERCENT_REALISATION_CESS_AMT}
            </td>
            <td  >
                ${Model.PERCENT_REALISATION_CESS_AMT_UPTO}
            </td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th  colspan="2">
                TOTAL
            </th>
            
            <td  >
                ${Model.TOTAL_REALISATION_AMT}
            </td>
            <td  >
                ${Model.TOTAL_REALISATION_AMT_UPTO}
            </td>
            <td  >
                ${Model.TOTAL_REALISATION_AMT_PRE}
            </td>
            <td  >
                ${Model.TOTAL_REALISATION_AMT_PRE_UPTO}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_REALISATION_AMT}
            </td>
            <td  >
                ${Model.TOTAL_PERCENT_REALISATION_AMT_UPTO}
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

<br>
<br>
<br>
<table>   
                <tr>
                    <td colspan="4" align="center">
                        <h1>GI-GST-1A</h1>
                        <h2>
                            Arrest, Prosecution & Compounding of Offences
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
        
  <c:if test="${!(empty ModelA)}">
           <c:if test="${ReportType=='Crr'}">
            
                <div><h2>CORRECTED REPORT<span style="color:red;">**Corrections are shown in red</span></h2></div>
            </c:if>
       
        

    <table id="report_1" class="Report_body">
        <tr class="header_bcg_clr">
            <th rowspan="2" colspan="1"  width="5%">
                SI.NO.
            </th>
            <th rowspan="2" colspan="1"  width="10%">
                ITEMS OF WORK
            </th>
            
            <th colspan="4"  width="14%">
                CURRENT FINANCIAL YEAR
            </th>
            <th colspan="4"  width="14%">
                PREVIOUS FINANCIAL YEAR	
            </th>
            <th  colspan="4"  width="14%">
               PERCENTAGE INCREASE/DECREASE OVER PREVIOUS FINANCIAL YEAR 
            </th>
            
        </tr>
        
        <tr class="header_bcg_clr">
            
            <th rowspan="1" colspan="2" align="center">
                    FOR THE MONTH
            </th>
            <th rowspan="1" colspan="2" align="center">
                    UPTO THE MONTH
            </th>
                
                
            <th rowspan="1" colspan="2" align="center">
                FOR THE MONTH
            </th>
            <th rowspan="1" colspan="2" align="center">
                UPTO THE MONTH
            </th>
            <th rowspan="1" colspan="2" align="center">
                FOR THE MONTH
            </th>
            <th rowspan="1" colspan="2" align="center">
                UPTO THE MONTH
            </th>
          </tr>
 

        <tr class="table-datarow-right">
            
            <th class="table-datarow-center">
                1
            </th>
            <th >
                Arrests Made
            </th>
            
            <td  rowspan="1" colspan="2" >${ModelA.ARRESTS_MADE}</td>
            <td  rowspan="1" colspan="2" >${ModelA.ARRESTS_MADE_UPTO}</td>
            <td  rowspan="1" colspan="2" >${ModelA.ARRESTS_MADE_PRE}</td>
            <td  rowspan="1" colspan="2" >${ModelA.ARRESTS_MADE_PRE_UPTO}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PERCENT_ARRESTS_MADE}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PERCENT_ARRESTS_MADE_UPTO}</td>
                        
            </tr>
        <tr class="table-datarow-right">
            
            <th class="table-datarow-center">
                2
            </th>
            <th >
                PROSECUTION SANCTIONED
            </th>
            
            <td  rowspan="1" colspan="2" >${ModelA.PROSECUTION_SANCTIONED}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PROSECUTION_SANCTIONED_UPTO}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PROSECUTION_SANCTIONED_PRE}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PROSECUTION_SANCTIONED_PRE_UPTO}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PERCENT_PROSECUTION_SANCTIONED}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PERCENT_PROSECUTION_SANCTIONED_UPTO}</td>
            
            </tr>
        <tr class="table-datarow-right">
            
            <th class="table-datarow-center">
                3
            </th>
            <th >
               Compounding of Offences
            </th>
            
            <td  rowspan="1" colspan="2" >${ModelA.COMPOUNDING_OF_OFFENCES}</td>
            <td  rowspan="1" colspan="2" >${ModelA.COMPOUNDING_OF_OFFENCES_UPTO}</td>
            <td  rowspan="1" colspan="2" >${ModelA.COMPOUNDING_OF_OFFENCES_PRE}</td>
            <td  rowspan="1" colspan="2" >${ModelA.COMPOUNDING_OF_OFFENCES_PRE_UPTO}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PERCENT_COMPOUNDING_OF_OFFENCES}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PERCENT_COMPOUNDING_OF_OFFENCES_UPTO}</td>
            
            </tr>
        <tr class="table-datarow-right">
            <th class="table-datarow-center">
                4
            </th>
            <th >
                PROSECUTION LAUNCHED
            </th>
            <td  rowspan="1" colspan="2" >${ModelA.PROSECUTION_LAUNCHED}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PROSECUTION_LAUNCHED_UPTO}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PROSECUTION_LAUNCHED_PRE}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PROSECUTION_LAUNCHED_PRE_UPTO}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PERCENT_PROSECUTION_LAUNCHED}</td>
            <td  rowspan="1" colspan="2" >${ModelA.PERCENT_PROSECUTION_LAUNCHED_UPTO}</td>
            
            </tr>         
        
            
  
    </table>
  
         
</c:if>

<c:if test="${ModelA==null || ModelA==''}">  
            <table class="Report_body">
    <tr>
        <th colspan="4" align="center">
            <h1 style="color:red;">No Record Found !</h1>
        </th>
    </tr>
</table>
</c:if>
<br>
<br>
<br>
</div>
           <!--  <span style="color:red;">**All reports are provisional.</span></div> -->

</body>
</html>
