package metier;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("courant")
public class CompteCourant extends Compte {

	private double decouvert = 1000;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}


	public CompteCourant(long id, int numeroCompte, double solde, Date dateOuverture,
			Collection<CarteBancaire> carteBancaires, Client client, double decouvert) {
		super(id, numeroCompte, solde, dateOuverture, carteBancaires, client);
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", toString()=" + super.toString() + "]";
	}

}
