package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_DPM_GST_ADJ_1_COMM_TEMP_Result {
	 
	private String COMM_CODE;
	private String MM_YYYY;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_COMMISSIONERATE_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_RECEIPT_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_COMMISSIONERATE_RECEIPT_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_DISPOSAL_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_COMMISSIONERATE_DISPOSAL_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_OIO_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_COMMISSIONERATE_OIO_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_AGE_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_AGE_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_AGE_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_TIME_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_TIME_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_TIME_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_AUDIT_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_RECEIPT_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_AUDIT_RECEIPT_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_DISPOSAL_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_AUDIT_DISPOSAL_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_OIO_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_AUDIT_OIO_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_AGE_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_AGE_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_AGE_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_AGE_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_TIME_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_TIME_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_TIME_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_INVESTIGATION_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_RECEIPT_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_INVESTIGATION_RECEIPT_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_DISPOSAL_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_INVESTIGATION_DISPOSAL_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_OIO_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_INVESTIGATION_OIO_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_AGE_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_AGE_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_AGE_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_AGE_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_TIME_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_TIME_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_TIME_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_CALLBOOK_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_CALLBOOK_OPENING_AMT ;
	
	private String ADC_CALLBOOK_RECEIPT_NO ;
	
	private String ADC_CALLBOOK_RECEIPT_AMT ;
	
	private String ADC_CALLBOOK_DISPOSAL_NO ;
	
	private String ADC_CALLBOOK_DISPOSAL_AMT ;
	
	private String ADC_CALLBOOK_OIO_NO ;
	
	private String ADC_CALLBOOK_OIO_AMT ;
	
	private String ADC_CALLBOOK_AGE_LESS_3_NO ;
	
	private String ADC_CALLBOOK_AGE_3_TO_6_NO ;
	
	private String ADC_CALLBOOK_AGE_6_TO_12_NO ;
	
	private String ADC_CALLBOOK_AGE_MORE_THAN_1_NO ;
	
	private String ADC_CALLBOOK_TIME_LESS_3_NO ;
	
	private String ADC_CALLBOOK_TIME_3_TO_6_NO ;
	
	private String ADC_CALLBOOK_TIME_6_TO_12_NO ;
	
	private String ADC_CALLBOOK_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_COMMISSIONERATE_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_RECEIPT_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_COMMISSIONERATE_RECEIPT_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_DISPOSAL_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_COMMISSIONERATE_DISPOSAL_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_OIO_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_COMMISSIONERATE_OIO_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_AGE_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_AGE_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_AGE_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_TIME_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_TIME_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_TIME_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_AUDIT_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_RECEIPT_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_AUDIT_RECEIPT_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_DISPOSAL_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_AUDIT_DISPOSAL_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_OIO_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_AUDIT_OIO_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_AGE_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_AGE_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_AGE_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_AGE_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_TIME_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_TIME_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_TIME_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_INVESTIGATION_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_RECEIPT_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_INVESTIGATION_RECEIPT_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_DISPOSAL_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_INVESTIGATION_DISPOSAL_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_OIO_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_INVESTIGATION_OIO_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_AGE_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_AGE_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_AGE_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_AGE_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_TIME_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_TIME_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_TIME_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_CALLBOOK_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_CALLBOOK_OPENING_AMT ;
	
	private String DC_CALLBOOK_RECEIPT_NO ;
	
	private String DC_CALLBOOK_RECEIPT_AMT ;
	
	private String DC_CALLBOOK_DISPOSAL_NO ;
	
	private String DC_CALLBOOK_DISPOSAL_AMT ;
	
	private String DC_CALLBOOK_OIO_NO ;
	
	private String DC_CALLBOOK_OIO_AMT ;
	
	private String DC_CALLBOOK_AGE_LESS_3_NO ;
	
	private String DC_CALLBOOK_AGE_3_TO_6_NO ;
	
	private String DC_CALLBOOK_AGE_6_TO_12_NO ;
	
	private String DC_CALLBOOK_AGE_MORE_THAN_1_NO ;
	
	private String DC_CALLBOOK_TIME_LESS_3_NO ;
	
	private String DC_CALLBOOK_TIME_3_TO_6_NO ;
	
	private String DC_CALLBOOK_TIME_6_TO_12_NO ;
	
	private String DC_CALLBOOK_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_OIO_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_COMMISSIONERATE_OIO_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_AUDIT_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_RECEIPT_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_AUDIT_RECEIPT_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_DISPOSAL_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_AUDIT_DISPOSAL_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_OIO_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_AUDIT_OIO_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_AGE_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_TIME_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_INVESTIGATION_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_RECEIPT_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_OIO_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_INVESTIGATION_OIO_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_CALLBOOK_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_CALLBOOK_OPENING_AMT ;
	
	private String SUPERINTENDENT_CALLBOOK_RECEIPT_NO ;
	
	private String SUPERINTENDENT_CALLBOOK_RECEIPT_AMT ;
	
	private String SUPERINTENDENT_CALLBOOK_DISPOSAL_NO ;
	
	private String SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT ;
	
	private String SUPERINTENDENT_CALLBOOK_OIO_NO ;
	
	private String SUPERINTENDENT_CALLBOOK_OIO_AMT ;
	
	private String SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO ;
	
	private String SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO ;
	
	private String SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO ;
	
	private String SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO ;
	
	private String SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO ;
	
	private String SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO ;
	
	private String SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO ;
	
	private String SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO ;
	
	private String ADC_COMM_CLOSING_NO;
	
	private String ADC_COMM_CLOSING_AMT;
	
	private String ADC_AUDIT_CLOSING_NO;
	
	private String ADC_AUDIT_CLOSING_AMT;
	
	private String ADC_INVESTIGATION_CLOSING_NO;
	private String ADC_INVESTIGATION_CLOSING_AMT;
	
	private String ADC_CALLBOOK_CLOSING_NO;
	
	private String ADC_CALLBOOK_CLOSING_AMT;
	
	private String DC_COMM_CLOSING_NO;
	
	private String DC_COMM_CLOSING_AMT;
	
	private String DC_AUDIT_CLOSING_NO;
	
	private String DC_AUDIT_CLOSING_AMT;
	
	private String DC_INVESTIGATION_CLOSING_NO;
	
	private String DC_INVESTIGATION_CLOSING_AMT;
	
	private String DC_CALLBOOK_CLOSING_NO;
	
	private String DC_CALLBOOK_CLOSING_AMT;
	
	private String SUPERINTENDENT_COMM_CLOSING_NO;
	
	private String SUPERINTENDENT_COMM_CLOSING_AMT;
	
	private String SUPERINTENDENT_AUDIT_CLOSING_NO;
	
	private String SUPERINTENDENT_AUDIT_CLOSING_AMT;
	
	private String SUPERINTENDENT_INVESTIGATION_CLOSING_NO;
	
	private String SUPERINTENDENT_INVESTIGATION_CLOSING_AMT;
	
	private String SUPERINTENDENT_CALLBOOK_CLOSING_NO;
	private String SUPERINTENDENT_CALLBOOK_CLOSING_AMT;
	
	
	
	public String getCOMM_CODE() {
		return COMM_CODE;
	}


	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}


	public String getMM_YYYY() {
		return MM_YYYY;
	}


	public void setMM_YYYY(String mM_YYYY) {
		MM_YYYY = mM_YYYY;
	}


	
	public String getADC_COMMISSIONERATE_OPENING_NO() {
		return ADC_COMMISSIONERATE_OPENING_NO;
	}


	public void setADC_COMMISSIONERATE_OPENING_NO(String aDC_COMMISSIONERATE_OPENING_NO) {
		ADC_COMMISSIONERATE_OPENING_NO = aDC_COMMISSIONERATE_OPENING_NO;
	}


	public String getADC_COMMISSIONERATE_OPENING_AMT() {
		return ADC_COMMISSIONERATE_OPENING_AMT;
	}


	public void setADC_COMMISSIONERATE_OPENING_AMT(String aDC_COMMISSIONERATE_OPENING_AMT) {
		ADC_COMMISSIONERATE_OPENING_AMT = aDC_COMMISSIONERATE_OPENING_AMT;
	}


	public String getADC_COMMISSIONERATE_RECEIPT_NO() {
		return ADC_COMMISSIONERATE_RECEIPT_NO;
	}


	public void setADC_COMMISSIONERATE_RECEIPT_NO(String aDC_COMMISSIONERATE_RECEIPT_NO) {
		ADC_COMMISSIONERATE_RECEIPT_NO = aDC_COMMISSIONERATE_RECEIPT_NO;
	}


	public String getADC_COMMISSIONERATE_RECEIPT_AMT() {
		return ADC_COMMISSIONERATE_RECEIPT_AMT;
	}


	public void setADC_COMMISSIONERATE_RECEIPT_AMT(String aDC_COMMISSIONERATE_RECEIPT_AMT) {
		ADC_COMMISSIONERATE_RECEIPT_AMT = aDC_COMMISSIONERATE_RECEIPT_AMT;
	}


	public String getADC_COMMISSIONERATE_DISPOSAL_NO() {
		return ADC_COMMISSIONERATE_DISPOSAL_NO;
	}


	public void setADC_COMMISSIONERATE_DISPOSAL_NO(String aDC_COMMISSIONERATE_DISPOSAL_NO) {
		ADC_COMMISSIONERATE_DISPOSAL_NO = aDC_COMMISSIONERATE_DISPOSAL_NO;
	}


	public String getADC_COMMISSIONERATE_DISPOSAL_AMT() {
		return ADC_COMMISSIONERATE_DISPOSAL_AMT;
	}


	public void setADC_COMMISSIONERATE_DISPOSAL_AMT(String aDC_COMMISSIONERATE_DISPOSAL_AMT) {
		ADC_COMMISSIONERATE_DISPOSAL_AMT = aDC_COMMISSIONERATE_DISPOSAL_AMT;
	}


	public String getADC_COMMISSIONERATE_OIO_NO() {
		return ADC_COMMISSIONERATE_OIO_NO;
	}


	public void setADC_COMMISSIONERATE_OIO_NO(String aDC_COMMISSIONERATE_OIO_NO) {
		ADC_COMMISSIONERATE_OIO_NO = aDC_COMMISSIONERATE_OIO_NO;
	}


	public String getADC_COMMISSIONERATE_OIO_AMT() {
		return ADC_COMMISSIONERATE_OIO_AMT;
	}


	public void setADC_COMMISSIONERATE_OIO_AMT(String aDC_COMMISSIONERATE_OIO_AMT) {
		ADC_COMMISSIONERATE_OIO_AMT = aDC_COMMISSIONERATE_OIO_AMT;
	}


	public String getADC_COMMISSIONERATE_AGE_LESS_3_NO() {
		return ADC_COMMISSIONERATE_AGE_LESS_3_NO;
	}


	public void setADC_COMMISSIONERATE_AGE_LESS_3_NO(String aDC_COMMISSIONERATE_AGE_LESS_3_NO) {
		ADC_COMMISSIONERATE_AGE_LESS_3_NO = aDC_COMMISSIONERATE_AGE_LESS_3_NO;
	}


	public String getADC_COMMISSIONERATE_AGE_3_TO_6_NO() {
		return ADC_COMMISSIONERATE_AGE_3_TO_6_NO;
	}


	public void setADC_COMMISSIONERATE_AGE_3_TO_6_NO(String aDC_COMMISSIONERATE_AGE_3_TO_6_NO) {
		ADC_COMMISSIONERATE_AGE_3_TO_6_NO = aDC_COMMISSIONERATE_AGE_3_TO_6_NO;
	}


	public String getADC_COMMISSIONERATE_AGE_6_TO_12_NO() {
		return ADC_COMMISSIONERATE_AGE_6_TO_12_NO;
	}


	public void setADC_COMMISSIONERATE_AGE_6_TO_12_NO(String aDC_COMMISSIONERATE_AGE_6_TO_12_NO) {
		ADC_COMMISSIONERATE_AGE_6_TO_12_NO = aDC_COMMISSIONERATE_AGE_6_TO_12_NO;
	}


	public String getADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO() {
		return ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO;
	}


	public void setADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO(String aDC_COMMISSIONERATE_AGE_MORE_THAN_1_NO) {
		ADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO = aDC_COMMISSIONERATE_AGE_MORE_THAN_1_NO;
	}


	public String getADC_COMMISSIONERATE_TIME_LESS_3_NO() {
		return ADC_COMMISSIONERATE_TIME_LESS_3_NO;
	}


	public void setADC_COMMISSIONERATE_TIME_LESS_3_NO(String aDC_COMMISSIONERATE_TIME_LESS_3_NO) {
		ADC_COMMISSIONERATE_TIME_LESS_3_NO = aDC_COMMISSIONERATE_TIME_LESS_3_NO;
	}


	public String getADC_COMMISSIONERATE_TIME_3_TO_6_NO() {
		return ADC_COMMISSIONERATE_TIME_3_TO_6_NO;
	}


	public void setADC_COMMISSIONERATE_TIME_3_TO_6_NO(String aDC_COMMISSIONERATE_TIME_3_TO_6_NO) {
		ADC_COMMISSIONERATE_TIME_3_TO_6_NO = aDC_COMMISSIONERATE_TIME_3_TO_6_NO;
	}


	public String getADC_COMMISSIONERATE_TIME_6_TO_12_NO() {
		return ADC_COMMISSIONERATE_TIME_6_TO_12_NO;
	}


	public void setADC_COMMISSIONERATE_TIME_6_TO_12_NO(String aDC_COMMISSIONERATE_TIME_6_TO_12_NO) {
		ADC_COMMISSIONERATE_TIME_6_TO_12_NO = aDC_COMMISSIONERATE_TIME_6_TO_12_NO;
	}


	public String getADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO() {
		return ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO;
	}


	public void setADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO(String aDC_COMMISSIONERATE_TIME_MORE_THAN_1_NO) {
		ADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO = aDC_COMMISSIONERATE_TIME_MORE_THAN_1_NO;
	}


	public String getADC_AUDIT_OPENING_NO() {
		return ADC_AUDIT_OPENING_NO;
	}


	public void setADC_AUDIT_OPENING_NO(String aDC_AUDIT_OPENING_NO) {
		ADC_AUDIT_OPENING_NO = aDC_AUDIT_OPENING_NO;
	}


	public String getADC_AUDIT_OPENING_AMT() {
		return ADC_AUDIT_OPENING_AMT;
	}


	public void setADC_AUDIT_OPENING_AMT(String aDC_AUDIT_OPENING_AMT) {
		ADC_AUDIT_OPENING_AMT = aDC_AUDIT_OPENING_AMT;
	}


	public String getADC_AUDIT_RECEIPT_NO() {
		return ADC_AUDIT_RECEIPT_NO;
	}


	public void setADC_AUDIT_RECEIPT_NO(String aDC_AUDIT_RECEIPT_NO) {
		ADC_AUDIT_RECEIPT_NO = aDC_AUDIT_RECEIPT_NO;
	}


	public String getADC_AUDIT_RECEIPT_AMT() {
		return ADC_AUDIT_RECEIPT_AMT;
	}


	public void setADC_AUDIT_RECEIPT_AMT(String aDC_AUDIT_RECEIPT_AMT) {
		ADC_AUDIT_RECEIPT_AMT = aDC_AUDIT_RECEIPT_AMT;
	}


	public String getADC_AUDIT_DISPOSAL_NO() {
		return ADC_AUDIT_DISPOSAL_NO;
	}


	public void setADC_AUDIT_DISPOSAL_NO(String aDC_AUDIT_DISPOSAL_NO) {
		ADC_AUDIT_DISPOSAL_NO = aDC_AUDIT_DISPOSAL_NO;
	}


	public String getADC_AUDIT_DISPOSAL_AMT() {
		return ADC_AUDIT_DISPOSAL_AMT;
	}


	public void setADC_AUDIT_DISPOSAL_AMT(String aDC_AUDIT_DISPOSAL_AMT) {
		ADC_AUDIT_DISPOSAL_AMT = aDC_AUDIT_DISPOSAL_AMT;
	}


	public String getADC_AUDIT_OIO_NO() {
		return ADC_AUDIT_OIO_NO;
	}


	public void setADC_AUDIT_OIO_NO(String aDC_AUDIT_OIO_NO) {
		ADC_AUDIT_OIO_NO = aDC_AUDIT_OIO_NO;
	}


	public String getADC_AUDIT_OIO_AMT() {
		return ADC_AUDIT_OIO_AMT;
	}


	public void setADC_AUDIT_OIO_AMT(String aDC_AUDIT_OIO_AMT) {
		ADC_AUDIT_OIO_AMT = aDC_AUDIT_OIO_AMT;
	}


	public String getADC_AUDIT_AGE_LESS_3_NO() {
		return ADC_AUDIT_AGE_LESS_3_NO;
	}


	public void setADC_AUDIT_AGE_LESS_3_NO(String aDC_AUDIT_AGE_LESS_3_NO) {
		ADC_AUDIT_AGE_LESS_3_NO = aDC_AUDIT_AGE_LESS_3_NO;
	}


	public String getADC_AUDIT_AGE_3_TO_6_NO() {
		return ADC_AUDIT_AGE_3_TO_6_NO;
	}


	public void setADC_AUDIT_AGE_3_TO_6_NO(String aDC_AUDIT_AGE_3_TO_6_NO) {
		ADC_AUDIT_AGE_3_TO_6_NO = aDC_AUDIT_AGE_3_TO_6_NO;
	}


	public String getADC_AUDIT_AGE_6_TO_12_NO() {
		return ADC_AUDIT_AGE_6_TO_12_NO;
	}


	public void setADC_AUDIT_AGE_6_TO_12_NO(String aDC_AUDIT_AGE_6_TO_12_NO) {
		ADC_AUDIT_AGE_6_TO_12_NO = aDC_AUDIT_AGE_6_TO_12_NO;
	}


	public String getADC_AUDIT_AGE_MORE_THAN_1_NO() {
		return ADC_AUDIT_AGE_MORE_THAN_1_NO;
	}


	public void setADC_AUDIT_AGE_MORE_THAN_1_NO(String aDC_AUDIT_AGE_MORE_THAN_1_NO) {
		ADC_AUDIT_AGE_MORE_THAN_1_NO = aDC_AUDIT_AGE_MORE_THAN_1_NO;
	}


	public String getADC_AUDIT_TIME_LESS_3_NO() {
		return ADC_AUDIT_TIME_LESS_3_NO;
	}


	public void setADC_AUDIT_TIME_LESS_3_NO(String aDC_AUDIT_TIME_LESS_3_NO) {
		ADC_AUDIT_TIME_LESS_3_NO = aDC_AUDIT_TIME_LESS_3_NO;
	}


	public String getADC_AUDIT_TIME_3_TO_6_NO() {
		return ADC_AUDIT_TIME_3_TO_6_NO;
	}


	public void setADC_AUDIT_TIME_3_TO_6_NO(String aDC_AUDIT_TIME_3_TO_6_NO) {
		ADC_AUDIT_TIME_3_TO_6_NO = aDC_AUDIT_TIME_3_TO_6_NO;
	}


	public String getADC_AUDIT_TIME_6_TO_12_NO() {
		return ADC_AUDIT_TIME_6_TO_12_NO;
	}


	public void setADC_AUDIT_TIME_6_TO_12_NO(String aDC_AUDIT_TIME_6_TO_12_NO) {
		ADC_AUDIT_TIME_6_TO_12_NO = aDC_AUDIT_TIME_6_TO_12_NO;
	}


	public String getADC_AUDIT_TIME_MORE_THAN_1_NO() {
		return ADC_AUDIT_TIME_MORE_THAN_1_NO;
	}


	public void setADC_AUDIT_TIME_MORE_THAN_1_NO(String aDC_AUDIT_TIME_MORE_THAN_1_NO) {
		ADC_AUDIT_TIME_MORE_THAN_1_NO = aDC_AUDIT_TIME_MORE_THAN_1_NO;
	}


	public String getADC_INVESTIGATION_OPENING_NO() {
		return ADC_INVESTIGATION_OPENING_NO;
	}


	public void setADC_INVESTIGATION_OPENING_NO(String aDC_INVESTIGATION_OPENING_NO) {
		ADC_INVESTIGATION_OPENING_NO = aDC_INVESTIGATION_OPENING_NO;
	}


	public String getADC_INVESTIGATION_OPENING_AMT() {
		return ADC_INVESTIGATION_OPENING_AMT;
	}


	public void setADC_INVESTIGATION_OPENING_AMT(String aDC_INVESTIGATION_OPENING_AMT) {
		ADC_INVESTIGATION_OPENING_AMT = aDC_INVESTIGATION_OPENING_AMT;
	}


	public String getADC_INVESTIGATION_RECEIPT_NO() {
		return ADC_INVESTIGATION_RECEIPT_NO;
	}


	public void setADC_INVESTIGATION_RECEIPT_NO(String aDC_INVESTIGATION_RECEIPT_NO) {
		ADC_INVESTIGATION_RECEIPT_NO = aDC_INVESTIGATION_RECEIPT_NO;
	}


	public String getADC_INVESTIGATION_RECEIPT_AMT() {
		return ADC_INVESTIGATION_RECEIPT_AMT;
	}


	public void setADC_INVESTIGATION_RECEIPT_AMT(String aDC_INVESTIGATION_RECEIPT_AMT) {
		ADC_INVESTIGATION_RECEIPT_AMT = aDC_INVESTIGATION_RECEIPT_AMT;
	}


	public String getADC_INVESTIGATION_DISPOSAL_NO() {
		return ADC_INVESTIGATION_DISPOSAL_NO;
	}


	public void setADC_INVESTIGATION_DISPOSAL_NO(String aDC_INVESTIGATION_DISPOSAL_NO) {
		ADC_INVESTIGATION_DISPOSAL_NO = aDC_INVESTIGATION_DISPOSAL_NO;
	}


	public String getADC_INVESTIGATION_DISPOSAL_AMT() {
		return ADC_INVESTIGATION_DISPOSAL_AMT;
	}


	public void setADC_INVESTIGATION_DISPOSAL_AMT(String aDC_INVESTIGATION_DISPOSAL_AMT) {
		ADC_INVESTIGATION_DISPOSAL_AMT = aDC_INVESTIGATION_DISPOSAL_AMT;
	}


	public String getADC_INVESTIGATION_OIO_NO() {
		return ADC_INVESTIGATION_OIO_NO;
	}


	public void setADC_INVESTIGATION_OIO_NO(String aDC_INVESTIGATION_OIO_NO) {
		ADC_INVESTIGATION_OIO_NO = aDC_INVESTIGATION_OIO_NO;
	}


	public String getADC_INVESTIGATION_OIO_AMT() {
		return ADC_INVESTIGATION_OIO_AMT;
	}


	public void setADC_INVESTIGATION_OIO_AMT(String aDC_INVESTIGATION_OIO_AMT) {
		ADC_INVESTIGATION_OIO_AMT = aDC_INVESTIGATION_OIO_AMT;
	}


	public String getADC_INVESTIGATION_AGE_LESS_3_NO() {
		return ADC_INVESTIGATION_AGE_LESS_3_NO;
	}


	public void setADC_INVESTIGATION_AGE_LESS_3_NO(String aDC_INVESTIGATION_AGE_LESS_3_NO) {
		ADC_INVESTIGATION_AGE_LESS_3_NO = aDC_INVESTIGATION_AGE_LESS_3_NO;
	}


	public String getADC_INVESTIGATION_AGE_3_TO_6_NO() {
		return ADC_INVESTIGATION_AGE_3_TO_6_NO;
	}


	public void setADC_INVESTIGATION_AGE_3_TO_6_NO(String aDC_INVESTIGATION_AGE_3_TO_6_NO) {
		ADC_INVESTIGATION_AGE_3_TO_6_NO = aDC_INVESTIGATION_AGE_3_TO_6_NO;
	}


	public String getADC_INVESTIGATION_AGE_6_TO_12_NO() {
		return ADC_INVESTIGATION_AGE_6_TO_12_NO;
	}


	public void setADC_INVESTIGATION_AGE_6_TO_12_NO(String aDC_INVESTIGATION_AGE_6_TO_12_NO) {
		ADC_INVESTIGATION_AGE_6_TO_12_NO = aDC_INVESTIGATION_AGE_6_TO_12_NO;
	}


	public String getADC_INVESTIGATION_AGE_MORE_THAN_1_NO() {
		return ADC_INVESTIGATION_AGE_MORE_THAN_1_NO;
	}


	public void setADC_INVESTIGATION_AGE_MORE_THAN_1_NO(String aDC_INVESTIGATION_AGE_MORE_THAN_1_NO) {
		ADC_INVESTIGATION_AGE_MORE_THAN_1_NO = aDC_INVESTIGATION_AGE_MORE_THAN_1_NO;
	}


	public String getADC_INVESTIGATION_TIME_LESS_3_NO() {
		return ADC_INVESTIGATION_TIME_LESS_3_NO;
	}


	public void setADC_INVESTIGATION_TIME_LESS_3_NO(String aDC_INVESTIGATION_TIME_LESS_3_NO) {
		ADC_INVESTIGATION_TIME_LESS_3_NO = aDC_INVESTIGATION_TIME_LESS_3_NO;
	}


	public String getADC_INVESTIGATION_TIME_3_TO_6_NO() {
		return ADC_INVESTIGATION_TIME_3_TO_6_NO;
	}


	public void setADC_INVESTIGATION_TIME_3_TO_6_NO(String aDC_INVESTIGATION_TIME_3_TO_6_NO) {
		ADC_INVESTIGATION_TIME_3_TO_6_NO = aDC_INVESTIGATION_TIME_3_TO_6_NO;
	}


	public String getADC_INVESTIGATION_TIME_6_TO_12_NO() {
		return ADC_INVESTIGATION_TIME_6_TO_12_NO;
	}


	public void setADC_INVESTIGATION_TIME_6_TO_12_NO(String aDC_INVESTIGATION_TIME_6_TO_12_NO) {
		ADC_INVESTIGATION_TIME_6_TO_12_NO = aDC_INVESTIGATION_TIME_6_TO_12_NO;
	}


	public String getADC_INVESTIGATION_TIME_MORE_THAN_1_NO() {
		return ADC_INVESTIGATION_TIME_MORE_THAN_1_NO;
	}


	public void setADC_INVESTIGATION_TIME_MORE_THAN_1_NO(String aDC_INVESTIGATION_TIME_MORE_THAN_1_NO) {
		ADC_INVESTIGATION_TIME_MORE_THAN_1_NO = aDC_INVESTIGATION_TIME_MORE_THAN_1_NO;
	}


	public String getADC_CALLBOOK_OPENING_NO() {
		return ADC_CALLBOOK_OPENING_NO;
	}


	public void setADC_CALLBOOK_OPENING_NO(String aDC_CALLBOOK_OPENING_NO) {
		ADC_CALLBOOK_OPENING_NO = aDC_CALLBOOK_OPENING_NO;
	}


	public String getADC_CALLBOOK_OPENING_AMT() {
		return ADC_CALLBOOK_OPENING_AMT;
	}


	public void setADC_CALLBOOK_OPENING_AMT(String aDC_CALLBOOK_OPENING_AMT) {
		ADC_CALLBOOK_OPENING_AMT = aDC_CALLBOOK_OPENING_AMT;
	}


	public String getADC_CALLBOOK_RECEIPT_NO() {
		return ADC_CALLBOOK_RECEIPT_NO;
	}


	public void setADC_CALLBOOK_RECEIPT_NO(String aDC_CALLBOOK_RECEIPT_NO) {
		ADC_CALLBOOK_RECEIPT_NO = aDC_CALLBOOK_RECEIPT_NO;
	}


	public String getADC_CALLBOOK_RECEIPT_AMT() {
		return ADC_CALLBOOK_RECEIPT_AMT;
	}


	public void setADC_CALLBOOK_RECEIPT_AMT(String aDC_CALLBOOK_RECEIPT_AMT) {
		ADC_CALLBOOK_RECEIPT_AMT = aDC_CALLBOOK_RECEIPT_AMT;
	}


	public String getADC_CALLBOOK_DISPOSAL_NO() {
		return ADC_CALLBOOK_DISPOSAL_NO;
	}


	public void setADC_CALLBOOK_DISPOSAL_NO(String aDC_CALLBOOK_DISPOSAL_NO) {
		ADC_CALLBOOK_DISPOSAL_NO = aDC_CALLBOOK_DISPOSAL_NO;
	}


	public String getADC_CALLBOOK_DISPOSAL_AMT() {
		return ADC_CALLBOOK_DISPOSAL_AMT;
	}


	public void setADC_CALLBOOK_DISPOSAL_AMT(String aDC_CALLBOOK_DISPOSAL_AMT) {
		ADC_CALLBOOK_DISPOSAL_AMT = aDC_CALLBOOK_DISPOSAL_AMT;
	}


	public String getADC_CALLBOOK_OIO_NO() {
		return ADC_CALLBOOK_OIO_NO;
	}


	public void setADC_CALLBOOK_OIO_NO(String aDC_CALLBOOK_OIO_NO) {
		ADC_CALLBOOK_OIO_NO = aDC_CALLBOOK_OIO_NO;
	}


	public String getADC_CALLBOOK_OIO_AMT() {
		return ADC_CALLBOOK_OIO_AMT;
	}


	public void setADC_CALLBOOK_OIO_AMT(String aDC_CALLBOOK_OIO_AMT) {
		ADC_CALLBOOK_OIO_AMT = aDC_CALLBOOK_OIO_AMT;
	}


	public String getADC_CALLBOOK_AGE_LESS_3_NO() {
		return ADC_CALLBOOK_AGE_LESS_3_NO;
	}


	public void setADC_CALLBOOK_AGE_LESS_3_NO(String aDC_CALLBOOK_AGE_LESS_3_NO) {
		ADC_CALLBOOK_AGE_LESS_3_NO = aDC_CALLBOOK_AGE_LESS_3_NO;
	}


	public String getADC_CALLBOOK_AGE_3_TO_6_NO() {
		return ADC_CALLBOOK_AGE_3_TO_6_NO;
	}


	public void setADC_CALLBOOK_AGE_3_TO_6_NO(String aDC_CALLBOOK_AGE_3_TO_6_NO) {
		ADC_CALLBOOK_AGE_3_TO_6_NO = aDC_CALLBOOK_AGE_3_TO_6_NO;
	}


	public String getADC_CALLBOOK_AGE_6_TO_12_NO() {
		return ADC_CALLBOOK_AGE_6_TO_12_NO;
	}


	public void setADC_CALLBOOK_AGE_6_TO_12_NO(String aDC_CALLBOOK_AGE_6_TO_12_NO) {
		ADC_CALLBOOK_AGE_6_TO_12_NO = aDC_CALLBOOK_AGE_6_TO_12_NO;
	}


	public String getADC_CALLBOOK_AGE_MORE_THAN_1_NO() {
		return ADC_CALLBOOK_AGE_MORE_THAN_1_NO;
	}


	public void setADC_CALLBOOK_AGE_MORE_THAN_1_NO(String aDC_CALLBOOK_AGE_MORE_THAN_1_NO) {
		ADC_CALLBOOK_AGE_MORE_THAN_1_NO = aDC_CALLBOOK_AGE_MORE_THAN_1_NO;
	}


	public String getADC_CALLBOOK_TIME_LESS_3_NO() {
		return ADC_CALLBOOK_TIME_LESS_3_NO;
	}


	public void setADC_CALLBOOK_TIME_LESS_3_NO(String aDC_CALLBOOK_TIME_LESS_3_NO) {
		ADC_CALLBOOK_TIME_LESS_3_NO = aDC_CALLBOOK_TIME_LESS_3_NO;
	}


	public String getADC_CALLBOOK_TIME_3_TO_6_NO() {
		return ADC_CALLBOOK_TIME_3_TO_6_NO;
	}


	public void setADC_CALLBOOK_TIME_3_TO_6_NO(String aDC_CALLBOOK_TIME_3_TO_6_NO) {
		ADC_CALLBOOK_TIME_3_TO_6_NO = aDC_CALLBOOK_TIME_3_TO_6_NO;
	}


	public String getADC_CALLBOOK_TIME_6_TO_12_NO() {
		return ADC_CALLBOOK_TIME_6_TO_12_NO;
	}


	public void setADC_CALLBOOK_TIME_6_TO_12_NO(String aDC_CALLBOOK_TIME_6_TO_12_NO) {
		ADC_CALLBOOK_TIME_6_TO_12_NO = aDC_CALLBOOK_TIME_6_TO_12_NO;
	}


	public String getADC_CALLBOOK_TIME_MORE_THAN_1_NO() {
		return ADC_CALLBOOK_TIME_MORE_THAN_1_NO;
	}


	public void setADC_CALLBOOK_TIME_MORE_THAN_1_NO(String aDC_CALLBOOK_TIME_MORE_THAN_1_NO) {
		ADC_CALLBOOK_TIME_MORE_THAN_1_NO = aDC_CALLBOOK_TIME_MORE_THAN_1_NO;
	}


	public String getDC_COMMISSIONERATE_OPENING_NO() {
		return DC_COMMISSIONERATE_OPENING_NO;
	}


	public void setDC_COMMISSIONERATE_OPENING_NO(String dC_COMMISSIONERATE_OPENING_NO) {
		DC_COMMISSIONERATE_OPENING_NO = dC_COMMISSIONERATE_OPENING_NO;
	}


	public String getDC_COMMISSIONERATE_OPENING_AMT() {
		return DC_COMMISSIONERATE_OPENING_AMT;
	}


	public void setDC_COMMISSIONERATE_OPENING_AMT(String dC_COMMISSIONERATE_OPENING_AMT) {
		DC_COMMISSIONERATE_OPENING_AMT = dC_COMMISSIONERATE_OPENING_AMT;
	}


	public String getDC_COMMISSIONERATE_RECEIPT_NO() {
		return DC_COMMISSIONERATE_RECEIPT_NO;
	}


	public void setDC_COMMISSIONERATE_RECEIPT_NO(String dC_COMMISSIONERATE_RECEIPT_NO) {
		DC_COMMISSIONERATE_RECEIPT_NO = dC_COMMISSIONERATE_RECEIPT_NO;
	}


	public String getDC_COMMISSIONERATE_RECEIPT_AMT() {
		return DC_COMMISSIONERATE_RECEIPT_AMT;
	}


	public void setDC_COMMISSIONERATE_RECEIPT_AMT(String dC_COMMISSIONERATE_RECEIPT_AMT) {
		DC_COMMISSIONERATE_RECEIPT_AMT = dC_COMMISSIONERATE_RECEIPT_AMT;
	}


	public String getDC_COMMISSIONERATE_DISPOSAL_NO() {
		return DC_COMMISSIONERATE_DISPOSAL_NO;
	}


	public void setDC_COMMISSIONERATE_DISPOSAL_NO(String dC_COMMISSIONERATE_DISPOSAL_NO) {
		DC_COMMISSIONERATE_DISPOSAL_NO = dC_COMMISSIONERATE_DISPOSAL_NO;
	}


	public String getDC_COMMISSIONERATE_DISPOSAL_AMT() {
		return DC_COMMISSIONERATE_DISPOSAL_AMT;
	}


	public void setDC_COMMISSIONERATE_DISPOSAL_AMT(String dC_COMMISSIONERATE_DISPOSAL_AMT) {
		DC_COMMISSIONERATE_DISPOSAL_AMT = dC_COMMISSIONERATE_DISPOSAL_AMT;
	}


	public String getDC_COMMISSIONERATE_OIO_NO() {
		return DC_COMMISSIONERATE_OIO_NO;
	}


	public void setDC_COMMISSIONERATE_OIO_NO(String dC_COMMISSIONERATE_OIO_NO) {
		DC_COMMISSIONERATE_OIO_NO = dC_COMMISSIONERATE_OIO_NO;
	}


	public String getDC_COMMISSIONERATE_OIO_AMT() {
		return DC_COMMISSIONERATE_OIO_AMT;
	}


	public void setDC_COMMISSIONERATE_OIO_AMT(String dC_COMMISSIONERATE_OIO_AMT) {
		DC_COMMISSIONERATE_OIO_AMT = dC_COMMISSIONERATE_OIO_AMT;
	}


	public String getDC_COMMISSIONERATE_AGE_LESS_3_NO() {
		return DC_COMMISSIONERATE_AGE_LESS_3_NO;
	}


	public void setDC_COMMISSIONERATE_AGE_LESS_3_NO(String dC_COMMISSIONERATE_AGE_LESS_3_NO) {
		DC_COMMISSIONERATE_AGE_LESS_3_NO = dC_COMMISSIONERATE_AGE_LESS_3_NO;
	}


	public String getDC_COMMISSIONERATE_AGE_3_TO_6_NO() {
		return DC_COMMISSIONERATE_AGE_3_TO_6_NO;
	}


	public void setDC_COMMISSIONERATE_AGE_3_TO_6_NO(String dC_COMMISSIONERATE_AGE_3_TO_6_NO) {
		DC_COMMISSIONERATE_AGE_3_TO_6_NO = dC_COMMISSIONERATE_AGE_3_TO_6_NO;
	}


	public String getDC_COMMISSIONERATE_AGE_6_TO_12_NO() {
		return DC_COMMISSIONERATE_AGE_6_TO_12_NO;
	}


	public void setDC_COMMISSIONERATE_AGE_6_TO_12_NO(String dC_COMMISSIONERATE_AGE_6_TO_12_NO) {
		DC_COMMISSIONERATE_AGE_6_TO_12_NO = dC_COMMISSIONERATE_AGE_6_TO_12_NO;
	}


	public String getDC_COMMISSIONERATE_AGE_MORE_THAN_1_NO() {
		return DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO;
	}


	public void setDC_COMMISSIONERATE_AGE_MORE_THAN_1_NO(String dC_COMMISSIONERATE_AGE_MORE_THAN_1_NO) {
		DC_COMMISSIONERATE_AGE_MORE_THAN_1_NO = dC_COMMISSIONERATE_AGE_MORE_THAN_1_NO;
	}


	public String getDC_COMMISSIONERATE_TIME_LESS_3_NO() {
		return DC_COMMISSIONERATE_TIME_LESS_3_NO;
	}


	public void setDC_COMMISSIONERATE_TIME_LESS_3_NO(String dC_COMMISSIONERATE_TIME_LESS_3_NO) {
		DC_COMMISSIONERATE_TIME_LESS_3_NO = dC_COMMISSIONERATE_TIME_LESS_3_NO;
	}


	public String getDC_COMMISSIONERATE_TIME_3_TO_6_NO() {
		return DC_COMMISSIONERATE_TIME_3_TO_6_NO;
	}


	public void setDC_COMMISSIONERATE_TIME_3_TO_6_NO(String dC_COMMISSIONERATE_TIME_3_TO_6_NO) {
		DC_COMMISSIONERATE_TIME_3_TO_6_NO = dC_COMMISSIONERATE_TIME_3_TO_6_NO;
	}


	public String getDC_COMMISSIONERATE_TIME_6_TO_12_NO() {
		return DC_COMMISSIONERATE_TIME_6_TO_12_NO;
	}


	public void setDC_COMMISSIONERATE_TIME_6_TO_12_NO(String dC_COMMISSIONERATE_TIME_6_TO_12_NO) {
		DC_COMMISSIONERATE_TIME_6_TO_12_NO = dC_COMMISSIONERATE_TIME_6_TO_12_NO;
	}


	public String getDC_COMMISSIONERATE_TIME_MORE_THAN_1_NO() {
		return DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO;
	}


	public void setDC_COMMISSIONERATE_TIME_MORE_THAN_1_NO(String dC_COMMISSIONERATE_TIME_MORE_THAN_1_NO) {
		DC_COMMISSIONERATE_TIME_MORE_THAN_1_NO = dC_COMMISSIONERATE_TIME_MORE_THAN_1_NO;
	}


	public String getDC_AUDIT_OPENING_NO() {
		return DC_AUDIT_OPENING_NO;
	}


	public void setDC_AUDIT_OPENING_NO(String dC_AUDIT_OPENING_NO) {
		DC_AUDIT_OPENING_NO = dC_AUDIT_OPENING_NO;
	}


	public String getDC_AUDIT_OPENING_AMT() {
		return DC_AUDIT_OPENING_AMT;
	}


	public void setDC_AUDIT_OPENING_AMT(String dC_AUDIT_OPENING_AMT) {
		DC_AUDIT_OPENING_AMT = dC_AUDIT_OPENING_AMT;
	}


	public String getDC_AUDIT_RECEIPT_NO() {
		return DC_AUDIT_RECEIPT_NO;
	}


	public void setDC_AUDIT_RECEIPT_NO(String dC_AUDIT_RECEIPT_NO) {
		DC_AUDIT_RECEIPT_NO = dC_AUDIT_RECEIPT_NO;
	}


	public String getDC_AUDIT_RECEIPT_AMT() {
		return DC_AUDIT_RECEIPT_AMT;
	}


	public void setDC_AUDIT_RECEIPT_AMT(String dC_AUDIT_RECEIPT_AMT) {
		DC_AUDIT_RECEIPT_AMT = dC_AUDIT_RECEIPT_AMT;
	}


	public String getDC_AUDIT_DISPOSAL_NO() {
		return DC_AUDIT_DISPOSAL_NO;
	}


	public void setDC_AUDIT_DISPOSAL_NO(String dC_AUDIT_DISPOSAL_NO) {
		DC_AUDIT_DISPOSAL_NO = dC_AUDIT_DISPOSAL_NO;
	}


	public String getDC_AUDIT_DISPOSAL_AMT() {
		return DC_AUDIT_DISPOSAL_AMT;
	}


	public void setDC_AUDIT_DISPOSAL_AMT(String dC_AUDIT_DISPOSAL_AMT) {
		DC_AUDIT_DISPOSAL_AMT = dC_AUDIT_DISPOSAL_AMT;
	}


	public String getDC_AUDIT_OIO_NO() {
		return DC_AUDIT_OIO_NO;
	}


	public void setDC_AUDIT_OIO_NO(String dC_AUDIT_OIO_NO) {
		DC_AUDIT_OIO_NO = dC_AUDIT_OIO_NO;
	}


	public String getDC_AUDIT_OIO_AMT() {
		return DC_AUDIT_OIO_AMT;
	}


	public void setDC_AUDIT_OIO_AMT(String dC_AUDIT_OIO_AMT) {
		DC_AUDIT_OIO_AMT = dC_AUDIT_OIO_AMT;
	}


	public String getDC_AUDIT_AGE_LESS_3_NO() {
		return DC_AUDIT_AGE_LESS_3_NO;
	}


	public void setDC_AUDIT_AGE_LESS_3_NO(String dC_AUDIT_AGE_LESS_3_NO) {
		DC_AUDIT_AGE_LESS_3_NO = dC_AUDIT_AGE_LESS_3_NO;
	}


	public String getDC_AUDIT_AGE_3_TO_6_NO() {
		return DC_AUDIT_AGE_3_TO_6_NO;
	}


	public void setDC_AUDIT_AGE_3_TO_6_NO(String dC_AUDIT_AGE_3_TO_6_NO) {
		DC_AUDIT_AGE_3_TO_6_NO = dC_AUDIT_AGE_3_TO_6_NO;
	}


	public String getDC_AUDIT_AGE_6_TO_12_NO() {
		return DC_AUDIT_AGE_6_TO_12_NO;
	}


	public void setDC_AUDIT_AGE_6_TO_12_NO(String dC_AUDIT_AGE_6_TO_12_NO) {
		DC_AUDIT_AGE_6_TO_12_NO = dC_AUDIT_AGE_6_TO_12_NO;
	}


	public String getDC_AUDIT_AGE_MORE_THAN_1_NO() {
		return DC_AUDIT_AGE_MORE_THAN_1_NO;
	}


	public void setDC_AUDIT_AGE_MORE_THAN_1_NO(String dC_AUDIT_AGE_MORE_THAN_1_NO) {
		DC_AUDIT_AGE_MORE_THAN_1_NO = dC_AUDIT_AGE_MORE_THAN_1_NO;
	}


	public String getDC_AUDIT_TIME_LESS_3_NO() {
		return DC_AUDIT_TIME_LESS_3_NO;
	}


	public void setDC_AUDIT_TIME_LESS_3_NO(String dC_AUDIT_TIME_LESS_3_NO) {
		DC_AUDIT_TIME_LESS_3_NO = dC_AUDIT_TIME_LESS_3_NO;
	}


	public String getDC_AUDIT_TIME_3_TO_6_NO() {
		return DC_AUDIT_TIME_3_TO_6_NO;
	}


	public void setDC_AUDIT_TIME_3_TO_6_NO(String dC_AUDIT_TIME_3_TO_6_NO) {
		DC_AUDIT_TIME_3_TO_6_NO = dC_AUDIT_TIME_3_TO_6_NO;
	}


	public String getDC_AUDIT_TIME_6_TO_12_NO() {
		return DC_AUDIT_TIME_6_TO_12_NO;
	}


	public void setDC_AUDIT_TIME_6_TO_12_NO(String dC_AUDIT_TIME_6_TO_12_NO) {
		DC_AUDIT_TIME_6_TO_12_NO = dC_AUDIT_TIME_6_TO_12_NO;
	}


	public String getDC_AUDIT_TIME_MORE_THAN_1_NO() {
		return DC_AUDIT_TIME_MORE_THAN_1_NO;
	}


	public void setDC_AUDIT_TIME_MORE_THAN_1_NO(String dC_AUDIT_TIME_MORE_THAN_1_NO) {
		DC_AUDIT_TIME_MORE_THAN_1_NO = dC_AUDIT_TIME_MORE_THAN_1_NO;
	}


	public String getDC_INVESTIGATION_OPENING_NO() {
		return DC_INVESTIGATION_OPENING_NO;
	}


	public void setDC_INVESTIGATION_OPENING_NO(String dC_INVESTIGATION_OPENING_NO) {
		DC_INVESTIGATION_OPENING_NO = dC_INVESTIGATION_OPENING_NO;
	}


	public String getDC_INVESTIGATION_OPENING_AMT() {
		return DC_INVESTIGATION_OPENING_AMT;
	}


	public void setDC_INVESTIGATION_OPENING_AMT(String dC_INVESTIGATION_OPENING_AMT) {
		DC_INVESTIGATION_OPENING_AMT = dC_INVESTIGATION_OPENING_AMT;
	}


	public String getDC_INVESTIGATION_RECEIPT_NO() {
		return DC_INVESTIGATION_RECEIPT_NO;
	}


	public void setDC_INVESTIGATION_RECEIPT_NO(String dC_INVESTIGATION_RECEIPT_NO) {
		DC_INVESTIGATION_RECEIPT_NO = dC_INVESTIGATION_RECEIPT_NO;
	}


	public String getDC_INVESTIGATION_RECEIPT_AMT() {
		return DC_INVESTIGATION_RECEIPT_AMT;
	}


	public void setDC_INVESTIGATION_RECEIPT_AMT(String dC_INVESTIGATION_RECEIPT_AMT) {
		DC_INVESTIGATION_RECEIPT_AMT = dC_INVESTIGATION_RECEIPT_AMT;
	}


	public String getDC_INVESTIGATION_DISPOSAL_NO() {
		return DC_INVESTIGATION_DISPOSAL_NO;
	}


	public void setDC_INVESTIGATION_DISPOSAL_NO(String dC_INVESTIGATION_DISPOSAL_NO) {
		DC_INVESTIGATION_DISPOSAL_NO = dC_INVESTIGATION_DISPOSAL_NO;
	}


	public String getDC_INVESTIGATION_DISPOSAL_AMT() {
		return DC_INVESTIGATION_DISPOSAL_AMT;
	}


	public void setDC_INVESTIGATION_DISPOSAL_AMT(String dC_INVESTIGATION_DISPOSAL_AMT) {
		DC_INVESTIGATION_DISPOSAL_AMT = dC_INVESTIGATION_DISPOSAL_AMT;
	}


	public String getDC_INVESTIGATION_OIO_NO() {
		return DC_INVESTIGATION_OIO_NO;
	}


	public void setDC_INVESTIGATION_OIO_NO(String dC_INVESTIGATION_OIO_NO) {
		DC_INVESTIGATION_OIO_NO = dC_INVESTIGATION_OIO_NO;
	}


	public String getDC_INVESTIGATION_OIO_AMT() {
		return DC_INVESTIGATION_OIO_AMT;
	}


	public void setDC_INVESTIGATION_OIO_AMT(String dC_INVESTIGATION_OIO_AMT) {
		DC_INVESTIGATION_OIO_AMT = dC_INVESTIGATION_OIO_AMT;
	}


	public String getDC_INVESTIGATION_AGE_LESS_3_NO() {
		return DC_INVESTIGATION_AGE_LESS_3_NO;
	}


	public void setDC_INVESTIGATION_AGE_LESS_3_NO(String dC_INVESTIGATION_AGE_LESS_3_NO) {
		DC_INVESTIGATION_AGE_LESS_3_NO = dC_INVESTIGATION_AGE_LESS_3_NO;
	}


	public String getDC_INVESTIGATION_AGE_3_TO_6_NO() {
		return DC_INVESTIGATION_AGE_3_TO_6_NO;
	}


	public void setDC_INVESTIGATION_AGE_3_TO_6_NO(String dC_INVESTIGATION_AGE_3_TO_6_NO) {
		DC_INVESTIGATION_AGE_3_TO_6_NO = dC_INVESTIGATION_AGE_3_TO_6_NO;
	}


	public String getDC_INVESTIGATION_AGE_6_TO_12_NO() {
		return DC_INVESTIGATION_AGE_6_TO_12_NO;
	}


	public void setDC_INVESTIGATION_AGE_6_TO_12_NO(String dC_INVESTIGATION_AGE_6_TO_12_NO) {
		DC_INVESTIGATION_AGE_6_TO_12_NO = dC_INVESTIGATION_AGE_6_TO_12_NO;
	}


	public String getDC_INVESTIGATION_AGE_MORE_THAN_1_NO() {
		return DC_INVESTIGATION_AGE_MORE_THAN_1_NO;
	}


	public void setDC_INVESTIGATION_AGE_MORE_THAN_1_NO(String dC_INVESTIGATION_AGE_MORE_THAN_1_NO) {
		DC_INVESTIGATION_AGE_MORE_THAN_1_NO = dC_INVESTIGATION_AGE_MORE_THAN_1_NO;
	}


	public String getDC_INVESTIGATION_TIME_LESS_3_NO() {
		return DC_INVESTIGATION_TIME_LESS_3_NO;
	}


	public void setDC_INVESTIGATION_TIME_LESS_3_NO(String dC_INVESTIGATION_TIME_LESS_3_NO) {
		DC_INVESTIGATION_TIME_LESS_3_NO = dC_INVESTIGATION_TIME_LESS_3_NO;
	}


	public String getDC_INVESTIGATION_TIME_3_TO_6_NO() {
		return DC_INVESTIGATION_TIME_3_TO_6_NO;
	}


	public void setDC_INVESTIGATION_TIME_3_TO_6_NO(String dC_INVESTIGATION_TIME_3_TO_6_NO) {
		DC_INVESTIGATION_TIME_3_TO_6_NO = dC_INVESTIGATION_TIME_3_TO_6_NO;
	}


	public String getDC_INVESTIGATION_TIME_6_TO_12_NO() {
		return DC_INVESTIGATION_TIME_6_TO_12_NO;
	}


	public void setDC_INVESTIGATION_TIME_6_TO_12_NO(String dC_INVESTIGATION_TIME_6_TO_12_NO) {
		DC_INVESTIGATION_TIME_6_TO_12_NO = dC_INVESTIGATION_TIME_6_TO_12_NO;
	}


	public String getDC_INVESTIGATION_TIME_MORE_THAN_1_NO() {
		return DC_INVESTIGATION_TIME_MORE_THAN_1_NO;
	}


	public void setDC_INVESTIGATION_TIME_MORE_THAN_1_NO(String dC_INVESTIGATION_TIME_MORE_THAN_1_NO) {
		DC_INVESTIGATION_TIME_MORE_THAN_1_NO = dC_INVESTIGATION_TIME_MORE_THAN_1_NO;
	}


	public String getDC_CALLBOOK_OPENING_NO() {
		return DC_CALLBOOK_OPENING_NO;
	}


	public void setDC_CALLBOOK_OPENING_NO(String dC_CALLBOOK_OPENING_NO) {
		DC_CALLBOOK_OPENING_NO = dC_CALLBOOK_OPENING_NO;
	}


	public String getDC_CALLBOOK_OPENING_AMT() {
		return DC_CALLBOOK_OPENING_AMT;
	}


	public void setDC_CALLBOOK_OPENING_AMT(String dC_CALLBOOK_OPENING_AMT) {
		DC_CALLBOOK_OPENING_AMT = dC_CALLBOOK_OPENING_AMT;
	}


	public String getDC_CALLBOOK_RECEIPT_NO() {
		return DC_CALLBOOK_RECEIPT_NO;
	}


	public void setDC_CALLBOOK_RECEIPT_NO(String dC_CALLBOOK_RECEIPT_NO) {
		DC_CALLBOOK_RECEIPT_NO = dC_CALLBOOK_RECEIPT_NO;
	}


	public String getDC_CALLBOOK_RECEIPT_AMT() {
		return DC_CALLBOOK_RECEIPT_AMT;
	}


	public void setDC_CALLBOOK_RECEIPT_AMT(String dC_CALLBOOK_RECEIPT_AMT) {
		DC_CALLBOOK_RECEIPT_AMT = dC_CALLBOOK_RECEIPT_AMT;
	}


	public String getDC_CALLBOOK_DISPOSAL_NO() {
		return DC_CALLBOOK_DISPOSAL_NO;
	}


	public void setDC_CALLBOOK_DISPOSAL_NO(String dC_CALLBOOK_DISPOSAL_NO) {
		DC_CALLBOOK_DISPOSAL_NO = dC_CALLBOOK_DISPOSAL_NO;
	}


	public String getDC_CALLBOOK_DISPOSAL_AMT() {
		return DC_CALLBOOK_DISPOSAL_AMT;
	}


	public void setDC_CALLBOOK_DISPOSAL_AMT(String dC_CALLBOOK_DISPOSAL_AMT) {
		DC_CALLBOOK_DISPOSAL_AMT = dC_CALLBOOK_DISPOSAL_AMT;
	}


	public String getDC_CALLBOOK_OIO_NO() {
		return DC_CALLBOOK_OIO_NO;
	}


	public void setDC_CALLBOOK_OIO_NO(String dC_CALLBOOK_OIO_NO) {
		DC_CALLBOOK_OIO_NO = dC_CALLBOOK_OIO_NO;
	}


	public String getDC_CALLBOOK_OIO_AMT() {
		return DC_CALLBOOK_OIO_AMT;
	}


	public void setDC_CALLBOOK_OIO_AMT(String dC_CALLBOOK_OIO_AMT) {
		DC_CALLBOOK_OIO_AMT = dC_CALLBOOK_OIO_AMT;
	}


	public String getDC_CALLBOOK_AGE_LESS_3_NO() {
		return DC_CALLBOOK_AGE_LESS_3_NO;
	}


	public void setDC_CALLBOOK_AGE_LESS_3_NO(String dC_CALLBOOK_AGE_LESS_3_NO) {
		DC_CALLBOOK_AGE_LESS_3_NO = dC_CALLBOOK_AGE_LESS_3_NO;
	}


	public String getDC_CALLBOOK_AGE_3_TO_6_NO() {
		return DC_CALLBOOK_AGE_3_TO_6_NO;
	}


	public void setDC_CALLBOOK_AGE_3_TO_6_NO(String dC_CALLBOOK_AGE_3_TO_6_NO) {
		DC_CALLBOOK_AGE_3_TO_6_NO = dC_CALLBOOK_AGE_3_TO_6_NO;
	}


	public String getDC_CALLBOOK_AGE_6_TO_12_NO() {
		return DC_CALLBOOK_AGE_6_TO_12_NO;
	}


	public void setDC_CALLBOOK_AGE_6_TO_12_NO(String dC_CALLBOOK_AGE_6_TO_12_NO) {
		DC_CALLBOOK_AGE_6_TO_12_NO = dC_CALLBOOK_AGE_6_TO_12_NO;
	}


	public String getDC_CALLBOOK_AGE_MORE_THAN_1_NO() {
		return DC_CALLBOOK_AGE_MORE_THAN_1_NO;
	}


	public void setDC_CALLBOOK_AGE_MORE_THAN_1_NO(String dC_CALLBOOK_AGE_MORE_THAN_1_NO) {
		DC_CALLBOOK_AGE_MORE_THAN_1_NO = dC_CALLBOOK_AGE_MORE_THAN_1_NO;
	}


	public String getDC_CALLBOOK_TIME_LESS_3_NO() {
		return DC_CALLBOOK_TIME_LESS_3_NO;
	}


	public void setDC_CALLBOOK_TIME_LESS_3_NO(String dC_CALLBOOK_TIME_LESS_3_NO) {
		DC_CALLBOOK_TIME_LESS_3_NO = dC_CALLBOOK_TIME_LESS_3_NO;
	}


	public String getDC_CALLBOOK_TIME_3_TO_6_NO() {
		return DC_CALLBOOK_TIME_3_TO_6_NO;
	}


	public void setDC_CALLBOOK_TIME_3_TO_6_NO(String dC_CALLBOOK_TIME_3_TO_6_NO) {
		DC_CALLBOOK_TIME_3_TO_6_NO = dC_CALLBOOK_TIME_3_TO_6_NO;
	}


	public String getDC_CALLBOOK_TIME_6_TO_12_NO() {
		return DC_CALLBOOK_TIME_6_TO_12_NO;
	}


	public void setDC_CALLBOOK_TIME_6_TO_12_NO(String dC_CALLBOOK_TIME_6_TO_12_NO) {
		DC_CALLBOOK_TIME_6_TO_12_NO = dC_CALLBOOK_TIME_6_TO_12_NO;
	}


	public String getDC_CALLBOOK_TIME_MORE_THAN_1_NO() {
		return DC_CALLBOOK_TIME_MORE_THAN_1_NO;
	}


	public void setDC_CALLBOOK_TIME_MORE_THAN_1_NO(String dC_CALLBOOK_TIME_MORE_THAN_1_NO) {
		DC_CALLBOOK_TIME_MORE_THAN_1_NO = dC_CALLBOOK_TIME_MORE_THAN_1_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_OPENING_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_OPENING_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_OPENING_NO(String sUPERINTENDENT_COMMISSIONERATE_OPENING_NO) {
		SUPERINTENDENT_COMMISSIONERATE_OPENING_NO = sUPERINTENDENT_COMMISSIONERATE_OPENING_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_OPENING_AMT() {
		return SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_OPENING_AMT(String sUPERINTENDENT_COMMISSIONERATE_OPENING_AMT) {
		SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT = sUPERINTENDENT_COMMISSIONERATE_OPENING_AMT;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO(String sUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO) {
		SUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO = sUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT() {
		return SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT(String sUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT) {
		SUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT = sUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO(String sUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO) {
		SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO = sUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT() {
		return SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT(String sUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT) {
		SUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT = sUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_OIO_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_OIO_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_OIO_NO(String sUPERINTENDENT_COMMISSIONERATE_OIO_NO) {
		SUPERINTENDENT_COMMISSIONERATE_OIO_NO = sUPERINTENDENT_COMMISSIONERATE_OIO_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_OIO_AMT() {
		return SUPERINTENDENT_COMMISSIONERATE_OIO_AMT;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_OIO_AMT(String sUPERINTENDENT_COMMISSIONERATE_OIO_AMT) {
		SUPERINTENDENT_COMMISSIONERATE_OIO_AMT = sUPERINTENDENT_COMMISSIONERATE_OIO_AMT;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO(String sUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO) {
		SUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO = sUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO(String sUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO) {
		SUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO = sUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO(String sUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO) {
		SUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO = sUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO(
			String sUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO) {
		SUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO = sUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO(String sUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO) {
		SUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO = sUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO(String sUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO) {
		SUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO = sUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO(String sUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO) {
		SUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO = sUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO(
			String sUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO) {
		SUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO = sUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO;
	}


	public String getSUPERINTENDENT_AUDIT_OPENING_NO() {
		return SUPERINTENDENT_AUDIT_OPENING_NO;
	}


	public void setSUPERINTENDENT_AUDIT_OPENING_NO(String sUPERINTENDENT_AUDIT_OPENING_NO) {
		SUPERINTENDENT_AUDIT_OPENING_NO = sUPERINTENDENT_AUDIT_OPENING_NO;
	}


	public String getSUPERINTENDENT_AUDIT_OPENING_AMT() {
		return SUPERINTENDENT_AUDIT_OPENING_AMT;
	}


	public void setSUPERINTENDENT_AUDIT_OPENING_AMT(String sUPERINTENDENT_AUDIT_OPENING_AMT) {
		SUPERINTENDENT_AUDIT_OPENING_AMT = sUPERINTENDENT_AUDIT_OPENING_AMT;
	}


	public String getSUPERINTENDENT_AUDIT_RECEIPT_NO() {
		return SUPERINTENDENT_AUDIT_RECEIPT_NO;
	}


	public void setSUPERINTENDENT_AUDIT_RECEIPT_NO(String sUPERINTENDENT_AUDIT_RECEIPT_NO) {
		SUPERINTENDENT_AUDIT_RECEIPT_NO = sUPERINTENDENT_AUDIT_RECEIPT_NO;
	}


	public String getSUPERINTENDENT_AUDIT_RECEIPT_AMT() {
		return SUPERINTENDENT_AUDIT_RECEIPT_AMT;
	}


	public void setSUPERINTENDENT_AUDIT_RECEIPT_AMT(String sUPERINTENDENT_AUDIT_RECEIPT_AMT) {
		SUPERINTENDENT_AUDIT_RECEIPT_AMT = sUPERINTENDENT_AUDIT_RECEIPT_AMT;
	}


	public String getSUPERINTENDENT_AUDIT_DISPOSAL_NO() {
		return SUPERINTENDENT_AUDIT_DISPOSAL_NO;
	}


	public void setSUPERINTENDENT_AUDIT_DISPOSAL_NO(String sUPERINTENDENT_AUDIT_DISPOSAL_NO) {
		SUPERINTENDENT_AUDIT_DISPOSAL_NO = sUPERINTENDENT_AUDIT_DISPOSAL_NO;
	}


	public String getSUPERINTENDENT_AUDIT_DISPOSAL_AMT() {
		return SUPERINTENDENT_AUDIT_DISPOSAL_AMT;
	}


	public void setSUPERINTENDENT_AUDIT_DISPOSAL_AMT(String sUPERINTENDENT_AUDIT_DISPOSAL_AMT) {
		SUPERINTENDENT_AUDIT_DISPOSAL_AMT = sUPERINTENDENT_AUDIT_DISPOSAL_AMT;
	}


	public String getSUPERINTENDENT_AUDIT_OIO_NO() {
		return SUPERINTENDENT_AUDIT_OIO_NO;
	}


	public void setSUPERINTENDENT_AUDIT_OIO_NO(String sUPERINTENDENT_AUDIT_OIO_NO) {
		SUPERINTENDENT_AUDIT_OIO_NO = sUPERINTENDENT_AUDIT_OIO_NO;
	}


	public String getSUPERINTENDENT_AUDIT_OIO_AMT() {
		return SUPERINTENDENT_AUDIT_OIO_AMT;
	}


	public void setSUPERINTENDENT_AUDIT_OIO_AMT(String sUPERINTENDENT_AUDIT_OIO_AMT) {
		SUPERINTENDENT_AUDIT_OIO_AMT = sUPERINTENDENT_AUDIT_OIO_AMT;
	}


	public String getSUPERINTENDENT_AUDIT_AGE_LESS_3_NO() {
		return SUPERINTENDENT_AUDIT_AGE_LESS_3_NO;
	}


	public void setSUPERINTENDENT_AUDIT_AGE_LESS_3_NO(String sUPERINTENDENT_AUDIT_AGE_LESS_3_NO) {
		SUPERINTENDENT_AUDIT_AGE_LESS_3_NO = sUPERINTENDENT_AUDIT_AGE_LESS_3_NO;
	}


	public String getSUPERINTENDENT_AUDIT_AGE_3_TO_6_NO() {
		return SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO;
	}


	public void setSUPERINTENDENT_AUDIT_AGE_3_TO_6_NO(String sUPERINTENDENT_AUDIT_AGE_3_TO_6_NO) {
		SUPERINTENDENT_AUDIT_AGE_3_TO_6_NO = sUPERINTENDENT_AUDIT_AGE_3_TO_6_NO;
	}


	public String getSUPERINTENDENT_AUDIT_AGE_6_TO_12_NO() {
		return SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO;
	}


	public void setSUPERINTENDENT_AUDIT_AGE_6_TO_12_NO(String sUPERINTENDENT_AUDIT_AGE_6_TO_12_NO) {
		SUPERINTENDENT_AUDIT_AGE_6_TO_12_NO = sUPERINTENDENT_AUDIT_AGE_6_TO_12_NO;
	}


	public String getSUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO() {
		return SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO;
	}


	public void setSUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO(String sUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO) {
		SUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO = sUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO;
	}


	public String getSUPERINTENDENT_AUDIT_TIME_LESS_3_NO() {
		return SUPERINTENDENT_AUDIT_TIME_LESS_3_NO;
	}


	public void setSUPERINTENDENT_AUDIT_TIME_LESS_3_NO(String sUPERINTENDENT_AUDIT_TIME_LESS_3_NO) {
		SUPERINTENDENT_AUDIT_TIME_LESS_3_NO = sUPERINTENDENT_AUDIT_TIME_LESS_3_NO;
	}


	public String getSUPERINTENDENT_AUDIT_TIME_3_TO_6_NO() {
		return SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO;
	}


	public void setSUPERINTENDENT_AUDIT_TIME_3_TO_6_NO(String sUPERINTENDENT_AUDIT_TIME_3_TO_6_NO) {
		SUPERINTENDENT_AUDIT_TIME_3_TO_6_NO = sUPERINTENDENT_AUDIT_TIME_3_TO_6_NO;
	}


	public String getSUPERINTENDENT_AUDIT_TIME_6_TO_12_NO() {
		return SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO;
	}


	public void setSUPERINTENDENT_AUDIT_TIME_6_TO_12_NO(String sUPERINTENDENT_AUDIT_TIME_6_TO_12_NO) {
		SUPERINTENDENT_AUDIT_TIME_6_TO_12_NO = sUPERINTENDENT_AUDIT_TIME_6_TO_12_NO;
	}


	public String getSUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO() {
		return SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO;
	}


	public void setSUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO(String sUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO) {
		SUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO = sUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_OPENING_NO() {
		return SUPERINTENDENT_INVESTIGATION_OPENING_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_OPENING_NO(String sUPERINTENDENT_INVESTIGATION_OPENING_NO) {
		SUPERINTENDENT_INVESTIGATION_OPENING_NO = sUPERINTENDENT_INVESTIGATION_OPENING_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_OPENING_AMT() {
		return SUPERINTENDENT_INVESTIGATION_OPENING_AMT;
	}


	public void setSUPERINTENDENT_INVESTIGATION_OPENING_AMT(String sUPERINTENDENT_INVESTIGATION_OPENING_AMT) {
		SUPERINTENDENT_INVESTIGATION_OPENING_AMT = sUPERINTENDENT_INVESTIGATION_OPENING_AMT;
	}


	public String getSUPERINTENDENT_INVESTIGATION_RECEIPT_NO() {
		return SUPERINTENDENT_INVESTIGATION_RECEIPT_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_RECEIPT_NO(String sUPERINTENDENT_INVESTIGATION_RECEIPT_NO) {
		SUPERINTENDENT_INVESTIGATION_RECEIPT_NO = sUPERINTENDENT_INVESTIGATION_RECEIPT_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_RECEIPT_AMT() {
		return SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT;
	}


	public void setSUPERINTENDENT_INVESTIGATION_RECEIPT_AMT(String sUPERINTENDENT_INVESTIGATION_RECEIPT_AMT) {
		SUPERINTENDENT_INVESTIGATION_RECEIPT_AMT = sUPERINTENDENT_INVESTIGATION_RECEIPT_AMT;
	}


	public String getSUPERINTENDENT_INVESTIGATION_DISPOSAL_NO() {
		return SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_DISPOSAL_NO(String sUPERINTENDENT_INVESTIGATION_DISPOSAL_NO) {
		SUPERINTENDENT_INVESTIGATION_DISPOSAL_NO = sUPERINTENDENT_INVESTIGATION_DISPOSAL_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT() {
		return SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT;
	}


	public void setSUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT(String sUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT) {
		SUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT = sUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT;
	}


	public String getSUPERINTENDENT_INVESTIGATION_OIO_NO() {
		return SUPERINTENDENT_INVESTIGATION_OIO_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_OIO_NO(String sUPERINTENDENT_INVESTIGATION_OIO_NO) {
		SUPERINTENDENT_INVESTIGATION_OIO_NO = sUPERINTENDENT_INVESTIGATION_OIO_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_OIO_AMT() {
		return SUPERINTENDENT_INVESTIGATION_OIO_AMT;
	}


	public void setSUPERINTENDENT_INVESTIGATION_OIO_AMT(String sUPERINTENDENT_INVESTIGATION_OIO_AMT) {
		SUPERINTENDENT_INVESTIGATION_OIO_AMT = sUPERINTENDENT_INVESTIGATION_OIO_AMT;
	}


	public String getSUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO() {
		return SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO(String sUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO) {
		SUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO = sUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO() {
		return SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO(String sUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO) {
		SUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO = sUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO() {
		return SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO(String sUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO) {
		SUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO = sUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO() {
		return SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO(String sUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO) {
		SUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO = sUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO() {
		return SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO(String sUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO) {
		SUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO = sUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO() {
		return SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO(String sUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO) {
		SUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO = sUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO() {
		return SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO(String sUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO) {
		SUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO = sUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO() {
		return SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO(
			String sUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO) {
		SUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO = sUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_OPENING_NO() {
		return SUPERINTENDENT_CALLBOOK_OPENING_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_OPENING_NO(String sUPERINTENDENT_CALLBOOK_OPENING_NO) {
		SUPERINTENDENT_CALLBOOK_OPENING_NO = sUPERINTENDENT_CALLBOOK_OPENING_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_OPENING_AMT() {
		return SUPERINTENDENT_CALLBOOK_OPENING_AMT;
	}


	public void setSUPERINTENDENT_CALLBOOK_OPENING_AMT(String sUPERINTENDENT_CALLBOOK_OPENING_AMT) {
		SUPERINTENDENT_CALLBOOK_OPENING_AMT = sUPERINTENDENT_CALLBOOK_OPENING_AMT;
	}


	public String getSUPERINTENDENT_CALLBOOK_RECEIPT_NO() {
		return SUPERINTENDENT_CALLBOOK_RECEIPT_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_RECEIPT_NO(String sUPERINTENDENT_CALLBOOK_RECEIPT_NO) {
		SUPERINTENDENT_CALLBOOK_RECEIPT_NO = sUPERINTENDENT_CALLBOOK_RECEIPT_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_RECEIPT_AMT() {
		return SUPERINTENDENT_CALLBOOK_RECEIPT_AMT;
	}


	public void setSUPERINTENDENT_CALLBOOK_RECEIPT_AMT(String sUPERINTENDENT_CALLBOOK_RECEIPT_AMT) {
		SUPERINTENDENT_CALLBOOK_RECEIPT_AMT = sUPERINTENDENT_CALLBOOK_RECEIPT_AMT;
	}


	public String getSUPERINTENDENT_CALLBOOK_DISPOSAL_NO() {
		return SUPERINTENDENT_CALLBOOK_DISPOSAL_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_DISPOSAL_NO(String sUPERINTENDENT_CALLBOOK_DISPOSAL_NO) {
		SUPERINTENDENT_CALLBOOK_DISPOSAL_NO = sUPERINTENDENT_CALLBOOK_DISPOSAL_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_DISPOSAL_AMT() {
		return SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT;
	}


	public void setSUPERINTENDENT_CALLBOOK_DISPOSAL_AMT(String sUPERINTENDENT_CALLBOOK_DISPOSAL_AMT) {
		SUPERINTENDENT_CALLBOOK_DISPOSAL_AMT = sUPERINTENDENT_CALLBOOK_DISPOSAL_AMT;
	}


	public String getSUPERINTENDENT_CALLBOOK_OIO_NO() {
		return SUPERINTENDENT_CALLBOOK_OIO_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_OIO_NO(String sUPERINTENDENT_CALLBOOK_OIO_NO) {
		SUPERINTENDENT_CALLBOOK_OIO_NO = sUPERINTENDENT_CALLBOOK_OIO_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_OIO_AMT() {
		return SUPERINTENDENT_CALLBOOK_OIO_AMT;
	}


	public void setSUPERINTENDENT_CALLBOOK_OIO_AMT(String sUPERINTENDENT_CALLBOOK_OIO_AMT) {
		SUPERINTENDENT_CALLBOOK_OIO_AMT = sUPERINTENDENT_CALLBOOK_OIO_AMT;
	}


	public String getSUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO() {
		return SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO(String sUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO) {
		SUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO = sUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO() {
		return SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO(String sUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO) {
		SUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO = sUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO() {
		return SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO(String sUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO) {
		SUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO = sUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO() {
		return SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO(String sUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO) {
		SUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO = sUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO() {
		return SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO(String sUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO) {
		SUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO = sUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO() {
		return SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO(String sUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO) {
		SUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO = sUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO() {
		return SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO(String sUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO) {
		SUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO = sUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO() {
		return SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO(String sUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO) {
		SUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO = sUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO;
	}


	public String getADC_COMM_CLOSING_NO() {
		return ADC_COMM_CLOSING_NO;
	}


	public void setADC_COMM_CLOSING_NO(String aDC_COMM_CLOSING_NO) {
		ADC_COMM_CLOSING_NO = aDC_COMM_CLOSING_NO;
	}


	public String getADC_COMM_CLOSING_AMT() {
		return ADC_COMM_CLOSING_AMT;
	}


	public void setADC_COMM_CLOSING_AMT(String aDC_COMM_CLOSING_AMT) {
		ADC_COMM_CLOSING_AMT = aDC_COMM_CLOSING_AMT;
	}


	public String getADC_AUDIT_CLOSING_NO() {
		return ADC_AUDIT_CLOSING_NO;
	}


	public void setADC_AUDIT_CLOSING_NO(String aDC_AUDIT_CLOSING_NO) {
		ADC_AUDIT_CLOSING_NO = aDC_AUDIT_CLOSING_NO;
	}


	public String getADC_AUDIT_CLOSING_AMT() {
		return ADC_AUDIT_CLOSING_AMT;
	}


	public void setADC_AUDIT_CLOSING_AMT(String aDC_AUDIT_CLOSING_AMT) {
		ADC_AUDIT_CLOSING_AMT = aDC_AUDIT_CLOSING_AMT;
	}


	public String getADC_INVESTIGATION_CLOSING_NO() {
		return ADC_INVESTIGATION_CLOSING_NO;
	}


	public void setADC_INVESTIGATION_CLOSING_NO(String aDC_INVESTIGATION_CLOSING_NO) {
		ADC_INVESTIGATION_CLOSING_NO = aDC_INVESTIGATION_CLOSING_NO;
	}


	public String getADC_INVESTIGATION_CLOSING_AMT() {
		return ADC_INVESTIGATION_CLOSING_AMT;
	}


	public void setADC_INVESTIGATION_CLOSING_AMT(String aDC_INVESTIGATION_CLOSING_AMT) {
		ADC_INVESTIGATION_CLOSING_AMT = aDC_INVESTIGATION_CLOSING_AMT;
	}


	public String getADC_CALLBOOK_CLOSING_NO() {
		return ADC_CALLBOOK_CLOSING_NO;
	}


	public void setADC_CALLBOOK_CLOSING_NO(String aDC_CALLBOOK_CLOSING_NO) {
		ADC_CALLBOOK_CLOSING_NO = aDC_CALLBOOK_CLOSING_NO;
	}


	public String getADC_CALLBOOK_CLOSING_AMT() {
		return ADC_CALLBOOK_CLOSING_AMT;
	}


	public void setADC_CALLBOOK_CLOSING_AMT(String aDC_CALLBOOK_CLOSING_AMT) {
		ADC_CALLBOOK_CLOSING_AMT = aDC_CALLBOOK_CLOSING_AMT;
	}


	public String getDC_COMM_CLOSING_NO() {
		return DC_COMM_CLOSING_NO;
	}


	public void setDC_COMM_CLOSING_NO(String dC_COMM_CLOSING_NO) {
		DC_COMM_CLOSING_NO = dC_COMM_CLOSING_NO;
	}


	public String getDC_COMM_CLOSING_AMT() {
		return DC_COMM_CLOSING_AMT;
	}


	public void setDC_COMM_CLOSING_AMT(String dC_COMM_CLOSING_AMT) {
		DC_COMM_CLOSING_AMT = dC_COMM_CLOSING_AMT;
	}


	public String getDC_AUDIT_CLOSING_NO() {
		return DC_AUDIT_CLOSING_NO;
	}


	public void setDC_AUDIT_CLOSING_NO(String dC_AUDIT_CLOSING_NO) {
		DC_AUDIT_CLOSING_NO = dC_AUDIT_CLOSING_NO;
	}


	public String getDC_AUDIT_CLOSING_AMT() {
		return DC_AUDIT_CLOSING_AMT;
	}


	public void setDC_AUDIT_CLOSING_AMT(String dC_AUDIT_CLOSING_AMT) {
		DC_AUDIT_CLOSING_AMT = dC_AUDIT_CLOSING_AMT;
	}


	public String getDC_INVESTIGATION_CLOSING_NO() {
		return DC_INVESTIGATION_CLOSING_NO;
	}


	public void setDC_INVESTIGATION_CLOSING_NO(String dC_INVESTIGATION_CLOSING_NO) {
		DC_INVESTIGATION_CLOSING_NO = dC_INVESTIGATION_CLOSING_NO;
	}


	public String getDC_INVESTIGATION_CLOSING_AMT() {
		return DC_INVESTIGATION_CLOSING_AMT;
	}


	public void setDC_INVESTIGATION_CLOSING_AMT(String dC_INVESTIGATION_CLOSING_AMT) {
		DC_INVESTIGATION_CLOSING_AMT = dC_INVESTIGATION_CLOSING_AMT;
	}


	public String getDC_CALLBOOK_CLOSING_NO() {
		return DC_CALLBOOK_CLOSING_NO;
	}


	public void setDC_CALLBOOK_CLOSING_NO(String dC_CALLBOOK_CLOSING_NO) {
		DC_CALLBOOK_CLOSING_NO = dC_CALLBOOK_CLOSING_NO;
	}


	public String getDC_CALLBOOK_CLOSING_AMT() {
		return DC_CALLBOOK_CLOSING_AMT;
	}


	public void setDC_CALLBOOK_CLOSING_AMT(String dC_CALLBOOK_CLOSING_AMT) {
		DC_CALLBOOK_CLOSING_AMT = dC_CALLBOOK_CLOSING_AMT;
	}


	public String getSUPERINTENDENT_COMM_CLOSING_NO() {
		return SUPERINTENDENT_COMM_CLOSING_NO;
	}


	public void setSUPERINTENDENT_COMM_CLOSING_NO(String sUPERINTENDENT_COMM_CLOSING_NO) {
		SUPERINTENDENT_COMM_CLOSING_NO = sUPERINTENDENT_COMM_CLOSING_NO;
	}


	public String getSUPERINTENDENT_COMM_CLOSING_AMT() {
		return SUPERINTENDENT_COMM_CLOSING_AMT;
	}


	public void setSUPERINTENDENT_COMM_CLOSING_AMT(String sUPERINTENDENT_COMM_CLOSING_AMT) {
		SUPERINTENDENT_COMM_CLOSING_AMT = sUPERINTENDENT_COMM_CLOSING_AMT;
	}


	public String getSUPERINTENDENT_AUDIT_CLOSING_NO() {
		return SUPERINTENDENT_AUDIT_CLOSING_NO;
	}


	public void setSUPERINTENDENT_AUDIT_CLOSING_NO(String sUPERINTENDENT_AUDIT_CLOSING_NO) {
		SUPERINTENDENT_AUDIT_CLOSING_NO = sUPERINTENDENT_AUDIT_CLOSING_NO;
	}


	public String getSUPERINTENDENT_AUDIT_CLOSING_AMT() {
		return SUPERINTENDENT_AUDIT_CLOSING_AMT;
	}


	public void setSUPERINTENDENT_AUDIT_CLOSING_AMT(String sUPERINTENDENT_AUDIT_CLOSING_AMT) {
		SUPERINTENDENT_AUDIT_CLOSING_AMT = sUPERINTENDENT_AUDIT_CLOSING_AMT;
	}


	public String getSUPERINTENDENT_INVESTIGATION_CLOSING_NO() {
		return SUPERINTENDENT_INVESTIGATION_CLOSING_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_CLOSING_NO(String sUPERINTENDENT_INVESTIGATION_CLOSING_NO) {
		SUPERINTENDENT_INVESTIGATION_CLOSING_NO = sUPERINTENDENT_INVESTIGATION_CLOSING_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_CLOSING_AMT() {
		return SUPERINTENDENT_INVESTIGATION_CLOSING_AMT;
	}


	public void setSUPERINTENDENT_INVESTIGATION_CLOSING_AMT(String sUPERINTENDENT_INVESTIGATION_CLOSING_AMT) {
		SUPERINTENDENT_INVESTIGATION_CLOSING_AMT = sUPERINTENDENT_INVESTIGATION_CLOSING_AMT;
	}


	public String getSUPERINTENDENT_CALLBOOK_CLOSING_NO() {
		return SUPERINTENDENT_CALLBOOK_CLOSING_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_CLOSING_NO(String sUPERINTENDENT_CALLBOOK_CLOSING_NO) {
		SUPERINTENDENT_CALLBOOK_CLOSING_NO = sUPERINTENDENT_CALLBOOK_CLOSING_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_CLOSING_AMT() {
		return SUPERINTENDENT_CALLBOOK_CLOSING_AMT;
	}


	public void setSUPERINTENDENT_CALLBOOK_CLOSING_AMT(String sUPERINTENDENT_CALLBOOK_CLOSING_AMT) {
		SUPERINTENDENT_CALLBOOK_CLOSING_AMT = sUPERINTENDENT_CALLBOOK_CLOSING_AMT;
	}


	public SP_DPM_GST_ADJ_1_COMM_TEMP_Result  generateAllResult(List <Object []> resultList) {
		if(resultList.size()==0)
			  return null;
		else {
		List <SP_DPM_GST_ADJ_1_COMM_TEMP_Result> list =  new ArrayList<SP_DPM_GST_ADJ_1_COMM_TEMP_Result>();
		//for(Object [] objectArray : resultList) { 
			SP_DPM_GST_ADJ_1_COMM_TEMP_Result temp = new SP_DPM_GST_ADJ_1_COMM_TEMP_Result ();
			
		temp = generateReportBean(resultList.get(0));
		list.add(temp);
		//}
		return list.get(0);
		}
	}
	
	
	 private SP_DPM_GST_ADJ_1_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_DPM_GST_ADJ_1_COMM_TEMP_Result temp =  new SP_DPM_GST_ADJ_1_COMM_TEMP_Result();
			
			if (null != objectArray[0]){ temp.setCOMM_CODE(String.valueOf(objectArray[0]));}
			if (null != objectArray[1]){ temp.setMM_YYYY(String.valueOf(objectArray[1]));}
			if (null != objectArray[2]){ temp.setADC_COMMISSIONERATE_OPENING_NO (String.valueOf(objectArray[2]));}
			if (null != objectArray[3]){ temp.setADC_COMMISSIONERATE_OPENING_AMT (String.valueOf(objectArray[3]));}
			if (null != objectArray[4]){ temp.setADC_COMMISSIONERATE_RECEIPT_NO (String.valueOf(objectArray[4]));}
			if (null != objectArray[5]){ temp.setADC_COMMISSIONERATE_RECEIPT_AMT (String.valueOf(objectArray[5]));}
			if (null != objectArray[6]){ temp.setADC_COMMISSIONERATE_DISPOSAL_NO (String.valueOf(objectArray[6]));}
			if (null != objectArray[7]){ temp.setADC_COMMISSIONERATE_DISPOSAL_AMT (String.valueOf(objectArray[7]));}
			if (null != objectArray[8]){ temp.setADC_COMMISSIONERATE_OIO_NO (String.valueOf(objectArray[8]));}
			if (null != objectArray[9]){ temp.setADC_COMMISSIONERATE_OIO_AMT (String.valueOf(objectArray[9]));}
			if (null != objectArray[10]){ temp.setADC_COMM_CLOSING_NO(String.valueOf(objectArray[10]));}
			if (null != objectArray[11]){ temp.setADC_COMM_CLOSING_AMT(String.valueOf(objectArray[11]));}
			if (null != objectArray[12]){ temp.setADC_COMMISSIONERATE_AGE_LESS_3_NO (String.valueOf(objectArray[12]));}
			if (null != objectArray[13]){ temp.setADC_COMMISSIONERATE_AGE_3_TO_6_NO (String.valueOf(objectArray[13]));}
			if (null != objectArray[14]){ temp.setADC_COMMISSIONERATE_AGE_6_TO_12_NO (String.valueOf(objectArray[14]));}
			if (null != objectArray[15]){ temp.setADC_COMMISSIONERATE_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[15]));}
			if (null != objectArray[16]){ temp.setADC_COMMISSIONERATE_TIME_LESS_3_NO (String.valueOf(objectArray[16]));}
			if (null != objectArray[17]){ temp.setADC_COMMISSIONERATE_TIME_3_TO_6_NO (String.valueOf(objectArray[17]));}
			if (null != objectArray[18]){ temp.setADC_COMMISSIONERATE_TIME_6_TO_12_NO (String.valueOf(objectArray[18]));}
			if (null != objectArray[19]){ temp.setADC_COMMISSIONERATE_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[19]));}
			if (null != objectArray[20]){ temp.setADC_AUDIT_OPENING_NO (String.valueOf(objectArray[20]));}
			if (null != objectArray[21]){ temp.setADC_AUDIT_OPENING_AMT (String.valueOf(objectArray[21]));}
			if (null != objectArray[22]){ temp.setADC_AUDIT_RECEIPT_NO (String.valueOf(objectArray[22]));}
			if (null != objectArray[23]){ temp.setADC_AUDIT_RECEIPT_AMT (String.valueOf(objectArray[23]));}
			if (null != objectArray[24]){ temp.setADC_AUDIT_DISPOSAL_NO (String.valueOf(objectArray[24]));}
			if (null != objectArray[25]){ temp.setADC_AUDIT_DISPOSAL_AMT (String.valueOf(objectArray[25]));}
			if (null != objectArray[26]){ temp.setADC_AUDIT_OIO_NO (String.valueOf(objectArray[26]));}
			if (null != objectArray[27]){ temp.setADC_AUDIT_OIO_AMT (String.valueOf(objectArray[27]));}
			if (null != objectArray[28]){ temp.setADC_AUDIT_CLOSING_NO(String.valueOf(objectArray[28]));}
			if (null != objectArray[29]){ temp.setADC_AUDIT_CLOSING_AMT(String.valueOf(objectArray[29]));}
			if (null != objectArray[30]){ temp.setADC_AUDIT_AGE_LESS_3_NO (String.valueOf(objectArray[30]));}
			if (null != objectArray[31]){ temp.setADC_AUDIT_AGE_3_TO_6_NO (String.valueOf(objectArray[31]));}
			if (null != objectArray[32]){ temp.setADC_AUDIT_AGE_6_TO_12_NO (String.valueOf(objectArray[32]));}
			if (null != objectArray[33]){ temp.setADC_AUDIT_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[33]));}
			if (null != objectArray[34]){ temp.setADC_AUDIT_TIME_LESS_3_NO (String.valueOf(objectArray[34]));}
			if (null != objectArray[35]){ temp.setADC_AUDIT_TIME_3_TO_6_NO (String.valueOf(objectArray[35]));}
			if (null != objectArray[36]){ temp.setADC_AUDIT_TIME_6_TO_12_NO (String.valueOf(objectArray[36]));}
			if (null != objectArray[37]){ temp.setADC_AUDIT_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[37]));}
			if (null != objectArray[38]){ temp.setADC_INVESTIGATION_OPENING_NO (String.valueOf(objectArray[38]));}
			if (null != objectArray[39]){ temp.setADC_INVESTIGATION_OPENING_AMT (String.valueOf(objectArray[39]));}
			if (null != objectArray[40]){ temp.setADC_INVESTIGATION_RECEIPT_NO (String.valueOf(objectArray[40]));}
			if (null != objectArray[41]){ temp.setADC_INVESTIGATION_RECEIPT_AMT (String.valueOf(objectArray[41]));}
			if (null != objectArray[42]){ temp.setADC_INVESTIGATION_DISPOSAL_NO (String.valueOf(objectArray[42]));}
			if (null != objectArray[43]){ temp.setADC_INVESTIGATION_DISPOSAL_AMT (String.valueOf(objectArray[43]));}
			if (null != objectArray[44]){ temp.setADC_INVESTIGATION_OIO_NO (String.valueOf(objectArray[44]));}
			if (null != objectArray[45]){ temp.setADC_INVESTIGATION_OIO_AMT (String.valueOf(objectArray[45]));}
			if (null != objectArray[46]){ temp.setADC_INVESTIGATION_CLOSING_NO(String.valueOf(objectArray[46]));}
			if (null != objectArray[47]){ temp.setADC_INVESTIGATION_CLOSING_AMT(String.valueOf(objectArray[47]));}
			if (null != objectArray[48]){ temp.setADC_INVESTIGATION_AGE_LESS_3_NO (String.valueOf(objectArray[48]));}
			if (null != objectArray[49]){ temp.setADC_INVESTIGATION_AGE_3_TO_6_NO (String.valueOf(objectArray[49]));}
			if (null != objectArray[50]){ temp.setADC_INVESTIGATION_AGE_6_TO_12_NO (String.valueOf(objectArray[50]));}
			if (null != objectArray[51]){ temp.setADC_INVESTIGATION_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[51]));}
			if (null != objectArray[52]){ temp.setADC_INVESTIGATION_TIME_LESS_3_NO (String.valueOf(objectArray[52]));}
			if (null != objectArray[53]){ temp.setADC_INVESTIGATION_TIME_3_TO_6_NO (String.valueOf(objectArray[53]));}
			if (null != objectArray[54]){ temp.setADC_INVESTIGATION_TIME_6_TO_12_NO (String.valueOf(objectArray[54]));}
			if (null != objectArray[55]){ temp.setADC_INVESTIGATION_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[55]));}
			if (null != objectArray[56]){ temp.setADC_CALLBOOK_OPENING_NO (String.valueOf(objectArray[56]));}
			if (null != objectArray[57]){ temp.setADC_CALLBOOK_OPENING_AMT (String.valueOf(objectArray[57]));}
			if (null != objectArray[58]){ temp.setADC_CALLBOOK_RECEIPT_NO (String.valueOf(objectArray[58]));}
			if (null != objectArray[59]){ temp.setADC_CALLBOOK_RECEIPT_AMT (String.valueOf(objectArray[59]));}
			if (null != objectArray[60]){ temp.setADC_CALLBOOK_DISPOSAL_NO (String.valueOf(objectArray[60]));}
			if (null != objectArray[61]){ temp.setADC_CALLBOOK_DISPOSAL_AMT (String.valueOf(objectArray[61]));}
			if (null != objectArray[62]){ temp.setADC_CALLBOOK_OIO_NO (String.valueOf(objectArray[62]));}
			if (null != objectArray[63]){ temp.setADC_CALLBOOK_OIO_AMT (String.valueOf(objectArray[63]));}
			if (null != objectArray[64]){ temp.setADC_CALLBOOK_CLOSING_NO(String.valueOf(objectArray[64]));}
			if (null != objectArray[65]){ temp.setADC_CALLBOOK_CLOSING_AMT(String.valueOf(objectArray[65]));}
			if (null != objectArray[66]){ temp.setADC_CALLBOOK_AGE_LESS_3_NO (String.valueOf(objectArray[66]));}
			if (null != objectArray[67]){ temp.setADC_CALLBOOK_AGE_3_TO_6_NO (String.valueOf(objectArray[67]));}
			if (null != objectArray[68]){ temp.setADC_CALLBOOK_AGE_6_TO_12_NO (String.valueOf(objectArray[68]));}
			if (null != objectArray[69]){ temp.setADC_CALLBOOK_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[69]));}
			if (null != objectArray[70]){ temp.setADC_CALLBOOK_TIME_LESS_3_NO (String.valueOf(objectArray[70]));}
			if (null != objectArray[71]){ temp.setADC_CALLBOOK_TIME_3_TO_6_NO (String.valueOf(objectArray[71]));}
			if (null != objectArray[72]){ temp.setADC_CALLBOOK_TIME_6_TO_12_NO (String.valueOf(objectArray[72]));}
			if (null != objectArray[73]){ temp.setADC_CALLBOOK_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[73]));}
			if (null != objectArray[74]){ temp.setDC_COMMISSIONERATE_OPENING_NO (String.valueOf(objectArray[74]));}
			if (null != objectArray[75]){ temp.setDC_COMMISSIONERATE_OPENING_AMT (String.valueOf(objectArray[75]));}
			if (null != objectArray[76]){ temp.setDC_COMMISSIONERATE_RECEIPT_NO (String.valueOf(objectArray[76]));}
			if (null != objectArray[77]){ temp.setDC_COMMISSIONERATE_RECEIPT_AMT (String.valueOf(objectArray[77]));}
			if (null != objectArray[78]){ temp.setDC_COMMISSIONERATE_DISPOSAL_NO (String.valueOf(objectArray[78]));}
			if (null != objectArray[79]){ temp.setDC_COMMISSIONERATE_DISPOSAL_AMT (String.valueOf(objectArray[79]));}
			if (null != objectArray[80]){ temp.setDC_COMMISSIONERATE_OIO_NO (String.valueOf(objectArray[80]));}
			if (null != objectArray[81]){ temp.setDC_COMMISSIONERATE_OIO_AMT (String.valueOf(objectArray[81]));}
			if (null != objectArray[82]){ temp.setDC_COMM_CLOSING_NO(String.valueOf(objectArray[82]));}
			if (null != objectArray[83]){ temp.setDC_COMM_CLOSING_AMT(String.valueOf(objectArray[83]));}
			if (null != objectArray[84]){ temp.setDC_COMMISSIONERATE_AGE_LESS_3_NO (String.valueOf(objectArray[84]));}
			if (null != objectArray[85]){ temp.setDC_COMMISSIONERATE_AGE_3_TO_6_NO (String.valueOf(objectArray[85]));}
			if (null != objectArray[86]){ temp.setDC_COMMISSIONERATE_AGE_6_TO_12_NO (String.valueOf(objectArray[86]));}
			if (null != objectArray[87]){ temp.setDC_COMMISSIONERATE_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[87]));}
			if (null != objectArray[88]){ temp.setDC_COMMISSIONERATE_TIME_LESS_3_NO (String.valueOf(objectArray[88]));}
			if (null != objectArray[89]){ temp.setDC_COMMISSIONERATE_TIME_3_TO_6_NO (String.valueOf(objectArray[89]));}
			if (null != objectArray[90]){ temp.setDC_COMMISSIONERATE_TIME_6_TO_12_NO (String.valueOf(objectArray[90]));}
			if (null != objectArray[91]){ temp.setDC_COMMISSIONERATE_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[91]));}
			if (null != objectArray[92]){ temp.setDC_AUDIT_OPENING_NO (String.valueOf(objectArray[92]));}
			if (null != objectArray[93]){ temp.setDC_AUDIT_OPENING_AMT (String.valueOf(objectArray[93]));}
			if (null != objectArray[94]){ temp.setDC_AUDIT_RECEIPT_NO (String.valueOf(objectArray[94]));}
			if (null != objectArray[95]){ temp.setDC_AUDIT_RECEIPT_AMT (String.valueOf(objectArray[95]));}
			if (null != objectArray[96]){ temp.setDC_AUDIT_DISPOSAL_NO (String.valueOf(objectArray[96]));}
			if (null != objectArray[97]){ temp.setDC_AUDIT_DISPOSAL_AMT (String.valueOf(objectArray[97]));}
			if (null != objectArray[98]){ temp.setDC_AUDIT_OIO_NO (String.valueOf(objectArray[98]));}
			if (null != objectArray[99]){ temp.setDC_AUDIT_OIO_AMT (String.valueOf(objectArray[99]));}
			if (null != objectArray[100]){ temp.setDC_AUDIT_CLOSING_NO(String.valueOf(objectArray[100]));}
			if (null != objectArray[101]){ temp.setDC_AUDIT_CLOSING_AMT(String.valueOf(objectArray[101]));}
			if (null != objectArray[102]){ temp.setDC_AUDIT_AGE_LESS_3_NO (String.valueOf(objectArray[102]));}
			if (null != objectArray[103]){ temp.setDC_AUDIT_AGE_3_TO_6_NO (String.valueOf(objectArray[103]));}
			if (null != objectArray[104]){ temp.setDC_AUDIT_AGE_6_TO_12_NO (String.valueOf(objectArray[104]));}
			if (null != objectArray[105]){ temp.setDC_AUDIT_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[105]));}
			if (null != objectArray[106]){ temp.setDC_AUDIT_TIME_LESS_3_NO (String.valueOf(objectArray[106]));}
			if (null != objectArray[107]){ temp.setDC_AUDIT_TIME_3_TO_6_NO (String.valueOf(objectArray[107]));}
			if (null != objectArray[108]){ temp.setDC_AUDIT_TIME_6_TO_12_NO (String.valueOf(objectArray[108]));}
			if (null != objectArray[109]){ temp.setDC_AUDIT_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[109]));}
			if (null != objectArray[110]){ temp.setDC_INVESTIGATION_OPENING_NO (String.valueOf(objectArray[110]));}
			if (null != objectArray[111]){ temp.setDC_INVESTIGATION_OPENING_AMT (String.valueOf(objectArray[111]));}
			if (null != objectArray[112]){ temp.setDC_INVESTIGATION_RECEIPT_NO (String.valueOf(objectArray[112]));}
			if (null != objectArray[113]){ temp.setDC_INVESTIGATION_RECEIPT_AMT (String.valueOf(objectArray[113]));}
			if (null != objectArray[114]){ temp.setDC_INVESTIGATION_DISPOSAL_NO (String.valueOf(objectArray[114]));}
			if (null != objectArray[115]){ temp.setDC_INVESTIGATION_DISPOSAL_AMT (String.valueOf(objectArray[115]));}
			if (null != objectArray[116]){ temp.setDC_INVESTIGATION_OIO_NO (String.valueOf(objectArray[116]));}
			if (null != objectArray[117]){ temp.setDC_INVESTIGATION_OIO_AMT (String.valueOf(objectArray[117]));}
			if (null != objectArray[118]){ temp.setDC_INVESTIGATION_CLOSING_NO(String.valueOf(objectArray[118]));}
			if (null != objectArray[119]){ temp.setDC_INVESTIGATION_CLOSING_AMT(String.valueOf(objectArray[119]));}
			if (null != objectArray[120]){ temp.setDC_INVESTIGATION_AGE_LESS_3_NO (String.valueOf(objectArray[120]));}
			if (null != objectArray[121]){ temp.setDC_INVESTIGATION_AGE_3_TO_6_NO (String.valueOf(objectArray[121]));}
			if (null != objectArray[122]){ temp.setDC_INVESTIGATION_AGE_6_TO_12_NO (String.valueOf(objectArray[122]));}
			if (null != objectArray[123]){ temp.setDC_INVESTIGATION_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[123]));}
			if (null != objectArray[124]){ temp.setDC_INVESTIGATION_TIME_LESS_3_NO (String.valueOf(objectArray[124]));}
			if (null != objectArray[125]){ temp.setDC_INVESTIGATION_TIME_3_TO_6_NO (String.valueOf(objectArray[125]));}
			if (null != objectArray[126]){ temp.setDC_INVESTIGATION_TIME_6_TO_12_NO (String.valueOf(objectArray[126]));}
			if (null != objectArray[127]){ temp.setDC_INVESTIGATION_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[127]));}
			if (null != objectArray[128]){ temp.setDC_CALLBOOK_OPENING_NO (String.valueOf(objectArray[128]));}
			if (null != objectArray[129]){ temp.setDC_CALLBOOK_OPENING_AMT (String.valueOf(objectArray[129]));}
			if (null != objectArray[130]){ temp.setDC_CALLBOOK_RECEIPT_NO (String.valueOf(objectArray[130]));}
			if (null != objectArray[131]){ temp.setDC_CALLBOOK_RECEIPT_AMT (String.valueOf(objectArray[131]));}
			if (null != objectArray[132]){ temp.setDC_CALLBOOK_DISPOSAL_NO (String.valueOf(objectArray[132]));}
			if (null != objectArray[133]){ temp.setDC_CALLBOOK_DISPOSAL_AMT (String.valueOf(objectArray[133]));}
			if (null != objectArray[134]){ temp.setDC_CALLBOOK_OIO_NO (String.valueOf(objectArray[134]));}
			if (null != objectArray[135]){ temp.setDC_CALLBOOK_OIO_AMT (String.valueOf(objectArray[135]));}
			if (null != objectArray[136]){ temp.setDC_CALLBOOK_CLOSING_NO(String.valueOf(objectArray[136]));}
			if (null != objectArray[137]){ temp.setDC_CALLBOOK_CLOSING_AMT(String.valueOf(objectArray[137]));}
			if (null != objectArray[138]){ temp.setDC_CALLBOOK_AGE_LESS_3_NO (String.valueOf(objectArray[138]));}
			if (null != objectArray[139]){ temp.setDC_CALLBOOK_AGE_3_TO_6_NO (String.valueOf(objectArray[139]));}
			if (null != objectArray[140]){ temp.setDC_CALLBOOK_AGE_6_TO_12_NO (String.valueOf(objectArray[140]));}
			if (null != objectArray[141]){ temp.setDC_CALLBOOK_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[141]));}
			if (null != objectArray[142]){ temp.setDC_CALLBOOK_TIME_LESS_3_NO (String.valueOf(objectArray[142]));}
			if (null != objectArray[143]){ temp.setDC_CALLBOOK_TIME_3_TO_6_NO (String.valueOf(objectArray[143]));}
			if (null != objectArray[144]){ temp.setDC_CALLBOOK_TIME_6_TO_12_NO (String.valueOf(objectArray[144]));}
			if (null != objectArray[145]){ temp.setDC_CALLBOOK_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[145]));}
			if (null != objectArray[146]){ temp.setSUPERINTENDENT_COMMISSIONERATE_OPENING_NO (String.valueOf(objectArray[146]));}
			if (null != objectArray[147]){ temp.setSUPERINTENDENT_COMMISSIONERATE_OPENING_AMT (String.valueOf(objectArray[147]));}
			if (null != objectArray[148]){ temp.setSUPERINTENDENT_COMMISSIONERATE_RECEIPT_NO (String.valueOf(objectArray[148]));}
			if (null != objectArray[149]){ temp.setSUPERINTENDENT_COMMISSIONERATE_RECEIPT_AMT (String.valueOf(objectArray[149]));}
			if (null != objectArray[150]){ temp.setSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_NO (String.valueOf(objectArray[150]));}
			if (null != objectArray[151]){ temp.setSUPERINTENDENT_COMMISSIONERATE_DISPOSAL_AMT (String.valueOf(objectArray[151]));}
			if (null != objectArray[152]){ temp.setSUPERINTENDENT_COMMISSIONERATE_OIO_NO (String.valueOf(objectArray[152]));}
			if (null != objectArray[153]){ temp.setSUPERINTENDENT_COMMISSIONERATE_OIO_AMT (String.valueOf(objectArray[153]));}
			if (null != objectArray[154]){ temp.setSUPERINTENDENT_COMM_CLOSING_NO(String.valueOf(objectArray[154]));}
			if (null != objectArray[155]){ temp.setSUPERINTENDENT_COMM_CLOSING_AMT(String.valueOf(objectArray[155]));}
			if (null != objectArray[156]){ temp.setSUPERINTENDENT_COMMISSIONERATE_AGE_LESS_3_NO (String.valueOf(objectArray[156]));}
			if (null != objectArray[157]){ temp.setSUPERINTENDENT_COMMISSIONERATE_AGE_3_TO_6_NO (String.valueOf(objectArray[157]));}
			if (null != objectArray[158]){ temp.setSUPERINTENDENT_COMMISSIONERATE_AGE_6_TO_12_NO (String.valueOf(objectArray[158]));}
			if (null != objectArray[159]){ temp.setSUPERINTENDENT_COMMISSIONERATE_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[159]));}
			if (null != objectArray[160]){ temp.setSUPERINTENDENT_COMMISSIONERATE_TIME_LESS_3_NO (String.valueOf(objectArray[160]));}
			if (null != objectArray[161]){ temp.setSUPERINTENDENT_COMMISSIONERATE_TIME_3_TO_6_NO (String.valueOf(objectArray[161]));}
			if (null != objectArray[162]){ temp.setSUPERINTENDENT_COMMISSIONERATE_TIME_6_TO_12_NO (String.valueOf(objectArray[162]));}
			if (null != objectArray[163]){ temp.setSUPERINTENDENT_COMMISSIONERATE_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[163]));}
			if (null != objectArray[164]){ temp.setSUPERINTENDENT_AUDIT_OPENING_NO (String.valueOf(objectArray[164]));}
			if (null != objectArray[165]){ temp.setSUPERINTENDENT_AUDIT_OPENING_AMT (String.valueOf(objectArray[165]));}
			if (null != objectArray[166]){ temp.setSUPERINTENDENT_AUDIT_RECEIPT_NO (String.valueOf(objectArray[166]));}
			if (null != objectArray[167]){ temp.setSUPERINTENDENT_AUDIT_RECEIPT_AMT (String.valueOf(objectArray[167]));}
			if (null != objectArray[168]){ temp.setSUPERINTENDENT_AUDIT_DISPOSAL_NO (String.valueOf(objectArray[168]));}
			if (null != objectArray[169]){ temp.setSUPERINTENDENT_AUDIT_DISPOSAL_AMT (String.valueOf(objectArray[169]));}
			if (null != objectArray[170]){ temp.setSUPERINTENDENT_AUDIT_OIO_NO (String.valueOf(objectArray[170]));}
			if (null != objectArray[171]){ temp.setSUPERINTENDENT_AUDIT_OIO_AMT (String.valueOf(objectArray[171]));}
			if (null != objectArray[172]){ temp.setSUPERINTENDENT_AUDIT_CLOSING_NO(String.valueOf(objectArray[172]));}
			if (null != objectArray[173]){ temp.setSUPERINTENDENT_AUDIT_CLOSING_AMT(String.valueOf(objectArray[173]));}
			if (null != objectArray[174]){ temp.setSUPERINTENDENT_AUDIT_AGE_LESS_3_NO (String.valueOf(objectArray[174]));}
			if (null != objectArray[175]){ temp.setSUPERINTENDENT_AUDIT_AGE_3_TO_6_NO (String.valueOf(objectArray[175]));}
			if (null != objectArray[176]){ temp.setSUPERINTENDENT_AUDIT_AGE_6_TO_12_NO (String.valueOf(objectArray[176]));}
			if (null != objectArray[177]){ temp.setSUPERINTENDENT_AUDIT_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[177]));}
			if (null != objectArray[178]){ temp.setSUPERINTENDENT_AUDIT_TIME_LESS_3_NO (String.valueOf(objectArray[178]));}
			if (null != objectArray[179]){ temp.setSUPERINTENDENT_AUDIT_TIME_3_TO_6_NO (String.valueOf(objectArray[179]));}
			if (null != objectArray[180]){ temp.setSUPERINTENDENT_AUDIT_TIME_6_TO_12_NO (String.valueOf(objectArray[180]));}
			if (null != objectArray[181]){ temp.setSUPERINTENDENT_AUDIT_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[181]));}
			if (null != objectArray[182]){ temp.setSUPERINTENDENT_INVESTIGATION_OPENING_NO (String.valueOf(objectArray[182]));}
			if (null != objectArray[183]){ temp.setSUPERINTENDENT_INVESTIGATION_OPENING_AMT (String.valueOf(objectArray[183]));}
			if (null != objectArray[184]){ temp.setSUPERINTENDENT_INVESTIGATION_RECEIPT_NO (String.valueOf(objectArray[184]));}
			if (null != objectArray[185]){ temp.setSUPERINTENDENT_INVESTIGATION_RECEIPT_AMT (String.valueOf(objectArray[185]));}
			if (null != objectArray[186]){ temp.setSUPERINTENDENT_INVESTIGATION_DISPOSAL_NO (String.valueOf(objectArray[186]));}
			if (null != objectArray[187]){ temp.setSUPERINTENDENT_INVESTIGATION_DISPOSAL_AMT (String.valueOf(objectArray[187]));}
			if (null != objectArray[188]){ temp.setSUPERINTENDENT_INVESTIGATION_OIO_NO (String.valueOf(objectArray[188]));}
			if (null != objectArray[189]){ temp.setSUPERINTENDENT_INVESTIGATION_OIO_AMT (String.valueOf(objectArray[189]));}
			if (null != objectArray[190]){ temp.setSUPERINTENDENT_INVESTIGATION_CLOSING_NO(String.valueOf(objectArray[190]));}
			if (null != objectArray[191]){ temp.setSUPERINTENDENT_INVESTIGATION_CLOSING_AMT(String.valueOf(objectArray[191]));}
			if (null != objectArray[192]){ temp.setSUPERINTENDENT_INVESTIGATION_AGE_LESS_3_NO (String.valueOf(objectArray[192]));}
			if (null != objectArray[193]){ temp.setSUPERINTENDENT_INVESTIGATION_AGE_3_TO_6_NO (String.valueOf(objectArray[193]));}
			if (null != objectArray[194]){ temp.setSUPERINTENDENT_INVESTIGATION_AGE_6_TO_12_NO (String.valueOf(objectArray[194]));}
			if (null != objectArray[195]){ temp.setSUPERINTENDENT_INVESTIGATION_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[195]));}
			if (null != objectArray[196]){ temp.setSUPERINTENDENT_INVESTIGATION_TIME_LESS_3_NO (String.valueOf(objectArray[196]));}
			if (null != objectArray[197]){ temp.setSUPERINTENDENT_INVESTIGATION_TIME_3_TO_6_NO (String.valueOf(objectArray[197]));}
			if (null != objectArray[198]){ temp.setSUPERINTENDENT_INVESTIGATION_TIME_6_TO_12_NO (String.valueOf(objectArray[198]));}
			if (null != objectArray[199]){ temp.setSUPERINTENDENT_INVESTIGATION_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[199]));}
			if (null != objectArray[200]){ temp.setSUPERINTENDENT_CALLBOOK_OPENING_NO (String.valueOf(objectArray[200]));}
			if (null != objectArray[201]){ temp.setSUPERINTENDENT_CALLBOOK_OPENING_AMT (String.valueOf(objectArray[201]));}
			if (null != objectArray[202]){ temp.setSUPERINTENDENT_CALLBOOK_RECEIPT_NO (String.valueOf(objectArray[202]));}
			if (null != objectArray[203]){ temp.setSUPERINTENDENT_CALLBOOK_RECEIPT_AMT (String.valueOf(objectArray[203]));}
			if (null != objectArray[204]){ temp.setSUPERINTENDENT_CALLBOOK_DISPOSAL_NO (String.valueOf(objectArray[204]));}
			if (null != objectArray[205]){ temp.setSUPERINTENDENT_CALLBOOK_DISPOSAL_AMT (String.valueOf(objectArray[205]));}
			if (null != objectArray[206]){ temp.setSUPERINTENDENT_CALLBOOK_OIO_NO (String.valueOf(objectArray[206]));}
			if (null != objectArray[207]){ temp.setSUPERINTENDENT_CALLBOOK_OIO_AMT (String.valueOf(objectArray[207]));}
			if (null != objectArray[208]){ temp.setSUPERINTENDENT_CALLBOOK_CLOSING_NO(String.valueOf(objectArray[208]));}
			if (null != objectArray[209]){ temp.setSUPERINTENDENT_CALLBOOK_CLOSING_AMT(String.valueOf(objectArray[209]));}
			if (null != objectArray[210]){ temp.setSUPERINTENDENT_CALLBOOK_AGE_LESS_3_NO (String.valueOf(objectArray[210]));}
			if (null != objectArray[211]){ temp.setSUPERINTENDENT_CALLBOOK_AGE_3_TO_6_NO (String.valueOf(objectArray[211]));}
			if (null != objectArray[212]){ temp.setSUPERINTENDENT_CALLBOOK_AGE_6_TO_12_NO (String.valueOf(objectArray[212]));}
			if (null != objectArray[213]){ temp.setSUPERINTENDENT_CALLBOOK_AGE_MORE_THAN_1_NO (String.valueOf(objectArray[213]));}
			if (null != objectArray[214]){ temp.setSUPERINTENDENT_CALLBOOK_TIME_LESS_3_NO (String.valueOf(objectArray[214]));}
			if (null != objectArray[215]){ temp.setSUPERINTENDENT_CALLBOOK_TIME_3_TO_6_NO (String.valueOf(objectArray[215]));}
			if (null != objectArray[216]){ temp.setSUPERINTENDENT_CALLBOOK_TIME_6_TO_12_NO (String.valueOf(objectArray[216]));}
			if (null != objectArray[217]){ temp.setSUPERINTENDENT_CALLBOOK_TIME_MORE_THAN_1_NO (String.valueOf(objectArray[217]));}

			
				
   return temp;
	
	 }
	
	
	
	
	
	
	

}
