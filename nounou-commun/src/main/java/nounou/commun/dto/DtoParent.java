package nounou.commun.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DtoParent implements Serializable {
	
	
	// Champs
	
	private int				id;
	
	private String			nom;
	
	private String			prenom;
	
	private String			telephone;
	
	private String			adresse;
	
	private DtoCompte compte;
	
	
	// Constructeurs
	
	public DtoParent() {
	}

	public DtoParent(int id, String nom, String prenom, String telephone, String adresse  ) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
	}
	
	
	
	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public DtoCompte getCompte() {
		return compte;
	}

	public void setCompte(DtoCompte compte) {
		this.compte = compte;
	}

}
