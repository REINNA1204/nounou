package nounou.jsf.data;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;


@SuppressWarnings("serial")
public class Suivi implements Serializable {


	// Champs
	
	private Integer			id;
	
	private Date			datedujour;
	
	private Time			heurearrivee;
	
	private Time			heuredepart;
	
	private boolean			isrepas;
	
	private double			montantjour;

	@NotNull( message = "Le contrat est obligatoire")
	private Contrat		contrat = new Contrat();
	
	DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
	
	// Constructeurs
	
	public Suivi() {
	}

	public Suivi(Integer id, Date datedujour, Time heurearrivee, Time heuredepart, boolean isrepas, double montantjour, Contrat contrat) {
		super();
		this.id = id;
		this.datedujour = datedujour;
		this.heurearrivee = heurearrivee;
		this.heuredepart = heuredepart;
		this.isrepas = isrepas;
		this.montantjour = montantjour;
		this.contrat = contrat;
	}
	
	
	// Getters & setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public DateFormat getDformat() {
		return dformat;
	}

	public void setDformat(DateFormat dformat) {
		this.dformat = dformat;
	}

	
	// hashCode() & equals()

	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Suivi) obj;
		return Objects.equals(id, other.id);
	}
	

}
