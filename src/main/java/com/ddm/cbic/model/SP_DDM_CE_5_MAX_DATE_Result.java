package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.*;


public  class SP_DDM_CE_5_MAX_DATE_Result
{


Date MM_YYYY;




public Date getMM_YYYY() {
	return MM_YYYY;
}


public void setMM_YYYY(Date mM_YYYY) {
	MM_YYYY = mM_YYYY;
}


public List<SP_DDM_CE_5_MAX_DATE_Result> generateResultList_SP_DDM_CEX_5_MAX_DATE(List<Object[]> listObjectArray){
List <SP_DDM_CE_5_MAX_DATE_Result> list = new ArrayList<SP_DDM_CE_5_MAX_DATE_Result>();
for(Object[] objArray : listObjectArray) {
SP_DDM_CE_5_MAX_DATE_Result temp = new SP_DDM_CE_5_MAX_DATE_Result();
temp = generateResultBean_SP_DDM_CEX_5_MAX_DATE(objArray);
list.add(temp);
}
return list;
}


public SP_DDM_CE_5_MAX_DATE_Result generateResultBean_SP_DDM_CEX_5_MAX_DATE(Object[] objectArray)
{
SP_DDM_CE_5_MAX_DATE_Result temp = new SP_DDM_CE_5_MAX_DATE_Result();
temp.setMM_YYYY((Date)(objectArray[0]));
return temp;
}


}
