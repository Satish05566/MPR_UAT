package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.*;
import javax.validation.constraints.Digits;


public  class SP_DDM_CUS_5_COMM_TEMP_Result
{


String COMM_CODE;
Date MM_YYYY;
@Digits(message="Must be numeric", fraction = 2, integer = 15)
BigDecimal AUDIT;
@Digits(message="Must be numeric", fraction = 2, integer = 15)
BigDecimal ANIT_SMG;
@Digits(message="Must be numeric", fraction = 2, integer = 15)
BigDecimal RCD;
@Digits(message="Must be numeric", fraction = 2, integer = 15)
BigDecimal PRE_DEPOSITS;
@Digits(message="Must be numeric", fraction = 2, integer = 15)
BigDecimal RFD;
@Digits(message="Must be numeric", fraction = 2, integer = 15)
BigDecimal VALUE_LOAD;
@Digits(message="Must be numeric", fraction = 2, integer = 15)
BigDecimal FINAL_PA;
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


public BigDecimal getANIT_SMG() {
	return ANIT_SMG;
}


public void setANIT_SMG(BigDecimal aNIT_SMG) {
	ANIT_SMG = aNIT_SMG;
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


public BigDecimal getRFD() {
	return RFD;
}


public void setRFD(BigDecimal rFD) {
	RFD = rFD;
}


public BigDecimal getVALUE_LOAD() {
	return VALUE_LOAD;
}


public void setVALUE_LOAD(BigDecimal vALUE_LOAD) {
	VALUE_LOAD = vALUE_LOAD;
}


public BigDecimal getFINAL_PA() {
	return FINAL_PA;
}


public void setFINAL_PA(BigDecimal fINAL_PA) {
	FINAL_PA = fINAL_PA;
}


public BigDecimal getOTHERS() {
	return OTHERS;
}


public void setOTHERS(BigDecimal oTHERS) {
	OTHERS = oTHERS;
}


public List<SP_DDM_CUS_5_COMM_TEMP_Result> generateResultList_SP_DDM_CUS_5_COMM_TEMP(List<Object[]> listObjectArray){
List <SP_DDM_CUS_5_COMM_TEMP_Result> list = new ArrayList<SP_DDM_CUS_5_COMM_TEMP_Result>();
for(Object[] objArray : listObjectArray) {
SP_DDM_CUS_5_COMM_TEMP_Result temp = new SP_DDM_CUS_5_COMM_TEMP_Result();
//temp = generateResultBean_SP_DDM_CUS_5_COMM_TEMP(objArray);
list.add(temp);
}
return list;
}


public SP_DDM_CUS_5_COMM_TEMP_Result generateResultBeanSP_DDM_CUS_5_COMM_TEMP(Object[] objectArray)
{
	//   COMM_CODE, MM_YYYY, AUDIT, ANIT_SMG, RCD, PRE_DEPOSITS, RFD, VALUE_LOAD, FINAL_PA, OTHERS
SP_DDM_CUS_5_COMM_TEMP_Result temp = new SP_DDM_CUS_5_COMM_TEMP_Result();
temp.setCOMM_CODE((String)(objectArray[0]));
temp.setMM_YYYY((Date)(objectArray[1]));
temp.setAUDIT((BigDecimal)(objectArray[2]));
temp.setANIT_SMG((BigDecimal)(objectArray[3]));
temp.setRCD((BigDecimal)(objectArray[4]));
temp.setPRE_DEPOSITS((BigDecimal)(objectArray[5]));
temp.setRFD((BigDecimal)(objectArray[6]));
temp.setVALUE_LOAD((BigDecimal)(objectArray[7]));
temp.setFINAL_PA((BigDecimal)(objectArray[8]));
temp.setOTHERS((BigDecimal)(objectArray[9]));

return temp;
}


}
