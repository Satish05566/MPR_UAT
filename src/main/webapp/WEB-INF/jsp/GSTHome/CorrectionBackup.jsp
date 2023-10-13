<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ include file="../../../Layout/_GSTLayout.jsp"%>
	
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><i class="fa fa-external-link fa-fw"></i> Correction Request</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-warning">
             
<!--                 @using (Html.BeginForm(null, null, FormMethod.Post, new { id = "__AjaxAntiForgeryForm" })) -->
<!--                 { -->
<!--                     @Html.AntiForgeryToken() -->
                    
                    <form method="post" id="__AjaxAntiForgeryForm">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="col-lg-2">
                                    <div class="form-group">
                                      <select id="ddl_dep" onchange="javascript:GetZone();" class="form-control">
                                <option value="">Select Stream</option>
                                <option value="CEX">Central Excise</option>
                                 <option value="CUS">Customs</option>
                                  <option value="STX">Service Tax</option>
                                   <option value="GST">GST</option>
                                </select>
                                    
                                    
<!--                                         @Html.DropDownList("ddl_dep", new List<SelectListItem> -->
<!--       { -->
<!--         new SelectListItem { Text = "Central Excise", Value = "CEX"}, -->
<!--         new SelectListItem { Text = "Customs", Value = "CUS"}, -->
<!--         new SelectListItem { Text = "Service Tax", Value = "STX"}, -->
<!--         new SelectListItem { Text = "GST", Value = "GST"} -->
<!--         }, "Select Stream", -->
<!--           new { onchange = "javascript:GetZone();", @class = "form-control" } -->
<!--      ) -->
                                    </div>
                                </div>

                                <div class="col-lg-2" id="ddlzone_div">
                                    <div class="form-group">
                                        <select id="ddlzone" name="ddlzone" onchange="javascript: GetComm(this.value);" class="form-control"></select>

                                    </div>
                                </div>

                                <div class="col-lg-2" id="ddlcomm_div">
                                    <div class="form-group">

                                        <select id="ddlcomm" name="ddlcomm" class="form-control"></select>
                                    </div>
                                </div>

                                <div class="col-lg-2">
                                    <div class="form-group">
                                        <select id="ddl_ReportGroup" name="ddl_ReportGroup" onchange="javascript:GetMPR();" class="form-control"></select>

                                    </div>
                                </div>

                                <div class="col-lg-2">
                                    <div class="form-group">

                                        <select id="ddl_MPR" name="ddl_MPR" class="form-control"></select>
                                    </div>
                                </div>

                                <div class="col-lg-2">
                                    <div class="form-group">
                                    
                                     <select id="ddl_year" class="form-control">
                                   <option value="">All Year</option>
                                <option value="2017">2017</option>
                                  <option value="2018">2018</option>
                                  <option value="2019">2019</option>
                                  <option value="2020">2020</option>
                                  <option value="2021">2021</option>
                                </select>
<!--                                         @{ -->
<!--                     var listItems = new List<SelectListItem>(); -->

<!--                     int i = 0; -->
<!--                     if (DateTime.Now.Month > 1) -->
<!--                     { -->
<!--                         i = DateTime.Now.Year; -->
<!--                     } -->
<!--                     else -->
<!--                     { -->
<!--                         i = DateTime.Now.Year - 1; -->
<!--                     } -->
<!--                     while (i >= 2017) -->
<!--                     { -->
<!--                         listItems.Add(new SelectListItem { Text = i.ToString(), Value = i.ToString() }); -->
<!--                         i = i - 1; -->
<!--                     } -->
<!--                     @Html.DropDownList("ddl_year", listItems, "All Year", new { @class = "form-control" }) -->
<!--                                         } -->
                                    </div>
                                </div>

                                <div class="col-lg-2">
                                    <div class="form-group">
                                    
                                       <select id="ddl_mth" class="form-control">
                                
                                 <option value="">All Month</option>
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
                                
<!--                                         @Html.DropDownList("ddl_mth", new List<SelectListItem> -->
<!--              { -->
<!--                new SelectListItem { Text = "APR", Value = "4"}, -->
<!--                new SelectListItem { Text = "MAY", Value = "5"}, -->
<!--                new SelectListItem { Text = "JUN", Value = "6"}, -->
<!--                new SelectListItem { Text = "JUL", Value = "07"}, -->
<!--                new SelectListItem { Text = "AUG", Value = "8"}, -->
<!--                new SelectListItem { Text = "SEP", Value = "9"}, -->
<!--                new SelectListItem { Text = "OCT", Value = "10"}, -->
<!--                new SelectListItem { Text = "NOV", Value = "11"}, -->
<!--                new SelectListItem { Text = "DEC", Value = "12"}, -->
<!--                new SelectListItem { Text = "JAN", Value = "1"}, -->
<!--                new SelectListItem { Text = "FEB", Value = "2"}, -->
<!--                new SelectListItem { Text = "MAR", Value = "3"} -->

<!--                }, "All Month", new { @class = "form-control" }) -->
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12">
                                <div class="form-group">
                                    <a href="javascript:CorrectionList();" class="btn btn-success float-right">View Report</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <div class="row" id="table_div">
        <div class="col-lg-12">
            <div class="panel panel-danger">
           
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover" id="tbl_Report"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>

<script src="../../../Content-GST/jsGST/jquery.js"></script>

<script language="javascript" type="text/javascript">
    $(document).ready(function () {
        $('#table_div').hide();
        if ('@Session["TYPE"]' == 'COMMISSIONERATE') {
            $("#ddlzone").hide();
            $("#ddlcomm").hide();
            $("#ddlzone_div").hide();
            $("#ddlcomm_div").hide();
           
        }

        if ('@Session["TYPE"]' == 'ZONE') {
            $("#ddlzone").hide();
            $("#ddlzone_div").hide();         
            GetComm('@Session["CODE"]', 'CEX')
        }
        //$('#MPR').css('color', 'black');
        if ('@Request["MPR"]' != '' && '@Request["MM_YYYY"]' != '') {

            var form = $('#__AjaxAntiForgeryForm');
            var token = $('input[name="__RequestVerificationToken"]', form).val();

            $.ajax({
                url: "/MIS/GSTHome/Correction_Backup_List/",
                data: {
                    __RequestVerificationToken: token, mpr: '@Request["MPR"]', group: '', comm_code: '', zone_code: '', dep: '', MM_YYYY: '@Request["MM_YYYY"]'
                },
                cache: false,
                type: "POST",
                success: function (data) {
                    Correction_Report(data);
                },
                error: function (reponse) {
                    alert("error : " + reponse);
                }
            });
        }


        //-------------------------------------
    });
    function GetMPR() {

        var form = $('#__AjaxAntiForgeryForm');
        var token = $('input[name="__RequestVerificationToken"]', form).val();

        var _group = $("#ddl_ReportGroup option:selected").text();
        var _dep = $("#ddl_dep").val()
        var url = "/MIS/GSTHome/MPR_Bind/";
        $.ajax({
            url: url,
            data:
                {
                    __RequestVerificationToken: token,
                    dep: _dep,
                    group: _group
                },
            cache: false,
            type: "POST",
            success: function (data) {

                if (data != '[]' && data != '') {
                    var arr = [];
                    arr = $.parseJSON(data);
                    var markup = "<option value=''>Select MPR</option>";
                    for (var x = 0; x < arr.length; x++) {
                        markup += "<option value='" + arr[x] + "'>" + arr[x] + "</option>";
                    }
                }
                $("#ddl_MPR").html(markup).show();

            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }
    function GetZone(dep) {


        GetReportGroup($('#ddl_dep').val());
        if ('@Session["TYPE"]' == 'ZONE' || '@Session["TYPE"]' == 'COMMISSIONERATE') {
            return false;
        }
        var procemessage = "<option value='0'> Please wait...</option>";

        var form = $('#__AjaxAntiForgeryForm');
        var token = $('input[name="__RequestVerificationToken"]', form).val();

        $("#ddlzone").html(procemessage).show();
        var url = "/MIS/GSTHome/Zone_Bind/";



        $.ajax({
            url: url,
            data: { __RequestVerificationToken: token, dep: dep },
            cache: false,
            type: "POST",
            success: function (data) {
                var markup = "<option value=''>All India</option>";
                for (var x = 0; x < data.length; x++) {
                    markup += "<option value=" + data[x].Value + ">" + data[x].Text + "</option>";
                }
                $("#ddlzone").html(markup).show();
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }
    function GetComm(zoneId, dep) {
        var procemessage = "<option value='0'> Please wait...</option>";

        var form = $('#__AjaxAntiForgeryForm');
        var token = $('input[name="__RequestVerificationToken"]', form).val();

        $("#ddlcomm").html(procemessage).show();
        var url = "/MIS/GSTHome/Comm_Bind/";

        $.ajax({
            url: url,
            data: { __RequestVerificationToken: token, zone: zoneId, dep: $('#ddl_dep').val() },
            cache: false,
            type: "POST",
            success: function (data) {
                var markup = "<option value=''>All</option>";
                for (var x = 0; x < data.length; x++) {
                    markup += "<option value=" + data[x].Value + ">" + data[x].Text + "</option>";
                }
                $("#ddlcomm").html(markup).show();
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }
    function GetReportGroup(dep) {
        var url = "/MIS/GSTHome/ReportGroup_Bind/";

        var form = $('#__AjaxAntiForgeryForm');
        var token = $('input[name="__RequestVerificationToken"]', form).val();

        $.ajax({
            url: url,
            data: { __RequestVerificationToken: token, dep: dep },
            cache: false,
            type: "POST",
            success: function (data) {
                var markup;
                for (var x = 0; x < data.length; x++) {
                    markup += "<option value=" + data[x].Text + ">" + data[x].Text + "</option>";
                }
                $("#ddl_ReportGroup").html(markup).show();
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }
    //------------------------------------------------------------------------------------------------
    function ReportEmpty() {
        $("#tbl_Report").html('').show();

    }
    function CorrectionList() {
        $('#table_div').show();
        var comm_code = $('#ddlcomm').val();
        var zone_code = $('#ddlzone').val();
        var mm_yyyy = '1900-01-01';
        var group;

        if ($("#ddl_ReportGroup option:selected").text() == 'Select Report Group') {
            group = '';
        }
        else {
            group = $("#ddl_ReportGroup option:selected").text();
        }
        if ($('#ddl_year').val() != '' && $('#ddl_mth').val() != '') {
            mm_yyyy = $('#ddl_year').val() + '-' + $('#ddl_mth').val() + '-01';
        }

        if ('@Session["TYPE"]' == "COMMISSIONERATE") {
            comm_code = '@Session["CODE"]';
        }

        if ('@Session["TYPE"]' == "ZONE") {
            zone_code = '@Session["CODE"]';
        }
        var url = "/MIS/GSTHome/Correction_Backup_List/";

        var form = $('#__AjaxAntiForgeryForm');
        var token = $('input[name="__RequestVerificationToken"]', form).val();

        $.ajax({
            url: url,
            data: {
                __RequestVerificationToken: token, mpr: $('#ddl_MPR').val(), group: group, comm_code: comm_code, zone_code: zone_code, dep: $('#ddl_dep').val(), MM_YYYY: mm_yyyy
            },
            cache: false,
            type: "POST",
            success: function (data) {
                Correction_Report(data);



            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });
    }
    function Correction_Report(data) {

        var markup = "";
        if (data != '[]') {
            var arr = [];
            arr = $.parseJSON(data);
            markup += "<thead >"
            markup += "<tr> <th>COMMISSIONERATE</th>"
            //markup += "<th>FUNCTIONAL OWNER</th>"
            markup += "<th>MPR</th>"
            markup += "<th>YEAR/MONTH</th>"
            markup += "<th>SUBMISSION DATE & TIME</th>"
            markup += "<th>VALIDATION DATE & TIME</th>"
            markup += "<th>APPROVAL DATE</th>"
            markup += "<th>STATUS</th>"
            markup += "<th>REMARKS</th>"
            markup += "<th>ACTION</th>"
            markup += "</tr>"
            markup += "</thead>"
            var count1 = 1;

            for (var x = 0; x < arr.length; x++) {
                if (count1 == 1) { markup += "<div><tr>" }
                markup += "<td>" + arr[x].COMM_NAME + "</td>"
                //markup += "<td>" + arr[x].FO + "</td>"
                markup += "<td>" + arr[x].MPR + "</td>"
                markup += "<td>" + arr[x].MM_YYYY.substring(0, 10) + "</td>"
                markup += "<td>" + arr[x].SUBMISSION_DT + "</td>"

                if (arr[x].VALIDATION_DT != null) {
                    markup += "<td>" + arr[x].VALIDATION_DT + "</td>"
                }
                else {
                    markup += "<td></td>"
                }
                if (arr[x].CORRECTION_DT != null) {
                    markup += "<td>" + arr[x].CORRECTION_DT + "</td>"
                }
                else {
                    markup += "<td></td>"
                }

                markup += "<td>" + arr[x].STATUS + "</td>"
                markup += "<td>" + arr[x].REMARKS + "</td>"

                if (arr[x].STATUS == "APPROVED") {
                    markup += "<td><a class='btn btn-success' href='javascript: GetReport(" + '"' + arr[x].MPR + '"' + ',' + '"' + arr[x].COMM_NAME + '"' + ',' + '"' + arr[x].MM_YYYY + '"' + ',' + '"' + arr[x].SUBMISSION_DT + '"' + ',' + '"' + arr[x].MAX_MM_YYYY + '"' + ");'>View Earlier Report</a></td>"
                }

                else if (arr[x].STATUS == "REJECTED") {
                    markup += "<td></td>"
                }


                else if (arr[x].STATUS == "PENDING FOR VALIDATION") {
                    markup += "<td><a class='btn btn-primary' href='javascript: GetReportCRR(" + '"' + arr[x].MPR + '"' + ',' + '"' + arr[x].COMM_NAME + '"' + ',' + '"' + arr[x].MM_YYYY + '"' + ',' + '"' + arr[x].SUBMISSION_DT + '"' + ',' + '"' + arr[x].MAX_MM_YYYY + '"' + ");'>View Corrected Report</a></td>"
                }


                else if (arr[x].STATUS == "PENDING FOR APPROVAL") {

                    markup += "<td><a class='btn btn-warning' href='javascript: GetReportCRR(" + '"' + arr[x].MPR + '"' + ',' + '"' + arr[x].COMM_NAME + '"' + ',' + '"' + arr[x].MM_YYYY + '"' + ',' + '"' + arr[x].SUBMISSION_DT + '"' + ',' + '"' + arr[x].MAX_MM_YYYY + '"' + ");'>View Corrected Report</a></td>"
                }


                if (count1 == 1)
                { count1 = 1; markup += "</tr></div>" }
            }
        }

        $("#tbl_Report").html(markup).show();
        $('#tbl_Report td').each(function () {
            if ($(this).html() == 'PENDING FOR VALIDATION') {
                //$(this).closest('tr').css('background', '#592B1B');
                //$(this).closest('tr').css('color', 'white');
                $(this).closest('tr').css('color', 'Brown');
                $(this).closest('tr').css('font-weight', 'bold');
            }
        });
    }




    function GetReport(_reportname, _comm_name, _mm_yyyy, _submission_dt, max_mmyyyy) {

        var date = new Date(_submission_dt);
        //var day = date.getDay();        // yields day
        //var month = date.getMonth();    // yields month
        //var year = date.getFullYear();  // yields year
        //var hour = date.getUTCHours();     // yields hours
        var hour = date.getHours();
        if (hour.toString().length < 2) {
            hour = '0' + hour.toString();
        }

        //var minute = date.getUTCMinutes(); // yields minutes
        var minute = date.getMinutes();
        if (minute.toString().length < 2) {
            minute = '0' + minute.toString();
        }

        var second = date.getUTCSeconds(); // yields seconds
        var milisec = date.getUTCMilliseconds();
        _submission_dt = _submission_dt.substring(0, 10) + hour + minute + '00' + '000';

        if (_reportname == 'DOL-CUS-1-OTHERS') {
            _reportname = 'DOL-CUS-1';
        }


        else if (_reportname == 'DOL-CUS-3-OTHERS') {
            _reportname = 'DOL-CUS-3';
        }

        else if (_reportname == 'DOL-CUS-4-OTHERS') {
            _reportname = 'DOL-CUS-4';
        }

        var url = "/MIS/" + "GST" + _reportname.substring(0, 3) + "/Report/" + _reportname.replace(/\-/g, '_') + "/Bak/" + _comm_name.substring((_comm_name.length - 3), (_comm_name.length - 1)) + "/" + _comm_name.substring(0, (_comm_name.length - 4)) + "/" + _mm_yyyy.substring(0, 10) + "/" + _submission_dt + "?max_mmyyyy=" + max_mmyyyy.substring(0, 10);
        window.open(url, '_blank');
    }



    function GetReportCRR(_reportname, _comm_name, _mm_yyyy, _submission_dt, max_mmyyyy) {

        var date = new Date(_submission_dt);
        var day = date.getDay();        // yields day
        var month = date.getMonth();    // yields month
        var year = date.getFullYear();  // yields year
        var hour = date.getHours();     // yields hours
        var minute = date.getMinutes(); // yields minutes
        var second = date.getSeconds(); // yields seconds
        _submission_dt = _submission_dt.substring(0, 10) + hour + minute + second;

        if (_reportname == 'DOL-CUS-1-OTHERS') {
            _reportname = 'DOL-CUS-1';
        }


        else if (_reportname == 'DOL-CUS-3-OTHERS') {
            _reportname = 'DOL-CUS-3';
        }

        else if (_reportname == 'DOL-CUS-4-OTHERS') {
            _reportname = 'DOL-CUS-4';
        }

        var url = "/MIS/" + "GST" + _reportname.substring(0, 3) + "/Report/" + _reportname.replace(/\-/g, '_') + "/Crr/" + _comm_name.substring((_comm_name.length - 3), (_comm_name.length - 1)) + "/" + _comm_name.substring(0, (_comm_name.length - 4)) + "/" + _mm_yyyy.substring(0, 10) + "?max_mmyyyy=" + max_mmyyyy.substring(0, 10);
        window.open(url, '_blank');
    }

    jQuery('#ddl_year').change(function () {
        var currentSelectedValue = $(this).val();
        var currentYear = new Date().getFullYear();
        var currentMonth = new Date().getMonth();
        if (currentSelectedValue != '') {

            var SelectedYear = parseInt(currentSelectedValue);

            var totalMonths = 11;
            if (SelectedYear == currentYear) {
                totalMonths = currentMonth - 1;
            }
            var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
            //Emptying the Month Dropdown to clear our last values
            $('#ddl_mth').empty();          
           
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



</script>
