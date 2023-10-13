package com.ddm.cbic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;


@Entity

@NamedStoredProcedureQueries(
		{@NamedStoredProcedureQuery(name="LOGIN_ACDC",procedureName="SP_LOGIN_ACDC", resultClasses= {User.class},
				parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="paramId",type=String.class),
						@StoredProcedureParameter(mode=ParameterMode.IN,name="paramPass",type=String.class)}),			
		@NamedStoredProcedureQuery(name="LOGIN_GST_COMM",procedureName="SP_LOGIN_GST_COMM", resultClasses= {User.class},
					parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="paramId",type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,name="paramPass",type=String.class)}),
		@NamedStoredProcedureQuery(name="LOGIN_COMM",procedureName="SP_LOGIN_COMM", resultClasses= {User.class},
			parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="paramId",type=String.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,name="paramPass",type=String.class)}),	
		@NamedStoredProcedureQuery(name="LOGIN_GST_DIV",procedureName="SP_LOGIN_GST_DIV", resultClasses= {User.class},
		parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="paramId",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="paramPass",type=String.class)}),
		@NamedStoredProcedureQuery(name="LOGIN_GST_ZONE",procedureName="SP_LOGIN_GST_ZONE", resultClasses= {User.class},
		parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="paramId",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="paramPass",type=String.class)}),
		@NamedStoredProcedureQuery(name="LOGIN_REGION",procedureName="SP_LOGIN_REGION", resultClasses= {User.class},
		parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="paramId",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="paramPass",type=String.class)}),		
		@NamedStoredProcedureQuery(name="LOGIN_ZONE",procedureName="SP_LOGIN_ZONE", resultClasses= {User.class},
		parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="paramId",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="paramPass",type=String.class)})
		})
public class User{
	@Id
	String id;
	String code;
	String pass;
	String Name;
	String type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
