package com.ddm.cbic.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public  class SP_DDM_CUS_6_COMM_TEMP_REPORT_Result
{


	BigDecimal ACTUAL_FOR;
	BigDecimal ACTUAL_FOR_C;
	BigDecimal ACTUAL_FOR_P;
	BigDecimal ACTUAL_UPTO_ACTUAL;
	BigDecimal ACTUAL_UPTO_C;
	BigDecimal ACTUAL_UPTO_P;
	BigDecimal ACTUAL_UPTO_PER;
int AMND;
String COMM_CODE;
String COMMODITY_GROUP;
int COMPLETE_COMM;
String S_NO;
String TOTAL_COMM;


public BigDecimal getACTUAL_FOR()
{
return ACTUAL_FOR;
}
public void setACTUAL_FOR(BigDecimal aCTUAL_FOR)
{
ACTUAL_FOR = aCTUAL_FOR;
}
public BigDecimal getACTUAL_FOR_C()
{
return ACTUAL_FOR_C;
}
public void setACTUAL_FOR_C(BigDecimal aCTUAL_FOR_C)
{
ACTUAL_FOR_C = aCTUAL_FOR_C;
}
public BigDecimal getACTUAL_FOR_P()
{
return ACTUAL_FOR_P;
}
public void setACTUAL_FOR_P(BigDecimal aCTUAL_FOR_P)
{
ACTUAL_FOR_P = aCTUAL_FOR_P;
}
public BigDecimal getACTUAL_UPTO_ACTUAL()
{
return ACTUAL_UPTO_ACTUAL;
}
public void setACTUAL_UPTO_ACTUAL(BigDecimal aCTUAL_UPTO_ACTUAL)
{
ACTUAL_UPTO_ACTUAL = aCTUAL_UPTO_ACTUAL;
}
public BigDecimal getACTUAL_UPTO_C()
{
return ACTUAL_UPTO_C;
}
public void setACTUAL_UPTO_C(BigDecimal aCTUAL_UPTO_C)
{
ACTUAL_UPTO_C = aCTUAL_UPTO_C;
}
public BigDecimal getACTUAL_UPTO_P()
{
return ACTUAL_UPTO_P;
}
public void setACTUAL_UPTO_P(BigDecimal aCTUAL_UPTO_P)
{
ACTUAL_UPTO_P = aCTUAL_UPTO_P;
}
public BigDecimal getACTUAL_UPTO_PER()
{
return ACTUAL_UPTO_PER;
}
public void setACTUAL_UPTO_PER(BigDecimal aCTUAL_UPTO_PER)
{
ACTUAL_UPTO_PER = aCTUAL_UPTO_PER;
}
public int getAMND()
{
return AMND;
}
public void setAMND(int aMND)
{
AMND = aMND;
}
public String getCOMM_CODE()
{
return COMM_CODE;
}
public void setCOMM_CODE(String cOMM_CODE)
{
COMM_CODE = cOMM_CODE;
}
public String getCOMMODITY_GROUP()
{
return COMMODITY_GROUP;
}
public void setCOMMODITY_GROUP(String cOMMODITY_GROUP)
{
COMMODITY_GROUP = cOMMODITY_GROUP;
}
public int getCOMPLETE_COMM()
{
return COMPLETE_COMM;
}
public void setCOMPLETE_COMM(int cOMPLETE_COMM)
{
COMPLETE_COMM = cOMPLETE_COMM;
}
public String getS_NO()
{
return S_NO;
}
public void setS_NO(String s_NO)
{
S_NO = s_NO;
}
public String getTOTAL_COMM()
{
return TOTAL_COMM;
}
public void setTOTAL_COMM(String tOTAL_COMM)
{
TOTAL_COMM = tOTAL_COMM;
}


public List<SP_DDM_CUS_6_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CUS_6_COMM_TEMP_REPORT(List<Object[]> listObjectArray){
List <SP_DDM_CUS_6_COMM_TEMP_REPORT_Result> list = new ArrayList<SP_DDM_CUS_6_COMM_TEMP_REPORT_Result>();
for(Object[] objArray : listObjectArray) {
SP_DDM_CUS_6_COMM_TEMP_REPORT_Result temp = new SP_DDM_CUS_6_COMM_TEMP_REPORT_Result();
temp = generateResultBean(objArray);
list.add(temp);
}
return list;
}


public SP_DDM_CUS_6_COMM_TEMP_REPORT_Result generateResultBean(Object[] objectArray)
{
SP_DDM_CUS_6_COMM_TEMP_REPORT_Result temp = new SP_DDM_CUS_6_COMM_TEMP_REPORT_Result();


temp.setACTUAL_FOR((BigDecimal)(objectArray[0]));
temp.setACTUAL_FOR_C((BigDecimal)(objectArray[1]));
temp.setACTUAL_FOR_P((BigDecimal)(objectArray[2]));
temp.setACTUAL_UPTO_ACTUAL((BigDecimal)(objectArray[3]));
temp.setACTUAL_UPTO_C((BigDecimal)(objectArray[4]));
temp.setACTUAL_UPTO_P((BigDecimal)(objectArray[5]));
temp.setACTUAL_UPTO_PER((BigDecimal)(objectArray[6]));
temp.setAMND((int)(objectArray[7]));
temp.setCOMM_CODE((String)(objectArray[8]));
temp.setCOMMODITY_GROUP((String)(objectArray[9]));
temp.setCOMPLETE_COMM((int)(objectArray[10]));
temp.setS_NO((String)(objectArray[11]));
temp.setTOTAL_COMM((String)(objectArray[12]));
return temp;
}


}
