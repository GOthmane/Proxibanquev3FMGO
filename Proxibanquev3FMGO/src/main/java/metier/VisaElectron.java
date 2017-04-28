package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("electron")
public class VisaElectron extends CarteBancaire {

	public VisaElectron() {
		super();
	}

	@Override
	public String toString() {
		return "VisaElectron []";
	}

}
