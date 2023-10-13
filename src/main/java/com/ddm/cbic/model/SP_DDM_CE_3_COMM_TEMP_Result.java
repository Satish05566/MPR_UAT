package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.*;


public  class SP_DDM_CE_3_COMM_TEMP_Result
{
private String COMM_CODE;
private String MM_YYYY;
private String EPZ;
private String EOU;
private String SEZ;
private String SFIS;
private String SEIS;
private String FPS;
private String FMS;
private String AIIS;
private String VKGU;
private String SHIS;
private String MEIS;
private String EPCG;




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


public String getEPZ() {
	return EPZ;
}


public void setEPZ(String ePZ) {
	EPZ = ePZ;
}


public String getEOU() {
	return EOU;
}


public void setEOU(String eOU) {
	EOU = eOU;
}


public String getSEZ() {
	return SEZ;
}


public void setSEZ(String sEZ) {
	SEZ = sEZ;
}


public String getSFIS() {
	return SFIS;
}


public void setSFIS(String sFIS) {
	SFIS = sFIS;
}


public String getSEIS() {
	return SEIS;
}


public void setSEIS(String sEIS) {
	SEIS = sEIS;
}


public String getFPS() {
	return FPS;
}


public void setFPS(String fPS) {
	FPS = fPS;
}


public String getFMS() {
	return FMS;
}


public void setFMS(String fMS) {
	FMS = fMS;
}


public String getAIIS() {
	return AIIS;
}


public void setAIIS(String aIIS) {
	AIIS = aIIS;
}


public String getVKGU() {
	return VKGU;
}


public void setVKGU(String vKGU) {
	VKGU = vKGU;
}


public String getSHIS() {
	return SHIS;
}


public void setSHIS(String sHIS) {
	SHIS = sHIS;
}


public String getMEIS() {
	return MEIS;
}


public void setMEIS(String mEIS) {
	MEIS = mEIS;
}


public String getEPCG() {
	return EPCG;
}


public void setEPCG(String ePCG) {
	EPCG = ePCG;
}


public List<SP_DDM_CE_3_COMM_TEMP_Result> generateResultList_SP_DDM_CE_3_COMM_TEMP(List<Object[]> listObjectArray){
List <SP_DDM_CE_3_COMM_TEMP_Result> list = new ArrayList<SP_DDM_CE_3_COMM_TEMP_Result>();
for(Object[] objArray : listObjectArray) {
SP_DDM_CE_3_COMM_TEMP_Result temp = new SP_DDM_CE_3_COMM_TEMP_Result();
temp = generateResultBean_SP_DDM_CE_3_COMM_TEMP(objArray);
list.add(temp);
}
return list;
}


public SP_DDM_CE_3_COMM_TEMP_Result generateResultBean_SP_DDM_CE_3_COMM_TEMP(Object[] objectArray)
 {
SP_DDM_CE_3_COMM_TEMP_Result temp = new SP_DDM_CE_3_COMM_TEMP_Result();



if(null != objectArray[0]){temp.setCOMM_CODE(objectArray[0].toString());}else{temp.setCOMM_CODE("0");}
if(null != objectArray[1]){temp.setMM_YYYY(objectArray[1].toString());}else{temp.setMM_YYYY("0");}
if(null != objectArray[2]){temp.setEPZ(objectArray[2].toString());}else{temp.setEPZ("0");}
if(null != objectArray[3]){temp.setEOU(objectArray[3].toString());}else{temp.setEOU("0");}
if(null != objectArray[4]){temp.setSEZ(objectArray[4].toString());}else{temp.setSEZ("0");}
if(null != objectArray[5]){temp.setSFIS(objectArray[5].toString());}else{temp.setSFIS("0");}
if(null != objectArray[6]){temp.setSEIS(objectArray[6].toString());}else{temp.setSEIS("0");}
if(null != objectArray[7]){temp.setFPS(objectArray[7].toString());}else{temp.setFPS("0");}
if(null != objectArray[8]){temp.setFMS(objectArray[8].toString());}else{temp.setFMS("0");}
if(null != objectArray[9]){temp.setAIIS(objectArray[9].toString());}else{temp.setAIIS("0");}
if(null != objectArray[10]){temp.setVKGU(objectArray[10].toString());}else{temp.setVKGU("0");}
if(null != objectArray[11]){temp.setSHIS(objectArray[11].toString());}else{temp.setSHIS("0");}
if(null != objectArray[12]){temp.setMEIS(objectArray[12].toString());}else{temp.setMEIS("0");}
if(null != objectArray[13]){temp.setEPCG(objectArray[13].toString());}else{temp.setEPCG("0");}

return temp;
}

}
