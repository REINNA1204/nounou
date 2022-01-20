package nounou.jsf.data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Contrat implements Serializable {


	// Champs
	
	private Integer			id;
	
	@NotBlank( message = "Le nom de l'enfant doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom de l'enfant : 25 caractères maxi" )
	private String			nomenfant;

	@NotBlank( message = "Le prénom de l'enfant doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le prénom de l'enfant : 25 car. maxi" )
	private String			prenomenfant;
	
	//@NotBlank( message = "La date de naissance de l'enfant doit être renseigné")
	private Date			datenaissanceenfant;
	
	//@NotBlank( message = "La date de début du contrat doit être renseigné")
	private Date			datedebut;
	
	//@NotBlank( message = "La date de fin du contrat doit être renseigné")
	private Date			datefin;
	
	@NotBlank( message = "le tarif horaire doit être renseignée")
	private double			tarifhoraire;

	@NotNull( message = "Le parent est obligatoire")
	private Parent		parent = new Parent();
	
	@NotNull( message = "Le personnel est obligatoire")
	private Personnel		personnel = new Personnel();
	
	DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
	
	// Constructeurs
	
	public Contrat() {
	}

	public Contrat(Integer id, String nomenfant, String prenomenfant, Date datenaissanceenfant, Date datedebut, Date datefin, double tarifhoraire, Parent parent, Personnel personnel) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
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
		var other = (Contrat) obj;
		return Objects.equals(id, other.id);
	}
	

}
