package cursoj.datos.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DaoBase {

	public static final String JPA_UNIT = "cursoj";
	
	public EntityManagerFactory factory;
	public EntityManager entityManager;
	

	//constructor
	public DaoBase() {
		this.factory = Persistence.createEntityManagerFactory(DaoBase.JPA_UNIT);
		this.entityManager = factory.createEntityManager();
		int aux=1;
	}
	
	public void close(){
		this.entityManager.close();
		this.factory.close();
	}
	
	//transacciones
	//..................................................................
	public void beginTransaction(){
		this.entityManager.getTransaction().begin();
	}
	
	public void commit(){
		this.entityManager.getTransaction().commit();
	}
	
	public void rollBack(){
		entityManager.getTransaction().rollback();
	}

	
}//end class
