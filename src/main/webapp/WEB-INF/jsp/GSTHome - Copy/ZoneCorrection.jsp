<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Header.jsp" />
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><i class="fa fa-external-link fa-fw"></i> Correction Requests Pending For Validation</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-warning">
            <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="col-lg-3">
                                <div class="form-group" style="margin-bottom:0px !important;">
                                </div>

                                <select id="ddl_dep" onchange="javascript: Zone_CorrectionList();" class="form-control">
                                    <option selected disabled>Select Stream</option>
                                    <option value="CEX">Central Excise</option>
                                    <option value="CUS">Customs</option>
                                    <option value="STX">Service Tax</option>
                                    <option value="GST">GST</option>
                                </select>
                            </div>
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <input type="button" id="demo" value="Validate" onclick="javascript: test();" class="btn btn-success" />
                                </div>
                            </div>
                            <div class="col-lg-7">
                            	<!-- 
                                <div class="form-group">
                                   <a id="BCorrection" title="See All Correction Requests" href="/CorrectionBackup"  class = "btn btn-warning float-right">See All Correction Requests</a>
                                </div>
                                 -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row" id="table_div">
        <div class="col-lg-12">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    Correction List
                </div>
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
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery.validate.min.js"></script>

<!-- @*Inline Script For Validation Purpose*@ -->
<script language="javascript" type="text/javascript">
    $(document).ready(function () {
        $('#table_div').hide();
        $('#CORRECTION_ZONE').css('color', 'black');
        if ($('#ddl_dep').val() == '') {
            $("#demo").hide();
        }
    });
    function Zone_CorrectionList() {
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Zone_CorrectionList/";
        var _dep = $('#ddl_dep').val();

        $.ajax({
            url: url,
            data: {
                dep: _dep,
            },
            cache: false,
            type: "POST",
            success: function (data) {
                Correction_Report(data);
                $("#table_div").show();

            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });
    }

    function Correction_Report(data) {
       // alert("Correction_Report");
        var arr=  JSON.parse(data.dt);
        $("#demo").show();
        var markup = "";
        if (arr != '[]') {
            //var arr = [];
            markup += "<thead>"
            markup += "<tr><th>SELECT</th>"
            markup += "<th>COMMISSIONERATE</th>"
            markup += "<th>FUNCTIONAL OWNER</th>"
            markup += "<th>MPR</th>"
            markup += "<th>YEAR/MONTH</th>"
            markup += "<th>SUBMISSION DATE & TIME</th>"
            markup += "<th>ACTION</th>"
            markup += "</tr>"
            markup += "</thead>"
            var count1 = 1;
            for (var x = 0; x < arr.length; x++) {

                var chk = '<input type="checkbox" name="chkb"  id="ck' + x + '" class="chck" />'
                if (count1 == 1) { markup += "<div><tr>" }
                markup += "<td>" + chk + "</td>"
                markup += "<td>" + arr[x].COMM_NAME + "</td>"
                markup += "<td>" + arr[x].FO + "</td>"
                markup += "<td>" + arr[x].MPR.replace('DDM-CUS-1A', 'DDM-CUS-1') + "</td>"
                markup += "<td>" + arr[x].MM_YYYY + "</td>"
                markup += "<td>" + arr[x].SUBMISSION_DT + "</td>"

                markup += "<td><a class='btn btn-success' href='javascript: GetReportCRR(" + '"' + arr[x].MPR + '"' + ',' + '"' + arr[x].COMM_NAME + '"' + ',' + '"' + arr[x].MM_YYYY + '"' + ',' + '"' + arr[x].SUBMISSION_DT + '"' + ',' + '"' + arr[x].MAX_MM_YYYY + '"' + ");'>View Report</a></td>"
                if (count1 == 1)
                { count1 = 1; markup += "</tr></div>" }

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

    function GetReportCRR(_reportname, _comm_name, _mm_yyyy, _submission_dt, max_mmyyyy) {
       //alert("reportname->"+_reportname+" comm_name->"+_comm_name+" mm_yyyy->"+_mm_yyyy+" submission_dt->"+_submission_dt+" max_mmyyyy->"+max_mmyyyy);
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
        //var url = "/MIS/" + "GST" + _reportname.substring(0, 3) + "/Report/" + _reportname.replace(/\-/g, '_') + "/Crr/" + _comm_name.substring((_comm_name.length - 3), (_comm_name.length - 1)) + "/" + _comm_name.substring(0, (_comm_name.length - 4)) + "/" + _mm_yyyy + "?max_mmyyyy=" + max_mmyyyy.substring(0, 10);
       // var url = "GST" + _reportname.substring(0, 3) + "/Report/" + _reportname.replace(/\-/g, '_') + "/Crr/" + _comm_name.substring((_comm_name.length - 3), (_comm_name.length - 1)) + "/" + _comm_name.substring(0, (_comm_name.length - 4)) + "/" + _mm_yyyy + "?max_mmyyyy=" + max_mmyyyy.substring(0, 10);
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>"+"GST" + _reportname.substring(0, 3) + "/Report/" + _reportname.replace(/\-/g, '_') + "/Crr/" + _comm_name.substring((_comm_name.length - 3), (_comm_name.length - 1)) + "/" + _comm_name.substring(0, (_comm_name.length - 4)) + "/" + _mm_yyyy +"/<%=request.getSession().getAttribute("CSRF_Token").toString() %>" ; 
	
	window.open(url, '_blank');
    }
</script>

<script type="text/javascript">
function test(){
//    alert("#demo.live click");
    var values = new Array();
    var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Zone_Update_Status/";
    var _dep = $('#ddl_dep').val();
    $.each($("input[name=chkb]:checked").closest("td").siblings("td"),
           function () {
               values.push($(this).text());
           });

    var a = values.join(", ");
    $.ajax({
        url: url,
        data: {
            list_values: a,
            dep: _dep

        },
        cache: false,
        type: "POST",
        success: function (data) {

            Correction_Report(data);
            return false;
        },
        error: function (reponse) {
            alert("error : " + reponse);
        }
    });
  
	
}
    $("#demo").live("click", function () {
    	//alert("#demo.live click");
        var myArray = new Array();
        var j = 0;
        $("input:checkbox[name=chkb]:checked").each(function () {
            myArray[j] = $(this).attr("id");
            j++;
        });
        //alert(myArray);
        //  ChangeStatus();

    });
</script>
<jsp:include page="Footer.jsp" />

