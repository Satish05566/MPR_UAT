<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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

    <title>MSR-DPM-CUS-7G</title>
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
                        <a download='MSR-DPM-CUS-7G(<%= desDt.toUpperCase() %>).xls' href="#">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a>
                    </td>
                    <td style="text-align: right; "><%= new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date()) %></td>
                </tr>
            </c:if>
            <tr>

                <td colspan="3" align="center" style="font-size:18px;">

                    <% String display = ""; %>
                            <c:if test="${ViewBag_Report_Name=='ASC'}">
                            
                            <c:set var = "display"  value = "ASCENDING"/>
                            	
                             </c:if>
                             <c:if test="${ViewBag_Report_Name=='DSC'}">
                             
                             <c:set var = "display"  value = "DESCENDING"/>
                            	
                             </c:if>
                       <h1>
                        MSR-DPM-CUS-4
                    </h1>
                    <h2>
                        PENDENCY OF REFUND CASES IN <label id="lbl_order">DESCENDING</label> ORDER ON THE BASIS OF MORE THAN 3 MONTHS OLD CASES
                    </h2>              
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

            <table class="Report_body">


                <tr class="grid_head">
                    <th align="center" rowspan="2">
                        SR.NO.
                    </th>
                    <th align="center" rowspan="2">
                        Zones
                    </th>

                    <th align="center" rowspan="2" colspan="2">
                        CLOSING BALANCE
                    </th>
                    <th align="center" colspan="8">
                        age-wise Break up

                    </th>
                    <th align="center" rowspan="2" colspan="2">
                        > 3 MONTHS

                    </th>

                </tr>
                <tr class="grid_head">
                    <th align="center" colspan="2">
                        LESS THAN 3MONTHS
                    </th>
                    <th align="center" colspan="2">
                        3-6MONTHS
                    </th>

                    <th align="center" colspan="2">
                        6-12 MONTHS
                    </th>
                    <th align="center" colspan="2">
                        OVER 1 YEAR

                    </th>

                </tr>

                <tr class="grid_head">
                    <th align="center">

                    </th>
                    <th align="center">

                    </th>
                    <th align="center">
                        NO
                    </th>
                    <th align="center">
                        AMT
                    </th>

                    <th align="center">
                        NO
                    </th>
                    <th align="center">
                        AMT

                    </th>
                    <th align="center">
                        NO

                    </th>
                    <th align="center">
                        AMT
                    </th>
                    <th align="center">
                        NO
                    </th>
                    <th align="center">
                        AMT
                    </th>

                    <th align="center">
                        NO
                    </th>
                    <th align="center">
                        AMT

                    </th>

                    <th align="center">
                        NO
                    </th>
                    <th align="center">
                        AMT

                    </th>
                </tr>

                <tr class="grid_head">
                    <th align="center">
                        1
                    </th>
                    <th align="center">
                        2
                    </th>
                    <th align="center">
                        3
                    </th>
                    <th align="center">
                        4
                    </th>

                    <th align="center">
                        5
                    </th>
                    <th align="center">
                        6

                    </th>
                    <th align="center">
                        7

                    </th>
                    <th align="center">
                        8
                    </th>
                    <th align="center">
                        9
                    </th>
                    <th align="center">
                        10
                    </th>

                    <th align="center">
                        11
                    </th>
                    <th align="center">
                        12

                    </th>

                    <th align="center">
                        13
                    </th>
                    <th align="center">
                        14

                    </th>
                </tr>


                <c:forEach var ="r" items="${Model}" >
                    <tr class="grid_head">
                 <c:if test="${r.SNO != 50}">
                      
                            <th align="center" width="5%" height="22px">
                                ${r.SNO}
                            </th>
                      </c:if>
                           <c:if test="${!(r.SNO != 50)}">
                      
                            <th align="center" width="5%" height="22px">
                               
                            </th>
                      </c:if>
                       <c:if test="${r.ZONE_CODE!='ZY'}">
                      
                        <th align="left" width="25%" height="22px">
                           <a id="Zone_Link" href= "<%= session.getAttribute("DYNAMIC_LINK_PATH") %>GSTDPM/MSR/MSR_DPM_CUS_REFUND_4_COMM/ALL/${r.ZONE_CODE}/DESC/<%= desDt1.toUpperCase() %>/<%= session.getAttribute("CSRF_Token") %>" >${r.ZONE_NAME}</a>
                       
                        </th>
                       </c:if>
                       <c:if test="${!(r.ZONE_CODE!='ZY')}">
                            <th align="left" width="25%" height="22px">
                            ${r.ZONE_NAME}
                            </th>
                       </c:if>
                        <td align="right" width="8%" height="22px">
                            ${r.CLOSING_NO}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.CLOSING_AMT}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.MONTHS_3_NO}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.MONTHS_3_AMT}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.MONTHS_3TO6_NO}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.MONTHS_3TO6_AMT}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.MONTHS_6TO12_NO}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.MONTHS_6TO12_AMT}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.MORE_YEAR_NO}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.MORE_YEAR_AMT}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.MORE_3MONTHS_NO}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.MORE_3MONTHS_AMT}
                        </td>
                    </tr>
               </c:forEach>


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
