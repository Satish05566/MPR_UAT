@{
    Layout = null;
}

@{

    int addtion = 0;
    int reduction = 0;
    int closing_no_c = 0;
    int closing_no_P = 0;
    decimal closing_amt_c = 0;
    decimal closing_amt_P = 0;

    string addt = "addition of";
    string reduc = "reduction of";

    string inc = "increased.";
    string dec = "decreased.";

    int No_OF_CASES_P = 0;
    int No_OF_CASES_C = 0;
    decimal Amnt_P = 0;
    decimal Amnt_C = 0;
    List<MIS.Models.SP_MSR_DPM_CUS_13_1_Result> DPM_CUS_1A_1 = ViewBag.DPM_CUS_1A_1;
    if (DPM_CUS_1A_1.Count != 0 && DPM_CUS_1A_1.Count > 1)
    {
        No_OF_CASES_P = Convert.ToInt32(DPM_CUS_1A_1[0].TOTAL_CLOSING_NO);
        No_OF_CASES_C = Convert.ToInt32(DPM_CUS_1A_1[1].TOTAL_CLOSING_NO);
        Amnt_P = DPM_CUS_1A_1[0].TOTAL_CLOSING_AMT.Value;
        Amnt_C = DPM_CUS_1A_1[1].TOTAL_CLOSING_AMT.Value;
        if (No_OF_CASES_C > No_OF_CASES_P)
        {
            addtion = No_OF_CASES_C - No_OF_CASES_P;
        }
        else
        {
            reduction = No_OF_CASES_P - No_OF_CASES_C;
        }
    }

}




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

    <script src="~/Scripts/jquery-1.8.2.min.js"></script>

    <script src="~/Scripts/Sort.js" type="text/javascript"></script>
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





    <title>MSR-DPM-CUS-13</title>
</head>
<body>

    <div id="Report_main">

        <table>
            @if (
                 ((ViewBag.DPM_CUS_1A_1) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_1A_1).Count() > 0)) &&
                 ((ViewBag.DPM_CUS_1A_1_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_1A_1_2).Count() > 0)) &&
                 ((ViewBag.DPM_CUS_3) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_3).Count() > 0)) &&
                 ((ViewBag.DPM_CUS_1A_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_1A_2).Count() > 0)) &&
                 ((ViewBag.DPM_CUS_1A_3) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_1A_3).Count() > 0)) &&
                 ((ViewBag.DPM_CUS_4) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_4).Count() > 0)) &&
                 ((ViewBag.DPM_CUS_5A) != null) &&
                 ((ViewBag.DPM_CUS_3B) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_3B).Count() > 0)) &&
                 ((ViewBag.DPM_CUS_3A_2_1) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_3A_2_1).Count() > 0)) &&
                 ((ViewBag.DPM_CUS_2_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_2_2).Count() > 0))
                )
            {
                <tr>
                    <td>
                        @if (
                            (Convert.ToInt32((ViewBag.DPM_CUS_1A_1)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CUS_1A_1)[0].COMPLETE_COMM)) ||
                            (Convert.ToInt32((ViewBag.DPM_CUS_1A_1_2)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CUS_1A_1_2)[0].COMPLETE_COMM)) ||
                            (Convert.ToInt32((ViewBag.DPM_CUS_3)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CUS_3)[0].COMPLETE_COMM)) ||
                            (Convert.ToInt32((ViewBag.DPM_CUS_1A_2)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CUS_1A_2)[0].COMPLETE_COMM)) ||
                            (Convert.ToInt32((ViewBag.DPM_CUS_1A_3)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CUS_1A_3)[0].COMPLETE_COMM)) ||
                            (Convert.ToInt32((ViewBag.DPM_CUS_4)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CUS_4)[0].COMPLETE_COMM)) ||
                            (Convert.ToInt32((ViewBag.DPM_CUS_5A).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CUS_5A).COMPLETE_COMM)) ||
                            (Convert.ToInt32((ViewBag.DPM_CUS_3B)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CUS_3B)[0].COMPLETE_COMM)) ||
                            (Convert.ToInt32((ViewBag.DPM_CUS_3A_2_1)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CUS_3A_2_1)[0].COMPLETE_COMM)) ||
                            (Convert.ToInt32((ViewBag.DPM_CUS_2_2)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CUS_2_2)[0].COMPLETE_COMM))
                            )
                        {
                            <img src="~/images/incomplete.gif" title="@((ViewBag.DPM_CUS_1A_1)[0].COMPLETE_COMM)/@((ViewBag.DPM_CUS_1A_1)[0].TOTAL_COMM)" />
                        }
                        else
                        {
                            <img src="~/images/complete.gif" />
                        }
                        @if (
                            ((ViewBag.DPM_CUS_1A_1)[0].AMND != 0) &&
                            ((ViewBag.DPM_CUS_1A_1_2)[0].AMND != 0) &&
                            ((ViewBag.DPM_CUS_3)[0].AMND != 0) &&
                            ((ViewBag.DPM_CUS_1A_2)[0].AMND != 0) &&
                            ((ViewBag.DPM_CUS_1A_3)[0].AMND != 0) &&
                            ((ViewBag.DPM_CUS_4)[0].AMND != 0) &&
                            ((ViewBag.DPM_CUS_5A)[0].AMND != 0) &&
                            ((ViewBag.DPM_CUS_3B)[0].AMND != 0) &&
                            ((ViewBag.DPM_CUS_3A_2_1)[0].AMND != 0) &&
                            ((ViewBag.DPM_CUS_2_2)[0].AMND != 0)
                            )
                        {
                            <a href="~/Home/CorrectionBackup?MM_YYYY=@ViewBag.MM_YYYY&MPR=DPM-CUS-13" style="color:brown; font-weight:bold;"><img src="~/images/Amended.gif" /></a>
                        }
                    </td>
                    <td style="text-align: center;">
                        <a download='MSR-DPM-CUS-13(@Convert.ToDateTime(ViewBag.MM_YYYY).ToString("MMM-yyyy").ToUpper()).xls' href="#">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a>
                    </td>
                    <td align="right">@DateTime.Now</td>

                </tr>
            }
            <tr>

                <td colspan="3" align="center">

                    <h1> MSR-DPM-CUS-13</h1>
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

        <div class="DPM" id="1">
            @if (((ViewBag.DPM_CUS_1A_1) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_1A_1).Count() == 2)))
            {
                <p>
                    <strong>1. &nbsp; Adjudication:-</strong> As per the MPR, <strong>@No_OF_CASES_C</strong> cases are pending for adjudication involving duty amount<strong> Rs. @Amnt_C Lakhs</strong> at the end of Nov 2016. <strong> @No_OF_CASES_P</strong> cases involving an amount of <strong> Rs. @Amnt_P Lakhs</strong> were pending for adjudication at the end of Oct, 2016. The comparative analysis shows that there is a
                    @if (No_OF_CASES_C > No_OF_CASES_P)
                    {
                        @addt <strong>@addtion </strong>
                    }
                    else
                    {

                        @reduc <strong>@reduction </strong>
                    }




                    cases pending adjudication as
                    compared to previous month. The amount involved has also
                    @if (Amnt_C > Amnt_P)
                    {
                        @inc
                    }
                    else
                    {
                        @dec
                    } The age wise breakup of the cases for the month of @Html.Raw(Convert.ToDateTime((ViewBag.DPM_CUS_1A_1)[0].MM_YYYY).ToString("MMM,yyyy")) and @Html.Raw(Convert.ToDateTime((ViewBag.DPM_CUS_1A_1)[1].MM_YYYY).ToString("MMM,yyyy")) are given below:-
                </p>
            }

            @if (((ViewBag.DPM_CUS_1A_1) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_1A_1).Count() == 2)))
            {
                <table class="Report_body">
                    <tr>
                        <th align="center">

                        </th>
                        <th align="center">
                            No. of cases
                        </th>

                        <th align="center">
                            Amount (Rs. in Lakh)
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

                    @foreach (var item in (List<MIS.Models.SP_MSR_DPM_CUS_13_1_Result>)ViewBag.DPM_CUS_1A_1)
                    {

                        <tr>
                            <th align="center">
                                @(Convert.ToDateTime(item.MM_YYYY).ToString("MMM,yyyy"))
                            </th>
                            <th align="center">@item.TOTAL_CLOSING_NO</th>
                            <th align="center">@item.TOTAL_CLOSING_AMT</th>
                            <td align="center">@item.TOTAL_MONTHS_3_AMT</td>
                            <td align="center">@item.TOTAL_MONTHS_3TO6_AMT</td>
                            <td align="center">@item.TOTAL_MONTHS_6TO12_AMT</td>
                            <td align="center">@item.TOTAL_MONTHS_MORE_YEAR_AMT</td>
                        </tr>
                    }






                </table>
            }
            <br />
            @if (((ViewBag.DPM_CUS_1A_1_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_1A_1_2).Count() == 2)))
            {
                <p>
                    <strong>1.1</strong> The distribution of pendency of case before various adjudicating authorities for the period @(Convert.ToDateTime((ViewBag.DPM_CUS_1A_1_2)[0].MM_YYYY).ToString("MMM yyyy")) and @(Convert.ToDateTime((ViewBag.DPM_CUS_1A_1_2)[1].MM_YYYY).ToString("MMM yyyy")) respectively, are as under:-
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

                    <tr>
                        <th align="center" rowspan="3">@(Convert.ToDateTime((ViewBag.DPM_CUS_1A_1_2)[0].MM_YYYY).ToString("MMM,yyyy"))</th>
                        <td align="center">Commissioner</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[0].COMM_CLOSING_NO)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[0].PERCEN_COMM_NO, 2))%</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[0].COMM_CLOSING_AMT)</td>
                        <td align="center">@(Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[0].PERCEN_COMM_AMT, 2)))%</td>
                    </tr>


                    <tr>
                        <td align="center">Addl./Jt.Commr</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[0].JC_CLOSING_NO)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[0].PERCEN_JC_NO, 2))%</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[0].JC_CLOSING_AMT)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[0].PERCEN_JC_AMT, 2))%</td>
                    </tr>

                    <tr>
                        <td align="center">DC/AC</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[0].AC_CLOSING_NO)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[0].PERCEN_AC_NO, 2))%</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[0].AC_CLOSING_AMT)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[0].PERCEN_AC_AMT, 2))%</td>
                    </tr>


                    <tr>
                        <th align="center" rowspan="3">@(Convert.ToDateTime((ViewBag.DPM_CUS_1A_1_2)[1].MM_YYYY).ToString("MMM,yyyy"))</th>
                        <td align="center">Commissioner</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[1].COMM_CLOSING_NO)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[1].PERCEN_COMM_NO, 2))%</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[1].COMM_CLOSING_AMT)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[1].PERCEN_COMM_AMT, 2))%</td>
                    </tr>


                    <tr>
                        <td align="center">Addl./Jt.Commr</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[1].JC_CLOSING_NO)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[1].PERCEN_JC_NO, 2))%</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[1].JC_CLOSING_AMT)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[1].PERCEN_JC_AMT, 2))%</td>
                    </tr>

                    <tr>
                        <td align="center">DC/AC</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[1].AC_CLOSING_NO)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[1].PERCEN_AC_NO, 2))%</td>
                        <td align="center">@((ViewBag.DPM_CUS_1A_1_2)[1].AC_CLOSING_AMT)</td>
                        <td align="center">@Html.Raw(Math.Round((ViewBag.DPM_CUS_1A_1_2)[1].PERCEN_AC_AMT, 2))%</td>
                    </tr>



                </table>
            }
            <br />
            @if (((ViewBag.DPM_CUS_3) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_3).Count() == 2)))
            {
                int close_no_c = 0;
                int close_no_P = 0;
                decimal close_amt_c = 0;
                decimal close_amt_P = 0;
                string incs = "increased";
                string decs = "decreased";

                close_no_c = Convert.ToInt32((ViewBag.DPM_CUS_3)[1].CLOSING_NO);
                close_no_P = Convert.ToInt32((ViewBag.DPM_CUS_3)[0].CLOSING_NO);
                close_amt_c = Convert.ToDecimal(((ViewBag.DPM_CUS_3)[1].CLOSING_AMT));
                close_amt_P = Convert.ToDecimal((ViewBag.DPM_CUS_3)[0].CLOSING_AMT);
                <p>
                    <strong>1.2 &nbsp; </strong> As regards the  <strong>cases involving duty amount of Rs. 1 Crore & above,</strong> the total pendency, has
                    @if (close_no_c > close_no_P)
                    {
                        @incs
                    }
                    else
                    {

                        @decs
                    }
                    to <strong>@((ViewBag.DPM_CUS_3)[1].CLOSING_NO) cases</strong> as compared to <strong>@((ViewBag.DPM_CUS_3)[0].CLOSING_NO) cases</strong> last month and similarly, amount involved has also
                    @if (close_amt_c > close_amt_P)
                    {
                        @incs
                    }
                    else
                    {

                        @decs
                    }.
                </p>
            }
            @if (((ViewBag.DPM_CUS_3) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_3).Count() == 2)))
            {
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
                    @foreach (var item in ViewBag.DPM_CUS_3)
                    {
                        <tr>
                            <th align="center">@(Convert.ToDateTime(item.MM_YYYY).ToString("MMM,yyyy"))</th>
                            <th align="center">@item.CLOSING_NO</th>
                            <th align="center">@item.CLOSING_AMT</th>
                            <th align="center">@item.YEAR_1</th>
                            <th align="center">@item.YEARS_1TO2</th>
                            <th align="center">@item.YEARS_2TO3</th>
                            <th align="center">@item.MORE_THAN_3</th>
                        </tr>
                    }



                </table>

                <p>However, <strong>@((ViewBag.DPM_CUS_3)[1].YEARS_1TO2 + (ViewBag.DPM_CUS_3)[1].YEARS_2TO3 + (ViewBag.DPM_CUS_3)[1].MORE_THAN_3)</strong> cases are pending for more than one year as compared to <strong>@((ViewBag.DPM_CUS_3)[0].YEARS_1TO2 + (ViewBag.DPM_CUS_3)[0].YEARS_2TO3 + (ViewBag.DPM_CUS_3)[0].MORE_THAN_3)</strong> in @(Convert.ToDateTime((ViewBag.DPM_CUS_3)[0].MM_YYYY).ToString("MMM,yyyy")).</p>
            }
        </div>


        <div class="DPM" id="2" hidden>

           
            @if (((ViewBag.DPM_CUS_1A_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_1A_2).Count()>4)) && ((ViewBag.DPM_CUS_1A_3) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_1A_3).Count() == 5)))
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
                            @(Convert.ToDateTime((ViewBag.DPM_CUS_1A_2)[0].MM_YYYY).ToString("MMM,yyyy"))
                        </th>

                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.DPM_CUS_1A_3)[0].MM_YYYY).ToString("MMM,yyyy"))
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
                            <th align="center">@((ViewBag.DPM_CUS_1A_2)[i].S_NO) </th>
                            <td align="center">@((ViewBag.DPM_CUS_1A_2)[i].ZONE_NAME) </td>
                            <td align="center">@((ViewBag.DPM_CUS_1A_2)[i].PENDENCY) </td>
                            <td align="center">@((ViewBag.DPM_CUS_1A_3)[i].ZONE_NAME) </td>
                            <td align="center">@((ViewBag.DPM_CUS_1A_3)[i].PENDENCY)  </td>
                        </tr>


                    }

                </table>
            }
            @if ((ViewBag.DPM_CUS_1A_3) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_1A_3).Count() == 5))
            {
                <p>As evident from the table above @((ViewBag.DPM_CUS_1A_3)[0].ZONE_NAME) tops the table with <strong>@((ViewBag.DPM_CUS_1A_3)[0].PENDENCY) cases</strong> followed by @((ViewBag.DPM_CUS_1A_3)[1].ZONE_NAME) with <strong>@((ViewBag.DPM_CUS_1A_3)[1].PENDENCY) cases. </strong> @((ViewBag.DPM_CUS_1A_3)[2].ZONE_NAME) zone is at 3rd place with <strong>@((ViewBag.DPM_CUS_1A_3)[2].PENDENCY) cases.</strong></p>
            }
            <br />

            
            @if (((ViewBag.DPM_CUS_2_1) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_2_1).Count()>4)) && ((ViewBag.DPM_CUS_2_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_2_2).Count() == 5)))
            {
                <p>
                <strong>2.2 &nbsp; </strong> The top five zones in the category of pending total number of <strong>cases involving duty of Rs. 1 Crore & above </strong> are as under:
            </p>
                <table class="Report_body">
                    <tr>
                        <th align="center" rowspan="2">
                            Sr. No.
                        </th>
                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.DPM_CUS_2_1)[0].MM_YYYY).ToString("MMM,yyyy"))
                        </th>

                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.DPM_CUS_2_2)[0].MM_YYYY).ToString("MMM,yyyy"))
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
                            <th align="center">@((ViewBag.DPM_CUS_2_1)[i].S_NO) </th>
                            <td align="center">@((ViewBag.DPM_CUS_2_1)[i].ZONE_NAME) </td>
                            <td align="center">@((ViewBag.DPM_CUS_2_1)[i].PENDENCY) </td>
                            <td align="center">@((ViewBag.DPM_CUS_2_2)[i].ZONE_NAME) </td>
                            <td align="center">@((ViewBag.DPM_CUS_2_2)[i].PENDENCY)  </td>
                        </tr>


                    }
                </table>
            }
            @if (((ViewBag.DPM_CUS_2_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_2_2).Count() == 2)))
            {
                <p>From the above table, @((ViewBag.DPM_CUS_2_2)[0].ZONE_NAME) zone is at the top of the table followed by @((ViewBag.DPM_CUS_2_2)[1].ZONE_NAME), @((ViewBag.DPM_CUS_2_2)[2].ZONE_NAME), @((ViewBag.DPM_CUS_2_2)[3].ZONE_NAME) & @((ViewBag.DPM_CUS_2_2)[4].ZONE_NAME) at No. 2,3,4, & 5 respectively</p>
            }
        </div>


        <div class="DPM" id="3" hidden>
            @if (((ViewBag.DPM_CUS_3A_1) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_3A_1).Count() > 0)))
            {
                <p>
                    <strong>3 &nbsp;  Call Book Cases:</strong> The total number of cases pending in Call Book in @(Convert.ToDateTime((ViewBag.DPM_CUS_3A_1)[0].CURR_MONTH).ToString("MMM,yyyy")), is <strong> @((ViewBag.DPM_CUS_3A_1)[0].CURR_TOTAL_CLOSING) cases</strong> as compared to <strong> @((ViewBag.DPM_CUS_3A_1)[0].PRE_TOTAL_CLOSING) cases </strong>in @(Convert.ToDateTime((ViewBag.DPM_CUS_3A_1)[0].PRE_MONTH).ToString("MMM,yyyy")). The top five zones having high pendency are as under :-
                </p>
            }
            @if (((ViewBag.DPM_CUS_3A_2_1) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_3A_2_1).Count()>4)) && ((ViewBag.DPM_CUS_3A_2_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_3A_2_2).Count() == 5)))
            {
                <table class="Report_body">
                    <tr>
                        <th align="center" rowspan="2">
                            Sr. No.
                        </th>
                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.DPM_CUS_3A_2_1)[0].MM_YYYY).ToString("MMM,yyyy"))
                        </th>

                        <th align="center" colspan="2">
                            @(Convert.ToDateTime((ViewBag.DPM_CUS_3A_2_2)[0].MM_YYYY).ToString("MMM,yyyy"))
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
                            <th align="center">@((ViewBag.DPM_CUS_3A_2_1)[i].S_NO) </th>
                            <td align="center">@((ViewBag.DPM_CUS_3A_2_1)[i].ZONE_NAME) </td>
                            <td align="center">@((ViewBag.DPM_CUS_3A_2_1)[i].PENDENCY) </td>
                            <td align="center">@((ViewBag.DPM_CUS_3A_2_2)[i].ZONE_NAME) </td>
                            <td align="center">@((ViewBag.DPM_CUS_3A_2_2)[i].PENDENCY)  </td>
                        </tr>


                    }
                </table>
            }
            @if (((ViewBag.DPM_CUS_3B) != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_3B).Count() > 0))
            {
                <p>The analysis shows that the maximum number of cases viz. <strong>@((ViewBag.DPM_CUS_3B)[0].DEPT_NOC_1) cases</strong> pending pertain to the category where the Department has gone in appeal. This is followed by <strong>@((ViewBag.DPM_CUS_3B)[0].OBJECTIONS_NOC_2) cases</strong> based on CERA objection. <strong>@((ViewBag.DPM_CUS_3B)[0].OBJECTIONS_NOC_3)</strong> cases were pending during @(Convert.ToDateTime((ViewBag.DPM_CUS_3B)[0].MM_YYYY_P).ToString("MMM,yyyy")) which have reduced to <strong>@((ViewBag.DPM_CUS_3B)[0].OBJECTIONS_NOC_2)</strong>.  <strong>@((ViewBag.DPM_CUS_3B)[0].SPEC_NOC_4)</strong> cases have been shown pending as cases where Board has specifically ordered the case to be kept in call book.</p>
            }
            <br />
            @if (((ViewBag.DPM_CUS_4) != null) && (((IEnumerable<dynamic>)ViewBag.DPM_CUS_4).Count() == 7))
            {
                decimal Pecentage = 0; if (((ViewBag.DPM_CUS_4)[6].MORE_3_MONTHS) != 0) { Pecentage = (((ViewBag.DPM_CUS_4)[5].MORE_3_MONTHS) / (((ViewBag.DPM_CUS_4)[6].MORE_3_MONTHS)) * 100); }
                <p>
                    <strong>4 &nbsp; Refund:</strong> As per norms, refund is to be finalized within three months of its receipt. However, <strong>@((ViewBag.DPM_CUS_4)[6].MORE_3_MONTHS) cases (Refund)</strong> are pending for more than 3 months. @((ViewBag.DPM_CUS_4)[0].ZONE_NAME) <strong>(@((ViewBag.DPM_CUS_4)[0].MORE_3_MONTHS)),</strong> @((ViewBag.DPM_CUS_4)[1].ZONE_NAME) <strong>(@((ViewBag.DPM_CUS_4)[1].MORE_3_MONTHS))</strong>, @((ViewBag.DPM_CUS_4)[2].ZONE_NAME) <strong>(@((ViewBag.DPM_CUS_4)[2].MORE_3_MONTHS)),</strong> @((ViewBag.DPM_CUS_4)[3].ZONE_NAME) <strong>(@((ViewBag.DPM_CUS_4)[3].MORE_3_MONTHS))</strong> & @((ViewBag.DPM_CUS_4)[4].ZONE_NAME) <strong>(@((ViewBag.DPM_CUS_4)[4].MORE_3_MONTHS))</strong> zones account for <strong>@(Math.Round(Pecentage, 2)) %</strong> of this pendency.
                </p>
            }
            @if (((ViewBag.DPM_CUS_5A) != null))
            {
                <p>
                    <strong>5 &nbsp; Provisional Assessment: @ViewBag.DPM_CUS_5A.CLOSING_NO</strong> assessments are pending finalization.<strong> @ViewBag.DPM_CUS_5A.MORE_6_MONTH_PENDENCY cases</strong> are pending for more than six months.
                </p>
            }
            <br />
        </div>


        <br />
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
