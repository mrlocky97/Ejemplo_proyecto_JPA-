package cursoj.vista;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import cursoj.application.MbeanSession;
import cursoj.datos.model.Persona;
import cursoj.negocio.MBeanServicePersonas;



@ManagedBean(name="mBeanPaginaA")
@SessionScoped
public class MBeanPaginaA  implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_ALTA_SUCCESS = "paginaB";
	
	
	@ManagedProperty(value="#{mBeanSession}")
	MbeanSession mBeanSession;
	
	@ManagedProperty(value="#{mBeanServicePersonas}")
	MBeanServicePersonas mBeanServicePersonas;
	
	private Persona persona;
	

	//inicializacion
	//.............................................................	
	@PostConstruct
	public void init() {
		this.persona = new Persona();
	}//end method

	public String ejecutarAlta(){		
		String pageNavigate = MBeanPaginaA.PAGE_ALTA_SUCCESS;
		this.mBeanServicePersonas.altaPersona(this.persona);			
		return pageNavigate;
	};//end method
	
	public MBeanServicePersonas getmBeanServicePersonas() {
		return mBeanServicePersonas;
	}

	public void setmBeanServicePersonas(MBeanServicePersonas mBeanServicePersonas) {
		this.mBeanServicePersonas = mBeanServicePersonas;
	}

	//setters/getters
	//.............................................................	
	public MbeanSession getmBeanSession() {
		return mBeanSession;
	}

	public void setmBeanSession(MbeanSession mBeanSession) {
		this.mBeanSession = mBeanSession;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
}//end class
