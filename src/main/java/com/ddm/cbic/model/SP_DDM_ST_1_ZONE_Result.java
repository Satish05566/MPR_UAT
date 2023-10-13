package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SP_DDM_ST_1_ZONE_Result {
	public int TOTAL_COMM ;
	public int AMND ;
    public int COMPLETE_COMM ;
    public BigDecimal GROSS ;
    public BigDecimal REFUND ;
    public BigDecimal REBATE ;
    public BigDecimal TOTAL_FY ;
    public BigDecimal TOTAL_TARGET_UPTO ;
    public BigDecimal TOTAL_TARGET_FOR ;
    public BigDecimal GROSS_FOR_C ;
    public BigDecimal REFUND_FOR_C ;
    public BigDecimal REBATE_FOR_C ;
    public BigDecimal TOTAL_FOR_C ;
    public BigDecimal GROSS_FOR_P ;
    public BigDecimal REFUND_FOR_P ;
    public BigDecimal REBATE_FOR_P ;
    public BigDecimal TOTAL_FOR_P ;
    public BigDecimal GROSS_UPTO_C ;
    public BigDecimal REFUND_UPTO_C ;
    public BigDecimal REBATE_UPTO_C ;
    public BigDecimal TOTAL_UPTO_C ;
    public BigDecimal GROSS_UPTO_P ;
    public BigDecimal REFUND_UPTO_P ;
    public BigDecimal REBATE_UPTO_P ;
    public BigDecimal TOTAL_UPTO_P ;
    
    public BigDecimal ACTUAL_GROSS ;
    public BigDecimal ACTUAL_REFUND ;
    public BigDecimal ACTUAL_REBATE ;
    //public BigDecimal ACTUAL_REBATE_STX ;
    public BigDecimal ACTUAL_TOTAL ;
    public BigDecimal GROSS_PERCENT_UPTO ;
    public BigDecimal REFUND_PERCENT_UPTO ;
    public BigDecimal REBATE_PERCENT_UPTO ;
    public BigDecimal TOTAL_PERCENT_UPTO ;
    public BigDecimal TOTAL_TARGET_ACTUAL ;
    public BigDecimal TOTAL_TARGET_PERCENT_UPTO ;
	public int getTOTAL_COMM() {
		return TOTAL_COMM;
	}
	public void setTOTAL_COMM(int tOTAL_COMM) {
		TOTAL_COMM = tOTAL_COMM;
	}
	public int getAMND() {
		return AMND;
	}
	public void setAMND(int aMND) {
		AMND = aMND;
	}
	public int getCOMPLETE_COMM() {
		return COMPLETE_COMM;
	}
	public void setCOMPLETE_COMM(int cOMPLETE_COMM) {
		COMPLETE_COMM = cOMPLETE_COMM;
	}
	public BigDecimal getGROSS() {
		return GROSS;
	}
	public void setGROSS(BigDecimal gROSS) {
		GROSS = gROSS;
	}
	public BigDecimal getREFUND() {
		return REFUND;
	}
	public void setREFUND(BigDecimal rEFUND) {
		REFUND = rEFUND;
	}
	public BigDecimal getREBATE() {
		return REBATE;
	}
	public void setREBATE(BigDecimal rEBATE) {
		REBATE = rEBATE;
	}
	public BigDecimal getTOTAL_FY() {
		return TOTAL_FY;
	}
	public void setTOTAL_FY(BigDecimal tOTAL_FY) {
		TOTAL_FY = tOTAL_FY;
	}
	public BigDecimal getTOTAL_TARGET_UPTO() {
		return TOTAL_TARGET_UPTO;
	}
	public void setTOTAL_TARGET_UPTO(BigDecimal tOTAL_TARGET_UPTO) {
		TOTAL_TARGET_UPTO = tOTAL_TARGET_UPTO;
	}
	public BigDecimal getTOTAL_TARGET_FOR() {
		return TOTAL_TARGET_FOR;
	}
	public void setTOTAL_TARGET_FOR(BigDecimal tOTAL_TARGET_FOR) {
		TOTAL_TARGET_FOR = tOTAL_TARGET_FOR;
	}
	public BigDecimal getGROSS_FOR_C() {
		return GROSS_FOR_C;
	}
	public void setGROSS_FOR_C(BigDecimal gROSS_FOR_C) {
		GROSS_FOR_C = gROSS_FOR_C;
	}
	public BigDecimal getREFUND_FOR_C() {
		return REFUND_FOR_C;
	}
	public void setREFUND_FOR_C(BigDecimal rEFUND_FOR_C) {
		REFUND_FOR_C = rEFUND_FOR_C;
	}
	public BigDecimal getREBATE_FOR_C() {
		return REBATE_FOR_C;
	}
	public void setREBATE_FOR_C(BigDecimal rEBATE_FOR_C) {
		REBATE_FOR_C = rEBATE_FOR_C;
	}
	public BigDecimal getTOTAL_FOR_C() {
		return TOTAL_FOR_C;
	}
	public void setTOTAL_FOR_C(BigDecimal tOTAL_FOR_C) {
		TOTAL_FOR_C = tOTAL_FOR_C;
	}
	public BigDecimal getGROSS_FOR_P() {
		return GROSS_FOR_P;
	}
	public void setGROSS_FOR_P(BigDecimal gROSS_FOR_P) {
		GROSS_FOR_P = gROSS_FOR_P;
	}
	public BigDecimal getREFUND_FOR_P() {
		return REFUND_FOR_P;
	}
	public void setREFUND_FOR_P(BigDecimal rEFUND_FOR_P) {
		REFUND_FOR_P = rEFUND_FOR_P;
	}
	public BigDecimal getREBATE_FOR_P() {
		return REBATE_FOR_P;
	}
	public void setREBATE_FOR_P(BigDecimal rEBATE_FOR_P) {
		REBATE_FOR_P = rEBATE_FOR_P;
	}
	public BigDecimal getTOTAL_FOR_P() {
		return TOTAL_FOR_P;
	}
	public void setTOTAL_FOR_P(BigDecimal tOTAL_FOR_P) {
		TOTAL_FOR_P = tOTAL_FOR_P;
	}
	public BigDecimal getGROSS_UPTO_C() {
		return GROSS_UPTO_C;
	}
	public void setGROSS_UPTO_C(BigDecimal gROSS_UPTO_C) {
		GROSS_UPTO_C = gROSS_UPTO_C;
	}
	public BigDecimal getREFUND_UPTO_C() {
		return REFUND_UPTO_C;
	}
	public void setREFUND_UPTO_C(BigDecimal rEFUND_UPTO_C) {
		REFUND_UPTO_C = rEFUND_UPTO_C;
	}
	public BigDecimal getREBATE_UPTO_C() {
		return REBATE_UPTO_C;
	}
	public void setREBATE_UPTO_C(BigDecimal rEBATE_UPTO_C) {
		REBATE_UPTO_C = rEBATE_UPTO_C;
	}
	public BigDecimal getTOTAL_UPTO_C() {
		return TOTAL_UPTO_C;
	}
	public void setTOTAL_UPTO_C(BigDecimal tOTAL_UPTO_C) {
		TOTAL_UPTO_C = tOTAL_UPTO_C;
	}
	public BigDecimal getGROSS_UPTO_P() {
		return GROSS_UPTO_P;
	}
	public void setGROSS_UPTO_P(BigDecimal gROSS_UPTO_P) {
		GROSS_UPTO_P = gROSS_UPTO_P;
	}
	public BigDecimal getREFUND_UPTO_P() {
		return REFUND_UPTO_P;
	}
	public void setREFUND_UPTO_P(BigDecimal rEFUND_UPTO_P) {
		REFUND_UPTO_P = rEFUND_UPTO_P;
	}
	public BigDecimal getREBATE_UPTO_P() {
		return REBATE_UPTO_P;
	}
	public void setREBATE_UPTO_P(BigDecimal rEBATE_UPTO_P) {
		REBATE_UPTO_P = rEBATE_UPTO_P;
	}
	public BigDecimal getTOTAL_UPTO_P() {
		return TOTAL_UPTO_P;
	}
	public void setTOTAL_UPTO_P(BigDecimal tOTAL_UPTO_P) {
		TOTAL_UPTO_P = tOTAL_UPTO_P;
	}
	public BigDecimal getACTUAL_GROSS() {
		return ACTUAL_GROSS;
	}
	public void setACTUAL_GROSS(BigDecimal aCTUAL_GROSS) {
		ACTUAL_GROSS = aCTUAL_GROSS;
	}
	public BigDecimal getACTUAL_REFUND() {
		return ACTUAL_REFUND;
	}
	public void setACTUAL_REFUND(BigDecimal aCTUAL_REFUND) {
		ACTUAL_REFUND = aCTUAL_REFUND;
	}
	public BigDecimal getACTUAL_REBATE() {
		return ACTUAL_REBATE;
	}
	public void setACTUAL_REBATE(BigDecimal aCTUAL_REBATE) {
		ACTUAL_REBATE = aCTUAL_REBATE;
	}
	
	public BigDecimal getACTUAL_TOTAL() {
		return ACTUAL_TOTAL;
	}
	public void setACTUAL_TOTAL(BigDecimal aCTUAL_TOTAL) {
		ACTUAL_TOTAL = aCTUAL_TOTAL;
	}
	public BigDecimal getGROSS_PERCENT_UPTO() {
		return GROSS_PERCENT_UPTO;
	}
	public void setGROSS_PERCENT_UPTO(BigDecimal gROSS_PERCENT_UPTO) {
		GROSS_PERCENT_UPTO = gROSS_PERCENT_UPTO;
	}
	public BigDecimal getREFUND_PERCENT_UPTO() {
		return REFUND_PERCENT_UPTO;
	}
	public void setREFUND_PERCENT_UPTO(BigDecimal rEFUND_PERCENT_UPTO) {
		REFUND_PERCENT_UPTO = rEFUND_PERCENT_UPTO;
	}
	public BigDecimal getREBATE_PERCENT_UPTO() {
		return REBATE_PERCENT_UPTO;
	}
	public void setREBATE_PERCENT_UPTO(BigDecimal rEBATE_PERCENT_UPTO) {
		REBATE_PERCENT_UPTO = rEBATE_PERCENT_UPTO;
	}
	public BigDecimal getTOTAL_PERCENT_UPTO() {
		return TOTAL_PERCENT_UPTO;
	}
	public void setTOTAL_PERCENT_UPTO(BigDecimal tOTAL_PERCENT_UPTO) {
		TOTAL_PERCENT_UPTO = tOTAL_PERCENT_UPTO;
	}
	public BigDecimal getTOTAL_TARGET_ACTUAL() {
		return TOTAL_TARGET_ACTUAL;
	}
	public void setTOTAL_TARGET_ACTUAL(BigDecimal tOTAL_TARGET_ACTUAL) {
		TOTAL_TARGET_ACTUAL = tOTAL_TARGET_ACTUAL;
	}
	public BigDecimal getTOTAL_TARGET_PERCENT_UPTO() {
		return TOTAL_TARGET_PERCENT_UPTO;
	}
	public void setTOTAL_TARGET_PERCENT_UPTO(BigDecimal tOTAL_TARGET_PERCENT_UPTO) {
		TOTAL_TARGET_PERCENT_UPTO = tOTAL_TARGET_PERCENT_UPTO;
	}

    
	
	
	public List<SP_DDM_ST_1_ZONE_Result> SP_DDM_ST_1_ZONE_Result(List<Object[]> listObjectArray){
		List <SP_DDM_ST_1_ZONE_Result> list = new ArrayList<SP_DDM_ST_1_ZONE_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_ST_1_ZONE_Result temp = new SP_DDM_ST_1_ZONE_Result();
		temp = generateResultBean_SP_DDM_ST_1_ZONE(objArray);
		list.add(temp);
		}
		return list;
		}

		public SP_DDM_ST_1_ZONE_Result generateResultBean_SP_DDM_ST_1_ZONE(Object[] objectArray)
		{
			SP_DDM_ST_1_ZONE_Result temp = new SP_DDM_ST_1_ZONE_Result();
			if(null!=objectArray[0] && objectArray[0]!=null) {
				temp.setTOTAL_COMM((int)( objectArray[0]));}
			if(null!=objectArray[1] && objectArray[1]!=null) {
			temp.setAMND((int)( objectArray[1]));}
			if(null!=objectArray[2] && objectArray[2]!=null) {
			temp.setCOMPLETE_COMM((int)( objectArray[2]));}
			if(null!=objectArray[3] && objectArray[3]!=null) {
			temp.setGROSS((BigDecimal)( objectArray[3]));}
			if(null!=objectArray[4] && objectArray[4]!=null) {
			temp.setREFUND((BigDecimal)( objectArray[4]));}
			if(null!=objectArray[5] && objectArray[5]!=null) {
			temp.setREBATE((BigDecimal)( objectArray[5]));}
			if(null!=objectArray[6] && objectArray[6]!=null) {
			temp.setTOTAL_FY((BigDecimal)( objectArray[6]));}
			
			if(null!=objectArray[7] && objectArray[7]!=null) {
			temp.setTOTAL_TARGET_UPTO((BigDecimal)( objectArray[7]));}
			if(null!=objectArray[8] && objectArray[8]!=null) {
			temp.setTOTAL_TARGET_FOR((BigDecimal)( objectArray[8]));}
			if(null!=objectArray[9] && objectArray[9]!=null) {
			temp.setGROSS_FOR_C((BigDecimal)( objectArray[9]));}
			if(null!=objectArray[10] && objectArray[10]!=null) {
			temp.setREFUND_FOR_C((BigDecimal)( objectArray[10]));}
					
			if(null!=objectArray[11] && objectArray[11]!=null) {
			temp.setREBATE_FOR_C((BigDecimal)( objectArray[11]));}
			if(null!=objectArray[12] && objectArray[12]!=null) {
			temp.setTOTAL_FOR_C((BigDecimal)( objectArray[12]));}
			
			if(null!=objectArray[13] && objectArray[13]!=null) {
			temp.setGROSS_FOR_P((BigDecimal)( objectArray[13]));}
			if(null!=objectArray[14] && objectArray[14]!=null) {
			temp.setREFUND_FOR_P((BigDecimal)( objectArray[14]));}
			if(null!=objectArray[15] && objectArray[15]!=null) {
			temp.setREBATE_FOR_P((BigDecimal)( objectArray[15]));}
			if(null!=objectArray[16] && objectArray[16]!=null) {
			temp.setTOTAL_FOR_P((BigDecimal)( objectArray[16]));}
			if(null!=objectArray[17] && objectArray[17]!=null) {
			temp.setGROSS_UPTO_C((BigDecimal)( objectArray[17]));}		
			
			if(null!=objectArray[18] && objectArray[18]!=null) {
			temp.setREFUND_UPTO_C((BigDecimal)( objectArray[18]));}
			if(null!=objectArray[19] && objectArray[19]!=null) {
			temp.setREBATE_UPTO_C((BigDecimal)( objectArray[19]));}
			if(null!=objectArray[20] && objectArray[20]!=null) {
			temp.setTOTAL_UPTO_C((BigDecimal)( objectArray[20]));}
			
			if(null!=objectArray[21] && objectArray[21]!=null) {
			temp.setGROSS_UPTO_P((BigDecimal)( objectArray[21]));}
			if(null!=objectArray[22] && objectArray[22]!=null) {
			temp.setREFUND_UPTO_P((BigDecimal)( objectArray[22]));}
			if(null!=objectArray[23] && objectArray[23]!=null) {
			temp.setREBATE_UPTO_P((BigDecimal)( objectArray[23]));}
			if(null!=objectArray[24] && objectArray[24]!=null) {
			temp.setTOTAL_UPTO_P((BigDecimal)( objectArray[24]));}
			
			
			if(null!=objectArray[25] && objectArray[25]!=null) {
			temp.setACTUAL_GROSS((BigDecimal)( objectArray[25]));}
			if(null!=objectArray[26] && objectArray[26]!=null) {
			temp.setACTUAL_REFUND((BigDecimal)( objectArray[26]));}
			if(null!=objectArray[27] && objectArray[27]!=null) {
			temp.setACTUAL_REBATE((BigDecimal)( objectArray[27]));}
			
			
			if(null!=objectArray[28] && objectArray[28]!=null) {
			temp.setACTUAL_TOTAL((BigDecimal)( objectArray[28]));}
			if(null!=objectArray[29] && objectArray[29]!=null) {
			temp.setGROSS_PERCENT_UPTO((BigDecimal)( objectArray[29]));}
			if(null!=objectArray[30] && objectArray[30]!=null) {
			temp.setREFUND_PERCENT_UPTO((BigDecimal)( objectArray[30]));}
			if(null!=objectArray[31] && objectArray[31]!=null) {
			temp.setREBATE_PERCENT_UPTO((BigDecimal)( objectArray[31]));}
			
			if(null!=objectArray[32] && objectArray[32]!=null) {
			temp.setTOTAL_PERCENT_UPTO((BigDecimal)( objectArray[32]));}
			if(null!=objectArray[33] && objectArray[33]!=null) {
			temp.setTOTAL_TARGET_ACTUAL((BigDecimal)( objectArray[33]));}
			if(null!=objectArray[34] && objectArray[34]!=null) {
			temp.setTOTAL_TARGET_PERCENT_UPTO((BigDecimal)( objectArray[34]));}
				
			
		return temp;

		}
	
    
    

}
