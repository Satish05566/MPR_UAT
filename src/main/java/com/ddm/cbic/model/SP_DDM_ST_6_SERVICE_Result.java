package com.ddm.cbic.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DDM_ST_6_SERVICE_Result
    {
        public String SERVICE_CODE ;
        public String SERVICE ;
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
		
		
		public List<SP_DDM_ST_6_SERVICE_Result> generateResultList_SP_DDM_ST_6_SERVICE(List<Object[]> listObjectArray){
			 List <SP_DDM_ST_6_SERVICE_Result> list = new ArrayList<SP_DDM_ST_6_SERVICE_Result>();
			 for(Object[] objArray : listObjectArray) {
				 SP_DDM_ST_6_SERVICE_Result temp = new SP_DDM_ST_6_SERVICE_Result();
			 temp = generateResultBean_SP_DDM_ST_6_SERVICE(objArray);
			 list.add(temp);
			 }
			 return list;
			 }


			public SP_DDM_ST_6_SERVICE_Result generateResultBean_SP_DDM_ST_6_SERVICE(Object[] objectArray)
			{
				SP_DDM_ST_6_SERVICE_Result temp = new SP_DDM_ST_6_SERVICE_Result();

			temp.setSERVICE_CODE((String)(objectArray[0]));
			temp.setSERVICE((String)(objectArray[1]));
			
			return temp;
			}
		
    
}
