package nounou.jsf.data;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Agrement implements Serializable {

	
	// Champs

    private Integer        	id;
    
	@NotBlank( message = "Le libellé doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le libellé : 25 car. maxi" )
    private String      	libelle;
	
	@Min(value=1, message = "Le nombre max d'enfants autorisés doit être valide (>0)" )
    private int      	nombremaxenfants;
    
    
    // Constructeurs
    
    public Agrement() {
	}

    public Agrement(Integer id, String libelle, int nombremaxenfants) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.nombremaxenfants = nombremaxenfants;
	}
    
    
    // Getters & setters

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public int getNombremaxenfants() {
		return nombremaxenfants;
	}

	public void setNombremaxenfants(int nombremaxenfants) {
		this.nombremaxenfants = nombremaxenfants;
	}
    
    // toString()

	@Override
	public String toString() {
		return libelle;
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
		var other = (Agrement) obj;
		return Objects.equals(id, other.id);
	}

}
