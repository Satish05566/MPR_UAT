package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.*;
import javax.validation.constraints.Digits;

public class SP_DDM_GST_1_COMM_TEMP_Result {
	
	String COMM_CODE;
	Date MM_YYYY;
	BigDecimal CENTRAL_MOVING_TARGET ;
	
	BigDecimal STATEUT_MOVING_TARGET  ;
	BigDecimal INTEGRATED_MOVING_TARGET  ;
	BigDecimal CESS_MOVING_TARGET  ;
	BigDecimal CENTRAL_GST_GROSS ;
	BigDecimal STATEUT_GST_GROSS ;
	BigDecimal INTEGRATED_GST_GROSS ;
	BigDecimal CESS_GST_GROSS;
	BigDecimal CENTRAL_GST_REFUND;
	BigDecimal STATEUT_GST_REFUND;
	BigDecimal INTEGRATED_GST_REFUND;
	BigDecimal CESS_GST_REFUND;

	public String getCOMM_CODE()
	{
	return COMM_CODE;
	}
	public void setCOMM_CODE(String cOMM_CODE)
	{
	COMM_CODE = cOMM_CODE;
	}
	public Date getMM_YYYY()
	{
	return MM_YYYY;
	}
	public void setMM_YYYY(Date mM_YYYY)
	{
	MM_YYYY = mM_YYYY;
	}

	public BigDecimal getCENTRAL_MOVING_TARGET()
	{
	return CENTRAL_MOVING_TARGET;
	}
	public void setCENTRAL_MOVING_TARGET(BigDecimal cENTRAL_MOVING_TARGET)
	{
		CENTRAL_MOVING_TARGET = cENTRAL_MOVING_TARGET;
	}
	public BigDecimal getSTATEUT_MOVING_TARGET()
	{
	return STATEUT_MOVING_TARGET;
	}
	public void setSTATEUT_MOVING_TARGET(BigDecimal sTATEUT_MOVING_TARGET)
	{
		STATEUT_MOVING_TARGET = sTATEUT_MOVING_TARGET;
	}
	public BigDecimal getINTEGRATED_MOVING_TARGET()
	{
	return INTEGRATED_MOVING_TARGET;
	}
	public void setINTEGRATED_MOVING_TARGET(BigDecimal iNTEGRATED_MOVING_TARGET)
	{
		INTEGRATED_MOVING_TARGET = iNTEGRATED_MOVING_TARGET;
	}

	public BigDecimal getCESS_MOVING_TARGET()
	{
	return CESS_MOVING_TARGET;
	}
	public void setCESS_MOVING_TARGET(BigDecimal cESS_MOVING_TARGET)
	{
		CESS_MOVING_TARGET = cESS_MOVING_TARGET;
	}
	public BigDecimal getCENTRAL_GST_GROSS()
	{
	return CENTRAL_GST_GROSS;
	}
	public void setCENTRAL_GST_GROSS(BigDecimal cENTRAL_GST_GROSS)
	{
		CENTRAL_GST_GROSS = cENTRAL_GST_GROSS;
	}
	public BigDecimal getSTATEUT_GST_GROSS()
	{
	return STATEUT_GST_GROSS;
	}
	public void setSTATEUT_GST_GROSS(BigDecimal sTATEUT_GST_GROSS)
	{
		STATEUT_GST_GROSS = sTATEUT_GST_GROSS;
	}
	public BigDecimal getINTEGRATED_GST_GROSS()
	{
	return INTEGRATED_GST_GROSS;
	}
	public void setINTEGRATED_GST_GROSS(BigDecimal iNTEGRATED_GST_GROSS)
	{
		INTEGRATED_GST_GROSS = iNTEGRATED_GST_GROSS;
	}

	public BigDecimal getCESS_GST_GROSS()
	{
	return CESS_GST_GROSS;
	}
	public void setCESS_GST_GROSS(BigDecimal cESS_GST_GROSS)
	{
		CESS_GST_GROSS = cESS_GST_GROSS;
	}

	public BigDecimal getCENTRAL_GST_REFUND()
	{
	return CENTRAL_GST_REFUND;
	}
	public void setCENTRAL_GST_REFUND(BigDecimal cENTRAL_GST_REFUND)
	{
		CENTRAL_GST_REFUND = cENTRAL_GST_REFUND;
	}
	public BigDecimal getSTATEUT_GST_REFUND()
	{
	return STATEUT_GST_REFUND;
	}
	public void setSTATEUT_GST_REFUND(BigDecimal sTATEUT_GST_REFUND)
	{
		STATEUT_GST_REFUND = sTATEUT_GST_REFUND;
	}
	public BigDecimal getINTEGRATED_GST_REFUND()
	{
	return INTEGRATED_GST_REFUND;
	}
	public void setINTEGRATED_GST_REFUND(BigDecimal iNTEGRATED_GST_REFUND)
	{
		INTEGRATED_GST_REFUND = iNTEGRATED_GST_REFUND;
	}

	public BigDecimal getCESS_GST_REFUND()
	{
	return CESS_GST_REFUND;
	}
	public void setCESS_GST_REFUND(BigDecimal cESS_GST_REFUND)
	{
		CESS_GST_REFUND = cESS_GST_REFUND;
	}

	public List<SP_DDM_GST_1_COMM_TEMP_Result> generateResultList_SP_DDM_GST_1_COMM_TEMP(List<Object[]> listObjectArray){
		List <SP_DDM_GST_1_COMM_TEMP_Result> list = new ArrayList<SP_DDM_GST_1_COMM_TEMP_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_GST_1_COMM_TEMP_Result temp = new SP_DDM_GST_1_COMM_TEMP_Result();

		list.add(temp);
		}
		return list;
		}
	public SP_DDM_GST_1_COMM_TEMP_Result generateResultBeanSP_DDM_GST_1_COMM_TEMP(Object[] objectArray)
	{
		
	SP_DDM_GST_1_COMM_TEMP_Result temp = new SP_DDM_GST_1_COMM_TEMP_Result();

	temp.setCOMM_CODE((String)(objectArray[0]));
	temp.setMM_YYYY((Date)(objectArray[1]));
	temp.setCENTRAL_MOVING_TARGET((BigDecimal)(objectArray[2]));
	temp.setSTATEUT_MOVING_TARGET((BigDecimal)(objectArray[3]));
	temp.setINTEGRATED_MOVING_TARGET((BigDecimal)(objectArray[4]));
	temp.setCESS_MOVING_TARGET((BigDecimal)(objectArray[5]));
	temp.setCENTRAL_GST_GROSS((BigDecimal)(objectArray[6]));
	temp.setSTATEUT_GST_GROSS((BigDecimal)(objectArray[7]));
	temp.setINTEGRATED_GST_GROSS((BigDecimal)(objectArray[8]));
	temp.setCESS_GST_GROSS((BigDecimal)(objectArray[9]));
	temp.setCENTRAL_GST_REFUND((BigDecimal)(objectArray[10]));
	temp.setSTATEUT_GST_REFUND((BigDecimal)(objectArray[11]));
	temp.setINTEGRATED_GST_REFUND((BigDecimal)(objectArray[12]));
	temp.setCESS_GST_REFUND((BigDecimal)(objectArray[13]));

	return temp;
	}



}
