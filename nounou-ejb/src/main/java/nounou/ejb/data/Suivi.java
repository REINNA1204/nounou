package nounou.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "suivi"  )
public class Suivi {

	// champs
	
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idsuivi" )
	private int				id;
	
	@Column( name = "datedujour" )
	private Date			datedujour;
	
	@Column( name = "heurearrivee" )
	private Time			heurearrivee;
	
	@Column( name = "heuredepart" )
	private Time			heuredepart;
	
	@Column( name = "isrepas" )
	private boolean			isrepas;

	@Column( name = "montantjour" )
	private double			montantjour;
	
	@ManyToOne
	@JoinColumn( name = "idcontrat" )
	private Contrat		contrat;

	// Constructeurs
	
	public Suivi() {
	}
	
	public Suivi(int id, Date datedujour, Time heurearrivee, Time heuredepart, boolean isrepas, double montantjour, Contrat contrat) {
		this.id = id;
		this.datedujour = datedujour;
		this.heurearrivee = heurearrivee;
		this.heuredepart = heuredepart;
		this.isrepas = isrepas;
		this.montantjour = montantjour;
		this.contrat = contrat;
	}

	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatedujour() {
		return datedujour;
	}

	public void setDatedujour(Date datedujour) {
		this.datedujour = datedujour;
	}

	public Time getHeurearrivee() {
		return heurearrivee;
	}

	public void setHeurearrivee(Time heurearrivee) {
		this.heurearrivee = heurearrivee;
	}

	public Time getHeuredepart() {
		return heuredepart;
	}

	public void setHeuredepart(Time heuredepart) {
		this.heuredepart = heuredepart;
	}

	public boolean isIsrepas() {
		return isrepas;
	}

	public void setIsrepas(boolean isrepas) {
		this.isrepas = isrepas;
	}

	public double getMontantjour() {
		return montantjour;
	}

	public void setMontantjour(double montantjour) {
		this.montantjour = montantjour;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	// hashcode() + equals()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suivi suivi = (Suivi) obj;
		if (id != suivi.id)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
