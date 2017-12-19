package cursoj.negocio;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import cursoj.application.MbeanSession;


@ManagedBean(name="mBeanServiceSecurity")
@SessionScoped
public class MBeanServiceSecurity  implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_AUT_SUCCESS = "paginaA";
	public static final String PAGE_AUT_FAILED = "error";
	
	@ManagedProperty(value="#{mBeanSession}")
	MbeanSession mBeanSession;
	
	private String loginId;
	private String loginPassword;
	
	//inicializacion
	//.............................................................	
	@PostConstruct
	public void init() {
	}//end method

	
	public String authenticate(){
		String pageNavigate = null;
		if(this.loginId.equals("cursoj") && loginPassword.equals("cursoj") ) {
			this.mBeanSession.setUserId(this.loginId);
			pageNavigate = MBeanServiceSecurity.PAGE_AUT_SUCCESS;
		}
		else{
			pageNavigate = MBeanServiceSecurity.PAGE_AUT_FAILED;
		}
		return pageNavigate;
	};//end method
	
	
	//getters and setters
	//........................................................................	
	public MbeanSession getmBeanSession() {
		return mBeanSession;
	}
	public void setmBeanSession(MbeanSession mBeanSession) {
		this.mBeanSession = mBeanSession;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	
}//end class
