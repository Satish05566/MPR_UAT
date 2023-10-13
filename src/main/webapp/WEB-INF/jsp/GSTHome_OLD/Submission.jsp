<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<jsp:include page="Header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import = "java.io.*,java.util.*,java.time.format.DateTimeFormatter,java.time.LocalDateTime" %>

<!--  <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>  -->
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>

<%!  String Type = "";%>
<%	
		    String str_zone_code = request.getSession().getAttribute("CODE").toString();
		     Type = request.getSession().getAttribute("TYPE").toString();		    
		%>
		

<form action="" method="Post" >

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
                                    <div id="Message">
                                    
                                    </div>
                                </div>
                                <div class="login_success" id="login_success" style="display:none;">
                                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                                    <div id="success-msg">
                                    </div>
                                </div>
                            </div> 
                        </div>
                        <div class="col-lg-12">
                            <div class="col-lg-3">
                                <div class="form-group">
                                		<input type="hidden" id="session_Code" name="session_Code" value="<%= request.getSession().getAttribute("CODE").toString() %>">
                                		<input type="hidden" id="session_Name" name="session_Name" value="<%= request.getSession().getAttribute("NAME").toString() %>">
                                   		<select name="ddl_dep" id="ddl_dep"  class="form-control" onchange='javascript: GetComm();ReportBind();'>
											<option value="">Select Stream</option>
											<!-- <option value="All">All</option>
											<option value="CEX">Central Excise</option>
											<option value="CUS">Customs</option>
											<option value="STX">Service Tax</option> -->
											<option value="GST">GST</option>
										
										</select>
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
                    Part-I Revenue
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
                    
                    <c:set var = "Type"  value = "<%=Type %>"/>
                    <c:if test="${Type == 'ZONE'}">
                    
                        <p id="part_2_cus_8" style="float:right"><a target="_blank" href="/MPR/GSTDRI/Insert/DRI_CUS_8_ZONE/<%=request.getSession().getAttribute("CSRF_Token").toString() %>" >Compounding Offense (DRI-CUS-8)</a></p>
                
                     </c:if>
                     
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
    <!-- <div class="row" id="div_3">
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
    </div> -->
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
    <!-- <div class="row" id="div_7">
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
 -->    

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
            
  

    </div>

 </form>


<script language="javascript" type="text/javascript">

$(document).ready(function () {
    $('#VALIDATE').css('color', 'black');
    
    $('#login_success').css({'background-color': 'green', 'padding': '10px', 'margin-bottom': '15px', 'font-size': '15px', 'text-align': 'center', 'color': 'white'});
    
    <% if (request.getSession().getAttribute("TYPE").toString().equalsIgnoreCase("COMMISSIONERATE")) { %>
    //$("#ddl_dep").hide();
    $("#ddlcomm").hide();
    $('form input').hide();
    //ReportBind();
	<% } %>

	 $("#div_1 , #div_2 , #div_3, #div_4, #div_5, #div_6, #div_7, #div_8, #div_9, #div_10, #div_11").hide();
});
 

    function ReportBind() {
    	var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/ReportBind/";
     	var code;
		<%	
        if (request.getSession().getAttribute("TYPE").toString().equalsIgnoreCase("COMMISSIONERATE")) {%>
            code = document.getElementById("session_Code").value;

       <% }
        else { %>
            code = $('#ddlcomm').val();

       <% } %>

       if ($('#ddl_dep').val() == 'All') {
           var _dep = 'GST';
       }
       else
           {
       		var _dep = $('#ddl_dep').val();
           }
       
      // jQuery.get('/ReportBind', {comm: code, dep: $('#ddl_dep').val() }, function (data) { chkReportBind(data) });
      
        $.ajax({
            url: url,
            data: {
                comm: code,
                dep: _dep
                    //$('#ddl_dep').val()
            },
            cache: false,
            type: "GET",
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
                    $("#part_5").html(DisplayReport('Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous', data.data5.replace('DPM-GST-14A', 'DPM-GST-14').replace('DPM-GST-15A', 'DPM-GST-15'), 5)).show();
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

  /*  function chkReportBind(def) {
        //  alert("inside chkReportBind");
  		
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
            $("#part_10").html(DisplayReport('Part-X Withdrawal of Departmental Appeals', def.data10.replace('DLA-ALL-C', ''), 10)).show();
            $("#part_11").html(DisplayReport('', '[]', 11)).show();
        }
        else {
            $("#part_1").html(DisplayReport('Part-I Revenue', def.data1.replace('DDM-CUS-1A', 'DDM-CUS-1'), 1)).show();
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
        }
	

  		
    }
    */
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

    <%String _code = (String) session.getAttribute("CODE");%>
    function GetComm() {

        //alert("inside GetComm()");
        
        <%if (request.getSession().getAttribute("TYPE").toString().equalsIgnoreCase("COMMISSIONERATE")) {%>
         	ReportBind();
            return false;
       <% } %>
        var procemessage = "<option value='0'> Please wait...</option>";
        $("#ddlcomm").html(procemessage).show();
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Validate/CommBind";

       

        //alert("inside GetComm() 1");
         
        

		//alert("inside GetComm() 2");
		

		var code= '<%=_code%>';

		//alert("inside GetComm() 3"+ code);
        $.ajax({
            url: url,
            data: { zone: code},
            cache: false,
            type: "GET",
            success: function (data) {
                
            	var data = JSON.parse(data.gstCommList);
                var markup = "<option value='0'>All</option>";
                //---------------------------------------------------
                <%if (request.getSession().getAttribute("CODE").toString().equalsIgnoreCase("CC")) {%>
                    markup += "<option value='C0'>HQRS</option>";
                <%}
                else if(request.getSession().getAttribute("CODE").toString().equalsIgnoreCase("DD")) {%>        
                
                	markup += "<option value='H1'>HQ-G1</option>";
                	markup += "<option value='H2'>HQ-C1</option>";
            	<%}%>
                //---------------------------------------------------
                for (var x = 0; x < data.length; x++) {
                    if (data[x].COMM_CODE == 'NQ') {
                        var commname = "MUMBAI(EXPORT)";
                        markup += "<option value=" + data[x].COMM_CODE + ">" + commname + "</option>";
                    }
                    else if (data[x].COMM_CODE == 'NS') {

                    }
                    else if (data[x].COMM_CODE == 'NC') {
                        var commname = "DELHI (AIRPORT AND GENERAL)";
                        markup += "<option value=" + data[x].COMM_CODE + ">" + commname + "</option>";
                    }
                    else if (data[x].COMM_CODE == 'NA') {

                    }
                    else if ((data[x].COMM_CODE == 'MS' || data[x].COMM_CODE == 'MT')) {

                    }
                    else {
                        markup += "<option value=" + data[x].COMM_CODE + ">" + data[x].COMM_NAME + "</option>";
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
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>Validate/Report_Submission";
        var code;

        <%if (request.getSession().getAttribute("TYPE").toString().equalsIgnoreCase("COMMISSIONERATE")) {%>

        	code = document.getElementById("session_Code").value;
            
       <% }
        else { %>
            code = $('#ddlcomm').val();
       <% } %>
		
       if ($('#ddl_dep').val() == 'All') {
           var _dep = 'GST';
       }
       else
           {
       		var _dep = $('#ddl_dep').val();
           }      
      // alert("code"+ code);
      // alert("Group"+ Group);
      // alert(" dep "+$('#ddl_dep').val());
        $.ajax({
            url: url,
            data: {
                comm_code: code,
                Report_Group: Group,
                dep: _dep
                    //$('#ddl_dep').val()
            },
            cache: false,
            type: "GET",
            success: function (data) {
            	var data = JSON.parse(data.result);
            	if(data.indexOf("SUBMITTED") !== -1){
           		 	$("#login_success").show();
                    $("#success-msg").html(data);
                    $("#login_error").hide();
	           	}else{
	           		$("#login_error").show();
	                   $("#Message").html(data);
	                   $("#login_success").hide();
	           	}
            	
                $(window).scrollTop($("#login_error").position().top);
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
        

        <%if (request.getSession().getAttribute("TYPE").toString().equalsIgnoreCase("COMMISSIONERATE")) {%>

    	code = document.getElementById("session_Code").value;
    	name = document.getElementById("session_Name").value;
        
   		<% }
       
        else { %>
            code = $('#ddlcomm').val();
            name = $("#ddlcomm option:selected").text();
		<%

        } 
        %>

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
        else if (reportname == 'DGA-CE-1') {
            reportname = 'DGA-CE-1-1';
        }
        else if (reportname == 'DGA-CE-1A') {
            reportname = 'DGA-CE-1A-1';
        }
        else if (reportname == 'DGA-ST-1') {
            reportname = 'DGA-ST-1-1';
        }
        else if (reportname == 'DGA-ST-1A') {
            reportname = 'DGA-ST-1A-1';
        }
        

       var MM_YYYY='-';
       var Submission_Date='';
        window.open("<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + reportname.substring(0, 3) + "/Report/" + reportname.replace(/\-/g, '_') + "/Temp/" + code + "/" + name + "/" + "-/"+"/<%=request.getSession().getAttribute("CSRF_Token").toString() %>" , '_blank');

    }
</script>

<jsp:include page="Footer.jsp" />