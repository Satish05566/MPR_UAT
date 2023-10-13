<jsp:include page="Header.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page
	import="java.io.*,java.util.*,java.time.format.DateTimeFormatter,java.time.LocalDateTime"%>

<div id="page-wrapper">
	<div class="row">
	
		<div class="col-lg-4">
			<h4 class="page-header p-b-0 no-border">
				<i class="fa fa-upload fa-fw"></i> UPLOAD
			</h4>

		</div>
		<div class="col-lg-8">

			<ol class="breadcrumb float-right  no-bg-col p-t-20 m-b-0 p-r-0">
				<li><a href="/KPI_Home"><i class="fa fa-home"></i> Management Information</a></li>
				<li class="active">Upload</li>

			</ol>
		</div>
	
	</div>

	<form action="" method="Post">

		<input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-warning">
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">

								<div class="col-lg-4">
									<div class="form-group m-b-0">

										<%
											java.util.Map<String, String> dep = new java.util.LinkedHashMap<String, String>();
											dep.put("", "Select Stream");
											/* dep.put("All", "All");
											dep.put("CEX", "Central Excise");
											dep.put("CUS", "Customs");
											dep.put("STX", "Service Tax"); */
											dep.put("GST", "GST");
											request.setAttribute("dep", dep);
										%>
										<select name="ddl_dep" id="ddl_dep" class="form-control"
											onchange="javascript:ReportBind();">
											<c:forEach items="${dep}" var="vardep">
												<option value="${vardep.key}">${vardep.value}</option>
											</c:forEach>
										</select>  

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
						<!-- @*<p id="part_1_cus_1" style="float:right"></p>*@  -->
					</div>

					<div class="panel-body p-t-b-0">
						<div class="row p-l-r-20">							
							<div class="col-lg-12">
							<!-- <div class="col-lg-3" id="part_1_target"></div>  -->
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
					<div class="panel-heading">Part-II Anti-smuggling</div>
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
					<div class="panel-heading">Part-III Anti-evasion</div>
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
		<!-- <div class="row" id="div_4">
			<div class="col-lg-12">
				<div class="panel panel-danger">
					<div class="panel-heading">Part-IV Audit</div>
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
					<div class="panel-heading">Part-V Adjudication, Call Book,
						Refunds, Provisional Assessments, Miscellaneous</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<!-- @*<div class="col-lg-2"><p id="opening_updation_5">Opening Updation :</p></div>
                            <div class="col-lg-2" id="part_5_opening"></div>*@  -->
								<div class="col-lg-12" id="part_5"></div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row" id="div_6">
			<div class="col-lg-12">
				<div class="panel panel-warning">
					<div class="panel-heading">Part-VI Valuation</div>
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
					<div class="panel-heading">Part-VII Legal</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								@*<div class="col-lg-2"><p id="opening_updation_7">Opening Updation :</p></div>*@
                            @*<div class="col-lg-2" id="part_7_opening"></div>*@ 
								<div id="part_7" class="col-lg-12"></div>
								@*<div class="col-lg-12"><button class="btn btn-danger" >DLA Uploading has been suspended for Today, 15<sup>th</sup> Oct,2018. Sorry for Inconvenience. </button></div>*@ 

							</div>

						</div>
					</div>
				</div>
			</div>
		</div> -->
		<!-- <div class="row" id="div_8">
			<div class="col-lg-12">
				<div class="panel panel-danger">
					<div class="panel-heading">Part-VIII Arrears</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								@*<div class="col-lg-2"><p id="opening_updation_8">Opening Updation :</p></div>
                              <div class="col-lg-2" id="part_8_opening"></div>*@  
								<div class="col-lg-2" id="part_8_target"></div>
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
					<div class="panel-heading">Part-IX Logistics</div>
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
					<div class="panel-heading">Part-X Withdrawal of Departmental
						Appeals</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<div class="col-lg-10" id="part_10"></div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row" id="div_11">
			<div class="col-lg-12">
				<div class="panel panel-success">
					<div class="panel-heading">Part-XI Refund granted to UIN
						entities</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<div class="col-lg-10" id="part_11"></div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</form>
</div>

<!-- Inline Plugin Script For Validation Purpose  -->
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>

<!-- Inline Script For Validation Purpose  -->

<script language="javascript" type="text/javascript">
    $(document).ready(function () {
     $("#div_1 , #div_2 , #div_3, #div_4, #div_5, #div_6, #div_7, #div_8, #div_9, #div_10, #div_11").hide();
    });

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
    <%String _code = (String) session.getAttribute("CODE");%>
    function ReportBind() {
    	ReportEmpty();
    	//$("#div_1 , #div_2 , #div_3, #div_4, #div_5, #div_6, #div_7, #div_8, #div_9, #div_10, #div_11").hide();
    
        var code= '<%=_code%>';
        
       if ($('#ddl_dep').val() == 'All') {
            var _dep = 'GST';
        }
        else
            {
        		var _dep = $('#ddl_dep').val();
            }
          
        //alert("code " + code);
		//alert($('#ddl_dep').val());
		var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/ReportBind/";
		//jQuery.get('/ReportBind', {comm: code, dep: $('#ddl_dep').val(),type : 'Insert',zone: '' }, function (data) { chkReportBind(data) });

		$.ajax({
            url: url,
            data: {
                comm: code,
                dep: _dep,
                    //$('#ddl_dep').val(),
                type: 'Insert'
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
                    $("#part_10").html(DisplayReport('Part-X Withdrawal of Departmental Appeals', data.data10.replace('DLA-ALL-B', 'DLA-ALL-A1').replace('DLA-ALL-C', 'DLA-ALL-B'), 10)).show();
                    $("#part_11").html(DisplayReport('', '[]', 11)).show();
                }
                else
                {
                    $("#part_1").html(DisplayReport('Part-I Revenue', data.data1.replace('DDM-CUS-1A', 'DDM-CUS-1'), 1)).show();
                    $("#part_2").html(DisplayReport('Part-II Anti-smuggling', data.data2, 2)).show();
                    $("#part_3").html(DisplayReport('Part-III Anti-evasion', data.data3, 3)).show();
                    $("#part_4").html(DisplayReport('Part-IV Audit', data.data4, 4)).show();
                    $("#part_5").html(DisplayReport('Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous', data.data5, 5)).show();
                    $("#part_6").html(DisplayReport('Part-VI Valuation', data.data6, 6)).show();
                    $("#part_7").html(DisplayReport('Part-VII Legal', data.data7, 7)).show();
                    $("#part_8").html(DisplayReport('Part-VIII Arrears', data.data8, 8)).show();
                    $("#part_9").html(DisplayReport('Part-IX Logistics', data.data9, 9)).show();
                    $("#part_10").html(DisplayReport('', '[]', 10)).show();
                    $("#part_11").html(DisplayReport('Part-XI Refund granted to UIN entities', data.data11, 11)).show();
                }
                
                if ($('#ddl_dep').val() == 'CEX') {
                    var dpt = 'CE';
                    var _TARGET="_1";
                }
                else if ($('#ddl_dep').val() == 'CUS') {
                    var dpt = 'CUS';
                    var _TARGET="_1A";
                }
                else if ($('#ddl_dep').val() == 'STX') {
                    var dpt = 'ST';
                    var _TARGET="_1";
                }
                else if ($('#ddl_dep').val() == 'GST') {
                    var dpt = 'GST';
                    var _TARGET="_1";
                }

                part_1.innerHTML = "<a class='btn btn-primary' style='margin:10px' target='_blank' href='/MPR/GSTDDM/Insert/DDM_" + dpt + _TARGET + "_TARGET/<%= session.getAttribute("CSRF_Token") %>' target='_blank'>REVENUE TARGET UPLOAD</a>"+ part_1.innerHTML;
                //part_1.rows[0].cells[0].innerHTML = "<a target='_blank' href='/GSTDDM/Insert/DDM_" + dpt + "_1_TARGET' target='_blank'>REVENUE TARGET UPLOAD</a>";
                //part_2.rows[0].cells[0].innerHTML = "<td><div style='text-align:left;'>" + part_2.rows[0].cells[0].innerHTML + "<h4>Opening Updation:- <select id='ddl_MPR_2' name='ddl_MPR' style='width: 120px'></select></h4></div</td>";
                //part_9.rows[0].cells[0].innerHTML = "<td><div style='text-align:left;'>" + part_9.rows[0].cells[0].innerHTML + "<h4>Opening Updation:- <select id='ddl_MPR_9' name='ddl_MPR' style='width: 120px' onchange = 'javascript:GetOpening('part_9');'></select></h4></div</td>";
                if ($('#ddl_dep').val() != 'GST') {
                part_8.innerHTML = "<a class='btn btn-primary' style='margin:10px' target='_blank' href='/MPR/GSTTAR/Insert/TAR_" + dpt + "_TARGET' target='_blank'>TAR TARGET UPLOAD</a>"+ part_8.innerHTML;
                }
                //part_9.innerHTML = "<a class='btn btn-primary' style='margin:10px' target='_blank' href='/GSTDOL/Insert/DOL_TARGET' target='_blank'>DOL TARGET UPLOAD</a>"+ part_9.innerHTML;
                part_9.innerHTML = "<a class='btn btn-primary' style='margin:10px' target='_blank' href='/MPR/GSTDOL/Insert/DOL_TARGET" + "/<%= session.getAttribute("CSRF_Token") %>' target='_blank'>DOL TARGET UPLOAD</a>"+ part_9.innerHTML;
                
                //part_5_opening.innerHTML = "<select id='ddl_MPR_5' name='ddl_MPR' class='form-control' onchange = 'javascript:GetOpening('part_5');'></select>";
                //part_7_opening.innerHTML = "<select id='ddl_MPR_7' name='ddl_MPR' class='form-control' onchange = 'javascript:GetOpening('part_7');'></select>";
                //part_8_opening.innerHTML = "<select id='ddl_MPR_8' name='ddl_MPR' class='form-control' onchange = 'javascript:GetOpening('part_8');'></select>";

                //part_1_cus_1.innerHTML = "<a class='btn btn-primary' style='margin:10px' target='_blank' href='/GSTDDM/Report/DDM_CUS_1/Comm/" + dpt + "_1_TARGET' target='_blank'>DDM-CUS-1 (OLD-FORMAT)</a>";


            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });
	}
      
	
	function DisplayReport(group, data, divNo) {

		if (data != '[]' && data != '') {
			//alert(data);
			//GetMPR(group);

			var arr = [];
			arr = JSON.parse(data);
			//alert(arr);

			var markup = "";
			var count1 = 1;
			var session_csrf_token=  '<%=request.getSession().getAttribute("CSRF_Token").toString() %>';
			for (var x = 0; x < arr.length; x++) {
				if (count1 == 1) {
					markup += ""
				}
				if (arr[x].CODE == 'DLA-ALL-A1') {
					//markup += "<a target='_blank' class='btn btn-default m-10' href='/GST"	+ arr[x].CODE.substring(0, 3) + "/Insert/"+ arr[x].CODE.replace(/\-/g, '_').replace("DLA_ALL_A1", "DLA_ALL_B")+ "'>"+ arr[x].CODE + "</a>"
					markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DLA_ALL_A1", "DLA_ALL_B") +"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
				} 
				else if (arr[x].CODE == 'DLA-ALL-B') {
					//markup += "<a target='_blank' class='btn btn-default m-10' href='/GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DLA_ALL_B", "DLA_ALL_C") + "'>"+ arr[x].CODE + "</a>"
					markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DLA_ALL_B", "DLA_ALL_C") +"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
				} 
				else if (arr[x].CODE == 'DLA-ALL-X') {
					//markup += "<a target='_blank' class='btn btn-default m-10' href='/GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DLA_ALL_X", "DLA_ALL_D") + "'>"+ arr[x].CODE + "</a>"
					markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DLA_ALL_X", "DLA_ALL_D") +"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
				} 
				else if (arr[x].CODE == 'DDM-CUS-1') {
                    //markup += "<a target='_blank' class='btn btn-default m-10' href='/GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DDM_CUS_1", "DDM_CUS_1A") + "'>" + arr[x].CODE + "</a>"
					markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DDM_CUS_1", "DDM_CUS_1A") +"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
                }
				else if (arr[x].CODE == 'DGA-CE-1') {
                    //markup += "<a target='_blank' class='btn btn-default m-10' href='/GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DDM_CUS_1", "DDM_CUS_1A") + "'>" + arr[x].CODE + "</a>"
					markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DGA_CE_1", "DGA_CE_1_1") +"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
                }
				else if (arr[x].CODE == 'DGA-CE-1A') {
                    //markup += "<a target='_blank' class='btn btn-default m-10' href='/GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DDM_CUS_1", "DDM_CUS_1A") + "'>" + arr[x].CODE + "</a>"
					markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DGA_CE_1A", "DGA_CE_1A_1") +"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
                }
				else if (arr[x].CODE == 'DGA-ST-1') {
                    //markup += "<a target='_blank' class='btn btn-default m-10' href='/GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DDM_CUS_1", "DDM_CUS_1A") + "'>" + arr[x].CODE + "</a>"
					markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DGA_ST_1", "DGA_ST_1_1") +"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
                }
				else if (arr[x].CODE == 'DGA-ST-1A') {
                    //markup += "<a target='_blank' class='btn btn-default m-10' href='/GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DDM_CUS_1", "DDM_CUS_1A") + "'>" + arr[x].CODE + "</a>"
					markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DGA_ST_1A", "DGA_ST_1A_1") +"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
                }
				else if (arr[x].CODE == 'DDM-GST-1' || arr[x].CODE == 'DDM-GST-2' || arr[x].CODE == 'DDM-GST-5' || arr[x].CODE == 'DPM-GST-4' || arr[x].CODE == 'DPM-GST-12' || arr[x].CODE == 'DPM-GST-14A' || arr[x].CODE == 'DPM-GST-14B' || arr[x].CODE == 'DPM-GST-15A' || arr[x].CODE == 'DPM-GST-15B' || arr[x].CODE == 'DPM-GST-15C') {
					markup += "<a target='_blank' style='background-color: #f2dede;' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_')+"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
					
				}
				else if (arr[x].CODE == 'DDM-GST-3' || arr[x].CODE == 'DDM-GST-3A' || arr[x].CODE == 'DDM-GST-4' || arr[x].CODE == 'DDM-GST-4A' || arr[x].CODE == 'GST-GST-2') {
					markup += "<a target='_blank' style='background-color: #f2dede;' class='btn btn-default m-10' title='This proforma contains data pertaining to Section 39 of the CGST Act, 2017 and is available for the month prior to the reporting month' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_')+"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
					
				}
				else if (arr[x].CODE.substring(0, 2)== 'GI') {
					markup += "<a target='_blank' style='background-color: #f2dede;' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 2) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_')+"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
					
				}
				else { 

					//markup += "<a target='_blank' class='btn btn-default m-10' href='/GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DRI_CUS_9", "DRI_CUS_9_1") + "'>" + arr[x].CODE + "</a>"
					markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_')+"/" + "<%=request.getSession().getAttribute("CSRF_Token").toString() %>'>" + arr[x].CODE + "</a>"
				}
				if (count1 == 100) {
					count1 = 1;
					markup += ""
				} else {
					count1++;
				}
			}

			$('#div_' + divNo).show();
			return markup;

		} else {
			$('#div_' + divNo).hide();
			return "";
		}
	}
	/*@*<a href="@Url.Action(@r.CODE.Replace("-","_"), "DDM/Insert")" target="_blank">*@*/

	function GetMPR(group) {
		var _group = group;
		var _dep = $("#ddl_dep").val()
		var _type = "Insert";
		var url = "/GSTDDM/MPR_Bind/";

		//var form = $('#__AjaxAntiForgeryForm');
		//var token = $('input[name="__RequestVerificationToken"]', form).val();

		$.ajax({
					url : url,
					data : {
						//__RequestVerificationToken: token,
						dep : _dep,
						group : _group,
						type : _type
					},
					cache : false,
					type : "POST",
					success : function(data) {
						var data = JSON.parse(data.MPRList);
						alert(data);
						if (data != '[]' && data != '') {
							var arr = [];
							arr = JSON.parse(data);
							//alert(arr);

							var markup = "";
							markup += "<option value='-1'>" + '--Select MPR--' + "</option>";
							for (var x = 0; x < arr.length; x++) {
								markup += "<option value='" + arr[x] + "'>"	+ arr[x] + "</option>";
							}
						}
						if (group == 'Part-II Anti-smuggling') {
							$("#ddl_MPR_2").html(markup).show();
						} else if (group == 'Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous') {
							$("#ddl_MPR_5").html(markup).show();
						} else if (group == 'Part-VII Legal') {
							$("#ddl_MPR_7").html(markup).show();
						} else if (group == 'Part-VIII Arrears') {
							$("#ddl_MPR_8").html(markup).show();
						} else if (group == 'Part-IX Logistics') {
							$("#ddl_MPR_9").html(markup).show();
						}

					},
					error : function(reponse) {
						alert("error2 : " + reponse);
					}
				});

	}
</script>

<script language="javascript" type="text/javascript">
	$(document).ready(function() {
		$('#INSERT').css('color', 'black');

		//part_2------
		$("#ddl_MPR_2").live('change', function() {

			var url = "/GSTDDM/Opening_Redirect/";
			var _mpr_name = $('#ddl_MPR_2').val();
			$.ajax({
				url : url,
				data : {
					Report_Name : _mpr_name
				},
				cache : false,
				type : "POST",
				success : function(data) {
					if (data != '')
						data = '' + data;
					window.open(data, '_blank');
					return false;
				},
				error : function(reponse) {
					alert("error : " + reponse);
				}
			});

		});
		//part_5------
		$("#ddl_MPR_5").live('change', function() {

			var url = "/GSTDDM/Opening_Redirect/";
			var _mpr_name = $('#ddl_MPR_5').val();
			$.ajax({
				url : url,
				data : {
					Report_Name : _mpr_name
				},
				cache : false,
				type : "POST",
				success : function(data) {
					if (data != '')
						data = '' + data;
					window.open(data, '_blank');
					return false;
				},
				error : function(reponse) {
					alert("error : " + reponse);
				}
			});

		});

		//part_7------
		$("#ddl_MPR_7").live('change', function() {

			var url = "/GSTDDM/Opening_Redirect/";
			var _mpr_name = $('#ddl_MPR_7').val();
			$.ajax({
				url : url,
				data : {
					Report_Name : _mpr_name
				},
				cache : false,
				type : "POST",
				success : function(data) {
					if (data != '')
						data = '' + data;
					window.open(data, '_blank');
					return false;
				},
				error : function(reponse) {
					alert("error : " + reponse);
				}
			});

		});

		//part_8------
		$("#ddl_MPR_8").live('change', function() {

			var url = "/GSTDDM/Opening_Redirect/";
			var _mpr_name = $('#ddl_MPR_8').val();
			$.ajax({
				url : url,
				data : {
					Report_Name : _mpr_name
				},
				cache : false,
				type : "POST",
				success : function(data) {
					if (data != '')
						data = '' + data;
					window.open(data, '_blank');
					return false;
				},
				error : function(reponse) {
					alert("error : " + reponse);
				}
			});

		});

		//part_9------
		$("#ddl_MPR_9").live('change', function() {

			var url = "/GSTDDM/Opening_Redirect/";
			var _mpr_name = $('#ddl_MPR_9').val();
			$.ajax({
				url : url,
				data : {
					Report_Name : _mpr_name
				},
				cache : false,
				type : "POST",
				success : function(data) {
					if (data != '')
						data = '' + data;
					window.open(data, '_blank');
					return false;
				},
				error : function(reponse) {
					alert("error : " + reponse);
				}
			});

		});

	});
</script>
<jsp:include page="Footer.jsp" />