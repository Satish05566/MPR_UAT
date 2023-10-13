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
                        background-color: #3B5998;
                    }

                    ul.pagination li a:focus {
                        background-color: #3B5998;
                    }

                    ul.pagination li a:hover:not(.active) {
                        background-color: #3B5998;
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

    <title>MSR-DPM-CE-8</title>
</head>
<body>

    <div id="Report_main">

        @*Header Portion*@

        <table>
            @if (
                    (ViewBag.DPM_CE_8_1) != null &&
                    (ViewBag.DPM_CE_8_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_2).Count() > 0) &&
                    (ViewBag.DPM_CE_8_3) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_3).Count() > 0) &&
                    (ViewBag.DPM_CE_8_4) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_4).Count() > 0) &&
                    (ViewBag.DPM_CE_8_5) != null && 
                    (ViewBag.DPM_CE_8_6) != null && 
                    (ViewBag.DPM_CE_8_7) != null && 
                    (ViewBag.DPM_CE_8_8) != null && 
                    (ViewBag.DPM_CE_8_9) != null &&
                    (ViewBag.DPM_CE_8_10) != null &&
                    (ViewBag.DPM_CE_8_11) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_11).Count() > 0) &&
                    (ViewBag.DPM_CE_8_12) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_12).Count() > 0) &&
                    (ViewBag.DPM_CE_8_13) != null &&
                    (ViewBag.DPM_CE_8_14) != null &&
                    (ViewBag.DPM_CE_8_15) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_15).Count() > 0) &&
                    (ViewBag.DPM_CE_8_16) != null && 
                    (ViewBag.DPM_CE_8_17_REFUND) != null &&
                    (ViewBag.DPM_CE_8_18_REBATE) != null &&
                    (ViewBag.DPM_CE_8_19_REFUND) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_19_REFUND).Count() > 0) &&
                    (ViewBag.DPM_CE_8_20_REBATE) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_20_REBATE).Count() > 0) &&
                    (ViewBag.DPM_CE_8_21) != null &&
                    (ViewBag.DPM_CE_8_22) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_22).Count() > 0) &&
                    (ViewBag.DPM_CE_8_23) != null && 
                    (ViewBag.DPM_CE_8_24) != null  
                    )
            {
                <tr>
                    <td>
                        @if (
                                (Convert.ToInt32((ViewBag.DPM_CE_8_1).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_1).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_2)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_2)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_3)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_3)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_4)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_4)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_5).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_5).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_6).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_6).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_7).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_7).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_8).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_8).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_9).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_9).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_10).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_10).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_11)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_11)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_12)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_12)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_13).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_13).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_14).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_14).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_15)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_15)[0].COMPLETE_COMM))||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_16).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_16).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_17_REFUND).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_17_REFUND).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_18_REBATE).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_18_REBATE).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_19_REFUND)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_19_REFUND)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_20_REBATE)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_20_REBATE)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_21).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_21).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_22)[0].TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_22)[0].COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_23).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_23).COMPLETE_COMM)) ||
                                (Convert.ToInt32((ViewBag.DPM_CE_8_24).TOTAL_COMM) > Convert.ToInt32((ViewBag.DPM_CE_8_24).COMPLETE_COMM))
                            
                                )
                        {
                            <img src="~/images/incomplete.gif" title="@((ViewBag.DPM_CE_8_1).COMPLETE_COMM)/@((ViewBag.DPM_CE_8_1).TOTAL_COMM)" />
                        }
                        else
                        {
                            <img src="~/images/complete.gif" title="@((ViewBag.DPM_CE_8_1).COMPLETE_COMM)/@((ViewBag.DPM_CE_8_1).TOTAL_COMM)" />

                        }
                        @if (
                                ((ViewBag.DPM_CE_8_1).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_2)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_8_3)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_8_4)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_8_5).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_6).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_7).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_8).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_9).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_10).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_11)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_8_12)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_8_13).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_14).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_15)[0].AMND != 0)&&
                                ((ViewBag.DPM_CE_8_16).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_17_REFUND).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_18_REBATE).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_19_REFUND)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_8_20_REBATE)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_8_21).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_22)[0].AMND != 0) &&
                                ((ViewBag.DPM_CE_8_23).AMND != 0) &&
                                ((ViewBag.DPM_CE_8_24).AMND != 0) 

                                )
                        {
                            <a href="~/Home/CorrectionBackup?MM_YYYY=@ViewBag.MM_YYYY&MPR=DPM-CE-8" style="color:brown; font-weight:bold;"><img src="~/images/Amended.gif" /></a>
                        }
                    </td>
                    <td style="text-align: center;">
                        <a download='MSR-DPM-CE-8(@Convert.ToDateTime(ViewBag.MM_YYYY).ToString("MMM-yyyy").ToUpper()).xls' href="#">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a>
                    </td>
                    <td align="right">@DateTime.Now</td>

                </tr>
            }
            

            <tr>
                <td colspan="3" align="center">
                    <h1>MSR-DPM-CE-8 </h1>
                    <h2>COMMENTS AND ANALYSIS</h2>
                   
                </td>
            </tr>

            <tr>
                 <td align="left">
                    <br /> <h2>MONTH : </h2>
                </td>
                
            </tr>

        </table>

       
        @*Body Portion Page 1*@

        <div class="DPM" id="1" style="width:100%;   ">
            @if ((ViewBag.DPM_CE_8_1) != null)
            {
            <table>
                <tr>
                    <td align="left">
                        <h2><u>Details of Adjudication Cases:</u></h2>
                    </td>                                       
                </tr>
                <tr>
                    <td align="left">
                        <h4>(a)&nbsp; All India pendency of adjudication cases: </h4>             
                    </td>
                    <td > </td>
                    <td > </td>
                    <td align="right"><h4>(Amount in Rs. Lakhs)</h4></td>
                                     
                </tr>

            </table>
            

            <table class="Report_body">              
                <tr>                        
                    <th align="center">
                        No. of cases
                    </th>

                    <th align="center">
                        Amount
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
                       
                        <td align="right" width="15%">
                            @Html.Raw(ViewBag.DPM_CE_8_1.TOTAL_CLOSING_NO_C)
                        </td>
                        <td align="right" width="15%">
                            @Html.Raw(ViewBag.DPM_CE_8_1.TOTAL_CLOSING_AMT_C)
                        </td>
                        <td align="right" width="15%">
                            @Html.Raw(ViewBag.DPM_CE_8_1.TOTAL_MONTHS_3_AMT_C)
                        </td>
                        <td align="right" width="15%">
                            @Html.Raw(ViewBag.DPM_CE_8_1.TOTAL_MONTHS_3TO6_AMT_C)
                        </td>
                        <td align="right" width="15%">
                            @Html.Raw(ViewBag.DPM_CE_8_1.TOTAL_MONTHS_6TO12_AMT_C)
                        </td>
                        <td align="right" width="15%">
                            @Html.Raw(ViewBag.DPM_CE_8_1.TOTAL_MORE_YEAR_AMT_C)
                        </td>
                       
                       
                    </tr>


                }  
            </table>

            <p>
                The prescribed time period for disposal of adjudication is 6 months. It is evident that @Html.Raw(ViewBag.DPM_CE_8_1.PERCENTAGE_DISPOSAL)% of cases have not been decided within the time limit of 6 months. Further, @Html.Raw(ViewBag.DPM_CE_8_1.PERCENTAGE_MORE_YEAR)% of the total cases are pending adjudication for more than one year which is very alarming.

            </p>
            }
            
@if (((ViewBag.DPM_CE_8_2) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_2).Count() == 5)))
{
    decimal percentage_no = (((ViewBag.DPM_CE_8_2)[0].TOTAL_PENDENCY_C + (ViewBag.DPM_CE_8_2)[1].TOTAL_PENDENCY_C + (ViewBag.DPM_CE_8_2)[2].TOTAL_PENDENCY_C + (ViewBag.DPM_CE_8_2)[3].TOTAL_PENDENCY_C + (ViewBag.DPM_CE_8_2)[4].TOTAL_PENDENCY_C) * 100 / (ViewBag.DPM_CE_8_1).TOTAL_CLOSING_NO_C);


            <table>
                <tr>
                    <td align="left">
                        <strong>(b)&nbsp; Top 5 Zones with maximum pendency of adjudication cases: </strong>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <h4>&nbsp; &nbsp; &nbsp; &nbsp;(i) @*<u>MSR-DPM-CE-1AA :</u>*@ In terms of numbers:-</h4>
                    </td>   
                </tr>

            </table>
            
            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>

                    <th align="center">
                        ZONE
                    </th>
                    <th align="center">
                        PENDENCY

                    </th>

                </tr>


                @for (int i = 0; i < 5; i++)
                {

                    <tr>
                        <th align="center">@(i + 1)</th>
                        <td align="left">@((ViewBag.DPM_CE_8_2)[i].ZONE_NZME_C) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_2)[i].TOTAL_PENDENCY_C) </td>
                       
                    </tr>

                }

            </table>

            <p>
                
                The top five zones account for 
                <strong> @(Math.Round(percentage_no, 2))%</strong>
                of the total pendency in terms of number of cases pending with them. Therefore, these zones would need to make extra efforts to liquidate the pendency of adjudication.
            </p>
            }
          

      
            @if (((ViewBag.DPM_CE_8_3) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_3).Count() == 5)))
            {
                decimal percentage_amt = (((ViewBag.DPM_CE_8_3)[0].TOTAL_PENDENCY_C + (ViewBag.DPM_CE_8_3)[1].TOTAL_PENDENCY_C + (ViewBag.DPM_CE_8_3)[2].TOTAL_PENDENCY_C + (ViewBag.DPM_CE_8_3)[3].TOTAL_PENDENCY_C + (ViewBag.DPM_CE_8_3)[4].TOTAL_PENDENCY_C) * 100 / (ViewBag.DPM_CE_8_1).TOTAL_CLOSING_AMT_C);

            <table>              
                <tr>
                    <td align="left">
                        <h4>&nbsp; &nbsp; &nbsp; &nbsp;(ii) @*<u>msr-dpm-ce-1af :</u>*@ In terms of amount:-</h4>
                    </td>
                    <td></td>
                    <td></td>
                    <td align="right"><h4>(Amount in Rs. Lakhs)</h4></td>
                </tr>

            </table>           
             <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>

                    <th align="center">
                        ZONE
                    </th>
                    <th align="center">
                        PENDENCY

                    </th>

                </tr>

                @for (int i = 0; i < 5; i++)
                {

                    <tr>
                        <th align="center">@(i + 1)</th>
                        <td align="left">@((ViewBag.DPM_CE_8_3)[i].ZONE_NZME_C) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_3)[i].TOTAL_PENDENCY_C) </td>

                    </tr>

                }
            </table>

            <p>
               
                
                The top five zones account for 
                <strong> @(Math.Round(percentage_amt, 2))%</strong> 
                of the total pendency in terms of amount involved in adjudication. Therefore, these zones would need to make extra efforts to liqidate the pendency of adjudication especoally 
                @((ViewBag.DPM_CE_8_3)[0].ZONE_NZME_C), @((ViewBag.DPM_CE_8_3)[1].ZONE_NZME_C) and @((ViewBag.DPM_CE_8_3)[2].ZONE_NZME_C) 
                who are among the top five in number as well as in amount involved.
            </p>
            }
           
            @if (((ViewBag.DPM_CE_8_4) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_4).Count() == 5)))
            {
            <table>
                <tr>
                    <td align="left">
                        <h4>&nbsp; &nbsp; &nbsp; &nbsp;(iii) @*<u>MSR-DPM-CE-1AA :</u>*@ Cases pending for more than 1 Year:-</h4>
                    </td>                    
                </tr>
            </table>    
           
            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>

                    <th align="center">
                        ZONE
                    </th>
                    <th align="center">
                        PENDENCY

                    </th>

                </tr>


                @for (int i = 0; i < 5; i++)
                {

                    <tr>
                        <th align="center">@(i + 1)</th>
                        <td align="left">@((ViewBag.DPM_CE_8_4)[i].ZONE_NZME_C) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_4)[i].TOTAL_PENDENCY_C) </td>

                    </tr>

                }
            </table>
                      
           }
         
         </div>           
        @*Body Portion Page 2*@


        <div class="DPM" id="2" hidden>
            @if ((ViewBag.DPM_CE_8_5) != null)
            {
            <table>
                <tr>
                    <td align="left">
                        <h4>(c) &nbsp; Distribution of percentage of pendency before various adjudicating authorities in terms of number and amount (on all India basis):</h4>
                    </td>
                </tr>
            </table>    
            
            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>
                    <th align="center">
                        Adjudicating Authority
                    </th>
                    <th align="center">
                        Number
                    </th>
                    <th align="center">
                        Percentage
                    </th>
                    <th align="center">
                        Amount
                    </th>
                    <th align="center">
                        Percentage
                    </th>

                </tr>

                    
                     <tr>
                       
                         <td align="center">1</td>
                         <td align="left">COMMISSIONER</td>
                        <td align="right" width="15%">
                            @Html.Raw(ViewBag.DPM_CE_8_5.COMM_CLOSING_NO_C)
                        </td>
                        <td align="right" width="15%">
                            @Html.Raw(ViewBag.DPM_CE_8_5.COMM_CLOSING_NO_CERCENT_C)%
                        </td>
                        <td align="right" width="15%">
                            @Html.Raw(ViewBag.DPM_CE_8_5.COMM_CLOSING_AMT_C)
                        </td>
                        <td align="right" width="15%">
                            @Html.Raw(ViewBag.DPM_CE_8_5.COMM_CLOSING_AMT_CERCENT_C)%
                        </td>
                       
                       
                    </tr>
                <tr>

                    <td align="center">2</td>
                    <td align="left">ADC/JC</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.JC_CLOSING_NO_C)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.JC_CLOSING_NO_CERCENT_C)%
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.JC_CLOSING_AMT_C)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.JC_CLOSING_AMT_CERCENT_C)%
                    </td>


                </tr>

                <tr>

                    <td align="center">3</td>
                    <td align="left">DC/AC</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.AC_CLOSING_NO_C)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.AC_CLOSING_NO_CERCENT_C)%
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.AC_CLOSING_AMT_C)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.AC_CLOSING_AMT_CERCENT_C)%
                    </td>


                </tr>
                <tr>

                    <td align="center">4</td>
                    <td align="left">SUPERINTENDENT</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.SUP_CLOSING_NO_C)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.SUP_CLOSING_NO_CERCENT_C)%
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.SUP_CLOSING_AMT_C)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_5.SUP_CLOSING_AMT_CERCENT_C)%
                    </td>


                </tr>

            </table>

            <p>
               More than @Html.Raw(ViewBag.DPM_CE_8_5.COMM_CLOSING_AMT_CERCENT_C)% of the cases in terms of amount are pending adjudication at the level of Commissioners.
            </p>

            <p>
               The cases pending for adjudication before ADC/JCs, DCs/ACs and Superintendents account for @Html.Raw(ViewBag.DPM_CE_8_5.PERCENTAGE_TOTAL_PENDENCY_NO)% of the total pendency in terms of number and about @Html.Raw(ViewBag.DPM_CE_8_5.PERCENTAGE_TOTAL_PENDENCY_AMT)% of the pendency in terms of amount. Since, most of the cases before ADC/JCs, DCs/ACs and Superintendents may be of technical nature and involve relatively small amount of duty, these cases can be easily taken up on priority for disposal which would result in reducing the all India pendency by way of number.
            </p>
            }
            
            @if ((ViewBag.DPM_CE_8_6) != null)
            {
            <table>
                <tr>
                    <td align="left">
                        <h4>(d) &nbsp; Disposal of adjudication cases as a percentage of receipt of fresh cases during the month:- @Html.Raw(ViewBag.DPM_CE_8_6.TOTAL_PERCENTAGE)%</h4>
                    </td>                   
                </tr>
            </table>            
            
            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>
                    <th align="center">
                        Authority
                    </th>
                    <th align="center">
                        Receipt
                    </th>
                    <th align="center">
                        Disposal
                    </th>
                    <th align="center">
                        Percentage
                    </th>
                </tr>
                <tr>

                    <td align="center">1</td>
                    <td align="left">COMMISSIONER</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.COMM_RECEIPT_NO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.COMM_DISPOSAL_NO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.COMM_PERCENTAGE)%
                    </td>
                   

                </tr>
                <tr>

                    <td align="center">2</td>
                    <td align="left">ADC/JC</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.JC_RECEIPT_NO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.JC_DISPOSAL_NO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.JC_PERCENTAGE)%
                    </td>

                </tr>
                <tr>

                    <td align="center">3</td>
                    <td align="left">DC/AC</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.AC_RECEIPT_NO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.AC_DISPOSAL_NO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.AC_PERCENTAGE)%
                    </td>


                </tr>
                <tr>

                    <td align="center">4</td>
                    <td align="left">SUPERINTENDENT</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.SUP_RECEIPT_NO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.SUP_DISPOSAL_NO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_6.SUP_PERCENTAGE)%
                    </td>


                </tr>
            </table>
            }
            
            @if ((ViewBag.DPM_CE_8_7) != null)
            {
            <table>
                <tr>
                    <td align="left">
                        <h4>(e) &nbsp; Summary of cases:-</h4>
                    </td>
                </tr>
            </table>    
           
            <table class="Report_body">

                <tr>

                    <td align="center">1</td>
                    <td align="left">OPENING BALANCE ON 01.01.2017</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_7.TOTAL_OPENING_NO)
                    </td>
                    
                </tr>
                <tr>

                    <td align="center">2</td>
                    <td align="left">NUMBER OF CASES RECEIVED OF FOR THE MONTH</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_7.TOTAL_RECEIPT_NO_FOR)
                    </td>

                </tr>
                <tr>

                    <td align="center">3</td>
                    <td align="left">NUMBER OF CASES DISPOSED OF FOR THE MONTH</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_7.TOTAL_DISPOSAL_NO_FOR)
                    </td>

                </tr>
                <tr>

                    <td align="center">4</td>
                    <td align="left">NUMBER OF CASES RECEIVED OF UPTO THE MONTH</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_7.TOTAL_RECEIPT_NO_UPTO)
                    </td>

                </tr>
                <tr>

                    <td align="center">5</td>
                    <td align="left">NUMBER OF CASES DISPOSED OF UPTO THE MONTH</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_7.TOTAL_DISPOSAL_NO_UPTO)
                    </td>

                 </tr>
                <tr>

                    <td align="center">6</td>
                    <td align="left">CLOSING BALANCE ON 31.01.2017</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_7.TOTAL_CLOSING_NO)
                    </td>

                </tr>
            </table>
           }
        </div>

        @*Body Portion Page 3*@


        <div class="DPM" id="3" hidden>
           @if ((ViewBag.DPM_CE_8_8) != null)
            {
            <table>
                    <tr>
                        <td align="left">
                            <h2><u>DPM-CE-1B : Break up of adjudication cases disposed of:</u></h2>
                        </td>
                    </tr>
                    <tr>
                        <td align="left">
                            <h4> Summary of cases: </h4>
                        </td>                       
                    </tr>

                </table>
            
            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>
                    <th align="center">
                        Category by
                    </th>
                    <th align="center">
                        During theh month
                    </th>
                    <th align="center">
                        Upto the month
                    </th>
                </tr>
                
                <tr>

                    <td align="center">1</td>
                    <td align="left">PASSING ORDER</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_8.ADJUDICATED_NO_FOR)
                        
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_8.ADJUDICATED_NO_UPTO)
                    </td>

                </tr>
                <tr>

                    <td align="center">2</td>
                    <td align="left">TRANSFERRED TO CALL BOOK</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_8.TRANSFERRED_NO_FOR)
                        
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_8.TRANSFERRED_NO_UPTO)
                    </td>

                </tr>
                <tr>

                    <td align="center">3</td>
                    <td align="left">OTHER DISPOSAL</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_8.OTHER_NO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_8.OTHER_NO_UPTO)
                    </td>

                </tr>
                <tr>

                    <td align="center">4</td>
                    <td align="left">TOTAL</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_8.TOTAL_NO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_8.TOTAL_NO_UPTO)
                    </td>

                </tr>
            </table>  
            }
            
@if ((ViewBag.DPM_CE_8_9) != null)
{
            <table>
                <tr>
                    <td align="left">
                        <h2><u>@*DPM-CE-1C :*@ Number of adjudication orders issued within 30 days of final hearing:-</u></h2>
                    </td>
                </tr>             
            </table>
           
            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>
                    <th align="center">
                       Adjudicating Authority
                    </th>
                    <th colspan="2" align="center">
                       Total No. of OIOs issued
                    </th>
                    <th colspan="2" align="center">
                       No. of OIOs issued within 30 days of Final Hearing
                    </th>
                    <th colspan="2" align="center">
                        % of OIOs issued within 30 days
                    </th>
                </tr>

                <tr>

                    <td align="center">1</td>
                    <td align="left">COMMISSIONER</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.COMM_TOTAL_OIO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.COMM_TOTAL_OIO_UPTO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.COMM_OIO_30DAYS_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.COMM_OIO_30DAYS_UPTO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.COMM_OIO_PERCENT_FOR)%
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.COMM_OIO_PERCENT_UPTO)%
                    </td>


                </tr>
                <tr>

                    <td align="center">2</td>
                    <td align="left">ADC/JC</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.JC_TOTAL_OIO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.JC_TOTAL_OIO_UPTO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.JC_OIO_30DAYS_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.JC_OIO_30DAYS_UPTO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.JC_OIO_PERCENT_FOR)%
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.JC_OIO_PERCENT_UPTO)%
                    </td>

                </tr>
                <tr>

                    <td align="center">3</td>
                    <td align="left">DC/AC</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.AC_TOTAL_OIO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.AC_TOTAL_OIO_UPTO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.AC_OIO_30DAYS_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.AC_OIO_30DAYS_UPTO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.AC_OIO_PERCENT_FOR)%
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.AC_OIO_PERCENT_UPTO)%
                    </td>


                </tr>
                <tr>

                    <td align="center">4</td>
                    <td align="left">SUPERINTENDENT</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.SUP_TOTAL_OIO_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.SUP_TOTAL_OIO_UPTO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.SUP_OIO_30DAYS_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.SUP_OIO_30DAYS_UPTO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.SUP_OIO_PERCENT_FOR)%
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.SUP_OIO_PERCENT_UPTO)%
                    </td>


                </tr>
                <tr>

                    <td align="center"></td>
                    <td align="left">TOTAL</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.TOTAL_OIO_TOTAL_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.TOTAL_OIO_TOTAL_UPTO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.TOTAL_OIO_30DAYS_FOR)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.TOTAL_OIO_30DAYS_UPTO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.TOTAL_PERCENT_FOR)%
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_9.TOTAL_PERCENT_UPTO)%
                    </td>


                </tr>
            </table>     
            <p> The analysis of data indicates that out of total @Html.Raw(ViewBag.DPM_CE_8_9.TOTAL_OIO_TOTAL_FOR) cases decided during the month, O-I-Os were issued within the prescribed time limit of 30 days of final hearing in @Html.Raw(ViewBag.DPM_CE_8_9.TOTAL_PERCENT_FOR_LIMIT)% cases i.e. @Html.Raw(ViewBag.DPM_CE_8_9.TOTAL_OIO_30DAYS_FOR) cases.</p>       
            }
        </div>

        @*Body Portion Page 4*@


        <div class="DPM" id="4" hidden>
@if ((ViewBag.DPM_CE_8_10) != null)
{
            <table>
                <tr>
                    <td align="left">
                        <h2><u>@*DPM-CE-2 :*@ Pendency of Adjudication Cases involving Central Excise Duty of Rs. One crore and above</u></h2>
                    </td>
                    <td >                        
                    </td>
                    <td align="right">
                        <h2>Amount Rs. in Lakhs</h2>
                    </td>
                </tr>               

            </table>
           
            <table class="Report_body">
                <tr>
                    <th align="center">
                        No. of cases
                    </th>

                    <th align="center">
                        Amount of duty
                    </th>
                    <th align="center">
                        < 1 year
                    </th>
                    <th align="center">
                        1-2 year
                    </th>
                    <th align="center">
                        2-3 year
                    </th>
                    <th align="center">
                        More than 3 years
                    </th>

                </tr>

                <tr>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_10.CLOSING_NO)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_10.CLOSING_AMT)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_10.YEAR_1)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_10.YEARS_1TO2)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_10.YEARS_2TO3)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_10.MORE_THAN_3)
                    </td>

                </tr>
            </table>

            <p>
                The prescribed time period for disposal of adjudication is 6 months. From the above data collected from all the Zones, it is evident that out of @Html.Raw(ViewBag.DPM_CE_8_10.CLOSING_NO) cases, @Html.Raw(ViewBag.DPM_CE_8_10.MORE_THAN_1_YEAR) cases involving duty of Rs. one crore and above are pending for more than one year which comes to @Html.Raw(ViewBag.DPM_CE_8_10.PERCENTAGE_MORE_THAN_1_YEAR)% of the total pendency. The pendency of cases involving high revenue is very alarming. This aspect requires constant monitoring at the Zonal level.
            </p>
            }

@if (((ViewBag.DPM_CE_8_11) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_11).Count() > 0)))
{
            <table>
                <tr>
                    <td align="left">
                        <h4>&nbsp;(a) @*<u>MSR-DPM-CE-2A :</u>*@ Top 5 Zones with cases involving Central Excise duty of more than Rs. One Crore pending for more than 1 year:-</h4>
                    </td>                 
                </tr>

            </table>        
            
            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>

                    <th align="center">
                        ZONE
                    </th>
                    <th align="center">
                        PENDENCY

                    </th>

                </tr>


                @for (int i = 0; i < 5; i++)
                {

                    <tr>
                        <th align="center">@(i + 1)</th>
                        <td align="left">@((ViewBag.DPM_CE_8_11)[i].ZONE_NAME) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_11)[i].CLOSING_NO) </td>

                    </tr>

                }
            </table>
            
            <p> 
                These 5 Zones have maximum pendency of adjudication in terms of number of cases, where the duty involved is more than Rs. 1 crore and pending for more than 1 year. Therefore, these zones must make special efforts to liquidate the pendency.
            </p>
            }
            
@if (((ViewBag.DPM_CE_8_12) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_12).Count() > 0)))
{
            <table>
                <tr>
                    <td align="left">
                        <h4>&nbsp;(b) @*<u>MSR-DPM-CE-2B :</u>*@ Top 5 Zones with cases involving Central Excise duty of more than Rs. One Crore pending for more than 2 years:-</h4>
                    </td>
                </tr>

            </table>
           
            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>

                    <th align="center">
                        ZONE
                    </th>
                    <th align="center">
                        PENDENCY

                    </th>

                </tr>


                @for (int i = 0; i < 5; i++)
                {

                    <tr>
                        <th align="center">@(i + 1)</th>
                        <td align="left">@((ViewBag.DPM_CE_8_12)[i].ZONE_NAME) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_12)[i].MORE_THAN_2) </td>

                    </tr>

                }
            </table>

            <p>
                These 5 Zones have the highest number of cases involving duty of more than Rs. 1 crore and pending for more than 2 year; therefore these Zones would need to make special efforts to liquidate the pendency.
            </p>
            }
        </div>


        @*Body Portion Page 5*@
        
        <div class="DPM" id="5" hidden>
            @if ((ViewBag.DPM_CE_8_13) != null)
            {
            <table>
                <tr>
                    <td align="left">
                        <h2><u>DPM-CE-3A : Call Book cases with reasons for pendency:</u></h2>
                    </td>
                </tr> 
                <tr>
                    <td align="left">
                        <h4>(a) &nbsp; Total number of cases pending all-India :- @Html.Raw(ViewBag.DPM_CE_8_13.CLOSING_TOTAL)</h4>
                    </td>
                </tr>               
            </table>

            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>
                    <th align="center">
                       Adjudicating Authority
                    </th>
                    <th align="center">
                       Number
                    </th>  
                    <th align="center">
                       % of total
                    </th>                   
                </tr>

                <tr>
                    <th align="center">1</th>
                    <th align="left">Commissioner</th>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_13.COMM_CLOSING)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_13.COMM_PERCENTAGE)%
                    </td>
                   
                </tr>
                <tr>
                    <th align="center">2</th>
                    <th align="left">Addl./Jt/ Commissioner</th>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_13.ADDL_CLOSING)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_13.ADDL_PERCENTAGE)%
                    </td>
                </tr>
                <tr>
                    <th align="center">3</th>
                    <th align="left">Dy./Astt. Commissioner</th>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_13.ASTT_CLOSING)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_13.ASTT_PERCENTAGE)%
                    </td>
                </tr>
                <tr>
                    <th align="center">4</th>
                    <th align="left">Superintendent</th>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_13.SUP_CLOSING)
                    </td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_13.SUP_PERCENTAGE)%
                    </td>
                </tr>
            </table>

            <p>
                The pendency of Call Book cases (@Html.Raw(ViewBag.DPM_CE_8_13.CLOSING_TOTAL)) is alarming. The pendency is almost proportionately distributed amongst Commissioners, Addl/Joint Commissioners and Dy/Assistant Commissioners.
            </p>
}

@if ((ViewBag.DPM_CE_8_14) != null)
{
            <table>
              
                <tr>
                    <td align="left">
                        <h4>(b) &nbsp; Age wise break up of pendency:</h4>
                    </td>
                </tr>
            </table>

            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>
                    <th align="center">
                        Age wise break up
                    </th>
                    <th align="center">
                       Pendency
                    </th>
                 
                </tr>

                <tr>
                    <th align="center">1</th>
                    <td align="left">< 3 months</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_14.MONTHS_3_TOTAL)
                    </td>
                   
                </tr>
                <tr>
                    <th align="center">2</th>
                    <td align="left">3-6 months</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_14.MONTHS_3TO6_TOTAL)
                    </td>
                </tr>
                <tr>
                    <th align="center">3</th>
                    <td align="left">6-12 months</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_14.MONTHS_6TO12_TOTAL)
                    </td>
                </tr>
                <tr>
                    <th align="center">4</th>
                    <td align="left">1-2 years</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_14.YEARS_1TO2_TOTAL)
                    </td>
                </tr>
                <tr>
                    <th align="center">5</th>
                    <td align="left">More than 2 years</td>
                    <td align="right" width="15%">
                        @Html.Raw(ViewBag.DPM_CE_8_14.YEARS_MORE_TOTAL)
                    </td>
                </tr>
               
            </table>
            <p> 
            It is seen thatr, about @Html.Raw(ViewBag.DPM_CE_8_14.PERCENTAGE_YEARS_MORE_TOTAL)% cases are pending for more than 2 years and @Html.Raw(ViewBag.DPM_CE_8_14.PERCENTAGE_YEARS_1TO2_TOTAL)% for 1-2 year. These call for the maximum attention of the Zones.
            </p>
}
       
       
@if (((ViewBag.DPM_CE_8_15) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_15).Count() > 0)))
{
    decimal percentage_3a = (((ViewBag.DPM_CE_8_15)[0].CLOSING_TOTAL + (ViewBag.DPM_CE_8_15)[1].CLOSING_TOTAL + (ViewBag.DPM_CE_8_15)[2].CLOSING_TOTAL + (ViewBag.DPM_CE_8_15)[3].CLOSING_TOTAL + (ViewBag.DPM_CE_8_15)[4].CLOSING_TOTAL) * 100 / (ViewBag.DPM_CE_8_13).CLOSING_TOTAL);

            <table>
                <tr>
                    <td align="left">
                        <h4>&nbsp; @*<u>MSR-DPM-CE-3A :</u>*@ Top 5 Zones with maximum pendency of Call Book cases:</h4>
                    </td>
                </tr>
            </table>  
       
            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>

                    <th align="center">
                        ZONE
                    </th>
                    <th align="center">
                        NUMBER

                    </th>
                    <th align="center">
                        % OF ALL INDIA TOTAL

                    </th>

                </tr>


                @for (int i = 0; i < 5; i++)
                {

                    <tr>
                        <th align="center">@(i + 1)</th>
                        <td align="left">@((ViewBag.DPM_CE_8_15)[i].ZONE_NAME) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_15)[i].CLOSING_TOTAL) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_15)[i].COMM_PERCENTAGE)% </td>

                    </tr>

                }
            </table>

            <p>
               
                
                The top five zones account for almost <strong> @(Math.Round(percentage_3a, 2))%</strong> of total pendency.
            </p>
}

@if ((ViewBag.DPM_CE_8_16) != null)
{
            <table>
                <tr>
                    <td align="left">
                        <h4>&nbsp; @*<u>MSR-DPM-CE-3B :</u>*@ Call Book Cases - Category Wise distrubution</h4>
                    </td>
                </tr>
            </table>

            <table class="Report_body">
                <tr>
                    <th rowspan="2" align="center">
                        Category
                    </th>
                    <th rowspan="2" align="center">
                        No. of Cases Pending
                    </th>
                    <th rowspan="2" align="center">
                        Amount Involved (Rs. in Lakhs)
                    </th>
                    <th colspan="5" align="center">
                        Age wise break up
                    </th>
                </tr>

                <tr >                  
                    <th align="center"> < 3 months </th>
                    <th align="center"> 3-6 months </th>
                    <th align="center"> 6-12 months </th>
                    <th align="center"> 1-2 years </th>
                    <th align="center"> > 2 years </th>
                </tr>

                <tr>
                    <th align="left">CASES IN WHICH DEPARMENT HAS GONE IN APPEAL TO THE APPROPRIATE AUTHORITY</th>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.DEPT_NOC)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.DEPT_AMOUNT)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.DEPT_MONTHS_3)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.DEPT_MONTHS_3TO6)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.DEPT_MONTHS_6TO12)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.DEPT_YEARS_1TO2)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.DEPT_MORE_2YEAR)</td>
                </tr>
                <tr>
                    <th align="left">CASES WHERE INJUNCTION HAS BEEN ISSUED BY SC/HC/TRIBUNAL ETC.</th>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.INJUNCTION_NOC)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.INJUNCTION_AMOUNT)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.INJUNCTION_MONTHS_3)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.INJUNCTION_MONTHS_3TO6)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.INJUNCTION_MONTHS_6TO12)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.INJUNCTION_YEARS_1TO2)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.INJUNCTION_MORE_2YEAR)</td>
                </tr>
                <tr>
                    <th align="left">CASES WHERE CERA AUDIT OBJECTIONS ARE CONTESTED</th>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.OBJECTIONS_NOC)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.OBJECTIONS_AMOUNT)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.OBJECTIONS_MONTHS_3)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.OBJECTIONS_MONTHS_3TO6)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.OBJECTIONS_MONTHS_6TO12)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.OBJECTIONS_YEARS_1TO2)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.OBJECTIONS_MORE_2YEAR)</td>
                </tr>
                <tr>
                    <th align="left">CASES WHERE BOARD HAS SPECIFICALLY ORDERED THE CASE TO BE KEPT IN CALL BOOK/OTHERS</th>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.SPEC_NOC)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.SPEC_AMOUNT)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.SPEC_MONTHS_3)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.SPEC_MONTHS_3TO6)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.SPEC_MONTHS_6TO12)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.SPEC_YEARS_1TO2)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.SPEC_MORE_2YEAR)</td>
                </tr>
                <tr>
                    <th align="left">CASES WHERE PARTIES HAD FILED APPLICATIONS IN SETTLEMENT COMMISSION, WHICH ARE PENDING</th>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.APP_NOC)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.APP_AMOUNT)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.APP_MONTHS_3)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.APP_MONTHS_3TO6)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.APP_MONTHS_6TO12)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.APP_YEARS_1TO2)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_16.APP_MORE_2YEAR)</td>
                </tr>
            </table>

            <p>
                An analysis of the above figures indicates that the maximum call book cases are in the category of cases where the department has gone in appeal. The second highest are cases where CERA Audit objections are contested. The Zonal Chief Commissioners are required to take a closer look at these two issues and ensure that only the cases which ought to have been kept in call book are so kept to reduce the pendency in this key area.
            </p>
}
        </div>

        @*Body Portion Page 6*@

        <div class="DPM" id="6" hidden>
@if ((ViewBag.DPM_CE_8_17_REFUND) != null)
            {
            <table>
                <tr>
                    <td align="left">
                        <h2><u>@*DPM-CE-4:*@ Refund / Rebate - </u></h2>
                    </td>
                </tr>

                <tr>
                    <td align="left">
                        <h4>Refund : Total number of pending cases all-India - @Html.Raw(ViewBag.DPM_CE_8_17_REFUND.TOTAL_REF_NO)</h4>                        
                  
                   
                        <h4>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  Amount involved - Rs. @Html.Raw(ViewBag.DPM_CE_8_17_REFUND.TOTAL_REF_AMT) lakhs</h4>
                   
                        <h4>Rebate : Total number of pending cases all-India - @Html.Raw(ViewBag.DPM_CE_8_18_REBATE.TOTAL_REBATE_NO)</h4>
                    
                        <h4>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;  Amount involved - Rs. @Html.Raw(ViewBag.DPM_CE_8_18_REBATE.TOTAL_REBATE_AMT) lakhs</h4>
                    </td>
                </tr>

                </table>
}

@if ((ViewBag.DPM_CE_8_17_REFUND) != null)
     {
            <table>
                <tr>
                    <td align="left">
                        <h4>(a) &nbsp; Age wise break up of pendency:-</h4>
                        <h4>&nbsp; &nbsp; Refund</h4>
                    </td>
                    
                </tr>
            </table>

           
            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>
                    <th align="center">
                       Age wise break up
                    </th>
                    <th align="center">
                        Number
                    </th>
                    <th align="center">
                        % of total
                    </th>
                </tr>

                <tr>
                    <th align="center">1</th>
                    <td align="left">Less than 3 months</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_17_REFUND.REF_MONTHS_3_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_17_REFUND.PERCENTAGE_REF_MONTHS_3) %</td>
                </tr>
                <tr>
                    <th align="center">2</th>
                    <td align="left">3-6 Months</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_17_REFUND.REF_MONTHS_3TO6_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_17_REFUND.PERCENTAGE_REF_MONTHS_3TO6) %</td>
                </tr>
                <tr>
                    <th align="center">3</th>
                    <td align="left">6-12 Months</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_17_REFUND.REF_MONTHS_6TO12_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_17_REFUND.PERCENTAGE_REF_MONTHS_6TO12) %</td>
                </tr>
                <tr>
                    <th align="center">4</th>
                    <td align="left">Over 1 Year</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_17_REFUND.REF_MORE_YEAR_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_17_REFUND.PERCENTAGE_REF_OVER1YEAR) %</td>
                </tr>
            </table>
}

@if ((ViewBag.DPM_CE_8_18_REBATE) != null && (ViewBag.DPM_CE_8_18_REBATE.REBATE_MONTHS_3_NO) != null)
{
            <table>
                <tr>                    
                    <td align="left">
                        <strong>&nbsp; &nbsp; Rebate</strong>
                    </td>
                </tr>
            </table>

            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>
                    <th align="center">
                        Age wise break up
                    </th>
                    <th align="center">
                        Number
                    </th>
                    <th align="center">
                        % of total
                    </th>
                </tr>

                <tr>
                    <th align="center">1</th>
                    <td align="left">Less than 3 months</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_18_REBATE.REBATE_MONTHS_3_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_18_REBATE.PERCENTAGE_REBATE_MONTHS_3) %</td>
                </tr>
                <tr>
                    <th align="center">2</th>
                    <td align="left">3-6 Months</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_18_REBATE.REBATE_MONTHS_3TO6_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_18_REBATE.PERCENTAGE_REBATE_MONTHS_3TO6) %</td>
                </tr>
                <tr>
                    <th align="center">3</th>
                    <td align="left">6-12 Months</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_18_REBATE.REBATE_MONTHS_6TO12_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_18_REBATE.PERCENTAGE_REBATE_MONTHS_6TO12) %</td>
                </tr>
                <tr>
                    <th align="center">4</th>
                    <td align="left">Over 1 Year</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_18_REBATE.REBATE_MORE_YEAR_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_18_REBATE.PERCENTAGE_REBATE_OVER1YEAR) %</td>
                </tr>
            </table>

                    
            <p>
                An alarming number of cases of refund & rebate together i.e. @(ViewBag.DPM_CE_8_17_REFUND.REF_MONTHS_3TO6_NO + ViewBag.DPM_CE_8_17_REFUND.REF_MONTHS_6TO12_NO + ViewBag.DPM_CE_8_17_REFUND.REF_MORE_YEAR_NO + ViewBag.DPM_CE_8_18_REBATE.REBATE_MONTHS_3TO6_NO + ViewBag.DPM_CE_8_18_REBATE.REBATE_MONTHS_6TO12_NO + ViewBag.DPM_CE_8_18_REBATE.REBATE_MORE_YEAR_NO) 
                cases are pending for more than 3 months out of which @(ViewBag.DPM_CE_8_17_REFUND.REF_MONTHS_6TO12_NO + ViewBag.DPM_CE_8_17_REFUND.REF_MORE_YEAR_NO + ViewBag.DPM_CE_8_18_REBATE.REBATE_MONTHS_6TO12_NO + ViewBag.DPM_CE_8_18_REBATE.REBATE_MORE_YEAR_NO) 
                are pending for more than 6 months and @(ViewBag.DPM_CE_8_17_REFUND.REF_MORE_YEAR_NO + ViewBag.DPM_CE_8_18_REBATE.REBATE_MORE_YEAR_NO) 
                are pending for more than 1 year.
            </p>
}
       
@if (((ViewBag.DPM_CE_8_19_REFUND) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_19_REFUND).Count() > 0)))
{
    decimal percentage_ref = (((ViewBag.DPM_CE_8_19_REFUND)[0].TOTAL_REF + (ViewBag.DPM_CE_8_19_REFUND)[1].TOTAL_REF + (ViewBag.DPM_CE_8_19_REFUND)[2].TOTAL_REF + (ViewBag.DPM_CE_8_19_REFUND)[3].TOTAL_REF + (ViewBag.DPM_CE_8_19_REFUND)[4].TOTAL_REF) * 100 / ((ViewBag.DPM_CE_8_17_REFUND).REF_MONTHS_3TO6_NO + (ViewBag.DPM_CE_8_17_REFUND).REF_MONTHS_6TO12_NO + (ViewBag.DPM_CE_8_17_REFUND).REF_MORE_YEAR_NO));

            <table>               
                <tr>
                    <td align="left">
                        <h4>(b) &nbsp; @*<u>MSR-DPM-CE-4A :</u>*@ Top 5 ZOnes with maximum cases of Refund pending for more than 3 months:-</h4>
                        <h4> &nbsp;&nbsp; Redund:</h4>
                    </td>
                    
                </tr>
            </table>
                   
            <table class="Report_body">
                <tr>
                    
                    <th align="center">
                        ZONE
                    </th>
                    <th align="center">
                        NUMBER

                    </th>
                    <th align="center">
                        % OF ALL INDIA TOTAL

                    </th>

                </tr>


                @for (int i = 0; i < 5; i++)
                {

                    <tr>
                        
                        <td align="left">@((ViewBag.DPM_CE_8_19_REFUND)[i].ZONE_NAME) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_19_REFUND)[i].TOTAL_REF) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_19_REFUND)[i].PERCENTAGE_REF_MONTHS_3)% </td>

                    </tr>

                }
            </table>

            <p>
                
                         
                These zones together account for <strong> @(Math.Round(percentage_ref, 2))%</strong> of the total number of cases pending for more than 3 months.
            </p>
            }

@if (((ViewBag.DPM_CE_8_20_REBATE) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_20_REBATE).Count() > 0)))
{
    decimal percentage_rebt = (((ViewBag.DPM_CE_8_20_REBATE)[0].TOTAL_REF + (ViewBag.DPM_CE_8_20_REBATE)[1].TOTAL_REF + (ViewBag.DPM_CE_8_20_REBATE)[2].TOTAL_REF + (ViewBag.DPM_CE_8_20_REBATE)[3].TOTAL_REF + (ViewBag.DPM_CE_8_20_REBATE)[4].TOTAL_REF) * 100 / ((ViewBag.DPM_CE_8_18_REBATE).REBATE_MONTHS_3TO6_NO + (ViewBag.DPM_CE_8_18_REBATE).REBATE_MONTHS_6TO12_NO + (ViewBag.DPM_CE_8_18_REBATE).REBATE_MORE_YEAR_NO));

            <table>
                <tr>
                    <td align="left">
                        <h4>(c) &nbsp; @*<u>MSR-DPM-CE-4B :</u>*@ Top 5 ZOnes with maximum cases of Rebate pending for more than 3 months:-</h4>
                        <h4> &nbsp;&nbsp; Rebate:</h4>
                    </td>
                  
                </tr>
            </table>
      
            <table class="Report_body">
                <tr>

                    <th align="center">
                        ZONE
                    </th>
                    <th align="center">
                        NUMBER

                    </th>
                    <th align="center">
                        % OF ALL INDIA TOTAL

                    </th>

                </tr>


                @for (int i = 0; i < 5; i++)
                {

                    <tr>

                        <td align="left">@((ViewBag.DPM_CE_8_20_REBATE)[i].ZONE_NAME) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_20_REBATE)[i].TOTAL_REF) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_20_REBATE)[i].PERCENTAGE_REBATE_MONTHS_3)% </td>

                    </tr>

                }
            </table>

            <p>
               
                These zones together account for <strong> @(Math.Round(percentage_rebt, 2))%</strong> of the total number of cases pending for more than 3 months.
            </p>
}      
        </div>

        @*Body Portion Page 7*@

        <div class="DPM" id="7" hidden>
@if ((ViewBag.DPM_CE_8_21) != null )
            {
            <table>
                <tr>
                    <td align="left">
                        <h2><u>@*DPM-CE-5 :*@ Provisional Assessment - </u></h2>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <strong>(a) &nbsp; Summary of cases : Total Cases - 
                        @(ViewBag.DPM_CE_8_21.MONTHS_0TO6_NO + ViewBag.DPM_CE_8_21.MONTHS_6TO12_NO + ViewBag.DPM_CE_8_21.YEAR_1TO2_NO + ViewBag.DPM_CE_8_21.MORE_2YEAR_NO)</strong>
                        <h4>(b) &nbsp;Age wise break up of pendency</h4>
                    </td>
                    </tr>
            </table>

            <table class="Report_body">
                <tr>
                    <th align="center">
                        Sr.No.
                    </th>
                    <th align="center">
                        Age wise break up
                    </th>
                    <th align="center">
                        Number
                    </th>
                    <th align="center">
                        % of total
                    </th>
                </tr>

                <tr>
                    <th align="center">1</th>
                    <td align="left">0-6 Months</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_21.MONTHS_0TO6_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_21.PERCENTAGE_MONTHS_0TO6_NO) %</td>
                </tr>
                <tr>
                    <th align="center">2</th>
                    <td align="left">6-12 Months</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_21.MONTHS_6TO12_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_21.PERCENTAGE_MONTHS_6TO12_NO) %</td>
                </tr>
                <tr>
                    <th align="center">3</th>
                    <td align="left">1-2 Years</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_21.YEAR_1TO2_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_21.PERCENTAGEYEAR_1TO2_NO) %</td>
                </tr>
                <tr>
                    <th align="center">4</th>
                    <td align="left">2 Years & above</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_21.MORE_2YEAR_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_21.PERCENTAGE_MORE_2YEAR_NO) %</td>
                </tr>
            </table>
}

@if (((ViewBag.DPM_CE_8_22) != null && (((IEnumerable<dynamic>)ViewBag.DPM_CE_8_22).Count() > 0)))
{
            <table>

                <tr>
                    <td align="left">
                        <h4>(c) &nbsp; Top 5 Zone with maximum pendency of Provisional Assessment:</h4>
                    </td>
                </tr>
            </table>

            <table class="Report_body">
                <tr>

                    <th align="center">
                        ZONE
                    </th>
                    <th align="center">
                        NUMBER

                    </th>
                    <th align="center">
                        % OF ALL INDIA TOTAL

                    </th>

                </tr>


                @for (int i = 0; i < 5; i++)
                {

                    <tr>

                        <td align="left">@((ViewBag.DPM_CE_8_22)[i].ZONE_NAME) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_22)[i].CLOSING_NO) </td>
                        <td align="right">@((ViewBag.DPM_CE_8_22)[i].PERCENTAGE_CLOSING_NO)% </td>

                    </tr>

                }
            </table>

            <p>
               Statutory provisions require that provisional assessment should be finalized within 6 months. There are 
                @((ViewBag.DPM_CE_8_22)[0].CLOSING_NO+(ViewBag.DPM_CE_8_22)[1].CLOSING_NO+(ViewBag.DPM_CE_8_22)[2].CLOSING_NO+(ViewBag.DPM_CE_8_22)[3].CLOSING_NO+(ViewBag.DPM_CE_8_22)[4].CLOSING_NO) 
                cases of provisional assessment which are pending for more than 6 months. @((ViewBag.DPM_CE_8_22)[0].ZONE_NAME) Zone has the maximum pendency of @((ViewBag.DPM_CE_8_22)[0].CLOSING_NO) cases.
            </p>
}

@if ((ViewBag.DPM_CE_8_23) != null)
{
            <table>

                <tr>
                    <td align="left">
                        <h2><u>@*DPM-CE-6 -*@ Bank Guarantees -</u></h2>
                    </td>
                </tr>
            </table>

            <table class="Report_body">
                <tr>
                    <th align="center">
                        Opening balance
                    </th>
                    <th align="center">
                        Bank guarantees received
                    </th>
                    <th align="center">
                        Bank guarantees returned to party
                    </th>
                    <th align="center">
                        Closing balance (Dec, 2016)
                    </th>

                </tr>

                <tr>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_23.OPENING_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_23.BG_RECEIVED_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_23.BG_RETURNED_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_23.CLOSING_NO)</td>

                </tr>
                

            </table>
}

@if ((ViewBag.DPM_CE_8_24) != null)
{
            <table>

                <tr>
                    <td align="left">
                        <h4>Breakup of valadity of bank guarantee (Bank Guarantee valid for)</h4>
                    </td>
                </tr>
            </table>

            <table class="Report_body">
                <tr>
                    <th align="center">
                        1-3 Months
                    </th>
                    <th align="center">
                       3-6 Months
                    </th>
                    <th align="center">
                       6-12 Months
                    </th>
                    <th align="center">
                       More than 1 year
                    </th>

                </tr>

                <tr>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_24.MONTHS_1TO3_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_24.MONTHS_3TO6_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_24.MONTHS_6TO12_NO)</td>
                    <td align="right">@Html.Raw(ViewBag.DPM_CE_8_24.MORE_YEAR_NO)</td>

                </tr>


            </table>
}
            <p>
               The Bank Guarantees require constant monitoring so that they do not lapse for want of watch and should be enforced to safeguard revenue where required.
            </p>

            <p>
                <strong>
                    REMARKS:- These comments have been prepared after examining the statistical data pertaining to Central Excise contained in Part V of Zonal Monthly Performance Reports uploaded by field formations on MIS web based utility available at <u>www.cbecddm.gov.in</u>. The Director General of Performance Management is closely monitoring the pendencies in Adjudication, Call Book, Refund & Rebate, Provisional Assessment and Bank Guarantees.
                </strong>
            </p>

        </div>

        <br />

    </div>
    <div align="right">
        <ul class="pagination" style="background-color:gray;">
            <li><a href="javascript:void(0);" class="link 1">1</a></li>
            <li><a href="javascript:void(0);" class="link 2">2</a></li>
            <li><a href="javascript:void(0);" class="link 3">3</a></li>
            <li><a href="javascript:void(0);" class="link 4">4</a></li>
            <li><a href="javascript:void(0);" class="link 5">5</a></li>
            <li><a href="javascript:void(0);" class="link 6">6</a></li>
            <li><a href="javascript:void(0);" class="link 7">7</a></li>
            
        </ul>
    </div>

</body>
</html>
