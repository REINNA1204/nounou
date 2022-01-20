package nounou.commun.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DtoAgrement implements Serializable {
    
    // Champs
    
    private int         id;
    private String      libelle;
    private int			nombremaxenfants;
	
	
	// Constructeurs
    
    public DtoAgrement() {
		super();
	}
    
    public DtoAgrement(int id, String libelle, int nombremaxenfants) {
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
    
}
