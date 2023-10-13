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

    <script>
        $(document).ready(function () {
            $("#hndcode").val("@ViewContext.RouteData.Values["Code"]");

            if ($("#hndcode").val() == "ASC") {
                $("#r1").hide();
                $("#r2").show();
                $("#lbl_order").text('ascending');
            }

            else {
                $("#r1").show();
                $("#r2").hide();
                $("#lbl_order").text('descending');
            }

        });

    </script>



    <script type="text/javascript">


        $(function () {
            $('input[name=rdOrder]').click(function () {
                var checked_site_radio = $('input:radio[name=rdOrder]:checked').val();
                window.location = "/MIS/DPM/MSR/MSR_DPM_CUS_11/@ViewContext.RouteData.Values["Report_Type"]/" + checked_site_radio + "/All%20India/@ViewContext.RouteData.Values["MM_YYYY"]";

                $("#hndcode").val("@ViewContext.RouteData.Values["Code"]");

            });
        });

        $(function () {
            $('input[name=rdOrder1]').click(function () {
                var checked_site_radio1 = $('input:radio[name=rdOrder1]:checked').val();
                window.location = "/MIS/DPM/MSR/MSR_DPM_CUS_11/@ViewContext.RouteData.Values["Report_Type"]/" + checked_site_radio1 + "/All%20India/@ViewContext.RouteData.Values["MM_YYYY"]";

                $("#hndcode").val("@ViewContext.RouteData.Values["Code"]");

            });
        });

    </script>
    <title>MSR-DPM-CUS-11-COMM</title>
</head>
<body>
    <div id="Report_main">
        <input type="hidden" name="hndcode" id="hndcode" value="@ViewContext.RouteData.Values["Code"]" />
        <table>
           <%!  String desDt = ""; String desDt1 = ""; int month=0; int year=0; %>
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
                            <a href="../../../../../Home/CorrectionBackup?MM_YYYY=${ViewBag_MM_YYYY}.MM_YYYY&MPR=DRI-CUS-1" style="color:brown; font-weight:bold;"><img src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
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
                        <a download='MSR-DPM_CUS-11(<%= desDt.toUpperCase() %>).xls' href="#">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a>
                    </td>
                    <td style="text-align: right; "><%= new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date()) %></td>
                </tr>
            </c:if>
            <tr>

                <td colspan="3" align="center">

                    <h1>MSR-DPM-CUS-11-COMM</h1>

                    <h2> Monitoring of fulfillment of Export obligation- Report for EPCG (from year 1994-95) as on end of the month</h2>

                </td>

            </tr>


            <tr>
                <td align="left">
                    <br /> <h2>MONTH : <%= desDt.toUpperCase() %></h2>
                </td>

                <td></td>
                <td></td>
            </tr>

      





        </table>

        <br />
        <c:if test="${!(empty Model)}">
            <table class="Report_body">




                <tr>
                    <th align="center" rowspan="3" width="5%">
                        SI.NO.
                    </th>
                    <th align="center" rowspan="3" width="26%">
                        COMMISSIONERATE
                    </th>
                    <th align="center" rowspan="2" width="10%">No. of Licenses Registered</th>
                    <th align="center" rowspan="2" width="10%">No. of cases where Export Obligation(EO) fulfilled</th>
                    <th align="center" rowspan="2" width="10%">No. of cases where time to produce evidence of <br /> EO fulfillment is not over</th>
                    <th align="center" rowspan="2" width="10%">No. of cases where time to produce evidence of <br /> EO fulfillment is  over </th>
                    <th align="center" colspan="3" width="30%">Status of cases indicated in column 6</th>
                    <th align="center" rowspan="3" width="10%"> % Of Cases Where Action Not Yet Initiated (col.7(A)/col.6)</th>
                </tr>
                
                <tr>
                    <th align="center"  width="10%">No. of cases where action not yet initiated</th>
                    <th align="center"  width="10%">No.of cases where adjudication order passed in the Zone</th>
                    <th align="center"  width="20%">No. of cases where notice issued in the Zone <br /> '(In Terms of bond or undertaking) to importer,but not adjudicated</th>
                </tr>
                <tr>
                    <th align="center" width="5%">Upto the month</th>
                    <th align="center" width="5%">Upto the month</th>
                    <th align="center" width="5%">Upto the month</th>
                    <th align="center" width="5%">Upto the month</th>
                    <th align="center" width="5%">Upto the month</th>
                    <th align="center" width="5%">Upto the month</th>
                    <th align="center" width="5%">Upto the month</th>
                </tr>
                <tr>
                    <th align="center" width="10%">1</th>
                    <th align="center" width="10%">2</th>
                    <th align="center" width="5%">3</th>
                    <th align="center" width="5%">4</th>
                    <th align="center" width="5%">5</th>
                    <th align="center" width="5%">6</th>
                    <th align="center" width="10%">7(A)</th>
                    <th align="center" width="5%">7(B)</th>
                    <th align="center" width="5%">7(C)</th>
                    <th align="center" width="10%">8</th>
                </tr>
              

               <c:forEach var="r" items="${Model}">

                    <tr class="grid_head">
                       <c:if test="${r.SNO != 100}">
                        
                            <th align="center" width="5%" height="22px">
                                ${r.SNO}
                            </th>
                            </c:if>
                       <c:if test="${!(r.SNO != 100)}">
                            <th align="center" width="5%" height="22px">

                            </th>
                        </c:if>
                     
                            <th align="left" width="26%" height="22px">
                                ${r.COMM_NAME}
                            </th>
                      
                        <td align="right" width="8%" height="22px">
                            ${r.LICENSES_REGISTER}
                        </td>                       
                        <td align="right" width="7%" height="22px">
                            ${r.CASES_EXPORT}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.NOC_EVIDENCE}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.PRODUCE_FULFILMENT_IS_OVER}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.CASESNOT_ACTION}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.CASES_ADJUDICATION}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.IMPORTER_BUT_NOT_ADJUDICATED}
                        </td>
                        <td align="right" width="8%" height="22px">
                            ${r.ACTION_NOT_YET_INITIATE}
                        </td>
                    </tr>

               </c:forEach>

            </table>
        </c:if>
       <a id="back_lnk" href="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>GSTDPM/MSR/MSR_DPM_CUS_11/All/0/All%20India/<%= desDt1.toUpperCase() %>/<%= session.getAttribute("CSRF_Token") %>">Back to Previous Report</a>                
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
