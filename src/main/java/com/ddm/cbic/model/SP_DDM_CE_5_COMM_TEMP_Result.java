package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.*;
import javax.validation.constraints.Digits;


public  class SP_DDM_CE_5_COMM_TEMP_Result
{

	String COMM_CODE;
    Date MM_YYYY;
    @Digits(message="Must be numeric", fraction = 2, integer = 15)
    BigDecimal AUDIT;
    @Digits(message="Must be numeric", fraction = 2, integer = 15)
    BigDecimal AER;
    @Digits(message="Must be numeric", fraction = 2, integer = 15)
    BigDecimal RCD ;
    @Digits(message="Must be numeric", fraction = 2, integer = 15)
    BigDecimal PRE_DEPOSITS;
    @Digits(message="Must be numeric", fraction = 2, integer = 15)
    BigDecimal BY_SR;
    @Digits(message="Must be numeric", fraction = 2, integer = 15)
    BigDecimal RFD ;
    @Digits(message="Must be numeric", fraction = 2, integer = 15)
    BigDecimal FPA ;
    @Digits(message="Must be numeric", fraction = 2, integer = 15)
    BigDecimal OTHERS;
	



public String getCOMM_CODE() {
		return COMM_CODE;
	}


	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}


	public Date getMM_YYYY() {
		return MM_YYYY;
	}


	public void setMM_YYYY(Date mM_YYYY) {
		MM_YYYY = mM_YYYY;
	}


	public BigDecimal getAUDIT() {
		return AUDIT;
	}


	public void setAUDIT(BigDecimal aUDIT) {
		AUDIT = aUDIT;
	}


	public BigDecimal getAER() {
		return AER;
	}


	public void setAER(BigDecimal aER) {
		AER = aER;
	}


	public BigDecimal getRCD() {
		return RCD;
	}


	public void setRCD(BigDecimal rCD) {
		RCD = rCD;
	}


	public BigDecimal getPRE_DEPOSITS() {
		return PRE_DEPOSITS;
	}


	public void setPRE_DEPOSITS(BigDecimal pRE_DEPOSITS) {
		PRE_DEPOSITS = pRE_DEPOSITS;
	}


	public BigDecimal getBY_SR() {
		return BY_SR;
	}


	public void setBY_SR(BigDecimal bY_SR) {
		BY_SR = bY_SR;
	}


	public BigDecimal getRFD() {
		return RFD;
	}


	public void setRFD(BigDecimal rFD) {
		RFD = rFD;
	}


	public BigDecimal getFPA() {
		return FPA;
	}


	public void setFPA(BigDecimal fPA) {
		FPA = fPA;
	}


	public BigDecimal getOTHERS() {
		return OTHERS;
	}


	public void setOTHERS(BigDecimal oTHERS) {
		OTHERS = oTHERS;
	}


public List<SP_DDM_CE_5_COMM_TEMP_Result> generateResultList_SP_DDM_CEX_5_COMM_TEMP(List<Object[]> listObjectArray){
List <SP_DDM_CE_5_COMM_TEMP_Result> list = new ArrayList<SP_DDM_CE_5_COMM_TEMP_Result>();
for(Object[] objArray : listObjectArray) {
SP_DDM_CE_5_COMM_TEMP_Result temp = new SP_DDM_CE_5_COMM_TEMP_Result();
temp = generateResultBeanSP_DDM_CEX_5_COMM_TEMP(objArray);
list.add(temp);
}
return list;
}


public SP_DDM_CE_5_COMM_TEMP_Result generateResultBeanSP_DDM_CEX_5_COMM_TEMP(Object[] objectArray)
{

SP_DDM_CE_5_COMM_TEMP_Result temp = new SP_DDM_CE_5_COMM_TEMP_Result();
temp.setCOMM_CODE((String)(objectArray[0]));
temp.setMM_YYYY((Date)(objectArray[1]));
temp.setAUDIT((BigDecimal)(objectArray[2]));
temp.setAER((BigDecimal)(objectArray[3]));
temp.setRCD ((BigDecimal)(objectArray[4]));
temp.setPRE_DEPOSITS((BigDecimal)(objectArray[5]));
temp.setBY_SR((BigDecimal)(objectArray[6]));
temp.setRFD ((BigDecimal)(objectArray[7]));
temp.setFPA ((BigDecimal)(objectArray[8]));
temp.setOTHERS((BigDecimal)(objectArray[9]));

return temp;
}


}
