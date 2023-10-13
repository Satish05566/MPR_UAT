package com.ddm.cbic.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public  class SP_DDM_CUS_6_COMMODITY_Result
{


String COMMODITY;
BigDecimal COMMODITY_CODE;
String COMMODITY_GROUP;


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


public List<SP_DDM_CUS_6_COMMODITY_Result> generateResultList_SP_DDM_CUS_6_COMMODITY(List<Object[]> listObjectArray){
List <SP_DDM_CUS_6_COMMODITY_Result> list = new ArrayList<SP_DDM_CUS_6_COMMODITY_Result>();
for(Object[] objArray : listObjectArray) {
SP_DDM_CUS_6_COMMODITY_Result temp = new SP_DDM_CUS_6_COMMODITY_Result();
temp = generateResultBean(objArray);
list.add(temp);
}
return list;
}


public SP_DDM_CUS_6_COMMODITY_Result generateResultBean(Object[] objectArray)
{
SP_DDM_CUS_6_COMMODITY_Result temp = new SP_DDM_CUS_6_COMMODITY_Result();


temp.setCOMMODITY((String)(objectArray[0]));
temp.setCOMMODITY_CODE((BigDecimal)(objectArray[1]));
temp.setCOMMODITY_GROUP((String)(objectArray[2]));
return temp;
}


}
