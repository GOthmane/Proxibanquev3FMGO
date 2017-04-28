package mbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import metier.Client;
import metier.Conseiller;
import service.ILoginService;
import service.IService;
import service.ServiceImpl;

@ManagedBean
@SessionScoped
public class ConseillerBean {
	
	private ILoginService ilservice = new ServiceImpl();
	private IService icservice = new ServiceImpl();
	
	private Conseiller conseiller = new Conseiller();
	private String login;
	private String pwd;
	private List<Client> listeClients;

	public ILoginService getIlservice() {
		return ilservice;
	}

	public void setIlservice(ILoginService ilservice) {
		this.ilservice = ilservice;
	}

	public IService getIcservice() {
		return icservice;
	}

	public void setIcservice(IService icservice) {
		this.icservice = icservice;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
	public List<Client> getListeClients() {
		return icservice.listClientsByConseiller(conseiller);
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public String verificationLogin(){
		conseiller = ilservice.verificationLogin(login, pwd);
		if(conseiller.getId()!=0){
			return "home";
		}
		else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou mot de passe incorrect!", "Veuillez essayer à nouveau"));
            login = "";
            pwd="";
			return "login";
        }
	}

}
