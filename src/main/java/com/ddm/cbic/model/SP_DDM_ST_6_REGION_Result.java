package com.ddm.cbic.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DDM_ST_6_REGION_Result
    {
        public String S_NO ;
        public String REGION_CODE ;
        public String SERVICE ;
        public String SERVICE_CODE ;
        public String NO_ASSESSEES_FOR_C ;
        public String CURR_PLA_FOR_C ;
        public String CURR_CENVAT_FOR_C ;
        public String CURR_PLA_FOR_P ;
        public String NO_ASSESSEES_FOR_P ;
        public String CURR_CENVAT_FOR_P ;
        public String CURR_PLA_UPTO_P ;
        public String CURR_CENVAT_UPTO_P ;
        public String CURR_PLA_UPTO_C ;
        public String CURR_CENVAT_UPTO_C ;
        public String ACTUAL_UPTO_PLA ;
        public String ACTUAL_UPTO_CENVAT ;
        public String PERCEN_PLA ;
        public String PERCEN_CENVAT ;
		public String getREGION_CODE() {
			return REGION_CODE;
		}
		public void setREGION_CODE(String rEGION_CODE) {
			REGION_CODE = rEGION_CODE;
		}
		public String getSERVICE() {
			return SERVICE;
		}
		public void setSERVICE(String sERVICE) {
			SERVICE = sERVICE;
		}
		public String getSERVICE_CODE() {
			return SERVICE_CODE;
		}
		public void setSERVICE_CODE(String sERVICE_CODE) {
			SERVICE_CODE = sERVICE_CODE;
		}
		public String getNO_ASSESSEES_FOR_C() {
			return NO_ASSESSEES_FOR_C;
		}
		public void setNO_ASSESSEES_FOR_C(String nO_ASSESSEES_FOR_C) {
			NO_ASSESSEES_FOR_C = nO_ASSESSEES_FOR_C;
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
		public String getCURR_PLA_FOR_P() {
			return CURR_PLA_FOR_P;
		}
		public void setCURR_PLA_FOR_P(String cURR_PLA_FOR_P) {
			CURR_PLA_FOR_P = cURR_PLA_FOR_P;
		}
		public String getNO_ASSESSEES_FOR_P() {
			return NO_ASSESSEES_FOR_P;
		}
		public void setNO_ASSESSEES_FOR_P(String nO_ASSESSEES_FOR_P) {
			NO_ASSESSEES_FOR_P = nO_ASSESSEES_FOR_P;
		}
		public String getCURR_CENVAT_FOR_P() {
			return CURR_CENVAT_FOR_P;
		}
		public void setCURR_CENVAT_FOR_P(String cURR_CENVAT_FOR_P) {
			CURR_CENVAT_FOR_P = cURR_CENVAT_FOR_P;
		}
		public String getCURR_PLA_UPTO_P() {
			return CURR_PLA_UPTO_P;
		}
		public void setCURR_PLA_UPTO_P(String cURR_PLA_UPTO_P) {
			CURR_PLA_UPTO_P = cURR_PLA_UPTO_P;
		}
		public String getCURR_CENVAT_UPTO_P() {
			return CURR_CENVAT_UPTO_P;
		}
		public void setCURR_CENVAT_UPTO_P(String cURR_CENVAT_UPTO_P) {
			CURR_CENVAT_UPTO_P = cURR_CENVAT_UPTO_P;
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
		
		public List<SP_DDM_ST_6_REGION_Result> generateResultList_SP_DDM_ST_6_REGION(List<Object[]> listObjectArray){
			 List <SP_DDM_ST_6_REGION_Result> list = new ArrayList<SP_DDM_ST_6_REGION_Result>();
			 for(Object[] objArray : listObjectArray) {
				 SP_DDM_ST_6_REGION_Result temp = new SP_DDM_ST_6_REGION_Result();
			 temp = generateResultBean_SP_DDM_ST_6_REGION(objArray);
			 list.add(temp);
			 }
			 return list;
			 }


			public SP_DDM_ST_6_REGION_Result generateResultBean_SP_DDM_ST_6_REGION(Object[] objectArray)
			{
			SP_DDM_ST_6_REGION_Result temp = new SP_DDM_ST_6_REGION_Result();

			temp.setS_NO((String)(objectArray[0]));
			temp.setREGION_CODE((String)(objectArray[1]));
			temp.setSERVICE((String)(objectArray[2]));
			temp.setSERVICE_CODE((String)(objectArray[3]));
			temp.setNO_ASSESSEES_FOR_C((String)(objectArray[4]));
			temp.setCURR_PLA_FOR_C((String)(objectArray[5]));
			temp.setCURR_CENVAT_FOR_C((String)(objectArray[6]));
			temp.setCURR_PLA_FOR_P((String)(objectArray[7]));
			temp.setNO_ASSESSEES_FOR_P((String)(objectArray[8]));
			temp.setCURR_CENVAT_FOR_P((String)(objectArray[9]));
			temp.setCURR_PLA_UPTO_P((String)(objectArray[10]));
			temp.setCURR_CENVAT_UPTO_P((String)(objectArray[11]));
			
			
			temp.setCURR_PLA_UPTO_C((String)(objectArray[12]));
			temp.setCURR_CENVAT_FOR_C((String)(objectArray[13]));
			temp.setCURR_PLA_UPTO_C((String)(objectArray[14]));
			temp.setCURR_CENVAT_UPTO_C((String)(objectArray[15]));
			
			temp.setACTUAL_UPTO_PLA((String)(objectArray[16]));
			temp.setACTUAL_UPTO_CENVAT((String)(objectArray[17]));
			temp.setPERCEN_PLA((String)(objectArray[18]));
			temp.setPERCEN_CENVAT((String)(objectArray[19]));
			
			
			return temp;
			}
			public String getS_NO() {
				return S_NO;
			}
			public void setS_NO(String s_NO) {
				S_NO = s_NO;
			}
       
        
    
}
