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

    <title>GI-GST-3 </title>
</head>
<body>
<%!String desDt = "";
	String strDate = "";%>
	<c:set var="TOTAL_COMM" value="${model.TOTAL_COMM}" />
	<c:set var="COMPLETE_COMM" value="${model.COMPLETE_COMM}" />
	<c:set var="AMND" value="${model.AMND}" />
    <div id="Report_main">
        <table>
        
        <%
						 	String strDate = (String) request.getAttribute("ViewBag_MM_YYYY");
					      	java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
					      	java.util.Date date = srcDtFormat.parse(strDate);
					      	java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
					        desDt = desDtFormat.format(date);
						
						%>

<c:if test="${model != null}">
            
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
									href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=GST-AE-3 "
									style="color: brown; font-weight: bold;"> <img
									src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
							</c:if></td>
						<td>&nbsp;</td>
						
						
						<td style="text-align: center;"><a
							download='GST-AE-3 (<%=desDt.toUpperCase()%>).xls' href="">Download</a>
							&nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
						<td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
					</tr>
                </table>
            </c:if>
       <table >     
            <tr>
                <td colspan="20" align="center">
                    <h1>GST-AE-3</h1>
                    <h2>STATUS OF REWARD SANCTIONED/ DISBURSED</h2>

                </td>

            </tr>
          
            <tr>
                <td align="left" colspan="2" style="padding-left:10px;">
                   <h2>${ViewBag_Report_Name}<br />
                   <!--  COMMISSIONERATE : <br/>
                   FINANCIAL YEAR: <br/> -->
                   MONTH : <%=desDt.toUpperCase()%>                   
                   </h2>
					
                </td>
                <td align="right" colspan="2" style="padding-left:10px;">
                    <h2>Amount: Rs. in Lakhs</h2>
               </td>
            </tr>
        </table>
        
            <c:if test="${model != null}">
        <c:if test="${Report_Type=='Crr'}">
            <div><h2>CORRECTED REPORT<span style="color:red;"> **Corrections are shown in red</span></h2></div>
        </c:if>
         <table id="report_1" class="Report_body">
            <tr class="header_bcg_clr">
                <th rowspan="3" width="3%">
                    S. NO.
                </th>
                <th rowspan="3"  align="center" style="width:20%">
                    Description
                </th>
                <th rowspan="3"  align="center" style="width:10%">Reward Recipient</th>
                
                <th rowspan="1" colspan="4" style="width:30%">
                    Reward fund allocated in the Current Financial Year 
                </th>

            </tr>
            <tr class="header_bcg_clr">
               
                <th rowspan="1" colspan="2" >
                    During the month
                </th>
                <th rowspan="1" colspan="2" >
                    Upto the month
                </th>
                
            </tr>
            <tr class="header_bcg_clr">
            	<th rowspan="1" colspan="1" style="width:70px;" >
                    No. of Cases
                </th>
                <th rowspan="1" colspan="1" >
                    Amount
                </th>
                
                <th rowspan="1" colspan="1" style="width:70px;" >
                    No. of Cases
                </th>
                <th rowspan="1" colspan="1" >
                    Amount
                </th>
            </tr>

            <tr>
                <th  width="5%">
                    1
                </th>
                <th  >
                    2
                </th>
                <th  >
                    3
                </th>
                <th  >
                    4
                </th>
                <th  >
                    5
                </th>
                <th  >
                    6
                </th>
                <th  >
                    7
                </th>
                
            </tr>
               
       <tr class="table-datarow-right">
            <th class="table-datarow-center" rowspan="2">
                1
            </th>

            <th rowspan="2">
               Cases ripe for sanction of reward
            </th>

            <th >
               Departmental Officer
            </th>
            <td >
               ${model.REWARD_DEPARTMENTAL_NO_FOR}
            </td>
            <td >
               ${model.REWARD_DEPARTMENTAL_AMT_FOR}
            </td>
             <td >
               ${model.REWARD_DEPARTMENTAL_NO_UPTO}
            </td>
            <td >
               ${model.REWARD_DEPARTMENTAL_AMT_UPTO}
            </td>
           
           
        </tr>

        <tr class="table-datarow-right">
           
            <th>
                Informer
            </th>
             <td >
               ${model.REWARD_INFORMER_NO_FOR}
            </td>
            <td >
               ${model.REWARD_INFORMER_AMT_FOR}
            </td>
             <td >
               ${model.REWARD_INFORMER_NO_UPTO}
            </td>
            <td >
               ${model.REWARD_INFORMER_AMT_UPTO}
            </td>
        </tr>
               
        <tr class="table-datarow-right">
            <th class="table-datarow-center" rowspan="2">
                2
            </th>

            <th rowspan="2">
               Reward sanctioned and disbursed
            </th>

            <th >
               Departmental Officer
            </th>
             <td >
               ${model.DISBURSED_DEPARTMENTAL_NO_FOR}
            </td>
            <td >
               ${model.DISBURSED_DEPARTMENTAL_AMT_FOR}
            </td>
             <td >
               ${model.DISBURSED_DEPARTMENTAL_NO_UPTO}
            </td>
            <td >
               ${model.DISBURSED_DEPARTMENTAL_AMT_UPTO}
            </td>           
           
        </tr>

        <tr class="table-datarow-right">
           
            <th>
                Informer
            </th>
           <td >
               ${model.DISBURSED_INFORMER_NO_FOR}
            </td>
            <td >
               ${model.DISBURSED_INFORMER_AMT_FOR}
            </td>
             <td >
               ${model.DISBURSED_INFORMER_NO_UPTO}
            </td>
            <td >
               ${model.DISBURSED_INFORMER_AMT_UPTO}
            </td>
        </tr>                  

		<tr class="table-datarow-right">
            <th class="table-datarow-center" rowspan="2">
                3
            </th>

            <th rowspan="2">
               Reward sanctioned but pending for disbursal
            </th>

            <th >
               Departmental Officer
            </th>
            <td >
               ${model.PENDING_DEPARTMENTAL_NO_FOR}
            </td>
            <td >
               ${model.PENDING_DEPARTMENTAL_AMT_FOR}
            </td>
             <td >
               ${model.PENDING_DEPARTMENTAL_NO_UPTO}
            </td>
            <td >
               ${model.PENDING_DEPARTMENTAL_AMT_UPTO}
            </td>              
           
        </tr>

        <tr class="table-datarow-right">
           
            <th>
                Informer
            </th>
            <td >
               ${model.PENDING_INFORMER_NO_FOR}
            </td>
            <td >
               ${model.PENDING_INFORMER_AMT_FOR}
            </td>
             <td >
               ${model.PENDING_INFORMER_NO_UPTO}
            </td>
            <td >
               ${model.PENDING_INFORMER_AMT_UPTO}
            </td>       
        </tr>                  


   </table>    
     
  <c:if test="${ViewBag_Report != null}">
             <center> <h2>EXISTING REPORT</h2></center>
   <table id="report_2" class="Report_body" >
        <tr class="grid_head">
                <th rowspan="2" width="5%" align="center">
                    S.NO
                </th>
                <th rowspan="2"  align="center">
                    ITEMS OF ARM (ADDITIONAL REVENUE MOBILISATION)
                </th>
                <th rowspan="1" colspan="2"  align="center">
                    RECOVERY DETAILS (CURRENT F.Y.)
                </th>
                <th rowspan="1" colspan="2"  align="center">
                    RECOVERY DETAILS (PREVIOUS F.Y.)
                </th>
                <th rowspan="1" colspan="2"  align="center">
                    DIFFERENCE
                </th>
               
            </tr>
            <tr>
                <th rowspan="1" colspan="1" align="center" >
                    FOR THE MONTH
                </th>
                <th rowspan="1" colspan="1" align="center" >
                    UPTO THE MONTH
                </th>
                <th rowspan="1" colspan="1" align="center" >
                    FOR THE MONTH
                </th>
                <th rowspan="1" colspan="1" align="center" >
                    UPTO THE MONTH
                </th>
                <th rowspan="1" colspan="1" align="center" >
                    FOR THE MONTH
                </th>
                <th rowspan="1" colspan="1" align="center" >
                    UPTO THE MONTH
                </th>
                
            </tr>

            <tr>
                <th align="center" width="5%">
                    1
                </th>
                <th align="center" >
                    2
                </th>
                <th align="center" >
                    3
                </th>
                <th align="center" >
                    4
                </th>
                <th align="center" >
                    5
                </th>
                <th align="center" >
                    6
                </th>
                <th align="center" >
                    7
                </th>
                <th align="center" >
                    8
                </th>
                
            </tr>
       
        <tr>
            <th align="center" width="5%">
                1
            </th>

            <th align="center" >
               AUDIT RECOVERY
            </th>


            <td align="right" >
               ${ViewBag_Report.AUDIT_RECOVERY_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.AUDIT_RECOVERY_UPTO_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.AUDIT_RECOVERY_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.AUDIT_RECOVERY_UPTO_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.AUDIT_RECOVERY_DIFF_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.AUDIT_RECOVERY_DIFF_UPTO}
            </td>
           

        </tr>
        <tr>
            <th align="center" >
                2
            </th>

            <th align="center" >
                ANTI-EVASION RECOVERY INCLUDING TRANSIT CHECKS
            </th>
            <td align="right" >
               ${ViewBag_Report.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_UPTO_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_UPTO_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_DIFF_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_DIFF_UPTO}
            </td>
           
        </tr>
        <tr>
            <th align="center" >
                3
            </th>

            <th align="center" >
                RECOVERY OF CONFIRMED DEMANDS
            </th>

              <td align="right" >
               ${ViewBag_Report.RECOVERY_OF_CONFIRMED_DEMANDS_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.RECOVERY_OF_CONFIRMED_DEMANDS_UPTO_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.RECOVERY_OF_CONFIRMED_DEMANDS_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.RECOVERY_OF_CONFIRMED_DEMANDS_UPTO_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.RECOVERY_OF_CONFIRMED_DEMANDS_DIFF_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.RECOVERY_OF_CONFIRMED_DEMANDS_DIFF_UPTO}
            </td>
        </tr>
        
            <tr>
            <th align="center" >
                4
            </th>

            <th align="center" >
                PRE-DEPOSITS
            </th>

            <td align="right" >
               ${ViewBag_Report.PRE_DEPOSITS_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.PRE_DEPOSITS_UPTO_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.PRE_DEPOSITS_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.PRE_DEPOSITS_UPTO_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.PRE_DEPOSITS_DIFF_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.PRE_DEPOSITS_DIFF_UPTO}
            </td>
        </tr>
        
            <tr>
            <th align="center" >
                5
            </th>

            <th align="center" >
                SCRUTINY OF GST RETURNS
            </th>

              <td align="right" >
               ${ViewBag_Report.SCRUTINY_OF_GST_RETURNS_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.SCRUTINY_OF_GST_RETURNS_UPTO_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.SCRUTINY_OF_GST_RETURNS_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.SCRUTINY_OF_GST_RETURNS_UPTO_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.SCRUTINY_OF_GST_RETURNS_DIFF_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.SCRUTINY_OF_GST_RETURNS_DIFF_UPTO}
            </td>
        </tr>
        
            <tr>
            <th align="center" >
                6
            </th>

            <th align="center" >
                RECOVERY FROM DEFAULTERS
            </th>

             <td align="right" >
               ${ViewBag_Report.RECOVERY_FROM_DEFAULTERS_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.RECOVERY_FROM_DEFAULTERS_UPTO_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.RECOVERY_FROM_DEFAULTERS_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.RECOVERY_FROM_DEFAULTERS_UPTO_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.RECOVERY_FROM_DEFAULTERS_DIFF_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.RECOVERY_FROM_DEFAULTERS_DIFF_UPTO}
            </td>
        </tr>
        
            <tr>
            <th align="center" >
                7
            </th>

            <th align="center" >
                FINALISATION OF PROVISIONAL ASSESSMENTS
            </th>

            <td align="right" >
               ${ViewBag_Report.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_UPTO_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_UPTO_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_DIFF_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_DIFF_UPTO}
            </td>
        </tr>
        
            <tr>
            <th align="center" >
                8
            </th>

            <th align="center" >
                OTHERS (SPECIFY)
            </th>

            <td align="right" >
               ${ViewBag_Report.OTHERS_C} 
            </td>
            <td align="right" >
               ${ViewBag_Report.OTHERS_UPTO_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.OTHERS_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.OTHERS_UPTO_P}
            </td>
            <td align="right" >
               ${ViewBag_Report.OTHERS_DIFF_C}
            </td>
            <td align="right" >
               ${ViewBag_Report.OTHERS_DIFF_UPTO}
            </td>
        </tr>
        
            <tr>
            <th align="center" >
                9
            </th>

            <th align="center" >
                TOTAL RECOVERIES
            </th>

            <td align="right" >
               ${ViewBag_Report.AUDIT_RECOVERY_C+model.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_C+model.RECOVERY_OF_CONFIRMED_DEMANDS_C+model.PRE_DEPOSITS_C+model.SCRUTINY_OF_GST_RETURNS_C+model.RECOVERY_FROM_DEFAULTERS_C+model.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_C+model.OTHERS_C}
            </td>
            <td align="right" >
                ${ViewBag_Report.AUDIT_RECOVERY_UPTO_C+model.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_UPTO_C+model.RECOVERY_OF_CONFIRMED_DEMANDS_UPTO_C+model.PRE_DEPOSITS_UPTO_C+model.SCRUTINY_OF_GST_RETURNS_UPTO_C+model.RECOVERY_FROM_DEFAULTERS_UPTO_C+model.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_UPTO_C+model.OTHERS_UPTO_C}
            </td>
            <td align="right" >
                ${ViewBag_Report.AUDIT_RECOVERY_P+model.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_P+model.RECOVERY_OF_CONFIRMED_DEMANDS_P+model.PRE_DEPOSITS_P+model.SCRUTINY_OF_GST_RETURNS_P+model.RECOVERY_FROM_DEFAULTERS_P+model.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_P+model.OTHERS_P}
            </td>
            <td align="right" >
                ${ViewBag_Report.AUDIT_RECOVERY_UPTO_P+model.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_UPTO_P+model.RECOVERY_OF_CONFIRMED_DEMANDS_UPTO_P+model.PRE_DEPOSITS_UPTO_P+model.SCRUTINY_OF_GST_RETURNS_UPTO_P+model.RECOVERY_FROM_DEFAULTERS_UPTO_P+model.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_UPTO_P+model.OTHERS_UPTO_P}
            </td>
            <td align="right" >
                ${ViewBag_Report.AUDIT_RECOVERY_DIFF_C+model.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_DIFF_C+model.RECOVERY_OF_CONFIRMED_DEMANDS_DIFF_C+model.PRE_DEPOSITS_DIFF_C+model.SCRUTINY_OF_GST_RETURNS_DIFF_C+model.RECOVERY_FROM_DEFAULTERS_DIFF_C+model.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_DIFF_C+model.OTHERS_DIFF_C}
            </td>
            <td align="right" >
                ${ViewBag_Report.AUDIT_RECOVERY_DIFF_UPTO+model.ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS_DIFF_UPTO+model.RECOVERY_OF_CONFIRMED_DEMANDS_DIFF_UPTO+model.PRE_DEPOSITS_DIFF_UPTO+model.SCRUTINY_OF_GST_RETURNS_DIFF_UPTO+model.RECOVERY_FROM_DEFAULTERS_DIFF_UPTO+model.FINALISATION_OF_PROVISIONAL_ASSESSMENTS_DIFF_UPTO+model.OTHERS_DIFF_UPTO}
            </td>
        </tr>

   </table>   
   </c:if>   
        </c:if>
        
        
        <c:if test="${empty model}">
        <table class="Report_body">
            <tr>
                <th colspan="18" align="center">
                    <h1 style="color:red;">No Record Found !</h1>
                </th>
            </tr>
        </table>
        </c:if>
    </div>
    
</body>
</html>


