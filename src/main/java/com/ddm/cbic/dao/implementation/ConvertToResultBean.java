package com.ddm.cbic.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import com.ddm.cbic.model.User_GN;

public class ConvertToResultBean {

	public static List<User_GN> generateResultBean(List<Object []> listObjectArray) {
		
		List<User_GN> list = new ArrayList<User_GN>();
		for (Object [] objArray : listObjectArray) {
			User_GN user_GN = new User_GN();
			user_GN.setId((String)(objArray[0]));
			user_GN.setCode((String)(objArray[1]));
			user_GN.setPass((String)(objArray[2]));
			user_GN.setName((String)(objArray[3]));
			user_GN.setType((String)(objArray[4]));
		    
		    list.add(user_GN);
		}
		return list;
	}
}
