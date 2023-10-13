<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tr class="text-center-capitalize">
	<td class = "header-text-readonly" rowspan="4">Superintendent</td>
	<td class = "header-text-readonly">COMMISSIONERATE LEVEL CASES</td>
	<td><form:input path="SUPERINTENDENT_COMMISSIONERATE_OPENING_NO"
			name="SUPERINTENDENT_COMMISSIONERATE_OPENING_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_OPENING_NO"
			class="form-control min-width-1"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			value="${model.SUPERINTENDENT_COMMISSIONERATE_OPENING_NO}"  readonly='true'
			required="true"  maxlength="18" /> <form:errors
			path="SUPERINTENDENT_COMMISSIONERATE_OPENING_NO" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT"
			type="text" name="SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT"
			id="SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT"
			class="form-control min-width-1"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT}"  readonly='true'
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO"
			type="text" name="SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT"
			type="text" name="SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT"
			id="SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO"
			type="text" name="SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT"
			type="text" name="SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT"
			id="SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_COMMISSIONERATE_OIO_NO"
			type="text" name="SUPERINTENDENT_COMMISSIONERATE_OIO_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_OIO_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_OIO_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_OIO_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_COMMISSIONERATE_OIO_AMT"
			type="text" name="SUPERINTENDENT_COMMISSIONERATE_OIO_AMT"
			id="SUPERINTENDENT_COMMISSIONERATE_OIO_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_OIO_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_OIO_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_COMM_CLOSING_NO" type="text"
			name="SUPERINTENDENT_COMM_CLOSING_NO"
			id="SUPERINTENDENT_COMM_CLOSING_NO" class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMM_CLOSING_NO}" readonly='true' 
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_COMM_CLOSING_NO" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_COMM_CLOSING_AMT" type="text"
			name="SUPERINTENDENT_COMM_CLOSING_AMT"
			id="SUPERINTENDENT_COMM_CLOSING_AMT" class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMM_CLOSING_AMT}" readonly='true' 
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_COMM_CLOSING_AMT" cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO" type="text"
			name="SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO"
			cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO" type="text"
			name="SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO"
			cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO" type="text"
			name="SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO"
			cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO" type="text"
			name="SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO"
			cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO" type="text"
			name="SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO"
			cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO" type="text"
			name="SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO"
			cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO" type="text"
			name="SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO"
			cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO" type="text"
			name="SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO"
			id="SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO"
			cssClass="error" /></td>
</tr>
<tr class="text-center-capitalize">

	<td class = "header-text-readonly">AUDIT CASES</td>
	<td><form:input path="SUPERINTENDENT_AUDIT_OPENING_NO" type="text"
			name="SUPERINTENDENT_AUDIT_OPENING_NO"
			id="SUPERINTENDENT_AUDIT_OPENING_NO" class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_OPENING_NO}"  readonly='true'
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_OPENING_NO" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_OPENING_AMT"
			type="text" name="SUPERINTENDENT_AUDIT_OPENING_AMT"
			id="SUPERINTENDENT_AUDIT_OPENING_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_OPENING_AMT}"  readonly='true'
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_OPENING_AMT" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_RECEIPT_NO" type="text"
			name="SUPERINTENDENT_AUDIT_RECEIPT_NO"
			id="SUPERINTENDENT_AUDIT_RECEIPT_NO" class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_RECEIPT_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_RECEIPT_NO" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_RECEIPT_AMT"
			type="text" name="SUPERINTENDENT_AUDIT_RECEIPT_AMT"
			id="SUPERINTENDENT_AUDIT_RECEIPT_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_RECEIPT_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_RECEIPT_AMT" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_DISPOSAL_NO"
			type="text" name="SUPERINTENDENT_AUDIT_DISPOSAL_NO"
			id="SUPERINTENDENT_AUDIT_DISPOSAL_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_DISPOSAL_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_DISPOSAL_NO" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_DISPOSAL_AMT"
			type="text" name="SUPERINTENDENT_AUDIT_DISPOSAL_AMT"
			id="SUPERINTENDENT_AUDIT_DISPOSAL_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_DISPOSAL_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_DISPOSAL_AMT" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_OIO_NO" type="text"
			name="SUPERINTENDENT_AUDIT_OIO_NO" id="SUPERINTENDENT_AUDIT_OIO_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_OIO_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_OIO_NO" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_OIO_AMT" type="text"
			name="SUPERINTENDENT_AUDIT_OIO_AMT" id="SUPERINTENDENT_AUDIT_OIO_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_OIO_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_OIO_AMT" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_CLOSING_NO" type="text"
			name="SUPERINTENDENT_AUDIT_CLOSING_NO"
			id="SUPERINTENDENT_AUDIT_CLOSING_NO" class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_CLOSING_NO}" readonly='true' 
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_AUDIT_CLOSING_NO" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_CLOSING_AMT"
			type="text" name="SUPERINTENDENT_AUDIT_CLOSING_AMT"
			id="SUPERINTENDENT_AUDIT_CLOSING_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_CLOSING_AMT}" readonly='true' 
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_AUDIT_CLOSING_AMT" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_AGE_LESS_3_NO"
			type="text" name="SUPERINTENDENT_AUDIT_AGE_LESS_3_NO"
			id="SUPERINTENDENT_AUDIT_AGE_LESS_3_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_AGE_LESS_3_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_AGE_LESS_3_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO"
			type="text" name="SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO"
			id="SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO"
			type="text" name="SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO"
			id="SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO"
			type="text" name="SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO"
			id="SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_TIME_LESS_3_NO"
			type="text" name="SUPERINTENDENT_AUDIT_TIME_LESS_3_NO"
			id="SUPERINTENDENT_AUDIT_TIME_LESS_3_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_TIME_LESS_3_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_TIME_LESS_3_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO"
			type="text" name="SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO"
			id="SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO"
			type="text" name="SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO"
			id="SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO"
			type="text" name="SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO"
			id="SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO"
			cssClass="error" /></td>
</tr>
<tr class="text-center-capitalize">

	<td class = "header-text-readonly">INVESTIGATION AGENCIES CASES</td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_OPENING_NO"
			type="text" name="SUPERINTENDENT_INVESTIGATION_OPENING_NO"
			id="SUPERINTENDENT_INVESTIGATION_OPENING_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_OPENING_NO}"  readonly='true'
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_OPENING_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_OPENING_AMT"
			type="text" name="SUPERINTENDENT_INVESTIGATION_OPENING_AMT"
			id="SUPERINTENDENT_INVESTIGATION_OPENING_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_OPENING_AMT}"  readonly='true'
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_OPENING_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_RECEIPT_NO"
			type="text" name="SUPERINTENDENT_INVESTIGATION_RECEIPT_NO"
			id="SUPERINTENDENT_INVESTIGATION_RECEIPT_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_RECEIPT_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_RECEIPT_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT"
			type="text" name="SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT"
			id="SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO"
			type="text" name="SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO"
			id="SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT"
			type="text" name="SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT"
			id="SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_OIO_NO"
			type="text" name="SUPERINTENDENT_INVESTIGATION_OIO_NO"
			id="SUPERINTENDENT_INVESTIGATION_OIO_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_OIO_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_OIO_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_OIO_AMT"
			type="text" name="SUPERINTENDENT_INVESTIGATION_OIO_AMT"
			id="SUPERINTENDENT_INVESTIGATION_OIO_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_OIO_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_OIO_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_CLOSING_NO"
			type="text" name="SUPERINTENDENT_INVESTIGATION_CLOSING_NO"
			id="SUPERINTENDENT_INVESTIGATION_CLOSING_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_CLOSING_NO}" readonly='true' 
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_CLOSING_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_CLOSING_AMT"
			type="text" name="SUPERINTENDENT_INVESTIGATION_CLOSING_AMT"
			id="SUPERINTENDENT_INVESTIGATION_CLOSING_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_CLOSING_AMT}" readonly='true' 
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_CLOSING_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO"
			type="text" name="SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO"
			id="SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO"
			type="text" name="SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO"
			id="SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO"
			type="text" name="SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO"
			id="SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO"
			cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO" type="text"
			name="SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO"
			id="SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO"
			type="text" name="SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO"
			id="SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO"
			type="text" name="SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO"
			id="SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO"
			cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO" type="text"
			name="SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO"
			id="SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO"
			cssClass="error" /></td>
	<td><form:input
			path="SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO" type="text"
			name="SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO"
			id="SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18" />
		<form:errors path="SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO"
			cssClass="error" /></td>
</tr>
<tr class="text-center-capitalize">

	<td class = "header-text-readonly">CALL BOOK CASES CASES PENDING UNDER SECTION 75(11) OF CGST ACT
	</td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_OPENING_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_OPENING_NO"
			id="SUPERINTENDENT_CALLBOOK_OPENING_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_OPENING_NO}"  readonly='true'
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_OPENING_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_OPENING_AMT"
			type="text" name="SUPERINTENDENT_CALLBOOK_OPENING_AMT"
			id="SUPERINTENDENT_CALLBOOK_OPENING_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_OPENING_AMT}"  readonly='true'
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_OPENING_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_RECEIPT_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_RECEIPT_NO"
			id="SUPERINTENDENT_CALLBOOK_RECEIPT_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_RECEIPT_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"   />
		<form:errors path="SUPERINTENDENT_CALLBOOK_RECEIPT_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_RECEIPT_AMT"
			type="text" name="SUPERINTENDENT_CALLBOOK_RECEIPT_AMT"
			id="SUPERINTENDENT_CALLBOOK_RECEIPT_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_RECEIPT_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_RECEIPT_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_DISPOSAL_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_DISPOSAL_NO"
			id="SUPERINTENDENT_CALLBOOK_DISPOSAL_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_DISPOSAL_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_DISPOSAL_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT"
			type="text" name="SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT"
			id="SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_OIO_NO" type="text"
			name="SUPERINTENDENT_CALLBOOK_OIO_NO"
			id="SUPERINTENDENT_CALLBOOK_OIO_NO" class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_OIO_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_OIO_NO" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_OIO_AMT" type="text"
			name="SUPERINTENDENT_CALLBOOK_OIO_AMT"
			id="SUPERINTENDENT_CALLBOOK_OIO_AMT" class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_OIO_AMT}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_OIO_AMT" cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_CLOSING_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_CLOSING_NO"
			id="SUPERINTENDENT_CALLBOOK_CLOSING_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_CLOSING_NO}" readonly='true' 
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_CLOSING_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_CLOSING_AMT"
			type="text" name="SUPERINTENDENT_CALLBOOK_CLOSING_AMT"
			id="SUPERINTENDENT_CALLBOOK_CLOSING_AMT"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_CLOSING_AMT}" readonly='true' 
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46"
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_CLOSING_AMT"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO"
			id="SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO"
			id="SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO"
			id="SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO"
			id="SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO"
			id="SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO"
			id="SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO"
			id="SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO"
			cssClass="error" /></td>
	<td><form:input path="SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO"
			type="text" name="SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO"
			id="SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO"
			class="form-control min-width-1"
			value="${model.SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO}"
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 "
			required="true"  maxlength="18"  />
		<form:errors path="SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO"
			cssClass="error" /></td>
</tr>


