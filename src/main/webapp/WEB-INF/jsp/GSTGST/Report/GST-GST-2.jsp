<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.math.BigDecimal"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />

<link href="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/cssMPR/mpr-report.css" rel="stylesheet" />
   
   <script src="<%= session.getAttribute("JSP_PATH_RESOLVE") %>Content-MPR/jsMPR/jquery-3.6.0.min.js"></script>
    <script language="javascript" type="text/javascript">
        $(document).ready(function () {
            $('#report_1 tr').each(function () {
                var row = $(this).index();
                $(this).find('td').each(function () {
                    var col = $(this).index();
                    if (report_1.rows[row].cells[col].innerHTML.trim() != report_2.rows[row].cells[col].innerHTML.trim()) {
                        $(this).css('color', 'red');
                        report_2.rows[row].cells[col].style.backgroundColor = "grey";
                    }
                });
            })
        });
    </script>

    <title>GST-RTN-1</title>
</head>
<body>
<%!String desDt = "";
    String strDate = "";%>
    <c:set var="TOTAL_COMM" value="${model.TOTAL_COMM}" />
    <c:set var="COMPLETE_COMM" value="${model.COMPLETE_COMM}" />
    <c:set var="AMND" value="${model.AMND}" />
    <div id="Report_main">
	<table>
	<%
                        String strDate = (String) request.getAttribute("ViewBag_MM_YYYY");
                        java.text.DateFormat srcDtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = srcDtFormat.parse(strDate);
                        java.text.DateFormat desDtFormat = new java.text.SimpleDateFormat("MMM-yyyy");
                        desDt = desDtFormat.format(date);
                    
                    %>
		<c:if test="${not empty model && model.COMPLETE_COMM >=1}">
            <table>
                <tr>              
                
                    <td style="text-align: left;">
                    <c:if test="${TOTAL_COMM > COMPLETE_COMM}">
                            <img
                                src="<%= session.getAttribute("DYNAMIC_LINK_PATH") %>Content-MPR/imagesMPR/mpr-img/incomplete.gif"
                                title="${COMPLETE_COMM}/${TOTAL_COMM}" />
                        </c:if> 
                        <c:if test="${!(TOTAL_COMM > COMPLETE_COMM)}">
                            <img src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/complete.gif" />
                            
                        </c:if> <c:if test="${AMND != 0}">
                            <a
                                href="/../../../Home/Correction_Backup_List?MM_YYYY=${ViewBag_MM_YYYY}&MPR=GST-GST-2"
                                style="color: brown; font-weight: bold;"> <img
                                src="<%=session.getAttribute("DYNAMIC_LINK_PATH")%>Content-MPR/imagesMPR/mpr-img/Amended.gif" /></a>
                        </c:if></td>
                    <td>&nbsp;</td>
                    
                    
                    <td style="text-align: center;"><a
                        download='GST-GST-2(<%=desDt.toUpperCase()%>).xls' href="">Download</a>
                        &nbsp;&nbsp; <a href="javascript:window.print();">Print</a></td>
                    <td style="text-align: right;"><%=new java.text.SimpleDateFormat("M/dd/yyyy hh:mm:ss a").format(new java.util.Date())%></td>
                </tr>
            </table>
        </c:if>  
        <table>
            <tr>
                <td align="center">
                    <h1>GST-RTN-1  </h1>
                    <h2>Status of filing of various GST returns</h2>
                </td>
            </tr>
            </table>
            <tr>
                <td align="left" colspan="2" style="padding-left:10px;">
                   <h2>${ViewBag_Report_Name}<br />
                   MONTH : <%=desDt.toUpperCase()%>                   
                   </h2>
                </td>
            </tr>
      </table>
        
              <c:if test="${not empty model && model.COMPLETE_COMM >=1}">
            <% int i=0; %>
		         <c:if test="${Report_Type=='Crr'}">
		            <div><h2>CORRECTED REPORT<span style="color:red;"> **Corrections are shown in red</span></h2></div>
		        </c:if>
		        
				<table id="report_1" class="Report_body" >
					<!-- <tr>
				       <th colspan="32" align="center">Status of filing of various GST returns </th>
				   </tr> -->
				   <tr class="header_bcg_clr">
				       <th rowspan="3" >S. No.</th>
				       <th  colspan="9" >Number of Taxpayers required to file GST Returns</th>
				       <th  colspan="9" >Taxpayers who filed GST Returns</th>
				       <th  colspan="10" >Taxpayers who have not filed GST Return</th> 
				       <th rowspan="3" >Taxpayers where GSTR 3A has been issued (out of col no. 29)</th>
				       <th rowspan="3" >Taxpayers where GSTR 3A has not been issued  (out of col no. 30)</th>
				   </tr>
				 
				    <tr class="header_bcg_clr">
				       <th colspan="2" >Monthly Return</th>
				       <th colspan="3" >Quarterly Return</th>
				       <th colspan="4" >Annual Return</th>
				       <th colspan="2" >Monthly Return</th>
				       <th colspan="3" >Quarterly Return</th>
				       <th colspan="4" >Annual Return</th>
				       <th colspan="2" >Monthly Return</th>
				       <th colspan="3" >Quarterly Return</th>
				       <th colspan="4" >Annual Return</th>	
				       <th rowspan="2" >Total</th>	       
				       
				   </tr>
				<tr class="header_bcg_clr">
				       <th rowspan="1" colspan="1" >GSTR 1M</th>
				       <th rowspan="1" colspan="1" >GSTR 3BM</th>
				       <th rowspan="1" colspan="1" >GSTR-1Q</th> 
				       <th rowspan="1" colspan="1" >GSTR-3BQ</th>
				       <th rowspan="1" colspan="1" >GST-CMP-08 </th>
				       <th rowspan="1" colspan="1" >GSTR 4</th>
				       <th rowspan="1" colspan="1" >GSTR 9</th>
				       <th rowspan="1" colspan="1" >GSTR 9A</th>
				       <th rowspan="1" colspan="1" >GSTR 9C</th>
				       <th rowspan="1" colspan="1" >GSTR 1M</th>
				       <th rowspan="1" colspan="1" >GSTR 3BM</th>
				       <th rowspan="1" colspan="1" >GSTR-1Q</th> 
				       <th rowspan="1" colspan="1" >GSTR-3BQ</th>
				       <th rowspan="1" colspan="1" >GST-CMP-08</th>
				       <th rowspan="1" colspan="1" >GSTR 4</th>
				       <th rowspan="1" colspan="1" >GSTR 9</th>
				       <th rowspan="1" colspan="1" >GSTR 9A</th>
				       <th rowspan="1" colspan="1" >GSTR 9C</th>


				       <th rowspan="1" colspan="1" >GSTR 1M</th>
				       <th rowspan="1" colspan="1" >GSTR 3BM</th>
				       <th rowspan="1" colspan="1" >GSTR-1Q</th> 
				       <th rowspan="1" colspan="1" >GSTR-3BQ</th>
				       <th rowspan="1" colspan="1" >GST-CMP-08</th>
				       <th rowspan="1" colspan="1" >GSTR 4</th>
				       <th rowspan="1" colspan="1" >GSTR 9</th>
				       <th rowspan="1" colspan="1" >GSTR 9A</th>
				       <th rowspan="1" colspan="1" >GSTR 9C</th>
				   </tr>
				  
				   <tr class="header_bcg_clr">
				       <th >1</th>
				       <th >2</th>
				       <th >3</th>
				       <th >4</th>
				       <th >5</th>
				       <th >6</th>
				       <th >7</th>
				       <th >8</th>
				       <th >9</th>				       
				       <th >10</th>
				       <th >11</th>
				       <th >12</th>
				       <th >13</th>
				       <th >14</th>
				       <th >15</th>
				       <th >16</th>
				       <th >17</th>
				       <th >18</th>
				       <th >19</th>
				       <th >20</th>
				       <th >21</th>
				       <th >22</th>
				       <th >23</th>
				       <th >24</th>				       
				       <th >25</th>
				       <th >26</th>
				       <th >27</th>
				       <th >28</th>
				       <th >29</th>
				       <th >30</th>
				       <th >31</th>
				       <!-- <th align="center">32</th> -->
				   </tr>
				   <tr class="table-datarow-right">
            <th class="table-datarow-center">
				   
						   <%= i+1 %></th>
						   <%--  <th align="right">${ViewBag_Report_Name}</th> --%>
						    <td  width="5%">${model.GSTR_1M_F}</td>
						    <td  width="5%">${model.GSTR_3BM_F}</td>
						    <td  width="5%">${model.GSTR_1Q_F}</td>
						    <td  width="5%">${model.GSTR_3BQ_F}</td>
						    <td  width="5%">${model.GST_CMP_08_F}</td>                          
						    <td  width="5%">${model.GSTR_4_F}</td>                           
						    <td  width="5%">${model.GSTR_9_F}</td>
						    <td  width="5%">${model.GSTR_9A_F}</td>
						    <td  width="5%">${model.GSTR_9C_F}</td>
						    <td  width="5%">${model.GSTR_1M_D}</td>
                            <td  width="5%">${model.GSTR_3BM_D}</td>
                            <td  width="5%">${model.GSTR_1Q_D}</td>
                            <td  width="5%">${model.GSTR_3BQ_D}</td>
                            <td  width="5%">${model.GST_CMP_08_D}</td>                          
                            <td  width="5%">${model.GSTR_4_D}</td>                           
                            <td  width="5%">${model.GSTR_9_D}</td>
                            <td  width="5%">${model.GSTR_9A_D}</td>
                            <td  width="5%">${model.GSTR_9C_D}</td>
                            <td  width="5%">${model.GSTR_1M_N}</td>
                            <td  width="5%">${model.GSTR_3BM_N}</td>
                            <td  width="5%">${model.GSTR_1Q_N}</td>
                            <td  width="5%">${model.GSTR_3BQ_N}</td>
                            <td  width="5%">${model.GST_CMP_08_N}</td>                          
                            <td  width="5%">${model.GSTR_4_N}</td>                           
                            <td  width="5%">${model.GSTR_9_N}</td>
                            <td  width="5%">${model.GSTR_9A_N}</td>
                            <td  width="5%">${model.GSTR_9C_N}</td>
                            <td  width="5%">${model.TOTAL}</td>
                            <td  width="5%">${model.GSTR_3A_I}</td>
						    <td  width="5%">${model.GSTR_3A_NI}</td>

						</tr>
					 <% i=i+1; %>
					
				</table>
				
				
				
				
         </c:if> 
        <c:if test="${empty model || model.COMPLETE_COMM == 0}">
        <table class="Report_body">
            <tr>
                <th colspan="9" align="center">
                    <h1 style="color:red;">No Record Found !</h1>
                </th>
            </tr>
        </table>
        </c:if>
    </div>
    
</body>
</html>


