package nounou.commun.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;


@SuppressWarnings("serial")
public class DtoSuivi implements Serializable {
	
	
	// Champs
	
	private int				id;
	
	private Date			datedujour;
	
	private Time			heurearrivee;
	
	private Time			heuredepart;
	
	private boolean			isrepas;
	
	private double			montantjour;

	private DtoContrat			contrat;
	
	
	// Constructeurs
	
	public DtoSuivi() {
	}

	public DtoSuivi(int id, Date datedujour, Time heurearrivee, Time heuredepart, boolean isrepas, double montantjour, DtoContrat contrat ) {
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

	public DtoContrat getContrat() {
		return contrat;
	}

	public void setContrat(DtoContrat contrat) {
		this.contrat = contrat;
	}
}
