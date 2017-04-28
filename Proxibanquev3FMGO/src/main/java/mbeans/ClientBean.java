package mbeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import metier.Client;
import metier.Conseiller;
import metier.Coordonnees;
import service.IService;
import service.ServiceImpl;

@ManagedBean
@SessionScoped
public class ClientBean implements Serializable{

	private static final long serialVersionUID = 918817368870220014L;
	
	private IService service = new ServiceImpl();
	private Client client;
	private boolean editMode = false;
	private	Coordonnees coordonnees = new Coordonnees();
	
	@ManagedProperty(value="#{conseillerBean}")
    private ConseillerBean conseillerBean;
	
	public Coordonnees getCoordonnees() {
		return service.getCoordonneesFromClient(client);
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Client getClient() {
		if(client == null){
            client = new Client();
        }
        return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public String add() {
		if (!client.getNom().equalsIgnoreCase("") && !client.getPrenom().equalsIgnoreCase("")) {
			if (editMode == false) {
				// Methode non implementée pour l'instant
				//service.addCoordonneesToClient(coordonnees, client);
				//service.addClientToConseiller(client, conseillerBean.getConseiller());
			} else {
				service.majClient(client);
				editMode = false;
			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("client", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir les valeurs non nulles", null));
		}
		coordonnees = new Coordonnees();
		client = new Client();
		return "index";
	}

	public ConseillerBean getConseillerBean() {
		return conseillerBean;
	}

	public void setConseillerBean(ConseillerBean conseillerBean) {
		this.conseillerBean = conseillerBean;
	}

	public void delete() {
		service.deleteClient(client);
		client = new Client();
	}

	public void maj() {
		editMode = true;
	}
	
	public void onUserSelect(SelectEvent event){ 
    	this.client =  (Client)event.getObject();
    	System.out.println("client = "+client.getId());
    }
    public void onUserUnselect(UnselectEvent event)
    {
    	client =  null;
    }
    
    public void rowSelect(SelectEvent event){
    	client =  (Client)event.getObject();
    	System.out.println("client = "+client.getPrenom());	
    }
	
}