package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;    
    public class SP_DDM_CE_6_COMM_TEMP_Result
    {
        public String COMM_CODE ;
        public String MM_YYYY ;
        public String COMMODITY_CODE ;
        public String COMMODITY ;
        public String COMMODITY_GROUP ;
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
		public String getCOMMODITY_CODE() {
			return COMMODITY_CODE;
		}
		public void setCOMMODITY_CODE(String cOMMODITY_CODE) {
			COMMODITY_CODE = cOMMODITY_CODE;
		}
		public String getCOMMODITY() {
			return COMMODITY;
		}
		public void setCOMMODITY(String cOMMODITY) {
			COMMODITY = cOMMODITY;
		}
		public String getCOMMODITY_GROUP() {
			return COMMODITY_GROUP;
		}
		public void setCOMMODITY_GROUP(String cOMMODITY_GROUP) {
			COMMODITY_GROUP = cOMMODITY_GROUP;
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
        
		public List<SP_DDM_CE_6_COMM_TEMP_Result> generateResultList_SP_DDM_CE_6_COMM_TEMP(List<Object[]> listObjectArray){
			 List <SP_DDM_CE_6_COMM_TEMP_Result> list = new ArrayList<SP_DDM_CE_6_COMM_TEMP_Result>();
			 for(Object[] objArray : listObjectArray) {
				 SP_DDM_CE_6_COMM_TEMP_Result temp = new SP_DDM_CE_6_COMM_TEMP_Result();
			 temp = generateResultBean_SP_DDM_CE_6_COMM_TEMP(objArray);
			 list.add(temp);
			 }
			 return list;
			 }


			public SP_DDM_CE_6_COMM_TEMP_Result generateResultBean_SP_DDM_CE_6_COMM_TEMP(Object[] objectArray)
			{
			SP_DDM_CE_6_COMM_TEMP_Result temp = new SP_DDM_CE_6_COMM_TEMP_Result();

			temp.setCOMM_CODE((String)(objectArray[0]));
			temp.setMM_YYYY((String)(objectArray[1]));
			temp.setCOMMODITY_CODE((String)(objectArray[2]));
			temp.setCOMMODITY((String)(objectArray[3]));
			temp.setCOMMODITY_GROUP((String)(objectArray[4]));
			temp.setCURR_PLA((String)(objectArray[5]));
			temp.setCURR_CENVAT((String)(objectArray[5]));
			
			return temp;
			}
		
		
		
		
		
		
		
		
		
		
		
		
    
}
