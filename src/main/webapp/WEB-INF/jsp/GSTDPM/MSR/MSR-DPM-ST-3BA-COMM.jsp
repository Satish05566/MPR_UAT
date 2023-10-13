
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

    <script>
        $(document).ready(function () {
            $("#hndcode").val("@ViewContext.RouteData.Values["Report_Type"]");

            if ($("#hndcode").val() == "ASC") {
                $("#r1").hide();
                $("#r2").show();
                $("#lbl_order").text('ASCENDING');
            }

            else {
                $("#r1").show();
                $("#r2").hide();
                $("#lbl_order").text('DESCENDING');
            }

        });

    </script>

    <script type="text/javascript">


    $(function () {
        $('input[name=rdOrder]').click(function () {
            var checked_site_radio = $('input:radio[name=rdOrder]:checked').val();
            window.location = "/MIS/DPM/MSR/MSR_DPM_ST_3BA_COMM/" + checked_site_radio + "/@ViewContext.RouteData.Values["Code"]/All%20India/@ViewContext.RouteData.Values["MM_YYYY"]";

            $("#hndcode").val("@ViewContext.RouteData.Values["Report_Type"]");

            });
        });

        $(function () {
            $('input[name=rdOrder1]').click(function () {
                var checked_site_radio1 = $('input:radio[name=rdOrder1]:checked').val();
                window.location = "/MIS/DPM/MSR/MSR_DPM_ST_3BA_COMM/" + checked_site_radio1 + "/@ViewContext.RouteData.Values["Code"]/All%20India/@ViewContext.RouteData.Values["MM_YYYY"]";

                $("#hndcode").val("@ViewContext.RouteData.Values["Report_Type"]");

        });
    });

    </script>

    <title>MSR-DPM-ST-3BA</title>
</head>
<body>

    <div id="Report_main">
        <input type="hidden" name="hndcode" id="hndcode" value="@ViewContext.RouteData.Values["Code"]" />
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
                        <a download='MSR-DPM-ST-1AA(<%= desDt.toUpperCase() %>).xls' href="#">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a>
                    </td>
                    <td style="text-align: right; "><%= new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date()) %></td>
                </tr>
            </c:if>
            <tr>

                <td colspan="3" align="center">

                    <h1>MSR-DPM-ST-3BA</h1>

                    <h2>
                        REASONS FOR PENDING CALL BOOK CASES IN <label id="lbl_order">DESCENDING</label> ORDER  ON THE BASIS OF NO.OF CASES PENDING.<br />
                        CATEGORY:CASES IN WHICH DEPARTMENT HAS GONE IN APPEAL TO THE APPROPRIATE AUTHORITY
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
                   <!--  <div id="r1">

                        <b>@Html.RadioButton("rdOrder", "DSC", isChecked: true)@Html.Label("DESCENDING")</b>
                        <b> @Html.RadioButton("rdOrder", "ASC", isChecked: false)@Html.Label("ASCENDING")</b>

                    </div>
                    <div id="r2">

                        <b>@Html.RadioButton("rdOrder1", "DSC", isChecked: false)@Html.Label("DESCENDING")</b>
                        <b> @Html.RadioButton("rdOrder1", "ASC", isChecked: true)@Html.Label("ASCENDING")</b>

                    </div> -->

                </td>

            </tr>


        </table>

        <br />
       <c:if test="${!(empty Model)}">
            <table class="Report_body">


                <tr>
                    <th align="center" rowspan="2" width="5">
                        SI.NO.
                    </th>
                    <th align="center" rowspan="2" width="25">
                        COMMISSIONERATES
                    </th>

                    <th align="center" rowspan="2" width="7">
                        NO.OF CASES PENDING
                    </th>
                    <th align="center" rowspan="2" width="14">
                        AMOUNT OF DUTY INVOLVED

                    </th>
                    <th align="center" colspan="5" width="14">
                        AGE-WISE BREAK UP OF PENDENCY
                    </th>
                </tr>

                <tr>
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
                        1-2 YEARS

                    </th>
                    <th align="center" width="7">
                        MORE THAN 2 YEARS
                    </th>
                </tr>

              <c:forEach var ="r" items="${Model}" >

                    <tr class="grid_head">
                    <c:if test="${r.SNO != 50}">
                       
                            <th align="center" width="5%" height="22px">
                                ${r.SNO}
                            </th>
                        </c:if>
                        <c:if test="${r.SNO == 50}">
                            <th align="center" width="5%" height="22px">

                            </th>
                        </c:if>
                        <th align="left" width="25%" height="22px">
                            ${r.COMM_NAME}
                        </th>
                        <td align="right" width="7%" height="22px">
                            ${r.DEPT_NOC}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.DEPT_AMOUNT}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.DEPT_MONTHS_3}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.DEPT_MONTHS_3TO6}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.DEPT_MONTHS_6TO12}
                        </td>

                        <td align="right" width="7%" height="22px">
                            ${r.DEPT_YEARS_1TO2}
                        </td>
                        <td align="right" width="7%" height="22px">
                            ${r.DEPT_MORE_2YEAR}
                        </td>

                    </tr>
               </c:forEach>




            </table>
   
    <a id="back_lnk" href="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>GSTDPM/MSR/MSR_DPM_ST_3BA/All/0/DSC/<%= desDt1.toUpperCase() %>/<%= session.getAttribute("CSRF_Token") %>">Back to Previous Report</a>
        
    
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
