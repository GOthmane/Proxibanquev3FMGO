package metier;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Placement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private double montant;
	private String placeFinanciere;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Client client;

	public Placement(long id, double montant, String placeFinanciere) {
		super();
		this.id = id;
		this.montant = montant;
		this.placeFinanciere = placeFinanciere;
	}

	public Placement() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getPlaceFinanciere() {
		return placeFinanciere;
	}

	public void setPlaceFinanciere(String placeFinanciere) {
		this.placeFinanciere = placeFinanciere;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Placement [id=" + id + ", montant=" + montant + ", placeFinanciere=" + placeFinanciere + ", client="
				+ client + ", toString()=" + super.toString() + "]";
	}

}
