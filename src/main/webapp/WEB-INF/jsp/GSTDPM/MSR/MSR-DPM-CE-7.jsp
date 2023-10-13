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
            margin:auto;
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




    @*AMIT CODE*@

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
    <script src="~/Scripts/jquery-1.8.2.js"></script>
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





    <title>MSR-DPM-CE-7</title>
</head>
<body>

    <div id="Report_main">
        <table>
            @if (
                    (ViewBag.DPM_CE_7_1) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_1).Count() > 0) &&
                    (ViewBag.DPM_CE_7_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_2).Count() > 0) &&
                    (ViewBag.DPM_CE_7_3) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_3).Count() > 0) &&
                    ((ViewBag.DPM_CE_7_4C) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_4C).Count()==5)&&
                    (ViewBag.DPM_CE_7_4P) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_4P).Count()==5)&&
                    (ViewBag.DPM_CE_7_5C) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_5C).Count()==5)&&
                    (ViewBag.DPM_CE_7_5P) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_5P).Count()==5)&&
                    (ViewBag.DPM_CE_7_6_ALL) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_6_ALL).Count() > 0) &&
                    (ViewBag.DPM_CE_7_6C) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_6C).Count()==5)&&
                    (ViewBag.DPM_CE_7_6P) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_6P).Count()==5)&&
                    (ViewBag.DPM_CE_7_6_3B_ALL) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_6_3B_ALL).Count() > 0) &&
                    (ViewBag.DPM_CE_7_7_ALL) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_7_ALL).Count() > 0) &&
                    (ViewBag.DPM_CE_7_7_ZONE) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_7_ZONE).Count() == 5) &&
                    (ViewBag.DPM_CE_7_8) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_8).Count() > 0) &&
                    (ViewBag.DPM_CE_7_9) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_9).Count() > 0))
                    )
            {
                <tr>
                    <td>
                        @if (
                                (Convert.ToInt32((ViewBag.DPM_CE_7_1)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_1)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_2)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_2)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_3)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_3)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_4C)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_4C)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_4P)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_4P)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_5C)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_5C)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_5P)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_5P)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_6_ALL)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_6_ALL)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_6C)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_6C)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_6P)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_6P)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_6_3B_ALL)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_6_3B_ALL)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_7_ALL)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_7_ALL)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_7_ZONE)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_7_ZONE)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_8)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_8)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_7_9)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_7_9)[0].COMPLETE_COMM))
                                )
                                {
                                    <img src="~/images/incomplete.gif" title="@((ViewBag.DPM_CE_7_1)[0].COMPLETE_COMM)/@((ViewBag.DPM_CE_7_1)[0].TOTAL_COMM)" />
                                }
                                        else
                                        {
                                            <img src="~/images/complete.gif" />

                                        }
                        @if (
                                ((ViewBag.DPM_CE_7_1)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_2)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_3)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_4C)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_4P)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_5C)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_5P)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_6_ALL)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_6C)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_6P)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_6_3B_ALL)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_7_ALL)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_7_ZONE)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_8)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_7_9)[0].AMND != 0)

                                )
                            
                        {
                            <a href="~/Home/CorrectionBackup?MM_YYYY=@ViewBag.MM_YYYY&MPR=DPM-CE-7" style="color:brown; font-weight:bold;"><img src="~/images/Amended.gif" /></a>
                        }
                    </td>
                    <td style="text-align: center;">
                        <a download='MSR-DPM-CE-7(@Convert.ToDateTime(ViewBag.MM_YYYY).ToString("MMM-yyyy").ToUpper()).xls' href="#">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a>
                    </td>
                    <td align="right">@DateTime.Now</td>

                </tr>
            }
            <tr>

                <td colspan="3" align="center">

                    <h1>MSR-DPM-CE-7</h1>
                    <h2>COMPARATIVE ANALYSIS OF THE MPR REPORTS IN RESPECT OF KEY PERFORMANCE AREAS</h2>
                    @*@{string display = string.Empty;}
                        @if (ViewContext.RouteData.Values["Order"].ToString() == "ASC")
                        {
                            display = "ASCENDING";
                        }

                        else if (ViewContext.RouteData.Values["Order"].ToString() == "DSC")
                        {
                            display = "DESCENDING";
                        }*@

                    @*<h2> ADJUDICATION CASES IN @display  ORDER  ON THE BASIS OF CLOSING BALANCE</h2>
                        <h2> ADJUDICATING AUTHORITY:ADC/JC</h2>*@
                </td>

            </tr>


            <tr>
                <td align="left">
                    <br /> <h2>MONTH : </h2>
                </td>

                <td></td>
                <td></td>
            </tr>

            @*<tr>

                <td align="center" colspan="3">
                        <div>
                            <b>@Html.RadioButton("rdOrder", "DSC", isChecked: true)@Html.Label("DESCENDING")</b>
                            <b> @Html.RadioButton("rdOrder", "ASC", isChecked: false)@Html.Label("ASCENDING")</b>

                        </div>


                    </td>

                </tr>*@





        </table>

        <br />
        @*@if (Model != null && Model.Count > 1)
              {




                 <a id="back_lnk" href='/DPM/MSR/MSR_DPM_CE_1AC/All/0/All%20India/@ViewContext.RouteData.Values["MM_YYYY"].ToString()/ DESC'>Back</a>

            }
                 else
            {
                <table class="Report_body">
                    <tr>
                        <th align="center">
                            <h1 style="color:red;">No Record Found !</h1>
                        </th>
                    </tr>
                </table>
            }
        *@

        <div class="DPM" id="1" style="width:100%;   ">
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

            @if ((ViewBag.DPM_CE_7_1 != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_1).Count() > 0))
            {
                closing_no_c = Convert.ToInt32((ViewBag.DPM_CE_7_1)[0].TOTAL_CLOSING_NO_C);
                closing_no_P = Convert.ToInt32((ViewBag.DPM_CE_7_1)[0].TOTAL_CLOSING_NO_P);
                closing_amt_c = Convert.ToDecimal((ViewBag.DPM_CE_7_1)[0].TOTAL_CLOSING_AMT_C);
                closing_amt_P = Convert.ToDecimal((ViewBag.DPM_CE_7_1)[0].TOTAL_CLOSING_AMT_P);

                if (closing_no_c > closing_no_P)
                {
                    addtion = closing_no_c - closing_no_P;
                }
                else
                {
                    reduction = closing_no_P - closing_no_c;
                }
                <p>
                    <strong>1. &nbsp; Adjudication:-</strong> As per the  MPR, <strong>@closing_no_c </strong>cases are pending for adjudication involving duty amount <strong>Rs.@closing_amt_c Lakhs </strong>at the end of @Html.Raw(Convert.ToDateTime((ViewBag.DPM_CE_7_1)[0].MM_YYYY).ToString("MMM,yyyy").ToUpper()). <strong>@closing_no_P</strong> cases involving an amount of <strong>Rs. @closing_amt_P Lakhs</strong> were pending for adjudication at the end of @Html.Raw(Convert.ToDateTime((ViewBag.DPM_CE_7_1)[0].MM_YYYY_P).ToString("MMM,yyyy").ToUpper()).
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


                    The age wise breakup of the cases for the month of  @Html.Raw(Convert.ToDateTime((ViewBag.DPM_CE_7_1)[0].MM_YYYY_P).ToString("MMM,yyyy")) and @Html.Raw(Convert.ToDateTime((ViewBag.DPM_CE_7_1)[0].MM_YYYY).ToString("MMM,yyyy")) are given below:-
                </p>



                <table class="Report_body">
                    <tr>
                        <th align="center">

                        </th>
                        <th align="center">
                            No. of cases
                        </th>

                        <th align="center">
                            Amount (Rs. in Lakhs)
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


                    @foreach (var r in ViewBag.DPM_CE_7_1)
                    {


                        <tr>
                            <th align="center">@(Convert.ToDateTime(r.MM_YYYY_P).ToString("MMM,yyyy"))</th>
                            <th align="center">@r.TOTAL_CLOSING_NO_P</th>
                            <th align="center">@r.TOTAL_CLOSING_AMT_P</th>
                            <td align="center">@r.TOTAL_MONTHS_3_AMT_P</td>
                            <td align="center">@r.TOTAL_MONTHS_3TO6_AMT_P</td>
                            <td align="center">@r.TOTAL_MONTHS_6TO12_AMT_P</td>
                            <td align="center">@r.TOTAL_MORE_YEAR_AMT_P</td>
                        </tr>


                        <tr>
                            <th align="center">@(Convert.ToDateTime(r.MM_YYYY).ToString("MMM,yyyy"))</th>
                            <th align="center">@r.TOTAL_CLOSING_NO_C</th>
                            <th align="center">@r.TOTAL_CLOSING_AMT_C</th>
                            <td align="center">@r.TOTAL_MONTHS_3_AMT_C</td>
                            <td align="center">@r.TOTAL_MONTHS_3TO6_AMT_C</td>
                            <td align="center">@r.TOTAL_MONTHS_6TO12_AMT_C</td>
                            <td align="center">@r.TOTAL_MORE_YEAR_AMT_C</td>
                        </tr>


                    }
                </table>
            }

            <br />


            @if ((ViewBag.DPM_CE_7_2 != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_2).Count() > 0))
            {
                <p>
                    <strong>1.1</strong> The distribution of pendency of cases before various adjudicating authorities for the period of @(Convert.ToDateTime((ViewBag.DPM_CE_7_2)[0].MM_YYYY_P).ToString("MMM yyyy")) and @(Convert.ToDateTime((ViewBag.DPM_CE_7_2)[0].MM_YYYY).ToString("MMM yyyy")) respectively, are as under:-
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
                            Amount (Rs. in Lakhs)
                        </th>

                        <th align="center">
                            % age
                        </th>

                    </tr>


                    @foreach (var r in ViewBag.DPM_CE_7_2)
                    {


                        <tr>
                            <th align="center" rowspan="4"> @(Convert.ToDateTime(r.MM_YYYY_P).ToString("MMM,yyyy")) </th>
                            <td align="center">Commissioner</td>
                            <td align="center">@r.COMM_CLOSING_NO_P</td>
                            <td align="center">@r.COMM_CLOSING_NO_CERCENT_P %</td>
                            <td align="center">@r.COMM_CLOSING_AMT_P</td>
                            <td align="center">@r.COMM_CLOSING_AMT_CERCENT_P %</td>
                        </tr>

                        <tr>
                            <td align="center">Addl./Jt.Commr</td>
                            <td align="center">@r.JC_CLOSING_NO_P</td>
                            <td align="center">@r.JC_CLOSING_NO_CERCENT_P %</td>
                            <td align="center">@r.JC_CLOSING_AMT_P</td>
                            <td align="center">@r.JC_CLOSING_AMT_CERCENT_P %</td>
                        </tr>

                        <tr>
                            <td align="center">DC/AC</td>
                            <td align="center">@r.AC_CLOSING_NO_P</td>
                            <td align="center">@r.AC_CLOSING_NO_CERCENT_P %</td>
                            <td align="center">@r.AC_CLOSING_AMT_P</td>
                            <td align="center">@r.AC_CLOSING_AMT_CERCENT_P %</td>
                        </tr>

                        <tr>
                            <td align="center">Supdts</td>
                            <td align="center">@r.SUP_CLOSING_NO_P</td>
                            <td align="center">@r.SUP_CLOSING_NO_CERCENT_P %</td>
                            <td align="center">@r.SUP_CLOSING_AMT_P</td>
                            <td align="center">@r.SUP_CLOSING_AMT_CERCENT_P %</td>
                        </tr>


                        <tr>
                            <th align="center" rowspan="4">@(Convert.ToDateTime(r.MM_YYYY).ToString("MMM,yyyy"))</th>
                            <td align="center">Commissioner</td>
                            <td align="center">@r.COMM_CLOSING_NO_C</td>
                            <td align="center">@r.COMM_CLOSING_NO_CERCENT_C %</td>
                            <td align="center">@r.COMM_CLOSING_AMT_C</td>
                            <td align="center">@r.COMM_CLOSING_AMT_CERCENT_C %</td>
                        </tr>

                        <tr>
                            <td align="center">Addl./Jt.Commr</td>
                            <td align="center">@r.JC_CLOSING_NO_C</td>
                            <td align="center">@r.JC_CLOSING_NO_CERCENT_C %</td>
                            <td align="center">@r.JC_CLOSING_AMT_C</td>
                            <td align="center">@r.JC_CLOSING_AMT_CERCENT_C %</td>
                        </tr>

                        <tr>
                            <td align="center">DC/AC</td>
                            <td align="center">@r.AC_CLOSING_NO_C</td>
                            <td align="center">@r.AC_CLOSING_NO_CERCENT_C %</td>
                            <td align="center">@r.AC_CLOSING_AMT_C</td>
                            <td align="center">@r.AC_CLOSING_AMT_CERCENT_C %</td>
                        </tr>

                        <tr>
                            <td align="center">Supdts</td>
                            <td align="center">@r.SUP_CLOSING_NO_C</td>
                            <td align="center">@r.SUP_CLOSING_NO_CERCENT_C  %</td>
                            <td align="center">@r.SUP_CLOSING_AMT_C</td>
                            <td align="center">@r.SUP_CLOSING_AMT_CERCENT_C  %</td>
                        </tr>

                    }

                </table>
            }
            <br />


            @if ((ViewBag.DPM_CE_7_3 != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_3).Count() > 0))
            {

                int close_no_c = 0;
                int close_no_P = 0;
                decimal close_amt_c = 0;
                decimal close_amt_P = 0;
                string incs = "increased";
                string decs = "decreased";



                close_no_c = Convert.ToInt32((ViewBag.DPM_CE_7_3)[0].CLOSING_NO_C);
                close_no_P = Convert.ToInt32((ViewBag.DPM_CE_7_3)[0].CLOSING_NO_P);
                close_amt_c = Convert.ToDecimal((ViewBag.DPM_CE_7_3)[0].CLOSING_AMT_C);
                close_amt_P = Convert.ToDecimal((ViewBag.DPM_CE_7_3)[0].CLOSING_AMT_P);
                <p>
                    <strong>1.2 &nbsp; </strong> As regards the <strong>cases involving duty amount of Rs. 1 crore & above, </strong>the total pendency, has
                    @if (close_no_c > close_no_P)
                    {
                        @incs
                    }
                    else
                    {

                        @decs
                    }

                    to  <strong>@((ViewBag.DPM_CE_7_3)[0].CLOSING_NO_C) cases</strong> as compared to <strong>@((ViewBag.DPM_CE_7_3)[0].CLOSING_NO_P) cases</strong> last month and similarly, amount involved has also
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
                            Amt of duty (in Lakhs)
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

                    @foreach (var r in ViewBag.DPM_CE_7_3)
                    {


                        <tr>
                            <th align="center">@(Convert.ToDateTime(r.MM_YYYY_P).ToString("MMM,yyyy"))</th>
                            <th align="center">@r.CLOSING_NO_P</th>
                            <th align="center">@r.CLOSING_AMT_P</th>
                            <td align="center">@r.YEAR_1_P</td>
                            <td align="center">@r.YEARS_1TO2_P</td>
                            <td align="center">@r.YEARS_2TO3_P</td>
                            <td align="center">@r.MORE_THAN_3_P</td>
                        </tr>

                        <tr>
                            <th align="center">@(Convert.ToDateTime(r.MM_YYYY).ToString("MMM,yyyy"))</th>
                            <th align="center">@r.CLOSING_NO_C</th>
                            <th align="center">@r.CLOSING_AMT_C</th>
                            <td align="center">@r.YEAR_1_C</td>
                            <td align="center">@r.YEARS_1TO2_C</td>
                            <td align="center">@r.YEARS_2TO3_C</td>
                            <td align="center">@r.MORE_THAN_3_C</td>

                        </tr>

                    }

                </table>
                <p>
                    However, <strong> @((ViewBag.DPM_CE_7_3)[0].YEARS_1TO2_C + (ViewBag.DPM_CE_7_3)[0].YEARS_2TO3_C + (ViewBag.DPM_CE_7_3)[0].MORE_THAN_3_C)  cases</strong> are pending for more than one year
                    as compared to <strong>@((ViewBag.DPM_CE_7_3)[0].YEARS_1TO2_P + (ViewBag.DPM_CE_7_3)[0].YEARS_2TO3_P + (ViewBag.DPM_CE_7_3)[0].MORE_THAN_3_P)</strong>  @(Convert.ToDateTime((ViewBag.DPM_CE_7_3)[0].MM_YYYY_P).ToString("MMM yyyy")).
                </p>
            }
        </div>


        <div class="DPM" id="2" hidden>

            @if ((ViewBag.DPM_CE_7_4C != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_4C).Count() == 5) && (ViewBag.DPM_CE_7_4P != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_4P).Count() == 5)) 
            {

                <p>
                    <strong>2.1 &nbsp; </strong> The top five zones in the category of total number of <strong>cases pending for more than one year </strong> are as under:
                </p>

                <table class="Report_body">
                    <tr>
                        <th align="center" rowspan="2">
                            Sr. No.
                        </th>
                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.DPM_CE_7_4P)[0].MM_YYYY_P).ToString("MMM-yyyy"))
                        </th>

                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.DPM_CE_7_4C)[0].MM_YYYY).ToString("MMM-yyyy"))
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
                            <td align="center">@((ViewBag.DPM_CE_7_4P)[i].ZONE_NZME_P) </td>
                            <td align="center">@((ViewBag.DPM_CE_7_4P)[i].TOTAL_PENDENCY_P) </td>
                            <td align="center">@((ViewBag.DPM_CE_7_4C)[i].ZONE_NZME_C) </td>
                            <td align="center">@((ViewBag.DPM_CE_7_4C)[i].TOTAL_PENDENCY_C)  </td>
                        </tr>

                    }

                </table>
                <p>
                    As evident from the table above @((ViewBag.DPM_CE_7_4C)[0].ZONE_NZME_C) tops the table with <strong> @((ViewBag.DPM_CE_7_4C)[0].TOTAL_PENDENCY_C) cases</strong>
                    followed by @((ViewBag.DPM_CE_7_4C)[1].ZONE_NZME_C) with <strong> @((ViewBag.DPM_CE_7_4C)[1].TOTAL_PENDENCY_C) cases. </strong> @((ViewBag.DPM_CE_7_4C)[2].ZONE_NZME_C) zone is at 3rd place with
                    <strong> @((ViewBag.DPM_CE_7_4C)[2].TOTAL_PENDENCY_C) cases.</strong>
                </p>
            }
            <br />

            
            @if ((ViewBag.DPM_CE_7_5C != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_5C).Count() == 5) && (ViewBag.DPM_CE_7_5P != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_5P).Count() == 5)) 
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
                            @(Convert.ToDateTime((ViewBag.DPM_CE_7_5P)[0].MM_YYYY_P).ToString("MMM-yyyy"))
                        </th>

                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.DPM_CE_7_5C)[0].MM_YYYY_C).ToString("MMM-yyyy"))
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
                            <td align="center">@((ViewBag.DPM_CE_7_5P)[i].ZONE_NZME_P) </td>
                            <td align="center">@((ViewBag.DPM_CE_7_5P)[i].TOTAL_PENDENCY_P) </td>
                            <td align="center">@((ViewBag.DPM_CE_7_5C)[i].ZONE_NZME_C) </td>
                            <td align="center">@((ViewBag.DPM_CE_7_5C)[i].TOTAL_PENDENCY_C)  </td>
                        </tr>

                    }


                </table>
                <p>From the above table, @((ViewBag.DPM_CE_7_5C)[0].ZONE_NZME_C) zone is at the top of the table followed by @((ViewBag.DPM_CE_7_5C)[1].ZONE_NZME_C), @((ViewBag.DPM_CE_7_5C)[2].ZONE_NZME_C), @((ViewBag.DPM_CE_7_5C)[3].ZONE_NZME_C) & @((ViewBag.DPM_CE_7_5C)[4].ZONE_NZME_C) at No. 2,3,4, & 5 respectively.</p>
            }
        </div>


        <div class="DPM" id="3" hidden>
            @if ((ViewBag.DPM_CE_7_6_ALL != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_6_ALL).Count() > 0))
            {
                <p>
                    <strong>3 &nbsp;  Call Book Cases:</strong> The total number of cases pending in Call Book in @(Convert.ToDateTime((ViewBag.DPM_CE_7_6_ALL)[0].MM_YYYY).ToString("MMM yyyy")),
                    is <strong>@((ViewBag.DPM_CE_7_6_ALL)[0].TOTAL_CLOSING_C) cases</strong> as compared to <strong> @((ViewBag.DPM_CE_7_6_ALL)[0].TOTAL_CLOSING_P) cases </strong>in @(Convert.ToDateTime((ViewBag.DPM_CE_7_6_ALL)[0].MM_YYYY_P).ToString("MMM yyyy")). The top five zones having high pendency are as under:-
                </p>
            }


            @if ((ViewBag.DPM_CE_7_6C != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_6C).Count() == 5) && (ViewBag.DPM_CE_7_6P != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_6P).Count() == 5))
            {
                <table class="Report_body">
                    <tr>
                        <th align="center" rowspan="2">
                            Sr. No.
                        </th>
                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.DPM_CE_7_6P)[0].MM_YYYY_P).ToString("MMM-yyyy"))
                        </th>

                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.DPM_CE_7_6C)[0].MM_YYYY).ToString("MMM-yyyy"))
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
                            <td align="center">@((ViewBag.DPM_CE_7_6P)[i].ZONE_NZME_P) </td>
                            <td align="center">@((ViewBag.DPM_CE_7_6P)[i].TOTAL_PENDENCY_P) </td>
                            <td align="center">@((ViewBag.DPM_CE_7_6C)[i].ZONE_NZME_C) </td>
                            <td align="center">@((ViewBag.DPM_CE_7_6C)[i].TOTAL_PENDENCY_C)  </td>
                        </tr>

                    }


                </table>
            }

            @if (((ViewBag.DPM_CE_7_6_3B_ALL) != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_6_3B_ALL).Count() > 0))
            {
                <p>
                    The analysis shows that the maximum number of cases viz. <strong>@((ViewBag.DPM_CE_7_6_3B_ALL)[0].DEPT_NOC_1) cases</strong>
                    pending pertain to the category where the Department has gone in appeal.This is followed by <strong>@((ViewBag.DPM_CE_7_6_3B_ALL)[0].OBJECTIONS_NOC_2) cases</strong> based on CERA objection. <strong>@((ViewBag.DPM_CE_7_6_3B_ALL)[0].OBJECTIONS_NOC_3) cases</strong> were pending
                    during @(Convert.ToDateTime((ViewBag.DPM_CE_7_6_3B_ALL)[0].MM_YYYY_P).ToString("MMM,yyyy")) which have reduced to <strong>@((ViewBag.DPM_CE_7_6_3B_ALL)[0].OBJECTIONS_NOC_2)</strong>.
                    <strong>@((ViewBag.DPM_CE_7_6_3B_ALL)[0].SPEC_NOC_4) cases</strong> have been shown pending as cases where Board has specifically ordered the case to be kept in call book.
                </p>
            }



            <br />




            @if ((ViewBag.DPM_CE_7_7_ZONE != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_7_ZONE).Count() == 5))
            {


                decimal percentage = (((ViewBag.DPM_CE_7_7_ZONE)[0].TOTAL_PENDENCY + (ViewBag.DPM_CE_7_7_ZONE)[1].TOTAL_PENDENCY + (ViewBag.DPM_CE_7_7_ZONE)[2].TOTAL_PENDENCY + (ViewBag.DPM_CE_7_7_ZONE)[3].TOTAL_PENDENCY + (ViewBag.DPM_CE_7_7_ZONE)[4].TOTAL_PENDENCY) * 100 / (ViewBag.DPM_CE_7_7_ALL)[0].TOTAL_PENDENCY);



                <p>
                    <strong>4 &nbsp; Refund & Rebate: </strong>As per norms, refund/rebate is to be finalized within three months of its receipt.  However, <strong>
                        @((ViewBag.DPM_CE_7_7_ALL)[0].TOTAL_PENDENCY) cases (Refund & rebate)
                    </strong> are pending for more than 3 months. @((ViewBag.DPM_CE_7_7_ZONE)[0].ZONE_NAME) <strong> (@((ViewBag.DPM_CE_7_7_ZONE)[0].TOTAL_PENDENCY)), </strong>@((ViewBag.DPM_CE_7_7_ZONE)[1].ZONE_NAME) <strong> (@((ViewBag.DPM_CE_7_7_ZONE)[1].TOTAL_PENDENCY)), </strong> @((ViewBag.DPM_CE_7_7_ZONE)[2].ZONE_NAME) <strong>(@((ViewBag.DPM_CE_7_7_ZONE)[2].TOTAL_PENDENCY)), </strong>@((ViewBag.DPM_CE_7_7_ZONE)[3].ZONE_NAME) <strong>(@((ViewBag.DPM_CE_7_7_ZONE)[3].TOTAL_PENDENCY))</strong>
                    & @((ViewBag.DPM_CE_7_7_ZONE)[4].ZONE_NAME) <strong>(@((ViewBag.DPM_CE_7_7_ZONE)[4].TOTAL_PENDENCY))</strong> zones account for
                    <strong>  @(Math.Round(percentage, 2))%</strong> of this pendency.
                </p>

            }

            <br />
            @if ((ViewBag.DPM_CE_7_8 != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_8).Count() > 0))
            {
                <p>
                    <strong>5 &nbsp; Provisional Assessment: @((ViewBag.DPM_CE_7_8)[0].CLOSING_NO) </strong>assessments are pending finalization.<strong> @((ViewBag.DPM_CE_7_8)[0].PENDENCY_TOTAL) cases</strong> are pending for more than six months.
                </p>

            }

            <br />
            @if ((ViewBag.DPM_CE_7_9 != null)  && (((IEnumerable<dynamic>)ViewBag.DPM_CE_7_9).Count() > 0))
            {
                <p>
                    <strong>6 &nbsp; Bank Guarantees: </strong>As per the MPR report, <strong> @((ViewBag.DPM_CE_7_9)[0].CLOSING_NO) Bank Guarantees</strong> are available with the department.
                </p>
            }





            <br />
        </div>


        <br />
        <br />
 
    </div>
    <div align="right">
        <ul class="pagination" style="background-color:gray;">
            <li><a href="javascript:void(0);" class="link 1">1</a></li>
            <li><a href="javascript:void(0);" class="link 2">2</a></li>
            <li><a href="javascript:void(0);" class="link 3">3</a></li>
        </ul>
    </div>

</body>
</html>
