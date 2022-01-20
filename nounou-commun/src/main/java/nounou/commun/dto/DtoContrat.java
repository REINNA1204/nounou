package nounou.commun.dto;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
public class DtoContrat implements Serializable {
	
	
	// Champs
	
	private int				id;
	
	private String			nomenfant;
	
	private String			prenomenfant;
	
	private Date			datenaissanceenfant;
	
	private Date			datedebut;
	
	private Date			datefin;
	
	private double			tarifhoraire;

	private DtoParent			parent;
	
	private DtoPersonnel			personnel;
	
	
	// Constructeurs
	
	public DtoContrat() {
	}

	public DtoContrat(int id, String nomenfant, String prenomenfant, Date datenaissanceenfant, Date datedebut, Date datefin, double tarifhoraire, DtoParent parent, DtoPersonnel personnel ) {
		super();
		this.id = id;
		this.nomenfant = nomenfant;
		this.prenomenfant = prenomenfant;
		this.datenaissanceenfant = datenaissanceenfant;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.tarifhoraire = tarifhoraire;
		this.parent = parent;
		this.personnel = personnel;
	}
	
	
	
	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomenfant() {
		return nomenfant;
	}

	public void setNomenfant(String nomenfant) {
		this.nomenfant = nomenfant;
	}

	public String getPrenomenfant() {
		return prenomenfant;
	}

	public void setPrenomenfant(String prenomenfant) {
		this.prenomenfant = prenomenfant;
	}

	public Date getDatenaissanceenfant() {
		return datenaissanceenfant;
	}

	public void setDatenaissanceenfant(Date datenaissanceenfant) {
		this.datenaissanceenfant = datenaissanceenfant;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public double getTarifhoraire() {
		return tarifhoraire;
	}

	public void setTarifhoraire(double tarifhoraire) {
		this.tarifhoraire = tarifhoraire;
	}

	public DtoParent getParent() {
		return parent;
	}

	public void setParent(DtoParent parent) {
		this.parent = parent;
	}

	public DtoPersonnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(DtoPersonnel personnel) {
		this.personnel = personnel;
	}

	

}
