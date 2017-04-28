package metier;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class Compte {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private int numeroCompte;
	private double solde;
	private Date dateOuverture;
	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Collection<CarteBancaire> carteBancaires;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Client client;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Collection<CarteBancaire> getCarteBancaires() {
		return carteBancaires;
	}

	public void setCarteBancaires(Collection<CarteBancaire> carteBancaires) {
		this.carteBancaires = carteBancaires;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Compte(long id, int numeroCompte, double solde, Date dateOuverture, Collection<CarteBancaire> carteBancaires,
			Client client) {
		super();
		this.id = id;
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.carteBancaires = carteBancaires;
		this.client = client;
	}

	public Compte() {
		super();
	}

	

}
