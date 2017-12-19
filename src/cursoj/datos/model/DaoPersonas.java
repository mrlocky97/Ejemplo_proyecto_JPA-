package cursoj.datos.model;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.Query;




public class DaoPersonas extends DaoBase {
	
	public DaoPersonas() {
		super();
		
	}//end constructor		
	
	//CRUD
	//.........................................................................
	public void save(Persona persona){
		try{
			this.beginTransaction();
			this.entityManager.persist(persona);
			this.commit();			
		}
		catch(Exception e){
			e.printStackTrace();
			this.rollBack();
		}
	}
	
	public void update(Persona persona) {		
		try{
			this.beginTransaction();
			this.entityManager.merge(persona);
			this.commit();			
		}
		catch(Exception e){
			e.printStackTrace();
			this.rollBack();
		}		
	}
	
	public void delete(Persona persona) {
		try{
			this.beginTransaction();
			this.entityManager.remove(persona);
			this.commit();			
		}
		catch(Exception e){
			e.printStackTrace();
			this.rollBack();
		}
	}
	
	public void saveList(List<Persona> personas){	
		try{
			this.beginTransaction();
			for(Persona elem:personas){			
				this.entityManager.persist(elem);				
			} 				
			this.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			this.rollBack();
		}		
		
	}//end method	
	
	
	//CONSULTAS
	//.........................................................................	
	@SuppressWarnings("unchecked")
	public List<Persona> findAll() {
		return entityManager.createQuery(("FROM Persona")).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> findByGrupo(String grupo){
		List<Persona> personas = null;
		try {
			personas = this.entityManager.createNamedQuery("personas_findByGrupo")
					.setParameter("pGrupo",grupo).getResultList();					
					
		} 
		catch (RuntimeException e) {
			e.printStackTrace();
		}
		return personas;	
	}
	
	@SuppressWarnings("unchecked")
	public Integer getCountByGrupo(String grupo){		
		Integer count = null;
		try {
			Query q = entityManager.createNamedQuery("personas_countByGroup")
					 .setParameter("pGrupo",grupo);
			count = new Integer(q.getSingleResult().toString());
		} 
		catch (RuntimeException e) {
			e.printStackTrace();
		}
		return count;	
	}
	
	public String findNameById(Integer id,String coTabla){
		String name = null;
		try {
			name = (entityManager.createNamedQuery("personas_getNameById")
					.setParameter("pGrupo",id)
					.getSingleResult()).toString();
		} 
		catch (RuntimeException e) {
			e.printStackTrace();
		}		
		return name;
	};
	
	/*
	public StringDto findNameById(Integer id,String coTabla){
		return new StringDto(error,data);
	}	
	*/
	
}//end class
