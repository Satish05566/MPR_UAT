
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
            margin: auto;
            width: 90%;
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
                var url = "/DPM/MSR/" + pathArray[4] + "/All/" + pathArray[6] + "/All India/" + pathArray[8] + "/" + order;
                window.open(url, "_self");
            });
        });
        window.onload = function () {
            var pathArray = window.location.pathname.split('/');
            if (pathArray[9] == 'ASC') {
                $("input[name=rdOrder][value=" + pathArray[9] + "]").attr('checked', 'checked');
            }

            else {
                if (pathArray[9] == 'DSC') {
                    $("input[name=rdOrder][value=" + pathArray[9] + "]").attr('checked', 'checked');
                }
            }
        }
    </script>

    <style>
        ul.pagination {
            display: inline-block;
            padding: 0;
            margin: 0;
        }

            ul.pagination li {
                display: inline;
            }

                ul.pagination li a {
                    color: black;
                    float: left;
                    padding: 8px 16px;
                    text-decoration: none;
                    transition: background-color .3s;
                }

                    ul.pagination li a.active {
                        background-color: red;
                        color: blue;
                    }

                    ul.pagination li a:hover:not(.active) {
                        background-color: red;
                    }
    </style>
    
    <script>
        $(document).ready(function () {
            //var url = window.location.href;
            //var option = url.match(/option=(.*)/);
            //if (option !== null) {
            //    $(".link .".option[1]).trigger('click');
            //}

            $(".link").bind('click', function () {
                $('#intro-tekst').hide();
                $('.DPM').hide();
                $('.link').removeClass('selected');
                $(this).removeClass('link');
                $('#' + $(this).prop('class')).show();
                $(this).addClass('link selected');
            });
        });
    </script>





    <title>MSR-DPM-ST-6</title>
</head>
<body>

    @{
        DateTime date = System.DateTime.Now;
        if (ViewContext.RouteData.Values["MM_YYYY"] != null)
        {
            date = Convert.ToDateTime(ViewContext.RouteData.Values["MM_YYYY"]);
        }
    }

    <div id="Report_main">
        <table>
            @if (
                 (ViewBag.Report1) != null &&
                 (ViewBag.Report2) != null &&
                 (ViewBag.Report3) != null &&
                 (ViewBag.Report4) != null && (((IEnumerable<dynamic>)ViewBag.Report4).Count() == 5) &&
                 (ViewBag.Report5) != null && (((IEnumerable<dynamic>)ViewBag.Report5).Count() == 5) &&
                 (ViewBag.Report6) != null && (((IEnumerable<dynamic>)ViewBag.Report6).Count() == 5) &&
                 (ViewBag.Report7) != null && (((IEnumerable<dynamic>)ViewBag.Report7).Count() == 5) &&
                 (ViewBag.Report8) != null && (((IEnumerable<dynamic>)ViewBag.Report8).Count() == 5) &&
                 (ViewBag.Report9) != null && (((IEnumerable<dynamic>)ViewBag.Report9).Count() == 5) &&
                 (ViewBag.Report10) != null &&
                 (ViewBag.Report11) != null &&
                 (ViewBag.Report12) != null &&
                 (ViewBag.Report13) != null && (((IEnumerable<dynamic>)ViewBag.Report13).Count() == 5) &&
                 (ViewBag.Report14) != null
                )
            {
                <tr>
                    <td>
                        @if (
                            (Convert.ToInt32((ViewBag.Report1).TOTAL_COMM) > Convert.ToInt32((ViewBag.Report1).COMPLETE_COMM)) 
                            )
                        {
                            <img src="~/images/incomplete.gif" title="@((ViewBag.Report1).COMPLETE_COMM)/@((ViewBag.Report1).TOTAL_COMM)" />
                        }
                        else
                        {
                            <img src="~/images/complete.gif" />
                        }
                        @if (
                 ((ViewBag.Report1).AMND != 0) &&
                 ((ViewBag.Report2).AMND != 0) &&
                 ((ViewBag.Report3).AMND != 0) &&
                 ((ViewBag.Report4)[0].AMND != 0) &&
                 ((ViewBag.Report5)[0].AMND != 0) &&
                 ((ViewBag.Report6)[0].AMND != 0) &&
                 ((ViewBag.Report7)[0].AMND != 0) &&
                 ((ViewBag.Report8)[0].AMND != 0) &&
                 ((ViewBag.Report9)[0].AMND != 0) &&
                 ((ViewBag.Report10).AMND != 0) &&
                 ((ViewBag.Report11).AMND != 0) &&
                 ((ViewBag.Report12).AMND != 0) &&
                 ((ViewBag.Report13)[0].AMND != 0) &&
                 ((ViewBag.Report14).AMND != 0)
                            )
                        {
                            <a href="~/Home/CorrectionBackup?MM_YYYY=@ViewBag.MM_YYYY&MPR=DPM-ST-6" style="color:brown; font-weight:bold;"><img src="~/images/Amended.gif" /></a>
                        }
                    </td>
                    <td style="text-align: center;">
                        <a download='MSR-DPM-ST-6(@Convert.ToDateTime(ViewBag.MM_YYYY).ToString("MMM-yyyy").ToUpper()).xls' href="#">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a>
                    </td>
                    <td align="right">@DateTime.Now</td>

                </tr>
            }
            <tr>

                <td colspan="3" align="center">

                    <h1> MSR-DPM-ST-6</h1>
                    @*@{string display = string.Empty;}
                        @if (ViewContext.RouteData.Values["Order"].ToString() == "ASC")
                        {
                            display = "ASCENDING";
                        }

                        else if (ViewContext.RouteData.Values["Order"].ToString() == "DSC")
                        {
                            display = "DESCENDING";
                        }*@
                    <h2>COMPARATIVE ANALYSIS OF THE MPR REPORTS IN RESPECT OF KEY PERFORMANCE AREAS </h2>
                </td>

            </tr>
            <tr>
                <td align="left">
                    <br /> <h2>MONTH : @Convert.ToDateTime(ViewBag.MM_YYYY).ToString("MMM-yyyy").ToUpper()</h2>
                </td>

                <td></td>
                <td></td>
            </tr>

            <tr></tr>
        </table>

        <br />
        @if (date>=Convert.ToDateTime("2016-12-01"))
              {

        <div class="DPM" id="1">
            @{int addtion = 0;}
            @{int reduction = 0;}
            @{int closing_no_c = 0;}
            @{int closing_no_P = 0;}
            @{decimal closing_amt_c = 0;}
            @{decimal closing_amt_P = 0;}

            @{string addt = "addition of";}
            @{string reduc = "reduction of";}

            @{string inc = "increased.";}
            @{string dec = "decreased.";}

            @if (ViewBag.Report1 != null)  
            {
                closing_no_c = Convert.ToInt32(ViewBag.Report1.TOTAL_CLOSING_NO_C);
                closing_no_P = Convert.ToInt32(ViewBag.Report1.TOTAL_CLOSING_NO_P);
                closing_amt_c = Convert.ToDecimal(ViewBag.Report1.TOTAL_CLOSING_AMT_C);
                closing_amt_P = Convert.ToDecimal(ViewBag.Report1.TOTAL_CLOSING_AMT_P);

                if (closing_no_c > closing_no_P)
                {
                    addtion = closing_no_c - closing_no_P;
                }
                else
                {
                    reduction = closing_no_P - closing_no_c;
                }



                <p>
                    <strong>1. &nbsp; Adjudication:-</strong> As per the MPR, <strong>@closing_no_c </strong>cases are pending for adjudication involving duty amount <strong>Rs.@closing_amt_c Lakhs </strong>at the end of @Html.Raw(Convert.ToDateTime(ViewBag.Report1.MM_YYYY).ToString("MMM,yyyy").ToUpper()). <strong>@closing_no_P</strong> cases involving an amount of <strong>Rs. @closing_amt_P Lakhs</strong> were pending for adjudication at the end of @Html.Raw(Convert.ToDateTime(ViewBag.Report1.MM_YYYY_P).ToString("MMM,yyyy").ToUpper()).
                    The comparative analysis shows that there is a
                    @if (closing_no_c > closing_no_P)
                    {
                        @addt <strong>@addtion </strong>
                    }
                    else
                    {

                        @reduc <strong>@reduction </strong>
                    }

                    cases pending adjudication as compared to previous month. The amount involved has also
                    @if (closing_amt_c > closing_amt_P)
                    {
                        @inc
                    }
                    else
                    {
                        @dec
                    }


                    The age wise breakup of the cases for the month of @Html.Raw(Convert.ToDateTime(ViewBag.Report1.MM_YYYY_P).ToString("MMM,yyyy").ToLower()) and @Html.Raw(Convert.ToDateTime(ViewBag.Report1.MM_YYYY).ToString("MMM,yyyy").ToLower()) are given below:-
                </p>

                <table class="Report_body">
                    <tr>
                        <th align="center">

                        </th>
                        <th align="center">
                            No. of cases
                        </th>

                        <th align="center">
                            Amount (Rs. in lakhs)
                        </th>
                        <th align="center">
                            < 3 months

                        </th>
                        <th align="center">
                            3-6 months
                        </th>

                        <th align="center">
                            6-12 months
                        </th>

                        <th align="center">
                            Above 1 Year
                        </th>

                    </tr>

                    <tr>
                        <th align="center">@Html.Raw(Convert.ToDateTime(ViewBag.Report1.MM_YYYY_P).ToString("MMM,yyyy").ToLower())</th>
                        <th align="center">@Html.Raw(ViewBag.Report1.TOTAL_CLOSING_NO_P)</th>
                        <th align="center">@Html.Raw(ViewBag.Report1.TOTAL_CLOSING_AMT_P)</th>
                        <td align="center">@Html.Raw(ViewBag.Report1.TOTAL_MONTHS_3_AMT_P)</td>
                        <td align="center">@Html.Raw(ViewBag.Report1.TOTAL_MONTHS_3TO6_AMT_P)</td>
                        <td align="center">@Html.Raw(ViewBag.Report1.TOTAL_MONTHS_6TO12_AMT_P)</td>
                        <td align="center">@Html.Raw(ViewBag.Report1.TOTAL_MORE_YEAR_AMT_P)</td>
                    </tr>


                    <tr>
                        <th align="center">@Html.Raw(Convert.ToDateTime(ViewBag.Report1.MM_YYYY).ToString("MMM,yyyy").ToLower())</th>
                        <th align="center">@Html.Raw(ViewBag.Report1.TOTAL_CLOSING_NO_C)</th>
                        <th align="center">@Html.Raw(ViewBag.Report1.TOTAL_CLOSING_AMT_C)</th>
                        <td align="center">@Html.Raw(ViewBag.Report1.TOTAL_MONTHS_3_AMT_C)</td>
                        <td align="center">@Html.Raw(ViewBag.Report1.TOTAL_MONTHS_3TO6_AMT_C)</td>
                        <td align="center">@Html.Raw(ViewBag.Report1.TOTAL_MONTHS_6TO12_AMT_C)</td>
                        <td align="center">@Html.Raw(ViewBag.Report1.TOTAL_MORE_YEAR_AMT_C)</td>
                    </tr>



                </table>

            }

            <br />
            @if (ViewBag.Report2 != null) 
            {

                <p>
                    <strong>1.1</strong> The distribution of pendency of case before various adjudicating authorities for the period @Html.Raw(Convert.ToDateTime(ViewBag.Report2.MM_YYYY_P).ToString("MMM,yyyy").ToUpper()) and @Html.Raw(Convert.ToDateTime(ViewBag.Report2.MM_YYYY).ToString("MMM,yyyy").ToUpper()) respectively, are as under:-
                </p>

                <table class="Report_body">
                    <tr>
                        <th align="center">

                        </th>
                        <th align="center">
                            Adjn. Authority
                        </th>

                        <th align="center">
                            Number
                        </th>
                        <th align="center">
                            % age

                        </th>
                        <th align="center">
                            Amount (Rs. in crores)
                        </th>

                        <th align="center">
                            % age
                        </th>

                    </tr>

                    <tr>
                        <th align="center" rowspan="4">@Html.Raw(Convert.ToDateTime(ViewBag.Report2.MM_YYYY_P).ToString("MMM,yyyy").ToUpper())</th>
                        <td align="center">Commissioner</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.COMM_CLOSING_NO_P)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.COMM_CLOSING_NO_CERCENT_P == null ? "0" : Html.Raw(ViewBag.Report2.COMM_CLOSING_NO_CERCENT_P))</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.COMM_CLOSING_AMT_P)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.COMM_CLOSING_AMT_CERCENT_P == null ? "0" : Html.Raw(ViewBag.Report2.COMM_CLOSING_AMT_CERCENT_P))</td>
                    </tr>


                    <tr>
                        <td align="center">Addl./Jt.Commr</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.JC_CLOSING_NO_P)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.JC_CLOSING_NO_CERCENT_P == null ? "0" : Html.Raw(ViewBag.Report2.JC_CLOSING_NO_CERCENT_P))</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.JC_CLOSING_AMT_P)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.JC_CLOSING_AMT_CERCENT_P == null ? "0" : Html.Raw(ViewBag.Report2.JC_CLOSING_AMT_CERCENT_P))</td>
                    </tr>

                    <tr>
                        <td align="center">DC/AC</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.AC_CLOSING_NO_P)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.AC_CLOSING_NO_CERCENT_P == null ? "0" : Html.Raw(ViewBag.Report2.AC_CLOSING_NO_CERCENT_P))</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.AC_CLOSING_AMT_P)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.AC_CLOSING_AMT_CERCENT_P == null ? "0" : Html.Raw(ViewBag.Report2.AC_CLOSING_AMT_CERCENT_P))</td>
                    </tr>

                    <tr>
                        <td align="center">Supdts</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.SUP_CLOSING_NO_P)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.SUP_CLOSING_NO_CERCENT_P == null ? "0" : Html.Raw(ViewBag.Report2.SUP_CLOSING_NO_CERCENT_P))</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.SUP_CLOSING_AMT_P)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.SUP_CLOSING_AMT_CERCENT_P == null ? "0" : Html.Raw(ViewBag.Report2.SUP_CLOSING_AMT_CERCENT_P))</td>
                    </tr>


                    <tr>
                        <th align="center" rowspan="4">@Html.Raw(Convert.ToDateTime(ViewBag.Report2.MM_YYYY).ToString("MMM,yyyy").ToUpper())</th>
                        <td align="center">Commissioner</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.COMM_CLOSING_NO_C)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.COMM_CLOSING_NO_CERCENT_C == null ? "0" : Html.Raw(ViewBag.Report2.COMM_CLOSING_NO_CERCENT_C))</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.COMM_CLOSING_AMT_C)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.COMM_CLOSING_AMT_CERCENT_C == null ? "0" : Html.Raw(ViewBag.Report2.COMM_CLOSING_AMT_CERCENT_C))</td>
                    </tr>


                    <tr>
                        <td align="center">Addl./Jt.Commr</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.JC_CLOSING_NO_C)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.JC_CLOSING_NO_CERCENT_C == null ? "0" : Html.Raw(ViewBag.Report2.JC_CLOSING_NO_CERCENT_C))</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.JC_CLOSING_AMT_C)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.JC_CLOSING_AMT_CERCENT_C == null ? "0" : Html.Raw(ViewBag.Report2.JC_CLOSING_AMT_CERCENT_C))</td>
                    </tr>

                    <tr>
                        <td align="center">DC/AC</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.AC_CLOSING_NO_C)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.AC_CLOSING_NO_CERCENT_C == null ? "0" : Html.Raw(ViewBag.Report2.AC_CLOSING_NO_CERCENT_C))</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.AC_CLOSING_AMT_C)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.AC_CLOSING_AMT_CERCENT_C == null ? "0" : Html.Raw(ViewBag.Report2.AC_CLOSING_AMT_CERCENT_C))</td>
                    </tr>

                    <tr>
                        <td align="center">Supdts</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.SUP_CLOSING_NO_C)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.SUP_CLOSING_NO_CERCENT_C == null ? "0" : Html.Raw(ViewBag.Report2.SUP_CLOSING_NO_CERCENT_C))</td>
                        <td align="center">@Html.Raw(ViewBag.Report2.SUP_CLOSING_AMT_C)</td>
                        <td align="center">@string.Format("{0}%", ViewBag.Report2.SUP_CLOSING_AMT_CERCENT_C == null ? "0" : Html.Raw(ViewBag.Report2.SUP_CLOSING_AMT_CERCENT_C))</td>
                    </tr>



                </table>

            }

            <br />
            @{int close_no_c = 0;}
            @{int close_no_P = 0;}
            @{decimal close_amt_c = 0;}
            @{decimal close_amt_P = 0;}
            @{string incs = "increased";}
            @{string decs = "decreased";}

            @{int more_1_c = 0;}
            @{int more_1_p = 0;}

            @if (ViewBag.Report3 != null) 
            {
                close_no_c = Convert.ToInt32(ViewBag.Report3.CLOSING_NO_C);
                close_no_P = Convert.ToInt32(ViewBag.Report3.CLOSING_NO_P);
                close_amt_c = Convert.ToDecimal(ViewBag.Report3.CLOSING_AMT_C);
                close_amt_P = Convert.ToDecimal(ViewBag.Report3.CLOSING_AMT_P);

                more_1_c = Convert.ToInt32(ViewBag.Report3.YEARS_1TO2_C) + Convert.ToInt32(ViewBag.Report3.YEARS_2TO3_C) + Convert.ToInt32(ViewBag.Report3.MORE_THAN_3_C);
                more_1_p = Convert.ToInt32(ViewBag.Report3.YEARS_1TO2_P) + Convert.ToInt32(ViewBag.Report3.YEARS_2TO3_P) + Convert.ToInt32(ViewBag.Report3.MORE_THAN_3_P);

                <p>
                    <strong>1.2 &nbsp; </strong> As regards the  <strong>cases involving duty amount of Rs. 1 crore & above,</strong> the total pendency, has
                    @if (close_no_c > close_no_P)
                    {
                        @incs
                    }
                    else
                    {

                        @decs
                    }
                    to <strong>@close_no_c cases</strong> as compared to <strong>@close_no_P cases</strong> last month and similarly, amount involved has also
                    @if (close_amt_c > close_amt_P)
                    {
                        @incs
                    }
                    else
                    {
                        @decs
                    }
                    .
                </p>

                <table class="Report_body">
                    <tr>
                        <th align="center">

                        </th>
                        <th align="center">
                            No. of cases
                        </th>

                        <th align="center">
                            Amt of duty (in crores)
                        </th>
                        <th align="center">
                            < 1 Year

                        </th>
                        <th align="center">
                            1-2 Year
                        </th>
                        <th align="center">
                            2-3 Year
                        </th>
                        <th align="center">
                            More than 3 Year
                        </th>

                    </tr>

                    <tr>
                        <th align="center">@Html.Raw(Convert.ToDateTime(ViewBag.Report3.MM_YYYY_P).ToString("MMM,yyyy").ToUpper())</th>
                        <th align="center">@Html.Raw(ViewBag.Report3.CLOSING_NO_P)</th>
                        <th align="center">@Html.Raw(ViewBag.Report3.CLOSING_AMT_P)</th>
                        <td align="center">@Html.Raw(ViewBag.Report3.YEAR_1_P)</td>
                        <td align="center">@Html.Raw(ViewBag.Report3.YEARS_1TO2_P)</td>
                        <td align="center">@Html.Raw(ViewBag.Report3.YEARS_2TO3_P)</td>
                        <td align="center">@Html.Raw(ViewBag.Report3.MORE_THAN_3_P)</td>
                    </tr>

                    <tr>
                        <th align="center">@Html.Raw(Convert.ToDateTime(ViewBag.Report3.MM_YYYY).ToString("MMM,yyyy").ToUpper())</th>
                        <th align="center">@Html.Raw(ViewBag.Report3.CLOSING_NO_C)</th>
                        <th align="center">@Html.Raw(ViewBag.Report3.CLOSING_AMT_C)</th>
                        <td align="center">@Html.Raw(ViewBag.Report3.YEAR_1_C)</td>
                        <td align="center">@Html.Raw(ViewBag.Report3.YEARS_1TO2_C)</td>
                        <td align="center">@Html.Raw(ViewBag.Report3.YEARS_2TO3_C)</td>
                        <td align="center">@Html.Raw(ViewBag.Report3.MORE_THAN_3_C)</td>

                    </tr>
                </table>
                <p>However, @more_1_c cases are pending for more than one year as compared to <strong> @more_1_p </strong> in @Html.Raw(Convert.ToDateTime(ViewBag.Report3.MM_YYYY_P).ToString("MMM,yyyy").ToUpper()).</p>

            }

        </div>


        <div class="DPM" id="2" hidden>
            @if ((ViewBag.Report4 != null) && (((IEnumerable<dynamic>)ViewBag.Report4).Count() == 5) && (ViewBag.Report5 != null) && (((IEnumerable<dynamic>)ViewBag.Report5).Count() == 5))
            {
                <p>
                    <strong>2.1 &nbsp; </strong> The top five zones in the category of total number of <strong>cases pending for more than one year</strong> are as under:
                </p>

                <table class="Report_body">
                    <tr>
                        <th align="center" rowspan="2">
                            Sr. No.
                        </th>
                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.Report5)[0].MM_YYYY_P).ToString("MMM-yyyy"))
                        </th>

                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.Report4)[0].MM_YYYY).ToString("MMM-yyyy"))
                        </th>
                    </tr>

                    <tr>
                        <th align="center">Zone</th>
                        <th align="center">Pendency</th>
                        <th align="center">Zone</th>
                        <th align="center">Pendency</th>
                    </tr>

                    @for (int i = 0; i < 5; i++)
                {


                    <tr>
                        <th align="center">@(i + 1)</th>
                        <td align="center">@((ViewBag.Report5)[i].ZONE_NZME_P) </td>
                        <td align="center">@((ViewBag.Report5)[i].TOTAL_PENDENCY_P) </td>
                        <td align="center">@((ViewBag.Report4)[i].ZONE_NZME_C) </td>
                        <td align="center">@((ViewBag.Report4)[i].TOTAL_PENDENCY_C)  </td>
                    </tr>

                }

                </table>
                <p>As evident from the table above @((ViewBag.Report4)[0].ZONE_NZME_C) tops the table with <strong> @((ViewBag.Report4)[0].TOTAL_PENDENCY_C) cases</strong> followed by @((ViewBag.Report4)[1].ZONE_NZME_C) with <strong> @((ViewBag.Report4)[1].TOTAL_PENDENCY_C) cases. </strong> @((ViewBag.Report4)[2].ZONE_NZME_C) zone is at 3rd place with <strong> @((ViewBag.Report4)[2].TOTAL_PENDENCY_C) cases.</strong></p>
            }
            <br />
            @if ((ViewBag.Report6 != null) && (((IEnumerable<dynamic>)ViewBag.Report6).Count() == 5) && (ViewBag.Report7 != null) && (((IEnumerable<dynamic>)ViewBag.Report7).Count() == 5))
            {
                <p>
                    <strong>2.2 &nbsp; </strong> The top five zones in the category of pending total number of <strong>cases involving duty of Rs. 1 crore & above </strong> are as under:
                </p>

                <table class="Report_body">
                    <tr>
                        <th align="center" rowspan="2">
                            Sr. No.
                        </th>
                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.Report7)[0].MM_YYYY_P).ToString("MMM-yyyy"))
                        </th>

                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.Report6)[0].MM_YYYY_C).ToString("MMM-yyyy"))
                        </th>
                    </tr>

                    <tr>
                        <th align="center">Zone</th>
                        <th align="center">Pendency</th>
                        <th align="center">Zone</th>
                        <th align="center">Pendency</th>
                    </tr>

                    @for (int i = 0; i < 5; i++)
                {


                    <tr>
                        <th align="center">@(i + 1)</th>
                        <td align="center">@((ViewBag.Report7)[i].ZONE_NZME_P) </td>
                        <td align="center">@((ViewBag.Report7)[i].TOTAL_PENDENCY_P) </td>
                        <td align="center">@((ViewBag.Report6)[i].ZONE_NZME_C) </td>
                        <td align="center">@((ViewBag.Report6)[i].TOTAL_PENDENCY_C)  </td>
                    </tr>

                }


                </table>
                <p>From the above table, @((ViewBag.Report6)[0].ZONE_NZME_C) zone is at the top of the table followed by @((ViewBag.Report6)[1].ZONE_NZME_C), @((ViewBag.Report6)[2].ZONE_NZME_C), @((ViewBag.Report6)[3].ZONE_NZME_C) & @((ViewBag.Report6)[4].ZONE_NZME_C) at No. 2,3,4, & 5 respectively.</p>
            }
        </div>


        <div class="DPM" id="3" hidden>
            @if (ViewBag.Report10 != null) 
            {
                <p>
                    <strong>3 &nbsp;  Call Book Cases: </strong> The total number of cases pending in Call Book in @Html.Raw(Convert.ToDateTime(ViewBag.Report10.MM_YYYY).ToString("MMM,yyyy").ToUpper()) is <strong>@Html.Raw(ViewBag.Report10.TOTAL_CLOSING_C) cases</strong>as compared to <strong>@Html.Raw(ViewBag.Report10.TOTAL_CLOSING_P) cases </strong>in @Html.Raw(Convert.ToDateTime(ViewBag.Report10.MM_YYYY_P).ToString("MMM,yyyy").ToUpper()). The top five zones having high pendency are as under :-
                </p>
            }

            @if ((ViewBag.Report8 != null) && (((IEnumerable<dynamic>)ViewBag.Report8).Count() == 5) && (ViewBag.Report9 != null) && (((IEnumerable<dynamic>)ViewBag.Report9).Count() == 5))
            {
                <table class="Report_body">
                    <tr>
                        <th align="center" rowspan="2">
                            Sr. No.
                        </th>
                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.Report9)[0].MM_YYYY_P).ToString("MMM,yyyy"))
                        </th>

                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.Report8)[0].MM_YYYY).ToString("MMM,yyyy"))
                        </th>
                    </tr>

                    <tr>
                        <th align="center">Zone</th>
                        <th align="center">Pendency</th>
                        <th align="center">Zone</th>
                        <th align="center">Pendency</th>
                    </tr>

                    @for (int i = 0; i < 5; i++)
                {

                <tr>
                    <th align="center">@(i + 1)</th>
                    <td align="center">@((ViewBag.Report9)[i].ZONE_NZME_P) </td>
                    <td align="center">@((ViewBag.Report9)[i].TOTAL_PENDENCY_P) </td>
                    <td align="center">@((ViewBag.Report8)[i].ZONE_NZME_C) </td>
                    <td align="center">@((ViewBag.Report8)[i].TOTAL_PENDENCY_C)  </td>
                </tr>

                }


                </table>

            }

            @if ((ViewBag.Report11) != null) 
            {
                <p>
                    The analysis shows that the maximum number of cases viz.<strong> @Html.Raw(ViewBag.Report11.DEPT_NOC_1) cases </strong> pending pertain to the category where the Department has gone in appeal. This is followed by <strong> @Html.Raw(ViewBag.Report11.OBJECTIONS_NOC_2) cases </strong> based on CERA objection.
                    <strong> @Html.Raw(ViewBag.Report11.OBJECTIONS_NOC_3) cases </strong> were pending during @Html.Raw(Convert.ToDateTime(ViewBag.Report11.MM_YYYY_P).ToString("MMM,yyyy").ToUpper()) which have reduced to
                    <strong> @Html.Raw(ViewBag.Report11.OBJECTIONS_NOC_2). @Html.Raw(ViewBag.Report11.SPEC_NOC_4) cases</strong> have shown pending as cases where Board has specifically ordered the case to be kept in call book.
                </p>
            }
            <br />

            @if ((ViewBag.Report13 != null) && (((IEnumerable<dynamic>)ViewBag.Report13).Count() == 5))
            {
                decimal percentage = (((ViewBag.Report13)[0].TOTAL_PENDENCY + (ViewBag.Report13)[1].TOTAL_PENDENCY + (ViewBag.Report13)[2].TOTAL_PENDENCY + (ViewBag.Report13)[3].TOTAL_PENDENCY + (ViewBag.Report13)[4].TOTAL_PENDENCY) * 100 / (ViewBag.Report12).TOTAL_PENDENCY);

                <p>

                    <strong>4 &nbsp; Refund:</strong>As per norms, refund is to be finalized within three months of its receipt. However, <strong>@Html.Raw(ViewBag.Report12.TOTAL_PENDENCY) cases (Refund & rebate)</strong>are pending for more than 3 months.

                    @for (int i = 0; i < 5; i++)
                    {
                        @((ViewBag.Report13)[i].ZONE_NAME)  <strong>(@((ViewBag.Report13)[i].TOTAL_PENDENCY)),</strong>

                    }


                    zones account for <strong> @(Math.Round(percentage, 2))%</strong> of this pendency.
                </p>

            }

            @if (ViewBag.Report14 != null) 
            {
                <p>
                    <strong>5 &nbsp; Provisional Assessment: @Html.Raw(ViewBag.Report14.CLOSING_NO)</strong> assessments are pending finalization. <strong> @Html.Raw(ViewBag.Report14.PENDENCY_TOTAL) cases </strong>are pending for more than six months.
                </p>
            }



            <br />
        </div>



        <br />
        <br />
        <br />


        <div align="right">
            <ul class="pagination" style="background-color:gray;">
                <li><a href="javascript:void(0);" class="link 1">1</a></li>
                <li><a href="javascript:void(0);" class="link 2">2</a></li>
                <li><a href="javascript:void(0);" class="link 3">3</a></li>
            </ul>
        </div>
              }

        else
        {
            <table class="report_body">
                <tr>
                    <th align="center">
                        <h1 style="color:red;">no record found !</h1>
                    </th>
                </tr>
            </table>
        }

    </div>


</body>
</html>
