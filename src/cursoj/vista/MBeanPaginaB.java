package cursoj.vista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import cursoj.datos.model.Persona;
import cursoj.negocio.MBeanServicePersonas;


@ManagedBean(name="mBeanPaginaB")
@ViewScoped
public class MBeanPaginaB  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{mBeanServicePersonas}")
	MBeanServicePersonas mBeanServicePersonas;
	
	private List<Persona> listPersonas;
	
//mBeanPaginaB.listPersonas
	//inicializacion
	//.............................................................	
	@PostConstruct
	public void init() {
		this.listPersonas = mBeanServicePersonas.obtenerInformePersonal();
		
	}//end method


	
	//setters/getters
	//.............................................................	
	public List<Persona> getListPersonas() {
		return this.listPersonas;
	}

	public void setListPersonas(List<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}
	
	public MBeanServicePersonas getmBeanServicePersonas() {
		return mBeanServicePersonas;
	}

	public void setmBeanServicePersonas(MBeanServicePersonas mBeanServicePersonas) {
		this.mBeanServicePersonas = mBeanServicePersonas;
	}

	/*
	public void cerrarSesion(){
		this.logeado = false;
		try {FacesContext.getCurrentInstance().getExternalContext().redirect(LOGIN_PAGE);} 
		catch (IOException e) {e.printStackTrace();}
	}//end method
	 */
	
}//end class
