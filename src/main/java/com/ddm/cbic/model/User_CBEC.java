package com.ddm.cbic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.Table;

@Entity
@Table
@NamedStoredProcedureQueries(
		{@NamedStoredProcedureQuery(name="LOGIN_CBEC",procedureName="SP_LOGIN_CBEC", resultClasses= {User_CBEC.class},
		parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="paramId",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="paramPass",type=String.class)}),
		@NamedStoredProcedureQuery(name="LOGIN_FO",procedureName="SP_LOGIN_FO", resultClasses= {User_CBEC.class},
			parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="paramId",type=String.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,name="paramPass",type=String.class)})
		})
public class User_CBEC {
	@Id
	String id;
	String Name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}
