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
//import com.ddm.cbic.model.SP_CHANGE_PROFILE_UPDATE_Result;

@Repository
public class SP_CHANGE_PROFILE_UPDATE_DaoImpl {
	/*
	 * @Autowired private EntityManager em; private SP_CHANGE_PROFILE_UPDATE_Result
	 * sp_CHANGE_PROFILE_UPDATE_Result = new SP_CHANGE_PROFILE_UPDATE_Result();
	 * public List<SP_CHANGE_PROFILE_UPDATE_Result > generateResultBeanList(Object[]
	 * objArray){
	 * 
	 * StoredProcedureQuery query =
	 * em.createStoredProcedureQuery("SP_CHANGE_PROFILE_UPDATE");
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,(String)objArray[0] );
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * query.setParameter(2,(String)objArray[1] );
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * query.setParameter(3,(String)objArray[2] );
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	 * query.setParameter(4,(String)objArray[3] );
	 * query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	 * query.setParameter(5,(String)objArray[4] );
	 * query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
	 * query.setParameter(6,(String)objArray[5] );
	 * query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
	 * query.setParameter(7,(String)objArray[6] );
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,(String)objArray[0] );
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * query.setParameter(2,(String)objArray[1] );
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * query.setParameter(3,(String)objArray[2] );
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	 * query.setParameter(4,(String)objArray[3] );
	 * query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	 * query.setParameter(5,(String)objArray[4] );
	 * query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
	 * query.setParameter(6,(String)objArray[5] );
	 * query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
	 * query.setParameter(7,(String)objArray[6] ); query.execute(); return
	 * sp_CHANGE_PROFILE_UPDATE_Result.generateResultBeanList(query.getResultList())
	 * ; }
	 * 
	 * public SP_CHANGE_PROFILE_UPDATE_Result generateResultBean(Object[] objArray){
	 * StoredProcedureQuery query =
	 * em.createStoredProcedureQuery("SP_CHANGE_PROFILE_UPDATE");
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,(String)objArray[0] );
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * query.setParameter(2,(String)objArray[1] );
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * query.setParameter(3,(String)objArray[2] );
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	 * query.setParameter(4,(String)objArray[3] );
	 * query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	 * query.setParameter(5,(String)objArray[4] );
	 * query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
	 * query.setParameter(6,(String)objArray[5] );
	 * query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
	 * query.setParameter(7,(String)objArray[6] );
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,(String)objArray[0] );
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * query.setParameter(2,(String)objArray[1] );
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * query.setParameter(3,(String)objArray[2] );
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	 * query.setParameter(4,(String)objArray[3] );
	 * query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	 * query.setParameter(5,(String)objArray[4] );
	 * query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
	 * query.setParameter(6,(String)objArray[5] );
	 * query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
	 * query.setParameter(7,(String)objArray[6] ); query.execute(); return
	 * sp_CHANGE_PROFILE_UPDATE_Result.generateResultBean((Object[])query.
	 * getResultList().get(0)); }
	 * 
	 * public boolean executeProc(Object[] objArray){ StoredProcedureQuery query =
	 * em.createStoredProcedureQuery("SP_CHANGE_PROFILE_UPDATE");
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,(String)objArray[0] );
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * query.setParameter(2,(String)objArray[1] );
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * query.setParameter(3,(String)objArray[2] );
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	 * query.setParameter(4,(String)objArray[3] );
	 * query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	 * query.setParameter(5,(String)objArray[4] );
	 * query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
	 * query.setParameter(6,(String)objArray[5] );
	 * query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
	 * query.setParameter(7,(String)objArray[6] );
	 * query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
	 * query.setParameter(1,(String)objArray[0] );
	 * query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
	 * query.setParameter(2,(String)objArray[1] );
	 * query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
	 * query.setParameter(3,(String)objArray[2] );
	 * query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);
	 * query.setParameter(4,(String)objArray[3] );
	 * query.registerStoredProcedureParameter(5,String.class,ParameterMode.IN);
	 * query.setParameter(5,(String)objArray[4] );
	 * query.registerStoredProcedureParameter(6,String.class,ParameterMode.IN);
	 * query.setParameter(6,(String)objArray[5] );
	 * query.registerStoredProcedureParameter(7,String.class,ParameterMode.IN);
	 * query.setParameter(7,(String)objArray[6] ); return query.execute(); }
	 * 
	 * public List<String> generateResultBeanLabels(){ return
	 * sp_CHANGE_PROFILE_UPDATE_Result.generateResultBeanLabels(); }
	 */
}
