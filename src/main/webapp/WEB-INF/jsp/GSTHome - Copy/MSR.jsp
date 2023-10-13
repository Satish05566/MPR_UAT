<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<jsp:include page="Header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ page import = "java.io.*,java.util.*,java.time.format.DateTimeFormatter,java.time.LocalDateTime" %>


<div id="page-wrapper">
    <div class="row">
       <div class="col-lg-6">

			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-book fa-fw"></i> Monthly Summary Report
			</h4>

		</div>
		<div class="col-lg-6">

			<ol class="breadcrumb float-right no-bg-col p-t-20 m-b-0 p-r-0">
				<li><a href="/GSTHome/Home"><i class="fa fa-home"></i> Management Information</a></li>
				<li class="active">MSR</li>

			</ol>
		</div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div id="Non_Revenue_Heading" class="panel-heading">
                    MSR
                </div>

                <div id="Revenue_Heading" class="panel-heading" style="height:55px">

                    <div class="col-lg-9">
                        <div class="form-group">
                            MSR
                        </div>
                    </div>
					
                    <div class="col-lg-3">
                        <div class="form-group">
                        
                        
                        
                        <select name="advanced_report" id="advanced_report"  class="form-control" onchange = "javascript:parthide();" style = "background-color:#d9edf7; color:#31708f; font-weight: bold">

											<option value="monthly_report" >Monthly Financial Report</option>
											<option value="months_wise" >Between Month Financial Report</option>
											<option value="years_wise" >Year-wise Financial Report</option>
											
											
									       </select> 
       
       							
       
                   </div>
                    </div>

                </div>

                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form role="form">
							
                                <!--start for monthly report-->
                                <div class="col-lg-4" id="MSR_Report_Name">
                                    <div class="form-group">
                                                      
               <select name="ddl_ReportGroup" id="ddl_ReportGroup"  class="form-control" onchange = "javascript:MSR_List(this.value);">

											<option value="tbl_Part_I">Part-I Revenue</option> 
											<option value="tbl_Part_II">Part-II Anti-smuggling</option>
											<option value="tbl_Part_III">Part-III Anti-evasion</option>
											<option value="tbl_Part_IV">Part-IV Audit</option> 
											<option value="tbl_Part_V">Part-V Adjudication</option> 
											<option value="tbl_Part_VI">Part-VI Valuation</option>
											<!--  <option value="tbl_Part_VII">Part-VII Legal</option> -->
											<option value="tbl_Part_VIII">Part-VIII Arrears</option> 
											<option value="tbl_Part_IX">Part-IX Logistics</option> 
											
											
									       </select> 
       
       										
       
                                    </div>
                                </div>

                                <div class="col-lg-4" id="MSR_Year">
                                    <div class="form-group">
                                    
                                    <select class="form-control" id="ddl_year" name="ddl_year"><option value="">--Select Year--</option>

<option value="2023">2023</option>
<option value="2022">2022</option>
<option value="2021">2021</option>
<option value="2020">2020</option>
<option value="2019">2019</option>
<option value="2018">2018</option>
<option value="2017">2017</option>
</select>
									       
<!--                                         @{ -->
<!--                                             var listItems = new List<SelectListItem>(); -->
<!--                                             listItems.Add(new SelectListItem { Text = "--Select Year--", Value = "" }); -->
<!--                                             int i = 0; -->
<!--                                             if (DateTime.Now.Month > 1) -->
<!--                                             { -->
<!--                                                 i = DateTime.Now.Year; -->
<!--                                             } -->
<!--                                             else -->
<!--                                             { -->
<!--                                                 i = DateTime.Now.Year - 1; -->
<!--                                             } -->
<!--                                             while (i >= 2017) -->
<!--                                             { -->
<!--                                                 listItems.Add(new SelectListItem { Text = i.ToString(), Value = i.ToString() }); -->
<!--                                                 i = i - 1; -->
<!--                                             } -->
<!--                                             @Html.DropDownList("ddl_year", listItems, new { @class = "form-control" }) -->
<!--                                         } -->

                                    </div>
                                </div>

                                <div class="col-lg-4" id="MSR_Month">
                                    <div class="form-group">
                                                     
               <select name="ddl_mth" id="ddl_mth"  class="form-control">

											<option value="4">APR</option>
											<option value="5">MAY</option>
											<option value="6">JUN</option>
											<option value="7">JUL</option>
											<option value="8">AUG</option>
											<option value="9">SEP</option>
											<option value="10">OCT</option>
											<option value="11">NOV</option>
											<option value="12">DEC</option>
											<option value="1">JAN</option>
											<option value="2">FEB</option>
											<option value="3">MAR</option>
																						
									       </select> 
       
       										
       
               
                                    </div>
                                </div>

                                <!--start for months wise report-->
                                <div class="col-lg-4" id="MSR_Year_Months">
                                    <div class="form-group">
                                    

                               <select class="form-control" id="ddl_year_months" name="ddl_year_months"><option value="">--Select Year--</option>

<option value="2023">2023</option>
<option value="2022">2022</option>
<option value="2021">2021</option>
<option value="2020">2020</option>
<option value="2019">2019</option>
<option value="2018">2018</option>
<option value="2017">2017</option>
</select>
									       
<!--                                         @{ -->
<!--                                             var listItems4 = new List<SelectListItem>(); -->
<!--                                             listItems4.Add(new SelectListItem { Text = "--Select Year--", Value = "" }); -->
<!--                                             int l = 0; -->
<!--                                             if (DateTime.Now.Month > 1) -->
<!--                                             { -->
<!--                                                 l = DateTime.Now.Year; -->
<!--                                             } -->
<!--                                             else -->
<!--                                             { -->
<!--                                                 l = DateTime.Now.Year - 1; -->
<!--                                             } -->
<!--                                             while (l >= 2017) -->
<!--                                             { -->
<!--                                                 listItems4.Add(new SelectListItem { Text = l.ToString(), Value = l.ToString() }); -->
<!--                                                 l = l - 1; -->
<!--                                             } -->
<!--                                             @Html.DropDownList("ddl_year_months", listItems4, new { @class = "form-control" }) -->
<!--                                         } -->

                                    </div>
                                </div>

                                <div class="col-lg-4" id="MSR_Month_To">
                                    <div class="form-group">
                                     <select name="ddl_mth_to" id="ddl_mth_to"  class="form-control" onchange = "javascript:parthide();">

											<option value="4">APR</option>
											<option value="5">MAY</option>
											<option value="6">JUN</option>
											<option value="7">JUL</option>
											<option value="8">AUG</option>
											<option value="9">SEP</option>
											<option value="10">OCT</option>
											<option value="11">NOV</option>
											<option value="12">DEC</option>
											<option value="1">JAN</option>
											<option value="2">FEB</option>
											<option value="3">MAR</option>
																						
									       </select> 
                                    
                                 
                                    </div>
                                </div>
                                <!--end for MOnth Wise report-->
                                <!--start for financial report-->
                                <div class="col-lg-4" id="MSR_Year_From">
                                    <div class="form-group">
                                    <select class="form-control" id="ddl_year_from" name="ddl_year_from"><option value="2019">2018-2019</option>
<option value="2018">2017-2018</option>
</select>
                                    
                                    
<!--                                         @{ -->
<!--                                             var listItems3 = new List<SelectListItem>(); -->

<!--                                             int k = 0; -->
<!--                                             if (DateTime.Now.Month > 1) -->
<!--                                             { -->
<!--                                                 k = DateTime.Now.Year; -->
<!--                                             } -->
<!--                                             else -->
<!--                                             { -->
<!--                                                 k = DateTime.Now.Year - 1; -->
<!--                                             } -->
<!--                                             while (k >= 2018) -->
<!--                                             { -->
<!--                                                 if (k <= 2019) -->
<!--                                                 { -->
<!--                                                     listItems3.Add(new SelectListItem { Text = (k - 1).ToString() + "-" + k.ToString(), Value = k.ToString() }); -->

<!--                                                 } -->
<!--                                                 k = k - 1; -->
<!--                                             } -->
<!--                                             @Html.DropDownList("ddl_year_from", listItems3, new { @class = "form-control" }) -->
<!--                                         } -->

                                    </div>
                                </div>

                                <div class="col-lg-4" id="MSR_Year_To" style="display: block; float: left">
                                    <div class="form-group">
                                    
                                  <select class="form-control" id="ddl_year_to" name="ddl_year_to"><option value="2019">2018-2019</option>
<option value="2018">2017-2018</option>
</select>
                                    
                                    
<!--                                         @{ -->
<!--                                             var listItems1 = new List<SelectListItem>(); -->

<!--                                             int j = 0; -->
<!--                                             if (DateTime.Now.Month > 1) -->
<!--                                             { -->
<!--                                                 j = DateTime.Now.Year; -->
<!--                                             } -->
<!--                                             else -->
<!--                                             { -->
<!--                                                 j = DateTime.Now.Year - 1; -->
<!--                                             } -->
<!--                                             while (j >= 2018) -->
<!--                                             { -->
<!--                                                 if (j <= 2019) -->
<!--                                                 { -->
<!--                                                     listItems1.Add(new SelectListItem { Text = (j - 1).ToString() + "-" + j.ToString(), Value = j.ToString() }); -->

<!--                                                 } -->
<!--                                                 j = j - 1; -->
<!--                                             } -->
<!--                                             @Html.DropDownList("ddl_year_to", listItems1, new { @class = "form-control" }) -->
<!--                                         } -->

                                    </div>
                                </div>
                                <!--end for financial report-->



                            </form>
                        </div>
                        <!-- /.col-lg-6 (nested) -->
                        <!-- /.col-lg-6 (nested) -->
                    </div>
                    <!-- /.row (nested) -->
                    <div class="row" id="tbl_Part_I">
                        <div class="col-lg-12">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <i class="fa fa-file fa-fw"></i> Part-I Revenue
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="row" id="tbl_Part_I">
                                        <div class="col-lg-12">
                                            <div class="panel panel-danger" data-toggle="collapse" data-target="#CexPartI">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Central Excise
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse in" id="CexPartI">
                                                    <div class="list-group">

                                                        <a href='javascript: GetReport("MSR-DDM-CE-1")' class="list-group-item">1) REVENUE REPORT - (MSR-DDM-CE-1)</a>
                                                        <a href='javascript: GetReport("MSR-DDM-CE-2")' class="list-group-item">2) CENVAT REPORT - (MSR-DDM-CE-2)</a>
                                                        <a href='javascript: GetReport("MSR-DDM-CE-3")' class="list-group-item">3) DUTY FOREGONE REPORT - (MSR-DDM-CE-3)</a>

                                                        <a href='javascript: GetReport("MSR-DDM-CE-4")' class="list-group-item" id="ddm_ce_4_hide">4) REVENUE TREND OF TOP 25 ASSESSEES - (MSR-DDM-CE-4)</a>

                                                        <a href='javascript: GetReport("MSR-DDM-CE-5")' class="list-group-item">5) REVENUE AUGMENTATION REPORT - (MSR-DDM-CE-5)</a>

                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                            <div class="panel panel-info" data-toggle="collapse" data-target="#CusPartI">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Customs
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="CusPartI">
                                                    <div class="list-group">
                                                        <a href='javascript: GetReport("MSR-DDM-CUS-1")' class="list-group-item">6) REVENUE REPORT - (MSR-DDM-CUS-1)</a>
                                                        <a href='javascript: GetReport("MSR-DDM-CUS-3")' class="list-group-item">7) DRAWBACK & DUTY FOREGONE - (MSR-DDM-CUS-3)</a>
                                                        <a href='javascript: GetReport("MSR-DDM-CUS-4")' class="list-group-item" id="ddm_cus_4_hide">8) REVENUE FROM TOP 25 ASSESSEES - (MSR-DDM-CUS-4)</a>
                                                        <a href='javascript: GetReport("MSR-DDM-CUS-5")' class="list-group-item">9) REVENUE AUGMENTATION - (MSR-DDM-CUS-5)</a>
                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                            <div class="panel panel-success" data-toggle="collapse" data-target="#STPartI">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Service Tax
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="STPartI">
                                                    <div class="list-group">
                                                        <a href='javascript: GetReport("MSR-DDM-ST-1")' class="list-group-item">10) REVENUE REPORT - (MSR-DDM-ST-1)</a>
                                                        <!-- <a href='javascript: GetReport("MSR-DDM-ST-2")' class="list-group-item">11) CENVAT REPORT - (MSR-DDM-ST-2)</a>
                                                            <a href='javascript: GetReport("MSR-DDM-ST-3")' class="list-group-item">12) SERVICE TAX FORGONE REPORT - (MSR-DDM-ST-3)</a>
                                                            <a href='javascript: GetReport("MSR-DDM-ST-4")' class="list-group-item">13) REVENUE TREND OF TOP 25 SERVICE PROVIDERS - (MSR-DDM-ST-4)</a> -->
                                                        <a href='javascript: GetReport("MSR-DDM-ST-5")' class="list-group-item">14) REVENUE AUGMENTATION - (MSR-DDM-ST-5)</a>
                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                        </div>
                                        <!-- /.col-lg-4 -->
                                    </div>
                                    <!-- /.list-group -->

                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                        <!-- /.col-lg-4 -->
                    </div>

                    <div class="row" id="tbl_Part_II">

                        <div class="col-lg-12">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <i class="fa fa-file fa-fw"></i> Part-II Anti-smuggling
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="list-group">

                                        <a href='javascript: GetReport("MSR-DRI-1")' class="list-group-item">1) SEIZURE SUMMARY - (MSR-DRI-1)</a>
                                        <a href='javascript: GetReport("MSR-DRI-2")' class="list-group-item">2) COMMERCIAL FRAUD DETECTION SUMMARY - (MSR-DRI-2)</a>
                                        <a href='javascript: GetReport("MSR-DRI-3")' class="list-group-item">3) INVESTIGATION SUMMARY - (MSR-DRI-3)</a>
                                        <a href='javascript: GetReport("MSR-DRI-4")' class="list-group-item">4) ADJUDICATION SUMMARY - (MSR-DRI-4)</a>
                                        <a href='javascript: GetReport("MSR-DRI-5")' class="list-group-item">5) RECOVERY SUMMARY - (MSR-DRI-5)</a>
                                        <a href='javascript: GetReport("MSR-DRI-6")' class="list-group-item">6) ARREST SUMMARY - (MSR-DRI-6)</a>
                                        <a href='javascript: GetReport("MSR-DRI-CUS-10A")' class="list-group-item">7) PERCENTAGE WISE SHARE OF COMMISSIONERATES FOR COMMODITY WISE DETECTIONS WITH REGARD TO CUS-10A - (MSR-DRI-7)</a>

                                    </div>
                                    <!-- /.list-group -->

                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                        <!-- /.col-lg-4 -->
                    </div>

                    <div class="row" id="tbl_Part_III">

                        <div class="col-lg-12">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <i class="fa fa-file fa-fw"></i> Part-III Anti-evasion
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="list-group">

                                        <a href='javascript: GetReport("MSR-CEI-1")' class="list-group-item">1) DETECTION OF CASES - (MSR-CEI-1)</a>
                                        <a href='javascript: GetReport("MSR-CEI-2")' class="list-group-item">2) REALIZATION OF DUTY & TAX - (MSR-CEI-2)</a>
                                        <a href='javascript: GetReport("MSR-CEI-3")' class="list-group-item">3) SEIZURE OF GOODS/VEHICLE/CURRENCY - (MSR-CEI-3)</a>
                                        <a href='javascript: GetReport("MSR-CEI-4")' class="list-group-item">4) INVESTIGATION OF CASES - (MSR-CEI-4)</a>
                                        <a href='javascript: GetReport("MSR-CEI-5")' class="list-group-item">5) COMPLETION OF INVESTIGATIONS - (MSR-CEI-5)</a>
                                        <a href='javascript: GetReport("MSR-CEI-6")' class="list-group-item">6) ARRESTS MADE BY DGCEI & COMMISSIONERATES - (MSR-CEI-6)</a>
                                    </div>
                                    <!-- /.list-group -->

                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                        <!-- /.col-lg-4 -->
                    </div>

                    <div class="row" id="tbl_Part_IV">
                        <div class="col-lg-12">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <i class="fa fa-file fa-fw"></i> Part-IV Audit
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="row" id="tbl_Part_I">
                                        <div class="col-lg-12">
                                            <div class="panel panel-danger" data-toggle="collapse" data-target="#CexPartIV">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Central Excise
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse in" id="CexPartIV">
                                                    <div class="list-group">

                                                        <a href='javascript: GetReport("MSR-DGA-CE-1-2")' class="list-group-item">1) ZONE WISE TOTAL UNITS AUDITED,AMOUNT OF SHORT-LEVY DETECTED,AMOUNT OF TOTAL RECOVERY AND PARAS PENDING - (MSR-DGA-CE-1 & 2)</a>
                                                        <a href='javascript: GetReport("MSR-DGA-CE-3A-3B")' class="list-group-item">2) ZONE WISE TOTAL UNITS AUDITED,AMOUNT OF SHORT-LEVY DETECTED,AMOUNT OF TOTAL RECOVERY AND PARAS PENDING - (MSR-DGA-CE-3A & 3B)</a>

                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                            <div class="panel panel-info" data-toggle="collapse" data-target="#STPartIV">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Service Tax
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="STPartIV">
                                                    <div class="list-group">
                                                        <a href='javascript: GetReport("MSR-DGA-ST-1-2")' class="list-group-item">3) ZONE WISE TOTAL UNITS AUDITED,AMOUNT OF SHORT-LEVY DETECTED,AMOUNT OF TOTAL RECOVERY AND PARAS PENDING - (MSR-DGA-ST-1 & 2)</a>
                                                        <a href='javascript: GetReport("MSR-DGA-ST-3A-3B-3C")' class="list-group-item">4) ZONE WISE   THIRD PARTY DATA BASED ON CBDT DATA FOR THE YEAR-2012-13 ,2013-14,2014-15 - (MSR-DGA-ST-3A,3B & 3C)</a>
                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                        </div>
                                        <!-- /.col-lg-4 -->
                                    </div>
                                    <!-- /.list-group -->

                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                        <!-- /.col-lg-4 -->
                    </div>


                    <div class="row" id="tbl_Part_V">
                        <div class="col-lg-12">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <i class="fa fa-file fa-fw"></i> Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="row" id="tbl_Part_I">
                                        <div class="col-lg-12">

                                            <div class="panel panel-danger" data-toggle="collapse" data-target="#CexPartV">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Central Excise
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="CexPartV">
                                                    <div class="list-group">
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CE-1AA")' class="list-group-item">1) ADJUDICATION CASES NUMBER WISE - (MSR-DPM-CE-1AA)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CE-1AB")' class="list-group-item">2) ADJUDICATION CASES NUMBER WISE(COMM) - (MSR-DPM-CE-1AB)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CE-1AC")' class="list-group-item">3) ADJUDICATION CASES NUMBER WISE(ADC/JC) - (MSR-DPM-CE-1AC)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CE-1AD")' class="list-group-item">4) ADJUDICATION CASES NUMBER WISE((DC/AC) - (MSR-DPM-CE-1AD)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CE-1AE")' class="list-group-item">5) ADJUDICATION CASES NUMBER WISE(SUPDI) - (MSR-DPM-CE-1AE)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CE-1A")' class="list-group-item">6) ADJUDICATION CASES AMOUNT WISE - (MSR-DPM-CE-1AF)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CE-1C")' class="list-group-item">7) ADJUDICATION CASES ISSUED WITHIN 30 DAYS - (MSR-DPM-CE-1C)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CE-2A")' class="list-group-item">8) ADJUDICATION CASES PENDING FOR MORE THAN ONE YEAR AND ONE CRORE - (MSR-DPM-CE-2A)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CE-2B")' class="list-group-item">9) ADJUDICATION CASES INVOLVING DUTY OF MORE THAN 1 CRORE AND PENDING FOR MORE THAN TWO YEARS - (MSR-DPM-CE-2B)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CE-3A")' class="list-group-item">10) CALL BOOK CASES - (MSR-DPM-CE-3A)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-3BA")' class="list-group-item">11) CALL BOOK CASES IN WHICH DEPARTMENT HAS GONE IN APPEAL TO THE APPROPRIATE AUTHORITY - (MSR-DPM-CE-3BA)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-3BB")' class="list-group-item">12) CALL BOOK CASES WHERE INJUNCTION HAS BEEN ISSUED BY SC/HC/TRIBUNAL ETC. - (MSR-DPM-CE-3BB)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-3BC")' class="list-group-item">13) CALL BOOK CASES WHERE CERA AUDIT OBJECTIONS ARE CONTESTED - (MSR-DPM-CE-3BC)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-3BD")' class="list-group-item">14) CALL BOOK CASES WHERE BOARD HAS SPECIFICALLY ORDERED THE CASE TO BE KEPT IN CALL BOOK - (MSR-DPM-CE-3BD)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-3BE")' class="list-group-item">15) CALL BOOK CASES WHERE PARTIES HAD FILED APPLICATIONS IN SETTLEMENT COMMISSION WHICH ARE PENDING - (MSR-DPM-CE-3BE)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-REFUND-4A")' class="list-group-item">16) PENDENCY OF REFUND CASES IN DESCENDING ORDER ON THE BASIS OF MORE THAN 3 MONTHS OLD CASES - (MSR-DPM-CE-4A)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-REBATE-4B")' class="list-group-item">17) PENDENCY OF REBATE CASES IN DESCENDING ORDER ON THE BASIS OF MORE THAN 3 MONTHS OLD CASES - (MSR-DPM-CE-4B)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-4C")' class="list-group-item">18) PENDENCY OF (REFUND+REBATE) CASES IN DESCENDING ORDER ON THE BASIS OF MORE THAN 3 MONTHS OLD CASES - (MSR-DPM-CE-4C)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-5A")' style="text-transform:uppercase;" class="list-group-item">19) PENDENCY OF PROVISIONAL ASSESSMENT CASES - (MSR-DPM-CE-5)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-6")' style="text-transform:uppercase;" class="list-group-item">20) BANK GUARANTEES - (MSR-DPM-CE-6)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-7")' style="text-transform:uppercase;" class="list-group-item">21) Comparative analysis of the MPR reports in Key Performance Areas in Central Excise - (MSR-DPM-CE-7)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CE-8")' style="text-transform:none;" class="list-group-item">22) ANALYSIS OF MPRs - (MSR-DPM-CE-8)</a>

                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                            <div class="panel panel-info" data-toggle="collapse" data-target="#CusPartV">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Customs
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="CusPartV">
                                                    <div class="list-group">
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CUS-1AA")' class="list-group-item">1) ADJUDICATION CASES NUMBER WISE - (MSR-DPM-CUS-1AA)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CUS-1AB")' class="list-group-item">2) ADJUDICATION CASES NUMBER WISE(COMM) - (MSR-DPM-CUS-1AB)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CUS-1AC")' class="list-group-item">3) ADJUDICATION CASES NUMBER WISE(ADC/JC) - (MSR-DPM-CUS-1AC)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CUS-1AD")' class="list-group-item">4) ADJUDICATION CASES NUMBER WISE(DC/AC) - (MSR-DPM-CUS-1AD)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CUS-1AE")' class="list-group-item">5) ADJUDICATION CASES ON THE BASIS OF CLOSING BALANCE IN AMOUNT - (MSR-DPM-CUS-1AE)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CUS-1C")' class="list-group-item">6) ADJUDICATION CASES ISSUED WITHIN 30 DAYS - (MSR-DPM-CUS-1C)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CUS-2A")' class="list-group-item">7) ADJUDICATION CASES PENDING FOR MORE THAN ONE YEAR AND ONE CRORE - (MSR-DPM-CUS-2A)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CUS-2B")' class="list-group-item">8) ADJUDICATION CASES PENDING FOR MORE THAN TWO YEARS - (MSR-DPM-CUS-2B)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-CUS-3A")' class="list-group-item">9) CALL BOOK CASES - (MSR-DPM-CUS-3A)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-3BA")' class="list-group-item">10) CALL BOOK CASES IN WHICH DEPARTMENT HAS GONE IN APPEAL TO THE APPROPRIATE AUTHORITY - (MSR-DPM-CUS-3BA)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-3BB")' class="list-group-item">11) CALL BOOK CASES WHERE INJUNCTION HAS BEEN ISSUED BY SC/HC/TRIBUNAL ETC. - (MSR-DPM-CUS-3BB)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-3BC")' class="list-group-item">12) CALL BOOK CASES WHERE CERA AUDIT OBJECTIONS ARE CONTESTED - (MSR-DPM-CUS-3BC)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-3BD")' class="list-group-item">13) CALL BOOK CASES WHERE BOARD HAS SPECIFICALLY ORDERED THE CASE TO BE KEPT IN CALL BOOK - (MSR-DPM-CUS-3BD)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-3BE")' class="list-group-item">14) CALL BOOK CASES WHERE PARTIES HAD FILED APPLICATIONS IN SETTLEMENT COMMISSION WHICH ARE PENDING - (MSR-DPM-CUS-3BE)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-REFUND-4")' class="list-group-item">15) PENDENCY OF REFUND CASES IN DESCENDING ORDER ON THE BASIS OF MORE THAN 3 MONTHS OLD CASES - (MSR-DPM-CUS-4)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-5A")' style="text-transform: uppercase; " class="list-group-item">16) Provisional Assessment Cases - (MSR-DPM-CUS-5A)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-5BA")' style="text-transform: uppercase;" class="list-group-item">17) Provisional Assessment Cases- Pending due to SVB investigation - (MSR-DPM-CUS-5BA)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-5BB")' style="text-transform: uppercase;" class="list-group-item">18) Provisional Assessment Cases- Documents not received - (MSR-DPM-CUS-5BB)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-5BC")' style="text-transform: uppercase;" class="list-group-item">19) Provisional Assessment Cases- Awaiting for Test Reports - (MSR-DPM-CUS-5BC)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-5BD")' style="text-transform: uppercase;" class="list-group-item">20) Provisional Assessment Cases- Project Import (Waiting for End Use) - (MSR-DPM-CUS-5BD)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-5BE")' style="text-transform: uppercase;" class="list-group-item">21) Provisional Assessment Cases- Request by Assessee - (MSR-DPM-CUS-5BE)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-7A")' style="text-transform: uppercase;" class="list-group-item">22) Total No. of Bonds - (MSR-DPM-CUS-7A)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-7B")' style="text-transform: uppercase;" class="list-group-item">23) End Use Bonds - (MSR-DPM-CUS-7B)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-7C")' style="text-transform: uppercase;" class="list-group-item">24) Miscellaneous Bonds - (MSR-DPM-CUS-7C)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-7D")' style="text-transform: uppercase;" class="list-group-item">25) PD Bonds - (MSR-DPM-CUS-7D)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-7E")' style="text-transform: uppercase;" class="list-group-item">26) Test Bonds - (MSR-DPM-CUS-7E)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-7F")' style="text-transform: uppercase;" class="list-group-item">27) Unmatched Transit Bonds - (MSR-DPM-CUS-7F)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-7G")' style="text-transform: uppercase;" class="list-group-item">28) Warehousing Bonds - (MSR-DPM-CUS-7G)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-8")' style="text-transform: uppercase;" class="list-group-item">29) Bank Guarantees - (MSR-DPM-CUS-8)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-9")' style="text-transform: uppercase;" class="list-group-item">30) Drawback claims disposed/pending - (MSR-DPM-CUS-9)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-11")' style="text-transform: uppercase;" class="list-group-item">31) Monitoring of fulfillment of Export obligation- Report for EPCG (from year 1994-95) as on end of the month - (MSR-DPM-CUS-11)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-12")' style="text-transform: uppercase;" class="list-group-item">32) Monitoring of fulfillment of Export obligation- Report for AA/DFIA (from year 1991-92) as on end of the month - (MSR-DPM-CUS-12)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-CUS-13")' style="text-transform: uppercase;" class="list-group-item">33) Comparative analysis of the MPR reports in Key Performance Areas in Custom - (MSR-DPM-CUS-13)</a>




                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                            <div class="panel panel-success" data-toggle="collapse" data-target="#STPartV">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Service Tax
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="STPartV">
                                                    <div class="list-group">
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-ST-1AA")' class="list-group-item">1) ADJUDICATION CASES NUMBER WISE - (MSR-DPM-ST-1AA)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-ST-1AB")' class="list-group-item">2) ADJUDICATION CASES NUMBER WISE(COMM) - (MSR-DPM-ST-1AB)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-ST-1AC")' class="list-group-item">3) ADJUDICATION CASES NUMBER WISE(ADC/JC) - (MSR-DPM-ST-1AC)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-ST-1AD")' class="list-group-item">4) ADJUDICATION CASES NUMBER WISE((DC/AC) - (MSR-DPM-ST-1AD)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-ST-1AE")' class="list-group-item">5) ADJUDICATION CASES NUMBER WISE(SUPDI) - (MSR-DPM-ST-1AE)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-ST-1B")' class="list-group-item">6) ADJUDICATION CASES AMOUNT WISE - (MSR-DPM-ST-1AF)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-ST-1C")' class="list-group-item">7) ADJUDICATION CASES ISSUED WITHIN 30 DAYS - (MSR-DPM-ST-1C)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-ST-2A")' class="list-group-item">8) ADJUDICATION CASES PENDING FOR MORE THAN ONE YEAR AND ONE CRORE - (MSR-DPM-ST-2A)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-ST-2B")' class="list-group-item">9) ADJUDICATION CASES INVOLVING DUTY OF MORE THAN 1 CRORE AND PENDING FOR MORE THAN TWO YEARS - (MSR-DPM-ST-2B)</a>
                                                        <a href='javascript: GetReport_DPM("MSR-DPM-ST-3A")' class="list-group-item">10) CALL BOOK CASES - (MSR-DPM-ST-3A)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-ST-3BA")' class="list-group-item">11) CALL BOOK CASES IN WHICH DEPARTMENT HAS GONE IN APPEAL TO THE APPROPRIATE AUTHORITY - (MSR-DPM-ST-3BA)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-ST-3BB")' class="list-group-item">12) CALL BOOK CASES WHERE INJUNCTION HAS BEEN ISSUED BY SC/HC/TRIBUNAL ETC. - (MSR-DPM-ST-3BB)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-ST-3BC")' class="list-group-item">13) CALL BOOK CASES WHERE CERA AUDIT OBJECTIONS ARE CONTESTED - (MSR-DPM-ST-3BC)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-ST-3BD")' class="list-group-item">14) CALL BOOK CASES WHERE BOARD HAS SPECIFICALLY ORDERED THE CASE TO BE KEPT IN CALL BOOK - (MSR-DPM-ST-3BD)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-ST-3BE")' class="list-group-item">15) CALL BOOK CASES WHERE PARTIES HAD FILED APPLICATIONS IN SETTLEMENT COMMISSION WHICH ARE PENDING - (MSR-DPM-ST-3BE)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-ST-REFUND-4")' class="list-group-item">16) PENDENCY OF REFUND CASES IN DESCENDING ORDER ON THE BASIS OF MORE THAN 3 MONTHS OLD CASES - (MSR-DPM-ST-4)</a>
                                                        <a href='javascript: GetReport("MSR-DPM-ST-5A")' class="list-group-item">17) PENDENCY OF PROVISIONAL ASSESSMENT - (MSR-DPM-ST-5A)</a>
                                                        <a style="text-transform: uppercase;" href='javascript: GetReport("MSR-DPM-ST-6")' class="list-group-item">18) Comparative analysis of the MPR reports in Key Performance Areas in Service Tax - (MSR-DPM-ST-6)</a>
                                                        <a style="text-transform: none;" href='javascript: GetReport("MSR-DPM-ST-7")' class="list-group-item">19) ANALYSIS OF MPRs - (MSR-DPM-ST-7)</a>







                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                        </div>
                                        <!-- /.col-lg-4 -->
                                    </div>
                                    <!-- /.list-group -->

                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                        <!-- /.col-lg-4 -->
                    </div>


                    <div class="row" id="tbl_Part_VI">

                        <div class="col-lg-8">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <i class="fa fa-file fa-fw"></i> Part-VI Valuation
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="list-group">
                                        <a href='javascript: GetReport("MSR-DOV-CUS-1")' class="list-group-item">1) ADDITIONAL REVENUE REPORT - (MSR-DOV-1)</a>

                                    </div>
                                    <!-- /.list-group -->

                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                        <!-- /.col-lg-4 -->
                    </div>

                    <div class="row" id="tbl_Part_VII">
                        <div class="col-lg-12">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <i class="fa fa-file fa-fw"></i> Part-VII Legal
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="row" id="tbl_Part_I">
                                        <div class="col-lg-12">
                                            <div class="panel panel-danger" data-toggle="collapse" data-target="#CexPartVII">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Central Excise
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="CexPartVII">
                                                    <div class="list-group">

                                                        <a href='javascript: GetReport("MSR-DLA-CE-1A")' class="list-group-item">1) TOTAL PENDING APPEALS FILED BY THE DEPARTMENT - (MSR-DLA-CE-1)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CE-2")' class="list-group-item">2) TOTAL PENDING APPEALS FILED BY THE PARTY - (MSR-DLA-CE-2)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CE-DEPT-PARTY")' class="list-group-item">3) TOTAL PENDING APPEALS FILED BY THE DEPARTMENT + PARTY - (MSR-DLA-CE-3)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CE-1")' class="list-group-item">4) SUCCESS RATE OF DEPARTMENT IN CESTAT-DEPARTMENT APPEALS - (MSR-DLA-CE-4)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CE-2-PARTY")' class="list-group-item">5) SUCCESS RATE OF DEPARTMENT IN CESTAT-PARTY APPEALS - (MSR-DLA-CE-5)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CE-6-DEPT")' class="list-group-item">6) SUCCESS RATE OF DEPARTMENT IN HIGH COURT-DEPARTMENT APPEALS - (MSR-DLA-CE-6)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CE-7-PARTY")' class="list-group-item">7) SUCCESS RATE OF DEPARTMENT IN HIGH COURT-PARTY APPEALS - (MSR-DLA-CE-7)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CE-8-DEPT")' class="list-group-item">8) SUCCESS RATE OF DEPARTMENT IN SUPREME COURT-DEPARTMENT APPEALS - (MSR-DLA-CE-8)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CE-9-PARTY")' class="list-group-item">9) SUCCESS RATE OF DEPARTMENT IN SUPREME COURT-PARTY APPEALS - (MSR-DLA-CE-9)</a>

                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                            <div class="panel panel-info" data-toggle="collapse" data-target="#CusPartVII">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Customs
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="CusPartVII">
                                                    <div class="list-group">

                                                        <a href='javascript: GetReport("MSR-DLA-CUS-1A")' class="list-group-item">10) TOTAL PENDING APPEALS FILED BY THE DEPARTMENT - (MSR-DLA-CUS-1)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CUS-2")' class="list-group-item">11) TOTAL PENDING APPEALS FILED BY THE PARTY - (MSR-DLA-CUS-2)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CUS-DEPT-PARTY")' class="list-group-item">12) TOTAL PENDING APPEALS FILED BY THE DEPARTMENT + PARTY - (MSR-DLA-CUS-3)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CUS-1")' class="list-group-item">13) SUCCESS RATE OF DEPARTMENT IN CESTAT-DEPARTMENT APPEALS - (MSR-DLA-CUS-4)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CUS-2-PARTY")' class="list-group-item">14) SUCCESS RATE OF DEPARTMENT IN CESTAT-PARTY APPEALS - (MSR-DLA-CUS-5)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CUS-6-DEPT")' class="list-group-item">15) SUCCESS RATE OF DEPARTMENT IN HIGH COURT-DEPARTMENT APPEALS - (MSR-DLA-CUS-6)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CUS-7-PARTY")' class="list-group-item">16) SUCCESS RATE OF DEPARTMENT IN HIGH COURT-PARTY APPEALS - (MSR-DLA-CUS-7)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CUS-8-DEPT")' class="list-group-item">17) SUCCESS RATE OF DEPARTMENT IN SUPREME COURT-DEPARTMENT APPEALS - (MSR-DLA-CUS-8)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CUS-9-PARTY")' class="list-group-item">18) SUCCESS RATE OF DEPARTMENT IN SUPREME COURT-PARTY APPEALS - (MSR-DLA-CUS-9)</a>
                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                            <div class="panel panel-success" data-toggle="collapse" data-target="#STPartVII">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Service Tax
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="STPartVII">
                                                    <div class="list-group">

                                                        <a href='javascript: GetReport("MSR-DLA-ST-1A")' class="list-group-item">19) TOTAL PENDING APPEALS FILED BY THE DEPARTMENT - (MSR-DLA-ST-1)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-ST-2")' class="list-group-item">20) TOTAL PENDING APPEALS FILED BY THE PARTY - (MSR-DLA-ST-2)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-ST-DEPT-PARTY")' class="list-group-item">21) TOTAL PENDING APPEALS FILED BY THE DEPARTMENT + PARTY - (MSR-DLA-ST-3)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-ST-1")' class="list-group-item">22) SUCCESS RATE OF DEPARTMENT IN CESTAT-DEPARTMENT APPEALS - (MSR-DLA-ST-4)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-ST-2-PARTY")' class="list-group-item">23) SUCCESS RATE OF DEPARTMENT IN CESTAT-PARTY APPEALS - (MSR-DLA-ST-5)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-ST-6-DEPT")' class="list-group-item">24) SUCCESS RATE OF DEPARTMENT IN HIGH COURT-DEPARTMENT APPEALS - (MSR-DLA-ST-6)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-ST-7-PARTY")' class="list-group-item">25) SUCCESS RATE OF DEPARTMENT IN HIGH COURT-PARTY APPEALS - (MSR-DLA-ST-7)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-ST-8-DEPT")' class="list-group-item">26) SUCCESS RATE OF DEPARTMENT IN SUPREME COURT-DEPARTMENT APPEALS - (MSR-DLA-ST-8)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-ST-9-PARTY")' class="list-group-item">27) SUCCESS RATE OF DEPARTMENT IN SUPREME COURT-PARTY APPEALS - (MSR-DLA-ST-9)</a>
                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                            <div class="panel panel-warning" data-toggle="collapse" data-target="#CCSPartVII">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Central Excise + Customs + Service Tax
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="CCSPartVII">
                                                    <div class="list-group">
                                                        <a href='javascript: GetReport("MSR-DLA-1A")' class="list-group-item">28) TOTAL PENDING APPEALS FILED BY THE DEPARTMENT - (MSR-DLA-1)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CESTAT-TOTAL-DEPT")' class="list-group-item">29) SUCCESS RATE OF DEPARTMENT IN CESTAT- DEPARTMENT APPEALS - (MSR-DLA-2)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CESTAT-TOTAL-PARTY")' class="list-group-item">30) SUCCESS RATE OF DEPARTMENT IN CESTAT- PARTY APPEALS - (MSR-DLA-3)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-CESTAT-DEPT-PARTY")' class="list-group-item">31) OVERALL SUCCESS RATE OF DEPARTMENT IN CESTAT- DEPARTMENT APPEALS + PARTY APPEALS - (MSR-DLA-4)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-5-HIGH-DEPT")' class="list-group-item">32) SUCCESS RATE OF DEPARTMENT IN HIGH COURT- DEPARTMENT APPEALS - (MSR-DLA-5)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-6-HIGH-PARTY")' class="list-group-item">33) SUCCESS RATE OF DEPARTMENT IN HIGH COURT- PARTY APPEALS - (MSR-DLA-6)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-7-HIGH-DEPT-PARTY")' class="list-group-item">34) OVERALL SUCCESS RATE OF DEPARTMENT IN HIGH COURT- DEPARTMENT APPEALS + PARTY APPEALS - (MSR-DLA-7)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-8-SUP-DEPT")' class="list-group-item">35) SUCCESS RATE OF DEPARTMENT IN SUPREME COURT- DEPARTMENT APPEALS - (MSR-DLA-8)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-9-SUP-PARTY")' class="list-group-item">36) SUCCESS RATE OF DEPARTMENT IN SUPREME COURT- PARTY APPEALS - (MSR-DLA-9)</a>
                                                        <a href='javascript: GetReport("MSR-DLA-10-SUP-DEPT-PARTY")' class="list-group-item">37) OVERALL SUCCESS RATE OF DEPARTMENT IN SUPREME COURT- DEPARTMENT APPEALS + PARTY APPEALS - (MSR-DLA-10)</a>

                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                        </div>
                                        <!-- /.col-lg-4 -->
                                    </div>
                                    <!-- /.list-group -->

                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                        <!-- /.col-lg-4 -->
                    </div>

                    <div class="row" id="tbl_Part_VIII">
                        <div class="col-lg-12">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <i class="fa fa-file fa-fw"></i> Part-VIII Arrears
                                </div>
                                <div class="panel-body">
                                    <a href='javascript: GetReport("MSR-TAR-5")' class="list-group-item">TAX ARREARS RECOVERY - (MSR-TAR-5)</a>

                                    <!-- /.list-group -->

                                </div>
                                <!-- /.panel-body -->
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="row" id="tbl_Part_I">
                                        <div class="col-lg-12">

                                            <div class="panel panel-danger" data-toggle="collapse" data-target="#CexPartVIII">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Central Excise
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse in" id="CexPartVIII">
                                                    <div class="list-group">

                                                        <a href='javascript: GetReport("MSR-TAR-CE-1")' class="list-group-item">1) CASES PENDING WITH LEGAL FORUM - (MSR-TAR-CE-1)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-CE-2")' class="list-group-item">2) PENDING CASES OF RESTRAINED ARREARS - (MSR-TAR-CE-2)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-CE-3")' class="list-group-item">3) RECOVERABLE ARREARS - (MSR-TAR-CE-3)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-CE-4")' class="list-group-item">4) TAX ARREARS STATEMENT - (MSR-TAR-CE-4)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-CE-6")' class="list-group-item">5) SUMMARY OF ARREARS(AS PER FRBM RULES) - (MSR-TAR-CE-6)</a>
                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                            <div class="panel panel-info" data-toggle="collapse" data-target="#CusPartVIII">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Customs
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="CusPartVIII">
                                                    <div class="list-group">
                                                        <a href='javascript: GetReport("MSR-TAR-CUS-1")' class="list-group-item">5) CASES PENDING WITH LEGAL FORUM - (MSR-TAR-CUS-1)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-CUS-2")' class="list-group-item">6) PENDING CASES OF RESTRAINED ARREARS - (MSR-TAR-CUS-2)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-CUS-3")' class="list-group-item">7) RECOVERABLE ARREARS - (MSR-TAR-CUS-3)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-CUS-4")' class="list-group-item">8) TAX ARREARS STATEMENT - (MSR-TAR-CUS-4)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-CUS-6")' class="list-group-item">5) SUMMARY OF ARREARS(AS PER FRBM RULES) - (MSR-TAR-CUS-6)</a>
                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>

                                            <div class="panel panel-success" data-toggle="collapse" data-target="#STPartVIII">
                                                <div class="panel-heading">
                                                    <i class="fa fa-file fa-fw"></i> Service Tax
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body collapse" id="STPartVIII">
                                                    <div class="list-group">
                                                        <a href='javascript: GetReport("MSR-TAR-ST-1")' class="list-group-item">9) CASES PENDING WITH LEGAL FORUM - (MSR-TAR-ST-1)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-ST-2")' class="list-group-item">10) PENDING CASES OF RESTRAINED ARREARS - (MSR-TAR-ST-2)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-ST-3")' class="list-group-item">11) RECOVERABLE ARREARS - (MSR-TAR-ST-3)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-ST-4")' class="list-group-item">12) TAX ARREARS STATEMENT - (MSR-TAR-ST-4)</a>
                                                        <a href='javascript: GetReport("MSR-TAR-ST-6")' class="list-group-item">5) SUMMARY OF ARREARS(AS PER FRBM RULES) - (MSR-TAR-ST-6)</a>
                                                    </div>
                                                    <!-- /.list-group -->

                                                </div>
                                                <!-- /.panel-body -->
                                            </div>



                                        </div>
                                        <!-- /.col-lg-4 -->
                                    </div>
                                    <!-- /.list-group -->

                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                        <!-- /.col-lg-4 -->
                    </div>

                    <div class="row" id="tbl_Part_IX">

                        <div class="col-lg-12">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <i class="fa fa-file fa-fw"></i> Part-IX Logistics
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="list-group">

                                        <a href='javascript: GetReport("MSR-DOL-1")' class="list-group-item">1) DISPOSAL TARGET ACHIEVEMENT - (MSR-DOL-1)</a>
                                        <a href='javascript: GetReport("MSR-DOL-2")' class="list-group-item">2) COMMODITY WISE MONTHLY DISPOSAL - (MSR-DOL-2)</a>
                                        <a href='javascript: GetReport("MSR-DOL-3")' class="list-group-item">3) QUATERLY DISPOSAL - (MSR-DOL-3)</a>
                                        <a href='javascript: GetReport("MSR-DOL-4")' class="list-group-item">4) E-AUCTION - (MSR-DOL-4)</a>


                                    </div>
                                    <!-- /.list-group -->

                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                        <!-- /.col-lg-4 -->
                    </div>


                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>

</div>

<!-- @*Inline Plugin Script For Validation Purpose*@ -->
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#MSR').css('color', 'black');
        $("#ddl_mth").val('@DateTime.Now.AddDays(15).AddMonths(-1).Month');
        HideList()
        $("#tbl_Part_I").show();
        //$("#tbl_Part_II").show();

        // work for revenue dropdown
        $("#MSR_Month_To").hide();
        $("#MSR_Year_To").hide();
        $("#MSR_Year_From").hide();
        $("#MSR_Year_Months").hide();

        var part = $('#ddl_ReportGroup').val();

        if (part == 'tbl_Part_I') {
            $("#Non_Revenue_Heading").hide();
            $("#Revenue_Heading").show();
        }
        else {
            $("#Non_Revenue_Heading").show();
            $("#Revenue_Heading").hide();
            $("#MSR_Month_To").hide();
            $("#MSR_Year_To").hide();
            $("#MSR_Year_From").hide();

            $("#MSR_Year_Months").hide();

        }
    });

    $("#ddl_ReportGroup").change(function () {
        var part = jQuery(this).val();
        if (part != 'tbl_Part_I') {
            $("#Non_Revenue_Heading").show();
            $("#Revenue_Heading").hide();
            $("#MSR_Month_To").hide();
            $("#MSR_Year_To").hide();
            $("#MSR_Year_From").hide();

            $("#MSR_Report_Name").show();
            $("#MSR_Year").show();
            $("#MSR_Month").show();

            $("#MSR_Report_Name").removeClass();
            $("#MSR_Report_Name").addClass('col-lg-4');
            $("#MSR_Year").removeClass();
            $("#MSR_Year").addClass('col-lg-4');
            $("#MSR_Month").removeClass();
            $("#MSR_Month").addClass('col-lg-4');


            $("#MSR_Year_Months").hide();

        }
        else if (part == 'tbl_Part_I') {
            $("#Non_Revenue_Heading").hide();
            $("#Revenue_Heading").show();
        }
    });


    $('#advanced_report').change(function () {
        var adv_report = jQuery(this).val();
        if (adv_report == 'months_wise') {
            $("#MSR_Report_Name").removeClass();
            $("#MSR_Report_Name").addClass('col-lg-4');
            $("#MSR_Year").removeClass();
            $("#MSR_Year").addClass('col-lg-2');
            $("#MSR_Month").removeClass();
            $("#MSR_Month").addClass('col-lg-2');
            $("#MSR_Month_To").removeClass();
            $("#MSR_Month_To").addClass('col-lg-2');
            $("#MSR_Year_Months").removeClass();
            $("#MSR_Year_Months").addClass('col-lg-2');

            $("#MSR_Report_Name").show();
            $("#MSR_Year").show();
            $("#MSR_Month").show();
            $("#MSR_Month_To").show();
            $("#MSR_Year_Months").show();

            $("#MSR_Year_To").hide();
            $("#MSR_Year_From").hide();

            $("#ddm_ce_4_hide").hide();
            $("#ddm_cus_4_hide").hide();


        }
        else if (adv_report == 'years_wise') {

            $("#MSR_Report_Name").removeClass();
            $("#MSR_Report_Name").addClass('col-lg-4');

            $("#MSR_Year_From").removeClass();
            $("#MSR_Year_From").addClass('col-lg-4');

            $("#MSR_Year_To").removeClass();
            $("#MSR_Year_To").addClass('col-lg-4');


            $("#MSR_Report_Name").show();
            $("#MSR_Year_From").show();
            $("#MSR_Year_To").show();

            $("#MSR_Month_To").hide();
            $("#MSR_Month").hide();
            $("#MSR_Year").hide();
            $("#ddm_ce_4_hide").hide();
            $("#ddm_cus_4_hide").hide();
            $("#MSR_Year_Months").hide();






        }
        else {
            $("#MSR_Report_Name").removeClass();
            $("#MSR_Report_Name").addClass('col-lg-4');

            $("#MSR_Year").removeClass();
            $("#MSR_Year").addClass('col-lg-4');

            $("#MSR_Month").removeClass();
            $("#MSR_Month").addClass('col-lg-4');

            $("#MSR_Report_Name").show();
            $("#MSR_Year").show();
            $("#MSR_Month").show();

            $("#MSR_Month_To").hide();
            $("#MSR_Year_To").hide();
            $("#MSR_Year_From").hide();
            $("#MSR_Year_Months").hide();

            $("#ddm_ce_4_hide").show();
            $("#ddm_cus_4_hide").show();

        }
    });



    //end work of revenue dropdown

    function GetReport(reportname) {
        var url = '';
        if (jQuery('#advanced_report').val() == 'years_wise') {
            reportname = reportname + "_YEARLY";
            url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>" + "GST" + reportname.substring(4, 7) + "/MSR/" + reportname.replace(/\-/g, '_') + "/All/0/All India/" + $('#ddl_year_from').val() + "-" + $("#ddl_year_to").val() +"/<%=request.getSession().getAttribute("CSRF_Token").toString() %>";
        }
        else if (jQuery('#advanced_report').val() == 'months_wise') {
            reportname = reportname + "_MONTHLY";

            url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>" + "GST" + reportname.substring(4, 7) + "/MSR/" + reportname.replace(/\-/g, '_') + "/All/0/All India/" + $('#ddl_year').val() + "-" + $("#ddl_mth option:selected").text() + "/" + $('#ddl_year_months').val() + "-" + $("#ddl_mth_to option:selected").text()+"/<%=request.getSession().getAttribute("CSRF_Token").toString() %>";;
        }
        else {
            url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>" + "GST" + reportname.substring(4, 7) + "/MSR/" + reportname.replace(/\-/g, '_') + "/All/0/All India/" + $('#ddl_year').val() + "-" + $("#ddl_mth option:selected").text()+"/<%=request.getSession().getAttribute("CSRF_Token").toString() %>";;
        }
        window.open(url, '_blank');

    }
    function GetReport_DPM(reportname) {

        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>" + "GST" + reportname.substring(4, 7) + "/MSR/" + reportname.replace(/\-/g, '_') + "/All/0/DSC/" + $('#ddl_year').val() + "-" + $("#ddl_mth option:selected").text()+"/<%=request.getSession().getAttribute("CSRF_Token").toString() %>";
        //var url = "/MIS/" + reportname.substring(4, 7) + "/MSR/" + reportname.replace(/\-/g, '_') + "/All/0/All India/" + $('#ddl_year').val() + "-" + $("#ddl_mth option:selected").text() + "/DSC";
        window.open(url, '_blank');
    }
    function MSR_List(tbl) {
        HideList()
        $("#" + tbl).show();

        parthide();

    }
    function HideList() {
        $("#tbl_Part_I").hide();
        $("#tbl_Part_II").hide();
        $("#tbl_Part_III").hide();
        $("#tbl_Part_IV").hide();
        $("#tbl_Part_V").hide();
        $("#tbl_Part_VI").hide();
        $("#tbl_Part_VII").hide();
        $("#tbl_Part_VIII").hide();
        $("#tbl_Part_IX").hide();

    }

    function parthide() {

        var part = $('#ddl_ReportGroup').val();
        var year = $('#ddl_year').val();
        var month = $('#ddl_mth').val();

        if ((part = 'tbl_Part_V') && (year <= 2016 && month < 12)) {
            $("#td_7").hide();
            $("#td_13").hide();
            $("#td_6").hide();

            $("#td_CE_8").hide();
            $("#td_ST_7").hide();
        }
        else {

            $("#td_7").show();
            $("#td_13").show();
            $("#td_6").show();

            $("#td_CE_8").show();
            $("#td_ST_7").show();
        }

    }

    $(function () {
        $('tr.parent')
            .css("cursor", "pointer")
            .attr("title", "Click to expand/collapse")
            .click(function () {
                $(this).siblings('.child-' + this.id).toggle();
            });
        $('tr[class^=child-]').hide().children('td');
    });

    //Start Here to bind the Monthly Year

    jQuery('#ddl_year').change(function () {
        var currentSelectedValue = $(this).val();
        var currentYear = new Date().getFullYear();
        var currentMonth = new Date().getMonth();
        if (currentSelectedValue != '') {

            var SelectedYear = parseInt(currentSelectedValue);

            var totalMonths = 11;
            if (SelectedYear == currentYear) {
                totalMonths = currentMonth-1;
            }
            var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
            //Emptying the Month Dropdown to clear our last values
            $('#ddl_mth').empty();
            $('#ddl_mth_to').empty();
            $('#ddl_mth_to').append('<option value="">-Select Month-</option>');
            $('#ddl_mth').append('<option value="">-Select Month-</option>');

            //Appending Current Valid Months
            for (var month = 0; month <= totalMonths; month++) {
                if (SelectedYear == '2017') {
                    if (parseInt(month + 1) >= 7) {
                        $('#ddl_mth').append('<option value="' + (month + 1) + '">' + monthNames[month] + '</option>');
                    }
                }
                else {
                    $('#ddl_mth').append('<option value="' + (month + 1) + '">' + monthNames[month] + '</option>');
                }
            }
        }
    });


    jQuery('#ddl_mth').change(function () {
        var currentSelectedYear = $('#ddl_year').val();
        var currentYear = new Date().getFullYear();
        var currentMonth = new Date().getMonth();
        var SelectedMonth = $('#ddl_mth').val();
        $('#ddl_year_months').empty();
        if (SelectedMonth != '') {

            var SelectedYear = parseInt(currentSelectedYear);
            var totalMonths = 11;

            if (SelectedYear == currentYear) {
                totalMonths = currentMonth;
                $('#ddl_year_months').append('<option value="' + (currentYear) + '">' + currentYear + '</option>');
            }
            else if (parseInt(SelectedMonth) == 12) {
                $('#ddl_year_months').append('<option value="' + (SelectedYear + 1) + '">' + (SelectedYear + 1) + '</option>');
                totalMonths = currentMonth;
            }
            else {
                $('#ddl_year_months').append('<option value="' + (SelectedYear) + '">' + SelectedYear + '</option>');
                $('#ddl_year_months').append('<option value="' + (SelectedYear + 1) + '">' + (SelectedYear + 1) + '</option>');
            }
            var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
            //Emptying the Month Dropdown to clear our last values
            $('#ddl_mth_to').empty();
            $('#ddl_mth_to').append('<option value="">-Select Month-</option>');

            //Appending Current Valid Months
            for (var month = 0; month <= totalMonths; month++) {
                if (parseInt(SelectedMonth) == 12) {
                    $('#ddl_mth_to').append('<option value="' + (month + 1) + '">' + monthNames[month] + '</option>');

                }
                else if (parseInt(month + 1) >= parseInt(SelectedMonth)) {
                    if (parseInt(SelectedMonth) != parseInt(month + 1)) {
                        $('#ddl_mth_to').append('<option value="' + (month + 1) + '">' + monthNames[month] + '</option>');
                    }
                }
            }
        }
    });

    $('#ddl_year_months').change(function () {
        var UptoYearSelected = jQuery(this).val();
        var FromYearSelected = $('#ddl_year').val();
        var currentYear = new Date().getFullYear();
        var currentMonth = new Date().getMonth();
        var FromSelectedMonth = $('#ddl_mth').val();
        if (UptoYearSelected != '') {
            var SelectedYear = parseInt(UptoYearSelected);
            var totalMonths = 11;

            if (UptoYearSelected == currentYear) {
                totalMonths = currentMonth;

            }

            var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
            //Emptying the Month Dropdown to clear our last values
            $('#ddl_mth_to').empty();
            $('#ddl_mth_to').append('<option value="">-Select Month-</option>');
           
            //Appending Current Valid Months
            for (var month = 0; month <= totalMonths; month++) {
                if (UptoYearSelected == FromYearSelected) {
                    if (parseInt(month + 1) >= parseInt(FromSelectedMonth)) {
                        if (parseInt(FromSelectedMonth) != parseInt(month + 1)) {
                            $('#ddl_mth_to').append('<option value="' + (month + 1) + '">' + monthNames[month] + '</option>');
                        }
                    }
                }
                else {
                    $('#ddl_mth_to').append('<option value="' + (month + 1) + '">' + monthNames[month] + '</option>');
                }
            }
        }

    });



</script>
    
    
<jsp:include page="Footer.jsp" />

