		package com.ddm.cbic.model;
		import java.util.ArrayList;
import java.util.List;
		
		
		public  class SP_DDM_CUS_6_COMM_Result
		{
		
		
		String ACTUAL_FOR;
		String ACTUAL_FOR_C;
		String ACTUAL_FOR_P;
		String ACTUAL_UPTO_ACTUAL;
		String ACTUAL_UPTO_C;
		String ACTUAL_UPTO_P;
		String ACTUAL_UPTO_PER;
		int AMND;
		String COMM_CODE;
		String COMMODITY_GROUP;
		String COMPLETE_COMM;
		String S_NO;
		String TOTAL_COMM;
		
		
		public int getAMND()
		{
		return AMND;
		}
		public String getACTUAL_FOR() {
			return ACTUAL_FOR;
		}
		public void setACTUAL_FOR(String aCTUAL_FOR) {
			ACTUAL_FOR = aCTUAL_FOR;
		}
		public String getACTUAL_FOR_C() {
			return ACTUAL_FOR_C;
		}
		public void setACTUAL_FOR_C(String aCTUAL_FOR_C) {
			ACTUAL_FOR_C = aCTUAL_FOR_C;
		}
		public String getACTUAL_FOR_P() {
			return ACTUAL_FOR_P;
		}
		public void setACTUAL_FOR_P(String aCTUAL_FOR_P) {
			ACTUAL_FOR_P = aCTUAL_FOR_P;
		}
		public String getACTUAL_UPTO_ACTUAL() {
			return ACTUAL_UPTO_ACTUAL;
		}
		public void setACTUAL_UPTO_ACTUAL(String aCTUAL_UPTO_ACTUAL) {
			ACTUAL_UPTO_ACTUAL = aCTUAL_UPTO_ACTUAL;
		}
		public String getACTUAL_UPTO_C() {
			return ACTUAL_UPTO_C;
		}
		public void setACTUAL_UPTO_C(String aCTUAL_UPTO_C) {
			ACTUAL_UPTO_C = aCTUAL_UPTO_C;
		}
		public String getACTUAL_UPTO_P() {
			return ACTUAL_UPTO_P;
		}
		public void setACTUAL_UPTO_P(String aCTUAL_UPTO_P) {
			ACTUAL_UPTO_P = aCTUAL_UPTO_P;
		}
		public String getACTUAL_UPTO_PER() {
			return ACTUAL_UPTO_PER;
		}
		public void setACTUAL_UPTO_PER(String aCTUAL_UPTO_PER) {
			ACTUAL_UPTO_PER = aCTUAL_UPTO_PER;
		}
		public void setAMND(int aMND)
		{
		AMND = aMND;
		}
		public String getCOMM_CODE()
		{
		return COMM_CODE;
		}
		public void setCOMM_CODE(String cOMM_CODE)
		{
		COMM_CODE = cOMM_CODE;
		}
		public String getCOMMODITY_GROUP()
		{
		return COMMODITY_GROUP;
		}
		public void setCOMMODITY_GROUP(String cOMMODITY_GROUP)
		{
		COMMODITY_GROUP = cOMMODITY_GROUP;
		}
		public String getCOMPLETE_COMM()
		{
		return COMPLETE_COMM;
		}
		public void setCOMPLETE_COMM(String cOMPLETE_COMM)
		{
		COMPLETE_COMM = cOMPLETE_COMM;
		}
		public String getS_NO()
		{
		return S_NO;
		}
		public void setS_NO(String s_NO)
		{
		S_NO = s_NO;
		}
		public String getTOTAL_COMM()
		{
		return TOTAL_COMM;
		}
		public void setTOTAL_COMM(String tOTAL_COMM)
		{
		TOTAL_COMM = tOTAL_COMM;
		}
		
		
		public List<SP_DDM_CUS_6_COMM_Result> generateResultList_SP_DDM_CUS_6_COMM(List<Object[]> listObjectArray){
		List <SP_DDM_CUS_6_COMM_Result> list = new ArrayList<SP_DDM_CUS_6_COMM_Result>();
		for(Object[] objArray : listObjectArray) {
		SP_DDM_CUS_6_COMM_Result temp = new SP_DDM_CUS_6_COMM_Result();
		temp = generateResultBean(objArray);
		list.add(temp);
		}
		return list;
		}
		
		
		public SP_DDM_CUS_6_COMM_Result generateResultBean(Object[] objectArray)
		{
		SP_DDM_CUS_6_COMM_Result temp = new SP_DDM_CUS_6_COMM_Result();
		
		System.out.println("objectArray[0]----"+objectArray[0]);
		System.out.println("objectArray[1]----"+objectArray[1]);
		System.out.println("objectArray[2]----"+objectArray[2]);
		System.out.println("objectArray[3]----"+objectArray[3]);
		System.out.println("objectArray[4]----"+objectArray[4]);
		System.out.println("objectArray[5]----"+objectArray[5]);
		System.out.println("objectArray[6]----"+objectArray[6]);
		System.out.println("objectArray[7]----"+objectArray[7]);
		System.out.println("objectArray[8]----"+objectArray[8]);
		System.out.println("objectArray[9]----"+objectArray[9]);
		System.out.println("objectArray[10]----"+objectArray[10]);
		System.out.println("objectArray[11]----"+objectArray[11]);
		System.out.println("objectArray[12]----"+objectArray[12]);
		
		temp.setS_NO(String.valueOf(objectArray[0]));
		temp.setCOMM_CODE(String.valueOf(objectArray[1]));
		temp.setCOMMODITY_GROUP(String.valueOf(objectArray[2]));
		temp.setACTUAL_FOR(String.valueOf(objectArray[3]));
		temp.setACTUAL_FOR_P(String.valueOf(objectArray[4]));
		temp.setACTUAL_UPTO_P(String.valueOf(objectArray[5]));
		temp.setACTUAL_FOR_C(String.valueOf(objectArray[6]));
		temp.setACTUAL_UPTO_C(String.valueOf(objectArray[7]));
		temp.setACTUAL_UPTO_ACTUAL(String.valueOf(objectArray[8]));
		temp.setACTUAL_UPTO_PER(String.valueOf(objectArray[9]));
		temp.setTOTAL_COMM(String.valueOf(objectArray[10]));
		temp.setCOMPLETE_COMM(String.valueOf(objectArray[11]));
		temp.setAMND((int)(objectArray[12]));
		
		
		
		//temp.setTOTAL_COMM((Integer.parseInt((String)(objectArray[10]))));
		//temp.setCOMPLETE_COMM((Integer.parseInt((String)(objectArray[11]))));
		
		
		/*
		 * temp.setACTUAL_FOR(String.valueOf(objectArray[0]));
		 * temp.setACTUAL_FOR_C(String.valueOf(objectArray[1]));
		 * temp.setACTUAL_FOR_P(String.valueOf(objectArray[2]));
		 * temp.setACTUAL_UPTO_ACTUAL(String.valueOf(objectArray[3]));
		 * temp.setACTUAL_UPTO_C(String.valueOf(objectArray[4]));
		 * temp.setACTUAL_UPTO_P(String.valueOf(objectArray[5]));
		 * temp.setACTUAL_UPTO_PER(String.valueOf(objectArray[6]));
		 * temp.setAMND((BigDecimal)(objectArray[7]));
		 * temp.setCOMM_CODE(String.valueOf(objectArray[8]));
		 * temp.setCOMMODITY_GROUP(String.valueOf(objectArray[9]));
		 * temp.setCOMPLETE_COMM((String)(objectArray[10]));
		 * temp.setS_NO(String.valueOf(objectArray[11]));
		 * temp.setTOTAL_COMM(String.valueOf(objectArray[12])); return temp;
		 * 
		 */
		return temp;
		}
		
		
		}
