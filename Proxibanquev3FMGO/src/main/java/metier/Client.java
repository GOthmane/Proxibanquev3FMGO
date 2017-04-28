package metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("client")
public class Client extends Personne {

	private boolean entreprise = false;
	private String telephone;
	private String email;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Coordonnees coordonnees;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Conseiller conseiller;
	@OneToMany(mappedBy="client",fetch=FetchType.EAGER)
	private Collection<Compte> comptes = new ArrayList<Compte>();
	@OneToMany(mappedBy="client",fetch=FetchType.EAGER)
	private Collection<Placement> placements = new ArrayList<Placement>();
	
	
	public Client() {
		super();
	}

	public boolean isEntreprise() {
		return entreprise;
	}

	public void setEntreprise(boolean entreprise) {
		this.entreprise = entreprise;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Collection<Placement> getPlacements() {
		return placements;
	}

	public void setPlacements(Collection<Placement> placements) {
		this.placements = placements;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [entreprise=" + entreprise + ", telephone=" + telephone + ", email=" + email + ", coordonnees="
				+ coordonnees + ", conseiller=" + conseiller + ", comptes=" + comptes + ", placements=" + placements
				+ ", toString()=" + super.toString() + "]";
	}

}
