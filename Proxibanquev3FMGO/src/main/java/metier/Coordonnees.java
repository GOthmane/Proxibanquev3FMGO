/**
 * 
 */
package metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Classe pour la gestion des adresses et des numeros de telephone.
 * 
 * @author Perrine EMIN et Guillaume OTHMANE
 */

@Entity
public class Coordonnees {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	private String numRue;
	private String ville;
	private String cp;
	@OneToMany(mappedBy="coordonnees",fetch=FetchType.EAGER)
	private Collection<Client> clients = new ArrayList<Client>();

	public Coordonnees(long id, String numRue, String ville, String cp) {
		super();
		this.id = id;
		this.numRue = numRue;
		this.ville = ville;
		this.cp = cp;
	}
	
	public Coordonnees() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter de l'adresse
	 * 
	 * @return Num�ro et rue
	 */
	public String getNumRue() {
		return numRue;
	}

	/**
	 * Setter de l'adresse
	 * 
	 * @param numRue
	 *            Num�ro et rue
	 */
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	/**
	 * Getter de la ville
	 * 
	 * @return Ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter de la ville
	 * 
	 * @param ville
	 *            Ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter du code postal
	 * 
	 * @return Code postal
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Setter du code postal
	 * 
	 * @param cp
	 *            Code postal
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Coordonnees [id=" + id + ", numRue=" + numRue + ", ville=" + ville + ", cp=" + cp + ", clients="
				+ clients + "]";
	}
	
}
