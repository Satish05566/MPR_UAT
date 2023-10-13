﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.io.*,java.util.*,java.math.BigDecimal" %>
<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />

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



  <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>/Content-MPR/jsMPR/jquery-1.8.2.min.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>/Content-MPR/jsMPR/Sort.js"></script>

    <script type="text/javascript">
        $(function () {

            $('input[name=rdOrder]').click(function () {

                var pathArray = window.location.pathname.split('/');
                var order = $('input[name=rdOrder]:checked').val();
                var url = "/MIS/DPM/MSR/" + pathArray[4] + "/All/0/" + order + "/" + pathArray[8];
                window.open(url, "_self");
            });
        });
        window.onload = function () {
            var pathArray = window.location.pathname.split('/');
            if (pathArray[7] == 'ASC') {
                $("input[name=rdOrder][value=" + pathArray[7] + "]").attr('checked', 'checked');
            }

            else {
                if (pathArray[7] == 'DSC') {
                    $("input[name=rdOrder][value=" + pathArray[7] + "]").attr('checked', 'checked');
                }
            }



        }
    </script>





    <title>MSR-DPM-CUS-2A</title>
</head>
<body>

    <div id="Report_main">
        <table style="width: 70%;" align="center">
            <%!  String desDt = ""; String desDt1 = ""; int month=0; int year=0; int rowNO=0; %>
        <c:set var = "TOTAL_COMM"  value = "${Model[0].TOTAL_COMM}"/>
        <c:set var = "COMPLETE_COMM"  value = "${Model[0].COMPLETE_COMM}"/>
        <c:set var = "AMND"  value = "${Model[0].AMND}"/>
         <%
						 	String strDate = (String) request.getAttribute("ViewBag_MM_YYYY");
					      	java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
					      	java.util.Date date = srcDtFormat.parse(strDate);
					      	java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
					      	java.text.DateFormat desMonth = new java.text.SimpleDateFormat("MM");
					      	java.text.DateFormat desYear = new java.text.SimpleDateFormat("yyyy");
					        desDt = desDtFormat.format(date);
					        java.text.DateFormat desDtFormat1 = new java.text.SimpleDateFormat("yyyy-MMM");
					        desDt1 = desDtFormat1.format(date);
						    month = Integer.parseInt(desMonth.format(date));
						    year = Integer.parseInt(desYear.format(date));
						    System.out.println("year----"+year);
						%>
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
                            <a href="../../../../../Home/CorrectionBackup?MM_YYYY=${ViewBag_MM_YYYY}.MM_YYYY&MPR=DRI-CUS-1" style="color:brown; font-weight:bold;"><img src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
                        </c:if>
                    </td>
                   
						
						  <td style="text-align: center; ">
                        <a download='MSR-DPM-CUS-2A(<%= desDt.toUpperCase() %>).xls' href="#">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a>
                    </td>
                    <td style="text-align: right; "><%= new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date()) %></td>
                </tr>
            </c:if>
            <tr>

                <td colspan="3" align="center" style="font-size:18px;">

                    <h1> MSR-DPM-CUS-2A</h1>
                     <% String display = ""; %>
                            <c:if test="${ViewBag_Report_Name=='ASC'}">
                            
                            <c:set var = "display"  value = "ASCENDING"/>
                            	
                             </c:if>
                             <c:if test="${ViewBag_Report_Name=='DSC'}">
                             
                             <c:set var = "display"  value = "DESCENDING"/>
                            	
                             </c:if>
                    
                    <h2> DETAILS OF ADJUDICATION CASES INVOLVING CUSTOMS DUTY OF MORE THAN Rs 1 CRORE AND MORE THAN 1 YEAR</h2>
                </td>

            </tr>
            <tr>
                <td align="left">
                    <br /> <h2>MONTH : <%= desDt.toUpperCase() %></h2>
                </td>

                <td></td>
                <td></td>
            </tr>

            <tr>

                <td align="center" colspan="3">
                    <div>
                        <!-- <b>@Html.RadioButton("rdOrder", "DSC", isChecked: true)@Html.Label("DESCENDING")</b>
                        <b> @Html.RadioButton("rdOrder", "ASC", isChecked: false)@Html.Label("ASCENDING")</b> -->

                    </div>


                </td>

            </tr>

        </table>


       <c:if test="${!(empty Model)}">
            <table class="Report_body" style="width: 70%;" align="center">

                <tr>
                    <th align="center">
                        SR.NO.
                    </th>
                    <th align="center">
                        ZONE
                    </th>

                    <th align="center">
                        NO OF CASES
                    </th>
                    <th align="center">
                        0-1 YEAR
                    </th>

                    <th align="center">
                        >1 YEAR
                    </th>
                    <th align="center">
                        % OF CASES(NO. OF CASES/TOTAL NO. OF CASES.)

                    </th>
                </tr>

                <c:forEach var ="r" items="${Model}" >
 <c:set var = "total"  value = "${TOTAL}"/>
 <c:set var = "less_1"  value = "${less_1 + r.YEAR_1}"/>
 <c:set var = "more_1"  value = "${more_1 + r.MORE_THAN_1}"/>
         

                    <tr class="grid_head">
                        <th align="center" width="4%" height="22px">
                            ${rowNO + 1}
                        </th>
                        <th align="left" width="4%" height="22px">
                            <a id="Zone_Link" href= "<%= session.getAttribute("DYNAMIC_LINK_PATH") %>GSTDPM/MSR/MSR_DPM_CUS_2A_COMM/ALL/${r.ZONE_CODE}/DESC/<%= desDt1.toUpperCase() %>/<%= session.getAttribute("CSRF_Token") %>" >${r.ZONE_NAME}</a>
                        </th>
                        <td align="right" width="4%" height="22px">
                            ${r.CLOSING_NO}
                        </td>
                        <td align="right" width="4%" height="22px">
                            ${r.YEAR_1}
                        </td>
                        <td align="right" width="4%" height="22px">
                            ${r.MORE_THAN_1}
                        </td>
                        <td align="right" width="4%" height="22px">
                            ${r.CASES_PERCENT}
                        </td>

                    </tr>
               </c:forEach>

                <tr>
                    <th align="center" width="4%" height="22px">

                    </th>
                    <th align="left" width="4%" height="22px">
                        TOTAL
                    </th>
                    <td align="right" width="4%" height="22px">
                        ${total}
                    </td>

                    <td align="right" width="4%" height="22px">
                        ${less_1}
                    </td>

                    <td align="right" width="4%" height="22px">
                        ${more_1}
                    </td>
                    <td align="right" width="4%" height="22px">
                        100.00%
                    </td>

                </tr>
            </table>
        </c:if>
       
        <c:if test="${empty Model}">
            <table class="Report_body">
                <tr>
                    <th colspan="12" align="center">
                        <h1 style="color:red;">No Record Found !</h1>
                    </th>
                </tr>
            </table>
        </c:if>

    </div>

</body>
</html>