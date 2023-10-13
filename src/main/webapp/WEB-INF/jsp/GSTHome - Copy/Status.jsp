<%-- <jsp:include page="../../GSTHome/Header.jsp" /> --%>
<jsp:include page="../GSTHome/Header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%
					String dateStr = (String) request.getAttribute("date_display");
					String timeStr = (String) request.getAttribute("time_display");
System.out.println("----------dateStr--------"+dateStr+"------timeStr-----"+timeStr);						
				%> 
				

				
	<div id="page-wrapper">												
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><i class="fa fa-external-link fa-fw"></i> Status</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-warning">
             
               <!--  @*<div class="panel-heading">
                   Status
                </div>*@ -->
             
             
             
               <!--  @*@using (Html.BeginForm())
                {*@ -->
                
                
                    <!-- @using (Html.BeginForm(null, null, FormMethod.Post, new { id = "__AjaxAntiForgeryForm" }))
                    {
                        @Html.AntiForgeryToken()
                         -->
                        
           			 <form action="" id="__AjaxAntiForgeryForm"  method="Post" >
           			 <input type="hidden" id="request_CSRF_Token" name="request_CSRF_Token" value="<%= session.getAttribute("CSRF_Token") %>">
       				 <input type="hidden"  id="flagForFF" name="flagForFF"   />
        
				   
				  
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
                                <div class="col-lg-3">
                                    <div class="form-group">
       					
                            
<!-- 
                                        @{
    var listItems = new List<SelectListItem>();

                    int i = 0;
                    if (DateTime.Now.Month > 1)
                    {
                        i = DateTime.Now.Year;
                    }
                    else
                    {
                        i = DateTime.Now.Year - 1;
                    }
                    while (i >= 2017)
                    {
                        listItems.Add(new SelectListItem { Text = i.ToString() + "-" + (i + 1).ToString().Substring(2), Value = i.ToString() + "-" + (i + 1).ToString().Substring(2) });
                        i = i - 1;
                    }
                    @Html.DropDownList("ddl_year", listItems, new { @class = "form-control" })
                                        }
  -->       
       					
       					
       					
       					 <select class="form-control" id="ddl_year" name="ddl_year">
       					 			<option value="2023">2023-24</option>
									<option value="2022">2022-23</option>
									<option value="2021">2021-22</option>
									<option value="2020">2020-21</option>
									<option value="2019">2019-20</option>
									<option value="2018">2018-19</option>
									<option value="2017">2017-18</option>
						</select>
           
                             </div>
                                </div>
                      		 <div class="col-lg-3" id="ddl_dep_div">
      						 <div class="form-group">
     
                               
<!-- 
              @Html.DropDownList("ddl_dep", new List<SelectListItem>
      {
          new SelectListItem { Text = "All", Value = "GST"},
        new SelectListItem { Text = "Central Excise", Value = "CEX"},
        new SelectListItem { Text = "Customs", Value = "CUS"},
        new SelectListItem { Text = "Service Tax", Value = "STX"},
         new SelectListItem { Text = "GST", Value = "GST"}
        }, "Select Stream",
         new { onchange = "javascript:GetZone(this.value);", @class = "form-control" }
     ) -->
     
     
     			<select name="ddl_dep" id="ddl_dep"  class="form-control" onchange = "javascript:GetZone(this.value)">
     			  				<option value="">--Select Stream--</option>
    							<option value="GST">All</option>
   				  			    <option value="CEX">Central Excise</option>
     							<option value="CUS">Customs</option>
     						    <option value="STX">Service Tax</option>
      							<option value="GST">GST</option>
      			</select> 
      
      							</div>
                                </div>
                                
                                <div class="col-lg-3">
                                    <div class="form-group">
                                        <select id="ddlzone" name="ddlzone" onchange="javascript: ReportBind();" class="form-control">
                                                                                       
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="col-lg-3">
                                    <div class="form-group">
                                        <select id="ddl_ReportGroup" name="ddl_ReportGroup" onchange="javascript: ReportBind();" class="form-control">                                            
                                        </select>
                                    </div>
                                </div>
                            </div>
                           
                   
                             
                             
                             <div class="col-lg-12" id="ddm_gst_mpr" style="display:none;">

                            <div class="col-lg-12" id="ddm_gst_mpr" >
                                   
                                    <div class="col-lg-3" id="ddl_dep_div">
                                     <div class="form-group">
                                        
                                        
                                          <!--   @Html.DropDownList("ddl_mpr", new List<SelectListItem>
                                          {
                                            new SelectListItem { Text = "DDM-GST-1", Value = "DDM-GST-1"},
                                            new SelectListItem { Text = "DDM-GST-4", Value = "DDM-GST-4"},
                                            new SelectListItem { Text = "DDM-GST-5", Value = "DDM-GST-5"}
                                            }, "All MPR",
                                            new { onchange = "javascript: ReportBind();", @class = "form-control" }
                                         ) -->
                                         
                                         
                                    <select  id="ddl_mpr" name="ddl_mpr" class="form-control"  onchange = "javascript: ReportBind"();">
									
									<option value="">--All MPR--</option>
									<option value="DDM-GST-1">DDM-GST-1</option>
									<option value="DDM-GST-4">DDM-GST-4</option>
									<option value="DDM-GST-5">DDM-GST-5</option>
									
									</select>
                                         
                              </div>
                           </div>   
                         </div>
                      </div>
                    </div>
                   
                </form>
            </div>
        </div>
    </div> 
    </div>
    <div class="row" id="table_div">
        <div class="col-lg-12">
            <div class="panel panel-danger">
                <div class="panel-heading">
                
               				 
              
                    <a class='btn btn-success' id="btnExport" href='#'><i class="fa fa-download" aria-hidden="true"></i> Download</a>

                   <!--  @*<a class='btn btn-success' download='STATUS(@Convert.ToDateTime(ViewBag.MM_YYYY).ToString("MMM-yyyy").ToUpper()).xls' href='#'><i class="fa fa-download" aria-hidden="true"></i> Download</a>*@ -->
                    
                    <a class='btn btn-info' href='javascript:window.print();'><i class="fa fa-print" aria-hidden="true"></i> Print</a>
                  
                   
                    <a class='btn btn-default float-right' style="margin-top:0px !important">Date :<%=dateStr%>
                    </a>
                    <a class='btn btn-default float-right' style="margin-top:0px !important">Time :<%=timeStr%>
                    </a>
                    
                  
                   <%-- <a class='btn btn-default float-right'>Time: <%= java.util.Calendar.getInstance().getTime() %></a> --%>
                    
                    
                   
                    
                </div>
                <!-- /.panel-heading -->			
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover" id="tbl_Report" ></table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>





<!-- @*Inline Plugin Script For Validation Purpose -->
<%--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  

<!-- <script src="~/Content-GST/jsGST/jquery.js"></script> -->
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script> --%>

<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-Common/js/jquery.js"></script>
<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>

<script>
    $(document).ready(function () {
        $("#btnExport").click(function (e) {
            e.preventDefault();

            //getting data from our table
            var data_type = 'data:application/vnd.ms-excel';
            var table_div = document.getElementById('tbl_Report');
            var table_html = table_div.outerHTML.replace(/ /g, '%20');
            var a = document.createElement('a');
            a.href = data_type + ', ' + table_html;
            //a.download = 'STATUS(@Convert.ToDateTime(ViewBag.MM_YYYY).ToString("MMM-yyyy").ToUpper()).xls';
            a.download = 'STATUS.xls';
            a.click();
        });
    });
</script>

 
	
<script language="javascript" type="text/javascript">
   
    $(document).ready(function () {
         // $('#ddl_dep').hide();
       // if ($('#ddl_dep').val() == 'CEX' 
        ManageMPR();
        $('#STATUS').css('color', 'black');
        $('#table_div').hide();
       
        //GstMpr()
    });

    function ManageMPR()
    {
        if ($('#ddl_ReportGroup').val() == 'PART_1' && $('#ddl_dep').val() == 'GST') {
            $('#ddm_gst_mpr').css('display', 'block');
        }
        else {
            $('#ddm_gst_mpr').css('display', 'none');
        }
    }
     //function GstMpr(_group,_dep) {
    //    var _group = $("#ddl_ReportGroup").val();
    //    var _dep = $("#ddl_dep").val()
    //    //if ($("#ddl_ReportGroup option:selected").val() == "Part-I Revenue" && (("#ddl_dep option:selected").val() == "GST")) {
    //    //    $('#ddl_dep_div').show();
    //    //}
    //    $('#ddl_ReportGroup').on('change', function () {
    //        if (_group == "Part-I Revenue" && (_dep == "GST")) {
    //            $('#ddl_dep_div').show();
    //        }
    //    });
    //    } 
   
    function GetZone(dep) {
    	//alert(" dep "+dep);
        if ($("input:radio[name='Report_Type']:checked").val() != "FF") {
        GetReportGroup(dep);
        
        }

        ManageMPR();

        var _dep_text = $("#ddl_dep option:selected").text();
        if (_dep_text == 'All' && ($('#ddl_dep').val() == 'GST')) {
            dep = null;
        }


        var procemessage = "<option value='0'> Please wait...</option>";
        $("#ddlzone").html(procemessage).show();
        //var url = "/GSTHome/Zone_Bind/";
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/Zone_Bind/";
		

        //var form = $('#__AjaxAntiForgeryForm');
        //var token = $('input[name="__RequestVerificationToken"]', form).val();

        $.ajax({
            url: url,
            data: { dep: dep },
            cache: false,
            type: "GET",
            success: function (data) {
                var data=JSON.parse(data.gstZoneList);
                
                var markup = "<option value=''>--Select Zone--</option>";
                markup += "<option value='0'>All India</option>";
                
                if ($('#ddl_dep').val() == 'CEX' || $('#ddl_dep').val() == 'STX' || $('#ddl_dep').val() == 'GST') {
                    markup += "<option value='CC'>DGCEI</option>";
                }
                else if ($('#ddl_dep').val() == 'CUS') {
                    markup += "<option value='DD'>DGRI</option>";
                }
                else if ($("input:radio[name='Report_Type']:checked").val() == "FF") {
                    markup += "<option value='CC'>DGCEI</option>";
                    markup += "<option value='DD'>DGRI</option>";
                }
               
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
    function GetReportGroup(dep) {
        var _dep_text = $("#ddl_dep option:selected").text();
        var _dep = $('#ddl_dep').val();
        if (_dep_text == 'All') {
            _dep = "GST";
        }

        //var url = "/GSTHome/ReportGroup_Bind/";
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/ReportGroup_Bind/";
        //var form = $('#__AjaxAntiForgeryForm');
        //var token = $('input[name="__RequestVerificationToken"]', form).val();

        $.ajax({
            url: url,
            data: { dep: _dep, dep_text: _dep_text },
            cache: false,
            type: "GET",
            success: function (data) {
                
               var data=JSON.parse(data.GetReportGroup_Bind);
                var markup;
                for (var x = 0; x < data.length; x++) {
                    markup += "<option value=" + data[x].Value + ">" + data[x].Text + "</option>";
                }
                $("#ddl_ReportGroup").html(markup).show();
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

    }

    function Get_FF() {
        if ($("input:radio[name='Report_Type']:checked").val() == "FF") {
            $('#ddl_dep').hide();
            $('#ddl_dep_div').hide();
            $('#table_div').hide();
            ReportEmpty();
            //$('#ddlzone').selectedIndex = 0;
            document.getElementById("ddlzone").selectedIndex = 0;
            document.getElementById("ddl_dep").selectedIndex = 0;
            GetZone(null);
            $('#ddl_ReportGroup').hide();
        }
        else {
            $('#ddl_dep').show();
            $('#ddl_ReportGroup').show();
            $('#ddlzone').empty();
            $('#table_div').hide();
            ReportEmpty();
            document.getElementById("ddl_dep").selectedIndex = 0;
            $('#ddl_dep_div').show();
        }
    }

     //------------------------------------------------------------------------------------------------ 
    function ReportEmpty() {
        $("#tbl_Report").html('').show();

    }

    function ReportBind() {
        ManageMPR();

        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/Status_ReportBind/";
        //var url = "/GSTHome/Status_ReportBind/";
        var ddl_year = $('#ddl_year').val();
        
        $("#tbl_Report").html("").hide();
        
        $("#table_div").hide();
        
        //var form = $('#__AjaxAntiForgeryForm');
        //var token = $('input[name="__RequestVerificationToken"]', form).val();

        $.ajax({
            url: url,
            data: {report_type: $("input:radio[name='Report_Type']:checked").val(), dep: $('#ddl_dep').val(), code: $('#ddlzone').val(), year: $('#ddl_year').val(), group: $("#ddl_ReportGroup option:selected").text(), group_value: $('#ddl_ReportGroup').val(), mpr: $('#ddl_mpr').val() },
            cache: false,
            type: "GET",
            success: function (data) {
                debugger;
                
            	var data=JSON.parse(data.gstReportList);
            	//alert('Length-',data.length);
            	//alert('Length-',data[0].NAME);

            	 /* if (data != '[]' && data!='') {
                 var abc="";
            	//var data=JSON.parse(data.gstReportList);
                var markup;
                for (var x = 0; x < data.length; x++) {
                	abc += "<option value=" + data[x].SNO + ">" + data[x].NAME + "</option>";
                }
				alert(abc);
            	 } */
            	
                var markup = "";
                if (data != '[]' && data!='') {
                    //var arr = [];
                    //arr = JSON.parse(data);
                    //arr = data;
                    
                    markup += "<thead>";
                    markup += "<tr></tr>"
                    markup += "<tr>"
                    markup += "<th>S.NO</th>"
                    markup += "<th>NAME</th>"
                    markup += "<th></th>"
                    if (ddl_year == '2017-18') {
                        markup += "<th style='display:none;'>APR</th>"
                        markup += "<th style='display:none;'>MAY</th>"
                        markup += "<th style='display:none;'>JUN</th>"
                    }
                    else {
                        markup += "<th>APR</th>"
                        markup += "<th>MAY</th>"
                        markup += "<th>JUN</th>"
                    }

                    markup += "<th>JUL</th>"
                    markup += "<th>AUG</th>"
                    markup += "<th>SEP</th>"
                    markup += "<th>OCT</th>"
                    markup += "<th>NOV</th>"
                    markup += "<th>DEC</th>"
                    markup += "<th>JAN</th>"
                    markup += "<th>FEB</th>"
                    markup += "<th>MAR</th>"
                    markup += "</tr>"
                    markup += "</thead>";

                    markup += "<tr style='text-align:center;background:#324F17; color:white;'>"
                    markup += "<th></th>"
                    markup += "<th>VALIDATED WITHIN DUE DATE(G)</th>"
                    markup += "<th></th>"
                    if (ddl_year == '2017-18') {
                        markup += "<th style='display:none;'>0</th>"
                        markup += "<th style='display:none;'>0</th>"
                        markup += "<th style='display:none;'>0</th>"
                    }
                    else {
                        markup += "<th>0</th>"
                        markup += "<th>0</th>"
                        markup += "<th>0</th>"
                    }

                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "</tr>"

                    markup += "<tr style='text-align:center;background:#EEC900; color:black;'>"
                    markup += "<th></th>"
                    markup += "<th>VALIDATED AFTER DUE DATE(Y)</th>"
                    markup += "<th></th>"
                    if (ddl_year == '2017-18') {
                        markup += "<th style='display:none;'>0</th>"
                        markup += "<th style='display:none;'>0</th>"
                        markup += "<th style='display:none;'>0</th>"
                    }
                    else {
                        markup += "<th>0</th>"
                        markup += "<th>0</th>"
                        markup += "<th>0</th>"
                    }
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "</tr>"

                    markup += "<tr style='text-align:center;background:#592B1B; color:white;'>"
                    markup += "<th></th>"
                    markup += "<th>NOT YET UPLOADED(B)</th>"
                    markup += "<th></th>"
                    if (ddl_year == '2017-18') {
                        markup += "<th style='display:none;'>0</th>"
                        markup += "<th style='display:none;'>0</th>"
                        markup += "<th style='display:none;'>0</th>"
                    }
                    else {
                        markup += "<th>0</th>"
                        markup += "<th>0</th>"
                        markup += "<th>0</th>"
                    }

                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "<th>0</th>"
                    markup += "</tr>"

    					
                    for (var x = 0; x < data.length; x++) {

                        markup += "<tr>"
                        markup += "<td>" + data[x].SNO + "</td>"
                        markup += "<td>" + data[x].NAME + "</td>"
                        markup += "<td>" + data[x].CODE + "</td>"
                        markup += "<td>" + data[x].APR + "</td>"
                        markup += "<td>" + data[x].MAY + "</td>"
                        markup += "<td>" + data[x].JUN + "</td>"
                        markup += "<td>" + data[x].JUL + "</td>"
                        markup += "<td>" + data[x].AUG + "</td>"
                        markup += "<td>" + data[x].SEP + "</td>"
                        markup += "<td>" + data[x].OCT + "</td>"
                        markup += "<td>" + data[x].NOV + "</td>"
                        markup += "<td>" + data[x].DEC + "</td>"
                        markup += "<td>" + data[x].JAN + "</td>"
                        markup += "<td>" + data[x].FEB + "</td>"
                        markup += "<td>" + data[x].MAR + "</td>"
                        markup += "</tr>"
                        $('#table_div').show();
                    }
                }
                $("#tbl_Report").html(markup).show();

                $('#tbl_Report tr').each(function () {
                    var $tds = $(this).find('td');
                    if (ddl_year == '2017-18') {
                        $tds.eq(3).css('display', 'none');
                        $tds.eq(4).css('display', 'none');
                        $tds.eq(5).css('display', 'none');
                    }


                    //---------------------------------------------------------------------
                    debugger;
                    //var max_date = $('#ddl_year').val().substring(0, 4) + '-05-01';
                    //var date_text = $tds.eq(3).text();
                    var year = $('#ddl_year').val().substring(0, 4);
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, year + '-05-16', $tds.eq(3).text(), 3, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, year + '-06-16', $tds.eq(4).text(), 4, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, year + '-07-16', $tds.eq(5).text(), 5, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, year + '-08-16', $tds.eq(6).text(), 6, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, year + '-09-16', $tds.eq(7).text(), 7, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, year + '-10-16', $tds.eq(8).text(), 8, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, year + '-11-16', $tds.eq(9).text(), 9, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, year + '-12-16', $tds.eq(10).text(), 10, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, parseInt(year) + 1 + '-01-16', $tds.eq(11).text(), 11, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, parseInt(year) + 1 + '-02-16', $tds.eq(12).text(), 12, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, parseInt(year) + 1 + '-03-16', $tds.eq(13).text(), 13, $tds)
                    color($tds.eq(1).text(), $tds.eq(2).text(), year, parseInt(year) + 1 + '-04-16', $tds.eq(14).text(), 14, $tds)
                    if ($tds.eq(0).text() == '0' && $tds.eq(2).text() == '0') {
                        $(this).html('<td colspan="15"><h3>' + $tds.eq(1).text() + '</h3></td>');
                    }

                    if ($tds.eq(0).text() == '0') {
                        $tds.eq(1).css('font-weight', 'bold');
                        $tds.eq(0).text('');
                        $tds.eq(2).text('');
                    }
                });
            },
            error: function (reponse) {
                /* alert("error : " + reponse); */
            }
        });
    }
    function color(name, code, year, max_date, date_text, td_index, $tds) {

        var ab = Date.parse(max_date);
        var dc = Date.parse('2018-01-16');
        var dd = Date.parse('2018-02-16');
        var de = Date.parse('2018-04-16');
        if ($('#ddl_dep').val() == 'CUS' && $('#ddl_ReportGroup').val() == 'PART_1' && (code == 'ZV' || code == 'ZX' || code == 'ZW' || code == 'YF' || code == 'YB' || code == 'TK' || code == 'TL' || code == 'XM' || code == 'XO' || code == 'XQ' || code == 'TH' || code == 'TI' || code == 'TJ' || name == 'LUCKNOW CE & GST' || name == 'CHENNAI CE & GST') && (ab > dc)) {
            $tds.eq(td_index).html('NA');
        }
        else if ($('#ddl_dep').val() == 'CUS' && $('#ddl_ReportGroup').val() == 'PART_2' && (code == 'YB' || code == 'YF' || code == 'TK' || code == 'TL' || code == 'XM' || code == 'XO' || code == 'XQ' || code == 'ZV' || code == 'ZX' || code == 'ZW' || code == 'TJ' || code == 'TH' || code == 'WE' || code == 'WF' || name == 'LUCKNOW CE & GST' || name == 'CHENNAI CE & GST' || name == 'KOLKATA CE & GST') && (ab > dc)) {
            $tds.eq(td_index).html('NA');
        }
        else if ($('#ddl_dep').val() == 'CUS' && $('#ddl_ReportGroup').val() == 'PART_4' && (code == 'ZX' || code == 'ZW' || code == 'YF' || code == 'TK' || code == 'TL' || code == 'XM' || code == 'XO' || code == 'XQ' || code == 'XP' || code == 'WE') && (ab > dc)) {
            $tds.eq(td_index).html('NA');
        }
        else if ($('#ddl_dep').val() == 'CUS' && $('#ddl_ReportGroup').val() == 'PART_5' && (code == 'ZV' || code == 'ZX' || code == 'ZW' || code == 'YF' || code == 'YB' || code == 'TJ' || code == 'TK' || code == 'XL' || code == 'TL' || code == 'XM' || code == 'XO' || code == 'XQ' || code == 'XP' || code == 'WE' || code == 'WF') && (ab > dc)) {
            $tds.eq(td_index).html('NA');
        }
        else if ($('#ddl_dep').val() == 'CUS' && $('#ddl_ReportGroup').val() == 'PART_7' && (code == 'ZV' || code == 'ZX' || code == 'ZW' || code == 'YF' || code == 'YB' || code == 'TI' || code == 'TJ' || code == 'TH' || code == 'TK' || code == 'TL' || code == 'XM' || code == 'XO' || code == 'XQ' || code == 'XP' || code == 'WF' || code == 'WE' || name == 'LUCKNOW CE & GST' || name == 'CHENNAI CE & GST' || name == 'KOLKATA CE & GST') && (ab > dc)) {
            $tds.eq(td_index).html('NA');
        }
        else if ($('#ddl_dep').val() == 'CUS' && $('#ddl_ReportGroup').val() == 'PART_8' && (code == 'ZX' || code == 'ZW' || code == 'YF' || code == 'YB' || code == 'TI' || code == 'TJ' || code == 'TH' || code == 'TK' || code == 'XL' || code == 'TL' || code == 'XM' || code == 'XO' || code == 'XQ' || code == 'XP' || code == 'WF' || code == 'WE' || name == 'LUCKNOW CE & GST' || name == 'CHENNAI CE & GST' || name == 'KOLKATA CE & GST') && (ab > dc)) {
            $tds.eq(td_index).html('NA');
        }
        else if ($('#ddl_dep').val() == 'CUS' && $('#ddl_ReportGroup').val() == 'PART_9' && (code == 'ZV' || code == 'ZX' || code == 'ZW' || code == 'ZU' || code == 'TK' || code == 'XL' || code == 'TL' || code == 'XM' || code == 'XO' || code == 'XQ' || code == 'XP' || code == 'WF' || code == 'WE' || name == 'LUCKNOW CE & GST' || name == 'CHENNAI CE & GST' || name == 'KOLKATA CE & GST') && (ab > dc)) {
            $tds.eq(td_index).html('NA');
        }
        else if ($('#ddl_dep').val() == 'CUS' && (code == 'OJ' || code == 'OK') && (ab <= dd)) {
            $tds.eq(td_index).html('NA');
        }
        else if ($('#ddl_dep').val() == 'CUS' && (code == 'UJ' || code == 'UI' || code == 'UM' || code == 'UL' || code == 'VH' || code == 'VJ' || code == 'VG' || code == 'VI') && (ab > dd)) {
            $tds.eq(td_index).html('NA');
        }
        else if ($('#ddl_dep').val() == 'CUS' && $('#ddl_ReportGroup').val() == 'PART_1' && (code == 'WE' || code == 'WF' || name == 'KOLKATA CE & GST') && (ab > dd)) {
            $tds.eq(td_index).html('NA');
        }
        else if ($('#ddl_dep').val() == 'CUS' && (code == 'MS' || code == 'MT' || code == 'NA' || code == 'NS' || code == 'VU' || code == 'VQ' || code == 'VW' || code == 'VV' || code == 'VT' || code == 'VR' || code == 'VS') && (ab > de)) {
            $tds.eq(td_index).html('NA');
        }
            //else if ($('#ddl_dep').val() == 'CUS' && $('#ddl_ReportGroup').val() == 'PART_2' && (code == 'XX' || code == 'XW' || name == 'RANCHI CE & GST' || code == 'WN' || code == 'WO' || code == 'WM' || code == 'WP' || name == 'JAIPUR CE & GST' || code == 'VC' || code == 'TA' || code == 'VB' || name == 'VADODARA CE & GST') && (ab > de)) {
            //    $tds.eq(td_index).html('NA');
            //}

        else {
            if (date_text == 'null' || date_text == '1800-01-01T00:00:00') {
                if (new Date(max_date).getYear() < new Date().getYear() || (new Date(max_date).getYear() == new Date().getYear() && (new Date(max_date).getMonth() < (new Date().getMonth() + 1) || (new Date().getMonth() + 1) == 0))) {
                    //if (new Date(max_date).getYear() < new Date().getYear() || (new Date(max_date).getYear() == new Date().getYear() && (new Date(max_date).getMonth() < (new Date().getMonth() - 3) || (new Date().getMonth() + 1) == 0))) {
                    $tds.eq(td_index).html('B');
                    $tds.eq(td_index).css('background', '#592B1B');
                    $tds.eq(td_index).css('color', 'white');
                    if ($tds.eq(0).html() != '0') {
                        tbl_Report.rows[4].cells[td_index].innerHTML = parseInt(tbl_Report.rows[4].cells[td_index].innerHTML) + 1;
                    }
                }
                else {
                    $tds.eq(td_index).html('-');
                }

            }
            else {
                if (new Date(date_text).getTime() <= new Date('2015-08-15').getTime() || new Date(date_text).getTime() <= new Date(max_date).getTime()) {
                    $tds.eq(td_index).css('background', '#324F17');
                    $tds.eq(td_index).css('color', 'white');
                    $tds.eq(td_index).html('G');
                    if ($tds.eq(0).html() != '0') {
                        tbl_Report.rows[2].cells[td_index].innerHTML = parseInt(tbl_Report.rows[2].cells[td_index].innerHTML) + 1;
                    }
                }
                else if (date_text != '') {
                    $tds.eq(td_index).css('background', '#EEC900');
                    $tds.eq(td_index).css('color', 'black');
                    $tds.eq(td_index).html('Y');
                    if ($tds.eq(0).html() != '0') {
                        tbl_Report.rows[3].cells[td_index].innerHTML = parseInt(tbl_Report.rows[3].cells[td_index].innerHTML) + 1;
                    }

                }
            }

        }
    }
</script>
