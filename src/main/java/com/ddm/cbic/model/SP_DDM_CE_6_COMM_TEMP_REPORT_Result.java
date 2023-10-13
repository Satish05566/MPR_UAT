package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;
    public class SP_DDM_CE_6_COMM_TEMP_REPORT_Result
    {
        public String S_NO ;
        public String TOTAL_COMM ;
        public String COMPLETE_COMM ;
        public String AMND ;
        public String COMM_CODE ;
        public String COMMODITY_GROUP ;
        public String PRE_PLA ;
        public String PRE_CENVAT ;
        public String PRE_PLA_FOR_P ;
        public String PRE_CENVAT_FOR_P ;
        public String PRE_PLA_UPTO_P ;
        public String PRE_CENVAT_UPTO_P ;
        public String CURR_PLA_FOR_C ;
        public String CURR_CENVAT_FOR_C ;
        public String CURR_PLA_UPTO_C ;
        public String CURR_CENVAT_UPTO_C ;
        public String ACTUAL_UPTO_PLA ;
        public String ACTUAL_UPTO_CENVAT ;
        public String PERCEN_PLA ;
        public String PERCEN_CENVAT ;
        
        
		public String getS_NO() {
			return S_NO;
		}
		public void setS_NO(String s_NO) {
			S_NO = s_NO;
		}
		public String getTOTAL_COMM() {
			return TOTAL_COMM;
		}
		public void setTOTAL_COMM(String tOTAL_COMM) {
			TOTAL_COMM = tOTAL_COMM;
		}
		public String getCOMPLETE_COMM() {
			return COMPLETE_COMM;
		}
		public void setCOMPLETE_COMM(String cOMPLETE_COMM) {
			COMPLETE_COMM = cOMPLETE_COMM;
		}
		public String getAMND() {
			return AMND;
		}
		public void setAMND(String aMND) {
			AMND = aMND;
		}
		public String getCOMM_CODE() {
			return COMM_CODE;
		}
		public void setCOMM_CODE(String cOMM_CODE) {
			COMM_CODE = cOMM_CODE;
		}
		public String getCOMMODITY_GROUP() {
			return COMMODITY_GROUP;
		}
		public void setCOMMODITY_GROUP(String cOMMODITY_GROUP) {
			COMMODITY_GROUP = cOMMODITY_GROUP;
		}
		public String getPRE_PLA() {
			return PRE_PLA;
		}
		public void setPRE_PLA(String pRE_PLA) {
			PRE_PLA = pRE_PLA;
		}
		public String getPRE_CENVAT() {
			return PRE_CENVAT;
		}
		public void setPRE_CENVAT(String pRE_CENVAT) {
			PRE_CENVAT = pRE_CENVAT;
		}
		public String getPRE_PLA_FOR_P() {
			return PRE_PLA_FOR_P;
		}
		public void setPRE_PLA_FOR_P(String pRE_PLA_FOR_P) {
			PRE_PLA_FOR_P = pRE_PLA_FOR_P;
		}
		public String getPRE_CENVAT_FOR_P() {
			return PRE_CENVAT_FOR_P;
		}
		public void setPRE_CENVAT_FOR_P(String pRE_CENVAT_FOR_P) {
			PRE_CENVAT_FOR_P = pRE_CENVAT_FOR_P;
		}
		public String getPRE_PLA_UPTO_P() {
			return PRE_PLA_UPTO_P;
		}
		public void setPRE_PLA_UPTO_P(String pRE_PLA_UPTO_P) {
			PRE_PLA_UPTO_P = pRE_PLA_UPTO_P;
		}
		public String getPRE_CENVAT_UPTO_P() {
			return PRE_CENVAT_UPTO_P;
		}
		public void setPRE_CENVAT_UPTO_P(String pRE_CENVAT_UPTO_P) {
			PRE_CENVAT_UPTO_P = pRE_CENVAT_UPTO_P;
		}
		public String getCURR_PLA_FOR_C() {
			return CURR_PLA_FOR_C;
		}
		public void setCURR_PLA_FOR_C(String cURR_PLA_FOR_C) {
			CURR_PLA_FOR_C = cURR_PLA_FOR_C;
		}
		public String getCURR_CENVAT_FOR_C() {
			return CURR_CENVAT_FOR_C;
		}
		public void setCURR_CENVAT_FOR_C(String cURR_CENVAT_FOR_C) {
			CURR_CENVAT_FOR_C = cURR_CENVAT_FOR_C;
		}
		public String getCURR_PLA_UPTO_C() {
			return CURR_PLA_UPTO_C;
		}
		public void setCURR_PLA_UPTO_C(String cURR_PLA_UPTO_C) {
			CURR_PLA_UPTO_C = cURR_PLA_UPTO_C;
		}
		public String getCURR_CENVAT_UPTO_C() {
			return CURR_CENVAT_UPTO_C;
		}
		public void setCURR_CENVAT_UPTO_C(String cURR_CENVAT_UPTO_C) {
			CURR_CENVAT_UPTO_C = cURR_CENVAT_UPTO_C;
		}
		public String getACTUAL_UPTO_PLA() {
			return ACTUAL_UPTO_PLA;
		}
		public void setACTUAL_UPTO_PLA(String aCTUAL_UPTO_PLA) {
			ACTUAL_UPTO_PLA = aCTUAL_UPTO_PLA;
		}
		public String getACTUAL_UPTO_CENVAT() {
			return ACTUAL_UPTO_CENVAT;
		}
		public void setACTUAL_UPTO_CENVAT(String aCTUAL_UPTO_CENVAT) {
			ACTUAL_UPTO_CENVAT = aCTUAL_UPTO_CENVAT;
		}
		public String getPERCEN_PLA() {
			return PERCEN_PLA;
		}
		public void setPERCEN_PLA(String pERCEN_PLA) {
			PERCEN_PLA = pERCEN_PLA;
		}
		public String getPERCEN_CENVAT() {
			return PERCEN_CENVAT;
		}
		public void setPERCEN_CENVAT(String pERCEN_CENVAT) {
			PERCEN_CENVAT = pERCEN_CENVAT;
		}
		
		
		
		public List<SP_DDM_CE_6_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CE_6_COMM_TEMP_REPORT(List<Object[]> listObjectArray){
			List <SP_DDM_CE_6_COMM_TEMP_REPORT_Result> list = new ArrayList<SP_DDM_CE_6_COMM_TEMP_REPORT_Result>();
			for(Object[] objArray : listObjectArray) {
			SP_DDM_CE_6_COMM_TEMP_REPORT_Result temp = new SP_DDM_CE_6_COMM_TEMP_REPORT_Result();
			//temp = generateResultBean(objArray);
			list.add(temp);
			}
			return list;
			}


			public SP_DDM_CE_6_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CE_6_COMM_TEMP_REPORT(Object[] objectArray)
			{
			SP_DDM_CE_6_COMM_TEMP_REPORT_Result temp = new SP_DDM_CE_6_COMM_TEMP_REPORT_Result();
			temp.setS_NO((String)(objectArray[0]));
			temp.setAMND((String)(objectArray[1]));
			temp.setTOTAL_COMM((String)(objectArray[2]));
			temp.setCOMPLETE_COMM((String)(objectArray[3]));
			temp.setCOMMODITY_GROUP((String)(objectArray[4]));
			temp.setPRE_PLA((String)(objectArray[5]));
			temp.setPRE_CENVAT((String)(objectArray[6]));
			temp.setPRE_CENVAT_FOR_P((String)(objectArray[7]));
			temp.setPRE_PLA_UPTO_P((String)(objectArray[8]));
			temp.setPRE_CENVAT_UPTO_P((String)(objectArray[9]));
			temp.setCURR_PLA_FOR_C((String)(objectArray[10]));
			temp.setCURR_CENVAT_FOR_C((String)(objectArray[11]));
			temp.setCURR_PLA_UPTO_C((String)(objectArray[12]));
			temp.setCURR_CENVAT_UPTO_C((String)(objectArray[13]));
			temp.setACTUAL_UPTO_PLA((String)(objectArray[14]));
			temp.setACTUAL_UPTO_CENVAT((String)(objectArray[15]));
			temp.setPERCEN_PLA((String)(objectArray[16]));
			temp.setPERCEN_CENVAT((String)(objectArray[17]));

			return temp;
			}
	
}
