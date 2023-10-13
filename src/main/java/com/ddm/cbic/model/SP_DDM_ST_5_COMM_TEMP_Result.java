package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;

public class SP_DDM_ST_5_COMM_TEMP_Result {

    public String COMM_CODE;
    public String MM_YYYY;
    public String AUDIT;
    public String AER;
    public String RCD;
    public String PRE_DEPOSITS;
    public String SCRUT_RETURNS;
    public String DETAIL_SCRUT;
    public String RFD;
    public String FPA;
    public String VCES;
    public String ITR_TDS;
    public String OTHERS;
    
   
    



	public String getMM_YYYY() {
		return MM_YYYY;
	}

	public void setMM_YYYY(String mM_YYYY) {
		MM_YYYY = mM_YYYY;
	}

	public String getCOMM_CODE() {
		return COMM_CODE;
	}

	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}

	public String getAUDIT() {
		return AUDIT;
	}

	public void setAUDIT(String aUDIT) {
		AUDIT = aUDIT;
	}

	public String getAER() {
		return AER;
	}

	public void setAER(String aER) {
		AER = aER;
	}

	public String getRCD() {
		return RCD;
	}

	public void setRCD(String rCD) {
		RCD = rCD;
	}

	public String getPRE_DEPOSITS() {
		return PRE_DEPOSITS;
	}

	public void setPRE_DEPOSITS(String pRE_DEPOSITS) {
		PRE_DEPOSITS = pRE_DEPOSITS;
	}

	public String getSCRUT_RETURNS() {
		return SCRUT_RETURNS;
	}

	public void setSCRUT_RETURNS(String sCRUT_RETURNS) {
		SCRUT_RETURNS = sCRUT_RETURNS;
	}

	public String getDETAIL_SCRUT() {
		return DETAIL_SCRUT;
	}

	public void setDETAIL_SCRUT(String dETAIL_SCRUT) {
		DETAIL_SCRUT = dETAIL_SCRUT;
	}

	public String getRFD() {
		return RFD;
	}

	public void setRFD(String rFD) {
		RFD = rFD;
	}

	public String getFPA() {
		return FPA;
	}

	public void setFPA(String fPA) {
		FPA = fPA;
	}

	public String getVCES() {
		return VCES;
	}

	public void setVCES(String vCES) {
		VCES = vCES;
	}

	public String getITR_TDS() {
		return ITR_TDS;
	}

	public void setITR_TDS(String iTR_TDS) {
		ITR_TDS = iTR_TDS;
	}

	public String getOTHERS() {
		return OTHERS;
	}

	public void setOTHERS(String oTHERS) {
		OTHERS = oTHERS;
	}

	public List<SP_DDM_ST_5_COMM_TEMP_Result> SP_DDM_ST_5_COMM_TEMP_Result(List<Object[]> listObjectArray){
		List <SP_DDM_ST_5_COMM_TEMP_Result> list = new ArrayList<SP_DDM_ST_5_COMM_TEMP_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_ST_5_COMM_TEMP_Result temp = new SP_DDM_ST_5_COMM_TEMP_Result();
		temp = generateResultBean_SP_DDM_ST_5_COMM_TEMP(objArray);
		list.add(temp);
		}
		return list;
		}

		public SP_DDM_ST_5_COMM_TEMP_Result generateResultBean_SP_DDM_ST_5_COMM_TEMP(Object[] objectArray)
		{
			SP_DDM_ST_5_COMM_TEMP_Result temp = new SP_DDM_ST_5_COMM_TEMP_Result();
			if(null!=objectArray[0] && objectArray[0]!=null) {
				temp.setCOMM_CODE((String)( objectArray[0]));}
			if(null!=objectArray[1] && objectArray[1]!=null) {
			temp.setMM_YYYY((String.valueOf( objectArray[1])));}
			if(null!=objectArray[2] && objectArray[2]!=null) {
			temp.setAUDIT((String.valueOf(objectArray[2])));}
			if(null!=objectArray[3] && objectArray[3]!=null) {
				temp.setAER((String.valueOf(objectArray[3])));}
			if(null!=objectArray[4] && objectArray[4]!=null) {
				temp.setRCD((String.valueOf(objectArray[4])));}
			if(null!=objectArray[5] && objectArray[5]!=null) {
				temp.setPRE_DEPOSITS((String.valueOf(objectArray[5])));}
			if(null!=objectArray[6] && objectArray[6]!=null) {
				temp.setSCRUT_RETURNS((String.valueOf(objectArray[6])));}
			if(null!=objectArray[7] && objectArray[7]!=null) {
				temp.setDETAIL_SCRUT((String.valueOf(objectArray[7])));}
			if(null!=objectArray[8] && objectArray[8]!=null) {
				temp.setRFD((String.valueOf(objectArray[8])));}
			if(null!=objectArray[9] && objectArray[9]!=null) {
				temp.setFPA((String.valueOf(objectArray[9])));}
			if(null!=objectArray[10] && objectArray[10]!=null) {
				temp.setVCES((String.valueOf(objectArray[10])));}
			if(null!=objectArray[11] && objectArray[11]!=null) {
				temp.setITR_TDS((String.valueOf(objectArray[11])));}
			if(null!=objectArray[12] && objectArray[12]!=null) {
				temp.setOTHERS((String.valueOf(objectArray[12])));}
		
			
		 
		return temp;

		}
	


}
