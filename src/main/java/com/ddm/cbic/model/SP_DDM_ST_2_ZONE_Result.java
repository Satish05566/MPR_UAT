package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SP_DDM_ST_2_ZONE_Result {
	
	private String TOTAL_COMM ;
    private String AMND ;
    private String COMPLETE_COMM ;
    private String CU_FOR_P ;
    private String CU_UPTO_P ;
    private String CU_FOR_C ;
    private String CU_UPTO_C ;
    private String ACTUAL ;
    private String PERC ;
    

	public String getTOTAL_COMM() {
		return TOTAL_COMM;
	}

	public void setTOTAL_COMM(String tOTAL_COMM) {
		TOTAL_COMM = tOTAL_COMM;
	}

	public String getAMND() {
		return AMND;
	}

	public void setAMND(String aMND) {
		AMND = aMND;
	}

	public String getCOMPLETE_COMM() {
		return COMPLETE_COMM;
	}

	public void setCOMPLETE_COMM(String cOMPLETE_COMM) {
		COMPLETE_COMM = cOMPLETE_COMM;
	}

	public String getCU_FOR_P() {
		return CU_FOR_P;
	}

	public void setCU_FOR_P(String cU_FOR_P) {
		CU_FOR_P = cU_FOR_P;
	}

	public String getCU_UPTO_P() {
		return CU_UPTO_P;
	}

	public void setCU_UPTO_P(String cU_UPTO_P) {
		CU_UPTO_P = cU_UPTO_P;
	}

	public String getCU_FOR_C() {
		return CU_FOR_C;
	}

	public void setCU_FOR_C(String cU_FOR_C) {
		CU_FOR_C = cU_FOR_C;
	}

	public String getCU_UPTO_C() {
		return CU_UPTO_C;
	}

	public void setCU_UPTO_C(String cU_UPTO_C) {
		CU_UPTO_C = cU_UPTO_C;
	}

	public String getACTUAL() {
		return ACTUAL;
	}

	public void setACTUAL(String aCTUAL) {
		ACTUAL = aCTUAL;
	}

	public String getPERC() {
		return PERC;
	}

	public void setPERC(String pERC) {
		PERC = pERC;
	}

	public List<SP_DDM_ST_2_ZONE_Result> SP_DDM_ST_2_ZONE_Result(List<Object[]> listObjectArray){
		List <SP_DDM_ST_2_ZONE_Result> list = new ArrayList<SP_DDM_ST_2_ZONE_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_ST_2_ZONE_Result temp = new SP_DDM_ST_2_ZONE_Result();
		temp = generateResultBean_SP_DDM_ST_2_ZONE(objArray);
		list.add(temp);
		}
		return list;
		}

		public SP_DDM_ST_2_ZONE_Result generateResultBean_SP_DDM_ST_2_ZONE(Object[] objectArray)
		{
			SP_DDM_ST_2_ZONE_Result temp = new SP_DDM_ST_2_ZONE_Result();

		temp.setTOTAL_COMM (String.valueOf(objectArray[0]));
        temp.setAMND (String.valueOf(objectArray[1]));
        temp.setCOMPLETE_COMM (String.valueOf(objectArray[2]));
        temp.setCU_FOR_P (String.valueOf(objectArray[3]));
        temp.setCU_UPTO_P (String.valueOf(objectArray[4]));
        temp.setCU_FOR_C (String.valueOf(objectArray[5]));
        temp.setCU_UPTO_C (String.valueOf(objectArray[6]));
        temp.setACTUAL (String.valueOf(objectArray[7]));
        temp.setPERC (String.valueOf(objectArray[8]));

			
		return temp;

		}
	
    
    

}
