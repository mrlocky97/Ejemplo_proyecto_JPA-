package cursoj.negocio;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cursoj.datos.model.DaoPersonas;
import cursoj.datos.model.Persona;


@ManagedBean(name="mBeanServicePersonas")
@SessionScoped
public class MBeanServicePersonas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//attributos
	//...............................................
	private String id = "manolo";
	
	private DaoPersonas daoPersonas;

	//inicializacion
	//.............................................................	
	@PostConstruct
	public void init() {
		this.daoPersonas = new DaoPersonas();			
	}


	public List<Persona> obtenerInformePersonal(){
		return this.daoPersonas.findAll();
	}//end method
	
	public Boolean altaPersona(Persona persona){
		Boolean res = Boolean.TRUE;
		this.daoPersonas.save(persona);		
		return res;
	}
	
	//getters and setters
	//.............................................................
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
			
	public DaoPersonas getDaoPersonas() {
		return daoPersonas;
	}

	public void setDaoPersonas(DaoPersonas daoPersonas) {
		this.daoPersonas = daoPersonas;
	}

}//end class
