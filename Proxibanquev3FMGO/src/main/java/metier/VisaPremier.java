package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("premier")
public class VisaPremier extends CarteBancaire {

	public VisaPremier() {
		super();
	}

	@Override
	public String toString() {
		return "VisaPremier []";
	}

}
