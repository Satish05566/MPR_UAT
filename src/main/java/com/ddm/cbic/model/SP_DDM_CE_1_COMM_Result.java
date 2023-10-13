package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SP_DDM_CE_1_COMM_Result {
	public String TOTAL_COMM ;
    public int AMND ;
    public String COMPLETE_COMM ;
    public BigDecimal POL_CRUDE ;
    public BigDecimal POL_OTHER ;
    public BigDecimal NON_POL ;
    public BigDecimal TOTAL_FY_GROSS ;
    public BigDecimal REFUND ;
    public BigDecimal REBATE ;
    public BigDecimal TOTAL_FY ;
    public BigDecimal TOTAL_TARGET_UPTO ;
    public BigDecimal TOTAL_TARGET_FOR ;
    public String COMM_CODE ;
    public BigDecimal POL_CRUDE_FOR_C ;
    public BigDecimal POL_OTHER_FOR_C ;
    
    
    public BigDecimal NON_POL_FOR_C ;
    public BigDecimal TOTAL_GROSS_FOR_C ;
    public BigDecimal REFUND_FOR_C ;
    public BigDecimal REBATE_FOR_C ;
    public BigDecimal TOTAL_FOR_C ;
    public BigDecimal POL_CRUDE_FOR_P ;
    public BigDecimal POL_OTHER_FOR_P ;
    public BigDecimal NON_POL_FOR_P ;
    public BigDecimal TOTAL_GROSS_FOR_P ;
    public BigDecimal REFUND_FOR_P ;
    public BigDecimal REBATE_FOR_P ;
    public BigDecimal TOTAL_FOR_P ;
    public BigDecimal POL_CRUDE_UPTO_C ;
    public BigDecimal POL_OTHER_UPTO_C ;
    public BigDecimal NON_POL_UPTO_C ;
    public BigDecimal TOTAL_GROSS_UPTO_C ;
    public BigDecimal REFUND_UPTO_C ;
    public BigDecimal REBATE_UPTO_C ;
    
    public BigDecimal TOTAL_UPTO_C ;
    public BigDecimal POL_CRUDE_UPTO_P ;
    public BigDecimal POL_OTHER_UPTO_P ;
    public BigDecimal NON_POL_UPTO_P ;
    public BigDecimal TOTAL_GROSS_UPTO_P ;
    public BigDecimal REFUND_UPTO_P ;
    public BigDecimal REBATE_UPTO_P ;
    public BigDecimal TOTAL_UPTO_P ;
    public BigDecimal ACTUAL_POL_CRUDE ;
    public BigDecimal ACTUAL_POL_OTHER ;
    public BigDecimal ACTUAL_NON_POL ;
    public BigDecimal ACTUAL_GROSS_TOTAL ;
    public BigDecimal ACTUAL_REFUND ;
    public BigDecimal ACTUAL_REBATE ;
    public BigDecimal ACTUAL_TOTAL ;
    public BigDecimal POL_CRUDE_PERCENT_UPTO ;
    public BigDecimal POL_OTHER_PERCENT_UPTO ;
    public BigDecimal NON_POL_PERCENT_UPTO ;
    public BigDecimal TOTAL_GROSS_PERCENT_UPTO ;
    public BigDecimal REFUND_PERCENT_UPTO ;
    public BigDecimal REBATE_PERCENT_UPTO ;
    public BigDecimal TOTAL_PERCENT_UPTO ;
    public BigDecimal TOTAL_TARGET_ACTUAL ;
    public BigDecimal TOTAL_TARGET_PERCENT_UPTO ;
    
	public String getTOTAL_COMM() {
		return TOTAL_COMM;
	}
	public void setTOTAL_COMM(String tOTAL_COMM) {
		TOTAL_COMM = tOTAL_COMM;
	}
	public int getAMND() {
		return AMND;
	}
	public void setAMND(int aMND) {
		AMND = aMND;
	}
	public String getCOMPLETE_COMM() {
		return COMPLETE_COMM;
	}
	public void setCOMPLETE_COMM(String cOMPLETE_COMM) {
		COMPLETE_COMM = cOMPLETE_COMM;
	}
	public BigDecimal getPOL_CRUDE() {
		return POL_CRUDE;
	}
	public void setPOL_CRUDE(BigDecimal pOL_CRUDE) {
		POL_CRUDE = pOL_CRUDE;
	}
	public BigDecimal getPOL_OTHER() {
		return POL_OTHER;
	}
	public void setPOL_OTHER(BigDecimal pOL_OTHER) {
		POL_OTHER = pOL_OTHER;
	}
	public BigDecimal getNON_POL() {
		return NON_POL;
	}
	public void setNON_POL(BigDecimal nON_POL) {
		NON_POL = nON_POL;
	}
	public BigDecimal getTOTAL_FY_GROSS() {
		return TOTAL_FY_GROSS;
	}
	public void setTOTAL_FY_GROSS(BigDecimal tOTAL_FY_GROSS) {
		TOTAL_FY_GROSS = tOTAL_FY_GROSS;
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
	public String getCOMM_CODE() {
		return COMM_CODE;
	}
	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}
	public BigDecimal getPOL_CRUDE_FOR_C() {
		return POL_CRUDE_FOR_C;
	}
	public void setPOL_CRUDE_FOR_C(BigDecimal pOL_CRUDE_FOR_C) {
		POL_CRUDE_FOR_C = pOL_CRUDE_FOR_C;
	}
	public BigDecimal getPOL_OTHER_FOR_C() {
		return POL_OTHER_FOR_C;
	}
	public void setPOL_OTHER_FOR_C(BigDecimal pOL_OTHER_FOR_C) {
		POL_OTHER_FOR_C = pOL_OTHER_FOR_C;
	}
	public BigDecimal getNON_POL_FOR_C() {
		return NON_POL_FOR_C;
	}
	public void setNON_POL_FOR_C(BigDecimal nON_POL_FOR_C) {
		NON_POL_FOR_C = nON_POL_FOR_C;
	}
	public BigDecimal getTOTAL_GROSS_FOR_C() {
		return TOTAL_GROSS_FOR_C;
	}
	public void setTOTAL_GROSS_FOR_C(BigDecimal tOTAL_GROSS_FOR_C) {
		TOTAL_GROSS_FOR_C = tOTAL_GROSS_FOR_C;
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
	public BigDecimal getPOL_CRUDE_FOR_P() {
		return POL_CRUDE_FOR_P;
	}
	public void setPOL_CRUDE_FOR_P(BigDecimal pOL_CRUDE_FOR_P) {
		POL_CRUDE_FOR_P = pOL_CRUDE_FOR_P;
	}
	public BigDecimal getPOL_OTHER_FOR_P() {
		return POL_OTHER_FOR_P;
	}
	public void setPOL_OTHER_FOR_P(BigDecimal pOL_OTHER_FOR_P) {
		POL_OTHER_FOR_P = pOL_OTHER_FOR_P;
	}
	public BigDecimal getNON_POL_FOR_P() {
		return NON_POL_FOR_P;
	}
	public void setNON_POL_FOR_P(BigDecimal nON_POL_FOR_P) {
		NON_POL_FOR_P = nON_POL_FOR_P;
	}
	public BigDecimal getTOTAL_GROSS_FOR_P() {
		return TOTAL_GROSS_FOR_P;
	}
	public void setTOTAL_GROSS_FOR_P(BigDecimal tOTAL_GROSS_FOR_P) {
		TOTAL_GROSS_FOR_P = tOTAL_GROSS_FOR_P;
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
	public BigDecimal getPOL_CRUDE_UPTO_C() {
		return POL_CRUDE_UPTO_C;
	}
	public void setPOL_CRUDE_UPTO_C(BigDecimal pOL_CRUDE_UPTO_C) {
		POL_CRUDE_UPTO_C = pOL_CRUDE_UPTO_C;
	}
	public BigDecimal getPOL_OTHER_UPTO_C() {
		return POL_OTHER_UPTO_C;
	}
	public void setPOL_OTHER_UPTO_C(BigDecimal pOL_OTHER_UPTO_C) {
		POL_OTHER_UPTO_C = pOL_OTHER_UPTO_C;
	}
	public BigDecimal getNON_POL_UPTO_C() {
		return NON_POL_UPTO_C;
	}
	public void setNON_POL_UPTO_C(BigDecimal nON_POL_UPTO_C) {
		NON_POL_UPTO_C = nON_POL_UPTO_C;
	}
	public BigDecimal getTOTAL_GROSS_UPTO_C() {
		return TOTAL_GROSS_UPTO_C;
	}
	public void setTOTAL_GROSS_UPTO_C(BigDecimal tOTAL_GROSS_UPTO_C) {
		TOTAL_GROSS_UPTO_C = tOTAL_GROSS_UPTO_C;
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
	public BigDecimal getPOL_CRUDE_UPTO_P() {
		return POL_CRUDE_UPTO_P;
	}
	public void setPOL_CRUDE_UPTO_P(BigDecimal pOL_CRUDE_UPTO_P) {
		POL_CRUDE_UPTO_P = pOL_CRUDE_UPTO_P;
	}
	public BigDecimal getPOL_OTHER_UPTO_P() {
		return POL_OTHER_UPTO_P;
	}
	public void setPOL_OTHER_UPTO_P(BigDecimal pOL_OTHER_UPTO_P) {
		POL_OTHER_UPTO_P = pOL_OTHER_UPTO_P;
	}
	public BigDecimal getNON_POL_UPTO_P() {
		return NON_POL_UPTO_P;
	}
	public void setNON_POL_UPTO_P(BigDecimal nON_POL_UPTO_P) {
		NON_POL_UPTO_P = nON_POL_UPTO_P;
	}
	public BigDecimal getTOTAL_GROSS_UPTO_P() {
		return TOTAL_GROSS_UPTO_P;
	}
	public void setTOTAL_GROSS_UPTO_P(BigDecimal tOTAL_GROSS_UPTO_P) {
		TOTAL_GROSS_UPTO_P = tOTAL_GROSS_UPTO_P;
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
	public BigDecimal getACTUAL_POL_CRUDE() {
		return ACTUAL_POL_CRUDE;
	}
	public void setACTUAL_POL_CRUDE(BigDecimal aCTUAL_POL_CRUDE) {
		ACTUAL_POL_CRUDE = aCTUAL_POL_CRUDE;
	}
	public BigDecimal getACTUAL_POL_OTHER() {
		return ACTUAL_POL_OTHER;
	}
	public void setACTUAL_POL_OTHER(BigDecimal aCTUAL_POL_OTHER) {
		ACTUAL_POL_OTHER = aCTUAL_POL_OTHER;
	}
	public BigDecimal getACTUAL_NON_POL() {
		return ACTUAL_NON_POL;
	}
	public void setACTUAL_NON_POL(BigDecimal aCTUAL_NON_POL) {
		ACTUAL_NON_POL = aCTUAL_NON_POL;
	}
	public BigDecimal getACTUAL_GROSS_TOTAL() {
		return ACTUAL_GROSS_TOTAL;
	}
	public void setACTUAL_GROSS_TOTAL(BigDecimal aCTUAL_GROSS_TOTAL) {
		ACTUAL_GROSS_TOTAL = aCTUAL_GROSS_TOTAL;
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
	public BigDecimal getPOL_CRUDE_PERCENT_UPTO() {
		return POL_CRUDE_PERCENT_UPTO;
	}
	public void setPOL_CRUDE_PERCENT_UPTO(BigDecimal pOL_CRUDE_PERCENT_UPTO) {
		POL_CRUDE_PERCENT_UPTO = pOL_CRUDE_PERCENT_UPTO;
	}
	public BigDecimal getPOL_OTHER_PERCENT_UPTO() {
		return POL_OTHER_PERCENT_UPTO;
	}
	public void setPOL_OTHER_PERCENT_UPTO(BigDecimal pOL_OTHER_PERCENT_UPTO) {
		POL_OTHER_PERCENT_UPTO = pOL_OTHER_PERCENT_UPTO;
	}
	public BigDecimal getNON_POL_PERCENT_UPTO() {
		return NON_POL_PERCENT_UPTO;
	}
	public void setNON_POL_PERCENT_UPTO(BigDecimal nON_POL_PERCENT_UPTO) {
		NON_POL_PERCENT_UPTO = nON_POL_PERCENT_UPTO;
	}
	public BigDecimal getTOTAL_GROSS_PERCENT_UPTO() {
		return TOTAL_GROSS_PERCENT_UPTO;
	}
	public void setTOTAL_GROSS_PERCENT_UPTO(BigDecimal tOTAL_GROSS_PERCENT_UPTO) {
		TOTAL_GROSS_PERCENT_UPTO = tOTAL_GROSS_PERCENT_UPTO;
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
    
	
	public List<SP_DDM_CE_1_COMM_Result> sp_DDM_CE_1_COMM_Result(List<Object[]> listObjectArray){
		List <SP_DDM_CE_1_COMM_Result> list = new ArrayList<SP_DDM_CE_1_COMM_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_CE_1_COMM_Result temp = new SP_DDM_CE_1_COMM_Result();
		temp = generateResultBean_SP_DDM_CE_1_COMM(objArray);
		list.add(temp);
		}
		return list;
		}

		public SP_DDM_CE_1_COMM_Result generateResultBean_SP_DDM_CE_1_COMM(Object[] objectArray)
		{
			SP_DDM_CE_1_COMM_Result temp = new SP_DDM_CE_1_COMM_Result();
			if(null!=objectArray[0] && objectArray[0]!=null) {
				temp.setTOTAL_COMM((String)( objectArray[0]));}
			if(null!=objectArray[1] && objectArray[1]!=null) {
				temp.setAMND((int)( objectArray[1]));}
			if(null!=objectArray[2] && objectArray[2]!=null) {
			temp.setCOMPLETE_COMM((String)( objectArray[2]));}
			if(null!=objectArray[3] && objectArray[3]!=null) {
			temp.setPOL_CRUDE((BigDecimal)( objectArray[3]));}
			if(null!=objectArray[4] && objectArray[4]!=null) {
			temp.setPOL_OTHER((BigDecimal)( objectArray[4]));}
			if(null!=objectArray[5] && objectArray[5]!=null) {
			temp.setNON_POL((BigDecimal)( objectArray[5]));}
			if(null!=objectArray[6] && objectArray[6]!=null) {
			temp.setTOTAL_FY_GROSS((BigDecimal)( objectArray[6]));}
			
			if(null!=objectArray[7] && objectArray[7]!=null) {
			temp.setREFUND((BigDecimal)( objectArray[7]));}
			if(null!=objectArray[8] && objectArray[8]!=null) {
			temp.setREBATE((BigDecimal)( objectArray[8]));}
			if(null!=objectArray[9] && objectArray[9]!=null) {
			temp.setTOTAL_FY((BigDecimal)( objectArray[9]));}
			if(null!=objectArray[10] && objectArray[10]!=null) {
			temp.setTOTAL_TARGET_UPTO((BigDecimal)( objectArray[10]));}
			if(null!=objectArray[11] && objectArray[11]!=null) {
			temp.setTOTAL_TARGET_FOR((BigDecimal)( objectArray[11]));}
			if(null!=objectArray[12] && objectArray[12]!=null) {
			temp.setCOMM_CODE((String)( objectArray[12]));}
			if(null!=objectArray[13] && objectArray[13]!=null) {
			temp.setPOL_CRUDE_FOR_C((BigDecimal)( objectArray[13]));}
			if(null!=objectArray[14] && objectArray[14]!=null) {
			temp.setPOL_OTHER_FOR_C((BigDecimal)( objectArray[14]));}
			
			if(null!=objectArray[15] && objectArray[15]!=null) {
			temp.setNON_POL_FOR_C((BigDecimal)( objectArray[15]));}
			if(null!=objectArray[16] && objectArray[16]!=null) {
			temp.setTOTAL_GROSS_FOR_C((BigDecimal)( objectArray[16]));}
			if(null!=objectArray[17] && objectArray[17]!=null) {
			temp.setREFUND_FOR_C((BigDecimal)( objectArray[17]));}
			if(null!=objectArray[18] && objectArray[18]!=null) {
			temp.setREBATE_FOR_C((BigDecimal)( objectArray[18]));}
			if(null!=objectArray[19] && objectArray[19]!=null) {
			temp.setTOTAL_FOR_C((BigDecimal)( objectArray[19]));}
			if(null!=objectArray[20] && objectArray[20]!=null) {
			temp.setPOL_CRUDE_FOR_P((BigDecimal)( objectArray[20]));}
			if(null!=objectArray[21] && objectArray[21]!=null) {
			temp.setPOL_OTHER_FOR_P((BigDecimal)( objectArray[21]));}
			if(null!=objectArray[22] && objectArray[22]!=null) {
			temp.setNON_POL_FOR_P((BigDecimal)( objectArray[22]));}
			if(null!=objectArray[23] && objectArray[23]!=null) {
			temp.setTOTAL_GROSS_FOR_P((BigDecimal)( objectArray[23]));}
			if(null!=objectArray[24] && objectArray[24]!=null) {
			temp.setREFUND_FOR_P((BigDecimal)( objectArray[24]));}
			if(null!=objectArray[25] && objectArray[25]!=null) {
			temp.setREBATE_FOR_P((BigDecimal)( objectArray[25]));}
			if(null!=objectArray[26] && objectArray[26]!=null) {
			temp.setTOTAL_FOR_P((BigDecimal)( objectArray[26]));}
			if(null!=objectArray[27] && objectArray[27]!=null) {
			temp.setPOL_CRUDE_UPTO_C((BigDecimal)( objectArray[27]));}
			if(null!=objectArray[28] && objectArray[28]!=null) {
			temp.setPOL_OTHER_UPTO_C((BigDecimal)( objectArray[28]));}
			if(null!=objectArray[29] && objectArray[29]!=null) {
			temp.setNON_POL_UPTO_C((BigDecimal)( objectArray[29]));}
			if(null!=objectArray[30] && objectArray[30]!=null) {
			temp.setTOTAL_GROSS_UPTO_C((BigDecimal)( objectArray[30]));}
			if(null!=objectArray[31] && objectArray[31]!=null) {
			temp.setREFUND_UPTO_C((BigDecimal)( objectArray[31]));}
			if(null!=objectArray[32] && objectArray[32]!=null) {
			temp.setREBATE_UPTO_C((BigDecimal)( objectArray[32]));}
			
			if(null!=objectArray[33] && objectArray[33]!=null) {
			temp.setTOTAL_UPTO_C((BigDecimal)( objectArray[33]));}
			if(null!=objectArray[34] && objectArray[34]!=null) {
			temp.setPOL_CRUDE_UPTO_P((BigDecimal)( objectArray[34]));}
			if(null!=objectArray[35] && objectArray[35]!=null) {
			temp.setPOL_OTHER_UPTO_P((BigDecimal)( objectArray[35]));}
			if(null!=objectArray[36] && objectArray[36]!=null) {
			temp.setNON_POL_UPTO_P((BigDecimal)( objectArray[36]));}
			if(null!=objectArray[37] && objectArray[37]!=null) {
			temp.setTOTAL_GROSS_UPTO_P((BigDecimal)( objectArray[37]));}
			if(null!=objectArray[38] && objectArray[38]!=null) {
			temp.setREFUND_UPTO_P((BigDecimal)( objectArray[38]));}
			
			if(null!=objectArray[39] && objectArray[39]!=null) {
			temp.setREBATE_UPTO_P((BigDecimal)( objectArray[39]));}
			if(null!=objectArray[40] && objectArray[40]!=null) {
			temp.setTOTAL_UPTO_P((BigDecimal)( objectArray[40]));}
			if(null!=objectArray[41] && objectArray[41]!=null) {
			temp.setACTUAL_POL_CRUDE((BigDecimal)( objectArray[41]));}
			if(null!=objectArray[42] && objectArray[42]!=null) {
			temp.setACTUAL_POL_OTHER((BigDecimal)( objectArray[42]));}
			if(null!=objectArray[43] && objectArray[43]!=null) {
			temp.setACTUAL_NON_POL((BigDecimal)( objectArray[43]));}
			if(null!=objectArray[44] && objectArray[44]!=null) {
			temp.setACTUAL_GROSS_TOTAL((BigDecimal)( objectArray[44]));}
			if(null!=objectArray[45] && objectArray[45]!=null) {
			temp.setACTUAL_REFUND((BigDecimal)( objectArray[45]));}
			if(null!=objectArray[46] && objectArray[46]!=null) {
			temp.setACTUAL_REBATE((BigDecimal)( objectArray[46]));}
			if(null!=objectArray[47] && objectArray[47]!=null) {
			temp.setACTUAL_TOTAL((BigDecimal)( objectArray[47]));}
			if(null!=objectArray[48] && objectArray[48]!=null) {
			temp.setPOL_CRUDE_PERCENT_UPTO((BigDecimal)( objectArray[48]));}
			if(null!=objectArray[49] && objectArray[49]!=null) {
			temp.setPOL_OTHER_PERCENT_UPTO((BigDecimal)( objectArray[49]));}
			
			if(null!=objectArray[50] && objectArray[50]!=null) {
			temp.setNON_POL_PERCENT_UPTO((BigDecimal)( objectArray[50]));}
			
			if(null!=objectArray[51] && objectArray[51]!=null) {
			temp.setTOTAL_GROSS_PERCENT_UPTO((BigDecimal)( objectArray[51]));}
			if(null!=objectArray[52] && objectArray[52]!=null) {
			temp.setREFUND_PERCENT_UPTO((BigDecimal)( objectArray[52]));}
			if(null!=objectArray[53] && objectArray[53]!=null) {
			temp.setREBATE_PERCENT_UPTO((BigDecimal)( objectArray[53]));}
			
			if(null!=objectArray[54] && objectArray[54]!=null) {
			temp.setTOTAL_PERCENT_UPTO((BigDecimal)( objectArray[54]));}
			if(null!=objectArray[55] && objectArray[55]!=null) {
			temp.setTOTAL_TARGET_ACTUAL((BigDecimal)( objectArray[55]));}
			if(null!=objectArray[56] && objectArray[56]!=null) {
			temp.setTOTAL_TARGET_PERCENT_UPTO((BigDecimal)( objectArray[56]));}
			
		return temp;

		}
    
    

}
