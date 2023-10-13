package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;
    public class SP_CORRECTION_LIST_ALL_GST_Result {
         String COMM_NAME ;
         String MPR ;
         String MM_YYYY ;
         String MAX_MM_YYYY ;
         String SUBMISSION_DT ;
         String VALIDATION_DT ;
         String CORRECTION_DT ;
         String REMARKS ;
         int STATUS ;
public void setCOMM_NAME(String COMM_NAME) {
this.COMM_NAME=COMM_NAME;
}

public String getCOMM_NAME() {
return COMM_NAME;
}

public void setMPR(String MPR) {
this.MPR=MPR;
}

public String getMPR() {
return MPR;
}

public void setMM_YYYY(String MM_YYYY) {
this.MM_YYYY=MM_YYYY;
}

public String getMM_YYYY() {
return MM_YYYY;
}

public void setMAX_MM_YYYY(String MAX_MM_YYYY) {
this.MAX_MM_YYYY=MAX_MM_YYYY;
}

public String getMAX_MM_YYYY() {
return MAX_MM_YYYY;
}

public void setSUBMISSION_DT(String SUBMISSION_DT) {
this.SUBMISSION_DT=SUBMISSION_DT;
}

public String getSUBMISSION_DT() {
return SUBMISSION_DT;
}

public void setVALIDATION_DT(String VALIDATION_DT) {
this.VALIDATION_DT=VALIDATION_DT;
}

public String getVALIDATION_DT() {
return VALIDATION_DT;
}

public void setCORRECTION_DT(String CORRECTION_DT) {
this.CORRECTION_DT=CORRECTION_DT;
}

public String getCORRECTION_DT() {
return CORRECTION_DT;
}

public void setREMARKS(String REMARKS) {
this.REMARKS=REMARKS;
}

public String getREMARKS() {
return REMARKS;
}

public void setSTATUS(int STATUS) {
this.STATUS=STATUS;
}

public int getSTATUS() {
return STATUS;
}

public  List<SP_CORRECTION_LIST_ALL_GST_Result> generateResultBeanList(List<Object []> listObjectArray) {
List <SP_CORRECTION_LIST_ALL_GST_Result> list =  new ArrayList<SP_CORRECTION_LIST_ALL_GST_Result>();
for(Object [] objArray : listObjectArray) { 
SP_CORRECTION_LIST_ALL_GST_Result temp = new SP_CORRECTION_LIST_ALL_GST_Result ();

temp = generateResultBean(objArray);
list.add(temp);
}
return list;
}

public  SP_CORRECTION_LIST_ALL_GST_Result generateResultBean(Object [] objectArray) {
SP_CORRECTION_LIST_ALL_GST_Result temp =  new SP_CORRECTION_LIST_ALL_GST_Result();
temp.setCOMM_NAME((String)( objectArray[0]));
temp.setMPR((String)( objectArray[1]));
temp.setMM_YYYY((String)( objectArray[2]));
temp.setMAX_MM_YYYY((String)( objectArray[3]));
temp.setSUBMISSION_DT((String)( objectArray[4]));
temp.setVALIDATION_DT((String)( objectArray[5]));
temp.setCORRECTION_DT((String)( objectArray[6]));
temp.setREMARKS((String)( objectArray[7]));
temp.setSTATUS((int)( objectArray[8]));
return temp;
}

public  List<String>  generateResultBeanLabels() {
List <String> listLabels =  new ArrayList<String>();
listLabels.add("COMM_NAME");
listLabels.add("MPR");
listLabels.add("MM_YYYY");
listLabels.add("MAX_MM_YYYY");
listLabels.add("SUBMISSION_DT");
listLabels.add("VALIDATION_DT");
listLabels.add("CORRECTION_DT");
listLabels.add("REMARKS");
listLabels.add("STATUS");
return listLabels;
}
}
