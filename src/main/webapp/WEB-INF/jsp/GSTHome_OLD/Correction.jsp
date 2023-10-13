<jsp:include page="Header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page
	import="java.io.*,java.util.*,java.time.format.DateTimeFormatter,java.time.LocalDateTime"%>


<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><i class="fa fa-external-link fa-fw"></i> CORRECTION REQUEST</h1>
        </div>
    </div>

    
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-warning">
                <div class="panel-heading">
                    Correction Request
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">

                            <div class="col-lg-3">
                                <div class="form-group">
                                
                                <select id="ddl_dep"  class="form-control">
                                <option value="">Select Stream</option>
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
                                <select id="ddl_year" class="form-control">
                                			<option value="">Select Year</option>
                                			<option value="2023">2023</option>
                                			<option value="2022">2022</option>
											<option value="2021">2021</option>
											<option value="2020">2020</option>
											<option value="2019">2019</option>
											<option value="2018">2018</option>
											<option value="2017">2017</option>
                                </select>
                                
<!--                                     @{ -->
<!--                                         var listItems = new List<SelectListItem>(); -->
<!--                                         listItems.Add(new SelectListItem { Text = "--Select Year--", Value = "" }); -->
<!--                                         int i = 0; -->
<!--                                         if (DateTime.Now.Month > 1) -->
<!--                                         { -->
<!--                                             i = DateTime.Now.Year; -->
<!--                                         } -->
<!--                                         else -->
<!--                                         { -->
<!--                                             i = DateTime.Now.Year - 1; -->
<!--                                         } -->
<!--                                         while (i >= 2017) -->
<!--                                         { -->
<!--                                             listItems.Add(new SelectListItem { Text = i.ToString(), Value = i.ToString() }); -->
<!--                                             i = i - 1; -->
<!--                                         } -->
<!--                                         @Html.DropDownList("ddl_year", listItems, new { @class = "form-control" }) -->
<!--                                     } -->

                                </div>
                            </div>

                            <div class="col-lg-3">
                                <div class="form-group">
                                  <select id="ddl_mth" onchange="javascript:ReportBind();" class="form-control">
                                <option value="04">APR</option>
                                  <option value="05">MAY</option>
                                  <option value="06">JUN</option>
                                  <option value="07">JUL</option>
                                  <option value="08">AUG</option>
                                   <option value="09">SEP</option>
                                    <option value="10">OCT</option>
                                     <option value="11">NOV</option>
                                      <option value="12">DEC</option>
                                        <option value="01">JAN</option>
                                     <option value="02">FEB</option>
                                      <option value="03">MAR</option>
                                </select>
                                
<!--                                     @Html.DropDownList("ddl_mth", new List<SelectListItem> -->
<!--       { -->
<!--           //new SelectListItem { Text = "APR", Value = "4"}, -->
<!--           //new SelectListItem { Text = "MAY", Value = "5"}, -->
<!--           //new SelectListItem { Text = "JUN", Value = "6"}, -->
<!--           //new SelectListItem { Text = "JUL", Value = "7"}, -->
<!--           //new SelectListItem { Text = "AUG", Value = "8"}, -->
<!--           //new SelectListItem { Text = "SEP", Value = "9"}, -->
<!--           //new SelectListItem { Text = "OCT", Value = "10"}, -->
<!--           //new SelectListItem { Text = "NOV", Value = "11"}, -->
<!--           //new SelectListItem { Text = "DEC", Value = "12"}, -->
<!--           //new SelectListItem { Text = "JAN", Value = "1"}, -->
<!--           //new SelectListItem { Text = "FEB", Value = "2"}, -->
<!--           //new SelectListItem { Text = "MAR", Value = "3"} -->

<!--       }, new { @class = "form-control" }) -->
                                </div>
                            </div>

							<!-- 
                            <div class="col-lg-3">
                                <div class="form-group">
                                
                                <button class = "btn btn-warning float-right" href="/home/CorrectionBackup/">See All Correction Requests</button>


                                </div>
                            </div>
                             -->
                            
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
                    Part-I Revenue <br />
                    <span style="color:red; font-size:14px;">
                        For F.Y 2018-19 in MPRs Part-I Revenue in MIS,corrections/revisions, if any, may be carried out in the database by 30th April,2019.
                        Data will be freezed automatically.
                    </span>
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

</div>

<!-- <script src="~/Content-GST/jsGST/jquery.js"></script> -->

<script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>

<script language="javascript" type="text/javascript">
    $(document).ready(function () {
    	$("#ddl_mth").val('@DateTime.Now.AddDays(15).AddMonths(-1).Month');
        $('#CORRECTION').css('color', 'black');
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
    function ReportBind() {
        ReportEmpty();
        //alert("inside reportbind inside");
        // var url = "/MIS/GSTHome/ReportBind/";
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GSTHome/ReportBind/";
        var code = "<%= (String) session.getAttribute("CODE")%>";

        $.ajax({
            url: url,
            data: {
                comm: code,
                dep: $('#ddl_dep').val(),
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

            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

        /*        
        $.ajax({
            url: url,
            data: {
                comm: '@Session["CODE"]',
                dep: $('#ddl_dep').val(),
                type: 'Insert'
            },
            cache: false,
            type: "POST",
            success: function (data) {

                $("#part_1").html(DisplayReport('Part-I Revenue', data.data1.replace('DDM-CUS-1A', 'DDM-CUS-1'), 1)).show();
                $("#part_2").html(DisplayReport('Part-II Anti-smuggling', data.data2,2)).show();
                $("#part_3").html(DisplayReport('Part-III Anti-evasion', data.data3,3)).show();
                $("#part_4").html(DisplayReport('Part-IV Audit', data.data4,4)).show();
                $("#part_5").html(DisplayReport('Part-V Adjudication, Call Book, Refunds, Provisional Assessments, Miscellaneous', data.data5,5)).show();
                $("#part_6").html(DisplayReport('Part-VI Valuation', data.data6,6)).show();
                $("#part_7").html(DisplayReport('Part-VII Legal', data.data7,7)).show();
                $("#part_8").html(DisplayReport('Part-VIII Arrears', data.data8,8)).show();
                $("#part_9").html(DisplayReport('Part-IX Logistics', data.data9, 9)).show();
                $("#part_10").html(DisplayReport('Part-X Withdrawal of Departmental Appeals', data.data10, 10)).show();
                $("#part_11").html(DisplayReport('Part-XI Refund granted to UIN entities', data.data11, 11)).show();
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });
		*/
    }

    
    function DisplayReport_new(group, data, divNo) {

		
		var month = $('#ddl_mth').val();
		var year =  $('#ddl_year').val();

		var MM_YYYY = year +"-" +month;

	
		
		if (data != '[]' && data != '') {
	
			var arr = [];
			arr = JSON.parse(data);
	

			var markup = "";
			var count1 = 1;
			for (var x = 0; x < arr.length; x++) {
				if (count1 == 1) {
					markup += ""
				}
				if (arr[x].CODE == 'DLA-ALL-A1') {
					markup += "<a target='_blank' class='btn btn-default m-10' href='" + "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST"	+ arr[x].CODE.substring(0, 3) + "/Insert/"+ arr[x].CODE.replace(/\-/g, '_').replace("DLA_ALL_A1", "DLA_ALL_B")+ "/" + MM_YYYY + "&CRR=T" + "'>"+ arr[x].CODE + "</a>"
				} 
				else if (arr[x].CODE == 'DLA-ALL-B') {
					markup += "<a target='_blank' class='btn btn-default m-10' href='"+ "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST"	+ arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DLA_ALL_B", "DLA_ALL_C")+ "/" + MM_YYYY + "&CRR=T"  + "'>"+ arr[x].CODE  + "</a>"
				} 
				else if (arr[x].CODE == 'DLA-ALL-X') {
					markup += "<a target='_blank' class='btn btn-default m-10' href='" + "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST"	+ arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DLA_ALL_X", "DLA_ALL_D")+ "/" + MM_YYYY + "&CRR=T"  + "'>"+ arr[x].CODE  + "</a>"
				} 
				else if (arr[x].CODE == 'DDM-CUS-1') {
                    markup += "<a target='_blank' class='btn btn-default m-10' href='" + "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST"	+ arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DDM_CUS_1", "DDM_CUS_1A")+ "/" + MM_YYYY + "&CRR=T"  + "'>" + arr[x].CODE + "</a>"
                }
				else if (arr[x].CODE == 'DGA-ST-1') {
                    markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DGA_ST_1", "DGA_ST_1_1") +"/" + MM_YYYY + "&CRR=T"  + "'>" + arr[x].CODE + "</a>"
                }
				else if (arr[x].CODE == 'DGA-ST-1A') {
                    markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DGA_ST_1A", "DGA_ST_1A_1") +"/" + MM_YYYY + "&CRR=T"  + "'>" + arr[x].CODE + "</a>"
                }
                else if (arr[x].CODE == 'DGA-CE-1') {
                    markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DGA_CE_1", "DGA_CE_1_1") +"/" + MM_YYYY + "&CRR=T"  + "'>" + arr[x].CODE + "</a>"
                }
				else if (arr[x].CODE == 'DGA-CE-1A') {
                    markup += "<a target='_blank' class='btn btn-default m-10' href='<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST" + arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_').replace("DGA_CE_1A", "DGA_CE_1A_1") +"/" + MM_YYYY + "&CRR=T"  + "'>" + arr[x].CODE + "</a>"
                }
				else {

					markup += "<a target='_blank' class='btn btn-default m-10' href='"+  "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST"	+ arr[x].CODE.substring(0, 3) + "/Insert/" + arr[x].CODE.replace(/\-/g, '_')+ "/" + MM_YYYY + "&CRR=T"  + "'>" + arr[x].CODE + "</a>"
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
	
    
    function DisplayReport(group, data, divNo) {
        if (data != '[]' && data != '') {
            var arr = [];
            arr = $.parseJSON(data);

            var markup = "";
            var count1 = 1;
            for (var x = 0; x < arr.length; x++) {

                if (count1 == 1) { markup += "" }
                
                markup += "<a class='btn btn-default' style='margin:10px' href='javascript:GetReport(" + '"' + arr[x].CODE + '"' + ");'>" + arr[x].CODE + "</a>"
                if (count1 == 5) { count1 = 1; markup += "" }
                else { count1++; }
            }
            //show div
            $('#div_' + divNo).show();

            return markup;

        }
        else {
            $('#div_' + divNo).hide();
            return "";      
        }
    }

    
    function GetReport(_reportname) {

    	var month = $("#ddl_mth option:selected").text();
    	//if(month < 10) {month = "0" + month;}
		var year =  $('#ddl_year').val();

		var MM_YYYY = year +"-" +month;
        
        //if ($('#ddl_mth').val() < 4 && $('#ddl_year').val() <= new Date().getFullYear())
        //{
        //    alert('You can not update previous financial year data.')
        //    return;
        //}
        if (_reportname == 'DDM-CUS-1') {
            _reportname = 'DDM-CUS-1A';
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

        /*
        	 string viewname = Report_Name.Replace("-", "_");
                string r_name = Report_Name.Substring(0, 3);
                string MM_YYYY = year + '-' + month;
                string url = "/" + "GST" + r_name + "/Insert/" + viewname + "?MM_YYYY=" + MM_YYYY + "&CRR=T";
        */

        
        // var url = "/MIS/GSTHome/Correction_Redirect/";
        
        var url = "<%=request.getSession().getAttribute("DYNAMIC_LINK_PATH") %>GST"+ _reportname.substring(0, 3) + "/Insert/"+ _reportname.replace(/\-/g, '_')+"/<%=request.getSession().getAttribute("CSRF_Token").toString() %>"+"?MM_YYYY=" + MM_YYYY +"&CRR=T";
        //alert("url " + url);
        
        var _month = $("#ddl_mth option:selected").text();
        var _year = $('#ddl_year').val();

        window.open(url, '_blank');
        /*
        $.ajax({
            url: url,
            data: {
            	month: _month,
                year: _year,
                Report_Name: _reportname
            },
            cache: false,
            type: "GET",
            success: function (data) {
            	
            	window.open('/MIS' + data, '_blank');

            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });
        */

        /*
        $.ajax({
            url: url,
            data: {
                month: _month,
                year: _year,
                Report_Name: _reportname
            },
            cache: false,
            type: "POST",
            success: function (data) {
                //window.location = data;
                data = data;
                window.open('/MIS' + data, '_blank');

                return false;
            },
            error: function (reponse) {
                alert("error : " + reponse);
            }
        });

        */

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
</script>

<jsp:include page="Footer.jsp" />
