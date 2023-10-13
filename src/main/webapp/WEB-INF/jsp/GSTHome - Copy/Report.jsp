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
				<i class="fa fa-book fa-fw"></i> Monthly Performance Report (MPR)
			</h4>
		</div>
		<div class="col-lg-6">
			<ol class="breadcrumb float-right no-bg-col p-t-20 m-b-0 p-r-0">
				<li><a href="/KPI_Home"><i class="fa fa-home"></i> Management Information</a></li>
				<li class="active">MPR</li>

			</ol>
		</div>
        
        
       <!-- /.col-lg-12 -->
    </div>
        
        <form action="" method="Post" >
        <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
        <input type="hidden"  id="flagForFF" name="flagForFF"   />
            
            <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-warning">
                   
                    <div class="panel-body">
                        <div class="row">
                            <div class="container-new">
                                <ul>
                                    <li>
                                        <input type="radio" value="FA" id="f-option" name="Report_Type" checked="checked" onclick="javascript: Get_FF();" />
                                        <label for="f-option"> Functional Area Wise</label>
                                        <div class="check"></div>
                                    </li>
                                    <li>
                                        <input type="radio" id="s-option" value="FF" name="Report_Type" onclick="javascript: Get_FF();" />
                                        <label for="s-option"> Field Formation Wise</label>
                                        <div class="check"><div class="inside"></div></div>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-lg-12">

                                <div class="col-lg-2">
                                    <div class="form-group">
   									
										<select name="ddl_year" id="ddl_year"  class="form-control">
											<option value="">Select Year</option>
											<option value="2023">2023</option>
											<option value="2022">2022</option>
											<option value="2021">2021</option>
											<option value="2020">2020</option>
											<option value="2019">2019</option>
											<option value="2018">2018</option>
											<option value="2017">2017</option>
										
										</select>

                                    </div>
                                </div>

                                <div class="col-lg-2">
                                   <div class="form-group">

									       <select name="ddl_mth" id="ddl_mth"  class="form-control">											
									       </select> 
                                    </div>
                                </div>

                                <div id="ddl_dep_div" class="col-lg-3">
         							<div class="form-group">
         						
						         		<select name="ddl_dep" id="ddl_dep"  class="form-control" onchange = "javascript:GetZone(this.value);">						         		
											<option value="GST">All</option>
											<!-- <option value="CEX">Central Excise</option>
											<option value="CUS">Customs</option>
											<option value="STX">Service Tax</option> -->
											<option value="GST">GST</option>				

										</select>
						      
                                   </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="form-group">
                                        <select id="ddlzone" name="ddlzone" onchange='javascript:GetComm(this.value);' class="form-control"> 
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="form-group">
                                        <select id="ddlregin" name="ddlregin" class="form-control" onchange = "javascript:ReportBind();"></select>
                                        <select id="ddlcomm" name="ddlcomm"  class="form-control" onchange = "javascript:ReportBind();"></select>
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
                    <div class="panel-heading p-b-0">
                        Part-I Revenue
                        <span style="color:red; font-size:14px;">                            
                                For F.Y 2018-19 in MPRs Part-I Revenue in MIS,corrections/revisions, if any, may be carried out in the database by 15th July,2019.
                                Data will be freezed automatically.                               
                        </span>
                        <p id="part_1_cus_1" style="float:right"></p>
                    </div>
                    <div class="panel-body p-t-b-0">
                        <div class="row p-l-r-20">
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
        <!-- 
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
 -->        <div class="row" id="div_5">
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
       <!--  <div class="row" id="div_7">
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
        </div> -->
       <!--  <div class="row" id="div_8">
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
        </div> -->
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

   
</form>
</div>

<!-- @*Inline Plugin Script For Validation Purpose*@ -->
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>

<!-- @*Inline Script For Validation Purpose*@  -->
<script language="javascript" type="text/javascript">
    $(document).ready(function () {
        $('#MPR').css('color', 'black');
        $("#ddl_mth").val('@DateTime.Now.AddDays(15).AddMonths(-1).Month');
        $('#ddlregin').hide();
        $("#div_1 , #div_2 , #div_3, #div_4, #div_5, #div_6, #div_7, #div_8, #div_9, #div_10, #div_11").hide();

        $('#ddl_mth').append('<option value="" selected>Select Month</option>');
    });
    function GetRegion() {
        //$('#ddlcomm').empty();
        ReportBind();
        var procemessage = "<option value='0'> Please wait...</option>";
        $("#ddlregin").html(procemessage).show();
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/Region_Bind/";

        $.ajax({
            url: url,
            data: {},
            cache: false,
            type: "GET",
            success: function (data) {
                var markup;
                var data = JSON.parse(data.gstRegionList);
                for (var x = 0; x < data.length; x++) {
                    markup += "<option value=" + data[x].REGION_CODE + ">" + data[x].REGION_NAME + "</option>";
                }
                $("#ddlregin").html(markup).show();
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }
    function GetZone(_stateId) {
        var _month = $("#ddl_mth option:selected").text();
        var _year = $('#ddl_year').val();
        if (_year == '' || _month == 'Select Month') {
           // alert('Please select the year and month');
            return false;
        }
        $('#ddlcomm').empty();
        ReportBind();
        var procemessage = "<option value='0'> Please wait...</option>";
        $("#ddlzone").html(procemessage).show();
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/Zone_Bind/";
		
        //var form = $('#__AjaxAntiForgeryForm');
        //var token = $('input[name="__RequestVerificationToken"]', form).val();
        $.ajax({
            url: url,
            data: { dep: _stateId },
            cache: false,
            type: "GET",
            success: function (data) {
                var markup = "<option value=''>All India</option>";
                //---------------------------------------------------------
                if ($('#ddl_dep').val() == 'CEX' || $('#ddl_dep').val() == 'STX') {
                    markup += "<option value='CC'>DGGI</option>";
                    markup += "<option value='A0'>DGA</option>";
                }
                if ($('#ddl_dep').val() == 'GST') {
                    markup += "<option value='CC'>DGGI</option>";
                }
                else if ($('#ddl_dep').val() == 'CUS') {
                    markup += "<option value='DD'>DGRI</option>";
                    markup += "<option value='A0'>DGA</option>";
                    markup += "<option value='0A'>CC ZONE</option>";
                }
                else if ($("input:radio[name='Report_Type']:checked").val() == "FF") {
                    markup += "<option value='00'>MEMBER REGION</option>";
                    markup += "<option value='CC'>DGCEI</option>";
                    markup += "<option value='DD'>DGRI</option>";
                    markup += "<option value='A0'>DGA</option>";
                    markup += "<option value='0A'>CC ZONE</option>";
                }
                //------------------------------------------------------------
                var data = JSON.parse(data.gstZoneList);
                for (var x = 0; x < data.length; x++) {
                    markup += "<option value=" + data[x].ZONE_CODE + ">" + data[x].ZONE_NAME + "</option>";
                }
                $("#ddlzone").html(markup).show();
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }
    function GetComm(zoneId, dep) {

        var _month = $("#ddl_mth option:selected").val();
        var _year = $('#ddl_year').val();

        if (zoneId == '00') {
            $('#ddlcomm').hide();
            $('#ddlregin').show();
            GetRegion();
            return false;
        }
        else if (zoneId == 'A0') {
            var markup = "<option value=''>All</option>";
            //---------------------------------------------------
            markup += "<option value='ALLZONE'>All Zones</option>";
            markup += "<option value='ALLADT'>All Audits Commissionerates</option>";
            markup += "<option value='ALLEXE'>All Executive Commissionerates</option>";
            markup += "<option value='A1'>Ahmedabad</option>";
            markup += "<option value='A2'>Bangalore</option>";
            markup += "<option value='A3'>Chennai</option>";
            markup += "<option value='A4'>Delhi</option>";
            markup += "<option value='A5'>Hyderabad</option>";
            markup += "<option value='A6'>Kolkata</option>";
            markup += "<option value='A7'>Mumbai</option>";


            //---------------------------------------------------

            $("#ddlcomm").html(markup).show();
            return false;
        }
        $('#ddlcomm').show();
        $('#ddlregin').hide();
        ReportBind();
        var procemessage = "<option value='0'> Please wait...</option>";
        $("#ddlcomm").html(procemessage).show();
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/Comm_Bind/";

        //var form = $('#__AjaxAntiForgeryForm');
        //var token = $('input[name="__RequestVerificationToken"]', form).val();

        $.ajax({
            url: url,
            data: { zone: zoneId, dep: $('#ddl_dep').val() },
            cache: false,
            type: "GET",
            success: function (data) {
                var markup = "<option value=''>All</option>";
                //---------------------------------------------------
               /* if (zoneId == 'CC') {
                    markup += "<option value='C0'>HQRS</option>";
                }
                else */
                    if (zoneId == 'DD') {
                    markup += "<option value='H1'>HQ-G1</option>";
                    markup += "<option value='H2'>HQ-C1</option>";
                }
                //---------------------------------------------------
                var data = JSON.parse(data.gstCommList);
                for (var x = 0; x < data.length; x++) {
                	//alert(_month +","+_year);
                    if (data[x].COMM_CODE == 'NQ' && (_month >= '4' && _year >= '2018')) {
                    	
                        var commname = "MUMBAI(EXPORT)";
                        markup += "<option value=" + data[x].COMM_CODE + ">" + commname + "</option>";
                    }
                    else if (data[x].COMM_CODE == 'NS' && (_month >= '4' && _year >= '2018')) {

                    }
                    else if (data[x].COMM_CODE == 'NC' && (_month >= '4' && _year >= '2018')) {
                        var commname = "DELHI (AIRPORT AND GENERAL)";
                        markup += "<option value=" + data[x].COMM_CODE + ">" + commname + "</option>";
                    }
                    else if (data[x].COMM_CODE == 'NA' && (_month >= '4' && _year >= '2018')) {

                    }
                    else if ((data[x].COMM_CODE == 'MS' || data[x].COMM_CODE == 'MT') && (_month >= '4' && _year >= '2018')) {

                    }
                    else {
                        markup += "<option value=" + data[x].COMM_CODE + ">" + data[x].COMM_NAME + "</option>";
                    }

                }
                $("#ddlcomm").html(markup).show();                
                //if (zoneId == 'CC' || zoneId == 'DD')
                //{
                //    ReportBind();
                //}

            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }
    function Get_FF() {
        if ($("input:radio[name='Report_Type']:checked").val() == "FF") {

          //  $('#ddl_dep').hide();
            $('#ddl_dep_div').hide();
            $('#ddlcomm').empty();
            //$('#ddlzone').selectedIndex = 0;
            document.getElementById("ddlzone").selectedIndex = 0;
            document.getElementById("ddl_dep").selectedIndex = 0;
            //ReportBind();
            document.getElementById('flagForFF').value =0;
            GetZone("null");

        }
        else {
            //$('#ddl_dep').show();
            $('#ddl_dep_div').show();
            $('#ddlcomm').empty();
            $('#ddlzone').empty();
            document.getElementById('flagForFF').value ='1';
      
            ReportEmpty();
            document.getElementById("ddl_dep").selectedIndex = 0;
            $("#div_1 , #div_2 , #div_3, #div_4, #div_5, #div_6, #div_7, #div_8, #div_9, #div_10, #div_11").hide();
        }
    }

    function GetReport(_reportname) {

    	var urlForWindow = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + _reportname.substring(0, 3) + "/Report/" + _reportname.replace(/\-/g, '_') + "/Region/" + $('#ddlregin').val() + "/" + $("#ddlregin option:selected").text() + "/" + $("#ddl_mth option:selected").text() + "-" + $('#ddl_year').val()+"/<%=request.getSession().getAttribute("CSRF_Token").toString() %>" ;
    	//alert("urlForWindow"+ urlForWindow);
        if ($('#ddlzone').val() == '00') {
            window.open(urlForWindow, '_blank');
            return false;
        }
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/Report_Redirect/";
        var _dep = $('#ddl_dep').val();
        var _zone_code = $('#ddlzone').val();
        var _zone_name = $("#ddlzone option:selected").text();
        var _zone_name_temp = _zone_name.replace('&', 'AND');
        _zone_name = _zone_name_temp;
        var _comm_code = $('#ddlcomm').val();
        var _comm_name = $("#ddlcomm option:selected").text();
        var _month = $("#ddl_mth option:selected").text();
        var _year = $('#ddl_year').val();

        var dynamicPath= "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>";

        if (_year == '' || _month == 'Select Month') {
           // alert('Please select the year and month');
            return false;
        }
        $.ajax({
            url: url,
            data: {
                dep: _dep,
                zone_code: _zone_code,
                zone_name: _zone_name,
                comm_code: _comm_code,
                comm_name: _comm_name,
                month: _month,
                year: _year,
                Report_Name: _reportname
            },
            cache: false,
            type: "GET",
            success: function (data) {
                data = data+"/<%=request.getSession().getAttribute("CSRF_Token").toString() %>";
                //alert("dynamicPath "+ dynamicPath);
                if(dynamicPath == "/MPR/"){
                	data = '/MPR' + data;

                 }
                
                data =   data;
               // alert("data"+ data);
                //window.location = data;
                window.open(data, '_blank');

                return false;
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });
    }
    //------------------------------------------------------------------------------------------------
    function ReportEmpty() {
        $("#part_1").html('').show();
        $("#part_2").html('').show();
        $("#part_3").html('').show();
        $("#part_4").html('').show();
        $("#part_5").html('').show();
        $("#part_6").html('').show();
        $("#part_7").html('').show();
        $("#part_8").html('').show();
        $("#part_9").html('').show();
        $("#part_10").html('').show();
        $("#part_11").html('').show();

    }
    function ReportBind() {
        //if (($('#ddlzone').val() == 'CC' || $('#ddlzone').val() == 'DD') && $('#ddlcomm').val()==0)----------Commented only due ti CEI listing not available
        //if ($('#ddlcomm').val() == '')
        //{
        //    var code = $('#ddlzone').val();
        //}
        //else
        //{
        //    var code = $('#ddlcomm').val();
        //}
                var _comm = '';
        
		//alert($('#ddlcomm').val());
		if($('#ddlcomm').val() == null || $('#ddlcomm').val() == '')
			{
	         _comm = null;
			
			}
		else
			{
			_comm = $('#ddlcomm').val();
			}
        //var _comm = 'TH';
        if(document.getElementById('flagForFF').value == '0'){
        	_comm = 	$('#ddlcomm').val();
            }
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/ReportBind/";
        $.ajax({
            url: url,
            data: {
              	 comm: _comm,
                //comm: $('#ddlcomm').val(),                    
                dep: $('#ddl_dep').val(),
                type: 'Report',
                zone: $('#ddlzone').val()
            },
            cache: false,
            type: "GET",
            success: function (data) {

                if ($('#ddlzone').val() == '0A') {
                    $("#part_2").html(DisplayReport('Part-II Anti-smuggling', data.data2, 2)).show();
                    $("#part_1").html(DisplayReport('', '[]', 1)).show();
                    $("#part_3").html(DisplayReport('', '[]', 3)).show();
                    $("#part_4").html(DisplayReport('', '[]', 4)).show();
                    $("#part_5").html(DisplayReport('', '[]', 5)).show();
                    $("#part_6").html(DisplayReport('', '[]', 6)).show();
                    $("#part_7").html(DisplayReport('', '[]', 7)).show();
                    $("#part_8").html(DisplayReport('', '[]', 8)).show();
                    $("#part_9").html(DisplayReport('', '[]', 9)).show();
                    $("#part_10").html(DisplayReport('', '[]', 10)).show();
                    $("#part_11").html(DisplayReport('', '[]', 11)).show();

                }
                else if ($('#ddlzone').val() == 'A0') {
                    $("#part_1").html(DisplayReport('', '[]', 1)).show();
                    $("#part_2").html(DisplayReport('', '[]', 2)).show();
                    $("#part_3").html(DisplayReport('', '[]', 3)).show();
                    $("#part_4").html(DisplayReport('Part-IV Audit', data.data4, 4)).show();
                    $("#part_5").html(DisplayReport('', '[]', 5)).show();
                    $("#part_6").html(DisplayReport('', '[]', 6)).show();
                    $("#part_7").html(DisplayReport('', '[]', 7)).show();
                    $("#part_8").html(DisplayReport('', '[]', 8)).show();
                    $("#part_9").html(DisplayReport('', '[]', 9)).show();
                    $("#part_10").html(DisplayReport('', '[]', 10)).show();
                    $("#part_11").html(DisplayReport('', '[]', 11)).show();
                    return false;
                }

                else {

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
                        $("#part_10").html(DisplayReport('Part-X Withdrawal of Departmental Appeals', data.data10, 10)).show();
                        $("#part_11").html(DisplayReport('', '[]', 11)).show();
                    }
                    else {
                        $("#part_1").html(DisplayReport('Part-I Revenue', data.data1.replace('DDM-CUS-1A', 'DDM-CUS-1'), 1)).show();
                        $("#part_2").html(DisplayReport('Part-II Anti-smuggling', data.data2, 2)).show();
                        $("#part_3").html(DisplayReport('Part-III Anti-evasion', data.data3.replace('CEI-GST-12A', 'CEI-GST-12'), 3)).show();
                        $("#part_4").html(DisplayReport('Part-IV Audit', data.data4, 4)).show();
                        $("#part_5").html(DisplayReport('Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous', data.data5.replace('DPM-GST-14A', 'DPM-GST-14').replace('DPM-GST-15A', 'DPM-GST-15'), 5)).show();
                        $("#part_6").html(DisplayReport('Part-VI Valuation', data.data6, 6)).show();
                        $("#part_7").html(DisplayReport('Part-VII Legal', data.data7, 7)).show();
                        $("#part_8").html(DisplayReport('Part-VIII Arrears', data.data8, 8)).show();
                        $("#part_9").html(DisplayReport('Part-IX Logistics', data.data9, 9)).show();
                        $("#part_10").html(DisplayReport('', '[]', 10)).show();
                        $("#part_11").html(DisplayReport('Part-XI Refund granted to UIN entities', data.data11, 11)).show();
                       
                        var cus="DDM-CUS-1-OLD"
                       // part_1_cus_1.innerHTML = "<a class='btn btn-primary' style='margin:10px' href='javascript: GetReport(" + '"' + cus + '"' + ");'> DDM-CUS-1 (OLD-FORMAT) </a>";
                        
                    }


                }
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }

    function DisplayReport(group, data, divNo) {
        debugger;
        if (data != '[]' && data != '') {
            var arr = [];
            arr = $.parseJSON(data);

            var markup = "";
            var count1 = 1;
            
            for (var x = 0; x < arr.length; x++) {

                if (count1 == 1) { markup += "" }
                markup += "<a  class='btn btn-default' style='margin:10px' href='javascript: GetReport(" + '"' + arr[x].CODE + '"' + ");'>" + arr[x].CODE + "</a>"
                if (count1 == 100) { count1 = 1; markup += "" }
                else { count1++; }
            }

            //show div
            $('#div_' + divNo).show();


            return markup;

        }
        else {
            //hide div
            $('#div_' + divNo).hide();
            return "";
        }

    }

    jQuery('#ddl_mth').change(function () {
        var ALL = "All";
        var CEX = "Central Excise";
        var CUS = "Customs";
        var STX = "Service Tax";
        var GST = "GST";
        $('#ddl_dep').empty();
        $('#ddlzone').empty();
        $('#ddlcomm').empty();
        $('#ddl_dep').append('<option value="GST">Select Stream</option>');
       // $('#ddl_dep').append('<option value="GST">' + ALL + '</option>');
       // $('#ddl_dep').append('<option value="CEX">' + CEX + '</option>');
        // $('#ddl_dep').append('<option value="CUS">' + CUS + '</option>');
        // $('#ddl_dep').append('<option value="STX">' + STX + '</option>');
        $('#ddl_dep').append('<option value="GST">' + GST + '</option>');
        Get_FF();

    });

    jQuery('#ddl_year').change(function () {
        var ALL = "All";
        var CEX = "Central Excise";
        var CUS = "Customs";
        var STX = "Service Tax";
        var GST = "GST";
        $('#ddl_dep').empty();
        $('#ddlzone').empty();
        $('#ddlcomm').empty();
        $('#ddl_dep').append('<option value="GST">Select Stream</option>');
        // $('#ddl_dep').append('<option value="GST">' + ALL + '</option>');
        // $('#ddl_dep').append('<option value="CEX">' + CEX + '</option>');
        // $('#ddl_dep').append('<option value="CUS">' + CUS + '</option>');
        // $('#ddl_dep').append('<option value="STX">' + STX + '</option>');
        $('#ddl_dep').append('<option value="GST">' + GST + '</option>');
        Get_FF();

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
            $('#ddl_mth').append('<option value="">Select Month</option>');

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
    
    
<jsp:include page="Footer.jsp" />

