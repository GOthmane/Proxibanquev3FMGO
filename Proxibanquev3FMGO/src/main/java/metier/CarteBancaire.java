package metier;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class CarteBancaire {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private boolean bloquee = false;
	
	public CarteBancaire() {
		super();
	}

	public CarteBancaire(long id, boolean bloquee) {
		super();
		this.id = id;
		this.bloquee = bloquee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isBloquee() {
		return bloquee;
	}

	public void setBloquee(boolean bloquee) {
		this.bloquee = bloquee;
	}

	@Override
	public String toString() {
		return "CarteBancaire [id=" + id + ", bloquee=" + bloquee + "]";
	}

}
