package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public  class SP_DDM_CUS_4_COMM_TEMP_Result
{

	String COMM_CODE ;
    Date MM_YYYY ;
    short ASSESSEE_CODE ;
   // @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric") 
   // @NotEmpty(message="*")
    String ASSESSEE ;
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric") 
    @NotEmpty(message="*")
    String REVENUE_PRE_YEAR ;
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric") 
    @NotEmpty(message="*")
    String PRE_YEAR_FOR ;
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric") 
    @NotEmpty(message="*")
    String PRE_YEAR_UPTO ;
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric") 
    @NotEmpty(message="*")
    String CUR_YEAR_FOR ;
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric") 
    @NotEmpty(message="*")
    String CUR_YEAR_UPTO ;
    String REASONS ;
    
	
public String getCOMM_CODE() {
		return COMM_CODE;
	}


	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}


	public Date getMM_YYYY() {
		return MM_YYYY;
	}


	public void setMM_YYYY(Date mM_YYYY) {
		MM_YYYY = mM_YYYY;
	}


	


	public short getASSESSEE_CODE() {
		return ASSESSEE_CODE;
	}


	public void setASSESSEE_CODE(short aSSESSEE_CODE) {
		ASSESSEE_CODE = aSSESSEE_CODE;
	}


	public String getASSESSEE() {
		return ASSESSEE;
	}


	public void setASSESSEE(String aSSESSEE) {
		ASSESSEE = aSSESSEE;
	}


	public String getREVENUE_PRE_YEAR() {
		return REVENUE_PRE_YEAR;
	}


	public void setREVENUE_PRE_YEAR(String rEVENUE_PRE_YEAR) {
		REVENUE_PRE_YEAR = rEVENUE_PRE_YEAR;
	}


	public String getPRE_YEAR_FOR() {
		return PRE_YEAR_FOR;
	}


	public void setPRE_YEAR_FOR(String pRE_YEAR_FOR) {
		PRE_YEAR_FOR = pRE_YEAR_FOR;
	}


	public String getPRE_YEAR_UPTO() {
		return PRE_YEAR_UPTO;
	}


	public void setPRE_YEAR_UPTO(String pRE_YEAR_UPTO) {
		PRE_YEAR_UPTO = pRE_YEAR_UPTO;
	}


	public String getCUR_YEAR_FOR() {
		return CUR_YEAR_FOR;
	}


	public void setCUR_YEAR_FOR(String cUR_YEAR_FOR) {
		CUR_YEAR_FOR = cUR_YEAR_FOR;
	}


	public String getCUR_YEAR_UPTO() {
		return CUR_YEAR_UPTO;
	}


	public void setCUR_YEAR_UPTO(String cUR_YEAR_UPTO) {
		CUR_YEAR_UPTO = cUR_YEAR_UPTO;
	}


	public String getREASONS() {
		return REASONS;
	}


	public void setREASONS(String rEASONS) {
		REASONS = rEASONS;
	}


public List<SP_DDM_CUS_4_COMM_TEMP_Result> generateResultList_SP_DDM_CUS_4_COMM_TEMP(List<Object[]> listObjectArray){
List <SP_DDM_CUS_4_COMM_TEMP_Result> list = new ArrayList<SP_DDM_CUS_4_COMM_TEMP_Result>();
for(Object[] objArray : listObjectArray) {
SP_DDM_CUS_4_COMM_TEMP_Result temp = new SP_DDM_CUS_4_COMM_TEMP_Result();
temp = generateResultBeanSP_DDM_CUS_4_COMM_TEMP(objArray);
list.add(temp);
}
return list;
}


public SP_DDM_CUS_4_COMM_TEMP_Result generateResultBeanSP_DDM_CUS_4_COMM_TEMP(Object[] objectArray)
{
	
SP_DDM_CUS_4_COMM_TEMP_Result temp = new SP_DDM_CUS_4_COMM_TEMP_Result();

temp.setCOMM_CODE((String)(objectArray[0])) ;
temp.setMM_YYYY((Date)(objectArray[1])) ;
temp.setASSESSEE_CODE((short)(objectArray[2])) ;
temp.setASSESSEE(String.valueOf(objectArray[3])) ;
temp.setREVENUE_PRE_YEAR(String.valueOf(objectArray[4])) ;
temp.setPRE_YEAR_FOR (String.valueOf(objectArray[5]));
temp.setPRE_YEAR_UPTO (String.valueOf(objectArray[6]));
temp.setCUR_YEAR_FOR (String.valueOf(objectArray[7]));
temp.setCUR_YEAR_UPTO (String.valueOf(objectArray[8]));
temp.setREASONS(String.valueOf(objectArray[9])) ;

return temp;
}


}
