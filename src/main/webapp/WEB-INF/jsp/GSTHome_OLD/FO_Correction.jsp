<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<jsp:include page="Header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ page import = "java.io.*,java.util.*,java.time.format.DateTimeFormatter,java.time.LocalDateTime" %>



<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><i class="fa fa-external-link fa-fw"></i> CORRECTION REQUESTS PENDING FOR APPROVAL</h1>
        </div>
    </div>
		<form action="CorrectionBackup" id="CorrectionBackupForm" name="CorrectionBackupForm" method="Post" >
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-warning">
                <div class="panel-heading">
                    Correction Requests Pending For Approval
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="col-lg-3">
                                <div class="form-group">
                                   <!--  @*@Html.DropDownList("ddl_dep", new List<SelectListItem>

            {
                new SelectListItem { Text = "Select Stream", Value = "", Selected=true, new { @disabled="disabled" }},
            new SelectListItem { Text = "Central Excise", Value = "CEX"},
            new SelectListItem { Text = "Customs", Value = "CUS"},
            new SelectListItem { Text = "Service Tax", Value = "STX"},
                  new SelectListItem { Text = "GST", Value = "GST"}
            },
                         new { onchange = "javascript:FO_CorrectionList();" , @class="form-control"})*@ -->

                                    <select id="ddl_dep" onchange="javascript:FO_CorrectionList();" class="form-control">
                                        <option selected disabled>Select Stream</option>
                                        <option value="CEX">Central Excise</option>
                                        <option value="CUS">Customs</option>
                                        <option value="STX">Service Tax</option>
                                        <option value="GST">GST</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-9">
                            	<!--  
                                <div class="form-group">
                                   
                                   
                                	<input type="button" class="btn btn-warning float-right" value="See All Correction Requests" 
                                	onclick="javascript:CorrectionBackup()"; />
                                </div>
                                -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
   <!--  @*<table id="zone_crr"></table>*@ -->

    <div class="row" id="table_div">
        <div class="col-lg-12">
            <div class="panel panel-danger">
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover" id="zone_crr"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="test"></div>
</div>


<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
<script type="text/javascript">


    $(document).ready(function () {
        $('#FO_Correction').css('color', 'black');
        $('#table_div').hide();

    });

    function CorrectionBackup() {
       // alert('correction backup');
        document.CorrectionBackupForm.submit();
    }
    
    function FO_CorrectionList() {
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>FO_CorrectionList";
        var _dep = $('#ddl_dep').val();
      //  alert('_dep--'+_dep);
        $.ajax({
            url: url,
            data: {
                dep: _dep,

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
      //  alert('data--'+data);
       // alert('JSON.parse(data.ListFoGstResult----'+JSON.parse(data.ListFoGstResult);
        //alert('arr---'+arr);
        var markup = "";
        if (data != '') {
          // alert('inside data!='[]');
           // var arr = [];
            var arr = JSON.parse(data.ListFoGstResult);
          //  alert('arr--'+arr);
            markup += "<tr>"
            markup += "<th style='border:1px solid black'>COMMISSIONERATE&nbsp;&nbsp;&nbsp;&nbsp;</th>"
            markup += "<th style='border:1px solid black'>MPR</th>"
            markup += "<th style='border:1px solid black'>YEAR/MONTH</th>"
            markup += "<th style='border:1px solid black'>SUBMISSION DATE & TIME</th>"
            markup += "<th style='border:1px solid black'>VALIDATION DATE & TIME</th>"
            markup += "<th style='border:1px solid black' colspan='3'>ACTION</th>"
            markup += "</tr>"
            var count1 = 1;
            for (var x = 0; x < arr.length; x++) {
                markup += "<td style='border:1px solid black'>" + arr[x].COMM_NAME + "</td>"
                markup += "<td style='border:1px solid black'>" + arr[x].MPR.replace('DDM-CUS-1A', 'DDM-CUS-1') + "</td>"
                markup += "<td style='border:1px solid black'>" + arr[x].MM_YYYY + "</td>"
                markup += "<td style='border:1px solid black'>" + arr[x].SUBMISSION_DT + "</td>"
                markup += "<td style='border:1px solid black'>" + arr[x].VALIDATION_DT + "</td>"
                markup += "<td style='border:1px solid black'><a class='btn btn-success' href='javascript: GetReportCRR(" + '"' + arr[x].MPR + '"' + ',' + '"' + arr[x].COMM_NAME + '"' + ',' + '"' + arr[x].MM_YYYY + '"' + ',' + '"' + arr[x].SUBMISSION_DT + '"' + ',' + '"' + arr[x].MAX_MM_YYYY + '"' + "); '>View Report</a></td>"
                markup += "<td style='border:1px solid black'><a class='btn btn-warning' href='javascript:validate(" + '"' + arr[x].COMM_NAME + '"' + ',' + '"' + arr[x].MM_YYYY + '"' + ',' + '"' + arr[x].SUBMISSION_DT + '"' + ',' + '"' + arr[x].MPR + '"' + ',""' + ");'>Approve</a></td>"
                markup += "<td style='border:1px solid black'><a class='btn btn-danger' href='javascript:reject(" + '"' + arr[x].COMM_NAME + '"' + ',' + '"' + arr[x].MM_YYYY + '"' + ',' + '"' + arr[x].SUBMISSION_DT + '"' + ',' + '"' + arr[x].MPR + '"' + ',"DELETE"' + ");'>Reject</a></td>"
                markup += "</tr>"
            }
        }
        $("#zone_crr").html(markup).show();
        if (markup != '') {
            $('#table_div').show();
        }
        else {
            $('#table_div').hide();
        }
    }

</script>

<script language="javascript" type="text/javascript">
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
        else if (_reportname == 'DGA-ST-1') {
            _reportname = 'DGA-ST-1-1';
        }
       else if (_reportname == 'DGA-ST-1A') {
           _reportname = 'DGA-ST-1A-1';
        }
       else if (_reportname == 'DGA-CE-1') {
           _reportname = 'DGA-CE-1-1';
        }
       else if (_reportname == 'DGA-CE-1A') {
           _reportname = 'DGA-CE-1A-1';
        }

       // var url = "/MIS/" + "GST" + _reportname.substring(0, 3) + "/Report/" + _reportname.replace(/\-/g, '_') + "/Crr/" + _comm_name.substring((_comm_name.length - 3), (_comm_name.length - 1)) + "/" + _comm_name.substring(0, (_comm_name.length - 4)) + "/" + _mm_yyyy + "?max_mmyyyy=" + max_mmyyyy.substring(0, 10);
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + _reportname.substring(0, 3) + "/Report/" + _reportname.replace(/\-/g, '_') + "/Crr/" + _comm_name.substring((_comm_name.length - 3), (_comm_name.length - 1)) + "/" + _comm_name.substring(0, (_comm_name.length - 4)) + "/" + _mm_yyyy + "/<%=request.getSession().getAttribute("CSRF_Token").toString() %>" + "?max_mmyyyy=" + max_mmyyyy.substring(0, 10);
        window.open(url, '_blank');
    }
   																  
</script>

<script type="text/javascript">
    function reject(code, MM_YYYY, sub_date, mpr, txt_Remarks) {
        
        if (txt_Remarks != '') {
        //	alert('txt_Remarks--1111'+txt_Remarks);
            $.ajax({
                url: "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>FO_Update_Status_Msg",
                data: {
                    code: code,
                    MM_YYYY: MM_YYYY,
                    sub_date: sub_date,
                    mpr: mpr,
                    txt_Remarks: txt_Remarks,
                    dep: $('#ddl_dep').val()
                },
                cache: false,
                type: "POST",
                success: function (data) {
                    //alert(data)
                    if (JSON.parse(data.data2) > 27) {

                        txt_Remarks = prompt("Please Enter Reason for Rejection ", JSON.parse(data.data2));;
                        validate(code, MM_YYYY, sub_date, mpr, txt_Remarks);
                    }
                    else {
                        txt_Remarks = prompt("Please Enter Reason for Rejection ", "Reason");
                        validate(code, MM_YYYY, sub_date, mpr, txt_Remarks);
                    }
                    return false;
                },
                error: function (reponse) {
                    alert("error : " + reponse);
                }

            });
        }

    }

    function validate(code, MM_YYYY, sub_date, mpr, txt_Remarks) {

    //	alert('code is--'+code);
        if (txt_Remarks == null) {

            return false;
        }

        else {
            $.ajax({
                url: "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>FO_Update_Status",
                data: {
                    code: code,
                    MM_YYYY: MM_YYYY,
                    sub_date: sub_date,
                    mpr: mpr,
                    txt_Remarks: txt_Remarks,
                    dep: $('#ddl_dep').val()
                },
                cache: false,
                type: "POST",
                success: function (data) {
                    //  Correction_Report(data.data1);
                   // var arr = JSON.parse(data.data2);
                    FO_CorrectionList();
                    if (JSON.parse(data.data2).length > 27) {
                        //alert("Reason : " + data.data2);                       ;
                        alert("You can not Approve the correction request.\n " + data.data2);
                    }
                    else {
                        alert(JSON.parse(data.data2));
                    }
                    return false;
                },
                error: function (reponse) {
                    alert("error : " + reponse);
                }

            });
        }

    }
</script>







<jsp:include page="Footer.jsp" />








