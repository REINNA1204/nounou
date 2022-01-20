package nounou.jsf.data;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Parent implements Serializable {


	// Champs
	
	private Integer			id;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String			nom;

	@NotBlank( message = "Le prénom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le prénom : 25 car. maxi" )
	private String			prenom;
	
	@NotBlank( message = "Le téléphone doit être renseigné")
	@Size(max=15, message = "Valeur trop longue pour le téléphone : 15 car. maxi" )
	private String			telephone;
	
	@NotBlank( message = "L'adresse doit être renseignée")
	private String			adresse;
	
	private Compte compte = new Compte();

	
	// Constructeurs
	
	public Parent() {
	}

	public Parent(Integer id, String nom, String prenom, String telephone, String adresse, Compte compte) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.compte = compte;
	}
	
	
	// Getters & setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public String toString() {
		return this.getNom() + " " + this.getPrenom();
	}
	
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
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
		var other = (Parent) obj;
		return Objects.equals(id, other.id);
	}
	

}
