package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DGI_GST_16_REFUND_CATEGORY {
	 
	private String refund_category_id;
	private String refund_Category_name;
		

	
	public String getRefund_category_id() {
		return refund_category_id;
	}


	public void setRefund_category_id(String refund_category_id) {
		this.refund_category_id = refund_category_id;
	}


	public String getRefund_Category_name() {
		return refund_Category_name;
	}


	public void setRefund_Category_name(String refund_Category_name) {
		this.refund_Category_name = refund_Category_name;
	}


	public List<SP_DGI_GST_16_REFUND_CATEGORY>  generateAllResult(List <Object []> resultList) {
		if(resultList.size()==0)
			  return null;
		else {
		List <SP_DGI_GST_16_REFUND_CATEGORY> list =  new ArrayList<SP_DGI_GST_16_REFUND_CATEGORY>();
		for(Object [] objectArray : resultList) { 
			SP_DGI_GST_16_REFUND_CATEGORY temp = new SP_DGI_GST_16_REFUND_CATEGORY ();
			
		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list;
		}
	}
	
	
	 private SP_DGI_GST_16_REFUND_CATEGORY generateReportBean(Object[] objectArray) {

			SP_DGI_GST_16_REFUND_CATEGORY temp =  new SP_DGI_GST_16_REFUND_CATEGORY();
			
			if(null != objectArray[0]) {temp.setRefund_category_id(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setRefund_Category_name(String.valueOf(objectArray[1]));}
			
				
   return temp;
	
	 }
	
	
	
	
	
	
	

}
