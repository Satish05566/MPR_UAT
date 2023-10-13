<%@page import="java.time.Year"%>
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
                                    
                                    <%
					         		java.util.Map<String,String> year = new java.util.LinkedHashMap<String,String>();
					         		year.put("Select Year","");
					         		int i = 0;
					         		
					         		Date current_month=new Date();
					                if (current_month.getMonth() > 1)
					                {
					                    i = current_month.getYear();
					                }
					                else
					                {
					                    i = current_month.getYear() - 1;
					                }
					                while (i >= 2017)
					                {
					                	year.put(Integer.toString(i),Integer.toString(i));
					                    i = i - 1;
					                }
					                request.setAttribute("year", year);
					                %>
                                      <select name="ddl_year" id="ddl_year"  class="form-control">
										<c:forEach items="${year}" var="varyear">
										        <option value="${varyear.value}">${varyear.key}</option>
										    </c:forEach>
									</select> 

                                    </div>
                                </div>

                                <div class="col-lg-2">
                                   <div class="form-group">
                                   									        
									       <select name="ddl_mth" id="ddl_mth"  class="form-control">
											<!-- <option value="04">Apr</option>
											<option value="05">May</option>
											<option value="06">Jun</option>
											<option value="07">Jul</option>
											<option value="08">Aug</option>
											<option value="09">Sep</option>
											<option value="10">Oct</option>
											<option value="11">Nov</option>
											<option value="12">Dec</option>
											<option value="01">Jan</option>
											<option value="02">Feb</option>
											<option value="03">Mar</option>  -->
									       </select> 

                                    </div>
                                </div>

                                <div id="ddl_dep_div" class="col-lg-3">
         						<div class="form-group">
         						
					         		<%					         							         		
					         		java.util.Map<String,String> dep = new java.util.LinkedHashMap<String,String>();
					         		//dep.put("Select Stream","Select Stream");
					         		dep.put("All","GST");
					         		dep.put("Central Excise","CEX");
					         		dep.put("Customs","CUS");
					         		dep.put("Service Tax","STX");
					         		dep.put("GST","GST");
					         		
					         		request.setAttribute("dep", dep);
					         		%>
         						
						         	<select name="ddl_dep" id="ddl_dep"  class="form-control" onchange = "javascript:GetZone(this.value);">
										<c:forEach items="${dep}" var="vardep">
										        <option value="${vardep.value}">${vardep.key}</option>
										    </c:forEach>
									</select>
						      
                                   </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="form-group">
                                    <select id="ddlzone" name="ddlzone" onchange='javascript:GetComm(this.value);' class="form-control"></select>                                       
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="form-group">
                                        <select id="ddlregin" name="ddlregin" class="form-control"></select>
                                        <select id="ddlcomm" name="ddlcomm" onchange='javascript: ReportBind();' class="form-control"></select>
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
                        <p id="part_1_cus_1 float-right"></p>
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

   
</form>
</div>

<!-- @*Inline Plugin Script For Validation Purpose*@ -->
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>

<!-- @*Inline Script For Validation Purpose*@ -->
<script language="javascript" type="text/javascript">
    $(document).ready(function () {
        $('#MPR').css('color', 'black');
    //    $("#ddl_mth").val('@DateTime.Now.AddDays(15).AddMonths(-1).Month');
        $('#ddlregin').hide();
        $("#div_1 , #div_2 , #div_3, #div_4, #div_5, #div_6, #div_7, #div_8, #div_9, #div_10, #div_11").hide();

    	$('#ddl_mth').append('<option value="" selected>Select Month</option>');
    });

    function GetReportFieldsValue(){

    	//alert ("Inside GetReportFieldsValue");    	
    	//alert ("document.getElementById(ddl_year).value" + document.getElementById("ddl_year").value);
    	//alert ("document.getElementById(ddl_mth).value" + document.getElementById("ddl_mth").value);
    	//alert ("document.getElementById(ddl_dep).value" + document.getElementById("ddl_dep").value);
    	//alert ("document.getElementById(ddl_year).value" + document.getElementById("ddl_year").value); 

    	

     }
    
    function GetRegion() {
        //$('#ddlcomm').empty();
        ReportBind();
        var procemessage = "<option value='0'> Please wait...</option>";
        $("#ddlregin").html(procemessage).show();
       // var url = "/GSTHome/Region_Bind/";
		/*
        $.ajax({
            url: url,
            data: {},
            cache: false,
            type: "POST",
            success: function (data) {
                var markup;
                for (var x = 0; x < data.length; x++) {
                    markup += "<option value=" + data[x].Value + ">" + data[x].Text + "</option>";
                }
                $("#ddlregin").html(markup).show();
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });*/
        var markup;
        markup =  "<option value='0'> Select REGION</option>";
        markup += "<option value='01'>EASTERN</option>";
        markup += "<option value='02'>SOUTHERN</option>";
        markup += "<option value='03'>CENTRAL</option>";
        markup += "<option value='04'>NORTHERN</option>";
        markup += "<option value='05'>WESTERN</option>";
        markup += "<option value='06'>NORTH WESTERN</option>";        
        
        
        $("#ddlregin").html(markup).show();
    }
    function GetZone(_stateId) {
		 // temporary JS by Tarun
        
    	// $("#div_1").show();
    	
       // return false;
       // alert("GetZone");
       	
        //alert("inside Get ZONE Dep " + _stateId);
        //alert("inside Get ZONE Dep val " + $('#ddl_dep').val());
        $('#ddlcomm').empty();
       // ReportBind();
               
        var procemessage = "<option value='0'> Please wait...</option>";
        $("#ddlzone").html(procemessage).show();

        var url = "/GSTHome/Zone_Bind/";
		//alert("1");
        var form = $('#__AjaxAntiForgeryForm');
        var token = $('input[name="__RequestVerificationToken"]', form).val();
       // alert("_stateId" + _stateId);
        if(_stateId != 'NO_FETCH'){
           // alert("before jquery call" );
        	jQuery.get('/GSTDDM/ZoneBind', { dep: _stateId }, function (data) { chkGetZone(data) });
    	}
	    else{
           // alert("else before call chkGetZone" );
	    	chkGetZone('');
		}
        //alert("3");

      //  ReportBind();

    }

    function chkGetZone(def) {
       // alert("inside chkGetZone");


        var data = "";

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
        	markup = "<option value=''>Select REGION</option>";
            markup += "<option value='00'>MEMBER REGION</option>";
            markup += "<option value='CC'>DGCEI</option>";
            markup += "<option value='DD'>DGRI</option>";
            markup += "<option value='A0'>DGA</option>";
            markup += "<option value='0A'>CC ZONE</option>";
        }
        //------------------------------------------------------------
		if(def != ''){
			var abc = JSON.parse(def.gstZoneList);
	        for (var x = 0; x < abc.length; x++) {
	            markup += "<option value=" + abc[x].ZONE_CODE + ">" + abc[x].ZONE_NAME + "</option>";
	        }
    	}
        $("#ddlzone").html(markup).show();
        
        
    }
	
    
   // function GetComm(zoneId, dep) {
	 function GetComm(zoneId) {
    	 // temporary JS by Tarun
        
   	  	
//       return false;

        var _month = $("#ddl_mth option:selected").val();
        var _year = $('#ddl_year').val();
	//	alert("_month " + _month);
	//	alert("_year " + _year);
	//	alert("zoneId " + zoneId);
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
        //alert("before call to ReportBind");
      // 	ReportBind();
       	//alert("after call to ReportBind");
        var procemessage = "<option value='0'> Please wait...</option>";
        $("#ddlcomm").html(procemessage).show();
        //var url = "/GSTHome/Comm_Bind/";

        //var form = $('#__AjaxAntiForgeryForm');
        //var token = $('input[name="__RequestVerificationToken"]', form).val();
        jQuery.get('/GSTDDM/CommBind', {zone: zoneId, dep: $('#ddl_dep').val() }, function (data) { chkGetComm(data,zoneId,_month,_year) });

        /*
        $.ajax({
            url: url,
            data: { __RequestVerificationToken: token, zone: zoneId, dep: $('#ddl_dep').val() },
            cache: false,
            type: "POST",
            success: function (data) {
                var markup = "<option value=''>All</option>";
                //---------------------------------------------------
                if (zoneId == 'CC') {
                    markup += "<option value='C0'>HQRS</option>";
                }
                else if (zoneId == 'DD') {
                    markup += "<option value='H1'>HQ-G1</option>";
                    markup += "<option value='H2'>HQ-C1</option>";
                }
                //---------------------------------------------------
                for (var x = 0; x < data.length; x++) {
                    if (data[x].Value == 'NQ' && (_month >= '4' && _year >= '2018')) {
                        var commname = "MUMBAI(EXPORT)";
                        markup += "<option value=" + data[x].Value + ">" + commname + "</option>";
                    }
                    else if (data[x].Value == 'NS' && (_month >= '4' && _year >= '2018')) {

                    }
                    else if (data[x].Value == 'NC' && (_month >= '4' && _year >= '2018')) {
                        var commname = "DELHI (AIRPORT AND GENERAL)";
                        markup += "<option value=" + data[x].Value + ">" + commname + "</option>";
                    }
                    else if (data[x].Value == 'NA' && (_month >= '4' && _year >= '2018')) {

                    }
                    else if ((data[x].Value == 'MS' || data[x].Value == 'MT') && (_month >= '4' && _year >= '2018')) {

                    }
                    else {
                        markup += "<option value=" + data[x].Value + ">" + data[x].Text + "</option>";
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
        }); */

    }

	 function chkGetComm(def,zoneId,_month,_year) {
	    	var abc = JSON.parse(def.gstCommList);
	        var data = "";

			//alert("inside chkGetComm");

			//alert("inside chkGetComm" + abc);

			//alert("zoneId" + zoneId);
			
	        var markup = "<option value=''>All</option>";
            //---------------------------------------------------
            if (zoneId == 'CC') {
                markup += "<option value='C0'>HQRS</option>";
            }
            else if (zoneId == 'DD') {
                markup += "<option value='H1'>HQ-G1</option>";
                markup += "<option value='H2'>HQ-C1</option>";
            }
            //---------------------------------------------------
            for (var x = 0; x < abc.length; x++) {
                if (abc[x].COMM_CODE == 'NQ' && (_month >= '4' && _year >= '2018')) {
                    var commname = "MUMBAI(EXPORT)";
                    markup += "<option value=" + abc[x].COMM_CODE + ">" + commname + "</option>";
                }
                else if (abc[x].COMM_CODE == 'NS' && (_month >= '4' && _year >= '2018')) {

                }
                else if (abc[x].COMM_CODE == 'NC' && (_month >= '4' && _year >= '2018')) {
                    var commname = "DELHI (AIRPORT AND GENERAL)";
                    markup += "<option value=" + abc[x].COMM_CODE + ">" + commname + "</option>";
                }
                else if (abc[x].COMM_CODE == 'NA' && (_month >= '4' && _year >= '2018')) {

                }
                else if ((abc[x].COMM_CODE == 'MS' || abc[x].COMM_CODE == 'MT') && (_month >= '4' && _year >= '2018')) {

                }
                else {
                    markup += "<option value=" + abc[x].COMM_CODE + ">" + abc[x].COMM_NAME + "</option>";
                }

            }
           // alert("markup "+ markup);
            $("#ddlcomm").html(markup).show();
	        
	    }	
	    
    function Get_FF() {
        if ($("input:radio[name='Report_Type']:checked").val() == "FF") {
          //  alert("inside if FF");
            //$('#ddl_dep').hide();
            $('#ddl_dep_div').hide();
        
            $('#ddlcomm').empty();
            //$('#ddlzone').selectedIndex = 0;
            document.getElementById("ddlzone").selectedIndex = 0;
            document.getElementById("ddl_dep").selectedIndex = 0;
         
          //  alert("before GetZone");
            GetZone('NO_FETCH');
        //    alert("inside if FF 2");
        //    alert("after GetZone");
        }
        else {
        //	alert("inside else FF");

            $('#ddl_dep_div').show();
            $('#ddlcomm').empty();
            $('#ddlzone').empty();
            $('#ddlregin').empty();
            $('#ddlregin').hide();   
             
            
            ReportEmpty();
            document.getElementById("ddl_dep").selectedIndex = 0;
            $("#div_1 , #div_2 , #div_3, #div_4, #div_5, #div_6, #div_7, #div_8, #div_9, #div_10, #div_11").hide();
        }
    }

    function GetReport(_reportname) {

    	//alert("Inside GetReport");
      //  alert("report Name "+ _reportname);

      //  alert("$(#ddlzone).val() "+ $('#ddlzone').val());

        if ($('#ddlzone').val() == '00') {
            window.open("/GST" + _reportname.substring(0, 3) + "/Report/" + _reportname.replace(/\-/g, '_') + "/Region/" + $('#ddlregin').val() + "/" + $("#ddlregin option:selected").text() + "/" + $("#ddl_mth option:selected").text() + "-" + $('#ddl_year').val(), '_blank');
            return false;
        }
        //var url = "/GSTHome/Report_Redirect/";
        
        var _dep = $('#ddl_dep').val();
       // alert("_dep "+ _dep);
        var _zone_code = $('#ddlzone').val();
     //  alert("_zone_code "+ _zone_code);
        var _zone_name = $("#ddlzone option:selected").text();
       // alert("_zone_name "+ _zone_name);
        var _zone_name_temp = _zone_name.replace('&', 'AND');
        _zone_name = _zone_name_temp;
    //   alert("_zone_name "+ _zone_name);
        var _comm_code = $('#ddlcomm').val();
  //      alert("_comm_code "+ _comm_code);
        var _comm_name = $("#ddlcomm option:selected").text();
   //     alert("_comm_name "+ _comm_name);
        var _month = $("#ddl_mth option:selected").text();
        //alert("_month "+ _month);
        var _year = $('#ddl_year').val();
        //alert("_year "+ _year);

        if (_year == '' || _month == 'Select Month') {
            alert('Please select the year and month');
            return false;
        }
        //alert("before Jquery call");
        
        jQuery.get('/GSTDDM/Report_Redirect', {dep: _dep,zone_code: _zone_code,zone_name: _zone_name,comm_code: _comm_code,comm_name: _comm_name,month: _month, year: _year,Report_Name: _reportname }, function (data) {window.open(data, '_blank');return false; });
        /*
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
            type: "POST",
            success: function (data) {
                data = '' + data;
                //window.location = data;
                window.open(data, '_blank');

                return false;
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });  */
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

        var url = "/GSTHome/ReportBind/";

       // alert("inside ReportBind  before juery call")
       // alert("zone " + $('#ddlzone').val());
       // alert("comm " + $('#ddlcomm').val());
       // alert("dep " + $('#ddl_dep').val());
       
      // alert("ddlregin -->" + $('#ddlregin').val() +"<--");
       var	_regin_val = $('#ddlregin').val();
       var	_regin = 0;
		var _comm = $('#ddlcomm').val();
		var _zone = $('#ddlzone').val();

		 if(_comm == null){
				_comm = "All";

	        } 
		if(_zone == null){
			_zone = "All India";

        }
		
       if(_regin_val == null){
    	   _regin = 0;
       }
       else{
    	   _regin = 1;
       }
     //  alert("_regin " + _regin + " _regin_val " + _regin_val)
     //   alert ("_comm " + _comm);
     //       alert ("dep " + $('#ddl_dep').val());
     //       alert ("zone " + _zone);
        
        jQuery.get('/ReportBind', {comm: _comm, dep: $('#ddl_dep').val(),zone: _zone,regin_flg:_regin,regin_code:_regin_val }, function (data) { chkReportBind(data) });
        /*
        $.ajax({
            url: url,
            data: {
                comm: $('#ddlcomm').val(),
                dep: $('#ddl_dep').val(),
                zone: $('#ddlzone').val()
            },
            cache: false,
            type: "POST",
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
                        $("#part_5").html(DisplayReport('Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous', data.data5, 5)).show();
                        $("#part_6").html(DisplayReport('Part-VI Valuation', data.data6, 6)).show();
                        $("#part_7").html(DisplayReport('Part-VII Legal', data.data7, 7)).show();
                        $("#part_8").html(DisplayReport('Part-VIII Arrears', data.data8, 8)).show();
                        $("#part_9").html(DisplayReport('Part-IX Logistics', data.data9, 9)).show();
                        $("#part_10").html(DisplayReport('', '[]', 10)).show();
                        $("#part_11").html(DisplayReport('Part-XI Refund granted to UIN entities', data.data11, 11)).show();
                       
                        var cus="DDM-CUS-1-OLD"
                        part_1_cus_1.innerHTML = "<a class='btn btn-primary m-10' href='javascript: GetReport(" + '"' + cus + '"' + ");'> DDM-CUS-1 (OLD-FORMAT) </a>";
                        
                    }


                }
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

        */	
    }

    function chkReportBind(def) {
      //  alert("inside chkReportBind");
		var data = def;

		/*
        alert(" ddlzone" + $('#ddlzone').val());
        alert(" ddl_dep" + $('#ddl_dep').val());

        alert(" def.data1" + def.data1);
        alert(" def.data2" + def.data2);
        alert(" def.data3" + def.data3);
        alert(" def.data4" + def.data4);
        alert(" def.data5" + def.data5);
        alert(" def.data6" + def.data6);
        alert(" def.data7" + def.data7);
        alert(" def.data8" + def.data8);
        alert(" def.data9" + def.data9);

        */
		
        if ($('#ddlzone').val() == '0A') {
          //  alert("inside Zone 1");
            $("#part_2").html(DisplayReport('Part-II Anti-smuggling', def.data2, 2)).show();
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
        //	alert("inside Zone 2");
            $("#part_1").html(DisplayReport('', '[]', 1)).show();
            $("#part_2").html(DisplayReport('', '[]', 2)).show();
            $("#part_3").html(DisplayReport('', '[]', 3)).show();
            $("#part_4").html(DisplayReport('Part-IV Audit', def.data4, 4)).show();
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
          //  	alert("inside Zone 3");
                $("#part_1").html(DisplayReport('', '[]', 1)).show();
                $("#part_2").html(DisplayReport('', '[]', 2)).show();
                $("#part_3").html(DisplayReport('', '[]', 3)).show();
                $("#part_4").html(DisplayReport('', '[]', 4)).show();
                $("#part_5").html(DisplayReport('', '[]', 5)).show();
                $("#part_6").html(DisplayReport('', '[]', 6)).show();
                $("#part_7").html(DisplayReport('', '[]', 7)).show();
                $("#part_8").html(DisplayReport('', '[]', 8)).show();
                $("#part_9").html(DisplayReport('', '[]', 9)).show();
             	$("#part_10").html(DisplayReport('Part-X Withdrawal of Departmental Appeals', def.data10, 10)).show();
                $("#part_11").html(DisplayReport('', '[]', 11)).show();
            }
            else {
            //	alert("inside Zone 4");
            	var param1 = 'Part-I Revenue';
            	//var param2 = def.data1.replace('DDM-CUS-1A', 'DDM-CUS-1');
            	var param2 = def.data1;
                var param3 = 1
                //alert("param1" + param1);alert("param2" + param2);alert("param3" + param3);	
                //$("#part_1").html(DisplayReport('Part-I Revenue', def.data1.replace('DDM-CUS-1A', 'DDM-CUS-1'), 1)).show();
                $("#part_1").html(DisplayReport(param1, param2, param3)).show();
                //alert("after part1");
                $("#part_2").html(DisplayReport('Part-II Anti-smuggling', def.data2, 2)).show();
                $("#part_3").html(DisplayReport('Part-III Anti-evasion', def.data3.replace('CEI-GST-12A', 'CEI-GST-12'), 3)).show();
                $("#part_4").html(DisplayReport('Part-IV Audit', def.data4, 4)).show();
                $("#part_5").html(DisplayReport('Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous', def.data5, 5)).show();
                $("#part_6").html(DisplayReport('Part-VI Valuation', def.data6, 6)).show();
                $("#part_7").html(DisplayReport('Part-VII Legal', def.data7, 7)).show();
                $("#part_8").html(DisplayReport('Part-VIII Arrears', def.data8, 8)).show();
                $("#part_9").html(DisplayReport('Part-IX Logistics', def.data9, 9)).show();
                $("#part_10").html(DisplayReport('', '[]', 10)).show();
              	$("#part_11").html(DisplayReport('Part-XI Refund granted to UIN entities', def.data11, 11)).show();
               
                var cus="DDM-CUS-1-OLD"
                part_1_cus_1.innerHTML = "<a class='btn btn-primary m-10' href='javascript: GetReport(" + '"' + cus + '"' + ");'> DDM-CUS-1 (OLD-FORMAT) </a>";
                
            }


       }

                
        
    }
    

    function DisplayReport(group, data, divNo) {
      //  alert("inside DisplayReport");
      //  alert("before other alerts");
      //  alert ("group "+group);
        
        if (data != '[]' && data != '') {
            var arr = [];
            arr = $.parseJSON(data);

            var markup = "";
            var count1 = 1;
            for (var x = 0; x < arr.length; x++) {

            	if (count1 == 1) { markup += "" }
                markup += "<a  class='btn btn-default m-10' href='javascript: GetReport(" + '"' + arr[x].CODE + '"' + ");'>" + arr[x].CODE + "</a>"
            	if (count1 == 100) { count1 = 1; markup += "" }
            	else { count1++; }
            }

          //  alert("markup ----> " + markup);
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
        //$('#ddl_dep').empty();
        $('#ddlzone').empty(); 
        $('#ddlcomm').empty();
        /*
        $('#ddl_dep').append('<option value="">Select Stream</option>');
        $('#ddl_dep').append('<option value="All">' + ALL + '</option>');
        $('#ddl_dep').append('<option value="CEX">' + CEX + '</option>');
        $('#ddl_dep').append('<option value="CUS">' + CUS + '</option>');
        $('#ddl_dep').append('<option value="STX">' + STX + '</option>');
        $('#ddl_dep').append('<option value="GST">' + GST + '</option>');
		*/
        Get_FF();

    });

    jQuery('#ddl_year').change(function () {
        var ALL = "All";
        var CEX = "Central Excise";
        var CUS = "Customs";
        var STX = "Service Tax";
        var GST = "GST";
      //  $('#ddl_dep').empty();
        $('#ddlzone').empty();
        $('#ddlcomm').empty();
		/*
        $('#ddl_dep').append('<option value="">Select Stream</option>');
        $('#ddl_dep').append('<option value="GST">' + ALL + '</option>');
        $('#ddl_dep').append('<option value="CEX">' + CEX + '</option>');
        $('#ddl_dep').append('<option value="CUS">' + CUS + '</option>');
        $('#ddl_dep').append('<option value="STX">' + STX + '</option>');
        $('#ddl_dep').append('<option value="GST">' + GST + '</option>');
		*/
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
          //  alert("totalMonths " + totalMonths);
          //  alert("SelectedYear " + SelectedYear);
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

