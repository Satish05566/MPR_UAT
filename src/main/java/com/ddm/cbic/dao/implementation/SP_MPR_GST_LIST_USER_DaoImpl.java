package com.ddm.cbic.dao.implementation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ddm.cbic.model.SP_MPR_GST_LIST_USER_Result;

@Repository
public class SP_MPR_GST_LIST_USER_DaoImpl {
	@Autowired
	private EntityManager em;
	private SP_MPR_GST_LIST_USER_Result sp_MPR_GST_LIST_USER_Result = new SP_MPR_GST_LIST_USER_Result();
	@SuppressWarnings("unchecked")
	public  List<SP_MPR_GST_LIST_USER_Result > generateResultBeanList(Object[] objArray){
		try {		
		System.out.println(" before  query.getResultList().size() ");
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_MPR_GST_LIST_USER");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	if(null!=objArray[0]) {
			if(!objArray[0].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[0].toString() "+objArray[0].toString());query.setParameter(1,objArray[0].toString() );}
	}
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	if(null!=objArray[1]) {
		if(!objArray[1].toString().trim().equalsIgnoreCase("null")){System.out.println(" --objArray[1].toString() "+objArray[1].toString());query.setParameter(2,objArray[1].toString() );}
	}
	
	query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	if(null!=objArray[2])
		{	if(!objArray[2].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[2].toString() "+objArray[2].toString());query.setParameter(3,objArray[2].toString() );}
		
		}
	//query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	
	query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	if(null!=objArray[3]) 
	{
		if(!objArray[3].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[3].toString() "+objArray[3].toString());query.setParameter(4,objArray[3].toString() );}
	}
	//query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	
	query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	if(null!=objArray[4])
		{
		if(!objArray[4].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[4].toString() "+objArray[4].toString());query.setParameter(5,objArray[4].toString() );}
		}
	query.execute();
	
	System.out.println("  query.getResultList().size() ");
	System.out.println("  query.getResultList().size() " +  query.getResultList().size());
	return sp_MPR_GST_LIST_USER_Result.generateResultBeanList(query.getResultList());
		}
		finally {
			em.close();
			
		}
}

public  SP_MPR_GST_LIST_USER_Result  generateResultBean(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_MPR_GST_LIST_USER");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	if(null!=objArray[0]) {
			if(!objArray[0].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[0].toString() "+objArray[0].toString());query.setParameter(1,objArray[0].toString() );}
	}
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	if(null!=objArray[1]) {
		if(!objArray[1].toString().trim().equalsIgnoreCase("null")){System.out.println(" --objArray[1].toString() "+objArray[1].toString());query.setParameter(2,objArray[1].toString() );}
	}
	
	query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	if(null!=objArray[2])
		{	if(!objArray[2].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[2].toString() "+objArray[2].toString());query.setParameter(3,objArray[2].toString() );}
		
		}
	//query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	
	query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	if(null!=objArray[3]) 
	{
		if(!objArray[3].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[3].toString() "+objArray[3].toString());query.setParameter(4,objArray[3].toString() );}
	}
	//query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	
	query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	if(null!=objArray[4])
		{
		if(!objArray[4].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[4].toString() "+objArray[4].toString());query.setParameter(5,objArray[4].toString() );}
		}
	query.execute();
	return sp_MPR_GST_LIST_USER_Result.generateResultBean((Object[])query.getResultList().get(0));
	}
	finally {
		em.close();
		
	}
}

public  boolean  executeProc(Object[] objArray){
	try {	
	StoredProcedureQuery query = em.createStoredProcedureQuery("SP_MPR_GST_LIST_USER");
	query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	if(null!=objArray[0]) {
			if(!objArray[0].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[0].toString() "+objArray[0].toString());query.setParameter(1,objArray[0].toString() );}
	}
	query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	if(null!=objArray[1]) {
		if(!objArray[1].toString().trim().equalsIgnoreCase("null")){System.out.println(" --objArray[1].toString() "+objArray[1].toString());query.setParameter(2,objArray[1].toString() );}
	}
	
	query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	if(null!=objArray[2])
		{	if(!objArray[2].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[2].toString() "+objArray[2].toString());query.setParameter(3,objArray[2].toString() );}
		
		}
	//query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	
	query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	if(null!=objArray[3]) 
	{
		if(!objArray[3].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[3].toString() "+objArray[3].toString());query.setParameter(4,objArray[3].toString() );}
	}
	//query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	
	query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	if(null!=objArray[4])
		{
		if(!objArray[4].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[4].toString() "+objArray[4].toString());query.setParameter(5,objArray[4].toString() );}
		}
	return query.execute();
	}
	finally {
		em.close();
		
	}
}

public  List<SP_MPR_GST_LIST_USER_Result > generateResultBeanListNonGST(Object[] objArray){
	try {		
	System.out.println(" before  query.getResultList().size() ");
StoredProcedureQuery query = em.createStoredProcedureQuery("SP_MPR_LIST_USER");
query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
if(null!=objArray[0]) {
		if(!objArray[0].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[0].toString() "+objArray[0].toString());query.setParameter(1,objArray[0].toString() );}
}
query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
if(null!=objArray[1]) {
	if(!objArray[1].toString().trim().equalsIgnoreCase("null")){System.out.println(" --objArray[1].toString() "+objArray[1].toString());query.setParameter(2,objArray[1].toString() );}
}

query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
if(null!=objArray[2])
	{	if(!objArray[2].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[2].toString() "+objArray[2].toString());query.setParameter(3,objArray[2].toString() );}
	
	}
//query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);

query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
if(null!=objArray[3]) 
{
	if(!objArray[3].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[3].toString() "+objArray[3].toString());query.setParameter(4,objArray[3].toString() );}
}
//query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);

query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
if(null!=objArray[4])
	{
	if(!objArray[4].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[4].toString() "+objArray[4].toString());query.setParameter(5,objArray[4].toString() );}
	}
query.execute();

System.out.println("  query.getResultList().size() ");
System.out.println("  query.getResultList().size() " +  query.getResultList().size());
return sp_MPR_GST_LIST_USER_Result.generateResultBeanList(query.getResultList());
	}
	finally {
		em.close();
		
	}
}

public  SP_MPR_GST_LIST_USER_Result  generateResultBeanNonGST(Object[] objArray){
try {	
StoredProcedureQuery query = em.createStoredProcedureQuery("SP_MPR_LIST_USER");
query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
if(null!=objArray[0]) {
		if(!objArray[0].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[0].toString() "+objArray[0].toString());query.setParameter(1,objArray[0].toString() );}
}
query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
if(null!=objArray[1]) {
	if(!objArray[1].toString().trim().equalsIgnoreCase("null")){System.out.println(" --objArray[1].toString() "+objArray[1].toString());query.setParameter(2,objArray[1].toString() );}
}

query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
if(null!=objArray[2])
	{	if(!objArray[2].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[2].toString() "+objArray[2].toString());query.setParameter(3,objArray[2].toString() );}
	
	}
//query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);

query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
if(null!=objArray[3]) 
{
	if(!objArray[3].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[3].toString() "+objArray[3].toString());query.setParameter(4,objArray[3].toString() );}
}
//query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);

query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
if(null!=objArray[4])
	{
	if(!objArray[4].toString().trim().equalsIgnoreCase("null")){System.out.println("-- objArray[4].toString() "+objArray[4].toString());query.setParameter(5,objArray[4].toString() );}
	}
query.execute();
return sp_MPR_GST_LIST_USER_Result.generateResultBean((Object[])query.getResultList().get(0));
}
finally {
	em.close();
	
}
}

public  List<String>  generateResultBeanLabels(){
	return  sp_MPR_GST_LIST_USER_Result.generateResultBeanLabels();
}

}
