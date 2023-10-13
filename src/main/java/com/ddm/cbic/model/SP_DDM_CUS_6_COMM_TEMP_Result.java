package com.ddm.cbic.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public  class SP_DDM_CUS_6_COMM_TEMP_Result
{


	BigDecimal ACTUAL_FOR;
String COMM_CODE;
String COMMODITY;
BigDecimal COMMODITY_CODE;
String COMMODITY_GROUP;
Date MM_YYYY;


public BigDecimal getACTUAL_FOR()
{
return ACTUAL_FOR;
}
public void setACTUAL_FOR(BigDecimal aCTUAL_FOR)
{
ACTUAL_FOR = aCTUAL_FOR;
}
public String getCOMM_CODE()
{
return COMM_CODE;
}
public void setCOMM_CODE(String cOMM_CODE)
{
COMM_CODE = cOMM_CODE;
}
public String getCOMMODITY()
{
return COMMODITY;
}
public void setCOMMODITY(String cOMMODITY)
{
COMMODITY = cOMMODITY;
}
public BigDecimal getCOMMODITY_CODE()
{
return COMMODITY_CODE;
}
public void setCOMMODITY_CODE(BigDecimal cOMMODITY_CODE)
{
COMMODITY_CODE = cOMMODITY_CODE;
}
public String getCOMMODITY_GROUP()
{
return COMMODITY_GROUP;
}
public void setCOMMODITY_GROUP(String cOMMODITY_GROUP)
{
COMMODITY_GROUP = cOMMODITY_GROUP;
}
public Date getMM_YYYY()
{
return MM_YYYY;
}
public void setMM_YYYY(Date mM_YYYY)
{
MM_YYYY = mM_YYYY;
}


public List<SP_DDM_CUS_6_COMM_TEMP_Result> generateResultList_SP_DDM_CUS_6_COMM_TEMP(List<Object[]> listObjectArray){
List <SP_DDM_CUS_6_COMM_TEMP_Result> list = new ArrayList<SP_DDM_CUS_6_COMM_TEMP_Result>();
for(Object[] objArray : listObjectArray) {
SP_DDM_CUS_6_COMM_TEMP_Result temp = new SP_DDM_CUS_6_COMM_TEMP_Result();
temp = generateResultBean(objArray);
list.add(temp);
}
return list;
}


public SP_DDM_CUS_6_COMM_TEMP_Result generateResultBean(Object[] objectArray)
{
SP_DDM_CUS_6_COMM_TEMP_Result temp = new SP_DDM_CUS_6_COMM_TEMP_Result();


temp.setACTUAL_FOR((BigDecimal)(objectArray[0]));
temp.setCOMM_CODE((String)(objectArray[1]));
temp.setCOMMODITY((String)(objectArray[2]));
temp.setCOMMODITY_CODE((BigDecimal)(objectArray[3]));
temp.setCOMMODITY_GROUP((String)(objectArray[4]));
temp.setMM_YYYY((Date)(objectArray[5]));
return temp;
}


}
