<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.io.*,java.util.*,java.math.BigDecimal" %>
<html>
<head>
    <meta name="viewport" content="width=device-width" />

    <style type="text/css">
        body {
            vertical-align: top;
            font-family: "Segoe UI", Verdana, Helvetica, Sans-Serif;
        }

        .red {
            border: 0px;
            width: 20px;
            vertical-align: baseline;
        }

        #Report_main {
            width: 100%;
            align-self: center;
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

    <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>/Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
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

    <title>MSR-DPM-ST-1AE</title>
</head>
<body>

    <div id="Report_main">
        <table>
                 
     <%!  String desDt = ""; String desDt1 = ""; int month=0; int year=0; int rowNO=0; %>
        <c:set var = "TOTAL_COMM"  value = "${Model[0].TOTAL_COMM}"/>
        <c:set var = "COMPLETE_COMM"  value = "${Model[0].COMPLETE_COMM}"/>
        <c:set var = "AMND"  value = "${Model[0].AMND}"/>
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
                            <a href="../../../../../Home/CorrectionBackup?MM_YYYY=${ViewBag_MM_YYYY}.MM_YYYY&MPR=MSR-DPM-ST-1AD" style="color:brown; font-weight:bold;"><img src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
                        </c:if>
                    </td>
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
						
						  <td style="text-align: center; ">
                        <a download='MSR-DPM-ST-1AE(<%= desDt.toUpperCase() %>).xls' href="#">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a>
                    </td>
                    <td style="text-align: right; "><%= new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date()) %></td>
                </tr>
            </c:if>

            <tr>

                <td colspan="3" align="center">

                    <h1>MSR-DPM-ST-1AE</h1>
                    <% String display = ""; %>
                            <c:if test="${ViewBag_Report_Name=='ASC'}">
                            
                            <c:set var = "display"  value = "ASCENDING"/>
                            	
                             </c:if>
                             <c:if test="${ViewBag_Report_Name=='DSC'}">
                             
                             <c:set var = "display"  value = "DESCENDING"/>
                            	
                             </c:if>
                           
                            <h2> ADJUDICATION  CASES IN ${display}  ORDER  ON THE BASIS OF CLOSING BALANCE</h2>
                        
                    <h2> ADJUDICATING AUTHORITY:SUPERINTENDENT</h2>
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
                       <!--  <b>@Html.RadioButton("rdOrder", "DSC", isChecked: true)@Html.Label("DESCENDING")</b>
                        <b>@Html.RadioButton("rdOrder", "ASC", isChecked: false)@Html.Label("ASCENDING")</b>
 -->
                    </div>


                </td>

            </tr>
        </table>

        <br />
       <c:if test="${!(empty Model)}">


            <table class="Report_body">

                <tr>
                    <th align="center" rowspan="3" width="5">
                        SI.NO.
                    </th>
                    <th align="center" rowspan="3" width="25">
                        CC ZONE
                    </th>

                    <th align="center" rowspan="2" width="7">
                        OPENING BALANCE
                    </th>
                    <th align="center" colspan="2" width="14">
                        RECEIPTS(INCLUDING TRANSFERRED FROM CALL/BOOK/DENOVO/AND OTHER CATEGORIES)

                    </th>
                    <th align="center" colspan="2" width="14">
                        DISPOSAL
                    </th>

                    <th align="center" rowspan="2" width="7">
                        CLOSING BALANCE
                    </th>

                    <th align="center" rowspan="2" colspan="4" width="28">
                        AGE WISE BREAK UP OF PENDENCY
                    </th>

                </tr>

                <tr>
                    <th align="center" width="7">
                        FOR THE MONTH
                    </th>
                    <th align="center" width="7">
                        UPTO THE MONTH
                    </th>

                    <th align="center" width="7">
                        FOR THE MONTH
                    </th>
                    <th align="center" width="7">
                        UPTO THE MONTH

                    </th>


                </tr>


                <tr>
                    <th align="center" width="7">
                        NO.
                    </th>
                    <th align="center" width="7">
                        NO.
                    </th>

                    <th align="center" width="7">
                        NO.
                    </th>
                    <th align="center" width="7">
                        NO.

                    </th>
                    <th align="center" width="7">
                        NO.
                    </th>

                    <th align="center" width="7">
                        NO.
                    </th>

                    <th align="center" width="7">
                        LESS THAN 3 MONTHS
                    </th>

                    <th align="center" width="7">
                        3-6 MONTHS
                    </th>


                    <th align="center" width="7">
                        6-12 MONTHS
                    </th>


                    <th align="center" width="7">
                        ABOVE 1 YEAR
                    </th>

                </tr>

 <c:forEach var ="r" items="${Model}" >
                    
<c:set var = "opening_no"  value = "${opening_no + r.SUP_OPENING_NO}"/>
<c:set var = "receipts_for"  value = "${receipts_for + r.SUP_RECEIPT_NO_FOR}"/>
<c:set var = "receipts_upto"  value = "${receipts_upto + r.SUP_RECEIPT_NO_UPTO}"/>
<c:set var = "disposal_for"  value = "${disposal_for + r.SUP_DISPOSAL_NO_FOR}"/>
<c:set var = "disposal_upto"  value = "${disposal_upto + r.SUP_DISPOSAL_NO_UPTO}"/>
<c:set var = "closing_no"  value = "${closing_no + r.SUP_CLOSING_NO}"/>
<c:set var = "less_3"  value = "${less_3 + r.SUP_MONTHS_3_AMT_FOR}"/>

<c:set var = "less_6"  value = "${less_6 + r.SUP_MONTHS_3TO6_AMT_FOR}"/>
<c:set var = "less_12"  value = "${less_12 + r.SUP_MONTHS_6TO12_AMT_FOR}"/>
<c:set var = "above_1"  value = "${above_1 + r.SUP_MORE_YEAR_AMT_FOR}"/>

                   
                    <tr class="grid_head">
                        <th align="center" width="5%" height="22px">
                            ${rowNO += 1}
                        </th>
                        <th align="left" width="25%" height="22px">
                            
                        <a id="Zone_Link" href= "<%= session.getAttribute("DYNAMIC_LINK_PATH") %>GSTDPM/MSR/MSR_DPM_ST_1AE_COMM/ALL/${r.ZONE_CODE}/DSC/<%= desDt1.toUpperCase() %>/<%= session.getAttribute("CSRF_Token") %>" >${r.ZONE_NAME}</a>
                        
                        </th>
                        <td align="right" width="7%" height="22px">
                            ${r.SUP_OPENING_NO}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.SUP_RECEIPT_NO_FOR}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.SUP_RECEIPT_NO_UPTO}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.SUP_DISPOSAL_NO_FOR}
                        </td>

                        <td align="right" width="7%" height="22px">
                            ${r.SUP_DISPOSAL_NO_UPTO}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.SUP_CLOSING_NO}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.SUP_MONTHS_3_AMT_FOR}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.SUP_MONTHS_3TO6_AMT_FOR}
                        </td>

                        <td align="right" width="7%" height="22px">
                            ${r.SUP_MONTHS_6TO12_AMT_FOR}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.SUP_MORE_YEAR_AMT_FOR}
                        </td>

                    </tr>
</c:forEach>
                <tr>

                    <th align="center" width="5%" height="22px">

                    </th>
                    <th align="left" width="25%" height="22px">
                        TOTAL
                    </th>
                    <td align="right" width="7%" height="22px">
                        ${opening_no}
                    </td>
                    <td align="right" width="7%" height="22px">
                        ${receipts_for}
                    </td>
                    <td align="right" width="7%" height="22px">
                        ${receipts_upto}
                    </td>
                    <td align="right" width="7%" height="22px">
                        ${disposal_for}
                    </td>

                    <td align="right" width="7%" height="22px">
                        ${disposal_upto}
                    </td>
                    <td align="right" width="7%" height="22px">
                        ${closing_no}
                    </td>
                    <td align="right" width="7%" height="22px">
                        ${less_3}
                    </td>
                    <td align="right" width="7%" height="22px">
                        ${less_6}
                    </td>

                    <td align="right" width="7%" height="22px">
                        ${less_12}
                    </td>
                    <td align="right" width="7%" height="22px">
                        ${above_1}
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