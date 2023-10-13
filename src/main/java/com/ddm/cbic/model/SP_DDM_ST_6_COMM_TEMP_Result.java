package com.ddm.cbic.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DDM_ST_6_COMM_TEMP_Result
    {
        public String COMM_CODE ;
        public String MM_YYYY ;
        public String SERVICE_CODE ;
        public String SERVICE ;
        public String NO_ASSESSEES ;
        public String CURR_PLA ;
        public String CURR_CENVAT ;
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
		public String getSERVICE_CODE() {
			return SERVICE_CODE;
		}
		public void setSERVICE_CODE(String sERVICE_CODE) {
			SERVICE_CODE = sERVICE_CODE;
		}
		public String getSERVICE() {
			return SERVICE;
		}
		public void setSERVICE(String sERVICE) {
			SERVICE = sERVICE;
		}
		public String getNO_ASSESSEES() {
			return NO_ASSESSEES;
		}
		public void setNO_ASSESSEES(String nO_ASSESSEES) {
			NO_ASSESSEES = nO_ASSESSEES;
		}
		public String getCURR_PLA() {
			return CURR_PLA;
		}
		public void setCURR_PLA(String cURR_PLA) {
			CURR_PLA = cURR_PLA;
		}
		public String getCURR_CENVAT() {
			return CURR_CENVAT;
		}
		public void setCURR_CENVAT(String cURR_CENVAT) {
			CURR_CENVAT = cURR_CENVAT;
		}
		
		public List<SP_DDM_ST_6_COMM_TEMP_Result> generateResultList_SP_DDM_ST_6_COMM_TEMP(List<Object[]> listObjectArray){
			 List <SP_DDM_ST_6_COMM_TEMP_Result> list = new ArrayList<SP_DDM_ST_6_COMM_TEMP_Result>();
			 for(Object[] objArray : listObjectArray) {
				 SP_DDM_ST_6_COMM_TEMP_Result temp = new SP_DDM_ST_6_COMM_TEMP_Result();
			 temp = generateResultBean_SP_DDM_ST_6_COMM_TEMP(objArray);
			 list.add(temp);
			 }
			 return list;
			 }


			public SP_DDM_ST_6_COMM_TEMP_Result generateResultBean_SP_DDM_ST_6_COMM_TEMP(Object[] objectArray)
			{
			SP_DDM_ST_6_COMM_TEMP_Result temp = new SP_DDM_ST_6_COMM_TEMP_Result();

			temp.setCOMM_CODE((String)(objectArray[0]));
			temp.setMM_YYYY((String)(objectArray[1]));
			temp.setSERVICE_CODE((String)(objectArray[2]));
			temp.setSERVICE((String)(objectArray[3]));
			temp.setNO_ASSESSEES((String)(objectArray[4]));
			temp.setCURR_PLA((String)(objectArray[5]));
			temp.setCURR_CENVAT((String)(objectArray[5]));
			
			return temp;
			}
        
    
}
