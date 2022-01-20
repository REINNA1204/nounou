package nounou.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table( name = "personnel"  )
public class Personnel {
	
	
	// Champs
	
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idpersonnel" )
	private int				id;
	
	@Column( name = "nom" )
	private String			nom;
	
	@Column( name = "prenom" )
	private String			prenom;
	
	@Column( name = "telephone" )
	private String			telephone;
	
	@Column( name = "adresse" )
	private String			adresse;
	
	@ManyToOne
	@JoinColumn( name = "idagrement" )
	private Agrement		agrement;

	@OneToOne( cascade = CascadeType.ALL ) 
    @JoinColumn( name="idcompte" )
    private Compte compte;
	
	
	// Constructeurs
	
	public Personnel() {
	}

	public Personnel(int id, String nom, String prenom, String telephone, String adresse, Agrement agrement ) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setTelephone(telephone);
		setAdresse(adresse);
		setAgrement(agrement);
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

	public Agrement getAgrement() {
		return agrement;
	}

	public void setAgrement(Agrement agrement) {
		this.agrement = agrement;
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

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	
	// Actions
	
	
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
		Personnel other = (Personnel) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
