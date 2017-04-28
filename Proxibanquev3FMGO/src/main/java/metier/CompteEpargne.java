package metier;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("epargne")
public class CompteEpargne extends Compte {

	private double remuneration = 0.03;

	public double getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(double remuneration) {
		this.remuneration = remuneration;
	}

	public CompteEpargne(long id, int numeroCompte, double solde, Date dateOuverture,
			Collection<CarteBancaire> carteBancaires, Client client) {
		super(id, numeroCompte, solde, dateOuverture, carteBancaires, client);
	}

	public CompteEpargne() {
		super();
	}

	@Override
	public String toString() {
		return "CompteEpargne [remuneration=" + remuneration + ", toString()=" + super.toString() + "]";
	}

}
