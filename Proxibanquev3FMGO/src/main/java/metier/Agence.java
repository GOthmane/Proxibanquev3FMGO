package metier;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String numAgence;
	private Date dateCreation;

	public Agence(String numAgence, Date dateCreation) {
		super();
		this.numAgence = numAgence;
		this.dateCreation = dateCreation;
	}

	public Agence() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumAgence() {
		return numAgence;
	}

	public void setNumAgence(String numAgence) {
		this.numAgence = numAgence;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", numAgence=" + numAgence + ", dateCreation=" + dateCreation + "]";
	}

}
