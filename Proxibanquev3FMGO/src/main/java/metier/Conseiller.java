package metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("conseiller")
public class Conseiller extends Personne {

	private String login;
	private String pwd;
	@OneToMany(mappedBy="conseiller",fetch=FetchType.EAGER)
	private Collection<Client> clients = new ArrayList<Client>();
	
	public Conseiller() {
		super();
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
	
	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Conseiller [login=" + login + ", pwd=" + pwd + ", clients=" + clients + ", toString()="
				+ super.toString() + "]";
	}

}
