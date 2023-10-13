package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;

public class SP_DDM_ST_2_COMM_TEMP_Result {
	 
	private String 	COMM_CODE	;
	private String 	MM_YYYY	;
	private String 	CENVAT_UTILISED	;
	

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

	public String getCENVAT_UTILISED() {
		return CENVAT_UTILISED;
	}

	public void setCENVAT_UTILISED(String cENVAT_UTILISED) {
		CENVAT_UTILISED = cENVAT_UTILISED;
	}

	public List<SP_DDM_ST_2_COMM_TEMP_Result> sp_DDM_ST_2_COMM_TEMP_Result(List<Object[]> listObjectArray){
		List <SP_DDM_ST_2_COMM_TEMP_Result> list = new ArrayList<SP_DDM_ST_2_COMM_TEMP_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_ST_2_COMM_TEMP_Result temp = new SP_DDM_ST_2_COMM_TEMP_Result();
		temp = generateResultBean_SP_DDM_ST_2_COMM_TEMP(objArray);
		list.add(temp);
		}
		return list;
		}

		public SP_DDM_ST_2_COMM_TEMP_Result generateResultBean_SP_DDM_ST_2_COMM_TEMP(Object[] objectArray)
		{
			SP_DDM_ST_2_COMM_TEMP_Result temp = new SP_DDM_ST_2_COMM_TEMP_Result();
			
			if(null != objectArray[0]){temp.setCOMM_CODE(objectArray[0].toString());}else{temp.setCOMM_CODE("0");}
			if(null != objectArray[1]){temp.setMM_YYYY(objectArray[1].toString());}else{temp.setMM_YYYY("0");}
			if(null != objectArray[2]){temp.setCENVAT_UTILISED(objectArray[2].toString());}else{temp.setCENVAT_UTILISED("0");}
			
			return temp;
					
			
		}

}
