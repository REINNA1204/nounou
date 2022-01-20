package nounou.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "agrement" )
public class Agrement {
    
	
    // Champs
    
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idagrement" )
    private int         	id;
    
	@Column( name = "libelle" )
    private String      	libelle;
	
	@Column( name = "nombremaxenfant" )
    private int      	nombremaxenfants;
	
	// Constructeurs

	public Agrement() {
		super();
	}
    
    public Agrement(int id, String libelle, int nombremaxenfants) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.nombremaxenfants = nombremaxenfants;
	}
    
    
    // Getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

	// soString()
    @Override
    public String toString() {
    	return this.libelle;
    }

    
	// hashcode() & equals()

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
		Agrement other = (Agrement) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
}
