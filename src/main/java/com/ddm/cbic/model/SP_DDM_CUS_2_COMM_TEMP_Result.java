package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.*;
import javax.validation.constraints.Digits;


public  class SP_DDM_CUS_2_COMM_TEMP_Result
{

	String COMM_CODE;
	Date MM_YYYY;
	
BigDecimal AIR_EDI_CUS;
	
BigDecimal AIR_EDI_CEX;
BigDecimal AIR_EDI_STX;
BigDecimal AIR_NEDI_CUS;
BigDecimal AIR_NEDI_CEX;
BigDecimal AIR_NEDI_STX;
BigDecimal BRAND_EDI_CUS;
BigDecimal BRAND_EDI_CEX;
BigDecimal BRAND_EDI_STX;
BigDecimal BRAND_NEDI_CUS;
BigDecimal BRAND_NEDI_CEX;
BigDecimal BRAND_NEDI_STX;
BigDecimal S74_EDI_CUS;
BigDecimal S74_EDI_CEX;
BigDecimal S74_EDI_STX;
BigDecimal S74_NEDI_CUS;
BigDecimal S74_NEDI_CEX;
BigDecimal S74_NEDI_STX;

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

public BigDecimal getAIR_EDI_CEX()
{
return AIR_EDI_CEX;
}
public void setAIR_EDI_CEX(BigDecimal aIR_EDI_CEX)
{
AIR_EDI_CEX = aIR_EDI_CEX;
}
public BigDecimal getAIR_EDI_CUS()
{
return AIR_EDI_CUS;
}
public void setAIR_EDI_CUS(BigDecimal aIR_EDI_CUS)
{
AIR_EDI_CUS = aIR_EDI_CUS;
}
public BigDecimal getAIR_EDI_STX()
{
return AIR_EDI_STX;
}
public void setAIR_EDI_STX(BigDecimal aIR_EDI_STX)
{
AIR_EDI_STX = aIR_EDI_STX;
}
public BigDecimal getAIR_NEDI_CEX()
{
return AIR_NEDI_CEX;
}
public void setAIR_NEDI_CEX(BigDecimal aIR_NEDI_CEX)
{
AIR_NEDI_CEX = aIR_NEDI_CEX;
}
public BigDecimal getAIR_NEDI_CUS()
{
return AIR_NEDI_CUS;
}
public void setAIR_NEDI_CUS(BigDecimal aIR_NEDI_CUS)
{
AIR_NEDI_CUS = aIR_NEDI_CUS;
}
public BigDecimal getAIR_NEDI_STX()
{
return AIR_NEDI_STX;
}
public void setAIR_NEDI_STX(BigDecimal aIR_NEDI_STX)
{
AIR_NEDI_STX = aIR_NEDI_STX;
}
public BigDecimal getBRAND_EDI_CEX()
{
return BRAND_EDI_CEX;
}
public void setBRAND_EDI_CEX(BigDecimal bRAND_EDI_CEX)
{
BRAND_EDI_CEX = bRAND_EDI_CEX;
}
public BigDecimal getBRAND_EDI_CUS()
{
return BRAND_EDI_CUS;
}
public void setBRAND_EDI_CUS(BigDecimal bRAND_EDI_CUS)
{
BRAND_EDI_CUS = bRAND_EDI_CUS;
}
public BigDecimal getBRAND_EDI_STX()
{
return BRAND_EDI_STX;
}
public void setBRAND_EDI_STX(BigDecimal bRAND_EDI_STX)
{
BRAND_EDI_STX = bRAND_EDI_STX;
}
public BigDecimal getBRAND_NEDI_CEX()
{
return BRAND_NEDI_CEX;
}
public void setBRAND_NEDI_CEX(BigDecimal bRAND_NEDI_CEX)
{
BRAND_NEDI_CEX = bRAND_NEDI_CEX;
}
public BigDecimal getBRAND_NEDI_CUS()
{
return BRAND_NEDI_CUS;
}
public void setBRAND_NEDI_CUS(BigDecimal bRAND_NEDI_CUS)
{
BRAND_NEDI_CUS = bRAND_NEDI_CUS;
}
public BigDecimal getBRAND_NEDI_STX()
{
return BRAND_NEDI_STX;
}
public void setBRAND_NEDI_STX(BigDecimal bRAND_NEDI_STX)
{
BRAND_NEDI_STX = bRAND_NEDI_STX;
}
public BigDecimal getS74_EDI_CEX()
{
return S74_EDI_CEX;
}
public void setS74_EDI_CEX(BigDecimal s74_EDI_CEX)
{
S74_EDI_CEX = s74_EDI_CEX;
}
public BigDecimal getS74_EDI_CUS()
{
return S74_EDI_CUS;
}
public void setS74_EDI_CUS(BigDecimal s74_EDI_CUS)
{
S74_EDI_CUS = s74_EDI_CUS;
}
public BigDecimal getS74_EDI_STX()
{
return S74_EDI_STX;
}
public void setS74_EDI_STX(BigDecimal s74_EDI_STX)
{
S74_EDI_STX = s74_EDI_STX;
}
public BigDecimal getS74_NEDI_CEX()
{
return S74_NEDI_CEX;
}
public void setS74_NEDI_CEX(BigDecimal s74_NEDI_CEX)
{
S74_NEDI_CEX = s74_NEDI_CEX;
}
public BigDecimal getS74_NEDI_CUS()
{
return S74_NEDI_CUS;
}
public void setS74_NEDI_CUS(BigDecimal s74_NEDI_CUS)
{
S74_NEDI_CUS = s74_NEDI_CUS;
}
public BigDecimal getS74_NEDI_STX()
{
return S74_NEDI_STX;
}
public void setS74_NEDI_STX(BigDecimal s74_NEDI_STX)
{
S74_NEDI_STX = s74_NEDI_STX;
}



@Override
public String toString() {
	return "SP_DDM_CUS_2_COMM_TEMP_Result [COMM_CODE=" + COMM_CODE + ", MM_YYYY=" + MM_YYYY + ", AIR_EDI_CUS="
			+ AIR_EDI_CUS + ", AIR_EDI_CEX=" + AIR_EDI_CEX + ", AIR_EDI_STX=" + AIR_EDI_STX + ", AIR_NEDI_CUS="
			+ AIR_NEDI_CUS + ", AIR_NEDI_CEX=" + AIR_NEDI_CEX + ", AIR_NEDI_STX=" + AIR_NEDI_STX + ", BRAND_EDI_CUS="
			+ BRAND_EDI_CUS + ", BRAND_EDI_CEX=" + BRAND_EDI_CEX + ", BRAND_EDI_STX=" + BRAND_EDI_STX
			+ ", BRAND_NEDI_CUS=" + BRAND_NEDI_CUS + ", BRAND_NEDI_CEX=" + BRAND_NEDI_CEX + ", BRAND_NEDI_STX="
			+ BRAND_NEDI_STX + ", S74_EDI_CUS=" + S74_EDI_CUS + ", S74_EDI_CEX=" + S74_EDI_CEX + ", S74_EDI_STX="
			+ S74_EDI_STX + ", S74_NEDI_CEX=" + S74_NEDI_CEX + ", S74_NEDI_CUS=" + S74_NEDI_CUS + ", S74_NEDI_STX="
			+ S74_NEDI_STX + "]";
}
public List<SP_DDM_CUS_2_COMM_TEMP_Result> generateResultList_SP_DDM_CUS_2_COMM_TEMP(List<Object[]> listObjectArray){
List <SP_DDM_CUS_2_COMM_TEMP_Result> list = new ArrayList<SP_DDM_CUS_2_COMM_TEMP_Result>();
for(Object[] objArray : listObjectArray) {
SP_DDM_CUS_2_COMM_TEMP_Result temp = new SP_DDM_CUS_2_COMM_TEMP_Result();

list.add(temp);
}
return list;
}


public SP_DDM_CUS_2_COMM_TEMP_Result generateResultBeanSP_DDM_CUS_2_COMM_TEMP(Object[] objectArray)
{
	
SP_DDM_CUS_2_COMM_TEMP_Result temp = new SP_DDM_CUS_2_COMM_TEMP_Result();

temp.setCOMM_CODE((String)(objectArray[0]));
temp.setMM_YYYY((Date)(objectArray[1]));
temp.setAIR_EDI_CUS((BigDecimal)(objectArray[2]));
temp.setAIR_EDI_CEX((BigDecimal)(objectArray[3]));
temp.setAIR_EDI_STX((BigDecimal)(objectArray[4]));
temp.setAIR_NEDI_CUS((BigDecimal)(objectArray[5]));
temp.setAIR_NEDI_CEX((BigDecimal)(objectArray[6]));
temp.setAIR_NEDI_STX((BigDecimal)(objectArray[7]));
temp.setBRAND_EDI_CUS((BigDecimal)(objectArray[8]));
temp.setBRAND_EDI_CEX((BigDecimal)(objectArray[9]));
temp.setBRAND_EDI_STX((BigDecimal)(objectArray[10]));
temp.setBRAND_NEDI_CUS((BigDecimal)(objectArray[11]));
temp.setBRAND_NEDI_CEX((BigDecimal)(objectArray[12]));
temp.setBRAND_NEDI_STX((BigDecimal)(objectArray[13]));
temp.setS74_EDI_CUS((BigDecimal)(objectArray[14]));
temp.setS74_EDI_CEX((BigDecimal)(objectArray[15]));
temp.setS74_EDI_STX((BigDecimal)(objectArray[16]));
temp.setS74_NEDI_CUS((BigDecimal)(objectArray[17]));
temp.setS74_NEDI_CEX((BigDecimal)(objectArray[18]));
temp.setS74_NEDI_STX((BigDecimal)(objectArray[19]));
return temp;
}


}
