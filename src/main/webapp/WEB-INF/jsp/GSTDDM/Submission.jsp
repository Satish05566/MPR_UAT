<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<jsp:include page="../GSTHome/Header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ page import = "java.io.*,java.util.*,java.time.format.DateTimeFormatter,java.time.LocalDateTime" %>


<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><i class="fa fa-check fa-fw"></i> VALIDATE</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>

    

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-warning">
               
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                           <div class="col-lg-12">
                                <div class="alert" id="login_error" style="display:none;">
                                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                                    <div id="Message"></div>
                                </div>
                            </div> 
                        </div>
                        <div class="col-lg-12">
                            <div class="col-lg-3">
                                <div class="form-group">
                                   
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="form-group">
                                    <select id="ddlcomm" name="ddlcomm" class="form-control" onchange='javascript: ReportBind();'></select>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="form-group">
                                   
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="form-group">
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>



     

    <div class="row" id="div_1">
        <div class="col-lg-12">
            <div class="panel panel-success">
                <div class="panel-heading">
                    Part-I Revenue dsfsf
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_1"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="div_2">
        <div class="col-lg-12">
            <div class="panel panel-warning">
                <div class="panel-heading">
                    Part-II Anti-smuggling
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_2"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="div_3">
        <div class="col-lg-12">
            <div class="panel panel-info">
                <div class="panel-heading">
                    Part-III Anti-evasion
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_3"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="div_4">
        <div class="col-lg-12">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    Part-IV Audit
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_4"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="div_5">
        <div class="col-lg-12">
            <div class="panel panel-success">
                <div class="panel-heading">
                    Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_5"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="div_6">
        <div class="col-lg-12">
            <div class="panel panel-warning">
                <div class="panel-heading">
                    Part-VI Valuation
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_6"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="div_7">
        <div class="col-lg-12">
            <div class="panel panel-info">
                <div class="panel-heading">
                    Part-VII Legal
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_7"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="div_8">
        <div class="col-lg-12">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    Part-VIII Arrears
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_8"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="div_9">
        <div class="col-lg-12">
            <div class="panel panel-success">
                <div class="panel-heading">
                    Part-IX Logistics
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_9"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row" id="div_10">
        <div class="col-lg-12">
            <div class="panel panel-success">
                <div class="panel-heading">
                    Part-X Withdrawal of Departmental Appeals
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_10"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row" id="div_11">
        <div class="col-lg-12">
            <div class="panel panel-success">
                <div class="panel-heading">
                    Part-XI Refund granted to UIN entities
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="part_11"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
            
        }

    </div>



<script language="javascript" type="text/javascript">
    $(document).ready(function () {
        $('#VALIDATE').css('color', 'black');

        <% if (request.getSession().getAttribute("TYPE").toString().equalsIgnoreCase("COMMISSIONERATE")) { %>
            //$("#ddl_dep").hide();
            $("#ddlcomm").hide();
            $('form input').hide();
            //ReportBind();
       <% } %>
        $("#div_1 , #div_2 , #div_3, #div_4, #div_5, #div_6, #div_7, #div_8, #div_9, #div_10, #div_11").hide();
    });


    function ReportBind() {
        var url = "/GSTHome/ReportBind/";
        var code;
		<%	
        if (request.getSession().getAttribute("TYPE").toString().equalsIgnoreCase("COMMISSIONERATE")) {%>
            code = <%= request.getSession().getAttribute("CODE").toString() %>;

       <% }
        else { %>
            code = $('#ddlcomm').val();

       <% } %>
        $.ajax({
            url: url,
            data: {
                comm: code,
                dep: $('#ddl_dep').val()
            },
            cache: false,
            type: "POST",
            success: function (data) {

                if ($("#ddl_dep option:selected").text() == 'All') {
                    $("#part_1").html(DisplayReport('', '[]', 1)).show();
                    $("#part_2").html(DisplayReport('', '[]', 2)).show();
                    $("#part_3").html(DisplayReport('', '[]', 3)).show();
                    $("#part_4").html(DisplayReport('', '[]', 4)).show();
                    $("#part_5").html(DisplayReport('', '[]', 5)).show();
                    $("#part_6").html(DisplayReport('', '[]', 6)).show();
                    $("#part_7").html(DisplayReport('', '[]', 7)).show();
                    $("#part_8").html(DisplayReport('', '[]', 8)).show();
                    $("#part_9").html(DisplayReport('', '[]', 9)).show();
                    $("#part_10").html(DisplayReport('Part-X Withdrawal of Departmental Appeals', data.data10.replace('DLA-ALL-C', ''), 10)).show();
                    $("#part_11").html(DisplayReport('', '[]', 11)).show();
                }
                else {
                    $("#part_1").html(DisplayReport('Part-I Revenue', data.data1.replace('DDM-CUS-1A', 'DDM-CUS-1'), 1)).show();
                    $("#part_2").html(DisplayReport('Part-II Anti-smuggling', data.data2, 2)).show();
                    $("#part_3").html(DisplayReport('Part-III Anti-evasion', data.data3.replace('CEI-GST-12A', 'CEI-GST-12'), 3)).show();
                    $("#part_4").html(DisplayReport('Part-IV Audit', data.data4, 4)).show();
                    $("#part_5").html(DisplayReport('Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous', data.data5, 5)).show();
                    $("#part_6").html(DisplayReport('Part-VI Valuation', data.data6, 6)).show();
                    $("#part_7").html(DisplayReport('Part-VII Legal', data.data7, 7)).show();
                    $("#part_8").html(DisplayReport('Part-VIII Arrears', data.data8, 8)).show();
                    $("#part_9").html(DisplayReport('Part-IX Logistics', data.data9, 9)).show();
                    $("#part_10").html(DisplayReport('', '[]', 10)).show();
                    $("#part_11").html(DisplayReport('Part-XI Refund granted to UIN entities', data.data11, 11)).show();
                }

                
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }
    function DisplayReport(group, data, divNo) {
        if (data != '[]' && data != '') {
            var arr = [];
            arr = $.parseJSON(data);

            var markup = "";
            var count1 = 1;
            for (var x = 0; x < arr.length; x++) {

                if (count1 == 1) { markup += "" }
                markup += "<a class='btn btn-default' style='margin:10px' href='javascript: GetReport(" + '"' + arr[x].CODE + '"' + ");'>" + arr[x].CODE + "</a>"
                if (count1 == 5) { count1 = 1; markup += "" }
                else { count1++; }
            }
           <% if(request.getSession().getAttribute("TYPE").toString().equalsIgnoreCase("ZONE"))  {%>

                markup += "<a class='btn btn-success float-right' href='javascript:Submit_Report(" + '"' + group + '"' + ");'>Validate</a>"
           <% } %>
            $('#div_' + divNo).show();

            return markup;

        }
        else {
            $('#div_' + divNo).hide();
            return "";
        }
    }






    function GetComm() {
        
        <%if (request.getSession().getAttribute("TYPE").toString().equalsIgnoreCase("COMMISSIONERATE")) {%>
            ReportBind();
            return false;
       <% } %>
        var procemessage = "<option value='0'> Please wait...</option>";
        $("#ddlcomm").html(procemessage).show();
        var url = "/MIS/GSTHome/Comm_Bind/";

        var form = $('#__AjaxAntiForgeryForm');
        var token = $('input[name="__RequestVerificationToken"]', form).val();


        $.ajax({
            url: url,
            data: { __RequestVerificationToken: token, zone: '@Session["CODE"]' },
            cache: false,
            type: "POST",
            success: function (data) {
                var markup = "<option value='0'>All</option>";
                //---------------------------------------------------
                if ('@Session["CODE"]' == 'CC') {
                    markup += "<option value='C0'>HQRS</option>";
                }
                else if ('@Session["CODE"]' == 'DD') {
                    markup += "<option value='H1'>HQ-G1</option>";
                    markup += "<option value='H2'>HQ-C1</option>";
                }
                //---------------------------------------------------
                for (var x = 0; x < data.length; x++) {
                    if (data[x].Value == 'NQ') {
                        var commname = "MUMBAI(EXPORT)";
                        markup += "<option value=" + data[x].Value + ">" + commname + "</option>";
                    }
                    else if (data[x].Value == 'NS') {

                    }
                    else if (data[x].Value == 'NC') {
                        var commname = "DELHI (AIRPORT AND GENERAL)";
                        markup += "<option value=" + data[x].Value + ">" + commname + "</option>";
                    }
                    else if (data[x].Value == 'NA') {

                    }
                    else if ((data[x].Value == 'MS' || data[x].Value == 'MT')) {

                    }
                    else {
                        markup += "<option value=" + data[x].Value + ">" + data[x].Text + "</option>";
                    }
                    //markup += "<option value=" + data[x].Value + ">" + data[x].Text + "</option>";
                }
                $("#ddlcomm").html(markup).show();
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }
    function Submit_Report(Group) {
        var url = "/GSTHome/Report_Submission/";
        var code;
        
        if ('@Session["TYPE"]' == 'COMMISSIONERATE') {
            code = '@Session["CODE"]'
        }
        else {
            code = $('#ddlcomm').val();
        }
        $.ajax({
            url: url,
            data: {
                comm_code: code,
                Report_Group: Group,
                dep: $('#ddl_dep').val()
            },
            cache: false,
            type: "POST",
            success: function (data) {
                $("#login_error").show();
                $("#Message").html(data);
            },
            error: function (reponse) {
                alert("error : " + reponse);
                $("#login_error").hide();
            }
        });

    }
    //----------------------------------------------------------
    function GetReport(reportname) {
        var code;
        var name;
        if ('@Session["TYPE"]' == 'COMMISSIONERATE') {
            code = '@Session["CODE"]';
            name = '@Session["NAME"]';

        }
        else {
            code = $('#ddlcomm').val();
            name = $("#ddlcomm option:selected").text();


        }

        if (reportname == 'DOL-CUS-1-OTHERS') {
            reportname = 'DOL-CUS-1';
        }


        else if (reportname == 'DOL-CUS-3-OTHERS') {
            reportname = 'DOL-CUS-3';
        }

        else if (reportname == 'DOL-CUS-4-OTHERS') {
            reportname = 'DOL-CUS-4';
        }

        else if (reportname == 'DLA-ALL-X') {
            reportname = 'DLA-ALL-D';
        }
        else if (reportname == 'DDM-CUS-1') {
            reportname = 'DDM-CUS-1A';
        }

        window.open("/MIS/" + "GST" + reportname.substring(0, 3) + "/Report/" + reportname.replace(/\-/g, '_') + "/Temp/" + code + "/" + name + "/", '_blank');

    }
</script>

<jsp:include page="../GSTHome/Footer.jsp" />